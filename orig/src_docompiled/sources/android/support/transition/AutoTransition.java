package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        m2977s();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2977s();
    }

    /* JADX INFO: renamed from: s */
    private void m2977s() {
        m3103a(1);
        m3104a(new Fade(2)).m3104a(new ChangeBounds()).m3104a(new Fade(1));
    }
}
