package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import p000.C1774hl;
import p000.InterfaceC1714ff;
import p000.InterfaceC1740ge;
import p000.InterfaceC1741gf;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, InterfaceC1740ge {

    /* JADX INFO: renamed from: e */
    static final int[] f3335e = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A */
    private final Runnable f3336A;

    /* JADX INFO: renamed from: B */
    private final NestedScrollingParentHelper f3337B;

    /* JADX INFO: renamed from: a */
    ActionBarContainer f3338a;

    /* JADX INFO: renamed from: b */
    boolean f3339b;

    /* JADX INFO: renamed from: c */
    ViewPropertyAnimator f3340c;

    /* JADX INFO: renamed from: d */
    final AnimatorListenerAdapter f3341d;

    /* JADX INFO: renamed from: f */
    private int f3342f;

    /* JADX INFO: renamed from: g */
    private int f3343g;

    /* JADX INFO: renamed from: h */
    private ContentFrameLayout f3344h;

    /* JADX INFO: renamed from: i */
    private InterfaceC1741gf f3345i;

    /* JADX INFO: renamed from: j */
    private Drawable f3346j;

    /* JADX INFO: renamed from: k */
    private boolean f3347k;

    /* JADX INFO: renamed from: l */
    private boolean f3348l;

    /* JADX INFO: renamed from: m */
    private boolean f3349m;

    /* JADX INFO: renamed from: n */
    private boolean f3350n;

    /* JADX INFO: renamed from: o */
    private int f3351o;

    /* JADX INFO: renamed from: p */
    private int f3352p;

    /* JADX INFO: renamed from: q */
    private final Rect f3353q;

    /* JADX INFO: renamed from: r */
    private final Rect f3354r;

    /* JADX INFO: renamed from: s */
    private final Rect f3355s;

    /* JADX INFO: renamed from: t */
    private final Rect f3356t;

    /* JADX INFO: renamed from: u */
    private final Rect f3357u;

    /* JADX INFO: renamed from: v */
    private final Rect f3358v;

    /* JADX INFO: renamed from: w */
    private final Rect f3359w;

    /* JADX INFO: renamed from: x */
    private InterfaceC0559a f3360x;

    /* JADX INFO: renamed from: y */
    private OverScroller f3361y;

    /* JADX INFO: renamed from: z */
    private final Runnable f3362z;

    /* JADX INFO: renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    public interface InterfaceC0559a {
        /* JADX INFO: renamed from: a */
        void mo3429a(int i);

        /* JADX INFO: renamed from: g */
        void mo3430g(boolean z);

        /* JADX INFO: renamed from: l */
        void mo3431l();

        /* JADX INFO: renamed from: m */
        void mo3432m();

        /* JADX INFO: renamed from: n */
        void mo3433n();

        /* JADX INFO: renamed from: o */
        void mo3434o();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3343g = 0;
        this.f3353q = new Rect();
        this.f3354r = new Rect();
        this.f3355s = new Rect();
        this.f3356t = new Rect();
        this.f3357u = new Rect();
        this.f3358v = new Rect();
        this.f3359w = new Rect();
        this.f3341d = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f3340c = null;
                ActionBarOverlayLayout.this.f3339b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f3340c = null;
                ActionBarOverlayLayout.this.f3339b = false;
            }
        };
        this.f3362z = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m3422d();
                ActionBarOverlayLayout.this.f3340c = ActionBarOverlayLayout.this.f3338a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f3341d);
            }
        };
        this.f3336A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m3422d();
                ActionBarOverlayLayout.this.f3340c = ActionBarOverlayLayout.this.f3338a.animate().translationY(-ActionBarOverlayLayout.this.f3338a.getHeight()).setListener(ActionBarOverlayLayout.this.f3341d);
            }
        };
        m3410a(context);
        this.f3337B = new NestedScrollingParentHelper(this);
    }

    /* JADX INFO: renamed from: a */
    private void m3410a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3335e);
        this.f3342f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3346j = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f3346j == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f3347k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3361y = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3422d();
    }

    public void setActionBarVisibilityCallback(InterfaceC0559a interfaceC0559a) {
        this.f3360x = interfaceC0559a;
        if (getWindowToken() != null) {
            this.f3360x.mo3429a(this.f3343g);
            if (this.f3352p != 0) {
                onWindowSystemUiVisibilityChanged(this.f3352p);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f3348l = z;
        this.f3347k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3419a() {
        return this.f3348l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f3349m = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3410a(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3421c();
        int i2 = this.f3352p ^ i;
        this.f3352p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.f3360x != null) {
            this.f3360x.mo3430g(!z2);
            if (z || !z2) {
                this.f3360x.mo3431l();
            } else {
                this.f3360x.mo3432m();
            }
        }
        if ((i2 & 256) == 0 || this.f3360x == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f3343g = i;
        if (this.f3360x != null) {
            this.f3360x.mo3429a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3412a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z || layoutParams.leftMargin == rect.left) {
            z5 = false;
        } else {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        m3421c();
        int windowSystemUiVisibility = ViewCompat.getWindowSystemUiVisibility(this) & 256;
        boolean zM3412a = m3412a(this.f3338a, rect, true, true, false, true);
        this.f3356t.set(rect);
        C1774hl.m9678a(this, this.f3356t, this.f3353q);
        if (!this.f3357u.equals(this.f3356t)) {
            this.f3357u.set(this.f3356t);
            zM3412a = true;
        }
        if (!this.f3354r.equals(this.f3353q)) {
            this.f3354r.set(this.f3353q);
            zM3412a = true;
        }
        if (zM3412a) {
            requestLayout();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        m3421c();
        measureChildWithMargins(this.f3338a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f3338a.getLayoutParams();
        int iMax = Math.max(0, this.f3338a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int iMax2 = Math.max(0, this.f3338a.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3338a.getMeasuredState());
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f3342f;
            if (this.f3349m && this.f3338a.getTabContainer() != null) {
                measuredHeight += this.f3342f;
            }
        } else {
            measuredHeight = this.f3338a.getVisibility() != 8 ? this.f3338a.getMeasuredHeight() : 0;
        }
        this.f3355s.set(this.f3353q);
        this.f3358v.set(this.f3356t);
        if (!this.f3348l && !z) {
            this.f3355s.top += measuredHeight;
            this.f3355s.bottom += 0;
        } else {
            this.f3358v.top += measuredHeight;
            this.f3358v.bottom += 0;
        }
        m3412a(this.f3344h, this.f3355s, true, true, true, true);
        if (!this.f3359w.equals(this.f3358v)) {
            this.f3359w.set(this.f3358v);
            this.f3344h.m3524a(this.f3358v);
        }
        measureChildWithMargins(this.f3344h, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f3344h.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f3344h.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int iMax4 = Math.max(iMax2, this.f3344h.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3344h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3346j == null || this.f3347k) {
            return;
        }
        int bottom = this.f3338a.getVisibility() == 0 ? (int) (this.f3338a.getBottom() + this.f3338a.getTranslationY() + 0.5f) : 0;
        this.f3346j.setBounds(0, bottom, getWidth(), this.f3346j.getIntrinsicHeight() + bottom);
        this.f3346j.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f3338a.getVisibility() != 0) {
            return false;
        }
        return this.f3350n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3337B.onNestedScrollAccepted(view, view2, i);
        this.f3351o = getActionBarHideOffset();
        m3422d();
        if (this.f3360x != null) {
            this.f3360x.mo3433n();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f3351o += i2;
        setActionBarHideOffset(this.f3351o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f3350n && !this.f3339b) {
            if (this.f3351o <= this.f3338a.getHeight()) {
                m3413k();
            } else {
                m3414l();
            }
        }
        if (this.f3360x != null) {
            this.f3360x.mo3434o();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f3350n || !z) {
            return false;
        }
        if (m3411a(f, f2)) {
            m3416n();
        } else {
            m3415m();
        }
        this.f3339b = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f3337B.getNestedScrollAxes();
    }

    /* JADX INFO: renamed from: c */
    void m3421c() {
        if (this.f3344h == null) {
            this.f3344h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f3338a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f3345i = m3409a(findViewById(R.id.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private InterfaceC1741gf m3409a(View view) {
        if (view instanceof InterfaceC1741gf) {
            return (InterfaceC1741gf) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f3350n) {
            this.f3350n = z;
            if (z) {
                return;
            }
            m3422d();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        if (this.f3338a != null) {
            return -((int) this.f3338a.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        m3422d();
        this.f3338a.setTranslationY(-Math.max(0, Math.min(i, this.f3338a.getHeight())));
    }

    /* JADX INFO: renamed from: d */
    void m3422d() {
        removeCallbacks(this.f3362z);
        removeCallbacks(this.f3336A);
        if (this.f3340c != null) {
            this.f3340c.cancel();
        }
    }

    /* JADX INFO: renamed from: k */
    private void m3413k() {
        m3422d();
        postDelayed(this.f3362z, 600L);
    }

    /* JADX INFO: renamed from: l */
    private void m3414l() {
        m3422d();
        postDelayed(this.f3336A, 600L);
    }

    /* JADX INFO: renamed from: m */
    private void m3415m() {
        m3422d();
        this.f3362z.run();
    }

    /* JADX INFO: renamed from: n */
    private void m3416n() {
        m3422d();
        this.f3336A.run();
    }

    /* JADX INFO: renamed from: a */
    private boolean m3411a(float f, float f2) {
        this.f3361y.fling(0, 0, 0, (int) f2, 0, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE);
        return this.f3361y.getFinalY() > this.f3338a.getHeight();
    }

    @Override // p000.InterfaceC1740ge
    public void setWindowCallback(Window.Callback callback) {
        m3421c();
        this.f3345i.mo9387a(callback);
    }

    @Override // p000.InterfaceC1740ge
    public void setWindowTitle(CharSequence charSequence) {
        m3421c();
        this.f3345i.mo9389a(charSequence);
    }

    public CharSequence getTitle() {
        m3421c();
        return this.f3345i.mo9398e();
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: a */
    public void mo3418a(int i) {
        m3421c();
        if (i == 2) {
            this.f3345i.mo9399f();
        } else if (i == 5) {
            this.f3345i.mo9400g();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void setIcon(int i) {
        m3421c();
        this.f3345i.mo9383a(i);
    }

    public void setIcon(Drawable drawable) {
        m3421c();
        this.f3345i.mo9384a(drawable);
    }

    public void setLogo(int i) {
        m3421c();
        this.f3345i.mo9392b(i);
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: e */
    public boolean mo3423e() {
        m3421c();
        return this.f3345i.mo9401h();
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: f */
    public boolean mo3424f() {
        m3421c();
        return this.f3345i.mo9402i();
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: g */
    public boolean mo3425g() {
        m3421c();
        return this.f3345i.mo9403j();
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: h */
    public boolean mo3426h() {
        m3421c();
        return this.f3345i.mo9404k();
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: i */
    public boolean mo3427i() {
        m3421c();
        return this.f3345i.mo9405l();
    }

    @Override // p000.InterfaceC1740ge
    public void setMenuPrepared() {
        m3421c();
        this.f3345i.mo9406m();
    }

    @Override // p000.InterfaceC1740ge
    public void setMenu(Menu menu, InterfaceC1714ff.a aVar) {
        m3421c();
        this.f3345i.mo9386a(menu, aVar);
    }

    @Override // p000.InterfaceC1740ge
    /* JADX INFO: renamed from: j */
    public void mo3428j() {
        m3421c();
        this.f3345i.mo9407n();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
