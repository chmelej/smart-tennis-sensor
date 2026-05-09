package android.support.design.widget;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import java.util.List;
import p000.C0776br;
import p000.C2178v;
import p000.InterfaceC0762bd;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a */
    static final Handler f2327a;

    /* JADX INFO: renamed from: d */
    private static final boolean f2328d;

    /* JADX INFO: renamed from: e */
    private static final int[] f2329e;

    /* JADX INFO: renamed from: b */
    protected final SnackbarBaseLayout f2330b;

    /* JADX INFO: renamed from: c */
    final C0776br.a f2331c;

    /* JADX INFO: renamed from: f */
    private final ViewGroup f2332f;

    /* JADX INFO: renamed from: g */
    private final InterfaceC0762bd f2333g;

    /* JADX INFO: renamed from: h */
    private List<AbstractC0268a<B>> f2334h;

    /* JADX INFO: renamed from: i */
    private Behavior f2335i;

    /* JADX INFO: renamed from: j */
    private final AccessibilityManager f2336j;

    /* JADX INFO: renamed from: android.support.design.widget.BaseTransientBottomBar$a */
    public static abstract class AbstractC0268a<B> {
        /* JADX INFO: renamed from: a */
        public void m2612a(B b) {
        }

        /* JADX INFO: renamed from: a */
        public void m2613a(B b, int i) {
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.BaseTransientBottomBar$c */
    public interface InterfaceC0270c {
        /* JADX INFO: renamed from: a */
        void mo2604a(View view);

        /* JADX INFO: renamed from: b */
        void mo2605b(View view);
    }

    /* JADX INFO: renamed from: android.support.design.widget.BaseTransientBottomBar$d */
    public interface InterfaceC0271d {
        /* JADX INFO: renamed from: a */
        void mo2606a(View view, int i, int i2, int i3, int i4);
    }

    static {
        f2328d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        f2329e = new int[]{R.attr.snackbarStyle};
        f2327a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.BaseTransientBottomBar.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((BaseTransientBottomBar) message.obj).m2597c();
                        break;
                    case 1:
                        ((BaseTransientBottomBar) message.obj).m2596b(message.arg1);
                        break;
                }
                return true;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected void m2593a(int i) {
        C0776br.m5686a().m5693a(this.f2331c, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2594a() {
        return C0776br.m5686a().m5698e(this.f2331c);
    }

    /* JADX INFO: renamed from: b */
    protected SwipeDismissBehavior<? extends View> m2595b() {
        return new Behavior();
    }

    /* JADX INFO: renamed from: c */
    final void m2597c() {
        if (this.f2330b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f2330b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0290d) {
                CoordinatorLayout.C0290d c0290d = (CoordinatorLayout.C0290d) layoutParams;
                SwipeDismissBehavior<? extends View> swipeDismissBehaviorM2595b = this.f2335i == null ? m2595b() : this.f2335i;
                if (swipeDismissBehaviorM2595b instanceof Behavior) {
                    ((Behavior) swipeDismissBehaviorM2595b).m2608a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehaviorM2595b.m2811a(new SwipeDismissBehavior.InterfaceC0301a() { // from class: android.support.design.widget.BaseTransientBottomBar.4
                    @Override // android.support.design.widget.SwipeDismissBehavior.InterfaceC0301a
                    /* JADX INFO: renamed from: a */
                    public void mo2603a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.m2593a(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.InterfaceC0301a
                    /* JADX INFO: renamed from: a */
                    public void mo2602a(int i) {
                        switch (i) {
                            case 0:
                                C0776br.m5686a().m5697d(BaseTransientBottomBar.this.f2331c);
                                break;
                            case 1:
                            case 2:
                                C0776br.m5686a().m5696c(BaseTransientBottomBar.this.f2331c);
                                break;
                        }
                    }
                });
                c0290d.m2736a(swipeDismissBehaviorM2595b);
                c0290d.f2462g = 80;
            }
            this.f2332f.addView(this.f2330b);
        }
        this.f2330b.setOnAttachStateChangeListener(new InterfaceC0270c() { // from class: android.support.design.widget.BaseTransientBottomBar.5
            @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0270c
            /* JADX INFO: renamed from: a */
            public void mo2604a(View view) {
            }

            @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0270c
            /* JADX INFO: renamed from: b */
            public void mo2605b(View view) {
                if (BaseTransientBottomBar.this.m2594a()) {
                    BaseTransientBottomBar.f2327a.post(new Runnable() { // from class: android.support.design.widget.BaseTransientBottomBar.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.m2598c(3);
                        }
                    });
                }
            }
        });
        if (ViewCompat.isLaidOut(this.f2330b)) {
            if (m2601f()) {
                m2599d();
                return;
            } else {
                m2600e();
                return;
            }
        }
        this.f2330b.setOnLayoutChangeListener(new InterfaceC0271d() { // from class: android.support.design.widget.BaseTransientBottomBar.6
            @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0271d
            /* JADX INFO: renamed from: a */
            public void mo2606a(View view, int i, int i2, int i3, int i4) {
                BaseTransientBottomBar.this.f2330b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.m2601f()) {
                    BaseTransientBottomBar.this.m2599d();
                } else {
                    BaseTransientBottomBar.this.m2600e();
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    void m2599d() {
        final int iM2592h = m2592h();
        if (f2328d) {
            ViewCompat.offsetTopAndBottom(this.f2330b, iM2592h);
        } else {
            this.f2330b.setTranslationY(iM2592h);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iM2592h, 0);
        valueAnimator.setInterpolator(C2178v.f13000b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f2333g.mo2803a(70, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.m2600e();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.8

            /* JADX INFO: renamed from: c */
            private int f2348c;

            {
                this.f2348c = iM2592h;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f2328d) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f2330b, iIntValue - this.f2348c);
                } else {
                    BaseTransientBottomBar.this.f2330b.setTranslationY(iIntValue);
                }
                this.f2348c = iIntValue;
            }
        });
        valueAnimator.start();
    }

    /* JADX INFO: renamed from: d */
    private void m2590d(final int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, m2592h());
        valueAnimator.setInterpolator(C2178v.f13000b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f2333g.mo2804b(0, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.m2598c(i);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.3

            /* JADX INFO: renamed from: b */
            private int f2340b = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f2328d) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f2330b, iIntValue - this.f2340b);
                } else {
                    BaseTransientBottomBar.this.f2330b.setTranslationY(iIntValue);
                }
                this.f2340b = iIntValue;
            }
        });
        valueAnimator.start();
    }

    /* JADX INFO: renamed from: h */
    private int m2592h() {
        int height = this.f2330b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f2330b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: renamed from: b */
    final void m2596b(int i) {
        if (m2601f() && this.f2330b.getVisibility() == 0) {
            m2590d(i);
        } else {
            m2598c(i);
        }
    }

    /* JADX INFO: renamed from: e */
    void m2600e() {
        C0776br.m5686a().m5695b(this.f2331c);
        if (this.f2334h != null) {
            for (int size = this.f2334h.size() - 1; size >= 0; size--) {
                this.f2334h.get(size).m2612a(this);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m2598c(int i) {
        C0776br.m5686a().m5692a(this.f2331c);
        if (this.f2334h != null) {
            for (int size = this.f2334h.size() - 1; size >= 0; size--) {
                this.f2334h.get(size).m2613a(this, i);
            }
        }
        ViewParent parent = this.f2330b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f2330b);
        }
    }

    /* JADX INFO: renamed from: f */
    boolean m2601f() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.f2336j.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: a */
        private final AccessibilityManager f2350a;

        /* JADX INFO: renamed from: b */
        private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f2351b;

        /* JADX INFO: renamed from: c */
        private InterfaceC0271d f2352c;

        /* JADX INFO: renamed from: d */
        private InterfaceC0270c f2353d;

        protected SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f2350a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f2351b = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: android.support.design.widget.BaseTransientBottomBar.SnackbarBaseLayout.1
                @Override // android.support.v4.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
                public void onTouchExplorationStateChanged(boolean z) {
                    SnackbarBaseLayout.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f2350a, this.f2351b);
            setClickableOrFocusableBasedOnAccessibility(this.f2350a.isTouchExplorationEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f2352c != null) {
                this.f2352c.mo2606a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f2353d != null) {
                this.f2353d.mo2604a(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f2353d != null) {
                this.f2353d.mo2605b(this);
            }
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(this.f2350a, this.f2351b);
        }

        void setOnLayoutChangeListener(InterfaceC0271d interfaceC0271d) {
            this.f2352c = interfaceC0271d;
        }

        void setOnAttachStateChangeListener(InterfaceC0270c interfaceC0270c) {
            this.f2353d = interfaceC0270c;
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: g */
        private final C0269b f2349g = new C0269b(this);

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m2608a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f2349g.m2614a(baseTransientBottomBar);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        /* JADX INFO: renamed from: a */
        public boolean mo2609a(View view) {
            return this.f2349g.m2616a(view);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b */
        public boolean mo2610b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f2349g.m2615a(coordinatorLayout, view, motionEvent);
            return super.mo2610b(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.BaseTransientBottomBar$b */
    public static class C0269b {

        /* JADX INFO: renamed from: a */
        private C0776br.a f2355a;

        public C0269b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.m2809a(0.1f);
            swipeDismissBehavior.m2812b(0.6f);
            swipeDismissBehavior.m2810a(0);
        }

        /* JADX INFO: renamed from: a */
        public void m2614a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f2355a = baseTransientBottomBar.f2331c;
        }

        /* JADX INFO: renamed from: a */
        public boolean m2616a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        /* JADX INFO: renamed from: a */
        public void m2615a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.m2702a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            C0776br.m5686a().m5696c(this.f2355a);
                        }
                        break;
                }
            }
            C0776br.m5686a().m5697d(this.f2355a);
        }
    }
}
