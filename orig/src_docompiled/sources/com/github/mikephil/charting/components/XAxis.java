package com.github.mikephil.charting.components;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XAxis extends AxisBase {
    protected List<String> mValues = new ArrayList();
    public int mLabelWidth = 1;
    public int mLabelHeight = 1;
    private int mSpaceBetweenLabels = 4;
    public int mAxisLabelModulus = 1;
    private boolean mIsAxisModulusCustom = false;
    public int mYAxisLabelModulus = 1;
    private boolean mAvoidFirstLastClipping = false;
    private XAxisPosition mPosition = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxisPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(XAxisPosition xAxisPosition) {
        this.mPosition = xAxisPosition;
    }

    public void setSpaceBetweenLabels(int i) {
        this.mSpaceBetweenLabels = i;
    }

    public void setLabelsToSkip(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mIsAxisModulusCustom = true;
        this.mAxisLabelModulus = i + 1;
    }

    public void resetLabelsToSkip() {
        this.mIsAxisModulusCustom = false;
    }

    public boolean isAxisModulusCustom() {
        return this.mIsAxisModulusCustom;
    }

    public int getSpaceBetweenLabels() {
        return this.mSpaceBetweenLabels;
    }

    public void setAvoidFirstLastClipping(boolean z) {
        this.mAvoidFirstLastClipping = z;
    }

    public boolean isAvoidFirstLastClippingEnabled() {
        return this.mAvoidFirstLastClipping;
    }

    public void setValues(List<String> list) {
        this.mValues = list;
    }

    public List<String> getValues() {
        return this.mValues;
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public String getLongestLabel() {
        String str = "";
        for (int i = 0; i < this.mValues.size(); i++) {
            String str2 = this.mValues.get(i);
            if (str.length() < str2.length()) {
                str = str2;
            }
        }
        return str;
    }
}
