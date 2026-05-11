# Tennis Sensor Pilot

Jednoduchý pilotní skript v Pythonu pro ověření základní komunikace s vaším tenisovým senzorem (Smart Tennis Sensor) na základě zmapovaného protokolu.

Tento skript **nijak nemodifikuje** nastavení senzoru ani neprovádí riskantní operace (jako OTA update nebo mazání dat). Zeptá se senzoru na **stav baterie** a **verzi firmwaru** (pokud to váš model podporuje) a přečte si odpověď. To spolehlivě ověří, že zmapované Bluetooth UUIDs a struktura paketů jsou správné.

## Požadavky

*   Nainstalovaný **Python 3.8+**
*   Počítač/notebook s podporou Bluetooth Low Energy (BLE)

## Instalace

Otevřete terminál a nainstalujte knihovnu pro Bluetooth komunikaci:

```bash
pip install bleak
```

## Použití

### 1. Vyhledání senzoru (Scan)
Nejprve zapněte svůj senzor a spusťte skript v režimu vyhledávání. Skript vypíše nalezená zařízení a upozorní vás na MAC adresu, pokud zachytí tenisový senzor (názvy jako `T0`, `T1`, `T2`, `TS`, `T5`, `KU`, atd.).

```bash
python tennis_sensor_pilot.py --scan
```
*Poznámka pro macOS uživatele: Místo klasické MAC adresy (např. `AA:BB:CC:DD:EE:FF`) uvidíte UUID (např. `XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX`). Tento formát si zkopírujte.*

### 2. Spuštění dotazu (Connect & Query)
Když máte adresu svého zařízení zkopírovanou, můžete zkusit navázat komunikaci. Kód pro čtení baterie a verze se odešle a rovnou se vypíše zachycená odpověď.

```bash
python tennis_sensor_pilot.py --address "VAŠE_MAC_ADRESA_NEBO_UUID"
```

Pokud by váš senzor patřil do série `KU` nebo `M` (zkontrolujte název v kroku scan), spusťte to s parametrem `--type`:

```bash
python tennis_sensor_pilot.py --address "VAŠE_MAC_ADRESA_NEBO_UUID" --type "KU"
```

### Očekávaný výstup
Když je komunikace úspěšná, měli byste v terminálu vidět výpis podobný tomuto:

```text
2024-05-10 15:00:00 - INFO - Connecting to AA:BB:CC:DD:EE:FF (Type: A)...
2024-05-10 15:00:02 - INFO - Connected: True
2024-05-10 15:00:02 - INFO - Subscribing to 00003000-0000-1000-8000-00805f9b34fb...
2024-05-10 15:00:03 - INFO - Sending Battery Request: a8220000000000000000000000000000000000ca
2024-05-10 15:00:03 - INFO - Received raw packet: a8224b0000...
2024-05-10 15:00:03 - INFO - -> Battery Level: 75%
2024-05-10 15:00:05 - INFO - Sending Firmware Version Request...
2024-05-10 15:00:05 - INFO - -> Firmware Version: V1.0.5
2024-05-10 15:00:07 - INFO - Unsubscribing and disconnecting...
2024-05-10 15:00:07 - INFO - Done.
```
