package com.coollang.tennis.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class CountView extends TextView {

    /* JADX INFO: renamed from: a */
    int f8233a;

    /* JADX INFO: renamed from: b */
    float f8234b;

    /* JADX INFO: renamed from: c */
    float f8235c;

    public CountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8233a = 1000;
        this.f8234b = 5.0f;
        this.f8235c = 0.0f;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void m8106a(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "number", (int) this.f8235c, i);
        objectAnimatorOfInt.setDuration(this.f8233a);
        objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfInt.start();
        this.f8235c = i;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void m8105a(float f) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "number", this.f8235c, f);
        objectAnimatorOfFloat.setDuration(this.f8233a);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.start();
        this.f8235c = f;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void m8107a(int i, int i2) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "number", (int) this.f8235c, i);
        objectAnimatorOfInt.setDuration(i2);
        objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfInt.start();
        this.f8235c = i;
    }

    public void setNumber(float f) {
        setText(String.format("%1$03.1f", Float.valueOf(f)));
    }

    public void setNumber(int i) {
        setText(Integer.toString(i));
    }
}
