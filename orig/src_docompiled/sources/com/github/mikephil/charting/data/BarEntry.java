package com.github.mikephil.charting.data;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class BarEntry extends Entry {
    private float[] mVals;

    public BarEntry(float[] fArr, int i) {
        super(calcSum(fArr), i);
        this.mVals = fArr;
    }

    public BarEntry(float f, int i) {
        super(f, i);
    }

    public BarEntry(float[] fArr, int i, String str) {
        super(calcSum(fArr), i, str);
        this.mVals = fArr;
    }

    public BarEntry(float f, int i, Object obj) {
        super(f, i, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getVal(), getXIndex(), getData());
        barEntry.mVals = this.mVals;
        return barEntry;
    }

    public float[] getVals() {
        return this.mVals;
    }

    public void setVals(float[] fArr) {
        setVal(calcSum(fArr));
        this.mVals = fArr;
    }

    public int getClosestIndexAbove(float f) {
        if (this.mVals == null) {
            return 0;
        }
        Log.i("TOUCHVALUE", f + "");
        int length = this.mVals.length + (-1);
        float f2 = 0.0f;
        while (length > 0 && f > this.mVals[length] + f2) {
            f2 += this.mVals[length];
            length--;
        }
        return length;
    }

    public float getBelowSum(int i) {
        float f = 0.0f;
        if (this.mVals == null) {
            return 0.0f;
        }
        for (int length = this.mVals.length - 1; length > i && length >= 0; length--) {
            f += this.mVals[length];
        }
        return f;
    }

    private static float calcSum(float[] fArr) {
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    public float getPositiveSum() {
        if (this.mVals == null) {
            return 0.0f;
        }
        float f = 0.0f;
        for (float f2 : this.mVals) {
            if (f2 >= 0.0f) {
                f += f2;
            }
        }
        return f;
    }

    public float getNegativeSum() {
        if (this.mVals == null) {
            return 0.0f;
        }
        float fAbs = 0.0f;
        for (float f : this.mVals) {
            if (f <= 0.0f) {
                fAbs += Math.abs(f);
            }
        }
        return fAbs;
    }
}
