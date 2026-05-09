package p000;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public class aij extends aik {

    /* JADX INFO: renamed from: a */
    static final byte[] f1132a = {13, 10};

    /* JADX INFO: renamed from: i */
    private static final byte[] f1133i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: j */
    private static final byte[] f1134j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: k */
    private static final byte[] f1135k = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* JADX INFO: renamed from: l */
    private final byte[] f1136l;

    /* JADX INFO: renamed from: m */
    private final byte[] f1137m;

    /* JADX INFO: renamed from: n */
    private final byte[] f1138n;

    /* JADX INFO: renamed from: o */
    private final int f1139o;

    /* JADX INFO: renamed from: p */
    private final int f1140p;

    /* JADX INFO: renamed from: q */
    private int f1141q;

    public aij() {
        this(0);
    }

    public aij(boolean z) {
        this(76, f1132a, z);
    }

    public aij(int i) {
        this(i, f1132a);
    }

    public aij(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public aij(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f1137m = f1135k;
        if (bArr != null) {
            if (m1335f(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + aih.m1315a(bArr) + "]");
            }
            if (i > 0) {
                this.f1140p = bArr.length + 4;
                this.f1138n = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.f1138n, 0, bArr.length);
            } else {
                this.f1140p = 4;
                this.f1138n = null;
            }
        } else {
            this.f1140p = 4;
            this.f1138n = null;
        }
        this.f1139o = this.f1140p - 1;
        this.f1136l = z ? f1134j : f1133i;
    }

    @Override // p000.aik
    /* JADX INFO: renamed from: a */
    void mo1324a(byte[] bArr, int i, int i2) {
        if (this.f1147f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = i;
            int i4 = 0;
            while (i4 < i2) {
                m1330a(this.f1140p);
                this.f1149h = (this.f1149h + 1) % 3;
                int i5 = i3 + 1;
                int i6 = bArr[i3];
                if (i6 < 0) {
                    i6 += 256;
                }
                this.f1141q = (this.f1141q << 8) + i6;
                if (this.f1149h == 0) {
                    byte[] bArr2 = this.f1145d;
                    int i7 = this.f1146e;
                    this.f1146e = i7 + 1;
                    bArr2[i7] = this.f1136l[(this.f1141q >> 18) & 63];
                    byte[] bArr3 = this.f1145d;
                    int i8 = this.f1146e;
                    this.f1146e = i8 + 1;
                    bArr3[i8] = this.f1136l[(this.f1141q >> 12) & 63];
                    byte[] bArr4 = this.f1145d;
                    int i9 = this.f1146e;
                    this.f1146e = i9 + 1;
                    bArr4[i9] = this.f1136l[(this.f1141q >> 6) & 63];
                    byte[] bArr5 = this.f1145d;
                    int i10 = this.f1146e;
                    this.f1146e = i10 + 1;
                    bArr5[i10] = this.f1136l[this.f1141q & 63];
                    this.f1148g += 4;
                    if (this.f1144c > 0 && this.f1144c <= this.f1148g) {
                        System.arraycopy(this.f1138n, 0, this.f1145d, this.f1146e, this.f1138n.length);
                        this.f1146e += this.f1138n.length;
                        this.f1148g = 0;
                    }
                }
                i4++;
                i3 = i5;
            }
            return;
        }
        this.f1147f = true;
        if (this.f1149h == 0 && this.f1144c == 0) {
            return;
        }
        m1330a(this.f1140p);
        int i11 = this.f1146e;
        switch (this.f1149h) {
            case 1:
                byte[] bArr6 = this.f1145d;
                int i12 = this.f1146e;
                this.f1146e = i12 + 1;
                bArr6[i12] = this.f1136l[(this.f1141q >> 2) & 63];
                byte[] bArr7 = this.f1145d;
                int i13 = this.f1146e;
                this.f1146e = i13 + 1;
                bArr7[i13] = this.f1136l[(this.f1141q << 4) & 63];
                if (this.f1136l == f1133i) {
                    byte[] bArr8 = this.f1145d;
                    int i14 = this.f1146e;
                    this.f1146e = i14 + 1;
                    bArr8[i14] = 61;
                    byte[] bArr9 = this.f1145d;
                    int i15 = this.f1146e;
                    this.f1146e = i15 + 1;
                    bArr9[i15] = 61;
                }
                break;
            case 2:
                byte[] bArr10 = this.f1145d;
                int i16 = this.f1146e;
                this.f1146e = i16 + 1;
                bArr10[i16] = this.f1136l[(this.f1141q >> 10) & 63];
                byte[] bArr11 = this.f1145d;
                int i17 = this.f1146e;
                this.f1146e = i17 + 1;
                bArr11[i17] = this.f1136l[(this.f1141q >> 4) & 63];
                byte[] bArr12 = this.f1145d;
                int i18 = this.f1146e;
                this.f1146e = i18 + 1;
                bArr12[i18] = this.f1136l[(this.f1141q << 2) & 63];
                if (this.f1136l == f1133i) {
                    byte[] bArr13 = this.f1145d;
                    int i19 = this.f1146e;
                    this.f1146e = i19 + 1;
                    bArr13[i19] = 61;
                }
                break;
        }
        this.f1148g += this.f1146e - i11;
        if (this.f1144c <= 0 || this.f1148g <= 0) {
            return;
        }
        System.arraycopy(this.f1138n, 0, this.f1145d, this.f1146e, this.f1138n.length);
        this.f1146e += this.f1138n.length;
    }

    @Override // p000.aik
    /* JADX INFO: renamed from: b */
    void mo1326b(byte[] bArr, int i, int i2) {
        byte b;
        if (this.f1147f) {
        }
        if (i2 < 0) {
            this.f1147f = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            m1330a(this.f1139o);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.f1147f = true;
                break;
            }
            if (b2 >= 0 && b2 < f1135k.length && (b = f1135k[b2]) >= 0) {
                this.f1149h = (this.f1149h + 1) % 4;
                this.f1141q = (this.f1141q << 6) + b;
                if (this.f1149h == 0) {
                    byte[] bArr2 = this.f1145d;
                    int i5 = this.f1146e;
                    this.f1146e = i5 + 1;
                    bArr2[i5] = (byte) ((this.f1141q >> 16) & 255);
                    byte[] bArr3 = this.f1145d;
                    int i6 = this.f1146e;
                    this.f1146e = i6 + 1;
                    bArr3[i6] = (byte) ((this.f1141q >> 8) & 255);
                    byte[] bArr4 = this.f1145d;
                    int i7 = this.f1146e;
                    this.f1146e = i7 + 1;
                    bArr4[i7] = (byte) (this.f1141q & 255);
                }
            }
            i3++;
            i = i4;
        }
        if (!this.f1147f || this.f1149h == 0) {
            return;
        }
        m1330a(this.f1139o);
        switch (this.f1149h) {
            case 2:
                this.f1141q >>= 4;
                byte[] bArr5 = this.f1145d;
                int i8 = this.f1146e;
                this.f1146e = i8 + 1;
                bArr5[i8] = (byte) (this.f1141q & 255);
                break;
            case 3:
                this.f1141q >>= 2;
                byte[] bArr6 = this.f1145d;
                int i9 = this.f1146e;
                this.f1146e = i9 + 1;
                bArr6[i9] = (byte) ((this.f1141q >> 8) & 255);
                byte[] bArr7 = this.f1145d;
                int i10 = this.f1146e;
                this.f1146e = i10 + 1;
                bArr7[i10] = (byte) (this.f1141q & 255);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1318a(byte[] bArr) {
        return m1319a(bArr, false);
    }

    /* JADX INFO: renamed from: b */
    public static String m1322b(byte[] bArr) {
        return aih.m1315a(m1319a(bArr, false));
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1319a(byte[] bArr, boolean z) {
        return m1320a(bArr, z, false);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1320a(byte[] bArr, boolean z, boolean z2) {
        return m1321a(bArr, z, z2, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1321a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        aij aijVar = z ? new aij(z2) : new aij(0, f1132a, z2);
        long jG = aijVar.m1336g(bArr);
        if (jG > i) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jG + ") than the specified maximum size of " + i);
        }
        return aijVar.m1334e(bArr);
    }

    /* JADX INFO: renamed from: c */
    public static byte[] m1323c(byte[] bArr) {
        return new aij().m1333d(bArr);
    }

    @Override // p000.aik
    /* JADX INFO: renamed from: a */
    protected boolean mo1325a(byte b) {
        return b >= 0 && b < this.f1137m.length && this.f1137m[b] != -1;
    }
}
