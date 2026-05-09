package com.github.mikephil.charting.data;

import android.graphics.Path;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScatterDataSet extends BarLineScatterCandleDataSet<Entry> {
    private Path mCustomScatterPath;
    private ScatterChart.ScatterShape mScatterShape;
    private float mShapeSize;

    public ScatterDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mShapeSize = 15.0f;
        this.mScatterShape = ScatterChart.ScatterShape.SQUARE;
        this.mCustomScatterPath = null;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mYVals.size(); i++) {
            arrayList.add(((Entry) this.mYVals.get(i)).copy());
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(arrayList, getLabel());
        scatterDataSet.mColors = this.mColors;
        scatterDataSet.mShapeSize = this.mShapeSize;
        scatterDataSet.mScatterShape = this.mScatterShape;
        scatterDataSet.mCustomScatterPath = this.mCustomScatterPath;
        scatterDataSet.mHighLightColor = this.mHighLightColor;
        return scatterDataSet;
    }

    public void setScatterShapeSize(float f) {
        this.mShapeSize = Utils.convertDpToPixel(f);
    }

    public float getScatterShapeSize() {
        return this.mShapeSize;
    }

    public void setScatterShape(ScatterChart.ScatterShape scatterShape) {
        this.mScatterShape = scatterShape;
    }

    public ScatterChart.ScatterShape getScatterShape() {
        return this.mScatterShape;
    }

    public void setCustomScatterShape(Path path) {
        this.mCustomScatterPath = path;
    }

    public Path getCustomScatterShape() {
        return this.mCustomScatterPath;
    }
}
