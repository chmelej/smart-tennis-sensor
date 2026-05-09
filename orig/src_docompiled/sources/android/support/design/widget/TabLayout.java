package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.R;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.Pools;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p000.C0751at;
import p000.C0752au;
import p000.C0753av;
import p000.C0756ay;
import p000.C1684ee;
import p000.C1768hf;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: w */
    private static final Pools.Pool<C0309f> f2544w = new Pools.SynchronizedPool(16);

    /* JADX INFO: renamed from: A */
    private final C0308e f2545A;

    /* JADX INFO: renamed from: B */
    private final int f2546B;

    /* JADX INFO: renamed from: C */
    private final int f2547C;

    /* JADX INFO: renamed from: D */
    private final int f2548D;

    /* JADX INFO: renamed from: E */
    private int f2549E;

    /* JADX INFO: renamed from: F */
    private InterfaceC0305b f2550F;

    /* JADX INFO: renamed from: G */
    private final ArrayList<InterfaceC0305b> f2551G;

    /* JADX INFO: renamed from: H */
    private InterfaceC0305b f2552H;

    /* JADX INFO: renamed from: I */
    private ValueAnimator f2553I;

    /* JADX INFO: renamed from: J */
    private PagerAdapter f2554J;

    /* JADX INFO: renamed from: K */
    private DataSetObserver f2555K;

    /* JADX INFO: renamed from: L */
    private TabLayoutOnPageChangeListener f2556L;

    /* JADX INFO: renamed from: M */
    private C0304a f2557M;

    /* JADX INFO: renamed from: N */
    private boolean f2558N;

    /* JADX INFO: renamed from: O */
    private final Pools.Pool<C0310g> f2559O;

    /* JADX INFO: renamed from: a */
    int f2560a;

    /* JADX INFO: renamed from: b */
    int f2561b;

    /* JADX INFO: renamed from: c */
    int f2562c;

    /* JADX INFO: renamed from: d */
    int f2563d;

    /* JADX INFO: renamed from: e */
    int f2564e;

    /* JADX INFO: renamed from: f */
    ColorStateList f2565f;

    /* JADX INFO: renamed from: g */
    ColorStateList f2566g;

    /* JADX INFO: renamed from: h */
    ColorStateList f2567h;

    /* JADX INFO: renamed from: i */
    Drawable f2568i;

    /* JADX INFO: renamed from: j */
    PorterDuff.Mode f2569j;

    /* JADX INFO: renamed from: k */
    float f2570k;

    /* JADX INFO: renamed from: l */
    float f2571l;

    /* JADX INFO: renamed from: m */
    final int f2572m;

    /* JADX INFO: renamed from: n */
    int f2573n;

    /* JADX INFO: renamed from: o */
    int f2574o;

    /* JADX INFO: renamed from: p */
    int f2575p;

    /* JADX INFO: renamed from: q */
    int f2576q;

    /* JADX INFO: renamed from: r */
    int f2577r;

    /* JADX INFO: renamed from: s */
    boolean f2578s;

    /* JADX INFO: renamed from: t */
    boolean f2579t;

    /* JADX INFO: renamed from: u */
    boolean f2580u;

    /* JADX INFO: renamed from: v */
    ViewPager f2581v;

    /* JADX INFO: renamed from: x */
    private final ArrayList<C0309f> f2582x;

    /* JADX INFO: renamed from: y */
    private C0309f f2583y;

    /* JADX INFO: renamed from: z */
    private final RectF f2584z;

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$b */
    public interface InterfaceC0305b<T extends C0309f> {
        /* JADX INFO: renamed from: a */
        void mo2852a(T t);

        /* JADX INFO: renamed from: b */
        void mo2853b(T t);

        /* JADX INFO: renamed from: c */
        void mo2854c(T t);
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$c */
    public interface InterfaceC0306c extends InterfaceC0305b {
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2582x = new ArrayList<>();
        this.f2584z = new RectF();
        this.f2573n = Integer.MAX_VALUE;
        this.f2551G = new ArrayList<>();
        this.f2559O = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        this.f2545A = new C0308e(context);
        super.addView(this.f2545A, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout, R.styleable.TabLayout_tabTextAppearance);
        this.f2545A.m2861b(typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        this.f2545A.m2857a(typedArrayM5390a.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(C0753av.m5479b(context, typedArrayM5390a, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayM5390a.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayM5390a.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f2563d = dimensionPixelSize;
        this.f2562c = dimensionPixelSize;
        this.f2561b = dimensionPixelSize;
        this.f2560a = dimensionPixelSize;
        this.f2560a = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.f2560a);
        this.f2561b = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f2561b);
        this.f2562c = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f2562c);
        this.f2563d = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f2563d);
        this.f2564e = typedArrayM5390a.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.f2564e, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.f2570k = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f2565f = C0753av.m5478a(context, typedArrayObtainStyledAttributes, android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayM5390a.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f2565f = C0753av.m5478a(context, typedArrayM5390a, R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayM5390a.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f2565f = m2815a(this.f2565f.getDefaultColor(), typedArrayM5390a.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f2566g = C0753av.m5478a(context, typedArrayM5390a, R.styleable.TabLayout_tabIconTint);
            this.f2569j = C0752au.m5475a(typedArrayM5390a.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f2567h = C0753av.m5478a(context, typedArrayM5390a, R.styleable.TabLayout_tabRippleColor);
            this.f2575p = typedArrayM5390a.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f2546B = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.f2547C = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.f2572m = typedArrayM5390a.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.f2549E = typedArrayM5390a.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.f2577r = typedArrayM5390a.getInt(R.styleable.TabLayout_tabMode, 1);
            this.f2574o = typedArrayM5390a.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.f2578s = typedArrayM5390a.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.f2580u = typedArrayM5390a.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayM5390a.recycle();
            Resources resources = getResources();
            this.f2571l = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f2548D = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            m2831h();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f2545A.m2857a(i);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.f2545A.m2861b(i);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        m2835a(i, f, z, true);
    }

    /* JADX INFO: renamed from: a */
    void m2835a(int i, float f, boolean z, boolean z2) {
        int iRound = Math.round(i + f);
        if (iRound < 0 || iRound >= this.f2545A.getChildCount()) {
            return;
        }
        if (z2) {
            this.f2545A.m2858a(i, f);
        }
        if (this.f2553I != null && this.f2553I.isRunning()) {
            this.f2553I.cancel();
        }
        scrollTo(m2814a(i, f), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2837a(C0309f c0309f) {
        m2839a(c0309f, this.f2582x.isEmpty());
    }

    /* JADX INFO: renamed from: a */
    public void m2839a(C0309f c0309f, boolean z) {
        m2838a(c0309f, this.f2582x.size(), z);
    }

    /* JADX INFO: renamed from: a */
    public void m2838a(C0309f c0309f, int i, boolean z) {
        if (c0309f.f2609a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m2818a(c0309f, i);
        m2826e(c0309f);
        if (z) {
            c0309f.m2875e();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2817a(TabItem tabItem) {
        C0309f c0309fM2833a = m2833a();
        if (tabItem.f2541a != null) {
            c0309fM2833a.m2868a(tabItem.f2541a);
        }
        if (tabItem.f2542b != null) {
            c0309fM2833a.m2866a(tabItem.f2542b);
        }
        if (tabItem.f2543c != 0) {
            c0309fM2833a.m2865a(tabItem.f2543c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            c0309fM2833a.m2871b(tabItem.getContentDescription());
        }
        m2837a(c0309fM2833a);
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC0305b interfaceC0305b) {
        if (this.f2550F != null) {
            m2844b(this.f2550F);
        }
        this.f2550F = interfaceC0305b;
        if (interfaceC0305b != null) {
            m2836a(interfaceC0305b);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2836a(InterfaceC0305b interfaceC0305b) {
        if (this.f2551G.contains(interfaceC0305b)) {
            return;
        }
        this.f2551G.add(interfaceC0305b);
    }

    /* JADX INFO: renamed from: b */
    public void m2844b(InterfaceC0305b interfaceC0305b) {
        this.f2551G.remove(interfaceC0305b);
    }

    /* JADX INFO: renamed from: a */
    public C0309f m2833a() {
        C0309f c0309fM2843b = m2843b();
        c0309fM2843b.f2609a = this;
        c0309fM2843b.f2610b = m2823d(c0309fM2843b);
        return c0309fM2843b;
    }

    /* JADX INFO: renamed from: b */
    protected C0309f m2843b() {
        C0309f c0309fAcquire = f2544w.acquire();
        return c0309fAcquire == null ? new C0309f() : c0309fAcquire;
    }

    /* JADX INFO: renamed from: b */
    protected boolean m2846b(C0309f c0309f) {
        return f2544w.release(c0309f);
    }

    public int getTabCount() {
        return this.f2582x.size();
    }

    /* JADX INFO: renamed from: a */
    public C0309f m2834a(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.f2582x.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.f2583y != null) {
            return this.f2583y.m2873c();
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public void m2847c() {
        for (int childCount = this.f2545A.getChildCount() - 1; childCount >= 0; childCount--) {
            m2822c(childCount);
        }
        Iterator<C0309f> it = this.f2582x.iterator();
        while (it.hasNext()) {
            C0309f next = it.next();
            it.remove();
            next.m2878h();
            m2846b(next);
        }
        this.f2583y = null;
    }

    public void setTabMode(int i) {
        if (i != this.f2577r) {
            this.f2577r = i;
            m2831h();
        }
    }

    public int getTabMode() {
        return this.f2577r;
    }

    public void setTabGravity(int i) {
        if (this.f2574o != i) {
            this.f2574o = i;
            m2831h();
        }
    }

    public int getTabGravity() {
        return this.f2574o;
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.f2576q != i) {
            this.f2576q = i;
            ViewCompat.postInvalidateOnAnimation(this.f2545A);
        }
    }

    public int getTabIndicatorGravity() {
        return this.f2576q;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.f2579t = z;
        ViewCompat.postInvalidateOnAnimation(this.f2545A);
    }

    public void setInlineLabel(boolean z) {
        if (this.f2578s != z) {
            this.f2578s = z;
            for (int i = 0; i < this.f2545A.getChildCount(); i++) {
                View childAt = this.f2545A.getChildAt(i);
                if (childAt instanceof C0310g) {
                    ((C0310g) childAt).m2890c();
                }
            }
            m2831h();
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    public void setUnboundedRipple(boolean z) {
        if (this.f2580u != z) {
            this.f2580u = z;
            for (int i = 0; i < this.f2545A.getChildCount(); i++) {
                View childAt = this.f2545A.getChildAt(i);
                if (childAt instanceof C0310g) {
                    ((C0310g) childAt).m2881a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f2565f != colorStateList) {
            this.f2565f = colorStateList;
            m2825e();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f2565f;
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(m2815a(i, i2));
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f2566g != colorStateList) {
            this.f2566g = colorStateList;
            m2825e();
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(C1684ee.m8972a(getContext(), i));
    }

    public ColorStateList getTabIconTint() {
        return this.f2566g;
    }

    public ColorStateList getTabRippleColor() {
        return this.f2567h;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f2567h != colorStateList) {
            this.f2567h = colorStateList;
            for (int i = 0; i < this.f2545A.getChildCount(); i++) {
                View childAt = this.f2545A.getChildAt(i);
                if (childAt instanceof C0310g) {
                    ((C0310g) childAt).m2881a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(C1684ee.m8972a(getContext(), i));
    }

    public Drawable getTabSelectedIndicator() {
        return this.f2568i;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f2568i != drawable) {
            this.f2568i = drawable;
            ViewCompat.postInvalidateOnAnimation(this.f2545A);
        }
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(C1684ee.m8975b(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        m2819a(viewPager, z, false);
    }

    /* JADX INFO: renamed from: a */
    private void m2819a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.f2581v != null) {
            if (this.f2556L != null) {
                this.f2581v.removeOnPageChangeListener(this.f2556L);
            }
            if (this.f2557M != null) {
                this.f2581v.removeOnAdapterChangeListener(this.f2557M);
            }
        }
        if (this.f2552H != null) {
            m2844b(this.f2552H);
            this.f2552H = null;
        }
        if (viewPager != null) {
            this.f2581v = viewPager;
            if (this.f2556L == null) {
                this.f2556L = new TabLayoutOnPageChangeListener(this);
            }
            this.f2556L.m2850a();
            viewPager.addOnPageChangeListener(this.f2556L);
            this.f2552H = new C0311h(viewPager);
            m2836a(this.f2552H);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                m2840a(adapter, z);
            }
            if (this.f2557M == null) {
                this.f2557M = new C0304a();
            }
            this.f2557M.m2851a(z);
            viewPager.addOnAdapterChangeListener(this.f2557M);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f2581v = null;
            m2840a((PagerAdapter) null, false);
        }
        this.f2558N = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        m2840a(pagerAdapter, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2581v == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m2819a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2558N) {
            setupWithViewPager(null);
            this.f2558N = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f2545A.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* JADX INFO: renamed from: a */
    void m2840a(PagerAdapter pagerAdapter, boolean z) {
        if (this.f2554J != null && this.f2555K != null) {
            this.f2554J.unregisterDataSetObserver(this.f2555K);
        }
        this.f2554J = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.f2555K == null) {
                this.f2555K = new C0307d();
            }
            pagerAdapter.registerDataSetObserver(this.f2555K);
        }
        m2849d();
    }

    /* JADX INFO: renamed from: d */
    void m2849d() {
        int currentItem;
        m2847c();
        if (this.f2554J != null) {
            int count = this.f2554J.getCount();
            for (int i = 0; i < count; i++) {
                m2839a(m2833a().m2868a(this.f2554J.getPageTitle(i)), false);
            }
            if (this.f2581v == null || count <= 0 || (currentItem = this.f2581v.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            m2848c(m2834a(currentItem));
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2825e() {
        int size = this.f2582x.size();
        for (int i = 0; i < size; i++) {
            this.f2582x.get(i).m2877g();
        }
    }

    /* JADX INFO: renamed from: d */
    private C0310g m2823d(C0309f c0309f) {
        C0310g c0310gAcquire = this.f2559O != null ? this.f2559O.acquire() : null;
        if (c0310gAcquire == null) {
            c0310gAcquire = new C0310g(getContext());
        }
        c0310gAcquire.m2888a(c0309f);
        c0310gAcquire.setFocusable(true);
        c0310gAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(c0309f.f2614f)) {
            c0310gAcquire.setContentDescription(c0309f.f2613e);
        } else {
            c0310gAcquire.setContentDescription(c0309f.f2614f);
        }
        return c0310gAcquire;
    }

    /* JADX INFO: renamed from: a */
    private void m2818a(C0309f c0309f, int i) {
        c0309f.m2872b(i);
        this.f2582x.add(i, c0309f);
        int size = this.f2582x.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.f2582x.get(i).m2872b(i);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2826e(C0309f c0309f) {
        this.f2545A.addView(c0309f.f2610b, c0309f.m2873c(), m2827f());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m2820a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        m2820a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m2820a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m2820a(view);
    }

    /* JADX INFO: renamed from: a */
    private void m2820a(View view) {
        if (view instanceof TabItem) {
            m2817a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* JADX INFO: renamed from: f */
    private LinearLayout.LayoutParams m2827f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        m2821a(layoutParams);
        return layoutParams;
    }

    /* JADX INFO: renamed from: a */
    private void m2821a(LinearLayout.LayoutParams layoutParams) {
        if (this.f2577r == 1 && this.f2574o == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    /* JADX INFO: renamed from: b */
    int m2842b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < this.f2545A.getChildCount(); i++) {
            View childAt = this.f2545A.getChildAt(i);
            if (childAt instanceof C0310g) {
                ((C0310g) childAt).m2882a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.m2842b(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L24
            if (r1 == 0) goto L1f
            goto L30
        L1f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L30
        L24:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L30:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L4a
            int r1 = r5.f2547C
            if (r1 <= 0) goto L41
            int r0 = r5.f2547C
            goto L48
        L41:
            r1 = 56
            int r1 = r5.m2842b(r1)
            int r0 = r0 - r1
        L48:
            r5.f2573n = r0
        L4a:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L96
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.f2577r
            switch(r2) {
                case 0: goto L6b;
                case 1: goto L5f;
                default: goto L5e;
            }
        L5e:
            goto L76
        L5f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L76
        L69:
            r6 = 1
            goto L76
        L6b:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L76
            goto L69
        L76:
            if (r6 == 0) goto L96
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: renamed from: c */
    private void m2822c(int i) {
        C0310g c0310g = (C0310g) this.f2545A.getChildAt(i);
        this.f2545A.removeViewAt(i);
        if (c0310g != null) {
            c0310g.m2887a();
            this.f2559O.release(c0310g);
        }
        requestLayout();
    }

    /* JADX INFO: renamed from: d */
    private void m2824d(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.f2545A.m2860a()) {
            setScrollPosition(i, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iM2814a = m2814a(i, 0.0f);
        if (scrollX != iM2814a) {
            m2829g();
            this.f2553I.setIntValues(scrollX, iM2814a);
            this.f2553I.start();
        }
        this.f2545A.m2862b(i, this.f2575p);
    }

    /* JADX INFO: renamed from: g */
    private void m2829g() {
        if (this.f2553I == null) {
            this.f2553I = new ValueAnimator();
            this.f2553I.setInterpolator(C2178v.f13000b);
            this.f2553I.setDuration(this.f2575p);
            this.f2553I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        m2829g();
        this.f2553I.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f2545A.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.f2545A.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m2848c(C0309f c0309f) {
        m2845b(c0309f, true);
    }

    /* JADX INFO: renamed from: b */
    void m2845b(C0309f c0309f, boolean z) {
        C0309f c0309f2 = this.f2583y;
        if (c0309f2 == c0309f) {
            if (c0309f2 != null) {
                m2832h(c0309f);
                m2824d(c0309f.m2873c());
                return;
            }
            return;
        }
        int iM2873c = c0309f != null ? c0309f.m2873c() : -1;
        if (z) {
            if ((c0309f2 == null || c0309f2.m2873c() == -1) && iM2873c != -1) {
                setScrollPosition(iM2873c, 0.0f, true);
            } else {
                m2824d(iM2873c);
            }
            if (iM2873c != -1) {
                setSelectedTabView(iM2873c);
            }
        }
        this.f2583y = c0309f;
        if (c0309f2 != null) {
            m2830g(c0309f2);
        }
        if (c0309f != null) {
            m2828f(c0309f);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m2828f(C0309f c0309f) {
        for (int size = this.f2551G.size() - 1; size >= 0; size--) {
            this.f2551G.get(size).mo2852a(c0309f);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2830g(C0309f c0309f) {
        for (int size = this.f2551G.size() - 1; size >= 0; size--) {
            this.f2551G.get(size).mo2853b(c0309f);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m2832h(C0309f c0309f) {
        for (int size = this.f2551G.size() - 1; size >= 0; size--) {
            this.f2551G.get(size).mo2854c(c0309f);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m2814a(int i, float f) {
        if (this.f2577r != 0) {
            return 0;
        }
        View childAt = this.f2545A.getChildAt(i);
        int i2 = i + 1;
        View childAt2 = i2 < this.f2545A.getChildCount() ? this.f2545A.getChildAt(i2) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i3 = (int) ((width + width2) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i3 : left - i3;
    }

    /* JADX INFO: renamed from: h */
    private void m2831h() {
        ViewCompat.setPaddingRelative(this.f2545A, this.f2577r == 0 ? Math.max(0, this.f2549E - this.f2560a) : 0, 0, 0, 0);
        switch (this.f2577r) {
            case 0:
                this.f2545A.setGravity(GravityCompat.START);
                break;
            case 1:
                this.f2545A.setGravity(1);
                break;
        }
        m2841a(true);
    }

    /* JADX INFO: renamed from: a */
    void m2841a(boolean z) {
        for (int i = 0; i < this.f2545A.getChildCount(); i++) {
            View childAt = this.f2545A.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m2821a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$f */
    public static class C0309f {

        /* JADX INFO: renamed from: a */
        public TabLayout f2609a;

        /* JADX INFO: renamed from: b */
        public C0310g f2610b;

        /* JADX INFO: renamed from: c */
        private Object f2611c;

        /* JADX INFO: renamed from: d */
        private Drawable f2612d;

        /* JADX INFO: renamed from: e */
        private CharSequence f2613e;

        /* JADX INFO: renamed from: f */
        private CharSequence f2614f;

        /* JADX INFO: renamed from: g */
        private int f2615g = -1;

        /* JADX INFO: renamed from: h */
        private View f2616h;

        /* JADX INFO: renamed from: a */
        public View m2869a() {
            return this.f2616h;
        }

        /* JADX INFO: renamed from: a */
        public C0309f m2867a(View view) {
            this.f2616h = view;
            m2877g();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0309f m2865a(int i) {
            return m2867a(LayoutInflater.from(this.f2610b.getContext()).inflate(i, (ViewGroup) this.f2610b, false));
        }

        /* JADX INFO: renamed from: b */
        public Drawable m2870b() {
            return this.f2612d;
        }

        /* JADX INFO: renamed from: c */
        public int m2873c() {
            return this.f2615g;
        }

        /* JADX INFO: renamed from: b */
        void m2872b(int i) {
            this.f2615g = i;
        }

        /* JADX INFO: renamed from: d */
        public CharSequence m2874d() {
            return this.f2613e;
        }

        /* JADX INFO: renamed from: a */
        public C0309f m2866a(Drawable drawable) {
            this.f2612d = drawable;
            m2877g();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0309f m2868a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f2614f) && !TextUtils.isEmpty(charSequence)) {
                this.f2610b.setContentDescription(charSequence);
            }
            this.f2613e = charSequence;
            m2877g();
            return this;
        }

        /* JADX INFO: renamed from: e */
        public void m2875e() {
            if (this.f2609a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f2609a.m2848c(this);
        }

        /* JADX INFO: renamed from: f */
        public boolean m2876f() {
            if (this.f2609a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.f2609a.getSelectedTabPosition() == this.f2615g;
        }

        /* JADX INFO: renamed from: b */
        public C0309f m2871b(CharSequence charSequence) {
            this.f2614f = charSequence;
            m2877g();
            return this;
        }

        /* JADX INFO: renamed from: g */
        void m2877g() {
            if (this.f2610b != null) {
                this.f2610b.m2889b();
            }
        }

        /* JADX INFO: renamed from: h */
        void m2878h() {
            this.f2609a = null;
            this.f2610b = null;
            this.f2611c = null;
            this.f2612d = null;
            this.f2613e = null;
            this.f2614f = null;
            this.f2615g = -1;
            this.f2616h = null;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$g */
    class C0310g extends LinearLayout {

        /* JADX INFO: renamed from: b */
        private C0309f f2618b;

        /* JADX INFO: renamed from: c */
        private TextView f2619c;

        /* JADX INFO: renamed from: d */
        private ImageView f2620d;

        /* JADX INFO: renamed from: e */
        private View f2621e;

        /* JADX INFO: renamed from: f */
        private TextView f2622f;

        /* JADX INFO: renamed from: g */
        private ImageView f2623g;

        /* JADX INFO: renamed from: h */
        private Drawable f2624h;

        /* JADX INFO: renamed from: i */
        private int f2625i;

        public C0310g(Context context) {
            super(context);
            this.f2625i = 2;
            m2881a(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f2560a, TabLayout.this.f2561b, TabLayout.this.f2562c, TabLayout.this.f2563d);
            setGravity(17);
            setOrientation(!TabLayout.this.f2578s ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m2881a(Context context) {
            if (TabLayout.this.f2572m != 0) {
                this.f2624h = C1684ee.m8975b(context, TabLayout.this.f2572m);
                if (this.f2624h != null && this.f2624h.isStateful()) {
                    this.f2624h.setState(getDrawableState());
                }
            } else {
                this.f2624h = null;
            }
            Drawable gradientDrawable = new GradientDrawable();
            ((GradientDrawable) gradientDrawable).setColor(0);
            if (TabLayout.this.f2567h != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListM5493a = C0756ay.m5493a(TabLayout.this.f2567h);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.f2580u) {
                        gradientDrawable = null;
                    }
                    if (TabLayout.this.f2580u) {
                        gradientDrawable2 = null;
                    }
                    gradientDrawable = new RippleDrawable(colorStateListM5493a, gradientDrawable, gradientDrawable2);
                } else {
                    Drawable drawableWrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(drawableWrap, colorStateListM5493a);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableWrap});
                }
            }
            ViewCompat.setBackground(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m2882a(Canvas canvas) {
            if (this.f2624h != null) {
                this.f2624h.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f2624h.draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            boolean state = false;
            if (this.f2624h != null && this.f2624h.isStateful()) {
                state = false | this.f2624h.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f2618b == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f2618b.m2875e();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f2619c != null) {
                this.f2619c.setSelected(z);
            }
            if (this.f2620d != null) {
                this.f2620d.setSelected(z);
            }
            if (this.f2621e != null) {
                this.f2621e.setSelected(z);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.AbstractC0525b.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.AbstractC0525b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f2573n, ExploreByTouchHelper.INVALID_ID);
            }
            super.onMeasure(i, i2);
            if (this.f2619c != null) {
                float f = TabLayout.this.f2570k;
                int i3 = this.f2625i;
                boolean z = true;
                if (this.f2620d != null && this.f2620d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.f2619c != null && this.f2619c.getLineCount() > 1) {
                    f = TabLayout.this.f2571l;
                }
                float textSize = this.f2619c.getTextSize();
                int lineCount = this.f2619c.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f2619c);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.f2577r == 1 && f > textSize && lineCount == 1 && ((layout = this.f2619c.getLayout()) == null || m2879a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f2619c.setTextSize(0, f);
                        this.f2619c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m2888a(C0309f c0309f) {
            if (c0309f != this.f2618b) {
                this.f2618b = c0309f;
                m2889b();
            }
        }

        /* JADX INFO: renamed from: a */
        void m2887a() {
            m2888a((C0309f) null);
            setSelected(false);
        }

        /* JADX INFO: renamed from: b */
        final void m2889b() {
            C0309f c0309f = this.f2618b;
            Drawable drawableMutate = null;
            View viewM2869a = c0309f != null ? c0309f.m2869a() : null;
            if (viewM2869a != null) {
                ViewParent parent = viewM2869a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM2869a);
                    }
                    addView(viewM2869a);
                }
                this.f2621e = viewM2869a;
                if (this.f2619c != null) {
                    this.f2619c.setVisibility(8);
                }
                if (this.f2620d != null) {
                    this.f2620d.setVisibility(8);
                    this.f2620d.setImageDrawable(null);
                }
                this.f2622f = (TextView) viewM2869a.findViewById(android.R.id.text1);
                if (this.f2622f != null) {
                    this.f2625i = TextViewCompat.getMaxLines(this.f2622f);
                }
                this.f2623g = (ImageView) viewM2869a.findViewById(android.R.id.icon);
            } else {
                if (this.f2621e != null) {
                    removeView(this.f2621e);
                    this.f2621e = null;
                }
                this.f2622f = null;
                this.f2623g = null;
            }
            boolean z = false;
            if (this.f2621e == null) {
                if (this.f2620d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.f2620d = imageView;
                }
                if (c0309f != null && c0309f.m2870b() != null) {
                    drawableMutate = DrawableCompat.wrap(c0309f.m2870b()).mutate();
                }
                if (drawableMutate != null) {
                    DrawableCompat.setTintList(drawableMutate, TabLayout.this.f2566g);
                    if (TabLayout.this.f2569j != null) {
                        DrawableCompat.setTintMode(drawableMutate, TabLayout.this.f2569j);
                    }
                }
                if (this.f2619c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.f2619c = textView;
                    this.f2625i = TextViewCompat.getMaxLines(this.f2619c);
                }
                TextViewCompat.setTextAppearance(this.f2619c, TabLayout.this.f2564e);
                if (TabLayout.this.f2565f != null) {
                    this.f2619c.setTextColor(TabLayout.this.f2565f);
                }
                m2885a(this.f2619c, this.f2620d);
            } else if (this.f2622f != null || this.f2623g != null) {
                m2885a(this.f2622f, this.f2623g);
            }
            if (c0309f != null && !TextUtils.isEmpty(c0309f.f2614f)) {
                setContentDescription(c0309f.f2614f);
            }
            if (c0309f != null && c0309f.m2876f()) {
                z = true;
            }
            setSelected(z);
        }

        /* JADX INFO: renamed from: c */
        final void m2890c() {
            setOrientation(!TabLayout.this.f2578s ? 1 : 0);
            if (this.f2622f != null || this.f2623g != null) {
                m2885a(this.f2622f, this.f2623g);
            } else {
                m2885a(this.f2619c, this.f2620d);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m2885a(TextView textView, ImageView imageView) {
            Drawable drawableMutate = (this.f2618b == null || this.f2618b.m2870b() == null) ? null : DrawableCompat.wrap(this.f2618b.m2870b()).mutate();
            CharSequence charSequenceM2874d = this.f2618b != null ? this.f2618b.m2874d() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceM2874d);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceM2874d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iM2842b = (z && imageView.getVisibility() == 0) ? TabLayout.this.m2842b(8) : 0;
                if (TabLayout.this.f2578s) {
                    if (iM2842b != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, iM2842b);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iM2842b != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iM2842b;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            CharSequence charSequence = this.f2618b != null ? this.f2618b.f2614f : null;
            if (z) {
                charSequence = null;
            }
            C1768hf.m9634a(this, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: d */
        public int m2886d() {
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (View view : new View[]{this.f2619c, this.f2620d, this.f2621e}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        /* JADX INFO: renamed from: a */
        private float m2879a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$e */
    class C0308e extends LinearLayout {

        /* JADX INFO: renamed from: a */
        int f2592a;

        /* JADX INFO: renamed from: b */
        float f2593b;

        /* JADX INFO: renamed from: d */
        private int f2595d;

        /* JADX INFO: renamed from: e */
        private final Paint f2596e;

        /* JADX INFO: renamed from: f */
        private final GradientDrawable f2597f;

        /* JADX INFO: renamed from: g */
        private int f2598g;

        /* JADX INFO: renamed from: h */
        private int f2599h;

        /* JADX INFO: renamed from: i */
        private int f2600i;

        /* JADX INFO: renamed from: j */
        private ValueAnimator f2601j;

        C0308e(Context context) {
            super(context);
            this.f2592a = -1;
            this.f2598g = -1;
            this.f2599h = -1;
            this.f2600i = -1;
            setWillNotDraw(false);
            this.f2596e = new Paint();
            this.f2597f = new GradientDrawable();
        }

        /* JADX INFO: renamed from: a */
        void m2857a(int i) {
            if (this.f2596e.getColor() != i) {
                this.f2596e.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* JADX INFO: renamed from: b */
        void m2861b(int i) {
            if (this.f2595d != i) {
                this.f2595d = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m2860a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        void m2858a(int i, float f) {
            if (this.f2601j != null && this.f2601j.isRunning()) {
                this.f2601j.cancel();
            }
            this.f2592a = i;
            this.f2593b = f;
            m2856b();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.f2598g == i) {
                return;
            }
            requestLayout();
            this.f2598g = i;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            boolean z = true;
            if (TabLayout.this.f2577r == 1 && TabLayout.this.f2574o == 1) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (TabLayout.this.m2842b(16) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout.this.f2574o = 0;
                    TabLayout.this.m2841a(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f2601j != null && this.f2601j.isRunning()) {
                this.f2601j.cancel();
                m2862b(this.f2592a, Math.round((1.0f - this.f2601j.getAnimatedFraction()) * this.f2601j.getDuration()));
                return;
            }
            m2856b();
        }

        /* JADX INFO: renamed from: b */
        private void m2856b() {
            int left;
            int right;
            View childAt = getChildAt(this.f2592a);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (!TabLayout.this.f2579t && (childAt instanceof C0310g)) {
                    m2855a((C0310g) childAt, TabLayout.this.f2584z);
                    left = (int) TabLayout.this.f2584z.left;
                    right = (int) TabLayout.this.f2584z.right;
                }
                if (this.f2593b > 0.0f && this.f2592a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f2592a + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    if (!TabLayout.this.f2579t && (childAt2 instanceof C0310g)) {
                        m2855a((C0310g) childAt2, TabLayout.this.f2584z);
                        left2 = (int) TabLayout.this.f2584z.left;
                        right2 = (int) TabLayout.this.f2584z.right;
                    }
                    left = (int) ((this.f2593b * left2) + ((1.0f - this.f2593b) * left));
                    right = (int) ((this.f2593b * right2) + ((1.0f - this.f2593b) * right));
                }
            }
            m2859a(left, right);
        }

        /* JADX INFO: renamed from: a */
        void m2859a(int i, int i2) {
            if (i == this.f2599h && i2 == this.f2600i) {
                return;
            }
            this.f2599h = i;
            this.f2600i = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* JADX INFO: renamed from: b */
        void m2862b(final int i, int i2) {
            if (this.f2601j != null && this.f2601j.isRunning()) {
                this.f2601j.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                m2856b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (!TabLayout.this.f2579t && (childAt instanceof C0310g)) {
                m2855a((C0310g) childAt, TabLayout.this.f2584z);
                left = (int) TabLayout.this.f2584z.left;
                right = (int) TabLayout.this.f2584z.right;
            }
            final int i3 = left;
            final int i4 = right;
            final int i5 = this.f2599h;
            final int i6 = this.f2600i;
            if (i5 == i3 && i6 == i4) {
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f2601j = valueAnimator;
            valueAnimator.setInterpolator(C2178v.f13000b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TabLayout.e.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float animatedFraction = valueAnimator2.getAnimatedFraction();
                    C0308e.this.m2859a(C2178v.m11882a(i5, i3, animatedFraction), C2178v.m11882a(i6, i4, animatedFraction));
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.TabLayout.e.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0308e.this.f2592a = i;
                    C0308e.this.f2593b = 0.0f;
                }
            });
            valueAnimator.start();
        }

        /* JADX INFO: renamed from: a */
        private void m2855a(C0310g c0310g, RectF rectF) {
            int iM2886d = c0310g.m2886d();
            if (iM2886d < TabLayout.this.m2842b(24)) {
                iM2886d = TabLayout.this.m2842b(24);
            }
            int left = (c0310g.getLeft() + c0310g.getRight()) / 2;
            int i = iM2886d / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height = 0;
            int intrinsicHeight = TabLayout.this.f2568i != null ? TabLayout.this.f2568i.getIntrinsicHeight() : 0;
            if (this.f2595d >= 0) {
                intrinsicHeight = this.f2595d;
            }
            switch (TabLayout.this.f2576q) {
                case 0:
                    height = getHeight() - intrinsicHeight;
                    intrinsicHeight = getHeight();
                    break;
                case 1:
                    height = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                    break;
                case 2:
                    break;
                case 3:
                    intrinsicHeight = getHeight();
                    break;
                default:
                    intrinsicHeight = 0;
                    break;
            }
            if (this.f2599h >= 0 && this.f2600i > this.f2599h) {
                Drawable drawableWrap = DrawableCompat.wrap(TabLayout.this.f2568i != null ? TabLayout.this.f2568i : this.f2597f);
                drawableWrap.setBounds(this.f2599h, height, this.f2600i, intrinsicHeight);
                if (this.f2596e != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        drawableWrap.setColorFilter(this.f2596e.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawableWrap, this.f2596e.getColor());
                    }
                }
                drawableWrap.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    /* JADX INFO: renamed from: a */
    private static ColorStateList m2815a(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getDefaultHeight() {
        int size = this.f2582x.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                C0309f c0309f = this.f2582x.get(i);
                if (c0309f != null && c0309f.m2870b() != null && !TextUtils.isEmpty(c0309f.m2874d())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return (!z || this.f2578s) ? 48 : 72;
    }

    private int getTabMinWidth() {
        if (this.f2546B != -1) {
            return this.f2546B;
        }
        if (this.f2577r == 0) {
            return this.f2548D;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.f2573n;
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a */
        private final WeakReference<TabLayout> f2586a;

        /* JADX INFO: renamed from: b */
        private int f2587b;

        /* JADX INFO: renamed from: c */
        private int f2588c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f2586a = new WeakReference<>(tabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f2587b = this.f2588c;
            this.f2588c = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.f2586a.get();
            if (tabLayout != null) {
                tabLayout.m2835a(i, f, this.f2588c != 2 || this.f2587b == 1, (this.f2588c == 2 && this.f2587b == 0) ? false : true);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.f2586a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            tabLayout.m2845b(tabLayout.m2834a(i), this.f2588c == 0 || (this.f2588c == 2 && this.f2587b == 0));
        }

        /* JADX INFO: renamed from: a */
        void m2850a() {
            this.f2588c = 0;
            this.f2587b = 0;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$h */
    public static class C0311h implements InterfaceC0306c {

        /* JADX INFO: renamed from: a */
        private final ViewPager f2626a;

        @Override // android.support.design.widget.TabLayout.InterfaceC0305b
        /* JADX INFO: renamed from: b */
        public void mo2853b(C0309f c0309f) {
        }

        @Override // android.support.design.widget.TabLayout.InterfaceC0305b
        /* JADX INFO: renamed from: c */
        public void mo2854c(C0309f c0309f) {
        }

        public C0311h(ViewPager viewPager) {
            this.f2626a = viewPager;
        }

        @Override // android.support.design.widget.TabLayout.InterfaceC0305b
        /* JADX INFO: renamed from: a */
        public void mo2852a(C0309f c0309f) {
            this.f2626a.setCurrentItem(c0309f.m2873c());
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$d */
    class C0307d extends DataSetObserver {
        C0307d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.m2849d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.m2849d();
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.TabLayout$a */
    class C0304a implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: b */
        private boolean f2590b;

        C0304a() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TabLayout.this.f2581v == viewPager) {
                TabLayout.this.m2840a(pagerAdapter2, this.f2590b);
            }
        }

        /* JADX INFO: renamed from: a */
        void m2851a(boolean z) {
            this.f2590b = z;
        }
    }
}
