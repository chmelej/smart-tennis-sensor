package com.github.mikephil.charting.data;

import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PieDataSet extends DataSet<Entry> {
    private float mShift;
    private float mSliceSpace;

    public PieDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mSliceSpace = 0.0f;
        this.mShift = 18.0f;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        pieDataSet.mColors = this.mColors;
        pieDataSet.mSliceSpace = this.mSliceSpace;
        pieDataSet.mShift = this.mShift;
        return pieDataSet;
    }

    public void setSliceSpace(float f) {
        if (f > 45.0f) {
            f = 45.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mSliceSpace = f;
    }

    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    public void setSelectionShift(float f) {
        this.mShift = Utils.convertDpToPixel(f);
    }

    public float getSelectionShift() {
        return this.mShift;
    }
}
