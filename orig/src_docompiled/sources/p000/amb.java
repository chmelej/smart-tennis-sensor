package p000;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import java.util.List;

/* JADX INFO: compiled from: BootloaderScannerLollipop.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class amb extends ScanCallback implements aly {

    /* JADX INFO: renamed from: a */
    private final Object f1703a = new Object();

    /* JADX INFO: renamed from: b */
    private String f1704b;

    /* JADX INFO: renamed from: c */
    private String f1705c;

    /* JADX INFO: renamed from: d */
    private String f1706d;

    /* JADX INFO: renamed from: e */
    private boolean f1707e;

    @Override // p000.aly
    /* JADX INFO: renamed from: a */
    public String mo1910a(String str) {
        String strSubstring = str.substring(0, 15);
        String str2 = String.format("%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
        this.f1704b = str;
        this.f1705c = strSubstring + str2;
        this.f1706d = null;
        this.f1707e = false;
        new Thread(new Runnable() { // from class: amb.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused) {
                }
                if (amb.this.f1707e) {
                    return;
                }
                amb.this.f1706d = null;
                amb.this.f1707e = true;
                synchronized (amb.this.f1703a) {
                    amb.this.f1703a.notifyAll();
                }
            }
        }, "Scanner timer").start();
        BluetoothLeScanner bluetoothLeScanner = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();
        bluetoothLeScanner.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), this);
        try {
            synchronized (this.f1703a) {
                while (!this.f1707e) {
                    this.f1703a.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.f1706d;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i, ScanResult scanResult) {
        String address = scanResult.getDevice().getAddress();
        if (this.f1704b.equals(address) || this.f1705c.equals(address)) {
            this.f1706d = address;
            this.f1707e = true;
            synchronized (this.f1703a) {
                this.f1703a.notifyAll();
            }
        }
    }
}
