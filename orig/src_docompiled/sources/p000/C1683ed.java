package p000;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000.AbstractC1694em;

/* JADX INFO: renamed from: ed */
/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class C1683ed extends ActionBar implements ActionBarOverlayLayout.InterfaceC0559a {

    /* JADX INFO: renamed from: s */
    static final /* synthetic */ boolean f9474s = true;

    /* JADX INFO: renamed from: t */
    private static final Interpolator f9475t = new AccelerateInterpolator();

    /* JADX INFO: renamed from: u */
    private static final Interpolator f9476u = new DecelerateInterpolator();

    /* JADX INFO: renamed from: A */
    private boolean f9477A;

    /* JADX INFO: renamed from: B */
    private boolean f9478B;

    /* JADX INFO: renamed from: D */
    private boolean f9480D;

    /* JADX INFO: renamed from: F */
    private boolean f9482F;

    /* JADX INFO: renamed from: H */
    private boolean f9484H;

    /* JADX INFO: renamed from: a */
    Context f9485a;

    /* JADX INFO: renamed from: b */
    ActionBarOverlayLayout f9486b;

    /* JADX INFO: renamed from: c */
    ActionBarContainer f9487c;

    /* JADX INFO: renamed from: d */
    InterfaceC1741gf f9488d;

    /* JADX INFO: renamed from: e */
    ActionBarContextView f9489e;

    /* JADX INFO: renamed from: f */
    View f9490f;

    /* JADX INFO: renamed from: g */
    ScrollingTabContainerView f9491g;

    /* JADX INFO: renamed from: h */
    a f9492h;

    /* JADX INFO: renamed from: i */
    AbstractC1694em f9493i;

    /* JADX INFO: renamed from: j */
    AbstractC1694em.a f9494j;

    /* JADX INFO: renamed from: l */
    boolean f9496l;

    /* JADX INFO: renamed from: m */
    boolean f9497m;

    /* JADX INFO: renamed from: n */
    C1700es f9498n;

    /* JADX INFO: renamed from: o */
    boolean f9499o;

    /* JADX INFO: renamed from: v */
    private Context f9503v;

    /* JADX INFO: renamed from: w */
    private Activity f9504w;

    /* JADX INFO: renamed from: x */
    private Dialog f9505x;

    /* JADX INFO: renamed from: y */
    private ArrayList<Object> f9506y = new ArrayList<>();

    /* JADX INFO: renamed from: z */
    private int f9507z = -1;

    /* JADX INFO: renamed from: C */
    private ArrayList<ActionBar.InterfaceC0524a> f9479C = new ArrayList<>();

    /* JADX INFO: renamed from: E */
    private int f9481E = 0;

    /* JADX INFO: renamed from: k */
    boolean f9495k = f9474s;

    /* JADX INFO: renamed from: G */
    private boolean f9483G = f9474s;

    /* JADX INFO: renamed from: p */
    final ViewPropertyAnimatorListener f9500p = new ViewPropertyAnimatorListenerAdapter() { // from class: ed.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (C1683ed.this.f9495k && C1683ed.this.f9490f != null) {
                C1683ed.this.f9490f.setTranslationY(0.0f);
                C1683ed.this.f9487c.setTranslationY(0.0f);
            }
            C1683ed.this.f9487c.setVisibility(8);
            C1683ed.this.f9487c.setTransitioning(false);
            C1683ed.this.f9498n = null;
            C1683ed.this.m8954j();
            if (C1683ed.this.f9486b != null) {
                ViewCompat.requestApplyInsets(C1683ed.this.f9486b);
            }
        }
    };

    /* JADX INFO: renamed from: q */
    final ViewPropertyAnimatorListener f9501q = new ViewPropertyAnimatorListenerAdapter() { // from class: ed.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            C1683ed.this.f9498n = null;
            C1683ed.this.f9487c.requestLayout();
        }
    };

    /* JADX INFO: renamed from: r */
    final ViewPropertyAnimatorUpdateListener f9502r = new ViewPropertyAnimatorUpdateListener() { // from class: ed.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) C1683ed.this.f9487c.getParent()).invalidate();
        }
    };

    /* JADX INFO: renamed from: a */
    static boolean m8943a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return f9474s;
        }
        if (z || z2) {
            return false;
        }
        return f9474s;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: o */
    public void mo3434o() {
    }

    public C1683ed(Activity activity, boolean z) {
        this.f9504w = activity;
        View decorView = activity.getWindow().getDecorView();
        m8942a(decorView);
        if (z) {
            return;
        }
        this.f9490f = decorView.findViewById(R.id.content);
    }

    public C1683ed(Dialog dialog) {
        this.f9505x = dialog;
        m8942a(dialog.getWindow().getDecorView());
    }

    /* JADX INFO: renamed from: a */
    private void m8942a(View view) {
        this.f9486b = (ActionBarOverlayLayout) view.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
        if (this.f9486b != null) {
            this.f9486b.setActionBarVisibilityCallback(this);
        }
        this.f9488d = m8944b(view.findViewById(android.support.v7.appcompat.R.id.action_bar));
        this.f9489e = (ActionBarContextView) view.findViewById(android.support.v7.appcompat.R.id.action_context_bar);
        this.f9487c = (ActionBarContainer) view.findViewById(android.support.v7.appcompat.R.id.action_bar_container);
        if (this.f9488d == null || this.f9489e == null || this.f9487c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f9485a = this.f9488d.mo9391b();
        boolean z = (this.f9488d.mo9408o() & 4) != 0 ? f9474s : false;
        if (z) {
            this.f9477A = f9474s;
        }
        C1693el c1693elM9059a = C1693el.m9059a(this.f9485a);
        mo3133a((c1693elM9059a.m9065f() || z) ? f9474s : false);
        m8945k(c1693elM9059a.m9063d());
        TypedArray typedArrayObtainStyledAttributes = this.f9485a.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            mo3137b(f9474s);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo3130a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    private InterfaceC1741gf m8944b(View view) {
        if (view instanceof InterfaceC1741gf) {
            return (InterfaceC1741gf) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3130a(float f) {
        ViewCompat.setElevation(this.f9487c, f);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3131a(Configuration configuration) {
        m8945k(C1693el.m9059a(this.f9485a).m9063d());
    }

    /* JADX INFO: renamed from: k */
    private void m8945k(boolean z) {
        this.f9480D = z;
        if (!this.f9480D) {
            this.f9488d.mo9385a((ScrollingTabContainerView) null);
            this.f9487c.setTabContainer(this.f9491g);
        } else {
            this.f9487c.setTabContainer(null);
            this.f9488d.mo9385a(this.f9491g);
        }
        int iM8956k = m8956k();
        boolean z2 = f9474s;
        boolean z3 = iM8956k == 2 ? f9474s : false;
        if (this.f9491g != null) {
            if (z3) {
                this.f9491g.setVisibility(0);
                if (this.f9486b != null) {
                    ViewCompat.requestApplyInsets(this.f9486b);
                }
            } else {
                this.f9491g.setVisibility(8);
            }
        }
        this.f9488d.mo9390a((this.f9480D || !z3) ? false : f9474s);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f9486b;
        if (this.f9480D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* JADX INFO: renamed from: j */
    void m8954j() {
        if (this.f9494j != null) {
            this.f9494j.mo3280a(this.f9493i);
            this.f9493i = null;
            this.f9494j = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: a */
    public void mo3429a(int i) {
        this.f9481E = i;
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: d */
    public void mo3141d(boolean z) {
        this.f9484H = z;
        if (z || this.f9498n == null) {
            return;
        }
        this.f9498n.m9095c();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: e */
    public void mo3142e(boolean z) {
        if (z == this.f9478B) {
            return;
        }
        this.f9478B = z;
        int size = this.f9479C.size();
        for (int i = 0; i < size; i++) {
            this.f9479C.get(i).m3148a(z);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m8951f(boolean z) {
        m8950a(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3133a(boolean z) {
        this.f9488d.mo9393b(z);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3132a(CharSequence charSequence) {
        this.f9488d.mo9389a(charSequence);
    }

    /* JADX INFO: renamed from: a */
    public void m8950a(int i, int i2) {
        int iMo9408o = this.f9488d.mo9408o();
        if ((i2 & 4) != 0) {
            this.f9477A = f9474s;
        }
        this.f9488d.mo9394c((i & i2) | ((i2 ^ (-1)) & iMo9408o));
    }

    /* JADX INFO: renamed from: k */
    public int m8956k() {
        return this.f9488d.mo9409p();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public int mo3128a() {
        return this.f9488d.mo9408o();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public AbstractC1694em mo3129a(AbstractC1694em.a aVar) {
        if (this.f9492h != null) {
            this.f9492h.mo8965c();
        }
        this.f9486b.setHideOnContentScrollEnabled(false);
        this.f9489e.m3407c();
        a aVar2 = new a(this.f9489e.getContext(), aVar);
        if (!aVar2.m8967e()) {
            return null;
        }
        this.f9492h = aVar2;
        aVar2.mo8966d();
        this.f9489e.m3405a(aVar2);
        m8955j(f9474s);
        this.f9489e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: g */
    public void mo3430g(boolean z) {
        this.f9495k = z;
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: b */
    public void mo3136b() {
        if (this.f9496l) {
            this.f9496l = false;
            m8946l(false);
        }
    }

    /* JADX INFO: renamed from: p */
    private void m8947p() {
        if (this.f9482F) {
            return;
        }
        this.f9482F = f9474s;
        if (this.f9486b != null) {
            this.f9486b.setShowingForActionMode(f9474s);
        }
        m8946l(false);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: l */
    public void mo3431l() {
        if (this.f9497m) {
            this.f9497m = false;
            m8946l(f9474s);
        }
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: c */
    public void mo3138c() {
        if (this.f9496l) {
            return;
        }
        this.f9496l = f9474s;
        m8946l(false);
    }

    /* JADX INFO: renamed from: q */
    private void m8948q() {
        if (this.f9482F) {
            this.f9482F = false;
            if (this.f9486b != null) {
                this.f9486b.setShowingForActionMode(false);
            }
            m8946l(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: m */
    public void mo3432m() {
        if (this.f9497m) {
            return;
        }
        this.f9497m = f9474s;
        m8946l(f9474s);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: b */
    public void mo3137b(boolean z) {
        if (z && !this.f9486b.m3419a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f9499o = z;
        this.f9486b.setHideOnContentScrollEnabled(z);
    }

    /* JADX INFO: renamed from: l */
    private void m8946l(boolean z) {
        if (m8943a(this.f9496l, this.f9497m, this.f9482F)) {
            if (this.f9483G) {
                return;
            }
            this.f9483G = f9474s;
            m8952h(z);
            return;
        }
        if (this.f9483G) {
            this.f9483G = false;
            m8953i(z);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m8952h(boolean z) {
        if (this.f9498n != null) {
            this.f9498n.m9095c();
        }
        this.f9487c.setVisibility(0);
        if (this.f9481E == 0 && (this.f9484H || z)) {
            this.f9487c.setTranslationY(0.0f);
            float f = -this.f9487c.getHeight();
            if (z) {
                this.f9487c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.f9487c.setTranslationY(f);
            C1700es c1700es = new C1700es();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.f9487c).translationY(0.0f);
            viewPropertyAnimatorCompatTranslationY.setUpdateListener(this.f9502r);
            c1700es.m9089a(viewPropertyAnimatorCompatTranslationY);
            if (this.f9495k && this.f9490f != null) {
                this.f9490f.setTranslationY(f);
                c1700es.m9089a(ViewCompat.animate(this.f9490f).translationY(0.0f));
            }
            c1700es.m9092a(f9476u);
            c1700es.m9088a(250L);
            c1700es.m9091a(this.f9501q);
            this.f9498n = c1700es;
            c1700es.m9093a();
        } else {
            this.f9487c.setAlpha(1.0f);
            this.f9487c.setTranslationY(0.0f);
            if (this.f9495k && this.f9490f != null) {
                this.f9490f.setTranslationY(0.0f);
            }
            this.f9501q.onAnimationEnd(null);
        }
        if (this.f9486b != null) {
            ViewCompat.requestApplyInsets(this.f9486b);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m8953i(boolean z) {
        if (this.f9498n != null) {
            this.f9498n.m9095c();
        }
        if (this.f9481E == 0 && (this.f9484H || z)) {
            this.f9487c.setAlpha(1.0f);
            this.f9487c.setTransitioning(f9474s);
            C1700es c1700es = new C1700es();
            float f = -this.f9487c.getHeight();
            if (z) {
                this.f9487c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.f9487c).translationY(f);
            viewPropertyAnimatorCompatTranslationY.setUpdateListener(this.f9502r);
            c1700es.m9089a(viewPropertyAnimatorCompatTranslationY);
            if (this.f9495k && this.f9490f != null) {
                c1700es.m9089a(ViewCompat.animate(this.f9490f).translationY(f));
            }
            c1700es.m9092a(f9475t);
            c1700es.m9088a(250L);
            c1700es.m9091a(this.f9500p);
            this.f9498n = c1700es;
            c1700es.m9093a();
            return;
        }
        this.f9500p.onAnimationEnd(null);
    }

    /* JADX INFO: renamed from: j */
    public void m8955j(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatMo9381a;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatMo3399a;
        if (z) {
            m8947p();
        } else {
            m8948q();
        }
        if (!m8949r()) {
            if (z) {
                this.f9488d.mo9397d(4);
                this.f9489e.setVisibility(0);
                return;
            } else {
                this.f9488d.mo9397d(0);
                this.f9489e.setVisibility(8);
                return;
            }
        }
        if (z) {
            viewPropertyAnimatorCompatMo3399a = this.f9488d.mo9381a(4, 100L);
            viewPropertyAnimatorCompatMo9381a = this.f9489e.mo3399a(0, 200L);
        } else {
            viewPropertyAnimatorCompatMo9381a = this.f9488d.mo9381a(0, 200L);
            viewPropertyAnimatorCompatMo3399a = this.f9489e.mo3399a(8, 100L);
        }
        C1700es c1700es = new C1700es();
        c1700es.m9090a(viewPropertyAnimatorCompatMo3399a, viewPropertyAnimatorCompatMo9381a);
        c1700es.m9093a();
    }

    /* JADX INFO: renamed from: r */
    private boolean m8949r() {
        return ViewCompat.isLaidOut(this.f9487c);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: d */
    public Context mo3140d() {
        if (this.f9503v == null) {
            TypedValue typedValue = new TypedValue();
            this.f9485a.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedValue, f9474s);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f9503v = new ContextThemeWrapper(this.f9485a, i);
            } else {
                this.f9503v = this.f9485a;
            }
        }
        return this.f9503v;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0559a
    /* JADX INFO: renamed from: n */
    public void mo3433n() {
        if (this.f9498n != null) {
            this.f9498n.m9095c();
            this.f9498n = null;
        }
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: h */
    public boolean mo3146h() {
        if (this.f9488d == null || !this.f9488d.mo9395c()) {
            return false;
        }
        this.f9488d.mo9396d();
        return f9474s;
    }

    /* JADX INFO: renamed from: ed$a */
    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class a extends AbstractC1694em implements MenuBuilder.InterfaceC0552a {

        /* JADX INFO: renamed from: b */
        private final Context f9512b;

        /* JADX INFO: renamed from: c */
        private final MenuBuilder f9513c;

        /* JADX INFO: renamed from: d */
        private AbstractC1694em.a f9514d;

        /* JADX INFO: renamed from: e */
        private WeakReference<View> f9515e;

        public a(Context context, AbstractC1694em.a aVar) {
            this.f9512b = context;
            this.f9514d = aVar;
            this.f9513c = new MenuBuilder(context).m3320a(1);
            this.f9513c.mo3327a(this);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: a */
        public MenuInflater mo8957a() {
            return new C1699er(this.f9512b);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: b */
        public Menu mo8962b() {
            return this.f9513c;
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: c */
        public void mo8965c() {
            if (C1683ed.this.f9492h != this) {
                return;
            }
            if (!C1683ed.m8943a(C1683ed.this.f9496l, C1683ed.this.f9497m, false)) {
                C1683ed.this.f9493i = this;
                C1683ed.this.f9494j = this.f9514d;
            } else {
                this.f9514d.mo3280a(this);
            }
            this.f9514d = null;
            C1683ed.this.m8955j(false);
            C1683ed.this.f9489e.m3406b();
            C1683ed.this.f9488d.mo9382a().sendAccessibilityEvent(32);
            C1683ed.this.f9486b.setHideOnContentScrollEnabled(C1683ed.this.f9499o);
            C1683ed.this.f9492h = null;
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: d */
        public void mo8966d() {
            if (C1683ed.this.f9492h != this) {
                return;
            }
            this.f9513c.m3355h();
            try {
                this.f9514d.mo3283b(this, this.f9513c);
            } finally {
                this.f9513c.m3356i();
            }
        }

        /* JADX INFO: renamed from: e */
        public boolean m8967e() {
            this.f9513c.m3355h();
            try {
                return this.f9514d.mo3281a(this, this.f9513c);
            } finally {
                this.f9513c.m3356i();
            }
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: a */
        public void mo8959a(View view) {
            C1683ed.this.f9489e.setCustomView(view);
            this.f9515e = new WeakReference<>(view);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: a */
        public void mo8960a(CharSequence charSequence) {
            C1683ed.this.f9489e.setSubtitle(charSequence);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: b */
        public void mo8964b(CharSequence charSequence) {
            C1683ed.this.f9489e.setTitle(charSequence);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: a */
        public void mo8958a(int i) {
            mo8964b(C1683ed.this.f9485a.getResources().getString(i));
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: b */
        public void mo8963b(int i) {
            mo8960a((CharSequence) C1683ed.this.f9485a.getResources().getString(i));
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: f */
        public CharSequence mo8968f() {
            return C1683ed.this.f9489e.getTitle();
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: g */
        public CharSequence mo8969g() {
            return C1683ed.this.f9489e.getSubtitle();
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: a */
        public void mo8961a(boolean z) {
            super.mo8961a(z);
            C1683ed.this.f9489e.setTitleOptional(z);
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: h */
        public boolean mo8970h() {
            return C1683ed.this.f9489e.m3408d();
        }

        @Override // p000.AbstractC1694em
        /* JADX INFO: renamed from: i */
        public View mo8971i() {
            if (this.f9515e != null) {
                return this.f9515e.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f9514d != null) {
                return this.f9514d.mo3282a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public void mo2621a(MenuBuilder menuBuilder) {
            if (this.f9514d == null) {
                return;
            }
            mo8966d();
            C1683ed.this.f9489e.mo3400a();
        }
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: c */
    public void mo3139c(boolean z) {
        if (this.f9477A) {
            return;
        }
        m8951f(z);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public boolean mo3134a(int i, KeyEvent keyEvent) {
        Menu menuMo8962b;
        if (this.f9492h == null || (menuMo8962b = this.f9492h.mo8962b()) == null) {
            return false;
        }
        int keyboardType = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType();
        boolean z = f9474s;
        if (keyboardType == 1) {
            z = false;
        }
        menuMo8962b.setQwertyMode(z);
        return menuMo8962b.performShortcut(i, keyEvent, 0);
    }
}
