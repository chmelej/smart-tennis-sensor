package p000;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: vz */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2204vz {
    /* JADX INFO: renamed from: a */
    private static int m12067a(int i) {
        return (i & SupportMenu.CATEGORY_MASK) >> 16;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m12071a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* JADX INFO: renamed from: b */
    public static int m12072b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* JADX INFO: renamed from: c */
    public static int m12074c(Context context) {
        switch (m12072b(context)) {
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m12076d(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo.reqGlEsVersion != 0) {
            return m12067a(deviceConfigurationInfo.reqGlEsVersion);
        }
        return 1;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m12077e(Context context) {
        Point pointM12078f = m12078f(context);
        return pointM12078f.x > pointM12078f.y;
    }

    @TargetApi(13)
    /* JADX INFO: renamed from: f */
    public static Point m12078f(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    /* JADX INFO: renamed from: a */
    public static String m12069a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 31 && cCharAt < 127) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m12070a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static String m12068a() {
        return m12069a(("os version:" + Build.VERSION.RELEASE + ", Android SDK_INT:" + Build.VERSION.SDK_INT + ", SoC Hardware:" + Build.HARDWARE).trim());
    }

    /* JADX INFO: renamed from: b */
    public static String m12073b() {
        String strTrim = Build.MODEL.trim();
        String strM12070a = m12070a(Build.MANUFACTURER.trim(), strTrim);
        if (TextUtils.isEmpty(strM12070a)) {
            strM12070a = m12070a(Build.BRAND.trim(), strTrim);
        }
        StringBuilder sb = new StringBuilder();
        if (strM12070a == null) {
            strM12070a = "";
        }
        sb.append(strM12070a);
        sb.append(strTrim);
        return m12069a(sb.toString()).replace(" ", "_");
    }

    /* JADX INFO: renamed from: g */
    public static String m12079g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m12080h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: i */
    public static String m12081i(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    /* JADX INFO: renamed from: c */
    public static String m12075c() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    /* JADX INFO: renamed from: j */
    public static String m12082j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_model", m12073b());
            jSONObject.put("os_version", m12068a());
            jSONObject.put("sdk_version", "amix-3.0;PLDroidShortVideo-1.9.0");
            jSONObject.put("app_name", m12079g(context));
            jSONObject.put("app_version", m12080h(context));
            jSONObject.put("gl_version", m12076d(context));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
