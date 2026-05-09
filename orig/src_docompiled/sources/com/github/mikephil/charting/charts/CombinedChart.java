package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.BarDataProvider;
import com.github.mikephil.charting.interfaces.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.CandleDataProvider;
import com.github.mikephil.charting.interfaces.LineDataProvider;
import com.github.mikephil.charting.interfaces.ScatterDataProvider;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;
import com.github.mikephil.charting.utils.FillFormatter;

/* JADX INFO: loaded from: classes.dex */
public class CombinedChart extends BarLineChartBase<CombinedData> implements BarDataProvider, BubbleDataProvider, CandleDataProvider, LineDataProvider, ScatterDataProvider {
    private boolean mDrawBarShadow;
    private boolean mDrawHighlightArrow;
    protected DrawOrder[] mDrawOrder;
    private boolean mDrawValueAboveBar;
    private boolean mDrawValuesForWholeStack;
    protected FillFormatter mFillFormatter;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawHighlightArrow = false;
        this.mDrawValueAboveBar = true;
        this.mDrawValuesForWholeStack = true;
        this.mDrawBarShadow = false;
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mFillFormatter = new BarLineChartBase.DefaultFillFormatter();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        if (getBarData() == null && getCandleData() == null && getBubbleData() == null) {
            return;
        }
        this.mXChartMin = -0.5f;
        this.mXChartMax = ((CombinedData) this.mData).getXVals().size() - 0.5f;
        if (getBubbleData() != null) {
            for (T t : getBubbleData().getDataSets()) {
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

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(CombinedData combinedData) {
        super.setData(combinedData);
        this.mRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mRenderer.initBuffers();
    }

    @Override // com.github.mikephil.charting.interfaces.LineDataProvider
    public void setFillFormatter(FillFormatter fillFormatter) {
        if (fillFormatter == null) {
            new BarLineChartBase.DefaultFillFormatter();
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
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).getLineData();
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public BarData getBarData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).getBarData();
    }

    @Override // com.github.mikephil.charting.interfaces.ScatterDataProvider
    public ScatterData getScatterData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).getScatterData();
    }

    @Override // com.github.mikephil.charting.interfaces.CandleDataProvider
    public CandleData getCandleData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).getCandleData();
    }

    @Override // com.github.mikephil.charting.interfaces.BubbleDataProvider
    public BubbleData getBubbleData() {
        if (this.mData == 0) {
            return null;
        }
        return ((CombinedData) this.mData).getBubbleData();
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawHighlightArrowEnabled() {
        return this.mDrawHighlightArrow;
    }

    @Override // com.github.mikephil.charting.interfaces.BarDataProvider
    public boolean isDrawValuesForWholeStackEnabled() {
        return this.mDrawValuesForWholeStack;
    }

    public void setDrawHighlightArrow(boolean z) {
        this.mDrawHighlightArrow = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.mDrawValueAboveBar = z;
    }

    public void setDrawValuesForWholeStack(boolean z) {
        this.mDrawValuesForWholeStack = z;
    }

    public void setDrawBarShadow(boolean z) {
        this.mDrawBarShadow = z;
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.mDrawOrder = drawOrderArr;
    }
}
