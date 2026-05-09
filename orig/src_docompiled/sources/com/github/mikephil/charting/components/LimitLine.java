package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes.dex */
public class LimitLine {
    private DashPathEffect mDashPathEffect;
    private String mLabel;
    private LimitLabelPosition mLabelPosition;
    private float mLimit;
    private int mLineColor;
    private float mLineWidth;
    private float mTextSize;
    private Paint.Style mTextStyle;
    private int mValueTextColor;

    public enum LimitLabelPosition {
        POS_LEFT,
        POS_RIGHT
    }

    public LimitLine(float f) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(237, 91, 91);
        this.mValueTextColor = -16777216;
        this.mTextSize = 13.0f;
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.POS_RIGHT;
        this.mLimit = f;
    }

    public LimitLine(float f, String str) {
        this.mLimit = 0.0f;
        this.mLineWidth = 2.0f;
        this.mLineColor = Color.rgb(237, 91, 91);
        this.mValueTextColor = -16777216;
        this.mTextSize = 13.0f;
        this.mTextStyle = Paint.Style.FILL_AND_STROKE;
        this.mLabel = "";
        this.mDashPathEffect = null;
        this.mLabelPosition = LimitLabelPosition.POS_RIGHT;
        this.mLimit = f;
        this.mLabel = str;
    }

    public float getLimit() {
        return this.mLimit;
    }

    public void setLineWidth(float f) {
        if (f < 0.2f) {
            f = 0.2f;
        }
        if (f > 12.0f) {
            f = 12.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    public void setTextColor(int i) {
        this.mValueTextColor = i;
    }

    public int getTextColor() {
        return this.mValueTextColor;
    }

    public void setTextStyle(Paint.Style style) {
        this.mTextStyle = style;
    }

    public Paint.Style getTextStyle() {
        return this.mTextStyle;
    }

    public void setLabelPosition(LimitLabelPosition limitLabelPosition) {
        this.mLabelPosition = limitLabelPosition;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.mLabelPosition;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setTextSize(float f) {
        this.mTextSize = Utils.convertDpToPixel(f);
    }

    public float getTextSize() {
        return this.mTextSize;
    }
}
