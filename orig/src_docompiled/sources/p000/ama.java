package p000;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: compiled from: BootloaderScannerJB.java */
/* JADX INFO: loaded from: classes.dex */
public class ama implements aly, BluetoothAdapter.LeScanCallback {

    /* JADX INFO: renamed from: a */
    private final Object f1697a = new Object();

    /* JADX INFO: renamed from: b */
    private String f1698b;

    /* JADX INFO: renamed from: c */
    private String f1699c;

    /* JADX INFO: renamed from: d */
    private String f1700d;

    /* JADX INFO: renamed from: e */
    private boolean f1701e;

    @Override // p000.aly
    /* JADX INFO: renamed from: a */
    public String mo1910a(String str) {
        String strSubstring = str.substring(0, 15);
        String str2 = String.format("%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
        this.f1698b = str;
        this.f1699c = strSubstring + str2;
        this.f1700d = null;
        this.f1701e = false;
        new Thread(new Runnable() { // from class: ama.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused) {
                }
                if (ama.this.f1701e) {
                    return;
                }
                ama.this.f1700d = null;
                ama.this.f1701e = true;
                synchronized (ama.this.f1697a) {
                    ama.this.f1697a.notifyAll();
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.f1697a) {
                while (!this.f1701e) {
                    this.f1697a.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.f1700d;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (this.f1698b.equals(address) || this.f1699c.equals(address)) {
            this.f1700d = address;
            this.f1701e = true;
            synchronized (this.f1697a) {
                this.f1697a.notifyAll();
            }
        }
    }
}
