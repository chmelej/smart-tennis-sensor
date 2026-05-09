package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a */
    private int f2691a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2691a = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        m2927a(i, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m2927a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f2691a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f2691a;
    }
}
