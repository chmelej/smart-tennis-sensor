package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.message.MsgConstant;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: UmengMessageDeviceConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class ahc {

    /* JADX INFO: renamed from: a */
    protected static final String f910a = "ahc";

    /* JADX INFO: renamed from: a */
    public static String m1048a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m1050b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1049a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m1047a() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.FileNotFoundException -> L2e
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L2e
            if (r1 == 0) goto L36
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L25 java.io.FileNotFoundException -> L2e
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.io.IOException -> L25 java.io.FileNotFoundException -> L2e
            java.lang.String r3 = r2.readLine()     // Catch: java.io.IOException -> L25 java.io.FileNotFoundException -> L2e
            r2.close()     // Catch: java.io.FileNotFoundException -> L1d java.io.IOException -> L21
            r1.close()     // Catch: java.io.FileNotFoundException -> L1d java.io.IOException -> L21
            r0 = r3
            goto L36
        L1d:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L2f
        L21:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L26
        L25:
            r1 = move-exception
        L26:
            java.lang.String r2 = p000.ahc.f910a     // Catch: java.io.FileNotFoundException -> L2e
            java.lang.String r3 = "Could not read from file /proc/cpuinfo"
            p000.ahb.m1042b(r2, r3, r1)     // Catch: java.io.FileNotFoundException -> L2e
            goto L36
        L2e:
            r1 = move-exception
        L2f:
            java.lang.String r2 = p000.ahc.f910a
            java.lang.String r3 = "Could not open file /proc/cpuinfo"
            p000.ahb.m1042b(r2, r3, r1)
        L36:
            if (r0 == 0) goto L48
            r1 = 58
            int r1 = r0.indexOf(r1)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r0 = r0.trim()
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ahc.m1047a():java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    public static String m1052c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            ahb.m1045d(f910a, "No IMEI.");
        }
        String strM1058i = "";
        try {
            if (m1049a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                strM1058i = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            ahb.m1044c(f910a, "No IMEI.", e);
        }
        if (TextUtils.isEmpty(strM1058i)) {
            ahb.m1045d(f910a, "No IMEI.");
            strM1058i = m1058i(context);
            if (TextUtils.isEmpty(strM1058i)) {
                ahb.m1045d(f910a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                ahb.m1039a(f910a, "getDeviceId: Secure.ANDROID_ID: " + string);
                return string;
            }
        }
        return strM1058i;
    }

    /* JADX INFO: renamed from: d */
    public static String m1053d(Context context) {
        return ail.m1340a(m1052c(context));
    }

    /* JADX INFO: renamed from: e */
    public static String[] m1054e(Context context) {
        ConnectivityManager connectivityManager;
        String[] strArr = {"Unknown", "Unknown"};
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
            return strArr;
        }
        return strArr;
    }

    /* JADX INFO: renamed from: f */
    public static int m1055f(Context context) {
        try {
            Calendar calendar = Calendar.getInstance(m1065p(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
            return 8;
        } catch (Exception e) {
            ahb.m1040a(f910a, "error in getTimeZone", e);
            return 8;
        }
    }

    /* JADX INFO: renamed from: g */
    public static String[] m1056g(Context context) {
        String[] strArr = new String[2];
        try {
            Locale localeM1065p = m1065p(context);
            if (localeM1065p != null) {
                strArr[0] = localeM1065p.getCountry();
                strArr[1] = localeM1065p.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e) {
            ahb.m1042b(f910a, "error in getLocaleInfo", e);
            return strArr;
        }
    }

    /* JADX INFO: renamed from: p */
    private static Locale m1065p(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Exception unused) {
            ahb.m1041b(f910a, "fail to read user config locale");
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    /* JADX INFO: renamed from: h */
    public static String m1057h(Context context) {
        return m1051b(context, "UMENG_APPKEY");
    }

    /* JADX INFO: renamed from: b */
    public static String m1051b(Context context, String str) {
        String string;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (string = applicationInfo.metaData.getString(str)) != null) {
                return string.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ahb.m1041b(f910a, String.format("Could not read meta-data %s from AndroidManifest.xml.", str));
        return null;
    }

    /* JADX INFO: renamed from: i */
    public static String m1058i(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (m1049a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            ahb.m1045d(f910a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            ahb.m1045d(f910a, "Could not get mac address." + e.toString());
            return "";
        }
    }

    /* JADX INFO: renamed from: j */
    public static String m1059j(Context context) {
        int iM1046a;
        int iM1046a2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                iM1046a = m1046a(displayMetrics, "noncompatWidthPixels");
                iM1046a2 = m1046a(displayMetrics, "noncompatHeightPixels");
            } else {
                iM1046a = -1;
                iM1046a2 = -1;
            }
            if (iM1046a == -1 || iM1046a2 == -1) {
                iM1046a = displayMetrics.widthPixels;
                iM1046a2 = displayMetrics.heightPixels;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iM1046a);
            stringBuffer.append("*");
            stringBuffer.append(iM1046a2);
            return stringBuffer.toString();
        } catch (Exception e) {
            ahb.m1042b(f910a, "read resolution fail", e);
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m1046a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            if (declaredField == null) {
                return -1;
            }
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: renamed from: k */
    public static String m1060k(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            ahb.m1040a(f910a, "read carrier fail", e);
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: l */
    public static String m1061l(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null) {
                return "Unknown";
            }
            String string = obj.toString();
            if (string != null) {
                return string;
            }
            ahb.m1039a(f910a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return "Unknown";
        } catch (Exception e) {
            ahb.m1039a(f910a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: m */
    public static String m1062m(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: renamed from: n */
    public static String m1063n(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* JADX INFO: renamed from: o */
    public static String m1064o(Context context) {
        try {
            return C2278ys.m12499a(context);
        } catch (Throwable th) {
            ahb.m1041b(f910a, "fail to get utdid. " + th.getMessage());
            return "";
        }
    }
}
