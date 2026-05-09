package com.coollang.tennis.choosephoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import p000.C1846kc;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends View {

    /* JADX INFO: renamed from: a */
    protected float f7453a;

    /* JADX INFO: renamed from: b */
    protected final float f7454b;

    /* JADX INFO: renamed from: c */
    protected final float f7455c;

    /* JADX INFO: renamed from: d */
    protected Drawable f7456d;

    /* JADX INFO: renamed from: e */
    protected C1846kc f7457e;

    /* JADX INFO: renamed from: f */
    protected Rect f7458f;

    /* JADX INFO: renamed from: g */
    protected Rect f7459g;

    /* JADX INFO: renamed from: h */
    protected Rect f7460h;

    /* JADX INFO: renamed from: i */
    protected boolean f7461i;

    /* JADX INFO: renamed from: j */
    protected Context f7462j;

    /* JADX INFO: renamed from: k */
    private float f7463k;

    /* JADX INFO: renamed from: l */
    private float f7464l;

    /* JADX INFO: renamed from: m */
    private float f7465m;

    /* JADX INFO: renamed from: n */
    private float f7466n;

    /* JADX INFO: renamed from: o */
    private float f7467o;

    /* JADX INFO: renamed from: p */
    private float f7468p;

    /* JADX INFO: renamed from: q */
    private final int f7469q;

    /* JADX INFO: renamed from: r */
    private final int f7470r;

    /* JADX INFO: renamed from: s */
    private final int f7471s;

    /* JADX INFO: renamed from: t */
    private int f7472t;

    /* JADX INFO: renamed from: u */
    private final int f7473u;

    /* JADX INFO: renamed from: v */
    private final int f7474v;

    /* JADX INFO: renamed from: w */
    private int f7475w;

    /* JADX INFO: renamed from: x */
    private int f7476x;

    /* JADX INFO: renamed from: y */
    private Path f7477y;

    public CropImageView(Context context) {
        super(context);
        this.f7463k = 0.0f;
        this.f7464l = 0.0f;
        this.f7465m = 0.0f;
        this.f7466n = 0.0f;
        this.f7467o = 0.0f;
        this.f7468p = 0.0f;
        this.f7469q = 1;
        this.f7470r = 2;
        this.f7471s = 3;
        this.f7472t = 1;
        this.f7473u = 300;
        this.f7474v = 300;
        this.f7475w = 300;
        this.f7476x = 300;
        this.f7453a = 0.0f;
        this.f7454b = 5.0f;
        this.f7455c = 0.333333f;
        this.f7458f = new Rect();
        this.f7459g = new Rect();
        this.f7460h = new Rect();
        this.f7461i = true;
        this.f7477y = new Path();
        m7767a(context);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7463k = 0.0f;
        this.f7464l = 0.0f;
        this.f7465m = 0.0f;
        this.f7466n = 0.0f;
        this.f7467o = 0.0f;
        this.f7468p = 0.0f;
        this.f7469q = 1;
        this.f7470r = 2;
        this.f7471s = 3;
        this.f7472t = 1;
        this.f7473u = 300;
        this.f7474v = 300;
        this.f7475w = 300;
        this.f7476x = 300;
        this.f7453a = 0.0f;
        this.f7454b = 5.0f;
        this.f7455c = 0.333333f;
        this.f7458f = new Rect();
        this.f7459g = new Rect();
        this.f7460h = new Rect();
        this.f7461i = true;
        this.f7477y = new Path();
        m7767a(context);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7463k = 0.0f;
        this.f7464l = 0.0f;
        this.f7465m = 0.0f;
        this.f7466n = 0.0f;
        this.f7467o = 0.0f;
        this.f7468p = 0.0f;
        this.f7469q = 1;
        this.f7470r = 2;
        this.f7471s = 3;
        this.f7472t = 1;
        this.f7473u = 300;
        this.f7474v = 300;
        this.f7475w = 300;
        this.f7476x = 300;
        this.f7453a = 0.0f;
        this.f7454b = 5.0f;
        this.f7455c = 0.333333f;
        this.f7458f = new Rect();
        this.f7459g = new Rect();
        this.f7460h = new Rect();
        this.f7461i = true;
        this.f7477y = new Path();
        m7767a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m7767a(Context context) {
        this.f7462j = context;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f7457e = new C1846kc(context);
    }

    public void setDrawable(Drawable drawable, int i, int i2) {
        this.f7456d = drawable;
        this.f7475w = i;
        this.f7476x = i2;
        this.f7461i = true;
        invalidate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (this.f7472t == 1) {
                this.f7472t = 2;
                this.f7465m = motionEvent.getX(0);
                this.f7466n = motionEvent.getY(0);
                this.f7467o = motionEvent.getX(1);
                this.f7468p = motionEvent.getY(1);
            } else if (this.f7472t == 2) {
                this.f7472t = 3;
            }
        } else {
            if (this.f7472t == 2 || this.f7472t == 3) {
                this.f7465m = 0.0f;
                this.f7466n = 0.0f;
                this.f7467o = 0.0f;
                this.f7468p = 0.0f;
                this.f7463k = motionEvent.getX();
                this.f7464l = motionEvent.getY();
            }
            this.f7472t = 1;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f7463k = motionEvent.getX();
                this.f7464l = motionEvent.getY();
                return true;
            case 1:
                m7770b();
                return true;
            case 2:
                if (this.f7472t == 3) {
                    float x = motionEvent.getX(0);
                    float y = motionEvent.getY(0);
                    float x2 = motionEvent.getX(1);
                    float y2 = motionEvent.getY(1);
                    float fAbs = Math.abs(this.f7467o - this.f7465m);
                    float fAbs2 = Math.abs(this.f7468p - this.f7466n);
                    float fAbs3 = Math.abs(x2 - x);
                    float fAbs4 = Math.abs(y2 - y);
                    float f = Math.abs(fAbs4 - fAbs2) > Math.abs(fAbs3 - fAbs) ? fAbs4 / fAbs2 : fAbs3 / fAbs;
                    int iCenterX = this.f7459g.centerX();
                    int iCenterY = this.f7459g.centerY();
                    int iWidth = (int) (this.f7459g.width() * f);
                    float f2 = iWidth;
                    int i = (int) (f2 / this.f7453a);
                    float fWidth = f2 / this.f7458f.width();
                    if (fWidth >= 5.0f) {
                        iWidth = (int) (this.f7458f.width() * 5.0f);
                        i = (int) (iWidth / this.f7453a);
                    } else if (fWidth <= 0.333333f) {
                        iWidth = (int) (this.f7458f.width() * 0.333333f);
                        i = (int) (iWidth / this.f7453a);
                    }
                    int i2 = iWidth / 2;
                    int i3 = i / 2;
                    this.f7459g.set(iCenterX - i2, iCenterY - i3, iCenterX + i2, iCenterY + i3);
                    invalidate();
                    Log.v("width():" + this.f7458f.width() + "height():" + this.f7458f.height(), "new width():" + this.f7459g.width() + "new height():" + this.f7459g.height());
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(((float) this.f7458f.height()) / ((float) this.f7458f.width()));
                    Log.v(sb.toString(), "mDrawableDst:" + (this.f7459g.height() / this.f7459g.width()));
                    this.f7465m = x;
                    this.f7466n = y;
                    this.f7467o = x2;
                    this.f7468p = y2;
                } else if (this.f7472t == 1) {
                    int x3 = (int) (motionEvent.getX() - this.f7463k);
                    int y3 = (int) (motionEvent.getY() - this.f7464l);
                    this.f7463k = motionEvent.getX();
                    this.f7464l = motionEvent.getY();
                    if (x3 != 0 || y3 != 0) {
                        this.f7459g.offset(x3, y3);
                        invalidate();
                    }
                }
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7456d == null || this.f7456d.getIntrinsicWidth() == 0 || this.f7456d.getIntrinsicHeight() == 0) {
            return;
        }
        m7769a();
        this.f7456d.draw(canvas);
        canvas.save();
        canvas.clipRect(this.f7460h, Region.Op.DIFFERENCE);
        canvas.drawColor(Color.parseColor("#a0000000"));
        canvas.restore();
        this.f7457e.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    protected void m7769a() {
        if (this.f7461i) {
            this.f7453a = this.f7456d.getIntrinsicWidth() / this.f7456d.getIntrinsicHeight();
            int iMin = Math.min(getWidth(), (int) ((this.f7456d.getIntrinsicWidth() * this.f7462j.getResources().getDisplayMetrics().density) + 0.5f));
            int i = (int) (iMin / this.f7453a);
            int width = (getWidth() - iMin) / 2;
            int height = (getHeight() - i) / 2;
            this.f7458f.set(width, height, iMin + width, i + height);
            this.f7459g.set(this.f7458f);
            int iM7768a = m7768a(this.f7462j, this.f7475w);
            int iM7768a2 = m7768a(this.f7462j, this.f7476x);
            if (iM7768a > getWidth()) {
                iM7768a = getWidth();
                iM7768a2 = (this.f7476x * iM7768a) / this.f7475w;
            }
            if (iM7768a2 > getHeight()) {
                iM7768a2 = getHeight();
                iM7768a = (this.f7475w * iM7768a2) / this.f7476x;
            }
            int width2 = (getWidth() - iM7768a) / 2;
            int height2 = (getHeight() - iM7768a2) / 2;
            this.f7460h.set(width2, height2, width2 + iM7768a, height2 + iM7768a2);
            this.f7477y.addCircle(width2 + (iM7768a / 2), height2 + r1, iM7768a2 / 2, Path.Direction.CW);
            this.f7461i = false;
        }
        this.f7456d.setBounds(this.f7459g);
        this.f7457e.setBounds(this.f7460h);
    }

    /* JADX INFO: renamed from: b */
    protected void m7770b() {
        boolean z;
        int width = this.f7459g.left;
        int height = this.f7459g.top;
        if (this.f7459g.left < (-this.f7459g.width())) {
            width = -this.f7459g.width();
            z = true;
        } else {
            z = false;
        }
        if (this.f7459g.top < (-this.f7459g.height())) {
            height = -this.f7459g.height();
            z = true;
        }
        if (this.f7459g.left > getWidth()) {
            width = getWidth();
            z = true;
        }
        if (this.f7459g.top > getHeight()) {
            height = getHeight();
            z = true;
        }
        this.f7459g.offsetTo(width, height);
        if (z) {
            invalidate();
        }
    }

    public Bitmap getCropImage() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        this.f7456d.draw(new Canvas(bitmapCreateBitmap));
        Matrix matrix = new Matrix();
        float fWidth = this.f7458f.width() / this.f7459g.width();
        matrix.postScale(fWidth, fWidth);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, this.f7460h.left, this.f7460h.top, this.f7460h.width(), this.f7460h.height(), matrix, true);
        bitmapCreateBitmap.recycle();
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap2, this.f7475w, this.f7476x, false);
        bitmapCreateBitmap2.recycle();
        return bitmapCreateScaledBitmap;
    }

    /* JADX INFO: renamed from: a */
    public int m7768a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
