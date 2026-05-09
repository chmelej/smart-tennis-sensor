package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: ButtonlessDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class alb extends aky {

    /* JADX INFO: renamed from: a */
    private static final byte[] f1577a = {1};

    /* JADX INFO: renamed from: c */
    protected abstract int mo1839c();

    /* JADX INFO: renamed from: n */
    protected abstract BluetoothGattCharacteristic mo1840n();

    /* JADX INFO: renamed from: o */
    protected abstract boolean mo1841o();

    alb(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) {
        byte[] bArrM;
        this.f1573v.m1846b(-2);
        this.f1572u.m10784a(1000);
        BluetoothGatt bluetoothGatt = this.f1562k;
        this.f1572u.m10785a(15, "Application with buttonless update found");
        this.f1572u.m10785a(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic bluetoothGattCharacteristicMo1840n = mo1840n();
        int iMo1839c = mo1839c();
        m1814a(bluetoothGattCharacteristicMo1840n, mo1839c());
        DfuBaseService dfuBaseService = this.f1572u;
        StringBuilder sb = new StringBuilder();
        sb.append(iMo1839c == 2 ? "Indications" : "Notifications");
        sb.append(" enabled");
        dfuBaseService.m10785a(10, sb.toString());
        this.f1572u.m10784a(1000);
        try {
            this.f1573v.m1846b(-3);
            m1821c("Sending Enter Bootloader (Op Code = 1)");
            m1815a(bluetoothGattCharacteristicMo1840n, f1577a, true);
            this.f1572u.m10785a(10, "Enter bootloader sent (Op Code = 1)");
            try {
                bArrM = m1831m();
            } catch (alq unused) {
                bArrM = this.f1570s;
            }
            if (bArrM != null) {
                int iM1836a = m1836a(bArrM, 1);
                m1821c("Response received (Op Code = " + ((int) bArrM[1]) + ", Status = " + iM1836a + ")");
                this.f1572u.m10785a(10, "Response received (Op Code = " + ((int) bArrM[1]) + ", Status = " + iM1836a + ")");
                if (iM1836a != 1) {
                    throw new alt("Device returned error after sending Enter Bootloader", iM1836a);
                }
                this.f1572u.m10783a();
            } else {
                m1821c("Device disconnected before receiving notification");
            }
            this.f1572u.m10785a(5, "Disconnected by the remote device");
            m1775a(intent, false, mo1841o());
        } catch (alt e) {
            int iM1907a = e.m1907a() | 8192;
            m1816a(e.getMessage());
            this.f1572u.m10785a(20, String.format("Remote DFU error: %s", m1837b(iM1907a)));
            this.f1572u.m10787a(bluetoothGatt, iM1907a);
        } catch (alw e2) {
            m1816a(e2.getMessage());
            this.f1572u.m10785a(20, e2.getMessage());
            this.f1572u.m10787a(bluetoothGatt, 4104);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1836a(byte[] bArr, int i) throws alw {
        if (bArr == null || bArr.length < 3 || bArr[0] != 32 || bArr[1] != i || (bArr[2] != 1 && bArr[2] != 2 && bArr[2] != 4)) {
            throw new alw("Invalid response received", bArr, 32, i);
        }
        return bArr[2];
    }

    /* JADX INFO: renamed from: b */
    private static String m1837b(int i) {
        int i2 = i & (-8193);
        if (i2 == 2) {
            return "REMOTE DFU OP CODE NOT SUPPORTED";
        }
        if (i2 == 4) {
            return "REMOTE DFU OPERATION FAILED";
        }
        return "UNKNOWN (" + i + ")";
    }
}
