package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LineBuffer extends AbstractBuffer<Entry> {
    public LineBuffer(int i) {
        super(i < 4 ? 4 : i);
    }

    public void moveTo(float f, float f2) {
        if (this.index != 0) {
            return;
        }
        float[] fArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        fArr[i] = f;
        float[] fArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        fArr2[i2] = f2;
        this.buffer[this.index] = f;
        this.buffer[this.index + 1] = f2;
    }

    public void lineTo(float f, float f2) {
        if (this.index == 2) {
            float[] fArr = this.buffer;
            int i = this.index;
            this.index = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.buffer;
            int i2 = this.index;
            this.index = i2 + 1;
            fArr2[i2] = f2;
            return;
        }
        float f3 = this.buffer[this.index - 2];
        float f4 = this.buffer[this.index - 1];
        float[] fArr3 = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        fArr3[i3] = f3;
        float[] fArr4 = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        fArr4[i4] = f4;
        float[] fArr5 = this.buffer;
        int i5 = this.index;
        this.index = i5 + 1;
        fArr5[i5] = f;
        float[] fArr6 = this.buffer;
        int i6 = this.index;
        this.index = i6 + 1;
        fArr6[i6] = f2;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(List<Entry> list) {
        moveTo(list.get(this.mFrom).getXIndex(), list.get(this.mFrom).getVal() * this.phaseY);
        int iCeil = (int) Math.ceil(((this.mTo - this.mFrom) * this.phaseX) + this.mFrom);
        for (int i = this.mFrom + 1; i < iCeil; i++) {
            lineTo(r2.getXIndex(), list.get(i).getVal() * this.phaseY);
        }
        reset();
    }
}
