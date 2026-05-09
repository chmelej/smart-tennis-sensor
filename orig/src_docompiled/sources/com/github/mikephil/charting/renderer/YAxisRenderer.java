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
public class YAxisRenderer extends AxisRenderer {
    protected YAxis mYAxis;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer);
        this.mYAxis = yAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    public void computeAxis(float f, float f2) {
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            PointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            PointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!this.mYAxis.isInverted()) {
                float f3 = (float) valuesByTouchPoint2.f8927y;
                f2 = (float) valuesByTouchPoint.f8927y;
                f = f3;
            } else {
                f = (float) valuesByTouchPoint.f8927y;
                f2 = (float) valuesByTouchPoint2.f8927y;
            }
        }
        computeAxisValues(f, f2);
    }

    protected void computeAxisValues(float f, float f2) {
        int labelCount = this.mYAxis.getLabelCount();
        double dAbs = Math.abs(f2 - f);
        if (labelCount == 0 || dAbs <= 0.0d) {
            this.mYAxis.mEntries = new float[0];
            this.mYAxis.mEntryCount = 0;
            return;
        }
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
            int i = 0;
            for (double d = dCeil; d <= Utils.nextUp(Math.floor(((double) f2) / dRoundToNextSignificant) * dRoundToNextSignificant); d += dRoundToNextSignificant) {
                i++;
            }
            this.mYAxis.mEntryCount = i;
            if (this.mYAxis.mEntries.length < i) {
                this.mYAxis.mEntries = new float[i];
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.mYAxis.mEntries[i2] = (float) dCeil;
                dCeil += dRoundToNextSignificant;
            }
        }
        if (dRoundToNextSignificant < 1.0d) {
            this.mYAxis.mDecimals = (int) Math.ceil(-Math.log10(dRoundToNextSignificant));
        } else {
            this.mYAxis.mDecimals = 0;
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        float fContentRight;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            float[] fArr = new float[this.mYAxis.mEntryCount * 2];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i + 1] = this.mYAxis.mEntries[i / 2];
            }
            this.mTrans.pointValuesToPixel(fArr);
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            float xOffset = this.mYAxis.getXOffset();
            float fCalcTextHeight = (Utils.calcTextHeight(this.mAxisLabelPaint, "A") / 2.5f) + this.mYAxis.getYOffset();
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                    fContentRight = this.mViewPortHandler.offsetLeft() - xOffset;
                } else {
                    this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                    fContentRight = this.mViewPortHandler.offsetLeft() + xOffset;
                }
            } else if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                fContentRight = this.mViewPortHandler.contentRight() + xOffset;
            } else {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                fContentRight = this.mViewPortHandler.contentRight() - xOffset;
            }
            drawYLabels(canvas, fContentRight, fArr, fCalcTextHeight);
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            } else {
                canvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    protected void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        for (int i = 0; i < this.mYAxis.mEntryCount; i++) {
            String formattedLabel = this.mYAxis.getFormattedLabel(i);
            if (!this.mYAxis.isDrawTopYLabelEntryEnabled() && i >= this.mYAxis.mEntryCount - 1) {
                return;
            }
            canvas.drawText(formattedLabel, f, fArr[(i * 2) + 1] + f2, this.mAxisLabelPaint);
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isDrawGridLinesEnabled() && this.mYAxis.isEnabled()) {
            float[] fArr = new float[2];
            this.mGridPaint.setColor(this.mYAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
            this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
            Path path = new Path();
            for (int i = 0; i < this.mYAxis.mEntryCount; i++) {
                fArr[1] = this.mYAxis.mEntries[i];
                this.mTrans.pointValuesToPixel(fArr);
                path.moveTo(this.mViewPortHandler.offsetLeft(), fArr[1]);
                path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                canvas.drawPath(path, this.mGridPaint);
                path.reset();
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
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
