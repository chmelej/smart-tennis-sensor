package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Proxy;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ahr {

    /* JADX INFO: renamed from: b */
    private static final String f1097b = "ahr";

    /* JADX INFO: renamed from: e */
    private static int f1098e = 1800;

    /* JADX INFO: renamed from: f */
    private static int f1099f = 7200;

    /* JADX INFO: renamed from: g */
    private static int f1100g = 2500;

    /* JADX INFO: renamed from: h */
    private static final ReentrantLock f1101h = new ReentrantLock();

    /* JADX INFO: renamed from: i */
    private static ahr f1102i;

    /* JADX INFO: renamed from: a */
    public boolean f1103a;

    /* JADX INFO: renamed from: c */
    private Context f1104c;

    /* JADX INFO: renamed from: d */
    private String f1105d;

    /* JADX INFO: renamed from: j */
    private String f1106j;

    /* JADX INFO: renamed from: l */
    private String f1108l;

    /* JADX INFO: renamed from: m */
    private String f1109m;

    /* JADX INFO: renamed from: n */
    private String f1110n;

    /* JADX INFO: renamed from: o */
    private String f1111o;

    /* JADX INFO: renamed from: p */
    private String f1112p;

    /* JADX INFO: renamed from: q */
    private String f1113q;

    /* JADX INFO: renamed from: r */
    private int f1114r;

    /* JADX INFO: renamed from: k */
    private String f1107k = "tb_android_daemon_1.1.0";

    /* JADX INFO: renamed from: s */
    private boolean f1115s = true;

    public ahr(Context context, int i, boolean z) {
        this.f1104c = null;
        this.f1103a = false;
        this.f1106j = "100001";
        this.f1108l = "";
        this.f1109m = "21646297";
        this.f1110n = "null";
        this.f1111o = "";
        this.f1112p = "100.69.165.28";
        this.f1113q = "http://100.69.165.28/agoo/report";
        this.f1114r = 80;
        this.f1104c = context;
        f1098e = i;
        this.f1103a = z;
        this.f1105d = m1248a(new Build(), "CPU_ABI");
        this.f1108l = "/data/data/" + context.getPackageName();
        this.f1111o = String.valueOf(apo.m4902o(this.f1104c));
        this.f1109m = apo.m4883c(this.f1104c);
        this.f1110n = ais.m1388c(this.f1104c);
        int iM4911x = apo.m4911x(this.f1104c);
        if (iM4911x == 1 || iM4911x == 2) {
            this.f1112p = "agoodm.m.taobao.com";
            this.f1114r = 80;
            this.f1113q = "http://agoodm.m.taobao.com/agoo/report";
            this.f1106j = "1009527";
            return;
        }
        if (iM4911x == 0) {
            this.f1112p = "110.75.98.154";
            this.f1114r = 80;
            this.f1113q = "http://agoodm.wapa.taobao.com/agoo/report";
            this.f1106j = "1009527";
            return;
        }
        this.f1112p = "100.69.168.33";
        this.f1114r = 80;
        this.f1113q = "http://100.69.168.33/agoo/report";
        f1098e = 60;
        this.f1106j = "9527";
    }

    /* JADX INFO: renamed from: c */
    private String m1254c() {
        if (this.f1105d.startsWith("arm")) {
            return "armeabi/";
        }
        return this.f1105d + "/";
    }

    /* JADX INFO: renamed from: a */
    private static String m1248a(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: renamed from: a */
    public static ahr m1246a(Context context, int i, boolean z) {
        try {
            f1101h.lock();
            if (f1102i == null) {
                f1102i = new ahr(context, i, z);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            f1101h.unlock();
            throw th;
        }
        f1101h.unlock();
        return f1102i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008d -> B:40:0x00b0). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: d */
    private String m1255d() throws Throwable {
        ?? r0;
        ?? file = new File(this.f1104c.getFilesDir(), "DaemonServer");
        if (file.exists()) {
            file.delete();
        }
        Log.w(f1097b, "open assets from = " + m1254c() + "DaemonServer");
        FileOutputStream fileOutputStream = new FileOutputStream((File) file);
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (this.f1103a) {
                        InputStream inputStreamOpen = this.f1104c.getAssets().open(m1254c() + "DaemonServer");
                        try {
                            byte[] bArr = new byte[100];
                            while (true) {
                                int i = inputStreamOpen.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            inputStream = inputStreamOpen;
                        } catch (Exception e) {
                            e = e;
                            inputStream = inputStreamOpen;
                            Log.e(f1097b, "error in copy daemon files", e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    Log.e(f1097b, "error in close input file", e2);
                                }
                            }
                            fileOutputStream.close();
                            r0 = file;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamOpen;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    Log.e(f1097b, "error in close input file", e3);
                                }
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e4) {
                                Log.e(f1097b, "error in close io", e4);
                                throw th;
                            }
                        }
                    } else {
                        m1250a(fileOutputStream);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            Log.e(f1097b, "error in close input file", e5);
                        }
                    }
                    fileOutputStream.close();
                    r0 = file;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (IOException e7) {
            Log.e(f1097b, "error in close io", e7);
            r0 = file;
        }
        file = r0.getCanonicalPath();
        return file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0090 -> B:52:0x0093). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a */
    private void m1250a(FileOutputStream e) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        String strM1264a = ahs.m1264a(this.f1105d);
        Log.d(f1097b, ">>>soDataSize:datasize:" + strM1264a.length());
        byte[] bArrM1265a = aht.m1265a(strM1264a.getBytes());
        Log.d(f1097b, ">>>soDataSize:" + bArrM1265a.length);
        if (bArrM1265a.length > 0 && e != 0) {
            ?? r1 = 0;
            r1 = 0;
            r1 = 0;
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArrM1265a);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    byte[] bArr = new byte[100];
                    while (true) {
                        int i = byteArrayInputStream.read(bArr, 0, 100);
                        if (i >= 0) {
                            e.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                Log.e(f1097b, "error in write files", e3);
                                r1 = "error in write files";
                                e = e3;
                            }
                        }
                    }
                    e.flush();
                    r1 = bArr;
                    e = e;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                } catch (IOException e4) {
                    e = e4;
                    r1 = byteArrayInputStream;
                    Log.e(f1097b, "error in write files", e);
                    try {
                        e.flush();
                        e = e;
                    } catch (IOException e5) {
                        Log.e(f1097b, "error in write files", e5);
                        e = e5;
                    }
                    if (r1 != 0) {
                        r1.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r1 = byteArrayInputStream;
                    try {
                        e.flush();
                    } catch (IOException e6) {
                        Log.e(f1097b, "error in write files", e6);
                    }
                    if (r1 != 0) {
                        try {
                            r1.close();
                            throw th;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1251a(String str) {
        StringBuilder sb = new StringBuilder();
        ahv.m1269a("", "chmod 500 " + str, sb);
        ahv.m1269a("", str + " " + m1256e(), sb);
        Log.w(f1097b, str + " " + m1256e());
    }

    /* JADX INFO: renamed from: e */
    private String m1256e() {
        StringBuilder sb = new StringBuilder();
        String str = "/data/data/" + this.f1104c.getPackageName();
        sb.append("-s \"" + str + "/lib/\" ");
        sb.append("-n \"runServer\" ");
        sb.append("-p \"" + m1260i() + "\" ");
        sb.append("-f \"" + str + "\" ");
        sb.append("-t \"" + f1098e + "\" ");
        sb.append("-c \"agoo.pid\" ");
        if (this.f1108l != null) {
            sb.append("-P " + this.f1108l + " ");
        }
        if (this.f1106j != null) {
            sb.append("-K " + this.f1106j + " ");
        }
        if (this.f1107k != null) {
            sb.append("-U " + this.f1107k + " ");
        }
        if (this.f1113q != null) {
            sb.append("-L " + this.f1113q + " ");
        }
        sb.append("-D " + m1259h() + " ");
        if (this.f1112p != null) {
            sb.append("-I " + this.f1112p + " ");
        }
        if (this.f1114r > 0) {
            sb.append("-O " + this.f1114r + " ");
        }
        String strM1257f = m1257f();
        String strM1258g = m1258g();
        if (strM1257f != null && !strM1257f.isEmpty()) {
            sb.append("-X " + strM1257f + " ");
            sb.append("-Y " + strM1258g + " ");
        }
        if (this.f1115s) {
            sb.append("-T ");
        }
        sb.append("-Z ");
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    private static String m1257f() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    /* JADX INFO: renamed from: g */
    private static String m1258g() {
        if (Build.VERSION.SDK_INT < 11) {
            return String.valueOf(Proxy.getDefaultPort());
        }
        return System.getProperty("http.proxyPort");
    }

    /* JADX INFO: renamed from: h */
    private String m1259h() {
        String str = "{\"package\":\"" + this.f1104c.getPackageName() + "\",\"appKey\":\"" + this.f1109m + "\",\"utdid\":\"" + this.f1110n + "\",\"sdkVersion\":\"" + this.f1111o + "\"}";
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: renamed from: i */
    private String m1260i() {
        StringBuilder sb = new StringBuilder();
        sb.append("startservice -n {packname}/com.umeng.message.UmengService --es cockroach cockroach-PPreotect --es pack {packname}".replaceAll("\\{packname\\}", this.f1104c.getApplicationContext().getPackageName()));
        if (Build.VERSION.SDK_INT > 15) {
            sb.append(" --user 0");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m1261a() {
        m1262a(apo.m4913z(this.f1104c));
    }

    /* JADX INFO: renamed from: a */
    public void m1262a(int i) {
        if (i > 0) {
            f1098e = i;
        }
        Log.d(f1097b, "api level is:" + Build.VERSION.SDK_INT);
        m1252b(this.f1104c);
        if (Build.VERSION.SDK_INT < 20) {
            try {
                m1251a(m1255d());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ais.m1403j(this.f1104c);
    }

    /* JADX INFO: renamed from: b */
    public void m1263b() {
        File file = new File("/data/data/" + this.f1104c.getPackageName(), "daemonserver.pid");
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final PendingIntent m1247a(Context context) {
        Intent intent = new Intent();
        intent.setAction(context.getApplicationContext().getPackageName() + ".intent.action.COCKROACH");
        intent.putExtra("cockroach", "cockroach-PPreotect");
        intent.putExtra("pack", context.getApplicationContext().getPackageName());
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    /* JADX INFO: renamed from: b */
    public static void m1252b(Context context) {
        int i = Calendar.getInstance().get(11);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent pendingIntentM1247a = m1247a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (i > 23 || i < 6) {
                Log.w(f1097b, "time is night, do not wakeup cpu");
                m1253b(context, alarmManager, pendingIntentM1247a, jElapsedRealtime);
            } else {
                Log.w(f1097b, "time is daytime, wakeup cpu for keeping connecntion");
                m1249a(context, alarmManager, pendingIntentM1247a, jElapsedRealtime);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1249a(Context context, AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(2, j + ((long) (f1100g * 1000)), f1100g * 1000, pendingIntent);
    }

    /* JADX INFO: renamed from: b */
    private static void m1253b(Context context, AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(3, j + ((long) (f1099f * 1000)), f1099f * 1000, pendingIntent);
    }
}
