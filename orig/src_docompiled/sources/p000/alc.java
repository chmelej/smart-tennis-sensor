package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: ButtonlessDfuWithBondSharingImpl.java */
/* JADX INFO: loaded from: classes.dex */
class alc extends alb {

    /* JADX INFO: renamed from: a */
    protected static final UUID f1578a = alm.f1646y;

    /* JADX INFO: renamed from: b */
    protected static final UUID f1579b = new UUID(-8157989228746813600L, -6937650605005804976L);

    /* JADX INFO: renamed from: c */
    protected static UUID f1580c = f1578a;

    /* JADX INFO: renamed from: y */
    protected static UUID f1581y = f1579b;

    /* JADX INFO: renamed from: z */
    private BluetoothGattCharacteristic f1582z;

    @Override // p000.alb
    /* JADX INFO: renamed from: c */
    protected int mo1839c() {
        return 2;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: o */
    protected boolean mo1841o() {
        return false;
    }

    alc(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(f1580c);
        if (service == null) {
            return false;
        }
        this.f1582z = service.getCharacteristic(f1581y);
        return this.f1582z != null;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: n */
    protected BluetoothGattCharacteristic mo1840n() {
        return this.f1582z;
    }

    @Override // p000.alb, p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) {
        m1821c("Buttonless service with bond sharing found -> SDK 14 or newer");
        if (!m1830l()) {
            m1820b("Device is not paired, cancelling DFU");
            this.f1572u.m10785a(15, "Device is not bonded");
            this.f1572u.m10787a(this.f1562k, 4110);
            return;
        }
        super.mo1838a(intent);
    }
}
