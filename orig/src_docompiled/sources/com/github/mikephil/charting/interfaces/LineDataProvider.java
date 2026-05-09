package com.github.mikephil.charting.interfaces;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.utils.FillFormatter;

/* JADX INFO: loaded from: classes.dex */
public interface LineDataProvider extends BarLineScatterCandleDataProvider {
    FillFormatter getFillFormatter();

    LineData getLineData();

    void setFillFormatter(FillFormatter fillFormatter);
}
