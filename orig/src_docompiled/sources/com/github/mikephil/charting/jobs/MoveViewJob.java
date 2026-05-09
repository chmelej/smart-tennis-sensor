package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public class MoveViewJob implements Runnable {
    protected Transformer mTrans;
    protected ViewPortHandler mViewPortHandler;
    protected View view;
    protected float xIndex;
    protected float yValue;

    public MoveViewJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        this.xIndex = 0.0f;
        this.yValue = 0.0f;
        this.mViewPortHandler = viewPortHandler;
        this.xIndex = f;
        this.yValue = f2;
        this.mTrans = transformer;
        this.view = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = {this.xIndex, this.yValue};
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(fArr, this.view);
    }
}
