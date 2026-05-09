package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;

/* JADX INFO: compiled from: DeviceConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class ati {

    /* JADX INFO: renamed from: a */
    protected static final String f5036a = "ati";

    /* JADX INFO: renamed from: a */
    public static String m5411a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5413a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* JADX INFO: renamed from: b */
    public static String m5414b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            atj.m5429d(f5036a, "No IMEI.");
        }
        try {
        } catch (Exception e) {
            atj.m5430d(f5036a, "No IMEI.", e);
        }
        String deviceId = m5413a(context, MsgConstant.PERMISSION_READ_PHONE_STATE) ? telephonyManager.getDeviceId() : "";
        if (TextUtils.isEmpty(deviceId)) {
            atj.m5429d(f5036a, "No IMEI.");
            deviceId = m5419g(context);
            if (TextUtils.isEmpty(deviceId)) {
                atj.m5429d(f5036a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                atj.m5423a(f5036a, "getDeviceId: Secure.ANDROID_ID: " + string);
                return string;
            }
        }
        return deviceId;
    }

    /* JADX INFO: renamed from: c */
    public static String[] m5415c(Context context) {
        String[] strArr = {"", ""};
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (context.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        if (connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo.getSubtypeName();
            return strArr;
        }
        return strArr;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m5416d(Context context) {
        return "Wi-Fi".equals(m5415c(context)[0]);
    }

    /* JADX INFO: renamed from: e */
    public static boolean m5417e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5412a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX INFO: renamed from: f */
    public static String m5418f(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            atj.m5425b(f5036a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Exception e) {
            atj.m5426b(f5036a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static String m5419g(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (m5413a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            atj.m5429d(f5036a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            atj.m5429d(f5036a, "Could not get mac address." + e.toString());
            return "";
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m5420h(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) != null) {
                String string = obj.toString();
                if (string != null) {
                    return string;
                }
                atj.m5423a(f5036a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            atj.m5423a(f5036a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
        }
        return "Unknown";
    }

    /* JADX INFO: renamed from: i */
    public static String m5421i(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: renamed from: j */
    public static String m5422j(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }
}
