package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public class XAxisRendererBarChart extends XAxisRenderer {
    protected BarChart mChart;

    public XAxisRendererBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.mChart = barChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawLabels(Canvas canvas, float f) {
        float[] fArr = {0.0f, 0.0f};
        BarData barData = (BarData) this.mChart.getData();
        int dataSetCount = barData.getDataSetCount();
        int i = this.mMinX;
        while (i <= this.mMaxX) {
            fArr[0] = (i * dataSetCount) + (i * barData.getGroupSpace()) + (barData.getGroupSpace() / 2.0f);
            if (dataSetCount > 1) {
                fArr[0] = fArr[0] + ((dataSetCount - 1.0f) / 2.0f);
            }
            this.mTrans.pointValuesToPixel(fArr);
            if (this.mViewPortHandler.isInBoundsX(fArr[0]) && i >= 0 && i < this.mXAxis.getValues().size()) {
                String str = this.mXAxis.getValues().get(i);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    if (i == this.mXAxis.getValues().size() - 1) {
                        float fCalcTextWidth = Utils.calcTextWidth(this.mAxisLabelPaint, str);
                        if (fCalcTextWidth > this.mViewPortHandler.offsetRight() * 2.0f && fArr[0] + fCalcTextWidth > this.mViewPortHandler.getChartWidth()) {
                            fArr[0] = fArr[0] - (fCalcTextWidth / 2.0f);
                        }
                    } else if (i == 0) {
                        fArr[0] = fArr[0] + (Utils.calcTextWidth(this.mAxisLabelPaint, str) / 2.0f);
                    }
                }
                canvas.drawText(str, fArr[0], f, this.mAxisLabelPaint);
            }
            i += this.mXAxis.mAxisLabelModulus;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] fArr = {0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            BarData barData = (BarData) this.mChart.getData();
            int dataSetCount = barData.getDataSetCount();
            int i = this.mMinX;
            while (i < this.mMaxX) {
                fArr[0] = ((i * dataSetCount) + (i * barData.getGroupSpace())) - 0.5f;
                this.mTrans.pointValuesToPixel(fArr);
                if (this.mViewPortHandler.isInBoundsX(fArr[0])) {
                    canvas.drawLine(fArr[0], this.mViewPortHandler.offsetTop(), fArr[0], this.mViewPortHandler.contentBottom(), this.mGridPaint);
                }
                i += this.mXAxis.mAxisLabelModulus;
            }
        }
    }
}
