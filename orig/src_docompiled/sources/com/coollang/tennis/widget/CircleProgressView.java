package com.coollang.tennis.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.coollang.tennis.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: A */
    private int f8043A;

    /* JADX INFO: renamed from: B */
    private int f8044B;

    /* JADX INFO: renamed from: C */
    private int[] f8045C;

    /* JADX INFO: renamed from: D */
    private int[] f8046D;

    /* JADX INFO: renamed from: E */
    private Paint.Cap f8047E;

    /* JADX INFO: renamed from: F */
    private Paint.Cap f8048F;

    /* JADX INFO: renamed from: G */
    private Paint f8049G;

    /* JADX INFO: renamed from: H */
    private Paint f8050H;

    /* JADX INFO: renamed from: I */
    private Paint f8051I;

    /* JADX INFO: renamed from: J */
    private Paint f8052J;

    /* JADX INFO: renamed from: K */
    private Paint f8053K;

    /* JADX INFO: renamed from: L */
    private Paint f8054L;

    /* JADX INFO: renamed from: M */
    private Paint f8055M;

    /* JADX INFO: renamed from: N */
    private RectF f8056N;

    /* JADX INFO: renamed from: O */
    private RectF f8057O;

    /* JADX INFO: renamed from: P */
    private RectF f8058P;

    /* JADX INFO: renamed from: Q */
    private RectF f8059Q;

    /* JADX INFO: renamed from: R */
    private RectF f8060R;

    /* JADX INFO: renamed from: S */
    private RectF f8061S;

    /* JADX INFO: renamed from: T */
    private float f8062T;

    /* JADX INFO: renamed from: U */
    private double f8063U;

    /* JADX INFO: renamed from: V */
    private int f8064V;

    /* JADX INFO: renamed from: W */
    private boolean f8065W;

    /* JADX INFO: renamed from: a */
    private float f8066a;

    /* JADX INFO: renamed from: aa */
    private Handler f8067aa;

    /* JADX INFO: renamed from: ab */
    private EnumC1312c f8068ab;

    /* JADX INFO: renamed from: ac */
    private TimeInterpolator f8069ac;

    /* JADX INFO: renamed from: ad */
    private String f8070ad;

    /* JADX INFO: renamed from: ae */
    private String f8071ae;

    /* JADX INFO: renamed from: af */
    private int f8072af;

    /* JADX INFO: renamed from: ag */
    private boolean f8073ag;

    /* JADX INFO: renamed from: ah */
    private boolean f8074ah;

    /* JADX INFO: renamed from: ai */
    private boolean f8075ai;

    /* JADX INFO: renamed from: aj */
    private boolean f8076aj;

    /* JADX INFO: renamed from: ak */
    private float f8077ak;

    /* JADX INFO: renamed from: al */
    private boolean f8078al;

    /* JADX INFO: renamed from: b */
    private float f8079b;

    /* JADX INFO: renamed from: c */
    private float f8080c;

    /* JADX INFO: renamed from: d */
    private float f8081d;

    /* JADX INFO: renamed from: e */
    private float f8082e;

    /* JADX INFO: renamed from: f */
    private float f8083f;

    /* JADX INFO: renamed from: g */
    private float f8084g;

    /* JADX INFO: renamed from: h */
    private int f8085h;

    /* JADX INFO: renamed from: i */
    private int f8086i;

    /* JADX INFO: renamed from: j */
    private int f8087j;

    /* JADX INFO: renamed from: k */
    private int f8088k;

    /* JADX INFO: renamed from: l */
    private int f8089l;

    /* JADX INFO: renamed from: m */
    private int f8090m;

    /* JADX INFO: renamed from: n */
    private int f8091n;

    /* JADX INFO: renamed from: o */
    private float f8092o;

    /* JADX INFO: renamed from: p */
    private float f8093p;

    /* JADX INFO: renamed from: q */
    private float f8094q;

    /* JADX INFO: renamed from: r */
    private int f8095r;

    /* JADX INFO: renamed from: s */
    private int f8096s;

    /* JADX INFO: renamed from: t */
    private int f8097t;

    /* JADX INFO: renamed from: u */
    private int f8098u;

    /* JADX INFO: renamed from: v */
    private final int f8099v;

    /* JADX INFO: renamed from: w */
    private int f8100w;

    /* JADX INFO: renamed from: x */
    private int f8101x;

    /* JADX INFO: renamed from: y */
    private int f8102y;

    /* JADX INFO: renamed from: z */
    private int f8103z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircleProgressView$b */
    enum EnumC1311b {
        START_SPINNING,
        STOP_SPINNING,
        SET_VALUE,
        SET_VALUE_ANIMATED,
        TICK
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircleProgressView$c */
    enum EnumC1312c {
        IDLE,
        SPINNING,
        END_SPINNING,
        END_SPINNING_START_ANIMATING,
        ANIMATING
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8066a = 0.0f;
        this.f8079b = 0.0f;
        this.f8080c = 0.0f;
        this.f8081d = 100.0f;
        this.f8082e = 0.0f;
        this.f8083f = 42.0f;
        this.f8084g = 0.0f;
        this.f8085h = 0;
        this.f8086i = 0;
        this.f8087j = 100;
        this.f8088k = 80;
        this.f8089l = 40;
        this.f8090m = 40;
        this.f8091n = 20;
        this.f8092o = 1.0f;
        this.f8093p = 1.0f;
        this.f8094q = 1.0f;
        this.f8095r = 0;
        this.f8096s = 0;
        this.f8097t = 0;
        this.f8098u = 0;
        this.f8099v = -16738680;
        this.f8100w = -1442840576;
        this.f8101x = -16738680;
        this.f8102y = 0;
        this.f8103z = -1434201911;
        this.f8043A = -16777216;
        this.f8044B = -16777216;
        this.f8045C = new int[]{-16738680, -16738680};
        this.f8046D = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        this.f8047E = Paint.Cap.ROUND;
        this.f8048F = Paint.Cap.ROUND;
        this.f8049G = new Paint();
        this.f8050H = new Paint();
        this.f8051I = new Paint();
        this.f8052J = new Paint();
        this.f8053K = new Paint();
        this.f8054L = new Paint();
        this.f8055M = new Paint();
        this.f8056N = new RectF();
        this.f8057O = new RectF();
        this.f8058P = new RectF();
        this.f8059Q = new RectF();
        this.f8060R = new RectF();
        this.f8061S = new RectF();
        this.f8062T = 2.8f;
        this.f8063U = 900.0d;
        this.f8064V = 15;
        this.f8067aa = new HandlerC1310a(this);
        this.f8068ab = EnumC1312c.IDLE;
        this.f8069ac = new AccelerateDecelerateInterpolator();
        this.f8070ad = "";
        this.f8071ae = "";
        this.f8075ai = true;
        this.f8076aj = false;
        this.f8077ak = 0.3f;
        this.f8078al = false;
        m8043a(context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressView));
    }

    /* JADX INFO: renamed from: a */
    private void m8043a(TypedArray typedArray) {
        setBarWidth((int) typedArray.getDimension(4, this.f8089l));
        setRimWidth((int) typedArray.getDimension(11, this.f8090m));
        setSpinSpeed((int) typedArray.getDimension(15, this.f8062T));
        if (typedArray.hasValue(0) && typedArray.hasValue(1) && typedArray.hasValue(2) && typedArray.hasValue(3)) {
            this.f8045C = new int[]{typedArray.getColor(0, -16738680), typedArray.getColor(1, -16738680), typedArray.getColor(2, -16738680), typedArray.getColor(3, -16738680)};
        } else if (typedArray.hasValue(0) && typedArray.hasValue(1) && typedArray.hasValue(2)) {
            this.f8045C = new int[]{typedArray.getColor(0, -16738680), typedArray.getColor(1, -16738680), typedArray.getColor(2, -16738680)};
        } else if (typedArray.hasValue(0) && typedArray.hasValue(1)) {
            this.f8045C = new int[]{typedArray.getColor(0, -16738680), typedArray.getColor(1, -16738680)};
        } else {
            this.f8045C = new int[]{typedArray.getColor(0, -16738680), typedArray.getColor(0, -16738680)};
        }
        this.f8078al = typedArray.getBoolean(8, false);
        setSpinBarColor(typedArray.getColor(14, this.f8101x));
        float dimension = typedArray.getDimension(13, this.f8083f);
        this.f8083f = dimension;
        setSpinningBarLength(dimension);
        setTextSize((int) typedArray.getDimension(19, -1.0f));
        setTextColor(typedArray.getColor(17, -1));
        setUnitColor(typedArray.getColor(21, -1));
        setText(typedArray.getString(16));
        setRimColor(typedArray.getColor(10, this.f8103z));
        setFillColor(typedArray.getColor(7, this.f8102y));
        setContourColor(typedArray.getColor(5, this.f8100w));
        setContourSize(typedArray.getDimension(6, this.f8092o));
        setMaxValue(typedArray.getDimension(9, this.f8081d));
        setUnit(typedArray.getString(20));
        setShowUnit(typedArray.getBoolean(12, this.f8076aj));
        setTextScale(typedArray.getDimension(18, this.f8093p));
        setUnitScale(typedArray.getDimension(22, this.f8094q));
        typedArray.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft > paddingTop) {
            paddingLeft = paddingTop;
        }
        setMeasuredDimension(getPaddingLeft() + paddingLeft + getPaddingRight(), paddingLeft + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: renamed from: a */
    private RectF m8040a(RectF rectF) {
        float f;
        float fWidth = (rectF.width() - ((float) ((((double) ((rectF.width() - Math.max(this.f8089l, this.f8090m)) - (this.f8092o * 2.0f))) / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        float f2 = 1.0f;
        if (m8067a()) {
            f2 = 0.77f;
            f = 1.33f;
        } else {
            f = 1.0f;
        }
        float f3 = f2 * fWidth;
        float f4 = fWidth * f;
        return new RectF(rectF.left + f3, rectF.top + f4, rectF.right - f3, rectF.bottom - f4);
    }

    /* JADX INFO: renamed from: a */
    private static float m8039a(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8086i = i;
        this.f8085h = i2;
        m8050b();
        setupPaints();
        invalidate();
    }

    public Paint.Cap getSpinnerStrokeCap() {
        return this.f8048F;
    }

    public void setSpinnerStrokeCap(Paint.Cap cap) {
        this.f8048F = cap;
    }

    public Paint.Cap getBarStrokeCap() {
        return this.f8047E;
    }

    public void setBarStrokeCap(Paint.Cap cap) {
        this.f8047E = cap;
    }

    public int getContourColor() {
        return this.f8100w;
    }

    public void setContourColor(int i) {
        this.f8100w = i;
    }

    public float getContourSize() {
        return this.f8092o;
    }

    public void setContourSize(float f) {
        this.f8092o = f;
    }

    public void setText(String str) {
        if (str == null || str.isEmpty()) {
            this.f8070ad = "";
            this.f8073ag = true;
        } else {
            this.f8070ad = str;
            this.f8073ag = false;
        }
        invalidate();
    }

    public String getUnit() {
        return this.f8071ae;
    }

    public void setUnit(String str) {
        if (str == null) {
            this.f8071ae = "";
        } else {
            this.f8071ae = str;
        }
        invalidate();
    }

    /* JADX INFO: renamed from: b */
    private RectF m8049b(String str, Paint paint, RectF rectF) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        RectF rectF2 = new RectF();
        if (str.length() >= 3 && this.f8071ae.length() > 2) {
            rectF2.left = rectF.left + ((rectF.width() - r0.width()) / 3.0f);
        } else {
            rectF2.left = rectF.left + ((rectF.width() - r0.width()) / 2.0f);
        }
        rectF2.top = rectF.top + ((rectF.height() - r0.height()) / 2.0f);
        rectF2.right = rectF2.left + r0.width();
        rectF2.bottom = rectF2.top + r0.height();
        return rectF2;
    }

    public void setShowPercentAsAutoValue(boolean z) {
        this.f8075ai = z;
    }

    public int getTextSize() {
        return this.f8091n;
    }

    public void setTextSize(int i) {
        if (i > 0) {
            this.f8091n = i;
            this.f8074ah = false;
        } else {
            this.f8074ah = true;
        }
    }

    public double getMaxValue() {
        return this.f8081d;
    }

    public void setMaxValue(float f) {
        this.f8081d = f;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.f8095r;
    }

    public void setPaddingTop(int i) {
        this.f8095r = i;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.f8096s;
    }

    public void setPaddingBottom(int i) {
        this.f8096s = i;
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.f8097t;
    }

    public void setPaddingLeft(int i) {
        this.f8097t = i;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.f8098u;
    }

    public void setPaddingRight(int i) {
        this.f8098u = i;
    }

    public int getCircleRadius() {
        return this.f8088k;
    }

    /* JADX INFO: renamed from: a */
    public boolean m8067a() {
        return this.f8076aj;
    }

    public void setShowUnit(boolean z) {
        this.f8076aj = z;
        this.f8072af = 0;
        invalidate();
        this.f8057O = m8040a(this.f8056N);
    }

    public float getUnitScale() {
        return this.f8094q;
    }

    public void setUnitScale(float f) {
        this.f8094q = f;
    }

    public float getTextScale() {
        return this.f8093p;
    }

    public void setTextScale(float f) {
        this.f8093p = f;
    }

    public void setSpinningBarLength(float f) {
        this.f8083f = f;
        this.f8082e = f;
    }

    public int getBarWidth() {
        return this.f8089l;
    }

    public void setBarWidth(int i) {
        this.f8089l = i;
    }

    public int[] getBarColors() {
        return this.f8045C;
    }

    public void setBarColor(int... iArr) {
        if (iArr.length == 1) {
            this.f8045C = new int[]{iArr[0], iArr[0]};
        } else {
            this.f8045C = iArr;
        }
    }

    public void setSpinBarColor(int i) {
        this.f8101x = i;
    }

    public int getFillColor() {
        return this.f8102y;
    }

    public void setFillColor(int i) {
        this.f8102y = i;
    }

    public int getRimColor() {
        return this.f8103z;
    }

    public void setRimColor(int i) {
        this.f8103z = i;
    }

    public Shader getRimShader() {
        return this.f8052J.getShader();
    }

    public void setRimShader(Shader shader) {
        this.f8052J.setShader(shader);
    }

    /* JADX INFO: renamed from: a */
    public int m8066a(double d) {
        int length = (int) (((double) this.f8045C.length) * (1.0d / getMaxValue()) * d);
        int[] iArr = this.f8045C;
        if (length >= this.f8045C.length) {
            length = this.f8045C.length - 1;
        }
        return iArr[length];
    }

    public int getTextColor() {
        return this.f8043A;
    }

    public void setTextColor(int i) {
        this.f8043A = i;
    }

    public void setUnitColor(int i) {
        this.f8044B = i;
    }

    public float getSpinSpeed() {
        return this.f8062T;
    }

    public void setSpinSpeed(float f) {
        this.f8062T = f;
    }

    public int getRimWidth() {
        return this.f8090m;
    }

    public void setRimWidth(int i) {
        this.f8090m = i;
    }

    public int getDelayMillis() {
        return this.f8064V;
    }

    public void setDelayMillis(int i) {
        this.f8064V = i;
    }

    public void setupPaints() {
        if (this.f8078al) {
            this.f8049G.setShader(new SweepGradient(this.f8056N.centerX(), this.f8056N.centerY(), this.f8046D, (float[]) null));
        } else {
            this.f8049G.setShader(new SweepGradient(this.f8056N.centerX(), this.f8056N.centerY(), this.f8045C, (float[]) null));
        }
        Matrix matrix = new Matrix();
        this.f8049G.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.f8056N.centerX(), -this.f8056N.centerY());
        matrix.postRotate(-90.0f);
        matrix.postTranslate(this.f8056N.centerX(), this.f8056N.centerY());
        this.f8049G.getShader().setLocalMatrix(matrix);
        this.f8049G.setAntiAlias(true);
        this.f8049G.setStyle(Paint.Style.STROKE);
        this.f8049G.setStrokeWidth(this.f8089l);
        this.f8050H.setAntiAlias(true);
        this.f8050H.setStrokeCap(this.f8048F);
        this.f8050H.setStyle(Paint.Style.STROKE);
        this.f8050H.setStrokeWidth(this.f8089l);
        this.f8050H.setColor(this.f8101x);
        this.f8052J.setColor(this.f8103z);
        this.f8052J.setAntiAlias(true);
        this.f8052J.setStyle(Paint.Style.STROKE);
        this.f8052J.setStrokeWidth(this.f8090m);
        this.f8051I.setColor(this.f8102y);
        this.f8051I.setAntiAlias(true);
        this.f8051I.setStyle(Paint.Style.FILL);
        this.f8053K.setColor(this.f8043A);
        this.f8053K.setStyle(Paint.Style.FILL);
        this.f8053K.setAntiAlias(true);
        this.f8053K.setTextSize(getTextSize());
        this.f8054L.setColor(this.f8044B);
        this.f8054L.setStyle(Paint.Style.FILL);
        this.f8054L.setAntiAlias(true);
        this.f8054L.setTextSize(getTextSize());
        this.f8055M.setColor(this.f8100w);
        this.f8055M.setAntiAlias(true);
        this.f8055M.setStyle(Paint.Style.STROKE);
        this.f8055M.setStrokeWidth(this.f8092o);
    }

    /* JADX INFO: renamed from: b */
    private void m8050b() {
        int iMin = Math.min(this.f8086i, this.f8085h);
        int i = this.f8086i - iMin;
        int i2 = (this.f8085h - iMin) / 2;
        this.f8095r = getPaddingTop() + i2;
        this.f8096s = getPaddingBottom() + i2;
        int i3 = i / 2;
        this.f8097t = getPaddingLeft() + i3;
        this.f8098u = getPaddingRight() + i3;
        int width = getWidth();
        this.f8056N = new RectF(this.f8097t + this.f8089l, this.f8095r + this.f8089l, (width - this.f8098u) - this.f8089l, (getHeight() - this.f8096s) - this.f8089l);
        this.f8057O = m8040a(this.f8056N);
        this.f8061S = new RectF(this.f8056N.left + (this.f8090m / 2.0f) + (this.f8092o / 2.0f), this.f8056N.top + (this.f8090m / 2.0f) + (this.f8092o / 2.0f), (this.f8056N.right - (this.f8090m / 2.0f)) - (this.f8092o / 2.0f), (this.f8056N.bottom - (this.f8090m / 2.0f)) - (this.f8092o / 2.0f));
        this.f8060R = new RectF((this.f8056N.left - (this.f8090m / 2.0f)) - (this.f8092o / 2.0f), (this.f8056N.top - (this.f8090m / 2.0f)) - (this.f8092o / 2.0f), this.f8056N.right + (this.f8090m / 2.0f) + (this.f8092o / 2.0f), this.f8056N.bottom + (this.f8090m / 2.0f) + (this.f8092o / 2.0f));
        this.f8087j = ((width - this.f8098u) - this.f8089l) / 2;
        this.f8088k = (this.f8087j - this.f8089l) + 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (360.0f / this.f8081d) * this.f8066a;
        canvas.drawArc(this.f8056N, 360.0f, 360.0f, false, this.f8051I);
        if (this.f8090m > 0) {
            canvas.drawArc(this.f8056N, 360.0f, 360.0f, false, this.f8052J);
        }
        if (this.f8092o > 0.0f) {
            canvas.drawArc(this.f8060R, 360.0f, 360.0f, false, this.f8055M);
            canvas.drawArc(this.f8061S, 360.0f, 360.0f, false, this.f8055M);
        }
        if (this.f8068ab == EnumC1312c.SPINNING || this.f8068ab == EnumC1312c.END_SPINNING) {
            m8044a(canvas);
            return;
        }
        if (this.f8068ab == EnumC1312c.END_SPINNING_START_ANIMATING) {
            m8044a(canvas);
            if (this.f8065W) {
                m8045a(canvas, f);
                return;
            }
            return;
        }
        m8045a(canvas, f);
    }

    /* JADX INFO: renamed from: a */
    private void m8044a(Canvas canvas) {
        if (this.f8082e < 0.0f) {
            this.f8082e = 1.0f;
        }
        canvas.drawArc(this.f8056N, (this.f8084g - 90.0f) - this.f8082e, this.f8082e, false, this.f8050H);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8045a(android.graphics.Canvas r10, float r11) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.CircleProgressView.m8045a(android.graphics.Canvas, float):void");
    }

    public void setValue(float f) {
        Message message = new Message();
        message.what = EnumC1311b.SET_VALUE.ordinal();
        message.obj = new float[]{f, f};
        this.f8067aa.sendMessage(message);
    }

    public void setValueAnimated(float f, float f2, long j) {
        this.f8063U = j;
        Message message = new Message();
        message.what = EnumC1311b.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{f, f2};
        this.f8067aa.sendMessage(message);
    }

    public void setValueAnimated(float f, long j) {
        this.f8063U = j;
        Message message = new Message();
        message.what = EnumC1311b.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.f8066a, f};
        this.f8067aa.sendMessage(message);
    }

    public void setValueAnimated(float f) {
        this.f8063U = 1200.0d;
        Message message = new Message();
        message.what = EnumC1311b.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.f8066a, f};
        this.f8067aa.sendMessage(message);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircleProgressView$a */
    static class HandlerC1310a extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<CircleProgressView> f8106a;

        /* JADX INFO: renamed from: b */
        private float f8107b;

        /* JADX INFO: renamed from: c */
        private long f8108c;

        /* JADX INFO: renamed from: d */
        private long f8109d;

        /* JADX INFO: renamed from: e */
        private TimeInterpolator f8110e;

        /* JADX INFO: renamed from: f */
        private double f8111f;

        HandlerC1310a(CircleProgressView circleProgressView) {
            super(circleProgressView.getContext().getMainLooper());
            this.f8110e = new DecelerateInterpolator();
            this.f8106a = new WeakReference<>(circleProgressView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CircleProgressView circleProgressView = this.f8106a.get();
            if (circleProgressView == null) {
            }
            EnumC1311b enumC1311b = EnumC1311b.values()[message.what];
            if (enumC1311b == EnumC1311b.TICK) {
                removeMessages(EnumC1311b.TICK.ordinal());
            }
            switch (circleProgressView.f8068ab) {
                case IDLE:
                    switch (enumC1311b) {
                        case START_SPINNING:
                            m8073c(circleProgressView);
                            break;
                        case SET_VALUE:
                            m8071b(message, circleProgressView);
                            break;
                        case SET_VALUE_ANIMATED:
                            m8068a(message, circleProgressView);
                            break;
                        case TICK:
                            removeMessages(EnumC1311b.TICK.ordinal());
                            break;
                    }
                    break;
                case SPINNING:
                    switch (enumC1311b) {
                        case STOP_SPINNING:
                            m8069a(circleProgressView);
                            break;
                        case SET_VALUE:
                            m8071b(message, circleProgressView);
                            break;
                        case SET_VALUE_ANIMATED:
                            m8070a(circleProgressView, message);
                            break;
                        case TICK:
                            float f = circleProgressView.f8082e - circleProgressView.f8083f;
                            float fCurrentTimeMillis = (float) ((System.currentTimeMillis() - this.f8109d) / this.f8111f);
                            if (fCurrentTimeMillis > 1.0f) {
                                fCurrentTimeMillis = 1.0f;
                            }
                            float interpolation = this.f8110e.getInterpolation(fCurrentTimeMillis);
                            if (Math.abs(f) < 1.0f) {
                                circleProgressView.f8082e = circleProgressView.f8083f;
                            } else if (circleProgressView.f8082e < circleProgressView.f8083f) {
                                circleProgressView.f8082e = this.f8107b + ((circleProgressView.f8083f - this.f8107b) * interpolation);
                            } else {
                                circleProgressView.f8082e = this.f8107b - ((this.f8107b - circleProgressView.f8083f) * interpolation);
                            }
                            circleProgressView.f8084g += circleProgressView.f8062T;
                            if (circleProgressView.f8084g > 360.0f) {
                                circleProgressView.f8084g = 0.0f;
                            }
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            circleProgressView.invalidate();
                            break;
                    }
                    break;
                case END_SPINNING:
                    switch (enumC1311b) {
                        case START_SPINNING:
                            circleProgressView.f8068ab = EnumC1312c.SPINNING;
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            break;
                        case SET_VALUE:
                            m8071b(message, circleProgressView);
                            break;
                        case SET_VALUE_ANIMATED:
                            m8070a(circleProgressView, message);
                            break;
                        case TICK:
                            float fCurrentTimeMillis2 = (float) ((System.currentTimeMillis() - this.f8109d) / this.f8111f);
                            if (fCurrentTimeMillis2 > 1.0f) {
                                fCurrentTimeMillis2 = 1.0f;
                            }
                            circleProgressView.f8082e = this.f8107b * (1.0f - this.f8110e.getInterpolation(fCurrentTimeMillis2));
                            circleProgressView.f8084g += circleProgressView.f8062T;
                            if (circleProgressView.f8082e < 0.01f) {
                                circleProgressView.f8068ab = EnumC1312c.IDLE;
                            }
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            circleProgressView.invalidate();
                            break;
                    }
                    break;
                case END_SPINNING_START_ANIMATING:
                    switch (enumC1311b) {
                        case START_SPINNING:
                            circleProgressView.f8065W = false;
                            m8073c(circleProgressView);
                            break;
                        case SET_VALUE:
                            circleProgressView.f8065W = false;
                            m8071b(message, circleProgressView);
                            break;
                        case SET_VALUE_ANIMATED:
                            circleProgressView.f8080c = 0.0f;
                            circleProgressView.f8079b = ((float[]) message.obj)[1];
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            break;
                        case TICK:
                            if (circleProgressView.f8082e > circleProgressView.f8083f && !circleProgressView.f8065W) {
                                float fCurrentTimeMillis3 = (float) ((System.currentTimeMillis() - this.f8109d) / this.f8111f);
                                if (fCurrentTimeMillis3 > 1.0f) {
                                    fCurrentTimeMillis3 = 1.0f;
                                }
                                circleProgressView.f8082e = this.f8107b * (1.0f - this.f8110e.getInterpolation(fCurrentTimeMillis3));
                            }
                            circleProgressView.f8084g += circleProgressView.f8062T;
                            if (circleProgressView.f8084g > 360.0f && !circleProgressView.f8065W) {
                                this.f8108c = System.currentTimeMillis();
                                circleProgressView.f8065W = true;
                                m8072b(circleProgressView);
                            }
                            if (circleProgressView.f8065W) {
                                circleProgressView.f8084g = 360.0f;
                                circleProgressView.f8082e -= circleProgressView.f8062T;
                                m8074d(circleProgressView);
                                float fCurrentTimeMillis4 = (float) ((System.currentTimeMillis() - this.f8109d) / this.f8111f);
                                if (fCurrentTimeMillis4 > 1.0f) {
                                    fCurrentTimeMillis4 = 1.0f;
                                }
                                circleProgressView.f8082e = this.f8107b * (1.0f - this.f8110e.getInterpolation(fCurrentTimeMillis4));
                            }
                            if (circleProgressView.f8082e < 0.1d) {
                                circleProgressView.f8068ab = EnumC1312c.ANIMATING;
                                circleProgressView.invalidate();
                                circleProgressView.f8065W = false;
                                circleProgressView.f8082e = circleProgressView.f8083f;
                            } else {
                                circleProgressView.invalidate();
                            }
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            break;
                    }
                    break;
                case ANIMATING:
                    switch (enumC1311b) {
                        case START_SPINNING:
                            m8073c(circleProgressView);
                            break;
                        case SET_VALUE:
                            m8071b(message, circleProgressView);
                            break;
                        case SET_VALUE_ANIMATED:
                            this.f8108c = System.currentTimeMillis();
                            circleProgressView.f8080c = circleProgressView.f8066a;
                            circleProgressView.f8079b = ((float[]) message.obj)[1];
                            break;
                        case TICK:
                            if (m8074d(circleProgressView)) {
                                circleProgressView.f8068ab = EnumC1312c.IDLE;
                                circleProgressView.f8066a = circleProgressView.f8079b;
                            }
                            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
                            circleProgressView.invalidate();
                            break;
                    }
                    break;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m8068a(Message message, CircleProgressView circleProgressView) {
            circleProgressView.f8080c = ((float[]) message.obj)[0];
            circleProgressView.f8079b = ((float[]) message.obj)[1];
            this.f8108c = System.currentTimeMillis();
            circleProgressView.f8068ab = EnumC1312c.ANIMATING;
            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
        }

        /* JADX INFO: renamed from: a */
        private void m8070a(CircleProgressView circleProgressView, Message message) {
            circleProgressView.f8068ab = EnumC1312c.END_SPINNING_START_ANIMATING;
            circleProgressView.f8080c = 0.0f;
            circleProgressView.f8079b = ((float[]) message.obj)[1];
            this.f8109d = System.currentTimeMillis();
            this.f8107b = circleProgressView.f8082e;
            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
        }

        /* JADX INFO: renamed from: a */
        private void m8069a(CircleProgressView circleProgressView) {
            circleProgressView.f8068ab = EnumC1312c.END_SPINNING;
            m8072b(circleProgressView);
            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
        }

        /* JADX INFO: renamed from: b */
        private void m8072b(CircleProgressView circleProgressView) {
            this.f8111f = (circleProgressView.f8082e / circleProgressView.f8062T) * circleProgressView.f8064V * 2.0f;
            this.f8109d = System.currentTimeMillis();
            this.f8107b = circleProgressView.f8082e;
        }

        /* JADX INFO: renamed from: c */
        private void m8073c(CircleProgressView circleProgressView) {
            circleProgressView.f8068ab = EnumC1312c.SPINNING;
            circleProgressView.f8082e = (360.0f / circleProgressView.f8081d) * circleProgressView.f8066a;
            circleProgressView.f8084g = (360.0f / circleProgressView.f8081d) * circleProgressView.f8066a;
            this.f8109d = System.currentTimeMillis();
            this.f8107b = circleProgressView.f8082e;
            this.f8111f = (circleProgressView.f8083f / circleProgressView.f8062T) * circleProgressView.f8064V * 2.0f;
            circleProgressView.f8067aa.sendEmptyMessageDelayed(EnumC1311b.TICK.ordinal(), circleProgressView.f8064V);
        }

        /* JADX INFO: renamed from: d */
        private boolean m8074d(CircleProgressView circleProgressView) {
            float fCurrentTimeMillis = (float) ((System.currentTimeMillis() - this.f8108c) / circleProgressView.f8063U);
            if (fCurrentTimeMillis > 1.0f) {
                fCurrentTimeMillis = 1.0f;
            }
            circleProgressView.f8066a = circleProgressView.f8080c + ((circleProgressView.f8079b - circleProgressView.f8080c) * circleProgressView.f8069ac.getInterpolation(fCurrentTimeMillis));
            return fCurrentTimeMillis >= 1.0f;
        }

        /* JADX INFO: renamed from: b */
        private void m8071b(Message message, CircleProgressView circleProgressView) {
            circleProgressView.f8080c = circleProgressView.f8079b;
            circleProgressView.f8066a = circleProgressView.f8079b = ((float[]) message.obj)[0];
            circleProgressView.f8068ab = EnumC1312c.IDLE;
            circleProgressView.invalidate();
        }
    }
}
