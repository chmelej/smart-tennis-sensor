package p000;

/* JADX INFO: renamed from: pk */
/* JADX INFO: compiled from: CastUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2025pk {
    /* JADX INFO: renamed from: a */
    public static int m11093a(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + ")");
    }
}
