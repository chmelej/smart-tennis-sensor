package com.coollang.tennis.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class RippleView extends RelativeLayout {

    /* JADX INFO: renamed from: a */
    private int f8599a;

    /* JADX INFO: renamed from: b */
    private int f8600b;

    /* JADX INFO: renamed from: c */
    private int f8601c;

    /* JADX INFO: renamed from: d */
    private int f8602d;

    /* JADX INFO: renamed from: e */
    private int f8603e;

    /* JADX INFO: renamed from: f */
    private Handler f8604f;

    /* JADX INFO: renamed from: g */
    private float f8605g;

    /* JADX INFO: renamed from: h */
    private boolean f8606h;

    /* JADX INFO: renamed from: i */
    private int f8607i;

    /* JADX INFO: renamed from: j */
    private int f8608j;

    /* JADX INFO: renamed from: k */
    private int f8609k;

    /* JADX INFO: renamed from: l */
    private float f8610l;

    /* JADX INFO: renamed from: m */
    private float f8611m;

    /* JADX INFO: renamed from: n */
    private int f8612n;

    /* JADX INFO: renamed from: o */
    private float f8613o;

    /* JADX INFO: renamed from: p */
    private ScaleAnimation f8614p;

    /* JADX INFO: renamed from: q */
    private Boolean f8615q;

    /* JADX INFO: renamed from: r */
    private Boolean f8616r;

    /* JADX INFO: renamed from: s */
    private Integer f8617s;

    /* JADX INFO: renamed from: t */
    private Paint f8618t;

    /* JADX INFO: renamed from: u */
    private Bitmap f8619u;

    /* JADX INFO: renamed from: v */
    private int f8620v;

    /* JADX INFO: renamed from: w */
    private int f8621w;

    /* JADX INFO: renamed from: x */
    private GestureDetector f8622x;

    /* JADX INFO: renamed from: y */
    private final Runnable f8623y;

    /* JADX INFO: renamed from: z */
    private InterfaceC1365a f8624z;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.RippleView$a */
    public interface InterfaceC1365a {
        /* JADX INFO: renamed from: a */
        void mo7110a(RippleView rippleView);
    }

    public RippleView(Context context) {
        super(context);
        this.f8601c = 10;
        this.f8602d = 200;
        this.f8603e = 90;
        this.f8605g = 0.0f;
        this.f8606h = false;
        this.f8607i = 0;
        this.f8608j = 0;
        this.f8609k = -1;
        this.f8610l = -1.0f;
        this.f8611m = -1.0f;
        this.f8623y = new Runnable() { // from class: com.coollang.tennis.widget.RippleView.1
            @Override // java.lang.Runnable
            public void run() {
                RippleView.this.invalidate();
            }
        };
    }

    public RippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8601c = 10;
        this.f8602d = 200;
        this.f8603e = 90;
        this.f8605g = 0.0f;
        this.f8606h = false;
        this.f8607i = 0;
        this.f8608j = 0;
        this.f8609k = -1;
        this.f8610l = -1.0f;
        this.f8611m = -1.0f;
        this.f8623y = new Runnable() { // from class: com.coollang.tennis.widget.RippleView.1
            @Override // java.lang.Runnable
            public void run() {
                RippleView.this.invalidate();
            }
        };
        m8244a(context, attributeSet);
    }

    public RippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8601c = 10;
        this.f8602d = 200;
        this.f8603e = 90;
        this.f8605g = 0.0f;
        this.f8606h = false;
        this.f8607i = 0;
        this.f8608j = 0;
        this.f8609k = -1;
        this.f8610l = -1.0f;
        this.f8611m = -1.0f;
        this.f8623y = new Runnable() { // from class: com.coollang.tennis.widget.RippleView.1
            @Override // java.lang.Runnable
            public void run() {
                RippleView.this.invalidate();
            }
        };
        m8244a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m8244a(Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RippleView);
        this.f8620v = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.white_menu_bg));
        this.f8617s = Integer.valueOf(typedArrayObtainStyledAttributes.getInt(6, 0));
        this.f8615q = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(7, false));
        this.f8616r = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(1, false));
        this.f8602d = typedArrayObtainStyledAttributes.getInteger(4, this.f8602d);
        this.f8601c = typedArrayObtainStyledAttributes.getInteger(3, this.f8601c);
        this.f8603e = typedArrayObtainStyledAttributes.getInteger(0, this.f8603e);
        this.f8621w = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f8604f = new Handler();
        this.f8613o = typedArrayObtainStyledAttributes.getFloat(9, 1.03f);
        this.f8612n = typedArrayObtainStyledAttributes.getInt(8, 200);
        typedArrayObtainStyledAttributes.recycle();
        this.f8618t = new Paint();
        this.f8618t.setAntiAlias(true);
        this.f8618t.setStyle(Paint.Style.FILL);
        this.f8618t.setColor(this.f8620v);
        this.f8618t.setAlpha(this.f8603e);
        setWillNotDraw(false);
        this.f8622x = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.coollang.tennis.widget.RippleView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                RippleView.this.m8247a(motionEvent);
                RippleView.this.m8246a((Boolean) true);
            }
        });
        setDrawingCacheEnabled(true);
        setClickable(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f8606h) {
            if (this.f8602d <= this.f8607i * this.f8601c) {
                this.f8606h = false;
                this.f8607i = 0;
                this.f8609k = -1;
                this.f8608j = 0;
                canvas.save();
                canvas.restore();
                invalidate();
                if (this.f8624z != null) {
                    this.f8624z.mo7110a(this);
                    return;
                }
                return;
            }
            this.f8604f.postDelayed(this.f8623y, this.f8601c);
            if (this.f8607i == 0) {
                canvas.save();
            }
            canvas.drawCircle(this.f8610l, this.f8611m, this.f8605g * ((this.f8607i * this.f8601c) / this.f8602d), this.f8618t);
            this.f8618t.setColor(Color.parseColor("#ffff4444"));
            if (this.f8617s.intValue() == 1 && this.f8619u != null && (this.f8607i * this.f8601c) / this.f8602d > 0.4f) {
                if (this.f8609k == -1) {
                    this.f8609k = this.f8602d - (this.f8607i * this.f8601c);
                }
                this.f8608j++;
                Bitmap bitmapM8242a = m8242a((int) (this.f8605g * ((this.f8608j * this.f8601c) / this.f8609k)));
                canvas.drawBitmap(bitmapM8242a, 0.0f, 0.0f, this.f8618t);
                bitmapM8242a.recycle();
            }
            this.f8618t.setColor(this.f8620v);
            if (this.f8617s.intValue() != 1) {
                this.f8618t.setAlpha((int) (this.f8603e - (this.f8603e * ((this.f8607i * this.f8601c) / this.f8602d))));
            } else if ((this.f8607i * this.f8601c) / this.f8602d > 0.6f) {
                this.f8618t.setAlpha((int) (this.f8603e - (this.f8603e * ((this.f8608j * this.f8601c) / this.f8609k))));
            } else {
                this.f8618t.setAlpha(this.f8603e);
            }
            this.f8607i++;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8599a = i;
        this.f8600b = i2;
        this.f8614p = new ScaleAnimation(1.0f, this.f8613o, 1.0f, this.f8613o, i / 2, i2 / 2);
        this.f8614p.setDuration(this.f8612n);
        this.f8614p.setRepeatMode(2);
        this.f8614p.setRepeatCount(1);
    }

    /* JADX INFO: renamed from: a */
    public void m8247a(MotionEvent motionEvent) {
        m8243a(motionEvent.getX(), motionEvent.getY());
    }

    /* JADX INFO: renamed from: a */
    private void m8243a(float f, float f2) {
        if (!isEnabled() || this.f8606h) {
            return;
        }
        if (this.f8615q.booleanValue()) {
            startAnimation(this.f8614p);
        }
        this.f8605g = Math.max(this.f8599a, this.f8600b);
        if (this.f8617s.intValue() != 2) {
            this.f8605g /= 2.0f;
        }
        this.f8605g -= this.f8621w;
        if (this.f8616r.booleanValue() || this.f8617s.intValue() == 1) {
            this.f8610l = getMeasuredWidth() / 2;
            this.f8611m = getMeasuredHeight() / 2;
        } else {
            this.f8610l = f;
            this.f8611m = f2;
        }
        this.f8606h = true;
        if (this.f8617s.intValue() == 1 && this.f8619u == null) {
            this.f8619u = getDrawingCache(true);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8622x.onTouchEvent(motionEvent)) {
            m8247a(motionEvent);
            m8246a((Boolean) false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8246a(Boolean bool) {
        if (getParent() instanceof AdapterView) {
            AdapterView<?> adapterView = (AdapterView) getParent();
            int positionForView = adapterView.getPositionForView(this);
            long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
            if (bool.booleanValue()) {
                if (adapterView.getOnItemLongClickListener() != null) {
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition);
                }
            } else if (adapterView.getOnItemClickListener() != null) {
                adapterView.getOnItemClickListener().onItemClick(adapterView, this, positionForView, itemIdAtPosition);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m8242a(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f8619u.getWidth(), this.f8619u.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        float f = i;
        Rect rect = new Rect((int) (this.f8610l - f), (int) (this.f8611m - f), (int) (this.f8610l + f), (int) (this.f8611m + f));
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.f8610l, this.f8611m, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.f8619u, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public void setRippleColor(int i) {
        this.f8620v = getResources().getColor(i);
    }

    public int getRippleColor() {
        return this.f8620v;
    }

    public EnumC1366b getRippleType() {
        return EnumC1366b.values()[this.f8617s.intValue()];
    }

    public void setRippleType(EnumC1366b enumC1366b) {
        this.f8617s = Integer.valueOf(enumC1366b.ordinal());
    }

    public void setCentered(Boolean bool) {
        this.f8616r = bool;
    }

    public int getRipplePadding() {
        return this.f8621w;
    }

    public void setRipplePadding(int i) {
        this.f8621w = i;
    }

    public void setZooming(Boolean bool) {
        this.f8615q = bool;
    }

    public float getZoomScale() {
        return this.f8613o;
    }

    public void setZoomScale(float f) {
        this.f8613o = f;
    }

    public int getZoomDuration() {
        return this.f8612n;
    }

    public void setZoomDuration(int i) {
        this.f8612n = i;
    }

    public int getRippleDuration() {
        return this.f8602d;
    }

    public void setRippleDuration(int i) {
        this.f8602d = i;
    }

    public int getFrameRate() {
        return this.f8601c;
    }

    public void setFrameRate(int i) {
        this.f8601c = i;
    }

    public int getRippleAlpha() {
        return this.f8603e;
    }

    public void setRippleAlpha(int i) {
        this.f8603e = i;
    }

    public void setOnRippleCompleteListener(InterfaceC1365a interfaceC1365a) {
        this.f8624z = interfaceC1365a;
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.RippleView$b */
    public enum EnumC1366b {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);


        /* JADX INFO: renamed from: d */
        int f8631d;

        EnumC1366b(int i) {
            this.f8631d = i;
        }
    }
}
