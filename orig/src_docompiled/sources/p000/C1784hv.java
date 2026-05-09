package p000;

import android.support.p002v8.renderscript.RenderScript;
import android.util.SparseArray;

/* JADX INFO: renamed from: hv */
/* JADX INFO: compiled from: Script.java */
/* JADX INFO: loaded from: classes.dex */
public class C1784hv extends C1777ho {

    /* JADX INFO: renamed from: a */
    private boolean f10274a;

    /* JADX INFO: renamed from: b */
    private final SparseArray<Object> f10275b;

    /* JADX INFO: renamed from: c */
    private final SparseArray<Object> f10276c;

    /* JADX INFO: renamed from: d */
    private final SparseArray<Object> f10277d;

    /* JADX INFO: renamed from: a */
    protected void m9718a(boolean z) {
        this.f10274a = z;
    }

    /* JADX INFO: renamed from: a */
    long m9714a(C1776hn c1776hn) {
        if (c1776hn == null) {
            return 0L;
        }
        C1787hy c1787hyM9692a = c1776hn.m9692a();
        long jM4397a = this.f10229r.m4397a(c1776hn.m9698a(this.f10229r), c1787hyM9692a.m9723a(this.f10229r, c1787hyM9692a.m9724a().m9712h(this.f10229r)), c1787hyM9692a.m9725e() * c1787hyM9692a.m9724a().m9710a());
        c1776hn.m9693a(jM4397a);
        return jM4397a;
    }

    /* JADX INFO: renamed from: a */
    protected void m9716a(int i, C1776hn c1776hn, C1776hn c1776hn2, C1779hq c1779hq) {
        if (c1776hn == null && c1776hn2 == null) {
            throw new C1781hs("At least one of ain or aout is required to be non-null.");
        }
        long jA = c1776hn != null ? c1776hn.m9698a(this.f10229r) : 0L;
        long jA2 = c1776hn2 != null ? c1776hn2.m9698a(this.f10229r) : 0L;
        byte[] bArrM9713a = c1779hq != null ? c1779hq.m9713a() : null;
        if (this.f10274a) {
            this.f10229r.m4400a(m9698a(this.f10229r), i, m9714a(c1776hn), m9714a(c1776hn2), bArrM9713a, this.f10274a);
        } else {
            this.f10229r.m4400a(m9698a(this.f10229r), i, jA, jA2, bArrM9713a, this.f10274a);
        }
    }

    C1784hv(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.f10275b = new SparseArray<>();
        this.f10276c = new SparseArray<>();
        this.f10277d = new SparseArray<>();
        this.f10274a = false;
    }

    /* JADX INFO: renamed from: a */
    public void m9715a(int i, float f) {
        this.f10229r.m4399a(m9698a(this.f10229r), i, f, this.f10274a);
    }

    /* JADX INFO: renamed from: a */
    public void m9717a(int i, C1777ho c1777ho) {
        if (this.f10274a) {
            this.f10229r.m4401a(m9698a(this.f10229r), i, c1777ho == null ? 0L : m9714a((C1776hn) c1777ho), this.f10274a);
        } else {
            this.f10229r.m4401a(m9698a(this.f10229r), i, c1777ho != null ? c1777ho.m9698a(this.f10229r) : 0L, this.f10274a);
        }
    }
}
