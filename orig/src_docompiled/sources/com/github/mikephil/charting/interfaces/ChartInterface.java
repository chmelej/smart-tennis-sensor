package com.github.mikephil.charting.interfaces;

import android.graphics.PointF;
import android.graphics.RectF;
import com.github.mikephil.charting.utils.ValueFormatter;

/* JADX INFO: loaded from: classes.dex */
public interface ChartInterface {
    PointF getCenterOfView();

    PointF getCenterOffsets();

    RectF getContentRect();

    ValueFormatter getDefaultValueFormatter();

    int getHeight();

    int getWidth();

    float getXChartMax();

    float getXChartMin();

    int getXValCount();

    float getYChartMax();

    float getYChartMin();
}
