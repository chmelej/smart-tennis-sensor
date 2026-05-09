package p000;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: qw */
/* JADX INFO: compiled from: DisplayBitmapTask.java */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC2066qw implements Runnable {

    /* JADX INFO: renamed from: a */
    private final Bitmap f12406a;

    /* JADX INFO: renamed from: b */
    private final String f12407b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC2095ry f12408c;

    /* JADX INFO: renamed from: d */
    private final String f12409d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC2090rt f12410e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC2100sc f12411f;

    /* JADX INFO: renamed from: g */
    private final C2071ra f12412g;

    /* JADX INFO: renamed from: h */
    private final EnumC2080rj f12413h;

    public RunnableC2066qw(Bitmap bitmap, C2072rb c2072rb, C2071ra c2071ra, EnumC2080rj enumC2080rj) {
        this.f12406a = bitmap;
        this.f12407b = c2072rb.f12518a;
        this.f12408c = c2072rb.f12520c;
        this.f12409d = c2072rb.f12519b;
        this.f12410e = c2072rb.f12522e.m11320q();
        this.f12411f = c2072rb.f12523f;
        this.f12412g = c2071ra;
        this.f12413h = enumC2080rj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f12408c.mo11499e()) {
            C2106si.m11522a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f12409d);
            this.f12411f.mo11509b(this.f12407b, this.f12408c.mo11498d());
        } else if (m11280a()) {
            C2106si.m11522a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f12409d);
            this.f12411f.mo11509b(this.f12407b, this.f12408c.mo11498d());
        } else {
            C2106si.m11522a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f12413h, this.f12409d);
            this.f12410e.mo11479a(this.f12406a, this.f12408c, this.f12413h);
            this.f12412g.m11407b(this.f12408c);
            this.f12411f.mo11366a(this.f12407b, this.f12408c.mo11498d(), this.f12406a);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m11280a() {
        return !this.f12409d.equals(this.f12412g.m11399a(this.f12408c));
    }
}
