package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public class LegendRenderer extends Renderer {
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        this.mLegendLabelPaint = new Paint(1);
        this.mLegendLabelPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        this.mLegendFormPaint = new Paint(1);
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
        this.mLegendFormPaint.setStrokeWidth(3.0f);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r12) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    public void renderLegend(Canvas canvas) {
        float fContentLeft;
        float f;
        Legend.LegendPosition legendPosition;
        int i;
        int i2;
        float fContentTop;
        float f2;
        Boolean bool;
        int i3;
        float f3;
        float f4;
        float f5;
        Legend.LegendDirection legendDirection;
        float fCalcTextWidth;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint) + this.mLegend.getYEntrySpace();
            float fCalcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            String[] labels = this.mLegend.getLabels();
            int[] colors = this.mLegend.getColors();
            float formToTextSpace = this.mLegend.getFormToTextSpace();
            float xEntrySpace = this.mLegend.getXEntrySpace();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float formSize = this.mLegend.getFormSize();
            float stackSpace = this.mLegend.getStackSpace();
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            Legend.LegendPosition position = this.mLegend.getPosition();
            int i4 = -2;
            switch (position) {
                case BELOW_CHART_LEFT:
                case BELOW_CHART_RIGHT:
                case BELOW_CHART_CENTER:
                    float fContentWidth = this.mViewPortHandler.contentWidth();
                    if (position == Legend.LegendPosition.BELOW_CHART_LEFT) {
                        fContentLeft = this.mViewPortHandler.contentLeft() + xOffset;
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fContentLeft += this.mLegend.mNeededWidth;
                        }
                    } else if (position == Legend.LegendPosition.BELOW_CHART_RIGHT) {
                        fContentLeft = this.mViewPortHandler.contentRight() - xOffset;
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            fContentLeft -= this.mLegend.mNeededWidth;
                        }
                    } else {
                        fContentLeft = (fContentWidth / 2.0f) + this.mViewPortHandler.contentLeft();
                    }
                    float f6 = fContentLeft;
                    FSize[] calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                    FSize[] calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                    Boolean[] calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                    float chartHeight = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                    int length = labels.length;
                    float f7 = f6;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < length) {
                        float f8 = f7;
                        if (calculatedLabelBreakPoints[i6].booleanValue()) {
                            f = chartHeight + lineHeight + lineSpacing;
                            f8 = f6;
                        } else {
                            f = chartHeight;
                        }
                        if (f8 == f6 && position == Legend.LegendPosition.BELOW_CHART_CENTER) {
                            f8 += (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes[i5].width : -calculatedLineSizes[i5].width) / 2.0f;
                            i5++;
                        }
                        int i7 = i5;
                        boolean z = colors[i6] != -2;
                        boolean z2 = labels[i6] == null;
                        if (z) {
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f8 -= formSize;
                            }
                            legendPosition = position;
                            i = i6;
                            i2 = length;
                            drawForm(canvas, f8, f + fCalcTextHeight, i6, this.mLegend);
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f8 += formSize;
                            }
                        } else {
                            legendPosition = position;
                            i = i6;
                            i2 = length;
                        }
                        if (!z2) {
                            if (z) {
                                f8 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -formToTextSpace : formToTextSpace;
                            }
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f8 -= calculatedLabelSizes[i].width;
                            }
                            float f9 = f8;
                            drawLabel(canvas, f9, f + lineHeight, labels[i]);
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f9 += calculatedLabelSizes[i].width;
                            }
                            f7 = f9 + (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -xEntrySpace : xEntrySpace);
                        } else {
                            f7 = f8 + (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -stackSpace : stackSpace);
                        }
                        i6 = i + 1;
                        chartHeight = f;
                        i5 = i7;
                        position = legendPosition;
                        length = i2;
                    }
                    break;
                case PIECHART_CENTER:
                case RIGHT_OF_CHART:
                case RIGHT_OF_CHART_CENTER:
                case RIGHT_OF_CHART_INSIDE:
                case LEFT_OF_CHART:
                case LEFT_OF_CHART_CENTER:
                case LEFT_OF_CHART_INSIDE:
                    if (position == Legend.LegendPosition.PIECHART_CENTER) {
                        float chartWidth = (this.mViewPortHandler.getChartWidth() / 2.0f) + ((direction == Legend.LegendDirection.LEFT_TO_RIGHT ? -this.mLegend.mTextWidthMax : this.mLegend.mTextWidthMax) / 2.0f);
                        fContentTop = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                        f2 = chartWidth;
                    } else {
                        if (position == Legend.LegendPosition.RIGHT_OF_CHART || position == Legend.LegendPosition.RIGHT_OF_CHART_CENTER || position == Legend.LegendPosition.RIGHT_OF_CHART_INSIDE) {
                            xOffset = this.mViewPortHandler.getChartWidth() - xOffset;
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                xOffset -= this.mLegend.mTextWidthMax;
                            }
                        } else if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            xOffset += this.mLegend.mTextWidthMax;
                        }
                        if (position == Legend.LegendPosition.RIGHT_OF_CHART || position == Legend.LegendPosition.LEFT_OF_CHART) {
                            fContentTop = this.mViewPortHandler.contentTop() + yOffset;
                        } else if (position == Legend.LegendPosition.RIGHT_OF_CHART_CENTER || position == Legend.LegendPosition.LEFT_OF_CHART_CENTER) {
                            fContentTop = (this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f);
                        } else {
                            fContentTop = this.mViewPortHandler.contentTop() + yOffset;
                        }
                        f2 = xOffset;
                    }
                    float f10 = fContentTop;
                    int i8 = 0;
                    float f11 = 0.0f;
                    boolean z3 = false;
                    while (i8 < labels.length) {
                        Boolean boolValueOf = Boolean.valueOf(colors[i8] != i4);
                        if (boolValueOf.booleanValue()) {
                            float f12 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f2 + f11 : f2 - (formSize - f11);
                            bool = boolValueOf;
                            i3 = i8;
                            f4 = f2;
                            f5 = stackSpace;
                            f3 = fCalcTextHeight;
                            legendDirection = direction;
                            drawForm(canvas, f12, f10 + fCalcTextHeight, i3, this.mLegend);
                            fCalcTextWidth = legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? f12 + formSize : f12;
                        } else {
                            bool = boolValueOf;
                            i3 = i8;
                            f3 = fCalcTextHeight;
                            f4 = f2;
                            f5 = stackSpace;
                            legendDirection = direction;
                            fCalcTextWidth = f4;
                        }
                        if (labels[i3] != null) {
                            if (bool.booleanValue() && !z3) {
                                fCalcTextWidth += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? formToTextSpace : -formToTextSpace;
                            } else if (z3) {
                                fCalcTextWidth = f4;
                            }
                            if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                fCalcTextWidth -= Utils.calcTextWidth(this.mLegendLabelPaint, labels[i3]);
                            }
                            if (!z3) {
                                drawLabel(canvas, fCalcTextWidth, f10 + lineHeight, labels[i3]);
                            } else {
                                f10 += lineHeight + lineSpacing;
                                drawLabel(canvas, fCalcTextWidth, f10 + lineHeight, labels[i3]);
                            }
                            f10 += lineHeight + lineSpacing;
                            f11 = 0.0f;
                        } else {
                            f11 += formSize + f5;
                            z3 = true;
                        }
                        i8 = i3 + 1;
                        direction = legendDirection;
                        stackSpace = f5;
                        f2 = f4;
                        fCalcTextHeight = f3;
                        i4 = -2;
                    }
                    break;
            }
        }
    }

    protected void drawForm(Canvas canvas, float f, float f2, int i, Legend legend) {
        if (legend.getColors()[i] == -2) {
        }
        this.mLegendFormPaint.setColor(legend.getColors()[i]);
        float formSize = legend.getFormSize();
        float f3 = formSize / 2.0f;
        switch (legend.getForm()) {
            case CIRCLE:
                canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
                break;
            case SQUARE:
                canvas.drawRect(f, f2 - f3, formSize + f, f2 + f3, this.mLegendFormPaint);
                break;
            case LINE:
                canvas.drawLine(f, f2, formSize + f, f2, this.mLegendFormPaint);
                break;
            case MYPIC:
                canvas.drawBitmap(legend.getmBitMaps()[i], f - (f3 * 2.0f), f2 - formSize, this.mLegendFormPaint);
                break;
        }
    }

    protected void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }
}
