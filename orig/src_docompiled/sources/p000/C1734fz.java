package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: fz */
/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class C1734fz implements InterfaceC1738gc {
    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9333a() {
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9338a(InterfaceC1737gb interfaceC1737gb, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        interfaceC1737gb.mo3519a(new C1754gs(colorStateList, f));
        View viewMo3523d = interfaceC1737gb.mo3523d();
        viewMo3523d.setClipToOutline(true);
        viewMo3523d.setElevation(f2);
        mo9341b(interfaceC1737gb, f3);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9337a(InterfaceC1737gb interfaceC1737gb, float f) {
        m9335j(interfaceC1737gb).m9516a(f);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: b */
    public void mo9341b(InterfaceC1737gb interfaceC1737gb, float f) {
        m9335j(interfaceC1737gb).m9517a(f, interfaceC1737gb.mo3520a(), interfaceC1737gb.mo3521b());
        mo9346f(interfaceC1737gb);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public float mo9336a(InterfaceC1737gb interfaceC1737gb) {
        return m9335j(interfaceC1737gb).m9515a();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: b */
    public float mo9340b(InterfaceC1737gb interfaceC1737gb) {
        return mo9344d(interfaceC1737gb) * 2.0f;
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: c */
    public float mo9342c(InterfaceC1737gb interfaceC1737gb) {
        return mo9344d(interfaceC1737gb) * 2.0f;
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: d */
    public float mo9344d(InterfaceC1737gb interfaceC1737gb) {
        return m9335j(interfaceC1737gb).m9519b();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: c */
    public void mo9343c(InterfaceC1737gb interfaceC1737gb, float f) {
        interfaceC1737gb.mo3523d().setElevation(f);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: e */
    public float mo9345e(InterfaceC1737gb interfaceC1737gb) {
        return interfaceC1737gb.mo3523d().getElevation();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: f */
    public void mo9346f(InterfaceC1737gb interfaceC1737gb) {
        if (!interfaceC1737gb.mo3520a()) {
            interfaceC1737gb.mo3518a(0, 0, 0, 0);
            return;
        }
        float fMo9336a = mo9336a(interfaceC1737gb);
        float fMo9344d = mo9344d(interfaceC1737gb);
        int iCeil = (int) Math.ceil(C1755gt.m9524b(fMo9336a, fMo9344d, interfaceC1737gb.mo3521b()));
        int iCeil2 = (int) Math.ceil(C1755gt.m9521a(fMo9336a, fMo9344d, interfaceC1737gb.mo3521b()));
        interfaceC1737gb.mo3518a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: g */
    public void mo9347g(InterfaceC1737gb interfaceC1737gb) {
        mo9341b(interfaceC1737gb, mo9336a(interfaceC1737gb));
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: h */
    public void mo9348h(InterfaceC1737gb interfaceC1737gb) {
        mo9341b(interfaceC1737gb, mo9336a(interfaceC1737gb));
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9339a(InterfaceC1737gb interfaceC1737gb, ColorStateList colorStateList) {
        m9335j(interfaceC1737gb).m9518a(colorStateList);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: i */
    public ColorStateList mo9349i(InterfaceC1737gb interfaceC1737gb) {
        return m9335j(interfaceC1737gb).m9520c();
    }

    /* JADX INFO: renamed from: j */
    private C1754gs m9335j(InterfaceC1737gb interfaceC1737gb) {
        return (C1754gs) interfaceC1737gb.mo3522c();
    }
}
