package p000;

/* JADX INFO: renamed from: af */
/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class C0079af extends C0759ba {

    /* JADX INFO: renamed from: a */
    private float f733a;

    /* JADX INFO: renamed from: b */
    private float f734b;

    /* JADX INFO: renamed from: c */
    private float f735c;

    /* JADX INFO: renamed from: d */
    private float f736d;

    /* JADX INFO: renamed from: e */
    private float f737e;

    public C0079af(float f, float f2, float f3) {
        this.f734b = f;
        this.f733a = f2;
        this.f736d = f3;
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f737e = 0.0f;
    }

    @Override // p000.C0759ba
    /* JADX INFO: renamed from: a */
    public void mo789a(float f, float f2, C0760bb c0760bb) {
        if (this.f735c == 0.0f) {
            c0760bb.m5498b(f, 0.0f);
            return;
        }
        float f3 = ((this.f734b * 2.0f) + this.f735c) / 2.0f;
        float f4 = f2 * this.f733a;
        float f5 = (f / 2.0f) + this.f737e;
        float f6 = (this.f736d * f2) + ((1.0f - f2) * f3);
        if (f6 / f3 >= 1.0f) {
            c0760bb.m5498b(f, 0.0f);
            return;
        }
        float f7 = f3 + f4;
        float f8 = f6 + f4;
        float fSqrt = (float) Math.sqrt((f7 * f7) - (f8 * f8));
        float f9 = f5 - fSqrt;
        float f10 = f5 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f8));
        float f11 = 90.0f - degrees;
        float f12 = f9 - f4;
        c0760bb.m5498b(f12, 0.0f);
        float f13 = f4 * 2.0f;
        c0760bb.m5496a(f12, 0.0f, f9 + f4, f13, 270.0f, degrees);
        c0760bb.m5496a(f5 - f3, (-f3) - f6, f5 + f3, f3 - f6, 180.0f - f11, (f11 * 2.0f) - 180.0f);
        c0760bb.m5496a(f10 - f4, 0.0f, f10 + f4, f13, 270.0f - degrees, degrees);
        c0760bb.m5498b(f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public void m788a(float f) {
        this.f737e = f;
    }

    /* JADX INFO: renamed from: a */
    public float m787a() {
        return this.f737e;
    }

    /* JADX INFO: renamed from: b */
    public float m790b() {
        return this.f736d;
    }

    /* JADX INFO: renamed from: b */
    public void m791b(float f) {
        this.f736d = f;
    }

    /* JADX INFO: renamed from: c */
    public float m792c() {
        return this.f735c;
    }

    /* JADX INFO: renamed from: c */
    public void m793c(float f) {
        this.f735c = f;
    }

    /* JADX INFO: renamed from: d */
    public float m794d() {
        return this.f734b;
    }

    /* JADX INFO: renamed from: d */
    public void m795d(float f) {
        this.f734b = f;
    }

    /* JADX INFO: renamed from: e */
    public float m796e() {
        return this.f733a;
    }

    /* JADX INFO: renamed from: e */
    public void m797e(float f) {
        this.f733a = f;
    }
}
