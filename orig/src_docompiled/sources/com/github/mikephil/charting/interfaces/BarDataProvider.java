package com.github.mikephil.charting.interfaces;

import com.github.mikephil.charting.data.BarData;

/* JADX INFO: loaded from: classes.dex */
public interface BarDataProvider extends BarLineScatterCandleDataProvider {
    BarData getBarData();

    boolean isDrawBarShadowEnabled();

    boolean isDrawHighlightArrowEnabled();

    boolean isDrawValueAboveBarEnabled();

    boolean isDrawValuesForWholeStackEnabled();
}
