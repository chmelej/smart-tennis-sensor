package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Transformer {
    protected ViewPortHandler mViewPortHandler;
    protected Matrix mMatrixValueToPx = new Matrix();
    protected Matrix mMatrixOffset = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public void prepareMatrixValuePx(float f, float f2, float f3, float f4) {
        float fContentWidth = this.mViewPortHandler.contentWidth() / f2;
        float fContentHeight = this.mViewPortHandler.contentHeight() / f3;
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f, -f4);
        this.mMatrixValueToPx.postScale(fContentWidth, -fContentHeight);
    }

    public void prepareMatrixOffset(boolean z) {
        this.mMatrixOffset.reset();
        if (!z) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
        } else {
            this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
            this.mMatrixOffset.postScale(1.0f, -1.0f);
        }
    }

    public float[] generateTransformedValuesScatter(List<? extends Entry> list, float f) {
        float[] fArr = new float[list.size() * 2];
        for (int i = 0; i < fArr.length; i += 2) {
            Entry entry = list.get(i / 2);
            if (entry != null) {
                fArr[i] = entry.getXIndex();
                fArr[i + 1] = entry.getVal() * f;
            }
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesBubble(List<? extends Entry> list, float f, float f2, int i, int i2) {
        int iCeil = ((int) Math.ceil(i2 - i)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            Entry entry = list.get((i3 / 2) + i);
            if (entry != null) {
                fArr[i3] = ((entry.getXIndex() - i) * f) + i;
                fArr[i3 + 1] = entry.getVal() * f2;
            }
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesLine(List<? extends Entry> list, float f, float f2, int i, int i2) {
        int iCeil = ((int) Math.ceil((i2 - i) * f)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            Entry entry = list.get((i3 / 2) + i);
            if (entry != null) {
                fArr[i3] = entry.getXIndex();
                fArr[i3 + 1] = entry.getVal() * f2;
            }
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesCandle(List<CandleEntry> list, float f, float f2, int i, int i2) {
        int iCeil = ((int) Math.ceil((i2 - i) * f)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            CandleEntry candleEntry = list.get((i3 / 2) + i);
            if (candleEntry != null) {
                fArr[i3] = candleEntry.getXIndex();
                fArr[i3 + 1] = candleEntry.getHigh() * f2;
            }
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesBarChart(List<? extends Entry> list, int i, BarData barData, float f) {
        float[] fArr = new float[list.size() * 2];
        int dataSetCount = barData.getDataSetCount();
        float groupSpace = barData.getGroupSpace();
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            int i3 = i2 / 2;
            float xIndex = r4.getXIndex() + ((dataSetCount - 1) * i3) + i + (i3 * groupSpace) + (groupSpace / 2.0f);
            float val = list.get(i3).getVal();
            fArr[i2] = xIndex;
            fArr[i2 + 1] = val * f;
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesHorizontalBarChart(List<? extends Entry> list, int i, BarData barData, float f) {
        float[] fArr = new float[list.size() * 2];
        int dataSetCount = barData.getDataSetCount();
        float groupSpace = barData.getGroupSpace();
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            int i3 = i2 / 2;
            fArr[i2] = list.get(i3).getVal() * f;
            fArr[i2 + 1] = r4.getXIndex() + ((dataSetCount - 1) * i3) + i + (i3 * groupSpace) + (groupSpace / 2.0f);
        }
        pointValuesToPixel(fArr);
        return fArr;
    }

    public void pathValueToPixel(Path path) {
        path.transform(this.mMatrixValueToPx);
        path.transform(this.mViewPortHandler.getMatrixTouch());
        path.transform(this.mMatrixOffset);
    }

    public void pathValuesToPixel(List<Path> list) {
        for (int i = 0; i < list.size(); i++) {
            pathValueToPixel(list.get(i));
        }
    }

    public void pointValuesToPixel(float[] fArr) {
        this.mMatrixValueToPx.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().mapPoints(fArr);
        this.mMatrixOffset.mapPoints(fArr);
    }

    public void rectValueToPixel(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixel(RectF rectF, float f) {
        if (rectF.top > 0.0f) {
            rectF.top *= f;
        } else {
            rectF.bottom *= f;
        }
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixelHorizontal(RectF rectF, float f) {
        if (rectF.left > 0.0f) {
            rectF.left *= f;
        } else {
            rectF.right *= f;
        }
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValuesToPixel(List<RectF> list) {
        for (int i = 0; i < list.size(); i++) {
            rectValueToPixel(list.get(i));
        }
    }

    public void pixelsToValue(float[] fArr) {
        Matrix matrix = new Matrix();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().invert(matrix);
        matrix.mapPoints(fArr);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public PointD getValuesByTouchPoint(float f, float f2) {
        pixelsToValue(new float[]{f, f2});
        return new PointD(r0[0], r0[1]);
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }
}
