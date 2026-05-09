package com.github.mikephil.charting.utils;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class LargeValueFormatter implements ValueFormatter {
    private static final int MAX_LENGTH = 4;
    private static final String[] SUFFIX = {"", "k", "m", "b", "t"};
    private DecimalFormat mFormat;
    private String mText;

    public LargeValueFormatter() {
        this.mText = "";
        this.mFormat = new DecimalFormat("###E0");
    }

    public LargeValueFormatter(String str) {
        this();
        this.mText = str;
    }

    @Override // com.github.mikephil.charting.utils.ValueFormatter
    public String getFormattedValue(float f) {
        return makePretty(f) + this.mText;
    }

    private String makePretty(double d) {
        String str = this.mFormat.format(d);
        String strReplaceAll = str.replaceAll("E[0-9]", SUFFIX[Character.getNumericValue(str.charAt(str.length() - 1)) / 3]);
        while (true) {
            if (strReplaceAll.length() <= 4 && !strReplaceAll.matches("[0-9]+\\.[a-z]")) {
                return strReplaceAll;
            }
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 2) + strReplaceAll.substring(strReplaceAll.length() - 1);
        }
    }
}
