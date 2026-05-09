package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LineDataSet extends LineRadarDataSet<Entry> {
    public final int NOANGLE;
    int hitpoint;
    private int languageID;
    private int mCircleColorHole;
    private List<Integer> mCircleColors;
    private float mCircleSize;
    private float mCubicIntensity;
    private DashPathEffect mDashPathEffect;
    private boolean mDrawCircleHole;
    private boolean mDrawCircles;
    private boolean mDrawCubic;
    int pageindex;
    int speedpoint;

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mCircleColors = null;
        this.mCircleColorHole = -1;
        this.mCircleSize = 8.0f;
        this.mCubicIntensity = 0.2f;
        this.mDashPathEffect = null;
        this.mDrawCircles = true;
        this.mDrawCubic = false;
        this.mDrawCircleHole = true;
        this.NOANGLE = -1;
        this.speedpoint = -1;
        this.hitpoint = -1;
        this.pageindex = 0;
        this.languageID = 1;
        this.mCircleColors = new ArrayList();
        this.mCircleColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public void setSwingPoint(int i, int i2, int i3, int i4) {
        this.speedpoint = i;
        this.hitpoint = i2;
        this.pageindex = i3;
        this.languageID = i4;
    }

    public int getSpeedPoint() {
        return this.speedpoint;
    }

    public int getHitPoint() {
        return this.hitpoint;
    }

    public int getPageindex() {
        return this.pageindex;
    }

    public int getLanguageId() {
        return this.languageID;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        lineDataSet.mColors = this.mColors;
        lineDataSet.mCircleSize = this.mCircleSize;
        lineDataSet.mCircleColors = this.mCircleColors;
        lineDataSet.mDashPathEffect = this.mDashPathEffect;
        lineDataSet.mDrawCircles = this.mDrawCircles;
        lineDataSet.mDrawCubic = this.mDrawCubic;
        lineDataSet.mHighLightColor = this.mHighLightColor;
        return lineDataSet;
    }

    public void setCubicIntensity(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.05f) {
            f = 0.05f;
        }
        this.mCubicIntensity = f;
    }

    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    public void setCircleSize(float f) {
        this.mCircleSize = Utils.convertDpToPixel(f);
    }

    public float getCircleSize() {
        return this.mCircleSize;
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

    public void setDrawCircles(boolean z) {
        this.mDrawCircles = z;
    }

    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    public void setDrawCubic(boolean z) {
        this.mDrawCubic = z;
    }

    public boolean isDrawCubicEnabled() {
        return this.mDrawCubic;
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    public int getCircleColor(int i) {
        return this.mCircleColors.get(i % this.mCircleColors.size()).intValue();
    }

    public void setCircleColors(List<Integer> list) {
        this.mCircleColors = list;
    }

    public void setCircleColors(int[] iArr) {
        this.mCircleColors = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(i)));
        }
        this.mCircleColors = arrayList;
    }

    public void setCircleColor(int i) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(i));
    }

    public void resetCircleColors() {
        this.mCircleColors = new ArrayList();
    }

    public void setCircleColorHole(int i) {
        this.mCircleColorHole = i;
    }

    public int getCircleHoleColor() {
        return this.mCircleColorHole;
    }

    public void setDrawCircleHole(boolean z) {
        this.mDrawCircleHole = z;
    }

    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }
}
