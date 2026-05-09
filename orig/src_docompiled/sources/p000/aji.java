package p000;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.umeng.update.UpdateDialogActivity;
import java.io.File;

/* JADX INFO: compiled from: UpdateInternal.java */
/* JADX INFO: loaded from: classes.dex */
public class aji implements ajn {

    /* JADX INFO: renamed from: c */
    private ajc f1275c = null;

    /* JADX INFO: renamed from: d */
    private String f1276d = null;

    /* JADX INFO: renamed from: e */
    private String f1277e = null;

    /* JADX INFO: renamed from: f */
    private String f1278f = null;

    /* JADX INFO: renamed from: g */
    private String f1279g = null;

    /* JADX INFO: renamed from: h */
    private Context f1280h = null;

    /* JADX INFO: renamed from: i */
    private String f1281i = null;

    /* JADX INFO: renamed from: j */
    private ajk f1282j = null;

    /* JADX INFO: renamed from: k */
    private boolean f1283k = false;

    /* JADX INFO: renamed from: a */
    private final String f1273a = "delta_update";

    /* JADX INFO: renamed from: b */
    private final String f1274b = "update_normal";

    /* JADX INFO: renamed from: a */
    public void m1522a(Context context, String str, String str2, String str3, String str4, ajc ajcVar) {
        this.f1280h = context;
        this.f1281i = ati.m5422j(context);
        this.f1276d = str;
        this.f1277e = str2;
        this.f1278f = str3;
        this.f1279g = str4;
        this.f1275c = ajcVar;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1523a() {
        return this.f1283k;
    }

    /* JADX INFO: renamed from: b */
    public void m1525b() {
        this.f1282j = new ajk(this.f1280h, this.f1273a, this.f1281i, this.f1278f, this);
        this.f1282j.m1552a(this.f1279g);
        this.f1282j.m1554b(this.f1277e);
        m1518a(this.f1282j);
    }

    /* JADX INFO: renamed from: c */
    public void m1527c() {
        this.f1282j = new ajk(this.f1280h, this.f1274b, this.f1281i, this.f1276d, this);
        this.f1282j.m1552a(this.f1277e);
        this.f1282j.m1554b(this.f1277e);
        m1518a(this.f1282j);
    }

    /* JADX INFO: renamed from: a */
    private void m1518a(ajk ajkVar) {
        int i = 0;
        try {
            i = this.f1280h.getPackageManager().getPackageInfo(this.f1280h.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 16 && i >= 14 && ajf.m1513h() && !ajf.m1510e()) {
            ajkVar.m1553a(true);
        }
        ajkVar.m1555b(ajf.m1510e());
        ajkVar.m1556c(ajf.m1510e());
        ajkVar.m1551a();
    }

    @Override // p000.ajn
    /* JADX INFO: renamed from: d */
    public void mo1528d() {
        this.f1283k = true;
        if (this.f1275c != null) {
            this.f1275c.m1474a();
        }
    }

    @Override // p000.ajn
    /* JADX INFO: renamed from: a */
    public void mo1519a(int i) {
        if (this.f1275c != null) {
            this.f1275c.m1475a(i);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0003. Please report as an issue. */
    @Override // p000.ajn
    /* JADX INFO: renamed from: a */
    public void mo1520a(int i, int i2, String str) {
        if (i != 3) {
            switch (i) {
            }
        } else {
            m1527c();
        }
        this.f1283k = false;
        if (this.f1275c != null) {
            this.f1275c.m1476a(i, str);
        }
    }

    @Override // p000.ajn
    /* JADX INFO: renamed from: b */
    public void mo1526b(int i) {
        if (i != 2) {
            switch (i) {
                case 6:
                    this.f1283k = false;
                    break;
            }
        }
        this.f1283k = true;
    }

    /* JADX INFO: renamed from: a */
    public void m1521a(Context context, ajg ajgVar, boolean z, File file) {
        Intent intent = new Intent(context, (Class<?>) UpdateDialogActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("response", ajgVar);
        if (z) {
            bundle.putString("file", file.getAbsolutePath());
        } else {
            bundle.putString("file", null);
        }
        bundle.putBoolean("force", ajf.m1508c());
        intent.putExtras(bundle);
        intent.addFlags(335544320);
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: aji$a */
    /* JADX INFO: compiled from: UpdateInternal.java */
    class C0159a extends ajr {

        /* JADX INFO: renamed from: e */
        private String f1285e;

        /* JADX INFO: renamed from: f */
        private String f1286f;

        public C0159a(Context context) {
            super(context);
            this.f1285e = "";
            this.f1286f = "";
        }

        /* JADX INFO: renamed from: a */
        public C0159a m1529a(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f1351d.setContentText(charSequence);
            }
            this.f1286f = charSequence.toString();
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0159a m1531b(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f1351d.setContentTitle(charSequence);
            }
            this.f1285e = charSequence.toString();
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C0159a m1532c(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f1351d.setStyle(new Notification.BigTextStyle().bigText(charSequence));
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Notification m1530a() {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.f1351d.build();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return this.f1351d.getNotification();
            }
            this.f1350c.setLatestEventInfo(this.f1349b, this.f1285e, this.f1286f, this.f1350c.contentIntent);
            return this.f1350c;
        }
    }

    /* JADX INFO: renamed from: b */
    public C0159a m1524b(Context context, ajg ajgVar, boolean z, File file) {
        String string;
        Intent intent;
        String strM5422j = ati.m5422j(context);
        String strM1515a = ajgVar.m1515a(context, z);
        if (z) {
            string = context.getString(atk.m5432a(context).m5436d("UMDialog_InstallAPK"));
            intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        } else {
            String string2 = context.getString(atk.m5432a(context).m5436d("UMUpdateTitle"));
            Intent intent2 = new Intent(context, (Class<?>) UpdateDialogActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("response", ajgVar);
            bundle.putString("file", null);
            bundle.putBoolean("force", ajf.m1508c());
            intent2.putExtras(bundle);
            intent2.addFlags(335544320);
            string = string2;
            intent = intent2;
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        C0159a c0159a = new C0159a(context);
        c0159a.m1532c(strM1515a).m1531b(strM5422j).m1529a(string).m1611d(strM5422j + string).m1607a(activity).m1605a(R.drawable.stat_notify_sync_noanim).m1610b(true);
        return c0159a;
    }
}
