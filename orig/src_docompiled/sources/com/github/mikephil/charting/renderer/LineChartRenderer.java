package com.github.mikephil.charting.renderer;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.CircleBuffer;
import com.github.mikephil.charting.buffer.LineBuffer;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.LineDataProvider;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.PrintStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LineChartRenderer extends DataRenderer {
    protected Path cubicFillPath;
    protected Path cubicPath;
    protected Canvas mBitmapCanvas;
    protected LineDataProvider mChart;
    protected CircleBuffer[] mCircleBuffers;
    protected Paint mCirclePaintInner;
    protected Bitmap mDrawBitmap;
    protected LineBuffer[] mLineBuffers;
    private String[] strArray;
    float y11;
    float y12;

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.cubicPath = new Path();
        this.cubicFillPath = new Path();
        this.strArray = new String[]{"角度:", "耗时:", "发力点", "击球点", "发球点速度", "发球点力度", "击球点速度", "击球点力度", "angle:", "time:", "penalty mark", "hitting point", "Speed of penalty mark", "Power of penalty mark", "Speed of hitting point", "Power of hitting point"};
        this.mChart = lineDataProvider;
        this.mCirclePaintInner = new Paint(1);
        this.mCirclePaintInner.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        LineData lineData = this.mChart.getLineData();
        this.mLineBuffers = new LineBuffer[lineData.getDataSetCount()];
        this.mCircleBuffers = new CircleBuffer[lineData.getDataSetCount()];
        for (int i = 0; i < this.mLineBuffers.length; i++) {
            LineDataSet lineDataSet = (LineDataSet) lineData.getDataSetByIndex(i);
            this.mLineBuffers[i] = new LineBuffer((lineDataSet.getEntryCount() * 4) - 4);
            this.mCircleBuffers[i] = new CircleBuffer(lineDataSet.getEntryCount() * 2);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        if (this.mDrawBitmap == null || this.mDrawBitmap.getWidth() != chartWidth || this.mDrawBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            this.mDrawBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mBitmapCanvas = new Canvas(this.mDrawBitmap);
        }
        this.mDrawBitmap.eraseColor(0);
        for (T t : this.mChart.getLineData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
        canvas.drawBitmap(this.mDrawBitmap, 0.0f, 0.0f, this.mRenderPaint);
    }

    protected void drawDataSet(Canvas canvas, LineDataSet lineDataSet) {
        List<Entry> yVals = lineDataSet.getYVals();
        if (yVals.size() < 1) {
            return;
        }
        this.mRenderPaint.setStrokeWidth(lineDataSet.getLineWidth());
        this.mRenderPaint.setPathEffect(lineDataSet.getDashPathEffect());
        if (lineDataSet.isDrawCubicEnabled()) {
            drawCubic(canvas, lineDataSet, yVals);
        } else {
            drawLinear(canvas, lineDataSet, yVals);
        }
        this.mRenderPaint.setPathEffect(null);
    }

    protected void drawCubic(Canvas canvas, LineDataSet lineDataSet, List<Entry> list) {
        float f;
        int i;
        int size;
        Transformer transformer = this.mChart.getTransformer(lineDataSet.getAxisDependency());
        Entry entryForXIndex = lineDataSet.getEntryForXIndex(this.mMinX);
        Entry entryForXIndex2 = lineDataSet.getEntryForXIndex(this.mMaxX);
        int iMax = Math.max(lineDataSet.getEntryPosition(entryForXIndex), 0);
        int iMin = Math.min(lineDataSet.getEntryPosition(entryForXIndex2) + 1, list.size());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float cubicIntensity = lineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        int iCeil = (int) Math.ceil(((iMin - iMax) * phaseX) + iMax);
        if (iCeil - iMax >= 2) {
            list.get(iMax);
            Entry entry = list.get(iMax);
            Entry entry2 = list.get(iMax);
            int i2 = iMax + 1;
            Entry entry3 = list.get(i2);
            this.cubicPath.moveTo(entry2.getXIndex(), entry2.getVal() * phaseY);
            f = phaseX;
            this.cubicPath.cubicTo(entry.getXIndex() + ((entry2.getXIndex() - entry.getXIndex()) * cubicIntensity), (entry.getVal() + ((entry2.getVal() - entry.getVal()) * cubicIntensity)) * phaseY, entry2.getXIndex() - ((entry3.getXIndex() - entry2.getXIndex()) * cubicIntensity), (entry2.getVal() - ((entry3.getVal() - entry2.getVal()) * cubicIntensity)) * phaseY, entry2.getXIndex(), entry2.getVal() * phaseY);
            int i3 = 1;
            int iMin2 = Math.min(iCeil, list.size() - 1);
            int i4 = i2;
            while (i4 < iMin2) {
                Entry entry4 = list.get(i4 == i3 ? 0 : i4 - 2);
                Entry entry5 = list.get(i4 - 1);
                Entry entry6 = list.get(i4);
                int i5 = i4 + 1;
                this.cubicPath.cubicTo(entry5.getXIndex() + ((entry6.getXIndex() - entry4.getXIndex()) * cubicIntensity), (entry5.getVal() + ((entry6.getVal() - entry4.getVal()) * cubicIntensity)) * phaseY, entry6.getXIndex() - ((r13.getXIndex() - entry5.getXIndex()) * cubicIntensity), (entry6.getVal() - ((list.get(i5).getVal() - entry5.getVal()) * cubicIntensity)) * phaseY, entry6.getXIndex(), entry6.getVal() * phaseY);
                iMin2 = iMin2;
                i4 = i5;
                i3 = 1;
            }
            if (iCeil > list.size() - 1) {
                if (list.size() >= 3) {
                    size = list.size() - 3;
                    i = 2;
                } else {
                    i = 2;
                    size = list.size() - 2;
                }
                Entry entry7 = list.get(size);
                Entry entry8 = list.get(list.size() - i);
                Entry entry9 = list.get(list.size() - 1);
                this.cubicPath.cubicTo(entry8.getXIndex() + ((entry9.getXIndex() - entry7.getXIndex()) * cubicIntensity), (entry8.getVal() + ((entry9.getVal() - entry7.getVal()) * cubicIntensity)) * phaseY, entry9.getXIndex() - ((entry9.getXIndex() - entry8.getXIndex()) * cubicIntensity), (entry9.getVal() - ((entry9.getVal() - entry8.getVal()) * cubicIntensity)) * phaseY, entry9.getXIndex(), entry9.getVal() * phaseY);
            }
        } else {
            f = phaseX;
        }
        if (lineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(lineDataSet, this.cubicFillPath, transformer, entryForXIndex.getXIndex(), entryForXIndex.getXIndex() + iCeil);
        }
        this.mRenderPaint.setColor(lineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect(null);
        if (f == 1.0f) {
            drawAngle(canvas, lineDataSet, list);
        }
    }

    protected void drawCubicFill(LineDataSet lineDataSet, Path path, Transformer transformer, int i, int i2) {
        float fillLinePosition = this.mChart.getFillFormatter().getFillLinePosition(lineDataSet, this.mChart.getLineData(), this.mChart.getYChartMax(), this.mChart.getYChartMin());
        path.lineTo(i2 - 1, fillLinePosition);
        path.lineTo(i, fillLinePosition);
        path.close();
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mRenderPaint.setColor(lineDataSet.getFillColor());
        this.mRenderPaint.setAlpha(lineDataSet.getFillAlpha());
        transformer.pathValueToPixel(path);
        this.mBitmapCanvas.drawPath(path, this.mRenderPaint);
        this.mRenderPaint.setAlpha(255);
    }

    protected void drawLinear(Canvas canvas, LineDataSet lineDataSet, List<Entry> list) {
        int indexOfDataSet = this.mChart.getLineData().getIndexOfDataSet(lineDataSet);
        Transformer transformer = this.mChart.getTransformer(lineDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = lineDataSet.isDashedLineEnabled() ? this.mBitmapCanvas : canvas;
        Entry entryForXIndex = lineDataSet.getEntryForXIndex(this.mMinX);
        Entry entryForXIndex2 = lineDataSet.getEntryForXIndex(this.mMaxX);
        int iMax = Math.max(lineDataSet.getEntryPosition(entryForXIndex), 0);
        int iMin = Math.min(lineDataSet.getEntryPosition(entryForXIndex2) + 1, list.size());
        int i = ((iMin - iMax) * 4) - 4;
        LineBuffer lineBuffer = this.mLineBuffers[indexOfDataSet];
        lineBuffer.setPhases(phaseX, phaseY);
        lineBuffer.limitFrom(iMax);
        lineBuffer.limitTo(iMin);
        lineBuffer.feed(list);
        transformer.pointValuesToPixel(lineBuffer.buffer);
        if (lineDataSet.getColors().size() > 1) {
            for (int i2 = 0; i2 < i && this.mViewPortHandler.isInBoundsRight(lineBuffer.buffer[i2]); i2 += 4) {
                int i3 = i2 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(lineBuffer.buffer[i3])) {
                    int i4 = i2 + 1;
                    if ((this.mViewPortHandler.isInBoundsTop(lineBuffer.buffer[i4]) || this.mViewPortHandler.isInBoundsBottom(lineBuffer.buffer[i2 + 3])) && (this.mViewPortHandler.isInBoundsTop(lineBuffer.buffer[i4]) || this.mViewPortHandler.isInBoundsBottom(lineBuffer.buffer[i2 + 3]))) {
                        this.mRenderPaint.setColor(lineDataSet.getColor((i2 / 4) + iMax));
                        canvas2.drawLine(lineBuffer.buffer[i2], lineBuffer.buffer[i4], lineBuffer.buffer[i3], lineBuffer.buffer[i2 + 3], this.mRenderPaint);
                    }
                }
            }
        } else {
            this.mRenderPaint.setColor(lineDataSet.getColor());
            canvas2.drawLines(lineBuffer.buffer, 0, i, this.mRenderPaint);
        }
        this.mRenderPaint.setPathEffect(null);
        if (!lineDataSet.isDrawFilledEnabled() || list.size() <= 0) {
            return;
        }
        drawLinearFill(canvas, lineDataSet, list, iMax, iMin, transformer);
    }

    protected void drawLinearFill(Canvas canvas, LineDataSet lineDataSet, List<Entry> list, int i, int i2, Transformer transformer) {
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mRenderPaint.setColor(lineDataSet.getFillColor());
        this.mRenderPaint.setAlpha(lineDataSet.getFillAlpha());
        Path pathGenerateFilledPath = generateFilledPath(list, this.mChart.getFillFormatter().getFillLinePosition(lineDataSet, this.mChart.getLineData(), this.mChart.getYChartMax(), this.mChart.getYChartMin()), i, i2);
        transformer.pathValueToPixel(pathGenerateFilledPath);
        canvas.drawPath(pathGenerateFilledPath, this.mRenderPaint);
        this.mRenderPaint.setAlpha(255);
    }

    private Path generateFilledPath(List<Entry> list, float f, int i, int i2) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        Path path = new Path();
        path.moveTo(list.get(i).getXIndex(), f);
        path.lineTo(list.get(i).getXIndex(), list.get(i).getVal() * phaseY);
        int iCeil = (int) Math.ceil(((i2 - i) * phaseX) + i);
        for (int i3 = i + 1; i3 < iCeil; i3++) {
            path.lineTo(r4.getXIndex(), list.get(i3).getVal() * phaseY);
        }
        path.lineTo(list.get(Math.max(Math.min(((int) Math.ceil(r9)) - 1, list.size() - 1), 0)).getXIndex(), f);
        path.close();
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        if (this.mChart.getLineData().getYValCount() < this.mChart.getMaxVisibleCount() * this.mViewPortHandler.getScaleX()) {
            List<T> dataSets = this.mChart.getLineData().getDataSets();
            for (int i = 0; i < dataSets.size(); i++) {
                LineDataSet lineDataSet = (LineDataSet) dataSets.get(i);
                if (lineDataSet.isDrawValuesEnabled()) {
                    applyValueTextStyle(lineDataSet);
                    Transformer transformer = this.mChart.getTransformer(lineDataSet.getAxisDependency());
                    int circleSize = (int) (lineDataSet.getCircleSize() * 1.75f);
                    if (!lineDataSet.isDrawCirclesEnabled()) {
                        circleSize /= 2;
                    }
                    List<? extends Entry> yVals = lineDataSet.getYVals();
                    Entry entryForXIndex = lineDataSet.getEntryForXIndex(this.mMinX);
                    Entry entryForXIndex2 = lineDataSet.getEntryForXIndex(this.mMaxX);
                    int iMax = Math.max(lineDataSet.getEntryPosition(entryForXIndex), 0);
                    float[] fArrGenerateTransformedValuesLine = transformer.generateTransformedValuesLine(yVals, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), iMax, Math.min(lineDataSet.getEntryPosition(entryForXIndex2) + 1, yVals.size()));
                    for (int i2 = 0; i2 < fArrGenerateTransformedValuesLine.length; i2 += 2) {
                        float f = fArrGenerateTransformedValuesLine[i2];
                        float f2 = fArrGenerateTransformedValuesLine[i2 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f)) {
                            break;
                        }
                        if (this.mViewPortHandler.isInBoundsLeft(f) && this.mViewPortHandler.isInBoundsY(f2)) {
                            canvas.drawText(lineDataSet.getValueFormatter().getFormattedValue(yVals.get((i2 / 2) + iMax).getVal()), f, f2 - circleSize, this.mValuePaint);
                        }
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    protected void drawCircles(Canvas canvas) {
        float f;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List<T> dataSets = this.mChart.getLineData().getDataSets();
        int i = 0;
        int i2 = 0;
        while (i2 < dataSets.size()) {
            LineDataSet lineDataSet = (LineDataSet) dataSets.get(i2);
            if (lineDataSet.isVisible() && lineDataSet.isDrawCirclesEnabled()) {
                this.mCirclePaintInner.setColor(lineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(lineDataSet.getAxisDependency());
                List<Entry> yVals = lineDataSet.getYVals();
                Entry entryForXIndex = lineDataSet.getEntryForXIndex(this.mMinX < 0 ? 0 : this.mMinX);
                Entry entryForXIndex2 = lineDataSet.getEntryForXIndex(this.mMaxX);
                int iMax = Math.max(lineDataSet.getEntryPosition(entryForXIndex), i);
                int iMin = Math.min(lineDataSet.getEntryPosition(entryForXIndex2) + 1, yVals.size());
                CircleBuffer circleBuffer = this.mCircleBuffers[i2];
                circleBuffer.setPhases(phaseX, phaseY);
                circleBuffer.limitFrom(iMax);
                circleBuffer.limitTo(iMin);
                circleBuffer.feed(yVals);
                transformer.pointValuesToPixel(circleBuffer.buffer);
                float circleSize = lineDataSet.getCircleSize() / 2.0f;
                int iCeil = ((int) Math.ceil(((iMin - iMax) * phaseX) + iMax)) * 2;
                int i3 = 0;
                while (i3 < iCeil) {
                    float f2 = circleBuffer.buffer[i3];
                    float f3 = circleBuffer.buffer[i3 + 1];
                    if (i3 == 11) {
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder();
                        f = phaseX;
                        sb.append("x=========");
                        sb.append(f2);
                        sb.append("y==========");
                        sb.append(f3);
                        printStream.println(sb.toString());
                    } else {
                        f = phaseX;
                    }
                    if (!this.mViewPortHandler.isInBoundsRight(f2)) {
                        break;
                    }
                    if (this.mViewPortHandler.isInBoundsLeft(f2) && this.mViewPortHandler.isInBoundsY(f3)) {
                        int circleColor = lineDataSet.getCircleColor((i3 / 2) + iMax);
                        this.mRenderPaint.setColor(circleColor);
                        canvas.drawCircle(f2, f3, lineDataSet.getCircleSize(), this.mRenderPaint);
                        if (lineDataSet.isDrawCircleHoleEnabled() && circleColor != this.mCirclePaintInner.getColor()) {
                            canvas.drawCircle(f2, f3, circleSize, this.mCirclePaintInner);
                        }
                    }
                    i3 += 2;
                    phaseX = f;
                }
                f = phaseX;
            } else {
                f = phaseX;
            }
            i2++;
            phaseX = f;
            i = 0;
        }
    }

    @SuppressLint({"NewApi"})
    public void drawAngle(Canvas canvas, LineDataSet lineDataSet, List<Entry> list) {
        TextPaint textPaint;
        int speedPoint = lineDataSet.getSpeedPoint();
        int hitPoint = lineDataSet.getHitPoint();
        int pageindex = lineDataSet.getPageindex();
        int languageId = lineDataSet.getLanguageId();
        System.out.println("hitPoint=" + hitPoint);
        lineDataSet.getClass();
        if (speedPoint == -1) {
            return;
        }
        int indexOfDataSet = this.mChart.getLineData().getIndexOfDataSet(lineDataSet);
        Transformer transformer = this.mChart.getTransformer(lineDataSet.getAxisDependency());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = this.mBitmapCanvas;
        Entry entryForXIndex = lineDataSet.getEntryForXIndex(this.mMinX);
        Entry entryForXIndex2 = lineDataSet.getEntryForXIndex(this.mMaxX);
        int iMax = Math.max(lineDataSet.getEntryPosition(entryForXIndex), 0);
        int iMin = Math.min(lineDataSet.getEntryPosition(entryForXIndex2) + 1, list.size());
        CircleBuffer circleBuffer = this.mCircleBuffers[indexOfDataSet];
        circleBuffer.limitFrom(iMax);
        circleBuffer.limitTo(iMin);
        circleBuffer.feed(list);
        transformer.pointValuesToPixel(circleBuffer.buffer);
        Paint paint = new Paint();
        paint.setColor(-1862270977);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(Utils.convertDpToPixel(0.5f));
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(-1);
        textPaint2.setTextSize(Utils.convertDpToPixel(10.0f));
        int i = speedPoint * 2;
        float f = circleBuffer.buffer[i - 2];
        float f2 = circleBuffer.buffer[i - 1];
        int i2 = hitPoint * 2;
        float f3 = circleBuffer.buffer[i2 - 2];
        float f4 = circleBuffer.buffer[i2 - 1];
        this.mRenderPaint.setColor(lineDataSet.getCircleColor(hitPoint));
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
        canvas2.drawCircle(f, f2, Utils.convertDpToPixel(3.0f), this.mRenderPaint);
        canvas2.drawCircle(f3, f4, Utils.convertDpToPixel(3.0f), this.mRenderPaint);
        float[] fArr = {f, this.mChart.getYChartMin(), f, Utils.convertDpToPixel(300.0f)};
        float[] fArr2 = {f3, this.mChart.getYChartMin(), f3, Utils.convertDpToPixel(300.0f)};
        if (pageindex == 0) {
            paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
            canvas2.drawLines(fArr, paint);
            canvas2.drawLines(fArr2, paint);
            if (indexOfDataSet == 1) {
                this.y11 = f2;
                this.y12 = f4;
                if (languageId == 1) {
                    canvas2.drawText(this.strArray[4] + ((int) list.get(speedPoint - 1).getVal()) + "km/h", f + Utils.convertDpToPixel(8.0f), f2 + Utils.convertDpToPixel(5.0f), textPaint2);
                    canvas2.drawText(this.strArray[6] + ((int) list.get(hitPoint - 1).getVal()) + "km/h", f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint2);
                } else {
                    canvas2.drawText(this.strArray[12] + ((int) list.get(speedPoint - 1).getVal()) + "km/h", f + Utils.convertDpToPixel(8.0f), f2 + Utils.convertDpToPixel(5.0f), textPaint2);
                    canvas2.drawText(this.strArray[14] + ((int) list.get(hitPoint - 1).getVal()) + "km/h", f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint2);
                }
            } else {
                if (Math.abs(f4 - this.y12) < Utils.convertDpToPixel(12.0f)) {
                    float fConvertDpToPixel = f4 - this.y12 > 0.0f ? Utils.convertDpToPixel(12.0f) - Math.abs(f4 - this.y12) : Math.abs(f4 - this.y12) - Utils.convertDpToPixel(12.0f);
                    if (languageId == 1) {
                        canvas2.drawText(this.strArray[7] + ((int) list.get(hitPoint - 1).getVal()) + "N", f3 + Utils.convertDpToPixel(8.0f), f4 + fConvertDpToPixel + Utils.convertDpToPixel(3.0f), textPaint2);
                    } else {
                        canvas2.drawText(this.strArray[15] + ((int) list.get(hitPoint - 1).getVal()) + "N", f3 + Utils.convertDpToPixel(8.0f), f4 + fConvertDpToPixel + Utils.convertDpToPixel(3.0f), textPaint2);
                    }
                } else if (languageId == 1) {
                    canvas2.drawText(this.strArray[7] + ((int) list.get(hitPoint - 1).getVal()) + "N", f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint2);
                } else {
                    canvas2.drawText(this.strArray[15] + ((int) list.get(hitPoint - 1).getVal()) + "N", f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint2);
                }
                if (languageId == 1) {
                    canvas2.drawText(this.strArray[5] + ((int) list.get(speedPoint - 1).getVal()) + "N", f + Utils.convertDpToPixel(8.0f), f2 + Utils.convertDpToPixel(5.0f), textPaint2);
                }
            }
        } else if (pageindex == 1) {
            canvas2.drawLine(f, f2, f3, f4, paint);
            canvas2.drawLine(f, f2, f + Utils.convertDpToPixel(65.0f), f2, paint);
            int degrees = (int) Math.toDegrees(Math.atan((f2 - f4) / (f3 - f)));
            paint.setStyle(Paint.Style.STROKE);
            canvas2.drawArc(new RectF(f - Utils.convertDpToPixel(15.0f), f2 - Utils.convertDpToPixel(15.0f), f + Utils.convertDpToPixel(15.0f), Utils.convertDpToPixel(15.0f) + f2), 360 - degrees, degrees, false, paint);
            if (languageId == 1) {
                textPaint = textPaint2;
                canvas2.drawText(this.strArray[0] + Integer.toString(degrees) + "°", Utils.convertDpToPixel(18.0f) + f, f2 - Utils.convertDpToPixel(3.0f), textPaint);
            } else {
                textPaint = textPaint2;
                canvas2.drawText(this.strArray[8] + Integer.toString(degrees) + "°", Utils.convertDpToPixel(18.0f) + f, f2 - Utils.convertDpToPixel(3.0f), textPaint);
            }
            if (indexOfDataSet == 1) {
                if (languageId == 1) {
                    canvas2.drawText(this.strArray[2], f, f2 + Utils.convertDpToPixel(13.0f), textPaint);
                    canvas2.drawText(this.strArray[3], f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint);
                } else {
                    canvas2.drawText(this.strArray[10], f, f2 + Utils.convertDpToPixel(13.0f), textPaint);
                    canvas2.drawText(this.strArray[11], f3 + Utils.convertDpToPixel(8.0f), f4 + Utils.convertDpToPixel(3.0f), textPaint);
                }
                float[] fArr3 = {f, this.mChart.getYChartMax(), f3, this.mChart.getYChartMax()};
                paint.setColor(lineDataSet.getColor());
                paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
                canvas2.drawLines(fArr, paint);
                canvas2.drawLines(fArr2, paint);
                paint.setPathEffect(null);
                paint.setStyle(Paint.Style.FILL);
                canvas2.drawLines(fArr3, paint);
                TextPaint textPaint3 = textPaint;
                canvas2.drawRect(f + Utils.convertDpToPixel(8.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(6.0f), Utils.convertDpToPixel(70.0f) + f, this.mChart.getYChartMax() + Utils.convertDpToPixel(22.0f), paint);
                if (languageId == 1) {
                    canvas2.drawText(this.strArray[1] + ((hitPoint - speedPoint) * 10) + "ms", f + Utils.convertDpToPixel(10.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(18.0f), textPaint3);
                } else {
                    canvas2.drawText(this.strArray[9] + ((hitPoint - speedPoint) * 10) + "ms", f + Utils.convertDpToPixel(10.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(18.0f), textPaint3);
                }
            } else {
                TextPaint textPaint4 = textPaint;
                float[] fArr4 = {f, this.mChart.getYChartMax() + Utils.convertDpToPixel(30.0f), f3, this.mChart.getYChartMax() + Utils.convertDpToPixel(30.0f)};
                paint.setColor(lineDataSet.getColor());
                paint.setPathEffect(new DashPathEffect(new float[]{7.0f, 7.0f, 7.0f, 7.0f}, 1.0f));
                canvas2.drawLines(fArr, paint);
                canvas2.drawLines(fArr2, paint);
                paint.setPathEffect(null);
                paint.setStyle(Paint.Style.FILL);
                canvas2.drawLines(fArr4, paint);
                canvas2.drawRect(f + Utils.convertDpToPixel(8.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(36.0f), f + Utils.convertDpToPixel(70.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(52.0f), paint);
                if (languageId == 1) {
                    canvas2.drawText(this.strArray[1] + ((hitPoint - speedPoint) * 10) + "ms", f + Utils.convertDpToPixel(10.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(18.0f), textPaint4);
                } else {
                    canvas2.drawText(this.strArray[9] + ((hitPoint - speedPoint) * 10) + "ms", f + Utils.convertDpToPixel(10.0f), this.mChart.getYChartMax() + Utils.convertDpToPixel(18.0f), textPaint4);
                }
            }
        }
        this.mRenderPaint.setPathEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i = 0; i < highlightArr.length; i++) {
            LineDataSet lineDataSet = (LineDataSet) this.mChart.getLineData().getDataSetByIndex(highlightArr[i].getDataSetIndex());
            if (lineDataSet != null && lineDataSet.isHighlightEnabled()) {
                this.mHighlightPaint.setColor(lineDataSet.getHighLightColor());
                int xIndex = highlightArr[i].getXIndex();
                float f = xIndex;
                if (f <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX() && lineDataSet.getYValForXIndex(xIndex) != Float.NaN) {
                    this.mAnimator.getPhaseY();
                    float[] fArr = {f, this.mChart.getYChartMax(), f, this.mChart.getYChartMin()};
                    this.mChart.getTransformer(lineDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                    canvas.drawLines(fArr, this.mHighlightPaint);
                }
            }
        }
    }
}
