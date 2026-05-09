package p000;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: yh */
/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public class C2267yh {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f13694a = true;

    /* JADX INFO: renamed from: yh$a */
    /* JADX INFO: compiled from: Base64.java */
    static abstract class a {

        /* JADX INFO: renamed from: a */
        public byte[] f13695a;

        /* JADX INFO: renamed from: b */
        public int f13696b;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m12414a(String str, int i) {
        return m12415a(str.getBytes(), i);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m12415a(byte[] bArr, int i) {
        return m12416a(bArr, 0, bArr.length, i);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m12416a(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[(i2 * 3) / 4]);
        if (!bVar.m12420a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (bVar.f13696b == bVar.f13695a.length) {
            return bVar.f13695a;
        }
        byte[] bArr2 = new byte[bVar.f13696b];
        System.arraycopy(bVar.f13695a, 0, bArr2, 0, bVar.f13696b);
        return bArr2;
    }

    /* JADX INFO: renamed from: yh$b */
    /* JADX INFO: compiled from: Base64.java */
    static class b extends a {

        /* JADX INFO: renamed from: c */
        private static final int[] f13697c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: d */
        private static final int[] f13698d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: e */
        private int f13699e;

        /* JADX INFO: renamed from: f */
        private int f13700f;

        /* JADX INFO: renamed from: g */
        private final int[] f13701g;

        public b(int i, byte[] bArr) {
            this.f13695a = bArr;
            this.f13701g = (i & 8) == 0 ? f13697c : f13698d;
            this.f13699e = 0;
            this.f13700f = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m12420a(byte[] r12, int r13, int r14, boolean r15) {
            /*
                Method dump skipped, instruction units count: 306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2267yh.b.m12420a(byte[], int, int, boolean):boolean");
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m12417b(byte[] bArr, int i) {
        try {
            return new String(m12419c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: c */
    public static byte[] m12419c(byte[] bArr, int i) {
        return m12418b(bArr, 0, bArr.length, i);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m12418b(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!cVar.f13706d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.f13707e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.f13708f ? 2 : 1);
        }
        cVar.f13695a = new byte[i4];
        cVar.m12421a(bArr, i, i2, true);
        if (f13694a || cVar.f13696b == i4) {
            return cVar.f13695a;
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: yh$c */
    /* JADX INFO: compiled from: Base64.java */
    static class c extends a {

        /* JADX INFO: renamed from: g */
        static final /* synthetic */ boolean f13702g = true;

        /* JADX INFO: renamed from: h */
        private static final byte[] f13703h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: i */
        private static final byte[] f13704i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: c */
        int f13705c;

        /* JADX INFO: renamed from: d */
        public final boolean f13706d;

        /* JADX INFO: renamed from: e */
        public final boolean f13707e;

        /* JADX INFO: renamed from: f */
        public final boolean f13708f;

        /* JADX INFO: renamed from: j */
        private final byte[] f13709j;

        /* JADX INFO: renamed from: k */
        private int f13710k;

        /* JADX INFO: renamed from: l */
        private final byte[] f13711l;

        public c(int i, byte[] bArr) {
            this.f13695a = bArr;
            this.f13706d = (i & 1) == 0;
            this.f13707e = (i & 2) == 0;
            this.f13708f = (i & 4) != 0;
            this.f13711l = (i & 8) == 0 ? f13703h : f13704i;
            this.f13709j = new byte[2];
            this.f13705c = 0;
            this.f13710k = this.f13707e ? 19 : -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m12421a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instruction units count: 550
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2267yh.c.m12421a(byte[], int, int, boolean):boolean");
        }
    }

    private C2267yh() {
    }
}
