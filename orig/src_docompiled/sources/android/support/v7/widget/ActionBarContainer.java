package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import p000.C1721fm;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a */
    public Drawable f3312a;

    /* JADX INFO: renamed from: b */
    public Drawable f3313b;

    /* JADX INFO: renamed from: c */
    public Drawable f3314c;

    /* JADX INFO: renamed from: d */
    public boolean f3315d;

    /* JADX INFO: renamed from: e */
    public boolean f3316e;

    /* JADX INFO: renamed from: f */
    private boolean f3317f;

    /* JADX INFO: renamed from: g */
    private View f3318g;

    /* JADX INFO: renamed from: h */
    private View f3319h;

    /* JADX INFO: renamed from: i */
    private View f3320i;

    /* JADX INFO: renamed from: j */
    private int f3321j;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, new C1721fm(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f3312a = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f3313b = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f3321j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f3315d = true;
            this.f3314c = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f3315d ? !(this.f3312a != null || this.f3313b != null) : this.f3314c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3319h = findViewById(R.id.action_bar);
        this.f3320i = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.f3312a != null) {
            this.f3312a.setCallback(null);
            unscheduleDrawable(this.f3312a);
        }
        this.f3312a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3319h != null) {
                this.f3312a.setBounds(this.f3319h.getLeft(), this.f3319h.getTop(), this.f3319h.getRight(), this.f3319h.getBottom());
            }
        }
        boolean z = false;
        if (!this.f3315d ? !(this.f3312a != null || this.f3313b != null) : this.f3314c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.f3313b != null) {
            this.f3313b.setCallback(null);
            unscheduleDrawable(this.f3313b);
        }
        this.f3313b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3316e && this.f3313b != null) {
                this.f3313b.setBounds(this.f3318g.getLeft(), this.f3318g.getTop(), this.f3318g.getRight(), this.f3318g.getBottom());
            }
        }
        boolean z = false;
        if (!this.f3315d ? !(this.f3312a != null || this.f3313b != null) : this.f3314c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.f3314c != null) {
            this.f3314c.setCallback(null);
            unscheduleDrawable(this.f3314c);
        }
        this.f3314c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3315d && this.f3314c != null) {
                this.f3314c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f3315d ? !(this.f3312a != null || this.f3313b != null) : this.f3314c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f3312a != null) {
            this.f3312a.setVisible(z, false);
        }
        if (this.f3313b != null) {
            this.f3313b.setVisible(z, false);
        }
        if (this.f3314c != null) {
            this.f3314c.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f3312a && !this.f3315d) || (drawable == this.f3313b && this.f3316e) || ((drawable == this.f3314c && this.f3315d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3312a != null && this.f3312a.isStateful()) {
            this.f3312a.setState(getDrawableState());
        }
        if (this.f3313b != null && this.f3313b.isStateful()) {
            this.f3313b.setState(getDrawableState());
        }
        if (this.f3314c == null || !this.f3314c.isStateful()) {
            return;
        }
        this.f3314c.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f3312a != null) {
            this.f3312a.jumpToCurrentState();
        }
        if (this.f3313b != null) {
            this.f3313b.jumpToCurrentState();
        }
        if (this.f3314c != null) {
            this.f3314c.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f3317f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3317f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f3318g != null) {
            removeView(this.f3318g);
        }
        this.f3318g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f3318g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3402a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* JADX INFO: renamed from: b */
    private int m3403b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iM3403b;
        if (this.f3319h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f3321j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f3321j, View.MeasureSpec.getSize(i2)), ExploreByTouchHelper.INVALID_ID);
        }
        super.onMeasure(i, i2);
        if (this.f3319h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (this.f3318g == null || this.f3318g.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!m3402a(this.f3319h)) {
            iM3403b = m3403b(this.f3319h);
        } else {
            iM3403b = !m3402a(this.f3320i) ? m3403b(this.f3320i) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iM3403b + m3403b(this.f3318g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f3318g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f3315d) {
            if (this.f3314c != null) {
                this.f3314c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f3312a != null) {
                if (this.f3319h.getVisibility() == 0) {
                    this.f3312a.setBounds(this.f3319h.getLeft(), this.f3319h.getTop(), this.f3319h.getRight(), this.f3319h.getBottom());
                } else if (this.f3320i != null && this.f3320i.getVisibility() == 0) {
                    this.f3312a.setBounds(this.f3320i.getLeft(), this.f3320i.getTop(), this.f3320i.getRight(), this.f3320i.getBottom());
                } else {
                    this.f3312a.setBounds(0, 0, 0, 0);
                }
                z3 = true;
            }
            this.f3316e = z4;
            if (!z4 || this.f3313b == null) {
                z2 = z3;
            } else {
                this.f3313b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }
}
