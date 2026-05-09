package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: pp */
/* JADX INFO: compiled from: Matrix.java */
/* JADX INFO: loaded from: classes.dex */
public class C2030pp {

    /* JADX INFO: renamed from: j */
    public static final C2030pp f12194j = new C2030pp(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: k */
    public static final C2030pp f12195k = new C2030pp(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: l */
    public static final C2030pp f12196l = new C2030pp(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: m */
    public static final C2030pp f12197m = new C2030pp(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: a */
    double f12198a;

    /* JADX INFO: renamed from: b */
    double f12199b;

    /* JADX INFO: renamed from: c */
    double f12200c;

    /* JADX INFO: renamed from: d */
    double f12201d;

    /* JADX INFO: renamed from: e */
    double f12202e;

    /* JADX INFO: renamed from: f */
    double f12203f;

    /* JADX INFO: renamed from: g */
    double f12204g;

    /* JADX INFO: renamed from: h */
    double f12205h;

    /* JADX INFO: renamed from: i */
    double f12206i;

    public C2030pp(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f12198a = d5;
        this.f12199b = d6;
        this.f12200c = d7;
        this.f12201d = d;
        this.f12202e = d2;
        this.f12203f = d3;
        this.f12204g = d4;
        this.f12205h = d8;
        this.f12206i = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2030pp c2030pp = (C2030pp) obj;
        return Double.compare(c2030pp.f12201d, this.f12201d) == 0 && Double.compare(c2030pp.f12202e, this.f12202e) == 0 && Double.compare(c2030pp.f12203f, this.f12203f) == 0 && Double.compare(c2030pp.f12204g, this.f12204g) == 0 && Double.compare(c2030pp.f12205h, this.f12205h) == 0 && Double.compare(c2030pp.f12206i, this.f12206i) == 0 && Double.compare(c2030pp.f12198a, this.f12198a) == 0 && Double.compare(c2030pp.f12199b, this.f12199b) == 0 && Double.compare(c2030pp.f12200c, this.f12200c) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f12198a);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f12199b);
        int i = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f12200c);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f12201d);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.f12202e);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.f12203f);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.f12204g);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.f12205h);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.f12206i);
        return (i7 * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public String toString() {
        if (equals(f12194j)) {
            return "Rotate 0°";
        }
        if (equals(f12195k)) {
            return "Rotate 90°";
        }
        if (equals(f12196l)) {
            return "Rotate 180°";
        }
        if (equals(f12197m)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.f12198a + ", v=" + this.f12199b + ", w=" + this.f12200c + ", a=" + this.f12201d + ", b=" + this.f12202e + ", c=" + this.f12203f + ", d=" + this.f12204g + ", tx=" + this.f12205h + ", ty=" + this.f12206i + '}';
    }

    /* JADX INFO: renamed from: a */
    public static C2030pp m11098a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return new C2030pp(d, d2, d4, d5, d3, d6, d9, d7, d8);
    }

    /* JADX INFO: renamed from: a */
    public static C2030pp m11099a(ByteBuffer byteBuffer) {
        return m11098a(C1934nf.m10739f(byteBuffer), C1934nf.m10739f(byteBuffer), C1934nf.m10740g(byteBuffer), C1934nf.m10739f(byteBuffer), C1934nf.m10739f(byteBuffer), C1934nf.m10740g(byteBuffer), C1934nf.m10739f(byteBuffer), C1934nf.m10739f(byteBuffer), C1934nf.m10740g(byteBuffer));
    }

    /* JADX INFO: renamed from: b */
    public void m11100b(ByteBuffer byteBuffer) {
        C1935ng.m10744a(byteBuffer, this.f12201d);
        C1935ng.m10744a(byteBuffer, this.f12202e);
        C1935ng.m10748b(byteBuffer, this.f12198a);
        C1935ng.m10744a(byteBuffer, this.f12203f);
        C1935ng.m10744a(byteBuffer, this.f12204g);
        C1935ng.m10748b(byteBuffer, this.f12199b);
        C1935ng.m10744a(byteBuffer, this.f12205h);
        C1935ng.m10744a(byteBuffer, this.f12206i);
        C1935ng.m10748b(byteBuffer, this.f12200c);
    }
}
