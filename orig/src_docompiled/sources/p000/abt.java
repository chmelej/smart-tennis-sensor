package p000;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.umeng.message.MsgConstant;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class abt {

    /* JADX INFO: renamed from: a */
    private static String f165a = null;

    /* JADX INFO: renamed from: b */
    private static String f166b = null;

    /* JADX INFO: renamed from: c */
    private static String f167c = null;

    /* JADX INFO: renamed from: d */
    private static String f168d = null;

    /* JADX INFO: renamed from: e */
    private static Random f169e = null;

    /* JADX INFO: renamed from: f */
    private static DisplayMetrics f170f = null;

    /* JADX INFO: renamed from: g */
    private static String f171g = null;

    /* JADX INFO: renamed from: h */
    private static String f172h = "";

    /* JADX INFO: renamed from: i */
    private static String f173i = "";

    /* JADX INFO: renamed from: j */
    private static int f174j = -1;

    /* JADX INFO: renamed from: k */
    private static abj f175k = null;

    /* JADX INFO: renamed from: l */
    private static String f176l = null;

    /* JADX INFO: renamed from: m */
    private static String f177m = null;

    /* JADX INFO: renamed from: n */
    private static volatile int f178n = -1;

    /* JADX INFO: renamed from: o */
    private static String f179o = null;

    /* JADX INFO: renamed from: p */
    private static String f180p = null;

    /* JADX INFO: renamed from: q */
    private static long f181q = -1;

    /* JADX INFO: renamed from: r */
    private static String f182r = "";

    /* JADX INFO: renamed from: s */
    private static abw f183s = null;

    /* JADX INFO: renamed from: t */
    private static String f184t = "__MTA_FIRST_ACTIVATE__";

    /* JADX INFO: renamed from: u */
    private static int f185u = -1;

    /* JADX INFO: renamed from: v */
    private static long f186v = -1;

    /* JADX INFO: renamed from: w */
    private static int f187w = 0;

    /* JADX INFO: renamed from: x */
    private static String f188x = "";

    /* JADX INFO: renamed from: a */
    public static int m76a() {
        return m103i().nextInt(Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public static int m77a(Context context, boolean z) {
        if (z) {
            f187w = aby.m125a(context, "mta.qq.com.difftime", 0);
        }
        return f187w;
    }

    /* JADX INFO: renamed from: a */
    private static Long m78a(String str, String str2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] strArrSplit = str.split(str2);
        if (strArrSplit.length == 3) {
            try {
                Long lValueOf = 0L;
                for (String str3 : strArrSplit) {
                    lValueOf = Long.valueOf((lValueOf.longValue() + Long.valueOf(str3).longValue()) * 100);
                }
                return lValueOf;
            } catch (NumberFormatException unused) {
            }
        }
        return l;
    }

    /* JADX INFO: renamed from: a */
    public static String m79a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    /* JADX INFO: renamed from: a */
    public static String m80a(Context context, String str) {
        if (acb.m191v()) {
            if (f177m == null) {
                f177m = m110o(context);
            }
            if (f177m != null) {
                return str + "_" + f177m;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public static String m81a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    /* JADX INFO: renamed from: a */
    public static HttpHost m82a(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        if (context.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return null;
        }
        if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
            return null;
        }
        if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        }
        return new HttpHost("10.0.0.172", 80);
    }

    /* JADX INFO: renamed from: a */
    public static void m83a(Context context, int i) {
        f187w = i;
        aby.m130b(context, "mta.qq.com.difftime", i);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m84a(ace aceVar) {
        if (aceVar == null) {
            return false;
        }
        return m91c(aceVar.m230c());
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m85a(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int i = gZIPInputStream.read(bArr2);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m86b() {
        if (f174j != -1) {
            return f174j;
        }
        try {
            if (abx.m124a()) {
                f174j = 1;
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        f174j = 0;
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public static long m87b(String str) {
        return m78a(str, ".", 0L).longValue();
    }

    /* JADX INFO: renamed from: b */
    public static synchronized String m88b(Context context) {
        if (f165a != null && f165a.trim().length() != 0) {
            return f165a;
        }
        String strM132a = abz.m132a(context);
        f165a = strM132a;
        if (strM132a == null || f165a.trim().length() == 0) {
            f165a = Integer.toString(m103i().nextInt(Integer.MAX_VALUE));
        }
        return f165a;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized abj m89c() {
        if (f175k == null) {
            abj abjVar = new abj("MtaSDK");
            f175k = abjVar;
            abjVar.m50a();
        }
        return f175k;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized String m90c(Context context) {
        if (f167c == null || f167c.trim().length() == 0) {
            f167c = abz.m136b(context);
        }
        return f167c;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m91c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public static long m92d() {
        long jCurrentTimeMillis;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            jCurrentTimeMillis = calendar.getTimeInMillis();
        } catch (Throwable th) {
            f175k.m54b(th);
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jCurrentTimeMillis + 86400000;
    }

    /* JADX INFO: renamed from: d */
    public static DisplayMetrics m93d(Context context) {
        if (f170f == null) {
            f170f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f170f);
        }
        return f170f;
    }

    /* JADX INFO: renamed from: e */
    public static String m94e() {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    /* JADX INFO: renamed from: e */
    public static boolean m95e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            if (!abz.m135a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                f175k.m53b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (int i = 0; i < allNetworkInfo.length; i++) {
                    if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            f175k.m54b(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m96f() {
        if (m91c(f180p)) {
            return f180p;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
        f180p = str;
        return str;
    }

    /* JADX INFO: renamed from: f */
    public static String m97f(Context context) {
        if (f166b != null) {
            return f166b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("TA_APPKEY");
            if (string != null) {
                f166b = string;
                return string;
            }
            f175k.m51a("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            f175k.m51a("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static String m98g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("InstallChannel");
            if (obj != null) {
                return obj.toString();
            }
            f175k.m55c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            f175k.m57e("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static JSONObject m99g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", abu.m120a());
            String strM123d = abu.m123d();
            if (strM123d != null && strM123d.length() > 0) {
                jSONObject.put("na", strM123d);
            }
            int iM121b = abu.m121b();
            if (iM121b > 0) {
                jSONObject.put("fx", iM121b / 1000000);
            }
            int iM122c = abu.m122c();
            if (iM122c > 0) {
                jSONObject.put("fn", iM122c / 1000000);
                return jSONObject;
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: h */
    public static String m101h(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    /* JADX INFO: renamed from: i */
    public static String m102i(Context context) {
        TelephonyManager telephonyManager;
        if (f171g != null) {
            return f171g;
        }
        try {
            if (abz.m135a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                if ((context.getPackageManager().checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE, context.getPackageName()) == 0) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    f171g = telephonyManager.getSimOperator();
                }
            } else {
                f175k.m57e("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        return f171g;
    }

    /* JADX INFO: renamed from: i */
    private static synchronized Random m103i() {
        if (f169e == null) {
            f169e = new Random();
        }
        return f169e;
    }

    /* JADX INFO: renamed from: j */
    private static long m104j() {
        if (f181q > 0) {
            return f181q;
        }
        long jIntValue = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            jIntValue = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
        } catch (Exception unused) {
        }
        f181q = jIntValue;
        return jIntValue;
    }

    /* JADX INFO: renamed from: j */
    public static String m105j(Context context) {
        if (m91c(f172h)) {
            return f172h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f172h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        return f172h;
    }

    /* JADX INFO: renamed from: k */
    public static String m106k(Context context) {
        String str = "";
        try {
            if (abz.m135a(context, MsgConstant.PERMISSION_INTERNET) && abz.m135a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        }
                        if (extraInfo != null) {
                            return extraInfo;
                        }
                        str = typeName;
                    }
                }
            } else {
                f175k.m57e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        return str;
    }

    /* JADX INFO: renamed from: l */
    public static Integer m107l(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: m */
    public static String m108m(Context context) {
        if (m91c(f173i)) {
            return f173i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f173i = str;
            if (str == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (f173i.length() == 0) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        return f173i;
    }

    /* JADX INFO: renamed from: n */
    public static String m109n(Context context) {
        String path;
        if (m91c(f176l)) {
            return f176l;
        }
        try {
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        if (!abz.m135a(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            f175k.m53b("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
            String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(blockCount);
            f176l = str;
            return str;
        }
        return null;
    }

    /* JADX INFO: renamed from: o */
    static String m110o(Context context) {
        if (f177m != null) {
            return f177m;
        }
        int iMyPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == iMyPid) {
                f177m = next.processName;
                break;
            }
        }
        return f177m;
    }

    /* JADX INFO: renamed from: p */
    public static String m111p(Context context) {
        return m80a(context, abi.f111b);
    }

    /* JADX INFO: renamed from: q */
    public static synchronized Integer m112q(Context context) {
        int i;
        if (f178n > 0) {
            if (f178n % 1000 == 0) {
                try {
                    int i2 = f178n + 1000;
                    if (f178n >= 2147383647) {
                        i2 = 0;
                    }
                    aby.m130b(context, "MTA_EVENT_INDEX", i2);
                } catch (Throwable th) {
                    f175k.m55c(th);
                }
            }
        }
        f178n = aby.m125a(context, "MTA_EVENT_INDEX", 0);
        aby.m130b(context, "MTA_EVENT_INDEX", f178n + 1000);
        i = f178n + 1;
        f178n = i;
        return Integer.valueOf(i);
    }

    /* JADX INFO: renamed from: r */
    public static String m113r(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(m104j() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: s */
    public static String m114s(Context context) {
        List<Sensor> sensorList;
        if (m91c(f182r)) {
            return f182r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                StringBuilder sb = new StringBuilder(sensorList.size() * 10);
                for (int i = 0; i < sensorList.size(); i++) {
                    sb.append(sensorList.get(i).getType());
                    if (i != sensorList.size() - 1) {
                        sb.append(",");
                    }
                }
                f182r = sb.toString();
            }
        } catch (Throwable th) {
            f175k.m54b(th);
        }
        return f182r;
    }

    /* JADX INFO: renamed from: t */
    public static synchronized int m115t(Context context) {
        if (f185u != -1) {
            return f185u;
        }
        m116u(context);
        return f185u;
    }

    /* JADX INFO: renamed from: u */
    public static void m116u(Context context) {
        int iM125a = aby.m125a(context, f184t, 1);
        f185u = iM125a;
        if (iM125a == 1) {
            aby.m130b(context, f184t, 0);
        }
    }

    /* JADX INFO: renamed from: v */
    public static boolean m117v(Context context) {
        if (f186v < 0) {
            f186v = aby.m126a(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - f186v) > 86400000;
    }

    /* JADX INFO: renamed from: w */
    public static void m118w(Context context) {
        f186v = System.currentTimeMillis();
        aby.m129a(context, "mta.qq.com.checktime", f186v);
    }

    /* JADX INFO: renamed from: x */
    public static String m119x(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity.activityInfo == null || resolveInfoResolveActivity.activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveInfoResolveActivity.activityInfo.packageName;
    }
}
