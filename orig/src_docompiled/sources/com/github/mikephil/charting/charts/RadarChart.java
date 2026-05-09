package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes.dex */
public class RadarChart extends PieRadarChartBase<RadarData> {
    private boolean mDrawWeb;
    private float mInnerWebLineWidth;
    private int mWebAlpha;
    private int mWebColor;
    private int mWebColorInner;
    private float mWebLineWidth;
    private XAxis mXAxis;
    protected XAxisRendererRadarChart mXAxisRenderer;
    private YAxis mYAxis;
    protected YAxisRendererRadarChart mYAxisRenderer;

    public RadarChart(Context context) {
        super(context);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
        this.mXAxis = new XAxis();
        this.mXAxis.setSpaceBetweenLabels(0);
        this.mWebLineWidth = Utils.convertDpToPixel(1.5f);
        this.mInnerWebLineWidth = Utils.convertDpToPixel(0.75f);
        this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.mYAxis, this);
        this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        float yMin = ((RadarData) this.mData).getYMin(YAxis.AxisDependency.LEFT);
        float yMax = ((RadarData) this.mData).getYMax(YAxis.AxisDependency.LEFT);
        this.mXChartMax = ((RadarData) this.mData).getXVals().size() - 1;
        this.mDeltaX = Math.abs(this.mXChartMax - this.mXChartMin);
        float fAbs = Math.abs(yMax - (this.mYAxis.isStartAtZeroEnabled() ? 0.0f : yMin)) / 100.0f;
        float spaceTop = this.mYAxis.getSpaceTop() * fAbs;
        float spaceBottom = fAbs * this.mYAxis.getSpaceBottom();
        this.mXChartMax = ((RadarData) this.mData).getXVals().size() - 1;
        this.mDeltaX = Math.abs(this.mXChartMax - this.mXChartMin);
        this.mYAxis.mAxisMaximum = !Float.isNaN(this.mYAxis.getAxisMaxValue()) ? this.mYAxis.getAxisMaxValue() : yMax + spaceTop;
        this.mYAxis.mAxisMinimum = !Float.isNaN(this.mYAxis.getAxisMinValue()) ? this.mYAxis.getAxisMinValue() : yMin - spaceBottom;
        if (this.mYAxis.isStartAtZeroEnabled()) {
            this.mYAxis.mAxisMinimum = 0.0f;
        }
        this.mYAxis.mAxisRange = Math.abs(this.mYAxis.mAxisMaximum - this.mYAxis.mAxisMinimum);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Entry entry, int i) {
        float sliceAngle = (getSliceAngle() * entry.getXIndex()) + getRotationAngle();
        float val = entry.getVal() * getFactor();
        PointF centerOffsets = getCenterOffsets();
        double d = val;
        double d2 = sliceAngle;
        PointF pointF = new PointF((float) (((double) centerOffsets.x) + (Math.cos(Math.toRadians(d2)) * d)), (float) (((double) centerOffsets.y) + (d * Math.sin(Math.toRadians(d2)))));
        return new float[]{pointF.x, pointF.y};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mDataNotSet) {
            return;
        }
        calcMinMax();
        if (this.mYAxis.needsDefaultFormatter()) {
            this.mYAxis.setValueFormatter(this.mDefaultFormatter);
        }
        this.mYAxisRenderer.computeAxis(this.mYAxis.mAxisMinimum, this.mYAxis.mAxisMaximum);
        this.mXAxisRenderer.computeAxis(((RadarData) this.mData).getXValAverageLength(), ((RadarData) this.mData).getXVals());
        if (this.mLegend != null && !this.mLegend.isLegendCustom()) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDataNotSet) {
            return;
        }
        this.mXAxisRenderer.renderAxisLabels(canvas);
        if (this.mDrawWeb) {
            this.mRenderer.drawExtras(canvas);
        }
        this.mYAxisRenderer.renderLimitLines(canvas);
        this.mRenderer.drawData(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHightlight);
        }
        this.mYAxisRenderer.renderAxisLabels(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public float getFactor() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f) / this.mYAxis.mAxisRange;
    }

    public float getSliceAngle() {
        return 360.0f / ((RadarData) this.mData).getXValCount();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float normalizedAngle = Utils.getNormalizedAngle(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int i = 0;
        while (i < ((RadarData) this.mData).getXValCount()) {
            int i2 = i + 1;
            if ((i2 * sliceAngle) - (sliceAngle / 2.0f) > normalizedAngle) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    public YAxis getYAxis() {
        return this.mYAxis;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public void setWebLineWidth(float f) {
        this.mWebLineWidth = Utils.convertDpToPixel(f);
    }

    public float getWebLineWidth() {
        return this.mWebLineWidth;
    }

    public void setWebLineWidthInner(float f) {
        this.mInnerWebLineWidth = Utils.convertDpToPixel(f);
    }

    public float getWebLineWidthInner() {
        return this.mInnerWebLineWidth;
    }

    public void setWebAlpha(int i) {
        this.mWebAlpha = i;
    }

    public int getWebAlpha() {
        return this.mWebAlpha;
    }

    public void setWebColor(int i) {
        this.mWebColor = i;
    }

    public int getWebColor() {
        return this.mWebColor;
    }

    public void setWebColorInner(int i) {
        this.mWebColorInner = i;
    }

    public int getWebColorInner() {
        return this.mWebColorInner;
    }

    public void setDrawWeb(boolean z) {
        this.mDrawWeb = z;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBottomOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 4.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return this.mXAxis.isEnabled() ? this.mXAxis.mLabelWidth : Utils.convertDpToPixel(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMax() {
        return this.mYAxis.mAxisMaximum;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMin() {
        return this.mYAxis.mAxisMinimum;
    }

    public float getYRange() {
        return this.mYAxis.mAxisRange;
    }
}
