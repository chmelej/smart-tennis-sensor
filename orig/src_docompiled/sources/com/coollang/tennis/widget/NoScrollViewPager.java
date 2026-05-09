package com.coollang.tennis.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class NoScrollViewPager extends ViewGroup {

    /* JADX INFO: renamed from: A */
    private int f8497A;

    /* JADX INFO: renamed from: B */
    private int f8498B;

    /* JADX INFO: renamed from: C */
    private int f8499C;

    /* JADX INFO: renamed from: D */
    private int f8500D;

    /* JADX INFO: renamed from: E */
    private int f8501E;

    /* JADX INFO: renamed from: F */
    private int f8502F;

    /* JADX INFO: renamed from: G */
    private int f8503G;

    /* JADX INFO: renamed from: H */
    private int f8504H;

    /* JADX INFO: renamed from: I */
    private int f8505I;

    /* JADX INFO: renamed from: J */
    private EdgeEffectCompat f8506J;

    /* JADX INFO: renamed from: K */
    private EdgeEffectCompat f8507K;

    /* JADX INFO: renamed from: L */
    private boolean f8508L;

    /* JADX INFO: renamed from: M */
    private boolean f8509M;

    /* JADX INFO: renamed from: N */
    private boolean f8510N;

    /* JADX INFO: renamed from: O */
    private int f8511O;

    /* JADX INFO: renamed from: P */
    private InterfaceC1356e f8512P;

    /* JADX INFO: renamed from: Q */
    private InterfaceC1356e f8513Q;

    /* JADX INFO: renamed from: R */
    private InterfaceC1355d f8514R;

    /* JADX INFO: renamed from: S */
    private InterfaceC1357f f8515S;

    /* JADX INFO: renamed from: T */
    private Method f8516T;

    /* JADX INFO: renamed from: U */
    private int f8517U;

    /* JADX INFO: renamed from: V */
    private ArrayList<View> f8518V;

    /* JADX INFO: renamed from: a */
    private boolean f8519a;

    /* JADX INFO: renamed from: aa */
    private final Runnable f8520aa;

    /* JADX INFO: renamed from: ab */
    private int f8521ab;

    /* JADX INFO: renamed from: c */
    private int f8522c;

    /* JADX INFO: renamed from: f */
    private final ArrayList<C1353b> f8523f;

    /* JADX INFO: renamed from: g */
    private final C1353b f8524g;

    /* JADX INFO: renamed from: h */
    private final Rect f8525h;

    /* JADX INFO: renamed from: i */
    private PagerAdapter f8526i;

    /* JADX INFO: renamed from: j */
    private int f8527j;

    /* JADX INFO: renamed from: k */
    private int f8528k;

    /* JADX INFO: renamed from: l */
    private Parcelable f8529l;

    /* JADX INFO: renamed from: m */
    private ClassLoader f8530m;

    /* JADX INFO: renamed from: n */
    private Scroller f8531n;

    /* JADX INFO: renamed from: o */
    private C1358g f8532o;

    /* JADX INFO: renamed from: p */
    private int f8533p;

    /* JADX INFO: renamed from: q */
    private Drawable f8534q;

    /* JADX INFO: renamed from: r */
    private int f8535r;

    /* JADX INFO: renamed from: s */
    private int f8536s;

    /* JADX INFO: renamed from: t */
    private float f8537t;

    /* JADX INFO: renamed from: u */
    private float f8538u;

    /* JADX INFO: renamed from: v */
    private int f8539v;

    /* JADX INFO: renamed from: w */
    private int f8540w;

    /* JADX INFO: renamed from: x */
    private boolean f8541x;

    /* JADX INFO: renamed from: y */
    private boolean f8542y;

    /* JADX INFO: renamed from: z */
    private boolean f8543z;

    /* JADX INFO: renamed from: b */
    private static final int[] f8494b = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: d */
    private static final Comparator<C1353b> f8495d = new Comparator<C1353b>() { // from class: com.coollang.tennis.widget.NoScrollViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1353b c1353b, C1353b c1353b2) {
            return c1353b.f8555b - c1353b2.f8555b;
        }
    };

    /* JADX INFO: renamed from: e */
    private static final Interpolator f8496e = new Interpolator() { // from class: com.coollang.tennis.widget.NoScrollViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: W */
    private static final C1359h f8493W = new C1359h();

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$a */
    interface InterfaceC1352a {
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$d */
    interface InterfaceC1355d {
        /* JADX INFO: renamed from: a */
        void m8228a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$e */
    public interface InterfaceC1356e {
        /* JADX INFO: renamed from: a */
        void m8229a(int i);

        /* JADX INFO: renamed from: a */
        void m8230a(int i, float f, int i2);

        /* JADX INFO: renamed from: b */
        void m8231b(int i);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$f */
    public interface InterfaceC1357f {
        /* JADX INFO: renamed from: a */
        void m8232a(View view, float f);
    }

    public void setScanScroll(boolean z) {
        this.f8519a = z;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8519a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8519a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$b */
    static class C1353b {

        /* JADX INFO: renamed from: a */
        Object f8554a;

        /* JADX INFO: renamed from: b */
        int f8555b;

        /* JADX INFO: renamed from: c */
        boolean f8556c;

        /* JADX INFO: renamed from: d */
        float f8557d;

        /* JADX INFO: renamed from: e */
        float f8558e;

        C1353b() {
        }
    }

    public NoScrollViewPager(Context context) {
        super(context);
        this.f8519a = false;
        this.f8523f = new ArrayList<>();
        this.f8524g = new C1353b();
        this.f8525h = new Rect();
        this.f8528k = -1;
        this.f8529l = null;
        this.f8530m = null;
        this.f8537t = -3.4028235E38f;
        this.f8538u = Float.MAX_VALUE;
        this.f8497A = 1;
        this.f8501E = -1;
        this.f8508L = true;
        this.f8509M = false;
        this.f8520aa = new Runnable() { // from class: com.coollang.tennis.widget.NoScrollViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                NoScrollViewPager.this.setScrollState(0);
                NoScrollViewPager.this.m8220c();
            }
        };
        this.f8521ab = 0;
        m8210a();
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8519a = false;
        this.f8523f = new ArrayList<>();
        this.f8524g = new C1353b();
        this.f8525h = new Rect();
        this.f8528k = -1;
        this.f8529l = null;
        this.f8530m = null;
        this.f8537t = -3.4028235E38f;
        this.f8538u = Float.MAX_VALUE;
        this.f8497A = 1;
        this.f8501E = -1;
        this.f8508L = true;
        this.f8509M = false;
        this.f8520aa = new Runnable() { // from class: com.coollang.tennis.widget.NoScrollViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                NoScrollViewPager.this.setScrollState(0);
                NoScrollViewPager.this.m8220c();
            }
        };
        this.f8521ab = 0;
        m8210a();
    }

    /* JADX INFO: renamed from: a */
    void m8210a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f8531n = new Scroller(context, new DecelerateInterpolator());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f8500D = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f8502F = (int) (400.0f * f);
        this.f8503G = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f8506J = new EdgeEffectCompat(context);
        this.f8507K = new EdgeEffectCompat(context);
        this.f8504H = (int) (25.0f * f);
        this.f8505I = (int) (2.0f * f);
        this.f8498B = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new C1354c());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f8520aa);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f8521ab == i) {
            return;
        }
        this.f8521ab = i;
        if (this.f8515S != null) {
            m8201b(i != 0);
        }
        if (this.f8512P != null) {
            this.f8512P.m8231b(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f8526i != null) {
            this.f8526i.unregisterDataSetObserver(this.f8532o);
            this.f8526i.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f8523f.size(); i++) {
                C1353b c1353b = this.f8523f.get(i);
                this.f8526i.destroyItem((ViewGroup) this, c1353b.f8555b, c1353b.f8554a);
            }
            this.f8526i.finishUpdate((ViewGroup) this);
            this.f8523f.clear();
            m8204g();
            this.f8527j = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f8526i;
        this.f8526i = pagerAdapter;
        this.f8522c = 0;
        if (this.f8526i != null) {
            if (this.f8532o == null) {
                this.f8532o = new C1358g();
            }
            this.f8526i.registerDataSetObserver(this.f8532o);
            this.f8543z = false;
            boolean z = this.f8508L;
            this.f8508L = true;
            this.f8522c = this.f8526i.getCount();
            if (this.f8528k >= 0) {
                this.f8526i.restoreState(this.f8529l, this.f8530m);
                m8214a(this.f8528k, false, true);
                this.f8528k = -1;
                this.f8529l = null;
                this.f8530m = null;
            } else if (!z) {
                m8220c();
            } else {
                requestLayout();
            }
        }
        if (this.f8514R == null || pagerAdapter2 == pagerAdapter) {
            return;
        }
        this.f8514R.m8228a(pagerAdapter2, pagerAdapter);
    }

    /* JADX INFO: renamed from: g */
    private void m8204g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f8545a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f8526i;
    }

    void setOnAdapterChangeListener(InterfaceC1355d interfaceC1355d) {
        this.f8514R = interfaceC1355d;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.f8543z = false;
        m8214a(i, !this.f8508L, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f8543z = false;
        m8214a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f8527j;
    }

    /* JADX INFO: renamed from: a */
    void m8214a(int i, boolean z, boolean z2) {
        m8215a(i, z, z2, 0);
    }

    /* JADX INFO: renamed from: a */
    void m8215a(int i, boolean z, boolean z2, int i2) {
        if (this.f8526i == null || this.f8526i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f8527j == i && this.f8523f.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f8526i.getCount()) {
            i = this.f8526i.getCount() - 1;
        }
        int i3 = this.f8497A;
        if (i > this.f8527j + i3 || i < this.f8527j - i3) {
            for (int i4 = 0; i4 < this.f8523f.size(); i4++) {
                this.f8523f.get(i4).f8556c = true;
            }
        }
        boolean z3 = this.f8527j != i;
        if (this.f8508L) {
            this.f8527j = i;
            if (z3 && this.f8512P != null) {
                this.f8512P.m8229a(i);
            }
            if (z3 && this.f8513Q != null) {
                this.f8513Q.m8229a(i);
            }
            requestLayout();
            return;
        }
        m8211a(i);
        m8196a(i, z, i2, z3);
    }

    /* JADX INFO: renamed from: a */
    private void m8196a(int i, boolean z, int i2, boolean z2) {
        C1353b c1353bM8217b = m8217b(i);
        int clientWidth = c1353bM8217b != null ? (int) (getClientWidth() * Math.max(this.f8537t, Math.min(c1353bM8217b.f8558e, this.f8538u))) : 0;
        if (z) {
            m8213a(clientWidth, 0, i2);
            if (z2 && this.f8512P != null) {
                this.f8512P.m8229a(i);
            }
            if (!z2 || this.f8513Q == null) {
                return;
            }
            this.f8513Q.m8229a(i);
            return;
        }
        if (z2 && this.f8512P != null) {
            this.f8512P.m8229a(i);
        }
        if (z2 && this.f8513Q != null) {
            this.f8513Q.m8229a(i);
        }
        m8199a(false);
        scrollTo(clientWidth, 0);
        m8202d(clientWidth);
    }

    public void setOnPageChangeListener(InterfaceC1356e interfaceC1356e) {
        this.f8512P = interfaceC1356e;
    }

    public void setPageTransformer(boolean z, InterfaceC1357f interfaceC1357f) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = interfaceC1357f != null;
            boolean z3 = z2 != (this.f8515S != null);
            this.f8515S = interfaceC1357f;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                this.f8517U = z ? 2 : 1;
            } else {
                this.f8517U = 0;
            }
            if (z3) {
                m8220c();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f8516T == null) {
                try {
                    this.f8516T = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f8516T.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f8517U == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f8518V.get(i2).getLayoutParams()).f8550f;
    }

    public int getOffscreenPageLimit() {
        return this.f8497A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f8497A) {
            this.f8497A = i;
            m8220c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f8533p;
        this.f8533p = i;
        int width = getWidth();
        m8195a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f8533p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f8534q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8534q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8534q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* JADX INFO: renamed from: a */
    float m8207a(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    /* JADX INFO: renamed from: a */
    void m8213a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m8199a(false);
            m8220c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        float f = clientWidth / 2;
        float fM8207a = f + (m8207a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientWidth)) * f);
        int iAbs = Math.abs(i3);
        if (iAbs > 0) {
            Math.round(Math.abs(fM8207a / iAbs) * 1000.0f);
        } else {
            this.f8526i.getPageWidth(this.f8527j);
            Math.abs(i4);
            int i6 = this.f8533p;
        }
        this.f8531n.startScroll(scrollX, scrollY, i4, i5, 500);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX INFO: renamed from: a */
    C1353b m8208a(int i, int i2) {
        C1353b c1353b = new C1353b();
        c1353b.f8555b = i;
        c1353b.f8554a = this.f8526i.instantiateItem((ViewGroup) this, i);
        c1353b.f8557d = this.f8526i.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f8523f.size()) {
            this.f8523f.add(c1353b);
        } else {
            this.f8523f.add(i2, c1353b);
        }
        return c1353b;
    }

    /* JADX INFO: renamed from: b */
    void m8219b() {
        int count = this.f8526i.getCount();
        this.f8522c = count;
        boolean z = this.f8523f.size() < (this.f8497A * 2) + 1 && this.f8523f.size() < count;
        int iMax = this.f8527j;
        int i = 0;
        boolean z2 = false;
        while (i < this.f8523f.size()) {
            C1353b c1353b = this.f8523f.get(i);
            int itemPosition = this.f8526i.getItemPosition(c1353b.f8554a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f8523f.remove(i);
                    i--;
                    if (!z2) {
                        this.f8526i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f8526i.destroyItem((ViewGroup) this, c1353b.f8555b, c1353b.f8554a);
                    if (this.f8527j == c1353b.f8555b) {
                        iMax = Math.max(0, Math.min(this.f8527j, count - 1));
                    }
                } else if (c1353b.f8555b != itemPosition) {
                    if (c1353b.f8555b == this.f8527j) {
                        iMax = itemPosition;
                    }
                    c1353b.f8555b = itemPosition;
                }
                z = true;
            }
            i++;
        }
        if (z2) {
            this.f8526i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f8523f, f8495d);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f8545a) {
                    layoutParams.f8547c = 0.0f;
                }
            }
            m8214a(iMax, false, true);
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: c */
    void m8220c() {
        m8211a(this.f8527j);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x015f A[PHI: r8 r11 r15
      0x015f: PHI (r8v14 float) = (r8v12 float), (r8v13 float), (r8v5 float) binds: [B:71:0x0154, B:68:0x013e, B:62:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x015f: PHI (r11v9 int) = (r11v1 int), (r11v8 int), (r11v12 int) binds: [B:71:0x0154, B:68:0x013e, B:62:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x015f: PHI (r15v5 int) = (r15v4 int), (r15v3 int), (r15v8 int) binds: [B:71:0x0154, B:68:0x013e, B:62:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m8211a(int r19) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.NoScrollViewPager.m8211a(int):void");
    }

    /* JADX INFO: renamed from: h */
    private void m8205h() {
        if (this.f8517U != 0) {
            if (this.f8518V == null) {
                this.f8518V = new ArrayList<>();
            } else {
                this.f8518V.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f8518V.add(getChildAt(i));
            }
            Collections.sort(this.f8518V, f8493W);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8197a(C1353b c1353b, int i, C1353b c1353b2) {
        C1353b c1353b3;
        C1353b c1353b4;
        int count = this.f8526i.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.f8533p / clientWidth : 0.0f;
        if (c1353b2 != null) {
            int i2 = c1353b2.f8555b;
            if (i2 < c1353b.f8555b) {
                float pageWidth = c1353b2.f8558e + c1353b2.f8557d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= c1353b.f8555b && i4 < this.f8523f.size()) {
                    C1353b c1353b5 = this.f8523f.get(i4);
                    while (true) {
                        c1353b4 = c1353b5;
                        if (i3 <= c1353b4.f8555b || i4 >= this.f8523f.size() - 1) {
                            break;
                        }
                        i4++;
                        c1353b5 = this.f8523f.get(i4);
                    }
                    while (i3 < c1353b4.f8555b) {
                        pageWidth += this.f8526i.getPageWidth(i3) + f;
                        i3++;
                    }
                    c1353b4.f8558e = pageWidth;
                    pageWidth += c1353b4.f8557d + f;
                    i3++;
                }
            } else if (i2 > c1353b.f8555b) {
                int size = this.f8523f.size() - 1;
                float pageWidth2 = c1353b2.f8558e;
                while (true) {
                    i2--;
                    if (i2 < c1353b.f8555b || size < 0) {
                        break;
                    }
                    C1353b c1353b6 = this.f8523f.get(size);
                    while (true) {
                        c1353b3 = c1353b6;
                        if (i2 >= c1353b3.f8555b || size <= 0) {
                            break;
                        }
                        size--;
                        c1353b6 = this.f8523f.get(size);
                    }
                    while (i2 > c1353b3.f8555b) {
                        pageWidth2 -= this.f8526i.getPageWidth(i2) + f;
                        i2--;
                    }
                    pageWidth2 -= c1353b3.f8557d + f;
                    c1353b3.f8558e = pageWidth2;
                }
            }
        }
        int size2 = this.f8523f.size();
        float pageWidth3 = c1353b.f8558e;
        int i5 = c1353b.f8555b - 1;
        this.f8537t = c1353b.f8555b == 0 ? c1353b.f8558e : -3.4028235E38f;
        int i6 = count - 1;
        this.f8538u = c1353b.f8555b == i6 ? (c1353b.f8558e + c1353b.f8557d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C1353b c1353b7 = this.f8523f.get(i7);
            while (i5 > c1353b7.f8555b) {
                pageWidth3 -= this.f8526i.getPageWidth(i5) + f;
                i5--;
            }
            pageWidth3 -= c1353b7.f8557d + f;
            c1353b7.f8558e = pageWidth3;
            if (c1353b7.f8555b == 0) {
                this.f8537t = pageWidth3;
            }
            i7--;
            i5--;
        }
        float pageWidth4 = c1353b.f8558e + c1353b.f8557d + f;
        int i8 = c1353b.f8555b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C1353b c1353b8 = this.f8523f.get(i9);
            while (i8 < c1353b8.f8555b) {
                pageWidth4 += this.f8526i.getPageWidth(i8) + f;
                i8++;
            }
            if (c1353b8.f8555b == i6) {
                this.f8538u = (c1353b8.f8557d + pageWidth4) - 1.0f;
            }
            c1353b8.f8558e = pageWidth4;
            pageWidth4 += c1353b8.f8557d + f;
            i9++;
            i8++;
        }
        this.f8509M = false;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.coollang.tennis.widget.NoScrollViewPager.SavedState.1
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* JADX INFO: renamed from: a */
        int f8551a;

        /* JADX INFO: renamed from: b */
        Parcelable f8552b;

        /* JADX INFO: renamed from: c */
        ClassLoader f8553c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8551a);
            parcel.writeParcelable(this.f8552b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f8551a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f8551a = parcel.readInt();
            this.f8552b = parcel.readParcelable(classLoader);
            this.f8553c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8551a = this.f8527j;
        if (this.f8526i != null) {
            savedState.f8552b = this.f8526i.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f8526i != null) {
            this.f8526i.restoreState(savedState.f8552b, savedState.f8553c);
            m8214a(savedState.f8551a, false, true);
        } else {
            this.f8528k = savedState.f8551a;
            this.f8529l = savedState.f8552b;
            this.f8530m = savedState.f8553c;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f8545a |= view instanceof InterfaceC1352a;
        if (this.f8541x) {
            if (layoutParams2 != null && layoutParams2.f8545a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f8548d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f8541x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX INFO: renamed from: a */
    C1353b m8209a(View view) {
        for (int i = 0; i < this.f8523f.size(); i++) {
            C1353b c1353b = this.f8523f.get(i);
            if (this.f8526i.isViewFromObject(view, c1353b.f8554a)) {
                return c1353b;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    C1353b m8218b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return m8209a(view);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    C1353b m8217b(int i) {
        for (int i2 = 0; i2 < this.f8523f.size(); i2++) {
            C1353b c1353b = this.f8523f.get(i2);
            if (c1353b.f8555b == i) {
                return c1353b;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8508L = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.NoScrollViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m8195a(i, i3, this.f8533p, this.f8533p);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8195a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f8523f.isEmpty()) {
            int scrollX = (int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3));
            scrollTo(scrollX, getScrollY());
            if (this.f8531n.isFinished()) {
                return;
            }
            this.f8531n.startScroll(scrollX, 0, (int) (m8217b(this.f8527j).f8558e * i), 0, this.f8531n.getDuration() - this.f8531n.timePassed());
            return;
        }
        C1353b c1353bM8217b = m8217b(this.f8527j);
        int iMin = (int) ((c1353bM8217b != null ? Math.min(c1353bM8217b.f8558e, this.f8538u) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m8199a(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        C1353b c1353bM8209a;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i7 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f8545a) {
                    int i9 = layoutParams.f8546b & 7;
                    int i10 = layoutParams.f8546b & 112;
                    if (i9 == 1) {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i9 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i9 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i10 == 16) {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i10 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i10 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i6 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i11 = iMax + scrollX;
                    childAt.layout(i11, iMax2, childAt.getMeasuredWidth() + i11, iMax2 + childAt.getMeasuredHeight());
                    i7++;
                }
            }
        }
        int i12 = (i5 - measuredWidth) - paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f8545a && (c1353bM8209a = m8209a(childAt2)) != null) {
                    float f = i12;
                    int i14 = ((int) (c1353bM8209a.f8558e * f)) + measuredWidth;
                    if (layoutParams2.f8548d) {
                        layoutParams2.f8548d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f8547c), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - measuredHeight2) - measuredHeight, 1073741824));
                    }
                    childAt2.layout(i14, measuredHeight2, childAt2.getMeasuredWidth() + i14, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.f8535r = measuredHeight2;
        this.f8536s = i6 - measuredHeight;
        this.f8511O = i7;
        if (this.f8508L) {
            z2 = false;
            m8196a(this.f8527j, false, 0, false);
        } else {
            z2 = false;
        }
        this.f8508L = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f8531n.isFinished() && this.f8531n.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f8531n.getCurrX();
            int currY = this.f8531n.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m8202d(currX)) {
                    this.f8531n.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        m8199a(true);
    }

    /* JADX INFO: renamed from: d */
    private boolean m8202d(int i) {
        if (this.f8523f.size() == 0) {
            this.f8510N = false;
            m8212a(0, 0.0f, 0);
            if (this.f8510N) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C1353b c1353bM8206i = m8206i();
        int clientWidth = getClientWidth();
        int i2 = this.f8533p + clientWidth;
        float f = clientWidth;
        int i3 = c1353bM8206i.f8555b;
        float f2 = ((i / f) - c1353bM8206i.f8558e) / (c1353bM8206i.f8557d + (this.f8533p / f));
        this.f8510N = false;
        m8212a(i3, f2, (int) (i2 * f2));
        if (this.f8510N) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m8212a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f8511O
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.coollang.tennis.widget.NoScrollViewPager$LayoutParams r9 = (com.coollang.tennis.widget.NoScrollViewPager.LayoutParams) r9
            boolean r10 = r9.f8545a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f8546b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            com.coollang.tennis.widget.NoScrollViewPager$e r0 = r12.f8512P
            if (r0 == 0) goto L76
            com.coollang.tennis.widget.NoScrollViewPager$e r0 = r12.f8512P
            r0.m8230a(r13, r14, r15)
        L76:
            com.coollang.tennis.widget.NoScrollViewPager$e r0 = r12.f8513Q
            if (r0 == 0) goto L7f
            com.coollang.tennis.widget.NoScrollViewPager$e r0 = r12.f8513Q
            r0.m8230a(r13, r14, r15)
        L7f:
            com.coollang.tennis.widget.NoScrollViewPager$f r13 = r12.f8515S
            if (r13 == 0) goto Lb0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L8b:
            if (r1 >= r14) goto Lb0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.coollang.tennis.widget.NoScrollViewPager$LayoutParams r0 = (com.coollang.tennis.widget.NoScrollViewPager.LayoutParams) r0
            boolean r0 = r0.f8545a
            if (r0 == 0) goto L9c
            goto Lad
        L9c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.coollang.tennis.widget.NoScrollViewPager$f r3 = r12.f8515S
            r3.m8232a(r15, r0)
        Lad:
            int r1 = r1 + 1
            goto L8b
        Lb0:
            r12.f8510N = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.NoScrollViewPager.m8212a(int, float, int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m8199a(boolean z) {
        boolean z2 = this.f8521ab == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f8531n.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f8531n.getCurrX();
            int currY = this.f8531n.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.f8543z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f8523f.size(); i++) {
            C1353b c1353b = this.f8523f.get(i);
            if (c1353b.f8556c) {
                c1353b.f8556c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.f8520aa);
            } else {
                this.f8520aa.run();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8201b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    /* JADX INFO: renamed from: i */
    private C1353b m8206i() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.f8533p / clientWidth : 0.0f;
        C1353b c1353b = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.f8523f.size()) {
            C1353b c1353b2 = this.f8523f.get(i2);
            if (!z && c1353b2.f8555b != (i = i3 + 1)) {
                c1353b2 = this.f8524g;
                c1353b2.f8558e = f2 + f3 + f;
                c1353b2.f8555b = i;
                c1353b2.f8557d = this.f8526i.getPageWidth(c1353b2.f8555b);
                i2--;
            }
            f2 = c1353b2.f8558e;
            float f4 = c1353b2.f8557d + f2 + f;
            if (!z && scrollX < f2) {
                return c1353b;
            }
            if (scrollX < f4 || i2 == this.f8523f.size() - 1) {
                return c1353b2;
            }
            i3 = c1353b2.f8555b;
            f3 = c1353b2.f8557d;
            i2++;
            c1353b = c1353b2;
            z = false;
        }
        return c1353b;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f8526i != null && this.f8526i.getCount() > 1)) {
            if (!this.f8506J.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f8537t * width);
                this.f8506J.setSize(height, width);
                zDraw = false | this.f8506J.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f8507K.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f8538u + 1.0f)) * width2);
                this.f8507K.setSize(height2, width2);
                zDraw |= this.f8507K.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f8506J.finish();
            this.f8507K.finish();
        }
        if (zDraw) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f8533p <= 0 || this.f8534q == null || this.f8523f.size() <= 0 || this.f8526i == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.f8533p / width;
        int i = 0;
        C1353b c1353b = this.f8523f.get(0);
        float f4 = c1353b.f8558e;
        int size = this.f8523f.size();
        int i2 = c1353b.f8555b;
        int i3 = this.f8523f.get(size - 1).f8555b;
        while (i2 < i3) {
            while (i2 > c1353b.f8555b && i < size) {
                i++;
                c1353b = this.f8523f.get(i);
            }
            if (i2 == c1353b.f8555b) {
                f = (c1353b.f8558e + c1353b.f8557d) * width;
                f4 = c1353b.f8558e + c1353b.f8557d + f3;
            } else {
                float pageWidth = this.f8526i.getPageWidth(i2);
                f = (f4 + pageWidth) * width;
                f4 += pageWidth + f3;
            }
            if (this.f8533p + f > scrollX) {
                f2 = f3;
                this.f8534q.setBounds((int) f, this.f8535r, (int) (this.f8533p + f + 0.5f), this.f8536s);
                this.f8534q.draw(canvas);
            } else {
                f2 = f3;
            }
            if (f > scrollX + r2) {
                return;
            }
            i2++;
            f3 = f2;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f8542y != z) {
            this.f8542y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f8526i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.f8537t)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.f8538u));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m8216a(keyEvent);
    }

    /* JADX INFO: renamed from: a */
    public boolean m8216a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        return m8221c(17);
                    case 22:
                        return m8221c(66);
                }
            }
            if (Build.VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    return m8221c(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m8221c(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m8221c(int r8) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.widget.NoScrollViewPager.m8221c(int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private Rect m8193a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* JADX INFO: renamed from: d */
    boolean m8222d() {
        if (this.f8527j <= 0) {
            return false;
        }
        setCurrentItem(this.f8527j - 1, true);
        return true;
    }

    /* JADX INFO: renamed from: e */
    boolean m8223e() {
        if (this.f8526i == null || this.f8527j >= this.f8526i.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f8527j + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C1353b c1353bM8209a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (c1353bM8209a = m8209a(childAt)) != null && c1353bM8209a.f8555b == this.f8527j) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C1353b c1353bM8209a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (c1353bM8209a = m8209a(childAt)) != null && c1353bM8209a.f8555b == this.f8527j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C1353b c1353bM8209a;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (c1353bM8209a = m8209a(childAt)) != null && c1353bM8209a.f8555b == this.f8527j && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C1353b c1353bM8209a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (c1353bM8209a = m8209a(childAt)) != null && c1353bM8209a.f8555b == this.f8527j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$c */
    class C1354c extends AccessibilityDelegateCompat {
        C1354c() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat accessibilityRecordCompatObtain = AccessibilityRecordCompat.obtain();
            accessibilityRecordCompatObtain.setScrollable(m8227a());
            if (accessibilityEvent.getEventType() != 4096 || NoScrollViewPager.this.f8526i == null) {
                return;
            }
            accessibilityRecordCompatObtain.setItemCount(NoScrollViewPager.this.f8526i.getCount());
            accessibilityRecordCompatObtain.setFromIndex(NoScrollViewPager.this.f8527j);
            accessibilityRecordCompatObtain.setToIndex(NoScrollViewPager.this.f8527j);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m8227a());
            if (NoScrollViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (NoScrollViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!NoScrollViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                NoScrollViewPager.this.setCurrentItem(NoScrollViewPager.this.f8527j + 1);
                return true;
            }
            if (i != 8192 || !NoScrollViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            NoScrollViewPager.this.setCurrentItem(NoScrollViewPager.this.f8527j - 1);
            return true;
        }

        /* JADX INFO: renamed from: a */
        private boolean m8227a() {
            return NoScrollViewPager.this.f8526i != null && NoScrollViewPager.this.f8526i.getCount() > 1;
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$g */
    class C1358g extends DataSetObserver {
        private C1358g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            NoScrollViewPager.this.m8219b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            NoScrollViewPager.this.m8219b();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a */
        public boolean f8545a;

        /* JADX INFO: renamed from: b */
        public int f8546b;

        /* JADX INFO: renamed from: c */
        float f8547c;

        /* JADX INFO: renamed from: d */
        boolean f8548d;

        /* JADX INFO: renamed from: e */
        int f8549e;

        /* JADX INFO: renamed from: f */
        int f8550f;

        public LayoutParams() {
            super(-1, -1);
            this.f8547c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8547c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NoScrollViewPager.f8494b);
            this.f8546b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.NoScrollViewPager$h */
    static class C1359h implements Comparator<View> {
        C1359h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.f8545a != layoutParams2.f8545a) {
                return layoutParams.f8545a ? 1 : -1;
            }
            return layoutParams.f8549e - layoutParams2.f8549e;
        }
    }
}
