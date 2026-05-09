package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.Scroller;
import com.coollang.tennis.R;
import java.util.ArrayList;
import p000.AbstractC1917mp;
import p000.C1890lt;

/* JADX INFO: loaded from: classes.dex */
public class CoverFlowView<T extends AbstractC1917mp> extends View {

    /* JADX INFO: renamed from: h */
    private static float f8236h = 3.0f;

    /* JADX INFO: renamed from: i */
    private static final int f8237i = ViewConfiguration.getLongPressTimeout();

    /* JADX INFO: renamed from: A */
    private float f8238A;

    /* JADX INFO: renamed from: B */
    private long f8239B;

    /* JADX INFO: renamed from: C */
    private float f8240C;

    /* JADX INFO: renamed from: D */
    private float f8241D;

    /* JADX INFO: renamed from: E */
    private Runnable f8242E;

    /* JADX INFO: renamed from: F */
    private VelocityTracker f8243F;

    /* JADX INFO: renamed from: G */
    private int f8244G;

    /* JADX INFO: renamed from: H */
    private int f8245H;

    /* JADX INFO: renamed from: I */
    private int f8246I;

    /* JADX INFO: renamed from: J */
    private float f8247J;

    /* JADX INFO: renamed from: K */
    private int f8248K;

    /* JADX INFO: renamed from: L */
    private boolean f8249L;

    /* JADX INFO: renamed from: M */
    private InterfaceC1328c<T> f8250M;

    /* JADX INFO: renamed from: N */
    private InterfaceC1331f f8251N;

    /* JADX INFO: renamed from: O */
    private CoverFlowView<T>.RunnableC1329d f8252O;

    /* JADX INFO: renamed from: P */
    private boolean f8253P;

    /* JADX INFO: renamed from: Q */
    private boolean f8254Q;

    /* JADX INFO: renamed from: R */
    private int f8255R;

    /* JADX INFO: renamed from: S */
    private Scroller f8256S;

    /* JADX INFO: renamed from: T */
    private boolean f8257T;

    /* JADX INFO: renamed from: U */
    private ArrayList<Integer> f8258U;

    /* JADX INFO: renamed from: V */
    private SparseArray<int[]> f8259V;

    /* JADX INFO: renamed from: a */
    protected final int f8260a;

    /* JADX INFO: renamed from: b */
    protected int f8261b;

    /* JADX INFO: renamed from: c */
    protected final int f8262c;

    /* JADX INFO: renamed from: d */
    protected EnumC1326a f8263d;

    /* JADX INFO: renamed from: e */
    protected EnumC1327b f8264e;

    /* JADX INFO: renamed from: f */
    private final int f8265f;

    /* JADX INFO: renamed from: g */
    private int f8266g;

    /* JADX INFO: renamed from: j */
    private CoverFlowView<T>.C1330e f8267j;

    /* JADX INFO: renamed from: k */
    private T f8268k;

    /* JADX INFO: renamed from: l */
    private int f8269l;

    /* JADX INFO: renamed from: m */
    private int f8270m;

    /* JADX INFO: renamed from: n */
    private Rect f8271n;

    /* JADX INFO: renamed from: o */
    private PaintFlagsDrawFilter f8272o;

    /* JADX INFO: renamed from: p */
    private Matrix f8273p;

    /* JADX INFO: renamed from: q */
    private Matrix f8274q;

    /* JADX INFO: renamed from: r */
    private Paint f8275r;

    /* JADX INFO: renamed from: s */
    private RectF f8276s;

    /* JADX INFO: renamed from: t */
    private int f8277t;

    /* JADX INFO: renamed from: u */
    private boolean f8278u;

    /* JADX INFO: renamed from: v */
    private float f8279v;

    /* JADX INFO: renamed from: w */
    private float f8280w;

    /* JADX INFO: renamed from: x */
    private float f8281x;

    /* JADX INFO: renamed from: y */
    private float f8282y;

    /* JADX INFO: renamed from: z */
    private int f8283z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$a */
    public enum EnumC1326a {
        TOP,
        BOTTOM,
        CENTER_VERTICAL
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$b */
    public enum EnumC1327b {
        MATCH_PARENT,
        WRAP_CONTENT
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$c */
    public interface InterfaceC1328c<V extends AbstractC1917mp> {
        /* JADX INFO: renamed from: a */
        void m8129a();

        /* JADX INFO: renamed from: a */
        void m8130a(CoverFlowView<V> coverFlowView, int i);

        /* JADX INFO: renamed from: a */
        void m8131a(CoverFlowView<V> coverFlowView, int i, float f, float f2, float f3, float f4);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$f */
    public interface InterfaceC1331f {
        /* JADX INFO: renamed from: a */
        void m8140a(int i);
    }

    /* JADX INFO: renamed from: a */
    protected void m8128a(Matrix matrix, Paint paint, Bitmap bitmap, int i, float f) {
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public CoverFlowView(Context context) {
        super(context);
        this.f8260a = -1;
        this.f8261b = 3;
        this.f8262c = -200;
        this.f8265f = 76;
        this.f8249L = true;
        m8109a();
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8260a = -1;
        this.f8261b = 3;
        this.f8262c = -200;
        this.f8265f = 76;
        this.f8249L = true;
        m8114a(context, attributeSet);
        m8109a();
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8260a = -1;
        this.f8261b = 3;
        this.f8262c = -200;
        this.f8265f = 76;
        this.f8249L = true;
        m8114a(context, attributeSet);
        m8109a();
    }

    /* JADX INFO: renamed from: a */
    private void m8114a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageCoverFlowView);
        int i = typedArrayObtainStyledAttributes.getInt(5, 2);
        if (i % 2 == 0) {
            throw new IllegalArgumentException("visible image must be an odd number");
        }
        this.f8261b = i >> 1;
        this.f8247J = typedArrayObtainStyledAttributes.getFraction(3, 100, 0, 0.0f);
        if (this.f8247J > 100.0f) {
            this.f8247J = 100.0f;
        }
        this.f8247J /= 100.0f;
        this.f8248K = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f8263d = EnumC1326a.values()[typedArrayObtainStyledAttributes.getInt(0, EnumC1326a.CENTER_VERTICAL.ordinal())];
        this.f8264e = EnumC1327b.values()[typedArrayObtainStyledAttributes.getInt(1, EnumC1327b.WRAP_CONTENT.ordinal())];
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    private void m8109a() {
        setWillNotDraw(false);
        setClickable(true);
        this.f8273p = new Matrix();
        this.f8274q = new Matrix();
        this.f8276s = new RectF();
        this.f8259V = new SparseArray<>();
        this.f8275r = new Paint();
        this.f8275r.setAntiAlias(true);
        this.f8275r.setFlags(1);
        this.f8271n = new Rect();
        this.f8272o = new PaintFlagsDrawFilter(0, 3);
        this.f8256S = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
        this.f8258U = new ArrayList<>();
    }

    public void setAdapter(T t) {
        this.f8268k = t;
        if (this.f8268k != null) {
            this.f8270m = this.f8268k.m10582a();
            if (this.f8270m < (this.f8261b << 1) + 1) {
                throw new IllegalArgumentException("total count in adapter must larger than visible images!");
            }
            this.f8267j = new C1330e();
        }
        m8121b();
        requestLayout();
    }

    public T getAdapter() {
        return this.f8268k;
    }

    public void setCoverFlowListener(InterfaceC1328c<T> interfaceC1328c) {
        this.f8250M = interfaceC1328c;
    }

    /* JADX INFO: renamed from: b */
    private void m8121b() {
        if (this.f8267j != null) {
            this.f8267j.m8135a();
        }
        this.f8244G = 0;
        this.f8282y = 0.0f;
        this.f8283z = -1;
        this.f8266g = 179 / this.f8261b;
        if (this.f8263d == null) {
            this.f8263d = EnumC1326a.CENTER_VERTICAL;
        }
        if (this.f8264e == null) {
            this.f8264e = EnumC1327b.WRAP_CONTENT;
        }
        this.f8259V.clear();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8268k == null) {
            return;
        }
        this.f8271n.left = getPaddingLeft();
        this.f8271n.right = getPaddingRight();
        this.f8271n.top = getPaddingTop();
        this.f8271n.bottom = getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = (this.f8261b << 1) + 1;
        int i4 = (size2 - this.f8271n.top) - this.f8271n.bottom;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            float height = this.f8268k.m10583a(i6).getHeight();
            int i7 = (int) (height + (this.f8247J * height) + this.f8248K);
            if (i5 < i7) {
                i5 = i7;
            }
        }
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            if (i4 < i5 || this.f8264e == EnumC1327b.MATCH_PARENT) {
                this.f8244G = i4;
            } else if (this.f8264e == EnumC1327b.WRAP_CONTENT) {
                this.f8244G = i5;
                if (mode == Integer.MIN_VALUE) {
                    size2 = this.f8244G + this.f8271n.top + this.f8271n.bottom;
                }
            }
        } else if (this.f8264e == EnumC1327b.MATCH_PARENT) {
            this.f8244G = i4;
        } else if (this.f8264e == EnumC1327b.WRAP_CONTENT) {
            this.f8244G = i5;
            size2 = this.f8244G + this.f8271n.top + this.f8271n.bottom;
        }
        if (this.f8263d == EnumC1326a.CENTER_VERTICAL) {
            this.f8245H = (size2 >> 1) - (this.f8244G >> 1);
        } else if (this.f8263d == EnumC1326a.TOP) {
            this.f8245H = this.f8271n.top;
        } else if (this.f8263d == EnumC1326a.BOTTOM) {
            this.f8245H = (size2 - this.f8271n.bottom) - this.f8244G;
        }
        this.f8246I = (int) ((this.f8245H + this.f8244G) - (this.f8244G * this.f8247J));
        setMeasuredDimension(size, size2);
        this.f8269l = i3;
        this.f8277t = size;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f8268k == null) {
            super.onDraw(canvas);
            return;
        }
        this.f8257T = true;
        canvas.setDrawFilter(this.f8272o);
        float f = this.f8282y;
        int iFloor = (int) Math.floor(((double) f) + 0.5d);
        int i = this.f8269l % 2 == 0 ? (this.f8269l >> 1) - 1 : this.f8269l >> 1;
        for (int i2 = iFloor - (this.f8269l >> 1); i2 < iFloor; i2++) {
            m8127a(canvas, i2, i2 - f);
        }
        for (int i3 = i + iFloor; i3 >= iFloor; i3--) {
            m8127a(canvas, i3, i3 - f);
        }
        int i4 = (int) f;
        if (this.f8283z != i4) {
            m8113a(m8119b(i4));
            this.f8283z = i4;
        }
        this.f8257T = false;
        int size = this.f8258U.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f8267j.m8137b(this.f8258U.get(i5).intValue());
        }
        this.f8258U.clear();
        super.onDraw(canvas);
        if (this.f8250M != null) {
            this.f8250M.m8129a();
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m8127a(Canvas canvas, int i, float f) {
        int iM8119b = m8119b(i);
        Bitmap bitmapM10583a = this.f8268k.m10583a(iM8119b);
        m8108a(iM8119b, bitmapM10583a);
        int[] iArr = this.f8259V.get(iM8119b);
        if (iArr == null) {
            this.f8259V.put(iM8119b, new int[]{bitmapM10583a.getWidth(), bitmapM10583a.getHeight()});
        } else {
            iArr[0] = bitmapM10583a.getWidth();
            iArr[1] = bitmapM10583a.getHeight();
        }
        if (bitmapM10583a == null || bitmapM10583a.isRecycled() || canvas == null) {
            return;
        }
        m8115a(bitmapM10583a, i, f);
        canvas.drawBitmap(bitmapM10583a, this.f8273p, this.f8275r);
    }

    /* JADX INFO: renamed from: a */
    private void m8115a(Bitmap bitmap, int i, float f) {
        float fAbs;
        float f2;
        this.f8273p.reset();
        this.f8274q.reset();
        if (i != 0) {
            fAbs = 1.0f - (Math.abs(f) * 0.25f);
        } else {
            fAbs = 1.0f - (Math.abs(f) * 0.15f);
        }
        float f3 = fAbs;
        int i2 = (int) ((this.f8244G - (this.f8244G * this.f8247J)) - this.f8248K);
        int height = (int) (bitmap.getHeight() + (bitmap.getHeight() * this.f8247J) + this.f8248K);
        float height2 = i2 / bitmap.getHeight();
        float f4 = height2 * f3;
        int width = (int) (bitmap.getWidth() * f4);
        int width2 = ((int) (bitmap.getWidth() * height2)) >> 1;
        int i3 = ((this.f8277t >> 1) - this.f8271n.left) - width2;
        int i4 = ((this.f8277t >> 1) - this.f8271n.right) - width2;
        if (f <= 0.0f) {
            f2 = ((i3 / this.f8261b) * (this.f8261b + f)) + this.f8271n.left;
        } else {
            f2 = ((this.f8277t - ((i4 / this.f8261b) * (this.f8261b - f))) - width) - this.f8271n.right;
        }
        float f5 = f2;
        float fAbs2 = 254.0f - (Math.abs(f) * this.f8266g);
        if (fAbs2 < 0.0f) {
            fAbs2 = 0.0f;
        } else if (fAbs2 > 254.0f) {
            fAbs2 = 254.0f;
        }
        this.f8275r.setAlpha((int) fAbs2);
        int i5 = height >> 1;
        float f6 = -i5;
        this.f8273p.preTranslate(0.0f, f6);
        this.f8273p.postScale(f4, f4);
        float f7 = f4 != 1.0f ? (this.f8244G - height) >> 1 : 0.0f;
        this.f8273p.postTranslate(f5, this.f8245H + f7);
        m8128a(this.f8273p, this.f8275r, bitmap, i, f);
        float f8 = i5;
        this.f8273p.postTranslate(0.0f, f8);
        this.f8274q.preTranslate(0.0f, f6);
        this.f8274q.postScale(f4, f4);
        this.f8274q.postTranslate(f5, (this.f8246I * f3) + f7);
        m8128a(this.f8274q, this.f8275r, bitmap, i, f);
        this.f8274q.postTranslate(0.0f, f8);
    }

    /* JADX INFO: renamed from: a */
    private void m8113a(int i) {
        this.f8255R = i;
        int[] iArr = this.f8259V.get(i);
        int i2 = this.f8244G;
        int i3 = this.f8244G;
        float f = this.f8247J;
        int i4 = this.f8248K;
        int i5 = iArr[1];
        int i6 = iArr[0];
        Log.e("View", "height ==>652 width ==>540");
        this.f8276s.left = (float) ((this.f8277t >> 1) + (-270));
        this.f8276s.top = (float) this.f8245H;
        this.f8276s.right = this.f8276s.left + ((float) 540);
        this.f8276s.bottom = this.f8276s.top + ((float) 652);
        Log.e("View", "rect==>" + this.f8276s);
        if (this.f8250M != null) {
            this.f8250M.m8131a(this, i, this.f8276s.left, this.f8276s.top, this.f8276s.right, this.f8276s.bottom);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f8256S.computeScrollOffset()) {
                    this.f8256S.abortAnimation();
                    invalidate();
                }
                m8123c();
                m8112a(motionEvent.getX(), motionEvent.getY());
                m8116a(motionEvent);
                break;
            case 1:
                m8124c(motionEvent);
                m8123c();
                break;
            case 2:
                m8122b(motionEvent);
                break;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m8112a(float f, float f2) {
        if (!this.f8276s.contains(f, f2) || this.f8251N == null || !this.f8249L || this.f8253P) {
            return;
        }
        this.f8252O.m8132a(this.f8255R);
        postDelayed(this.f8252O, f8237i);
    }

    /* JADX INFO: renamed from: c */
    private void m8123c() {
        if (this.f8252O != null) {
            removeCallbacks(this.f8252O);
            this.f8253P = false;
            this.f8254Q = false;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8116a(MotionEvent motionEvent) {
        m8126e();
        float x = motionEvent.getX();
        this.f8280w = x;
        this.f8281x = motionEvent.getY();
        this.f8239B = AnimationUtils.currentAnimationTimeMillis();
        this.f8238A = this.f8282y;
        this.f8278u = false;
        this.f8279v = ((x / this.f8277t) * f8236h) - 5.0f;
        this.f8279v /= 2.0f;
        this.f8243F = VelocityTracker.obtain();
        this.f8243F.addMovement(motionEvent);
    }

    /* JADX INFO: renamed from: b */
    private void m8122b(MotionEvent motionEvent) {
        float x = (((motionEvent.getX() / this.f8277t) * f8236h) - 5.0f) / 2.0f;
        if (!this.f8278u) {
            float fAbs = Math.abs(motionEvent.getX() - this.f8280w);
            float fAbs2 = Math.abs(motionEvent.getY() - this.f8281x);
            if (fAbs < 5.0f && fAbs2 < 5.0f) {
                return;
            }
            this.f8278u = true;
            m8123c();
        }
        this.f8282y = (this.f8238A + this.f8279v) - x;
        invalidate();
        this.f8243F.addMovement(motionEvent);
    }

    /* JADX INFO: renamed from: c */
    private void m8124c(MotionEvent motionEvent) {
        float x = (((motionEvent.getX() / this.f8277t) * f8236h) - 5.0f) / 2.0f;
        if (this.f8278u || ((double) this.f8282y) - Math.floor(this.f8282y) != 0.0d) {
            this.f8238A += this.f8279v - x;
            this.f8282y = this.f8238A;
            this.f8243F.addMovement(motionEvent);
            this.f8243F.computeCurrentVelocity(1000);
            double xVelocity = (((double) this.f8243F.getXVelocity()) / ((double) this.f8277t)) * 1.0d;
            if (xVelocity > 6.0d) {
                xVelocity = 6.0d;
            } else if (xVelocity < -6.0d) {
                xVelocity = -6.0d;
            }
            m8110a(-xVelocity);
        } else {
            Log.e("View", " touch ==>" + motionEvent.getX() + " , " + motionEvent.getY());
            if (this.f8276s != null && this.f8276s.contains(motionEvent.getX(), motionEvent.getY()) && this.f8250M != null && this.f8249L && !this.f8254Q) {
                this.f8250M.m8130a(this, this.f8255R);
            }
        }
        this.f8243F.clear();
        this.f8243F.recycle();
    }

    /* JADX INFO: renamed from: a */
    private void m8110a(double d) {
        if (this.f8242E != null) {
            return;
        }
        double d2 = (d * d) / 20.0d;
        if (d < 0.0d) {
            d2 = -d2;
        }
        double dFloor = Math.floor(((double) this.f8238A) + d2 + 0.5d);
        this.f8240C = (float) Math.sqrt(Math.abs(dFloor - ((double) this.f8238A)) * 10.0d * 2.0d);
        if (dFloor < this.f8238A) {
            this.f8240C = -this.f8240C;
        }
        this.f8241D = Math.abs(this.f8240C / 10.0f);
        this.f8239B = AnimationUtils.currentAnimationTimeMillis();
        this.f8242E = new Runnable() { // from class: com.coollang.tennis.widget.CoverFlowView.1
            @Override // java.lang.Runnable
            public void run() {
                CoverFlowView.this.m8125d();
            }
        };
        post(this.f8242E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m8125d() {
        float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - this.f8239B) / 1000.0f;
        if (fCurrentAnimationTimeMillis >= this.f8241D) {
            m8126e();
        } else {
            m8111a(fCurrentAnimationTimeMillis);
            post(this.f8242E);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m8126e() {
        if (this.f8242E != null) {
            this.f8282y = (float) Math.floor(((double) this.f8282y) + 0.5d);
            invalidate();
            removeCallbacks(this.f8242E);
            this.f8242E = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8111a(float f) {
        if (f > this.f8241D) {
            f = this.f8241D;
        }
        float fAbs = (Math.abs(this.f8240C) * f) - (((10.0f * f) * f) / 2.0f);
        if (this.f8240C < 0.0f) {
            fAbs = -fAbs;
        }
        this.f8282y = this.f8238A + fAbs;
        invalidate();
    }

    /* JADX INFO: renamed from: b */
    private int m8119b(int i) {
        if (this.f8268k == null) {
            return -1;
        }
        int iM10582a = this.f8268k.m10582a();
        int i2 = i + this.f8261b;
        while (true) {
            if (i2 >= 0 && i2 < iM10582a) {
                return i2;
            }
            if (i2 < 0) {
                i2 += iM10582a;
            } else if (i2 >= iM10582a) {
                i2 -= iM10582a;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m8108a(int i, Bitmap bitmap) {
        if (this.f8247J <= 0.0f) {
            return null;
        }
        Bitmap bitmapM8134a = this.f8267j.m8134a(i);
        if (bitmapM8134a == null || bitmapM8134a.isRecycled()) {
            this.f8267j.m8137b(i);
            bitmapM8134a = C1890lt.m10437a(bitmap, this.f8247J);
            if (bitmapM8134a != null) {
                this.f8267j.m8136a(i, bitmapM8134a);
                return bitmapM8134a;
            }
        }
        return bitmapM8134a;
    }

    public void setVisibleImage(int i) {
        if (i % 2 == 0) {
            throw new IllegalArgumentException("visible image must be an odd number");
        }
        this.f8261b = i / 2;
        this.f8266g = 179 / this.f8261b;
    }

    public void setCoverFlowGravity(EnumC1326a enumC1326a) {
        this.f8263d = enumC1326a;
    }

    public void setCoverFlowLayoutMode(EnumC1327b enumC1327b) {
        this.f8264e = enumC1327b;
    }

    public void setReflectionHeight(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.f8247J = i;
    }

    public void setReflectionGap(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f8248K = i;
    }

    public void setSelection(int i) {
        int iM10582a = this.f8268k.m10582a();
        if (i < 0 || i >= iM10582a) {
            throw new IllegalArgumentException("Position want to select can not less than 0 or larger than max of adapter provide!");
        }
        if (this.f8255R != i) {
            if (this.f8256S.computeScrollOffset()) {
                this.f8256S.abortAnimation();
            }
            int i2 = (int) (this.f8282y * 100.0f);
            this.f8256S.startScroll(i2, 0, ((i - this.f8261b) * 100) - i2, 0, Math.min(Math.abs((iM10582a + i) - this.f8255R), Math.abs(i - this.f8255R)) * 100);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8256S.computeScrollOffset()) {
            this.f8282y = this.f8256S.getCurrX() / 100.0f;
            invalidate();
        }
    }

    public void setTopImageLongClickListener(InterfaceC1331f interfaceC1331f) {
        this.f8251N = interfaceC1331f;
        if (interfaceC1331f == null) {
            this.f8252O = null;
        } else if (this.f8252O == null) {
            this.f8252O = new RunnableC1329d();
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$d */
    class RunnableC1329d implements Runnable {

        /* JADX INFO: renamed from: b */
        private int f8293b;

        private RunnableC1329d() {
        }

        /* JADX INFO: renamed from: a */
        public void m8132a(int i) {
            this.f8293b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CoverFlowView.this.f8251N != null) {
                CoverFlowView.this.f8251N.m8140a(this.f8293b);
                CoverFlowView.this.f8254Q = true;
            }
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CoverFlowView$e */
    class C1330e {

        /* JADX INFO: renamed from: a */
        @SuppressLint({"NewApi"})
        final LruCache<Integer, Bitmap> f8294a;

        C1330e() {
            this.f8294a = new LruCache<Integer, Bitmap>(m8133a(CoverFlowView.this.getContext())) { // from class: com.coollang.tennis.widget.CoverFlowView.e.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.util.LruCache
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int sizeOf(Integer num, Bitmap bitmap) {
                    if (Build.VERSION.SDK_INT < 12) {
                        return bitmap.getRowBytes() * bitmap.getHeight();
                    }
                    return bitmap.getByteCount();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.util.LruCache
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                    if (!z || bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    bitmap.recycle();
                }
            };
        }

        @SuppressLint({"NewApi"})
        /* JADX INFO: renamed from: a */
        public Bitmap m8134a(int i) {
            return this.f8294a.get(Integer.valueOf(i));
        }

        @SuppressLint({"NewApi"})
        /* JADX INFO: renamed from: a */
        public void m8136a(int i, Bitmap bitmap) {
            this.f8294a.put(Integer.valueOf(i), bitmap);
            Runtime.getRuntime().gc();
        }

        @SuppressLint({"NewApi"})
        /* JADX INFO: renamed from: b */
        public Bitmap m8137b(int i) {
            if (i < 0 || i >= this.f8294a.size()) {
                return null;
            }
            return this.f8294a.remove(Integer.valueOf(i));
        }

        @SuppressLint({"NewApi"})
        /* JADX INFO: renamed from: a */
        public void m8135a() {
            this.f8294a.evictAll();
        }

        /* JADX INFO: renamed from: a */
        private int m8133a(Context context) {
            int memoryClass = (((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1048576) / 21;
            Log.e("View", "cacheSize == " + memoryClass);
            return memoryClass;
        }
    }
}
