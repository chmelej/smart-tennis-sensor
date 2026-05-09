package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p000.C1733fy;
import p000.C1734fz;
import p000.C1736ga;
import p000.InterfaceC1737gb;
import p000.InterfaceC1738gc;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: e */
    private static final int[] f3499e = {R.attr.colorBackground};

    /* JADX INFO: renamed from: f */
    private static final InterfaceC1738gc f3500f;

    /* JADX INFO: renamed from: a */
    int f3501a;

    /* JADX INFO: renamed from: b */
    int f3502b;

    /* JADX INFO: renamed from: c */
    final Rect f3503c;

    /* JADX INFO: renamed from: d */
    final Rect f3504d;

    /* JADX INFO: renamed from: g */
    private boolean f3505g;

    /* JADX INFO: renamed from: h */
    private boolean f3506h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC1737gb f3507i;

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f3500f = new C1734fz();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f3500f = new C1733fy();
        } else {
            f3500f = new C1736ga();
        }
        f3500f.mo9333a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.cardview.R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        this.f3503c = new Rect();
        this.f3504d = new Rect();
        this.f3507i = new InterfaceC1737gb() { // from class: android.support.v7.widget.CardView.1

            /* JADX INFO: renamed from: b */
            private Drawable f3509b;

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: a */
            public void mo3519a(Drawable drawable) {
                this.f3509b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: a */
            public boolean mo3520a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: b */
            public boolean mo3521b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: a */
            public void mo3518a(int i2, int i3, int i4, int i5) {
                CardView.this.f3504d.set(i2, i3, i4, i5);
                CardView.super.setPadding(i2 + CardView.this.f3503c.left, i3 + CardView.this.f3503c.top, i4 + CardView.this.f3503c.right, i5 + CardView.this.f3503c.bottom);
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: a */
            public void mo3517a(int i2, int i3) {
                if (i2 > CardView.this.f3501a) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.f3502b) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: c */
            public Drawable mo3522c() {
                return this.f3509b;
            }

            @Override // p000.InterfaceC1737gb
            /* JADX INFO: renamed from: d */
            public View mo3523d() {
                return CardView.this;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.cardview.R.styleable.CardView, i, android.support.v7.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f3499e);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f3505g = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f3506h = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPadding, 0);
        this.f3503c.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f3503c.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f3503c.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f3503c.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f3501a = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f3502b = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f3500f.mo9338a(this.f3507i, context, colorStateList, dimension, dimension2, f);
    }

    public boolean getUseCompatPadding() {
        return this.f3505g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f3505g != z) {
            this.f3505g = z;
            f3500f.mo9347g(this.f3507i);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f3503c.set(i, i2, i3, i4);
        f3500f.mo9346f(this.f3507i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f3500f instanceof C1734fz)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f3500f.mo9340b(this.f3507i)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f3500f.mo9342c(this.f3507i)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f3501a = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f3502b = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f3500f.mo9339a(this.f3507i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f3500f.mo9339a(this.f3507i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f3500f.mo9349i(this.f3507i);
    }

    public int getContentPaddingLeft() {
        return this.f3503c.left;
    }

    public int getContentPaddingRight() {
        return this.f3503c.right;
    }

    public int getContentPaddingTop() {
        return this.f3503c.top;
    }

    public int getContentPaddingBottom() {
        return this.f3503c.bottom;
    }

    public void setRadius(float f) {
        f3500f.mo9337a(this.f3507i, f);
    }

    public float getRadius() {
        return f3500f.mo9344d(this.f3507i);
    }

    public void setCardElevation(float f) {
        f3500f.mo9343c(this.f3507i, f);
    }

    public float getCardElevation() {
        return f3500f.mo9345e(this.f3507i);
    }

    public void setMaxCardElevation(float f) {
        f3500f.mo9341b(this.f3507i, f);
    }

    public float getMaxCardElevation() {
        return f3500f.mo9336a(this.f3507i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f3506h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f3506h) {
            this.f3506h = z;
            f3500f.mo9348h(this.f3507i);
        }
    }
}
