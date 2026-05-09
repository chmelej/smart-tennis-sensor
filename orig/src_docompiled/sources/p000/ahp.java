package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

/* JADX INFO: compiled from: ConnectManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ahp {

    /* JADX INFO: renamed from: a */
    private String f1085a;

    /* JADX INFO: renamed from: b */
    private int f1086b;

    /* JADX INFO: renamed from: c */
    private String f1087c;

    /* JADX INFO: renamed from: d */
    private boolean f1088d = false;

    /* JADX INFO: renamed from: e */
    private String f1089e;

    /* JADX INFO: renamed from: f */
    private String f1090f;

    public ahp(Context context) {
        m1238b(context);
        this.f1090f = aic.m1300b(context);
    }

    /* JADX INFO: renamed from: a */
    private final void m1235a(Context context, NetworkInfo networkInfo) {
        String strTrim;
        try {
            if (networkInfo.getExtraInfo() != null && (strTrim = networkInfo.getExtraInfo().toUpperCase().trim()) != null) {
                this.f1087c = strTrim;
                if (strTrim.indexOf("CMWAP") == -1 && strTrim.indexOf("UNIWAP") == -1 && strTrim.indexOf("3GWAP") == -1) {
                    if (strTrim.indexOf("CTWAP") != -1) {
                        this.f1088d = true;
                        this.f1085a = "10.0.0.200";
                        this.f1086b = 80;
                        return;
                    }
                }
                this.f1088d = true;
                this.f1085a = "10.0.0.172";
                this.f1086b = 80;
                return;
            }
            this.f1088d = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m1238b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                    this.f1089e = "wifi";
                    this.f1088d = false;
                } else {
                    m1235a(context, activeNetworkInfo);
                    m1236a(activeNetworkInfo.getSubtypeName().toLowerCase());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1237a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m1236a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1089e = "none";
            return;
        }
        if (str.equals("gsm") || str.equals("gprs") || str.equals("edge")) {
            this.f1089e = "2g";
            return;
        }
        if (str.startsWith("cdma") || str.equals("umts") || str.equals("1xrtt") || str.equals("ehrpd") || str.equals("evdo0") || str.equals("evdoa") || str.equals("evdob") || str.equals("hsupa") || str.equals("hsdpa") || str.equals("hspa")) {
            this.f1089e = "3g";
        } else if (str.equals("lte") || str.equals("umb") || str.equals("hspa+")) {
            this.f1089e = "4g";
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1239a() {
        return this.f1088d;
    }

    /* JADX INFO: renamed from: b */
    public final String m1240b() {
        return this.f1087c;
    }

    /* JADX INFO: renamed from: c */
    public final String m1241c() {
        return this.f1089e;
    }

    /* JADX INFO: renamed from: d */
    public final String m1242d() {
        return this.f1085a;
    }

    /* JADX INFO: renamed from: e */
    public final int m1243e() {
        return this.f1086b;
    }

    /* JADX INFO: renamed from: f */
    public final String m1244f() {
        if (TextUtils.isEmpty(this.f1090f)) {
            return null;
        }
        if (this.f1090f.startsWith("46000") || this.f1090f.startsWith("46002")) {
            return "cm";
        }
        if (this.f1090f.startsWith("46001")) {
            return "cu";
        }
        if (this.f1090f.startsWith("46003")) {
            return "ct";
        }
        return null;
    }
}
