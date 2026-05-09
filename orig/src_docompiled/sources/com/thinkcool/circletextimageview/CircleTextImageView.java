package com.thinkcool.circletextimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class CircleTextImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private static final ImageView.ScaleType f9118a = ImageView.ScaleType.CENTER_CROP;

    /* JADX INFO: renamed from: b */
    private static final Bitmap.Config f9119b = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: c */
    private final RectF f9120c;

    /* JADX INFO: renamed from: d */
    private final RectF f9121d;

    /* JADX INFO: renamed from: e */
    private final Matrix f9122e;

    /* JADX INFO: renamed from: f */
    private final Paint f9123f;

    /* JADX INFO: renamed from: g */
    private final Paint f9124g;

    /* JADX INFO: renamed from: h */
    private final Paint f9125h;

    /* JADX INFO: renamed from: i */
    private final Paint f9126i;

    /* JADX INFO: renamed from: j */
    private int f9127j;

    /* JADX INFO: renamed from: k */
    private int f9128k;

    /* JADX INFO: renamed from: l */
    private int f9129l;

    /* JADX INFO: renamed from: m */
    private String f9130m;

    /* JADX INFO: renamed from: n */
    private int f9131n;

    /* JADX INFO: renamed from: o */
    private int f9132o;

    /* JADX INFO: renamed from: p */
    private int f9133p;

    /* JADX INFO: renamed from: q */
    private Bitmap f9134q;

    /* JADX INFO: renamed from: r */
    private BitmapShader f9135r;

    /* JADX INFO: renamed from: s */
    private int f9136s;

    /* JADX INFO: renamed from: t */
    private int f9137t;

    /* JADX INFO: renamed from: u */
    private float f9138u;

    /* JADX INFO: renamed from: v */
    private float f9139v;

    /* JADX INFO: renamed from: w */
    private ColorFilter f9140w;

    /* JADX INFO: renamed from: x */
    private boolean f9141x;

    /* JADX INFO: renamed from: y */
    private boolean f9142y;

    /* JADX INFO: renamed from: z */
    private boolean f9143z;

    public CircleTextImageView(Context context) {
        super(context);
        this.f9120c = new RectF();
        this.f9121d = new RectF();
        this.f9122e = new Matrix();
        this.f9123f = new Paint();
        this.f9124g = new Paint();
        this.f9125h = new Paint();
        this.f9126i = new Paint();
        this.f9127j = -16777216;
        this.f9128k = 0;
        this.f9129l = 0;
        this.f9131n = -16777216;
        this.f9132o = 22;
        this.f9133p = 4;
        m8682a();
    }

    public CircleTextImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9120c = new RectF();
        this.f9121d = new RectF();
        this.f9122e = new Matrix();
        this.f9123f = new Paint();
        this.f9124g = new Paint();
        this.f9125h = new Paint();
        this.f9126i = new Paint();
        this.f9127j = -16777216;
        this.f9128k = 0;
        this.f9129l = 0;
        this.f9131n = -16777216;
        this.f9132o = 22;
        this.f9133p = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleTextImageView, i, 0);
        this.f9128k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleTextImageView_citv_border_width, 0);
        this.f9127j = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleTextImageView_citv_border_color, -16777216);
        this.f9143z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircleTextImageView_citv_border_overlay, false);
        this.f9129l = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleTextImageView_citv_fill_color, 0);
        this.f9130m = typedArrayObtainStyledAttributes.getString(R.styleable.CircleTextImageView_citv_text_text);
        this.f9131n = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleTextImageView_citv_border_color, -16777216);
        this.f9132o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleTextImageView_citv_text_size, 22);
        this.f9133p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleTextImageView_citv_text_padding, 4);
        typedArrayObtainStyledAttributes.recycle();
        m8682a();
    }

    /* JADX INFO: renamed from: a */
    private void m8682a() {
        super.setScaleType(f9118a);
        this.f9141x = true;
        if (this.f9142y) {
            m8683b();
            this.f9142y = false;
        }
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f9118a;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f9118a) {
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
        if (this.f9134q == null && TextUtils.isEmpty(this.f9130m)) {
            return;
        }
        if (this.f9129l != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f9138u, this.f9125h);
        }
        if (this.f9134q != null) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f9138u, this.f9123f);
        }
        if (this.f9128k != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f9139v, this.f9124g);
        }
        if (TextUtils.isEmpty(this.f9130m)) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = this.f9126i.getFontMetricsInt();
        canvas.drawText(this.f9130m, (getWidth() / 2) - (this.f9126i.measureText(this.f9130m) / 2.0f), ((getHeight() / 2) - fontMetricsInt.descent) + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2), this.f9126i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m8683b();
    }

    public String getTextString() {
        return this.f9130m;
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setText(String str) {
        this.f9130m = str;
        invalidate();
    }

    public int getTextColor() {
        return this.f9131n;
    }

    public void setTextColor(int i) {
        this.f9131n = i;
        this.f9126i.setColor(i);
        invalidate();
    }

    public void setTextColorResource(int i) {
        setTextColor(getResources().getColor(i));
    }

    public int getTextSize() {
        return this.f9132o;
    }

    public void setTextSize(int i) {
        this.f9132o = i;
        this.f9126i.setTextSize(i);
        invalidate();
    }

    public int getTextPadding() {
        return this.f9133p;
    }

    public void setTextPadding(int i) {
        this.f9133p = i;
        invalidate();
    }

    public int getBorderColor() {
        return this.f9127j;
    }

    public void setBorderColor(int i) {
        if (i == this.f9127j) {
            return;
        }
        this.f9127j = i;
        this.f9124g.setColor(this.f9127j);
        invalidate();
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getFillColor() {
        return this.f9129l;
    }

    public void setFillColor(int i) {
        if (i == this.f9129l) {
            return;
        }
        this.f9129l = i;
        this.f9125h.setColor(i);
        invalidate();
    }

    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f9128k;
    }

    public void setBorderWidth(int i) {
        if (i == this.f9128k) {
            return;
        }
        this.f9128k = i;
        m8683b();
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.f9143z) {
            return;
        }
        this.f9143z = z;
        m8683b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f9134q = bitmap;
        m8683b();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f9134q = m8681a(drawable);
        m8683b();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f9134q = m8681a(getDrawable());
        m8683b();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f9134q = uri != null ? m8681a(getDrawable()) : null;
        m8683b();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.f9140w) {
            return;
        }
        this.f9140w = colorFilter;
        this.f9123f.setColorFilter(this.f9140w);
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m8681a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmapCreateBitmap = Bitmap.createBitmap(2, 2, f9119b);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f9119b);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8683b() {
        if (!this.f9141x) {
            this.f9142y = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f9134q == null && TextUtils.isEmpty(this.f9130m)) {
            invalidate();
            return;
        }
        this.f9126i.setAntiAlias(true);
        this.f9126i.setColor(this.f9131n);
        this.f9126i.setTextSize(this.f9132o);
        this.f9124g.setStyle(Paint.Style.STROKE);
        this.f9124g.setAntiAlias(true);
        this.f9124g.setColor(this.f9127j);
        this.f9124g.setStrokeWidth(this.f9128k);
        this.f9125h.setStyle(Paint.Style.FILL);
        this.f9125h.setAntiAlias(true);
        this.f9125h.setColor(this.f9129l);
        this.f9121d.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f9139v = Math.min((this.f9121d.height() - this.f9128k) / 2.0f, (this.f9121d.width() - this.f9128k) / 2.0f);
        this.f9120c.set(this.f9121d);
        if (!this.f9143z) {
            this.f9120c.inset(this.f9128k, this.f9128k);
        }
        this.f9138u = Math.min(this.f9120c.height() / 2.0f, this.f9120c.width() / 2.0f);
        if (this.f9134q != null) {
            this.f9135r = new BitmapShader(this.f9134q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f9137t = this.f9134q.getHeight();
            this.f9136s = this.f9134q.getWidth();
            this.f9123f.setAntiAlias(true);
            this.f9123f.setShader(this.f9135r);
            m8684c();
        }
        invalidate();
    }

    /* JADX INFO: renamed from: c */
    private void m8684c() {
        float fWidth;
        float fHeight;
        this.f9122e.set(null);
        float fWidth2 = 0.0f;
        if (this.f9136s * this.f9120c.height() > this.f9120c.width() * this.f9137t) {
            fWidth = this.f9120c.height() / this.f9137t;
            fWidth2 = (this.f9120c.width() - (this.f9136s * fWidth)) * 0.5f;
            fHeight = 0.0f;
        } else {
            fWidth = this.f9120c.width() / this.f9136s;
            fHeight = (this.f9120c.height() - (this.f9137t * fWidth)) * 0.5f;
        }
        this.f9122e.setScale(fWidth, fWidth);
        this.f9122e.postTranslate(((int) (fWidth2 + 0.5f)) + this.f9120c.left, ((int) (fHeight + 0.5f)) + this.f9120c.top);
        this.f9135r.setLocalMatrix(this.f9122e);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i2);
        if (TextUtils.isEmpty(this.f9130m)) {
            return;
        }
        int iMeasureText = ((int) this.f9126i.measureText(this.f9130m)) + (this.f9133p * 2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            if (iMeasureText > getMeasuredWidth() || iMeasureText > getMeasuredHeight()) {
                setMeasuredDimension(iMeasureText, iMeasureText);
            }
        }
    }
}
