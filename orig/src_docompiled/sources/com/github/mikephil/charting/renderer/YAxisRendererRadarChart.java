package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.mChart = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void computeAxis(float f, float f2) {
        computeAxisValues(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void computeAxisValues(float f, float f2) {
        int labelCount = this.mYAxis.getLabelCount();
        double dAbs = Math.abs(f2 - f);
        if (labelCount != 0) {
            if (dAbs > 0.0d) {
                double dRoundToNextSignificant = Utils.roundToNextSignificant(dAbs / ((double) labelCount));
                double dPow = Math.pow(10.0d, (int) Math.log10(dRoundToNextSignificant));
                if (((int) (dRoundToNextSignificant / dPow)) > 5) {
                    dRoundToNextSignificant = Math.floor(dPow * 10.0d);
                }
                if (this.mYAxis.isShowOnlyMinMaxEnabled()) {
                    this.mYAxis.mEntryCount = 2;
                    this.mYAxis.mEntries = new float[2];
                    this.mYAxis.mEntries[0] = f;
                    this.mYAxis.mEntries[1] = f2;
                } else {
                    double dCeil = Math.ceil(((double) f) / dRoundToNextSignificant) * dRoundToNextSignificant;
                    double d = dCeil != 0.0d ? dCeil : 0.0d;
                    int i = 0;
                    for (double d2 = d; d2 <= Utils.nextUp(Math.floor(((double) f2) / dRoundToNextSignificant) * dRoundToNextSignificant); d2 += dRoundToNextSignificant) {
                        i++;
                    }
                    if (Float.isNaN(this.mYAxis.getAxisMaxValue())) {
                        i++;
                    }
                    this.mYAxis.mEntryCount = i;
                    if (this.mYAxis.mEntries.length < i) {
                        this.mYAxis.mEntries = new float[i];
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        this.mYAxis.mEntries[i2] = (float) d;
                        d += dRoundToNextSignificant;
                    }
                }
                if (dRoundToNextSignificant < 1.0d) {
                    this.mYAxis.mDecimals = (int) Math.ceil(-Math.log10(dRoundToNextSignificant));
                } else {
                    this.mYAxis.mDecimals = 0;
                }
                this.mYAxis.mAxisMaximum = this.mYAxis.mEntries[this.mYAxis.mEntryCount - 1];
                this.mYAxis.mAxisRange = Math.abs(this.mYAxis.mAxisMaximum - this.mYAxis.mAxisMinimum);
                return;
            }
        }
        this.mYAxis.mEntries = new float[0];
        this.mYAxis.mEntryCount = 0;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            PointF centerOffsets = this.mChart.getCenterOffsets();
            float factor = this.mChart.getFactor();
            int i = this.mYAxis.mEntryCount;
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 == i - 1 && !this.mYAxis.isDrawTopYLabelEntryEnabled()) {
                    return;
                }
                PointF position = Utils.getPosition(centerOffsets, (this.mYAxis.mEntries[i2] - this.mYAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle());
                canvas.drawText(this.mYAxis.getFormattedLabel(i2), position.x + 10.0f, position.y, this.mAxisLabelPaint);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null) {
            return;
        }
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        for (int i = 0; i < limitLines.size(); i++) {
            LimitLine limitLine = limitLines.get(i);
            this.mLimitLinePaint.setColor(limitLine.getLineColor());
            this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
            this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
            float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
            Path path = new Path();
            for (int i2 = 0; i2 < ((RadarData) this.mChart.getData()).getXValCount(); i2++) {
                PointF position = Utils.getPosition(centerOffsets, limit, (i2 * sliceAngle) + this.mChart.getRotationAngle());
                if (i2 == 0) {
                    path.moveTo(position.x, position.y);
                } else {
                    path.lineTo(position.x, position.y);
                }
            }
            path.close();
            canvas.drawPath(path, this.mLimitLinePaint);
        }
    }
}
