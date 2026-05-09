package p000;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.blemanager.RFStarBLEService;

/* JADX INFO: renamed from: jv */
/* JADX INFO: compiled from: BLEDevice.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public abstract class AbstractC1838jv {

    /* JADX INFO: renamed from: e */
    protected static RFStarBLEService f10806e;

    /* JADX INFO: renamed from: f */
    public static BluetoothDevice f10807f;

    /* JADX INFO: renamed from: h */
    static Handler f10808h = new Handler();

    /* JADX INFO: renamed from: i */
    static Runnable f10809i = new Runnable() { // from class: jv.2
        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC1838jv.f10807f != null && AbstractC1838jv.f10806e != null && MyApplication.m7738a().m7743c() != null && MyApplication.m7738a().m7743c().isEnabled()) {
                C1808is.m9827c("postRun");
                AbstractC1838jv.f10806e.m7759c(AbstractC1838jv.f10807f);
                AbstractC1838jv.f10808h.postDelayed(this, 2000L);
            } else if (C1839jw.f10820a != null) {
                C1839jw.f10820a.m10016a();
                C1839jw.f10820a = null;
                MyApplication.m7738a().f7401b = false;
            }
        }
    };

    /* JADX INFO: renamed from: a */
    Intent f10810a;

    /* JADX INFO: renamed from: b */
    protected Context f10811b;

    /* JADX INFO: renamed from: c */
    public String f10812c;

    /* JADX INFO: renamed from: d */
    public String f10813d;

    /* JADX INFO: renamed from: g */
    public a f10814g = null;

    /* JADX INFO: renamed from: j */
    private ServiceConnection f10815j = new ServiceConnection() { // from class: jv.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC1838jv.f10806e = null;
            Log.w("App.TAG", "bbbbbbbbbbb gatt is onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AbstractC1838jv.f10806e = ((RFStarBLEService.BinderC1218a) iBinder).m7761a();
            AbstractC1838jv.f10806e.m7757a(AbstractC1838jv.f10807f);
            Log.w("App.TAG", "bbbbbbbbbbb gatt is init");
        }
    };

    /* JADX INFO: renamed from: k */
    private int f10816k = 0;

    /* JADX INFO: renamed from: l */
    private BroadcastReceiver f10817l = new BroadcastReceiver() { // from class: jv.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("com.rfstar.kevin.service.characteristic");
            if ("com.rfstar.kevin.service.ACTION_GATT_CONNECTED".equals(intent.getAction())) {
                Log.d("App.TAG", " connect is succed");
                AbstractC1838jv.f10808h.removeCallbacks(AbstractC1838jv.f10809i);
                AbstractC1838jv.this.f10816k = 0;
            } else if ("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED".equals(intent.getAction())) {
                AbstractC1838jv.f10808h.removeCallbacks(AbstractC1838jv.f10809i);
                AbstractC1838jv.f10808h.post(AbstractC1838jv.f10809i);
            } else if ("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED".equals(intent.getAction())) {
                AbstractC1838jv.this.mo10022d();
            } else if ("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE".equals(intent.getAction()) && intent.getByteArrayExtra("com.rfstar.kevin.service.EXTRA_DATA") == null) {
                return;
            }
            if (AbstractC1838jv.this.f10814g != null) {
                AbstractC1838jv.this.f10814g.mo7490a(context, intent, AbstractC1838jv.f10807f.getAddress(), stringExtra);
            }
        }
    };

    /* JADX INFO: renamed from: jv$a */
    /* JADX INFO: compiled from: BLEDevice.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7490a(Context context, Intent intent, String str, String str2);
    }

    /* JADX INFO: renamed from: d */
    protected abstract void mo10022d();

    public AbstractC1838jv(Context context, BluetoothDevice bluetoothDevice) {
        this.f10811b = null;
        this.f10812c = null;
        this.f10813d = null;
        f10807f = bluetoothDevice;
        this.f10812c = f10807f.getName();
        this.f10813d = f10807f.getAddress();
        this.f10811b = context;
        m10021c();
        if (this.f10810a == null) {
            this.f10810a = new Intent(this.f10811b, (Class<?>) RFStarBLEService.class);
            this.f10811b.bindService(this.f10810a, this.f10815j, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10019a(a aVar) {
        this.f10814g = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m10017a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic == null) {
            Log.w("App.TAG", "55555555555 writeValue characteristic is null");
            return;
        }
        Log.d("App.TAG", "charaterUUID write is success  : " + bluetoothGattCharacteristic.getUuid().toString());
        f10806e.m7755a(f10807f, bluetoothGattCharacteristic);
    }

    /* JADX INFO: renamed from: a */
    public void m10018a(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (bluetoothGattCharacteristic == null) {
            Log.w("App.TAG", "55555555555 Notification characteristic is null");
        } else {
            f10806e.m7756a(f10807f, bluetoothGattCharacteristic, z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10016a() {
        f10806e.m7758b(f10807f);
        this.f10811b.unregisterReceiver(this.f10817l);
        this.f10811b.unbindService(this.f10815j);
        f10808h.removeCallbacks(f10809i);
        C1839jw.f10820a = null;
        f10806e = null;
    }

    /* JADX INFO: renamed from: b */
    protected IntentFilter m10020b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.rfstar.kevin.service.ACTION_GATT_CONNECTED");
        intentFilter.addAction("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED");
        intentFilter.addAction("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED");
        intentFilter.addAction("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE");
        intentFilter.addAction("com.rfstar.kevin.service.RSSI");
        intentFilter.addAction("com.rfstar.kevin.service.ACTION_GATT_CONNECTING");
        return intentFilter;
    }

    /* JADX INFO: renamed from: c */
    public void m10021c() {
        this.f10811b.registerReceiver(this.f10817l, m10020b());
    }

    /* JADX INFO: renamed from: e */
    public String m10023e() {
        return this.f10812c != null ? this.f10812c.trim() : "";
    }
}
