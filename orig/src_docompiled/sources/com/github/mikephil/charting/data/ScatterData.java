package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScatterData extends BarLineScatterCandleData<ScatterDataSet> {
    public ScatterData() {
    }

    public ScatterData(List<String> list) {
        super(list);
    }

    public ScatterData(String[] strArr) {
        super(strArr);
    }

    public ScatterData(List<String> list, List<ScatterDataSet> list2) {
        super(list, list2);
    }

    public ScatterData(String[] strArr, List<ScatterDataSet> list) {
        super(strArr, list);
    }

    public ScatterData(List<String> list, ScatterDataSet scatterDataSet) {
        super(list, toList(scatterDataSet));
    }

    public ScatterData(String[] strArr, ScatterDataSet scatterDataSet) {
        super(strArr, toList(scatterDataSet));
    }

    private static List<ScatterDataSet> toList(ScatterDataSet scatterDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(scatterDataSet);
        return arrayList;
    }

    public float getGreatestShapeSize() {
        Iterator it = this.mDataSets.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            float scatterShapeSize = ((ScatterDataSet) it.next()).getScatterShapeSize();
            if (scatterShapeSize > f) {
                f = scatterShapeSize;
            }
        }
        return f;
    }
}
