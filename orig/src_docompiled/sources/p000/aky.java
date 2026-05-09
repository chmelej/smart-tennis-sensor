package p000;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.DfuBaseService;
import p000.ala;

/* JADX INFO: compiled from: BaseButtonlessDfuImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class aky extends ala {

    /* JADX INFO: renamed from: a */
    private final C0183a f1537a;

    /* JADX INFO: renamed from: aky$a */
    /* JADX INFO: compiled from: BaseButtonlessDfuImpl.java */
    public class C0183a extends ala.C0186a {
        protected C0183a() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            aky.this.f1572u.m10785a(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + m1833a(bluetoothGattCharacteristic));
            aky.this.f1570s = bluetoothGattCharacteristic.getValue();
            aky.this.m1826h();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            aky.this.f1567p = true;
            aky.this.m1826h();
        }
    }

    aky(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.f1537a = new C0183a();
    }

    @Override // p000.ale
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ala.C0186a mo1776b() {
        return this.f1537a;
    }

    /* JADX INFO: renamed from: a */
    protected void m1775a(Intent intent, boolean z, boolean z2) {
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.f1572u.m10788a(this.f1562k, z || !booleanExtra);
        this.f1572u.m10789b(this.f1562k);
        if (this.f1562k.getDevice().getBondState() == 12 && (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false) || !booleanExtra)) {
            m1829k();
            this.f1572u.m10784a(2000);
        }
        m1821c("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        m1819b(intent2, z2);
    }
}
