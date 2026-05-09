package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.coordinatorlayout.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DirectedAcyclicGraph;
import android.support.v4.widget.ViewGroupUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a */
    static final String f2429a;

    /* JADX INFO: renamed from: b */
    static final Class<?>[] f2430b;

    /* JADX INFO: renamed from: c */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f2431c;

    /* JADX INFO: renamed from: d */
    static final Comparator<View> f2432d;

    /* JADX INFO: renamed from: f */
    private static final Pools.Pool<Rect> f2433f;

    /* JADX INFO: renamed from: e */
    ViewGroup.OnHierarchyChangeListener f2434e;

    /* JADX INFO: renamed from: g */
    private final List<View> f2435g;

    /* JADX INFO: renamed from: h */
    private final DirectedAcyclicGraph<View> f2436h;

    /* JADX INFO: renamed from: i */
    private final List<View> f2437i;

    /* JADX INFO: renamed from: j */
    private final List<View> f2438j;

    /* JADX INFO: renamed from: k */
    private final int[] f2439k;

    /* JADX INFO: renamed from: l */
    private Paint f2440l;

    /* JADX INFO: renamed from: m */
    private boolean f2441m;

    /* JADX INFO: renamed from: n */
    private boolean f2442n;

    /* JADX INFO: renamed from: o */
    private int[] f2443o;

    /* JADX INFO: renamed from: p */
    private View f2444p;

    /* JADX INFO: renamed from: q */
    private View f2445q;

    /* JADX INFO: renamed from: r */
    private ViewTreeObserverOnPreDrawListenerC0291e f2446r;

    /* JADX INFO: renamed from: s */
    private boolean f2447s;

    /* JADX INFO: renamed from: t */
    private WindowInsetsCompat f2448t;

    /* JADX INFO: renamed from: u */
    private boolean f2449u;

    /* JADX INFO: renamed from: v */
    private Drawable f2450v;

    /* JADX INFO: renamed from: w */
    private OnApplyWindowInsetsListener f2451w;

    /* JADX INFO: renamed from: x */
    private final NestedScrollingParentHelper f2452x;

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$a */
    public interface InterfaceC0287a {
        Behavior getBehavior();
    }

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$b */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface InterfaceC0288b {
        /* JADX INFO: renamed from: a */
        Class<? extends Behavior> m2728a();
    }

    /* JADX INFO: renamed from: a */
    private static int m2669a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* JADX INFO: renamed from: c */
    private static int m2684c(int i) {
        if ((i & 7) == 0) {
            i |= GravityCompat.START;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    /* JADX INFO: renamed from: d */
    private static int m2687d(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* JADX INFO: renamed from: e */
    private static int m2689e(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f2429a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f2432d = new C0292f();
        } else {
            f2432d = null;
        }
        f2430b = new Class[]{Context.class, AttributeSet.class};
        f2431c = new ThreadLocal<>();
        f2433f = new Pools.SynchronizedPool(12);
    }

    /* JADX INFO: renamed from: a */
    private static Rect m2670a() {
        Rect rectAcquire = f2433f.acquire();
        return rectAcquire == null ? new Rect() : rectAcquire;
    }

    /* JADX INFO: renamed from: a */
    private static void m2672a(Rect rect) {
        rect.setEmpty();
        f2433f.release(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.f2435g = new ArrayList();
        this.f2436h = new DirectedAcyclicGraph<>();
        this.f2437i = new ArrayList();
        this.f2438j = new ArrayList();
        this.f2439k = new int[2];
        this.f2452x = new NestedScrollingParentHelper(this);
        if (i == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2443o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f2443o.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f2443o[i2] = (int) (this.f2443o[i2] * f);
            }
        }
        this.f2450v = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        m2685c();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0289c());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2434e = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2678a(false);
        if (this.f2447s) {
            if (this.f2446r == null) {
                this.f2446r = new ViewTreeObserverOnPreDrawListenerC0291e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2446r);
        }
        if (this.f2448t == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.f2442n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2678a(false);
        if (this.f2447s && this.f2446r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2446r);
        }
        if (this.f2445q != null) {
            onStopNestedScroll(this.f2445q);
        }
        this.f2442n = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.f2450v != drawable) {
            if (this.f2450v != null) {
                this.f2450v.setCallback(null);
            }
            this.f2450v = drawable != null ? drawable.mutate() : null;
            if (this.f2450v != null) {
                if (this.f2450v.isStateful()) {
                    this.f2450v.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f2450v, ViewCompat.getLayoutDirection(this));
                this.f2450v.setVisible(getVisibility() == 0, false);
                this.f2450v.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f2450v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2450v;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2450v;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f2450v == null || this.f2450v.isVisible() == z) {
            return;
        }
        this.f2450v.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* JADX INFO: renamed from: a */
    final WindowInsetsCompat m2695a(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.equals(this.f2448t, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f2448t = windowInsetsCompat;
        boolean z = false;
        this.f2449u = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        if (!this.f2449u && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        WindowInsetsCompat windowInsetsCompatM2681b = m2681b(windowInsetsCompat);
        requestLayout();
        return windowInsetsCompatM2681b;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f2448t;
    }

    /* JADX INFO: renamed from: a */
    private void m2678a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behaviorM2740b = ((C0290d) childAt.getLayoutParams()).m2740b();
            if (behaviorM2740b != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behaviorM2740b.mo2610b(this, childAt, motionEventObtain);
                } else {
                    behaviorM2740b.mo2513a(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0290d) getChildAt(i2).getLayoutParams()).m2746f();
        }
        this.f2444p = null;
        this.f2441m = false;
    }

    /* JADX INFO: renamed from: a */
    private void m2677a(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (f2432d != null) {
            Collections.sort(list, f2432d);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2679a(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2437i;
        m2677a(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zMo2610b = false;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            C0290d c0290d = (C0290d) view.getLayoutParams();
            Behavior behaviorM2740b = c0290d.m2740b();
            if (!(zMo2610b || z) || actionMasked == 0) {
                if (!zMo2610b && behaviorM2740b != null) {
                    switch (i) {
                        case 0:
                            zMo2610b = behaviorM2740b.mo2610b(this, view, motionEvent);
                            break;
                        case 1:
                            zMo2610b = behaviorM2740b.mo2513a(this, view, motionEvent);
                            break;
                    }
                    if (zMo2610b) {
                        this.f2444p = view;
                    }
                }
                boolean zM2745e = c0290d.m2745e();
                boolean zM2738a = c0290d.m2738a(this, view);
                z = zM2738a && !zM2745e;
                if (zM2738a && !z) {
                    list.clear();
                    return zMo2610b;
                }
            } else if (behaviorM2740b != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                switch (i) {
                    case 0:
                        behaviorM2740b.mo2610b(this, view, motionEventObtain);
                        break;
                    case 1:
                        behaviorM2740b.mo2513a(this, view, motionEventObtain);
                        break;
                }
            }
        }
        list.clear();
        return zMo2610b;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m2678a(true);
        }
        boolean zM2679a = m2679a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m2678a(true);
        }
        return zM2679a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2444p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.m2679a(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.f2444p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$d r6 = (android.support.design.widget.CoordinatorLayout.C0290d) r6
            android.support.design.widget.CoordinatorLayout$Behavior r6 = r6.m2740b()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f2444p
            boolean r6 = r6.mo2513a(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f2444p
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.m2678a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f2441m) {
            return;
        }
        m2678a(false);
        this.f2441m = true;
    }

    /* JADX INFO: renamed from: b */
    private int m2680b(int i) {
        if (this.f2443o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i < 0 || i >= this.f2443o.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
        return this.f2443o[i];
    }

    /* JADX INFO: renamed from: a */
    static Behavior m2671a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f2429a)) {
            str = f2429a + '.' + str;
        }
        try {
            Map map = f2431c.get();
            if (map == null) {
                map = new HashMap();
                f2431c.set((Map<String, Constructor<Behavior>>) map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f2430b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    C0290d m2693a(View view) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (!c0290d.f2457b) {
            if (view instanceof InterfaceC0287a) {
                Behavior behavior = ((InterfaceC0287a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c0290d.m2736a(behavior);
                c0290d.f2457b = true;
            } else {
                InterfaceC0288b interfaceC0288b = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    interfaceC0288b = (InterfaceC0288b) superclass.getAnnotation(InterfaceC0288b.class);
                    if (interfaceC0288b != null) {
                        break;
                    }
                }
                if (interfaceC0288b != null) {
                    try {
                        c0290d.m2736a(interfaceC0288b.m2728a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0288b.m2728a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                c0290d.f2457b = true;
            }
        }
        return c0290d;
    }

    /* JADX INFO: renamed from: b */
    private void m2682b() {
        this.f2435g.clear();
        this.f2436h.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0290d c0290dM2693a = m2693a(childAt);
            c0290dM2693a.m2741b(this, childAt);
            this.f2436h.addNode(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (c0290dM2693a.m2739a(this, childAt, childAt2)) {
                        if (!this.f2436h.contains(childAt2)) {
                            this.f2436h.addNode(childAt2);
                        }
                        this.f2436h.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.f2435g.addAll(this.f2436h.getSortedList());
        Collections.reverse(this.f2435g);
    }

    /* JADX INFO: renamed from: a */
    void m2700a(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: renamed from: a */
    public void m2698a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0126  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: renamed from: b */
    private WindowInsetsCompat m2681b(WindowInsetsCompat windowInsetsCompat) {
        Behavior behaviorM2740b;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt) && (behaviorM2740b = ((C0290d) childAt.getLayoutParams()).m2740b()) != null) {
                windowInsetsCompat = behaviorM2740b.m2713a(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: a */
    public void m2697a(View view, int i) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (c0290d.m2744d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (c0290d.f2466k != null) {
            m2676a(view, c0290d.f2466k, i);
        } else if (c0290d.f2460e >= 0) {
            m2683b(view, c0290d.f2460e, i);
        } else {
            m2686c(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behaviorM2740b;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f2435g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f2435g.get(i5);
            if (view.getVisibility() != 8 && ((behaviorM2740b = ((C0290d) view.getLayoutParams()).m2740b()) == null || !behaviorM2740b.mo2208a(this, view, layoutDirection))) {
                m2697a(view, layoutDirection);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f2449u || this.f2450v == null) {
            return;
        }
        int systemWindowInsetTop = this.f2448t != null ? this.f2448t.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f2450v.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f2450v.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m2685c();
    }

    /* JADX INFO: renamed from: b */
    void m2705b(View view, Rect rect) {
        ((C0290d) view.getLayoutParams()).m2735a(rect);
    }

    /* JADX INFO: renamed from: c */
    void m2707c(View view, Rect rect) {
        rect.set(((C0290d) view.getLayoutParams()).m2743c());
    }

    /* JADX INFO: renamed from: a */
    void m2701a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m2700a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2674a(View view, int i, Rect rect, Rect rect2, C0290d c0290d, int i2, int i3) {
        int iWidth;
        int iHeight;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m2689e(c0290d.f2458c), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(m2684c(c0290d.f2459d), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 7;
        int i7 = absoluteGravity2 & 112;
        if (i6 == 1) {
            iWidth = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            iWidth = rect.left;
        } else {
            iWidth = rect.right;
        }
        if (i7 == 16) {
            iHeight = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            iHeight = rect.top;
        } else {
            iHeight = rect.bottom;
        }
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    /* JADX INFO: renamed from: a */
    private void m2673a(C0290d c0290d, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + c0290d.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c0290d.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + c0290d.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c0290d.bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    /* JADX INFO: renamed from: a */
    void m2699a(View view, int i, Rect rect, Rect rect2) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m2674a(view, i, rect, rect2, c0290d, measuredWidth, measuredHeight);
        m2673a(c0290d, rect2, measuredWidth, measuredHeight);
    }

    /* JADX INFO: renamed from: a */
    private void m2676a(View view, View view2, int i) {
        Rect rectM2670a = m2670a();
        Rect rectM2670a2 = m2670a();
        try {
            m2700a(view2, rectM2670a);
            m2699a(view, i, rectM2670a, rectM2670a2);
            view.layout(rectM2670a2.left, rectM2670a2.top, rectM2670a2.right, rectM2670a2.bottom);
        } finally {
            m2672a(rectM2670a);
            m2672a(rectM2670a2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2683b(View view, int i, int i2) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(m2687d(c0290d.f2458c), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int iM2680b = m2680b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            iM2680b += measuredWidth / 2;
        } else if (i3 == 5) {
            iM2680b += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + c0290d.leftMargin, Math.min(iM2680b, ((width - getPaddingRight()) - measuredWidth) - c0290d.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + c0290d.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - c0290d.bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    /* JADX INFO: renamed from: c */
    private void m2686c(View view, int i) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        Rect rectM2670a = m2670a();
        rectM2670a.set(getPaddingLeft() + c0290d.leftMargin, getPaddingTop() + c0290d.topMargin, (getWidth() - getPaddingRight()) - c0290d.rightMargin, (getHeight() - getPaddingBottom()) - c0290d.bottomMargin);
        if (this.f2448t != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            rectM2670a.left += this.f2448t.getSystemWindowInsetLeft();
            rectM2670a.top += this.f2448t.getSystemWindowInsetTop();
            rectM2670a.right -= this.f2448t.getSystemWindowInsetRight();
            rectM2670a.bottom -= this.f2448t.getSystemWindowInsetBottom();
        }
        Rect rectM2670a2 = m2670a();
        GravityCompat.apply(m2684c(c0290d.f2458c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectM2670a, rectM2670a2, i);
        view.layout(rectM2670a2.left, rectM2670a2.top, rectM2670a2.right, rectM2670a2.bottom);
        m2672a(rectM2670a);
        m2672a(rectM2670a2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (c0290d.f2456a != null) {
            float fM2722d = c0290d.f2456a.m2722d(this, view);
            if (fM2722d > 0.0f) {
                if (this.f2440l == null) {
                    this.f2440l = new Paint();
                }
                this.f2440l.setColor(c0290d.f2456a.m2719c(this, view));
                this.f2440l.setAlpha(m2669a(Math.round(fM2722d * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2440l);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void m2696a(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.m2696a(int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m2675a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0290d c0290d = (C0290d) view.getLayoutParams();
            Behavior behaviorM2740b = c0290d.m2740b();
            Rect rectM2670a = m2670a();
            Rect rectM2670a2 = m2670a();
            rectM2670a2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorM2740b != null && behaviorM2740b.mo2715a(this, view, rectM2670a)) {
                if (!rectM2670a2.contains(rectM2670a)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectM2670a.toShortString() + " | Bounds:" + rectM2670a2.toShortString());
                }
            } else {
                rectM2670a.set(rectM2670a2);
            }
            m2672a(rectM2670a2);
            if (rectM2670a.isEmpty()) {
                m2672a(rectM2670a);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(c0290d.f2463h, i);
            if ((absoluteGravity & 48) != 48 || (i3 = (rectM2670a.top - c0290d.topMargin) - c0290d.f2465j) >= rect.top) {
                z = false;
            } else {
                m2690e(view, rect.top - i3);
                z = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - rectM2670a.bottom) - c0290d.bottomMargin) + c0290d.f2465j) < rect.bottom) {
                m2690e(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                m2690e(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i2 = (rectM2670a.left - c0290d.leftMargin) - c0290d.f2464i) >= rect.left) {
                z2 = false;
            } else {
                m2688d(view, rect.left - i2);
                z2 = true;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - rectM2670a.right) - c0290d.rightMargin) + c0290d.f2464i) < rect.right) {
                m2688d(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                m2688d(view, 0);
            }
            m2672a(rectM2670a);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2688d(View view, int i) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (c0290d.f2464i != i) {
            ViewCompat.offsetLeftAndRight(view, i - c0290d.f2464i);
            c0290d.f2464i = i;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2690e(View view, int i) {
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (c0290d.f2465j != i) {
            ViewCompat.offsetTopAndBottom(view, i - c0290d.f2465j);
            c0290d.f2465j = i;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2703b(View view) {
        List incomingEdges = this.f2436h.getIncomingEdges(view);
        if (incomingEdges == null || incomingEdges.isEmpty()) {
            return;
        }
        for (int i = 0; i < incomingEdges.size(); i++) {
            View view2 = (View) incomingEdges.get(i);
            Behavior behaviorM2740b = ((C0290d) view2.getLayoutParams()).m2740b();
            if (behaviorM2740b != null) {
                behaviorM2740b.mo2489b(this, view2, view);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public List<View> m2706c(View view) {
        List<View> outgoingEdges = this.f2436h.getOutgoingEdges(view);
        this.f2438j.clear();
        if (outgoingEdges != null) {
            this.f2438j.addAll(outgoingEdges);
        }
        return this.f2438j;
    }

    /* JADX INFO: renamed from: d */
    public List<View> m2708d(View view) {
        List incomingEdges = this.f2436h.getIncomingEdges(view);
        this.f2438j.clear();
        if (incomingEdges != null) {
            this.f2438j.addAll(incomingEdges);
        }
        return this.f2438j;
    }

    final List<View> getDependencySortedChildren() {
        m2682b();
        return Collections.unmodifiableList(this.f2435g);
    }

    /* JADX INFO: renamed from: d */
    void m2709d() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (m2691e(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.f2447s) {
            if (z) {
                m2710e();
            } else {
                m2711f();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m2691e(View view) {
        return this.f2436h.hasOutgoingEdges(view);
    }

    /* JADX INFO: renamed from: e */
    void m2710e() {
        if (this.f2442n) {
            if (this.f2446r == null) {
                this.f2446r = new ViewTreeObserverOnPreDrawListenerC0291e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2446r);
        }
        this.f2447s = true;
    }

    /* JADX INFO: renamed from: f */
    void m2711f() {
        if (this.f2442n && this.f2446r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2446r);
        }
        this.f2447s = false;
    }

    /* JADX INFO: renamed from: b */
    void m2704b(View view, int i) {
        Behavior behaviorM2740b;
        C0290d c0290d = (C0290d) view.getLayoutParams();
        if (c0290d.f2466k != null) {
            Rect rectM2670a = m2670a();
            Rect rectM2670a2 = m2670a();
            Rect rectM2670a3 = m2670a();
            m2700a(c0290d.f2466k, rectM2670a);
            m2701a(view, false, rectM2670a2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m2674a(view, i, rectM2670a, rectM2670a3, c0290d, measuredWidth, measuredHeight);
            boolean z = (rectM2670a3.left == rectM2670a2.left && rectM2670a3.top == rectM2670a2.top) ? false : true;
            m2673a(c0290d, rectM2670a3, measuredWidth, measuredHeight);
            int i2 = rectM2670a3.left - rectM2670a2.left;
            int i3 = rectM2670a3.top - rectM2670a2.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view, i3);
            }
            if (z && (behaviorM2740b = c0290d.m2740b()) != null) {
                behaviorM2740b.mo2489b(this, view, c0290d.f2466k);
            }
            m2672a(rectM2670a);
            m2672a(rectM2670a2);
            m2672a(rectM2670a3);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2702a(View view, int i, int i2) {
        Rect rectM2670a = m2670a();
        m2700a(view, rectM2670a);
        try {
            return rectM2670a.contains(i, i2);
        } finally {
            m2672a(rectM2670a);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0290d generateLayoutParams(AttributeSet attributeSet) {
        return new C0290d(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0290d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0290d) {
            return new C0290d((C0290d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0290d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0290d(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0290d generateDefaultLayoutParams() {
        return new C0290d(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0290d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0290d c0290d = (C0290d) childAt.getLayoutParams();
                Behavior behaviorM2740b = c0290d.m2740b();
                if (behaviorM2740b != null) {
                    boolean zMo2248a = behaviorM2740b.mo2248a(this, childAt, view, view2, i, i2);
                    c0290d.m2734a(i2, zMo2248a);
                    z |= zMo2248a;
                } else {
                    c0290d.m2734a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Behavior behaviorM2740b;
        this.f2452x.onNestedScrollAccepted(view, view2, i, i2);
        this.f2445q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0290d c0290d = (C0290d) childAt.getLayoutParams();
            if (c0290d.m2742b(i2) && (behaviorM2740b = c0290d.m2740b()) != null) {
                behaviorM2740b.m2718b(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.f2452x.onStopNestedScroll(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0290d c0290d = (C0290d) childAt.getLayoutParams();
            if (c0290d.m2742b(i)) {
                Behavior behaviorM2740b = c0290d.m2740b();
                if (behaviorM2740b != null) {
                    behaviorM2740b.mo2557a(this, childAt, view, i);
                }
                c0290d.m2733a(i);
                c0290d.m2748h();
            }
        }
        this.f2445q = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        Behavior behaviorM2740b;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0290d c0290d = (C0290d) childAt.getLayoutParams();
                if (c0290d.m2742b(i5) && (behaviorM2740b = c0290d.m2740b()) != null) {
                    behaviorM2740b.mo2558a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            m2696a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behaviorM2740b;
        int iMin;
        int iMin2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0290d c0290d = (C0290d) childAt.getLayoutParams();
                if (c0290d.m2742b(i3) && (behaviorM2740b = c0290d.m2740b()) != null) {
                    int[] iArr2 = this.f2439k;
                    this.f2439k[1] = 0;
                    iArr2[0] = 0;
                    behaviorM2740b.mo2559a(this, childAt, view, i, i2, this.f2439k, i3);
                    if (i > 0) {
                        iMin = Math.max(i4, this.f2439k[0]);
                    } else {
                        iMin = Math.min(i4, this.f2439k[0]);
                    }
                    if (i2 > 0) {
                        iMin2 = Math.max(i5, this.f2439k[1]);
                    } else {
                        iMin2 = Math.min(i5, this.f2439k[1]);
                    }
                    i4 = iMin;
                    i5 = iMin2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            m2696a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Behavior behaviorM2740b;
        int childCount = getChildCount();
        boolean zM2716a = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0290d c0290d = (C0290d) childAt.getLayoutParams();
                if (c0290d.m2742b(0) && (behaviorM2740b = c0290d.m2740b()) != null) {
                    zM2716a |= behaviorM2740b.m2716a(this, childAt, view, f, f2, z);
                }
            }
        }
        if (zM2716a) {
            m2696a(1);
        }
        return zM2716a;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behaviorM2740b;
        int childCount = getChildCount();
        boolean zMo2643a = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0290d c0290d = (C0290d) childAt.getLayoutParams();
                if (c0290d.m2742b(0) && (behaviorM2740b = c0290d.m2740b()) != null) {
                    zMo2643a |= behaviorM2740b.mo2643a(this, childAt, view, f, f2);
                }
            }
        }
        return zMo2643a;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f2452x.getNestedScrollAxes();
    }

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$e */
    class ViewTreeObserverOnPreDrawListenerC0291e implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserverOnPreDrawListenerC0291e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.m2696a(0);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$f */
    static class C0292f implements Comparator<View> {
        C0292f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float z = ViewCompat.getZ(view);
            float z2 = ViewCompat.getZ(view2);
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    public static abstract class Behavior<V extends View> {
        /* JADX INFO: renamed from: a */
        public WindowInsetsCompat m2713a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* JADX INFO: renamed from: a */
        public void mo2511a(C0290d c0290d) {
        }

        /* JADX INFO: renamed from: a */
        public void mo2556a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void mo2206a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m2714a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2208a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2564a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2715a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2585a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2513a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2487a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2643a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean m2716a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public boolean mo2209a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        /* JADX INFO: renamed from: b */
        public void m2717b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* JADX INFO: renamed from: b */
        public boolean mo2610b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public boolean mo2489b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX INFO: renamed from: c */
        public int m2719c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        /* JADX INFO: renamed from: c */
        public void m2720c() {
        }

        /* JADX INFO: renamed from: c */
        public void m2721c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* JADX INFO: renamed from: d */
        public float m2722d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        @Deprecated
        /* JADX INFO: renamed from: d */
        public void m2723d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        /* JADX INFO: renamed from: e */
        public boolean m2724e(CoordinatorLayout coordinatorLayout, V v) {
            return m2722d(coordinatorLayout, v) > 0.0f;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2248a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return mo2209a(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        /* JADX INFO: renamed from: b */
        public void m2718b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                m2717b(coordinatorLayout, v, view, view2, i);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2557a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                m2723d(coordinatorLayout, v, view);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2558a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                mo2206a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2559a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                m2714a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        /* JADX INFO: renamed from: b */
        public Parcelable mo2568b(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$d */
    public static class C0290d extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a */
        Behavior f2456a;

        /* JADX INFO: renamed from: b */
        boolean f2457b;

        /* JADX INFO: renamed from: c */
        public int f2458c;

        /* JADX INFO: renamed from: d */
        public int f2459d;

        /* JADX INFO: renamed from: e */
        public int f2460e;

        /* JADX INFO: renamed from: f */
        int f2461f;

        /* JADX INFO: renamed from: g */
        public int f2462g;

        /* JADX INFO: renamed from: h */
        public int f2463h;

        /* JADX INFO: renamed from: i */
        int f2464i;

        /* JADX INFO: renamed from: j */
        int f2465j;

        /* JADX INFO: renamed from: k */
        View f2466k;

        /* JADX INFO: renamed from: l */
        View f2467l;

        /* JADX INFO: renamed from: m */
        final Rect f2468m;

        /* JADX INFO: renamed from: n */
        Object f2469n;

        /* JADX INFO: renamed from: o */
        private boolean f2470o;

        /* JADX INFO: renamed from: p */
        private boolean f2471p;

        /* JADX INFO: renamed from: q */
        private boolean f2472q;

        /* JADX INFO: renamed from: r */
        private boolean f2473r;

        public C0290d(int i, int i2) {
            super(i, i2);
            this.f2457b = false;
            this.f2458c = 0;
            this.f2459d = 0;
            this.f2460e = -1;
            this.f2461f = -1;
            this.f2462g = 0;
            this.f2463h = 0;
            this.f2468m = new Rect();
        }

        C0290d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2457b = false;
            this.f2458c = 0;
            this.f2459d = 0;
            this.f2460e = -1;
            this.f2461f = -1;
            this.f2462g = 0;
            this.f2463h = 0;
            this.f2468m = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2458c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2461f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2459d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2460e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2462g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2463h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f2457b = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f2457b) {
                this.f2456a = CoordinatorLayout.m2671a(context, attributeSet, typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f2456a != null) {
                this.f2456a.mo2511a(this);
            }
        }

        public C0290d(C0290d c0290d) {
            super((ViewGroup.MarginLayoutParams) c0290d);
            this.f2457b = false;
            this.f2458c = 0;
            this.f2459d = 0;
            this.f2460e = -1;
            this.f2461f = -1;
            this.f2462g = 0;
            this.f2463h = 0;
            this.f2468m = new Rect();
        }

        public C0290d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2457b = false;
            this.f2458c = 0;
            this.f2459d = 0;
            this.f2460e = -1;
            this.f2461f = -1;
            this.f2462g = 0;
            this.f2463h = 0;
            this.f2468m = new Rect();
        }

        public C0290d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2457b = false;
            this.f2458c = 0;
            this.f2459d = 0;
            this.f2460e = -1;
            this.f2461f = -1;
            this.f2462g = 0;
            this.f2463h = 0;
            this.f2468m = new Rect();
        }

        /* JADX INFO: renamed from: a */
        public int m2732a() {
            return this.f2461f;
        }

        /* JADX INFO: renamed from: b */
        public Behavior m2740b() {
            return this.f2456a;
        }

        /* JADX INFO: renamed from: a */
        public void m2736a(Behavior behavior) {
            if (this.f2456a != behavior) {
                if (this.f2456a != null) {
                    this.f2456a.m2720c();
                }
                this.f2456a = behavior;
                this.f2469n = null;
                this.f2457b = true;
                if (behavior != null) {
                    behavior.mo2511a(this);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m2735a(Rect rect) {
            this.f2468m.set(rect);
        }

        /* JADX INFO: renamed from: c */
        Rect m2743c() {
            return this.f2468m;
        }

        /* JADX INFO: renamed from: d */
        boolean m2744d() {
            return this.f2466k == null && this.f2461f != -1;
        }

        /* JADX INFO: renamed from: e */
        boolean m2745e() {
            if (this.f2456a == null) {
                this.f2470o = false;
            }
            return this.f2470o;
        }

        /* JADX INFO: renamed from: a */
        boolean m2738a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2470o) {
                return true;
            }
            boolean zM2724e = (this.f2456a != null ? this.f2456a.m2724e(coordinatorLayout, view) : false) | this.f2470o;
            this.f2470o = zM2724e;
            return zM2724e;
        }

        /* JADX INFO: renamed from: f */
        void m2746f() {
            this.f2470o = false;
        }

        /* JADX INFO: renamed from: a */
        void m2733a(int i) {
            m2734a(i, false);
        }

        /* JADX INFO: renamed from: a */
        void m2734a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f2471p = z;
                    break;
                case 1:
                    this.f2472q = z;
                    break;
            }
        }

        /* JADX INFO: renamed from: b */
        boolean m2742b(int i) {
            switch (i) {
                case 0:
                    return this.f2471p;
                case 1:
                    return this.f2472q;
                default:
                    return false;
            }
        }

        /* JADX INFO: renamed from: g */
        boolean m2747g() {
            return this.f2473r;
        }

        /* JADX INFO: renamed from: a */
        void m2737a(boolean z) {
            this.f2473r = z;
        }

        /* JADX INFO: renamed from: h */
        void m2748h() {
            this.f2473r = false;
        }

        /* JADX INFO: renamed from: a */
        boolean m2739a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f2467l || m2730a(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || (this.f2456a != null && this.f2456a.mo2487a(coordinatorLayout, view, view2));
        }

        /* JADX INFO: renamed from: b */
        View m2741b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2461f == -1) {
                this.f2467l = null;
                this.f2466k = null;
                return null;
            }
            if (this.f2466k == null || !m2731b(view, coordinatorLayout)) {
                m2729a(view, coordinatorLayout);
            }
            return this.f2466k;
        }

        /* JADX INFO: renamed from: a */
        private void m2729a(View view, CoordinatorLayout coordinatorLayout) {
            this.f2466k = coordinatorLayout.findViewById(this.f2461f);
            if (this.f2466k != null) {
                if (this.f2466k == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f2467l = null;
                        this.f2466k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                View view2 = this.f2466k;
                for (ViewParent parent = this.f2466k.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f2467l = null;
                            this.f2466k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.f2467l = view2;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.f2467l = null;
                this.f2466k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2461f) + " to anchor view " + view);
        }

        /* JADX INFO: renamed from: b */
        private boolean m2731b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2466k.getId() != this.f2461f) {
                return false;
            }
            View view2 = this.f2466k;
            for (ViewParent parent = this.f2466k.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2467l = null;
                    this.f2466k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f2467l = view2;
            return true;
        }

        /* JADX INFO: renamed from: a */
        private boolean m2730a(View view, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((C0290d) view.getLayoutParams()).f2462g, i);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f2463h, i) & absoluteGravity) == absoluteGravity;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.CoordinatorLayout$c */
    class ViewGroupOnHierarchyChangeListenerC0289c implements ViewGroup.OnHierarchyChangeListener {
        ViewGroupOnHierarchyChangeListenerC0289c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f2434e != null) {
                CoordinatorLayout.this.f2434e.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.m2696a(2);
            if (CoordinatorLayout.this.f2434e != null) {
                CoordinatorLayout.this.f2434e.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f2454a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM2740b = m2693a(childAt).m2740b();
            if (id != -1 && behaviorM2740b != null && (parcelable2 = sparseArray.get(id)) != null) {
                behaviorM2740b.mo2556a(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableMo2568b;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM2740b = ((C0290d) childAt.getLayoutParams()).m2740b();
            if (id != -1 && behaviorM2740b != null && (parcelableMo2568b = behaviorM2740b.mo2568b(this, childAt)) != null) {
                sparseArray.append(id, parcelableMo2568b);
            }
        }
        savedState.f2454a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behaviorM2740b = ((C0290d) view.getLayoutParams()).m2740b();
        if (behaviorM2740b == null || !behaviorM2740b.mo2585a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    private void m2685c() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.f2451w == null) {
                this.f2451w = new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CoordinatorLayout.1
                    @Override // android.support.v4.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.m2695a(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.f2451w);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> f2454a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f2454a = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f2454a.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f2454a != null ? this.f2454a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f2454a.keyAt(i2);
                parcelableArr[i2] = this.f2454a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
