package android.support.v7.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.C1723fo;
import p000.C1739gd;
import p000.C1742gg;
import p000.C1745gj;
import p000.C1772hj;
import p000.C1773hk;
import p000.RunnableC1748gm;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild2, ScrollingView {

    /* JADX INFO: renamed from: L */
    static final Interpolator f3637L;

    /* JADX INFO: renamed from: M */
    private static final int[] f3638M = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: N */
    private static final int[] f3639N = {R.attr.clipToPadding};

    /* JADX INFO: renamed from: O */
    private static final boolean f3640O;

    /* JADX INFO: renamed from: P */
    private static final boolean f3641P;

    /* JADX INFO: renamed from: Q */
    private static final Class<?>[] f3642Q;

    /* JADX INFO: renamed from: a */
    static final boolean f3643a;

    /* JADX INFO: renamed from: b */
    static final boolean f3644b;

    /* JADX INFO: renamed from: c */
    static final boolean f3645c;

    /* JADX INFO: renamed from: d */
    static final boolean f3646d;

    /* JADX INFO: renamed from: A */
    final RunnableC0623u f3647A;

    /* JADX INFO: renamed from: B */
    RunnableC1748gm f3648B;

    /* JADX INFO: renamed from: C */
    public RunnableC1748gm.a f3649C;

    /* JADX INFO: renamed from: D */
    public final C0621s f3650D;

    /* JADX INFO: renamed from: E */
    boolean f3651E;

    /* JADX INFO: renamed from: F */
    boolean f3652F;

    /* JADX INFO: renamed from: G */
    boolean f3653G;

    /* JADX INFO: renamed from: H */
    RecyclerViewAccessibilityDelegate f3654H;

    /* JADX INFO: renamed from: I */
    final int[] f3655I;

    /* JADX INFO: renamed from: J */
    final int[] f3656J;

    /* JADX INFO: renamed from: K */
    final List<AbstractC0624v> f3657K;

    /* JADX INFO: renamed from: R */
    private final C0619q f3658R;

    /* JADX INFO: renamed from: S */
    private SavedState f3659S;

    /* JADX INFO: renamed from: T */
    private final Rect f3660T;

    /* JADX INFO: renamed from: U */
    private final ArrayList<InterfaceC0614l> f3661U;

    /* JADX INFO: renamed from: V */
    private InterfaceC0614l f3662V;

    /* JADX INFO: renamed from: W */
    private int f3663W;

    /* JADX INFO: renamed from: aA */
    private List<AbstractC0615m> f3664aA;

    /* JADX INFO: renamed from: aB */
    private AbstractC0608f.b f3665aB;

    /* JADX INFO: renamed from: aC */
    private InterfaceC0606d f3666aC;

    /* JADX INFO: renamed from: aD */
    private final int[] f3667aD;

    /* JADX INFO: renamed from: aE */
    private NestedScrollingChildHelper f3668aE;

    /* JADX INFO: renamed from: aF */
    private final int[] f3669aF;

    /* JADX INFO: renamed from: aG */
    private final int[] f3670aG;

    /* JADX INFO: renamed from: aH */
    private Runnable f3671aH;

    /* JADX INFO: renamed from: aI */
    private final C1773hk.b f3672aI;

    /* JADX INFO: renamed from: aa */
    private boolean f3673aa;

    /* JADX INFO: renamed from: ab */
    private int f3674ab;

    /* JADX INFO: renamed from: ac */
    private final AccessibilityManager f3675ac;

    /* JADX INFO: renamed from: ad */
    private List<InterfaceC0612j> f3676ad;

    /* JADX INFO: renamed from: ae */
    private int f3677ae;

    /* JADX INFO: renamed from: af */
    private int f3678af;

    /* JADX INFO: renamed from: ag */
    private C0607e f3679ag;

    /* JADX INFO: renamed from: ah */
    private EdgeEffect f3680ah;

    /* JADX INFO: renamed from: ai */
    private EdgeEffect f3681ai;

    /* JADX INFO: renamed from: aj */
    private EdgeEffect f3682aj;

    /* JADX INFO: renamed from: ak */
    private EdgeEffect f3683ak;

    /* JADX INFO: renamed from: al */
    private int f3684al;

    /* JADX INFO: renamed from: am */
    private int f3685am;

    /* JADX INFO: renamed from: an */
    private VelocityTracker f3686an;

    /* JADX INFO: renamed from: ao */
    private int f3687ao;

    /* JADX INFO: renamed from: ap */
    private int f3688ap;

    /* JADX INFO: renamed from: aq */
    private int f3689aq;

    /* JADX INFO: renamed from: ar */
    private int f3690ar;

    /* JADX INFO: renamed from: as */
    private int f3691as;

    /* JADX INFO: renamed from: at */
    private AbstractC0613k f3692at;

    /* JADX INFO: renamed from: au */
    private final int f3693au;

    /* JADX INFO: renamed from: av */
    private final int f3694av;

    /* JADX INFO: renamed from: aw */
    private float f3695aw;

    /* JADX INFO: renamed from: ax */
    private float f3696ax;

    /* JADX INFO: renamed from: ay */
    private boolean f3697ay;

    /* JADX INFO: renamed from: az */
    private AbstractC0615m f3698az;

    /* JADX INFO: renamed from: e */
    public final C0617o f3699e;

    /* JADX INFO: renamed from: f */
    public C1723fo f3700f;

    /* JADX INFO: renamed from: g */
    public C1739gd f3701g;

    /* JADX INFO: renamed from: h */
    final C1773hk f3702h;

    /* JADX INFO: renamed from: i */
    boolean f3703i;

    /* JADX INFO: renamed from: j */
    final Runnable f3704j;

    /* JADX INFO: renamed from: k */
    final Rect f3705k;

    /* JADX INFO: renamed from: l */
    final RectF f3706l;

    /* JADX INFO: renamed from: m */
    public AbstractC0603a f3707m;

    /* JADX INFO: renamed from: n */
    public AbstractC0611i f3708n;

    /* JADX INFO: renamed from: o */
    InterfaceC0618p f3709o;

    /* JADX INFO: renamed from: p */
    final ArrayList<AbstractC0610h> f3710p;

    /* JADX INFO: renamed from: q */
    boolean f3711q;

    /* JADX INFO: renamed from: r */
    boolean f3712r;

    /* JADX INFO: renamed from: s */
    boolean f3713s;

    /* JADX INFO: renamed from: t */
    boolean f3714t;

    /* JADX INFO: renamed from: u */
    boolean f3715u;

    /* JADX INFO: renamed from: v */
    boolean f3716v;

    /* JADX INFO: renamed from: w */
    boolean f3717w;

    /* JADX INFO: renamed from: x */
    public boolean f3718x;

    /* JADX INFO: renamed from: y */
    boolean f3719y;

    /* JADX INFO: renamed from: z */
    AbstractC0608f f3720z;

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$c */
    public static abstract class AbstractC0605c {
        /* JADX INFO: renamed from: a */
        public void mo3882a() {
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$d */
    public interface InterfaceC0606d {
        /* JADX INFO: renamed from: a */
        int m3883a(int i, int i2);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$j */
    public interface InterfaceC0612j {
        /* JADX INFO: renamed from: a */
        void m4023a(View view);

        /* JADX INFO: renamed from: b */
        void m4024b(View view);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$k */
    public static abstract class AbstractC0613k {
        /* JADX INFO: renamed from: a */
        public abstract boolean m4025a(int i, int i2);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$l */
    public interface InterfaceC0614l {
        /* JADX INFO: renamed from: a */
        void mo4026a(boolean z);

        /* JADX INFO: renamed from: a */
        boolean mo4027a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* JADX INFO: renamed from: b */
        void mo4028b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$m */
    public static abstract class AbstractC0615m {
        /* JADX INFO: renamed from: a */
        public void m4029a(RecyclerView recyclerView, int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4030a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$p */
    public interface InterfaceC0618p {
        /* JADX INFO: renamed from: a */
        void m4082a(AbstractC0624v abstractC0624v);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$t */
    public static abstract class AbstractC0622t {
        /* JADX INFO: renamed from: a */
        public abstract View m4106a(C0617o c0617o, int i, int i2);
    }

    /* JADX INFO: renamed from: f */
    public void m3802f(int i) {
    }

    /* JADX INFO: renamed from: g */
    public void m3807g(View view) {
    }

    /* JADX INFO: renamed from: h */
    public void m3809h(int i, int i2) {
    }

    /* JADX INFO: renamed from: h */
    public void m3810h(View view) {
    }

    static {
        f3643a = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        f3644b = Build.VERSION.SDK_INT >= 23;
        f3645c = Build.VERSION.SDK_INT >= 16;
        f3646d = Build.VERSION.SDK_INT >= 21;
        f3640O = Build.VERSION.SDK_INT <= 15;
        f3641P = Build.VERSION.SDK_INT <= 15;
        f3642Q = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        f3637L = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3658R = new C0619q();
        this.f3699e = new C0617o();
        this.f3702h = new C1773hk();
        this.f3704j = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.f3714t || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.f3711q) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.f3716v) {
                    RecyclerView.this.f3715u = true;
                } else {
                    RecyclerView.this.m3794d();
                }
            }
        };
        this.f3705k = new Rect();
        this.f3660T = new Rect();
        this.f3706l = new RectF();
        this.f3710p = new ArrayList<>();
        this.f3661U = new ArrayList<>();
        this.f3663W = 0;
        this.f3718x = false;
        this.f3719y = false;
        this.f3677ae = 0;
        this.f3678af = 0;
        this.f3679ag = new C0607e();
        this.f3720z = new C1742gg();
        this.f3684al = 0;
        this.f3685am = -1;
        this.f3695aw = Float.MIN_VALUE;
        this.f3696ax = Float.MIN_VALUE;
        boolean z = true;
        this.f3697ay = true;
        this.f3647A = new RunnableC0623u();
        this.f3649C = f3646d ? new RunnableC1748gm.a() : null;
        this.f3650D = new C0621s();
        this.f3651E = false;
        this.f3652F = false;
        this.f3665aB = new C0609g();
        this.f3653G = false;
        this.f3667aD = new int[2];
        this.f3669aF = new int[2];
        this.f3655I = new int[2];
        this.f3670aG = new int[2];
        this.f3656J = new int[2];
        this.f3657K = new ArrayList();
        this.f3671aH = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.f3720z != null) {
                    RecyclerView.this.f3720z.mo3888a();
                }
                RecyclerView.this.f3653G = false;
            }
        };
        this.f3672aI = new C1773hk.b() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // p000.C1773hk.b
            /* JADX INFO: renamed from: a */
            public void mo3832a(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar, AbstractC0608f.c cVar2) {
                RecyclerView.this.f3699e.m4069c(abstractC0624v);
                RecyclerView.this.m3783b(abstractC0624v, cVar, cVar2);
            }

            @Override // p000.C1773hk.b
            /* JADX INFO: renamed from: b */
            public void mo3833b(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar, AbstractC0608f.c cVar2) {
                RecyclerView.this.m3770a(abstractC0624v, cVar, cVar2);
            }

            @Override // p000.C1773hk.b
            /* JADX INFO: renamed from: c */
            public void mo3834c(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar, AbstractC0608f.c cVar2) {
                abstractC0624v.m4127a(false);
                if (RecyclerView.this.f3718x) {
                    if (RecyclerView.this.f3720z.mo3891a(abstractC0624v, abstractC0624v, cVar, cVar2)) {
                        RecyclerView.this.m3822p();
                    }
                } else if (RecyclerView.this.f3720z.mo3895c(abstractC0624v, cVar, cVar2)) {
                    RecyclerView.this.m3822p();
                }
            }

            @Override // p000.C1773hk.b
            /* JADX INFO: renamed from: a */
            public void mo3831a(AbstractC0624v abstractC0624v) {
                RecyclerView.this.f3708n.m3951a(abstractC0624v.f3823a, RecyclerView.this.f3699e);
            }
        };
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3639N, i, 0);
            this.f3703i = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f3703i = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3691as = viewConfiguration.getScaledTouchSlop();
        this.f3695aw = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.f3696ax = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.f3693au = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3694av = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f3720z.m3889a(this.f3665aB);
        m3778b();
        m3752z();
        m3751y();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.f3675ac = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i, 0);
            String string = typedArrayObtainStyledAttributes2.getString(android.support.v7.recyclerview.R.styleable.RecyclerView_layoutManager);
            if (typedArrayObtainStyledAttributes2.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.f3713s = typedArrayObtainStyledAttributes2.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.f3713s) {
                m3763a((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            typedArrayObtainStyledAttributes2.recycle();
            m3731a(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f3638M, i, 0);
                boolean z2 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
                typedArrayObtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    /* JADX INFO: renamed from: a */
    String m3756a() {
        return " " + super.toString() + ", adapter:" + this.f3707m + ", layout:" + this.f3708n + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    /* JADX INFO: renamed from: y */
    private void m3751y() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f3654H;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f3654H = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.f3654H);
    }

    /* JADX INFO: renamed from: a */
    private void m3731a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strM3728a = m3728a(context, strTrim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> clsAsSubclass = classLoader.loadClass(strM3728a).asSubclass(AbstractC0611i.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(f3642Q);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strM3728a, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0611i) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strM3728a, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strM3728a, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strM3728a, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strM3728a, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strM3728a, e7);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private String m3728a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    /* JADX INFO: renamed from: z */
    private void m3752z() {
        this.f3701g = new C1739gd(new C1739gd.b() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: a */
            public int mo3835a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: a */
            public void mo3838a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.m3818l(view);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: a */
            public int mo3836a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: a */
            public void mo3837a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.m3816k(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: b */
            public View mo3841b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: b */
            public void mo3842b() {
                int iMo3835a = mo3835a();
                for (int i = 0; i < iMo3835a; i++) {
                    View viewMo3841b = mo3841b(i);
                    RecyclerView.this.m3816k(viewMo3841b);
                    viewMo3841b.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: b */
            public AbstractC0624v mo3840b(View view) {
                return RecyclerView.m3746e(view);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: a */
            public void mo3839a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
                if (abstractC0624vM3746e != null) {
                    if (!abstractC0624vM3746e.m4147r() && !abstractC0624vM3746e.m4132c()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + abstractC0624vM3746e + RecyclerView.this.m3756a());
                    }
                    abstractC0624vM3746e.m4142m();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: c */
            public void mo3843c(int i) {
                AbstractC0624v abstractC0624vM3746e;
                View viewMo3841b = mo3841b(i);
                if (viewMo3841b != null && (abstractC0624vM3746e = RecyclerView.m3746e(viewMo3841b)) != null) {
                    if (abstractC0624vM3746e.m4147r() && !abstractC0624vM3746e.m4132c()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + abstractC0624vM3746e + RecyclerView.this.m3756a());
                    }
                    abstractC0624vM3746e.m4130b(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: c */
            public void mo3844c(View view) {
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
                if (abstractC0624vM3746e != null) {
                    abstractC0624vM3746e.m4125a(RecyclerView.this);
                }
            }

            @Override // p000.C1739gd.b
            /* JADX INFO: renamed from: d */
            public void mo3845d(View view) {
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
                if (abstractC0624vM3746e != null) {
                    abstractC0624vM3746e.m4131b(RecyclerView.this);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    void m3778b() {
        this.f3700f = new C1723fo(new C1723fo.a() { // from class: android.support.v7.widget.RecyclerView.6
            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: a */
            public AbstractC0624v mo3846a(int i) {
                AbstractC0624v abstractC0624vM3754a = RecyclerView.this.m3754a(i, true);
                if (abstractC0624vM3754a == null || RecyclerView.this.f3701g.m9367c(abstractC0624vM3754a.f3823a)) {
                    return null;
                }
                return abstractC0624vM3754a;
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: a */
            public void mo3847a(int i, int i2) {
                RecyclerView.this.m3761a(i, i2, true);
                RecyclerView.this.f3651E = true;
                RecyclerView.this.f3650D.f3800c += i2;
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: b */
            public void mo3850b(int i, int i2) {
                RecyclerView.this.m3761a(i, i2, false);
                RecyclerView.this.f3651E = true;
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: a */
            public void mo3848a(int i, int i2, Object obj) {
                RecyclerView.this.m3760a(i, i2, obj);
                RecyclerView.this.f3652F = true;
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: a */
            public void mo3849a(C1723fo.b bVar) {
                m3853c(bVar);
            }

            /* JADX INFO: renamed from: c */
            void m3853c(C1723fo.b bVar) {
                int i = bVar.f9838a;
                if (i == 4) {
                    RecyclerView.this.f3708n.mo3557a(RecyclerView.this, bVar.f9839b, bVar.f9841d, bVar.f9840c);
                    return;
                }
                if (i != 8) {
                    switch (i) {
                        case 1:
                            RecyclerView.this.f3708n.mo3555a(RecyclerView.this, bVar.f9839b, bVar.f9841d);
                            break;
                        case 2:
                            RecyclerView.this.f3708n.mo3562b(RecyclerView.this, bVar.f9839b, bVar.f9841d);
                            break;
                    }
                    return;
                }
                RecyclerView.this.f3708n.mo3556a(RecyclerView.this, bVar.f9839b, bVar.f9841d, 1);
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: b */
            public void mo3851b(C1723fo.b bVar) {
                m3853c(bVar);
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: c */
            public void mo3852c(int i, int i2) {
                RecyclerView.this.m3806g(i, i2);
                RecyclerView.this.f3651E = true;
            }

            @Override // p000.C1723fo.a
            /* JADX INFO: renamed from: d */
            public void mo3854d(int i, int i2) {
                RecyclerView.this.m3803f(i, i2);
                RecyclerView.this.f3651E = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.f3712r = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f3703i) {
            m3815k();
        }
        this.f3703i = z;
        super.setClipToPadding(z);
        if (this.f3714t) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3703i;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f3691as = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f3691as = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(AbstractC0603a abstractC0603a) {
        setLayoutFrozen(false);
        m3732a(abstractC0603a, false, true);
        m3791c(false);
        requestLayout();
    }

    /* JADX INFO: renamed from: c */
    public void m3789c() {
        if (this.f3720z != null) {
            this.f3720z.mo3896d();
        }
        if (this.f3708n != null) {
            this.f3708n.m3973c(this.f3699e);
            this.f3708n.m3965b(this.f3699e);
        }
        this.f3699e.m4050a();
    }

    /* JADX INFO: renamed from: a */
    private void m3732a(AbstractC0603a abstractC0603a, boolean z, boolean z2) {
        if (this.f3707m != null) {
            this.f3707m.m3872b(this.f3658R);
            this.f3707m.m3874b(this);
        }
        if (!z || z2) {
            m3789c();
        }
        this.f3700f.m9199a();
        AbstractC0603a abstractC0603a2 = this.f3707m;
        this.f3707m = abstractC0603a;
        if (abstractC0603a != null) {
            abstractC0603a.m3865a(this.f3658R);
            abstractC0603a.m3869a(this);
        }
        if (this.f3708n != null) {
            this.f3708n.m3938a(abstractC0603a2, this.f3707m);
        }
        this.f3699e.m4054a(abstractC0603a2, this.f3707m, z);
        this.f3650D.f3803f = true;
    }

    public AbstractC0603a getAdapter() {
        return this.f3707m;
    }

    public void setRecyclerListener(InterfaceC0618p interfaceC0618p) {
        this.f3709o = interfaceC0618p;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.f3708n != null) {
            return this.f3708n.m4011u();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(AbstractC0611i abstractC0611i) {
        if (abstractC0611i == this.f3708n) {
            return;
        }
        m3801f();
        if (this.f3708n != null) {
            if (this.f3720z != null) {
                this.f3720z.mo3896d();
            }
            this.f3708n.m3973c(this.f3699e);
            this.f3708n.m3965b(this.f3699e);
            this.f3699e.m4050a();
            if (this.f3711q) {
                this.f3708n.m3967b(this, this.f3699e);
            }
            this.f3708n.m3966b((RecyclerView) null);
            this.f3708n = null;
        } else {
            this.f3699e.m4050a();
        }
        this.f3701g.m9356a();
        this.f3708n = abstractC0611i;
        if (abstractC0611i != null) {
            if (abstractC0611i.f3753q != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0611i + " is already attached to a RecyclerView:" + abstractC0611i.f3753q.m3756a());
            }
            this.f3708n.m3966b(this);
            if (this.f3711q) {
                this.f3708n.m3974c(this);
            }
        }
        this.f3699e.m4062b();
        requestLayout();
    }

    public void setOnFlingListener(AbstractC0613k abstractC0613k) {
        this.f3692at = abstractC0613k;
    }

    public AbstractC0613k getOnFlingListener() {
        return this.f3692at;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f3659S != null) {
            savedState.m3859a(this.f3659S);
        } else if (this.f3708n != null) {
            savedState.f3730a = this.f3708n.mo3640d();
        } else {
            savedState.f3730a = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.f3659S = (SavedState) parcelable;
        super.onRestoreInstanceState(this.f3659S.getSuperState());
        if (this.f3708n == null || this.f3659S.f3730a == null) {
            return;
        }
        this.f3708n.mo3626a(this.f3659S.f3730a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* JADX INFO: renamed from: e */
    private void m3747e(AbstractC0624v abstractC0624v) {
        View view = abstractC0624v.f3823a;
        boolean z = view.getParent() == this;
        this.f3699e.m4069c(m3777b(view));
        if (abstractC0624v.m4147r()) {
            this.f3701g.m9359a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f3701g.m9361a(view, true);
        } else {
            this.f3701g.m9369d(view);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3775a(View view) {
        m3797e();
        boolean zM9372f = this.f3701g.m9372f(view);
        if (zM9372f) {
            AbstractC0624v abstractC0624vM3746e = m3746e(view);
            this.f3699e.m4069c(abstractC0624vM3746e);
            this.f3699e.m4064b(abstractC0624vM3746e);
        }
        m3772a(!zM9372f);
        return zM9372f;
    }

    public AbstractC0611i getLayoutManager() {
        return this.f3708n;
    }

    public C0616n getRecycledViewPool() {
        return this.f3699e.m4078g();
    }

    public void setRecycledViewPool(C0616n c0616n) {
        this.f3699e.m4055a(c0616n);
    }

    public void setViewCacheExtension(AbstractC0622t abstractC0622t) {
        this.f3699e.m4056a(abstractC0622t);
    }

    public void setItemViewCacheSize(int i) {
        this.f3699e.m4051a(i);
    }

    public int getScrollState() {
        return this.f3684al;
    }

    void setScrollState(int i) {
        if (i == this.f3684al) {
            return;
        }
        this.f3684al = i;
        if (i != 2) {
            m3714B();
        }
        m3805g(i);
    }

    /* JADX INFO: renamed from: a */
    public void m3765a(AbstractC0610h abstractC0610h, int i) {
        if (this.f3708n != null) {
            this.f3708n.mo3629a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3710p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f3710p.add(abstractC0610h);
        } else {
            this.f3710p.add(i, abstractC0610h);
        }
        m3824r();
        requestLayout();
    }

    /* JADX INFO: renamed from: a */
    public void m3764a(AbstractC0610h abstractC0610h) {
        m3765a(abstractC0610h, -1);
    }

    public int getItemDecorationCount() {
        return this.f3710p.size();
    }

    /* JADX INFO: renamed from: b */
    public void m3780b(AbstractC0610h abstractC0610h) {
        if (this.f3708n != null) {
            this.f3708n.mo3629a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3710p.remove(abstractC0610h);
        if (this.f3710p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m3824r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0606d interfaceC0606d) {
        if (interfaceC0606d == this.f3666aC) {
            return;
        }
        this.f3666aC = interfaceC0606d;
        setChildrenDrawingOrderEnabled(this.f3666aC != null);
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0615m abstractC0615m) {
        this.f3698az = abstractC0615m;
    }

    /* JADX INFO: renamed from: a */
    public void m3767a(AbstractC0615m abstractC0615m) {
        if (this.f3664aA == null) {
            this.f3664aA = new ArrayList();
        }
        this.f3664aA.add(abstractC0615m);
    }

    /* JADX INFO: renamed from: b */
    public void m3782b(AbstractC0615m abstractC0615m) {
        if (this.f3664aA != null) {
            this.f3664aA.remove(abstractC0615m);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3757a(int i) {
        if (this.f3716v) {
            return;
        }
        m3801f();
        if (this.f3708n == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            this.f3708n.mo3642e(i);
            awakenScrollBars();
        }
    }

    /* JADX INFO: renamed from: b */
    void m3779b(int i) {
        if (this.f3708n == null) {
            return;
        }
        this.f3708n.mo3642e(i);
        awakenScrollBars();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.f3708n == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3716v) {
            return;
        }
        boolean zMo3643e = this.f3708n.mo3643e();
        boolean zMo3646f = this.f3708n.mo3646f();
        if (zMo3643e || zMo3646f) {
            if (!zMo3643e) {
                i = 0;
            }
            if (!zMo3646f) {
                i2 = 0;
            }
            m3773a(i, i2, (MotionEvent) null);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3762a(int i, int i2, int[] iArr) {
        m3797e();
        m3817l();
        TraceCompat.beginSection("RV Scroll");
        m3768a(this.f3650D);
        int iMo3540a = i != 0 ? this.f3708n.mo3540a(i, this.f3699e, this.f3650D) : 0;
        int iMo3560b = i2 != 0 ? this.f3708n.mo3560b(i2, this.f3699e, this.f3650D) : 0;
        TraceCompat.endSection();
        m3829w();
        m3819m();
        m3772a(false);
        if (iArr != null) {
            iArr[0] = iMo3540a;
            iArr[1] = iMo3560b;
        }
    }

    /* JADX INFO: renamed from: d */
    void m3794d() {
        if (!this.f3714t || this.f3718x) {
            TraceCompat.beginSection("RV FullInvalidate");
            m3823q();
            TraceCompat.endSection();
            return;
        }
        if (this.f3700f.m9208d()) {
            if (this.f3700f.m9203a(4) && !this.f3700f.m9203a(11)) {
                TraceCompat.beginSection("RV PartialInvalidate");
                m3797e();
                m3817l();
                this.f3700f.m9205b();
                if (!this.f3715u) {
                    if (m3713A()) {
                        m3823q();
                    } else {
                        this.f3700f.m9207c();
                    }
                }
                m3772a(true);
                m3819m();
                TraceCompat.endSection();
                return;
            }
            if (this.f3700f.m9208d()) {
                TraceCompat.beginSection("RV FullInvalidate");
                m3823q();
                TraceCompat.endSection();
            }
        }
    }

    /* JADX INFO: renamed from: A */
    private boolean m3713A() {
        int iM9362b = this.f3701g.m9362b();
        for (int i = 0; i < iM9362b; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9364b(i));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4132c() && abstractC0624vM3746e.m4155z()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    boolean m3773a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        m3794d();
        if (this.f3707m != null) {
            m3762a(i, i2, this.f3656J);
            int i7 = this.f3656J[0];
            int i8 = this.f3656J[1];
            i4 = i7;
            i5 = i8;
            i6 = i - i7;
            i3 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.f3710p.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (dispatchNestedScroll(i4, i5, i6, i3, this.f3669aF, 0)) {
            this.f3689aq -= this.f3669aF[0];
            this.f3690ar -= this.f3669aF[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.f3669aF[0], this.f3669aF[1]);
            }
            int[] iArr = this.f3670aG;
            iArr[0] = iArr[0] + this.f3669aF[0];
            int[] iArr2 = this.f3670aG;
            iArr2[1] = iArr2[1] + this.f3669aF[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                m3729a(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            m3790c(i, i2);
        }
        if (i4 != 0 || i5 != 0) {
            m3813i(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        if (this.f3708n != null && this.f3708n.mo3643e()) {
            return this.f3708n.mo3635c(this.f3650D);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        if (this.f3708n != null && this.f3708n.mo3643e()) {
            return this.f3708n.mo3641e(this.f3650D);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollRange() {
        if (this.f3708n != null && this.f3708n.mo3643e()) {
            return this.f3708n.mo3648g(this.f3650D);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        if (this.f3708n != null && this.f3708n.mo3646f()) {
            return this.f3708n.mo3638d(this.f3650D);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        if (this.f3708n != null && this.f3708n.mo3646f()) {
            return this.f3708n.mo3645f(this.f3650D);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollRange() {
        if (this.f3708n != null && this.f3708n.mo3646f()) {
            return this.f3708n.mo3649h(this.f3650D);
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    void m3797e() {
        this.f3663W++;
        if (this.f3663W != 1 || this.f3716v) {
            return;
        }
        this.f3715u = false;
    }

    /* JADX INFO: renamed from: a */
    void m3772a(boolean z) {
        if (this.f3663W < 1) {
            this.f3663W = 1;
        }
        if (!z && !this.f3716v) {
            this.f3715u = false;
        }
        if (this.f3663W == 1) {
            if (z && this.f3715u && !this.f3716v && this.f3708n != null && this.f3707m != null) {
                m3823q();
            }
            if (!this.f3716v) {
                this.f3715u = false;
            }
        }
        this.f3663W--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f3716v) {
            m3771a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f3716v = false;
                if (this.f3715u && this.f3708n != null && this.f3707m != null) {
                    requestLayout();
                }
                this.f3715u = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3716v = true;
            this.f3673aa = true;
            m3801f();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3758a(int i, int i2) {
        m3759a(i, i2, (Interpolator) null);
    }

    /* JADX INFO: renamed from: a */
    public void m3759a(int i, int i2, Interpolator interpolator) {
        if (this.f3708n == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3716v) {
            return;
        }
        if (!this.f3708n.mo3643e()) {
            i = 0;
        }
        if (!this.f3708n.mo3646f()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.f3647A.m4116a(i, i2, interpolator);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3785b(int i, int i2) {
        if (this.f3708n == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f3716v) {
            return false;
        }
        boolean zMo3643e = this.f3708n.mo3643e();
        boolean zMo3646f = this.f3708n.mo3646f();
        if (!zMo3643e || Math.abs(i) < this.f3693au) {
            i = 0;
        }
        if (!zMo3646f || Math.abs(i2) < this.f3693au) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = zMo3643e || zMo3646f;
            dispatchNestedFling(f, f2, z);
            if (this.f3692at != null && this.f3692at.m4025a(i, i2)) {
                return true;
            }
            if (z) {
                int i3 = zMo3643e ? 1 : 0;
                if (zMo3646f) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 1);
                this.f3647A.m4112a(Math.max(-this.f3694av, Math.min(i, this.f3694av)), Math.max(-this.f3694av, Math.min(i2, this.f3694av)));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public void m3801f() {
        setScrollState(0);
        m3714B();
    }

    /* JADX INFO: renamed from: B */
    private void m3714B() {
        this.f3647A.m4117b();
        if (this.f3708n != null) {
            this.f3708n.m3933H();
        }
    }

    public int getMinFlingVelocity() {
        return this.f3693au;
    }

    public int getMaxFlingVelocity() {
        return this.f3694av;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m3729a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.m3804g()
            android.widget.EdgeEffect r1 = r6.f3680ah
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            android.support.v4.widget.EdgeEffectCompat.onPull(r1, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.m3808h()
            android.widget.EdgeEffect r1 = r6.f3682aj
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            android.support.v4.widget.EdgeEffectCompat.onPull(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.m3812i()
            android.widget.EdgeEffect r9 = r6.f3681ai
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            android.support.v4.widget.EdgeEffectCompat.onPull(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.m3814j()
            android.widget.EdgeEffect r9 = r6.f3683ak
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            android.support.v4.widget.EdgeEffectCompat.onPull(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.m3729a(float, float, float, float):void");
    }

    /* JADX INFO: renamed from: C */
    private void m3715C() {
        boolean zIsFinished;
        if (this.f3680ah != null) {
            this.f3680ah.onRelease();
            zIsFinished = this.f3680ah.isFinished();
        } else {
            zIsFinished = false;
        }
        if (this.f3681ai != null) {
            this.f3681ai.onRelease();
            zIsFinished |= this.f3681ai.isFinished();
        }
        if (this.f3682aj != null) {
            this.f3682aj.onRelease();
            zIsFinished |= this.f3682aj.isFinished();
        }
        if (this.f3683ak != null) {
            this.f3683ak.onRelease();
            zIsFinished |= this.f3683ak.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: renamed from: c */
    void m3790c(int i, int i2) {
        boolean zIsFinished;
        if (this.f3680ah == null || this.f3680ah.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.f3680ah.onRelease();
            zIsFinished = this.f3680ah.isFinished();
        }
        if (this.f3682aj != null && !this.f3682aj.isFinished() && i < 0) {
            this.f3682aj.onRelease();
            zIsFinished |= this.f3682aj.isFinished();
        }
        if (this.f3681ai != null && !this.f3681ai.isFinished() && i2 > 0) {
            this.f3681ai.onRelease();
            zIsFinished |= this.f3681ai.isFinished();
        }
        if (this.f3683ak != null && !this.f3683ak.isFinished() && i2 < 0) {
            this.f3683ak.onRelease();
            zIsFinished |= this.f3683ak.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: renamed from: d */
    void m3796d(int i, int i2) {
        if (i < 0) {
            m3804g();
            this.f3680ah.onAbsorb(-i);
        } else if (i > 0) {
            m3808h();
            this.f3682aj.onAbsorb(i);
        }
        if (i2 < 0) {
            m3812i();
            this.f3681ai.onAbsorb(-i2);
        } else if (i2 > 0) {
            m3814j();
            this.f3683ak.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX INFO: renamed from: g */
    void m3804g() {
        if (this.f3680ah != null) {
            return;
        }
        this.f3680ah = this.f3679ag.m3884a(this, 0);
        if (this.f3703i) {
            this.f3680ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.f3680ah.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: renamed from: h */
    void m3808h() {
        if (this.f3682aj != null) {
            return;
        }
        this.f3682aj = this.f3679ag.m3884a(this, 2);
        if (this.f3703i) {
            this.f3682aj.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.f3682aj.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: renamed from: i */
    void m3812i() {
        if (this.f3681ai != null) {
            return;
        }
        this.f3681ai = this.f3679ag.m3884a(this, 1);
        if (this.f3703i) {
            this.f3681ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.f3681ai.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: renamed from: j */
    void m3814j() {
        if (this.f3683ak != null) {
            return;
        }
        this.f3683ak = this.f3679ag.m3884a(this, 3);
        if (this.f3703i) {
            this.f3683ak.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.f3683ak.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: renamed from: k */
    void m3815k() {
        this.f3683ak = null;
        this.f3681ai = null;
        this.f3682aj = null;
        this.f3680ah = null;
    }

    public void setEdgeEffectFactory(C0607e c0607e) {
        Preconditions.checkNotNull(c0607e);
        this.f3679ag = c0607e;
        m3815k();
    }

    public C0607e getEdgeEffectFactory() {
        return this.f3679ag;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewMo3546a;
        boolean z;
        View viewM3980d = this.f3708n.m3980d(view, i);
        if (viewM3980d != null) {
            return viewM3980d;
        }
        boolean z2 = (this.f3707m == null || this.f3708n == null || m3821o() || this.f3716v) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.f3708n.mo3646f()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (f3640O) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f3708n.mo3643e()) {
                int i3 = (this.f3708n.m4010t() == 1) ^ (i == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (f3640O) {
                    i = i3;
                }
            }
            if (z) {
                m3794d();
                if (m3788c(view) == null) {
                    return null;
                }
                m3797e();
                this.f3708n.mo3546a(view, i, this.f3699e, this.f3650D);
                m3772a(false);
            }
            viewMo3546a = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                m3794d();
                if (m3788c(view) == null) {
                    return null;
                }
                m3797e();
                viewMo3546a = this.f3708n.mo3546a(view, i, this.f3699e, this.f3650D);
                m3772a(false);
            } else {
                viewMo3546a = viewFindNextFocus;
            }
        }
        if (viewMo3546a == null || viewMo3546a.hasFocusable()) {
            return m3742a(view, viewMo3546a, i) ? viewMo3546a : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        m3738a(viewMo3546a, (View) null);
        return view;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3742a(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || m3788c(view2) == null) {
            return false;
        }
        if (view == null || m3788c(view) == null) {
            return true;
        }
        this.f3705k.set(0, 0, view.getWidth(), view.getHeight());
        this.f3660T.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3705k);
        offsetDescendantRectToMyCoords(view2, this.f3660T);
        byte b = -1;
        int i3 = this.f3708n.m4010t() == 1 ? -1 : 1;
        if ((this.f3705k.left < this.f3660T.left || this.f3705k.right <= this.f3660T.left) && this.f3705k.right < this.f3660T.right) {
            i2 = 1;
        } else {
            i2 = ((this.f3705k.right > this.f3660T.right || this.f3705k.left >= this.f3660T.right) && this.f3705k.left > this.f3660T.left) ? -1 : 0;
        }
        if ((this.f3705k.top < this.f3660T.top || this.f3705k.bottom <= this.f3660T.top) && this.f3705k.bottom < this.f3660T.bottom) {
            b = 1;
        } else if ((this.f3705k.bottom <= this.f3660T.bottom && this.f3705k.top < this.f3660T.bottom) || this.f3705k.top <= this.f3660T.top) {
            b = 0;
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b > 0;
        }
        switch (i) {
            case 1:
                return b < 0 || (b == 0 && i2 * i3 <= 0);
            case 2:
                return b > 0 || (b == 0 && i2 * i3 >= 0);
            default:
                throw new IllegalArgumentException("Invalid direction: " + i + m3756a());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3708n.m3956a(this, this.f3650D, view, view2) && view2 != null) {
            m3738a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    /* JADX INFO: renamed from: a */
    private void m3738a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3705k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f3728e) {
                Rect rect = layoutParams2.f3727d;
                this.f3705k.left -= rect.left;
                this.f3705k.right += rect.right;
                this.f3705k.top -= rect.top;
                this.f3705k.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3705k);
            offsetRectIntoDescendantCoords(view, this.f3705k);
        }
        this.f3708n.m3958a(this, view, this.f3705k, !this.f3714t, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f3708n.m3957a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f3708n == null || !this.f3708n.m3960a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (m3821o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.f3677ae = r0
            r1 = 1
            r4.f3711q = r1
            boolean r2 = r4.f3714t
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.f3714t = r1
            android.support.v7.widget.RecyclerView$i r1 = r4.f3708n
            if (r1 == 0) goto L20
            android.support.v7.widget.RecyclerView$i r1 = r4.f3708n
            r1.m3974c(r4)
        L20:
            r4.f3653G = r0
            boolean r0 = android.support.v7.widget.RecyclerView.f3646d
            if (r0 == 0) goto L6b
            java.lang.ThreadLocal<gm> r0 = p000.RunnableC1748gm.f10031a
            java.lang.Object r0 = r0.get()
            gm r0 = (p000.RunnableC1748gm) r0
            r4.f3648B = r0
            gm r0 = r4.f3648B
            if (r0 != 0) goto L66
            gm r0 = new gm
            r0.<init>()
            r4.f3648B = r0
            android.view.Display r0 = android.support.v4.view.ViewCompat.getDisplay(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L54
            if (r0 == 0) goto L54
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L54
            goto L56
        L54:
            r0 = 1114636288(0x42700000, float:60.0)
        L56:
            gm r1 = r4.f3648B
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f10035d = r2
            java.lang.ThreadLocal<gm> r0 = p000.RunnableC1748gm.f10031a
            gm r1 = r4.f3648B
            r0.set(r1)
        L66:
            gm r0 = r4.f3648B
            r0.m9476a(r4)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3720z != null) {
            this.f3720z.mo3896d();
        }
        m3801f();
        this.f3711q = false;
        if (this.f3708n != null) {
            this.f3708n.m3967b(this, this.f3699e);
        }
        this.f3657K.clear();
        removeCallbacks(this.f3671aH);
        this.f3702h.m9666b();
        if (!f3646d || this.f3648B == null) {
            return;
        }
        this.f3648B.m9478b(this);
        this.f3648B = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f3711q;
    }

    /* JADX INFO: renamed from: a */
    void m3771a(String str) {
        if (m3821o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + m3756a());
            }
            throw new IllegalStateException(str);
        }
        if (this.f3678af > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + m3756a()));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3766a(InterfaceC0614l interfaceC0614l) {
        this.f3661U.add(interfaceC0614l);
    }

    /* JADX INFO: renamed from: b */
    public void m3781b(InterfaceC0614l interfaceC0614l) {
        this.f3661U.remove(interfaceC0614l);
        if (this.f3662V == interfaceC0614l) {
            this.f3662V = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3741a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f3662V = null;
        }
        int size = this.f3661U.size();
        for (int i = 0; i < size; i++) {
            InterfaceC0614l interfaceC0614l = this.f3661U.get(i);
            if (interfaceC0614l.mo4027a(this, motionEvent) && action != 3) {
                this.f3662V = interfaceC0614l;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3743b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f3662V != null) {
            if (action == 0) {
                this.f3662V = null;
            } else {
                this.f3662V.mo4028b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f3662V = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f3661U.size();
            for (int i = 0; i < size; i++) {
                InterfaceC0614l interfaceC0614l = this.f3661U.get(i);
                if (interfaceC0614l.mo4027a(this, motionEvent)) {
                    this.f3662V = interfaceC0614l;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f3716v) {
            return false;
        }
        if (m3741a(motionEvent)) {
            m3717E();
            return true;
        }
        if (this.f3708n == null) {
            return false;
        }
        boolean zMo3643e = this.f3708n.mo3643e();
        boolean zMo3646f = this.f3708n.mo3646f();
        if (this.f3686an == null) {
            this.f3686an = VelocityTracker.obtain();
        }
        this.f3686an.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.f3673aa) {
                    this.f3673aa = false;
                }
                this.f3685am = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.f3689aq = x;
                this.f3687ao = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.f3690ar = y;
                this.f3688ap = y;
                if (this.f3684al == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.f3670aG;
                this.f3670aG[1] = 0;
                iArr[0] = 0;
                int i = zMo3643e ? 1 : 0;
                if (zMo3646f) {
                    i |= 2;
                }
                startNestedScroll(i, 0);
                break;
            case 1:
                this.f3686an.clear();
                stopNestedScroll(0);
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3685am);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3685am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                if (this.f3684al != 1) {
                    int i2 = x2 - this.f3687ao;
                    int i3 = y2 - this.f3688ap;
                    if (!zMo3643e || Math.abs(i2) <= this.f3691as) {
                        z = false;
                    } else {
                        this.f3689aq = x2;
                        z = true;
                    }
                    if (zMo3646f && Math.abs(i3) > this.f3691as) {
                        this.f3690ar = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                break;
                break;
            case 3:
                m3717E();
                break;
            case 5:
                this.f3685am = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f3689aq = x3;
                this.f3687ao = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f3690ar = y3;
                this.f3688ap = y3;
                break;
            case 6:
                m3745c(motionEvent);
                break;
        }
        return this.f3684al == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f3661U.size();
        for (int i = 0; i < size; i++) {
            this.f3661U.get(i).mo4026a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.f3716v || this.f3673aa) {
            return false;
        }
        if (m3743b(motionEvent)) {
            m3717E();
            return true;
        }
        if (this.f3708n == null) {
            return false;
        }
        boolean zMo3643e = this.f3708n.mo3643e();
        boolean zMo3646f = this.f3708n.mo3646f();
        if (this.f3686an == null) {
            this.f3686an = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f3670aG;
            this.f3670aG[1] = 0;
            iArr[0] = 0;
        }
        motionEventObtain.offsetLocation(this.f3670aG[0], this.f3670aG[1]);
        switch (actionMasked) {
            case 0:
                this.f3685am = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.f3689aq = x;
                this.f3687ao = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.f3690ar = y;
                this.f3688ap = y;
                int i = zMo3643e ? 1 : 0;
                if (zMo3646f) {
                    i |= 2;
                }
                startNestedScroll(i, 0);
                break;
            case 1:
                this.f3686an.addMovement(motionEventObtain);
                this.f3686an.computeCurrentVelocity(1000, this.f3694av);
                float f = zMo3643e ? -this.f3686an.getXVelocity(this.f3685am) : 0.0f;
                float f2 = zMo3646f ? -this.f3686an.getYVelocity(this.f3685am) : 0.0f;
                if ((f == 0.0f && f2 == 0.0f) || !m3785b((int) f, (int) f2)) {
                    setScrollState(0);
                }
                m3716D();
                z2 = true;
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3685am);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3685am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int i2 = this.f3689aq - x2;
                int i3 = this.f3690ar - y2;
                if (dispatchNestedPreScroll(i2, i3, this.f3655I, this.f3669aF, 0)) {
                    i2 -= this.f3655I[0];
                    i3 -= this.f3655I[1];
                    motionEventObtain.offsetLocation(this.f3669aF[0], this.f3669aF[1]);
                    int[] iArr2 = this.f3670aG;
                    iArr2[0] = iArr2[0] + this.f3669aF[0];
                    int[] iArr3 = this.f3670aG;
                    iArr3[1] = iArr3[1] + this.f3669aF[1];
                }
                if (this.f3684al != 1) {
                    if (!zMo3643e || Math.abs(i2) <= this.f3691as) {
                        z = false;
                    } else {
                        if (i2 > 0) {
                            i2 -= this.f3691as;
                        } else {
                            i2 += this.f3691as;
                        }
                        z = true;
                    }
                    if (zMo3646f && Math.abs(i3) > this.f3691as) {
                        if (i3 > 0) {
                            i3 -= this.f3691as;
                        } else {
                            i3 += this.f3691as;
                        }
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                if (this.f3684al == 1) {
                    this.f3689aq = x2 - this.f3669aF[0];
                    this.f3690ar = y2 - this.f3669aF[1];
                    if (m3773a(zMo3643e ? i2 : 0, zMo3646f ? i3 : 0, motionEventObtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.f3648B != null && (i2 != 0 || i3 != 0)) {
                        this.f3648B.m9477a(this, i2, i3);
                    }
                }
                break;
                break;
            case 3:
                m3717E();
                break;
            case 5:
                this.f3685am = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f3689aq = x3;
                this.f3687ao = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f3690ar = y3;
                this.f3688ap = y3;
                break;
            case 6:
                m3745c(motionEvent);
                break;
        }
        if (!z2) {
            this.f3686an.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    /* JADX INFO: renamed from: D */
    private void m3716D() {
        if (this.f3686an != null) {
            this.f3686an.clear();
        }
        stopNestedScroll(0);
        m3715C();
    }

    /* JADX INFO: renamed from: E */
    private void m3717E() {
        m3716D();
        setScrollState(0);
    }

    /* JADX INFO: renamed from: c */
    private void m3745c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3685am) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f3685am = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f3689aq = x;
            this.f3687ao = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f3690ar = y;
            this.f3688ap = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.RecyclerView$i r0 = r5.f3708n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f3716v
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            android.support.v7.widget.RecyclerView$i r0 = r5.f3708n
            boolean r0 = r0.mo3646f()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            android.support.v7.widget.RecyclerView$i r3 = r5.f3708n
            boolean r3 = r3.mo3643e()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            android.support.v7.widget.RecyclerView$i r3 = r5.f3708n
            boolean r3 = r3.mo3646f()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            android.support.v7.widget.RecyclerView$i r3 = r5.f3708n
            boolean r3 = r3.mo3643e()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.f3695aw
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3696ax
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.m3773a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f3708n == null) {
            m3799e(i, i2);
            return;
        }
        boolean z = false;
        if (this.f3708n.mo3637c()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f3708n.m3940a(this.f3699e, this.f3650D, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.f3707m == null) {
                return;
            }
            if (this.f3650D.f3801d == 1) {
                m3725M();
            }
            this.f3708n.m3972c(i, i2);
            this.f3650D.f3806i = true;
            m3726N();
            this.f3708n.m3981d(i, i2);
            if (this.f3708n.mo3654l()) {
                this.f3708n.m3972c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f3650D.f3806i = true;
                m3726N();
                this.f3708n.m3981d(i, i2);
                return;
            }
            return;
        }
        if (this.f3712r) {
            this.f3708n.m3940a(this.f3699e, this.f3650D, i, i2);
            return;
        }
        if (this.f3717w) {
            m3797e();
            m3817l();
            m3720H();
            m3819m();
            if (this.f3650D.f3808k) {
                this.f3650D.f3804g = true;
            } else {
                this.f3700f.m9209e();
                this.f3650D.f3804g = false;
            }
            this.f3717w = false;
            m3772a(false);
        } else if (this.f3650D.f3808k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        if (this.f3707m != null) {
            this.f3650D.f3802e = this.f3707m.mo3863a();
        } else {
            this.f3650D.f3802e = 0;
        }
        m3797e();
        this.f3708n.m3940a(this.f3699e, this.f3650D, i, i2);
        m3772a(false);
        this.f3650D.f3804g = false;
    }

    /* JADX INFO: renamed from: e */
    void m3799e(int i, int i2) {
        setMeasuredDimension(AbstractC0611i.m3917a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), AbstractC0611i.m3917a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        m3815k();
    }

    public void setItemAnimator(AbstractC0608f abstractC0608f) {
        if (this.f3720z != null) {
            this.f3720z.mo3896d();
            this.f3720z.m3889a(null);
        }
        this.f3720z = abstractC0608f;
        if (this.f3720z != null) {
            this.f3720z.m3889a(this.f3665aB);
        }
    }

    /* JADX INFO: renamed from: l */
    public void m3817l() {
        this.f3677ae++;
    }

    /* JADX INFO: renamed from: m */
    void m3819m() {
        m3784b(true);
    }

    /* JADX INFO: renamed from: b */
    public void m3784b(boolean z) {
        this.f3677ae--;
        if (this.f3677ae < 1) {
            this.f3677ae = 0;
            if (z) {
                m3718F();
                m3830x();
            }
        }
    }

    /* JADX INFO: renamed from: n */
    boolean m3820n() {
        return this.f3675ac != null && this.f3675ac.isEnabled();
    }

    /* JADX INFO: renamed from: F */
    private void m3718F() {
        int i = this.f3674ab;
        this.f3674ab = 0;
        if (i == 0 || !m3820n()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEventObtain, i);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    /* JADX INFO: renamed from: o */
    public boolean m3821o() {
        return this.f3677ae > 0;
    }

    /* JADX INFO: renamed from: a */
    boolean m3776a(AccessibilityEvent accessibilityEvent) {
        if (!m3821o()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes == 0) {
            contentChangeTypes = 0;
        }
        this.f3674ab = contentChangeTypes | this.f3674ab;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (m3776a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public AbstractC0608f getItemAnimator() {
        return this.f3720z;
    }

    /* JADX INFO: renamed from: p */
    void m3822p() {
        if (this.f3653G || !this.f3711q) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.f3671aH);
        this.f3653G = true;
    }

    /* JADX INFO: renamed from: G */
    private boolean m3719G() {
        return this.f3720z != null && this.f3708n.mo3563b();
    }

    /* JADX INFO: renamed from: H */
    private void m3720H() {
        if (this.f3718x) {
            this.f3700f.m9199a();
            if (this.f3719y) {
                this.f3708n.mo3554a(this);
            }
        }
        if (m3719G()) {
            this.f3700f.m9205b();
        } else {
            this.f3700f.m9209e();
        }
        boolean z = this.f3651E || this.f3652F;
        this.f3650D.f3807j = this.f3714t && this.f3720z != null && (this.f3718x || z || this.f3708n.f3757u) && (!this.f3718x || this.f3707m.m3879e());
        this.f3650D.f3808k = this.f3650D.f3807j && z && !this.f3718x && m3719G();
    }

    /* JADX INFO: renamed from: q */
    void m3823q() {
        if (this.f3707m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f3708n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.f3650D.f3806i = false;
        if (this.f3650D.f3801d == 1) {
            m3725M();
            this.f3708n.m3989f(this);
            m3726N();
        } else if (this.f3700f.m9210f() || this.f3708n.m4015y() != getWidth() || this.f3708n.m4016z() != getHeight()) {
            this.f3708n.m3989f(this);
            m3726N();
        } else {
            this.f3708n.m3989f(this);
        }
        m3727O();
    }

    /* JADX INFO: renamed from: I */
    private void m3721I() {
        int iM4134e;
        View focusedChild = (this.f3697ay && hasFocus() && this.f3707m != null) ? getFocusedChild() : null;
        AbstractC0624v abstractC0624vM3793d = focusedChild != null ? m3793d(focusedChild) : null;
        if (abstractC0624vM3793d == null) {
            m3722J();
            return;
        }
        this.f3650D.f3810m = this.f3707m.m3879e() ? abstractC0624vM3793d.m4136g() : -1L;
        C0621s c0621s = this.f3650D;
        if (this.f3718x) {
            iM4134e = -1;
        } else {
            iM4134e = abstractC0624vM3793d.m4146q() ? abstractC0624vM3793d.f3826d : abstractC0624vM3793d.m4134e();
        }
        c0621s.f3809l = iM4134e;
        this.f3650D.f3811n = m3750m(abstractC0624vM3793d.f3823a);
    }

    /* JADX INFO: renamed from: J */
    private void m3722J() {
        this.f3650D.f3810m = -1L;
        this.f3650D.f3809l = -1;
        this.f3650D.f3811n = -1;
    }

    /* JADX INFO: renamed from: K */
    private View m3723K() {
        AbstractC0624v abstractC0624vM3787c;
        int i = this.f3650D.f3809l != -1 ? this.f3650D.f3809l : 0;
        int iM4105e = this.f3650D.m4105e();
        for (int i2 = i; i2 < iM4105e; i2++) {
            AbstractC0624v abstractC0624vM3787c2 = m3787c(i2);
            if (abstractC0624vM3787c2 == null) {
                break;
            }
            if (abstractC0624vM3787c2.f3823a.hasFocusable()) {
                return abstractC0624vM3787c2.f3823a;
            }
        }
        int iMin = Math.min(iM4105e, i);
        do {
            iMin--;
            if (iMin < 0 || (abstractC0624vM3787c = m3787c(iMin)) == null) {
                return null;
            }
        } while (!abstractC0624vM3787c.f3823a.hasFocusable());
        return abstractC0624vM3787c.f3823a;
    }

    /* JADX INFO: renamed from: L */
    private void m3724L() {
        View viewFindViewById;
        if (!this.f3697ay || this.f3707m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (f3641P && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.f3701g.m9362b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.f3701g.m9367c(focusedChild)) {
                return;
            }
        }
        View viewM3723K = null;
        AbstractC0624v abstractC0624vM3755a = (this.f3650D.f3810m == -1 || !this.f3707m.m3879e()) ? null : m3755a(this.f3650D.f3810m);
        if (abstractC0624vM3755a == null || this.f3701g.m9367c(abstractC0624vM3755a.f3823a) || !abstractC0624vM3755a.f3823a.hasFocusable()) {
            if (this.f3701g.m9362b() > 0) {
                viewM3723K = m3723K();
            }
        } else {
            viewM3723K = abstractC0624vM3755a.f3823a;
        }
        if (viewM3723K != null) {
            if (this.f3650D.f3811n != -1 && (viewFindViewById = viewM3723K.findViewById(this.f3650D.f3811n)) != null && viewFindViewById.isFocusable()) {
                viewM3723K = viewFindViewById;
            }
            viewM3723K.requestFocus();
        }
    }

    /* JADX INFO: renamed from: m */
    private int m3750m(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* JADX INFO: renamed from: a */
    final void m3768a(C0621s c0621s) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f3647A.f3815a;
            c0621s.f3812o = overScroller.getFinalX() - overScroller.getCurrX();
            c0621s.f3813p = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            c0621s.f3812o = 0;
            c0621s.f3813p = 0;
        }
    }

    /* JADX INFO: renamed from: M */
    private void m3725M() {
        this.f3650D.m4099a(1);
        m3768a(this.f3650D);
        this.f3650D.f3806i = false;
        m3797e();
        this.f3702h.m9660a();
        m3817l();
        m3720H();
        m3721I();
        this.f3650D.f3805h = this.f3650D.f3807j && this.f3652F;
        this.f3652F = false;
        this.f3651E = false;
        this.f3650D.f3804g = this.f3650D.f3808k;
        this.f3650D.f3802e = this.f3707m.mo3863a();
        m3739a(this.f3667aD);
        if (this.f3650D.f3807j) {
            int iM9362b = this.f3701g.m9362b();
            for (int i = 0; i < iM9362b; i++) {
                AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9364b(i));
                if (!abstractC0624vM3746e.m4132c() && (!abstractC0624vM3746e.m4143n() || this.f3707m.m3879e())) {
                    this.f3702h.m9662a(abstractC0624vM3746e, this.f3720z.m3887a(this.f3650D, abstractC0624vM3746e, AbstractC0608f.m3885e(abstractC0624vM3746e), abstractC0624vM3746e.m4150u()));
                    if (this.f3650D.f3805h && abstractC0624vM3746e.m4155z() && !abstractC0624vM3746e.m4146q() && !abstractC0624vM3746e.m4132c() && !abstractC0624vM3746e.m4143n()) {
                        this.f3702h.m9661a(m3753a(abstractC0624vM3746e), abstractC0624vM3746e);
                    }
                }
            }
        }
        if (this.f3650D.f3808k) {
            m3825s();
            boolean z = this.f3650D.f3803f;
            this.f3650D.f3803f = false;
            this.f3708n.mo3564c(this.f3699e, this.f3650D);
            this.f3650D.f3803f = z;
            for (int i2 = 0; i2 < this.f3701g.m9362b(); i2++) {
                AbstractC0624v abstractC0624vM3746e2 = m3746e(this.f3701g.m9364b(i2));
                if (!abstractC0624vM3746e2.m4132c() && !this.f3702h.m9670d(abstractC0624vM3746e2)) {
                    int iM3885e = AbstractC0608f.m3885e(abstractC0624vM3746e2);
                    boolean zM4128a = abstractC0624vM3746e2.m4128a(8192);
                    if (!zM4128a) {
                        iM3885e |= 4096;
                    }
                    AbstractC0608f.c cVarM3887a = this.f3720z.m3887a(this.f3650D, abstractC0624vM3746e2, iM3885e, abstractC0624vM3746e2.m4150u());
                    if (zM4128a) {
                        m3769a(abstractC0624vM3746e2, cVarM3887a);
                    } else {
                        this.f3702h.m9667b(abstractC0624vM3746e2, cVarM3887a);
                    }
                }
            }
            m3826t();
        } else {
            m3826t();
        }
        m3819m();
        m3772a(false);
        this.f3650D.f3801d = 2;
    }

    /* JADX INFO: renamed from: N */
    private void m3726N() {
        m3797e();
        m3817l();
        this.f3650D.m4099a(6);
        this.f3700f.m9209e();
        this.f3650D.f3802e = this.f3707m.mo3863a();
        this.f3650D.f3800c = 0;
        this.f3650D.f3804g = false;
        this.f3708n.mo3564c(this.f3699e, this.f3650D);
        this.f3650D.f3803f = false;
        this.f3659S = null;
        this.f3650D.f3807j = this.f3650D.f3807j && this.f3720z != null;
        this.f3650D.f3801d = 4;
        m3819m();
        m3772a(false);
    }

    /* JADX INFO: renamed from: O */
    private void m3727O() {
        this.f3650D.m4099a(4);
        m3797e();
        m3817l();
        this.f3650D.f3801d = 1;
        if (this.f3650D.f3807j) {
            for (int iM9362b = this.f3701g.m9362b() - 1; iM9362b >= 0; iM9362b--) {
                AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9364b(iM9362b));
                if (!abstractC0624vM3746e.m4132c()) {
                    long jM3753a = m3753a(abstractC0624vM3746e);
                    AbstractC0608f.c cVarM3886a = this.f3720z.m3886a(this.f3650D, abstractC0624vM3746e);
                    AbstractC0624v abstractC0624vM9659a = this.f3702h.m9659a(jM3753a);
                    if (abstractC0624vM9659a != null && !abstractC0624vM9659a.m4132c()) {
                        boolean zM9664a = this.f3702h.m9664a(abstractC0624vM9659a);
                        boolean zM9664a2 = this.f3702h.m9664a(abstractC0624vM3746e);
                        if (zM9664a && abstractC0624vM9659a == abstractC0624vM3746e) {
                            this.f3702h.m9669c(abstractC0624vM3746e, cVarM3886a);
                        } else {
                            AbstractC0608f.c cVarM9665b = this.f3702h.m9665b(abstractC0624vM9659a);
                            this.f3702h.m9669c(abstractC0624vM3746e, cVarM3886a);
                            AbstractC0608f.c cVarM9668c = this.f3702h.m9668c(abstractC0624vM3746e);
                            if (cVarM9665b == null) {
                                m3730a(jM3753a, abstractC0624vM3746e, abstractC0624vM9659a);
                            } else {
                                m3733a(abstractC0624vM9659a, abstractC0624vM3746e, cVarM9665b, cVarM9668c, zM9664a, zM9664a2);
                            }
                        }
                    } else {
                        this.f3702h.m9669c(abstractC0624vM3746e, cVarM3886a);
                    }
                }
            }
            this.f3702h.m9663a(this.f3672aI);
        }
        this.f3708n.m3965b(this.f3699e);
        this.f3650D.f3799b = this.f3650D.f3802e;
        this.f3718x = false;
        this.f3719y = false;
        this.f3650D.f3807j = false;
        this.f3650D.f3808k = false;
        this.f3708n.f3757u = false;
        if (this.f3699e.f3775b != null) {
            this.f3699e.f3775b.clear();
        }
        if (this.f3708n.f3761y) {
            this.f3708n.f3760x = 0;
            this.f3708n.f3761y = false;
            this.f3699e.m4062b();
        }
        this.f3708n.mo3552a(this.f3650D);
        m3819m();
        m3772a(false);
        this.f3702h.m9660a();
        if (m3749j(this.f3667aD[0], this.f3667aD[1])) {
            m3813i(0, 0);
        }
        m3724L();
        m3722J();
    }

    /* JADX INFO: renamed from: a */
    private void m3730a(long j, AbstractC0624v abstractC0624v, AbstractC0624v abstractC0624v2) {
        int iM9362b = this.f3701g.m9362b();
        for (int i = 0; i < iM9362b; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9364b(i));
            if (abstractC0624vM3746e != abstractC0624v && m3753a(abstractC0624vM3746e) == j) {
                if (this.f3707m != null && this.f3707m.m3879e()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + abstractC0624vM3746e + " \n View Holder 2:" + abstractC0624v + m3756a());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + abstractC0624vM3746e + " \n View Holder 2:" + abstractC0624v + m3756a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0624v2 + " cannot be found but it is necessary for " + abstractC0624v + m3756a());
    }

    /* JADX INFO: renamed from: a */
    void m3769a(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar) {
        abstractC0624v.m4121a(0, 8192);
        if (this.f3650D.f3805h && abstractC0624v.m4155z() && !abstractC0624v.m4146q() && !abstractC0624v.m4132c()) {
            this.f3702h.m9661a(m3753a(abstractC0624v), abstractC0624v);
        }
        this.f3702h.m9662a(abstractC0624v, cVar);
    }

    /* JADX INFO: renamed from: a */
    private void m3739a(int[] iArr) {
        int iM9362b = this.f3701g.m9362b();
        if (iM9362b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = ExploreByTouchHelper.INVALID_ID;
        for (int i3 = 0; i3 < iM9362b; i3++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9364b(i3));
            if (!abstractC0624vM3746e.m4132c()) {
                int iM4133d = abstractC0624vM3746e.m4133d();
                if (iM4133d < i) {
                    i = iM4133d;
                }
                if (iM4133d > i2) {
                    i2 = iM4133d;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* JADX INFO: renamed from: j */
    private boolean m3749j(int i, int i2) {
        m3739a(this.f3667aD);
        return (this.f3667aD[0] == i && this.f3667aD[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        AbstractC0624v abstractC0624vM3746e = m3746e(view);
        if (abstractC0624vM3746e != null) {
            if (abstractC0624vM3746e.m4147r()) {
                abstractC0624vM3746e.m4142m();
            } else if (!abstractC0624vM3746e.m4132c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + abstractC0624vM3746e + m3756a());
            }
        }
        view.clearAnimation();
        m3816k(view);
        super.removeDetachedView(view, z);
    }

    /* JADX INFO: renamed from: a */
    long m3753a(AbstractC0624v abstractC0624v) {
        return this.f3707m.m3879e() ? abstractC0624v.m4136g() : abstractC0624v.f3825c;
    }

    /* JADX INFO: renamed from: a */
    void m3770a(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar, AbstractC0608f.c cVar2) {
        abstractC0624v.m4127a(false);
        if (this.f3720z.mo3894b(abstractC0624v, cVar, cVar2)) {
            m3822p();
        }
    }

    /* JADX INFO: renamed from: b */
    void m3783b(AbstractC0624v abstractC0624v, AbstractC0608f.c cVar, AbstractC0608f.c cVar2) {
        m3747e(abstractC0624v);
        abstractC0624v.m4127a(false);
        if (this.f3720z.mo3890a(abstractC0624v, cVar, cVar2)) {
            m3822p();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3733a(AbstractC0624v abstractC0624v, AbstractC0624v abstractC0624v2, AbstractC0608f.c cVar, AbstractC0608f.c cVar2, boolean z, boolean z2) {
        abstractC0624v.m4127a(false);
        if (z) {
            m3747e(abstractC0624v);
        }
        if (abstractC0624v != abstractC0624v2) {
            if (z2) {
                m3747e(abstractC0624v2);
            }
            abstractC0624v.f3830h = abstractC0624v2;
            m3747e(abstractC0624v);
            this.f3699e.m4069c(abstractC0624v);
            abstractC0624v2.m4127a(false);
            abstractC0624v2.f3831i = abstractC0624v;
        }
        if (this.f3720z.mo3891a(abstractC0624v, abstractC0624v2, cVar, cVar2)) {
            m3822p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        m3823q();
        TraceCompat.endSection();
        this.f3714t = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3663W == 0 && !this.f3716v) {
            super.requestLayout();
        } else {
            this.f3715u = true;
        }
    }

    /* JADX INFO: renamed from: r */
    void m3824r() {
        int iM9365c = this.f3701g.m9365c();
        for (int i = 0; i < iM9365c; i++) {
            ((LayoutParams) this.f3701g.m9368d(i).getLayoutParams()).f3728e = true;
        }
        this.f3699e.m4081j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.f3710p.size();
        boolean z3 = false;
        for (int i = 0; i < size; i++) {
            this.f3710p.get(i).mo3912a(canvas, this, this.f3650D);
        }
        if (this.f3680ah == null || this.f3680ah.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f3703i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            z = this.f3680ah != null && this.f3680ah.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (this.f3681ai != null && !this.f3681ai.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f3703i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.f3681ai != null && this.f3681ai.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (this.f3682aj != null && !this.f3682aj.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3703i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.f3682aj != null && this.f3682aj.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        if (this.f3683ak == null || this.f3683ak.isFinished()) {
            z2 = z;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3703i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.f3683ak != null && this.f3683ak.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.f3720z != null && this.f3710p.size() > 0 && this.f3720z.mo3893b()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3710p.size();
        for (int i = 0; i < size; i++) {
            this.f3710p.get(i).m3916b(canvas, this, this.f3650D);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f3708n.mo3559a((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f3708n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + m3756a());
        }
        return this.f3708n.mo3542a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f3708n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + m3756a());
        }
        return this.f3708n.mo3543a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f3708n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + m3756a());
        }
        return this.f3708n.mo3544a(layoutParams);
    }

    /* JADX INFO: renamed from: s */
    void m3825s() {
        int iM9365c = this.f3701g.m9365c();
        for (int i = 0; i < iM9365c; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i));
            if (!abstractC0624vM3746e.m4132c()) {
                abstractC0624vM3746e.m4129b();
            }
        }
    }

    /* JADX INFO: renamed from: t */
    void m3826t() {
        int iM9365c = this.f3701g.m9365c();
        for (int i = 0; i < iM9365c; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i));
            if (!abstractC0624vM3746e.m4132c()) {
                abstractC0624vM3746e.m4120a();
            }
        }
        this.f3699e.m4080i();
    }

    /* JADX INFO: renamed from: f */
    void m3803f(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iM9365c = this.f3701g.m9365c();
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iM9365c; i6++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i6));
            if (abstractC0624vM3746e != null && abstractC0624vM3746e.f3825c >= i4 && abstractC0624vM3746e.f3825c <= i3) {
                if (abstractC0624vM3746e.f3825c == i) {
                    abstractC0624vM3746e.m4123a(i2 - i, false);
                } else {
                    abstractC0624vM3746e.m4123a(i5, false);
                }
                this.f3650D.f3803f = true;
            }
        }
        this.f3699e.m4052a(i, i2);
        requestLayout();
    }

    /* JADX INFO: renamed from: g */
    void m3806g(int i, int i2) {
        int iM9365c = this.f3701g.m9365c();
        for (int i3 = 0; i3 < iM9365c; i3++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i3));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4132c() && abstractC0624vM3746e.f3825c >= i) {
                abstractC0624vM3746e.m4123a(i2, false);
                this.f3650D.f3803f = true;
            }
        }
        this.f3699e.m4063b(i, i2);
        requestLayout();
    }

    /* JADX INFO: renamed from: a */
    void m3761a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iM9365c = this.f3701g.m9365c();
        for (int i4 = 0; i4 < iM9365c; i4++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i4));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4132c()) {
                if (abstractC0624vM3746e.f3825c >= i3) {
                    abstractC0624vM3746e.m4123a(-i2, z);
                    this.f3650D.f3803f = true;
                } else if (abstractC0624vM3746e.f3825c >= i) {
                    abstractC0624vM3746e.m4122a(i - 1, -i2, z);
                    this.f3650D.f3803f = true;
                }
            }
        }
        this.f3699e.m4053a(i, i2, z);
        requestLayout();
    }

    /* JADX INFO: renamed from: a */
    void m3760a(int i, int i2, Object obj) {
        int iM9365c = this.f3701g.m9365c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iM9365c; i4++) {
            View viewM9368d = this.f3701g.m9368d(i4);
            AbstractC0624v abstractC0624vM3746e = m3746e(viewM9368d);
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4132c() && abstractC0624vM3746e.f3825c >= i && abstractC0624vM3746e.f3825c < i3) {
                abstractC0624vM3746e.m4130b(2);
                abstractC0624vM3746e.m4126a(obj);
                ((LayoutParams) viewM9368d.getLayoutParams()).f3728e = true;
            }
        }
        this.f3699e.m4068c(i, i2);
    }

    /* JADX INFO: renamed from: b */
    boolean m3786b(AbstractC0624v abstractC0624v) {
        return this.f3720z == null || this.f3720z.mo3892a(abstractC0624v, abstractC0624v.m4150u());
    }

    /* JADX INFO: renamed from: c */
    void m3791c(boolean z) {
        this.f3719y = z | this.f3719y;
        this.f3718x = true;
        m3827u();
    }

    /* JADX INFO: renamed from: u */
    void m3827u() {
        int iM9365c = this.f3701g.m9365c();
        for (int i = 0; i < iM9365c; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4132c()) {
                abstractC0624vM3746e.m4130b(6);
            }
        }
        m3824r();
        this.f3699e.m4079h();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3697ay;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f3697ay = z;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0624v m3777b(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return m3746e(view);
    }

    /* JADX INFO: renamed from: c */
    public View m3788c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public AbstractC0624v m3793d(View view) {
        View viewM3788c = m3788c(view);
        if (viewM3788c == null) {
            return null;
        }
        return m3777b(viewM3788c);
    }

    /* JADX INFO: renamed from: e */
    public static AbstractC0624v m3746e(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f3726c;
    }

    /* JADX INFO: renamed from: f */
    public int m3800f(View view) {
        AbstractC0624v abstractC0624vM3746e = m3746e(view);
        if (abstractC0624vM3746e != null) {
            return abstractC0624vM3746e.m4133d();
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public AbstractC0624v m3787c(int i) {
        AbstractC0624v abstractC0624v = null;
        if (this.f3718x) {
            return null;
        }
        int iM9365c = this.f3701g.m9365c();
        for (int i2 = 0; i2 < iM9365c; i2++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i2));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4146q() && m3792d(abstractC0624vM3746e) == i) {
                if (!this.f3701g.m9367c(abstractC0624vM3746e.f3823a)) {
                    return abstractC0624vM3746e;
                }
                abstractC0624v = abstractC0624vM3746e;
            }
        }
        return abstractC0624v;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.support.v7.widget.RecyclerView.AbstractC0624v m3754a(int r6, boolean r7) {
        /*
            r5 = this;
            gd r0 = r5.f3701g
            int r0 = r0.m9365c()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            gd r3 = r5.f3701g
            android.view.View r3 = r3.m9368d(r2)
            android.support.v7.widget.RecyclerView$v r3 = m3746e(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.m4146q()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f3825c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m4133d()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            gd r1 = r5.f3701g
            android.view.View r4 = r3.f3823a
            boolean r1 = r1.m9367c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.m3754a(int, boolean):android.support.v7.widget.RecyclerView$v");
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0624v m3755a(long j) {
        AbstractC0624v abstractC0624v = null;
        if (this.f3707m == null || !this.f3707m.m3879e()) {
            return null;
        }
        int iM9365c = this.f3701g.m9365c();
        for (int i = 0; i < iM9365c; i++) {
            AbstractC0624v abstractC0624vM3746e = m3746e(this.f3701g.m9368d(i));
            if (abstractC0624vM3746e != null && !abstractC0624vM3746e.m4146q() && abstractC0624vM3746e.m4136g() == j) {
                if (!this.f3701g.m9367c(abstractC0624vM3746e.f3823a)) {
                    return abstractC0624vM3746e;
                }
                abstractC0624v = abstractC0624vM3746e;
            }
        }
        return abstractC0624v;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* JADX INFO: renamed from: d */
    public void m3795d(int i) {
        int iM9362b = this.f3701g.m9362b();
        for (int i2 = 0; i2 < iM9362b; i2++) {
            this.f3701g.m9364b(i2).offsetTopAndBottom(i);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m3798e(int i) {
        int iM9362b = this.f3701g.m9362b();
        for (int i2 = 0; i2 < iM9362b; i2++) {
            this.f3701g.m9364b(i2).offsetLeftAndRight(i);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3737a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f3727d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* JADX INFO: renamed from: i */
    Rect m3811i(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f3728e) {
            return layoutParams.f3727d;
        }
        if (this.f3650D.m4101a() && (layoutParams.m3857e() || layoutParams.m3855c())) {
            return layoutParams.f3727d;
        }
        Rect rect = layoutParams.f3727d;
        rect.set(0, 0, 0, 0);
        int size = this.f3710p.size();
        for (int i = 0; i < size; i++) {
            this.f3705k.set(0, 0, 0, 0);
            this.f3710p.get(i).m3914a(this.f3705k, view, this, this.f3650D);
            rect.left += this.f3705k.left;
            rect.top += this.f3705k.top;
            rect.right += this.f3705k.right;
            rect.bottom += this.f3705k.bottom;
        }
        layoutParams.f3728e = false;
        return rect;
    }

    /* JADX INFO: renamed from: i */
    void m3813i(int i, int i2) {
        this.f3678af++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m3809h(i, i2);
        if (this.f3698az != null) {
            this.f3698az.mo4030a(this, i, i2);
        }
        if (this.f3664aA != null) {
            for (int size = this.f3664aA.size() - 1; size >= 0; size--) {
                this.f3664aA.get(size).mo4030a(this, i, i2);
            }
        }
        this.f3678af--;
    }

    /* JADX INFO: renamed from: g */
    void m3805g(int i) {
        if (this.f3708n != null) {
            this.f3708n.mo4001l(i);
        }
        m3802f(i);
        if (this.f3698az != null) {
            this.f3698az.m4029a(this, i);
        }
        if (this.f3664aA != null) {
            for (int size = this.f3664aA.size() - 1; size >= 0; size--) {
                this.f3664aA.get(size).m4029a(this, i);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public boolean m3828v() {
        return !this.f3714t || this.f3718x || this.f3700f.m9208d();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$u */
    class RunnableC0623u implements Runnable {

        /* JADX INFO: renamed from: a */
        OverScroller f3815a;

        /* JADX INFO: renamed from: d */
        private int f3818d;

        /* JADX INFO: renamed from: e */
        private int f3819e;

        /* JADX INFO: renamed from: b */
        Interpolator f3816b = RecyclerView.f3637L;

        /* JADX INFO: renamed from: f */
        private boolean f3820f = false;

        /* JADX INFO: renamed from: g */
        private boolean f3821g = false;

        RunnableC0623u() {
            this.f3815a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f3637L);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 432
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.RunnableC0623u.run():void");
        }

        /* JADX INFO: renamed from: c */
        private void m4109c() {
            this.f3821g = false;
            this.f3820f = true;
        }

        /* JADX INFO: renamed from: d */
        private void m4110d() {
            this.f3820f = false;
            if (this.f3821g) {
                m4111a();
            }
        }

        /* JADX INFO: renamed from: a */
        void m4111a() {
            if (this.f3820f) {
                this.f3821g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4112a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f3819e = 0;
            this.f3818d = 0;
            this.f3815a.fling(0, 0, i, i2, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE);
            m4111a();
        }

        /* JADX INFO: renamed from: b */
        public void m4118b(int i, int i2) {
            m4114a(i, i2, 0, 0);
        }

        /* JADX INFO: renamed from: a */
        public void m4114a(int i, int i2, int i3, int i4) {
            m4113a(i, i2, m4108b(i, i2, i3, i4));
        }

        /* JADX INFO: renamed from: a */
        private float m4107a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        /* JADX INFO: renamed from: b */
        private int m4108b(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fM4107a = f2 + (m4107a(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fM4107a / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        /* JADX INFO: renamed from: a */
        public void m4113a(int i, int i2, int i3) {
            m4115a(i, i2, i3, RecyclerView.f3637L);
        }

        /* JADX INFO: renamed from: a */
        public void m4116a(int i, int i2, Interpolator interpolator) {
            int iM4108b = m4108b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f3637L;
            }
            m4115a(i, i2, iM4108b, interpolator);
        }

        /* JADX INFO: renamed from: a */
        public void m4115a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f3816b != interpolator) {
                this.f3816b = interpolator;
                this.f3815a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3819e = 0;
            this.f3818d = 0;
            this.f3815a.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3815a.computeScrollOffset();
            }
            m4111a();
        }

        /* JADX INFO: renamed from: b */
        public void m4117b() {
            RecyclerView.this.removeCallbacks(this);
            this.f3815a.abortAnimation();
        }
    }

    /* JADX INFO: renamed from: w */
    void m3829w() {
        int iM9362b = this.f3701g.m9362b();
        for (int i = 0; i < iM9362b; i++) {
            View viewM9364b = this.f3701g.m9364b(i);
            AbstractC0624v abstractC0624vM3777b = m3777b(viewM9364b);
            if (abstractC0624vM3777b != null && abstractC0624vM3777b.f3831i != null) {
                View view = abstractC0624vM3777b.f3831i.f3823a;
                int left = viewM9364b.getLeft();
                int top = viewM9364b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$q */
    class C0619q extends AbstractC0605c {
        C0619q() {
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0605c
        /* JADX INFO: renamed from: a */
        public void mo3882a() {
            RecyclerView.this.m3771a((String) null);
            RecyclerView.this.f3650D.f3803f = true;
            RecyclerView.this.m3791c(true);
            if (RecyclerView.this.f3700f.m9208d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$e */
    public static class C0607e {
        /* JADX INFO: renamed from: a */
        protected EdgeEffect m3884a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$n */
    public static class C0616n {

        /* JADX INFO: renamed from: a */
        SparseArray<a> f3768a = new SparseArray<>();

        /* JADX INFO: renamed from: b */
        private int f3769b = 0;

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$n$a */
        static class a {

            /* JADX INFO: renamed from: a */
            final ArrayList<AbstractC0624v> f3770a = new ArrayList<>();

            /* JADX INFO: renamed from: b */
            int f3771b = 5;

            /* JADX INFO: renamed from: c */
            long f3772c = 0;

            /* JADX INFO: renamed from: d */
            long f3773d = 0;

            a() {
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4034a() {
            for (int i = 0; i < this.f3768a.size(); i++) {
                this.f3768a.valueAt(i).f3770a.clear();
            }
        }

        /* JADX INFO: renamed from: a */
        public AbstractC0624v m4033a(int i) {
            a aVar = this.f3768a.get(i);
            if (aVar == null || aVar.f3770a.isEmpty()) {
                return null;
            }
            return aVar.f3770a.remove(r2.size() - 1);
        }

        /* JADX INFO: renamed from: a */
        public void m4037a(AbstractC0624v abstractC0624v) {
            int iM4137h = abstractC0624v.m4137h();
            ArrayList<AbstractC0624v> arrayList = m4031b(iM4137h).f3770a;
            if (this.f3768a.get(iM4137h).f3771b <= arrayList.size()) {
                return;
            }
            abstractC0624v.m4151v();
            arrayList.add(abstractC0624v);
        }

        /* JADX INFO: renamed from: a */
        long m4032a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* JADX INFO: renamed from: a */
        void m4035a(int i, long j) {
            a aVarM4031b = m4031b(i);
            aVarM4031b.f3772c = m4032a(aVarM4031b.f3772c, j);
        }

        /* JADX INFO: renamed from: b */
        void m4040b(int i, long j) {
            a aVarM4031b = m4031b(i);
            aVarM4031b.f3773d = m4032a(aVarM4031b.f3773d, j);
        }

        /* JADX INFO: renamed from: a */
        boolean m4038a(int i, long j, long j2) {
            long j3 = m4031b(i).f3772c;
            return j3 == 0 || j + j3 < j2;
        }

        /* JADX INFO: renamed from: b */
        boolean m4041b(int i, long j, long j2) {
            long j3 = m4031b(i).f3773d;
            return j3 == 0 || j + j3 < j2;
        }

        /* JADX INFO: renamed from: b */
        void m4039b() {
            this.f3769b++;
        }

        /* JADX INFO: renamed from: c */
        void m4042c() {
            this.f3769b--;
        }

        /* JADX INFO: renamed from: a */
        void m4036a(AbstractC0603a abstractC0603a, AbstractC0603a abstractC0603a2, boolean z) {
            if (abstractC0603a != null) {
                m4042c();
            }
            if (!z && this.f3769b == 0) {
                m4034a();
            }
            if (abstractC0603a2 != null) {
                m4039b();
            }
        }

        /* JADX INFO: renamed from: b */
        private a m4031b(int i) {
            a aVar = this.f3768a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f3768a.put(i, aVar2);
            return aVar2;
        }
    }

    /* JADX INFO: renamed from: j */
    static RecyclerView m3748j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewM3748j = m3748j(viewGroup.getChildAt(i));
            if (recyclerViewM3748j != null) {
                return recyclerViewM3748j;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    static void m3744c(AbstractC0624v abstractC0624v) {
        if (abstractC0624v.f3824b != null) {
            RecyclerView recyclerView = abstractC0624v.f3824b.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC0624v.f3823a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC0624v.f3824b = null;
        }
    }

    public long getNanoTime() {
        if (f3646d) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$o */
    public final class C0617o {

        /* JADX INFO: renamed from: e */
        C0616n f3778e;

        /* JADX INFO: renamed from: i */
        private AbstractC0622t f3782i;

        /* JADX INFO: renamed from: a */
        final ArrayList<AbstractC0624v> f3774a = new ArrayList<>();

        /* JADX INFO: renamed from: b */
        ArrayList<AbstractC0624v> f3775b = null;

        /* JADX INFO: renamed from: c */
        final ArrayList<AbstractC0624v> f3776c = new ArrayList<>();

        /* JADX INFO: renamed from: g */
        private final List<AbstractC0624v> f3780g = Collections.unmodifiableList(this.f3774a);

        /* JADX INFO: renamed from: h */
        private int f3781h = 2;

        /* JADX INFO: renamed from: d */
        int f3777d = 2;

        public C0617o() {
        }

        /* JADX INFO: renamed from: a */
        public void m4050a() {
            this.f3774a.clear();
            m4071d();
        }

        /* JADX INFO: renamed from: a */
        public void m4051a(int i) {
            this.f3781h = i;
            m4062b();
        }

        /* JADX INFO: renamed from: b */
        public void m4062b() {
            this.f3777d = this.f3781h + (RecyclerView.this.f3708n != null ? RecyclerView.this.f3708n.f3760x : 0);
            for (int size = this.f3776c.size() - 1; size >= 0 && this.f3776c.size() > this.f3777d; size--) {
                m4072d(size);
            }
        }

        /* JADX INFO: renamed from: c */
        public List<AbstractC0624v> m4067c() {
            return this.f3780g;
        }

        /* JADX INFO: renamed from: a */
        boolean m4059a(AbstractC0624v abstractC0624v) {
            if (abstractC0624v.m4146q()) {
                return RecyclerView.this.f3650D.m4101a();
            }
            if (abstractC0624v.f3825c < 0 || abstractC0624v.f3825c >= RecyclerView.this.f3707m.mo3863a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + abstractC0624v + RecyclerView.this.m3756a());
            }
            if (RecyclerView.this.f3650D.m4101a() || RecyclerView.this.f3707m.mo3870b(abstractC0624v.f3825c) == abstractC0624v.m4137h()) {
                return !RecyclerView.this.f3707m.m3879e() || abstractC0624v.m4136g() == RecyclerView.this.f3707m.mo3864a(abstractC0624v.f3825c);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private boolean m4044a(AbstractC0624v abstractC0624v, int i, int i2, long j) {
            abstractC0624v.f3838p = RecyclerView.this;
            int iM4137h = abstractC0624v.m4137h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f3778e.m4041b(iM4137h, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.f3707m.m3873b(abstractC0624v, i);
            this.f3778e.m4040b(abstractC0624v.m4137h(), RecyclerView.this.getNanoTime() - nanoTime);
            m4045e(abstractC0624v);
            if (!RecyclerView.this.f3650D.m4101a()) {
                return true;
            }
            abstractC0624v.f3829g = i2;
            return true;
        }

        /* JADX INFO: renamed from: b */
        public int m4060b(int i) {
            if (i >= 0 && i < RecyclerView.this.f3650D.m4105e()) {
                return !RecyclerView.this.f3650D.m4101a() ? i : RecyclerView.this.f3700f.m9204b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f3650D.m4105e() + RecyclerView.this.m3756a());
        }

        /* JADX INFO: renamed from: c */
        public View m4066c(int i) {
            return m4049a(i, false);
        }

        /* JADX INFO: renamed from: a */
        View m4049a(int i, boolean z) {
            return m4047a(i, z, Long.MAX_VALUE).f3823a;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0217  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0233 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x018d A[PHI: r1 r4
          0x018d: PHI (r1v12 android.support.v7.widget.RecyclerView$v) = (r1v11 android.support.v7.widget.RecyclerView$v), (r1v31 android.support.v7.widget.RecyclerView$v) binds: [B:29:0x005f, B:59:0x0106] A[DONT_GENERATE, DONT_INLINE]
          0x018d: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:29:0x005f, B:59:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01dc  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0209  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.support.v7.widget.RecyclerView.AbstractC0624v m4047a(int r18, boolean r19, long r20) {
            /*
                Method dump skipped, instruction units count: 626
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.C0617o.m4047a(int, boolean, long):android.support.v7.widget.RecyclerView$v");
        }

        /* JADX INFO: renamed from: e */
        private void m4045e(AbstractC0624v abstractC0624v) {
            if (RecyclerView.this.m3820n()) {
                View view = abstractC0624v.f3823a;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (ViewCompat.hasAccessibilityDelegate(view)) {
                    return;
                }
                abstractC0624v.m4130b(16384);
                ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.f3654H.m4157b());
            }
        }

        /* JADX INFO: renamed from: f */
        private void m4046f(AbstractC0624v abstractC0624v) {
            if (abstractC0624v.f3823a instanceof ViewGroup) {
                m4043a((ViewGroup) abstractC0624v.f3823a, false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m4043a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4043a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4058a(View view) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (abstractC0624vM3746e.m4147r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (abstractC0624vM3746e.m4138i()) {
                abstractC0624vM3746e.m4139j();
            } else if (abstractC0624vM3746e.m4140k()) {
                abstractC0624vM3746e.m4141l();
            }
            m4064b(abstractC0624vM3746e);
        }

        /* JADX INFO: renamed from: d */
        void m4071d() {
            for (int size = this.f3776c.size() - 1; size >= 0; size--) {
                m4072d(size);
            }
            this.f3776c.clear();
            if (RecyclerView.f3646d) {
                RecyclerView.this.f3649C.m9480a();
            }
        }

        /* JADX INFO: renamed from: d */
        void m4072d(int i) {
            m4057a(this.f3776c.get(i), true);
            this.f3776c.remove(i);
        }

        /* JADX INFO: renamed from: b */
        void m4064b(AbstractC0624v abstractC0624v) {
            boolean z;
            if (abstractC0624v.m4138i() || abstractC0624v.f3823a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(abstractC0624v.m4138i());
                sb.append(" isAttached:");
                sb.append(abstractC0624v.f3823a.getParent() != null);
                sb.append(RecyclerView.this.m3756a());
                throw new IllegalArgumentException(sb.toString());
            }
            if (abstractC0624v.m4147r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + abstractC0624v + RecyclerView.this.m3756a());
            }
            if (abstractC0624v.m4132c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.m3756a());
            }
            boolean zM4154y = abstractC0624v.m4154y();
            if ((RecyclerView.this.f3707m != null && zM4154y && RecyclerView.this.f3707m.m3875b(abstractC0624v)) || abstractC0624v.m4152w()) {
                if (this.f3777d <= 0 || abstractC0624v.m4128a(526)) {
                    z = false;
                } else {
                    int size = this.f3776c.size();
                    if (size >= this.f3777d && size > 0) {
                        m4072d(0);
                        size--;
                    }
                    if (RecyclerView.f3646d && size > 0 && !RecyclerView.this.f3649C.m9483a(abstractC0624v.f3825c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.f3649C.m9483a(this.f3776c.get(i).f3825c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.f3776c.add(size, abstractC0624v);
                    z = true;
                }
                if (!z) {
                    m4057a(abstractC0624v, true);
                    z = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.f3702h.m9673g(abstractC0624v);
            if (z || z || !zM4154y) {
                return;
            }
            abstractC0624v.f3838p = null;
        }

        /* JADX INFO: renamed from: a */
        public void m4057a(AbstractC0624v abstractC0624v, boolean z) {
            RecyclerView.m3744c(abstractC0624v);
            if (abstractC0624v.m4128a(16384)) {
                abstractC0624v.m4121a(0, 16384);
                ViewCompat.setAccessibilityDelegate(abstractC0624v.f3823a, null);
            }
            if (z) {
                m4073d(abstractC0624v);
            }
            abstractC0624v.f3838p = null;
            m4078g().m4037a(abstractC0624v);
        }

        /* JADX INFO: renamed from: b */
        void m4065b(View view) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            abstractC0624vM3746e.f3835m = null;
            abstractC0624vM3746e.f3836n = false;
            abstractC0624vM3746e.m4141l();
            m4064b(abstractC0624vM3746e);
        }

        /* JADX INFO: renamed from: c */
        void m4070c(View view) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (abstractC0624vM3746e.m4128a(12) || !abstractC0624vM3746e.m4155z() || RecyclerView.this.m3786b(abstractC0624vM3746e)) {
                if (abstractC0624vM3746e.m4143n() && !abstractC0624vM3746e.m4146q() && !RecyclerView.this.f3707m.m3879e()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.m3756a());
                }
                abstractC0624vM3746e.m4124a(this, false);
                this.f3774a.add(abstractC0624vM3746e);
                return;
            }
            if (this.f3775b == null) {
                this.f3775b = new ArrayList<>();
            }
            abstractC0624vM3746e.m4124a(this, true);
            this.f3775b.add(abstractC0624vM3746e);
        }

        /* JADX INFO: renamed from: c */
        void m4069c(AbstractC0624v abstractC0624v) {
            if (abstractC0624v.f3836n) {
                this.f3775b.remove(abstractC0624v);
            } else {
                this.f3774a.remove(abstractC0624v);
            }
            abstractC0624v.f3835m = null;
            abstractC0624v.f3836n = false;
            abstractC0624v.m4141l();
        }

        /* JADX INFO: renamed from: e */
        int m4074e() {
            return this.f3774a.size();
        }

        /* JADX INFO: renamed from: e */
        View m4075e(int i) {
            return this.f3774a.get(i).f3823a;
        }

        /* JADX INFO: renamed from: f */
        void m4077f() {
            this.f3774a.clear();
            if (this.f3775b != null) {
                this.f3775b.clear();
            }
        }

        /* JADX INFO: renamed from: f */
        AbstractC0624v m4076f(int i) {
            int size;
            int iM9204b;
            if (this.f3775b == null || (size = this.f3775b.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0624v abstractC0624v = this.f3775b.get(i2);
                if (!abstractC0624v.m4140k() && abstractC0624v.m4133d() == i) {
                    abstractC0624v.m4130b(32);
                    return abstractC0624v;
                }
            }
            if (RecyclerView.this.f3707m.m3879e() && (iM9204b = RecyclerView.this.f3700f.m9204b(i)) > 0 && iM9204b < RecyclerView.this.f3707m.mo3863a()) {
                long jMo3864a = RecyclerView.this.f3707m.mo3864a(iM9204b);
                for (int i3 = 0; i3 < size; i3++) {
                    AbstractC0624v abstractC0624v2 = this.f3775b.get(i3);
                    if (!abstractC0624v2.m4140k() && abstractC0624v2.m4136g() == jMo3864a) {
                        abstractC0624v2.m4130b(32);
                        return abstractC0624v2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        AbstractC0624v m4061b(int i, boolean z) {
            View viewM9366c;
            int size = this.f3774a.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0624v abstractC0624v = this.f3774a.get(i2);
                if (!abstractC0624v.m4140k() && abstractC0624v.m4133d() == i && !abstractC0624v.m4143n() && (RecyclerView.this.f3650D.f3804g || !abstractC0624v.m4146q())) {
                    abstractC0624v.m4130b(32);
                    return abstractC0624v;
                }
            }
            if (!z && (viewM9366c = RecyclerView.this.f3701g.m9366c(i)) != null) {
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(viewM9366c);
                RecyclerView.this.f3701g.m9371e(viewM9366c);
                int iM9363b = RecyclerView.this.f3701g.m9363b(viewM9366c);
                if (iM9363b == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + abstractC0624vM3746e + RecyclerView.this.m3756a());
                }
                RecyclerView.this.f3701g.m9370e(iM9363b);
                m4070c(viewM9366c);
                abstractC0624vM3746e.m4130b(8224);
                return abstractC0624vM3746e;
            }
            int size2 = this.f3776c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractC0624v abstractC0624v2 = this.f3776c.get(i3);
                if (!abstractC0624v2.m4143n() && abstractC0624v2.m4133d() == i) {
                    if (!z) {
                        this.f3776c.remove(i3);
                    }
                    return abstractC0624v2;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        AbstractC0624v m4048a(long j, int i, boolean z) {
            for (int size = this.f3774a.size() - 1; size >= 0; size--) {
                AbstractC0624v abstractC0624v = this.f3774a.get(size);
                if (abstractC0624v.m4136g() == j && !abstractC0624v.m4140k()) {
                    if (i == abstractC0624v.m4137h()) {
                        abstractC0624v.m4130b(32);
                        if (abstractC0624v.m4146q() && !RecyclerView.this.f3650D.m4101a()) {
                            abstractC0624v.m4121a(2, 14);
                        }
                        return abstractC0624v;
                    }
                    if (!z) {
                        this.f3774a.remove(size);
                        RecyclerView.this.removeDetachedView(abstractC0624v.f3823a, false);
                        m4065b(abstractC0624v.f3823a);
                    }
                }
            }
            int size2 = this.f3776c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                AbstractC0624v abstractC0624v2 = this.f3776c.get(size2);
                if (abstractC0624v2.m4136g() == j) {
                    if (i == abstractC0624v2.m4137h()) {
                        if (!z) {
                            this.f3776c.remove(size2);
                        }
                        return abstractC0624v2;
                    }
                    if (!z) {
                        m4072d(size2);
                        return null;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: d */
        void m4073d(AbstractC0624v abstractC0624v) {
            if (RecyclerView.this.f3709o != null) {
                RecyclerView.this.f3709o.m4082a(abstractC0624v);
            }
            if (RecyclerView.this.f3707m != null) {
                RecyclerView.this.f3707m.mo3866a(abstractC0624v);
            }
            if (RecyclerView.this.f3650D != null) {
                RecyclerView.this.f3702h.m9673g(abstractC0624v);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4054a(AbstractC0603a abstractC0603a, AbstractC0603a abstractC0603a2, boolean z) {
            m4050a();
            m4078g().m4036a(abstractC0603a, abstractC0603a2, z);
        }

        /* JADX INFO: renamed from: a */
        void m4052a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.f3776c.size();
            for (int i6 = 0; i6 < size; i6++) {
                AbstractC0624v abstractC0624v = this.f3776c.get(i6);
                if (abstractC0624v != null && abstractC0624v.f3825c >= i4 && abstractC0624v.f3825c <= i3) {
                    if (abstractC0624v.f3825c == i) {
                        abstractC0624v.m4123a(i2 - i, false);
                    } else {
                        abstractC0624v.m4123a(i5, false);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4063b(int i, int i2) {
            int size = this.f3776c.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0624v abstractC0624v = this.f3776c.get(i3);
                if (abstractC0624v != null && abstractC0624v.f3825c >= i) {
                    abstractC0624v.m4123a(i2, true);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4053a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f3776c.size() - 1; size >= 0; size--) {
                AbstractC0624v abstractC0624v = this.f3776c.get(size);
                if (abstractC0624v != null) {
                    if (abstractC0624v.f3825c >= i3) {
                        abstractC0624v.m4123a(-i2, z);
                    } else if (abstractC0624v.f3825c >= i) {
                        abstractC0624v.m4130b(8);
                        m4072d(size);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4056a(AbstractC0622t abstractC0622t) {
            this.f3782i = abstractC0622t;
        }

        /* JADX INFO: renamed from: a */
        void m4055a(C0616n c0616n) {
            if (this.f3778e != null) {
                this.f3778e.m4042c();
            }
            this.f3778e = c0616n;
            if (this.f3778e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f3778e.m4039b();
        }

        /* JADX INFO: renamed from: g */
        C0616n m4078g() {
            if (this.f3778e == null) {
                this.f3778e = new C0616n();
            }
            return this.f3778e;
        }

        /* JADX INFO: renamed from: c */
        void m4068c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f3776c.size() - 1; size >= 0; size--) {
                AbstractC0624v abstractC0624v = this.f3776c.get(size);
                if (abstractC0624v != null && (i3 = abstractC0624v.f3825c) >= i && i3 < i4) {
                    abstractC0624v.m4130b(2);
                    m4072d(size);
                }
            }
        }

        /* JADX INFO: renamed from: h */
        void m4079h() {
            int size = this.f3776c.size();
            for (int i = 0; i < size; i++) {
                AbstractC0624v abstractC0624v = this.f3776c.get(i);
                if (abstractC0624v != null) {
                    abstractC0624v.m4130b(6);
                    abstractC0624v.m4126a((Object) null);
                }
            }
            if (RecyclerView.this.f3707m == null || !RecyclerView.this.f3707m.m3879e()) {
                m4071d();
            }
        }

        /* JADX INFO: renamed from: i */
        void m4080i() {
            int size = this.f3776c.size();
            for (int i = 0; i < size; i++) {
                this.f3776c.get(i).m4120a();
            }
            int size2 = this.f3774a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f3774a.get(i2).m4120a();
            }
            if (this.f3775b != null) {
                int size3 = this.f3775b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f3775b.get(i3).m4120a();
                }
            }
        }

        /* JADX INFO: renamed from: j */
        void m4081j() {
            int size = this.f3776c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f3776c.get(i).f3823a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f3728e = true;
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$a */
    public static abstract class AbstractC0603a<VH extends AbstractC0624v> {

        /* JADX INFO: renamed from: a */
        private final C0604b f3731a = new C0604b();

        /* JADX INFO: renamed from: b */
        private boolean f3732b = false;

        /* JADX INFO: renamed from: a */
        public abstract int mo3863a();

        /* JADX INFO: renamed from: a */
        public long mo3864a(int i) {
            return -1L;
        }

        /* JADX INFO: renamed from: a */
        public void mo3866a(VH vh) {
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo3867a(VH vh, int i);

        /* JADX INFO: renamed from: a */
        public void m3869a(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: b */
        public int mo3870b(int i) {
            return 0;
        }

        /* JADX INFO: renamed from: b */
        public abstract VH mo3871b(ViewGroup viewGroup, int i);

        /* JADX INFO: renamed from: b */
        public void m3874b(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: b */
        public boolean m3875b(VH vh) {
            return false;
        }

        /* JADX INFO: renamed from: c */
        public void m3877c(VH vh) {
        }

        /* JADX INFO: renamed from: d */
        public void mo3878d(VH vh) {
        }

        /* JADX INFO: renamed from: a */
        public void m3868a(VH vh, int i, List<Object> list) {
            mo3867a(vh, i);
        }

        /* JADX INFO: renamed from: c */
        public final VH m3876c(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH vh = (VH) mo3871b(viewGroup, i);
                if (vh.f3823a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f3828f = i;
                return vh;
            } finally {
                TraceCompat.endSection();
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m3873b(VH vh, int i) {
            vh.f3825c = i;
            if (m3879e()) {
                vh.f3827e = mo3864a(i);
            }
            vh.m4121a(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            m3868a(vh, i, vh.m4150u());
            vh.m4149t();
            ViewGroup.LayoutParams layoutParams = vh.f3823a.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f3728e = true;
            }
            TraceCompat.endSection();
        }

        /* JADX INFO: renamed from: e */
        public final boolean m3879e() {
            return this.f3732b;
        }

        /* JADX INFO: renamed from: a */
        public void m3865a(AbstractC0605c abstractC0605c) {
            this.f3731a.registerObserver(abstractC0605c);
        }

        /* JADX INFO: renamed from: b */
        public void m3872b(AbstractC0605c abstractC0605c) {
            this.f3731a.unregisterObserver(abstractC0605c);
        }

        /* JADX INFO: renamed from: f */
        public final void m3880f() {
            this.f3731a.m3881a();
        }
    }

    /* JADX INFO: renamed from: k */
    void m3816k(View view) {
        AbstractC0624v abstractC0624vM3746e = m3746e(view);
        m3810h(view);
        if (this.f3707m != null && abstractC0624vM3746e != null) {
            this.f3707m.mo3878d(abstractC0624vM3746e);
        }
        if (this.f3676ad != null) {
            for (int size = this.f3676ad.size() - 1; size >= 0; size--) {
                this.f3676ad.get(size).m4024b(view);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    void m3818l(View view) {
        AbstractC0624v abstractC0624vM3746e = m3746e(view);
        m3807g(view);
        if (this.f3707m != null && abstractC0624vM3746e != null) {
            this.f3707m.m3877c(abstractC0624vM3746e);
        }
        if (this.f3676ad != null) {
            for (int size = this.f3676ad.size() - 1; size >= 0; size--) {
                this.f3676ad.get(size).m4023a(view);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$i */
    public static abstract class AbstractC0611i {

        /* JADX INFO: renamed from: e */
        private int f3748e;

        /* JADX INFO: renamed from: f */
        private int f3749f;

        /* JADX INFO: renamed from: g */
        private int f3750g;

        /* JADX INFO: renamed from: h */
        private int f3751h;

        /* JADX INFO: renamed from: p */
        C1739gd f3752p;

        /* JADX INFO: renamed from: q */
        RecyclerView f3753q;

        /* JADX INFO: renamed from: t */
        AbstractC0620r f3756t;

        /* JADX INFO: renamed from: x */
        public int f3760x;

        /* JADX INFO: renamed from: y */
        public boolean f3761y;

        /* JADX INFO: renamed from: a */
        private final C1772hj.b f3744a = new C1772hj.b() { // from class: android.support.v7.widget.RecyclerView.i.1
            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public View mo4019a(int i) {
                return AbstractC0611i.this.m3995i(i);
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public int mo4017a() {
                return AbstractC0611i.this.m3926A();
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: b */
            public int mo4020b() {
                return AbstractC0611i.this.m4015y() - AbstractC0611i.this.m3928C();
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public int mo4018a(View view) {
                return AbstractC0611i.this.m3992h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: b */
            public int mo4021b(View view) {
                return AbstractC0611i.this.m3996j(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        };

        /* JADX INFO: renamed from: b */
        private final C1772hj.b f3745b = new C1772hj.b() { // from class: android.support.v7.widget.RecyclerView.i.2
            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public View mo4019a(int i) {
                return AbstractC0611i.this.m3995i(i);
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public int mo4017a() {
                return AbstractC0611i.this.m3927B();
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: b */
            public int mo4020b() {
                return AbstractC0611i.this.m4016z() - AbstractC0611i.this.m3929D();
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: a */
            public int mo4018a(View view) {
                return AbstractC0611i.this.m3994i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // p000.C1772hj.b
            /* JADX INFO: renamed from: b */
            public int mo4021b(View view) {
                return AbstractC0611i.this.m3998k(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        };

        /* JADX INFO: renamed from: r */
        C1772hj f3754r = new C1772hj(this.f3744a);

        /* JADX INFO: renamed from: s */
        C1772hj f3755s = new C1772hj(this.f3745b);

        /* JADX INFO: renamed from: u */
        boolean f3757u = false;

        /* JADX INFO: renamed from: v */
        boolean f3758v = false;

        /* JADX INFO: renamed from: w */
        boolean f3759w = false;

        /* JADX INFO: renamed from: c */
        private boolean f3746c = true;

        /* JADX INFO: renamed from: d */
        private boolean f3747d = true;

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$i$a */
        public interface a {
            /* JADX INFO: renamed from: b */
            void mo4022b(int i, int i2);
        }

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$i$b */
        public static class b {

            /* JADX INFO: renamed from: a */
            public int f3764a;

            /* JADX INFO: renamed from: b */
            public int f3765b;

            /* JADX INFO: renamed from: c */
            public boolean f3766c;

            /* JADX INFO: renamed from: d */
            public boolean f3767d;
        }

        /* JADX INFO: renamed from: a */
        public int mo3540a(int i, C0617o c0617o, C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public abstract LayoutParams mo3542a();

        /* JADX INFO: renamed from: a */
        public View mo3546a(View view, int i, C0617o c0617o, C0621s c0621s) {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public void mo3624a(int i, int i2, C0621s c0621s, a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3625a(int i, a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3626a(Parcelable parcelable) {
        }

        /* JADX INFO: renamed from: a */
        public void m3938a(AbstractC0603a abstractC0603a, AbstractC0603a abstractC0603a2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3552a(C0621s c0621s) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3554a(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3555a(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3556a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo3559a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3955a(C0617o c0617o, C0621s c0621s, View view, int i, Bundle bundle) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3960a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public int mo3560b(int i, C0617o c0617o, C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: b */
        public void mo3562b(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: b */
        public boolean mo3563b() {
            return false;
        }

        /* JADX INFO: renamed from: c */
        public int mo3635c(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: c */
        public void m3975c(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: d */
        public int m3978d(C0617o c0617o, C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: d */
        public int mo3638d(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: d */
        public Parcelable mo3640d() {
            return null;
        }

        /* JADX INFO: renamed from: d */
        public View m3980d(View view, int i) {
            return null;
        }

        /* JADX INFO: renamed from: d */
        public void m3982d(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: e */
        public int mo3641e(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: e */
        public void mo3642e(int i) {
        }

        @Deprecated
        /* JADX INFO: renamed from: e */
        public void m3985e(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: e */
        public boolean mo3643e() {
            return false;
        }

        /* JADX INFO: renamed from: e */
        public boolean m3986e(C0617o c0617o, C0621s c0621s) {
            return false;
        }

        /* JADX INFO: renamed from: f */
        public int mo3645f(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: f */
        public boolean mo3646f() {
            return false;
        }

        /* JADX INFO: renamed from: g */
        public int mo3648g(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: h */
        public int mo3649h(C0621s c0621s) {
            return 0;
        }

        /* JADX INFO: renamed from: l */
        public void mo4001l(int i) {
        }

        /* JADX INFO: renamed from: l */
        boolean mo3654l() {
            return false;
        }

        /* JADX INFO: renamed from: u */
        public int m4011u() {
            return -1;
        }

        /* JADX INFO: renamed from: b */
        void m3966b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3753q = null;
                this.f3752p = null;
                this.f3750g = 0;
                this.f3751h = 0;
            } else {
                this.f3753q = recyclerView;
                this.f3752p = recyclerView.f3701g;
                this.f3750g = recyclerView.getWidth();
                this.f3751h = recyclerView.getHeight();
            }
            this.f3748e = 1073741824;
            this.f3749f = 1073741824;
        }

        /* JADX INFO: renamed from: c */
        void m3972c(int i, int i2) {
            this.f3750g = View.MeasureSpec.getSize(i);
            this.f3748e = View.MeasureSpec.getMode(i);
            if (this.f3748e == 0 && !RecyclerView.f3644b) {
                this.f3750g = 0;
            }
            this.f3751h = View.MeasureSpec.getSize(i2);
            this.f3749f = View.MeasureSpec.getMode(i2);
            if (this.f3749f != 0 || RecyclerView.f3644b) {
                return;
            }
            this.f3751h = 0;
        }

        /* JADX INFO: renamed from: d */
        void m3981d(int i, int i2) {
            int iM4012v = m4012v();
            if (iM4012v == 0) {
                this.f3753q.m3799e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = ExploreByTouchHelper.INVALID_ID;
            int i6 = ExploreByTouchHelper.INVALID_ID;
            for (int i7 = 0; i7 < iM4012v; i7++) {
                View viewM3995i = m3995i(i7);
                Rect rect = this.f3753q.f3705k;
                m3949a(viewM3995i, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.f3753q.f3705k.set(i3, i4, i5, i6);
            mo3548a(this.f3753q.f3705k, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void mo3548a(Rect rect, int i, int i2) {
            m3988f(m3917a(i, rect.width() + m3926A() + m3928C(), m3931F()), m3917a(i2, rect.height() + m3927B() + m3929D(), m3932G()));
        }

        /* JADX INFO: renamed from: o */
        public void m4005o() {
            if (this.f3753q != null) {
                this.f3753q.requestLayout();
            }
        }

        /* JADX INFO: renamed from: a */
        public static int m3917a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* JADX INFO: renamed from: a */
        public void mo3629a(String str) {
            if (this.f3753q != null) {
                this.f3753q.m3771a(str);
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean mo3637c() {
            return this.f3759w;
        }

        /* JADX INFO: renamed from: p */
        public final boolean m4006p() {
            return this.f3747d;
        }

        /* JADX INFO: renamed from: c */
        void m3974c(RecyclerView recyclerView) {
            this.f3758v = true;
            m3982d(recyclerView);
        }

        /* JADX INFO: renamed from: b */
        void m3967b(RecyclerView recyclerView, C0617o c0617o) {
            this.f3758v = false;
            mo3627a(recyclerView, c0617o);
        }

        /* JADX INFO: renamed from: q */
        public boolean m4007q() {
            return this.f3758v;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3964a(Runnable runnable) {
            if (this.f3753q != null) {
                return this.f3753q.removeCallbacks(runnable);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo3627a(RecyclerView recyclerView, C0617o c0617o) {
            m3985e(recyclerView);
        }

        /* JADX INFO: renamed from: r */
        public boolean m4008r() {
            return this.f3753q != null && this.f3753q.f3703i;
        }

        /* JADX INFO: renamed from: c */
        public void mo3564c(C0617o c0617o, C0621s c0621s) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* JADX INFO: renamed from: a */
        public LayoutParams mo3544a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        /* JADX INFO: renamed from: a */
        public LayoutParams mo3543a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        /* JADX INFO: renamed from: s */
        public boolean m4009s() {
            return this.f3756t != null && this.f3756t.m4093d();
        }

        /* JADX INFO: renamed from: t */
        public int m4010t() {
            return ViewCompat.getLayoutDirection(this.f3753q);
        }

        /* JADX INFO: renamed from: a */
        public void m3944a(View view) {
            m3945a(view, -1);
        }

        /* JADX INFO: renamed from: a */
        public void m3945a(View view, int i) {
            m3922a(view, i, true);
        }

        /* JADX INFO: renamed from: b */
        public void m3968b(View view) {
            m3969b(view, -1);
        }

        /* JADX INFO: renamed from: b */
        public void m3969b(View view, int i) {
            m3922a(view, i, false);
        }

        /* JADX INFO: renamed from: a */
        private void m3922a(View view, int i, boolean z) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (z || abstractC0624vM3746e.m4146q()) {
                this.f3753q.f3702h.m9671e(abstractC0624vM3746e);
            } else {
                this.f3753q.f3702h.m9672f(abstractC0624vM3746e);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (abstractC0624vM3746e.m4140k() || abstractC0624vM3746e.m4138i()) {
                if (abstractC0624vM3746e.m4138i()) {
                    abstractC0624vM3746e.m4139j();
                } else {
                    abstractC0624vM3746e.m4141l();
                }
                this.f3752p.m9359a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3753q) {
                int iM9363b = this.f3752p.m9363b(view);
                if (i == -1) {
                    i = this.f3752p.m9362b();
                }
                if (iM9363b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3753q.indexOfChild(view) + this.f3753q.m3756a());
                }
                if (iM9363b != i) {
                    this.f3753q.f3708n.m3984e(iM9363b, i);
                }
            } else {
                this.f3752p.m9360a(view, i, false);
                layoutParams.f3728e = true;
                if (this.f3756t != null && this.f3756t.m4093d()) {
                    this.f3756t.m4091b(view);
                }
            }
            if (layoutParams.f3729f) {
                abstractC0624vM3746e.f3823a.invalidate();
                layoutParams.f3729f = false;
            }
        }

        /* JADX INFO: renamed from: c */
        public void m3976c(View view) {
            this.f3752p.m9358a(view);
        }

        /* JADX INFO: renamed from: g */
        public void m3991g(int i) {
            if (m3995i(i) != null) {
                this.f3752p.m9357a(i);
            }
        }

        /* JADX INFO: renamed from: d */
        public int m3979d(View view) {
            return ((LayoutParams) view.getLayoutParams()).m3858f();
        }

        /* JADX INFO: renamed from: e */
        public View m3983e(View view) {
            View viewM3788c;
            if (this.f3753q == null || (viewM3788c = this.f3753q.m3788c(view)) == null || this.f3752p.m9367c(viewM3788c)) {
                return null;
            }
            return viewM3788c;
        }

        /* JADX INFO: renamed from: c */
        public View mo3636c(int i) {
            int iM4012v = m4012v();
            for (int i2 = 0; i2 < iM4012v; i2++) {
                View viewM3995i = m3995i(i2);
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(viewM3995i);
                if (abstractC0624vM3746e != null && abstractC0624vM3746e.m4133d() == i && !abstractC0624vM3746e.m4132c() && (this.f3753q.f3650D.m4101a() || !abstractC0624vM3746e.m4146q())) {
                    return viewM3995i;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: h */
        public void m3993h(int i) {
            m3920a(i, m3995i(i));
        }

        /* JADX INFO: renamed from: a */
        private void m3920a(int i, View view) {
            this.f3752p.m9370e(i);
        }

        /* JADX INFO: renamed from: a */
        public void m3948a(View view, int i, LayoutParams layoutParams) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (abstractC0624vM3746e.m4146q()) {
                this.f3753q.f3702h.m9671e(abstractC0624vM3746e);
            } else {
                this.f3753q.f3702h.m9672f(abstractC0624vM3746e);
            }
            this.f3752p.m9359a(view, i, layoutParams, abstractC0624vM3746e.m4146q());
        }

        /* JADX INFO: renamed from: c */
        public void m3977c(View view, int i) {
            m3948a(view, i, (LayoutParams) view.getLayoutParams());
        }

        /* JADX INFO: renamed from: e */
        public void m3984e(int i, int i2) {
            View viewM3995i = m3995i(i);
            if (viewM3995i == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f3753q.toString());
            }
            m3993h(i);
            m3977c(viewM3995i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void m3951a(View view, C0617o c0617o) {
            m3976c(view);
            c0617o.m4058a(view);
        }

        /* JADX INFO: renamed from: a */
        public void m3936a(int i, C0617o c0617o) {
            View viewM3995i = m3995i(i);
            m3991g(i);
            c0617o.m4058a(viewM3995i);
        }

        /* JADX INFO: renamed from: v */
        public int m4012v() {
            if (this.f3752p != null) {
                return this.f3752p.m9362b();
            }
            return 0;
        }

        /* JADX INFO: renamed from: i */
        public View m3995i(int i) {
            if (this.f3752p != null) {
                return this.f3752p.m9364b(i);
            }
            return null;
        }

        /* JADX INFO: renamed from: w */
        public int m4013w() {
            return this.f3748e;
        }

        /* JADX INFO: renamed from: x */
        public int m4014x() {
            return this.f3749f;
        }

        /* JADX INFO: renamed from: y */
        public int m4015y() {
            return this.f3750g;
        }

        /* JADX INFO: renamed from: z */
        public int m4016z() {
            return this.f3751h;
        }

        /* JADX INFO: renamed from: A */
        public int m3926A() {
            if (this.f3753q != null) {
                return this.f3753q.getPaddingLeft();
            }
            return 0;
        }

        /* JADX INFO: renamed from: B */
        public int m3927B() {
            if (this.f3753q != null) {
                return this.f3753q.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: renamed from: C */
        public int m3928C() {
            if (this.f3753q != null) {
                return this.f3753q.getPaddingRight();
            }
            return 0;
        }

        /* JADX INFO: renamed from: D */
        public int m3929D() {
            if (this.f3753q != null) {
                return this.f3753q.getPaddingBottom();
            }
            return 0;
        }

        /* JADX INFO: renamed from: E */
        public View m3930E() {
            View focusedChild;
            if (this.f3753q == null || (focusedChild = this.f3753q.getFocusedChild()) == null || this.f3752p.m9367c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX INFO: renamed from: j */
        public void mo3997j(int i) {
            if (this.f3753q != null) {
                this.f3753q.m3798e(i);
            }
        }

        /* JADX INFO: renamed from: k */
        public void mo3999k(int i) {
            if (this.f3753q != null) {
                this.f3753q.m3795d(i);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m3939a(C0617o c0617o) {
            for (int iM4012v = m4012v() - 1; iM4012v >= 0; iM4012v--) {
                m3921a(c0617o, iM4012v, m3995i(iM4012v));
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3921a(C0617o c0617o, int i, View view) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (abstractC0624vM3746e.m4132c()) {
                return;
            }
            if (abstractC0624vM3746e.m4143n() && !abstractC0624vM3746e.m4146q() && !this.f3753q.f3707m.m3879e()) {
                m3991g(i);
                c0617o.m4064b(abstractC0624vM3746e);
            } else {
                m3993h(i);
                c0617o.m4070c(view);
                this.f3753q.f3702h.m9674h(abstractC0624vM3746e);
            }
        }

        /* JADX INFO: renamed from: b */
        void m3965b(C0617o c0617o) {
            int iM4074e = c0617o.m4074e();
            for (int i = iM4074e - 1; i >= 0; i--) {
                View viewM4075e = c0617o.m4075e(i);
                AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(viewM4075e);
                if (!abstractC0624vM3746e.m4132c()) {
                    abstractC0624vM3746e.m4127a(false);
                    if (abstractC0624vM3746e.m4147r()) {
                        this.f3753q.removeDetachedView(viewM4075e, false);
                    }
                    if (this.f3753q.f3720z != null) {
                        this.f3753q.f3720z.mo3897d(abstractC0624vM3746e);
                    }
                    abstractC0624vM3746e.m4127a(true);
                    c0617o.m4065b(viewM4075e);
                }
            }
            c0617o.m4077f();
            if (iM4074e > 0) {
                this.f3753q.invalidate();
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m3961a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.f3746c && m3923b(view.getMeasuredWidth(), i, layoutParams.width) && m3923b(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: renamed from: b */
        boolean m3971b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.f3746c && m3923b(view.getWidth(), i, layoutParams.width) && m3923b(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: renamed from: b */
        private static boolean m3923b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* JADX INFO: renamed from: a */
        public void m3946a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rectM3811i = this.f3753q.m3811i(view);
            int i3 = i + rectM3811i.left + rectM3811i.right;
            int i4 = i2 + rectM3811i.top + rectM3811i.bottom;
            int iM3918a = m3918a(m4015y(), m4013w(), m3926A() + m3928C() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width, mo3643e());
            int iM3918a2 = m3918a(m4016z(), m4014x(), m3927B() + m3929D() + layoutParams.topMargin + layoutParams.bottomMargin + i4, layoutParams.height, mo3646f());
            if (m3971b(view, iM3918a, iM3918a2, layoutParams)) {
                view.measure(iM3918a, iM3918a2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m3918a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L23
                if (r7 < 0) goto L14
            L10:
                r4 = r7
                r6 = 1073741824(0x40000000, float:2.0)
                goto L34
            L14:
                if (r7 != r1) goto L33
                if (r5 == r2) goto L1f
                if (r5 == 0) goto L1c
                if (r5 == r3) goto L1f
            L1c:
                r5 = 0
                r7 = 0
                goto L20
            L1f:
                r7 = r4
            L20:
                r6 = r5
                r4 = r7
                goto L34
            L23:
                if (r7 < 0) goto L26
                goto L10
            L26:
                if (r7 != r1) goto L2a
                r6 = r5
                goto L34
            L2a:
                if (r7 != r0) goto L33
                if (r5 == r2) goto L30
                if (r5 != r3) goto L34
            L30:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L34
            L33:
                r4 = 0
            L34:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.AbstractC0611i.m3918a(int, int, int, int, boolean):int");
        }

        /* JADX INFO: renamed from: f */
        public int m3987f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3727d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* JADX INFO: renamed from: g */
        public int m3990g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3727d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* JADX INFO: renamed from: a */
        public void m3947a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f3727d;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        /* JADX INFO: renamed from: a */
        public void m3952a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f3727d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f3753q != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f3753q.f3706l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* JADX INFO: renamed from: a */
        public void m3949a(View view, Rect rect) {
            RecyclerView.m3737a(view, rect);
        }

        /* JADX INFO: renamed from: h */
        public int m3992h(View view) {
            return view.getLeft() - m4003n(view);
        }

        /* JADX INFO: renamed from: i */
        public int m3994i(View view) {
            return view.getTop() - m4000l(view);
        }

        /* JADX INFO: renamed from: j */
        public int m3996j(View view) {
            return view.getRight() + m4004o(view);
        }

        /* JADX INFO: renamed from: k */
        public int m3998k(View view) {
            return view.getBottom() + m4002m(view);
        }

        /* JADX INFO: renamed from: b */
        public void m3970b(View view, Rect rect) {
            if (this.f3753q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f3753q.m3811i(view));
            }
        }

        /* JADX INFO: renamed from: l */
        public int m4000l(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3727d.top;
        }

        /* JADX INFO: renamed from: m */
        public int m4002m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3727d.bottom;
        }

        /* JADX INFO: renamed from: n */
        public int m4003n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3727d.left;
        }

        /* JADX INFO: renamed from: o */
        public int m4004o(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3727d.right;
        }

        /* JADX INFO: renamed from: b */
        private int[] m3924b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iM3926A = m3926A();
            int iM3927B = m3927B();
            int iM4015y = m4015y() - m3928C();
            int iM4016z = m4016z() - m3929D();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iM3926A;
            int iMin = Math.min(0, i);
            int i2 = top - iM3927B;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iM4015y;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iM4016z);
            if (m4010t() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3957a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return m3958a(recyclerView, view, rect, z, false);
        }

        /* JADX INFO: renamed from: a */
        public boolean m3958a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrM3924b = m3924b(recyclerView, view, rect, z);
            int i = iArrM3924b[0];
            int i2 = iArrM3924b[1];
            if ((z2 && !m3925d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.m3758a(i, i2);
            }
            return true;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3963a(View view, boolean z, boolean z2) {
            boolean z3 = this.f3754r.m9652a(view, 24579) && this.f3755s.m9652a(view, 24579);
            return z ? z3 : !z3;
        }

        /* JADX INFO: renamed from: d */
        private boolean m3925d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iM3926A = m3926A();
            int iM3927B = m3927B();
            int iM4015y = m4015y() - m3928C();
            int iM4016z = m4016z() - m3929D();
            Rect rect = this.f3753q.f3705k;
            m3949a(focusedChild, rect);
            return rect.left - i < iM4015y && rect.right - i > iM3926A && rect.top - i2 < iM4016z && rect.bottom - i2 > iM3927B;
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public boolean m3959a(RecyclerView recyclerView, View view, View view2) {
            return m4009s() || recyclerView.m3821o();
        }

        /* JADX INFO: renamed from: a */
        public boolean m3956a(RecyclerView recyclerView, C0621s c0621s, View view, View view2) {
            return m3959a(recyclerView, view, view2);
        }

        /* JADX INFO: renamed from: a */
        public void mo3557a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m3975c(recyclerView, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void m3940a(C0617o c0617o, C0621s c0621s, int i, int i2) {
            this.f3753q.m3799e(i, i2);
        }

        /* JADX INFO: renamed from: f */
        public void m3988f(int i, int i2) {
            this.f3753q.setMeasuredDimension(i, i2);
        }

        /* JADX INFO: renamed from: F */
        public int m3931F() {
            return ViewCompat.getMinimumWidth(this.f3753q);
        }

        /* JADX INFO: renamed from: G */
        public int m3932G() {
            return ViewCompat.getMinimumHeight(this.f3753q);
        }

        /* JADX INFO: renamed from: H */
        void m3933H() {
            if (this.f3756t != null) {
                this.f3756t.m4090b();
            }
        }

        /* JADX INFO: renamed from: a */
        void m3943a(AbstractC0620r abstractC0620r) {
            if (this.f3756t == abstractC0620r) {
                this.f3756t = null;
            }
        }

        /* JADX INFO: renamed from: c */
        public void m3973c(C0617o c0617o) {
            for (int iM4012v = m4012v() - 1; iM4012v >= 0; iM4012v--) {
                if (!RecyclerView.m3746e(m3995i(iM4012v)).m4132c()) {
                    m3936a(iM4012v, c0617o);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m3937a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            m3941a(this.f3753q.f3699e, this.f3753q.f3650D, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: renamed from: a */
        public void m3941a(C0617o c0617o, C0621s c0621s, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f3753q.canScrollVertically(-1) || this.f3753q.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.f3753q.canScrollVertically(1) || this.f3753q.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(mo3541a(c0617o, c0621s), mo3561b(c0617o, c0621s), m3986e(c0617o, c0621s), m3978d(c0617o, c0621s)));
        }

        /* JADX INFO: renamed from: a */
        public void mo3628a(AccessibilityEvent accessibilityEvent) {
            m3942a(this.f3753q.f3699e, this.f3753q.f3650D, accessibilityEvent);
        }

        /* JADX INFO: renamed from: a */
        public void m3942a(C0617o c0617o, C0621s c0621s, AccessibilityEvent accessibilityEvent) {
            if (this.f3753q == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!this.f3753q.canScrollVertically(1) && !this.f3753q.canScrollVertically(-1) && !this.f3753q.canScrollHorizontally(-1) && !this.f3753q.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.f3753q.f3707m != null) {
                accessibilityEvent.setItemCount(this.f3753q.f3707m.mo3863a());
            }
        }

        /* JADX INFO: renamed from: a */
        void m3950a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(view);
            if (abstractC0624vM3746e == null || abstractC0624vM3746e.m4146q() || this.f3752p.m9367c(abstractC0624vM3746e.f3823a)) {
                return;
            }
            mo3551a(this.f3753q.f3699e, this.f3753q.f3650D, view, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: renamed from: a */
        public void mo3551a(C0617o c0617o, C0621s c0621s, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(mo3646f() ? m3979d(view) : 0, 1, mo3643e() ? m3979d(view) : 0, 1, false, false));
        }

        /* JADX INFO: renamed from: I */
        public void m3934I() {
            this.f3757u = true;
        }

        /* JADX INFO: renamed from: a */
        public int mo3541a(C0617o c0617o, C0621s c0621s) {
            if (this.f3753q == null || this.f3753q.f3707m == null || !mo3646f()) {
                return 1;
            }
            return this.f3753q.f3707m.mo3863a();
        }

        /* JADX INFO: renamed from: b */
        public int mo3561b(C0617o c0617o, C0621s c0621s) {
            if (this.f3753q == null || this.f3753q.f3707m == null || !mo3643e()) {
                return 1;
            }
            return this.f3753q.f3707m.mo3863a();
        }

        /* JADX INFO: renamed from: a */
        boolean m3953a(int i, Bundle bundle) {
            return m3954a(this.f3753q.f3699e, this.f3753q.f3650D, i, bundle);
        }

        /* JADX INFO: renamed from: a */
        public boolean m3954a(C0617o c0617o, C0621s c0621s, int i, Bundle bundle) {
            int iM4016z;
            int iM4015y;
            if (this.f3753q == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    iM4016z = 0;
                } else {
                    iM4016z = this.f3753q.canScrollVertically(-1) ? -((m4016z() - m3927B()) - m3929D()) : 0;
                    if (this.f3753q.canScrollHorizontally(-1)) {
                        iM4015y = -((m4015y() - m3926A()) - m3928C());
                    }
                }
            } else {
                iM4016z = this.f3753q.canScrollVertically(1) ? (m4016z() - m3927B()) - m3929D() : 0;
                iM4015y = this.f3753q.canScrollHorizontally(1) ? (m4015y() - m3926A()) - m3928C() : 0;
            }
            if (iM4016z == 0 && iM4015y == 0) {
                return false;
            }
            this.f3753q.m3758a(iM4015y, iM4016z);
            return true;
        }

        /* JADX INFO: renamed from: a */
        boolean m3962a(View view, int i, Bundle bundle) {
            return m3955a(this.f3753q.f3699e, this.f3753q.f3650D, view, i, bundle);
        }

        /* JADX INFO: renamed from: a */
        public static b m3919a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i, i2);
            bVar.f3764a = typedArrayObtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            bVar.f3765b = typedArrayObtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            bVar.f3766c = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            bVar.f3767d = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        /* JADX INFO: renamed from: f */
        void m3989f(RecyclerView recyclerView) {
            m3972c(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX INFO: renamed from: J */
        boolean m3935J() {
            int iM4012v = m4012v();
            for (int i = 0; i < iM4012v; i++) {
                ViewGroup.LayoutParams layoutParams = m3995i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$h */
    public static abstract class AbstractC0610h {
        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m3911a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        /* JADX INFO: renamed from: b */
        public void m3915b(Canvas canvas, RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: b */
        public void m3916b(Canvas canvas, RecyclerView recyclerView, C0621s c0621s) {
            m3911a(canvas, recyclerView);
        }

        /* JADX INFO: renamed from: a */
        public void mo3912a(Canvas canvas, RecyclerView recyclerView, C0621s c0621s) {
            m3915b(canvas, recyclerView);
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m3913a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* JADX INFO: renamed from: a */
        public void m3914a(Rect rect, View view, RecyclerView recyclerView, C0621s c0621s) {
            m3913a(rect, ((LayoutParams) view.getLayoutParams()).m3858f(), recyclerView);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$v */
    public static abstract class AbstractC0624v {

        /* JADX INFO: renamed from: q */
        private static final List<Object> f3822q = Collections.emptyList();

        /* JADX INFO: renamed from: a */
        public final View f3823a;

        /* JADX INFO: renamed from: b */
        public WeakReference<RecyclerView> f3824b;

        /* JADX INFO: renamed from: j */
        int f3832j;

        /* JADX INFO: renamed from: p */
        RecyclerView f3838p;

        /* JADX INFO: renamed from: c */
        public int f3825c = -1;

        /* JADX INFO: renamed from: d */
        int f3826d = -1;

        /* JADX INFO: renamed from: e */
        long f3827e = -1;

        /* JADX INFO: renamed from: f */
        int f3828f = -1;

        /* JADX INFO: renamed from: g */
        int f3829g = -1;

        /* JADX INFO: renamed from: h */
        AbstractC0624v f3830h = null;

        /* JADX INFO: renamed from: i */
        AbstractC0624v f3831i = null;

        /* JADX INFO: renamed from: k */
        List<Object> f3833k = null;

        /* JADX INFO: renamed from: l */
        List<Object> f3834l = null;

        /* JADX INFO: renamed from: r */
        private int f3839r = 0;

        /* JADX INFO: renamed from: m */
        C0617o f3835m = null;

        /* JADX INFO: renamed from: n */
        boolean f3836n = false;

        /* JADX INFO: renamed from: s */
        private int f3840s = 0;

        /* JADX INFO: renamed from: o */
        int f3837o = -1;

        public AbstractC0624v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f3823a = view;
        }

        /* JADX INFO: renamed from: a */
        void m4122a(int i, int i2, boolean z) {
            m4130b(8);
            m4123a(i2, z);
            this.f3825c = i;
        }

        /* JADX INFO: renamed from: a */
        void m4123a(int i, boolean z) {
            if (this.f3826d == -1) {
                this.f3826d = this.f3825c;
            }
            if (this.f3829g == -1) {
                this.f3829g = this.f3825c;
            }
            if (z) {
                this.f3829g += i;
            }
            this.f3825c += i;
            if (this.f3823a.getLayoutParams() != null) {
                ((LayoutParams) this.f3823a.getLayoutParams()).f3728e = true;
            }
        }

        /* JADX INFO: renamed from: a */
        void m4120a() {
            this.f3826d = -1;
            this.f3829g = -1;
        }

        /* JADX INFO: renamed from: b */
        void m4129b() {
            if (this.f3826d == -1) {
                this.f3826d = this.f3825c;
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m4132c() {
            return (this.f3832j & 128) != 0;
        }

        /* JADX INFO: renamed from: d */
        public final int m4133d() {
            return this.f3829g == -1 ? this.f3825c : this.f3829g;
        }

        /* JADX INFO: renamed from: e */
        public final int m4134e() {
            if (this.f3838p == null) {
                return -1;
            }
            return this.f3838p.m3792d(this);
        }

        /* JADX INFO: renamed from: f */
        public final int m4135f() {
            return this.f3826d;
        }

        /* JADX INFO: renamed from: g */
        public final long m4136g() {
            return this.f3827e;
        }

        /* JADX INFO: renamed from: h */
        public final int m4137h() {
            return this.f3828f;
        }

        /* JADX INFO: renamed from: i */
        boolean m4138i() {
            return this.f3835m != null;
        }

        /* JADX INFO: renamed from: j */
        void m4139j() {
            this.f3835m.m4069c(this);
        }

        /* JADX INFO: renamed from: k */
        boolean m4140k() {
            return (this.f3832j & 32) != 0;
        }

        /* JADX INFO: renamed from: l */
        void m4141l() {
            this.f3832j &= -33;
        }

        /* JADX INFO: renamed from: m */
        void m4142m() {
            this.f3832j &= -257;
        }

        /* JADX INFO: renamed from: a */
        void m4124a(C0617o c0617o, boolean z) {
            this.f3835m = c0617o;
            this.f3836n = z;
        }

        /* JADX INFO: renamed from: n */
        public boolean m4143n() {
            return (this.f3832j & 4) != 0;
        }

        /* JADX INFO: renamed from: o */
        boolean m4144o() {
            return (this.f3832j & 2) != 0;
        }

        /* JADX INFO: renamed from: p */
        public boolean m4145p() {
            return (this.f3832j & 1) != 0;
        }

        /* JADX INFO: renamed from: q */
        public boolean m4146q() {
            return (this.f3832j & 8) != 0;
        }

        /* JADX INFO: renamed from: a */
        boolean m4128a(int i) {
            return (i & this.f3832j) != 0;
        }

        /* JADX INFO: renamed from: r */
        boolean m4147r() {
            return (this.f3832j & 256) != 0;
        }

        /* JADX INFO: renamed from: s */
        boolean m4148s() {
            return (this.f3832j & 512) != 0 || m4143n();
        }

        /* JADX INFO: renamed from: a */
        void m4121a(int i, int i2) {
            this.f3832j = (i & i2) | (this.f3832j & (i2 ^ (-1)));
        }

        /* JADX INFO: renamed from: b */
        void m4130b(int i) {
            this.f3832j = i | this.f3832j;
        }

        /* JADX INFO: renamed from: a */
        void m4126a(Object obj) {
            if (obj == null) {
                m4130b(1024);
            } else if ((1024 & this.f3832j) == 0) {
                m4119A();
                this.f3833k.add(obj);
            }
        }

        /* JADX INFO: renamed from: A */
        private void m4119A() {
            if (this.f3833k == null) {
                this.f3833k = new ArrayList();
                this.f3834l = Collections.unmodifiableList(this.f3833k);
            }
        }

        /* JADX INFO: renamed from: t */
        void m4149t() {
            if (this.f3833k != null) {
                this.f3833k.clear();
            }
            this.f3832j &= -1025;
        }

        /* JADX INFO: renamed from: u */
        List<Object> m4150u() {
            if ((this.f3832j & 1024) == 0) {
                if (this.f3833k == null || this.f3833k.size() == 0) {
                    return f3822q;
                }
                return this.f3834l;
            }
            return f3822q;
        }

        /* JADX INFO: renamed from: v */
        void m4151v() {
            this.f3832j = 0;
            this.f3825c = -1;
            this.f3826d = -1;
            this.f3827e = -1L;
            this.f3829g = -1;
            this.f3839r = 0;
            this.f3830h = null;
            this.f3831i = null;
            m4149t();
            this.f3840s = 0;
            this.f3837o = -1;
            RecyclerView.m3744c(this);
        }

        /* JADX INFO: renamed from: a */
        void m4125a(RecyclerView recyclerView) {
            if (this.f3837o != -1) {
                this.f3840s = this.f3837o;
            } else {
                this.f3840s = ViewCompat.getImportantForAccessibility(this.f3823a);
            }
            recyclerView.m3774a(this, 4);
        }

        /* JADX INFO: renamed from: b */
        void m4131b(RecyclerView recyclerView) {
            recyclerView.m3774a(this, this.f3840s);
            this.f3840s = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f3825c + " id=" + this.f3827e + ", oldPos=" + this.f3826d + ", pLpos:" + this.f3829g);
            if (m4138i()) {
                sb.append(" scrap ");
                sb.append(this.f3836n ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m4143n()) {
                sb.append(" invalid");
            }
            if (!m4145p()) {
                sb.append(" unbound");
            }
            if (m4144o()) {
                sb.append(" update");
            }
            if (m4146q()) {
                sb.append(" removed");
            }
            if (m4132c()) {
                sb.append(" ignored");
            }
            if (m4147r()) {
                sb.append(" tmpDetached");
            }
            if (!m4152w()) {
                sb.append(" not recyclable(" + this.f3839r + ")");
            }
            if (m4148s()) {
                sb.append(" undefined adapter position");
            }
            if (this.f3823a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: renamed from: a */
        public final void m4127a(boolean z) {
            this.f3839r = z ? this.f3839r - 1 : this.f3839r + 1;
            if (this.f3839r < 0) {
                this.f3839r = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && this.f3839r == 1) {
                this.f3832j |= 16;
            } else if (z && this.f3839r == 0) {
                this.f3832j &= -17;
            }
        }

        /* JADX INFO: renamed from: w */
        public final boolean m4152w() {
            return (this.f3832j & 16) == 0 && !ViewCompat.hasTransientState(this.f3823a);
        }

        /* JADX INFO: renamed from: x */
        boolean m4153x() {
            return (this.f3832j & 16) != 0;
        }

        /* JADX INFO: renamed from: y */
        boolean m4154y() {
            return (this.f3832j & 16) == 0 && ViewCompat.hasTransientState(this.f3823a);
        }

        /* JADX INFO: renamed from: z */
        boolean m4155z() {
            return (this.f3832j & 2) != 0;
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3774a(AbstractC0624v abstractC0624v, int i) {
        if (m3821o()) {
            abstractC0624v.f3837o = i;
            this.f3657K.add(abstractC0624v);
            return false;
        }
        ViewCompat.setImportantForAccessibility(abstractC0624v.f3823a, i);
        return true;
    }

    /* JADX INFO: renamed from: x */
    void m3830x() {
        int i;
        for (int size = this.f3657K.size() - 1; size >= 0; size--) {
            AbstractC0624v abstractC0624v = this.f3657K.get(size);
            if (abstractC0624v.f3823a.getParent() == this && !abstractC0624v.m4132c() && (i = abstractC0624v.f3837o) != -1) {
                ViewCompat.setImportantForAccessibility(abstractC0624v.f3823a, i);
                abstractC0624v.f3837o = -1;
            }
        }
        this.f3657K.clear();
    }

    /* JADX INFO: renamed from: d */
    int m3792d(AbstractC0624v abstractC0624v) {
        if (abstractC0624v.m4128a(524) || !abstractC0624v.m4145p()) {
            return -1;
        }
        return this.f3700f.m9206c(abstractC0624v.f3825c);
    }

    /* JADX INFO: renamed from: a */
    void m3763a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + m3756a());
        }
        Resources resources = getContext().getResources();
        new C1745gj(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.recyclerview.R.dimen.fastscroll_margin));
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: c */
        AbstractC0624v f3726c;

        /* JADX INFO: renamed from: d */
        final Rect f3727d;

        /* JADX INFO: renamed from: e */
        boolean f3728e;

        /* JADX INFO: renamed from: f */
        boolean f3729f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3727d = new Rect();
            this.f3728e = true;
            this.f3729f = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3727d = new Rect();
            this.f3728e = true;
            this.f3729f = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3727d = new Rect();
            this.f3728e = true;
            this.f3729f = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3727d = new Rect();
            this.f3728e = true;
            this.f3729f = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f3727d = new Rect();
            this.f3728e = true;
            this.f3729f = false;
        }

        /* JADX INFO: renamed from: c */
        public boolean m3855c() {
            return this.f3726c.m4143n();
        }

        /* JADX INFO: renamed from: d */
        public boolean m3856d() {
            return this.f3726c.m4146q();
        }

        /* JADX INFO: renamed from: e */
        public boolean m3857e() {
            return this.f3726c.m4155z();
        }

        /* JADX INFO: renamed from: f */
        public int m3858f() {
            return this.f3726c.m4133d();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$r */
    public static abstract class AbstractC0620r {

        /* JADX INFO: renamed from: a */
        private int f3784a;

        /* JADX INFO: renamed from: b */
        private RecyclerView f3785b;

        /* JADX INFO: renamed from: c */
        private AbstractC0611i f3786c;

        /* JADX INFO: renamed from: d */
        private boolean f3787d;

        /* JADX INFO: renamed from: e */
        private boolean f3788e;

        /* JADX INFO: renamed from: f */
        private View f3789f;

        /* JADX INFO: renamed from: g */
        private final a f3790g;

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$r$b */
        public interface b {
            /* JADX INFO: renamed from: d */
            PointF mo3639d(int i);
        }

        /* JADX INFO: renamed from: a */
        protected abstract void m4087a(int i, int i2, C0621s c0621s, a aVar);

        /* JADX INFO: renamed from: a */
        protected abstract void m4088a(View view, C0621s c0621s, a aVar);

        /* JADX INFO: renamed from: f */
        protected abstract void m4095f();

        /* JADX INFO: renamed from: a */
        public void m4085a(int i) {
            this.f3784a = i;
        }

        /* JADX INFO: renamed from: b */
        public PointF m4089b(int i) {
            Object objM4084a = m4084a();
            if (objM4084a instanceof b) {
                return ((b) objM4084a).mo3639d(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        /* JADX INFO: renamed from: a */
        public AbstractC0611i m4084a() {
            return this.f3786c;
        }

        /* JADX INFO: renamed from: b */
        protected final void m4090b() {
            if (this.f3788e) {
                this.f3788e = false;
                m4095f();
                this.f3785b.f3650D.f3798a = -1;
                this.f3789f = null;
                this.f3784a = -1;
                this.f3787d = false;
                this.f3786c.m3943a(this);
                this.f3786c = null;
                this.f3785b = null;
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m4092c() {
            return this.f3787d;
        }

        /* JADX INFO: renamed from: d */
        public boolean m4093d() {
            return this.f3788e;
        }

        /* JADX INFO: renamed from: e */
        public int m4094e() {
            return this.f3784a;
        }

        /* JADX INFO: renamed from: a */
        void m4086a(int i, int i2) {
            PointF pointFM4089b;
            RecyclerView recyclerView = this.f3785b;
            if (!this.f3788e || this.f3784a == -1 || recyclerView == null) {
                m4090b();
            }
            if (this.f3787d && this.f3789f == null && this.f3786c != null && (pointFM4089b = m4089b(this.f3784a)) != null && (pointFM4089b.x != 0.0f || pointFM4089b.y != 0.0f)) {
                recyclerView.m3762a((int) Math.signum(pointFM4089b.x), (int) Math.signum(pointFM4089b.y), (int[]) null);
            }
            this.f3787d = false;
            if (this.f3789f != null) {
                if (m4083a(this.f3789f) == this.f3784a) {
                    m4088a(this.f3789f, recyclerView.f3650D, this.f3790g);
                    this.f3790g.m4097a(recyclerView);
                    m4090b();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f3789f = null;
                }
            }
            if (this.f3788e) {
                m4087a(i, i2, recyclerView.f3650D, this.f3790g);
                boolean zM4098a = this.f3790g.m4098a();
                this.f3790g.m4097a(recyclerView);
                if (zM4098a) {
                    if (this.f3788e) {
                        this.f3787d = true;
                        recyclerView.f3647A.m4111a();
                    } else {
                        m4090b();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public int m4083a(View view) {
            return this.f3785b.m3800f(view);
        }

        /* JADX INFO: renamed from: b */
        protected void m4091b(View view) {
            if (m4083a(view) == m4094e()) {
                this.f3789f = view;
            }
        }

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$r$a */
        public static class a {

            /* JADX INFO: renamed from: a */
            private int f3791a;

            /* JADX INFO: renamed from: b */
            private int f3792b;

            /* JADX INFO: renamed from: c */
            private int f3793c;

            /* JADX INFO: renamed from: d */
            private int f3794d;

            /* JADX INFO: renamed from: e */
            private Interpolator f3795e;

            /* JADX INFO: renamed from: f */
            private boolean f3796f;

            /* JADX INFO: renamed from: g */
            private int f3797g;

            /* JADX INFO: renamed from: a */
            boolean m4098a() {
                return this.f3794d >= 0;
            }

            /* JADX INFO: renamed from: a */
            void m4097a(RecyclerView recyclerView) {
                if (this.f3794d >= 0) {
                    int i = this.f3794d;
                    this.f3794d = -1;
                    recyclerView.m3779b(i);
                    this.f3796f = false;
                    return;
                }
                if (this.f3796f) {
                    m4096b();
                    if (this.f3795e == null) {
                        if (this.f3793c == Integer.MIN_VALUE) {
                            recyclerView.f3647A.m4118b(this.f3791a, this.f3792b);
                        } else {
                            recyclerView.f3647A.m4113a(this.f3791a, this.f3792b, this.f3793c);
                        }
                    } else {
                        recyclerView.f3647A.m4115a(this.f3791a, this.f3792b, this.f3793c, this.f3795e);
                    }
                    this.f3797g++;
                    if (this.f3797g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3796f = false;
                    return;
                }
                this.f3797g = 0;
            }

            /* JADX INFO: renamed from: b */
            private void m4096b() {
                if (this.f3795e != null && this.f3793c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f3793c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$b */
    static class C0604b extends Observable<AbstractC0605c> {
        C0604b() {
        }

        /* JADX INFO: renamed from: a */
        public void m3881a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0605c) this.mObservers.get(size)).mo3882a();
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
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
        Parcelable f3730a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3730a = parcel.readParcelable(classLoader == null ? AbstractC0611i.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3730a, 0);
        }

        /* JADX INFO: renamed from: a */
        void m3859a(SavedState savedState) {
            this.f3730a = savedState.f3730a;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$s */
    public static class C0621s {

        /* JADX INFO: renamed from: a */
        int f3798a = -1;

        /* JADX INFO: renamed from: b */
        int f3799b = 0;

        /* JADX INFO: renamed from: c */
        int f3800c = 0;

        /* JADX INFO: renamed from: d */
        int f3801d = 1;

        /* JADX INFO: renamed from: e */
        int f3802e = 0;

        /* JADX INFO: renamed from: f */
        boolean f3803f = false;

        /* JADX INFO: renamed from: g */
        boolean f3804g = false;

        /* JADX INFO: renamed from: h */
        boolean f3805h = false;

        /* JADX INFO: renamed from: i */
        boolean f3806i = false;

        /* JADX INFO: renamed from: j */
        boolean f3807j = false;

        /* JADX INFO: renamed from: k */
        boolean f3808k = false;

        /* JADX INFO: renamed from: l */
        int f3809l;

        /* JADX INFO: renamed from: m */
        long f3810m;

        /* JADX INFO: renamed from: n */
        int f3811n;

        /* JADX INFO: renamed from: o */
        int f3812o;

        /* JADX INFO: renamed from: p */
        int f3813p;

        /* JADX INFO: renamed from: q */
        private SparseArray<Object> f3814q;

        /* JADX INFO: renamed from: a */
        void m4099a(int i) {
            if ((this.f3801d & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f3801d));
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4100a(AbstractC0603a abstractC0603a) {
            this.f3801d = 1;
            this.f3802e = abstractC0603a.mo3863a();
            this.f3804g = false;
            this.f3805h = false;
            this.f3806i = false;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4101a() {
            return this.f3804g;
        }

        /* JADX INFO: renamed from: b */
        public boolean m4102b() {
            return this.f3808k;
        }

        /* JADX INFO: renamed from: c */
        public int m4103c() {
            return this.f3798a;
        }

        /* JADX INFO: renamed from: d */
        public boolean m4104d() {
            return this.f3798a != -1;
        }

        /* JADX INFO: renamed from: e */
        public int m4105e() {
            return this.f3804g ? this.f3799b - this.f3800c : this.f3802e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3798a + ", mData=" + this.f3814q + ", mItemCount=" + this.f3802e + ", mIsMeasuring=" + this.f3806i + ", mPreviousLayoutItemCount=" + this.f3799b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3800c + ", mStructureChanged=" + this.f3803f + ", mInPreLayout=" + this.f3804g + ", mRunSimpleAnimations=" + this.f3807j + ", mRunPredictiveAnimations=" + this.f3808k + '}';
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$g */
    class C0609g implements AbstractC0608f.b {
        C0609g() {
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0608f.b
        /* JADX INFO: renamed from: a */
        public void mo3908a(AbstractC0624v abstractC0624v) {
            abstractC0624v.m4127a(true);
            if (abstractC0624v.f3830h != null && abstractC0624v.f3831i == null) {
                abstractC0624v.f3830h = null;
            }
            abstractC0624v.f3831i = null;
            if (abstractC0624v.m4153x() || RecyclerView.this.m3775a(abstractC0624v.f3823a) || !abstractC0624v.m4147r()) {
                return;
            }
            RecyclerView.this.removeDetachedView(abstractC0624v.f3823a, false);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$f */
    public static abstract class AbstractC0608f {

        /* JADX INFO: renamed from: a */
        private b f3733a = null;

        /* JADX INFO: renamed from: b */
        private ArrayList<a> f3734b = new ArrayList<>();

        /* JADX INFO: renamed from: c */
        private long f3735c = 120;

        /* JADX INFO: renamed from: d */
        private long f3736d = 120;

        /* JADX INFO: renamed from: e */
        private long f3737e = 250;

        /* JADX INFO: renamed from: f */
        private long f3738f = 250;

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$f$a */
        public interface a {
            /* JADX INFO: renamed from: a */
            void m3907a();
        }

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$f$b */
        interface b {
            /* JADX INFO: renamed from: a */
            void mo3908a(AbstractC0624v abstractC0624v);
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo3888a();

        /* JADX INFO: renamed from: a */
        public abstract boolean mo3890a(AbstractC0624v abstractC0624v, c cVar, c cVar2);

        /* JADX INFO: renamed from: a */
        public abstract boolean mo3891a(AbstractC0624v abstractC0624v, AbstractC0624v abstractC0624v2, c cVar, c cVar2);

        /* JADX INFO: renamed from: b */
        public abstract boolean mo3893b();

        /* JADX INFO: renamed from: b */
        public abstract boolean mo3894b(AbstractC0624v abstractC0624v, c cVar, c cVar2);

        /* JADX INFO: renamed from: c */
        public abstract boolean mo3895c(AbstractC0624v abstractC0624v, c cVar, c cVar2);

        /* JADX INFO: renamed from: d */
        public abstract void mo3896d();

        /* JADX INFO: renamed from: d */
        public abstract void mo3897d(AbstractC0624v abstractC0624v);

        /* JADX INFO: renamed from: g */
        public void m3902g(AbstractC0624v abstractC0624v) {
        }

        /* JADX INFO: renamed from: h */
        public boolean mo3904h(AbstractC0624v abstractC0624v) {
            return true;
        }

        /* JADX INFO: renamed from: e */
        public long m3898e() {
            return this.f3737e;
        }

        /* JADX INFO: renamed from: f */
        public long m3899f() {
            return this.f3735c;
        }

        /* JADX INFO: renamed from: g */
        public long m3901g() {
            return this.f3736d;
        }

        /* JADX INFO: renamed from: h */
        public long m3903h() {
            return this.f3738f;
        }

        /* JADX INFO: renamed from: a */
        void m3889a(b bVar) {
            this.f3733a = bVar;
        }

        /* JADX INFO: renamed from: a */
        public c m3887a(C0621s c0621s, AbstractC0624v abstractC0624v, int i, List<Object> list) {
            return m3906j().m3909a(abstractC0624v);
        }

        /* JADX INFO: renamed from: a */
        public c m3886a(C0621s c0621s, AbstractC0624v abstractC0624v) {
            return m3906j().m3909a(abstractC0624v);
        }

        /* JADX INFO: renamed from: e */
        static int m3885e(AbstractC0624v abstractC0624v) {
            int i = abstractC0624v.f3832j & 14;
            if (abstractC0624v.m4143n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iM4135f = abstractC0624v.m4135f();
            int iM4134e = abstractC0624v.m4134e();
            return (iM4135f == -1 || iM4134e == -1 || iM4135f == iM4134e) ? i : i | 2048;
        }

        /* JADX INFO: renamed from: f */
        public final void m3900f(AbstractC0624v abstractC0624v) {
            m3902g(abstractC0624v);
            if (this.f3733a != null) {
                this.f3733a.mo3908a(abstractC0624v);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean mo3892a(AbstractC0624v abstractC0624v, List<Object> list) {
            return mo3904h(abstractC0624v);
        }

        /* JADX INFO: renamed from: i */
        public final void m3905i() {
            int size = this.f3734b.size();
            for (int i = 0; i < size; i++) {
                this.f3734b.get(i).m3907a();
            }
            this.f3734b.clear();
        }

        /* JADX INFO: renamed from: j */
        public c m3906j() {
            return new c();
        }

        /* JADX INFO: renamed from: android.support.v7.widget.RecyclerView$f$c */
        public static class c {

            /* JADX INFO: renamed from: a */
            public int f3739a;

            /* JADX INFO: renamed from: b */
            public int f3740b;

            /* JADX INFO: renamed from: c */
            public int f3741c;

            /* JADX INFO: renamed from: d */
            public int f3742d;

            /* JADX INFO: renamed from: a */
            public c m3909a(AbstractC0624v abstractC0624v) {
                return m3910a(abstractC0624v, 0);
            }

            /* JADX INFO: renamed from: a */
            public c m3910a(AbstractC0624v abstractC0624v, int i) {
                View view = abstractC0624v.f3823a;
                this.f3739a = view.getLeft();
                this.f3740b = view.getTop();
                this.f3741c = view.getRight();
                this.f3742d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f3666aC == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.f3666aC.m3883a(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f3668aE == null) {
            this.f3668aE = new NestedScrollingChildHelper(this);
        }
        return this.f3668aE;
    }
}
