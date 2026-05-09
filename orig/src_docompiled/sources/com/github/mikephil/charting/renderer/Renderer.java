package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public abstract class Renderer {
    protected ViewPortHandler mViewPortHandler;
    protected int mMinX = 0;
    protected int mMaxX = 0;

    protected boolean fitsBounds(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public void calcXBounds(BarLineScatterCandleDataProvider barLineScatterCandleDataProvider, int i) {
        int lowestVisibleXIndex = barLineScatterCandleDataProvider.getLowestVisibleXIndex();
        int highestVisibleXIndex = barLineScatterCandleDataProvider.getHighestVisibleXIndex();
        this.mMinX = Math.max(((lowestVisibleXIndex / i) * i) - (lowestVisibleXIndex % i == 0 ? i : 0), 0);
        this.mMaxX = Math.min(((highestVisibleXIndex / i) * i) + i, (int) barLineScatterCandleDataProvider.getXChartMax());
    }
}
