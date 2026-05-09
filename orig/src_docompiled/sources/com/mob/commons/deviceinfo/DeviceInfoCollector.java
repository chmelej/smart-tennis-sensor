package com.mob.commons.deviceinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.mob.commons.C1541a;
import com.mob.commons.C1549c;
import com.mob.commons.C1553e;
import com.mob.commons.C1558f;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfoCollector implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private static DeviceInfoCollector f8987a;

    /* JADX INFO: renamed from: b */
    private Context f8988b;

    /* JADX INFO: renamed from: d */
    private Handler f8990d;

    /* JADX INFO: renamed from: c */
    private Hashon f8989c = new Hashon();

    /* JADX INFO: renamed from: e */
    private Random f8991e = new Random();

    public static synchronized void startCollector(Context context) {
        if (f8987a == null) {
            f8987a = new DeviceInfoCollector(context);
            f8987a.m8534a();
        }
    }

    private DeviceInfoCollector(Context context) {
        this.f8988b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    private void m8534a() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.commons.deviceinfo.DeviceInfoCollector.1
            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                C1553e.m8546a(new File(ResHelper.getCacheRoot(DeviceInfoCollector.this.f8988b), "comm/locks/.dic_lock"), new Runnable() { // from class: com.mob.commons.deviceinfo.DeviceInfoCollector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m8544a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: a */
            public void m8544a() {
                super.run();
            }
        };
        mobHandlerThread.start();
        this.f8990d = new Handler(mobHandlerThread.getLooper(), this);
        this.f8990d.sendEmptyMessage(1);
        this.f8990d.sendEmptyMessage(2);
        this.f8990d.sendEmptyMessage(3);
        this.f8990d.sendEmptyMessage(5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (C1541a.m8451g(this.f8988b)) {
                    m8537b();
                }
                return false;
            case 2:
                if (C1541a.m8456l(this.f8988b)) {
                    if (m8539c()) {
                        m8540d();
                    }
                    m8541e();
                }
                return false;
            case 3:
                if (C1541a.m8452h(this.f8988b)) {
                    try {
                        m8542f();
                    } catch (Throwable th) {
                        MobLog.getInstance().m8622w(th);
                    }
                    break;
                }
                this.f8990d.sendEmptyMessageDelayed(4, (this.f8991e.nextInt(120) + 180) * 1000);
                return false;
            case 4:
                if (C1541a.m8452h(this.f8988b)) {
                    if (C1541a.m8440a(this.f8988b) + (((long) C1541a.m8453i(this.f8988b)) * 1000) >= C1541a.m8440a(this.f8988b)) {
                        try {
                            if (m8543g()) {
                                m8542f();
                            }
                        } catch (Throwable th2) {
                            MobLog.getInstance().m8622w(th2);
                        }
                        break;
                    } else {
                        m8542f();
                        break;
                    }
                    return false;
                }
                this.f8990d.sendEmptyMessageDelayed(4, (this.f8991e.nextInt(120) + 180) * 1000);
                return false;
            case 5:
                if (C1541a.m8454j(this.f8988b)) {
                    try {
                        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8988b);
                        m8535a((Location) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getLocation", 30, 0, true), 1);
                        m8535a((Location) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getLocation", 15, 0, true), 2);
                    } catch (Throwable th3) {
                        MobLog.getInstance().m8622w(th3);
                    }
                    break;
                }
                this.f8990d.sendEmptyMessageDelayed(5, C1541a.m8455k(this.f8988b) * 1000);
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8537b() {
        try {
            HashMap map = new HashMap();
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8988b);
            map.put("phonename", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getBluetoothName", new Object[0]));
            map.put("signmd5", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSignMD5", new Object[0]));
            String strMD5 = Data.MD5(this.f8989c.fromHashMap(map));
            String strM8555a = C1558f.m8555a(this.f8988b);
            if (strM8555a == null || !strM8555a.equals(strMD5)) {
                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("type", "DEVEXT");
                map2.put("data", map);
                map2.put("datetime", Long.valueOf(C1541a.m8440a(this.f8988b)));
                C1549c.m8516a(this.f8988b).m8529a(C1541a.m8440a(this.f8988b), map2);
                C1558f.m8557a(this.f8988b, strMD5);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m8539c() {
        long jM8558b = C1558f.m8558b(this.f8988b);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jM8558b);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        long jM8440a = C1541a.m8440a(this.f8988b);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(jM8440a);
        return (i == calendar2.get(1) && i2 == calendar2.get(2) && i3 == calendar2.get(5)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m8540d() {
        synchronized (f8987a) {
            try {
                HashMap map = new HashMap();
                Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8988b);
                map.put("ssid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSSID", new Object[0]));
                map.put("bssid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getBssid", new Object[0]));
                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("type", "WIFI_INFO");
                map2.put("data", map);
                long jM8440a = C1541a.m8440a(this.f8988b);
                map2.put("datetime", Long.valueOf(jM8440a));
                C1549c.m8516a(this.f8988b).m8529a(C1541a.m8440a(this.f8988b), map2);
                C1558f.m8556a(this.f8988b, jM8440a);
                C1558f.m8560b(this.f8988b, Data.MD5(this.f8989c.fromHashMap(map)));
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m8541e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.f8988b.registerReceiver(new BroadcastReceiver() { // from class: com.mob.commons.deviceinfo.DeviceInfoCollector.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Parcelable parcelableExtra;
                try {
                    if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null && ((NetworkInfo) parcelableExtra).isAvailable()) {
                        HashMap map = new HashMap();
                        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
                        map.put("ssid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSSID", new Object[0]));
                        map.put("bssid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getBssid", new Object[0]));
                        String strMD5 = Data.MD5(DeviceInfoCollector.this.f8989c.fromHashMap(map));
                        String strM8561c = C1558f.m8561c(context);
                        if ((strM8561c == null || !strM8561c.equals(strMD5)) && C1541a.m8456l(context)) {
                            DeviceInfoCollector.this.m8540d();
                        }
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: renamed from: f */
    private void m8542f() throws Throwable {
        int i;
        HashMap map = new HashMap();
        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8988b);
        try {
            i = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable unused) {
            i = -1;
        }
        map.put("carrier", Integer.valueOf(i));
        map.put("simopname", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCarrierName", new Object[0]));
        map.put("lac", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCellLac", new Object[0]));
        map.put("cell", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCellId", new Object[0]));
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("type", "BSINFO");
        map2.put("data", map);
        map2.put("datetime", Long.valueOf(C1541a.m8440a(this.f8988b)));
        C1549c.m8516a(this.f8988b).m8529a(C1541a.m8440a(this.f8988b), map2);
        C1558f.m8562c(this.f8988b, Data.MD5(this.f8989c.fromHashMap(map)));
        C1558f.m8559b(this.f8988b, C1541a.m8440a(this.f8988b) + (((long) C1541a.m8453i(this.f8988b)) * 1000));
    }

    /* JADX INFO: renamed from: g */
    private boolean m8543g() throws Throwable {
        int i;
        HashMap map = new HashMap();
        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8988b);
        try {
            i = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable unused) {
            i = -1;
        }
        map.put("carrier", Integer.valueOf(i));
        map.put("simopname", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCarrierName", new Object[0]));
        map.put("lac", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCellLac", new Object[0]));
        map.put("cell", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCellId", new Object[0]));
        String strMD5 = Data.MD5(this.f8989c.fromHashMap(map));
        String strM8563d = C1558f.m8563d(this.f8988b);
        return strM8563d == null || !strM8563d.equals(strMD5);
    }

    /* JADX INFO: renamed from: a */
    private void m8535a(Location location, int i) {
        if (location != null) {
            HashMap map = new HashMap();
            map.put("accuracy", Float.valueOf(location.getAccuracy()));
            map.put("latitude", Double.valueOf(location.getLatitude()));
            map.put("longitude", Double.valueOf(location.getLongitude()));
            map.put("location_type", Integer.valueOf(i));
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("type", "LOCATION");
            map2.put("data", map);
            map2.put("datetime", Long.valueOf(C1541a.m8440a(this.f8988b)));
            C1549c.m8516a(this.f8988b).m8529a(C1541a.m8440a(this.f8988b), map2);
        }
    }
}
