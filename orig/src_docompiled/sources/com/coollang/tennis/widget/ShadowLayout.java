package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private int f8657a;

    /* JADX INFO: renamed from: b */
    private float f8658b;

    /* JADX INFO: renamed from: c */
    private float f8659c;

    /* JADX INFO: renamed from: d */
    private float f8660d;

    /* JADX INFO: renamed from: e */
    private float f8661e;

    /* JADX INFO: renamed from: f */
    private boolean f8662f;

    /* JADX INFO: renamed from: g */
    private boolean f8663g;

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return 0;
    }

    public ShadowLayout(Context context) {
        super(context);
        this.f8662f = true;
        this.f8663g = false;
        m8255a(context, (AttributeSet) null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8662f = true;
        this.f8663g = false;
        m8255a(context, attributeSet);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8662f = true;
        this.f8663g = false;
        m8255a(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (getBackground() == null || this.f8662f || this.f8663g) {
            this.f8663g = false;
            m8254a(i, i2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8663g) {
            this.f8663g = false;
            m8254a(i3 - i, i4 - i2);
        }
    }

    public void setInvalidateShadowOnSizeChanged(boolean z) {
        this.f8662f = z;
    }

    /* JADX INFO: renamed from: a */
    private void m8255a(Context context, AttributeSet attributeSet) {
        m8256b(context, attributeSet);
        int iAbs = (int) (this.f8658b + Math.abs(this.f8660d));
        int iAbs2 = (int) (this.f8658b + Math.abs(this.f8661e));
        setPadding(iAbs, iAbs2, iAbs, iAbs2);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    private void m8254a(int i, int i2) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), m8253a(i, i2, this.f8659c, this.f8658b, this.f8660d, this.f8661e, this.f8657a, 0));
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(bitmapDrawable);
        } else {
            setBackground(bitmapDrawable);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8256b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayM8252a = m8252a(context, attributeSet, R.styleable.ShadowLayout);
        if (typedArrayM8252a == null) {
            return;
        }
        try {
            this.f8659c = typedArrayM8252a.getDimension(0, getResources().getDimension(R.dimen.default_corner_radius));
            this.f8658b = typedArrayM8252a.getDimension(4, getResources().getDimension(R.dimen.default_shadow_radius));
            this.f8660d = typedArrayM8252a.getDimension(1, 0.0f);
            this.f8661e = typedArrayM8252a.getDimension(2, 0.0f);
            this.f8657a = typedArrayM8252a.getColor(3, getResources().getColor(R.color.default_shadow_color));
        } finally {
            typedArrayM8252a.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    private TypedArray m8252a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m8253a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(f2, f2, i - f2, i2 - f2);
        if (f4 > 0.0f) {
            rectF.top += f4;
            rectF.bottom -= f4;
        } else if (f4 < 0.0f) {
            rectF.top += Math.abs(f4);
            rectF.bottom -= Math.abs(f4);
        }
        if (f3 > 0.0f) {
            rectF.left += f3;
            rectF.right -= f3;
        } else if (f3 < 0.0f) {
            rectF.left += Math.abs(f3);
            rectF.right -= Math.abs(f3);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(f2, f3, f4, i3);
        }
        canvas.drawRoundRect(rectF, f, f, paint);
        return bitmapCreateBitmap;
    }
}
