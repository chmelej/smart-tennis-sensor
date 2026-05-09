package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class PersonYearBarChartView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8577a;

    /* JADX INFO: renamed from: b */
    private int f8578b;

    /* JADX INFO: renamed from: c */
    private int f8579c;

    /* JADX INFO: renamed from: d */
    private int[] f8580d;

    /* JADX INFO: renamed from: e */
    private int f8581e;

    /* JADX INFO: renamed from: f */
    private Paint f8582f;

    /* JADX INFO: renamed from: g */
    private Paint f8583g;

    /* JADX INFO: renamed from: h */
    private Paint f8584h;

    /* JADX INFO: renamed from: i */
    private int f8585i;

    /* JADX INFO: renamed from: j */
    private int f8586j;

    /* JADX INFO: renamed from: k */
    private float f8587k;

    public PersonYearBarChartView(Context context) {
        super(context);
        this.f8577a = 10;
        this.f8580d = new int[]{20, 10, 18, 30, 8, 27, 200, 400, 600};
        this.f8581e = 1000;
        m8240a(context);
    }

    public PersonYearBarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8577a = 10;
        this.f8580d = new int[]{20, 10, 18, 30, 8, 27, 200, 400, 600};
        this.f8581e = 1000;
        m8240a(context);
    }

    public PersonYearBarChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8577a = 10;
        this.f8580d = new int[]{20, 10, 18, 30, 8, 27, 200, 400, 600};
        this.f8581e = 1000;
        m8240a(context);
    }

    @TargetApi(21)
    public PersonYearBarChartView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8577a = 10;
        this.f8580d = new int[]{20, 10, 18, 30, 8, 27, 200, 400, 600};
        this.f8581e = 1000;
        m8240a(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8578b = View.MeasureSpec.getSize(i);
        this.f8579c = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8578b, this.f8579c);
    }

    /* JADX INFO: renamed from: a */
    private void m8240a(Context context) {
        this.f8582f = new Paint();
        this.f8582f.setAntiAlias(true);
        this.f8582f.setColor(-7829368);
        this.f8582f.setTextSize(C1895ly.m10460a(context, 10.0f));
        this.f8583g = new Paint();
        this.f8583g.setAntiAlias(true);
        this.f8584h = new Paint();
        this.f8584h.setStyle(Paint.Style.STROKE);
        this.f8584h.setColor(Color.parseColor("#22000000"));
        this.f8585i = C1895ly.m10460a(context, 7.0f);
        this.f8586j = C1895ly.m10460a(context, 3.0f);
        this.f8587k = this.f8582f.measureText("99999");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        int i3 = this.f8579c - 10;
        float f = ((this.f8578b - 20) - this.f8587k) / 12.0f;
        int iM10460a = C1895ly.m10460a(getContext(), 10.0f);
        int iM10460a2 = C1895ly.m10460a(getContext(), 14.0f);
        float f2 = iM10460a2;
        int i4 = 5;
        if (f2 >= f) {
            i = ((int) f) - 10;
            i2 = 5;
        } else {
            i = iM10460a2;
            i2 = ((int) (f - f2)) / 2;
        }
        int textSize = (((i3 - (((int) this.f8582f.getTextSize()) * 2)) - iM10460a) - this.f8585i) - this.f8586j;
        int i5 = this.f8581e / 5;
        float f3 = i3;
        canvas.drawText("0", 10.0f, ((f3 - this.f8582f.getTextSize()) - this.f8585i) - this.f8586j, this.f8582f);
        canvas.drawLine(10.0f, (f3 - this.f8582f.getTextSize()) - this.f8585i, this.f8578b - 10, (f3 - this.f8582f.getTextSize()) - this.f8585i, this.f8584h);
        int i6 = 1;
        int i7 = 1;
        while (i7 < 6) {
            float f4 = (textSize * i7) / i4;
            canvas.drawText(String.valueOf(i5 * i7), 10.0f, (((f3 - this.f8582f.getTextSize()) - this.f8585i) - this.f8586j) - f4, this.f8582f);
            Path path = new Path();
            path.moveTo(10.0f, ((f3 - this.f8582f.getTextSize()) - this.f8585i) - f4);
            path.lineTo(this.f8578b - 10, ((f3 - this.f8582f.getTextSize()) - this.f8585i) - f4);
            this.f8584h.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
            canvas.drawPath(path, this.f8584h);
            i7++;
            i4 = 5;
        }
        int i8 = 0;
        while (i8 < this.f8580d.length) {
            int i9 = i8 + 1;
            canvas.drawText(String.valueOf(i9), ((this.f8587k + 10.0f) + ((f / 2.0f) * ((i9 * 2) - i6))) - (this.f8582f.measureText(String.valueOf(i9)) / 2.0f), f3, this.f8582f);
            int i10 = (this.f8580d[i8] * textSize) / this.f8581e;
            float f5 = (i8 * f) + 10.0f + i2;
            float f6 = (textSize - i10) + iM10460a;
            float f7 = i + f5;
            this.f8583g.setShader(new LinearGradient(f5 + this.f8587k, this.f8582f.getTextSize() + f6 + this.f8586j, f7 + this.f8587k, (f3 - this.f8582f.getTextSize()) - this.f8585i, Color.parseColor("#edc474"), getContext().getResources().getColor(R.color.yellow_re_start_ble), Shader.TileMode.CLAMP));
            canvas.drawRoundRect(new RectF(f5 + this.f8587k, f6 + this.f8582f.getTextSize() + this.f8586j, f7 + this.f8587k, (f3 - this.f8582f.getTextSize()) - this.f8585i), C1895ly.m10460a(getContext(), 2.0f), C1895ly.m10460a(getContext(), 2.0f), this.f8583g);
            i8 = i9;
            i6 = 1;
        }
    }

    private int getMaxValue() {
        int i = 0;
        for (int i2 = 0; i2 < this.f8580d.length; i2++) {
            if (i < this.f8580d[i2]) {
                i = this.f8580d[i2];
            }
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public void setData(int[] iArr) {
        this.f8580d = iArr;
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] > this.f8581e) {
                this.f8581e = ((iArr[i] + 1000) / 1000) * 1000;
            }
        }
        invalidate();
    }
}
