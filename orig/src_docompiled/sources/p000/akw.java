package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p002v8.renderscript.RenderScript;

/* JADX INFO: compiled from: RenderScriptBlur.java */
/* JADX INFO: loaded from: classes.dex */
public final class akw implements akt {

    /* JADX INFO: renamed from: a */
    private RenderScript f1528a;

    /* JADX INFO: renamed from: b */
    private C1786hx f1529b;

    /* JADX INFO: renamed from: c */
    private C1776hn f1530c;

    /* JADX INFO: renamed from: d */
    private boolean f1531d;

    /* JADX INFO: renamed from: e */
    private int f1532e = -1;

    /* JADX INFO: renamed from: f */
    private int f1533f = -1;

    public akw(Context context, boolean z) {
        this.f1531d = z;
        this.f1528a = RenderScript.m4383a(context);
        this.f1529b = C1786hx.m9719a(this.f1528a, C1778hp.m9709g(this.f1528a));
    }

    /* JADX INFO: renamed from: a */
    private boolean m1773a(Bitmap bitmap) {
        return bitmap.getHeight() == this.f1533f && bitmap.getWidth() == this.f1532e;
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: a */
    public final Bitmap mo1744a(Bitmap bitmap, float f) {
        C1776hn c1776hnM9688b = C1776hn.m9688b(this.f1528a, bitmap);
        Bitmap bitmapCreateBitmap = this.f1531d ? bitmap : Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        if (!m1773a(bitmap)) {
            if (this.f1530c != null) {
                this.f1530c.mo9696b();
            }
            this.f1530c = C1776hn.m9683a(this.f1528a, c1776hnM9688b.m9692a());
            this.f1532e = bitmap.getWidth();
            this.f1533f = bitmap.getHeight();
        }
        this.f1529b.m9720a(f);
        this.f1529b.m9721b(c1776hnM9688b);
        this.f1529b.m9722c(this.f1530c);
        this.f1530c.m9694a(bitmapCreateBitmap);
        c1776hnM9688b.mo9696b();
        return bitmapCreateBitmap;
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: a */
    public void mo1745a() {
        this.f1529b.mo9696b();
        this.f1528a.m4415h();
        if (this.f1530c != null) {
            this.f1530c.mo9696b();
        }
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: b */
    public Bitmap.Config mo1746b() {
        return Bitmap.Config.ARGB_8888;
    }
}
