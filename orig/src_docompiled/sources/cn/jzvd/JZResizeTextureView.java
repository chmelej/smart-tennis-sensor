package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* JADX INFO: loaded from: classes.dex */
public class JZResizeTextureView extends TextureView {

    /* JADX INFO: renamed from: a */
    public int f5387a;

    /* JADX INFO: renamed from: b */
    public int f5388b;

    public JZResizeTextureView(Context context) {
        super(context);
        this.f5387a = 0;
        this.f5388b = 0;
        this.f5387a = 0;
        this.f5388b = 0;
    }

    public JZResizeTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5387a = 0;
        this.f5388b = 0;
        this.f5387a = 0;
        this.f5388b = 0;
    }

    public void setVideoSize(int i, int i2) {
        if (this.f5387a == i && this.f5388b == i2) {
            return;
        }
        this.f5387a = i;
        this.f5388b = i2;
        requestLayout();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0146  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jzvd.JZResizeTextureView.onMeasure(int, int):void");
    }
}
