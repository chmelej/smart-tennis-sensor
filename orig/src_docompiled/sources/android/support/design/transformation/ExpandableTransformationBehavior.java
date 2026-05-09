package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: a */
    private AnimatorSet f2273a;

    /* JADX INFO: renamed from: b */
    protected abstract AnimatorSet mo2491b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableBehavior
    /* JADX INFO: renamed from: a */
    protected boolean mo2488a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f2273a != null;
        if (z3) {
            this.f2273a.cancel();
        }
        this.f2273a = mo2491b(view, view2, z, z3);
        this.f2273a.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.f2273a = null;
            }
        });
        this.f2273a.start();
        if (!z2) {
            this.f2273a.end();
        }
        return true;
    }
}
