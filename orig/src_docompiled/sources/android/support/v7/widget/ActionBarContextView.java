package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000.AbstractC1694em;
import p000.C1766hd;
import p000.C1774hl;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* JADX INFO: renamed from: g */
    private CharSequence f3322g;

    /* JADX INFO: renamed from: h */
    private CharSequence f3323h;

    /* JADX INFO: renamed from: i */
    private View f3324i;

    /* JADX INFO: renamed from: j */
    private View f3325j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f3326k;

    /* JADX INFO: renamed from: l */
    private TextView f3327l;

    /* JADX INFO: renamed from: m */
    private TextView f3328m;

    /* JADX INFO: renamed from: n */
    private int f3329n;

    /* JADX INFO: renamed from: o */
    private int f3330o;

    /* JADX INFO: renamed from: p */
    private boolean f3331p;

    /* JADX INFO: renamed from: q */
    private int f3332q;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat mo3399a(int i, long j) {
        return super.mo3399a(i, j);
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, R.styleable.ActionMode, i, 0);
        ViewCompat.setBackground(this, c1766hdM9601a.m9605a(R.styleable.ActionMode_background));
        this.f3329n = c1766hdM9601a.m9619g(R.styleable.ActionMode_titleTextStyle, 0);
        this.f3330o = c1766hdM9601a.m9619g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f3305e = c1766hdM9601a.m9617f(R.styleable.ActionMode_height, 0);
        this.f3332q = c1766hdM9601a.m9619g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        c1766hdM9601a.m9606a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3304d != null) {
            this.f3304d.m3454g();
            this.f3304d.m3456i();
        }
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public void setContentHeight(int i) {
        this.f3305e = i;
    }

    public void setCustomView(View view) {
        if (this.f3325j != null) {
            removeView(this.f3325j);
        }
        this.f3325j = view;
        if (view != null && this.f3326k != null) {
            removeView(this.f3326k);
            this.f3326k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3322g = charSequence;
        m3404e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3323h = charSequence;
        m3404e();
    }

    public CharSequence getTitle() {
        return this.f3322g;
    }

    public CharSequence getSubtitle() {
        return this.f3323h;
    }

    /* JADX INFO: renamed from: e */
    private void m3404e() {
        if (this.f3326k == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.f3326k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3327l = (TextView) this.f3326k.findViewById(R.id.action_bar_title);
            this.f3328m = (TextView) this.f3326k.findViewById(R.id.action_bar_subtitle);
            if (this.f3329n != 0) {
                this.f3327l.setTextAppearance(getContext(), this.f3329n);
            }
            if (this.f3330o != 0) {
                this.f3328m.setTextAppearance(getContext(), this.f3330o);
            }
        }
        this.f3327l.setText(this.f3322g);
        this.f3328m.setText(this.f3323h);
        boolean z = !TextUtils.isEmpty(this.f3322g);
        boolean z2 = !TextUtils.isEmpty(this.f3323h);
        this.f3328m.setVisibility(z2 ? 0 : 8);
        this.f3326k.setVisibility((z || z2) ? 0 : 8);
        if (this.f3326k.getParent() == null) {
            addView(this.f3326k);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3405a(final AbstractC1694em abstractC1694em) {
        if (this.f3324i == null) {
            this.f3324i = LayoutInflater.from(getContext()).inflate(this.f3332q, (ViewGroup) this, false);
            addView(this.f3324i);
        } else if (this.f3324i.getParent() == null) {
            addView(this.f3324i);
        }
        this.f3324i.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                abstractC1694em.mo8965c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) abstractC1694em.mo8962b();
        if (this.f3304d != null) {
            this.f3304d.m3455h();
        }
        this.f3304d = new ActionMenuPresenter(getContext());
        this.f3304d.m3450b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.m3331a(this.f3304d, this.f3302b);
        this.f3303c = (ActionMenuView) this.f3304d.mo3443a(this);
        ViewCompat.setBackground(this.f3303c, null);
        addView(this.f3303c, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public void m3406b() {
        if (this.f3324i == null) {
            m3407c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3407c() {
        removeAllViews();
        this.f3325j = null;
        this.f3303c = null;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    /* JADX INFO: renamed from: a */
    public boolean mo3400a() {
        if (this.f3304d != null) {
            return this.f3304d.m3453f();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f3305e > 0 ? this.f3305e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, ExploreByTouchHelper.INVALID_ID);
        if (this.f3324i != null) {
            int iA = m3397a(this.f3324i, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3324i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.f3303c != null && this.f3303c.getParent() == this) {
            paddingLeft = m3397a(this.f3303c, paddingLeft, iMakeMeasureSpec, 0);
        }
        if (this.f3326k != null && this.f3325j == null) {
            if (this.f3331p) {
                this.f3326k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f3326k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f3326k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m3397a(this.f3326k, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        if (this.f3325j != null) {
            ViewGroup.LayoutParams layoutParams = this.f3325j.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : ExploreByTouchHelper.INVALID_ID;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            int i4 = layoutParams.height == -2 ? ExploreByTouchHelper.INVALID_ID : 1073741824;
            if (layoutParams.height >= 0) {
                iMin = Math.min(layoutParams.height, iMin);
            }
            this.f3325j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.f3305e <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i5) {
                    i5 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i5);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        boolean zM9679a = C1774hl.m9679a(this);
        int paddingRight = zM9679a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f3324i == null || this.f3324i.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3324i.getLayoutParams();
            int i5 = zM9679a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zM9679a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = m3394a(paddingRight, i5, zM9679a);
            iA = m3394a(iA2 + m3398a(this.f3324i, iA2, paddingTop, paddingTop2, zM9679a), i6, zM9679a);
        }
        if (this.f3326k != null && this.f3325j == null && this.f3326k.getVisibility() != 8) {
            iA += m3398a(this.f3326k, iA, paddingTop, paddingTop2, zM9679a);
        }
        int i7 = iA;
        if (this.f3325j != null) {
            m3398a(this.f3325j, i7, paddingTop, paddingTop2, zM9679a);
        }
        int paddingLeft = zM9679a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f3303c != null) {
            m3398a(this.f3303c, paddingLeft, paddingTop, paddingTop2, !zM9679a);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f3322g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f3331p) {
            requestLayout();
        }
        this.f3331p = z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3408d() {
        return this.f3331p;
    }
}
