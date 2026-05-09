package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CandleShadowBuffer extends AbstractBuffer<CandleEntry> {
    public CandleShadowBuffer(int i) {
        super(i);
    }

    private void addShadow(float f, float f2, float f3, float f4) {
        float[] fArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        fArr[i] = f;
        float[] fArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        fArr2[i2] = f2;
        float[] fArr3 = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        fArr3[i3] = f3;
        float[] fArr4 = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        fArr4[i4] = f4;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(List<CandleEntry> list) {
        int iCeil = (int) Math.ceil(((this.mTo - this.mFrom) * this.phaseX) + this.mFrom);
        for (int i = this.mFrom; i < iCeil; i++) {
            CandleEntry candleEntry = list.get(i);
            addShadow(candleEntry.getXIndex(), candleEntry.getHigh() * this.phaseY, candleEntry.getXIndex(), candleEntry.getLow() * this.phaseY);
        }
        reset();
    }
}
