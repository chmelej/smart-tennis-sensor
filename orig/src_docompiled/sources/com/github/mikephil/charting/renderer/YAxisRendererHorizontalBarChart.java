package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void computeAxis(float f, float f2) {
        if (this.mViewPortHandler.contentHeight() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            PointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            PointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (!this.mYAxis.isInverted()) {
                f = (float) valuesByTouchPoint.f8926x;
                f2 = (float) valuesByTouchPoint2.f8926x;
            } else {
                float f3 = (float) valuesByTouchPoint2.f8926x;
                f2 = (float) valuesByTouchPoint.f8926x;
                f = f3;
            }
        }
        computeAxisValues(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        float fContentBottom;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            float[] fArr = new float[this.mYAxis.mEntryCount * 2];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i] = this.mYAxis.mEntries[i / 2];
            }
            this.mTrans.pointValuesToPixel(fArr);
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
            float fConvertDpToPixel = Utils.convertDpToPixel(2.5f);
            float fCalcTextHeight = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    fContentBottom = this.mViewPortHandler.contentTop() - fConvertDpToPixel;
                } else {
                    fContentBottom = this.mViewPortHandler.contentTop() - fConvertDpToPixel;
                }
            } else if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                fContentBottom = this.mViewPortHandler.contentBottom() + fCalcTextHeight + fConvertDpToPixel;
            } else {
                fContentBottom = this.mViewPortHandler.contentBottom() + fCalcTextHeight + fConvertDpToPixel;
            }
            drawYLabels(canvas, fContentBottom, fArr, this.mYAxis.getYOffset());
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            } else {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        for (int i = 0; i < this.mYAxis.mEntryCount; i++) {
            String formattedLabel = this.mYAxis.getFormattedLabel(i);
            if (!this.mYAxis.isDrawTopYLabelEntryEnabled() && i >= this.mYAxis.mEntryCount - 1) {
                return;
            }
            canvas.drawText(formattedLabel, fArr[i * 2], f - f2, this.mAxisLabelPaint);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isDrawGridLinesEnabled() && this.mYAxis.isEnabled()) {
            float[] fArr = new float[2];
            this.mGridPaint.setColor(this.mYAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
            for (int i = 0; i < this.mYAxis.mEntryCount; i++) {
                fArr[0] = this.mYAxis.mEntries[i];
                this.mTrans.pointValuesToPixel(fArr);
                canvas.drawLine(fArr[0], this.mViewPortHandler.contentTop(), fArr[0], this.mViewPortHandler.contentBottom(), this.mGridPaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null || limitLines.size() <= 0) {
            return;
        }
        float[] fArr = new float[4];
        Path path = new Path();
        for (int i = 0; i < limitLines.size(); i++) {
            LimitLine limitLine = limitLines.get(i);
            fArr[0] = limitLine.getLimit();
            fArr[2] = limitLine.getLimit();
            this.mTrans.pointValuesToPixel(fArr);
            fArr[1] = this.mViewPortHandler.contentTop();
            fArr[3] = this.mViewPortHandler.contentBottom();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
            this.mLimitLinePaint.setColor(limitLine.getLineColor());
            this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
            this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
            canvas.drawPath(path, this.mLimitLinePaint);
            path.reset();
            String label = limitLine.getLabel();
            if (label != null && !label.equals("")) {
                float lineWidth = limitLine.getLineWidth();
                float fConvertDpToPixel = Utils.convertDpToPixel(4.0f);
                this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                this.mLimitLinePaint.setPathEffect(null);
                this.mLimitLinePaint.setColor(limitLine.getTextColor());
                this.mLimitLinePaint.setStrokeWidth(0.5f);
                this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                float fCalcTextHeight = Utils.calcTextHeight(this.mLimitLinePaint, label) + (fConvertDpToPixel / 2.0f);
                if (limitLine.getLabelPosition() == LimitLine.LimitLabelPosition.POS_RIGHT) {
                    canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - fConvertDpToPixel, this.mLimitLinePaint);
                } else {
                    canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + fCalcTextHeight, this.mLimitLinePaint);
                }
            }
        }
    }
}
