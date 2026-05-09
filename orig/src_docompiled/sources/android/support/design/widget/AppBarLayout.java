package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p000.C0751at;
import p000.C0779bu;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.InterfaceC0288b(m2728a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private int f2298a;

    /* JADX INFO: renamed from: b */
    private int f2299b;

    /* JADX INFO: renamed from: c */
    private int f2300c;

    /* JADX INFO: renamed from: d */
    private boolean f2301d;

    /* JADX INFO: renamed from: e */
    private int f2302e;

    /* JADX INFO: renamed from: f */
    private WindowInsetsCompat f2303f;

    /* JADX INFO: renamed from: g */
    private List<InterfaceC0257a> f2304g;

    /* JADX INFO: renamed from: h */
    private boolean f2305h;

    /* JADX INFO: renamed from: i */
    private boolean f2306i;

    /* JADX INFO: renamed from: j */
    private boolean f2307j;

    /* JADX INFO: renamed from: k */
    private boolean f2308k;

    /* JADX INFO: renamed from: l */
    private int[] f2309l;

    /* JADX INFO: renamed from: android.support.design.widget.AppBarLayout$a */
    public interface InterfaceC0257a<T extends AppBarLayout> {
        /* JADX INFO: renamed from: a */
        void mo2588a(T t, int i);
    }

    /* JADX INFO: renamed from: android.support.design.widget.AppBarLayout$b */
    public interface InterfaceC0258b extends InterfaceC0257a<AppBarLayout> {
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2298a = -1;
        this.f2299b = -1;
        this.f2300c = -1;
        this.f2302e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            C0779bu.m5713a(this);
            C0779bu.m5715a(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout, new int[0]);
        ViewCompat.setBackground(this, typedArrayM5390a.getDrawable(R.styleable.AppBarLayout_android_background));
        if (typedArrayM5390a.hasValue(R.styleable.AppBarLayout_expanded)) {
            m2515a(typedArrayM5390a.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayM5390a.hasValue(R.styleable.AppBarLayout_elevation)) {
            C0779bu.m5714a(this, typedArrayM5390a.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayM5390a.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayM5390a.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayM5390a.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayM5390a.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f2308k = typedArrayM5390a.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        typedArrayM5390a.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.AppBarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.m2522a(windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m2524a(InterfaceC0257a interfaceC0257a) {
        if (this.f2304g == null) {
            this.f2304g = new ArrayList();
        }
        if (interfaceC0257a == null || this.f2304g.contains(interfaceC0257a)) {
            return;
        }
        this.f2304g.add(interfaceC0257a);
    }

    /* JADX INFO: renamed from: a */
    public void m2525a(InterfaceC0258b interfaceC0258b) {
        m2524a((InterfaceC0257a) interfaceC0258b);
    }

    /* JADX INFO: renamed from: b */
    public void m2527b(InterfaceC0257a interfaceC0257a) {
        if (this.f2304g == null || interfaceC0257a == null) {
            return;
        }
        this.f2304g.remove(interfaceC0257a);
    }

    /* JADX INFO: renamed from: b */
    public void m2528b(InterfaceC0258b interfaceC0258b) {
        m2527b((InterfaceC0257a) interfaceC0258b);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m2518g();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m2518g();
        this.f2301d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).m2578b() != null) {
                this.f2301d = true;
                break;
            }
            i5++;
        }
        if (this.f2305h) {
            return;
        }
        m2516b(this.f2308k || m2517f());
    }

    /* JADX INFO: renamed from: f */
    private boolean m2517f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).m2579c()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    private void m2518g() {
        this.f2298a = -1;
        this.f2299b = -1;
        this.f2300c = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        m2515a(z, z2, true);
    }

    /* JADX INFO: renamed from: a */
    private void m2515a(boolean z, boolean z2, boolean z3) {
        this.f2302e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: b */
    boolean m2529b() {
        return this.f2301d;
    }

    public final int getTotalScrollRange() {
        if (this.f2298a != -1) {
            return this.f2298a;
        }
        int childCount = getChildCount();
        int i = 0;
        int minimumHeight = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = layoutParams.f2325a;
            if ((i2 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((i2 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i++;
        }
        int iMax = Math.max(0, minimumHeight - getTopInset());
        this.f2298a = iMax;
        return iMax;
    }

    /* JADX INFO: renamed from: c */
    boolean m2530c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.f2299b != -1) {
            return this.f2299b;
        }
        int topInset = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = layoutParams.f2325a;
            if ((i & 5) != 5) {
                if (topInset > 0) {
                    break;
                }
            } else {
                int i2 = topInset + layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i & 8) != 0) {
                    topInset = i2 + ViewCompat.getMinimumHeight(childAt);
                } else if ((i & 2) != 0) {
                    topInset = i2 + (measuredHeight - ViewCompat.getMinimumHeight(childAt));
                } else {
                    topInset = i2 + (measuredHeight - getTopInset());
                }
            }
        }
        int iMax = Math.max(0, topInset);
        this.f2299b = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        if (this.f2300c != -1) {
            return this.f2300c;
        }
        int childCount = getChildCount();
        int i = 0;
        int minimumHeight = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i2 = layoutParams.f2325a;
            if ((i2 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i2 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                break;
            }
            i++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f2300c = iMax;
        return iMax;
    }

    /* JADX INFO: renamed from: a */
    void m2523a(int i) {
        if (this.f2304g != null) {
            int size = this.f2304g.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0257a interfaceC0257a = this.f2304g.get(i2);
                if (interfaceC0257a != null) {
                    interfaceC0257a.mo2588a(this, i);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
        return minimumHeight2 != 0 ? (minimumHeight2 * 2) + topInset : getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.f2309l == null) {
            this.f2309l = new int[4];
        }
        int[] iArr = this.f2309l;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f2306i ? R.attr.state_liftable : -R.attr.state_liftable;
        iArr[1] = (this.f2306i && this.f2307j) ? R.attr.state_lifted : -R.attr.state_lifted;
        iArr[2] = this.f2306i ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[3] = (this.f2306i && this.f2307j) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    /* JADX INFO: renamed from: b */
    private boolean m2516b(boolean z) {
        if (this.f2306i == z) {
            return false;
        }
        this.f2306i = z;
        refreshDrawableState();
        return true;
    }

    /* JADX INFO: renamed from: a */
    boolean m2526a(boolean z) {
        if (this.f2307j == z) {
            return false;
        }
        this.f2307j = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.f2308k = z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2531d() {
        return this.f2308k;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0779bu.m5714a(this, f);
        }
    }

    int getPendingAction() {
        return this.f2302e;
    }

    /* JADX INFO: renamed from: e */
    void m2532e() {
        this.f2302e = 0;
    }

    final int getTopInset() {
        if (this.f2303f != null) {
            return this.f2303f.getSystemWindowInsetTop();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    WindowInsetsCompat m2522a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f2303f, windowInsetsCompat2)) {
            this.f2303f = windowInsetsCompat2;
            m2518g();
        }
        return windowInsetsCompat;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f2325a;

        /* JADX INFO: renamed from: b */
        Interpolator f2326b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2325a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f2325a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f2326b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2325a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2325a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2325a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2325a = 1;
        }

        /* JADX INFO: renamed from: a */
        public int m2577a() {
            return this.f2325a;
        }

        /* JADX INFO: renamed from: b */
        public Interpolator m2578b() {
            return this.f2326b;
        }

        /* JADX INFO: renamed from: c */
        boolean m2579c() {
            return (this.f2325a & 1) == 1 && (this.f2325a & 10) != 0;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo2556a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.mo2556a(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo2557a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.mo2557a(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo2558a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.mo2558a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo2559a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.mo2559a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2575a(int i) {
            return super.mo2575a(i);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2208a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.mo2208a(coordinatorLayout, appBarLayout, i);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2564a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.mo2564a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2248a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.mo2248a(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ int mo2576b() {
            return super.mo2576b();
        }

        @Override // android.support.design.widget.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable mo2568b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.mo2568b(coordinatorLayout, appBarLayout);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* JADX INFO: renamed from: b */
        private int f2311b;

        /* JADX INFO: renamed from: c */
        private int f2312c;

        /* JADX INFO: renamed from: d */
        private ValueAnimator f2313d;

        /* JADX INFO: renamed from: e */
        private int f2314e;

        /* JADX INFO: renamed from: f */
        private boolean f2315f;

        /* JADX INFO: renamed from: g */
        private float f2316g;

        /* JADX INFO: renamed from: h */
        private WeakReference<View> f2317h;

        /* JADX INFO: renamed from: i */
        private AbstractC0256a f2318i;

        /* JADX INFO: renamed from: android.support.design.widget.AppBarLayout$BaseBehavior$a */
        public static abstract class AbstractC0256a<T extends AppBarLayout> {
            /* JADX INFO: renamed from: a */
            public abstract boolean m2574a(T t);
        }

        /* JADX INFO: renamed from: a */
        private static boolean m2540a(int i, int i2) {
            return (i & i2) == i2;
        }

        public BaseBehavior() {
            this.f2314e = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2314e = -1;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2248a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && (t.m2531d() || m2541a(coordinatorLayout, (AppBarLayout) t, view));
            if (z && this.f2313d != null) {
                this.f2313d.cancel();
            }
            this.f2317h = null;
            this.f2312c = i2;
            return z;
        }

        /* JADX INFO: renamed from: a */
        private boolean m2541a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.m2530c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2559a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i5 = -t.getTotalScrollRange();
                    i4 = i5;
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i5;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = m2787b(coordinatorLayout, t, i2, i4, downNestedPreScrollRange);
                    m2536a(i2, t, view, i3);
                }
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2558a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                m2787b(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
                m2536a(i4, t, view, i5);
            }
            if (t.m2531d()) {
                t.m2526a(view.getScrollY() > 0);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m2536a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int iMo2546a = mo2546a();
                if ((i >= 0 || iMo2546a != 0) && (i <= 0 || iMo2546a != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                ViewCompat.stopNestedScroll(view, 1);
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2557a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.f2312c == 0 || i == 1) {
                m2544c(coordinatorLayout, (AppBarLayout) t);
            }
            this.f2317h = new WeakReference<>(view);
        }

        /* JADX INFO: renamed from: a */
        private void m2537a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int iAbs = Math.abs(mo2546a() - i);
            float fAbs = Math.abs(f);
            if (fAbs > 0.0f) {
                height = Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f);
            }
            m2538a(coordinatorLayout, (AppBarLayout) t, i, height);
        }

        /* JADX INFO: renamed from: a */
        private void m2538a(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int iMo2546a = mo2546a();
            if (iMo2546a == i) {
                if (this.f2313d == null || !this.f2313d.isRunning()) {
                    return;
                }
                this.f2313d.cancel();
                return;
            }
            if (this.f2313d == null) {
                this.f2313d = new ValueAnimator();
                this.f2313d.setInterpolator(C2178v.f13003e);
                this.f2313d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.m2786a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.f2313d.cancel();
            }
            this.f2313d.setDuration(Math.min(i2, 600));
            this.f2313d.setIntValues(iMo2546a, i);
            this.f2313d.start();
        }

        /* JADX INFO: renamed from: a */
        private int m2534a(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m2540a(layoutParams.m2577a(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX INFO: renamed from: c */
        private void m2544c(CoordinatorLayout coordinatorLayout, T t) {
            int iMo2546a = mo2546a();
            int iM2534a = m2534a(t, iMo2546a);
            if (iM2534a >= 0) {
                View childAt = t.getChildAt(iM2534a);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iM2577a = layoutParams.m2577a();
                if ((iM2577a & 17) == 17) {
                    int i = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iM2534a == t.getChildCount() - 1) {
                        minimumHeight += t.getTopInset();
                    }
                    if (m2540a(iM2577a, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt);
                    } else if (m2540a(iM2577a, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                        if (iMo2546a < minimumHeight2) {
                            i = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (m2540a(iM2577a, 32)) {
                        i += layoutParams.topMargin;
                        minimumHeight -= layoutParams.bottomMargin;
                    }
                    if (iMo2546a < (minimumHeight + i) / 2) {
                        i = minimumHeight;
                    }
                    m2537a(coordinatorLayout, (AppBarLayout) t, MathUtils.clamp(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2564a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.C0290d) t.getLayoutParams()).height == -2) {
                coordinatorLayout.m2698a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.mo2564a(coordinatorLayout, t, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2208a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int iRound;
            boolean zA = super.mo2208a(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            if (this.f2314e >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(this.f2314e);
                int i2 = -childAt.getBottom();
                if (this.f2315f) {
                    iRound = i2 + ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                } else {
                    iRound = i2 + Math.round(childAt.getHeight() * this.f2316g);
                }
                m2786a_(coordinatorLayout, t, iRound);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        m2537a(coordinatorLayout, (AppBarLayout) t, i3, 0.0f);
                    } else {
                        m2786a_(coordinatorLayout, t, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m2537a(coordinatorLayout, (AppBarLayout) t, 0, 0.0f);
                    } else {
                        m2786a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.m2532e();
            this.f2314e = -1;
            mo2575a(MathUtils.clamp(mo2576b(), -t.getTotalScrollRange(), 0));
            m2539a(coordinatorLayout, (AppBarLayout) t, mo2576b(), 0, true);
            t.m2523a(mo2576b());
            return zA;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2570c(T t) {
            if (this.f2318i != null) {
                return this.f2318i.m2574a(t);
            }
            if (this.f2317h == null) {
                return true;
            }
            View view = this.f2317h.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2555a(CoordinatorLayout coordinatorLayout, T t) {
            m2544c(coordinatorLayout, (AppBarLayout) t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int mo2566b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int mo2549a(T t) {
            return t.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int mo2548a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int iMo2546a = mo2546a();
            int i4 = 0;
            if (i2 != 0 && iMo2546a >= i2 && iMo2546a <= i3) {
                int iClamp = MathUtils.clamp(i, i2, i3);
                if (iMo2546a != iClamp) {
                    int iM2542b = t.m2529b() ? m2542b(t, iClamp) : iClamp;
                    boolean zA = mo2575a(iM2542b);
                    i4 = iMo2546a - iClamp;
                    this.f2311b = iClamp - iM2542b;
                    if (!zA && t.m2529b()) {
                        coordinatorLayout.m2703b(t);
                    }
                    t.m2523a(mo2576b());
                    m2539a(coordinatorLayout, (AppBarLayout) t, iClamp, iClamp < iMo2546a ? -1 : 1, false);
                }
            } else {
                this.f2311b = 0;
            }
            return i4;
        }

        /* JADX INFO: renamed from: b */
        private int m2542b(T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorM2578b = layoutParams.m2578b();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (interpolatorM2578b != null) {
                    int iM2577a = layoutParams.m2577a();
                    if ((iM2577a & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((iM2577a & 2) != 0) {
                            topInset -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset > 0) {
                        float f = topInset;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorM2578b.getInterpolation((iAbs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void m2539a(android.support.design.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = m2543c(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                android.support.design.widget.AppBarLayout$LayoutParams r1 = (android.support.design.widget.AppBarLayout.LayoutParams) r1
                int r1 = r1.m2577a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = android.support.v4.view.ViewCompat.getMinimumHeight(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.m2531d()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.m2535a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = 1
                goto L57
            L56:
                r8 = 0
            L57:
                boolean r8 = r7.m2526a(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.m2545d(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.BaseBehavior.m2539a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        /* JADX INFO: renamed from: d */
        private boolean m2545d(CoordinatorLayout coordinatorLayout, T t) {
            List<View> listM2708d = coordinatorLayout.m2708d(t);
            int size = listM2708d.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behaviorM2740b = ((CoordinatorLayout.C0290d) listM2708d.get(i).getLayoutParams()).m2740b();
                if (behaviorM2740b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorM2740b).m2793d() != 0;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: c */
        private static View m2543c(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        private View m2535a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof NestedScrollingChild) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a */
        int mo2546a() {
            return mo2576b() + this.f2311b;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable mo2568b(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable parcelableB = super.mo2568b(coordinatorLayout, t);
            int iB = mo2576b();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + iB;
                if (childAt.getTop() + iB <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableB);
                    savedState.f2322a = i;
                    savedState.f2324c = bottom == ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                    savedState.f2323b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableB;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2556a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo2556a(coordinatorLayout, t, savedState.getSuperState());
                this.f2314e = savedState.f2322a;
                this.f2316g = savedState.f2323b;
                this.f2315f = savedState.f2324c;
                return;
            }
            super.mo2556a(coordinatorLayout, t, parcelable);
            this.f2314e = -1;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f2322a;

            /* JADX INFO: renamed from: b */
            float f2323b;

            /* JADX INFO: renamed from: c */
            boolean f2324c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2322a = parcel.readInt();
                this.f2323b = parcel.readFloat();
                this.f2324c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f2322a);
                parcel.writeFloat(this.f2323b);
                parcel.writeByte(this.f2324c ? (byte) 1 : (byte) 0);
            }
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2575a(int i) {
            return super.mo2575a(i);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2208a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo2208a(coordinatorLayout, view, i);
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2564a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo2564a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ int mo2576b() {
            return super.mo2576b();
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: b */
        /* synthetic */ View mo2587b(List list) {
            return m2584a((List<View>) list);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            m2790b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public boolean mo2487a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b */
        public boolean mo2489b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m2581a(view, view2);
            m2582b(view, view2);
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public boolean mo2585a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutM2584a = m2584a(coordinatorLayout.m2706c(view));
            if (appBarLayoutM2584a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f2507a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutM2584a.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private void m2581a(View view, View view2) {
            CoordinatorLayout.Behavior behaviorM2740b = ((CoordinatorLayout.C0290d) view2.getLayoutParams()).m2740b();
            if (behaviorM2740b instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorM2740b).f2311b) + m2789a()) - m2792c(view2));
            }
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: a */
        float mo2583a(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iM2580a = m2580a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iM2580a > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iM2580a / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* JADX INFO: renamed from: a */
        private static int m2580a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorM2740b = ((CoordinatorLayout.C0290d) appBarLayout.getLayoutParams()).m2740b();
            if (behaviorM2740b instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorM2740b).mo2546a();
            }
            return 0;
        }

        /* JADX INFO: renamed from: a */
        AppBarLayout m2584a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: b */
        int mo2586b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo2586b(view);
        }

        /* JADX INFO: renamed from: b */
        private void m2582b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.m2531d()) {
                    appBarLayout.m2526a(view.getScrollY() > 0);
                }
            }
        }
    }
}
