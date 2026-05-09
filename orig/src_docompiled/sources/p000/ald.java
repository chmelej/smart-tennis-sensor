package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: ButtonlessDfuWithoutBondSharingImpl.java */
/* JADX INFO: loaded from: classes.dex */
class ald extends alb {

    /* JADX INFO: renamed from: a */
    protected static final UUID f1583a = alm.f1646y;

    /* JADX INFO: renamed from: b */
    protected static final UUID f1584b = new UUID(-8157989233041780896L, -6937650605005804976L);

    /* JADX INFO: renamed from: c */
    protected static UUID f1585c = f1583a;

    /* JADX INFO: renamed from: y */
    protected static UUID f1586y = f1584b;

    /* JADX INFO: renamed from: z */
    private BluetoothGattCharacteristic f1587z;

    @Override // p000.alb
    /* JADX INFO: renamed from: c */
    protected int mo1839c() {
        return 2;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: o */
    protected boolean mo1841o() {
        return true;
    }

    ald(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(f1585c);
        if (service == null) {
            return false;
        }
        this.f1587z = service.getCharacteristic(f1586y);
        return this.f1587z != null;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: n */
    protected BluetoothGattCharacteristic mo1840n() {
        return this.f1587z;
    }

    @Override // p000.alb, p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) {
        m1821c("Buttonless service without bond sharing found -> SDK 13 or newer");
        super.mo1838a(intent);
    }
}
