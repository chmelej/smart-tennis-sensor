package com.github.mikephil.charting.data;

/* JADX INFO: loaded from: classes.dex */
public class BubbleEntry extends Entry {
    private float mSize;

    public BubbleEntry(int i, float f, float f2) {
        super(f, i);
        this.mSize = 0.0f;
        this.mSize = f2;
    }

    public BubbleEntry(int i, float f, float f2, Object obj) {
        super(f, i, obj);
        this.mSize = 0.0f;
        this.mSize = f2;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getXIndex(), getVal(), this.mSize, getData());
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f) {
        this.mSize = f;
    }
}
