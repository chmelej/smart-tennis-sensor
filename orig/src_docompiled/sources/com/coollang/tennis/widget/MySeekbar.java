package com.coollang.tennis.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
public class MySeekbar extends SeekBar {
    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public MySeekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MySeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MySeekbar(Context context) {
        super(context);
    }
}
