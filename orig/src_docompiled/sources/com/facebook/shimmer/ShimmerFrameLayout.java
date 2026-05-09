package com.facebook.shimmer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: c */
    private static final PorterDuffXfermode f8874c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* JADX INFO: renamed from: a */
    protected ValueAnimator f8875a;

    /* JADX INFO: renamed from: b */
    protected Bitmap f8876b;

    /* JADX INFO: renamed from: d */
    private Paint f8877d;

    /* JADX INFO: renamed from: e */
    private Paint f8878e;

    /* JADX INFO: renamed from: f */
    private C1397a f8879f;

    /* JADX INFO: renamed from: g */
    private C1400d f8880g;

    /* JADX INFO: renamed from: h */
    private Bitmap f8881h;

    /* JADX INFO: renamed from: i */
    private Bitmap f8882i;

    /* JADX INFO: renamed from: j */
    private boolean f8883j;

    /* JADX INFO: renamed from: k */
    private int f8884k;

    /* JADX INFO: renamed from: l */
    private int f8885l;

    /* JADX INFO: renamed from: m */
    private int f8886m;

    /* JADX INFO: renamed from: n */
    private int f8887n;

    /* JADX INFO: renamed from: o */
    private int f8888o;

    /* JADX INFO: renamed from: p */
    private int f8889p;

    /* JADX INFO: renamed from: q */
    private boolean f8890q;

    /* JADX INFO: renamed from: r */
    private ViewTreeObserver.OnGlobalLayoutListener f8891r;

    /* JADX INFO: renamed from: com.facebook.shimmer.ShimmerFrameLayout$b */
    public enum EnumC1398b {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* JADX INFO: renamed from: com.facebook.shimmer.ShimmerFrameLayout$c */
    public enum EnumC1399c {
        LINEAR,
        RADIAL
    }

    /* JADX INFO: renamed from: com.facebook.shimmer.ShimmerFrameLayout$a */
    static class C1397a {

        /* JADX INFO: renamed from: a */
        public EnumC1398b f8896a;

        /* JADX INFO: renamed from: b */
        public float f8897b;

        /* JADX INFO: renamed from: c */
        public float f8898c;

        /* JADX INFO: renamed from: d */
        public int f8899d;

        /* JADX INFO: renamed from: e */
        public int f8900e;

        /* JADX INFO: renamed from: f */
        public float f8901f;

        /* JADX INFO: renamed from: g */
        public float f8902g;

        /* JADX INFO: renamed from: h */
        public float f8903h;

        /* JADX INFO: renamed from: i */
        public EnumC1399c f8904i;

        private C1397a() {
        }

        /* JADX INFO: renamed from: a */
        public int m8392a(int i) {
            return this.f8899d > 0 ? this.f8899d : (int) (i * this.f8902g);
        }

        /* JADX INFO: renamed from: b */
        public int m8394b(int i) {
            return this.f8900e > 0 ? this.f8900e : (int) (i * this.f8903h);
        }

        /* JADX INFO: renamed from: a */
        public int[] m8393a() {
            if (C13963.f8894a[this.f8904i.ordinal()] != 2) {
                return new int[]{0, -16777216, -16777216, 0};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        /* JADX INFO: renamed from: b */
        public float[] m8395b() {
            if (C13963.f8894a[this.f8904i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f8901f) - this.f8898c) / 2.0f, 0.0f), Math.max((1.0f - this.f8901f) / 2.0f, 0.0f), Math.min((this.f8901f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f8901f + 1.0f) + this.f8898c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f8901f, 1.0f), Math.min(this.f8901f + this.f8898c, 1.0f)};
        }
    }

    /* JADX INFO: renamed from: com.facebook.shimmer.ShimmerFrameLayout$d */
    static class C1400d {

        /* JADX INFO: renamed from: a */
        public int f8913a;

        /* JADX INFO: renamed from: b */
        public int f8914b;

        /* JADX INFO: renamed from: c */
        public int f8915c;

        /* JADX INFO: renamed from: d */
        public int f8916d;

        private C1400d() {
        }

        /* JADX INFO: renamed from: a */
        public void m8396a(int i, int i2, int i3, int i4) {
            this.f8913a = i;
            this.f8914b = i2;
            this.f8915c = i3;
            this.f8916d = i4;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f8879f = new C1397a();
        this.f8877d = new Paint();
        this.f8878e = new Paint();
        this.f8878e.setAntiAlias(true);
        this.f8878e.setDither(true);
        this.f8878e.setFilterBitmap(true);
        this.f8878e.setXfermode(f8874c);
        m8389a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (typedArrayObtainStyledAttributes.hasValue(0)) {
                    setAutoStart(typedArrayObtainStyledAttributes.getBoolean(0, false));
                }
                if (typedArrayObtainStyledAttributes.hasValue(1)) {
                    setBaseAlpha(typedArrayObtainStyledAttributes.getFloat(1, 0.0f));
                }
                if (typedArrayObtainStyledAttributes.hasValue(2)) {
                    setDuration(typedArrayObtainStyledAttributes.getInt(2, 0));
                }
                if (typedArrayObtainStyledAttributes.hasValue(3)) {
                    setRepeatCount(typedArrayObtainStyledAttributes.getInt(3, 0));
                }
                if (typedArrayObtainStyledAttributes.hasValue(4)) {
                    setRepeatDelay(typedArrayObtainStyledAttributes.getInt(4, 0));
                }
                if (typedArrayObtainStyledAttributes.hasValue(5)) {
                    setRepeatMode(typedArrayObtainStyledAttributes.getInt(5, 0));
                }
                if (typedArrayObtainStyledAttributes.hasValue(6)) {
                    int i2 = typedArrayObtainStyledAttributes.getInt(6, 0);
                    if (i2 == 90) {
                        this.f8879f.f8896a = EnumC1398b.CW_90;
                    } else if (i2 == 180) {
                        this.f8879f.f8896a = EnumC1398b.CW_180;
                    } else if (i2 != 270) {
                        this.f8879f.f8896a = EnumC1398b.CW_0;
                    } else {
                        this.f8879f.f8896a = EnumC1398b.CW_270;
                    }
                }
                if (typedArrayObtainStyledAttributes.hasValue(13)) {
                    if (typedArrayObtainStyledAttributes.getInt(13, 0) != 1) {
                        this.f8879f.f8904i = EnumC1399c.LINEAR;
                    } else {
                        this.f8879f.f8904i = EnumC1399c.RADIAL;
                    }
                }
                if (typedArrayObtainStyledAttributes.hasValue(7)) {
                    this.f8879f.f8898c = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (typedArrayObtainStyledAttributes.hasValue(8)) {
                    this.f8879f.f8899d = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
                }
                if (typedArrayObtainStyledAttributes.hasValue(9)) {
                    this.f8879f.f8900e = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
                }
                if (typedArrayObtainStyledAttributes.hasValue(10)) {
                    this.f8879f.f8901f = typedArrayObtainStyledAttributes.getFloat(10, 0.0f);
                }
                if (typedArrayObtainStyledAttributes.hasValue(11)) {
                    this.f8879f.f8902g = typedArrayObtainStyledAttributes.getFloat(11, 0.0f);
                }
                if (typedArrayObtainStyledAttributes.hasValue(12)) {
                    this.f8879f.f8903h = typedArrayObtainStyledAttributes.getFloat(12, 0.0f);
                }
                if (typedArrayObtainStyledAttributes.hasValue(14)) {
                    this.f8879f.f8897b = typedArrayObtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8389a() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f8879f.f8896a = EnumC1398b.CW_0;
        this.f8879f.f8904i = EnumC1399c.LINEAR;
        this.f8879f.f8898c = 0.5f;
        this.f8879f.f8899d = 0;
        this.f8879f.f8900e = 0;
        this.f8879f.f8901f = 0.0f;
        this.f8879f.f8902g = 1.0f;
        this.f8879f.f8903h = 1.0f;
        this.f8879f.f8897b = 20.0f;
        this.f8880g = new C1400d();
        setBaseAlpha(0.3f);
        m8386g();
    }

    public void setAutoStart(boolean z) {
        this.f8883j = z;
        m8386g();
    }

    public float getBaseAlpha() {
        return this.f8877d.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.f8877d.setAlpha((int) (m8372a(0.0f, 1.0f, f) * 255.0f));
        m8386g();
    }

    public int getDuration() {
        return this.f8884k;
    }

    public void setDuration(int i) {
        this.f8884k = i;
        m8386g();
    }

    public int getRepeatCount() {
        return this.f8885l;
    }

    public void setRepeatCount(int i) {
        this.f8885l = i;
        m8386g();
    }

    public int getRepeatDelay() {
        return this.f8886m;
    }

    public void setRepeatDelay(int i) {
        this.f8886m = i;
        m8386g();
    }

    public int getRepeatMode() {
        return this.f8887n;
    }

    public void setRepeatMode(int i) {
        this.f8887n = i;
        m8386g();
    }

    public EnumC1399c getMaskShape() {
        return this.f8879f.f8904i;
    }

    public void setMaskShape(EnumC1399c enumC1399c) {
        this.f8879f.f8904i = enumC1399c;
        m8386g();
    }

    public EnumC1398b getAngle() {
        return this.f8879f.f8896a;
    }

    public void setAngle(EnumC1398b enumC1398b) {
        this.f8879f.f8896a = enumC1398b;
        m8386g();
    }

    public float getDropoff() {
        return this.f8879f.f8898c;
    }

    public void setDropoff(float f) {
        this.f8879f.f8898c = f;
        m8386g();
    }

    public int getFixedWidth() {
        return this.f8879f.f8899d;
    }

    public void setFixedWidth(int i) {
        this.f8879f.f8899d = i;
        m8386g();
    }

    public int getFixedHeight() {
        return this.f8879f.f8900e;
    }

    public void setFixedHeight(int i) {
        this.f8879f.f8900e = i;
        m8386g();
    }

    public float getIntensity() {
        return this.f8879f.f8901f;
    }

    public void setIntensity(float f) {
        this.f8879f.f8901f = f;
        m8386g();
    }

    public float getRelativeWidth() {
        return this.f8879f.f8902g;
    }

    public void setRelativeWidth(int i) {
        this.f8879f.f8902g = i;
        m8386g();
    }

    public float getRelativeHeight() {
        return this.f8879f.f8903h;
    }

    public void setRelativeHeight(int i) {
        this.f8879f.f8903h = i;
        m8386g();
    }

    public float getTilt() {
        return this.f8879f.f8897b;
    }

    public void setTilt(float f) {
        this.f8879f.f8897b = f;
        m8386g();
    }

    /* JADX INFO: renamed from: b */
    public void m8390b() {
        if (this.f8890q) {
            return;
        }
        getShimmerAnimation().start();
        this.f8890q = true;
    }

    /* JADX INFO: renamed from: c */
    public void m8391c() {
        if (this.f8875a != null) {
            this.f8875a.end();
            this.f8875a.removeAllUpdateListeners();
            this.f8875a.cancel();
        }
        this.f8875a = null;
        this.f8890q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.f8888o == i) {
            return;
        }
        this.f8888o = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.f8889p == i) {
            return;
        }
        this.f8889p = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8891r == null) {
            this.f8891r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f8891r);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.facebook.shimmer.ShimmerFrameLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z = ShimmerFrameLayout.this.f8890q;
                ShimmerFrameLayout.this.m8386g();
                if (ShimmerFrameLayout.this.f8883j || z) {
                    ShimmerFrameLayout.this.m8390b();
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        m8391c();
        if (this.f8891r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f8891r);
            this.f8891r = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.f8890q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m8375a(canvas);
        }
    }

    /* JADX INFO: renamed from: a */
    private static float m8372a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    /* JADX INFO: renamed from: a */
    private boolean m8375a(Canvas canvas) {
        Bitmap bitmapM8382d = m8382d();
        Bitmap bitmapM8384e = m8384e();
        if (bitmapM8382d == null || bitmapM8384e == null) {
            return false;
        }
        m8377b(new Canvas(bitmapM8382d));
        canvas.drawBitmap(bitmapM8382d, 0.0f, 0.0f, this.f8877d);
        m8380c(new Canvas(bitmapM8384e));
        canvas.drawBitmap(bitmapM8384e, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    /* JADX INFO: renamed from: d */
    private Bitmap m8382d() {
        if (this.f8882i == null) {
            this.f8882i = m8385f();
        }
        return this.f8882i;
    }

    /* JADX INFO: renamed from: e */
    private Bitmap m8384e() {
        if (this.f8881h == null) {
            this.f8881h = m8385f();
        }
        return this.f8881h;
    }

    /* JADX INFO: renamed from: f */
    private Bitmap m8385f() {
        int width = getWidth();
        int height = getHeight();
        try {
            return m8373a(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8377b(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: renamed from: c */
    private void m8380c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap == null) {
            return;
        }
        canvas.clipRect(this.f8888o, this.f8889p, this.f8888o + maskBitmap.getWidth(), this.f8889p + maskBitmap.getHeight());
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.f8888o, this.f8889p, this.f8878e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m8386g() {
        m8391c();
        m8387h();
        m8388i();
    }

    /* JADX INFO: renamed from: h */
    private void m8387h() {
        if (this.f8876b != null) {
            this.f8876b.recycle();
            this.f8876b = null;
        }
    }

    /* JADX INFO: renamed from: i */
    private void m8388i() {
        if (this.f8882i != null) {
            this.f8882i.recycle();
            this.f8882i = null;
        }
        if (this.f8881h != null) {
            this.f8881h.recycle();
            this.f8881h = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        if (this.f8876b != null) {
            return this.f8876b;
        }
        int iM8392a = this.f8879f.m8392a(getWidth());
        int iM8394b = this.f8879f.m8394b(getHeight());
        this.f8876b = m8373a(iM8392a, iM8394b);
        Canvas canvas = new Canvas(this.f8876b);
        if (C13963.f8894a[this.f8879f.f8904i.ordinal()] != 2) {
            int i4 = 0;
            switch (this.f8879f.f8896a) {
                case CW_90:
                    i = iM8394b;
                    i2 = 0;
                    i3 = 0;
                    break;
                case CW_180:
                    i4 = iM8392a;
                    i2 = 0;
                    i3 = 0;
                    i = 0;
                    break;
                case CW_270:
                    i2 = iM8394b;
                    i3 = 0;
                    i = 0;
                    break;
                default:
                    i3 = iM8392a;
                    i2 = 0;
                    i = 0;
                    break;
            }
            radialGradient = new LinearGradient(i4, i2, i3, i, this.f8879f.m8393a(), this.f8879f.m8395b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(iM8392a / 2, iM8394b / 2, (float) (((double) Math.max(iM8392a, iM8394b)) / Math.sqrt(2.0d)), this.f8879f.m8393a(), this.f8879f.m8395b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.f8879f.f8897b, iM8392a / 2, iM8394b / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        float f = -(((int) (Math.sqrt(2.0d) * ((double) Math.max(iM8392a, iM8394b)))) / 2);
        canvas.drawRect(f, f, iM8392a + r3, iM8394b + r3, paint);
        return this.f8876b;
    }

    /* JADX INFO: renamed from: com.facebook.shimmer.ShimmerFrameLayout$3 */
    static /* synthetic */ class C13963 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f8894a;

        static {
            try {
                f8895b[EnumC1398b.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8895b[EnumC1398b.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8895b[EnumC1398b.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8895b[EnumC1398b.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f8894a = new int[EnumC1399c.values().length];
            try {
                f8894a[EnumC1399c.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8894a[EnumC1399c.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private Animator getShimmerAnimation() {
        if (this.f8875a != null) {
            return this.f8875a;
        }
        int width = getWidth();
        int height = getHeight();
        int i = C13963.f8894a[this.f8879f.f8904i.ordinal()];
        switch (this.f8879f.f8896a) {
            case CW_90:
                this.f8880g.m8396a(0, -height, 0, height);
                break;
            case CW_180:
                this.f8880g.m8396a(width, 0, -width, 0);
                break;
            case CW_270:
                this.f8880g.m8396a(0, height, 0, -height);
                break;
            default:
                this.f8880g.m8396a(-width, 0, width, 0);
                break;
        }
        this.f8875a = ValueAnimator.ofFloat(0.0f, (this.f8886m / this.f8884k) + 1.0f);
        this.f8875a.setDuration(this.f8884k + this.f8886m);
        this.f8875a.setRepeatCount(this.f8885l);
        this.f8875a.setRepeatMode(this.f8887n);
        this.f8875a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.shimmer.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fMax = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                float f = 1.0f - fMax;
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.f8880g.f8913a * f) + (ShimmerFrameLayout.this.f8880g.f8915c * fMax)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((ShimmerFrameLayout.this.f8880g.f8914b * f) + (ShimmerFrameLayout.this.f8880g.f8916d * fMax)));
            }
        });
        return this.f8875a;
    }

    /* JADX INFO: renamed from: a */
    protected static Bitmap m8373a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
