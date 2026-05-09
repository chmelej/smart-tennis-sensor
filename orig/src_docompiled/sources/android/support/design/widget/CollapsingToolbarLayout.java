package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import p000.C0751at;
import p000.C0766bh;
import p000.C0768bj;
import p000.C0778bt;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    final C0766bh f2401a;

    /* JADX INFO: renamed from: b */
    Drawable f2402b;

    /* JADX INFO: renamed from: c */
    int f2403c;

    /* JADX INFO: renamed from: d */
    WindowInsetsCompat f2404d;

    /* JADX INFO: renamed from: e */
    private boolean f2405e;

    /* JADX INFO: renamed from: f */
    private int f2406f;

    /* JADX INFO: renamed from: g */
    private Toolbar f2407g;

    /* JADX INFO: renamed from: h */
    private View f2408h;

    /* JADX INFO: renamed from: i */
    private View f2409i;

    /* JADX INFO: renamed from: j */
    private int f2410j;

    /* JADX INFO: renamed from: k */
    private int f2411k;

    /* JADX INFO: renamed from: l */
    private int f2412l;

    /* JADX INFO: renamed from: m */
    private int f2413m;

    /* JADX INFO: renamed from: n */
    private final Rect f2414n;

    /* JADX INFO: renamed from: o */
    private boolean f2415o;

    /* JADX INFO: renamed from: p */
    private boolean f2416p;

    /* JADX INFO: renamed from: q */
    private Drawable f2417q;

    /* JADX INFO: renamed from: r */
    private int f2418r;

    /* JADX INFO: renamed from: s */
    private boolean f2419s;

    /* JADX INFO: renamed from: t */
    private ValueAnimator f2420t;

    /* JADX INFO: renamed from: u */
    private long f2421u;

    /* JADX INFO: renamed from: v */
    private int f2422v;

    /* JADX INFO: renamed from: w */
    private AppBarLayout.InterfaceC0258b f2423w;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2405e = true;
        this.f2414n = new Rect();
        this.f2422v = -1;
        this.f2401a = new C0766bh(this);
        this.f2401a.m5539a(C2178v.f13003e);
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar, new int[0]);
        this.f2401a.m5537a(typedArrayM5390a.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f2401a.m5548b(typedArrayM5390a.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f2413m = dimensionPixelSize;
        this.f2412l = dimensionPixelSize;
        this.f2411k = dimensionPixelSize;
        this.f2410j = dimensionPixelSize;
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f2410j = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f2412l = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f2411k = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f2413m = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f2415o = typedArrayM5390a.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayM5390a.getText(R.styleable.CollapsingToolbarLayout_title));
        this.f2401a.m5557d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f2401a.m5554c(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f2401a.m5557d(typedArrayM5390a.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayM5390a.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f2401a.m5554c(typedArrayM5390a.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f2422v = typedArrayM5390a.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f2421u = typedArrayM5390a.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayM5390a.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayM5390a.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f2406f = typedArrayM5390a.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayM5390a.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CollapsingToolbarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.m2664a(windowInsetsCompat);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.f2423w == null) {
                this.f2423w = new C0284a();
            }
            ((AppBarLayout) parent).m2525a(this.f2423w);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f2423w != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m2528b(this.f2423w);
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: renamed from: a */
    WindowInsetsCompat m2664a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f2404d, windowInsetsCompat2)) {
            this.f2404d = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        m2657c();
        if (this.f2407g == null && this.f2417q != null && this.f2418r > 0) {
            this.f2417q.mutate().setAlpha(this.f2418r);
            this.f2417q.draw(canvas);
        }
        if (this.f2415o && this.f2416p) {
            this.f2401a.m5541a(canvas);
        }
        if (this.f2402b == null || this.f2418r <= 0) {
            return;
        }
        int systemWindowInsetTop = this.f2404d != null ? this.f2404d.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f2402b.setBounds(0, -this.f2403c, getWidth(), systemWindowInsetTop - this.f2403c);
            this.f2402b.mutate().setAlpha(this.f2418r);
            this.f2402b.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.f2417q == null || this.f2418r <= 0 || !m2658c(view)) {
            z = false;
        } else {
            this.f2417q.mutate().setAlpha(this.f2418r);
            this.f2417q.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2417q != null) {
            this.f2417q.setBounds(0, 0, i, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2657c() {
        if (this.f2405e) {
            Toolbar toolbar = null;
            this.f2407g = null;
            this.f2408h = null;
            if (this.f2406f != -1) {
                this.f2407g = (Toolbar) findViewById(this.f2406f);
                if (this.f2407g != null) {
                    this.f2408h = m2659d(this.f2407g);
                }
            }
            if (this.f2407g == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i++;
                }
                this.f2407g = toolbar;
            }
            m2660d();
            this.f2405e = false;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m2658c(View view) {
        if (this.f2408h == null || this.f2408h == this) {
            if (view != this.f2407g) {
                return false;
            }
        } else if (view != this.f2408h) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    private View m2659d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: d */
    private void m2660d() {
        if (!this.f2415o && this.f2409i != null) {
            ViewParent parent = this.f2409i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2409i);
            }
        }
        if (!this.f2415o || this.f2407g == null) {
            return;
        }
        if (this.f2409i == null) {
            this.f2409i = new View(getContext());
        }
        if (this.f2409i.getParent() == null) {
            this.f2407g.addView(this.f2409i, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m2657c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int systemWindowInsetTop = this.f2404d != null ? this.f2404d.getSystemWindowInsetTop() : 0;
        if (mode != 0 || systemWindowInsetTop <= 0) {
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2404d != null) {
            int systemWindowInsetTop = this.f2404d.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.f2415o && this.f2409i != null) {
            this.f2416p = ViewCompat.isAttachedToWindow(this.f2409i) && this.f2409i.getVisibility() == 0;
            if (this.f2416p) {
                boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
                int iM2666b = m2666b(this.f2408h != null ? this.f2408h : this.f2407g);
                C0768bj.m5578b(this, this.f2409i, this.f2414n);
                this.f2401a.m5549b(this.f2414n.left + (z2 ? this.f2407g.getTitleMarginEnd() : this.f2407g.getTitleMarginStart()), this.f2414n.top + iM2666b + this.f2407g.getTitleMarginTop(), this.f2414n.right + (z2 ? this.f2407g.getTitleMarginStart() : this.f2407g.getTitleMarginEnd()), (this.f2414n.bottom + iM2666b) - this.f2407g.getTitleMarginBottom());
                this.f2401a.m5538a(z2 ? this.f2412l : this.f2410j, this.f2414n.top + this.f2411k, (i3 - i) - (z2 ? this.f2410j : this.f2412l), (i4 - i2) - this.f2413m);
                this.f2401a.m5564k();
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            m2655a(getChildAt(i6)).m5708a();
        }
        if (this.f2407g != null) {
            if (this.f2415o && TextUtils.isEmpty(this.f2401a.m5565l())) {
                setTitle(this.f2407g.getTitle());
            }
            if (this.f2408h == null || this.f2408h == this) {
                setMinimumHeight(m2661e(this.f2407g));
            } else {
                setMinimumHeight(m2661e(this.f2408h));
            }
        }
        m2667b();
    }

    /* JADX INFO: renamed from: e */
    private static int m2661e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    /* JADX INFO: renamed from: a */
    static C0778bt m2655a(View view) {
        C0778bt c0778bt = (C0778bt) view.getTag(R.id.view_offset_helper);
        if (c0778bt != null) {
            return c0778bt;
        }
        C0778bt c0778bt2 = new C0778bt(view);
        view.setTag(R.id.view_offset_helper, c0778bt2);
        return c0778bt2;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2401a.m5544a(charSequence);
        m2662e();
    }

    public CharSequence getTitle() {
        if (this.f2415o) {
            return this.f2401a.m5565l();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f2415o) {
            this.f2415o = z;
            m2662e();
            m2660d();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.f2419s != z) {
            if (z2) {
                m2656a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.f2419s = z;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2656a(int i) {
        m2657c();
        if (this.f2420t == null) {
            this.f2420t = new ValueAnimator();
            this.f2420t.setDuration(this.f2421u);
            this.f2420t.setInterpolator(i > this.f2418r ? C2178v.f13001c : C2178v.f13002d);
            this.f2420t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.f2420t.isRunning()) {
            this.f2420t.cancel();
        }
        this.f2420t.setIntValues(this.f2418r, i);
        this.f2420t.start();
    }

    void setScrimAlpha(int i) {
        if (i != this.f2418r) {
            if (this.f2417q != null && this.f2407g != null) {
                ViewCompat.postInvalidateOnAnimation(this.f2407g);
            }
            this.f2418r = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int getScrimAlpha() {
        return this.f2418r;
    }

    public void setContentScrim(Drawable drawable) {
        if (this.f2417q != drawable) {
            if (this.f2417q != null) {
                this.f2417q.setCallback(null);
            }
            this.f2417q = drawable != null ? drawable.mutate() : null;
            if (this.f2417q != null) {
                this.f2417q.setBounds(0, 0, getWidth(), getHeight());
                this.f2417q.setCallback(this);
                this.f2417q.setAlpha(this.f2418r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f2417q;
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.f2402b != drawable) {
            if (this.f2402b != null) {
                this.f2402b.setCallback(null);
            }
            this.f2402b = drawable != null ? drawable.mutate() : null;
            if (this.f2402b != null) {
                if (this.f2402b.isStateful()) {
                    this.f2402b.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f2402b, ViewCompat.getLayoutDirection(this));
                this.f2402b.setVisible(getVisibility() == 0, false);
                this.f2402b.setCallback(this);
                this.f2402b.setAlpha(this.f2418r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2402b;
        boolean zM5545a = false;
        if (drawable != null && drawable.isStateful()) {
            zM5545a = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2417q;
        if (drawable2 != null && drawable2.isStateful()) {
            zM5545a |= drawable2.setState(drawableState);
        }
        if (this.f2401a != null) {
            zM5545a |= this.f2401a.m5545a(drawableState);
        }
        if (zM5545a) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2417q || drawable == this.f2402b;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f2402b != null && this.f2402b.isVisible() != z) {
            this.f2402b.setVisible(z, false);
        }
        if (this.f2417q == null || this.f2417q.isVisible() == z) {
            return;
        }
        this.f2417q.setVisible(z, false);
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f2402b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f2401a.m5554c(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f2401a.m5540a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f2401a.m5548b(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f2401a.m5558e();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f2401a.m5557d(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f2401a.m5551b(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f2401a.m5537a(i);
    }

    public int getExpandedTitleGravity() {
        return this.f2401a.m5556d();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f2401a.m5543a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f2401a.m5559f();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f2401a.m5552b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f2401a.m5560g();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.f2410j = i;
        this.f2411k = i2;
        this.f2412l = i3;
        this.f2413m = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.f2410j;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f2410j = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f2411k;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f2411k = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f2412l;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f2412l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f2413m;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f2413m = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f2422v != i) {
            this.f2422v = i;
            m2667b();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.f2422v >= 0) {
            return this.f2422v;
        }
        int systemWindowInsetTop = this.f2404d != null ? this.f2404d.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f2421u = j;
    }

    public long getScrimAnimationDuration() {
        return this.f2421u;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f2426a;

        /* JADX INFO: renamed from: b */
        float f2427b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2426a = 0;
            this.f2427b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f2426a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            m2668a(typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2426a = 0;
            this.f2427b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2426a = 0;
            this.f2427b = 0.5f;
        }

        /* JADX INFO: renamed from: a */
        public void m2668a(float f) {
            this.f2427b = f;
        }
    }

    /* JADX INFO: renamed from: b */
    final void m2667b() {
        if (this.f2417q == null && this.f2402b == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f2403c < getScrimVisibleHeightTrigger());
    }

    /* JADX INFO: renamed from: b */
    final int m2666b(View view) {
        return ((getHeight() - m2655a(view).m5712c()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* JADX INFO: renamed from: e */
    private void m2662e() {
        setContentDescription(getTitle());
    }

    /* JADX INFO: renamed from: android.support.design.widget.CollapsingToolbarLayout$a */
    class C0284a implements AppBarLayout.InterfaceC0258b {
        C0284a() {
        }

        @Override // android.support.design.widget.AppBarLayout.InterfaceC0257a
        /* JADX INFO: renamed from: a */
        public void mo2588a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.f2403c = i;
            int systemWindowInsetTop = CollapsingToolbarLayout.this.f2404d != null ? CollapsingToolbarLayout.this.f2404d.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                C0778bt c0778btM2655a = CollapsingToolbarLayout.m2655a(childAt);
                switch (layoutParams.f2426a) {
                    case 1:
                        c0778btM2655a.m5709a(MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.m2666b(childAt)));
                        break;
                    case 2:
                        c0778btM2655a.m5709a(Math.round((-i) * layoutParams.f2427b));
                        break;
                }
            }
            CollapsingToolbarLayout.this.m2667b();
            if (CollapsingToolbarLayout.this.f2402b != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.f2401a.m5547b(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
        }
    }
}
