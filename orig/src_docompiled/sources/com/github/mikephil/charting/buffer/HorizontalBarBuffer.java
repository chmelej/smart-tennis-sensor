package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i, float f, int i2, boolean z) {
        super(i, f, i2, z);
    }

    @Override // com.github.mikephil.charting.buffer.BarBuffer, com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(List<BarEntry> list) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float size = list.size() * this.phaseX;
        int i = this.mDataSetCount - 1;
        float f6 = this.mBarSpace / 2.0f;
        float f7 = this.mGroupSpace / 2.0f;
        int i2 = 0;
        while (true) {
            float f8 = i2;
            if (f8 < size) {
                BarEntry barEntry = list.get(i2);
                float xIndex = barEntry.getXIndex() + (i2 * i) + this.mDataSetIndex + (this.mGroupSpace * f8) + f7;
                float val = barEntry.getVal();
                float[] vals = barEntry.getVals();
                float f9 = 0.0f;
                float f10 = 0.5f;
                if (!this.mContainsStacks || vals == null) {
                    f = size;
                    float f11 = (xIndex - 0.5f) + f6;
                    float f12 = (xIndex + 0.5f) - f6;
                    if (this.mInverted) {
                        f2 = 0.0f;
                        f3 = val >= 0.0f ? val : 0.0f;
                        if (val > 0.0f) {
                            val = 0.0f;
                        }
                    } else {
                        f2 = 0.0f;
                        float f13 = val >= 0.0f ? val : 0.0f;
                        if (val > 0.0f) {
                            val = 0.0f;
                        }
                        float f14 = f13;
                        f3 = val;
                        val = f14;
                    }
                    if (val > f2) {
                        val *= this.phaseY;
                    } else {
                        f3 *= this.phaseY;
                    }
                    addBar(f3, f12, val, f11);
                } else {
                    float positiveSum = barEntry.getPositiveSum();
                    float negativeSum = barEntry.getNegativeSum();
                    float f15 = positiveSum;
                    int i3 = 0;
                    while (i3 < vals.length) {
                        float f16 = vals[i3];
                        if (f16 >= f9) {
                            f15 -= f16;
                            f4 = f16 + f15;
                        } else {
                            negativeSum -= Math.abs(f16);
                            f4 = f16 + negativeSum;
                        }
                        float f17 = (xIndex - f10) + f6;
                        float f18 = (xIndex + f10) - f6;
                        float f19 = size;
                        if (this.mInverted) {
                            f5 = f4 >= f9 ? f4 : 0.0f;
                            if (f4 > f9) {
                                f4 = 0.0f;
                            }
                        } else {
                            float f20 = f4 >= f9 ? f4 : 0.0f;
                            if (f4 > f9) {
                                f4 = 0.0f;
                            }
                            float f21 = f4;
                            f4 = f20;
                            f5 = f21;
                        }
                        if (f4 > f9) {
                            f4 *= this.phaseY;
                        } else {
                            f5 *= this.phaseY;
                        }
                        addBar(f5, f18, f4, f17);
                        i3++;
                        size = f19;
                        f9 = 0.0f;
                        f10 = 0.5f;
                    }
                    f = size;
                }
                i2++;
                size = f;
            } else {
                reset();
                return;
            }
        }
    }
}
