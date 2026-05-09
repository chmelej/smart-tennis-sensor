package p000;

/* JADX INFO: renamed from: xr */
/* JADX INFO: compiled from: NetworkPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC2250xr {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);


    /* JADX INFO: renamed from: d */
    final int f13551d;

    /* JADX INFO: renamed from: a */
    public static boolean m12298a(int i) {
        return (i & NO_CACHE.f13551d) == 0;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m12299b(int i) {
        return (i & NO_STORE.f13551d) == 0;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m12300c(int i) {
        return (i & OFFLINE.f13551d) != 0;
    }

    EnumC2250xr(int i) {
        this.f13551d = i;
    }
}
