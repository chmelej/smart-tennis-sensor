package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private boolean f3496a;

    /* JADX INFO: renamed from: b */
    private int f3497b;

    /* JADX INFO: renamed from: c */
    private int f3498c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3497b = -1;
        this.f3498c = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        this.f3496a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f3496a != z) {
            this.f3496a = z;
            if (!this.f3496a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = 0;
        if (this.f3496a) {
            if (size > this.f3497b && m3513a()) {
                setStacked(false);
            }
            this.f3497b = size;
        }
        if (m3513a() || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.f3496a && !m3513a()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int iM3512a = m3512a(0);
        if (iM3512a >= 0) {
            View childAt = getChildAt(iM3512a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (m3513a()) {
                int iM3512a2 = m3512a(iM3512a + 1);
                if (iM3512a2 >= 0) {
                    paddingTop += getChildAt(iM3512a2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3512a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f3498c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View viewFindViewById = findViewById(R.id.spacer);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3513a() {
        return getOrientation() == 1;
    }
}
