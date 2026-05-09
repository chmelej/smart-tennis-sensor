package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LineData extends BarLineScatterCandleData<LineDataSet> {
    public LineData() {
    }

    public LineData(List<String> list) {
        super(list);
    }

    public LineData(String[] strArr) {
        super(strArr);
    }

    public LineData(List<String> list, List<LineDataSet> list2) {
        super(list, list2);
    }

    public LineData(String[] strArr, List<LineDataSet> list) {
        super(strArr, list);
    }

    public LineData(List<String> list, LineDataSet lineDataSet) {
        super(list, toList(lineDataSet));
    }

    public LineData(String[] strArr, LineDataSet lineDataSet) {
        super(strArr, toList(lineDataSet));
    }

    private static List<LineDataSet> toList(LineDataSet lineDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineDataSet);
        return arrayList;
    }
}
