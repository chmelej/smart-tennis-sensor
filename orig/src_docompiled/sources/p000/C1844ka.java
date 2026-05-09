package p000;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.coollang.tennis.base.MyApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ka */
/* JADX INFO: compiled from: SearchDevice.java */
/* JADX INFO: loaded from: classes.dex */
public class C1844ka {

    /* JADX INFO: renamed from: a */
    static C1844ka f10863a;

    /* JADX INFO: renamed from: b */
    static final List<String> f10864b = new ArrayList();

    /* JADX INFO: renamed from: e */
    private static BluetoothAdapter f10865e;

    /* JADX INFO: renamed from: f */
    private InterfaceC1876lf f10868f;

    /* JADX INFO: renamed from: g */
    private boolean f10869g = false;

    /* JADX INFO: renamed from: c */
    byte[] f10866c = new byte[0];

    /* JADX INFO: renamed from: d */
    @SuppressLint({"NewApi"})
    BluetoothAdapter.LeScanCallback f10867d = new BluetoothAdapter.LeScanCallback() { // from class: ka.1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
            MyApplication.m7738a().m7744d().post(new Runnable() { // from class: ka.1.1
                @Override // java.lang.Runnable
                public void run() {
                    C1900mc.m10474b("deviceSearch", "length == " + bArr.length + C1844ka.this.m10075a(bArr));
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        if (bArr[i2] == -1 && bArr[i2 - 1] == 7) {
                            String str = new String(new byte[]{bArr[i2 + 2], bArr[i2 + 1]});
                            if (C1844ka.f10864b.contains(str) && C1844ka.this.f10868f != null && bluetoothDevice != null) {
                                C1844ka.this.f10868f.mo10250a(bluetoothDevice, i, str);
                            }
                            C1900mc.m10474b("deviceSearch", "address: = " + bluetoothDevice.getAddress() + " Rssi = " + i + " pid = " + str);
                        }
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: a */
    public static C1844ka m10073a() {
        if (f10863a == null) {
            f10863a = new C1844ka();
            f10864b.add("T0");
            f10864b.add("T2");
            f10864b.add("T1");
            f10864b.add("TS");
            f10864b.add("T5");
        }
        if (f10865e == null) {
            f10865e = BluetoothAdapter.getDefaultAdapter();
        }
        return f10863a;
    }

    /* JADX INFO: renamed from: a */
    public void m10077a(InterfaceC1876lf interfaceC1876lf) {
        this.f10868f = interfaceC1876lf;
    }

    /* JADX INFO: renamed from: a */
    public void m10078a(boolean z, long j) {
        if (z) {
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: ka.2
                @Override // java.lang.Runnable
                public void run() {
                    C1844ka.this.m10081c();
                    if (C1844ka.this.f10868f != null) {
                        C1844ka.this.f10868f.mo10249a();
                    }
                }
            }, j);
            m10079b();
        } else {
            m10081c();
        }
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: b */
    public void m10079b() {
        if (f10865e != null) {
            f10865e.startLeScan(this.f10867d);
        }
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: c */
    public void m10081c() {
        if (f10865e != null) {
            f10865e.stopLeScan(this.f10867d);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10076a(String str) {
        if (str.startsWith("A")) {
            C1853kj.f10919a = "1000";
            C1853kj.f10920b = "3000";
            C1853kj.f10921c = "0003";
            C1853kj.f10922d = "1000";
            C1853kj.f10923e = "2000";
            return;
        }
        if (str.contains("KU") || str.contains("M")) {
            C1853kj.f10919a = "ffe0";
            C1853kj.f10920b = "ffe4";
            C1853kj.f10922d = "ffe5";
            C1853kj.f10923e = "ffe9";
            C1853kj.f10921c = "ffe4";
        }
    }

    /* JADX INFO: renamed from: a */
    public String m10075a(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("this byteArray must not be null or empty");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(bArr[i] & 255));
        }
        return sb.toString().toLowerCase();
    }

    /* JADX INFO: renamed from: b */
    public void m10080b(String str) {
        if (str != null) {
            m10081c();
            m10076a(str);
            MyApplication.m7738a().f7405f = str;
            C1902me.m10484a(C1914mm.m10554a(), "devicetype", str);
            C1900mc.m10474b("PID_SET", " PID ==  " + str);
        }
    }
}
