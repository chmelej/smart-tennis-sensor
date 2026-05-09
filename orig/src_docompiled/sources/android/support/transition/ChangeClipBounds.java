package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import p000.C1643cr;
import p000.C1651cz;
import p000.C1664dl;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* JADX INFO: renamed from: a */
    private static final String[] f2818a = {"android:clipBounds:clip"};

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2818a;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    private void m3003d(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clipBounds = ViewCompat.getClipBounds(view);
        c1651cz.f9356a.put("android:clipBounds:clip", clipBounds);
        if (clipBounds == null) {
            c1651cz.f9356a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m3003d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m3003d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null || c1651cz2 == null || !c1651cz.f9356a.containsKey("android:clipBounds:clip") || !c1651cz2.f9356a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) c1651cz.f9356a.get("android:clipBounds:clip");
        Rect rect2 = (Rect) c1651cz2.f9356a.get("android:clipBounds:clip");
        boolean z = rect2 == null;
        if (rect == null && rect2 == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) c1651cz.f9356a.get("android:clipBounds:bounds");
        } else if (rect2 == null) {
            rect2 = (Rect) c1651cz2.f9356a.get("android:clipBounds:bounds");
        }
        if (rect.equals(rect2)) {
            return null;
        }
        ViewCompat.setClipBounds(c1651cz2.f9357b, rect);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(c1651cz2.f9357b, (Property<View, V>) C1664dl.f9402b, (TypeEvaluator) new C1643cr(new Rect()), (Object[]) new Rect[]{rect, rect2});
        if (z) {
            final View view = c1651cz2.f9357b;
            objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeClipBounds.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewCompat.setClipBounds(view, null);
                }
            });
        }
        return objectAnimatorOfObject;
    }
}
