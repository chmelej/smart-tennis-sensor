package com.github.mikephil.charting.data;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CombinedData extends BarLineScatterCandleData<BarLineScatterCandleDataSet<?>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    public CombinedData() {
    }

    public CombinedData(List<String> list) {
        super(list);
    }

    public CombinedData(String[] strArr) {
        super(strArr);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setData(LineData lineData) {
        this.mLineData = lineData;
        this.mDataSets.addAll((Collection<? extends T>) lineData.getDataSets());
        init();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setData(BarData barData) {
        this.mBarData = barData;
        this.mDataSets.addAll((Collection<? extends T>) barData.getDataSets());
        init();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setData(ScatterData scatterData) {
        this.mScatterData = scatterData;
        this.mDataSets.addAll((Collection<? extends T>) scatterData.getDataSets());
        init();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setData(CandleData candleData) {
        this.mCandleData = candleData;
        this.mDataSets.addAll((Collection<? extends T>) candleData.getDataSets());
        init();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setData(BubbleData bubbleData) {
        this.mBubbleData = bubbleData;
        this.mDataSets.addAll((Collection<? extends T>) bubbleData.getDataSets());
        init();
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void notifyDataChanged() {
        if (this.mLineData != null) {
            this.mLineData.notifyDataChanged();
        }
        if (this.mBarData != null) {
            this.mBarData.notifyDataChanged();
        }
        if (this.mCandleData != null) {
            this.mCandleData.notifyDataChanged();
        }
        if (this.mScatterData != null) {
            this.mScatterData.notifyDataChanged();
        }
        if (this.mBubbleData != null) {
            this.mBubbleData.notifyDataChanged();
        }
    }
}
