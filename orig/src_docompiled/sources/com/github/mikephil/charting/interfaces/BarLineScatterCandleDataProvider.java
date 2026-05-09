package com.github.mikephil.charting.interfaces;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Transformer;

/* JADX INFO: loaded from: classes.dex */
public interface BarLineScatterCandleDataProvider extends ChartInterface {
    int getHighestVisibleXIndex();

    int getLowestVisibleXIndex();

    int getMaxVisibleCount();

    Transformer getTransformer(YAxis.AxisDependency axisDependency);

    boolean isInverted(YAxis.AxisDependency axisDependency);
}
