package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererBarChart;
import com.github.mikephil.charting.utils.Highlight;

/* JADX INFO: loaded from: classes.dex */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean mDrawBarShadow;
    private boolean mDrawHighlightArrow;
    private boolean mDrawValueAboveBar;
    private boolean mDrawValuesForWholeStack;

    public BarChart(Context context) {
        super(context);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxisRenderer = new XAxisRendererBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
        this.mXChartMin = -0.5f;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.github.mikephil.charting.data.DataSet] */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        this.mDeltaX += 0.5f;
        this.mDeltaX *= ((BarData) this.mData).getDataSetCount();
        int entryCount = 0;
        for (int i = 0; i < ((BarData) this.mData).getDataSetCount(); i++) {
            ?? dataSetByIndex = ((BarData) this.mData).getDataSetByIndex(i);
            if (entryCount < dataSetByIndex.getEntryCount()) {
                entryCount = dataSetByIndex.getEntryCount();
            }
        }
        this.mDeltaX += entryCount * ((BarData) this.mData).getGroupSpace();
        this.mXChartMax = this.mDeltaX - this.mXChartMin;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mDataNotSet || this.mData == 0) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        float[] fArr = {f, f2};
        this.mLeftAxisTransformer.pixelsToValue(fArr);
        if (fArr[0] < this.mXChartMin || fArr[0] > this.mXChartMax) {
            return null;
        }
        return getHighlight(fArr[0], fArr[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Highlight getHighlight(double d, double d2) {
        int i;
        int i2;
        int dataSetCount = ((BarData) this.mData).getDataSetCount();
        int xValCount = ((BarData) this.mData).getXValCount();
        int i3 = 0;
        if (!((BarData) this.mData).isGrouped()) {
            int iRound = (int) Math.round(d);
            if (iRound < 0) {
                i = 0;
            } else {
                if (iRound >= xValCount) {
                    iRound = xValCount - 1;
                }
                i = iRound;
            }
        } else {
            float f = (float) d;
            int groupSpace = (int) (f / (dataSetCount + ((BarData) this.mData).getGroupSpace()));
            float groupSpace2 = ((BarData) this.mData).getGroupSpace() * groupSpace;
            float f2 = f - groupSpace2;
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "base: " + d + ", steps: " + groupSpace + ", groupSpaceSum: " + groupSpace2 + ", baseNoSpace: " + f2);
            }
            int i4 = (int) f2;
            int i5 = i4 % dataSetCount;
            int i6 = i4 / dataSetCount;
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "xIndex: " + i6 + ", dataSet: " + i5);
            }
            if (i6 < 0) {
                i2 = 0;
                i = 0;
            } else if (i6 >= xValCount) {
                i = xValCount - 1;
                i2 = dataSetCount - 1;
            } else {
                i = i6;
                i2 = i5;
            }
            if (i2 >= 0) {
                i3 = i2 >= dataSetCount ? dataSetCount - 1 : i2;
            }
        }
        if (!((BarDataSet) ((BarData) this.mData).getDataSetByIndex(i3)).isStacked()) {
            return new Highlight(i, i3);
        }
        return getStackedHighlight(i, i3, d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Highlight getStackedHighlight(int i, int i2, double d) {
        BarEntry barEntry = (BarEntry) ((BarDataSet) ((BarData) this.mData).getDataSetByIndex(i2)).getEntryForXIndex(i);
        if (barEntry != null) {
            return new Highlight(i, i2, barEntry.getClosestIndexAbove((float) d));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RectF getBarBounds(BarEntry barEntry) {
        BarDataSet barDataSet = (BarDataSet) ((BarData) this.mData).getDataSetForEntry(barEntry);
        if (barDataSet == null) {
            return null;
        }
        float barSpace = barDataSet.getBarSpace();
        float val = barEntry.getVal();
        float xIndex = barEntry.getXIndex();
        float f = barSpace / 2.0f;
        RectF rectF = new RectF((xIndex - 0.5f) + f, val >= 0.0f ? val : 0.0f, (xIndex + 0.5f) - f, val <= 0.0f ? val : 0.0f);
        getTransformer(barDataSet.getAxisDependency()).rectValueToPixel(rectF);
        return rectF;
    }

    public void setDrawHighlightArrow(boolean z) {
        this.mDrawHighlightArrow = z;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawHighlightArrowEnabled() {
        return this.mDrawHighlightArrow;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.mDrawValueAboveBar = z;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    public void setDrawValuesForWholeStack(boolean z) {
        this.mDrawValuesForWholeStack = z;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawValuesForWholeStackEnabled() {
        return this.mDrawValuesForWholeStack;
    }

    public void setDrawBarShadow(boolean z) {
        this.mDrawBarShadow = z;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public int getLowestVisibleXIndex() {
        float dataSetCount = ((BarData) this.mData).getDataSetCount();
        float groupSpace = dataSetCount <= 1.0f ? 1.0f : dataSetCount + ((BarData) this.mData).getGroupSpace();
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return (int) (fArr[0] <= getXChartMin() ? 0.0f : (fArr[0] / groupSpace) + 1.0f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public int getHighestVisibleXIndex() {
        float dataSetCount = ((BarData) this.mData).getDataSetCount();
        float groupSpace = dataSetCount > 1.0f ? ((BarData) this.mData).getGroupSpace() + dataSetCount : 1.0f;
        float[] fArr = {this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return (int) ((fArr[0] >= getXChartMax() ? getXChartMax() : fArr[0]) / groupSpace);
    }
}
