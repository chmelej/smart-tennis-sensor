package p000;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.umeng.message.MsgConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: zd */
/* JADX INFO: loaded from: classes.dex */
public final class C2290zd {
    /* JADX INFO: renamed from: a */
    static String m12533a(Context context) {
        try {
            if (m12536a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            } else {
                Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
            }
            return "";
        } catch (Throwable th) {
            Log.w("MID", th);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m12534a(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    /* JADX INFO: renamed from: a */
    static void m12535a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (m12537a(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m12536a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
        } catch (Throwable th) {
            m12534a("checkPermission error", th);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static boolean m12537a(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    static String m12538b(Context context) {
        String str;
        if (m12536a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                str = "get wifi address error" + e;
            }
        } else {
            str = "Could not get permission of android.permission.ACCESS_WIFI_STATE";
        }
        Log.i("MID", str);
        return "";
    }

    /* JADX INFO: renamed from: b */
    public static boolean m12539b(String str) {
        return str != null && str.trim().length() >= 40;
    }

    /* JADX INFO: renamed from: c */
    static String m12540c(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(abo.m71b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            m12534a("decode error", th);
            return str;
        }
    }

    /* JADX INFO: renamed from: d */
    static String m12541d(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(abo.m69a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            m12534a("decode error", th);
            return str;
        }
    }
}
