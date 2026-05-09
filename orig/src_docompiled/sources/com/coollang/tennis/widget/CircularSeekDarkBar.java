package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
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
import android.view.animation.DecelerateInterpolator;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class CircularSeekDarkBar extends View {

    /* JADX INFO: renamed from: A */
    private int f8178A;

    /* JADX INFO: renamed from: B */
    private int f8179B;

    /* JADX INFO: renamed from: C */
    private double f8180C;

    /* JADX INFO: renamed from: D */
    private double f8181D;

    /* JADX INFO: renamed from: E */
    private ValueAnimator f8182E;

    /* JADX INFO: renamed from: F */
    private Handler f8183F;

    /* JADX INFO: renamed from: G */
    private RectF f8184G;

    /* JADX INFO: renamed from: H */
    private RectF f8185H;

    /* JADX INFO: renamed from: a */
    private Context f8186a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1323a f8187b;

    /* JADX INFO: renamed from: c */
    private Paint f8188c;

    /* JADX INFO: renamed from: d */
    private Paint f8189d;

    /* JADX INFO: renamed from: e */
    private float f8190e;

    /* JADX INFO: renamed from: f */
    private int f8191f;

    /* JADX INFO: renamed from: g */
    private int f8192g;

    /* JADX INFO: renamed from: h */
    private int f8193h;

    /* JADX INFO: renamed from: i */
    private int f8194i;

    /* JADX INFO: renamed from: j */
    private int f8195j;

    /* JADX INFO: renamed from: k */
    private float f8196k;

    /* JADX INFO: renamed from: l */
    private int f8197l;

    /* JADX INFO: renamed from: m */
    private float f8198m;

    /* JADX INFO: renamed from: n */
    private float f8199n;

    /* JADX INFO: renamed from: o */
    private float f8200o;

    /* JADX INFO: renamed from: p */
    private float f8201p;

    /* JADX INFO: renamed from: q */
    private float f8202q;

    /* JADX INFO: renamed from: r */
    private float f8203r;

    /* JADX INFO: renamed from: s */
    private float f8204s;

    /* JADX INFO: renamed from: t */
    private float f8205t;

    /* JADX INFO: renamed from: u */
    private float f8206u;

    /* JADX INFO: renamed from: v */
    private float f8207v;

    /* JADX INFO: renamed from: w */
    private float f8208w;

    /* JADX INFO: renamed from: x */
    private float f8209x;

    /* JADX INFO: renamed from: y */
    private float f8210y;

    /* JADX INFO: renamed from: z */
    private boolean f8211z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircularSeekDarkBar$a */
    public interface InterfaceC1323a {
        /* JADX INFO: renamed from: a */
        void mo8095a(CircularSeekDarkBar circularSeekDarkBar, int i);
    }

    public CircularSeekDarkBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8190e = 0.0f;
        this.f8191f = 140;
        this.f8192g = 5;
        this.f8195j = 100;
        this.f8210y = 100.0f;
        this.f8211z = false;
        this.f8178A = 0;
        this.f8179B = 0;
        this.f8180C = 0.0d;
        this.f8181D = 0.0d;
        this.f8183F = new Handler();
        this.f8184G = new RectF();
        this.f8185H = new RectF();
        this.f8187b = new InterfaceC1323a() { // from class: com.coollang.tennis.widget.CircularSeekDarkBar.1
            @Override // com.coollang.tennis.widget.CircularSeekDarkBar.InterfaceC1323a
            /* JADX INFO: renamed from: a */
            public void mo8095a(CircularSeekDarkBar circularSeekDarkBar, int i2) {
            }
        };
        this.f8188c = new Paint();
        this.f8189d = new Paint();
        this.f8188c.setColor(Color.parseColor("#fe865f"));
        this.f8189d.setColor(Color.parseColor("#dcdcdc"));
        this.f8188c.setAntiAlias(true);
        this.f8189d.setAntiAlias(true);
        this.f8188c.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8189d.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8188c.setStyle(Paint.Style.STROKE);
        this.f8189d.setStyle(Paint.Style.STROKE);
        this.f8186a = context;
        m8094a();
    }

    public CircularSeekDarkBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8190e = 0.0f;
        this.f8191f = 140;
        this.f8192g = 5;
        this.f8195j = 100;
        this.f8210y = 100.0f;
        this.f8211z = false;
        this.f8178A = 0;
        this.f8179B = 0;
        this.f8180C = 0.0d;
        this.f8181D = 0.0d;
        this.f8183F = new Handler();
        this.f8184G = new RectF();
        this.f8185H = new RectF();
        this.f8187b = new InterfaceC1323a() { // from class: com.coollang.tennis.widget.CircularSeekDarkBar.1
            @Override // com.coollang.tennis.widget.CircularSeekDarkBar.InterfaceC1323a
            /* JADX INFO: renamed from: a */
            public void mo8095a(CircularSeekDarkBar circularSeekDarkBar, int i2) {
            }
        };
        this.f8188c = new Paint();
        this.f8189d = new Paint();
        this.f8188c.setColor(Color.parseColor("#fe865f"));
        this.f8189d.setColor(Color.parseColor("#dcdcdc"));
        this.f8188c.setAntiAlias(true);
        this.f8189d.setAntiAlias(true);
        this.f8188c.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8189d.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8188c.setStyle(Paint.Style.STROKE);
        this.f8189d.setStyle(Paint.Style.STROKE);
        this.f8186a = context;
        m8094a();
    }

    public CircularSeekDarkBar(Context context) {
        super(context);
        this.f8190e = 0.0f;
        this.f8191f = 140;
        this.f8192g = 5;
        this.f8195j = 100;
        this.f8210y = 100.0f;
        this.f8211z = false;
        this.f8178A = 0;
        this.f8179B = 0;
        this.f8180C = 0.0d;
        this.f8181D = 0.0d;
        this.f8183F = new Handler();
        this.f8184G = new RectF();
        this.f8185H = new RectF();
        this.f8187b = new InterfaceC1323a() { // from class: com.coollang.tennis.widget.CircularSeekDarkBar.1
            @Override // com.coollang.tennis.widget.CircularSeekDarkBar.InterfaceC1323a
            /* JADX INFO: renamed from: a */
            public void mo8095a(CircularSeekDarkBar circularSeekDarkBar, int i2) {
            }
        };
        this.f8188c = new Paint();
        this.f8189d = new Paint();
        this.f8188c.setColor(Color.parseColor("#fe865f"));
        this.f8189d.setColor(Color.parseColor("#dcdcdc"));
        this.f8188c.setAntiAlias(true);
        this.f8189d.setAntiAlias(true);
        this.f8188c.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8189d.setStrokeWidth(C1895ly.m10460a(getContext(), 4.0f));
        this.f8188c.setStyle(Paint.Style.STROKE);
        this.f8189d.setStyle(Paint.Style.STROKE);
        this.f8186a = context;
        m8094a();
    }

    /* JADX INFO: renamed from: a */
    public void m8094a() {
        this.f8182E = new ValueAnimator();
        this.f8182E.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f8182E.setDuration(2000L);
        this.f8182E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.CircularSeekDarkBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (CircularSeekDarkBar.this.f8196k == ((Float) valueAnimator.getAnimatedValue()).floatValue()) {
                    return;
                }
                CircularSeekDarkBar.this.f8196k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularSeekDarkBar.this.setAngle((((CircularSeekDarkBar.this.f8196k * 100.0f) * 260.0f) / CircularSeekDarkBar.this.f8195j) / 100.0f);
                CircularSeekDarkBar.this.f8187b.mo8095a(CircularSeekDarkBar.this, CircularSeekDarkBar.this.getProgress());
                CircularSeekDarkBar.this.postInvalidate();
            }
        });
    }

    public void setRingBlue() {
        this.f8178A = 1;
        this.f8188c.setColor(getCurColor());
    }

    public void setRingRed() {
        this.f8178A = 2;
        this.f8188c.setColor(getCurColor());
    }

    public void setRingYello() {
        this.f8178A = 3;
        this.f8188c.setColor(getCurColor());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8193h = View.MeasureSpec.getSize(i);
        this.f8194i = this.f8193h;
        int i3 = this.f8193h > this.f8194i ? this.f8194i : this.f8193h;
        this.f8200o = this.f8193h / 2;
        this.f8201p = this.f8194i / 2;
        this.f8199n = (i3 / 2) - 10;
        this.f8198m = this.f8199n + (this.f8192g / 2);
        this.f8202q = this.f8200o - this.f8199n;
        this.f8203r = this.f8200o + this.f8199n;
        this.f8204s = this.f8201p - this.f8199n;
        this.f8205t = this.f8201p + this.f8199n;
        this.f8206u = this.f8200o;
        this.f8207v = this.f8201p - this.f8199n;
        this.f8208w = this.f8206u;
        this.f8209x = this.f8207v;
        this.f8185H.set(this.f8202q + 10.0f, this.f8204s + 10.0f, this.f8203r - 10.0f, this.f8205t - 10.0f);
        this.f8184G.set(this.f8202q + 10.0f, this.f8204s + 10.0f, this.f8203r - 10.0f, this.f8205t - 10.0f);
        setMeasuredDimension(this.f8193h, this.f8194i);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8188c.setShader(new SweepGradient(this.f8185H.centerX(), this.f8185H.centerY(), getStartColor(), getCurColor()));
        Matrix matrix = new Matrix();
        this.f8188c.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.f8185H.centerX(), -this.f8185H.centerY());
        matrix.postRotate(120.0f);
        matrix.postTranslate(this.f8185H.centerX(), this.f8185H.centerY());
        this.f8188c.getShader().setLocalMatrix(matrix);
        this.f8189d.setStrokeCap(Paint.Cap.BUTT);
        this.f8188c.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawArc(this.f8185H, this.f8191f, 260.0f, false, this.f8189d);
        if (this.f8190e == 0.0f) {
            this.f8190e = 0.1f;
        }
        canvas.drawArc(this.f8184G, this.f8191f, this.f8190e, false, this.f8188c);
    }

    private int getCurColor() {
        int color = Color.parseColor("#fe865f");
        switch (this.f8178A) {
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
        int color = Color.parseColor("#fe865f");
        switch (this.f8178A) {
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
        return this.f8190e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngle(float f) {
        this.f8190e = f;
        double d = f;
        this.f8208w = (float) (((double) this.f8200o) + (((double) this.f8198m) * Math.cos(Math.atan2(((double) this.f8198m) * Math.sin(d), ((double) this.f8198m) * Math.cos(d)) - 1.5707963267948966d)));
        this.f8209x = (float) (((double) this.f8201p) + (((double) this.f8198m) * Math.sin(Math.atan2(((double) this.f8198m) * Math.sin(d), ((double) this.f8198m) * Math.cos(d)) - 1.5707963267948966d)));
        setProgressPercent(Math.round((this.f8190e / 260.0f) * 100.0f));
    }

    public void setSeekBarChangeListener(InterfaceC1323a interfaceC1323a) {
        this.f8187b = interfaceC1323a;
    }

    public InterfaceC1323a getSeekBarChangeListener() {
        return this.f8187b;
    }

    public int getBarWidth() {
        return this.f8192g;
    }

    public void setBarWidth(int i) {
        this.f8192g = i;
    }

    public int getMaxProgress() {
        return this.f8195j;
    }

    public void setMaxProgress(int i) {
        this.f8195j = i;
    }

    public int getProgress() {
        return (int) this.f8196k;
    }

    public void setProgress(float f) {
        if (this.f8196k != f) {
            if (this.f8196k != this.f8195j || this.f8196k <= this.f8195j) {
                this.f8182E.setFloatValues(this.f8196k, f);
                this.f8182E.start();
            }
        }
    }

    public int getProgressPercent() {
        return this.f8197l;
    }

    public void setProgressPercent(int i) {
        this.f8197l = i;
    }

    public void setRingBackgroundColor(int i) {
        this.f8189d.setColor(i);
    }

    public void setProgressColor(int i) {
        this.f8188c.setColor(i);
    }

    public float getAdjustmentFactor() {
        return this.f8210y;
    }

    public void setAdjustmentFactor(float f) {
        this.f8210y = f;
    }
}
