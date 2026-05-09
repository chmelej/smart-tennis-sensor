package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.ScatterBuffer;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.ScatterDataProvider;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChartRenderer extends DataRenderer {
    protected ScatterDataProvider mChart;
    protected ScatterBuffer[] mScatterBuffers;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
        this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        ScatterData scatterData = this.mChart.getScatterData();
        this.mScatterBuffers = new ScatterBuffer[scatterData.getDataSetCount()];
        for (int i = 0; i < this.mScatterBuffers.length; i++) {
            this.mScatterBuffers[i] = new ScatterBuffer(((ScatterDataSet) scatterData.getDataSetByIndex(i)).getEntryCount() * 2);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getScatterData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, ScatterDataSet scatterDataSet) {
        Transformer transformer = this.mChart.getTransformer(scatterDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List<T> yVals = scatterDataSet.getYVals();
        float scatterShapeSize = scatterDataSet.getScatterShapeSize() / 2.0f;
        ScatterChart.ScatterShape scatterShape = scatterDataSet.getScatterShape();
        ScatterBuffer scatterBuffer = this.mScatterBuffers[this.mChart.getScatterData().getIndexOfDataSet(scatterDataSet)];
        scatterBuffer.setPhases(phaseX, phaseY);
        scatterBuffer.feed(yVals);
        transformer.pointValuesToPixel(scatterBuffer.buffer);
        int i = 0;
        switch (scatterShape) {
            case SQUARE:
                this.mRenderPaint.setStyle(Paint.Style.FILL);
                while (i < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i])) {
                        int i2 = i + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i2])) {
                            this.mRenderPaint.setColor(scatterDataSet.getColor(i / 2));
                            canvas.drawRect(scatterBuffer.buffer[i] - scatterShapeSize, scatterBuffer.buffer[i2] - scatterShapeSize, scatterBuffer.buffer[i] + scatterShapeSize, scatterBuffer.buffer[i2] + scatterShapeSize, this.mRenderPaint);
                        }
                    }
                    i += 2;
                }
                break;
            case CIRCLE:
                this.mRenderPaint.setStyle(Paint.Style.FILL);
                while (i < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i])) {
                        int i3 = i + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i3])) {
                            this.mRenderPaint.setColor(scatterDataSet.getColor(i / 2));
                            canvas.drawCircle(scatterBuffer.buffer[i], scatterBuffer.buffer[i3], scatterShapeSize, this.mRenderPaint);
                        }
                    }
                    i += 2;
                }
                break;
            case TRIANGLE:
                this.mRenderPaint.setStyle(Paint.Style.FILL);
                Path path = new Path();
                while (i < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i])) {
                        int i4 = i + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i4])) {
                            this.mRenderPaint.setColor(scatterDataSet.getColor(i / 2));
                            path.moveTo(scatterBuffer.buffer[i], scatterBuffer.buffer[i4] - scatterShapeSize);
                            path.lineTo(scatterBuffer.buffer[i] + scatterShapeSize, scatterBuffer.buffer[i4] + scatterShapeSize);
                            path.lineTo(scatterBuffer.buffer[i] - scatterShapeSize, scatterBuffer.buffer[i4] + scatterShapeSize);
                            path.close();
                            canvas.drawPath(path, this.mRenderPaint);
                            path.reset();
                        }
                    }
                    i += 2;
                }
                break;
            case CROSS:
                this.mRenderPaint.setStyle(Paint.Style.STROKE);
                while (i < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i])) {
                    if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i])) {
                        int i5 = i + 1;
                        if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i5])) {
                            this.mRenderPaint.setColor(scatterDataSet.getColor(i / 2));
                            canvas.drawLine(scatterBuffer.buffer[i] - scatterShapeSize, scatterBuffer.buffer[i5], scatterBuffer.buffer[i] + scatterShapeSize, scatterBuffer.buffer[i5], this.mRenderPaint);
                            canvas.drawLine(scatterBuffer.buffer[i], scatterBuffer.buffer[i5] - scatterShapeSize, scatterBuffer.buffer[i], scatterBuffer.buffer[i5] + scatterShapeSize, this.mRenderPaint);
                        }
                    }
                    i += 2;
                }
                break;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        if (this.mChart.getScatterData().getYValCount() < this.mChart.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()) {
            List<T> dataSets = this.mChart.getScatterData().getDataSets();
            for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++) {
                ScatterDataSet scatterDataSet = (ScatterDataSet) dataSets.get(i);
                if (scatterDataSet.isDrawValuesEnabled()) {
                    applyValueTextStyle(scatterDataSet);
                    List<T> yVals = scatterDataSet.getYVals();
                    float[] fArrGenerateTransformedValuesScatter = this.mChart.getTransformer(scatterDataSet.getAxisDependency()).generateTransformedValuesScatter(yVals, this.mAnimator.getPhaseY());
                    float scatterShapeSize = scatterDataSet.getScatterShapeSize();
                    for (int i2 = 0; i2 < fArrGenerateTransformedValuesScatter.length * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(fArrGenerateTransformedValuesScatter[i2]); i2 += 2) {
                        if (this.mViewPortHandler.isInBoundsLeft(fArrGenerateTransformedValuesScatter[i2])) {
                            int i3 = i2 + 1;
                            if (this.mViewPortHandler.isInBoundsY(fArrGenerateTransformedValuesScatter[i3])) {
                                canvas.drawText(scatterDataSet.getValueFormatter().getFormattedValue(((Entry) yVals.get(i2 / 2)).getVal()), fArrGenerateTransformedValuesScatter[i2], fArrGenerateTransformedValuesScatter[i3] - scatterShapeSize, this.mValuePaint);
                            }
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
            ScatterDataSet scatterDataSet = (ScatterDataSet) this.mChart.getScatterData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (scatterDataSet != null && scatterDataSet.isHighlightEnabled()) {
                this.mHighlightPaint.setColor(scatterDataSet.getHighLightColor());
                int xIndex = highlightArr[i].getXIndex();
                float f = xIndex;
                if (f <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yValForXIndex = scatterDataSet.getYValForXIndex(xIndex);
                    if (yValForXIndex != Float.NaN) {
                        float phaseY = yValForXIndex * this.mAnimator.getPhaseY();
                        float[] fArr = {f, this.mChart.getYChartMax(), f, this.mChart.getYChartMin(), 0.0f, phaseY, this.mChart.getXChartMax(), phaseY};
                        this.mChart.getTransformer(scatterDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                        canvas.drawLines(fArr, this.mHighlightPaint);
                    }
                }
            }
        }
    }
}
