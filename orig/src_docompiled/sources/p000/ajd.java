package p000;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;
import com.umeng.message.MsgConstant;
import com.umeng.message.MsgLogStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: UmengUpdateAgent.java */
/* JADX INFO: loaded from: classes.dex */
public class ajd {

    /* JADX INFO: renamed from: a */
    private static aje f1233a = null;

    /* JADX INFO: renamed from: b */
    private static ajb f1234b = null;

    /* JADX INFO: renamed from: c */
    private static ajc f1235c = null;

    /* JADX INFO: renamed from: d */
    private static Context f1236d = null;

    /* JADX INFO: renamed from: e */
    private static aji f1237e = new aji();

    /* JADX INFO: renamed from: f */
    private static Handler f1238f = null;

    /* JADX INFO: renamed from: g */
    private static boolean f1239g = false;

    /* JADX INFO: renamed from: h */
    private static String f1240h = "ajd";

    /* JADX INFO: renamed from: d */
    private static boolean m1497d() {
        Class<?> cls;
        try {
            cls = Class.forName("com.umeng.message.PushAgent");
        } catch (ClassNotFoundException e) {
            atj.m5430d(f1240h, "isIncludesUmengPushSDK", e);
            cls = null;
        }
        return cls != null;
    }

    /* JADX INFO: renamed from: a */
    public static void m1485a(boolean z) {
        f1239g = z;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1486a() {
        return f1239g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1489b(int i, ajg ajgVar) {
        Message message = new Message();
        message.what = i;
        message.obj = ajgVar;
        f1238f.sendMessage(message);
    }

    /* JADX INFO: renamed from: a */
    public static void m1480a(Context context) {
        ajf.m1502a(false);
        ajf.m1505b(false);
        m1494c(context.getApplicationContext());
    }

    /* JADX INFO: renamed from: c */
    private static void m1494c(final Context context) {
        try {
            if (context == null) {
                atj.m5425b("update", "unexpected null context in update");
                return;
            }
            f1238f = new Handler(context.getMainLooper()) { // from class: ajd.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == 0 && ajf.m1506b()) {
                        ajd.m1490b(ajd.f1236d, (ajg) message.obj, ajf.m1511f());
                    }
                    ajd.m1491b(context, message);
                    Context unused = ajd.f1236d = null;
                    if (ajd.f1233a != null) {
                        ajd.f1233a.m1499a(message.what, (ajg) message.obj);
                    }
                }
            };
            m1498d(context);
            if (!ati.m5416d(context)) {
                if (ajf.m1510e()) {
                    m1489b(2, (ajg) null);
                    return;
                } else if (ajf.m1503a() && !ajf.m1508c()) {
                    m1489b(2, (ajg) null);
                    return;
                }
            }
            if (f1237e.m1523a()) {
                m1489b(4, (ajg) null);
                atj.m5423a("update", "Is updating now.");
                f1238f.post(new Runnable() { // from class: ajd.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, atq.m5453b(context), 0).show();
                    }
                });
            } else {
                f1236d = context;
                new Thread(new RunnableC0158a(context.getApplicationContext())).start();
            }
        } catch (Exception e) {
            atj.m5426b("update", "Exception occurred in Mobclick.update(). ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1490b(Context context, ajg ajgVar, int i) {
        try {
            if (m1492b(context, ajgVar)) {
                return;
            }
            File fileM1477a = m1477a(context, ajgVar);
            boolean z = fileM1477a != null;
            if (z || !ajf.m1510e()) {
                switch (i) {
                    case 0:
                        f1237e.m1521a(context, ajgVar, z, fileM1477a);
                        break;
                    case 1:
                        ((NotificationManager) context.getSystemService("notification")).notify(0, f1237e.m1524b(context, ajgVar, z, fileM1477a).m1530a());
                        break;
                }
            } else {
                m1496d(context, ajgVar);
            }
        } catch (Exception e) {
            atj.m5426b("update", "Fail to create update dialog box.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static File m1477a(Context context, ajg ajgVar) {
        try {
            File file = new File(ajq.m1598a("/apk", context, new boolean[1]), ajgVar.f1264f + ".apk");
            if (file.exists()) {
                if (ajgVar.f1264f.equalsIgnoreCase(ats.m5469a(file))) {
                    return file;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1492b(Context context, ajg ajgVar) {
        return (ajgVar.f1264f == null || !ajgVar.f1264f.equalsIgnoreCase(ajf.m1507c(context)) || ajf.m1508c()) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public static void m1495c(Context context, ajg ajgVar) {
        ajf.m1501a(context, ajgVar.f1264f);
    }

    /* JADX INFO: renamed from: a */
    public static void m1479a(int i, Context context, ajg ajgVar, File file) {
        if (i == 5) {
            m1482a(context, ajgVar, file);
        } else if (i == 7) {
            m1495c(context, ajgVar);
        }
        if (f1234b != null) {
            f1234b.m1473a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1482a(Context context, ajg ajgVar, File file) {
        if (file == null) {
            m1496d(context, ajgVar);
        } else {
            m1484a(context, file);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1484a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: d */
    public static void m1496d(Context context, ajg ajgVar) {
        if (ajgVar.f1267i && ajf.m1509d()) {
            f1237e.m1522a(context, ajgVar.f1263e, ajgVar.f1264f, ajgVar.f1262d, ajgVar.f1268j, f1235c);
            f1237e.m1525b();
        } else {
            f1237e.m1522a(context, ajgVar.f1262d, ajgVar.f1264f, null, null, f1235c);
            f1237e.m1527c();
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m1498d(final Context context) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean zEquals;
        if (!ajf.m1512g()) {
            return true;
        }
        try {
            if (!Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG").getBoolean(null)) {
                return true;
            }
            boolean z6 = false;
            try {
                if (ajf.m1500a(context) == null) {
                    f1238f.post(new Runnable() { // from class: ajd.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, "Please set umeng appkey!", 1).show();
                        }
                    });
                    return false;
                }
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4101);
                if (packageInfo.activities != null) {
                    z = false;
                    for (int i = 0; i < packageInfo.activities.length; i++) {
                        try {
                            if ("com.umeng.update.UpdateDialogActivity".equals(packageInfo.activities[i].name)) {
                                z = true;
                            }
                        } catch (Exception unused) {
                            return z;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    f1238f.post(new Runnable() { // from class: ajd.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, "Please add Activity in AndroidManifest!", 1).show();
                        }
                    });
                    return false;
                }
                if (packageInfo.services != null) {
                    z2 = false;
                    for (int i2 = 0; i2 < packageInfo.services.length; i2++) {
                        if ("com.umeng.update.net.DownloadingService".equals(packageInfo.services[i2].name)) {
                            z2 = true;
                        }
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    f1238f.post(new Runnable() { // from class: ajd.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, "Please add Service in AndroidManifest!", 1).show();
                        }
                    });
                    return false;
                }
                if (packageInfo.requestedPermissions != null) {
                    z3 = false;
                    z4 = false;
                    z5 = false;
                    for (int i3 = 0; i3 < packageInfo.requestedPermissions.length; i3++) {
                        if (MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE.equals(packageInfo.requestedPermissions[i3])) {
                            z3 = true;
                        } else if (MsgConstant.PERMISSION_ACCESS_NETWORK_STATE.equals(packageInfo.requestedPermissions[i3])) {
                            z4 = true;
                        } else if (MsgConstant.PERMISSION_INTERNET.equals(packageInfo.requestedPermissions[i3])) {
                            z5 = true;
                        }
                    }
                } else {
                    z3 = false;
                    z4 = false;
                    z5 = false;
                }
                boolean z7 = z3 && z4 && z5;
                if (!z7) {
                    try {
                        f1238f.post(new Runnable() { // from class: ajd.6
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(context, "Please add Permission in AndroidManifest!", 1).show();
                            }
                        });
                        return false;
                    } catch (Exception unused2) {
                        return z7;
                    }
                }
                try {
                    zEquals = "2.6.0.1.20150312".equals(context.getString(Class.forName(context.getPackageName() + ".R$string").getField("UMUpdateCheck").getInt(null)));
                } catch (Exception unused3) {
                }
                if (zEquals) {
                    return true;
                }
                z6 = zEquals;
                f1238f.post(new Runnable() { // from class: ajd.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please copy all resources (res/) from SDK to your project!", 1).show();
                    }
                });
                return z6;
            } catch (Exception unused4) {
                return false;
            }
        } catch (Exception unused5) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1491b(Context context, Message message) {
        if (m1497d() && m1486a()) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("UpdateStatus", message.what);
            bundle.putSerializable(MsgLogStore.UpdateResponse, (ajg) message.obj);
            intent.putExtra("UpdateListener", bundle);
            intent.setAction("com.umeng.message.action.autoupdate");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            m1485a(false);
            atj.m5427c("UmengUpdateAgent", "UpdateFromPushMessage");
        }
    }

    /* JADX INFO: renamed from: ajd$a */
    /* JADX INFO: compiled from: UmengUpdateAgent.java */
    static class RunnableC0158a implements Runnable {

        /* JADX INFO: renamed from: a */
        Context f1248a;

        public RunnableC0158a(Context context) {
            this.f1248a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ajg ajgVarM1517b = new ajh(this.f1248a).m1517b();
                if (ajgVarM1517b == null) {
                    ajd.m1489b(3, (ajg) null);
                } else if (!ajgVarM1517b.f1259a) {
                    ajd.m1489b(1, ajgVarM1517b);
                } else {
                    ajd.m1489b(0, ajgVarM1517b);
                }
            } catch (Error e) {
                atj.m5423a("update", "request update error" + e.getMessage());
            } catch (Exception e2) {
                ajd.m1489b(1, (ajg) null);
                atj.m5424a("update", "request update error", e2);
            }
        }
    }
}
