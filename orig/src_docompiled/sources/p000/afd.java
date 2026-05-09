package p000;

/* JADX INFO: compiled from: EncodingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class afd {
    /* JADX INFO: renamed from: a */
    public static final boolean m826a(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    /* JADX INFO: renamed from: b */
    public static final int m827b(int i, int i2) {
        return i & ((1 << i2) ^ (-1));
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m825a(byte b, int i) {
        return m826a((int) b, i);
    }

    /* JADX INFO: renamed from: a */
    public static final byte m823a(byte b, int i, boolean z) {
        return (byte) m824a((int) b, i, z);
    }

    /* JADX INFO: renamed from: a */
    public static final int m824a(int i, int i2, boolean z) {
        return z ? i | (1 << i2) : m827b(i, i2);
    }
}
