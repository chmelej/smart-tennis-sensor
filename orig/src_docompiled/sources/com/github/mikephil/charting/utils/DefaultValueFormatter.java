package com.github.mikephil.charting.utils;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValueFormatter implements ValueFormatter {
    private DecimalFormat mFormat;

    public DefaultValueFormatter(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.utils.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f);
    }
}
