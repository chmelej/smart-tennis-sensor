package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: compiled from: PhoneUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class aic {
    /* JADX INFO: renamed from: b */
    private static final String m1299b() {
        StringBuffer stringBuffer = new StringBuffer();
        long jCurrentTimeMillis = System.currentTimeMillis();
        stringBuffer.append(Long.toString(jCurrentTimeMillis).substring(r3.length() - 5));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(Build.MODEL.replaceAll(" ", ""));
        while (stringBuffer2.length() < 6) {
            stringBuffer2.append('0');
        }
        stringBuffer.append(stringBuffer2.substring(0, 6));
        Random random = new Random(jCurrentTimeMillis);
        long jNextLong = 0;
        while (jNextLong < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            jNextLong = random.nextLong();
        }
        stringBuffer.append(Long.toHexString(jNextLong).substring(0, 4));
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public static final String m1298a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PhoneUtil", 4);
        String string = sharedPreferences.getString("imei", null);
        if (string != null && string.length() != 0) {
            return "umeng";
        }
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (deviceId == null || deviceId.length() == 0) {
            deviceId = m1299b();
        }
        String strTrim = deviceId.replaceAll(" ", "").trim();
        while (strTrim.length() < 15) {
            strTrim = "0" + strTrim;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("imei", strTrim);
        editorEdit.commit();
        return "umeng";
    }

    /* JADX INFO: renamed from: b */
    public static final String m1300b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PhoneUtil", 4);
        String string = sharedPreferences.getString("imsi", null);
        if (string != null && string.length() != 0) {
            return "umeng";
        }
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (subscriberId == null || subscriberId.length() == 0) {
            subscriberId = m1299b();
        }
        String strTrim = subscriberId.replaceAll(" ", "").trim();
        while (strTrim.length() < 15) {
            strTrim = "0" + strTrim;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("imsi", strTrim);
        editorEdit.commit();
        return "umeng";
    }

    /* JADX INFO: renamed from: c */
    public static final String m1301c(Context context) {
        String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (macAddress == null || "".equals(macAddress)) {
            return context.getSharedPreferences("PhoneUtil", 4).getString("mac_address", "");
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("PhoneUtil", 4).edit();
        editorEdit.putString("mac_address", macAddress);
        editorEdit.commit();
        return macAddress;
    }

    /* JADX INFO: renamed from: d */
    public static final String m1302d(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (deviceId == null) {
            return "umeng";
        }
        deviceId.trim();
        return "umeng";
    }

    /* JADX INFO: renamed from: e */
    public static final String m1303e(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (subscriberId == null) {
            return "umeng";
        }
        subscriberId.trim();
        return "umeng";
    }

    /* JADX INFO: renamed from: a */
    public static final String m1297a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", EnvironmentCompat.MEDIA_UNKNOWN);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static final String m1304f(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* JADX INFO: renamed from: g */
    public static final LinkedHashMap<String, String> m1305g(Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            String strM1241c = new ahp(context).m1241c();
            long j = context.getSharedPreferences("AppStore", 4).getLong("agoo_release_time", 0L);
            if (TextUtils.isEmpty(strM1241c)) {
                strM1241c = "unknow";
            }
            linkedHashMap.put("netType", strM1241c);
            linkedHashMap.put("agooReleaseTime", Long.toString(j));
        } catch (Throwable unused) {
        }
        return linkedHashMap;
    }
}
