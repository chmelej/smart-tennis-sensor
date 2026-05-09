package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CircularSeekBar extends View {

    /* JADX INFO: renamed from: A */
    private int f8144A;

    /* JADX INFO: renamed from: B */
    private int f8145B;

    /* JADX INFO: renamed from: C */
    private double f8146C;

    /* JADX INFO: renamed from: D */
    private double f8147D;

    /* JADX INFO: renamed from: E */
    private Handler f8148E;

    /* JADX INFO: renamed from: F */
    private RectF f8149F;

    /* JADX INFO: renamed from: G */
    private RectF f8150G;

    /* JADX INFO: renamed from: a */
    private Context f8151a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1320a f8152b;

    /* JADX INFO: renamed from: c */
    private Paint f8153c;

    /* JADX INFO: renamed from: d */
    private Paint f8154d;

    /* JADX INFO: renamed from: e */
    private float f8155e;

    /* JADX INFO: renamed from: f */
    private int f8156f;

    /* JADX INFO: renamed from: g */
    private int f8157g;

    /* JADX INFO: renamed from: h */
    private int f8158h;

    /* JADX INFO: renamed from: i */
    private int f8159i;

    /* JADX INFO: renamed from: j */
    private int f8160j;

    /* JADX INFO: renamed from: k */
    private int f8161k;

    /* JADX INFO: renamed from: l */
    private int f8162l;

    /* JADX INFO: renamed from: m */
    private float f8163m;

    /* JADX INFO: renamed from: n */
    private float f8164n;

    /* JADX INFO: renamed from: o */
    private float f8165o;

    /* JADX INFO: renamed from: p */
    private float f8166p;

    /* JADX INFO: renamed from: q */
    private float f8167q;

    /* JADX INFO: renamed from: r */
    private float f8168r;

    /* JADX INFO: renamed from: s */
    private float f8169s;

    /* JADX INFO: renamed from: t */
    private float f8170t;

    /* JADX INFO: renamed from: u */
    private float f8171u;

    /* JADX INFO: renamed from: v */
    private float f8172v;

    /* JADX INFO: renamed from: w */
    private float f8173w;

    /* JADX INFO: renamed from: x */
    private float f8174x;

    /* JADX INFO: renamed from: y */
    private float f8175y;

    /* JADX INFO: renamed from: z */
    private boolean f8176z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircularSeekBar$a */
    public interface InterfaceC1320a {
        /* JADX INFO: renamed from: a */
        void mo8088a(CircularSeekBar circularSeekBar, int i);
    }

    /* JADX INFO: renamed from: a */
    public void m8087a() {
    }

    public CircularSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8155e = 0.0f;
        this.f8156f = 140;
        this.f8157g = 5;
        this.f8160j = 100;
        this.f8175y = 100.0f;
        this.f8176z = false;
        this.f8144A = 0;
        this.f8145B = 0;
        this.f8146C = 0.0d;
        this.f8147D = 0.0d;
        this.f8148E = new Handler();
        this.f8149F = new RectF();
        this.f8150G = new RectF();
        this.f8152b = new InterfaceC1320a() { // from class: com.coollang.tennis.widget.CircularSeekBar.1
            @Override // com.coollang.tennis.widget.CircularSeekBar.InterfaceC1320a
            /* JADX INFO: renamed from: a */
            public void mo8088a(CircularSeekBar circularSeekBar, int i2) {
            }
        };
        this.f8153c = new Paint();
        this.f8154d = new Paint();
        this.f8153c.setColor(Color.parseColor("#51ff7e"));
        this.f8154d.setColor(Color.parseColor("#22ffffff"));
        this.f8153c.setAntiAlias(true);
        this.f8154d.setAntiAlias(true);
        this.f8153c.setStrokeWidth(15.0f);
        this.f8154d.setStrokeWidth(15.0f);
        this.f8153c.setStyle(Paint.Style.STROKE);
        this.f8154d.setStyle(Paint.Style.STROKE);
        this.f8151a = context;
        m8087a();
    }

    public CircularSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8155e = 0.0f;
        this.f8156f = 140;
        this.f8157g = 5;
        this.f8160j = 100;
        this.f8175y = 100.0f;
        this.f8176z = false;
        this.f8144A = 0;
        this.f8145B = 0;
        this.f8146C = 0.0d;
        this.f8147D = 0.0d;
        this.f8148E = new Handler();
        this.f8149F = new RectF();
        this.f8150G = new RectF();
        this.f8152b = new InterfaceC1320a() { // from class: com.coollang.tennis.widget.CircularSeekBar.1
            @Override // com.coollang.tennis.widget.CircularSeekBar.InterfaceC1320a
            /* JADX INFO: renamed from: a */
            public void mo8088a(CircularSeekBar circularSeekBar, int i2) {
            }
        };
        this.f8153c = new Paint();
        this.f8154d = new Paint();
        this.f8153c.setColor(Color.parseColor("#51ff7e"));
        this.f8154d.setColor(Color.parseColor("#22ffffff"));
        this.f8153c.setAntiAlias(true);
        this.f8154d.setAntiAlias(true);
        this.f8153c.setStrokeWidth(15.0f);
        this.f8154d.setStrokeWidth(15.0f);
        this.f8153c.setStyle(Paint.Style.STROKE);
        this.f8154d.setStyle(Paint.Style.STROKE);
        this.f8151a = context;
        m8087a();
    }

    public CircularSeekBar(Context context) {
        super(context);
        this.f8155e = 0.0f;
        this.f8156f = 140;
        this.f8157g = 5;
        this.f8160j = 100;
        this.f8175y = 100.0f;
        this.f8176z = false;
        this.f8144A = 0;
        this.f8145B = 0;
        this.f8146C = 0.0d;
        this.f8147D = 0.0d;
        this.f8148E = new Handler();
        this.f8149F = new RectF();
        this.f8150G = new RectF();
        this.f8152b = new InterfaceC1320a() { // from class: com.coollang.tennis.widget.CircularSeekBar.1
            @Override // com.coollang.tennis.widget.CircularSeekBar.InterfaceC1320a
            /* JADX INFO: renamed from: a */
            public void mo8088a(CircularSeekBar circularSeekBar, int i2) {
            }
        };
        this.f8153c = new Paint();
        this.f8154d = new Paint();
        this.f8153c.setColor(Color.parseColor("#51ff7e"));
        this.f8154d.setColor(Color.parseColor("#22ffffff"));
        this.f8153c.setAntiAlias(true);
        this.f8154d.setAntiAlias(true);
        this.f8153c.setStrokeWidth(15.0f);
        this.f8154d.setStrokeWidth(15.0f);
        this.f8153c.setStyle(Paint.Style.STROKE);
        this.f8154d.setStyle(Paint.Style.STROKE);
        this.f8151a = context;
        m8087a();
    }

    public void setRingBlue() {
        this.f8144A = 1;
        this.f8153c.setColor(getCurColor());
    }

    public void setRingRed() {
        this.f8144A = 2;
        this.f8153c.setColor(getCurColor());
    }

    public void setRingYello() {
        this.f8144A = 3;
        this.f8153c.setColor(getCurColor());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8158h = View.MeasureSpec.getSize(i);
        this.f8159i = this.f8158h;
        int i3 = this.f8158h > this.f8159i ? this.f8159i : this.f8158h;
        this.f8165o = this.f8158h / 2;
        this.f8166p = this.f8159i / 2;
        this.f8164n = (i3 / 2) - 10;
        this.f8163m = this.f8164n + (this.f8157g / 2);
        this.f8167q = this.f8165o - this.f8164n;
        this.f8168r = this.f8165o + this.f8164n;
        this.f8169s = this.f8166p - this.f8164n;
        this.f8170t = this.f8166p + this.f8164n;
        this.f8171u = this.f8165o;
        this.f8172v = this.f8166p - this.f8164n;
        this.f8173w = this.f8171u;
        this.f8174x = this.f8172v;
        this.f8150G.set(this.f8167q + 10.0f, this.f8169s + 10.0f, this.f8168r - 10.0f, this.f8170t - 10.0f);
        this.f8149F.set(this.f8167q + 10.0f, this.f8169s + 10.0f, this.f8168r - 10.0f, this.f8170t - 10.0f);
        setMeasuredDimension(this.f8158h, this.f8159i);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8153c.setShader(new SweepGradient(this.f8150G.centerX(), this.f8150G.centerY(), getStartColor(), getCurColor()));
        Matrix matrix = new Matrix();
        this.f8153c.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.f8150G.centerX(), -this.f8150G.centerY());
        matrix.postRotate(120.0f);
        matrix.postTranslate(this.f8150G.centerX(), this.f8150G.centerY());
        this.f8153c.getShader().setLocalMatrix(matrix);
        this.f8154d.setStrokeCap(Paint.Cap.BUTT);
        this.f8153c.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawArc(this.f8150G, this.f8156f, 260.0f, false, this.f8154d);
        if (this.f8155e == 0.0f) {
            this.f8155e = 0.1f;
        }
        canvas.drawArc(this.f8149F, this.f8156f, this.f8155e, false, this.f8153c);
    }

    private int getCurColor() {
        int color = Color.parseColor("#51ff7e");
        switch (this.f8144A) {
            case 1:
                return Color.parseColor("#f06fa5");
            case 2:
                return Color.parseColor("#7abeeb");
            case 3:
                return Color.parseColor("#f8c353");
            default:
                return color;
        }
    }

    private int getStartColor() {
        int color = Color.parseColor("#51ff7e");
        switch (this.f8144A) {
            case 1:
                return Color.parseColor("#44f06fa5");
            case 2:
                return Color.parseColor("#447abeeb");
            case 3:
                return Color.parseColor("#44f8c353");
            default:
                return color;
        }
    }

    public float getAngle() {
        return this.f8155e;
    }

    public void setAngle(int i) {
        this.f8155e = i;
        double d = i;
        this.f8173w = (float) (((double) this.f8165o) + (((double) this.f8163m) * Math.cos(Math.atan2(((double) this.f8163m) * Math.sin(d), ((double) this.f8163m) * Math.cos(d)) - 1.5707963267948966d)));
        this.f8174x = (float) (((double) this.f8166p) + (((double) this.f8163m) * Math.sin(Math.atan2(((double) this.f8163m) * Math.sin(d), ((double) this.f8163m) * Math.cos(d)) - 1.5707963267948966d)));
        float f = (this.f8155e / 260.0f) * 100.0f;
        setProgressPercent(Math.round(f));
        setProgress(Math.round((f / 100.0f) * getMaxProgress()));
    }

    public void setSeekBarChangeListener(InterfaceC1320a interfaceC1320a) {
        this.f8152b = interfaceC1320a;
    }

    public InterfaceC1320a getSeekBarChangeListener() {
        return this.f8152b;
    }

    public int getBarWidth() {
        return this.f8157g;
    }

    public void setBarWidth(int i) {
        this.f8157g = i;
    }

    public int getMaxProgress() {
        return this.f8160j;
    }

    public void setMaxProgress(int i) {
        this.f8160j = i;
    }

    public int getProgress() {
        return this.f8161k;
    }

    public void setProgress(int i) {
        if (this.f8161k != i) {
            this.f8161k = i;
            int i2 = (this.f8161k * 100) / this.f8160j;
            setAngle((i2 * 260) / 100);
            setProgressPercent(i2);
            this.f8152b.mo8088a(this, getProgress());
            invalidate();
        }
    }

    public int getProgressPercent() {
        return this.f8162l;
    }

    public void setProgressPercent(int i) {
        this.f8162l = i;
    }

    public void setRingBackgroundColor(int i) {
        this.f8154d.setColor(i);
    }

    public void setProgressColor(int i) {
        this.f8153c.setColor(i);
    }

    public float getAdjustmentFactor() {
        return this.f8175y;
    }

    public void setAdjustmentFactor(float f) {
        this.f8175y = f;
    }
}
