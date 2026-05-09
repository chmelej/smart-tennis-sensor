package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import p000.InterfaceC0194am;

/* JADX INFO: renamed from: ak */
/* JADX INFO: compiled from: CircularRevealCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0175ak {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static Animator m1695a(InterfaceC0194am interfaceC0194am, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(interfaceC0194am, (Property<InterfaceC0194am, V>) InterfaceC0194am.b.f1692a, (TypeEvaluator) InterfaceC0194am.a.f1690a, (Object[]) new InterfaceC0194am.d[]{new InterfaceC0194am.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return objectAnimatorOfObject;
        }
        InterfaceC0194am.d revealInfo = interfaceC0194am.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) interfaceC0194am, (int) f, (int) f2, revealInfo.f1696c, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    /* JADX INFO: renamed from: a */
    public static Animator.AnimatorListener m1694a(final InterfaceC0194am interfaceC0194am) {
        return new AnimatorListenerAdapter() { // from class: ak.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                interfaceC0194am.mo1912a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                interfaceC0194am.mo1913b();
            }
        };
    }
}
