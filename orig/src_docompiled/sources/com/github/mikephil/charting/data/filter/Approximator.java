package com.github.mikephil.charting.data.filter;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Approximator {
    private boolean[] keep;
    private float mDeltaRatio;
    private float mScaleRatio;
    private double mTolerance;
    private ApproximatorType mType;

    public enum ApproximatorType {
        NONE,
        DOUGLAS_PEUCKER
    }

    public Approximator() {
        this.mType = ApproximatorType.DOUGLAS_PEUCKER;
        this.mTolerance = 0.0d;
        this.mScaleRatio = 1.0f;
        this.mDeltaRatio = 1.0f;
        this.mType = ApproximatorType.NONE;
    }

    public Approximator(ApproximatorType approximatorType, double d) {
        this.mType = ApproximatorType.DOUGLAS_PEUCKER;
        this.mTolerance = 0.0d;
        this.mScaleRatio = 1.0f;
        this.mDeltaRatio = 1.0f;
        setup(approximatorType, d);
    }

    public void setup(ApproximatorType approximatorType, double d) {
        this.mType = approximatorType;
        this.mTolerance = d;
    }

    public void setTolerance(double d) {
        this.mTolerance = d;
    }

    public void setType(ApproximatorType approximatorType) {
        this.mType = approximatorType;
    }

    public void setRatios(float f, float f2) {
        this.mDeltaRatio = f;
        this.mScaleRatio = f2;
    }

    public List<Entry> filter(List<Entry> list) {
        return filter(list, this.mTolerance);
    }

    public List<Entry> filter(List<Entry> list, double d) {
        if (d <= 0.0d) {
            return list;
        }
        this.keep = new boolean[list.size()];
        switch (this.mType) {
        }
        return list;
    }

    private List<Entry> reduceWithDouglasPeuker(List<Entry> list, double d) {
        if (d <= 0.0d || list.size() < 3) {
            return list;
        }
        this.keep[0] = true;
        this.keep[list.size() - 1] = true;
        algorithmDouglasPeucker(list, d, 0, list.size() - 1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (this.keep[i]) {
                Entry entry = list.get(i);
                arrayList.add(new Entry(entry.getVal(), entry.getXIndex()));
            }
        }
        return arrayList;
    }

    private void algorithmDouglasPeucker(List<Entry> list, double d, int i, int i2) {
        int i3 = i + 1;
        if (i2 <= i3) {
            return;
        }
        double d2 = 0.0d;
        Entry entry = list.get(i);
        Entry entry2 = list.get(i2);
        int i4 = 0;
        while (i3 < i2) {
            double dCalcAngleBetweenLines = calcAngleBetweenLines(entry, entry2, entry, list.get(i3));
            if (dCalcAngleBetweenLines > d2) {
                i4 = i3;
                d2 = dCalcAngleBetweenLines;
            }
            i3++;
        }
        if (d2 > d) {
            this.keep[i4] = true;
            algorithmDouglasPeucker(list, d, i, i4);
            algorithmDouglasPeucker(list, d, i4, i2);
        }
    }

    public double calcPointToLineDistance(Entry entry, Entry entry2, Entry entry3) {
        return ((double) Math.abs(((entry3.getXIndex() - entry.getXIndex()) * (entry2.getVal() - entry.getVal())) - ((entry3.getVal() - entry.getVal()) * (entry2.getXIndex() - entry.getXIndex())))) / Math.sqrt((r0 * r0) + ((entry2.getVal() - entry.getVal()) * (entry2.getVal() - entry.getVal())));
    }

    public double calcAngleBetweenLines(Entry entry, Entry entry2, Entry entry3, Entry entry4) {
        return Math.abs(calcAngleWithRatios(entry, entry2) - calcAngleWithRatios(entry3, entry4));
    }

    public double calcAngleWithRatios(Entry entry, Entry entry2) {
        return (Math.atan2((entry2.getVal() * this.mScaleRatio) - (entry.getVal() * this.mScaleRatio), (entry2.getXIndex() * this.mDeltaRatio) - (entry.getXIndex() * this.mDeltaRatio)) * 180.0d) / 3.141592653589793d;
    }

    public double calcAngle(Entry entry, Entry entry2) {
        return (Math.atan2(entry2.getVal() - entry.getVal(), entry2.getXIndex() - entry.getXIndex()) * 180.0d) / 3.141592653589793d;
    }
}
