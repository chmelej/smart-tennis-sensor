package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    private int f2037a;

    /* JADX INFO: renamed from: b */
    private int f2038b;

    /* JADX INFO: renamed from: c */
    private ViewPropertyAnimator f2039c;

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2209a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2037a = 0;
        this.f2038b = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2037a = 0;
        this.f2038b = 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2208a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f2037a = v.getMeasuredHeight();
        return super.mo2208a(coordinatorLayout, v, i);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo2206a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f2038b != 1 && i2 > 0) {
            mo2210b(v);
        } else {
            if (this.f2038b == 2 || i2 >= 0) {
                return;
            }
            mo2207a(v);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo2207a(V v) {
        if (this.f2039c != null) {
            this.f2039c.cancel();
            v.clearAnimation();
        }
        this.f2038b = 2;
        m2205a(v, 0, 225L, C2178v.f13002d);
    }

    /* JADX INFO: renamed from: b */
    protected void mo2210b(V v) {
        if (this.f2039c != null) {
            this.f2039c.cancel();
            v.clearAnimation();
        }
        this.f2038b = 1;
        m2205a(v, this.f2037a, 175L, C2178v.f13001c);
    }

    /* JADX INFO: renamed from: a */
    private void m2205a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f2039c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.f2039c = null;
            }
        });
    }
}
