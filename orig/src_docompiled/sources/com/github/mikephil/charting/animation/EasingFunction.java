package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public interface EasingFunction extends TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    float getInterpolation(float f);
}
