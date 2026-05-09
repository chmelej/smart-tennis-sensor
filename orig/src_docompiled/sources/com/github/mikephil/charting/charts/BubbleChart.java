package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.BubbleDataProvider;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;

/* JADX INFO: loaded from: classes.dex */
public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {
    public BubbleChart(Context context) {
        super(context);
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new BubbleChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        if (this.mDeltaX == 0.0f && ((BubbleData) this.mData).getYValCount() > 0) {
            this.mDeltaX = 1.0f;
        }
        this.mXChartMin = -0.5f;
        this.mXChartMax = ((BubbleData) this.mData).getXValCount() - 0.5f;
        if (this.mRenderer != null) {
            for (T t : ((BubbleData) this.mData).getDataSets()) {
                float xMin = t.getXMin();
                float xMax = t.getXMax();
                if (xMin < this.mXChartMin) {
                    this.mXChartMin = xMin;
                }
                if (xMax > this.mXChartMax) {
                    this.mXChartMax = xMax;
                }
            }
        }
        this.mDeltaX = Math.abs(this.mXChartMax - this.mXChartMin);
    }

    @Override // com.github.mikephil.charting.interfaces.BubbleDataProvider
    public BubbleData getBubbleData() {
        return (BubbleData) this.mData;
    }
}
