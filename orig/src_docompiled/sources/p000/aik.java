package p000;

/* JADX INFO: compiled from: BaseNCodec.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class aik {

    /* JADX INFO: renamed from: a */
    private final int f1142a;

    /* JADX INFO: renamed from: b */
    protected final byte f1143b = 61;

    /* JADX INFO: renamed from: c */
    protected final int f1144c;

    /* JADX INFO: renamed from: d */
    protected byte[] f1145d;

    /* JADX INFO: renamed from: e */
    protected int f1146e;

    /* JADX INFO: renamed from: f */
    protected boolean f1147f;

    /* JADX INFO: renamed from: g */
    protected int f1148g;

    /* JADX INFO: renamed from: h */
    protected int f1149h;

    /* JADX INFO: renamed from: i */
    private final int f1150i;

    /* JADX INFO: renamed from: j */
    private final int f1151j;

    /* JADX INFO: renamed from: k */
    private int f1152k;

    /* JADX INFO: renamed from: a */
    abstract void mo1324a(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo1325a(byte b);

    /* JADX INFO: renamed from: b */
    protected int m1331b() {
        return 8192;
    }

    /* JADX INFO: renamed from: b */
    abstract void mo1326b(byte[] bArr, int i, int i2);

    protected aik(int i, int i2, int i3, int i4) {
        this.f1142a = i;
        this.f1150i = i2;
        this.f1144c = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f1151j = i4;
    }

    /* JADX INFO: renamed from: a */
    int m1329a() {
        if (this.f1145d != null) {
            return this.f1146e - this.f1152k;
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    private void m1327c() {
        if (this.f1145d == null) {
            this.f1145d = new byte[m1331b()];
            this.f1146e = 0;
            this.f1152k = 0;
        } else {
            byte[] bArr = new byte[this.f1145d.length * 2];
            System.arraycopy(this.f1145d, 0, bArr, 0, this.f1145d.length);
            this.f1145d = bArr;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1330a(int i) {
        if (this.f1145d == null || this.f1145d.length < this.f1146e + i) {
            m1327c();
        }
    }

    /* JADX INFO: renamed from: c */
    int m1332c(byte[] bArr, int i, int i2) {
        if (this.f1145d == null) {
            return this.f1147f ? -1 : 0;
        }
        int iMin = Math.min(m1329a(), i2);
        System.arraycopy(this.f1145d, this.f1152k, bArr, i, iMin);
        this.f1152k += iMin;
        if (this.f1152k >= this.f1146e) {
            this.f1145d = null;
        }
        return iMin;
    }

    /* JADX INFO: renamed from: d */
    private void m1328d() {
        this.f1145d = null;
        this.f1146e = 0;
        this.f1152k = 0;
        this.f1148g = 0;
        this.f1149h = 0;
        this.f1147f = false;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m1333d(byte[] bArr) {
        m1328d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo1326b(bArr, 0, bArr.length);
        mo1326b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f1146e];
        m1332c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* JADX INFO: renamed from: e */
    public byte[] m1334e(byte[] bArr) {
        m1328d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo1324a(bArr, 0, bArr.length);
        mo1324a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f1146e - this.f1152k];
        m1332c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* JADX INFO: renamed from: f */
    protected boolean m1335f(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (61 == bArr[i] || mo1325a(bArr[i])) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public long m1336g(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f1142a) - 1) / this.f1142a)) * ((long) this.f1150i);
        return this.f1144c > 0 ? length + ((((length + ((long) this.f1144c)) - 1) / ((long) this.f1144c)) * ((long) this.f1151j)) : length;
    }
}
