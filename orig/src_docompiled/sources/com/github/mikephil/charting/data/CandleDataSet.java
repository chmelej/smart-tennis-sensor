package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CandleDataSet extends BarLineScatterCandleDataSet<CandleEntry> {
    private float mBodySpace;
    protected int mDecreasingColor;
    protected Paint.Style mDecreasingPaintStyle;
    protected int mIncreasingColor;
    protected Paint.Style mIncreasingPaintStyle;
    protected int mShadowColor;
    private float mShadowWidth;

    public CandleDataSet(List<CandleEntry> list, String str) {
        super(list, str);
        this.mShadowWidth = 3.0f;
        this.mBodySpace = 0.1f;
        this.mIncreasingPaintStyle = Paint.Style.FILL;
        this.mDecreasingPaintStyle = Paint.Style.STROKE;
        this.mIncreasingColor = -1;
        this.mDecreasingColor = -1;
        this.mShadowColor = -1;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<CandleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((CandleEntry) this.mYVals.get(i)).copy());
        }
        CandleDataSet candleDataSet = new CandleDataSet(arrayList, getLabel());
        candleDataSet.mColors = this.mColors;
        candleDataSet.mShadowWidth = this.mShadowWidth;
        candleDataSet.mBodySpace = this.mBodySpace;
        candleDataSet.mHighLightColor = this.mHighLightColor;
        candleDataSet.mIncreasingPaintStyle = this.mIncreasingPaintStyle;
        candleDataSet.mDecreasingPaintStyle = this.mDecreasingPaintStyle;
        candleDataSet.mShadowColor = this.mShadowColor;
        return candleDataSet;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    protected void calcMinMax(int i, int i2) {
        if (this.mYVals.size() == 0) {
            return;
        }
        List<T> list = this.mYVals;
        if (i2 == 0) {
            i2 = this.mYVals.size() - 1;
        }
        this.mLastStart = i;
        this.mLastEnd = i2;
        this.mYMin = ((CandleEntry) this.mYVals.get(i)).getLow();
        this.mYMax = ((CandleEntry) this.mYVals.get(i)).getHigh();
        while (true) {
            i++;
            if (i > i2) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) list.get(i);
            if (candleEntry.getLow() < this.mYMin) {
                this.mYMin = candleEntry.getLow();
            }
            if (candleEntry.getHigh() > this.mYMax) {
                this.mYMax = candleEntry.getHigh();
            }
        }
    }

    public void setBodySpace(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 0.45f) {
            f = 0.45f;
        }
        this.mBodySpace = f;
    }

    public float getBodySpace() {
        return this.mBodySpace;
    }

    public void setShadowWidth(float f) {
        this.mShadowWidth = Utils.convertDpToPixel(f);
    }

    public float getShadowWidth() {
        return this.mShadowWidth;
    }

    public void setDecreasingColor(int i) {
        this.mDecreasingColor = i;
    }

    public int getDecreasingColor() {
        return this.mDecreasingColor;
    }

    public void setIncreasingColor(int i) {
        this.mIncreasingColor = i;
    }

    public int getIncreasingColor() {
        return this.mIncreasingColor;
    }

    public Paint.Style getDecreasingPaintStyle() {
        return this.mDecreasingPaintStyle;
    }

    public void setDecreasingPaintStyle(Paint.Style style) {
        this.mDecreasingPaintStyle = style;
    }

    public Paint.Style getIncreasingPaintStyle() {
        return this.mIncreasingPaintStyle;
    }

    public void setIncreasingPaintStyle(Paint.Style style) {
        this.mIncreasingPaintStyle = style;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public void setShadowColor(int i) {
        this.mShadowColor = i;
    }
}
