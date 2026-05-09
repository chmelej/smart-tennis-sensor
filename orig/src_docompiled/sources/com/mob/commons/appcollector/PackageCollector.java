package com.mob.commons.appcollector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mob.commons.C1541a;
import com.mob.commons.C1549c;
import com.mob.commons.C1553e;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class PackageCollector {

    /* JADX INFO: renamed from: a */
    private static final String[] f8951a = {"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED"};

    /* JADX INFO: renamed from: b */
    private static PackageCollector f8952b;

    /* JADX INFO: renamed from: c */
    private Context f8953c;

    /* JADX INFO: renamed from: d */
    private Hashon f8954d = new Hashon();

    /* JADX INFO: renamed from: e */
    private Handler f8955e;

    public static synchronized boolean register(Context context, String str) {
        startCollector(context);
        return true;
    }

    public static synchronized void startCollector(Context context) {
        if (f8952b == null) {
            f8952b = new PackageCollector(context);
            f8952b.m8467a();
        }
    }

    private PackageCollector(Context context) {
        this.f8953c = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    private void m8467a() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.commons.appcollector.PackageCollector.1
            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                C1553e.m8546a(new File(ResHelper.getCacheRoot(PackageCollector.this.f8953c), "comm/locks/.pkg_lock"), new Runnable() { // from class: com.mob.commons.appcollector.PackageCollector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (C1541a.m8448d(PackageCollector.this.f8953c)) {
                            PackageCollector.this.m8473b();
                        }
                        PackageCollector.this.m8480e();
                        m8482a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: a */
            public void m8482a() {
                super.run();
            }
        };
        mobHandlerThread.start();
        this.f8955e = new Handler(mobHandlerThread.getLooper(), new Handler.Callback() { // from class: com.mob.commons.appcollector.PackageCollector.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                PackageCollector.this.m8481f();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m8473b() {
        ArrayList<HashMap<String, String>> arrayList;
        ArrayList<HashMap<String, String>> arrayList2;
        ArrayList<HashMap<String, String>> arrayListM8475c = m8475c();
        if (arrayListM8475c == null || arrayListM8475c.isEmpty()) {
            try {
                arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8953c), "getInstalledApp", false);
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
                arrayList = new ArrayList<>();
            }
            m8469a(C1541a.m8457m(this.f8953c), "APPS_ALL", arrayList);
            m8470a(arrayList);
            m8468a(C1541a.m8440a(this.f8953c) + (C1541a.m8449e(this.f8953c) * 1000));
            return;
        }
        long jM8440a = C1541a.m8440a(this.f8953c);
        if (jM8440a >= m8477d()) {
            try {
                arrayList2 = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8953c), "getInstalledApp", false);
            } catch (Throwable th2) {
                MobLog.getInstance().m8622w(th2);
                arrayList2 = new ArrayList<>();
            }
            m8469a(C1541a.m8457m(this.f8953c), "APPS_ALL", arrayList2);
            m8470a(arrayList2);
            m8468a(jM8440a + (C1541a.m8449e(this.f8953c) * 1000));
            return;
        }
        m8481f();
    }

    /* JADX INFO: renamed from: c */
    private ArrayList<HashMap<String, String>> m8475c() {
        File file = new File(ResHelper.getCacheRoot(this.f8953c), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            try {
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file)), "utf-8"));
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    HashMap<String, String> mapFromJson = this.f8954d.fromJson(line);
                    if (mapFromJson != null) {
                        arrayList.add(mapFromJson);
                    }
                }
                bufferedReader.close();
                return arrayList;
            } catch (Throwable th) {
                MobLog.getInstance().m8610d(th);
            }
        }
        return new ArrayList<>();
    }

    /* JADX INFO: renamed from: a */
    private void m8469a(long j, String str, ArrayList<HashMap<String, String>> arrayList) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", str);
        map.put("list", arrayList);
        map.put("datetime", Long.valueOf(C1541a.m8440a(this.f8953c)));
        C1549c.m8516a(this.f8953c).m8529a(j, map);
    }

    /* JADX INFO: renamed from: a */
    private void m8470a(ArrayList<HashMap<String, String>> arrayList) {
        File file = new File(ResHelper.getCacheRoot(this.f8953c), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file)), "utf-8");
            Iterator<HashMap<String, String>> it = arrayList.iterator();
            while (it.hasNext()) {
                outputStreamWriter.append((CharSequence) this.f8954d.fromHashMap(it.next())).append('\n');
            }
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8468a(long j) {
        File file = new File(ResHelper.getCacheRoot(this.f8953c), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(j);
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: d */
    private long m8477d() {
        File file = new File(ResHelper.getCacheRoot(this.f8953c), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            return 0L;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            long j = dataInputStream.readLong();
            dataInputStream.close();
            return j;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m8480e() {
        IntentFilter intentFilter = new IntentFilter();
        for (int i = 0; i < f8951a.length; i++) {
            intentFilter.addAction(f8951a[i]);
        }
        intentFilter.addDataScheme("package");
        this.f8953c.registerReceiver(new BroadcastReceiver() { // from class: com.mob.commons.appcollector.PackageCollector.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (!PackageCollector.this.m8472a(intent != null ? intent.getAction() : null) || PackageCollector.this.f8955e == null) {
                    return;
                }
                PackageCollector.this.f8955e.removeMessages(1);
                PackageCollector.this.f8955e.sendEmptyMessageDelayed(1, 5000L);
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m8472a(String str) {
        for (String str2 : f8951a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m8481f() {
        ArrayList<HashMap<String, String>> arrayList;
        ArrayList<HashMap<String, String>> arrayListM8475c = m8475c();
        try {
            arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8953c), "getInstalledApp", false);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            arrayList = new ArrayList<>();
        }
        if (arrayListM8475c == null || arrayListM8475c.isEmpty()) {
            m8469a(C1541a.m8457m(this.f8953c), "APPS_ALL", arrayList);
            m8470a(arrayList);
            m8468a(C1541a.m8440a(this.f8953c) + (C1541a.m8449e(this.f8953c) * 1000));
            return;
        }
        ArrayList<HashMap<String, String>> arrayListM8466a = m8466a(arrayList, arrayListM8475c);
        if (!arrayListM8466a.isEmpty()) {
            m8469a(C1541a.m8440a(this.f8953c), "APPS_INCR", arrayListM8466a);
        }
        ArrayList<HashMap<String, String>> arrayListM8466a2 = m8466a(arrayListM8475c, arrayList);
        if (!arrayListM8466a2.isEmpty()) {
            m8469a(C1541a.m8440a(this.f8953c), "UNINSTALL", arrayListM8466a2);
        }
        m8470a(arrayList);
        m8468a(C1541a.m8440a(this.f8953c) + (C1541a.m8449e(this.f8953c) * 1000));
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<HashMap<String, String>> m8466a(ArrayList<HashMap<String, String>> arrayList, ArrayList<HashMap<String, String>> arrayList2) {
        ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
        for (HashMap<String, String> map : arrayList) {
            String str = map.get("pkg");
            if (!TextUtils.isEmpty(str)) {
                boolean z = false;
                Iterator<HashMap<String, String>> it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (str.equals(it.next().get("pkg"))) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList3.add(map);
                }
            }
        }
        return arrayList3;
    }
}
