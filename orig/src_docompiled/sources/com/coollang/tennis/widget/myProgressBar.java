package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class myProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a */
    private ValueAnimator f8870a;

    /* JADX INFO: renamed from: b */
    private int f8871b;

    public myProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8871b = 50;
    }

    public myProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8871b = 50;
    }

    public myProgressBar(Context context) {
        super(context);
        this.f8871b = 50;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m8369a(float f, float f2) {
        this.f8870a = ValueAnimator.ofFloat(f, f2);
        this.f8870a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.myProgressBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                myProgressBar.this.f8871b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                myProgressBar.this.postInvalidate();
            }
        });
        this.f8870a.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f8870a.setDuration(2000L);
        this.f8870a.start();
    }

    public void setMyProgress(int i, int i2) {
        m8369a(i, i2);
    }
}
