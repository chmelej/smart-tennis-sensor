package p000;

/* JADX INFO: renamed from: xq */
/* JADX INFO: compiled from: MemoryPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC2249xq {
    NO_CACHE(1),
    NO_STORE(2);


    /* JADX INFO: renamed from: c */
    final int f13546c;

    /* JADX INFO: renamed from: a */
    static boolean m12296a(int i) {
        return (i & NO_CACHE.f13546c) == 0;
    }

    /* JADX INFO: renamed from: b */
    static boolean m12297b(int i) {
        return (i & NO_STORE.f13546c) == 0;
    }

    EnumC2249xq(int i) {
        this.f13546c = i;
    }
}
