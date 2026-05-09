package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class MarkerView extends RelativeLayout {
    public View inflated;

    public abstract int getXOffset();

    public abstract int getYOffset();

    public abstract void refreshContent(Entry entry, int i);

    public MarkerView(Context context, int i) {
        super(context);
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        this.inflated = LayoutInflater.from(getContext()).inflate(i, this);
        this.inflated.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.inflated.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.inflated.layout(0, 0, this.inflated.getMeasuredWidth(), this.inflated.getMeasuredHeight());
    }

    public View getView() {
        return this.inflated;
    }

    public void draw(Canvas canvas, float f, float f2) {
        float xOffset = f + getXOffset();
        float yOffset = f2 + getYOffset();
        canvas.translate(xOffset, yOffset);
        draw(canvas);
        canvas.translate(-xOffset, -yOffset);
    }
}
