package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.BarLineScatterCandleDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BarLineScatterCandleData<T extends BarLineScatterCandleDataSet<? extends Entry>> extends ChartData<T> {
    public BarLineScatterCandleData() {
    }

    public BarLineScatterCandleData(List<String> list) {
        super(list);
    }

    public BarLineScatterCandleData(String[] strArr) {
        super(strArr);
    }

    public BarLineScatterCandleData(List<String> list, List<T> list2) {
        super(list, list2);
    }

    public BarLineScatterCandleData(String[] strArr, List<T> list) {
        super(strArr, list);
    }
}
