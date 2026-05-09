package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p000.C0006ad;
import p000.C2205w;

/* JADX INFO: loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a */
    private final C0006ad f2292a;

    /* JADX INFO: renamed from: b */
    private final C0006ad f2293b;

    public FabTransformationScrimBehavior() {
        this.f2292a = new C0006ad(75L, 150L);
        this.f2293b = new C0006ad(0L, 150L);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2292a = new C0006ad(75L, 150L);
        this.f2293b = new C0006ad(0L, 150L);
    }

    @Override // android.support.design.transformation.ExpandableBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2487a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2513a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.mo2513a(coordinatorLayout, view, motionEvent);
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    /* JADX INFO: renamed from: b */
    protected AnimatorSet mo2491b(View view, final View view2, final boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        m2512a(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        C2205w.m12083a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.transformation.FabTransformationScrimBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: renamed from: a */
    private void m2512a(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        C0006ad c0006ad = z ? this.f2292a : this.f2293b;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        c0006ad.m296a((Animator) objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }
}
