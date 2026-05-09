package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataRenderer extends Renderer {
    protected boolean isMulitColor;
    protected ChartAnimator mAnimator;
    protected Paint mDrawPaint;
    protected Paint mHighlightPaint;
    protected Paint mRenderPaint;
    protected Paint mValuePaint;

    public abstract void drawData(Canvas canvas);

    public abstract void drawExtras(Canvas canvas);

    public abstract void drawHighlighted(Canvas canvas, Highlight[] highlightArr);

    public abstract void drawValues(Canvas canvas);

    public abstract void initBuffers();

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.mAnimator = chartAnimator;
        this.mRenderPaint = new Paint(1);
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mDrawPaint = new Paint(4);
        this.mValuePaint = new Paint(1);
        this.mValuePaint.setColor(Color.rgb(63, 63, 63));
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
    }

    public Paint getPaintValues() {
        return this.mValuePaint;
    }

    public Paint getPaintHighlight() {
        return this.mHighlightPaint;
    }

    public Paint getPaintRender() {
        return this.mRenderPaint;
    }

    protected void applyValueTextStyle(DataSet<?> dataSet) {
        this.mValuePaint.setColor(dataSet.getValueTextColor());
        this.mValuePaint.setTypeface(dataSet.getValueTypeface());
        this.mValuePaint.setTextSize(dataSet.getValueTextSize());
    }

    public boolean isMulitColor() {
        return this.isMulitColor;
    }

    public void setMulitColor(boolean z) {
        this.isMulitColor = z;
    }
}
