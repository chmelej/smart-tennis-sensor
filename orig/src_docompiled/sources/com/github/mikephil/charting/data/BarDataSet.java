package com.github.mikephil.charting.data;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BarDataSet extends BarLineScatterCandleDataSet<BarEntry> {
    private int[] colors;
    private boolean isMulitColor;
    private int mBarShadowColor;
    private float mBarSpace;
    private int mEntryCountStacks;
    private int mHighLightAlpha;
    private String[] mStackLabels;
    private int mStackSize;

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.mBarSpace = 0.15f;
        this.mStackSize = 1;
        this.mBarShadowColor = Color.rgb(215, 215, 215);
        this.mHighLightAlpha = 120;
        this.mEntryCountStacks = 0;
        this.isMulitColor = false;
        this.mStackLabels = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb(0, 0, 0);
        calcStackSize(list);
        calcEntryCountIncludingStacks(list);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((BarEntry) this.mYVals.get(i)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        barDataSet.mColors = this.mColors;
        barDataSet.mStackSize = this.mStackSize;
        barDataSet.mBarSpace = this.mBarSpace;
        barDataSet.mBarShadowColor = this.mBarShadowColor;
        barDataSet.mStackLabels = this.mStackLabels;
        barDataSet.mHighLightColor = this.mHighLightColor;
        barDataSet.mHighLightAlpha = this.mHighLightAlpha;
        return barDataSet;
    }

    private void calcEntryCountIncludingStacks(List<BarEntry> list) {
        this.mEntryCountStacks = 0;
        for (int i = 0; i < list.size(); i++) {
            float[] vals = list.get(i).getVals();
            if (vals == null) {
                this.mEntryCountStacks++;
            } else {
                this.mEntryCountStacks += vals.length;
            }
        }
    }

    private void calcStackSize(List<BarEntry> list) {
        for (int i = 0; i < list.size(); i++) {
            float[] vals = list.get(i).getVals();
            if (vals != null && vals.length > this.mStackSize) {
                this.mStackSize = vals.length;
            }
        }
    }

    public int getStackSize() {
        return this.mStackSize;
    }

    public boolean isStacked() {
        return this.mStackSize > 1;
    }

    public int getEntryCountStacks() {
        return this.mEntryCountStacks;
    }

    public float getBarSpacePercent() {
        return this.mBarSpace * 100.0f;
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public void setBarSpacePercent(float f) {
        this.mBarSpace = f / 100.0f;
    }

    public void setBarShadowColor(int i) {
        this.mBarShadowColor = i;
    }

    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public void setHighLightAlpha(int i) {
        this.mHighLightAlpha = i;
    }

    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    public void setStackLabels(String[] strArr) {
        this.mStackLabels = strArr;
    }

    public String[] getStackLabels() {
        return this.mStackLabels;
    }

    public boolean isMulitColor() {
        return this.isMulitColor;
    }

    public void setMulitColor(boolean z) {
        this.isMulitColor = z;
    }

    public int[] getMultiColors() {
        return this.colors;
    }

    public void setMultiColors(int[] iArr) {
        this.colors = iArr;
    }
}
