package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.BubbleDataProvider;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BubbleChartRenderer extends DataRenderer {
    private float[] _hsvBuffer;
    protected BubbleDataProvider mChart;
    private float[] pointBuffer;
    private float[] sizeBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.sizeBuffer = new float[4];
        this.pointBuffer = new float[2];
        this._hsvBuffer = new float[3];
        this.mChart = bubbleDataProvider;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getBubbleData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    protected float getShapeSize(float f, float f2, float f3) {
        return f3 * (f2 == 0.0f ? 1.0f : (float) Math.sqrt(f / f2));
    }

    protected void drawDataSet(Canvas canvas, BubbleDataSet bubbleDataSet) {
        Transformer transformer = this.mChart.getTransformer(bubbleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List yVals = bubbleDataSet.getYVals();
        Entry entryForXIndex = bubbleDataSet.getEntryForXIndex(this.mMinX);
        Entry entryForXIndex2 = bubbleDataSet.getEntryForXIndex(this.mMaxX);
        char c = 0;
        int iMax = Math.max(bubbleDataSet.getEntryPosition(entryForXIndex), 0);
        int iMin = Math.min(bubbleDataSet.getEntryPosition(entryForXIndex2) + 1, yVals.size());
        this.sizeBuffer[0] = 0.0f;
        this.sizeBuffer[2] = 1.0f;
        transformer.pointValuesToPixel(this.sizeBuffer);
        float fMin = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(this.sizeBuffer[2] - this.sizeBuffer[0]));
        int i = iMax;
        while (i < iMin) {
            BubbleEntry bubbleEntry = (BubbleEntry) yVals.get(i);
            this.pointBuffer[c] = ((bubbleEntry.getXIndex() - iMax) * phaseX) + iMax;
            this.pointBuffer[1] = bubbleEntry.getVal() * phaseY;
            transformer.pointValuesToPixel(this.pointBuffer);
            float shapeSize = getShapeSize(bubbleEntry.getSize(), bubbleDataSet.getMaxSize(), fMin) / 2.0f;
            if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[c] + shapeSize)) {
                if (!this.mViewPortHandler.isInBoundsRight(this.pointBuffer[c] - shapeSize)) {
                    return;
                }
                this.mRenderPaint.setColor(bubbleDataSet.getColor(bubbleEntry.getXIndex()));
                canvas.drawCircle(this.pointBuffer[c], this.pointBuffer[1], shapeSize, this.mRenderPaint);
            }
            i++;
            c = 0;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        BubbleData bubbleData = this.mChart.getBubbleData();
        if (bubbleData != null && bubbleData.getYValCount() < ((int) Math.ceil(this.mChart.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()))) {
            List<T> dataSets = bubbleData.getDataSets();
            float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, "1");
            for (T t : dataSets) {
                if (t.isDrawValuesEnabled()) {
                    applyValueTextStyle(t);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    float f = phaseX == 1.0f ? phaseY : phaseX;
                    int valueTextColor = t.getValueTextColor();
                    this.mValuePaint.setColor(Color.argb(Math.round(f * 255.0f), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor)));
                    List<T> yVals = t.getYVals();
                    Entry entryForXIndex = t.getEntryForXIndex(this.mMinX);
                    Entry entryForXIndex2 = t.getEntryForXIndex(this.mMaxX);
                    int entryPosition = t.getEntryPosition(entryForXIndex);
                    float[] fArrGenerateTransformedValuesBubble = this.mChart.getTransformer(t.getAxisDependency()).generateTransformedValuesBubble(yVals, phaseX, phaseY, entryPosition, Math.min(t.getEntryPosition(entryForXIndex2) + 1, t.getEntryCount()));
                    for (int i = 0; i < fArrGenerateTransformedValuesBubble.length; i += 2) {
                        float f2 = fArrGenerateTransformedValuesBubble[i];
                        float f3 = fArrGenerateTransformedValuesBubble[i + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f2)) {
                            break;
                        }
                        if (this.mViewPortHandler.isInBoundsLeft(f2) && this.mViewPortHandler.isInBoundsY(f3)) {
                            canvas.drawText(t.getValueFormatter().getFormattedValue(((BubbleEntry) yVals.get((i / 2) + entryPosition)).getSize()), f2, f3 + (0.5f * fCalcTextHeight), this.mValuePaint);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0163  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawHighlighted(android.graphics.Canvas r20, com.github.mikephil.charting.utils.Highlight[] r21) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.BubbleChartRenderer.drawHighlighted(android.graphics.Canvas, com.github.mikephil.charting.utils.Highlight[]):void");
    }
}
