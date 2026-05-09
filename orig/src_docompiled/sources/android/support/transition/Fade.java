package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import p000.C1646cu;
import p000.C1647cv;
import p000.C1651cz;
import p000.C1664dl;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int i) {
        m3118b(i);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9337f);
        m3118b(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, m3119r()));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        super.mo2981a(c1651cz);
        c1651cz.f9356a.put("android:fade:transitionAlpha", Float.valueOf(C1664dl.m8868c(c1651cz.f9357b)));
    }

    /* JADX INFO: renamed from: a */
    private Animator m3038a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C1664dl.m8862a(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, C1664dl.f9401a, f2);
        objectAnimatorOfFloat.addListener(new C0350a(view));
        mo3064a(new C1647cv() { // from class: android.support.transition.Fade.1
            @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: a */
            public void mo2987a(Transition transition) {
                C1664dl.m8862a(view, 1.0f);
                C1664dl.m8871e(view);
                transition.mo3078b(this);
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo3035a(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        float fM3037a = m3037a(c1651cz, 0.0f);
        return m3038a(view, fM3037a != 1.0f ? fM3037a : 0.0f, 1.0f);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo3036b(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        C1664dl.m8870d(view);
        return m3038a(view, m3037a(c1651cz, 1.0f), 0.0f);
    }

    /* JADX INFO: renamed from: a */
    private static float m3037a(C1651cz c1651cz, float f) {
        Float f2;
        return (c1651cz == null || (f2 = (Float) c1651cz.f9356a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX INFO: renamed from: android.support.transition.Fade$a */
    static class C0350a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        private final View f2861a;

        /* JADX INFO: renamed from: b */
        private boolean f2862b = false;

        C0350a(View view) {
            this.f2861a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.f2861a) && this.f2861a.getLayerType() == 0) {
                this.f2862b = true;
                this.f2861a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1664dl.m8862a(this.f2861a, 1.0f);
            if (this.f2862b) {
                this.f2861a.setLayerType(0, null);
            }
        }
    }
}
