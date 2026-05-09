package p000;

/* JADX INFO: renamed from: sl */
/* JADX INFO: compiled from: Config.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2109sl {

    /* JADX INFO: renamed from: a */
    public static boolean f12644a = true;

    /* JADX INFO: renamed from: b */
    public static boolean f12645b = true;

    /* JADX INFO: renamed from: c */
    public static String f12646c = null;

    /* JADX INFO: renamed from: d */
    public static int f12647d = 2097152;

    /* JADX INFO: renamed from: e */
    public static int f12648e = 4096;

    /* JADX INFO: renamed from: f */
    public static int f12649f = 10;

    static {
        try {
            f12646c = C2143ts.m11708a().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}
