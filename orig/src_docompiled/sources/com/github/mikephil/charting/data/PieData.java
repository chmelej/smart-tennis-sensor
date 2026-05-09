package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PieData extends ChartData<PieDataSet> {
    public PieData() {
    }

    public PieData(List<String> list) {
        super(list);
    }

    public PieData(String[] strArr) {
        super(strArr);
    }

    public PieData(List<String> list, PieDataSet pieDataSet) {
        super(list, toList(pieDataSet));
    }

    public PieData(String[] strArr, PieDataSet pieDataSet) {
        super(strArr, toList(pieDataSet));
    }

    private static List<PieDataSet> toList(PieDataSet pieDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pieDataSet);
        return arrayList;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setDataSet(PieDataSet pieDataSet) {
        this.mDataSets.clear();
        this.mDataSets.add(pieDataSet);
        init();
    }

    public PieDataSet getDataSet() {
        return (PieDataSet) this.mDataSets.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public PieDataSet getDataSetByIndex(int i) {
        if (i == 0) {
            return getDataSet();
        }
        return null;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public PieDataSet getDataSetByLabel(String str, boolean z) {
        if (z) {
            if (str.equalsIgnoreCase(((PieDataSet) this.mDataSets.get(0)).getLabel())) {
                return (PieDataSet) this.mDataSets.get(0);
            }
            return null;
        }
        if (str.equals(((PieDataSet) this.mDataSets.get(0)).getLabel())) {
            return (PieDataSet) this.mDataSets.get(0);
        }
        return null;
    }
}
