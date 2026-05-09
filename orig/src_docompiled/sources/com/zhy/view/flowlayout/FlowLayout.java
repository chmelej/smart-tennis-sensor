package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a */
    protected List<List<View>> f9306a;

    /* JADX INFO: renamed from: b */
    protected List<Integer> f9307b;

    /* JADX INFO: renamed from: c */
    protected List<Integer> f9308c;

    /* JADX INFO: renamed from: d */
    private int f9309d;

    /* JADX INFO: renamed from: e */
    private List<View> f9310e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9306a = new ArrayList();
        this.f9307b = new ArrayList();
        this.f9308c = new ArrayList();
        this.f9310e = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f9309d = typedArrayObtainStyledAttributes.getInt(R.styleable.TagFlowLayout_tag_gravity, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                if (i4 == childCount - 1) {
                    iMax = Math.max(i5, iMax);
                    i6 += i7;
                }
                i3 = size2;
            } else {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i8 = i5 + measuredWidth;
                if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                    iMax = Math.max(iMax, i5);
                    i6 += i7;
                    i8 = measuredWidth;
                } else {
                    measuredHeight = Math.max(i7, measuredHeight);
                }
                if (i4 == childCount - 1) {
                    i6 += measuredHeight;
                    i7 = measuredHeight;
                    iMax = Math.max(i8, iMax);
                } else {
                    i7 = measuredHeight;
                }
                i5 = i8;
            }
            i4++;
            size2 = i3;
        }
        int i9 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + iMax + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i9 : i6 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f9306a.clear();
        this.f9307b.clear();
        this.f9308c.clear();
        this.f9310e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int iMax = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i5 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f9307b.add(Integer.valueOf(iMax));
                    this.f9306a.add(this.f9310e);
                    this.f9308c.add(Integer.valueOf(i5));
                    iMax = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f9310e = new ArrayList();
                    i5 = 0;
                }
                i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                iMax = Math.max(iMax, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f9310e.add(childAt);
            }
        }
        this.f9307b.add(Integer.valueOf(iMax));
        this.f9308c.add(Integer.valueOf(i5));
        this.f9306a.add(this.f9310e);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f9306a.size();
        int i7 = paddingTop;
        int paddingLeft2 = paddingLeft;
        int i8 = 0;
        while (i8 < size) {
            this.f9310e = this.f9306a.get(i8);
            int iIntValue = this.f9307b.get(i8).intValue();
            int iIntValue2 = this.f9308c.get(i8).intValue();
            switch (this.f9309d) {
                case -1:
                    paddingLeft2 = getPaddingLeft();
                    break;
                case 0:
                    paddingLeft2 = ((width - iIntValue2) / 2) + getPaddingLeft();
                    break;
                case 1:
                    paddingLeft2 = (width - iIntValue2) + getPaddingLeft();
                    break;
            }
            int measuredWidth2 = paddingLeft2;
            for (int i9 = 0; i9 < this.f9310e.size(); i9++) {
                View view = this.f9310e.get(i9);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i10 = marginLayoutParams2.leftMargin + measuredWidth2;
                    int i11 = marginLayoutParams2.topMargin + i7;
                    view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                    measuredWidth2 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            i7 += iIntValue;
            i8++;
            paddingLeft2 = measuredWidth2;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
