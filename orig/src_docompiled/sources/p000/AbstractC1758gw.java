package p000;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: renamed from: gw */
/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1758gw extends RecyclerView.AbstractC0608f {

    /* JADX INFO: renamed from: h */
    boolean f10097h = true;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo9418a(RecyclerView.AbstractC0624v abstractC0624v);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo9419a(RecyclerView.AbstractC0624v abstractC0624v, int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo9420a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0624v abstractC0624v2, int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo9422b(RecyclerView.AbstractC0624v abstractC0624v);

    /* JADX INFO: renamed from: c */
    public void m9553c(RecyclerView.AbstractC0624v abstractC0624v, boolean z) {
    }

    /* JADX INFO: renamed from: d */
    public void m9554d(RecyclerView.AbstractC0624v abstractC0624v, boolean z) {
    }

    /* JADX INFO: renamed from: o */
    public void m9561o(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    /* JADX INFO: renamed from: p */
    public void m9562p(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    /* JADX INFO: renamed from: q */
    public void m9563q(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    /* JADX INFO: renamed from: r */
    public void m9564r(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    /* JADX INFO: renamed from: s */
    public void m9565s(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    /* JADX INFO: renamed from: t */
    public void m9566t(RecyclerView.AbstractC0624v abstractC0624v) {
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: h */
    public boolean mo3904h(RecyclerView.AbstractC0624v abstractC0624v) {
        return !this.f10097h || abstractC0624v.m4143n();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: a */
    public boolean mo3890a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2) {
        int i = cVar.f3739a;
        int i2 = cVar.f3740b;
        View view = abstractC0624v.f3823a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3739a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3740b;
        if (!abstractC0624v.m4146q() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return mo9419a(abstractC0624v, i, i2, left, top);
        }
        return mo9418a(abstractC0624v);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: b */
    public boolean mo3894b(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2) {
        if (cVar != null && (cVar.f3739a != cVar2.f3739a || cVar.f3740b != cVar2.f3740b)) {
            return mo9419a(abstractC0624v, cVar.f3739a, cVar.f3740b, cVar2.f3739a, cVar2.f3740b);
        }
        return mo9422b(abstractC0624v);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: c */
    public boolean mo3895c(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2) {
        if (cVar.f3739a != cVar2.f3739a || cVar.f3740b != cVar2.f3740b) {
            return mo9419a(abstractC0624v, cVar.f3739a, cVar.f3740b, cVar2.f3739a, cVar2.f3740b);
        }
        m9556j(abstractC0624v);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: a */
    public boolean mo3891a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0624v abstractC0624v2, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f3739a;
        int i4 = cVar.f3740b;
        if (abstractC0624v2.m4132c()) {
            int i5 = cVar.f3739a;
            i2 = cVar.f3740b;
            i = i5;
        } else {
            i = cVar2.f3739a;
            i2 = cVar2.f3740b;
        }
        return mo9420a(abstractC0624v, abstractC0624v2, i3, i4, i, i2);
    }

    /* JADX INFO: renamed from: i */
    public final void m9555i(RecyclerView.AbstractC0624v abstractC0624v) {
        m9562p(abstractC0624v);
        m3900f(abstractC0624v);
    }

    /* JADX INFO: renamed from: j */
    public final void m9556j(RecyclerView.AbstractC0624v abstractC0624v) {
        m9566t(abstractC0624v);
        m3900f(abstractC0624v);
    }

    /* JADX INFO: renamed from: k */
    public final void m9557k(RecyclerView.AbstractC0624v abstractC0624v) {
        m9564r(abstractC0624v);
        m3900f(abstractC0624v);
    }

    /* JADX INFO: renamed from: a */
    public final void m9551a(RecyclerView.AbstractC0624v abstractC0624v, boolean z) {
        m9554d(abstractC0624v, z);
        m3900f(abstractC0624v);
    }

    /* JADX INFO: renamed from: l */
    public final void m9558l(RecyclerView.AbstractC0624v abstractC0624v) {
        m9561o(abstractC0624v);
    }

    /* JADX INFO: renamed from: m */
    public final void m9559m(RecyclerView.AbstractC0624v abstractC0624v) {
        m9565s(abstractC0624v);
    }

    /* JADX INFO: renamed from: n */
    public final void m9560n(RecyclerView.AbstractC0624v abstractC0624v) {
        m9563q(abstractC0624v);
    }

    /* JADX INFO: renamed from: b */
    public final void m9552b(RecyclerView.AbstractC0624v abstractC0624v, boolean z) {
        m9553c(abstractC0624v, z);
    }
}
