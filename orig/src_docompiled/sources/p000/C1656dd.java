package p000;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: renamed from: dd */
/* JADX INFO: compiled from: ViewGroupOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class C1656dd implements InterfaceC1657de {

    /* JADX INFO: renamed from: a */
    private final ViewGroupOverlay f9373a;

    C1656dd(ViewGroup viewGroup) {
        this.f9373a = viewGroup.getOverlay();
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: a */
    public void mo8839a(Drawable drawable) {
        this.f9373a.add(drawable);
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: b */
    public void mo8840b(Drawable drawable) {
        this.f9373a.remove(drawable);
    }

    @Override // p000.InterfaceC1657de
    /* JADX INFO: renamed from: a */
    public void mo8837a(View view) {
        this.f9373a.add(view);
    }

    @Override // p000.InterfaceC1657de
    /* JADX INFO: renamed from: b */
    public void mo8838b(View view) {
        this.f9373a.remove(view);
    }
}
