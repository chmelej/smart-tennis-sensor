package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.umeng.message.MsgConstant;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class abz {

    /* JADX INFO: renamed from: a */
    private static String f191a = "";

    /* JADX INFO: renamed from: a */
    public static String m132a(Context context) {
        try {
            if (m135a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            } else {
                Log.e("MtaSDK", "Could not get permission of android.permission.READ_PHONE_STATE");
            }
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "get device id error", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m133a(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(abo.m71b(abp.m72a(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "decode error", th);
            return str;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m134a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e("MtaSDK", "jsonPut error", th);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m135a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
        } catch (Throwable th) {
            Log.e("MtaSDK", "checkPermission error", th);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static String m136b(Context context) {
        if (!m135a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
            Log.e("MtaSDK", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            Log.e("MtaSDK", "get wifi address error", e);
            return "";
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m137b(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(abp.m73b(abo.m69a(str.getBytes("UTF-8"))), "UTF-8");
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return str;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m138c(Context context) {
        try {
            WifiInfo wifiInfoM142g = m142g(context);
            if (wifiInfoM142g != null) {
                return wifiInfoM142g.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static String m139d(Context context) {
        try {
            WifiInfo wifiInfoM142g = m142g(context);
            if (wifiInfoM142g != null) {
                return wifiInfoM142g.getSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e("MtaSDK", "encode error", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m140e(Context context) {
        try {
        } catch (Throwable th) {
            Log.e("MtaSDK", "isNetworkAvailable error", th);
        }
        if (!m135a(context, MsgConstant.PERMISSION_INTERNET) || !m135a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
            Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            Log.w("MtaSDK", "Network error");
            return false;
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public static JSONArray m141f(Context context) {
        List<ScanResult> scanResults;
        try {
            if (!m135a(context, MsgConstant.PERMISSION_INTERNET) || !m135a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                Log.e("MtaSDK", "can not get the permisson of android.permission.INTERNET");
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (scanResults = wifiManager.getScanResults()) == null || scanResults.size() <= 0) {
                return null;
            }
            Collections.sort(scanResults, new aca());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < scanResults.size() && i < 10; i++) {
                ScanResult scanResult = scanResults.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bs", scanResult.BSSID);
                jSONObject.put("ss", scanResult.SSID);
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th) {
            Log.e("MtaSDK", "isWifiNet error", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    private static WifiInfo m142g(Context context) {
        WifiManager wifiManager;
        if (!m135a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }
}
