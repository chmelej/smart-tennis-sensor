package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SportReportChart extends View {

    /* JADX INFO: renamed from: a */
    private int f8726a;

    /* JADX INFO: renamed from: b */
    private int f8727b;

    /* JADX INFO: renamed from: c */
    private Paint f8728c;

    /* JADX INFO: renamed from: d */
    private Paint f8729d;

    /* JADX INFO: renamed from: e */
    private Paint f8730e;

    /* JADX INFO: renamed from: f */
    private Paint f8731f;

    /* JADX INFO: renamed from: g */
    private Paint f8732g;

    /* JADX INFO: renamed from: h */
    private float[] f8733h;

    public SportReportChart(Context context) {
        super(context);
        m8270a();
    }

    public SportReportChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8270a();
    }

    public SportReportChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8270a();
    }

    /* JADX INFO: renamed from: a */
    private void m8270a() {
        this.f8728c = new Paint();
        this.f8728c.setColor(Color.parseColor("#dededf"));
        this.f8728c.setStyle(Paint.Style.FILL);
        this.f8728c.setAntiAlias(true);
        this.f8729d = new Paint();
        this.f8729d.setColor(Color.parseColor("#7ec1c3"));
        this.f8729d.setStyle(Paint.Style.FILL);
        this.f8729d.setAntiAlias(true);
        this.f8730e = new Paint();
        this.f8730e.setColor(Color.parseColor("#53b1b5"));
        this.f8730e.setStyle(Paint.Style.FILL);
        this.f8730e.setAntiAlias(true);
        this.f8731f = new Paint();
        this.f8731f.setColor(Color.parseColor("#0f989e"));
        this.f8731f.setStyle(Paint.Style.FILL);
        this.f8731f.setAntiAlias(true);
        this.f8732g = new Paint();
        this.f8732g.setColor(Color.parseColor("#f7f7f7"));
        this.f8732g.setStyle(Paint.Style.FILL);
        this.f8732g.setAntiAlias(true);
        this.f8732g.setStrokeWidth(2.0f);
    }

    public void setData(float f, float f2, float f3) {
        if (f >= 1.0f) {
            f = 1.0f;
        }
        if (f2 >= 1.0f) {
            f2 = 1.0f;
        }
        if (f3 >= 1.0f) {
            f3 = 1.0f;
        }
        this.f8733h = new float[]{f2, f, f3};
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8726a = View.MeasureSpec.getSize(i);
        this.f8727b = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8726a, this.f8727b);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fCos = (float) (((double) this.f8727b) / Math.cos(0.5235987755982988d));
        float f = (float) ((((double) this.f8727b) * 2.0d) / 3.0d);
        float f2 = (float) (((double) this.f8726a) / 2.0d);
        double d = fCos / 2.0f;
        float f3 = (float) ((((double) this.f8726a) / 2.0d) - d);
        float f4 = (float) ((((double) this.f8726a) / 2.0d) + d);
        float f5 = this.f8727b;
        Path path = new Path();
        path.moveTo(f2, 0.0f);
        path.lineTo(f3, f5);
        path.lineTo(f4, f5);
        canvas.drawPath(path, this.f8728c);
        float f6 = f - (this.f8733h[0] * f);
        double d2 = f2;
        float fCos2 = (float) (d2 - (((double) (this.f8733h[1] * f)) * Math.cos(0.5235987755982988d)));
        double d3 = f;
        float fSin = (float) ((((double) (this.f8733h[1] * f)) * Math.sin(0.5235987755982988d)) + d3);
        float fCos3 = (float) (d2 + (((double) (this.f8733h[2] * f)) * Math.cos(0.5235987755982988d)));
        float fSin2 = (float) (d3 + (((double) (this.f8733h[2] * f)) * Math.sin(0.5235987755982988d)));
        Path path2 = new Path();
        path2.moveTo(f2, f);
        path2.lineTo(f2, f6);
        path2.lineTo(fCos2, fSin);
        canvas.drawPath(path2, this.f8729d);
        Path path3 = new Path();
        path3.moveTo(f2, f);
        path3.lineTo(f2, f6);
        path3.lineTo(fCos3, fSin2);
        canvas.drawPath(path3, this.f8730e);
        Path path4 = new Path();
        path4.moveTo(f2, f);
        path4.lineTo(fCos2, fSin);
        path4.lineTo(fCos3, fSin2);
        canvas.drawPath(path4, this.f8731f);
        canvas.drawLine(f2, 0.0f, f2, f6, this.f8732g);
        canvas.drawLine(f3, f5, fCos2, fSin, this.f8732g);
        canvas.drawLine(f4, f5, fCos3, fSin2, this.f8732g);
    }
}
