package p000;

import android.content.Context;

/* JADX INFO: renamed from: tx */
/* JADX INFO: compiled from: FaceBeautyProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2148tx implements InterfaceC2170us {

    /* JADX INFO: renamed from: a */
    public static final boolean f12860a = C2202vx.m12056a().m12060b();

    /* JADX INFO: renamed from: b */
    private Context f12861b;

    /* JADX INFO: renamed from: c */
    private C2149ty f12862c;

    /* JADX INFO: renamed from: d */
    private C2158ug f12863d;

    /* JADX INFO: renamed from: e */
    private int f12864e;

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: d */
    public void mo11731d() {
    }

    public C2148tx(Context context, C2158ug c2158ug) {
        if (C2202vx.m12058a(true)) {
            C2201vw.f13218g.m12053c("FaceBeautyProcessor", "using the built-in fb");
            this.f12862c = new C2149ty();
        }
        this.f12861b = context;
        this.f12863d = c2158ug;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11728a() {
        return this.f12863d != null && this.f12863d.m11767a();
    }

    /* JADX INFO: renamed from: a */
    public void m11727a(C2158ug c2158ug) {
        if (this.f12862c == null) {
            return;
        }
        if (c2158ug == null) {
            C2201vw.f13218g.m12054d("FaceBeautyProcessor", "Invalid FB setting");
            return;
        }
        float fM11769c = c2158ug.m11769c();
        if (fM11769c > 1.0f) {
            fM11769c = 1.0f;
        }
        this.f12862c.m11737b(fM11769c / 2.0f);
        this.f12862c.m11739c(c2158ug.m11770d());
        this.f12862c.m11733a(c2158ug.m11768b());
        this.f12863d = c2158ug;
    }

    /* JADX INFO: renamed from: e */
    private void m11724e() {
        if (this.f12862c != null) {
            this.f12862c.m11732a();
            this.f12862c.m11735a(this.f12861b.getApplicationContext(), C2204vz.m12076d(this.f12861b), 0);
            this.f12862c.m11736a(!C2204vz.m12077e(this.f12861b));
            m11727a(this.f12863d);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11729b() {
        if (this.f12862c != null) {
            this.f12862c.m11732a();
        }
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: c */
    public void mo11730c() {
        this.f12864e = 0;
        m11724e();
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: a */
    public void mo11726a(int i, int i2) {
        if (this.f12862c != null) {
            this.f12862c.m11738b(this.f12861b.getApplicationContext(), i, i2);
        }
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: a */
    public int mo11725a(int i, int i2, int i3, long j, float[] fArr) {
        if (this.f12862c == null || i2 == 0 || i3 == 0) {
            return i;
        }
        if (this.f12864e == 0) {
            this.f12864e = C2200vv.m12038a(null, i2, i3, 6408);
        }
        this.f12862c.m11734a(i, i2, i3, this.f12864e);
        return this.f12864e;
    }
}
