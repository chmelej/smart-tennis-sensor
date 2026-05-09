import asyncio
import struct
import logging
from bleak import BleakScanner, BleakClient

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

# --- UUIDs ---
# The original code searches for characteristic UUIDs by the first 4 characters.
# In Bleak/Python, we need the full UUIDs. We will use the standard Bluetooth SIG base UUID
# for the missing parts, but the user may need to adjust this depending on the sensor's exact UUIDs.
# The base UUID is usually: 0000xxxx-0000-1000-8000-00805F9B34FB

def build_full_uuid(short_uuid_hex_str: str) -> str:
    """Helper to construct a full UUID from a 16-bit short UUID string."""
    return f"0000{short_uuid_hex_str}-0000-1000-8000-00805f9b34fb"

# A-Series Devices (T0, T1, T2, TS, T5)
A_SERIES_NOTIFY_CHAR_UUID = build_full_uuid("3000")
A_SERIES_WRITE_CHAR_UUID = build_full_uuid("2000")

# KU or M Series Devices
KU_SERIES_NOTIFY_CHAR_UUID = build_full_uuid("ffe4")
KU_SERIES_WRITE_CHAR_UUID = build_full_uuid("ffe9")


# --- Protocol Constants ---
PACKET_HEADER = 0xA8
PACKET_LENGTH = 20

# Command Codes (Write)
CMD_REQ_FIRMWARE_VER = 0x21
CMD_REQ_BATTERY = 0x22

# Response Codes (Notify)
RSP_FIRMWARE_VER = 0x21
RSP_BATTERY = 0x22


# --- Packet Builder & Parser ---

def calculate_checksum(packet: bytearray) -> int:
    """
    Calculates the checksum which is the sum of the first 19 bytes, masked to 8 bits.
    """
    return sum(packet[:19]) & 0xFF

def create_command_packet(command_code: int, payload: bytes = b'') -> bytearray:
    """
    Constructs a 20-byte command packet according to the Smart Tennis protocol.
    """
    if len(payload) > 17:
        raise ValueError("Payload too long! Maximum is 17 bytes.")

    packet = bytearray(PACKET_LENGTH)
    packet[0] = PACKET_HEADER
    packet[1] = command_code

    # Copy payload
    for i, byte_val in enumerate(payload):
        packet[2 + i] = byte_val

    # Bytes 7-18 are already 0x00 by default in bytearray initialization

    # Checksum is always the 20th byte (index 19)
    packet[19] = calculate_checksum(packet)

    return packet

def parse_sensor_response(data: bytearray):
    """
    Parses an incoming 20-byte packet and extracts known information.
    """
    if len(data) != PACKET_LENGTH:
        logger.warning(f"Received malformed packet (length {len(data)}): {data.hex()}")
        return None

    if data[0] != PACKET_HEADER:
        logger.warning(f"Received packet with wrong header: {data[0]:02X}")
        return None

    expected_checksum = calculate_checksum(data)
    if data[19] != expected_checksum:
        logger.warning(f"Checksum mismatch! Expected {expected_checksum:02X}, got {data[19]:02X}")
        return None

    cmd_code = data[1]

    if cmd_code == RSP_BATTERY:
        battery_level = data[2]
        logger.info(f"-> Battery Level: {battery_level}%")
        return {"type": "battery", "value": battery_level}

    elif cmd_code == RSP_FIRMWARE_VER:
        # Version is usually an ASCII string spanning bytes 2 to 15
        version_bytes = data[2:16]
        # Decode and strip null bytes or spaces
        try:
            version_str = version_bytes.decode('ascii').strip('\x00').strip()
            logger.info(f"-> Firmware Version: {version_str}")
            return {"type": "version", "value": version_str}
        except Exception as e:
            logger.error(f"Failed to parse firmware string: {e}")

    else:
        logger.debug(f"Received unknown/unhandled packet code 0x{cmd_code:02X}: {data.hex()}")
        return {"type": "unknown", "code": cmd_code, "raw": data}



# --- Async BLE Client ---

async def notification_handler(sender, data):
    """Callback for incoming notifications from the sensor."""
    logger.info(f"Received raw data from {sender}: {data.hex()}")
    parse_sensor_response(bytearray(data))

async def connect_and_query_sensor(address: str, device_type: str = "A"):
    """
    Connects to the tennis sensor, subscribes to the notify characteristic,
    and sends non-invasive queries (Battery, Firmware Version).
    """
    if device_type.upper() == "A":
        notify_char = A_SERIES_NOTIFY_CHAR_UUID
        write_char = A_SERIES_WRITE_CHAR_UUID
    else:
        notify_char = KU_SERIES_NOTIFY_CHAR_UUID
        write_char = KU_SERIES_WRITE_CHAR_UUID

    logger.info(f"Connecting to {address} (Type: {device_type})...")
    async with BleakClient(address) as client:
        logger.info(f"Connected: {client.is_connected}")

        # Subscribe to notifications
        logger.info(f"Subscribing to {notify_char}...")
        await client.start_notify(notify_char, notification_handler)

        # Request Battery Level
        battery_pkt = create_command_packet(CMD_REQ_BATTERY)
        logger.info(f"Sending Battery Request: {battery_pkt.hex()}")
        await client.write_gatt_char(write_char, battery_pkt, response=False)

        # Wait a moment for response
        await asyncio.sleep(2.0)

        # Request Firmware Version
        fw_pkt = create_command_packet(CMD_REQ_FIRMWARE_VER)
        logger.info(f"Sending Firmware Version Request: {fw_pkt.hex()}")
        await client.write_gatt_char(write_char, fw_pkt, response=False)

        # Wait a moment for response
        await asyncio.sleep(2.0)

        logger.info("Unsubscribing and disconnecting...")
        await client.stop_notify(notify_char)
        logger.info("Done.")

async def scan_for_sensor():
    """Scans for BLE devices and helps find the sensor."""
    logger.info("Scanning for 5 seconds, please wait...")
    devices = await BleakScanner.discover(timeout=5.0)

    sensor_found = False
    for d in devices:
        # The sensors usually have names starting with T0, T1, T2, TS, T5, or KU, M
        name = d.name or "Unknown"
        if name.startswith(("T0", "T1", "T2", "TS", "T5", "KU", "M")):
            logger.info(f"FOUND TENNIS SENSOR: {name} - Address: {d.address} - RSSI: {d.rssi}")
            sensor_found = True
        else:
            logger.debug(f"Other device: {name} - {d.address}")

    if not sensor_found:
        logger.warning("No obvious tennis sensors found. Make sure it's turned on and close.")

async def main():
    import argparse
    parser = argparse.ArgumentParser(description="Smart Tennis Sensor BLE Pilot")
    parser.add_argument("--scan", action="store_true", help="Scan for devices only")
    parser.add_argument("--address", type=str, help="MAC Address (Windows/Linux) or UUID (macOS) of the sensor")
    parser.add_argument("--type", type=str, default="A", help="Device Type Series (A, KU, M), default is A (T0,T1...)")

    args = parser.parse_args()

    if args.scan or not args.address:
        await scan_for_sensor()
        if not args.address:
            print("\nRun this script again with: python tennis_sensor_pilot.py --address <MAC_ADDRESS>")
            return

    if args.address:
        try:
            await connect_and_query_sensor(args.address, args.type)
        except Exception as e:
            logger.error(f"Failed to connect or query: {e}")

if __name__ == "__main__":
    asyncio.run(main())
