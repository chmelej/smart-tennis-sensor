package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.CandleBodyBuffer;
import com.github.mikephil.charting.buffer.CandleShadowBuffer;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.CandleDataProvider;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CandleStickChartRenderer extends DataRenderer {
    private CandleBodyBuffer[] mBodyBuffers;
    protected CandleDataProvider mChart;
    private CandleShadowBuffer[] mShadowBuffers;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = candleDataProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        CandleData candleData = this.mChart.getCandleData();
        this.mShadowBuffers = new CandleShadowBuffer[candleData.getDataSetCount()];
        this.mBodyBuffers = new CandleBodyBuffer[candleData.getDataSetCount()];
        for (int i = 0; i < this.mShadowBuffers.length; i++) {
            CandleDataSet candleDataSet = (CandleDataSet) candleData.getDataSetByIndex(i);
            this.mShadowBuffers[i] = new CandleShadowBuffer(candleDataSet.getValueCount() * 4);
            this.mBodyBuffers[i] = new CandleBodyBuffer(candleDataSet.getValueCount() * 4);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getCandleData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, CandleDataSet candleDataSet) {
        Transformer transformer = this.mChart.getTransformer(candleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        int indexOfDataSet = this.mChart.getCandleData().getIndexOfDataSet(candleDataSet);
        List<CandleEntry> yVals = candleDataSet.getYVals();
        Entry entryForXIndex = candleDataSet.getEntryForXIndex(this.mMinX);
        Entry entryForXIndex2 = candleDataSet.getEntryForXIndex(this.mMaxX);
        int iMax = Math.max(candleDataSet.getEntryPosition(entryForXIndex), 0);
        int iMin = Math.min(candleDataSet.getEntryPosition(entryForXIndex2) + 1, yVals.size());
        int i = (iMin - iMax) * 4;
        int iCeil = (int) Math.ceil((r10 * phaseX) + iMax);
        CandleShadowBuffer candleShadowBuffer = this.mShadowBuffers[indexOfDataSet];
        candleShadowBuffer.setPhases(phaseX, phaseY);
        candleShadowBuffer.limitFrom(iMax);
        candleShadowBuffer.limitTo(iMin);
        candleShadowBuffer.feed(yVals);
        transformer.pointValuesToPixel(candleShadowBuffer.buffer);
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (candleDataSet.getShadowColor() == -1) {
            this.mRenderPaint.setColor(candleDataSet.getColor());
        } else {
            this.mRenderPaint.setColor(candleDataSet.getShadowColor());
        }
        this.mRenderPaint.setStrokeWidth(candleDataSet.getShadowWidth());
        canvas.drawLines(candleShadowBuffer.buffer, 0, i, this.mRenderPaint);
        CandleBodyBuffer candleBodyBuffer = this.mBodyBuffers[indexOfDataSet];
        candleBodyBuffer.setBodySpace(candleDataSet.getBodySpace());
        candleBodyBuffer.setPhases(phaseX, phaseY);
        candleBodyBuffer.limitFrom(iMax);
        candleBodyBuffer.limitTo(iMin);
        candleBodyBuffer.feed(yVals);
        transformer.pointValuesToPixel(candleBodyBuffer.buffer);
        for (int i2 = 0; i2 < i; i2 += 4) {
            int i3 = (i2 / 4) + iMax;
            if (fitsBounds(yVals.get(i3).getXIndex(), this.mMinX, iCeil)) {
                float f = candleBodyBuffer.buffer[i2];
                float f2 = candleBodyBuffer.buffer[i2 + 1];
                float f3 = candleBodyBuffer.buffer[i2 + 2];
                float f4 = candleBodyBuffer.buffer[i2 + 3];
                if (f2 > f4) {
                    if (candleDataSet.getDecreasingColor() == -1) {
                        this.mRenderPaint.setColor(candleDataSet.getColor(i3));
                    } else {
                        this.mRenderPaint.setColor(candleDataSet.getDecreasingColor());
                    }
                    this.mRenderPaint.setStyle(candleDataSet.getDecreasingPaintStyle());
                    canvas.drawRect(f, f4, f3, f2, this.mRenderPaint);
                } else if (f2 < f4) {
                    if (candleDataSet.getIncreasingColor() == -1) {
                        this.mRenderPaint.setColor(candleDataSet.getColor(i3));
                    } else {
                        this.mRenderPaint.setColor(candleDataSet.getIncreasingColor());
                    }
                    this.mRenderPaint.setStyle(candleDataSet.getIncreasingPaintStyle());
                    canvas.drawRect(f, f2, f3, f4, this.mRenderPaint);
                } else {
                    this.mRenderPaint.setColor(-16777216);
                    this.mRenderPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawLine(f, f2, f3, f4, this.mRenderPaint);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        if (this.mChart.getCandleData().getYValCount() < this.mChart.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()) {
            List<T> dataSets = this.mChart.getCandleData().getDataSets();
            for (int i = 0; i < dataSets.size(); i++) {
                DataSet<?> dataSet = (CandleDataSet) dataSets.get(i);
                if (dataSet.isDrawValuesEnabled()) {
                    applyValueTextStyle(dataSet);
                    Transformer transformer = this.mChart.getTransformer(dataSet.getAxisDependency());
                    List<T> yVals = dataSet.getYVals();
                    Entry entryForXIndex = dataSet.getEntryForXIndex(this.mMinX);
                    Entry entryForXIndex2 = dataSet.getEntryForXIndex(this.mMaxX);
                    int iMax = Math.max(dataSet.getEntryPosition(entryForXIndex), 0);
                    float[] fArrGenerateTransformedValuesCandle = transformer.generateTransformedValuesCandle(yVals, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), iMax, Math.min(dataSet.getEntryPosition(entryForXIndex2) + 1, yVals.size()));
                    float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
                    for (int i2 = 0; i2 < fArrGenerateTransformedValuesCandle.length; i2 += 2) {
                        float f = fArrGenerateTransformedValuesCandle[i2];
                        float f2 = fArrGenerateTransformedValuesCandle[i2 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f)) {
                            break;
                        }
                        if (this.mViewPortHandler.isInBoundsLeft(f) && this.mViewPortHandler.isInBoundsY(f2)) {
                            canvas.drawText(dataSet.getValueFormatter().getFormattedValue(((CandleEntry) yVals.get((i2 / 2) + iMax)).getHigh()), f, f2 - fConvertDpToPixel, this.mValuePaint);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i = 0; i < highlightArr.length; i++) {
            int xIndex = highlightArr[i].getXIndex();
            CandleDataSet candleDataSet = (CandleDataSet) this.mChart.getCandleData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (candleDataSet != null && candleDataSet.isHighlightEnabled()) {
                this.mHighlightPaint.setColor(candleDataSet.getHighLightColor());
                CandleEntry candleEntry = (CandleEntry) candleDataSet.getEntryForXIndex(xIndex);
                if (candleEntry != null && candleEntry.getXIndex() == xIndex) {
                    float low = candleEntry.getLow() * this.mAnimator.getPhaseY();
                    float high = candleEntry.getHigh() * this.mAnimator.getPhaseY();
                    float yChartMin = this.mChart.getYChartMin();
                    float yChartMax = this.mChart.getYChartMax();
                    float f = xIndex;
                    float f2 = f - 0.5f;
                    float f3 = f + 0.5f;
                    float[] fArr = {f2, yChartMax, f2, yChartMin, f3, yChartMax, f3, yChartMin};
                    float[] fArr2 = {this.mChart.getXChartMin(), low, this.mChart.getXChartMax(), low, this.mChart.getXChartMin(), high, this.mChart.getXChartMax(), high};
                    this.mChart.getTransformer(candleDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                    this.mChart.getTransformer(candleDataSet.getAxisDependency()).pointValuesToPixel(fArr2);
                    canvas.drawLines(fArr, this.mHighlightPaint);
                    canvas.drawLines(fArr2, this.mHighlightPaint);
                }
            }
        }
    }
}
