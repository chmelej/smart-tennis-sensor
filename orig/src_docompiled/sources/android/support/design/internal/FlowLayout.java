package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a */
    private int f2216a;

    /* JADX INFO: renamed from: b */
    private int f2217b;

    /* JADX INFO: renamed from: c */
    private boolean f2218c;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2218c = false;
        m2452a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m2452a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f2216a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f2217b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected int getLineSpacing() {
        return this.f2216a;
    }

    protected void setLineSpacing(int i) {
        this.f2216a = i;
    }

    protected int getItemSpacing() {
        return this.f2217b;
    }

    protected void setItemSpacing(int i) {
        this.f2217b = i;
    }

    /* JADX INFO: renamed from: b */
    protected boolean m2453b() {
        return this.f2218c;
    }

    public void setSingleLine(boolean z) {
        this.f2218c = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i5 - getPaddingRight();
        int measuredWidth = paddingLeft;
        int i6 = paddingTop;
        int i7 = i6;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i3 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int i10 = measuredWidth;
                if (measuredWidth + i3 + childAt.getMeasuredWidth() > paddingRight && !m2453b()) {
                    int paddingLeft2 = getPaddingLeft();
                    i7 = this.f2216a + i6;
                    i10 = paddingLeft2;
                }
                int measuredWidth2 = i10 + i3 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (measuredWidth2 > i8) {
                    i8 = measuredWidth2;
                }
                i6 = measuredHeight;
                measuredWidth = i10 + i3 + i4 + childAt.getMeasuredWidth() + this.f2217b;
            }
        }
        setMeasuredDimension(m2451a(size, mode, i8), m2451a(size2, mode2, i6));
    }

    /* JADX INFO: renamed from: a */
    private static int m2451a(int i, int i2, int i3) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 1073741824 ? i3 : i;
        }
        return Math.min(i3, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int marginEnd;
        int marginStart;
        if (getChildCount() == 0) {
            return;
        }
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i5 = (i3 - i) - paddingLeft;
        int measuredWidth = paddingRight;
        int i6 = paddingTop;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    marginEnd = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    marginEnd = 0;
                    marginStart = 0;
                }
                int measuredWidth2 = measuredWidth + marginStart + childAt.getMeasuredWidth();
                if (!this.f2218c && measuredWidth2 > i5) {
                    i6 = paddingTop + this.f2216a;
                    measuredWidth = paddingRight;
                }
                int i8 = measuredWidth + marginStart;
                int measuredWidth3 = childAt.getMeasuredWidth() + i8;
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                if (z2) {
                    childAt.layout(i5 - measuredWidth3, i6, (i5 - measuredWidth) - marginStart, measuredHeight);
                } else {
                    childAt.layout(i8, i6, measuredWidth3, measuredHeight);
                }
                measuredWidth += marginStart + marginEnd + childAt.getMeasuredWidth() + this.f2217b;
                paddingTop = measuredHeight;
            }
        }
    }
}
