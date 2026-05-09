package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.BarDataProvider;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.umeng.message.MsgConstant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BarChartRenderer extends DataRenderer {
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mChart = barDataProvider;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        this.mShadowPaint = new Paint(1);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            BarDataSet barDataSet = (BarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(barDataSet.getValueCount() * 4 * barDataSet.getStackSize(), barData.getGroupSpace(), barData.getDataSetCount(), barDataSet.isStacked());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            BarDataSet barDataSet = (BarDataSet) barData.getDataSetByIndex(i);
            if (barDataSet.isVisible()) {
                drawDataSet(canvas, barDataSet, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, BarDataSet barDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(barDataSet.getAxisDependency());
        this.mShadowPaint.setColor(barDataSet.getBarShadowColor());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List<T> yVals = barDataSet.getYVals();
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setBarSpace(barDataSet.getBarSpace());
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(barDataSet.getAxisDependency()));
        barBuffer.feed(yVals);
        transformer.pointValuesToPixel(barBuffer.buffer);
        if (barDataSet.getColors().size() > 1) {
            for (int i2 = 0; i2 < barBuffer.size(); i2 += 4) {
                int i3 = i2 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i3])) {
                    if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i2])) {
                        return;
                    }
                    if (this.mChart.isDrawBarShadowEnabled()) {
                        canvas.drawRect(barBuffer.buffer[i2], this.mViewPortHandler.contentTop(), barBuffer.buffer[i3], this.mViewPortHandler.contentBottom(), this.mShadowPaint);
                    }
                    this.mRenderPaint.setColor(barDataSet.getColor(i2 / 4));
                    if (barDataSet.isMulitColor()) {
                        this.mRenderPaint.setShader(new LinearGradient(barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], barBuffer.buffer[i3], barBuffer.buffer[i2 + 3], barDataSet.getMultiColors()[0], barDataSet.getMultiColors()[1], Shader.TileMode.CLAMP));
                    }
                    canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], barBuffer.buffer[i3], barBuffer.buffer[i2 + 3], this.mRenderPaint);
                }
            }
            return;
        }
        this.mRenderPaint.setColor(barDataSet.getColor());
        for (int i4 = 0; i4 < barBuffer.size(); i4 += 4) {
            int i5 = i4 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i5])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i4])) {
                    return;
                }
                if (this.mChart.isDrawBarShadowEnabled()) {
                    canvas.drawRect(barBuffer.buffer[i4], this.mViewPortHandler.contentTop(), barBuffer.buffer[i5], this.mViewPortHandler.contentBottom(), this.mShadowPaint);
                }
                if (barDataSet.isMulitColor()) {
                    this.mRenderPaint.setShader(new LinearGradient(barBuffer.buffer[i4], barBuffer.buffer[i4 + 1], barBuffer.buffer[i5], barBuffer.buffer[i4 + 3], barDataSet.getMultiColors()[0], barDataSet.getMultiColors()[1], Shader.TileMode.CLAMP));
                }
                canvas.drawRect(barBuffer.buffer[i4], barBuffer.buffer[i4 + 1], barBuffer.buffer[i5], barBuffer.buffer[i4 + 3], this.mRenderPaint);
            }
        }
    }

    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        float f5 = (f - 0.5f) + f3;
        float f6 = (f + 0.5f) - f3;
        float f7 = f2 >= f4 ? f2 : f4;
        if (f2 > f4) {
            f2 = f4;
        }
        this.mBarRect.set(f5, f7, f6, f2);
        transformer.rectValueToPixel(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        float f;
        boolean z;
        List list2;
        float f2;
        List list3;
        if (passesCheck()) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean zIsDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i = 0;
            while (i < this.mChart.getBarData().getDataSetCount()) {
                BarDataSet barDataSet = (BarDataSet) dataSets.get(i);
                if (barDataSet.isDrawValuesEnabled()) {
                    boolean zIsInverted = this.mChart.isInverted(barDataSet.getAxisDependency());
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, MsgConstant.MESSAGE_NOTIFY_CLICK);
                    float f3 = zIsDrawValueAboveBarEnabled ? -fConvertDpToPixel : fCalcTextHeight + fConvertDpToPixel;
                    float f4 = zIsDrawValueAboveBarEnabled ? fCalcTextHeight + fConvertDpToPixel : -fConvertDpToPixel;
                    if (zIsInverted) {
                        f3 = (-f3) - fCalcTextHeight;
                        f4 = (-f4) - fCalcTextHeight;
                    }
                    applyValueTextStyle(barDataSet);
                    ValueFormatter valueFormatter = barDataSet.getValueFormatter();
                    Transformer transformer = this.mChart.getTransformer(barDataSet.getAxisDependency());
                    List yVals = barDataSet.getYVals();
                    float[] transformedValues = getTransformedValues(transformer, yVals, i);
                    if (this.mChart.isDrawValuesForWholeStackEnabled()) {
                        list = dataSets;
                        int i2 = 0;
                        while (i2 < (transformedValues.length - 1) * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry = (BarEntry) yVals.get(i2 / 2);
                            float[] vals = barEntry.getVals();
                            if (vals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(transformedValues[i2])) {
                                    break;
                                }
                                int i3 = i2 + 1;
                                if (this.mViewPortHandler.isInBoundsY(transformedValues[i3]) && this.mViewPortHandler.isInBoundsLeft(transformedValues[i2])) {
                                    drawValue(canvas, valueFormatter.getFormattedValue(barEntry.getVal()), transformedValues[i2], transformedValues[i3] + (barEntry.getVal() >= 0.0f ? f3 : f4));
                                }
                                f = fConvertDpToPixel;
                                z = zIsDrawValueAboveBarEnabled;
                            } else {
                                float[] fArr = new float[vals.length * 2];
                                float positiveSum = barEntry.getPositiveSum();
                                f = fConvertDpToPixel;
                                float negativeSum = barEntry.getNegativeSum();
                                float f5 = positiveSum;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < fArr.length) {
                                    float f6 = vals[i5];
                                    if (f6 >= 0.0f) {
                                        f5 -= f6;
                                        f2 = f6 + f5;
                                    } else {
                                        negativeSum -= Math.abs(f6);
                                        f2 = f6 + negativeSum;
                                    }
                                    fArr[i4 + 1] = f2 * this.mAnimator.getPhaseY();
                                    i4 += 2;
                                    i5++;
                                    zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                                }
                                z = zIsDrawValueAboveBarEnabled;
                                transformer.pointValuesToPixel(fArr);
                                int i6 = 0;
                                while (i6 < fArr.length) {
                                    float f7 = transformedValues[i2];
                                    int i7 = i6 / 2;
                                    float f8 = fArr[i6 + 1] + (vals[i7] >= 0.0f ? f3 : f4);
                                    list2 = yVals;
                                    if (!this.mViewPortHandler.isInBoundsRight(f7)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f8) && this.mViewPortHandler.isInBoundsLeft(f7)) {
                                        drawValue(canvas, valueFormatter.getFormattedValue(vals[i7]), f7, f8);
                                    }
                                    i6 += 2;
                                    yVals = list2;
                                }
                            }
                            list2 = yVals;
                            i2 += 2;
                            fConvertDpToPixel = f;
                            zIsDrawValueAboveBarEnabled = z;
                            yVals = list2;
                        }
                    } else {
                        int i8 = 0;
                        while (i8 < transformedValues.length * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(transformedValues[i8])) {
                            int i9 = i8 + 1;
                            if (this.mViewPortHandler.isInBoundsY(transformedValues[i9]) && this.mViewPortHandler.isInBoundsLeft(transformedValues[i8])) {
                                float val = ((BarEntry) yVals.get(i8 / 2)).getVal();
                                list3 = dataSets;
                                drawValue(canvas, valueFormatter.getFormattedValue(val), transformedValues[i8], transformedValues[i9] + (val >= 0.0f ? f3 : f4));
                            } else {
                                list3 = dataSets;
                            }
                            i8 += 2;
                            dataSets = list3;
                        }
                        list = dataSets;
                    }
                } else {
                    list = dataSets;
                }
                i++;
                dataSets = list;
                fConvertDpToPixel = fConvertDpToPixel;
                zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
            }
        }
    }

    protected void drawValue(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        BarEntry barEntry;
        int dataSetCount = this.mChart.getBarData().getDataSetCount();
        for (Highlight highlight : highlightArr) {
            int xIndex = highlight.getXIndex();
            BarDataSet barDataSet = (BarDataSet) this.mChart.getBarData().getDataSetByIndex(highlight.getDataSetIndex());
            if (barDataSet != null && barDataSet.isHighlightEnabled()) {
                float barSpace = barDataSet.getBarSpace() / 2.0f;
                Transformer transformer = this.mChart.getTransformer(barDataSet.getAxisDependency());
                this.mHighlightPaint.setColor(barDataSet.getHighLightColor());
                this.mHighlightPaint.setAlpha(barDataSet.getHighLightAlpha());
                if (xIndex >= 0) {
                    float f = xIndex;
                    if (f < (this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) / dataSetCount && (barEntry = (BarEntry) barDataSet.getEntryForXIndex(xIndex)) != null && barEntry.getXIndex() == xIndex) {
                        float groupSpace = this.mChart.getBarData().getGroupSpace();
                        boolean z = highlight.getStackIndex() >= 0;
                        float f2 = (xIndex * dataSetCount) + r2 + (groupSpace / 2.0f) + (groupSpace * f);
                        float belowSum = z ? barEntry.getVals()[highlight.getStackIndex()] + barEntry.getBelowSum(highlight.getStackIndex()) : barEntry.getVal();
                        prepareBarHighlight(f2, belowSum, barSpace, z ? barEntry.getBelowSum(highlight.getStackIndex()) : 0.0f, transformer);
                        canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                        if (this.mChart.isDrawHighlightArrowEnabled()) {
                            this.mHighlightPaint.setAlpha(255);
                            float phaseY = this.mAnimator.getPhaseY() * 0.07f;
                            Path path = new Path();
                            path.moveTo(0.5f + f2, (0.3f * phaseY) + belowSum);
                            float f3 = belowSum + phaseY;
                            path.lineTo(0.2f + f2, f3);
                            path.lineTo(f2 + 0.8f, f3);
                            transformer.pathValueToPixel(path);
                            canvas.drawPath(path, this.mHighlightPaint);
                        }
                    }
                }
            }
        }
    }

    public float[] getTransformedValues(Transformer transformer, List<BarEntry> list, int i) {
        return transformer.generateTransformedValuesBarChart(list, i, this.mChart.getBarData(), this.mAnimator.getPhaseY());
    }

    protected boolean passesCheck() {
        return ((float) this.mChart.getBarData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX();
    }
}
