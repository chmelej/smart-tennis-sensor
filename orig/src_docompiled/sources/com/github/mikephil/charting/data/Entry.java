package com.github.mikephil.charting.data;

/* JADX INFO: loaded from: classes.dex */
public class Entry {
    private Object mData;
    private float mVal;
    private int mXIndex;

    public Entry(float f, int i) {
        this.mVal = 0.0f;
        this.mXIndex = 0;
        this.mData = null;
        this.mVal = f;
        this.mXIndex = i;
    }

    public Entry(float f, int i, Object obj) {
        this(f, i);
        this.mData = obj;
    }

    public int getXIndex() {
        return this.mXIndex;
    }

    public void setXIndex(int i) {
        this.mXIndex = i;
    }

    public float getVal() {
        return this.mVal;
    }

    public void setVal(float f) {
        this.mVal = f;
    }

    public Object getData() {
        return this.mData;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public Entry copy() {
        return new Entry(this.mVal, this.mXIndex, this.mData);
    }

    public boolean equalTo(Entry entry) {
        return entry != null && entry.mData == this.mData && entry.mXIndex == this.mXIndex && Math.abs(entry.mVal - this.mVal) <= 1.0E-5f;
    }

    public String toString() {
        return "Entry, xIndex: " + this.mXIndex + " val (sum): " + getVal();
    }
}
