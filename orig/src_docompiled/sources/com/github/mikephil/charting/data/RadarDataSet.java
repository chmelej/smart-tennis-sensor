package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RadarDataSet extends LineRadarDataSet<Entry> {
    public RadarDataSet(List<Entry> list, String str) {
        super(list, str);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        RadarDataSet radarDataSet = new RadarDataSet(arrayList, getLabel());
        radarDataSet.mColors = this.mColors;
        radarDataSet.mHighLightColor = this.mHighLightColor;
        return radarDataSet;
    }
}
