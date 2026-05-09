package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import p000.C0751at;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a */
    protected boolean f2219a;

    /* JADX INFO: renamed from: b */
    boolean f2220b;

    /* JADX INFO: renamed from: c */
    private Drawable f2221c;

    /* JADX INFO: renamed from: d */
    private final Rect f2222d;

    /* JADX INFO: renamed from: e */
    private final Rect f2223e;

    /* JADX INFO: renamed from: f */
    private int f2224f;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2222d = new Rect();
        this.f2223e = new Rect();
        this.f2224f = 119;
        this.f2219a = true;
        this.f2220b = false;
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.f2224f = typedArrayM5390a.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f2224f);
        Drawable drawable = typedArrayM5390a.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f2219a = typedArrayM5390a.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayM5390a.recycle();
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f2224f;
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f2224f != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f2224f = i;
            if (this.f2224f == 119 && this.f2221c != null) {
                this.f2221c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2221c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f2221c != null) {
            this.f2221c.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2221c == null || !this.f2221c.isStateful()) {
            return;
        }
        this.f2221c.setState(getDrawableState());
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        if (this.f2221c != drawable) {
            if (this.f2221c != null) {
                this.f2221c.setCallback(null);
                unscheduleDrawable(this.f2221c);
            }
            this.f2221c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f2224f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f2221c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2220b = z | this.f2220b;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2220b = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2221c != null) {
            Drawable drawable = this.f2221c;
            if (this.f2220b) {
                this.f2220b = false;
                Rect rect = this.f2222d;
                Rect rect2 = this.f2223e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f2219a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f2224f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f2221c != null) {
            this.f2221c.setHotspot(f, f2);
        }
    }
}
