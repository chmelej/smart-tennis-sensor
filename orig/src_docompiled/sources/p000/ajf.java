package p000;

import android.content.Context;

/* JADX INFO: compiled from: UpdateConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class ajf {

    /* JADX INFO: renamed from: a */
    private static String f1249a = null;

    /* JADX INFO: renamed from: b */
    private static String f1250b = null;

    /* JADX INFO: renamed from: c */
    private static boolean f1251c = true;

    /* JADX INFO: renamed from: d */
    private static boolean f1252d = true;

    /* JADX INFO: renamed from: e */
    private static boolean f1253e = false;

    /* JADX INFO: renamed from: f */
    private static boolean f1254f = true;

    /* JADX INFO: renamed from: g */
    private static boolean f1255g = false;

    /* JADX INFO: renamed from: h */
    private static boolean f1256h = true;

    /* JADX INFO: renamed from: i */
    private static boolean f1257i = true;

    /* JADX INFO: renamed from: j */
    private static int f1258j;

    /* JADX INFO: renamed from: a */
    public static String m1500a(Context context) {
        if (f1249a == null) {
            f1249a = ati.m5418f(context);
        }
        return f1249a;
    }

    /* JADX INFO: renamed from: b */
    public static String m1504b(Context context) {
        if (f1250b == null) {
            f1250b = ati.m5420h(context);
        }
        return f1250b;
    }

    /* JADX INFO: renamed from: a */
    public static void m1501a(Context context, String str) {
        context.getApplicationContext().getSharedPreferences("umeng_update", 0).edit().putString("ignore", str).commit();
    }

    /* JADX INFO: renamed from: c */
    public static String m1507c(Context context) {
        String string = context.getApplicationContext().getSharedPreferences("umeng_update", 0).getString("ignore", "");
        if ("".equals(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1503a() {
        return f1251c;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1506b() {
        return f1252d;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1508c() {
        return f1253e;
    }

    /* JADX INFO: renamed from: a */
    public static void m1502a(boolean z) {
        f1253e = z;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m1509d() {
        return f1254f;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m1510e() {
        return f1255g;
    }

    /* JADX INFO: renamed from: b */
    public static void m1505b(boolean z) {
        f1255g = z;
    }

    /* JADX INFO: renamed from: f */
    public static int m1511f() {
        return f1258j;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m1512g() {
        return f1256h;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m1513h() {
        return f1257i;
    }
}
