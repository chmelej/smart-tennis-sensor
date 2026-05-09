package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import p000.C1650cy;
import p000.C1651cz;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* JADX INFO: renamed from: a */
    private static final String[] f2825a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m3013d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m3013d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2825a;
    }

    /* JADX INFO: renamed from: d */
    private void m3013d(C1651cz c1651cz) {
        c1651cz.f9356a.put("android:changeScroll:x", Integer.valueOf(c1651cz.f9357b.getScrollX()));
        c1651cz.f9356a.put("android:changeScroll:y", Integer.valueOf(c1651cz.f9357b.getScrollY()));
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (c1651cz == null || c1651cz2 == null) {
            return null;
        }
        View view = c1651cz2.f9357b;
        int iIntValue = ((Integer) c1651cz.f9356a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) c1651cz2.f9356a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) c1651cz.f9356a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) c1651cz2.f9356a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return C1650cy.m8826a(objectAnimatorOfInt, objectAnimatorOfInt2);
    }
}
