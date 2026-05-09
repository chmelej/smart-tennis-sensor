package p000;

import android.os.Build;
import android.support.p002v8.renderscript.RenderScript;

/* JADX INFO: renamed from: hx */
/* JADX INFO: compiled from: ScriptIntrinsicBlur.java */
/* JADX INFO: loaded from: classes.dex */
public class C1786hx extends AbstractC1785hw {

    /* JADX INFO: renamed from: a */
    private final float[] f10278a;

    /* JADX INFO: renamed from: b */
    private C1776hn f10279b;

    protected C1786hx(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.f10278a = new float[9];
    }

    /* JADX INFO: renamed from: a */
    public static C1786hx m9719a(RenderScript renderScript, C1778hp c1778hp) {
        if (!c1778hp.m9711a(C1778hp.m9709g(renderScript)) && !c1778hp.m9711a(C1778hp.m9704b(renderScript))) {
            throw new C1781hs("Unsupported element type.");
        }
        boolean z = renderScript.m4404a() && Build.VERSION.SDK_INT < 19;
        C1786hx c1786hx = new C1786hx(renderScript.m4390a(5, c1778hp.m9698a(renderScript), z), renderScript);
        c1786hx.m9718a(z);
        c1786hx.m9720a(5.0f);
        return c1786hx;
    }

    /* JADX INFO: renamed from: b */
    public void m9721b(C1776hn c1776hn) {
        if (c1776hn.m9692a().m9726f() == 0) {
            throw new C1781hs("Input set to a 1D Allocation");
        }
        this.f10279b = c1776hn;
        m9717a(1, c1776hn);
    }

    /* JADX INFO: renamed from: a */
    public void m9720a(float f) {
        if (f <= 0.0f || f > 25.0f) {
            throw new C1781hs("Radius out of range (0 < r <= 25).");
        }
        m9715a(0, f);
    }

    /* JADX INFO: renamed from: c */
    public void m9722c(C1776hn c1776hn) {
        if (c1776hn.m9692a().m9726f() == 0) {
            throw new C1781hs("Output is a 1D Allocation");
        }
        m9716a(0, (C1776hn) null, c1776hn, null);
    }
}
