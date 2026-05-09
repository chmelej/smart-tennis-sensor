package com.coollang.tennis.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private static final ImageView.ScaleType f8025a = ImageView.ScaleType.CENTER_CROP;

    /* JADX INFO: renamed from: b */
    private static final Bitmap.Config f8026b = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: c */
    private final RectF f8027c;

    /* JADX INFO: renamed from: d */
    private final RectF f8028d;

    /* JADX INFO: renamed from: e */
    private final Matrix f8029e;

    /* JADX INFO: renamed from: f */
    private final Paint f8030f;

    /* JADX INFO: renamed from: g */
    private final Paint f8031g;

    /* JADX INFO: renamed from: h */
    private int f8032h;

    /* JADX INFO: renamed from: i */
    private int f8033i;

    /* JADX INFO: renamed from: j */
    private Bitmap f8034j;

    /* JADX INFO: renamed from: k */
    private BitmapShader f8035k;

    /* JADX INFO: renamed from: l */
    private int f8036l;

    /* JADX INFO: renamed from: m */
    private int f8037m;

    /* JADX INFO: renamed from: n */
    private float f8038n;

    /* JADX INFO: renamed from: o */
    private float f8039o;

    /* JADX INFO: renamed from: p */
    private ColorFilter f8040p;

    /* JADX INFO: renamed from: q */
    private boolean f8041q;

    /* JADX INFO: renamed from: r */
    private boolean f8042r;

    public CircleImageView(Context context) {
        super(context);
        this.f8027c = new RectF();
        this.f8028d = new RectF();
        this.f8029e = new Matrix();
        this.f8030f = new Paint();
        this.f8031g = new Paint();
        this.f8032h = -1;
        this.f8033i = 0;
        m8036a(context, null, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8027c = new RectF();
        this.f8028d = new RectF();
        this.f8029e = new Matrix();
        this.f8030f = new Paint();
        this.f8031g = new Paint();
        this.f8032h = -1;
        this.f8033i = 0;
        this.f8033i = 0;
        this.f8032h = -1;
        m8036a(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m8036a(Context context, AttributeSet attributeSet, int i) {
        super.setScaleType(f8025a);
        this.f8041q = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.circleImage, i, 0);
        this.f8033i = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f8032h = typedArrayObtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        typedArrayObtainStyledAttributes.recycle();
        if (this.f8042r) {
            m8035a();
            this.f8042r = false;
        }
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f8025a;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f8025a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f8038n, this.f8030f);
        if (this.f8033i != 0) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f8039o, this.f8031g);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m8035a();
    }

    public int getBorderColor() {
        return this.f8032h;
    }

    public void setBorderColor(int i) {
        if (i == this.f8032h) {
            return;
        }
        this.f8032h = i;
        this.f8031g.setColor(this.f8032h);
        invalidate();
    }

    public int getBorderWidth() {
        return this.f8033i;
    }

    public void setBorderWidth(int i) {
        if (i == this.f8033i) {
            return;
        }
        this.f8033i = i;
        m8035a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f8034j = bitmap;
        m8035a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f8034j = m8034a(drawable);
        m8035a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f8034j = m8034a(getDrawable());
        m8035a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f8034j = m8034a(getDrawable());
        m8035a();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.f8040p) {
            return;
        }
        this.f8040p = colorFilter;
        this.f8030f.setColorFilter(this.f8040p);
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m8034a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmapCreateBitmap = Bitmap.createBitmap(2, 2, f8026b);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f8026b);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8035a() {
        if (!this.f8041q) {
            this.f8042r = true;
            return;
        }
        if (this.f8034j == null) {
            return;
        }
        this.f8035k = new BitmapShader(this.f8034j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f8030f.setAntiAlias(true);
        this.f8030f.setShader(this.f8035k);
        this.f8031g.setStyle(Paint.Style.STROKE);
        this.f8031g.setAntiAlias(true);
        this.f8031g.setColor(this.f8032h);
        this.f8031g.setStrokeWidth(this.f8033i);
        this.f8037m = this.f8034j.getHeight();
        this.f8036l = this.f8034j.getWidth();
        this.f8028d.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f8039o = Math.min((this.f8028d.height() - this.f8033i) / 2.0f, (this.f8028d.width() - this.f8033i) / 2.0f);
        this.f8027c.set(this.f8033i, this.f8033i, this.f8028d.width() - this.f8033i, this.f8028d.height() - this.f8033i);
        this.f8038n = Math.min(this.f8027c.height() / 2.0f, this.f8027c.width() / 2.0f);
        m8037b();
        invalidate();
    }

    /* JADX INFO: renamed from: b */
    private void m8037b() {
        float fWidth;
        float fHeight;
        this.f8029e.set(null);
        float fWidth2 = 0.0f;
        if (this.f8036l * this.f8027c.height() > this.f8027c.width() * this.f8037m) {
            fWidth = this.f8027c.height() / this.f8037m;
            fWidth2 = (this.f8027c.width() - (this.f8036l * fWidth)) * 0.5f;
            fHeight = 0.0f;
        } else {
            fWidth = this.f8027c.width() / this.f8036l;
            fHeight = (this.f8027c.height() - (this.f8037m * fWidth)) * 0.5f;
        }
        this.f8029e.setScale(fWidth, fWidth);
        this.f8029e.postTranslate(((int) (fWidth2 + 0.5f)) + this.f8033i, ((int) (fHeight + 0.5f)) + this.f8033i);
        this.f8035k.setLocalMatrix(this.f8029e);
    }
}
