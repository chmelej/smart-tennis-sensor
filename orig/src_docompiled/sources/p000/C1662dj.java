package p000;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: renamed from: dj */
/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class C1662dj implements InterfaceC1663dk {

    /* JADX INFO: renamed from: a */
    private final ViewOverlay f9400a;

    C1662dj(View view) {
        this.f9400a = view.getOverlay();
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: a */
    public void mo8839a(Drawable drawable) {
        this.f9400a.add(drawable);
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: b */
    public void mo8840b(Drawable drawable) {
        this.f9400a.remove(drawable);
    }
}
