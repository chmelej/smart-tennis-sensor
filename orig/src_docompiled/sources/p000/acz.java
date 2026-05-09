package p000;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: AnalyticsConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class acz {

    /* JADX INFO: renamed from: a */
    public static String f337a = null;

    /* JADX INFO: renamed from: b */
    public static String f338b = null;

    /* JADX INFO: renamed from: c */
    public static String f339c = "";

    /* JADX INFO: renamed from: d */
    public static String f340d = "";

    /* JADX INFO: renamed from: e */
    public static boolean f341e = true;

    /* JADX INFO: renamed from: f */
    public static boolean f342f = true;

    /* JADX INFO: renamed from: g */
    public static long f343g = 30000;

    /* JADX INFO: renamed from: h */
    public static boolean f344h = false;

    /* JADX INFO: renamed from: i */
    public static int f345i;

    /* JADX INFO: renamed from: j */
    static double[] f346j;

    /* JADX INFO: renamed from: k */
    private static String f347k;

    /* JADX INFO: renamed from: l */
    private static String f348l;

    /* JADX INFO: renamed from: m */
    private static String f349m;

    /* JADX INFO: renamed from: n */
    private static int f350n;

    /* JADX INFO: renamed from: e */
    public static String m292e(Context context) {
        return "6.1.4";
    }

    /* JADX INFO: renamed from: a */
    public static String m287a(Context context) {
        if (TextUtils.isEmpty(f347k)) {
            f347k = aeu.m741m(context);
            if (TextUtils.isEmpty(f347k)) {
                f347k = afc.m806a(context).m813b();
            }
        }
        return f347k;
    }

    /* JADX INFO: renamed from: b */
    public static String m289b(Context context) {
        if (TextUtils.isEmpty(f348l)) {
            f348l = aeu.m744p(context);
        }
        return f348l;
    }

    /* JADX INFO: renamed from: a */
    public static double[] m288a() {
        return f346j;
    }

    /* JADX INFO: renamed from: c */
    public static String m290c(Context context) {
        if (TextUtils.isEmpty(f349m)) {
            f349m = afc.m806a(context).m814c();
        }
        return f349m;
    }

    /* JADX INFO: renamed from: d */
    public static int m291d(Context context) {
        if (f350n == 0) {
            f350n = afc.m806a(context).m815d();
        }
        return f350n;
    }
}
