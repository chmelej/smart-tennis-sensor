package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: he */
/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1767he implements InterfaceC1741gf {

    /* JADX INFO: renamed from: a */
    Toolbar f10146a;

    /* JADX INFO: renamed from: b */
    CharSequence f10147b;

    /* JADX INFO: renamed from: c */
    Window.Callback f10148c;

    /* JADX INFO: renamed from: d */
    boolean f10149d;

    /* JADX INFO: renamed from: e */
    private int f10150e;

    /* JADX INFO: renamed from: f */
    private View f10151f;

    /* JADX INFO: renamed from: g */
    private View f10152g;

    /* JADX INFO: renamed from: h */
    private Drawable f10153h;

    /* JADX INFO: renamed from: i */
    private Drawable f10154i;

    /* JADX INFO: renamed from: j */
    private Drawable f10155j;

    /* JADX INFO: renamed from: k */
    private boolean f10156k;

    /* JADX INFO: renamed from: l */
    private CharSequence f10157l;

    /* JADX INFO: renamed from: m */
    private CharSequence f10158m;

    /* JADX INFO: renamed from: n */
    private ActionMenuPresenter f10159n;

    /* JADX INFO: renamed from: o */
    private int f10160o;

    /* JADX INFO: renamed from: p */
    private int f10161p;

    /* JADX INFO: renamed from: q */
    private Drawable f10162q;

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: b */
    public void mo9393b(boolean z) {
    }

    public C1767he(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public C1767he(Toolbar toolbar, boolean z, int i, int i2) {
        this.f10160o = 0;
        this.f10161p = 0;
        this.f10146a = toolbar;
        this.f10147b = toolbar.getTitle();
        this.f10157l = toolbar.getSubtitle();
        this.f10156k = this.f10147b != null;
        this.f10155j = toolbar.getNavigationIcon();
        C1766hd c1766hdM9601a = C1766hd.m9601a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f10162q = c1766hdM9601a.m9605a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceM9612c = c1766hdM9601a.m9612c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceM9612c)) {
                m9628b(charSequenceM9612c);
            }
            CharSequence charSequenceM9612c2 = c1766hdM9601a.m9612c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceM9612c2)) {
                m9630c(charSequenceM9612c2);
            }
            Drawable drawableM9605a = c1766hdM9601a.m9605a(R.styleable.ActionBar_logo);
            if (drawableM9605a != null) {
                m9627b(drawableM9605a);
            }
            Drawable drawableM9605a2 = c1766hdM9601a.m9605a(R.styleable.ActionBar_icon);
            if (drawableM9605a2 != null) {
                mo9384a(drawableM9605a2);
            }
            if (this.f10155j == null && this.f10162q != null) {
                m9629c(this.f10162q);
            }
            mo9394c(c1766hdM9601a.m9603a(R.styleable.ActionBar_displayOptions, 0));
            int iM9619g = c1766hdM9601a.m9619g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (iM9619g != 0) {
                m9626a(LayoutInflater.from(this.f10146a.getContext()).inflate(iM9619g, (ViewGroup) this.f10146a, false));
                mo9394c(this.f10150e | 16);
            }
            int iM9617f = c1766hdM9601a.m9617f(R.styleable.ActionBar_height, 0);
            if (iM9617f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f10146a.getLayoutParams();
                layoutParams.height = iM9617f;
                this.f10146a.setLayoutParams(layoutParams);
            }
            int iM9613d = c1766hdM9601a.m9613d(R.styleable.ActionBar_contentInsetStart, -1);
            int iM9613d2 = c1766hdM9601a.m9613d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (iM9613d >= 0 || iM9613d2 >= 0) {
                this.f10146a.setContentInsetsRelative(Math.max(iM9613d, 0), Math.max(iM9613d2, 0));
            }
            int iM9619g2 = c1766hdM9601a.m9619g(R.styleable.ActionBar_titleTextStyle, 0);
            if (iM9619g2 != 0) {
                this.f10146a.setTitleTextAppearance(this.f10146a.getContext(), iM9619g2);
            }
            int iM9619g3 = c1766hdM9601a.m9619g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iM9619g3 != 0) {
                this.f10146a.setSubtitleTextAppearance(this.f10146a.getContext(), iM9619g3);
            }
            int iM9619g4 = c1766hdM9601a.m9619g(R.styleable.ActionBar_popupTheme, 0);
            if (iM9619g4 != 0) {
                this.f10146a.setPopupTheme(iM9619g4);
            }
        } else {
            this.f10150e = m9622r();
        }
        c1766hdM9601a.m9606a();
        m9632e(i);
        this.f10158m = this.f10146a.getNavigationContentDescription();
        this.f10146a.setNavigationOnClickListener(new View.OnClickListener() { // from class: he.1

            /* JADX INFO: renamed from: a */
            final ActionMenuItem f10163a;

            {
                this.f10163a = new ActionMenuItem(C1767he.this.f10146a.getContext(), 0, android.R.id.home, 0, 0, C1767he.this.f10147b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1767he.this.f10148c == null || !C1767he.this.f10149d) {
                    return;
                }
                C1767he.this.f10148c.onMenuItemSelected(0, this.f10163a);
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public void m9632e(int i) {
        if (i == this.f10161p) {
            return;
        }
        this.f10161p = i;
        if (TextUtils.isEmpty(this.f10146a.getNavigationContentDescription())) {
            m9633f(this.f10161p);
        }
    }

    /* JADX INFO: renamed from: r */
    private int m9622r() {
        if (this.f10146a.getNavigationIcon() == null) {
            return 11;
        }
        this.f10162q = this.f10146a.getNavigationIcon();
        return 15;
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public ViewGroup mo9382a() {
        return this.f10146a;
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: b */
    public Context mo9391b() {
        return this.f10146a.getContext();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: c */
    public boolean mo9395c() {
        return this.f10146a.m4370g();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: d */
    public void mo9396d() {
        this.f10146a.m4371h();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9387a(Window.Callback callback) {
        this.f10148c = callback;
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9389a(CharSequence charSequence) {
        if (this.f10156k) {
            return;
        }
        m9621e(charSequence);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: e */
    public CharSequence mo9398e() {
        return this.f10146a.getTitle();
    }

    /* JADX INFO: renamed from: b */
    public void m9628b(CharSequence charSequence) {
        this.f10156k = true;
        m9621e(charSequence);
    }

    /* JADX INFO: renamed from: e */
    private void m9621e(CharSequence charSequence) {
        this.f10147b = charSequence;
        if ((this.f10150e & 8) != 0) {
            this.f10146a.setTitle(charSequence);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m9630c(CharSequence charSequence) {
        this.f10157l = charSequence;
        if ((this.f10150e & 8) != 0) {
            this.f10146a.setSubtitle(charSequence);
        }
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: f */
    public void mo9399f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: g */
    public void mo9400g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9383a(int i) {
        mo9384a(i != 0 ? C1684ee.m8975b(mo9391b(), i) : null);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9384a(Drawable drawable) {
        this.f10153h = drawable;
        m9623s();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: b */
    public void mo9392b(int i) {
        m9627b(i != 0 ? C1684ee.m8975b(mo9391b(), i) : null);
    }

    /* JADX INFO: renamed from: b */
    public void m9627b(Drawable drawable) {
        this.f10154i = drawable;
        m9623s();
    }

    /* JADX INFO: renamed from: s */
    private void m9623s() {
        Drawable drawable;
        if ((this.f10150e & 2) != 0) {
            drawable = ((this.f10150e & 1) == 0 || this.f10154i == null) ? this.f10153h : this.f10154i;
        } else {
            drawable = null;
        }
        this.f10146a.setLogo(drawable);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: h */
    public boolean mo9401h() {
        return this.f10146a.m4364a();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: i */
    public boolean mo9402i() {
        return this.f10146a.m4365b();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: j */
    public boolean mo9403j() {
        return this.f10146a.m4366c();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: k */
    public boolean mo9404k() {
        return this.f10146a.m4367d();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: l */
    public boolean mo9405l() {
        return this.f10146a.m4368e();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: m */
    public void mo9406m() {
        this.f10149d = true;
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9386a(Menu menu, InterfaceC1714ff.a aVar) {
        if (this.f10159n == null) {
            this.f10159n = new ActionMenuPresenter(this.f10146a.getContext());
            this.f10159n.m9097a(R.id.action_menu_presenter);
        }
        this.f10159n.mo2440a(aVar);
        this.f10146a.setMenu((MenuBuilder) menu, this.f10159n);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: n */
    public void mo9407n() {
        this.f10146a.m4369f();
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: o */
    public int mo9408o() {
        return this.f10150e;
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: c */
    public void mo9394c(int i) {
        int i2 = this.f10150e ^ i;
        this.f10150e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m9625u();
                }
                m9624t();
            }
            if ((i2 & 3) != 0) {
                m9623s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f10146a.setTitle(this.f10147b);
                    this.f10146a.setSubtitle(this.f10157l);
                } else {
                    this.f10146a.setTitle((CharSequence) null);
                    this.f10146a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || this.f10152g == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f10146a.addView(this.f10152g);
            } else {
                this.f10146a.removeView(this.f10152g);
            }
        }
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9385a(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f10151f != null && this.f10151f.getParent() == this.f10146a) {
            this.f10146a.removeView(this.f10151f);
        }
        this.f10151f = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f10160o != 2) {
            return;
        }
        this.f10146a.addView(this.f10151f, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f10151f.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.f2966a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9390a(boolean z) {
        this.f10146a.setCollapsible(z);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: p */
    public int mo9409p() {
        return this.f10160o;
    }

    /* JADX INFO: renamed from: a */
    public void m9626a(View view) {
        if (this.f10152g != null && (this.f10150e & 16) != 0) {
            this.f10146a.removeView(this.f10152g);
        }
        this.f10152g = view;
        if (view == null || (this.f10150e & 16) == 0) {
            return;
        }
        this.f10146a.addView(this.f10152g);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat mo9381a(final int i, long j) {
        return ViewCompat.animate(this.f10146a).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: he.2

            /* JADX INFO: renamed from: c */
            private boolean f10167c = false;

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                C1767he.this.f10146a.setVisibility(0);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (this.f10167c) {
                    return;
                }
                C1767he.this.f10146a.setVisibility(i);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.f10167c = true;
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m9629c(Drawable drawable) {
        this.f10155j = drawable;
        m9624t();
    }

    /* JADX INFO: renamed from: t */
    private void m9624t() {
        if ((this.f10150e & 4) != 0) {
            this.f10146a.setNavigationIcon(this.f10155j != null ? this.f10155j : this.f10162q);
        } else {
            this.f10146a.setNavigationIcon((Drawable) null);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m9631d(CharSequence charSequence) {
        this.f10158m = charSequence;
        m9625u();
    }

    /* JADX INFO: renamed from: f */
    public void m9633f(int i) {
        m9631d(i == 0 ? null : mo9391b().getString(i));
    }

    /* JADX INFO: renamed from: u */
    private void m9625u() {
        if ((this.f10150e & 4) != 0) {
            if (TextUtils.isEmpty(this.f10158m)) {
                this.f10146a.setNavigationContentDescription(this.f10161p);
            } else {
                this.f10146a.setNavigationContentDescription(this.f10158m);
            }
        }
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: d */
    public void mo9397d(int i) {
        this.f10146a.setVisibility(i);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: a */
    public void mo9388a(InterfaceC1714ff.a aVar, MenuBuilder.InterfaceC0552a interfaceC0552a) {
        this.f10146a.setMenuCallbacks(aVar, interfaceC0552a);
    }

    @Override // p000.InterfaceC1741gf
    /* JADX INFO: renamed from: q */
    public Menu mo9410q() {
        return this.f10146a.getMenu();
    }
}
