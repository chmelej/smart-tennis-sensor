package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mob.commons.logcollector.c */
/* JADX INFO: compiled from: LogsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1561c extends SSDKHandlerThread {

    /* JADX INFO: renamed from: a */
    private static C1561c f9007a = null;

    /* JADX INFO: renamed from: b */
    private static String f9008b = "http://api.exc.mob.com:80";

    /* JADX INFO: renamed from: d */
    private Context f9010d;

    /* JADX INFO: renamed from: f */
    private C1562d f9012f;

    /* JADX INFO: renamed from: g */
    private File f9013g;

    /* JADX INFO: renamed from: e */
    private NetworkHelper f9011e = new NetworkHelper();

    /* JADX INFO: renamed from: c */
    private HashMap<String, Integer> f9009c = new HashMap<>();

    /* JADX INFO: renamed from: h */
    private FileLocker f9014h = new FileLocker();

    private C1561c(Context context) {
        this.f9010d = context.getApplicationContext();
        this.f9012f = C1562d.m8592a(context);
        this.f9013g = new File(context.getFilesDir(), ".lock");
        if (!this.f9013g.exists()) {
            try {
                this.f9013g.createNewFile();
            } catch (Exception e) {
                MobLog.getInstance().m8622w(e);
            }
        }
        NLog.setContext(context);
        startThread();
    }

    /* JADX INFO: renamed from: a */
    public Context m8588a() {
        return this.f9010d;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C1561c m8577a(Context context) {
        if (f9007a == null) {
            f9007a = new C1561c(context);
        }
        return f9007a;
    }

    /* JADX INFO: renamed from: a */
    public void m8590a(int i, String str, String str2) {
        Message message = new Message();
        message.what = 100;
        message.arg1 = i;
        message.obj = new Object[]{str, str2};
        this.handler.sendMessage(message);
    }

    /* JADX INFO: renamed from: a */
    public void m8589a(int i, int i2, String str, String str2, String str3) {
        Message message = new Message();
        message.what = 101;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = new Object[]{str, str2, str3};
        this.handler.sendMessage(message);
    }

    /* JADX INFO: renamed from: a */
    private void m8580a(Message message) {
        this.handler.sendMessageDelayed(message, 1000L);
    }

    /* JADX INFO: renamed from: b */
    public void m8591b(int i, int i2, String str, String str2, String str3) {
        m8589a(i, i2, str, str2, str3);
        try {
            this.handler.wait();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onMessage(Message message) {
        switch (message.what) {
            case 100:
                m8584b(message);
                break;
            case 101:
                m8587c(message);
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8584b(Message message) {
        try {
            int i = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            m8583b(i, str, str2);
            m8579a(i, str, str2, null);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0128 A[Catch: Throwable -> 0x014e, TryCatch #1 {Throwable -> 0x014e, blocks: (B:3:0x0004, B:7:0x0023, B:9:0x002f, B:11:0x0042, B:13:0x0048, B:14:0x004c, B:16:0x0052, B:18:0x005e, B:21:0x0065, B:31:0x0088, B:45:0x00d8, B:48:0x00e3, B:52:0x00f7, B:57:0x010b, B:63:0x0120, B:65:0x0128, B:67:0x0136, B:69:0x0142, B:70:0x0146, B:6:0x0020), top: B:77:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0142 A[Catch: Throwable -> 0x014e, TryCatch #1 {Throwable -> 0x014e, blocks: (B:3:0x0004, B:7:0x0023, B:9:0x002f, B:11:0x0042, B:13:0x0048, B:14:0x004c, B:16:0x0052, B:18:0x005e, B:21:0x0065, B:31:0x0088, B:45:0x00d8, B:48:0x00e3, B:52:0x00f7, B:57:0x010b, B:63:0x0120, B:65:0x0128, B:67:0x0136, B:69:0x0142, B:70:0x0146, B:6:0x0020), top: B:77:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0146 A[Catch: Throwable -> 0x014e, TRY_LEAVE, TryCatch #1 {Throwable -> 0x014e, blocks: (B:3:0x0004, B:7:0x0023, B:9:0x002f, B:11:0x0042, B:13:0x0048, B:14:0x004c, B:16:0x0052, B:18:0x005e, B:21:0x0065, B:31:0x0088, B:45:0x00d8, B:48:0x00e3, B:52:0x00f7, B:57:0x010b, B:63:0x0120, B:65:0x0128, B:67:0x0136, B:69:0x0142, B:70:0x0146, B:6:0x0020), top: B:77:0x0004 }] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8587c(android.os.Message r26) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.logcollector.C1561c.m8587c(android.os.Message):void");
    }

    /* JADX INFO: renamed from: b */
    private String m8582b() {
        return f9008b + "/errconf";
    }

    /* JADX INFO: renamed from: b */
    private void m8583b(int i, String str, String str2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f9010d);
        arrayList.add(new KVPair<>("key", str2));
        arrayList.add(new KVPair<>("sdk", str));
        arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]))));
        arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppVersion", new Object[0]))));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(i)));
        arrayList.add(new KVPair<>("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPlatformCode", new Object[0]))));
        try {
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            String strHttpPost = this.f9011e.httpPost(m8582b(), arrayList, null, null, networkTimeOut);
            MobLog.getInstance().m8615i("get server config == %s", strHttpPost);
            HashMap mapFromJson = new Hashon().fromJson(strHttpPost);
            if ("-200".equals(String.valueOf(mapFromJson.get(NotificationCompat.CATEGORY_STATUS)))) {
                MobLog.getInstance().m8615i("error log server config response fail !!", new Object[0]);
                return;
            }
            Object obj = mapFromJson.get("result");
            if (obj != null && (obj instanceof HashMap)) {
                HashMap map = (HashMap) obj;
                if (map.containsKey("timestamp")) {
                    try {
                        this.f9012f.m8595a(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(map.get("timestamp"))));
                    } catch (Throwable th) {
                        MobLog.getInstance().m8616i(th);
                    }
                }
                if ("1".equals(String.valueOf(map.get("enable")))) {
                    this.f9012f.m8597a(true);
                } else {
                    this.f9012f.m8597a(false);
                }
                Object obj2 = map.get("upconf");
                if (obj2 != null && (obj2 instanceof HashMap)) {
                    HashMap map2 = (HashMap) obj2;
                    String strValueOf = String.valueOf(map2.get("crash"));
                    String strValueOf2 = String.valueOf(map2.get("sdkerr"));
                    String strValueOf3 = String.valueOf(map2.get("apperr"));
                    this.f9012f.m8594a(Integer.parseInt(strValueOf));
                    this.f9012f.m8598b(Integer.parseInt(strValueOf2));
                    this.f9012f.m8601c(Integer.parseInt(strValueOf3));
                }
                if (map.containsKey("requesthost") && map.containsKey("requestport")) {
                    String strValueOf4 = String.valueOf(map.get("requesthost"));
                    String strValueOf5 = String.valueOf(map.get("requestport"));
                    if (!TextUtils.isEmpty(strValueOf4) && !TextUtils.isEmpty(strValueOf5)) {
                        f9008b = "http://" + strValueOf4 + ":" + strValueOf5;
                    }
                }
                Object obj3 = map.get("filter");
                if (obj3 == null || !(obj3 instanceof ArrayList)) {
                    return;
                }
                ArrayList arrayList2 = (ArrayList) obj3;
                if (arrayList2.size() > 0) {
                    HashMap map3 = new HashMap();
                    map3.put("fakelist", arrayList2);
                    this.f9012f.m8596a(new Hashon().fromHashMap(map3));
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().m8610d(th2);
        }
    }

    /* JADX INFO: renamed from: c */
    private String m8585c() {
        return f9008b + "/errlog";
    }

    /* JADX INFO: renamed from: a */
    private void m8579a(int i, String str, String str2, String[] strArr) {
        try {
            if (this.f9012f.m8599b()) {
                if ("none".equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f9010d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                    throw new IllegalStateException("network is disconnected!");
                }
                ArrayList<C1563e> arrayListM8608a = C1564f.m8608a(this.f9010d, strArr);
                for (int i2 = 0; i2 < arrayListM8608a.size(); i2++) {
                    C1563e c1563e = arrayListM8608a.get(i2);
                    HashMap<String, Object> mapM8586c = m8586c(i, str, str2);
                    mapM8586c.put("errmsg", c1563e.f9017a);
                    if (m8581a(m8578a(new Hashon().fromHashMap(mapM8586c)), true)) {
                        C1564f.m8606a(this.f9010d, c1563e.f9018b);
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8616i(th);
        }
    }

    /* JADX INFO: renamed from: c */
    private HashMap<String, Object> m8586c(int i, String str, String str2) throws Throwable {
        HashMap<String, Object> map = new HashMap<>();
        Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f9010d);
        map.put("key", str2);
        map.put("plat", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPlatformCode", new Object[0]));
        map.put("sdk", str);
        map.put("sdkver", Integer.valueOf(i));
        map.put("appname", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppName", new Object[0]));
        map.put("apppkg", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]));
        map.put("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppVersion", new Object[0])));
        map.put("deviceid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDeviceKey", new Object[0]));
        map.put("model", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getModel", new Object[0]));
        map.put("mac", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getMacAddress", new Object[0]));
        map.put("udid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDeviceId", new Object[0]));
        map.put("sysver", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getOSVersionInt", new Object[0])));
        map.put("networktype", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
        return map;
    }

    /* JADX INFO: renamed from: a */
    private String m8578a(String str) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = byteArrayInputStream.read(bArr, 0, 1024);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m8581a(String str, boolean z) {
        try {
            if ("none".equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f9010d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("m", str));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            this.f9011e.httpPost(m8585c(), arrayList, null, null, networkTimeOut);
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().m8616i(th);
            return false;
        }
    }
}
