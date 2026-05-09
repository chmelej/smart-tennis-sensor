package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.umeng.update.net.DownloadingService;

/* JADX INFO: compiled from: DownloadAgent.java */
/* JADX INFO: loaded from: classes.dex */
public class ajk {

    /* JADX INFO: renamed from: b */
    private static final String f1290b = "ajk";

    /* JADX INFO: renamed from: c */
    private Context f1292c;

    /* JADX INFO: renamed from: d */
    private ajn f1293d;

    /* JADX INFO: renamed from: e */
    private Messenger f1294e;

    /* JADX INFO: renamed from: f */
    private String f1295f;

    /* JADX INFO: renamed from: g */
    private String f1296g;

    /* JADX INFO: renamed from: h */
    private String f1297h;

    /* JADX INFO: renamed from: i */
    private String f1298i;

    /* JADX INFO: renamed from: j */
    private String f1299j;

    /* JADX INFO: renamed from: k */
    private String[] f1300k;

    /* JADX INFO: renamed from: l */
    private boolean f1301l = false;

    /* JADX INFO: renamed from: m */
    private boolean f1302m = false;

    /* JADX INFO: renamed from: n */
    private boolean f1303n = false;

    /* JADX INFO: renamed from: a */
    final Messenger f1291a = new Messenger(new HandlerC0162b());

    /* JADX INFO: renamed from: o */
    private ServiceConnection f1304o = new ServiceConnection() { // from class: ajk.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            atj.m5427c(ajk.f1290b, "ServiceConnection.onServiceConnected");
            ajk.this.f1294e = new Messenger(iBinder);
            try {
                Message messageObtain = Message.obtain((Handler) null, 4);
                C0161a c0161a = new C0161a(ajk.this.f1295f, ajk.this.f1296g, ajk.this.f1297h);
                c0161a.f1309d = ajk.this.f1298i;
                c0161a.f1310e = ajk.this.f1299j;
                c0161a.f1311f = ajk.this.f1300k;
                c0161a.f1312g = ajk.this.f1301l;
                c0161a.f1313h = ajk.this.f1302m;
                c0161a.f1314i = ajk.this.f1303n;
                messageObtain.setData(c0161a.m1558a());
                messageObtain.replyTo = ajk.this.f1291a;
                ajk.this.f1294e.send(messageObtain);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            atj.m5427c(ajk.f1290b, "ServiceConnection.onServiceDisconnected");
            ajk.this.f1294e = null;
        }
    };

    /* JADX INFO: renamed from: a */
    public void m1552a(String str) {
        this.f1298i = str;
    }

    /* JADX INFO: renamed from: b */
    public void m1554b(String str) {
        this.f1299j = str;
    }

    /* JADX INFO: renamed from: a */
    public void m1553a(boolean z) {
        this.f1301l = z;
    }

    /* JADX INFO: renamed from: b */
    public void m1555b(boolean z) {
        this.f1302m = z;
    }

    /* JADX INFO: renamed from: c */
    public void m1556c(boolean z) {
        this.f1303n = z;
    }

    /* JADX INFO: renamed from: ajk$b */
    /* JADX INFO: compiled from: DownloadAgent.java */
    class HandlerC0162b extends Handler {
        HandlerC0162b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                atj.m5427c(ajk.f1290b, "DownloadAgent.handleMessage(" + message.what + "): ");
                int i = message.what;
                if (i != 5) {
                    switch (i) {
                        case 1:
                            if (ajk.this.f1293d != null) {
                                ajk.this.f1293d.mo1528d();
                            }
                            break;
                        case 2:
                            ajk.this.f1293d.mo1526b(message.arg1);
                            break;
                        case 3:
                            if (ajk.this.f1293d != null) {
                                ajk.this.f1293d.mo1519a(message.arg1);
                            }
                            break;
                        default:
                            super.handleMessage(message);
                            break;
                    }
                } else {
                    ajk.this.f1292c.unbindService(ajk.this.f1304o);
                    if (ajk.this.f1293d != null) {
                        if (message.arg1 != 1 && message.arg1 != 3 && message.arg1 != 5) {
                            ajk.this.f1293d.mo1520a(0, 0, null);
                            atj.m5427c(ajk.f1290b, "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
                        } else {
                            ajk.this.f1293d.mo1520a(message.arg1, message.arg2, message.getData().getString("filename"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                atj.m5427c(ajk.f1290b, "DownloadAgent.handleMessage(" + message.what + "): " + e.getMessage());
            }
        }
    }

    public ajk(Context context, String str, String str2, String str3, ajn ajnVar) {
        this.f1292c = context.getApplicationContext();
        this.f1295f = str;
        this.f1296g = str2;
        this.f1297h = str3;
        this.f1293d = ajnVar;
    }

    /* JADX INFO: renamed from: a */
    public void m1551a() {
        this.f1292c.bindService(new Intent(this.f1292c, (Class<?>) DownloadingService.class), this.f1304o, 1);
        this.f1292c.startService(new Intent(this.f1292c, (Class<?>) DownloadingService.class));
    }

    /* JADX INFO: renamed from: ajk$a */
    /* JADX INFO: compiled from: DownloadAgent.java */
    public static class C0161a {

        /* JADX INFO: renamed from: a */
        public String f1306a;

        /* JADX INFO: renamed from: b */
        public String f1307b;

        /* JADX INFO: renamed from: c */
        public String f1308c;

        /* JADX INFO: renamed from: d */
        public String f1309d;

        /* JADX INFO: renamed from: e */
        public String f1310e;

        /* JADX INFO: renamed from: f */
        public String[] f1311f = null;

        /* JADX INFO: renamed from: g */
        public boolean f1312g = false;

        /* JADX INFO: renamed from: h */
        public boolean f1313h = false;

        /* JADX INFO: renamed from: i */
        public boolean f1314i = false;

        public C0161a(String str, String str2, String str3) {
            this.f1306a = str;
            this.f1307b = str2;
            this.f1308c = str3;
        }

        /* JADX INFO: renamed from: a */
        public Bundle m1558a() {
            Bundle bundle = new Bundle();
            bundle.putString("mComponentName", this.f1306a);
            bundle.putString("mTitle", this.f1307b);
            bundle.putString("mUrl", this.f1308c);
            bundle.putString("mMd5", this.f1309d);
            bundle.putString("mTargetMd5", this.f1310e);
            bundle.putStringArray("reporturls", this.f1311f);
            bundle.putBoolean("rich_notification", this.f1312g);
            bundle.putBoolean("mSilent", this.f1313h);
            bundle.putBoolean("mWifiOnly", this.f1314i);
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        public static C0161a m1557a(Bundle bundle) {
            C0161a c0161a = new C0161a(bundle.getString("mComponentName"), bundle.getString("mTitle"), bundle.getString("mUrl"));
            c0161a.f1309d = bundle.getString("mMd5");
            c0161a.f1310e = bundle.getString("mTargetMd5");
            c0161a.f1311f = bundle.getStringArray("reporturls");
            c0161a.f1312g = bundle.getBoolean("rich_notification");
            c0161a.f1313h = bundle.getBoolean("mSilent");
            c0161a.f1314i = bundle.getBoolean("mWifiOnly");
            return c0161a;
        }
    }
}
