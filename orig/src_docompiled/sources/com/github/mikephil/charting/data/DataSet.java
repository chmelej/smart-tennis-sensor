package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.DefaultValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ValueFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataSet<T extends Entry> {
    protected List<Integer> mColors;
    private String mLabel;
    protected ValueFormatter mValueFormatter;
    private Typeface mValueTypeface;
    protected List<T> mYVals;
    protected float mYMax = 0.0f;
    protected float mYMin = 0.0f;
    private float mYValueSum = 0.0f;
    protected int mLastStart = 0;
    protected int mLastEnd = 0;
    private boolean mVisible = true;
    protected boolean mDrawValues = true;
    private int mValueColor = -16777216;
    private float mValueTextSize = 17.0f;
    protected YAxis.AxisDependency mAxisDependency = YAxis.AxisDependency.LEFT;
    protected boolean mHighlightEnabled = true;

    public abstract DataSet<T> copy();

    public DataSet(List<T> list, String str) {
        this.mColors = null;
        this.mYVals = null;
        this.mLabel = "DataSet";
        this.mLabel = str;
        this.mYVals = list;
        if (this.mYVals == null) {
            this.mYVals = new ArrayList();
        }
        this.mColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        calcMinMax(this.mLastStart, this.mLastEnd);
        calcYValueSum();
    }

    public void notifyDataSetChanged() {
        calcMinMax(this.mLastStart, this.mLastEnd);
        calcYValueSum();
    }

    protected void calcMinMax(int i, int i2) {
        if (this.mYVals.size() == 0) {
            return;
        }
        if (i2 == 0) {
            i2 = this.mYVals.size() - 1;
        }
        this.mLastStart = i;
        this.mLastEnd = i2;
        this.mYMin = Float.MAX_VALUE;
        this.mYMax = Float.MIN_VALUE;
        while (i <= i2) {
            T t = this.mYVals.get(i);
            if (t != null && !Float.isNaN(t.getVal())) {
                if (t.getVal() < this.mYMin) {
                    this.mYMin = t.getVal();
                }
                if (t.getVal() > this.mYMax) {
                    this.mYMax = t.getVal();
                }
            }
            i++;
        }
    }

    private void calcYValueSum() {
        this.mYValueSum = 0.0f;
        for (int i = 0; i < this.mYVals.size(); i++) {
            T t = this.mYVals.get(i);
            if (t != null) {
                this.mYValueSum += Math.abs(t.getVal());
            }
        }
    }

    public int getEntryCount() {
        return this.mYVals.size();
    }

    public float getYValForXIndex(int i) {
        Entry entryForXIndex = getEntryForXIndex(i);
        if (entryForXIndex == null || entryForXIndex.getXIndex() != i) {
            return Float.NaN;
        }
        return entryForXIndex.getVal();
    }

    public T getEntryForXIndex(int i) {
        int size = this.mYVals.size() - 1;
        int i2 = 0;
        T t = null;
        while (i2 <= size) {
            int i3 = (size + i2) / 2;
            if (i == this.mYVals.get(i3).getXIndex()) {
                while (i3 > 0 && this.mYVals.get(i3 - 1).getXIndex() == i) {
                    i3--;
                }
                return this.mYVals.get(i3);
            }
            if (i > this.mYVals.get(i3).getXIndex()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
            t = this.mYVals.get(i3);
        }
        return t;
    }

    public List<T> getEntriesForXIndex(int i) {
        ArrayList arrayList = new ArrayList();
        int size = this.mYVals.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (size + i2) / 2;
            T t = this.mYVals.get(i3);
            if (i == t.getXIndex()) {
                while (i3 > 0 && this.mYVals.get(i3 - 1).getXIndex() == i) {
                    i3--;
                }
                size = this.mYVals.size();
                while (i3 < size) {
                    t = this.mYVals.get(i3);
                    if (t.getXIndex() != i) {
                        break;
                    }
                    arrayList.add(t);
                    i3++;
                }
            }
            if (i > t.getXIndex()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return arrayList;
    }

    public List<T> getYVals() {
        return this.mYVals;
    }

    public float getYValueSum() {
        return this.mYValueSum;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public int getValueCount() {
        return this.mYVals.size();
    }

    public int getIndexInEntries(int i) {
        for (int i2 = 0; i2 < this.mYVals.size(); i2++) {
            if (i == this.mYVals.get(i2).getXIndex()) {
                return i2;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i = 0; i < this.mYVals.size(); i++) {
            stringBuffer.append(this.mYVals.get(i).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(this.mLabel == null ? "" : this.mLabel);
        sb.append(", entries: ");
        sb.append(this.mYVals.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setVisible(boolean z) {
        this.mVisible = z;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public void setAxisDependency(YAxis.AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
    }

    public void setDrawValues(boolean z) {
        this.mDrawValues = z;
    }

    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    public void addEntry(Entry entry) {
        if (entry == null) {
            return;
        }
        float val = entry.getVal();
        if (this.mYVals == null) {
            this.mYVals = new ArrayList();
        }
        if (this.mYVals.size() == 0) {
            this.mYMax = val;
            this.mYMin = val;
        } else {
            if (this.mYMax < val) {
                this.mYMax = val;
            }
            if (this.mYMin > val) {
                this.mYMin = val;
            }
        }
        this.mYValueSum += val;
        this.mYVals.add(entry);
    }

    public boolean removeEntry(T t) {
        if (t == null) {
            return false;
        }
        boolean zRemove = this.mYVals.remove(t);
        if (zRemove) {
            this.mYValueSum -= t.getVal();
            calcMinMax(this.mLastStart, this.mLastEnd);
        }
        return zRemove;
    }

    public boolean removeEntry(int i) {
        return removeEntry(getEntryForXIndex(i));
    }

    public void setColors(List<Integer> list) {
        this.mColors = list;
    }

    public void setColors(int[] iArr) {
        this.mColors = ColorTemplate.createColors(iArr);
    }

    public void setColors(int[] iArr, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(i)));
        }
        this.mColors = arrayList;
    }

    public void addColor(int i) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.add(Integer.valueOf(i));
    }

    public void setColor(int i) {
        resetColors();
        this.mColors.add(Integer.valueOf(i));
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public int getColor(int i) {
        return this.mColors.get(i % this.mColors.size()).intValue();
    }

    public int getColor() {
        return this.mColors.get(0).intValue();
    }

    public void resetColors() {
        this.mColors = new ArrayList();
    }

    public void setHighlightEnabled(boolean z) {
        this.mHighlightEnabled = z;
    }

    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    public int getEntryPosition(Entry entry) {
        for (int i = 0; i < this.mYVals.size(); i++) {
            if (entry.equalTo(this.mYVals.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.mValueFormatter = valueFormatter;
    }

    public ValueFormatter getValueFormatter() {
        if (this.mValueFormatter == null) {
            return new DefaultValueFormatter(1);
        }
        return this.mValueFormatter;
    }

    public boolean needsDefaultFormatter() {
        return this.mValueFormatter == null || (this.mValueFormatter instanceof DefaultValueFormatter);
    }

    public void setValueTextColor(int i) {
        this.mValueColor = i;
    }

    public int getValueTextColor() {
        return this.mValueColor;
    }

    public void setValueTypeface(Typeface typeface) {
        this.mValueTypeface = typeface;
    }

    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    public void setValueTextSize(float f) {
        this.mValueTextSize = Utils.convertDpToPixel(f);
    }

    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    public boolean contains(Entry entry) {
        Iterator<T> it = this.mYVals.iterator();
        while (it.hasNext()) {
            if (it.next().equals(entry)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.mYVals.clear();
        this.mLastStart = 0;
        this.mLastEnd = 0;
        notifyDataSetChanged();
    }
}
