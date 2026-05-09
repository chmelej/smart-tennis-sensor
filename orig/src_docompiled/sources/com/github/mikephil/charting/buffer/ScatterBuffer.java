package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScatterBuffer extends AbstractBuffer<Entry> {
    public ScatterBuffer(int i) {
        super(i);
    }

    protected void addForm(float f, float f2) {
        float[] fArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        fArr[i] = f;
        float[] fArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        fArr2[i2] = f2;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(List<Entry> list) {
        float size = list.size() * this.phaseX;
        for (int i = 0; i < size; i++) {
            addForm(r2.getXIndex(), list.get(i).getVal() * this.phaseY);
        }
        reset();
    }
}
