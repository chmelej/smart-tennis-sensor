package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ValueFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ChartData<T extends DataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected int mLastEnd;
    protected int mLastStart;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    private float mXValAverageLength;
    protected List<String> mXVals;
    protected float mYMax;
    protected float mYMin;
    private int mYValCount;
    private float mYValueSum;

    public ChartData() {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mYValCount = 0;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mXValAverageLength = 0.0f;
        this.mXVals = new ArrayList();
        this.mDataSets = new ArrayList();
    }

    public ChartData(List<String> list) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mYValCount = 0;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mXValAverageLength = 0.0f;
        this.mXVals = list;
        this.mDataSets = new ArrayList();
        init();
    }

    public ChartData(String[] strArr) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mYValCount = 0;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mXValAverageLength = 0.0f;
        this.mXVals = arrayToList(strArr);
        this.mDataSets = new ArrayList();
        init();
    }

    public ChartData(List<String> list, List<T> list2) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mYValCount = 0;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mXValAverageLength = 0.0f;
        this.mXVals = list;
        this.mDataSets = list2;
        init();
    }

    public ChartData(String[] strArr, List<T> list) {
        this.mYMax = 0.0f;
        this.mYMin = 0.0f;
        this.mLeftAxisMax = 0.0f;
        this.mLeftAxisMin = 0.0f;
        this.mRightAxisMax = 0.0f;
        this.mRightAxisMin = 0.0f;
        this.mYValueSum = 0.0f;
        this.mYValCount = 0;
        this.mLastStart = 0;
        this.mLastEnd = 0;
        this.mXValAverageLength = 0.0f;
        this.mXVals = arrayToList(strArr);
        this.mDataSets = list;
        init();
    }

    private List<String> arrayToList(String[] strArr) {
        return Arrays.asList(strArr);
    }

    protected void init() {
        isLegal();
        calcMinMax(this.mLastStart, this.mLastEnd);
        calcYValueSum();
        calcYValueCount();
        calcXValAverageLength();
    }

    private void calcXValAverageLength() {
        float length = 1.0f;
        if (this.mXVals.size() <= 0) {
            this.mXValAverageLength = 1.0f;
            return;
        }
        for (int i = 0; i < this.mXVals.size(); i++) {
            length += this.mXVals.get(i).length();
        }
        this.mXValAverageLength = length / this.mXVals.size();
    }

    private void isLegal() {
        if (this.mDataSets == null) {
            return;
        }
        for (int i = 0; i < this.mDataSets.size(); i++) {
            if (this.mDataSets.get(i).getYVals().size() > this.mXVals.size()) {
                throw new IllegalArgumentException("One or more of the DataSet Entry arrays are longer than the x-values array of this ChartData object.");
            }
        }
    }

    public void notifyDataChanged() {
        init();
    }

    public void calcMinMax(int i, int i2) {
        if (this.mDataSets == null || this.mDataSets.size() < 1) {
            this.mYMax = 0.0f;
            this.mYMin = 0.0f;
            return;
        }
        this.mLastStart = i;
        this.mLastEnd = i2;
        this.mYMin = Float.MAX_VALUE;
        this.mYMax = Float.MIN_VALUE;
        for (int i3 = 0; i3 < this.mDataSets.size(); i3++) {
            this.mDataSets.get(i3).calcMinMax(i, i2);
            if (this.mDataSets.get(i3).getYMin() < this.mYMin) {
                this.mYMin = this.mDataSets.get(i3).getYMin();
            }
            if (this.mDataSets.get(i3).getYMax() > this.mYMax) {
                this.mYMax = this.mDataSets.get(i3).getYMax();
            }
        }
        DataSet firstLeft = getFirstLeft();
        if (firstLeft != null) {
            this.mLeftAxisMax = firstLeft.getYMax();
            this.mLeftAxisMin = firstLeft.getYMin();
            for (T t : this.mDataSets) {
                if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (t.getYMin() < this.mLeftAxisMin) {
                        this.mLeftAxisMin = t.getYMin();
                    }
                    if (t.getYMax() > this.mLeftAxisMax) {
                        this.mLeftAxisMax = t.getYMax();
                    }
                }
            }
        }
        DataSet firstRight = getFirstRight();
        if (firstRight != null) {
            this.mRightAxisMax = firstRight.getYMax();
            this.mRightAxisMin = firstRight.getYMin();
            for (T t2 : this.mDataSets) {
                if (t2.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                    if (t2.getYMin() < this.mRightAxisMin) {
                        this.mRightAxisMin = t2.getYMin();
                    }
                    if (t2.getYMax() > this.mRightAxisMax) {
                        this.mRightAxisMax = t2.getYMax();
                    }
                }
            }
        }
        handleEmptyAxis(firstLeft, firstRight);
    }

    protected void calcYValueSum() {
        this.mYValueSum = 0.0f;
        if (this.mDataSets == null) {
            return;
        }
        for (int i = 0; i < this.mDataSets.size(); i++) {
            this.mYValueSum += Math.abs(this.mDataSets.get(i).getYValueSum());
        }
    }

    protected void calcYValueCount() {
        this.mYValCount = 0;
        if (this.mDataSets == null) {
            return;
        }
        int entryCount = 0;
        for (int i = 0; i < this.mDataSets.size(); i++) {
            entryCount += this.mDataSets.get(i).getEntryCount();
        }
        this.mYValCount = entryCount;
    }

    public int getDataSetCount() {
        if (this.mDataSets == null) {
            return 0;
        }
        return this.mDataSets.size();
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisMin;
        }
        return this.mRightAxisMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisMax;
        }
        return this.mRightAxisMax;
    }

    public float getXValAverageLength() {
        return this.mXValAverageLength;
    }

    public float getYValueSum() {
        return this.mYValueSum;
    }

    public int getYValCount() {
        return this.mYValCount;
    }

    public List<String> getXVals() {
        return this.mXVals;
    }

    public void addXValue(String str) {
        this.mXValAverageLength = (this.mXValAverageLength + str.length()) / 2.0f;
        this.mXVals.add(str);
    }

    public void removeXValue(int i) {
        this.mXVals.remove(i);
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    protected int getDataSetIndexByLabel(List<T> list, String str, boolean z) {
        int i = 0;
        if (z) {
            while (i < list.size()) {
                if (str.equalsIgnoreCase(list.get(i).getLabel())) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < list.size()) {
            if (str.equals(list.get(i).getLabel())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getXValCount() {
        return this.mXVals.size();
    }

    protected String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i = 0; i < this.mDataSets.size(); i++) {
            strArr[i] = this.mDataSets.get(i).getLabel();
        }
        return strArr;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        return this.mDataSets.get(highlight.getDataSetIndex()).getEntryForXIndex(highlight.getXIndex());
    }

    public T getDataSetByLabel(String str, boolean z) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(dataSetIndexByLabel);
    }

    public T getDataSetByIndex(int i) {
        if (this.mDataSets == null || i < 0 || i >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(i);
    }

    public void addDataSet(T t) {
        if (t == null) {
            return;
        }
        this.mYValCount += t.getEntryCount();
        this.mYValueSum += t.getYValueSum();
        if (this.mDataSets.size() <= 0) {
            this.mYMax = t.getYMax();
            this.mYMin = t.getYMin();
            if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                this.mLeftAxisMax = t.getYMax();
                this.mLeftAxisMin = t.getYMin();
            } else {
                this.mRightAxisMax = t.getYMax();
                this.mRightAxisMin = t.getYMin();
            }
        } else {
            if (this.mYMax < t.getYMax()) {
                this.mYMax = t.getYMax();
            }
            if (this.mYMin > t.getYMin()) {
                this.mYMin = t.getYMin();
            }
            if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                if (this.mLeftAxisMax < t.getYMax()) {
                    this.mLeftAxisMax = t.getYMax();
                }
                if (this.mLeftAxisMin > t.getYMin()) {
                    this.mLeftAxisMin = t.getYMin();
                }
            } else {
                if (this.mRightAxisMax < t.getYMax()) {
                    this.mRightAxisMax = t.getYMax();
                }
                if (this.mRightAxisMin > t.getYMin()) {
                    this.mRightAxisMin = t.getYMin();
                }
            }
        }
        this.mDataSets.add(t);
        handleEmptyAxis(getFirstLeft(), getFirstRight());
    }

    private void handleEmptyAxis(T t, T t2) {
        if (t == null) {
            this.mLeftAxisMax = this.mRightAxisMax;
            this.mLeftAxisMin = this.mRightAxisMin;
        } else if (t2 == null) {
            this.mRightAxisMax = this.mLeftAxisMax;
            this.mRightAxisMin = this.mLeftAxisMin;
        }
    }

    public boolean removeDataSet(T t) {
        if (t == null) {
            return false;
        }
        boolean zRemove = this.mDataSets.remove(t);
        if (zRemove) {
            this.mYValCount -= t.getEntryCount();
            this.mYValueSum -= t.getYValueSum();
            calcMinMax(this.mLastStart, this.mLastEnd);
        }
        return zRemove;
    }

    public boolean removeDataSet(int i) {
        if (i >= this.mDataSets.size() || i < 0) {
            return false;
        }
        return removeDataSet(this.mDataSets.get(i));
    }

    public void addEntry(Entry entry, int i) {
        if (this.mDataSets.size() > i && i >= 0) {
            float val = entry.getVal();
            this.mYValCount++;
            this.mYValueSum += val;
            if (this.mYMax < val) {
                this.mYMax = val;
            }
            if (this.mYMin > val) {
                this.mYMin = val;
            }
            T t = this.mDataSets.get(i);
            if (t != null) {
                if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (this.mLeftAxisMax < entry.getVal()) {
                        this.mLeftAxisMax = entry.getVal();
                    }
                    if (this.mLeftAxisMin > entry.getVal()) {
                        this.mLeftAxisMin = entry.getVal();
                    }
                } else {
                    if (this.mRightAxisMax < entry.getVal()) {
                        this.mRightAxisMax = entry.getVal();
                    }
                    if (this.mRightAxisMin > entry.getVal()) {
                        this.mRightAxisMin = entry.getVal();
                    }
                }
                handleEmptyAxis(getFirstLeft(), getFirstRight());
                t.addEntry(entry);
                return;
            }
            return;
        }
        Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
    }

    public boolean removeEntry(Entry entry, int i) {
        if (entry == null || i >= this.mDataSets.size()) {
            return false;
        }
        boolean zRemoveEntry = this.mDataSets.get(i).removeEntry(entry.getXIndex());
        if (zRemoveEntry) {
            this.mYValCount--;
            this.mYValueSum -= entry.getVal();
            calcMinMax(this.mLastStart, this.mLastEnd);
        }
        return zRemoveEntry;
    }

    public boolean removeEntry(int i, int i2) {
        if (i2 >= this.mDataSets.size()) {
            return false;
        }
        return removeEntry(this.mDataSets.get(i2).getEntryForXIndex(i), i2);
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i = 0; i < this.mDataSets.size(); i++) {
            T t = this.mDataSets.get(i);
            for (int i2 = 0; i2 < t.getEntryCount(); i2++) {
                if (entry.equalTo(t.getEntryForXIndex(entry.getXIndex()))) {
                    return t;
                }
            }
        }
        return null;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < this.mDataSets.size(); i++) {
            size += this.mDataSets.get(i).getColors().size();
        }
        int[] iArr = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < this.mDataSets.size(); i3++) {
            Iterator<Integer> it = this.mDataSets.get(i3).getColors().iterator();
            while (it.hasNext()) {
                iArr[i2] = it.next().intValue();
                i2++;
            }
        }
        return iArr;
    }

    public int getIndexOfDataSet(T t) {
        for (int i = 0; i < this.mDataSets.size(); i++) {
            if (this.mDataSets.get(i) == t) {
                return i;
            }
        }
        return -1;
    }

    public T getFirstLeft() {
        for (T t : this.mDataSets) {
            if (t.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public T getFirstRight() {
        for (T t : this.mDataSets) {
            if (t.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public static List<String> generateXVals(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            arrayList.add("" + i);
            i++;
        }
        return arrayList;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueFormatter(valueFormatter);
        }
    }

    public void setValueTextColor(int i) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTextColor(i);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTypeface(typeface);
        }
    }

    public void setValueTextSize(float f) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setValueTextSize(f);
        }
    }

    public void setDrawValues(boolean z) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setDrawValues(z);
        }
    }

    public void setHighlightEnabled(boolean z) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            it.next().setHighlightEnabled(z);
        }
    }

    public boolean isHighlightEnabled() {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            if (!it.next().isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void clearValues() {
        this.mDataSets.clear();
        notifyDataChanged();
    }

    public boolean contains(Entry entry) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            if (it.next().contains(entry)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(T t) {
        Iterator<T> it = this.mDataSets.iterator();
        while (it.hasNext()) {
            if (it.next().equals(t)) {
                return true;
            }
        }
        return false;
    }
}
