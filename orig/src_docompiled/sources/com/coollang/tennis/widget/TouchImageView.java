package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes.dex */
public class TouchImageView extends ImageView {

    /* JADX INFO: renamed from: A */
    private View.OnTouchListener f8734A;

    /* JADX INFO: renamed from: B */
    private InterfaceC1378e f8735B;

    /* JADX INFO: renamed from: a */
    private float f8736a;

    /* JADX INFO: renamed from: b */
    private Matrix f8737b;

    /* JADX INFO: renamed from: c */
    private Matrix f8738c;

    /* JADX INFO: renamed from: d */
    private EnumC1381h f8739d;

    /* JADX INFO: renamed from: e */
    private float f8740e;

    /* JADX INFO: renamed from: f */
    private float f8741f;

    /* JADX INFO: renamed from: g */
    private float f8742g;

    /* JADX INFO: renamed from: h */
    private float f8743h;

    /* JADX INFO: renamed from: i */
    private float[] f8744i;

    /* JADX INFO: renamed from: j */
    private Context f8745j;

    /* JADX INFO: renamed from: k */
    private RunnableC1376c f8746k;

    /* JADX INFO: renamed from: l */
    private ImageView.ScaleType f8747l;

    /* JADX INFO: renamed from: m */
    private boolean f8748m;

    /* JADX INFO: renamed from: n */
    private boolean f8749n;

    /* JADX INFO: renamed from: o */
    private C1382i f8750o;

    /* JADX INFO: renamed from: p */
    private int f8751p;

    /* JADX INFO: renamed from: q */
    private int f8752q;

    /* JADX INFO: renamed from: r */
    private int f8753r;

    /* JADX INFO: renamed from: s */
    private int f8754s;

    /* JADX INFO: renamed from: t */
    private float f8755t;

    /* JADX INFO: renamed from: u */
    private float f8756u;

    /* JADX INFO: renamed from: v */
    private float f8757v;

    /* JADX INFO: renamed from: w */
    private float f8758w;

    /* JADX INFO: renamed from: x */
    private ScaleGestureDetector f8759x;

    /* JADX INFO: renamed from: y */
    private GestureDetector f8760y;

    /* JADX INFO: renamed from: z */
    private GestureDetector.OnDoubleTapListener f8761z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$e */
    public interface InterfaceC1378e {
        /* JADX INFO: renamed from: a */
        void m8322a();
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$h */
    enum EnumC1381h {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    /* JADX INFO: renamed from: a */
    private float m8271a(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f5 = f2 - f3;
            f4 = 0.0f;
        } else {
            f4 = f2 - f3;
            f5 = 0.0f;
        }
        if (f < f4) {
            return (-f) + f4;
        }
        if (f > f5) {
            return (-f) + f5;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public float m8287b(float f, float f2, float f3) {
        if (f3 <= f2) {
            return 0.0f;
        }
        return f;
    }

    public TouchImageView(Context context) {
        super(context);
        this.f8761z = null;
        this.f8734A = null;
        this.f8735B = null;
        m8282a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8761z = null;
        this.f8734A = null;
        this.f8735B = null;
        m8282a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8761z = null;
        this.f8734A = null;
        this.f8735B = null;
        m8282a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m8282a(Context context) {
        super.setClickable(true);
        this.f8745j = context;
        C13731 c13731 = null;
        this.f8759x = new ScaleGestureDetector(context, new C1380g(this, c13731));
        this.f8760y = new GestureDetector(context, new C1377d(this, c13731));
        this.f8737b = new Matrix();
        this.f8738c = new Matrix();
        this.f8744i = new float[9];
        this.f8736a = 1.0f;
        if (this.f8747l == null) {
            this.f8747l = ImageView.ScaleType.FIT_CENTER;
        }
        this.f8740e = 1.0f;
        this.f8741f = 3.0f;
        this.f8742g = this.f8740e * 0.75f;
        this.f8743h = this.f8741f * 1.25f;
        setImageMatrix(this.f8737b);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(EnumC1381h.NONE);
        this.f8749n = false;
        super.setOnTouchListener(new ViewOnTouchListenerC1379f(this, c13731));
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f8734A = onTouchListener;
    }

    public void setOnTouchImageViewListener(InterfaceC1378e interfaceC1378e) {
        this.f8735B = interfaceC1378e;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8761z = onDoubleTapListener;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        m8290c();
        m8296f();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m8290c();
        m8296f();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m8290c();
        m8296f();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m8290c();
        m8296f();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        }
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        this.f8747l = scaleType;
        if (this.f8749n) {
            setZoom(this);
        }
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f8747l;
    }

    /* JADX INFO: renamed from: a */
    public boolean m8310a() {
        return this.f8736a != 1.0f;
    }

    public RectF getZoomedRect() {
        if (this.f8747l == ImageView.ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF pointFM8275a = m8275a(0.0f, 0.0f, true);
        PointF pointFM8275a2 = m8275a(this.f8751p, this.f8752q, true);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        return new RectF(pointFM8275a.x / intrinsicWidth, pointFM8275a.y / intrinsicHeight, pointFM8275a2.x / intrinsicWidth, pointFM8275a2.y / intrinsicHeight);
    }

    /* JADX INFO: renamed from: c */
    private void m8290c() {
        if (this.f8737b == null || this.f8752q == 0 || this.f8751p == 0) {
            return;
        }
        this.f8737b.getValues(this.f8744i);
        this.f8738c.setValues(this.f8744i);
        this.f8758w = this.f8756u;
        this.f8757v = this.f8755t;
        this.f8754s = this.f8752q;
        this.f8753r = this.f8751p;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f8736a);
        bundle.putFloat("matchViewHeight", this.f8756u);
        bundle.putFloat("matchViewWidth", this.f8755t);
        bundle.putInt("viewWidth", this.f8751p);
        bundle.putInt("viewHeight", this.f8752q);
        this.f8737b.getValues(this.f8744i);
        bundle.putFloatArray("matrix", this.f8744i);
        bundle.putBoolean("imageRendered", this.f8748m);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f8736a = bundle.getFloat("saveScale");
            this.f8744i = bundle.getFloatArray("matrix");
            this.f8738c.setValues(this.f8744i);
            this.f8758w = bundle.getFloat("matchViewHeight");
            this.f8757v = bundle.getFloat("matchViewWidth");
            this.f8754s = bundle.getInt("viewHeight");
            this.f8753r = bundle.getInt("viewWidth");
            this.f8748m = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f8749n = true;
        this.f8748m = true;
        if (this.f8750o != null) {
            setZoom(this.f8750o.f8791a, this.f8750o.f8792b, this.f8750o.f8793c, this.f8750o.f8794d);
            this.f8750o = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m8290c();
    }

    public float getMaxZoom() {
        return this.f8741f;
    }

    public void setMaxZoom(float f) {
        this.f8741f = f;
        this.f8743h = this.f8741f * 1.25f;
    }

    public float getMinZoom() {
        return this.f8740e;
    }

    public float getCurrentZoom() {
        return this.f8736a;
    }

    public void setMinZoom(float f) {
        this.f8740e = f;
        this.f8742g = this.f8740e * 0.75f;
    }

    /* JADX INFO: renamed from: b */
    public void m8311b() {
        this.f8736a = 1.0f;
        m8296f();
    }

    public void setZoom(float f) {
        setZoom(f, 0.5f, 0.5f);
    }

    public void setZoom(float f, float f2, float f3) {
        setZoom(f, f2, f3, this.f8747l);
    }

    public void setZoom(float f, float f2, float f3, ImageView.ScaleType scaleType) {
        if (!this.f8749n) {
            this.f8750o = new C1382i(f, f2, f3, scaleType);
            return;
        }
        if (scaleType != this.f8747l) {
            setScaleType(scaleType);
        }
        m8311b();
        m8280a(f, this.f8751p / 2, this.f8752q / 2, true);
        this.f8737b.getValues(this.f8744i);
        this.f8744i[2] = -((f2 * getImageWidth()) - (this.f8751p * 0.5f));
        this.f8744i[5] = -((f3 * getImageHeight()) - (this.f8752q * 0.5f));
        this.f8737b.setValues(this.f8744i);
        m8292d();
        setImageMatrix(this.f8737b);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        setZoom(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF pointFM8275a = m8275a(this.f8751p / 2, this.f8752q / 2, true);
        pointFM8275a.x /= intrinsicWidth;
        pointFM8275a.y /= intrinsicHeight;
        return pointFM8275a;
    }

    public void setScrollPosition(float f, float f2) {
        setZoom(this.f8736a, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m8292d() {
        this.f8737b.getValues(this.f8744i);
        float f = this.f8744i[2];
        float f2 = this.f8744i[5];
        float fM8271a = m8271a(f, this.f8751p, getImageWidth());
        float fM8271a2 = m8271a(f2, this.f8752q, getImageHeight());
        if (fM8271a == 0.0f && fM8271a2 == 0.0f) {
            return;
        }
        this.f8737b.postTranslate(fM8271a, fM8271a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m8294e() {
        m8292d();
        this.f8737b.getValues(this.f8744i);
        if (getImageWidth() < this.f8751p) {
            this.f8744i[2] = (this.f8751p - getImageWidth()) / 2.0f;
        }
        if (getImageHeight() < this.f8752q) {
            this.f8744i[5] = (this.f8752q - getImageHeight()) / 2.0f;
        }
        this.f8737b.setValues(this.f8744i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageWidth() {
        return this.f8755t * this.f8736a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageHeight() {
        return this.f8756u * this.f8736a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.f8751p = m8273a(mode, size, intrinsicWidth);
        this.f8752q = m8273a(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.f8751p, this.f8752q);
        m8296f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8296f() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.TouchImageView.m8296f():void");
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$1 */
    static /* synthetic */ class C13731 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f8762a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f8762a[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8762a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8762a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8762a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8762a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m8273a(int i, int i2, int i3) {
        if (i != Integer.MIN_VALUE) {
            return i != 0 ? i2 : i3;
        }
        return Math.min(i3, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m8281a(int i, float f, float f2, float f3, int i2, int i3, int i4) {
        float f4 = i3;
        if (f3 < f4) {
            this.f8744i[i] = (f4 - (i4 * this.f8744i[0])) * 0.5f;
        } else if (f > 0.0f) {
            this.f8744i[i] = -((f3 - f4) * 0.5f);
        } else {
            this.f8744i[i] = -((((Math.abs(f) + (i2 * 0.5f)) / f2) * f3) - (f4 * 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(EnumC1381h enumC1381h) {
        this.f8739d = enumC1381h;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        this.f8737b.getValues(this.f8744i);
        float f = this.f8744i[2];
        if (getImageWidth() < this.f8751p) {
            return false;
        }
        if (f < -1.0f || i >= 0) {
            return (Math.abs(f) + ((float) this.f8751p)) + 1.0f < getImageWidth() || i <= 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$d */
    class C1377d extends GestureDetector.SimpleOnGestureListener {
        private C1377d() {
        }

        /* synthetic */ C1377d(TouchImageView touchImageView, C13731 c13731) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (TouchImageView.this.f8761z != null) {
                return TouchImageView.this.f8761z.onSingleTapConfirmed(motionEvent);
            }
            return TouchImageView.this.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (TouchImageView.this.f8746k != null) {
                TouchImageView.this.f8746k.m8321a();
            }
            TouchImageView.this.f8746k = TouchImageView.this.new RunnableC1376c((int) f, (int) f2);
            TouchImageView.this.m8286a(TouchImageView.this.f8746k);
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = TouchImageView.this.f8761z != null ? TouchImageView.this.f8761z.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.f8739d != EnumC1381h.NONE) {
                return zOnDoubleTap;
            }
            TouchImageView.this.m8286a(TouchImageView.this.new RunnableC1375b(TouchImageView.this.f8736a == TouchImageView.this.f8740e ? TouchImageView.this.f8741f : TouchImageView.this.f8740e, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.f8761z != null) {
                return TouchImageView.this.f8761z.onDoubleTapEvent(motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$f */
    class ViewOnTouchListenerC1379f implements View.OnTouchListener {

        /* JADX INFO: renamed from: b */
        private PointF f8783b;

        private ViewOnTouchListenerC1379f() {
            this.f8783b = new PointF();
        }

        /* synthetic */ ViewOnTouchListenerC1379f(TouchImageView touchImageView, C13731 c13731) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
            /*
                Method dump skipped, instruction units count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.TouchImageView.ViewOnTouchListenerC1379f.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$g */
    class C1380g extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private C1380g() {
        }

        /* synthetic */ C1380g(TouchImageView touchImageView, C13731 c13731) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.setState(EnumC1381h.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.m8280a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.f8735B == null) {
                return true;
            }
            TouchImageView.this.f8735B.m8322a();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(EnumC1381h.NONE);
            float f = TouchImageView.this.f8736a;
            boolean z = true;
            if (TouchImageView.this.f8736a > TouchImageView.this.f8741f) {
                f = TouchImageView.this.f8741f;
            } else if (TouchImageView.this.f8736a < TouchImageView.this.f8740e) {
                f = TouchImageView.this.f8740e;
            } else {
                z = false;
            }
            float f2 = f;
            if (z) {
                TouchImageView.this.m8286a(TouchImageView.this.new RunnableC1375b(f2, TouchImageView.this.f8751p / 2, TouchImageView.this.f8752q / 2, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8280a(double d, float f, float f2, boolean z) {
        float f3;
        float f4;
        if (z) {
            f3 = this.f8742g;
            f4 = this.f8743h;
        } else {
            f3 = this.f8740e;
            f4 = this.f8741f;
        }
        float f5 = this.f8736a;
        this.f8736a = (float) (((double) this.f8736a) * d);
        if (this.f8736a > f4) {
            this.f8736a = f4;
            d = f4 / f5;
        } else if (this.f8736a < f3) {
            this.f8736a = f3;
            d = f3 / f5;
        }
        float f6 = (float) d;
        this.f8737b.postScale(f6, f6, f, f2);
        m8294e();
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$b */
    class RunnableC1375b implements Runnable {

        /* JADX INFO: renamed from: b */
        private long f8768b;

        /* JADX INFO: renamed from: c */
        private float f8769c;

        /* JADX INFO: renamed from: d */
        private float f8770d;

        /* JADX INFO: renamed from: e */
        private float f8771e;

        /* JADX INFO: renamed from: f */
        private float f8772f;

        /* JADX INFO: renamed from: g */
        private boolean f8773g;

        /* JADX INFO: renamed from: h */
        private AccelerateDecelerateInterpolator f8774h = new AccelerateDecelerateInterpolator();

        /* JADX INFO: renamed from: i */
        private PointF f8775i;

        /* JADX INFO: renamed from: j */
        private PointF f8776j;

        RunnableC1375b(float f, float f2, float f3, boolean z) {
            TouchImageView.this.setState(EnumC1381h.ANIMATE_ZOOM);
            this.f8768b = System.currentTimeMillis();
            this.f8769c = TouchImageView.this.f8736a;
            this.f8770d = f;
            this.f8773g = z;
            PointF pointFM8275a = TouchImageView.this.m8275a(f2, f3, false);
            this.f8771e = pointFM8275a.x;
            this.f8772f = pointFM8275a.y;
            this.f8775i = TouchImageView.this.m8274a(this.f8771e, this.f8772f);
            this.f8776j = new PointF(TouchImageView.this.f8751p / 2, TouchImageView.this.f8752q / 2);
        }

        @Override // java.lang.Runnable
        public void run() {
            float fM8318a = m8318a();
            TouchImageView.this.m8280a(m8320b(fM8318a), this.f8771e, this.f8772f, this.f8773g);
            m8319a(fM8318a);
            TouchImageView.this.m8294e();
            TouchImageView.this.setImageMatrix(TouchImageView.this.f8737b);
            if (TouchImageView.this.f8735B != null) {
                TouchImageView.this.f8735B.m8322a();
            }
            if (fM8318a < 1.0f) {
                TouchImageView.this.m8286a(this);
            } else {
                TouchImageView.this.setState(EnumC1381h.NONE);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m8319a(float f) {
            float f2 = this.f8775i.x + ((this.f8776j.x - this.f8775i.x) * f);
            float f3 = this.f8775i.y + (f * (this.f8776j.y - this.f8775i.y));
            PointF pointFM8274a = TouchImageView.this.m8274a(this.f8771e, this.f8772f);
            TouchImageView.this.f8737b.postTranslate(f2 - pointFM8274a.x, f3 - pointFM8274a.y);
        }

        /* JADX INFO: renamed from: a */
        private float m8318a() {
            return this.f8774h.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.f8768b) / 500.0f));
        }

        /* JADX INFO: renamed from: b */
        private double m8320b(float f) {
            return ((double) (this.f8769c + (f * (this.f8770d - this.f8769c)))) / ((double) TouchImageView.this.f8736a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public PointF m8275a(float f, float f2, boolean z) {
        this.f8737b.getValues(this.f8744i);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float f3 = this.f8744i[2];
        float f4 = this.f8744i[5];
        float imageWidth = ((f - f3) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f2 - f4) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public PointF m8274a(float f, float f2) {
        this.f8737b.getValues(this.f8744i);
        return new PointF(this.f8744i[2] + (getImageWidth() * (f / getDrawable().getIntrinsicWidth())), this.f8744i[5] + (getImageHeight() * (f2 / getDrawable().getIntrinsicHeight())));
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$c */
    class RunnableC1376c implements Runnable {

        /* JADX INFO: renamed from: a */
        C1374a f8777a;

        /* JADX INFO: renamed from: b */
        int f8778b;

        /* JADX INFO: renamed from: c */
        int f8779c;

        RunnableC1376c(int i, int i2) {
            int imageWidth;
            int i3;
            int imageHeight;
            int i4;
            TouchImageView.this.setState(EnumC1381h.FLING);
            this.f8777a = TouchImageView.this.new C1374a(TouchImageView.this.f8745j);
            TouchImageView.this.f8737b.getValues(TouchImageView.this.f8744i);
            int i5 = (int) TouchImageView.this.f8744i[2];
            int i6 = (int) TouchImageView.this.f8744i[5];
            if (TouchImageView.this.getImageWidth() > TouchImageView.this.f8751p) {
                imageWidth = TouchImageView.this.f8751p - ((int) TouchImageView.this.getImageWidth());
                i3 = 0;
            } else {
                imageWidth = i5;
                i3 = imageWidth;
            }
            if (TouchImageView.this.getImageHeight() > TouchImageView.this.f8752q) {
                imageHeight = TouchImageView.this.f8752q - ((int) TouchImageView.this.getImageHeight());
                i4 = 0;
            } else {
                imageHeight = i6;
                i4 = imageHeight;
            }
            this.f8777a.m8312a(i5, i6, i, i2, imageWidth, i3, imageHeight, i4);
            this.f8778b = i5;
            this.f8779c = i6;
        }

        /* JADX INFO: renamed from: a */
        public void m8321a() {
            if (this.f8777a != null) {
                TouchImageView.this.setState(EnumC1381h.NONE);
                this.f8777a.m8313a(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.f8735B != null) {
                TouchImageView.this.f8735B.m8322a();
            }
            if (this.f8777a.m8314a()) {
                this.f8777a = null;
                return;
            }
            if (this.f8777a.m8315b()) {
                int iM8316c = this.f8777a.m8316c();
                int iM8317d = this.f8777a.m8317d();
                int i = iM8316c - this.f8778b;
                int i2 = iM8317d - this.f8779c;
                this.f8778b = iM8316c;
                this.f8779c = iM8317d;
                TouchImageView.this.f8737b.postTranslate(i, i2);
                TouchImageView.this.m8292d();
                TouchImageView.this.setImageMatrix(TouchImageView.this.f8737b);
                TouchImageView.this.m8286a(this);
            }
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$a */
    @TargetApi(9)
    class C1374a {

        /* JADX INFO: renamed from: a */
        Scroller f8763a;

        /* JADX INFO: renamed from: b */
        OverScroller f8764b;

        /* JADX INFO: renamed from: c */
        boolean f8765c;

        public C1374a(Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.f8765c = true;
                this.f8763a = new Scroller(context);
            } else {
                this.f8765c = false;
                this.f8764b = new OverScroller(context);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m8312a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f8765c) {
                this.f8763a.fling(i, i2, i3, i4, i5, i6, i7, i8);
            } else {
                this.f8764b.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m8313a(boolean z) {
            if (this.f8765c) {
                this.f8763a.forceFinished(z);
            } else {
                this.f8764b.forceFinished(z);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m8314a() {
            if (this.f8765c) {
                return this.f8763a.isFinished();
            }
            return this.f8764b.isFinished();
        }

        /* JADX INFO: renamed from: b */
        public boolean m8315b() {
            if (this.f8765c) {
                return this.f8763a.computeScrollOffset();
            }
            this.f8764b.computeScrollOffset();
            return this.f8764b.computeScrollOffset();
        }

        /* JADX INFO: renamed from: c */
        public int m8316c() {
            if (this.f8765c) {
                return this.f8763a.getCurrX();
            }
            return this.f8764b.getCurrX();
        }

        /* JADX INFO: renamed from: d */
        public int m8317d() {
            if (this.f8765c) {
                return this.f8763a.getCurrY();
            }
            return this.f8764b.getCurrY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* JADX INFO: renamed from: a */
    public void m8286a(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchImageView$i */
    class C1382i {

        /* JADX INFO: renamed from: a */
        public float f8791a;

        /* JADX INFO: renamed from: b */
        public float f8792b;

        /* JADX INFO: renamed from: c */
        public float f8793c;

        /* JADX INFO: renamed from: d */
        public ImageView.ScaleType f8794d;

        public C1382i(float f, float f2, float f3, ImageView.ScaleType scaleType) {
            this.f8791a = f;
            this.f8792b = f2;
            this.f8793c = f3;
            this.f8794d = scaleType;
        }
    }
}
