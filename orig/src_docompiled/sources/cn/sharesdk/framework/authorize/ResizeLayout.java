package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ResizeLayout extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private OnResizeListener f5545a;

    public interface OnResizeListener {
        void OnResize(int i, int i2, int i3, int i4);
    }

    /* JADX INFO: renamed from: a */
    public void m5981a(OnResizeListener onResizeListener) {
        this.f5545a = onResizeListener;
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f5545a != null) {
            this.f5545a.OnResize(i, i2, i3, i4);
        }
    }
}
