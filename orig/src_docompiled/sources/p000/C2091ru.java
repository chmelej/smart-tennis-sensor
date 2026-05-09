package p000;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: ru */
/* JADX INFO: compiled from: FadeInBitmapDisplayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2091ru implements InterfaceC2090rt {

    /* JADX INFO: renamed from: a */
    private final int f12615a;

    /* JADX INFO: renamed from: b */
    private final boolean f12616b;

    /* JADX INFO: renamed from: c */
    private final boolean f12617c;

    /* JADX INFO: renamed from: d */
    private final boolean f12618d;

    public C2091ru(int i) {
        this(i, true, true, true);
    }

    public C2091ru(int i, boolean z, boolean z2, boolean z3) {
        this.f12615a = i;
        this.f12616b = z;
        this.f12617c = z2;
        this.f12618d = z3;
    }

    @Override // p000.InterfaceC2090rt
    /* JADX INFO: renamed from: a */
    public void mo11479a(Bitmap bitmap, InterfaceC2095ry interfaceC2095ry, EnumC2080rj enumC2080rj) {
        interfaceC2095ry.mo11494a(bitmap);
        if ((this.f12616b && enumC2080rj == EnumC2080rj.NETWORK) || ((this.f12617c && enumC2080rj == EnumC2080rj.DISC_CACHE) || (this.f12618d && enumC2080rj == EnumC2080rj.MEMORY_CACHE))) {
            m11480a(interfaceC2095ry.mo11498d(), this.f12615a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11480a(View view, int i) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }
}
