package com.mob.commons;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.authorize.C1547a;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: com.mob.commons.a */
/* JADX INFO: compiled from: CommonConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class C1541a {

    /* JADX INFO: renamed from: a */
    private static HashMap<String, Object> f8946a;

    /* JADX INFO: renamed from: b */
    private static long f8947b;

    /* JADX INFO: renamed from: c */
    private static long f8948c;

    /* JADX INFO: renamed from: d */
    private static boolean f8949d;

    /* JADX INFO: renamed from: a */
    public static long m8440a(Context context) {
        long jLongValue;
        m8459o(context);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            jLongValue = Long.valueOf(String.valueOf(f8946a.get("deviceTime"))).longValue();
        } catch (Throwable unused) {
            jLongValue = 0;
        }
        return ((Long) ResHelper.forceCast(f8946a.get("serverTime"), 0L)).longValue() + (jElapsedRealtime - jLongValue);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m8446b(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("rt"), 1)).intValue();
    }

    /* JADX INFO: renamed from: c */
    public static int m8447c(Context context) {
        m8459o(context);
        return ((Integer) ResHelper.forceCast(f8946a.get("rtsr"), 300)).intValue();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m8448d(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("all"), 1)).intValue();
    }

    /* JADX INFO: renamed from: e */
    public static long m8449e(Context context) {
        m8459o(context);
        return ((Long) ResHelper.forceCast(f8946a.get("aspa"), 2592000L)).longValue();
    }

    /* JADX INFO: renamed from: f */
    public static boolean m8450f(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("di"), 1)).intValue();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m8451g(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("ext"), 1)).intValue();
    }

    /* JADX INFO: renamed from: h */
    public static boolean m8452h(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("bs"), 1)).intValue();
    }

    /* JADX INFO: renamed from: i */
    public static int m8453i(Context context) {
        m8459o(context);
        return ((Integer) ResHelper.forceCast(f8946a.get("bsgap"), 86400)).intValue();
    }

    /* JADX INFO: renamed from: j */
    public static boolean m8454j(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("l"), 0)).intValue();
    }

    /* JADX INFO: renamed from: k */
    public static int m8455k(Context context) {
        m8459o(context);
        return ((Integer) ResHelper.forceCast(f8946a.get("lgap"), 86400)).intValue();
    }

    /* JADX INFO: renamed from: l */
    public static boolean m8456l(Context context) {
        m8459o(context);
        return 1 == ((Integer) ResHelper.forceCast(f8946a.get("wi"), 1)).intValue();
    }

    /* JADX INFO: renamed from: m */
    public static long m8457m(Context context) {
        m8459o(context);
        return m8440a(context) + (((long) ((Integer) ResHelper.forceCast(f8946a.get("adle"), 172800)).intValue()) * 1000);
    }

    /* JADX INFO: renamed from: o */
    private static synchronized void m8459o(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (f8946a == null) {
            if (m8460p(context)) {
                f8947b = jElapsedRealtime;
            }
        } else if (jElapsedRealtime - f8947b >= 60000 && m8461q(context)) {
            f8947b = jElapsedRealtime;
        }
    }

    /* JADX INFO: renamed from: p */
    private static boolean m8460p(Context context) {
        String strM8462r = m8462r(context);
        if (TextUtils.isEmpty(strM8462r)) {
            m8444b();
            return false;
        }
        m8445b(strM8462r);
        C1558f.m8564d(context, new Hashon().fromHashMap(f8946a));
        return true;
    }

    /* JADX INFO: renamed from: q */
    private static boolean m8461q(Context context) {
        String strM8565e = C1558f.m8565e(context);
        if (TextUtils.isEmpty(strM8565e)) {
            return m8460p(context);
        }
        m8445b(strM8565e);
        if (((Long) ResHelper.forceCast(f8946a.get("timestamp"), 0L)).longValue() - f8948c < 86400000) {
            return true;
        }
        m8463s(context);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public static String m8462r(Context context) {
        HashMap mapFromJson;
        try {
            C1548b c1548bM8511a = C1548b.m8511a(context);
            ArrayList<MobProduct> arrayListM8513a = c1548bM8511a.m8513a();
            if (arrayListM8513a.isEmpty()) {
                return null;
            }
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appkey", arrayListM8513a.get(0).getProductAppkey()));
            arrayList.add(new KVPair<>("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPlatformCode", new Object[0]))));
            arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppVersionName", new Object[0]))));
            arrayList.add(new KVPair<>("networktype", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            String strM8509a = new C1547a().m8509a(context);
            if (!TextUtils.isEmpty(strM8509a)) {
                arrayList.add(new KVPair<>("duid", strM8509a));
            }
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Identity", c1548bM8511a.m8512a(arrayListM8513a)));
            String strHttpGet = c1548bM8511a.httpGet(m8464t(context), arrayList, arrayList2, networkTimeOut);
            Hashon hashon = new Hashon();
            HashMap mapFromJson2 = hashon.fromJson(strHttpGet);
            if (mapFromJson2 == null) {
                return null;
            }
            if (!"200".equals(String.valueOf(mapFromJson2.get(NotificationCompat.CATEGORY_STATUS)))) {
                C1558f.m8566e(context, null);
                C1558f.m8568f(context, null);
                throw new Throwable("response is illegal: " + strHttpGet);
            }
            String str = (String) ResHelper.forceCast(mapFromJson2.get("sr"));
            if (str != null && (mapFromJson = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str, 2)))) != null) {
                HashMap map = (HashMap) ResHelper.forceCast(mapFromJson.get("cdata"));
                if (map != null) {
                    String str2 = (String) ResHelper.forceCast(map.get("host"));
                    int iIntValue = ((Integer) ResHelper.forceCast(map.get("httpport"), 0)).intValue();
                    String str3 = (String) ResHelper.forceCast(map.get("path"));
                    if (str2 != null && iIntValue != 0 && str3 != null) {
                        C1558f.m8566e(context, "http://" + str2 + ":" + iIntValue + str3);
                    } else {
                        C1558f.m8566e(context, null);
                    }
                } else {
                    C1558f.m8566e(context, null);
                }
                HashMap map2 = (HashMap) ResHelper.forceCast(mapFromJson.get("cconf"));
                if (map2 != null) {
                    String str4 = (String) ResHelper.forceCast(map2.get("host"));
                    int iIntValue2 = ((Integer) ResHelper.forceCast(map2.get("httpport"), 0)).intValue();
                    String str5 = (String) ResHelper.forceCast(map2.get("path"));
                    if (str4 != null && iIntValue2 != 0 && str5 != null) {
                        C1558f.m8568f(context, "http://" + str4 + ":" + iIntValue2 + str5);
                    } else {
                        C1558f.m8568f(context, null);
                    }
                } else {
                    C1558f.m8568f(context, null);
                }
            }
            String str6 = (String) ResHelper.forceCast(mapFromJson2.get("sc"));
            if (str6 == null) {
                throw new Throwable("response is illegal: " + strHttpGet);
            }
            HashMap mapFromJson3 = hashon.fromJson(Data.AES128Decode("FYsAXMqlWJLCDpnc", Base64.decode(str6, 2)));
            if (mapFromJson3 == null) {
                throw new Throwable("response is illegal: " + strHttpGet);
            }
            long jLongValue = ((Long) ResHelper.forceCast(mapFromJson2.get("timestamp"), 0L)).longValue();
            mapFromJson3.put("deviceTime", Long.valueOf(SystemClock.elapsedRealtime()));
            mapFromJson3.put("serverTime", Long.valueOf(jLongValue));
            return hashon.fromHashMap(mapFromJson3);
        } catch (Throwable th) {
            C1558f.m8566e(context, null);
            C1558f.m8568f(context, null);
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m8444b() {
        f8946a = new HashMap<>();
        f8946a.put("in", 0);
        f8946a.put("all", 0);
        f8946a.put("aspa", 2592000L);
        f8946a.put("un", 0);
        f8946a.put("rt", 0);
        f8946a.put("rtsr", 300000);
        f8946a.put("mi", 0);
        f8946a.put("ext", 0);
        f8946a.put("bs", 0);
        f8946a.put("bsgap", 86400);
        f8946a.put("di", 0);
        f8946a.put("l", 0);
        f8946a.put("lgap", 86400);
        f8946a.put("wi", 0);
        f8946a.put("adle", 172800);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m8445b(String str) {
        try {
            f8946a = new Hashon().fromJson(str);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.mob.commons.a$1] */
    /* JADX INFO: renamed from: s */
    private static void m8463s(final Context context) {
        if (f8949d) {
            return;
        }
        f8949d = true;
        new Thread() { // from class: com.mob.commons.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String strM8462r = C1541a.m8462r(context);
                if (!TextUtils.isEmpty(strM8462r)) {
                    C1541a.m8445b(strM8462r);
                    C1558f.m8564d(context, new Hashon().fromHashMap(C1541a.f8946a));
                }
                boolean unused = C1541a.f8949d = false;
            }
        }.start();
    }

    /* JADX INFO: renamed from: t */
    private static String m8464t(Context context) {
        String strM8569g;
        try {
            strM8569g = C1558f.m8569g(context);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            strM8569g = null;
        }
        return TextUtils.isEmpty(strM8569g) ? "http://m.data.mob.com/v2/cconf" : strM8569g;
    }
}
