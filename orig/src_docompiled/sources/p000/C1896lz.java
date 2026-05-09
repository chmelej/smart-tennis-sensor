package p000;

/* JADX INFO: renamed from: lz */
/* JADX INFO: compiled from: FastDoubleClick.java */
/* JADX INFO: loaded from: classes.dex */
public class C1896lz {

    /* JADX INFO: renamed from: a */
    private static long f11440a = 0;

    /* JADX INFO: renamed from: b */
    private static boolean f11441b = false;

    /* JADX INFO: renamed from: c */
    private static int f11442c;

    /* JADX INFO: renamed from: a */
    public static boolean m10463a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f11442c == i && jCurrentTimeMillis - f11440a < 800) {
            return true;
        }
        f11442c = i;
        f11440a = jCurrentTimeMillis;
        return false;
    }
}
