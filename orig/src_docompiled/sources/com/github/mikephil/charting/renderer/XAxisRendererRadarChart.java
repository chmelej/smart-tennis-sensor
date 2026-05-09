package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart mChart;

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
    }

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, null);
        this.mChart = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            float sliceAngle = this.mChart.getSliceAngle();
            float factor = this.mChart.getFactor();
            PointF centerOffsets = this.mChart.getCenterOffsets();
            for (int i = 0; i < this.mXAxis.getValues().size(); i++) {
                String str = this.mXAxis.getValues().get(i);
                PointF position = Utils.getPosition(centerOffsets, (this.mChart.getYRange() * factor) + (this.mXAxis.mLabelWidth / 2.0f), ((i * sliceAngle) + this.mChart.getRotationAngle()) % 360.0f);
                canvas.drawText(str, position.x, position.y + (this.mXAxis.mLabelHeight / 2.0f), this.mAxisLabelPaint);
            }
        }
    }
}
