package p000;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.Transition;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: renamed from: as */
/* JADX INFO: compiled from: TextScale.java */
/* JADX INFO: loaded from: classes.dex */
public class C0744as extends Transition {
    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m5311d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m5311d(c1651cz);
    }

    /* JADX INFO: renamed from: d */
    private void m5311d(C1651cz c1651cz) {
        if (c1651cz.f9357b instanceof TextView) {
            c1651cz.f9356a.put("android:textscale:scale", Float.valueOf(((TextView) c1651cz.f9357b).getScaleX()));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null || c1651cz2 == null || !(c1651cz.f9357b instanceof TextView) || !(c1651cz2.f9357b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) c1651cz2.f9357b;
        Map<String, Object> map = c1651cz.f9356a;
        Map<String, Object> map2 = c1651cz2.f9356a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: as.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}
