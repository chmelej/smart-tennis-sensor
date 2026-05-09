package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XAxisRenderer extends AxisRenderer {
    protected XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer);
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    public void computeAxis(float f, List<String> list) {
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        StringBuffer stringBuffer = new StringBuffer();
        int iRound = Math.round(f + this.mXAxis.getSpaceBetweenLabels());
        for (int i = 0; i < iRound; i++) {
            stringBuffer.append("h");
        }
        this.mXAxis.mLabelWidth = Utils.calcTextWidth(this.mAxisLabelPaint, stringBuffer.toString());
        this.mXAxis.mLabelHeight = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        this.mXAxis.setValues(list);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float fConvertDpToPixel = Utils.convertDpToPixel(4.0f);
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                drawLabels(canvas, this.mViewPortHandler.offsetTop() - fConvertDpToPixel);
                return;
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + this.mXAxis.mLabelHeight + (fConvertDpToPixel * 1.5f));
                return;
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                drawLabels(canvas, this.mViewPortHandler.contentBottom() - fConvertDpToPixel);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                drawLabels(canvas, this.mViewPortHandler.offsetTop() + fConvertDpToPixel + this.mXAxis.mLabelHeight);
            } else {
                drawLabels(canvas, this.mViewPortHandler.offsetTop() - fConvertDpToPixel);
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + this.mXAxis.mLabelHeight + (fConvertDpToPixel * 1.6f));
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    protected void drawLabels(Canvas canvas, float f) {
        float[] fArr = {0.0f, 0.0f};
        int i = this.mMinX;
        while (i <= this.mMaxX) {
            fArr[0] = i;
            this.mTrans.pointValuesToPixel(fArr);
            if (this.mViewPortHandler.isInBoundsX(fArr[0])) {
                String str = this.mXAxis.getValues().get(i);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    if (i == this.mXAxis.getValues().size() - 1 && this.mXAxis.getValues().size() > 1) {
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

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] fArr = {0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
            Path path = new Path();
            int i = this.mMinX;
            while (i <= this.mMaxX) {
                fArr[0] = i;
                this.mTrans.pointValuesToPixel(fArr);
                if (fArr[0] >= this.mViewPortHandler.offsetLeft() && fArr[0] <= this.mViewPortHandler.getChartWidth()) {
                    path.moveTo(fArr[0], this.mViewPortHandler.contentBottom());
                    path.lineTo(fArr[0], this.mViewPortHandler.contentTop());
                    canvas.drawPath(path, this.mGridPaint);
                }
                path.reset();
                i += this.mXAxis.mAxisLabelModulus;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
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
            this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
            this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
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
