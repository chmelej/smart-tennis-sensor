package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class DialChartView extends View {

    /* JADX INFO: renamed from: A */
    private int f8309A;

    /* JADX INFO: renamed from: B */
    private ValueAnimator f8310B;

    /* JADX INFO: renamed from: C */
    private RectF f8311C;

    /* JADX INFO: renamed from: D */
    private RectF f8312D;

    /* JADX INFO: renamed from: E */
    private Bitmap f8313E;

    /* JADX INFO: renamed from: F */
    private int f8314F;

    /* JADX INFO: renamed from: G */
    private Paint f8315G;

    /* JADX INFO: renamed from: H */
    private Paint f8316H;

    /* JADX INFO: renamed from: a */
    private final int f8317a;

    /* JADX INFO: renamed from: b */
    private Context f8318b;

    /* JADX INFO: renamed from: c */
    private InterfaceC1335a f8319c;

    /* JADX INFO: renamed from: d */
    private Paint f8320d;

    /* JADX INFO: renamed from: e */
    private Paint f8321e;

    /* JADX INFO: renamed from: f */
    private float f8322f;

    /* JADX INFO: renamed from: g */
    private int f8323g;

    /* JADX INFO: renamed from: h */
    private int f8324h;

    /* JADX INFO: renamed from: i */
    private int f8325i;

    /* JADX INFO: renamed from: j */
    private int f8326j;

    /* JADX INFO: renamed from: k */
    private int f8327k;

    /* JADX INFO: renamed from: l */
    private float f8328l;

    /* JADX INFO: renamed from: m */
    private float f8329m;

    /* JADX INFO: renamed from: n */
    private float f8330n;

    /* JADX INFO: renamed from: o */
    private float f8331o;

    /* JADX INFO: renamed from: p */
    private float f8332p;

    /* JADX INFO: renamed from: q */
    private float f8333q;

    /* JADX INFO: renamed from: r */
    private float f8334r;

    /* JADX INFO: renamed from: s */
    private float f8335s;

    /* JADX INFO: renamed from: t */
    private float f8336t;

    /* JADX INFO: renamed from: u */
    private float f8337u;

    /* JADX INFO: renamed from: v */
    private float f8338v;

    /* JADX INFO: renamed from: w */
    private float f8339w;

    /* JADX INFO: renamed from: x */
    private int f8340x;

    /* JADX INFO: renamed from: y */
    private int[] f8341y;

    /* JADX INFO: renamed from: z */
    private String[] f8342z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.DialChartView$a */
    public interface InterfaceC1335a {
        /* JADX INFO: renamed from: a */
        void mo8148a(DialChartView dialChartView, int i);
    }

    public DialChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8317a = 1101;
        this.f8322f = 0.0f;
        this.f8323g = 150;
        this.f8324h = 5;
        this.f8327k = 200;
        this.f8341y = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        this.f8342z = new String[]{"0", "20", "40", "60", "80", "100", "120", "140", "160", "180", "200"};
        this.f8311C = new RectF();
        this.f8312D = new RectF();
        this.f8319c = new InterfaceC1335a() { // from class: com.coollang.tennis.widget.DialChartView.1
            @Override // com.coollang.tennis.widget.DialChartView.InterfaceC1335a
            /* JADX INFO: renamed from: a */
            public void mo8148a(DialChartView dialChartView, int i2) {
            }
        };
        this.f8320d = new Paint();
        this.f8321e = new Paint();
        this.f8321e.setColor(Color.parseColor("#f3f3f3"));
        this.f8320d.setAntiAlias(true);
        this.f8321e.setAntiAlias(true);
        this.f8320d.setStyle(Paint.Style.STROKE);
        this.f8321e.setStyle(Paint.Style.STROKE);
        this.f8315G = new Paint();
        this.f8315G.setColor(Color.parseColor("#cc8d8c90"));
        this.f8315G.setAntiAlias(true);
        this.f8318b = context;
        m8147a();
    }

    public DialChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8317a = 1101;
        this.f8322f = 0.0f;
        this.f8323g = 150;
        this.f8324h = 5;
        this.f8327k = 200;
        this.f8341y = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        this.f8342z = new String[]{"0", "20", "40", "60", "80", "100", "120", "140", "160", "180", "200"};
        this.f8311C = new RectF();
        this.f8312D = new RectF();
        this.f8319c = new InterfaceC1335a() { // from class: com.coollang.tennis.widget.DialChartView.1
            @Override // com.coollang.tennis.widget.DialChartView.InterfaceC1335a
            /* JADX INFO: renamed from: a */
            public void mo8148a(DialChartView dialChartView, int i2) {
            }
        };
        this.f8320d = new Paint();
        this.f8321e = new Paint();
        this.f8321e.setColor(Color.parseColor("#f3f3f3"));
        this.f8320d.setAntiAlias(true);
        this.f8321e.setAntiAlias(true);
        this.f8320d.setStyle(Paint.Style.STROKE);
        this.f8321e.setStyle(Paint.Style.STROKE);
        this.f8315G = new Paint();
        this.f8315G.setColor(Color.parseColor("#cc8d8c90"));
        this.f8315G.setAntiAlias(true);
        this.f8318b = context;
        m8147a();
    }

    public DialChartView(Context context) {
        super(context);
        this.f8317a = 1101;
        this.f8322f = 0.0f;
        this.f8323g = 150;
        this.f8324h = 5;
        this.f8327k = 200;
        this.f8341y = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        this.f8342z = new String[]{"0", "20", "40", "60", "80", "100", "120", "140", "160", "180", "200"};
        this.f8311C = new RectF();
        this.f8312D = new RectF();
        this.f8319c = new InterfaceC1335a() { // from class: com.coollang.tennis.widget.DialChartView.1
            @Override // com.coollang.tennis.widget.DialChartView.InterfaceC1335a
            /* JADX INFO: renamed from: a */
            public void mo8148a(DialChartView dialChartView, int i2) {
            }
        };
        this.f8320d = new Paint();
        this.f8321e = new Paint();
        this.f8321e.setColor(Color.parseColor("#f3f3f3"));
        this.f8320d.setAntiAlias(true);
        this.f8321e.setAntiAlias(true);
        this.f8320d.setStyle(Paint.Style.STROKE);
        this.f8321e.setStyle(Paint.Style.STROKE);
        this.f8315G = new Paint();
        this.f8315G.setColor(Color.parseColor("#cc8d8c90"));
        this.f8315G.setAntiAlias(true);
        this.f8318b = context;
        m8147a();
    }

    /* JADX INFO: renamed from: a */
    public void m8147a() {
        this.f8315G.setTextSize(C1895ly.m10460a(this.f8318b, 10.0f));
        this.f8313E = BitmapFactory.decodeResource(this.f8318b.getResources(), R.drawable.indicator_dial_chart);
        this.f8314F = this.f8313E.getHeight() - C1895ly.m10460a(this.f8318b, 20.0f);
        this.f8309A = C1895ly.m10460a(this.f8318b, 6.0f);
        this.f8316H = new Paint();
        this.f8316H.setAntiAlias(true);
        this.f8316H.setStrokeWidth(1.0f);
        this.f8316H.setColor(this.f8318b.getResources().getColor(R.color.text_menu));
        this.f8310B = new ValueAnimator();
        this.f8310B.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f8310B.setDuration(1000L);
        this.f8310B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.DialChartView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (DialChartView.this.f8328l == ((Float) valueAnimator.getAnimatedValue()).floatValue()) {
                    return;
                }
                DialChartView.this.f8328l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DialChartView.this.setAngle((((DialChartView.this.f8328l * 100.0f) * 240.0f) / DialChartView.this.f8327k) / 100.0f);
                DialChartView.this.postInvalidate();
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8325i = View.MeasureSpec.getSize(i);
        this.f8326j = this.f8325i;
        int i3 = this.f8325i > this.f8326j ? this.f8326j : this.f8325i;
        this.f8332p = this.f8325i / 2;
        this.f8333q = this.f8326j / 2;
        this.f8331o = (i3 / 2) - 10;
        this.f8330n = this.f8331o + (this.f8324h / 2);
        this.f8334r = this.f8332p - this.f8331o;
        this.f8335s = this.f8332p + this.f8331o;
        this.f8336t = this.f8333q - this.f8331o;
        this.f8337u = this.f8333q + this.f8331o;
        this.f8338v = this.f8332p;
        this.f8339w = this.f8333q - this.f8331o;
        this.f8340x = C1895ly.m10460a(this.f8318b, 30.0f) + 10;
        this.f8312D.set(this.f8334r + this.f8340x, this.f8336t + this.f8340x, this.f8335s - this.f8340x, this.f8337u - this.f8340x);
        this.f8311C.set(this.f8334r + this.f8340x, this.f8336t + this.f8340x, this.f8335s - this.f8340x, this.f8337u - this.f8340x);
        setMeasuredDimension(this.f8325i, this.f8326j);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        this.f8320d.setStrokeWidth(C1895ly.m10460a(getContext(), 10.0f));
        this.f8321e.setStrokeWidth(C1895ly.m10460a(getContext(), 10.0f));
        this.f8320d.setShader(new SweepGradient(this.f8312D.centerX(), this.f8312D.centerY(), this.f8341y, (float[]) null));
        Matrix matrix = new Matrix();
        this.f8320d.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.f8312D.centerX(), -this.f8312D.centerY());
        matrix.postRotate(150.0f);
        matrix.postTranslate(this.f8312D.centerX(), this.f8312D.centerY());
        this.f8320d.getShader().setLocalMatrix(matrix);
        this.f8321e.setStrokeCap(Paint.Cap.BUTT);
        this.f8320d.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawArc(this.f8312D, this.f8323g, 240.0f, false, this.f8321e);
        if (this.f8322f == 0.0f) {
            this.f8322f = 0.1f;
        }
        canvas.drawArc(this.f8311C, this.f8323g, this.f8322f, false, this.f8320d);
        int iM10460a = C1895ly.m10460a(this.f8318b, 10.0f);
        float fM10460a = ((this.f8331o - this.f8340x) - C1895ly.m10460a(getContext(), 10.0f)) + 10.0f;
        int i2 = 0;
        while (i2 < this.f8342z.length) {
            int i3 = i2 * 24;
            if (i3 < 30) {
                int i4 = 30 - i3;
                canvas.drawText(this.f8342z[i2], (float) (((((double) this.f8332p) - (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.cos(Math.toRadians(Math.abs(i4))))) - ((double) this.f8315G.measureText(this.f8342z[i2]))) - 10.0d), (float) (((double) this.f8333q) + (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.sin(Math.toRadians(Math.abs(i4)))) + ((double) (iM10460a / 2))), this.f8315G);
                double d = fM10460a;
                i = i2;
                canvas.drawLine(this.f8332p - ((float) (Math.cos(Math.toRadians(Math.abs(i4))) * d)), (float) (((double) this.f8333q) + (d * Math.sin(Math.toRadians(Math.abs(i4))))), (float) (((double) this.f8332p) - (((double) (fM10460a - this.f8309A)) * Math.cos(Math.toRadians(Math.abs(i4))))), (float) (((double) this.f8333q) + (((double) (fM10460a - this.f8309A)) * Math.sin(Math.toRadians(Math.abs(i4))))), this.f8316H);
            } else {
                i = i2;
                if (i3 <= 120) {
                    int i5 = 30 - i3;
                    double dCos = ((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.cos(Math.toRadians(Math.abs(i5)));
                    double dSin = ((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.sin(Math.toRadians(Math.abs(i5)));
                    if (this.f8342z[i].equals("100")) {
                        canvas.drawText(this.f8342z[i], this.f8332p - (this.f8315G.measureText(this.f8342z[i]) / 2.0f), (float) ((((double) this.f8333q) - (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.sin(Math.toRadians(90.0d)))) - ((double) (iM10460a / 2))), this.f8315G);
                    } else {
                        canvas.drawText(this.f8342z[i], (float) (((((double) this.f8332p) - dCos) - ((double) this.f8315G.measureText(this.f8342z[i]))) - ((double) (this.f8342z[i].equals("80") ? 0 : 10))), (float) (((((double) this.f8333q) - dSin) - ((double) (this.f8342z[i].equals("80") ? iM10460a / 2 : 0))) - ((double) (this.f8342z[i].equals("60") ? iM10460a / 3.0f : 0.0f))), this.f8315G);
                    }
                    double d2 = fM10460a;
                    canvas.drawLine(this.f8332p - ((float) (Math.cos(Math.toRadians(Math.abs(i5))) * d2)), (float) (((double) this.f8333q) - (d2 * Math.sin(Math.toRadians(Math.abs(i5))))), (float) (((double) this.f8332p) - (((double) (fM10460a - this.f8309A)) * Math.cos(Math.toRadians(Math.abs(i5))))), (float) (((double) this.f8333q) - (((double) (fM10460a - this.f8309A)) * Math.sin(Math.toRadians(Math.abs(i5))))), this.f8316H);
                } else if (i3 <= 210) {
                    double d3 = i3 - 120;
                    canvas.drawText(this.f8342z[i], ((float) (((double) this.f8332p) + (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.sin(Math.toRadians(d3))))) + (this.f8342z[i].equals("160") ? 10 : 0), (float) ((((double) this.f8333q) - (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.cos(Math.toRadians(d3)))) - ((double) (this.f8342z[i].equals("160") ? 0.0f : iM10460a / 2.0f))), this.f8315G);
                    double d4 = fM10460a;
                    canvas.drawLine(this.f8332p + ((float) (Math.sin(Math.toRadians(Math.abs(r1))) * d4)), (float) (((double) this.f8333q) - (d4 * Math.cos(Math.toRadians(Math.abs(r1))))), (float) (((double) this.f8332p) + (((double) (fM10460a - this.f8309A)) * Math.sin(Math.toRadians(Math.abs(r1))))), (float) (((double) this.f8333q) - (((double) (fM10460a - this.f8309A)) * Math.cos(Math.toRadians(Math.abs(r1))))), this.f8316H);
                } else {
                    double d5 = i3 - 210;
                    canvas.drawText(this.f8342z[i], (float) (((double) this.f8332p) + (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.cos(Math.toRadians(d5))) + 10.0d), (float) (((double) this.f8333q) + (((double) ((this.f8331o - this.f8340x) + 10.0f)) * Math.sin(Math.toRadians(d5))) + ((double) (iM10460a / 2))), this.f8315G);
                    double d6 = fM10460a;
                    canvas.drawLine(this.f8332p + ((float) (Math.cos(Math.toRadians(Math.abs(r1))) * d6)), (float) (((double) this.f8333q) + (d6 * Math.sin(Math.toRadians(Math.abs(r1))))), (float) (((double) this.f8332p) + (((double) (fM10460a - this.f8309A)) * Math.cos(Math.toRadians(Math.abs(r1))))), (float) (((double) this.f8333q) + (((double) (fM10460a - this.f8309A)) * Math.sin(Math.toRadians(Math.abs(r1))))), this.f8316H);
                }
            }
            i2 = i + 1;
        }
        double dSqrt = Math.sqrt((((this.f8313E.getHeight() * 204) / 224) * ((this.f8313E.getHeight() * 204) / 224)) + ((this.f8313E.getWidth() * this.f8313E.getWidth()) / 4));
        canvas.save();
        canvas.rotate(this.f8322f - 120.0f, this.f8332p, this.f8333q);
        canvas.drawBitmap(this.f8313E, ((int) this.f8332p) - (this.f8313E.getWidth() / 2), (int) (((double) this.f8333q) - dSqrt), (Paint) null);
        canvas.restore();
        this.f8319c.mo8148a(this, getProgress());
    }

    public float getAngle() {
        return this.f8322f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngle(float f) {
        this.f8322f = f;
    }

    public void setSeekBarChangeListener(InterfaceC1335a interfaceC1335a) {
        this.f8319c = interfaceC1335a;
    }

    public InterfaceC1335a getSeekBarChangeListener() {
        return this.f8319c;
    }

    public int getBarWidth() {
        return this.f8324h;
    }

    public void setBarWidth(int i) {
        this.f8324h = i;
    }

    public int getMaxProgress() {
        return this.f8327k;
    }

    public void setMaxProgress(int i) {
        this.f8327k = i;
    }

    public int getProgress() {
        return (int) this.f8328l;
    }

    public void setProgress(float f) {
        if (this.f8329m != f) {
            if (this.f8329m != this.f8327k || f <= this.f8327k) {
                if (f > this.f8327k) {
                    f = this.f8327k;
                }
                this.f8329m = f;
                this.f8310B.setFloatValues(this.f8328l, this.f8329m);
                this.f8310B.start();
            }
        }
    }

    public void setRingBackgroundColor(int i) {
        this.f8321e.setColor(i);
    }

    public void setProgressColor(int i) {
        this.f8320d.setColor(i);
    }
}
