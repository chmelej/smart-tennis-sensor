package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* JADX INFO: renamed from: a */
    protected final VisibilityAnimListener f3301a;

    /* JADX INFO: renamed from: b */
    protected final Context f3302b;

    /* JADX INFO: renamed from: c */
    protected ActionMenuView f3303c;

    /* JADX INFO: renamed from: d */
    protected ActionMenuPresenter f3304d;

    /* JADX INFO: renamed from: e */
    protected int f3305e;

    /* JADX INFO: renamed from: f */
    protected ViewPropertyAnimatorCompat f3306f;

    /* JADX INFO: renamed from: g */
    private boolean f3307g;

    /* JADX INFO: renamed from: h */
    private boolean f3308h;

    /* JADX INFO: renamed from: a */
    protected static int m3394a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3301a = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f3302b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f3302b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.f3304d != null) {
            this.f3304d.m3444a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3307g = false;
        }
        if (!this.f3307g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3307g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3307g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3308h = false;
        }
        if (!this.f3308h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3308h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3308h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f3305e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f3305e;
    }

    public int getAnimatedVisibility() {
        if (this.f3306f != null) {
            return this.f3301a.f3309a;
        }
        return getVisibility();
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat mo3399a(int i, long j) {
        if (this.f3306f != null) {
            this.f3306f.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(this).alpha(1.0f);
            viewPropertyAnimatorCompatAlpha.setDuration(j);
            viewPropertyAnimatorCompatAlpha.setListener(this.f3301a.m3401a(viewPropertyAnimatorCompatAlpha, i));
            return viewPropertyAnimatorCompatAlpha;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha2 = ViewCompat.animate(this).alpha(0.0f);
        viewPropertyAnimatorCompatAlpha2.setDuration(j);
        viewPropertyAnimatorCompatAlpha2.setListener(this.f3301a.m3401a(viewPropertyAnimatorCompatAlpha2, i));
        return viewPropertyAnimatorCompatAlpha2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f3306f != null) {
                this.f3306f.cancel();
            }
            super.setVisibility(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3400a() {
        if (this.f3304d != null) {
            return this.f3304d.m3453f();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected int m3397a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, ExploreByTouchHelper.INVALID_ID), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: renamed from: a */
    protected int m3398a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a */
        int f3309a;

        /* JADX INFO: renamed from: c */
        private boolean f3311c = false;

        protected VisibilityAnimListener() {
        }

        /* JADX INFO: renamed from: a */
        public VisibilityAnimListener m3401a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.f3306f = viewPropertyAnimatorCompat;
            this.f3309a = i;
            return this;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f3311c = false;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.f3311c) {
                return;
            }
            AbsActionBarView.this.f3306f = null;
            AbsActionBarView.super.setVisibility(this.f3309a);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.f3311c = true;
        }
    }
}
