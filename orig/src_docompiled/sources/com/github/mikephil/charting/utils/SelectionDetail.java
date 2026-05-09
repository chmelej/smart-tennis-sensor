package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.DataSet;

/* JADX INFO: loaded from: classes.dex */
public class SelectionDetail {
    public DataSet<?> dataSet;
    public int dataSetIndex;
    public float val;

    public SelectionDetail(float f, int i, DataSet<?> dataSet) {
        this.val = f;
        this.dataSetIndex = i;
        this.dataSet = dataSet;
    }
}
