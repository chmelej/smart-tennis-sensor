package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RadarChartRenderer extends DataRenderer {
    protected RadarChart mChart;
    protected Paint mWebPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = radarChart;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
        this.mWebPaint = new Paint(1);
        this.mWebPaint.setStyle(Paint.Style.STROKE);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (RadarDataSet radarDataSet : ((RadarData) this.mChart.getData()).getDataSets()) {
            if (radarDataSet.isVisible()) {
                drawDataSet(canvas, radarDataSet);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, RadarDataSet radarDataSet) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        List<T> yVals = radarDataSet.getYVals();
        Path path = new Path();
        boolean z = false;
        for (int i = 0; i < yVals.size(); i++) {
            this.mRenderPaint.setColor(radarDataSet.getColor(i));
            PointF position = Utils.getPosition(centerOffsets, (((Entry) yVals.get(i)).getVal() - this.mChart.getYChartMin()) * factor, (i * sliceAngle) + this.mChart.getRotationAngle());
            if (!Float.isNaN(position.x)) {
                if (!z) {
                    path.moveTo(position.x, position.y);
                    z = true;
                } else {
                    path.lineTo(position.x, position.y);
                }
            }
        }
        path.close();
        if (radarDataSet.isDrawFilledEnabled()) {
            this.mRenderPaint.setStyle(Paint.Style.FILL);
            this.mRenderPaint.setAlpha(radarDataSet.getFillAlpha());
            canvas.drawPath(path, this.mRenderPaint);
            this.mRenderPaint.setAlpha(255);
        }
        this.mRenderPaint.setStrokeWidth(radarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!radarDataSet.isDrawFilledEnabled() || radarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
        for (int i = 0; i < ((RadarData) this.mChart.getData()).getDataSetCount(); i++) {
            RadarDataSet dataSetByIndex = ((RadarData) this.mChart.getData()).getDataSetByIndex(i);
            if (dataSetByIndex.isDrawValuesEnabled()) {
                applyValueTextStyle(dataSetByIndex);
                List<T> yVals = dataSetByIndex.getYVals();
                for (int i2 = 0; i2 < yVals.size(); i2++) {
                    Entry entry = (Entry) yVals.get(i2);
                    PointF position = Utils.getPosition(centerOffsets, (entry.getVal() - this.mChart.getYChartMin()) * factor, (i2 * sliceAngle) + this.mChart.getRotationAngle());
                    canvas.drawText(dataSetByIndex.getValueFormatter().getFormattedValue(entry.getVal()), position.x, position.y - fConvertDpToPixel, this.mValuePaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        for (int i = 0; i < ((RadarData) this.mChart.getData()).getXValCount(); i++) {
            PointF position = Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (i * sliceAngle) + rotationAngle);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, position.x, position.y, this.mWebPaint);
        }
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i2 = this.mChart.getYAxis().mEntryCount;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < ((RadarData) this.mChart.getData()).getXValCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i3] - this.mChart.getYChartMin()) * factor;
                PointF position2 = Utils.getPosition(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle);
                i4++;
                PointF position3 = Utils.getPosition(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle);
                canvas.drawLine(position2.x, position2.y, position3.x, position3.y, this.mWebPaint);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        for (int i = 0; i < highlightArr.length; i++) {
            RadarDataSet dataSetByIndex = ((RadarData) this.mChart.getData()).getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (dataSetByIndex != null && dataSetByIndex.isHighlightEnabled()) {
                this.mHighlightPaint.setColor(dataSetByIndex.getHighLightColor());
                int xIndex = highlightArr[i].getXIndex();
                Entry entryForXIndex = dataSetByIndex.getEntryForXIndex(xIndex);
                if (entryForXIndex != null && entryForXIndex.getXIndex() == xIndex) {
                    int entryPosition = dataSetByIndex.getEntryPosition(entryForXIndex);
                    float val = entryForXIndex.getVal() - this.mChart.getYChartMin();
                    if (!Float.isNaN(val)) {
                        PointF position = Utils.getPosition(centerOffsets, val * factor, (entryPosition * sliceAngle) + this.mChart.getRotationAngle());
                        canvas.drawLines(new float[]{position.x, 0.0f, position.x, this.mViewPortHandler.getChartHeight(), 0.0f, position.y, this.mViewPortHandler.getChartWidth(), position.y}, this.mHighlightPaint);
                    }
                }
            }
        }
    }
}
