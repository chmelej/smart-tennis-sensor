package android.support.design.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import p000.C0109ah;
import p000.C0751at;
import p000.C0752au;
import p000.C0753av;
import p000.C1684ee;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton {

    /* JADX INFO: renamed from: a */
    private final C0109ah f2065a;

    /* JADX INFO: renamed from: b */
    private int f2066b;

    /* JADX INFO: renamed from: c */
    private PorterDuff.Mode f2067c;

    /* JADX INFO: renamed from: d */
    private ColorStateList f2068d;

    /* JADX INFO: renamed from: e */
    private Drawable f2069e;

    /* JADX INFO: renamed from: f */
    private int f2070f;

    /* JADX INFO: renamed from: g */
    private int f2071g;

    /* JADX INFO: renamed from: h */
    private int f2072h;

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.MaterialButton, i, R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f2066b = typedArrayM5390a.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
        this.f2067c = C0752au.m5475a(typedArrayM5390a.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f2068d = C0753av.m5478a(getContext(), typedArrayM5390a, R.styleable.MaterialButton_iconTint);
        this.f2069e = C0753av.m5479b(getContext(), typedArrayM5390a, R.styleable.MaterialButton_icon);
        this.f2072h = typedArrayM5390a.getInteger(R.styleable.MaterialButton_iconGravity, 1);
        this.f2070f = typedArrayM5390a.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
        this.f2065a = new C0109ah(this);
        this.f2065a.m1025a(typedArrayM5390a);
        typedArrayM5390a.recycle();
        setCompoundDrawablePadding(this.f2066b);
        m2254b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !m2255c()) {
            return;
        }
        this.f2065a.m1026a(canvas);
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m2255c()) {
            this.f2065a.m1024a(colorStateList);
        } else if (this.f2065a != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (m2255c()) {
            return this.f2065a.m1031c();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m2255c()) {
            this.f2065a.m1027a(mode);
        } else if (this.f2065a != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v7.widget.AppCompatButton, android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (m2255c()) {
            return this.f2065a.m1034d();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (m2255c()) {
            this.f2065a.m1022a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? C1684ee.m8975b(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (m2255c()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f2065a.m1021a();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || this.f2065a == null) {
            return;
        }
        this.f2065a.m1023a(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2069e == null || this.f2072h != 2) {
            return;
        }
        int measuredWidth = (((((getMeasuredWidth() - ((int) getPaint().measureText(getText().toString()))) - ViewCompat.getPaddingEnd(this)) - (this.f2070f == 0 ? this.f2069e.getIntrinsicWidth() : this.f2070f)) - this.f2066b) - ViewCompat.getPaddingStart(this)) / 2;
        if (m2253a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f2071g != measuredWidth) {
            this.f2071g = measuredWidth;
            m2254b();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2253a() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i) {
        if (this.f2066b != i) {
            this.f2066b = i;
            setCompoundDrawablePadding(i);
        }
    }

    public int getIconPadding() {
        return this.f2066b;
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2070f != i) {
            this.f2070f = i;
            m2254b();
        }
    }

    public int getIconSize() {
        return this.f2070f;
    }

    public void setIcon(Drawable drawable) {
        if (this.f2069e != drawable) {
            this.f2069e = drawable;
            m2254b();
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? C1684ee.m8975b(getContext(), i) : null);
    }

    public Drawable getIcon() {
        return this.f2069e;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f2068d != colorStateList) {
            this.f2068d = colorStateList;
            m2254b();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(C1684ee.m8972a(getContext(), i));
    }

    public ColorStateList getIconTint() {
        return this.f2068d;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2067c != mode) {
            this.f2067c = mode;
            m2254b();
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2067c;
    }

    /* JADX INFO: renamed from: b */
    private void m2254b() {
        if (this.f2069e != null) {
            this.f2069e = this.f2069e.mutate();
            DrawableCompat.setTintList(this.f2069e, this.f2068d);
            if (this.f2067c != null) {
                DrawableCompat.setTintMode(this.f2069e, this.f2067c);
            }
            this.f2069e.setBounds(this.f2071g, 0, this.f2071g + (this.f2070f != 0 ? this.f2070f : this.f2069e.getIntrinsicWidth()), this.f2070f != 0 ? this.f2070f : this.f2069e.getIntrinsicHeight());
        }
        TextViewCompat.setCompoundDrawablesRelative(this, this.f2069e, null, null, null);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m2255c()) {
            this.f2065a.m1029b(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (m2255c()) {
            setRippleColor(C1684ee.m8972a(getContext(), i));
        }
    }

    public ColorStateList getRippleColor() {
        if (m2255c()) {
            return this.f2065a.m1035e();
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m2255c()) {
            this.f2065a.m1033c(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (m2255c()) {
            setStrokeColor(C1684ee.m8972a(getContext(), i));
        }
    }

    public ColorStateList getStrokeColor() {
        if (m2255c()) {
            return this.f2065a.m1036f();
        }
        return null;
    }

    public void setStrokeWidth(int i) {
        if (m2255c()) {
            this.f2065a.m1028b(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (m2255c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public int getStrokeWidth() {
        if (m2255c()) {
            return this.f2065a.m1037g();
        }
        return 0;
    }

    public void setCornerRadius(int i) {
        if (m2255c()) {
            this.f2065a.m1032c(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (m2255c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public int getCornerRadius() {
        if (m2255c()) {
            return this.f2065a.m1038h();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.f2072h;
    }

    public void setIconGravity(int i) {
        this.f2072h = i;
    }

    /* JADX INFO: renamed from: c */
    private boolean m2255c() {
        return (this.f2065a == null || this.f2065a.m1030b()) ? false : true;
    }
}
