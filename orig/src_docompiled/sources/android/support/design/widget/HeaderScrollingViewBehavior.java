package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: a */
    final Rect f2507a;

    /* JADX INFO: renamed from: b */
    final Rect f2508b;

    /* JADX INFO: renamed from: c */
    private int f2509c;

    /* JADX INFO: renamed from: d */
    private int f2510d;

    /* JADX INFO: renamed from: c */
    private static int m2788c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    float mo2583a(View view) {
        return 1.0f;
    }

    /* JADX INFO: renamed from: b */
    abstract View mo2587b(List<View> list);

    public HeaderScrollingViewBehavior() {
        this.f2507a = new Rect();
        this.f2508b = new Rect();
        this.f2509c = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2507a = new Rect();
        this.f2508b = new Rect();
        this.f2509c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2564a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewMo2587b;
        View view2;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewMo2587b = mo2587b(coordinatorLayout.m2706c(view))) == null) {
            return false;
        }
        if (!ViewCompat.getFitsSystemWindows(viewMo2587b) || ViewCompat.getFitsSystemWindows(view)) {
            view2 = view;
        } else {
            view2 = view;
            ViewCompat.setFitsSystemWindows(view2, true);
            if (ViewCompat.getFitsSystemWindows(view2)) {
                view2.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.m2698a(view2, i, i2, View.MeasureSpec.makeMeasureSpec((size - viewMo2587b.getMeasuredHeight()) + mo2586b(viewMo2587b), i5 == -1 ? 1073741824 : ExploreByTouchHelper.INVALID_ID), i4);
        return true;
    }

    @Override // android.support.design.widget.ViewOffsetBehavior
    /* JADX INFO: renamed from: b */
    protected void mo2791b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewMo2587b = mo2587b(coordinatorLayout.m2706c(view));
        if (viewMo2587b != null) {
            CoordinatorLayout.C0290d c0290d = (CoordinatorLayout.C0290d) view.getLayoutParams();
            Rect rect = this.f2507a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0290d.leftMargin, viewMo2587b.getBottom() + c0290d.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0290d.rightMargin, ((coordinatorLayout.getHeight() + viewMo2587b.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0290d.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f2508b;
            GravityCompat.apply(m2788c(c0290d.f2458c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int iM2792c = m2792c(viewMo2587b);
            view.layout(rect2.left, rect2.top - iM2792c, rect2.right, rect2.bottom - iM2792c);
            this.f2509c = rect2.top - viewMo2587b.getBottom();
            return;
        }
        super.mo2791b(coordinatorLayout, view, i);
        this.f2509c = 0;
    }

    /* JADX INFO: renamed from: c */
    final int m2792c(View view) {
        if (this.f2510d == 0) {
            return 0;
        }
        return MathUtils.clamp((int) (mo2583a(view) * this.f2510d), 0, this.f2510d);
    }

    /* JADX INFO: renamed from: b */
    int mo2586b(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: renamed from: a */
    final int m2789a() {
        return this.f2509c;
    }

    /* JADX INFO: renamed from: b */
    public final void m2790b(int i) {
        this.f2510d = i;
    }

    /* JADX INFO: renamed from: d */
    public final int m2793d() {
        return this.f2510d;
    }
}
