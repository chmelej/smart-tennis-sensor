package p000;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: xi */
/* JADX INFO: compiled from: DeferredRequestCreator.java */
/* JADX INFO: loaded from: classes.dex */
class ViewTreeObserverOnPreDrawListenerC2241xi implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a */
    final C2257xy f13493a;

    /* JADX INFO: renamed from: b */
    final WeakReference<ImageView> f13494b;

    /* JADX INFO: renamed from: c */
    InterfaceC2238xf f13495c;

    ViewTreeObserverOnPreDrawListenerC2241xi(C2257xy c2257xy, ImageView imageView, InterfaceC2238xf interfaceC2238xf) {
        this.f13493a = c2257xy;
        this.f13494b = new WeakReference<>(imageView);
        this.f13495c = interfaceC2238xf;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f13494b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width <= 0 || height <= 0) {
            return true;
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        this.f13493a.m12344a().m12346a(width, height).m12349a(imageView, this.f13495c);
        return true;
    }

    /* JADX INFO: renamed from: a */
    void m12259a() {
        this.f13495c = null;
        ImageView imageView = this.f13494b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }
}
