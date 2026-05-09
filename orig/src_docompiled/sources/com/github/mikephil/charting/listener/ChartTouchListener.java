package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.utils.Highlight;

/* JADX INFO: loaded from: classes.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    protected static final int DRAG = 1;
    protected static final int NONE = 0;
    protected static final int PINCH_ZOOM = 4;
    protected static final int POST_ZOOM = 5;
    protected static final int ROTATE = 6;
    protected static final int X_ZOOM = 2;
    protected static final int Y_ZOOM = 3;
    protected T mChart;
    protected GestureDetector mGestureDetector;
    protected Highlight mLastHighlighted;
    protected int mTouchMode = 0;

    public ChartTouchListener(T t) {
        this.mChart = t;
        this.mGestureDetector = new GestureDetector(t.getContext(), this);
    }

    public void setLastHighlighted(Highlight highlight) {
        this.mLastHighlighted = highlight;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    protected static float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
