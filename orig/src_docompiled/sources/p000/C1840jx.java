package p000;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: renamed from: jx */
/* JADX INFO: compiled from: CubicBLEDevice.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class C1840jx extends AbstractC1838jv {
    public C1840jx(Context context, BluetoothDevice bluetoothDevice) {
        super(context, bluetoothDevice);
    }

    @Override // p000.AbstractC1838jv
    /* JADX INFO: renamed from: d */
    protected void mo10022d() {
        Log.d("App.TAG", "load all the services ");
        for (BluetoothGattService bluetoothGattService : f10806e.m7760d(f10807f)) {
            Long.toHexString(bluetoothGattService.getUuid().getMostSignificantBits()).substring(0, 4);
            Iterator<BluetoothGattCharacteristic> it = bluetoothGattService.getCharacteristics().iterator();
            while (it.hasNext()) {
                Long.toHexString(it.next().getUuid().getMostSignificantBits()).substring(0, 4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10047a(String str, String str2, byte[] bArr) {
        C1808is.m9827c("serviceUUID=" + str + ";characteristicUUID=" + str2 + ";");
        for (BluetoothGattService bluetoothGattService : f10806e.m7760d(f10807f)) {
            String strSubstring = Long.toHexString(bluetoothGattService.getUuid().getMostSignificantBits()).substring(0, 4);
            C1808is.m9827c("gattServiceUUID=" + strSubstring + ";");
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                C1808is.m9827c(Long.toHexString(bluetoothGattCharacteristic.getUuid().getMostSignificantBits()));
                String strSubstring2 = Long.toHexString(bluetoothGattCharacteristic.getUuid().getMostSignificantBits()).substring(0, 4);
                C1808is.m9827c(";characterUUID=" + strSubstring2);
                if (strSubstring.equals(str) && str2.equals(strSubstring2)) {
                    C1808is.m9827c(bArr);
                    bluetoothGattCharacteristic.setValue(bArr);
                    m10017a(bluetoothGattCharacteristic);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10046a(String str, String str2, boolean z) {
        for (BluetoothGattService bluetoothGattService : f10806e.m7760d(f10807f)) {
            String strSubstring = Long.toHexString(bluetoothGattService.getUuid().getMostSignificantBits()).substring(0, 4);
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                String strSubstring2 = Long.toHexString(bluetoothGattCharacteristic.getUuid().getMostSignificantBits()).substring(0, 4);
                if (strSubstring.equals(str) && str2.equals(strSubstring2)) {
                    m10018a(bluetoothGattCharacteristic, z);
                }
            }
        }
    }
}
