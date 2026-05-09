package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BarData extends BarLineScatterCandleData<BarDataSet> {
    private float mGroupSpace;

    public BarData() {
        this.mGroupSpace = 0.8f;
    }

    public BarData(List<String> list) {
        super(list);
        this.mGroupSpace = 0.8f;
    }

    public BarData(String[] strArr) {
        super(strArr);
        this.mGroupSpace = 0.8f;
    }

    public BarData(List<String> list, List<BarDataSet> list2) {
        super(list, list2);
        this.mGroupSpace = 0.8f;
    }

    public BarData(String[] strArr, List<BarDataSet> list) {
        super(strArr, list);
        this.mGroupSpace = 0.8f;
    }

    public BarData(List<String> list, BarDataSet barDataSet) {
        super(list, toList(barDataSet));
        this.mGroupSpace = 0.8f;
    }

    public BarData(String[] strArr, BarDataSet barDataSet) {
        super(strArr, toList(barDataSet));
        this.mGroupSpace = 0.8f;
    }

    private static List<BarDataSet> toList(BarDataSet barDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(barDataSet);
        return arrayList;
    }

    public float getGroupSpace() {
        if (this.mDataSets.size() <= 1) {
            return 0.0f;
        }
        return this.mGroupSpace;
    }

    public void setGroupSpace(float f) {
        this.mGroupSpace = f / 100.0f;
    }

    public boolean isGrouped() {
        return this.mDataSets.size() > 1;
    }
}
