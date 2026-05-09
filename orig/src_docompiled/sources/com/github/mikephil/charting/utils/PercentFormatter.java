package com.github.mikephil.charting.utils;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class PercentFormatter implements ValueFormatter {
    protected DecimalFormat mFormat = new DecimalFormat("###,###,##0.0");

    @Override // com.github.mikephil.charting.utils.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f) + " %";
    }
}
