package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: LegacyButtonlessDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
class alk extends aky {

    /* JADX INFO: renamed from: a */
    protected static UUID f1608a = all.f1629y;

    /* JADX INFO: renamed from: b */
    protected static UUID f1609b = all.f1630z;

    /* JADX INFO: renamed from: c */
    protected static UUID f1610c = all.f1615B;

    /* JADX INFO: renamed from: y */
    private static final byte[] f1611y = {1, 4};

    /* JADX INFO: renamed from: A */
    private int f1612A;

    /* JADX INFO: renamed from: z */
    private BluetoothGattCharacteristic f1613z;

    /* JADX INFO: renamed from: b */
    private String m1863b(int i) {
        switch (i) {
            case 0:
                return "Bootloader from SDK 6.1 or older";
            case 1:
                return "Application with Legacy buttonless update from SDK 7.0 or newer";
            case 2:
            case 3:
            case 4:
            default:
                return "Unknown version";
            case 5:
                return "Bootloader from SDK 7.0 or newer. No bond sharing";
            case 6:
                return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
            case 7:
                return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
            case 8:
                return "Bootloader from SDK 9.0 or newer. Signature supported";
        }
    }

    alk(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) throws alr, alq, alx {
        int iM1862a;
        BluetoothGattService service = bluetoothGatt.getService(f1608a);
        if (service == null) {
            return false;
        }
        this.f1613z = service.getCharacteristic(f1609b);
        if (this.f1613z == null) {
            return false;
        }
        this.f1573v.m1846b(-2);
        this.f1572u.m10784a(1000);
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(f1610c);
        if (characteristic != null) {
            iM1862a = m1862a(bluetoothGatt, characteristic);
            this.f1612A = iM1862a;
            int i = iM1862a & 15;
            int i2 = iM1862a >> 8;
            m1821c("Version number read: " + i2 + "." + i + " -> " + m1863b(iM1862a));
            DfuBaseService dfuBaseService = this.f1572u;
            StringBuilder sb = new StringBuilder();
            sb.append("Version number read: ");
            sb.append(i2);
            sb.append(".");
            sb.append(i);
            dfuBaseService.m10785a(10, sb.toString());
        } else {
            m1821c("No DFU Version characteristic found -> " + m1863b(0));
            this.f1572u.m10785a(10, "DFU Version characteristic not found");
            iM1862a = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.f1572u).getBoolean("settings_assume_dfu_mode", false);
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU")) {
            booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU", false);
        }
        boolean z = bluetoothGatt.getServices().size() > 3;
        if (iM1862a == 0 && z) {
            m1821c("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return iM1862a == 1 || (!booleanExtra && iM1862a == 0 && z);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) {
        m1820b("Application with legacy buttonless update found");
        this.f1572u.m10785a(15, "Application with buttonless update found");
        this.f1572u.m10785a(1, "Jumping to the DFU Bootloader...");
        m1814a(this.f1613z, 1);
        this.f1572u.m10785a(10, "Notifications enabled");
        this.f1572u.m10784a(1000);
        this.f1573v.m1846b(-3);
        m1821c("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        m1815a(this.f1613z, f1611y, true);
        this.f1572u.m10785a(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        this.f1572u.m10783a();
        this.f1572u.m10785a(5, "Disconnected by the remote device");
        BluetoothGatt bluetoothGatt = this.f1562k;
        BluetoothGattService service = bluetoothGatt.getService(f1555d);
        this.f1572u.m10788a(bluetoothGatt, !((service == null || service.getCharacteristic(f1556e) == null) ? false : true));
        this.f1572u.m10789b(bluetoothGatt);
        m1821c("Starting service that will connect to the DFU bootloader");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        m1819b(intent2, this.f1612A == 0);
    }

    /* JADX INFO: renamed from: a */
    private int m1862a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws alr, alq, alx {
        if (!this.f1566o) {
            throw new alq("Unable to read version number: device disconnected");
        }
        if (this.f1565n) {
            throw new alx();
        }
        if (bluetoothGattCharacteristic == null) {
            return 0;
        }
        this.f1570s = null;
        this.f1569r = 0;
        m1821c("Reading DFU version number...");
        this.f1572u.m10785a(1, "Reading DFU version number...");
        bluetoothGattCharacteristic.setValue((byte[]) null);
        this.f1572u.m10785a(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.f1559h) {
                while (true) {
                    if (((this.f1567p && bluetoothGattCharacteristic.getValue() != null) || !this.f1566o || this.f1569r != 0 || this.f1565n) && !this.f1564m) {
                        break;
                    }
                    this.f1567p = false;
                    this.f1559h.wait();
                }
            }
        } catch (InterruptedException e) {
            m1817a("Sleeping interrupted", e);
        }
        if (this.f1569r != 0) {
            throw new alr("Unable to read version number", this.f1569r);
        }
        if (!this.f1566o) {
            throw new alq("Unable to read version number: device disconnected");
        }
        return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
    }
}
