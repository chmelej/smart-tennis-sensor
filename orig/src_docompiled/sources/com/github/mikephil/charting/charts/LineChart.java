package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.LineDataProvider;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.FillFormatter;

/* JADX INFO: loaded from: classes.dex */
public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    private FillFormatter mFillFormatter;

    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new LineChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mFillFormatter = new BarLineChartBase.DefaultFillFormatter(this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        if (this.mDeltaX != 0.0f || ((LineData) this.mData).getYValCount() <= 0) {
            return;
        }
        this.mDeltaX = 1.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.LineDataProvider
    public void setFillFormatter(FillFormatter fillFormatter) {
        if (fillFormatter == null) {
            new BarLineChartBase.DefaultFillFormatter(this);
        } else {
            this.mFillFormatter = fillFormatter;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.LineDataProvider
    public FillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.LineDataProvider
    public LineData getLineData() {
        return (LineData) this.mData;
    }
}
