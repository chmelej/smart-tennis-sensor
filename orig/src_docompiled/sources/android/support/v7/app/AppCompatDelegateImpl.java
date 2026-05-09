package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import p000.AbstractC1676dx;
import p000.AbstractC1694em;
import p000.C1678dz;
import p000.C1680ea;
import p000.C1682ec;
import p000.C1683ed;
import p000.C1684ee;
import p000.C1696eo;
import p000.C1697ep;
import p000.C1698eq;
import p000.C1699er;
import p000.C1706ey;
import p000.C1726fr;
import p000.C1766hd;
import p000.C1771hi;
import p000.C1774hl;
import p000.DialogC1677dy;
import p000.InterfaceC1675dw;
import p000.InterfaceC1714ff;
import p000.InterfaceC1715fg;
import p000.InterfaceC1740ge;
import p000.InterfaceC1746gk;
import p000.WindowCallbackC1701et;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl extends AbstractC1676dx implements MenuBuilder.InterfaceC0552a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: u */
    private static final boolean f3091u;

    /* JADX INFO: renamed from: v */
    private static final int[] f3092v;

    /* JADX INFO: renamed from: w */
    private static boolean f3093w;

    /* JADX INFO: renamed from: A */
    private C0548f f3094A;

    /* JADX INFO: renamed from: C */
    private boolean f3096C;

    /* JADX INFO: renamed from: D */
    private ViewGroup f3097D;

    /* JADX INFO: renamed from: E */
    private TextView f3098E;

    /* JADX INFO: renamed from: F */
    private View f3099F;

    /* JADX INFO: renamed from: G */
    private boolean f3100G;

    /* JADX INFO: renamed from: H */
    private boolean f3101H;

    /* JADX INFO: renamed from: I */
    private boolean f3102I;

    /* JADX INFO: renamed from: J */
    private PanelFeatureState[] f3103J;

    /* JADX INFO: renamed from: K */
    private PanelFeatureState f3104K;

    /* JADX INFO: renamed from: L */
    private boolean f3105L;

    /* JADX INFO: renamed from: N */
    private boolean f3107N;

    /* JADX INFO: renamed from: O */
    private C0546d f3108O;

    /* JADX INFO: renamed from: Q */
    private boolean f3110Q;

    /* JADX INFO: renamed from: R */
    private Rect f3111R;

    /* JADX INFO: renamed from: S */
    private Rect f3112S;

    /* JADX INFO: renamed from: T */
    private AppCompatViewInflater f3113T;

    /* JADX INFO: renamed from: a */
    final Context f3114a;

    /* JADX INFO: renamed from: b */
    final Window f3115b;

    /* JADX INFO: renamed from: c */
    final Window.Callback f3116c;

    /* JADX INFO: renamed from: d */
    final Window.Callback f3117d;

    /* JADX INFO: renamed from: e */
    final InterfaceC1675dw f3118e;

    /* JADX INFO: renamed from: f */
    ActionBar f3119f;

    /* JADX INFO: renamed from: g */
    MenuInflater f3120g;

    /* JADX INFO: renamed from: h */
    AbstractC1694em f3121h;

    /* JADX INFO: renamed from: i */
    ActionBarContextView f3122i;

    /* JADX INFO: renamed from: j */
    PopupWindow f3123j;

    /* JADX INFO: renamed from: k */
    Runnable f3124k;

    /* JADX INFO: renamed from: m */
    boolean f3126m;

    /* JADX INFO: renamed from: n */
    boolean f3127n;

    /* JADX INFO: renamed from: o */
    boolean f3128o;

    /* JADX INFO: renamed from: p */
    boolean f3129p;

    /* JADX INFO: renamed from: q */
    boolean f3130q;

    /* JADX INFO: renamed from: r */
    boolean f3131r;

    /* JADX INFO: renamed from: s */
    boolean f3132s;

    /* JADX INFO: renamed from: t */
    int f3133t;

    /* JADX INFO: renamed from: x */
    private CharSequence f3134x;

    /* JADX INFO: renamed from: y */
    private InterfaceC1740ge f3135y;

    /* JADX INFO: renamed from: z */
    private C0543a f3136z;

    /* JADX INFO: renamed from: l */
    ViewPropertyAnimatorCompat f3125l = null;

    /* JADX INFO: renamed from: B */
    private boolean f3095B = true;

    /* JADX INFO: renamed from: M */
    private int f3106M = -100;

    /* JADX INFO: renamed from: P */
    private final Runnable f3109P = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImpl.2
        @Override // java.lang.Runnable
        public void run() {
            if ((AppCompatDelegateImpl.this.f3133t & 1) != 0) {
                AppCompatDelegateImpl.this.m3252g(0);
            }
            if ((AppCompatDelegateImpl.this.f3133t & 4096) != 0) {
                AppCompatDelegateImpl.this.m3252g(108);
            }
            AppCompatDelegateImpl.this.f3132s = false;
            AppCompatDelegateImpl.this.f3133t = 0;
        }
    };

    /* JADX INFO: renamed from: a */
    void m3230a(ViewGroup viewGroup) {
    }

    static {
        f3091u = Build.VERSION.SDK_INT < 21;
        f3092v = new int[]{R.attr.windowBackground};
        if (!f3091u || f3093w) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.AppCompatDelegateImpl.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (m3266a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            /* JADX INFO: renamed from: a */
            private boolean m3266a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        f3093w = true;
    }

    public AppCompatDelegateImpl(Context context, Window window, InterfaceC1675dw interfaceC1675dw) {
        this.f3114a = context;
        this.f3115b = window;
        this.f3118e = interfaceC1675dw;
        this.f3116c = this.f3115b.getCallback();
        if (this.f3116c instanceof C0545c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f3117d = new C0545c(this.f3116c);
        this.f3115b.setCallback(this.f3117d);
        C1766hd c1766hdM9600a = C1766hd.m9600a(context, (AttributeSet) null, f3092v);
        Drawable drawableM9610b = c1766hdM9600a.m9610b(0);
        if (drawableM9610b != null) {
            this.f3115b.setBackgroundDrawable(drawableM9610b);
        }
        c1766hdM9600a.m9606a();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public void mo3226a(Bundle bundle) {
        if (this.f3116c instanceof Activity) {
            String parentActivityName = null;
            try {
                parentActivityName = NavUtils.getParentActivityName((Activity) this.f3116c);
            } catch (IllegalArgumentException unused) {
            }
            if (parentActivityName != null) {
                ActionBar actionBarM3257k = m3257k();
                if (actionBarM3257k == null) {
                    this.f3110Q = true;
                } else {
                    actionBarM3257k.mo3139c(true);
                }
            }
        }
        if (bundle == null || this.f3106M != -100) {
            return;
        }
        this.f3106M = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: b */
    public void mo3237b(Bundle bundle) {
        m3212u();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public ActionBar mo3218a() {
        m3211t();
        return this.f3119f;
    }

    /* JADX INFO: renamed from: k */
    final ActionBar m3257k() {
        return this.f3119f;
    }

    /* JADX INFO: renamed from: l */
    final Window.Callback m3258l() {
        return this.f3115b.getCallback();
    }

    /* JADX INFO: renamed from: t */
    private void m3211t() {
        m3212u();
        if (this.f3126m && this.f3119f == null) {
            if (this.f3116c instanceof Activity) {
                this.f3119f = new C1683ed((Activity) this.f3116c, this.f3127n);
            } else if (this.f3116c instanceof Dialog) {
                this.f3119f = new C1683ed((Dialog) this.f3116c);
            }
            if (this.f3119f != null) {
                this.f3119f.mo3139c(this.f3110Q);
            }
        }
    }

    /* JADX INFO: renamed from: m */
    final Context m3259m() {
        ActionBar actionBarMo3218a = mo3218a();
        Context contextMo3140d = actionBarMo3218a != null ? actionBarMo3218a.mo3140d() : null;
        return contextMo3140d == null ? this.f3114a : contextMo3140d;
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: b */
    public MenuInflater mo3234b() {
        if (this.f3120g == null) {
            m3211t();
            this.f3120g = new C1699er(this.f3119f != null ? this.f3119f.mo3140d() : this.f3114a);
        }
        return this.f3120g;
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public <T extends View> T mo3221a(int i) {
        m3212u();
        return (T) this.f3115b.findViewById(i);
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public void mo3225a(Configuration configuration) {
        ActionBar actionBarMo3218a;
        if (this.f3126m && this.f3096C && (actionBarMo3218a = mo3218a()) != null) {
            actionBarMo3218a.mo3131a(configuration);
        }
        C1726fr.m9237a().m9259a(this.f3114a);
        mo3256i();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: c */
    public void mo3241c() {
        mo3256i();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: d */
    public void mo3245d() {
        ActionBar actionBarMo3218a = mo3218a();
        if (actionBarMo3218a != null) {
            actionBarMo3218a.mo3141d(false);
        }
        if (this.f3108O != null) {
            this.f3108O.m3288d();
        }
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: e */
    public void mo3247e() {
        ActionBar actionBarMo3218a = mo3218a();
        if (actionBarMo3218a != null) {
            actionBarMo3218a.mo3141d(true);
        }
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public void mo3228a(View view) {
        m3212u();
        ViewGroup viewGroup = (ViewGroup) this.f3097D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3116c.onContentChanged();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: b */
    public void mo3236b(int i) {
        m3212u();
        ViewGroup viewGroup = (ViewGroup) this.f3097D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3114a).inflate(i, viewGroup);
        this.f3116c.onContentChanged();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public void mo3229a(View view, ViewGroup.LayoutParams layoutParams) {
        m3212u();
        ViewGroup viewGroup = (ViewGroup) this.f3097D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3116c.onContentChanged();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: b */
    public void mo3239b(View view, ViewGroup.LayoutParams layoutParams) {
        m3212u();
        ((ViewGroup) this.f3097D.findViewById(R.id.content)).addView(view, layoutParams);
        this.f3116c.onContentChanged();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: c */
    public void mo3242c(Bundle bundle) {
        if (this.f3106M != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f3106M);
        }
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: g */
    public void mo3251g() {
        if (this.f3132s) {
            this.f3115b.getDecorView().removeCallbacks(this.f3109P);
        }
        this.f3131r = true;
        if (this.f3119f != null) {
            this.f3119f.mo3147i();
        }
        if (this.f3108O != null) {
            this.f3108O.m3288d();
        }
    }

    /* JADX INFO: renamed from: u */
    private void m3212u() {
        if (this.f3096C) {
            return;
        }
        this.f3097D = m3213v();
        CharSequence charSequenceM3260n = m3260n();
        if (!TextUtils.isEmpty(charSequenceM3260n)) {
            if (this.f3135y != null) {
                this.f3135y.setWindowTitle(charSequenceM3260n);
            } else if (m3257k() != null) {
                m3257k().mo3132a(charSequenceM3260n);
            } else if (this.f3098E != null) {
                this.f3098E.setText(charSequenceM3260n);
            }
        }
        m3214w();
        m3230a(this.f3097D);
        this.f3096C = true;
        PanelFeatureState panelFeatureStateM3219a = m3219a(0, false);
        if (this.f3131r) {
            return;
        }
        if (panelFeatureStateM3219a == null || panelFeatureStateM3219a.f3154j == null) {
            m3208j(108);
        }
    }

    /* JADX INFO: renamed from: v */
    private ViewGroup m3213v() {
        ViewGroup viewGroup;
        Context c1696eo;
        TypedArray typedArrayObtainStyledAttributes = this.f3114a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            mo3243c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            mo3243c(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            mo3243c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            mo3243c(10);
        }
        this.f3129p = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f3115b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3114a);
        if (!this.f3130q) {
            if (this.f3129p) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f3127n = false;
                this.f3126m = false;
            } else if (this.f3126m) {
                TypedValue typedValue = new TypedValue();
                this.f3114a.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c1696eo = new C1696eo(this.f3114a, typedValue.resourceId);
                } else {
                    c1696eo = this.f3114a;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(c1696eo).inflate(android.support.v7.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.f3135y = (InterfaceC1740ge) viewGroup.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
                this.f3135y.setWindowCallback(m3258l());
                if (this.f3127n) {
                    this.f3135y.mo3418a(109);
                }
                if (this.f3100G) {
                    this.f3135y.mo3418a(2);
                }
                if (this.f3101H) {
                    this.f3135y.mo3418a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            if (this.f3128o) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(android.support.v7.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: android.support.v7.app.AppCompatDelegateImpl.3
                    @Override // android.support.v4.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int iM3253h = AppCompatDelegateImpl.this.m3253h(systemWindowInsetTop);
                        if (systemWindowInsetTop != iM3253h) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), iM3253h, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
            } else {
                ((InterfaceC1746gk) viewGroup).setOnFitSystemWindowsListener(new InterfaceC1746gk.a() { // from class: android.support.v7.app.AppCompatDelegateImpl.4
                    @Override // p000.InterfaceC1746gk.a
                    /* JADX INFO: renamed from: a */
                    public void mo3267a(Rect rect) {
                        rect.top = AppCompatDelegateImpl.this.m3253h(rect.top);
                    }
                });
            }
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f3126m + ", windowActionBarOverlay: " + this.f3127n + ", android:windowIsFloating: " + this.f3129p + ", windowActionModeOverlay: " + this.f3128o + ", windowNoTitle: " + this.f3130q + " }");
        }
        if (this.f3135y == null) {
            this.f3098E = (TextView) viewGroup.findViewById(android.support.v7.appcompat.R.id.title);
        }
        C1774hl.m9680b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f3115b.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f3115b.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.InterfaceC0582a() { // from class: android.support.v7.app.AppCompatDelegateImpl.5
            @Override // android.support.v7.widget.ContentFrameLayout.InterfaceC0582a
            /* JADX INFO: renamed from: a */
            public void mo3268a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.InterfaceC0582a
            /* JADX INFO: renamed from: b */
            public void mo3269b() {
                AppCompatDelegateImpl.this.m3265s();
            }
        });
        return viewGroup;
    }

    /* JADX INFO: renamed from: w */
    private void m3214w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f3097D.findViewById(R.id.content);
        View decorView = this.f3115b.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f3114a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(android.support.v7.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: c */
    public boolean mo3243c(int i) {
        int iM3209k = m3209k(i);
        if (this.f3130q && iM3209k == 108) {
            return false;
        }
        if (this.f3126m && iM3209k == 1) {
            this.f3126m = false;
        }
        switch (iM3209k) {
            case 1:
                m3215x();
                this.f3130q = true;
                return true;
            case 2:
                m3215x();
                this.f3100G = true;
                return true;
            case 5:
                m3215x();
                this.f3101H = true;
                return true;
            case 10:
                m3215x();
                this.f3128o = true;
                return true;
            case 108:
                m3215x();
                this.f3126m = true;
                return true;
            case 109:
                m3215x();
                this.f3127n = true;
                return true;
            default:
                return this.f3115b.requestFeature(iM3209k);
        }
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: a */
    public final void mo3231a(CharSequence charSequence) {
        this.f3134x = charSequence;
        if (this.f3135y != null) {
            this.f3135y.setWindowTitle(charSequence);
        } else if (m3257k() != null) {
            m3257k().mo3132a(charSequence);
        } else if (this.f3098E != null) {
            this.f3098E.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: n */
    final CharSequence m3260n() {
        if (this.f3116c instanceof Activity) {
            return ((Activity) this.f3116c).getTitle();
        }
        return this.f3134x;
    }

    /* JADX INFO: renamed from: d */
    void m3246d(int i) {
        if (i == 108) {
            ActionBar actionBarMo3218a = mo3218a();
            if (actionBarMo3218a != null) {
                actionBarMo3218a.mo3142e(false);
                return;
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState panelFeatureStateM3219a = m3219a(i, true);
            if (panelFeatureStateM3219a.f3159o) {
                m3227a(panelFeatureStateM3219a, false);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    void m3248e(int i) {
        ActionBar actionBarMo3218a;
        if (i != 108 || (actionBarMo3218a = mo3218a()) == null) {
            return;
        }
        actionBarMo3218a.mo3142e(true);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
    /* JADX INFO: renamed from: a */
    public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateM3220a;
        Window.Callback callbackM3258l = m3258l();
        if (callbackM3258l == null || this.f3131r || (panelFeatureStateM3220a = m3220a((Menu) menuBuilder.mo3364q())) == null) {
            return false;
        }
        return callbackM3258l.onMenuItemSelected(panelFeatureStateM3220a.f3145a, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
    /* JADX INFO: renamed from: a */
    public void mo2621a(MenuBuilder menuBuilder) {
        m3199a(menuBuilder, true);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC1694em m3223a(AbstractC1694em.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f3121h != null) {
            this.f3121h.mo8965c();
        }
        C0544b c0544b = new C0544b(aVar);
        ActionBar actionBarMo3218a = mo3218a();
        if (actionBarMo3218a != null) {
            this.f3121h = actionBarMo3218a.mo3129a(c0544b);
            if (this.f3121h != null && this.f3118e != null) {
                this.f3118e.mo3189a(this.f3121h);
            }
        }
        if (this.f3121h == null) {
            this.f3121h = m3235b(c0544b);
        }
        return this.f3121h;
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: f */
    public void mo3249f() {
        ActionBar actionBarMo3218a = mo3218a();
        if (actionBarMo3218a == null || !actionBarMo3218a.mo3145g()) {
            m3208j(0);
        }
    }

    /* JADX INFO: renamed from: b */
    AbstractC1694em m3235b(AbstractC1694em.a aVar) {
        AbstractC1694em abstractC1694emMo3187a;
        Context c1696eo;
        m3263q();
        if (this.f3121h != null) {
            this.f3121h.mo8965c();
        }
        if (!(aVar instanceof C0544b)) {
            aVar = new C0544b(aVar);
        }
        if (this.f3118e == null || this.f3131r) {
            abstractC1694emMo3187a = null;
        } else {
            try {
                abstractC1694emMo3187a = this.f3118e.mo3187a(aVar);
            } catch (AbstractMethodError unused) {
                abstractC1694emMo3187a = null;
            }
        }
        if (abstractC1694emMo3187a != null) {
            this.f3121h = abstractC1694emMo3187a;
        } else {
            if (this.f3122i == null) {
                if (this.f3129p) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f3114a.getTheme();
                    theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f3114a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        c1696eo = new C1696eo(this.f3114a, 0);
                        c1696eo.getTheme().setTo(themeNewTheme);
                    } else {
                        c1696eo = this.f3114a;
                    }
                    this.f3122i = new ActionBarContextView(c1696eo);
                    this.f3123j = new PopupWindow(c1696eo, (AttributeSet) null, android.support.v7.appcompat.R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.f3123j, 2);
                    this.f3123j.setContentView(this.f3122i);
                    this.f3123j.setWidth(-1);
                    c1696eo.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.f3122i.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c1696eo.getResources().getDisplayMetrics()));
                    this.f3123j.setHeight(-2);
                    this.f3124k = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImpl.6
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImpl.this.f3123j.showAtLocation(AppCompatDelegateImpl.this.f3122i, 55, 0, 0);
                            AppCompatDelegateImpl.this.m3263q();
                            if (AppCompatDelegateImpl.this.m3261o()) {
                                AppCompatDelegateImpl.this.f3122i.setAlpha(0.0f);
                                AppCompatDelegateImpl.this.f3125l = ViewCompat.animate(AppCompatDelegateImpl.this.f3122i).alpha(1.0f);
                                AppCompatDelegateImpl.this.f3125l.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImpl.6.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(View view) {
                                        AppCompatDelegateImpl.this.f3122i.setVisibility(0);
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(View view) {
                                        AppCompatDelegateImpl.this.f3122i.setAlpha(1.0f);
                                        AppCompatDelegateImpl.this.f3125l.setListener(null);
                                        AppCompatDelegateImpl.this.f3125l = null;
                                    }
                                });
                                return;
                            }
                            AppCompatDelegateImpl.this.f3122i.setAlpha(1.0f);
                            AppCompatDelegateImpl.this.f3122i.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f3097D.findViewById(android.support.v7.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m3259m()));
                        this.f3122i = (ActionBarContextView) viewStubCompat.m4381a();
                    }
                }
            }
            if (this.f3122i != null) {
                m3263q();
                this.f3122i.m3407c();
                C1697ep c1697ep = new C1697ep(this.f3122i.getContext(), this.f3122i, aVar, this.f3123j == null);
                if (aVar.mo3281a(c1697ep, c1697ep.mo8962b())) {
                    c1697ep.mo8966d();
                    this.f3122i.m3405a(c1697ep);
                    this.f3121h = c1697ep;
                    if (m3261o()) {
                        this.f3122i.setAlpha(0.0f);
                        this.f3125l = ViewCompat.animate(this.f3122i).alpha(1.0f);
                        this.f3125l.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImpl.7
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(View view) {
                                AppCompatDelegateImpl.this.f3122i.setVisibility(0);
                                AppCompatDelegateImpl.this.f3122i.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImpl.this.f3122i.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f3122i.getParent());
                                }
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(View view) {
                                AppCompatDelegateImpl.this.f3122i.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f3125l.setListener(null);
                                AppCompatDelegateImpl.this.f3125l = null;
                            }
                        });
                    } else {
                        this.f3122i.setAlpha(1.0f);
                        this.f3122i.setVisibility(0);
                        this.f3122i.sendAccessibilityEvent(32);
                        if (this.f3122i.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.f3122i.getParent());
                        }
                    }
                    if (this.f3123j != null) {
                        this.f3115b.getDecorView().post(this.f3124k);
                    }
                } else {
                    this.f3121h = null;
                }
            }
        }
        if (this.f3121h != null && this.f3118e != null) {
            this.f3118e.mo3189a(this.f3121h);
        }
        return this.f3121h;
    }

    /* JADX INFO: renamed from: o */
    final boolean m3261o() {
        return this.f3096C && this.f3097D != null && ViewCompat.isLaidOut(this.f3097D);
    }

    /* JADX INFO: renamed from: p */
    public boolean m3262p() {
        return this.f3095B;
    }

    /* JADX INFO: renamed from: q */
    void m3263q() {
        if (this.f3125l != null) {
            this.f3125l.cancel();
        }
    }

    /* JADX INFO: renamed from: r */
    boolean m3264r() {
        if (this.f3121h != null) {
            this.f3121h.mo8965c();
            return true;
        }
        ActionBar actionBarMo3218a = mo3218a();
        return actionBarMo3218a != null && actionBarMo3218a.mo3146h();
    }

    /* JADX INFO: renamed from: a */
    boolean m3232a(int i, KeyEvent keyEvent) {
        ActionBar actionBarMo3218a = mo3218a();
        if (actionBarMo3218a != null && actionBarMo3218a.mo3134a(i, keyEvent)) {
            return true;
        }
        if (this.f3104K != null && m3201a(this.f3104K, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f3104K != null) {
                this.f3104K.f3158n = true;
            }
            return true;
        }
        if (this.f3104K == null) {
            PanelFeatureState panelFeatureStateM3219a = m3219a(0, true);
            m3204b(panelFeatureStateM3219a, keyEvent);
            boolean zM3201a = m3201a(panelFeatureStateM3219a, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateM3219a.f3157m = false;
            if (zM3201a) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    boolean m3233a(KeyEvent keyEvent) {
        View decorView;
        if (((this.f3116c instanceof KeyEventDispatcher.Component) || (this.f3116c instanceof DialogC1677dy)) && (decorView = this.f3115b.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f3116c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m3244c(keyCode, keyEvent) : m3240b(keyCode, keyEvent);
    }

    /* JADX INFO: renamed from: b */
    boolean m3240b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f3105L;
            this.f3105L = false;
            PanelFeatureState panelFeatureStateM3219a = m3219a(0, false);
            if (panelFeatureStateM3219a != null && panelFeatureStateM3219a.f3159o) {
                if (!z) {
                    m3227a(panelFeatureStateM3219a, true);
                }
                return true;
            }
            if (m3264r()) {
                return true;
            }
        } else if (i == 82) {
            m3207e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    boolean m3244c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f3105L = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            m3206d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public View m3222a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zM3202a = false;
        if (this.f3113T == null) {
            String string = this.f3114a.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme).getString(android.support.v7.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f3113T = new AppCompatViewInflater();
            } else {
                try {
                    this.f3113T = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f3113T = new AppCompatViewInflater();
                }
            }
        }
        if (f3091u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zM3202a = true;
                }
            } else {
                zM3202a = m3202a((ViewParent) view);
            }
            z = zM3202a;
        } else {
            z = false;
        }
        return this.f3113T.createView(view, str, context, attributeSet, z, f3091u, true, C1771hi.m9648a());
    }

    /* JADX INFO: renamed from: a */
    private boolean m3202a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f3115b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: h */
    public void mo3254h() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3114a);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m3222a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m3198a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.f3159o || this.f3131r) {
            return;
        }
        if (panelFeatureState.f3145a == 0) {
            if ((this.f3114a.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackM3258l = m3258l();
        if (callbackM3258l != null && !callbackM3258l.onMenuOpened(panelFeatureState.f3145a, panelFeatureState.f3154j)) {
            m3227a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3114a.getSystemService("window");
        if (windowManager != null && m3204b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.f3151g == null || panelFeatureState.f3161q) {
                if (panelFeatureState.f3151g == null) {
                    if (!m3200a(panelFeatureState) || panelFeatureState.f3151g == null) {
                        return;
                    }
                } else if (panelFeatureState.f3161q && panelFeatureState.f3151g.getChildCount() > 0) {
                    panelFeatureState.f3151g.removeAllViews();
                }
                if (!m3205c(panelFeatureState) || !panelFeatureState.m3273a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f3152h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f3151g.setBackgroundResource(panelFeatureState.f3146b);
                ViewParent parent = panelFeatureState.f3152h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f3152h);
                }
                panelFeatureState.f3151g.addView(panelFeatureState.f3152h, layoutParams2);
                if (!panelFeatureState.f3152h.hasFocus()) {
                    panelFeatureState.f3152h.requestFocus();
                }
            } else {
                if (panelFeatureState.f3153i != null && (layoutParams = panelFeatureState.f3153i.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                panelFeatureState.f3158n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f3148d, panelFeatureState.f3149e, PointerIconCompat.TYPE_HAND, 8519680, -3);
                layoutParams3.gravity = panelFeatureState.f3147c;
                layoutParams3.windowAnimations = panelFeatureState.f3150f;
                windowManager.addView(panelFeatureState.f3151g, layoutParams3);
                panelFeatureState.f3159o = true;
            }
            i = -2;
            panelFeatureState.f3158n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f3148d, panelFeatureState.f3149e, PointerIconCompat.TYPE_HAND, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.f3147c;
            layoutParams32.windowAnimations = panelFeatureState.f3150f;
            windowManager.addView(panelFeatureState.f3151g, layoutParams32);
            panelFeatureState.f3159o = true;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3200a(PanelFeatureState panelFeatureState) {
        panelFeatureState.m3271a(m3259m());
        panelFeatureState.f3151g = new C0547e(panelFeatureState.f3156l);
        panelFeatureState.f3147c = 81;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m3199a(MenuBuilder menuBuilder, boolean z) {
        if (this.f3135y != null && this.f3135y.mo3423e() && (!ViewConfiguration.get(this.f3114a).hasPermanentMenuKey() || this.f3135y.mo3425g())) {
            Window.Callback callbackM3258l = m3258l();
            if (!this.f3135y.mo3424f() || !z) {
                if (callbackM3258l == null || this.f3131r) {
                    return;
                }
                if (this.f3132s && (this.f3133t & 1) != 0) {
                    this.f3115b.getDecorView().removeCallbacks(this.f3109P);
                    this.f3109P.run();
                }
                PanelFeatureState panelFeatureStateM3219a = m3219a(0, true);
                if (panelFeatureStateM3219a.f3154j == null || panelFeatureStateM3219a.f3162r || !callbackM3258l.onPreparePanel(0, panelFeatureStateM3219a.f3153i, panelFeatureStateM3219a.f3154j)) {
                    return;
                }
                callbackM3258l.onMenuOpened(108, panelFeatureStateM3219a.f3154j);
                this.f3135y.mo3426h();
                return;
            }
            this.f3135y.mo3427i();
            if (this.f3131r) {
                return;
            }
            callbackM3258l.onPanelClosed(108, m3219a(0, true).f3154j);
            return;
        }
        PanelFeatureState panelFeatureStateM3219a2 = m3219a(0, true);
        panelFeatureStateM3219a2.f3161q = true;
        m3227a(panelFeatureStateM3219a2, false);
        m3198a(panelFeatureStateM3219a2, (KeyEvent) null);
    }

    /* JADX INFO: renamed from: b */
    private boolean m3203b(PanelFeatureState panelFeatureState) {
        Context context = this.f3114a;
        if ((panelFeatureState.f3145a == 0 || panelFeatureState.f3145a == 108) && this.f3135y != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                C1696eo c1696eo = new C1696eo(context, 0);
                c1696eo.getTheme().setTo(themeNewTheme);
                context = c1696eo;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.mo3327a(this);
        panelFeatureState.m3272a(menuBuilder);
        return true;
    }

    /* JADX INFO: renamed from: c */
    private boolean m3205c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f3153i != null) {
            panelFeatureState.f3152h = panelFeatureState.f3153i;
            return true;
        }
        if (panelFeatureState.f3154j == null) {
            return false;
        }
        if (this.f3094A == null) {
            this.f3094A = new C0548f();
        }
        panelFeatureState.f3152h = (View) panelFeatureState.m3270a(this.f3094A);
        return panelFeatureState.f3152h != null;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3204b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.f3131r) {
            return false;
        }
        if (panelFeatureState.f3157m) {
            return true;
        }
        if (this.f3104K != null && this.f3104K != panelFeatureState) {
            m3227a(this.f3104K, false);
        }
        Window.Callback callbackM3258l = m3258l();
        if (callbackM3258l != null) {
            panelFeatureState.f3153i = callbackM3258l.onCreatePanelView(panelFeatureState.f3145a);
        }
        boolean z = panelFeatureState.f3145a == 0 || panelFeatureState.f3145a == 108;
        if (z && this.f3135y != null) {
            this.f3135y.setMenuPrepared();
        }
        if (panelFeatureState.f3153i == null && (!z || !(m3257k() instanceof C1680ea))) {
            if (panelFeatureState.f3154j == null || panelFeatureState.f3162r) {
                if (panelFeatureState.f3154j == null && (!m3203b(panelFeatureState) || panelFeatureState.f3154j == null)) {
                    return false;
                }
                if (z && this.f3135y != null) {
                    if (this.f3136z == null) {
                        this.f3136z = new C0543a();
                    }
                    this.f3135y.setMenu(panelFeatureState.f3154j, this.f3136z);
                }
                panelFeatureState.f3154j.m3355h();
                if (!callbackM3258l.onCreatePanelMenu(panelFeatureState.f3145a, panelFeatureState.f3154j)) {
                    panelFeatureState.m3272a((MenuBuilder) null);
                    if (z && this.f3135y != null) {
                        this.f3135y.setMenu(null, this.f3136z);
                    }
                    return false;
                }
                panelFeatureState.f3162r = false;
            }
            panelFeatureState.f3154j.m3355h();
            if (panelFeatureState.f3163s != null) {
                panelFeatureState.f3154j.m3348d(panelFeatureState.f3163s);
                panelFeatureState.f3163s = null;
            }
            if (!callbackM3258l.onPreparePanel(0, panelFeatureState.f3153i, panelFeatureState.f3154j)) {
                if (z && this.f3135y != null) {
                    this.f3135y.setMenu(null, this.f3136z);
                }
                panelFeatureState.f3154j.m3356i();
                return false;
            }
            panelFeatureState.f3160p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f3154j.setQwertyMode(panelFeatureState.f3160p);
            panelFeatureState.f3154j.m3356i();
        }
        panelFeatureState.f3157m = true;
        panelFeatureState.f3158n = false;
        this.f3104K = panelFeatureState;
        return true;
    }

    /* JADX INFO: renamed from: b */
    void m3238b(MenuBuilder menuBuilder) {
        if (this.f3102I) {
            return;
        }
        this.f3102I = true;
        this.f3135y.mo3428j();
        Window.Callback callbackM3258l = m3258l();
        if (callbackM3258l != null && !this.f3131r) {
            callbackM3258l.onPanelClosed(108, menuBuilder);
        }
        this.f3102I = false;
    }

    /* JADX INFO: renamed from: f */
    void m3250f(int i) {
        m3227a(m3219a(i, true), true);
    }

    /* JADX INFO: renamed from: a */
    void m3227a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f3145a == 0 && this.f3135y != null && this.f3135y.mo3424f()) {
            m3238b(panelFeatureState.f3154j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3114a.getSystemService("window");
        if (windowManager != null && panelFeatureState.f3159o && panelFeatureState.f3151g != null) {
            windowManager.removeView(panelFeatureState.f3151g);
            if (z) {
                m3224a(panelFeatureState.f3145a, panelFeatureState, null);
            }
        }
        panelFeatureState.f3157m = false;
        panelFeatureState.f3158n = false;
        panelFeatureState.f3159o = false;
        panelFeatureState.f3152h = null;
        panelFeatureState.f3161q = true;
        if (this.f3104K == panelFeatureState) {
            this.f3104K = null;
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m3206d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateM3219a = m3219a(i, true);
        if (panelFeatureStateM3219a.f3159o) {
            return false;
        }
        return m3204b(panelFeatureStateM3219a, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m3207e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            em r0 = r3.f3121h
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            android.support.v7.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.m3219a(r4, r0)
            if (r4 != 0) goto L45
            ge r4 = r3.f3135y
            if (r4 == 0) goto L45
            ge r4 = r3.f3135y
            boolean r4 = r4.mo3423e()
            if (r4 == 0) goto L45
            android.content.Context r4 = r3.f3114a
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L45
            ge r4 = r3.f3135y
            boolean r4 = r4.mo3424f()
            if (r4 != 0) goto L3e
            boolean r4 = r3.f3131r
            if (r4 != 0) goto L65
            boolean r4 = r3.m3204b(r2, r5)
            if (r4 == 0) goto L65
            ge r4 = r3.f3135y
            boolean r4 = r4.mo3426h()
            goto L6c
        L3e:
            ge r4 = r3.f3135y
            boolean r4 = r4.mo3427i()
            goto L6c
        L45:
            boolean r4 = r2.f3159o
            if (r4 != 0) goto L67
            boolean r4 = r2.f3158n
            if (r4 == 0) goto L4e
            goto L67
        L4e:
            boolean r4 = r2.f3157m
            if (r4 == 0) goto L65
            boolean r4 = r2.f3162r
            if (r4 == 0) goto L5d
            r2.f3157m = r1
            boolean r4 = r3.m3204b(r2, r5)
            goto L5e
        L5d:
            r4 = 1
        L5e:
            if (r4 == 0) goto L65
            r3.m3198a(r2, r5)
            r4 = 1
            goto L6c
        L65:
            r4 = 0
            goto L6c
        L67:
            boolean r4 = r2.f3159o
            r3.m3227a(r2, r0)
        L6c:
            if (r4 == 0) goto L85
            android.content.Context r5 = r3.f3114a
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImpl.m3207e(int, android.view.KeyEvent):boolean");
    }

    /* JADX INFO: renamed from: a */
    void m3224a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f3103J.length) {
                panelFeatureState = this.f3103J[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f3154j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f3159o) && !this.f3131r) {
            this.f3116c.onPanelClosed(i, menu);
        }
    }

    /* JADX INFO: renamed from: a */
    PanelFeatureState m3220a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f3103J;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f3154j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected PanelFeatureState m3219a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f3103J;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f3103J = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3201a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f3157m || m3204b(panelFeatureState, keyEvent)) && panelFeatureState.f3154j != null) {
            zPerformShortcut = panelFeatureState.f3154j.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.f3135y == null) {
            m3227a(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    /* JADX INFO: renamed from: j */
    private void m3208j(int i) {
        this.f3133t = (1 << i) | this.f3133t;
        if (this.f3132s) {
            return;
        }
        ViewCompat.postOnAnimation(this.f3115b.getDecorView(), this.f3109P);
        this.f3132s = true;
    }

    /* JADX INFO: renamed from: g */
    void m3252g(int i) {
        PanelFeatureState panelFeatureStateM3219a;
        PanelFeatureState panelFeatureStateM3219a2 = m3219a(i, true);
        if (panelFeatureStateM3219a2.f3154j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateM3219a2.f3154j.m3343c(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateM3219a2.f3163s = bundle;
            }
            panelFeatureStateM3219a2.f3154j.m3355h();
            panelFeatureStateM3219a2.f3154j.clear();
        }
        panelFeatureStateM3219a2.f3162r = true;
        panelFeatureStateM3219a2.f3161q = true;
        if ((i != 108 && i != 0) || this.f3135y == null || (panelFeatureStateM3219a = m3219a(0, false)) == null) {
            return;
        }
        panelFeatureStateM3219a.f3157m = false;
        m3204b(panelFeatureStateM3219a, (KeyEvent) null);
    }

    /* JADX INFO: renamed from: h */
    int m3253h(int i) {
        boolean z;
        boolean z2;
        if (this.f3122i == null || !(this.f3122i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3122i.getLayoutParams();
            if (this.f3122i.isShown()) {
                if (this.f3111R == null) {
                    this.f3111R = new Rect();
                    this.f3112S = new Rect();
                }
                Rect rect = this.f3111R;
                Rect rect2 = this.f3112S;
                rect.set(0, i, 0, 0);
                C1774hl.m9678a(this.f3097D, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f3099F == null) {
                        this.f3099F = new View(this.f3114a);
                        this.f3099F.setBackgroundColor(this.f3114a.getResources().getColor(android.support.v7.appcompat.R.color.abc_input_method_navigation_guard));
                        this.f3097D.addView(this.f3099F, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f3099F.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f3099F.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.f3099F != null;
                if (!this.f3128o && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.f3122i.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f3099F != null) {
            this.f3099F.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    /* JADX INFO: renamed from: x */
    private void m3215x() {
        if (this.f3096C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: renamed from: k */
    private int m3209k(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    /* JADX INFO: renamed from: s */
    void m3265s() {
        if (this.f3135y != null) {
            this.f3135y.mo3428j();
        }
        if (this.f3123j != null) {
            this.f3115b.getDecorView().removeCallbacks(this.f3124k);
            if (this.f3123j.isShowing()) {
                try {
                    this.f3123j.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f3123j = null;
        }
        m3263q();
        PanelFeatureState panelFeatureStateM3219a = m3219a(0, false);
        if (panelFeatureStateM3219a == null || panelFeatureStateM3219a.f3154j == null) {
            return;
        }
        panelFeatureStateM3219a.f3154j.close();
    }

    @Override // p000.AbstractC1676dx
    /* JADX INFO: renamed from: i */
    public boolean mo3256i() {
        int iM3216y = m3216y();
        int iM3255i = m3255i(iM3216y);
        boolean zM3210l = iM3255i != -1 ? m3210l(iM3255i) : false;
        if (iM3216y == 0) {
            m3217z();
            this.f3108O.m3287c();
        }
        this.f3107N = true;
        return zM3210l;
    }

    /* JADX INFO: renamed from: i */
    int m3255i(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.f3114a.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        m3217z();
        return this.f3108O.m3285a();
    }

    /* JADX INFO: renamed from: y */
    private int m3216y() {
        return this.f3106M != -100 ? this.f3106M : m8910j();
    }

    /* JADX INFO: renamed from: l */
    private boolean m3210l(int i) {
        Resources resources = this.f3114a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (m3197A()) {
            ((Activity) this.f3114a).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        C1678dz.m8915a(resources);
        return true;
    }

    /* JADX INFO: renamed from: z */
    private void m3217z() {
        if (this.f3108O == null) {
            this.f3108O = new C0546d(C1682ec.m8937a(this.f3114a));
        }
    }

    /* JADX INFO: renamed from: A */
    private boolean m3197A() {
        if (!this.f3107N || !(this.f3114a instanceof Activity)) {
            return false;
        }
        try {
            return (this.f3114a.getPackageManager().getActivityInfo(new ComponentName(this.f3114a, this.f3114a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$b */
    class C0544b implements AbstractC1694em.a {

        /* JADX INFO: renamed from: b */
        private AbstractC1694em.a f3169b;

        public C0544b(AbstractC1694em.a aVar) {
            this.f3169b = aVar;
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public boolean mo3281a(AbstractC1694em abstractC1694em, Menu menu) {
            return this.f3169b.mo3281a(abstractC1694em, menu);
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: b */
        public boolean mo3283b(AbstractC1694em abstractC1694em, Menu menu) {
            return this.f3169b.mo3283b(abstractC1694em, menu);
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public boolean mo3282a(AbstractC1694em abstractC1694em, MenuItem menuItem) {
            return this.f3169b.mo3282a(abstractC1694em, menuItem);
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public void mo3280a(AbstractC1694em abstractC1694em) {
            this.f3169b.mo3280a(abstractC1694em);
            if (AppCompatDelegateImpl.this.f3123j != null) {
                AppCompatDelegateImpl.this.f3115b.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f3124k);
            }
            if (AppCompatDelegateImpl.this.f3122i != null) {
                AppCompatDelegateImpl.this.m3263q();
                AppCompatDelegateImpl.this.f3125l = ViewCompat.animate(AppCompatDelegateImpl.this.f3122i).alpha(0.0f);
                AppCompatDelegateImpl.this.f3125l.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImpl.b.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.f3122i.setVisibility(8);
                        if (AppCompatDelegateImpl.this.f3123j != null) {
                            AppCompatDelegateImpl.this.f3123j.dismiss();
                        } else if (AppCompatDelegateImpl.this.f3122i.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f3122i.getParent());
                        }
                        AppCompatDelegateImpl.this.f3122i.removeAllViews();
                        AppCompatDelegateImpl.this.f3125l.setListener(null);
                        AppCompatDelegateImpl.this.f3125l = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.f3118e != null) {
                AppCompatDelegateImpl.this.f3118e.mo3193b(AppCompatDelegateImpl.this.f3121h);
            }
            AppCompatDelegateImpl.this.f3121h = null;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$f */
    final class C0548f implements InterfaceC1714ff.a {
        C0548f() {
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public void mo3278a(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder menuBuilderMo3364q = menuBuilder.mo3364q();
            boolean z2 = menuBuilderMo3364q != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = menuBuilderMo3364q;
            }
            PanelFeatureState panelFeatureStateM3220a = appCompatDelegateImpl.m3220a((Menu) menuBuilder);
            if (panelFeatureStateM3220a != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.m3224a(panelFeatureStateM3220a.f3145a, panelFeatureStateM3220a, menuBuilderMo3364q);
                    AppCompatDelegateImpl.this.m3227a(panelFeatureStateM3220a, true);
                } else {
                    AppCompatDelegateImpl.this.m3227a(panelFeatureStateM3220a, z);
                }
            }
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public boolean mo3279a(MenuBuilder menuBuilder) {
            Window.Callback callbackM3258l;
            if (menuBuilder != null || !AppCompatDelegateImpl.this.f3126m || (callbackM3258l = AppCompatDelegateImpl.this.m3258l()) == null || AppCompatDelegateImpl.this.f3131r) {
                return true;
            }
            callbackM3258l.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$a */
    final class C0543a implements InterfaceC1714ff.a {
        C0543a() {
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public boolean mo3279a(MenuBuilder menuBuilder) {
            Window.Callback callbackM3258l = AppCompatDelegateImpl.this.m3258l();
            if (callbackM3258l == null) {
                return true;
            }
            callbackM3258l.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public void mo3278a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.m3238b(menuBuilder);
        }
    }

    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: a */
        int f3145a;

        /* JADX INFO: renamed from: b */
        int f3146b;

        /* JADX INFO: renamed from: c */
        int f3147c;

        /* JADX INFO: renamed from: d */
        int f3148d;

        /* JADX INFO: renamed from: e */
        int f3149e;

        /* JADX INFO: renamed from: f */
        int f3150f;

        /* JADX INFO: renamed from: g */
        ViewGroup f3151g;

        /* JADX INFO: renamed from: h */
        View f3152h;

        /* JADX INFO: renamed from: i */
        View f3153i;

        /* JADX INFO: renamed from: j */
        MenuBuilder f3154j;

        /* JADX INFO: renamed from: k */
        C1706ey f3155k;

        /* JADX INFO: renamed from: l */
        Context f3156l;

        /* JADX INFO: renamed from: m */
        boolean f3157m;

        /* JADX INFO: renamed from: n */
        boolean f3158n;

        /* JADX INFO: renamed from: o */
        boolean f3159o;

        /* JADX INFO: renamed from: p */
        public boolean f3160p;

        /* JADX INFO: renamed from: q */
        boolean f3161q = false;

        /* JADX INFO: renamed from: r */
        boolean f3162r;

        /* JADX INFO: renamed from: s */
        Bundle f3163s;

        PanelFeatureState(int i) {
            this.f3145a = i;
        }

        /* JADX INFO: renamed from: a */
        public boolean m3273a() {
            if (this.f3152h == null) {
                return false;
            }
            return this.f3153i != null || this.f3155k.m9126d().getCount() > 0;
        }

        /* JADX INFO: renamed from: a */
        void m3271a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(android.support.v7.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            C1696eo c1696eo = new C1696eo(context, 0);
            c1696eo.getTheme().setTo(themeNewTheme);
            this.f3156l = c1696eo;
            TypedArray typedArrayObtainStyledAttributes = c1696eo.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.AppCompatTheme);
            this.f3146b = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f3150f = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: a */
        void m3272a(MenuBuilder menuBuilder) {
            if (menuBuilder == this.f3154j) {
                return;
            }
            if (this.f3154j != null) {
                this.f3154j.m3339b(this.f3155k);
            }
            this.f3154j = menuBuilder;
            if (menuBuilder == null || this.f3155k == null) {
                return;
            }
            menuBuilder.m3330a(this.f3155k);
        }

        /* JADX INFO: renamed from: a */
        InterfaceC1715fg m3270a(InterfaceC1714ff.a aVar) {
            if (this.f3154j == null) {
                return null;
            }
            if (this.f3155k == null) {
                this.f3155k = new C1706ey(this.f3156l, android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
                this.f3155k.mo2440a(aVar);
                this.f3154j.m3330a(this.f3155k);
            }
            return this.f3155k.m9123a(this.f3151g);
        }

        static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m3274a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.m3274a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f3164a;

            /* JADX INFO: renamed from: b */
            boolean f3165b;

            /* JADX INFO: renamed from: c */
            Bundle f3166c;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3164a);
                parcel.writeInt(this.f3165b ? 1 : 0);
                if (this.f3165b) {
                    parcel.writeBundle(this.f3166c);
                }
            }

            /* JADX INFO: renamed from: a */
            static SavedState m3274a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f3164a = parcel.readInt();
                savedState.f3165b = parcel.readInt() == 1;
                if (savedState.f3165b) {
                    savedState.f3166c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$e */
    class C0547e extends ContentFrameLayout {
        public C0547e(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m3233a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && m3289a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.m3250f(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C1684ee.m8975b(getContext(), i));
        }

        /* JADX INFO: renamed from: a */
        private boolean m3289a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$c */
    class C0545c extends WindowCallbackC1701et {
        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public void onContentChanged() {
        }

        C0545c(Window.Callback callback) {
            super(callback);
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m3233a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.m3232a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.m3344c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.m3344c(false);
            }
            return zOnPreparePanel;
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.m3248e(i);
            return true;
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.m3246d(i);
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.m3262p()) {
                return m3284a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* JADX INFO: renamed from: a */
        final ActionMode m3284a(ActionMode.Callback callback) {
            C1698eq.a aVar = new C1698eq.a(AppCompatDelegateImpl.this.f3114a, callback);
            AbstractC1694em abstractC1694emM3223a = AppCompatDelegateImpl.this.m3223a(aVar);
            if (abstractC1694emM3223a != null) {
                return aVar.m9075b(abstractC1694emM3223a);
            }
            return null;
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.m3262p() && i == 0) {
                return m3284a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // p000.WindowCallbackC1701et, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState panelFeatureStateM3219a = AppCompatDelegateImpl.this.m3219a(0, true);
            if (panelFeatureStateM3219a != null && panelFeatureStateM3219a.f3154j != null) {
                super.onProvideKeyboardShortcuts(list, panelFeatureStateM3219a.f3154j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatDelegateImpl$d */
    final class C0546d {

        /* JADX INFO: renamed from: b */
        private C1682ec f3173b;

        /* JADX INFO: renamed from: c */
        private boolean f3174c;

        /* JADX INFO: renamed from: d */
        private BroadcastReceiver f3175d;

        /* JADX INFO: renamed from: e */
        private IntentFilter f3176e;

        C0546d(C1682ec c1682ec) {
            this.f3173b = c1682ec;
            this.f3174c = c1682ec.m8941a();
        }

        /* JADX INFO: renamed from: a */
        int m3285a() {
            this.f3174c = this.f3173b.m8941a();
            return this.f3174c ? 2 : 1;
        }

        /* JADX INFO: renamed from: b */
        void m3286b() {
            boolean zM8941a = this.f3173b.m8941a();
            if (zM8941a != this.f3174c) {
                this.f3174c = zM8941a;
                AppCompatDelegateImpl.this.mo3256i();
            }
        }

        /* JADX INFO: renamed from: c */
        void m3287c() {
            m3288d();
            if (this.f3175d == null) {
                this.f3175d = new BroadcastReceiver() { // from class: android.support.v7.app.AppCompatDelegateImpl.d.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        C0546d.this.m3286b();
                    }
                };
            }
            if (this.f3176e == null) {
                this.f3176e = new IntentFilter();
                this.f3176e.addAction("android.intent.action.TIME_SET");
                this.f3176e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f3176e.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.f3114a.registerReceiver(this.f3175d, this.f3176e);
        }

        /* JADX INFO: renamed from: d */
        void m3288d() {
            if (this.f3175d != null) {
                AppCompatDelegateImpl.this.f3114a.unregisterReceiver(this.f3175d);
                this.f3175d = null;
            }
        }
    }
}
