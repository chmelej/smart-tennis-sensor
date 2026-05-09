package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.message.MsgConstant;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import p000.ada;

/* JADX INFO: compiled from: DeviceConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class aeu {

    /* JADX INFO: renamed from: a */
    protected static final String f709a = "aeu";

    /* JADX INFO: renamed from: a */
    public static String m719a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m725b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m723a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static String m724b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterfaceNextElement.getName()) || "eth0".equals(networkInterfaceNextElement.getName())) {
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                    return null;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private static String m727c() {
        String strM720a;
        try {
            for (String str : new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"}) {
                try {
                    strM720a = m720a(str);
                } catch (Throwable unused) {
                }
                if (strM720a != null) {
                    return strM720a;
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m720a(String str) {
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader(str);
            if (fileReader == null) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String line = bufferedReader.readLine();
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                return line;
            } catch (Throwable th2) {
                th = th2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable unused5) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[RETURN] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m718a() throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.FileNotFoundException -> L2e
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L2e
            if (r1 == 0) goto L36
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L25 java.io.FileNotFoundException -> L2e
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L25 java.io.FileNotFoundException -> L2e
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L25 java.io.FileNotFoundException -> L2e
            r2.close()     // Catch: java.io.FileNotFoundException -> L1d java.lang.Throwable -> L21
            r1.close()     // Catch: java.io.FileNotFoundException -> L1d java.lang.Throwable -> L21
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
            java.lang.String r2 = p000.aeu.f709a     // Catch: java.io.FileNotFoundException -> L2e
            java.lang.String r3 = "Could not read from file /proc/cpuinfo"
            p000.aex.m777c(r2, r3, r1)     // Catch: java.io.FileNotFoundException -> L2e
            goto L36
        L2e:
            r1 = move-exception
        L2f:
            java.lang.String r2 = p000.aeu.f709a
            java.lang.String r3 = "Could not open file /proc/cpuinfo"
            p000.aex.m777c(r2, r3, r1)
        L36:
            if (r0 == 0) goto L49
            r1 = 58
            int r1 = r0.indexOf(r1)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r0 = r0.trim()
            return r0
        L49:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.aeu.m718a():java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    public static String m728c(Context context) {
        if (ada.EnumC0007a.E_UM_ANALYTICS_OEM.m303a() == acz.m291d(context) || ada.EnumC0007a.E_UM_GAME_OEM.m303a() == acz.m291d(context)) {
            return m715A(context);
        }
        return m754z(context);
    }

    /* JADX INFO: renamed from: d */
    public static String m730d(Context context) {
        return aev.m762b(m728c(context));
    }

    /* JADX INFO: renamed from: e */
    public static String m731e(Context context) {
        if (m733f(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i == 0) {
            return null;
        }
        String strValueOf = String.valueOf(i2);
        if (i2 < 10) {
            strValueOf = String.format("%02d", Integer.valueOf(i2));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(i));
        stringBuffer.append(strValueOf);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: f */
    public static String m733f(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (m723a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public static String m735g(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (!m723a(context, MsgConstant.PERMISSION_READ_PHONE_STATE) || telephonyManager == null) ? "" : telephonyManager.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: h */
    public static String[] m736h(Context context) {
        String[] strArr = {"", ""};
        if (!m723a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
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

    /* JADX INFO: renamed from: i */
    public static boolean m737i(Context context) {
        return "Wi-Fi".equals(m736h(context)[0]);
    }

    /* JADX INFO: renamed from: j */
    public static boolean m738j(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!m723a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: k */
    public static int m739k(Context context) throws Throwable {
        try {
            Calendar calendar = Calendar.getInstance(m752x(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
            return 8;
        } catch (Throwable th) {
            aex.m775b(f709a, "error in getTimeZone", th);
            return 8;
        }
    }

    /* JADX INFO: renamed from: l */
    public static String[] m740l(Context context) throws Throwable {
        String[] strArr = new String[2];
        try {
            Locale localeM752x = m752x(context);
            if (localeM752x != null) {
                strArr[0] = localeM752x.getCountry();
                strArr[1] = localeM752x.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            aex.m777c(f709a, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    /* JADX INFO: renamed from: x */
    private static Locale m752x(Context context) throws Throwable {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Throwable unused) {
            aex.m771a(f709a, "fail to read user config locale");
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    /* JADX INFO: renamed from: m */
    public static String m741m(Context context) throws Throwable {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            aex.m771a(f709a, "getAppkey failed. the applicationinfo is null!");
            return null;
        } catch (Throwable th) {
            aex.m777c(f709a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static String m742n(Context context) {
        String strM724b;
        if (Build.VERSION.SDK_INT < 23) {
            return m753y(context);
        }
        if (Build.VERSION.SDK_INT == 23) {
            strM724b = m724b();
            if (TextUtils.isEmpty(strM724b)) {
                if (adb.f362a) {
                    return m727c();
                }
                return m753y(context);
            }
        } else {
            strM724b = m724b();
            if (TextUtils.isEmpty(strM724b)) {
                return m753y(context);
            }
        }
        return strM724b;
    }

    /* JADX INFO: renamed from: y */
    private static String m753y(Context context) {
        try {
            return m723a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) ? ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: o */
    public static int[] m743o(Context context) {
        int iM717a;
        int iM717a2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                iM717a = m717a(displayMetrics, "noncompatWidthPixels");
                iM717a2 = m717a(displayMetrics, "noncompatHeightPixels");
            } else {
                iM717a = -1;
                iM717a2 = -1;
            }
            if (iM717a == -1 || iM717a2 == -1) {
                iM717a = displayMetrics.widthPixels;
                iM717a2 = displayMetrics.heightPixels;
            }
            int[] iArr = new int[2];
            if (iM717a > iM717a2) {
                iArr[0] = iM717a2;
                iArr[1] = iM717a;
            } else {
                iArr[0] = iM717a;
                iArr[1] = iM717a2;
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m717a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: p */
    public static String m744p(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null) {
                return "Unknown";
            }
            String string = obj.toString();
            return string != null ? string : "Unknown";
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: q */
    public static String m745q(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: renamed from: r */
    public static String m746r(Context context) {
        try {
            return m722a(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(m745q(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m722a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: s */
    public static String m747s(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* JADX INFO: renamed from: t */
    public static String m748t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: z */
    private static String m754z(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            String strM716B = m716B(context);
            if (!TextUtils.isEmpty(strM716B)) {
                return strM716B;
            }
            String strM753y = m753y(context);
            if (!TextUtils.isEmpty(strM753y)) {
                return strM753y;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(string) ? m729d() : string;
        }
        if (Build.VERSION.SDK_INT == 23) {
            String strM716B2 = m716B(context);
            if (!TextUtils.isEmpty(strM716B2)) {
                return strM716B2;
            }
            String strM724b = m724b();
            if (TextUtils.isEmpty(strM724b)) {
                if (adb.f362a) {
                    strM724b = m727c();
                } else {
                    strM724b = m753y(context);
                }
            }
            if (!TextUtils.isEmpty(strM724b)) {
                return strM724b;
            }
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(string2) ? m729d() : string2;
        }
        String strM716B3 = m716B(context);
        if (!TextUtils.isEmpty(strM716B3)) {
            return strM716B3;
        }
        String strM729d = m729d();
        if (!TextUtils.isEmpty(strM729d)) {
            return strM729d;
        }
        String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string3)) {
            return string3;
        }
        String strM724b2 = m724b();
        return TextUtils.isEmpty(strM724b2) ? m753y(context) : strM724b2;
    }

    /* JADX INFO: renamed from: A */
    private static String m715A(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String strM753y = m753y(context);
            if (!TextUtils.isEmpty(strM753y)) {
                return strM753y;
            }
            String strM729d = m729d();
            return TextUtils.isEmpty(strM729d) ? m716B(context) : strM729d;
        }
        if (Build.VERSION.SDK_INT == 23) {
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string2)) {
                return string2;
            }
            String strM724b = m724b();
            if (TextUtils.isEmpty(strM724b)) {
                if (adb.f362a) {
                    strM724b = m727c();
                } else {
                    strM724b = m753y(context);
                }
            }
            if (!TextUtils.isEmpty(strM724b)) {
                return strM724b;
            }
            String strM729d2 = m729d();
            return TextUtils.isEmpty(strM729d2) ? m716B(context) : strM729d2;
        }
        String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string3)) {
            return string3;
        }
        String strM729d3 = m729d();
        if (!TextUtils.isEmpty(strM729d3)) {
            return strM729d3;
        }
        String strM716B = m716B(context);
        if (!TextUtils.isEmpty(strM716B)) {
            return strM716B;
        }
        String strM724b2 = m724b();
        return TextUtils.isEmpty(strM724b2) ? m753y(context) : strM724b2;
    }

    /* JADX INFO: renamed from: B */
    private static String m716B(Context context) {
        String deviceId = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            if (m723a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                if (Build.VERSION.SDK_INT > 26) {
                    Class<?> cls = Class.forName("android.telephony.TelephonyManager");
                    Method method = cls.getMethod("getImei", Integer.class);
                    deviceId = (String) method.invoke(telephonyManager, method, 0);
                    if (TextUtils.isEmpty(deviceId)) {
                        Method method2 = cls.getMethod("getMeid", Integer.class);
                        deviceId = (String) method2.invoke(telephonyManager, method2, 0);
                        if (TextUtils.isEmpty(deviceId)) {
                            deviceId = telephonyManager.getDeviceId();
                        }
                    }
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
            }
            return deviceId;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: d */
    private static String m729d() {
        if (Build.VERSION.SDK_INT >= 9 && Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: u */
    public static String m749u(Context context) throws Throwable {
        Properties propertiesM732e = m732e();
        try {
            String property = propertiesM732e.getProperty("ro.miui.ui.version.name");
            return TextUtils.isEmpty(property) ? m734f() ? "Flyme" : !TextUtils.isEmpty(m721a(propertiesM732e)) ? "YunOS" : property : "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: v */
    public static String m750v(Context context) throws Throwable {
        String strM721a;
        Properties propertiesM732e = m732e();
        try {
            String property = propertiesM732e.getProperty("ro.miui.ui.version.name");
            if (TextUtils.isEmpty(property)) {
                try {
                    if (m734f()) {
                        strM721a = m726b(propertiesM732e);
                    } else {
                        strM721a = m721a(propertiesM732e);
                    }
                    return strM721a;
                } catch (Throwable unused) {
                }
            }
            return property;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m721a(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property;
    }

    /* JADX INFO: renamed from: b */
    private static String m726b(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    private static Properties m732e() throws Throwable {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.load(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        return properties;
    }

    /* JADX INFO: renamed from: f */
    private static boolean m734f() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: w */
    public static String m751w(Context context) {
        String deviceId = null;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && m723a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                deviceId = telephonyManager.getDeviceId();
            }
            if (!TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            try {
                if (TextUtils.isEmpty(string) && Build.VERSION.SDK_INT >= 9) {
                    return Build.SERIAL;
                }
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable unused2) {
            return deviceId;
        }
    }
}
