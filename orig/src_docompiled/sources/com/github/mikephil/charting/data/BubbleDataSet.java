package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BubbleDataSet extends BarLineScatterCandleDataSet<BubbleEntry> {
    private float mHighlightCircleWidth;
    protected float mMaxSize;
    protected float mXMax;
    protected float mXMin;

    public BubbleDataSet(List<BubbleEntry> list, String str) {
        super(list, str);
        this.mHighlightCircleWidth = 2.5f;
    }

    public void setHighlightCircleWidth(float f) {
        this.mHighlightCircleWidth = Utils.convertDpToPixel(f);
    }

    public float getHighlightCircleWidth() {
        return this.mHighlightCircleWidth;
    }

    public void setColor(int i, int i2) {
        super.setColor(Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i)));
    }

    @Override // com.github.mikephil.charting.data.DataSet
    protected void calcMinMax(int i, int i2) {
        if (this.mYVals.size() == 0) {
            return;
        }
        List<T> yVals = getYVals();
        if (i2 == 0) {
            i2 = this.mYVals.size() - 1;
        }
        this.mLastStart = i;
        this.mLastEnd = i2;
        this.mYMin = yMin((BubbleEntry) yVals.get(i));
        this.mYMax = yMax((BubbleEntry) yVals.get(i));
        while (i <= i2) {
            BubbleEntry bubbleEntry = (BubbleEntry) yVals.get(i);
            float fYMin = yMin(bubbleEntry);
            float fYMax = yMax(bubbleEntry);
            if (fYMin < this.mYMin) {
                this.mYMin = fYMin;
            }
            if (fYMax > this.mYMax) {
                this.mYMax = fYMax;
            }
            float fXMin = xMin(bubbleEntry);
            float fXMax = xMax(bubbleEntry);
            if (fXMin < this.mXMin) {
                this.mXMin = fXMin;
            }
            if (fXMax > this.mXMax) {
                this.mXMax = fXMax;
            }
            float fLargestSize = largestSize(bubbleEntry);
            if (fLargestSize > this.mMaxSize) {
                this.mMaxSize = fLargestSize;
            }
            i++;
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BubbleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((BubbleEntry) this.mYVals.get(i)).copy());
        }
        BubbleDataSet bubbleDataSet = new BubbleDataSet(arrayList, getLabel());
        bubbleDataSet.mColors = this.mColors;
        bubbleDataSet.mHighLightColor = this.mHighLightColor;
        return bubbleDataSet;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getMaxSize() {
        return this.mMaxSize;
    }

    private float yMin(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float yMax(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float xMin(BubbleEntry bubbleEntry) {
        return bubbleEntry.getXIndex();
    }

    private float xMax(BubbleEntry bubbleEntry) {
        return bubbleEntry.getXIndex();
    }

    private float largestSize(BubbleEntry bubbleEntry) {
        return bubbleEntry.getSize();
    }
}
