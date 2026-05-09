package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: compiled from: ExperimentalButtonlessDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
class alj extends alb {

    /* JADX INFO: renamed from: a */
    protected static final UUID f1603a = new UUID(-8196551313441075360L, -6937650605005804976L);

    /* JADX INFO: renamed from: b */
    protected static final UUID f1604b = new UUID(-8196551313441075360L, -6937650605005804976L);

    /* JADX INFO: renamed from: c */
    protected static UUID f1605c = f1603a;

    /* JADX INFO: renamed from: y */
    protected static UUID f1606y = f1604b;

    /* JADX INFO: renamed from: z */
    private BluetoothGattCharacteristic f1607z;

    @Override // p000.alb
    /* JADX INFO: renamed from: c */
    protected int mo1839c() {
        return 1;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: o */
    protected boolean mo1841o() {
        return true;
    }

    alj(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // p000.alh
    /* JADX INFO: renamed from: a */
    public boolean mo1842a(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(f1605c);
        if (service == null) {
            return false;
        }
        this.f1607z = service.getCharacteristic(f1606y);
        return this.f1607z != null;
    }

    @Override // p000.alb
    /* JADX INFO: renamed from: n */
    protected BluetoothGattCharacteristic mo1840n() {
        return this.f1607z;
    }

    @Override // p000.alb, p000.alh
    /* JADX INFO: renamed from: a */
    public void mo1838a(Intent intent) {
        m1821c("Experimental buttonless service found -> SDK 12.x");
        super.mo1838a(intent);
    }
}
