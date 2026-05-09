package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RadarData extends ChartData<RadarDataSet> {
    public RadarData() {
    }

    public RadarData(List<String> list) {
        super(list);
    }

    public RadarData(String[] strArr) {
        super(strArr);
    }

    public RadarData(List<String> list, List<RadarDataSet> list2) {
        super(list, list2);
    }

    public RadarData(String[] strArr, List<RadarDataSet> list) {
        super(strArr, list);
    }

    public RadarData(List<String> list, RadarDataSet radarDataSet) {
        super(list, toList(radarDataSet));
    }

    public RadarData(String[] strArr, RadarDataSet radarDataSet) {
        super(strArr, toList(radarDataSet));
    }

    private static List<RadarDataSet> toList(RadarDataSet radarDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(radarDataSet);
        return arrayList;
    }
}
