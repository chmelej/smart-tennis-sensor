package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.BarDataProvider;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private float mYOffset;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mYOffset = 0.0f;
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            BarDataSet barDataSet = (BarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(barDataSet.getValueCount() * 4 * barDataSet.getStackSize(), barData.getGroupSpace(), barData.getDataSetCount(), barDataSet.isStacked());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
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
        for (int i2 = 0; i2 < barBuffer.size(); i2 += 4) {
            int i3 = i2 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i3])) {
                return;
            }
            int i4 = i2 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i4])) {
                if (this.mChart.isDrawBarShadowEnabled()) {
                    canvas.drawRect(this.mViewPortHandler.contentLeft(), barBuffer.buffer[i4], this.mViewPortHandler.contentRight(), barBuffer.buffer[i3], this.mShadowPaint);
                }
                this.mRenderPaint.setColor(barDataSet.getColor(i2 / 4));
                canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i4], barBuffer.buffer[i2 + 2], barBuffer.buffer[i3], this.mRenderPaint);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawValues(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.HorizontalBarChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        float f5 = (f - 0.5f) + f3;
        float f6 = (f + 0.5f) - f3;
        float f7 = f2 >= f4 ? f2 : f4;
        if (f2 > f4) {
            f2 = f4;
        }
        this.mBarRect.set(f7, f5, f2, f6);
        transformer.rectValueToPixelHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public float[] getTransformedValues(Transformer transformer, List<BarEntry> list, int i) {
        return transformer.generateTransformedValuesHorizontalBarChart(list, i, this.mChart.getBarData(), this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawValue(Canvas canvas, String str, float f, float f2) {
        super.drawValue(canvas, str, f, f2 + this.mYOffset);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected boolean passesCheck() {
        return ((float) this.mChart.getBarData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }
}
