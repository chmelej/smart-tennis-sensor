package com.github.mikephil.charting.components;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Legend extends ComponentBase {
    private Bitmap[] mBitMaps;
    private Boolean[] mCalculatedLabelBreakPoints;
    private FSize[] mCalculatedLabelSizes;
    private FSize[] mCalculatedLineSizes;
    private int[] mColors;
    private LegendDirection mDirection;
    private int[] mExtraColors;
    private String[] mExtraLabels;
    private float mFormSize;
    private float mFormToTextSpace;
    private boolean mIsLegendCustom;
    private String[] mLabels;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendPosition mPosition;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        SQUARE,
        CIRCLE,
        LINE,
        MYPIC
    }

    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        PIECHART_CENTER
    }

    public void test() {
    }

    public Legend() {
        this.mIsLegendCustom = false;
        this.mPosition = LegendPosition.BELOW_CHART_LEFT;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new FSize[0];
        this.mCalculatedLabelBreakPoints = new Boolean[0];
        this.mCalculatedLineSizes = new FSize[0];
        this.mFormSize = Utils.convertDpToPixel(8.0f);
        this.mXEntrySpace = Utils.convertDpToPixel(6.0f);
        this.mYEntrySpace = Utils.convertDpToPixel(0.0f);
        this.mFormToTextSpace = Utils.convertDpToPixel(5.0f);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mStackSpace = Utils.convertDpToPixel(3.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(7.0f);
    }

    public Legend(int[] iArr, String[] strArr) {
        this();
        if (iArr == null || strArr == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        }
        if (iArr.length != strArr.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mColors = iArr;
        this.mLabels = strArr;
    }

    public Legend(List<Integer> list, List<String> list2) {
        this();
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        }
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mColors = Utils.convertIntegers(list);
        this.mLabels = Utils.convertStrings(list2);
    }

    public Legend(Bitmap[] bitmapArr, String[] strArr) {
        this();
        if (bitmapArr == null || strArr == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        }
        if (bitmapArr.length != strArr.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mBitMaps = bitmapArr;
        this.mLabels = strArr;
    }

    public void setComputedColors(List<Integer> list) {
        this.mColors = Utils.convertIntegers(list);
    }

    public void setComputedLabels(List<String> list) {
        this.mLabels = Utils.convertStrings(list);
    }

    public float getMaximumEntryWidth(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                float fCalcTextWidth = Utils.calcTextWidth(paint, this.mLabels[i]);
                if (fCalcTextWidth > f) {
                    f = fCalcTextWidth;
                }
            }
        }
        return f + this.mFormSize + this.mFormToTextSpace;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                float fCalcTextHeight = Utils.calcTextHeight(paint, this.mLabels[i]);
                if (fCalcTextHeight > f) {
                    f = fCalcTextHeight;
                }
            }
        }
        return f;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public String[] getLabels() {
        return this.mLabels;
    }

    public String getLabel(int i) {
        return this.mLabels[i];
    }

    public int[] getExtraColors() {
        return this.mExtraColors;
    }

    public String[] getExtraLabels() {
        return this.mExtraLabels;
    }

    public void setExtra(List<Integer> list, List<String> list2) {
        this.mExtraColors = Utils.convertIntegers(list);
        this.mExtraLabels = Utils.convertStrings(list2);
    }

    public void setExtra(int[] iArr, String[] strArr) {
        this.mExtraColors = iArr;
        this.mExtraLabels = strArr;
    }

    public void setCustom(int[] iArr, String[] strArr) {
        if (iArr.length != strArr.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mLabels = strArr;
        this.mColors = iArr;
        this.mIsLegendCustom = true;
    }

    public void setCustom(Bitmap[] bitmapArr, String[] strArr) {
        if (bitmapArr.length != strArr.length) {
            throw new IllegalArgumentException("bitMaps array and labels array need to be of same size");
        }
        this.mBitMaps = bitmapArr;
        this.mLabels = strArr;
        this.mIsLegendCustom = true;
    }

    public void setBitMapCustom(List<Bitmap> list, List<String> list2) {
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("bitMaps array and labels array need to be of same size");
        }
        this.mBitMaps = Utils.convertBitMaps(list);
        this.mLabels = Utils.convertStrings(list2);
        this.mIsLegendCustom = true;
    }

    public void setCustom(List<Integer> list, List<String> list2) {
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        }
        this.mColors = Utils.convertIntegers(list);
        this.mLabels = Utils.convertStrings(list2);
        this.mIsLegendCustom = true;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public LegendPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(LegendPosition legendPosition) {
        this.mPosition = legendPosition;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormSize(float f) {
        this.mFormSize = Utils.convertDpToPixel(f);
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public void setXEntrySpace(float f) {
        this.mXEntrySpace = Utils.convertDpToPixel(f);
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public void setYEntrySpace(float f) {
        this.mYEntrySpace = Utils.convertDpToPixel(f);
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public void setFormToTextSpace(float f) {
        this.mFormToTextSpace = Utils.convertDpToPixel(f);
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public void setStackSpace(float f) {
        this.mStackSpace = f;
    }

    public float getFullWidth(Paint paint) {
        float fCalcTextWidth = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                if (this.mColors[i] != -2) {
                    fCalcTextWidth += this.mFormSize + this.mFormToTextSpace;
                }
                fCalcTextWidth += Utils.calcTextWidth(paint, this.mLabels[i]);
                if (i < this.mLabels.length - 1) {
                    fCalcTextWidth += this.mXEntrySpace;
                }
            } else {
                fCalcTextWidth += this.mFormSize;
                if (i < this.mLabels.length - 1) {
                    fCalcTextWidth += this.mStackSpace;
                }
            }
        }
        return fCalcTextWidth;
    }

    public float getFullHeight(Paint paint) {
        float fCalcTextHeight = 0.0f;
        for (int i = 0; i < this.mLabels.length; i++) {
            if (this.mLabels[i] != null) {
                fCalcTextHeight += Utils.calcTextHeight(paint, this.mLabels[i]);
                if (i < this.mLabels.length - 1) {
                    fCalcTextHeight += this.mYEntrySpace;
                }
            }
        }
        return fCalcTextHeight;
    }

    public void setWordWrapEnabled(boolean z) {
        this.mWordWrapEnabled = z;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public void setMaxSizePercent(float f) {
        this.mMaxSizePercent = f;
    }

    public FSize[] getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public Boolean[] getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public FSize[] getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0132 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void calculateDimensions(android.graphics.Paint r19, com.github.mikephil.charting.utils.ViewPortHandler r20) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.calculateDimensions(android.graphics.Paint, com.github.mikephil.charting.utils.ViewPortHandler):void");
    }

    public Bitmap[] getmBitMaps() {
        return this.mBitMaps;
    }

    public void setmBitMaps(Bitmap[] bitmapArr) {
        this.mBitMaps = bitmapArr;
    }
}
