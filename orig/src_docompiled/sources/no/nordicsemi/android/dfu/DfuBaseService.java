package no.nordicsemi.android.dfu;

import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import cn.sharesdk.framework.C0845d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
import p000.ale;
import p000.alg;
import p000.alo;
import p000.alp;

/* JADX INFO: loaded from: classes.dex */
public abstract class DfuBaseService extends IntentService implements alg.InterfaceC0188a {

    /* JADX INFO: renamed from: a */
    public static boolean f11730a = false;

    /* JADX INFO: renamed from: b */
    protected int f11731b;

    /* JADX INFO: renamed from: c */
    public alg f11732c;

    /* JADX INFO: renamed from: d */
    private final Object f11733d;

    /* JADX INFO: renamed from: e */
    private BluetoothAdapter f11734e;

    /* JADX INFO: renamed from: f */
    private String f11735f;

    /* JADX INFO: renamed from: g */
    private String f11736g;

    /* JADX INFO: renamed from: h */
    private boolean f11737h;

    /* JADX INFO: renamed from: i */
    private int f11738i;

    /* JADX INFO: renamed from: j */
    private int f11739j;

    /* JADX INFO: renamed from: k */
    private long f11740k;

    /* JADX INFO: renamed from: l */
    private boolean f11741l;

    /* JADX INFO: renamed from: m */
    private ale f11742m;

    /* JADX INFO: renamed from: n */
    private final BroadcastReceiver f11743n;

    /* JADX INFO: renamed from: o */
    private final BroadcastReceiver f11744o;

    /* JADX INFO: renamed from: p */
    private final BroadcastReceiver f11745p;

    /* JADX INFO: renamed from: q */
    private final BluetoothGattCallback f11746q;

    /* JADX INFO: renamed from: c */
    protected abstract Class<? extends Activity> mo10790c();

    /* JADX INFO: renamed from: d */
    protected boolean m10791d() {
        return false;
    }

    public DfuBaseService() {
        super("DfuBaseService");
        this.f11733d = new Object();
        this.f11739j = -1;
        this.f11743n = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 0);
                DfuBaseService.this.m10779d("User action received: " + intExtra);
                switch (intExtra) {
                    case 0:
                        DfuBaseService.this.m10785a(15, "[Broadcast] Pause action received");
                        if (DfuBaseService.this.f11742m != null) {
                            DfuBaseService.this.f11742m.mo1823e();
                        }
                        break;
                    case 1:
                        DfuBaseService.this.m10785a(15, "[Broadcast] Resume action received");
                        if (DfuBaseService.this.f11742m != null) {
                            DfuBaseService.this.f11742m.mo1824f();
                        }
                        break;
                    case 2:
                        DfuBaseService.this.m10785a(15, "[Broadcast] Abort action received");
                        DfuBaseService.this.f11741l = true;
                        if (DfuBaseService.this.f11742m != null) {
                            DfuBaseService.this.f11742m.mo1825g();
                        }
                        break;
                }
            }
        };
        this.f11744o = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                if (!((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.f11735f) || (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) == 11 || DfuBaseService.this.f11742m == null) {
                    return;
                }
                DfuBaseService.this.f11742m.mo1813a(intExtra);
            }
        };
        this.f11745p = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.f11735f)) {
                    String action = intent.getAction();
                    DfuBaseService.this.m10779d("Action received: " + action);
                    DfuBaseService.this.m10785a(0, "[Broadcast] Action received: " + action);
                    DfuBaseService.this.f11731b = 0;
                    if (DfuBaseService.this.f11742m != null) {
                        DfuBaseService.this.f11742m.mo1776b().mo1835a();
                    }
                    synchronized (DfuBaseService.this.f11733d) {
                        DfuBaseService.this.f11733d.notifyAll();
                    }
                }
            }
        };
        this.f11746q = new BluetoothGattCallback() { // from class: no.nordicsemi.android.dfu.DfuBaseService.4
            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                if (i != 0) {
                    DfuBaseService.this.m10774b("Connection state change error: " + i + " newState: " + i2);
                    if (i2 == 0) {
                        DfuBaseService.this.f11731b = 0;
                        if (DfuBaseService.this.f11742m != null) {
                            DfuBaseService.this.f11742m.mo1776b().mo1835a();
                        }
                    }
                    DfuBaseService.this.f11738i = i | 32768;
                } else if (i2 == 2) {
                    DfuBaseService.this.m10779d("Connected to GATT server");
                    DfuBaseService.this.m10785a(5, "Connected to " + DfuBaseService.this.f11735f);
                    DfuBaseService.this.f11731b = -2;
                    if (bluetoothGatt.getDevice().getBondState() == 12) {
                        DfuBaseService.this.m10779d("Waiting 1600 ms for a possible Service Changed indication...");
                        DfuBaseService.this.m10784a(1600);
                    }
                    DfuBaseService.this.m10785a(1, "Discovering services...");
                    DfuBaseService.this.m10785a(0, "gatt.discoverServices()");
                    boolean zDiscoverServices = bluetoothGatt.discoverServices();
                    DfuBaseService dfuBaseService = DfuBaseService.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to start service discovery... ");
                    sb.append(zDiscoverServices ? "succeed" : "failed");
                    dfuBaseService.m10779d(sb.toString());
                    if (zDiscoverServices) {
                        return;
                    } else {
                        DfuBaseService.this.f11738i = 4101;
                    }
                } else if (i2 == 0) {
                    DfuBaseService.this.m10779d("Disconnected from GATT server");
                    DfuBaseService.this.f11731b = 0;
                    if (DfuBaseService.this.f11742m != null) {
                        DfuBaseService.this.f11742m.mo1776b().mo1835a();
                    }
                }
                synchronized (DfuBaseService.this.f11733d) {
                    DfuBaseService.this.f11733d.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                if (i == 0) {
                    DfuBaseService.this.m10779d("Services discovered");
                    DfuBaseService.this.f11731b = -3;
                } else {
                    DfuBaseService.this.m10774b("Service discovery error: " + i);
                    DfuBaseService.this.f11738i = i | 16384;
                }
                synchronized (DfuBaseService.this.f11733d) {
                    DfuBaseService.this.f11733d.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.f11742m != null) {
                    DfuBaseService.this.f11742m.mo1776b().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.f11742m != null) {
                    DfuBaseService.this.f11742m.mo1776b().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                if (DfuBaseService.this.f11742m != null) {
                    DfuBaseService.this.f11742m.mo1776b().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.f11742m != null) {
                    DfuBaseService.this.f11742m.mo1776b().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.f11742m != null) {
                    DfuBaseService.this.f11742m.mo1776b().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }
        };
    }

    /* JADX INFO: renamed from: e */
    private static IntentFilter m10780e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
        return intentFilter;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f11730a = m10791d();
        m10781f();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilterM10780e = m10780e();
        localBroadcastManager.registerReceiver(this.f11743n, intentFilterM10780e);
        registerReceiver(this.f11743n, intentFilterM10780e);
        registerReceiver(this.f11745p, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        registerReceiver(this.f11744o, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        ((NotificationManager) getSystemService("notification")).cancel(283);
        stopSelf();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f11743n);
        unregisterReceiver(this.f11743n);
        unregisterReceiver(this.f11745p);
        unregisterReceiver(this.f11744o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ca A[Catch: all -> 0x00fa, PHI: r4
      0x03ca: PHI (r4v34 alh) = (r4v51 alh), (r4v52 alh), (r4v53 alh) binds: [B:191:0x03fe, B:181:0x03c8, B:188:0x03e7] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x00fa, blocks: (B:48:0x00f1, B:66:0x012b, B:68:0x0133, B:69:0x013a, B:71:0x013d, B:73:0x0145, B:75:0x014e, B:77:0x0156, B:79:0x015d, B:81:0x0165, B:82:0x016c, B:83:0x016d, B:85:0x0171, B:87:0x0179, B:88:0x0180, B:89:0x0181, B:91:0x0185, B:93:0x018d, B:94:0x0194, B:97:0x0198, B:99:0x019e, B:100:0x01a8, B:102:0x01ae, B:103:0x01b7, B:105:0x01d4, B:107:0x01e6, B:111:0x01fd, B:113:0x020f, B:117:0x0224, B:119:0x0228, B:123:0x023d, B:125:0x0247, B:127:0x024c, B:129:0x02b0, B:131:0x02b9, B:133:0x02c4, B:134:0x02c7, B:138:0x02ec, B:128:0x027e, B:142:0x02f7, B:144:0x02fb, B:148:0x0316, B:154:0x0345, B:163:0x035d, B:199:0x040b, B:200:0x040e, B:182:0x03ca, B:62:0x0119, B:64:0x0121), top: B:267:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1 A[Catch: all -> 0x00fa, Exception -> 0x00fe, IOException -> 0x0103, alv -> 0x0108, FileNotFoundException -> 0x010d, SecurityException -> 0x0112, TRY_ENTER, TryCatch #16 {all -> 0x00fa, blocks: (B:48:0x00f1, B:66:0x012b, B:68:0x0133, B:69:0x013a, B:71:0x013d, B:73:0x0145, B:75:0x014e, B:77:0x0156, B:79:0x015d, B:81:0x0165, B:82:0x016c, B:83:0x016d, B:85:0x0171, B:87:0x0179, B:88:0x0180, B:89:0x0181, B:91:0x0185, B:93:0x018d, B:94:0x0194, B:97:0x0198, B:99:0x019e, B:100:0x01a8, B:102:0x01ae, B:103:0x01b7, B:105:0x01d4, B:107:0x01e6, B:111:0x01fd, B:113:0x020f, B:117:0x0224, B:119:0x0228, B:123:0x023d, B:125:0x0247, B:127:0x024c, B:129:0x02b0, B:131:0x02b9, B:133:0x02c4, B:134:0x02c7, B:138:0x02ec, B:128:0x027e, B:142:0x02f7, B:144:0x02fb, B:148:0x0316, B:154:0x0345, B:163:0x035d, B:199:0x040b, B:200:0x040e, B:182:0x03ca, B:62:0x0119, B:64:0x0121), top: B:267:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0133 A[Catch: all -> 0x00fa, Exception -> 0x00fe, IOException -> 0x0103, alv -> 0x0108, FileNotFoundException -> 0x010d, SecurityException -> 0x0112, TryCatch #16 {all -> 0x00fa, blocks: (B:48:0x00f1, B:66:0x012b, B:68:0x0133, B:69:0x013a, B:71:0x013d, B:73:0x0145, B:75:0x014e, B:77:0x0156, B:79:0x015d, B:81:0x0165, B:82:0x016c, B:83:0x016d, B:85:0x0171, B:87:0x0179, B:88:0x0180, B:89:0x0181, B:91:0x0185, B:93:0x018d, B:94:0x0194, B:97:0x0198, B:99:0x019e, B:100:0x01a8, B:102:0x01ae, B:103:0x01b7, B:105:0x01d4, B:107:0x01e6, B:111:0x01fd, B:113:0x020f, B:117:0x0224, B:119:0x0228, B:123:0x023d, B:125:0x0247, B:127:0x024c, B:129:0x02b0, B:131:0x02b9, B:133:0x02c4, B:134:0x02c7, B:138:0x02ec, B:128:0x027e, B:142:0x02f7, B:144:0x02fb, B:148:0x0316, B:154:0x0345, B:163:0x035d, B:199:0x040b, B:200:0x040e, B:182:0x03ca, B:62:0x0119, B:64:0x0121), top: B:267:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r18v0, types: [alg$a, android.content.Context, no.nordicsemi.android.dfu.DfuBaseService] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [alh] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onHandleIntent(android.content.Intent r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    /* JADX INFO: renamed from: a */
    private InputStream m10767a(String str, String str2, int i, int i2) {
        FileInputStream fileInputStream = new FileInputStream(str);
        if ("application/zip".equals(str2)) {
            return new alo(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new alp(fileInputStream, i) : fileInputStream;
    }

    /* JADX INFO: renamed from: a */
    private InputStream m10766a(Uri uri, String str, int i, int i2) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        if ("application/zip".equals(str)) {
            return new alo(inputStreamOpenInputStream, i, i2);
        }
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        try {
            return (cursorQuery.moveToNext() && cursorQuery.getString(0).toLowerCase(Locale.US).endsWith("hex")) ? new alp(inputStreamOpenInputStream, i) : inputStreamOpenInputStream;
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: renamed from: a */
    private InputStream m10765a(int i, String str, int i2, int i3) throws IOException {
        InputStream inputStreamOpenRawResource = getResources().openRawResource(i);
        if ("application/zip".equals(str)) {
            return new alo(inputStreamOpenRawResource, i2, i3);
        }
        inputStreamOpenRawResource.mark(2);
        int i4 = inputStreamOpenRawResource.read();
        inputStreamOpenRawResource.reset();
        return i4 == 58 ? new alp(inputStreamOpenRawResource, i2) : inputStreamOpenRawResource;
    }

    /* JADX INFO: renamed from: a */
    protected BluetoothGatt m10782a(String str) {
        if (!this.f11734e.isEnabled()) {
            return null;
        }
        this.f11731b = -1;
        m10779d("Connecting to the device...");
        BluetoothDevice remoteDevice = this.f11734e.getRemoteDevice(str);
        m10785a(0, "gatt = device.connectGatt(autoConnect = false)");
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.f11746q);
        try {
            synchronized (this.f11733d) {
                while (true) {
                    if ((this.f11731b != -1 && this.f11731b != -2) || this.f11738i != 0) {
                        break;
                    }
                    this.f11733d.wait();
                }
            }
        } catch (InterruptedException e) {
            m10769a("Sleeping interrupted", e);
        }
        return bluetoothGattConnectGatt;
    }

    /* JADX INFO: renamed from: a */
    public void m10787a(BluetoothGatt bluetoothGatt, int i) {
        if (this.f11731b != 0) {
            m10786a(bluetoothGatt);
        }
        m10788a(bluetoothGatt, false);
        m10789b(bluetoothGatt);
        m10784a(600);
        if (i != 0) {
            m10773b(i);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m10786a(BluetoothGatt bluetoothGatt) {
        if (this.f11731b == 0) {
            return;
        }
        m10785a(1, "Disconnecting...");
        this.f11732c.m1846b(-5);
        this.f11731b = -4;
        m10779d("Disconnecting from the device...");
        m10785a(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        m10783a();
        m10785a(5, "Disconnected");
    }

    /* JADX INFO: renamed from: a */
    public void m10783a() {
        try {
            synchronized (this.f11733d) {
                while (this.f11731b != 0 && this.f11738i == 0) {
                    this.f11733d.wait();
                }
            }
        } catch (InterruptedException e) {
            m10769a("Sleeping interrupted", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10784a(int i) {
        synchronized (this.f11733d) {
            try {
                m10785a(0, "wait(" + i + ")");
                this.f11733d.wait((long) i);
            } catch (InterruptedException e) {
                m10769a("Sleeping interrupted", e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10789b(BluetoothGatt bluetoothGatt) {
        m10779d("Cleaning up...");
        m10785a(0, "gatt.close()");
        bluetoothGatt.close();
        this.f11731b = -5;
    }

    /* JADX INFO: renamed from: a */
    public void m10788a(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            m10785a(0, "gatt.refresh() (hidden)");
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    m10779d("Refreshing result: " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue());
                }
            } catch (Exception e) {
                m10769a("An exception occurred while refreshing device", e);
                m10785a(15, "Refreshing failed");
            }
        }
    }

    @Override // p000.alg.InterfaceC0188a
    /* JADX INFO: renamed from: b */
    public void mo1860b() {
        alg algVar = this.f11732c;
        int iM1850d = algVar.m1850d();
        if (this.f11739j == iM1850d) {
            return;
        }
        this.f11739j = iM1850d;
        m10768a(algVar);
        if (this.f11737h) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f11740k < 250) {
            return;
        }
        this.f11740k = jElapsedRealtime;
        String str = this.f11735f;
        String string = this.f11736g != null ? this.f11736g : getString(R.string.dfu_unknown_name);
        NotificationCompat.Builder onlyAlertOnce = new NotificationCompat.Builder(this).setSmallIcon(android.R.drawable.stat_sys_upload).setOnlyAlertOnce(true);
        onlyAlertOnce.setColor(-7829368);
        switch (iM1850d) {
            case C0845d.ERROR_IO /* -7 */:
                onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_aborted)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_aborted_msg)).setAutoCancel(true);
                break;
            case C0845d.ERROR_CONNECT /* -6 */:
                onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_completed)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_completed_msg)).setAutoCancel(true).setColor(-16730086);
                break;
            case -5:
                onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_disconnecting)).setContentText(getString(R.string.dfu_status_disconnecting_msg, new Object[]{string})).setProgress(100, 0, true);
                break;
            case -4:
                onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_validating)).setContentText(getString(R.string.dfu_status_validating_msg)).setProgress(100, 0, true);
                break;
            case -3:
                onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_switching_to_dfu)).setContentText(getString(R.string.dfu_status_switching_to_dfu_msg)).setProgress(100, 0, true);
                break;
            case -2:
                onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_starting)).setContentText(getString(R.string.dfu_status_starting_msg)).setProgress(100, 0, true);
                break;
            case -1:
                onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_connecting)).setContentText(getString(R.string.dfu_status_connecting_msg, new Object[]{string})).setProgress(100, 0, true);
                break;
            default:
                onlyAlertOnce.setOngoing(true).setContentTitle(algVar.m1858i() == 1 ? getString(R.string.dfu_status_uploading) : getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(algVar.m1857h()), Integer.valueOf(algVar.m1858i())})).setContentText(getString(R.string.dfu_status_uploading_msg, new Object[]{string})).setProgress(100, iM1850d, false);
                break;
        }
        Intent intent = new Intent(this, mo10790c());
        intent.addFlags(268435456);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", string);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", iM1850d);
        onlyAlertOnce.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
        if (iM1850d != -7 && iM1850d != -6) {
            Intent intent2 = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 2);
            onlyAlertOnce.addAction(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent2, 134217728));
        }
        ((NotificationManager) getSystemService("notification")).notify(283, onlyAlertOnce.build());
    }

    /* JADX INFO: renamed from: b */
    private void m10773b(int i) {
        m10777c(i);
        if (this.f11737h) {
            return;
        }
        String str = this.f11735f;
        String string = this.f11736g != null ? this.f11736g : getString(R.string.dfu_unknown_name);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this).setSmallIcon(android.R.drawable.stat_sys_upload).setOnlyAlertOnce(true).setColor(SupportMenu.CATEGORY_MASK).setOngoing(false).setContentTitle(getString(R.string.dfu_status_error)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_error_msg)).setAutoCancel(true);
        Intent intent = new Intent(this, mo10790c());
        intent.addFlags(268435456);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", string);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", i);
        autoCancel.setContentIntent(PendingIntent.getActivity(this, 0, intent, 134217728));
        ((NotificationManager) getSystemService("notification")).notify(283, autoCancel.build());
    }

    /* JADX INFO: renamed from: a */
    private void m10768a(alg algVar) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", algVar.m1850d());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f11735f);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", algVar.m1857h());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", algVar.m1858i());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", algVar.m1854f());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", algVar.m1856g());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: c */
    private void m10777c(int i) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
        if ((i & 16384) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i & (-16385));
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i & (-32769));
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 3);
        } else {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f11735f);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m10785a(int i, String str) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO", "[DFU] " + str);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL", i);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f11735f);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: f */
    private boolean m10781f() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            m10774b("Unable to initialize BluetoothManager.");
            return false;
        }
        this.f11734e = bluetoothManager.getAdapter();
        if (this.f11734e != null) {
            return true;
        }
        m10774b("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10774b(String str) {
        Log.e("DfuBaseService", str);
    }

    /* JADX INFO: renamed from: a */
    private void m10769a(String str, Throwable th) {
        Log.e("DfuBaseService", str, th);
    }

    /* JADX INFO: renamed from: c */
    private void m10778c(String str) {
        if (f11730a) {
            Log.w("DfuBaseService", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m10779d(String str) {
        if (f11730a) {
            Log.i("DfuBaseService", str);
        }
    }
}
