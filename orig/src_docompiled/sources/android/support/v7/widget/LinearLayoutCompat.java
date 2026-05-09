package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import p000.C1766hd;
import p000.C1774hl;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* JADX INFO: renamed from: a */
    private boolean f3532a;

    /* JADX INFO: renamed from: b */
    private int f3533b;

    /* JADX INFO: renamed from: c */
    private int f3534c;

    /* JADX INFO: renamed from: d */
    private int f3535d;

    /* JADX INFO: renamed from: e */
    private int f3536e;

    /* JADX INFO: renamed from: f */
    private int f3537f;

    /* JADX INFO: renamed from: g */
    private float f3538g;

    /* JADX INFO: renamed from: h */
    private boolean f3539h;

    /* JADX INFO: renamed from: i */
    private int[] f3540i;

    /* JADX INFO: renamed from: j */
    private int[] f3541j;

    /* JADX INFO: renamed from: k */
    private Drawable f3542k;

    /* JADX INFO: renamed from: l */
    private int f3543l;

    /* JADX INFO: renamed from: m */
    private int f3544m;

    /* JADX INFO: renamed from: n */
    private int f3545n;

    /* JADX INFO: renamed from: o */
    private int f3546o;

    /* JADX INFO: renamed from: a */
    int m3576a(View view) {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    int m3577a(View view, int i) {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    int m3583b(View view) {
        return 0;
    }

    /* JADX INFO: renamed from: d */
    int m3590d(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3532a = true;
        this.f3533b = -1;
        this.f3534c = 0;
        this.f3536e = 8388659;
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int iM9603a = c1766hdM9601a.m9603a(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (iM9603a >= 0) {
            setOrientation(iM9603a);
        }
        int iM9603a2 = c1766hdM9601a.m9603a(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (iM9603a2 >= 0) {
            setGravity(iM9603a2);
        }
        boolean zM9607a = c1766hdM9601a.m9607a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zM9607a) {
            setBaselineAligned(zM9607a);
        }
        this.f3538g = c1766hdM9601a.m9602a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f3533b = c1766hdM9601a.m9603a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f3539h = c1766hdM9601a.m9607a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(c1766hdM9601a.m9605a(R.styleable.LinearLayoutCompat_divider));
        this.f3545n = c1766hdM9601a.m9603a(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f3546o = c1766hdM9601a.m9615e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        c1766hdM9601a.m9606a();
    }

    public void setShowDividers(int i) {
        if (i != this.f3545n) {
            requestLayout();
        }
        this.f3545n = i;
    }

    public int getShowDividers() {
        return this.f3545n;
    }

    public Drawable getDividerDrawable() {
        return this.f3542k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f3542k) {
            return;
        }
        this.f3542k = drawable;
        if (drawable != null) {
            this.f3543l = drawable.getIntrinsicWidth();
            this.f3544m = drawable.getIntrinsicHeight();
        } else {
            this.f3543l = 0;
            this.f3544m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f3546o = i;
    }

    public int getDividerPadding() {
        return this.f3546o;
    }

    public int getDividerWidth() {
        return this.f3543l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f3542k == null) {
            return;
        }
        if (this.f3535d == 1) {
            m3580a(canvas);
        } else {
            m3587b(canvas);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3580a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM3584b = m3584b(i);
            if (viewM3584b != null && viewM3584b.getVisibility() != 8 && m3589c(i)) {
                m3581a(canvas, (viewM3584b.getTop() - ((LayoutParams) viewM3584b.getLayoutParams()).topMargin) - this.f3544m);
            }
        }
        if (m3589c(virtualChildCount)) {
            View viewM3584b2 = m3584b(virtualChildCount - 1);
            if (viewM3584b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f3544m;
            } else {
                bottom = viewM3584b2.getBottom() + ((LayoutParams) viewM3584b2.getLayoutParams()).bottomMargin;
            }
            m3581a(canvas, bottom);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3587b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean zM9679a = C1774hl.m9679a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM3584b = m3584b(i);
            if (viewM3584b != null && viewM3584b.getVisibility() != 8 && m3589c(i)) {
                LayoutParams layoutParams = (LayoutParams) viewM3584b.getLayoutParams();
                if (zM9679a) {
                    left = viewM3584b.getRight() + layoutParams.rightMargin;
                } else {
                    left = (viewM3584b.getLeft() - layoutParams.leftMargin) - this.f3543l;
                }
                m3588b(canvas, left);
            }
        }
        if (m3589c(virtualChildCount)) {
            View viewM3584b2 = m3584b(virtualChildCount - 1);
            if (viewM3584b2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) viewM3584b2.getLayoutParams();
                if (zM9679a) {
                    right = (viewM3584b2.getLeft() - layoutParams2.leftMargin) - this.f3543l;
                } else {
                    right = viewM3584b2.getRight() + layoutParams2.rightMargin;
                }
            } else if (zM9679a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f3543l;
            }
            m3588b(canvas, right);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3581a(Canvas canvas, int i) {
        this.f3542k.setBounds(getPaddingLeft() + this.f3546o, i, (getWidth() - getPaddingRight()) - this.f3546o, this.f3544m + i);
        this.f3542k.draw(canvas);
    }

    /* JADX INFO: renamed from: b */
    void m3588b(Canvas canvas, int i) {
        this.f3542k.setBounds(i, getPaddingTop() + this.f3546o, this.f3543l + i, (getHeight() - getPaddingBottom()) - this.f3546o);
        this.f3542k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f3532a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f3539h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f3533b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f3533b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f3533b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f3533b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f3534c;
        if (this.f3535d == 1 && (i = this.f3536e & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f3537f) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f3537f;
            }
        }
        return bottom + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3533b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f3533b = i;
    }

    /* JADX INFO: renamed from: b */
    View m3584b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f3538g;
    }

    public void setWeightSum(float f) {
        this.f3538g = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f3535d == 1) {
            m3578a(i, i2);
        } else {
            m3585b(i, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    protected boolean m3589c(int i) {
        if (i == 0) {
            return (this.f3545n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f3545n & 4) != 0;
        }
        if ((this.f3545n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x033e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m3578a(int r41, int r42) {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.m3578a(int, int):void");
    }

    /* JADX INFO: renamed from: c */
    private void m3574c(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM3584b = m3584b(i3);
            if (viewM3584b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM3584b.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = viewM3584b.getMeasuredHeight();
                    measureChildWithMargins(viewM3584b, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d4  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m3585b(int r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.m3585b(int, int):void");
    }

    /* JADX INFO: renamed from: d */
    private void m3575d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM3584b = m3584b(i3);
            if (viewM3584b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM3584b.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = viewM3584b.getMeasuredWidth();
                    measureChildWithMargins(viewM3584b, i2, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3582a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3535d == 1) {
            m3579a(i, i2, i3, i4);
        } else {
            m3586b(i, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3579a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i7 = this.f3536e & 112;
        int i8 = this.f3536e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i7 == 16) {
            paddingTop = (((i4 - i2) - this.f3537f) / 2) + getPaddingTop();
        } else if (i7 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.f3537f;
        } else {
            paddingTop = getPaddingTop();
        }
        int iM3577a = 0;
        while (iM3577a < virtualChildCount) {
            View viewM3584b = m3584b(iM3577a);
            if (viewM3584b == null) {
                paddingTop += m3590d(iM3577a);
            } else if (viewM3584b.getVisibility() != 8) {
                int measuredWidth = viewM3584b.getMeasuredWidth();
                int measuredHeight = viewM3584b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) viewM3584b.getLayoutParams();
                int i9 = layoutParams.f3548h;
                if (i9 < 0) {
                    i9 = i8;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i9, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (absoluteGravity == 5) {
                    i5 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                } else {
                    i5 = layoutParams.leftMargin + paddingLeft;
                }
                int i10 = i5;
                if (m3589c(iM3577a)) {
                    paddingTop += this.f3544m;
                }
                int i11 = paddingTop + layoutParams.topMargin;
                m3573a(viewM3584b, i10, i11 + m3576a(viewM3584b), measuredWidth, measuredHeight);
                int iM3583b = i11 + measuredHeight + layoutParams.bottomMargin + m3583b(viewM3584b);
                iM3577a += m3577a(viewM3584b, iM3577a);
                paddingTop = iM3583b;
            }
            iM3577a++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m3586b(int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.m3586b(int, int, int, int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m3573a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.f3535d != i) {
            this.f3535d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f3535d;
    }

    public void setGravity(int i) {
        if (this.f3536e != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f3536e = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f3536e;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((8388615 & this.f3536e) != i2) {
            this.f3536e = i2 | (this.f3536e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f3536e & 112) != i2) {
            this.f3536e = i2 | (this.f3536e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.f3535d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.f3535d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: g */
        public float f3547g;

        /* JADX INFO: renamed from: h */
        public int f3548h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3548h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.f3547g = typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f3548h = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3548h = -1;
            this.f3547g = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3548h = -1;
        }
    }
}
