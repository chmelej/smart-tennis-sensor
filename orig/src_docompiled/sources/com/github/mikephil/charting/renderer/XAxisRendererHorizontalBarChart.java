package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XAxisRendererHorizontalBarChart extends XAxisRendererBarChart {
    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer, barChart);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void computeAxis(float f, List<String> list) {
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        this.mXAxis.setValues(list);
        String longestLabel = this.mXAxis.getLongestLabel();
        this.mXAxis.mLabelWidth = (int) (Utils.calcTextWidth(this.mAxisLabelPaint, longestLabel) + (this.mXAxis.getXOffset() * 3.5f));
        this.mXAxis.mLabelHeight = Utils.calcTextHeight(this.mAxisLabelPaint, longestLabel);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float xOffset = this.mXAxis.getXOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                drawLabels(canvas, this.mViewPortHandler.contentRight() + xOffset);
                return;
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                drawLabels(canvas, this.mViewPortHandler.contentLeft() - xOffset);
                return;
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                drawLabels(canvas, this.mViewPortHandler.contentLeft() + xOffset);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                drawLabels(canvas, this.mViewPortHandler.contentRight() - xOffset);
            } else {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                drawLabels(canvas, this.mViewPortHandler.contentLeft() - xOffset);
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                drawLabels(canvas, this.mViewPortHandler.contentRight() + xOffset);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRendererBarChart, com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawLabels(Canvas canvas, float f) {
        float[] fArr = {0.0f, 0.0f};
        BarData barData = (BarData) this.mChart.getData();
        int dataSetCount = barData.getDataSetCount();
        int i = this.mMinX;
        while (i <= this.mMaxX) {
            fArr[1] = (i * dataSetCount) + (i * barData.getGroupSpace()) + (barData.getGroupSpace() / 2.0f);
            if (dataSetCount > 1) {
                fArr[1] = fArr[1] + ((dataSetCount - 1.0f) / 2.0f);
            }
            this.mTrans.pointValuesToPixel(fArr);
            if (this.mViewPortHandler.isInBoundsY(fArr[1])) {
                canvas.drawText(this.mXAxis.getValues().get(i), f, fArr[1] + (this.mXAxis.mLabelHeight / 2.0f), this.mAxisLabelPaint);
            }
            i += this.mXAxis.mAxisLabelModulus;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRendererBarChart, com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] fArr = {0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            BarData barData = (BarData) this.mChart.getData();
            int dataSetCount = barData.getDataSetCount();
            int i = this.mMinX;
            while (i <= this.mMaxX) {
                fArr[1] = ((i * dataSetCount) + (i * barData.getGroupSpace())) - 0.5f;
                this.mTrans.pointValuesToPixel(fArr);
                if (this.mViewPortHandler.isInBoundsY(fArr[1])) {
                    canvas.drawLine(this.mViewPortHandler.contentLeft(), fArr[1], this.mViewPortHandler.contentRight(), fArr[1], this.mGridPaint);
                }
                i += this.mXAxis.mAxisLabelModulus;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines == null || limitLines.size() <= 0) {
            return;
        }
        float[] fArr = new float[2];
        Path path = new Path();
        for (int i = 0; i < limitLines.size(); i++) {
            LimitLine limitLine = limitLines.get(i);
            this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
            this.mLimitLinePaint.setColor(limitLine.getLineColor());
            this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
            this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
            fArr[1] = limitLine.getLimit();
            this.mTrans.pointValuesToPixel(fArr);
            path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
            path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
            canvas.drawPath(path, this.mLimitLinePaint);
            path.reset();
            String label = limitLine.getLabel();
            if (label != null && !label.equals("")) {
                float fConvertDpToPixel = Utils.convertDpToPixel(4.0f);
                float lineWidth = limitLine.getLineWidth() + (Utils.calcTextHeight(this.mLimitLinePaint, label) / 2.0f);
                this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                this.mLimitLinePaint.setPathEffect(null);
                this.mLimitLinePaint.setColor(limitLine.getTextColor());
                this.mLimitLinePaint.setStrokeWidth(0.5f);
                this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                if (limitLine.getLabelPosition() == LimitLine.LimitLabelPosition.POS_RIGHT) {
                    this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(label, this.mViewPortHandler.contentRight() - fConvertDpToPixel, fArr[1] - lineWidth, this.mLimitLinePaint);
                } else {
                    this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText(label, this.mViewPortHandler.offsetLeft() + fConvertDpToPixel, fArr[1] - lineWidth, this.mLimitLinePaint);
                }
            }
        }
    }
}
