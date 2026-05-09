package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CandleData extends BarLineScatterCandleData<CandleDataSet> {
    public CandleData() {
    }

    public CandleData(List<String> list) {
        super(list);
    }

    public CandleData(String[] strArr) {
        super(strArr);
    }

    public CandleData(List<String> list, List<CandleDataSet> list2) {
        super(list, list2);
    }

    public CandleData(String[] strArr, List<CandleDataSet> list) {
        super(strArr, list);
    }

    public CandleData(List<String> list, CandleDataSet candleDataSet) {
        super(list, toList(candleDataSet));
    }

    public CandleData(String[] strArr, CandleDataSet candleDataSet) {
        super(strArr, toList(candleDataSet));
    }

    private static List<CandleDataSet> toList(CandleDataSet candleDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(candleDataSet);
        return arrayList;
    }
}
