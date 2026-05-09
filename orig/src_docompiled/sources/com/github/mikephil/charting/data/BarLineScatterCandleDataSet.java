package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BarLineScatterCandleDataSet<T extends Entry> extends DataSet<T> {
    protected int mHighLightColor;

    public BarLineScatterCandleDataSet(List<T> list, String str) {
        super(list, str);
        this.mHighLightColor = Color.rgb(255, 187, 115);
    }

    public void setHighLightColor(int i) {
        this.mHighLightColor = i;
    }

    public int getHighLightColor() {
        return this.mHighLightColor;
    }
}
