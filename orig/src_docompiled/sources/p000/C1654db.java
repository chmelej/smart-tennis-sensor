package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.support.transition.R;
import android.util.Property;
import android.view.View;

/* JADX INFO: renamed from: db */
/* JADX INFO: compiled from: TranslationAnimationCreator.java */
/* JADX INFO: loaded from: classes.dex */
public class C1654db {
    /* JADX INFO: renamed from: a */
    public static Animator m8835a(View view, C1651cz c1651cz, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) c1651cz.f9357b.getTag(R.id.transition_position)) != null) {
            f5 = (r8[0] - i) + translationX;
            f6 = (r8[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int iRound = i + Math.round(f5 - translationX);
        int iRound2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f4));
        a aVar = new a(view, c1651cz.f9357b, iRound, iRound2, translationX, translationY);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        C0791cf.m5780a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: db$a */
    /* JADX INFO: compiled from: TranslationAnimationCreator.java */
    static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        private final View f9364a;

        /* JADX INFO: renamed from: b */
        private final View f9365b;

        /* JADX INFO: renamed from: c */
        private final int f9366c;

        /* JADX INFO: renamed from: d */
        private final int f9367d;

        /* JADX INFO: renamed from: e */
        private int[] f9368e;

        /* JADX INFO: renamed from: f */
        private float f9369f;

        /* JADX INFO: renamed from: g */
        private float f9370g;

        /* JADX INFO: renamed from: h */
        private final float f9371h;

        /* JADX INFO: renamed from: i */
        private final float f9372i;

        a(View view, View view2, int i, int i2, float f, float f2) {
            this.f9365b = view;
            this.f9364a = view2;
            this.f9366c = i - Math.round(this.f9365b.getTranslationX());
            this.f9367d = i2 - Math.round(this.f9365b.getTranslationY());
            this.f9371h = f;
            this.f9372i = f2;
            this.f9368e = (int[]) this.f9364a.getTag(R.id.transition_position);
            if (this.f9368e != null) {
                this.f9364a.setTag(R.id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f9368e == null) {
                this.f9368e = new int[2];
            }
            this.f9368e[0] = Math.round(this.f9366c + this.f9365b.getTranslationX());
            this.f9368e[1] = Math.round(this.f9367d + this.f9365b.getTranslationY());
            this.f9364a.setTag(R.id.transition_position, this.f9368e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9365b.setTranslationX(this.f9371h);
            this.f9365b.setTranslationY(this.f9372i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f9369f = this.f9365b.getTranslationX();
            this.f9370g = this.f9365b.getTranslationY();
            this.f9365b.setTranslationX(this.f9371h);
            this.f9365b.setTranslationY(this.f9372i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f9365b.setTranslationX(this.f9369f);
            this.f9365b.setTranslationY(this.f9370g);
        }
    }
}
