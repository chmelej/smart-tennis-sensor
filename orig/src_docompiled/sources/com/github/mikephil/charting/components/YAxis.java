package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.DefaultValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ValueFormatter;

/* JADX INFO: loaded from: classes.dex */
public class YAxis extends AxisBase {
    private AxisDependency mAxisDependency;
    public float mAxisMaximum;
    public float mAxisMinimum;
    public float mAxisRange;
    protected float mCustomAxisMax;
    protected float mCustomAxisMin;
    public int mDecimals;
    private boolean mDrawTopYLabelEntry;
    public float[] mEntries;
    public int mEntryCount;
    protected boolean mInverted;
    private int mLabelCount;
    private YAxisLabelPosition mPosition;
    protected boolean mShowOnlyMinMax;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    protected boolean mStartAtZero;
    protected ValueFormatter mValueFormatter;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.mEntries = new float[0];
        this.mLabelCount = 6;
        this.mDrawTopYLabelEntry = true;
        this.mShowOnlyMinMax = false;
        this.mInverted = false;
        this.mStartAtZero = true;
        this.mCustomAxisMin = Float.NaN;
        this.mCustomAxisMax = Float.NaN;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mAxisMaximum = 0.0f;
        this.mAxisMinimum = 0.0f;
        this.mAxisRange = 0.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.mEntries = new float[0];
        this.mLabelCount = 6;
        this.mDrawTopYLabelEntry = true;
        this.mShowOnlyMinMax = false;
        this.mInverted = false;
        this.mStartAtZero = true;
        this.mCustomAxisMin = Float.NaN;
        this.mCustomAxisMax = Float.NaN;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mAxisMaximum = 0.0f;
        this.mAxisMinimum = 0.0f;
        this.mAxisRange = 0.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.mPosition = yAxisLabelPosition;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public void setDrawTopYLabelEntry(boolean z) {
        this.mDrawTopYLabelEntry = z;
    }

    public void setLabelCount(int i) {
        if (i > 25) {
            i = 25;
        }
        if (i < 2) {
            i = 2;
        }
        this.mLabelCount = i;
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public void setShowOnlyMinMax(boolean z) {
        this.mShowOnlyMinMax = z;
    }

    public boolean isShowOnlyMinMaxEnabled() {
        return this.mShowOnlyMinMax;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    public void setStartAtZero(boolean z) {
        this.mStartAtZero = z;
    }

    public boolean isStartAtZeroEnabled() {
        return this.mStartAtZero;
    }

    public float getAxisMinValue() {
        return this.mCustomAxisMin;
    }

    public void setAxisMinValue(float f) {
        this.mCustomAxisMin = f;
    }

    public void resetAxisMinValue() {
        this.mCustomAxisMin = Float.NaN;
    }

    public float getAxisMaxValue() {
        return this.mCustomAxisMax;
    }

    public void setAxisMaxValue(float f) {
        this.mCustomAxisMax = f;
    }

    public void resetAxisMaxValue() {
        this.mCustomAxisMax = Float.NaN;
    }

    public void setSpaceTop(float f) {
        this.mSpacePercentTop = f;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public void setSpaceBottom(float f) {
        this.mSpacePercentBottom = f;
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return Utils.calcTextWidth(paint, getLongestLabel()) + (getXOffset() * 2.0f);
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return Utils.calcTextHeight(paint, getLongestLabel()) + (Utils.convertDpToPixel(2.5f) * 2.0f) + getYOffset();
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public String getLongestLabel() {
        String str = "";
        for (int i = 0; i < this.mEntries.length; i++) {
            String formattedLabel = getFormattedLabel(i);
            if (str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public String getFormattedLabel(int i) {
        return (i < 0 || i >= this.mEntries.length) ? "" : getValueFormatter().getFormattedValue(this.mEntries[i]);
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.mValueFormatter = valueFormatter;
    }

    public ValueFormatter getValueFormatter() {
        return this.mValueFormatter;
    }

    public boolean needsDefaultFormatter() {
        return this.mValueFormatter == null || (this.mValueFormatter instanceof DefaultValueFormatter);
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }
}
