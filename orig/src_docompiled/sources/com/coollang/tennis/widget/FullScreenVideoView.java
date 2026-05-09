package com.coollang.tennis.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenVideoView extends VideoView {
    public FullScreenVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FullScreenVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullScreenVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
    }
}
