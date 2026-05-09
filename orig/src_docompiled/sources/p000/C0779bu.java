package p000;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: renamed from: bu */
/* JADX INFO: compiled from: ViewUtilsLollipop.java */
/* JADX INFO: loaded from: classes.dex */
public class C0779bu {

    /* JADX INFO: renamed from: a */
    private static final int[] f5303a = {R.attr.stateListAnimator};

    /* JADX INFO: renamed from: a */
    public static void m5713a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* JADX INFO: renamed from: a */
    public static void m5715a(View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, f5303a, i, i2, new int[0]);
        try {
            if (typedArrayM5390a.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayM5390a.getResourceId(0, 0)));
            }
        } finally {
            typedArrayM5390a.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5714a(View view, float f) {
        int integer = view.getResources().getInteger(android.support.design.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, android.support.design.R.attr.state_liftable, -android.support.design.R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
