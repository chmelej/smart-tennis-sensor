package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarChart extends BarChart {
    public HorizontalBarChart(Context context) {
        super(context);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void calculateOffsets() {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.HorizontalBarChart.calculateOffsets():void");
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void prepareValuePxMatrix() {
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisRange, this.mDeltaX, this.mXChartMin);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisRange, this.mDeltaX, this.mXChartMin);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void calcModulus() {
        this.mViewPortHandler.getMatrixTouch().getValues(new float[9]);
        this.mXAxis.mAxisLabelModulus = (int) Math.ceil((((BarData) this.mData).getXValCount() * this.mXAxis.mLabelHeight) / (this.mViewPortHandler.contentHeight() * r0[4]));
        if (this.mXAxis.mAxisLabelModulus < 1) {
            this.mXAxis.mAxisLabelModulus = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.charts.BarChart
    public RectF getBarBounds(BarEntry barEntry) {
        BarDataSet barDataSet = (BarDataSet) ((BarData) this.mData).getDataSetForEntry(barEntry);
        if (barDataSet == null) {
            return null;
        }
        float barSpace = barDataSet.getBarSpace();
        float val = barEntry.getVal();
        float xIndex = barEntry.getXIndex();
        float f = barSpace / 2.0f;
        RectF rectF = new RectF(val >= 0.0f ? val : 0.0f, (xIndex - 0.5f) + f, val <= 0.0f ? val : 0.0f, (xIndex + 0.5f) - f);
        getTransformer(barDataSet.getAxisDependency()).rectValueToPixel(rectF);
        return rectF;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {entry.getVal(), entry.getXIndex()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase
    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mDataNotSet || this.mData == 0) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        float[] fArr = {f, f2};
        this.mLeftAxisTransformer.pixelsToValue(fArr);
        if (fArr[1] < this.mXChartMin || fArr[1] > this.mXChartMax) {
            return null;
        }
        return getHighlight(fArr[1], fArr[0]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public int getLowestVisibleXIndex() {
        float dataSetCount = ((BarData) this.mData).getDataSetCount();
        float groupSpace = dataSetCount <= 1.0f ? 1.0f : dataSetCount + ((BarData) this.mData).getGroupSpace();
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return (int) ((fArr[1] > 0.0f ? fArr[1] / groupSpace : 0.0f) + 1.0f);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public int getHighestVisibleXIndex() {
        float dataSetCount = ((BarData) this.mData).getDataSetCount();
        float groupSpace = dataSetCount > 1.0f ? ((BarData) this.mData).getGroupSpace() + dataSetCount : 1.0f;
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return (int) ((fArr[1] >= getXChartMax() ? getXChartMax() : fArr[1]) / groupSpace);
    }
}
