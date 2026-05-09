package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_INT = 69;

    /* JADX INFO: renamed from: a */
    private static C0847f f5523a = null;

    /* JADX INFO: renamed from: b */
    private static boolean f5524b = true;

    public static int getSDKVersionCode() {
        return 69;
    }

    public static void stopSDK() {
    }

    public static void initSDK(Context context) {
        initSDK(context, null, true);
    }

    public static void initSDK(Context context, boolean z) {
        initSDK(context, null, z);
    }

    public static void initSDK(Context context, String str) {
        initSDK(context, str, true);
    }

    public static void initSDK(Context context, String str, boolean z) {
        if (DeviceHelper.getInstance(context) == null) {
            throw new RuntimeException("The param of context is null which in ShareSDK.initSDK(context)!");
        }
        if (f5523a == null) {
            C0847f c0847f = new C0847f(context, str);
            c0847f.m6159a(z);
            c0847f.startThread();
            f5523a = c0847f;
        }
    }

    public static void stopSDK(Context context) {
        stopSDK();
    }

    /* JADX INFO: renamed from: b */
    private static void m5946b() {
        if (f5523a == null) {
            throw new RuntimeException("Please call ShareSDK.initSDK(Context) in the main process before any action.");
        }
    }

    public static void registerService(Class<? extends Service> cls) {
        m5946b();
        f5523a.m6155a(cls);
    }

    public static void unregisterService(Class<? extends Service> cls) {
        m5946b();
        f5523a.m6166b(cls);
    }

    public static <T extends Service> T getService(Class<T> cls) {
        m5946b();
        return (T) f5523a.m6169c(cls);
    }

    public static void registerPlatform(Class<? extends CustomPlatform> cls) {
        m5946b();
        f5523a.m6173d(cls);
    }

    public static void unregisterPlatform(Class<? extends CustomPlatform> cls) {
        m5946b();
        f5523a.m6176e(cls);
    }

    public static String getSDKVersionName() {
        m5946b();
        return f5523a.m6163b();
    }

    public static void setConnTimeout(int i) {
        m5946b();
        f5523a.m6152a(i);
    }

    public static void setReadTimeout(int i) {
        m5946b();
        f5523a.m6165b(i);
    }

    public static void removeCookieOnAuthorize(boolean z) {
        m5946b();
        f5523a.m6167b(z);
    }

    public static void deleteCache() {
        m5946b();
        f5523a.m6175e();
    }

    @Deprecated
    public static synchronized Platform[] getPlatformList(Context context) {
        return getPlatformList();
    }

    public static synchronized Platform[] getPlatformList() {
        m5946b();
        return f5523a.m6161a();
    }

    @Deprecated
    public static Platform getPlatform(Context context, String str) {
        m5946b();
        return f5523a.m6148a(str);
    }

    public static Platform getPlatform(String str) {
        m5946b();
        return f5523a.m6148a(str);
    }

    public static void logDemoEvent(int i, Platform platform) {
        m5946b();
        f5523a.m6154a(i, platform);
    }

    public static void logApiEvent(String str, int i) {
        m5946b();
        f5523a.m6156a(str, i);
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> map) {
        m5946b();
        f5523a.m6158a(str, map);
    }

    public static String platformIdToName(int i) {
        m5946b();
        return f5523a.m6170c(i);
    }

    public static int platformNameToId(String str) {
        m5946b();
        return f5523a.m6162b(str);
    }

    public static boolean isRemoveCookieOnAuthorize() {
        m5946b();
        return f5523a.m6172c();
    }

    public static void closeDebug() {
        f5524b = false;
    }

    public static boolean isDebug() {
        return f5524b;
    }

    /* JADX INFO: renamed from: a */
    static void m5942a(String str, String str2) {
        m5946b();
        f5523a.m6157a(str, str2);
    }

    /* JADX INFO: renamed from: a */
    static void m5941a(int i, int i2) {
        m5946b();
        f5523a.m6153a(i, i2);
    }

    /* JADX INFO: renamed from: b */
    static String m5945b(String str, String str2) {
        m5946b();
        return f5523a.m6164b(str, str2);
    }

    /* JADX INFO: renamed from: a */
    static String m5937a(int i, String str) {
        m5946b();
        return f5523a.m6149a(i, str);
    }

    /* JADX INFO: renamed from: a */
    static boolean m5943a() {
        m5946b();
        return f5523a.m6174d();
    }

    /* JADX INFO: renamed from: a */
    static boolean m5944a(HashMap<String, Object> map) {
        m5946b();
        return f5523a.m6160a(map);
    }

    /* JADX INFO: renamed from: b */
    static boolean m5947b(HashMap<String, Object> map) {
        m5946b();
        return f5523a.m6168b(map);
    }

    /* JADX INFO: renamed from: a */
    static String m5940a(String str, boolean z, int i, String str2) {
        m5946b();
        return f5523a.m6151a(str, z, i, str2);
    }

    /* JADX INFO: renamed from: a */
    static String m5939a(String str) {
        m5946b();
        return f5523a.m6171c(str);
    }

    /* JADX INFO: renamed from: a */
    static String m5938a(Bitmap bitmap) {
        m5946b();
        return f5523a.m6150a(bitmap);
    }
}
