package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class SportLoadingProgress extends View {

    /* JADX INFO: renamed from: a */
    private Paint f8721a;

    /* JADX INFO: renamed from: b */
    private int f8722b;

    /* JADX INFO: renamed from: c */
    private int f8723c;

    /* JADX INFO: renamed from: d */
    private int f8724d;

    /* JADX INFO: renamed from: e */
    private int f8725e;

    public SportLoadingProgress(Context context) {
        super(context);
        this.f8724d = 0;
        this.f8725e = C1895ly.m10460a(getContext(), 2.0f);
        m8269a();
    }

    public SportLoadingProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8724d = 0;
        this.f8725e = C1895ly.m10460a(getContext(), 2.0f);
        m8269a();
    }

    public SportLoadingProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8724d = 0;
        this.f8725e = C1895ly.m10460a(getContext(), 2.0f);
        m8269a();
    }

    @TargetApi(21)
    public SportLoadingProgress(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8724d = 0;
        this.f8725e = C1895ly.m10460a(getContext(), 2.0f);
        m8269a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8722b = View.MeasureSpec.getSize(i);
        this.f8723c = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8722b, this.f8723c);
    }

    /* JADX INFO: renamed from: a */
    private void m8269a() {
        this.f8721a = new Paint();
        this.f8721a.setColor(getResources().getColor(R.color.text_menu_checked));
        this.f8721a.setStrokeCap(Paint.Cap.ROUND);
        this.f8721a.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.f8723c / 2) - (this.f8725e / 2);
        this.f8721a.setColor(Color.parseColor("#eaeaea"));
        canvas.drawRoundRect(new RectF(0.0f, f, this.f8722b, this.f8725e + f), this.f8725e, this.f8725e, this.f8721a);
        this.f8721a.setColor(getResources().getColor(R.color.text_menu_checked));
        canvas.drawRoundRect(new RectF(0.0f, f, (this.f8722b * this.f8724d) / 100.0f, this.f8725e + f), this.f8725e, this.f8725e, this.f8721a);
    }

    public void setProgress(int i) {
        this.f8724d = i;
        invalidate();
    }
}
