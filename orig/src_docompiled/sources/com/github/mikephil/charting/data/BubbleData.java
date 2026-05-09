package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BubbleData extends BarLineScatterCandleData<BubbleDataSet> {
    public BubbleData() {
    }

    public BubbleData(List<String> list) {
        super(list);
    }

    public BubbleData(String[] strArr) {
        super(strArr);
    }

    public BubbleData(List<String> list, List<BubbleDataSet> list2) {
        super(list, list2);
    }

    public BubbleData(String[] strArr, List<BubbleDataSet> list) {
        super(strArr, list);
    }

    public BubbleData(List<String> list, BubbleDataSet bubbleDataSet) {
        super(list, toList(bubbleDataSet));
    }

    public BubbleData(String[] strArr, BubbleDataSet bubbleDataSet) {
        super(strArr, toList(bubbleDataSet));
    }

    private static List<BubbleDataSet> toList(BubbleDataSet bubbleDataSet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bubbleDataSet);
        return arrayList;
    }

    public void setHighlightCircleWidth(float f) {
        Iterator it = this.mDataSets.iterator();
        while (it.hasNext()) {
            ((BubbleDataSet) it.next()).setHighlightCircleWidth(f);
        }
    }
}
