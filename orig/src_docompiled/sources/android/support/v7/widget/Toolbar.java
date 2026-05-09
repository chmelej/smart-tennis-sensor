package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import p000.C1684ee;
import p000.C1699er;
import p000.C1756gu;
import p000.C1766hd;
import p000.C1767he;
import p000.C1774hl;
import p000.InterfaceC1695en;
import p000.InterfaceC1714ff;
import p000.InterfaceC1741gf;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A */
    private int f4046A;

    /* JADX INFO: renamed from: B */
    private int f4047B;

    /* JADX INFO: renamed from: C */
    private boolean f4048C;

    /* JADX INFO: renamed from: D */
    private boolean f4049D;

    /* JADX INFO: renamed from: E */
    private final ArrayList<View> f4050E;

    /* JADX INFO: renamed from: F */
    private final ArrayList<View> f4051F;

    /* JADX INFO: renamed from: G */
    private final int[] f4052G;

    /* JADX INFO: renamed from: H */
    private final ActionMenuView.InterfaceC0570d f4053H;

    /* JADX INFO: renamed from: I */
    private C1767he f4054I;

    /* JADX INFO: renamed from: J */
    private ActionMenuPresenter f4055J;

    /* JADX INFO: renamed from: K */
    private C0658a f4056K;

    /* JADX INFO: renamed from: L */
    private InterfaceC1714ff.a f4057L;

    /* JADX INFO: renamed from: M */
    private MenuBuilder.InterfaceC0552a f4058M;

    /* JADX INFO: renamed from: N */
    private boolean f4059N;

    /* JADX INFO: renamed from: O */
    private final Runnable f4060O;

    /* JADX INFO: renamed from: a */
    private ActionMenuView f4061a;

    /* JADX INFO: renamed from: b */
    ImageButton f4062b;

    /* JADX INFO: renamed from: c */
    View f4063c;

    /* JADX INFO: renamed from: d */
    int f4064d;

    /* JADX INFO: renamed from: e */
    InterfaceC0659b f4065e;

    /* JADX INFO: renamed from: f */
    private TextView f4066f;

    /* JADX INFO: renamed from: g */
    private TextView f4067g;

    /* JADX INFO: renamed from: h */
    private ImageButton f4068h;

    /* JADX INFO: renamed from: i */
    private ImageView f4069i;

    /* JADX INFO: renamed from: j */
    private Drawable f4070j;

    /* JADX INFO: renamed from: k */
    private CharSequence f4071k;

    /* JADX INFO: renamed from: l */
    private Context f4072l;

    /* JADX INFO: renamed from: m */
    private int f4073m;

    /* JADX INFO: renamed from: n */
    private int f4074n;

    /* JADX INFO: renamed from: o */
    private int f4075o;

    /* JADX INFO: renamed from: p */
    private int f4076p;

    /* JADX INFO: renamed from: q */
    private int f4077q;

    /* JADX INFO: renamed from: r */
    private int f4078r;

    /* JADX INFO: renamed from: s */
    private int f4079s;

    /* JADX INFO: renamed from: t */
    private int f4080t;

    /* JADX INFO: renamed from: u */
    private C1756gu f4081u;

    /* JADX INFO: renamed from: v */
    private int f4082v;

    /* JADX INFO: renamed from: w */
    private int f4083w;

    /* JADX INFO: renamed from: x */
    private int f4084x;

    /* JADX INFO: renamed from: y */
    private CharSequence f4085y;

    /* JADX INFO: renamed from: z */
    private CharSequence f4086z;

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$b */
    public interface InterfaceC0659b {
        /* JADX INFO: renamed from: a */
        boolean m4380a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4084x = 8388627;
        this.f4050E = new ArrayList<>();
        this.f4051F = new ArrayList<>();
        this.f4052G = new int[2];
        this.f4053H = new ActionMenuView.InterfaceC0570d() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.InterfaceC0570d
            /* JADX INFO: renamed from: a */
            public boolean mo3480a(MenuItem menuItem) {
                if (Toolbar.this.f4065e != null) {
                    return Toolbar.this.f4065e.m4380a(menuItem);
                }
                return false;
            }
        };
        this.f4060O = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.m4367d();
            }
        };
        C1766hd c1766hdM9601a = C1766hd.m9601a(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.f4074n = c1766hdM9601a.m9619g(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f4075o = c1766hdM9601a.m9619g(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f4084x = c1766hdM9601a.m9611c(R.styleable.Toolbar_android_gravity, this.f4084x);
        this.f4064d = c1766hdM9601a.m9611c(R.styleable.Toolbar_buttonGravity, 48);
        int iM9613d = c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMargin, 0);
        iM9613d = c1766hdM9601a.m9620g(R.styleable.Toolbar_titleMargins) ? c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMargins, iM9613d) : iM9613d;
        this.f4080t = iM9613d;
        this.f4079s = iM9613d;
        this.f4078r = iM9613d;
        this.f4077q = iM9613d;
        int iM9613d2 = c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMarginStart, -1);
        if (iM9613d2 >= 0) {
            this.f4077q = iM9613d2;
        }
        int iM9613d3 = c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMarginEnd, -1);
        if (iM9613d3 >= 0) {
            this.f4078r = iM9613d3;
        }
        int iM9613d4 = c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMarginTop, -1);
        if (iM9613d4 >= 0) {
            this.f4079s = iM9613d4;
        }
        int iM9613d5 = c1766hdM9601a.m9613d(R.styleable.Toolbar_titleMarginBottom, -1);
        if (iM9613d5 >= 0) {
            this.f4080t = iM9613d5;
        }
        this.f4076p = c1766hdM9601a.m9615e(R.styleable.Toolbar_maxButtonHeight, -1);
        int iM9613d6 = c1766hdM9601a.m9613d(R.styleable.Toolbar_contentInsetStart, ExploreByTouchHelper.INVALID_ID);
        int iM9613d7 = c1766hdM9601a.m9613d(R.styleable.Toolbar_contentInsetEnd, ExploreByTouchHelper.INVALID_ID);
        int iM9615e = c1766hdM9601a.m9615e(R.styleable.Toolbar_contentInsetLeft, 0);
        int iM9615e2 = c1766hdM9601a.m9615e(R.styleable.Toolbar_contentInsetRight, 0);
        m4361s();
        this.f4081u.m9545b(iM9615e, iM9615e2);
        if (iM9613d6 != Integer.MIN_VALUE || iM9613d7 != Integer.MIN_VALUE) {
            this.f4081u.m9542a(iM9613d6, iM9613d7);
        }
        this.f4082v = c1766hdM9601a.m9613d(R.styleable.Toolbar_contentInsetStartWithNavigation, ExploreByTouchHelper.INVALID_ID);
        this.f4083w = c1766hdM9601a.m9613d(R.styleable.Toolbar_contentInsetEndWithActions, ExploreByTouchHelper.INVALID_ID);
        this.f4070j = c1766hdM9601a.m9605a(R.styleable.Toolbar_collapseIcon);
        this.f4071k = c1766hdM9601a.m9612c(R.styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceM9612c = c1766hdM9601a.m9612c(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceM9612c)) {
            setTitle(charSequenceM9612c);
        }
        CharSequence charSequenceM9612c2 = c1766hdM9601a.m9612c(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceM9612c2)) {
            setSubtitle(charSequenceM9612c2);
        }
        this.f4072l = getContext();
        setPopupTheme(c1766hdM9601a.m9619g(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawableM9605a = c1766hdM9601a.m9605a(R.styleable.Toolbar_navigationIcon);
        if (drawableM9605a != null) {
            setNavigationIcon(drawableM9605a);
        }
        CharSequence charSequenceM9612c3 = c1766hdM9601a.m9612c(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceM9612c3)) {
            setNavigationContentDescription(charSequenceM9612c3);
        }
        Drawable drawableM9605a2 = c1766hdM9601a.m9605a(R.styleable.Toolbar_logo);
        if (drawableM9605a2 != null) {
            setLogo(drawableM9605a2);
        }
        CharSequence charSequenceM9612c4 = c1766hdM9601a.m9612c(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceM9612c4)) {
            setLogoDescription(charSequenceM9612c4);
        }
        if (c1766hdM9601a.m9620g(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(c1766hdM9601a.m9609b(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (c1766hdM9601a.m9620g(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(c1766hdM9601a.m9609b(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        c1766hdM9601a.m9606a();
    }

    public void setPopupTheme(int i) {
        if (this.f4073m != i) {
            this.f4073m = i;
            if (i == 0) {
                this.f4072l = getContext();
            } else {
                this.f4072l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f4073m;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.f4077q = i;
        this.f4079s = i2;
        this.f4078r = i3;
        this.f4080t = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.f4077q;
    }

    public void setTitleMarginStart(int i) {
        this.f4077q = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f4079s;
    }

    public void setTitleMarginTop(int i) {
        this.f4079s = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f4078r;
    }

    public void setTitleMarginEnd(int i) {
        this.f4078r = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f4080t;
    }

    public void setTitleMarginBottom(int i) {
        this.f4080t = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m4361s();
        this.f4081u.m9543a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(C1684ee.m8975b(getContext(), i));
    }

    /* JADX INFO: renamed from: a */
    public boolean m4364a() {
        return getVisibility() == 0 && this.f4061a != null && this.f4061a.m3467a();
    }

    /* JADX INFO: renamed from: b */
    public boolean m4365b() {
        return this.f4061a != null && this.f4061a.m3476g();
    }

    /* JADX INFO: renamed from: c */
    public boolean m4366c() {
        return this.f4061a != null && this.f4061a.m3477h();
    }

    /* JADX INFO: renamed from: d */
    public boolean m4367d() {
        return this.f4061a != null && this.f4061a.m3474e();
    }

    /* JADX INFO: renamed from: e */
    public boolean m4368e() {
        return this.f4061a != null && this.f4061a.m3475f();
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.f4061a == null) {
            return;
        }
        m4357o();
        MenuBuilder menuBuilderM3473d = this.f4061a.m3473d();
        if (menuBuilderM3473d == menuBuilder) {
            return;
        }
        if (menuBuilderM3473d != null) {
            menuBuilderM3473d.m3339b(this.f4055J);
            menuBuilderM3473d.m3339b(this.f4056K);
        }
        if (this.f4056K == null) {
            this.f4056K = new C0658a();
        }
        actionMenuPresenter.m3451c(true);
        if (menuBuilder != null) {
            menuBuilder.m3331a(actionMenuPresenter, this.f4072l);
            menuBuilder.m3331a(this.f4056K, this.f4072l);
        } else {
            actionMenuPresenter.mo2436a(this.f4072l, (MenuBuilder) null);
            this.f4056K.mo2436a(this.f4072l, (MenuBuilder) null);
            actionMenuPresenter.mo2441a(true);
            this.f4056K.mo2441a(true);
        }
        this.f4061a.setPopupTheme(this.f4073m);
        this.f4061a.setPresenter(actionMenuPresenter);
        this.f4055J = actionMenuPresenter;
    }

    /* JADX INFO: renamed from: f */
    public void m4369f() {
        if (this.f4061a != null) {
            this.f4061a.m3478i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m4355m();
            if (!m4354d(this.f4069i)) {
                m4347a((View) this.f4069i, true);
            }
        } else if (this.f4069i != null && m4354d(this.f4069i)) {
            removeView(this.f4069i);
            this.f4051F.remove(this.f4069i);
        }
        if (this.f4069i != null) {
            this.f4069i.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.f4069i != null) {
            return this.f4069i.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4355m();
        }
        if (this.f4069i != null) {
            this.f4069i.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.f4069i != null) {
            return this.f4069i.getContentDescription();
        }
        return null;
    }

    /* JADX INFO: renamed from: m */
    private void m4355m() {
        if (this.f4069i == null) {
            this.f4069i = new AppCompatImageView(getContext());
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m4370g() {
        return (this.f4056K == null || this.f4056K.f4094b == null) ? false : true;
    }

    /* JADX INFO: renamed from: h */
    public void m4371h() {
        MenuItemImpl menuItemImpl = this.f4056K == null ? null : this.f4056K.f4094b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f4085y;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f4066f == null) {
                Context context = getContext();
                this.f4066f = new AppCompatTextView(context);
                this.f4066f.setSingleLine();
                this.f4066f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f4074n != 0) {
                    this.f4066f.setTextAppearance(context, this.f4074n);
                }
                if (this.f4046A != 0) {
                    this.f4066f.setTextColor(this.f4046A);
                }
            }
            if (!m4354d(this.f4066f)) {
                m4347a((View) this.f4066f, true);
            }
        } else if (this.f4066f != null && m4354d(this.f4066f)) {
            removeView(this.f4066f);
            this.f4051F.remove(this.f4066f);
        }
        if (this.f4066f != null) {
            this.f4066f.setText(charSequence);
        }
        this.f4085y = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f4086z;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f4067g == null) {
                Context context = getContext();
                this.f4067g = new AppCompatTextView(context);
                this.f4067g.setSingleLine();
                this.f4067g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f4075o != 0) {
                    this.f4067g.setTextAppearance(context, this.f4075o);
                }
                if (this.f4047B != 0) {
                    this.f4067g.setTextColor(this.f4047B);
                }
            }
            if (!m4354d(this.f4067g)) {
                m4347a((View) this.f4067g, true);
            }
        } else if (this.f4067g != null && m4354d(this.f4067g)) {
            removeView(this.f4067g);
            this.f4051F.remove(this.f4067g);
        }
        if (this.f4067g != null) {
            this.f4067g.setText(charSequence);
        }
        this.f4086z = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.f4074n = i;
        if (this.f4066f != null) {
            this.f4066f.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.f4075o = i;
        if (this.f4067g != null) {
            this.f4067g.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f4046A = i;
        if (this.f4066f != null) {
            this.f4066f.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f4047B = i;
        if (this.f4067g != null) {
            this.f4067g.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f4068h != null) {
            return this.f4068h.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4358p();
        }
        if (this.f4068h != null) {
            this.f4068h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C1684ee.m8975b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m4358p();
            if (!m4354d(this.f4068h)) {
                m4347a((View) this.f4068h, true);
            }
        } else if (this.f4068h != null && m4354d(this.f4068h)) {
            removeView(this.f4068h);
            this.f4051F.remove(this.f4068h);
        }
        if (this.f4068h != null) {
            this.f4068h.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.f4068h != null) {
            return this.f4068h.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m4358p();
        this.f4068h.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m4356n();
        return this.f4061a.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m4356n();
        this.f4061a.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m4356n();
        return this.f4061a.getOverflowIcon();
    }

    /* JADX INFO: renamed from: n */
    private void m4356n() {
        m4357o();
        if (this.f4061a.m3473d() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f4061a.getMenu();
            if (this.f4056K == null) {
                this.f4056K = new C0658a();
            }
            this.f4061a.setExpandedActionViewsExclusive(true);
            menuBuilder.m3331a(this.f4056K, this.f4072l);
        }
    }

    /* JADX INFO: renamed from: o */
    private void m4357o() {
        if (this.f4061a == null) {
            this.f4061a = new ActionMenuView(getContext());
            this.f4061a.setPopupTheme(this.f4073m);
            this.f4061a.setOnMenuItemClickListener(this.f4053H);
            this.f4061a.setMenuCallbacks(this.f4057L, this.f4058M);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f2966a = 8388613 | (this.f4064d & 112);
            this.f4061a.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            m4347a((View) this.f4061a, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C1699er(getContext());
    }

    public void setOnMenuItemClickListener(InterfaceC0659b interfaceC0659b) {
        this.f4065e = interfaceC0659b;
    }

    public void setContentInsetsRelative(int i, int i2) {
        m4361s();
        this.f4081u.m9542a(i, i2);
    }

    public int getContentInsetStart() {
        if (this.f4081u != null) {
            return this.f4081u.m9546c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        if (this.f4081u != null) {
            return this.f4081u.m9547d();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        m4361s();
        this.f4081u.m9545b(i, i2);
    }

    public int getContentInsetLeft() {
        if (this.f4081u != null) {
            return this.f4081u.m9541a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.f4081u != null) {
            return this.f4081u.m9544b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.f4082v != Integer.MIN_VALUE ? this.f4082v : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = ExploreByTouchHelper.INVALID_ID;
        }
        if (i != this.f4082v) {
            this.f4082v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        return this.f4083w != Integer.MIN_VALUE ? this.f4083w : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = ExploreByTouchHelper.INVALID_ID;
        }
        if (i != this.f4083w) {
            this.f4083w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f4082v, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilderM3473d;
        if ((this.f4061a == null || (menuBuilderM3473d = this.f4061a.m3473d()) == null || !menuBuilderM3473d.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.f4083w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    /* JADX INFO: renamed from: p */
    private void m4358p() {
        if (this.f4068h == null) {
            this.f4068h = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f2966a = 8388611 | (this.f4064d & 112);
            this.f4068h.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    /* JADX INFO: renamed from: i */
    void m4372i() {
        if (this.f4062b == null) {
            this.f4062b = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f4062b.setImageDrawable(this.f4070j);
            this.f4062b.setContentDescription(this.f4071k);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f2966a = 8388611 | (this.f4064d & 112);
            layoutParamsGenerateDefaultLayoutParams.f4090b = 2;
            this.f4062b.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.f4062b.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.m4371h();
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4347a(View view, boolean z) {
        LayoutParams layoutParamsGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParamsGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            layoutParamsGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            layoutParamsGenerateLayoutParams = (LayoutParams) layoutParams;
        }
        layoutParamsGenerateLayoutParams.f4090b = 1;
        if (z && this.f4063c != null) {
            view.setLayoutParams(layoutParamsGenerateLayoutParams);
            this.f4051F.add(view);
        } else {
            addView(view, layoutParamsGenerateLayoutParams);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f4056K != null && this.f4056K.f4094b != null) {
            savedState.f4091a = this.f4056K.f4094b.getItemId();
        }
        savedState.f4092b = m4365b();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        MenuBuilder menuBuilderM3473d = this.f4061a != null ? this.f4061a.m3473d() : null;
        if (savedState.f4091a != 0 && this.f4056K != null && menuBuilderM3473d != null && (menuItemFindItem = menuBuilderM3473d.findItem(savedState.f4091a)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f4092b) {
            m4359q();
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4359q() {
        removeCallbacks(this.f4060O);
        post(this.f4060O);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4060O);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4048C = false;
        }
        if (!this.f4048C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f4048C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4048C = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4049D = false;
        }
        if (!this.f4049D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f4049D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4049D = false;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m4346a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX INFO: renamed from: a */
    private int m4343a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* JADX INFO: renamed from: r */
    private boolean m4360r() {
        if (!this.f4059N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4349a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c;
        char c2;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.f4052G;
        if (C1774hl.m9679a(this)) {
            c = 1;
            c2 = 0;
        } else {
            c = 0;
            c2 = 1;
        }
        if (m4349a(this.f4068h)) {
            m4346a(this.f4068h, i, 0, i2, 0, this.f4076p);
            measuredWidth = this.f4068h.getMeasuredWidth() + m4351b(this.f4068h);
            iMax = Math.max(0, this.f4068h.getMeasuredHeight() + m4353c(this.f4068h));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f4068h.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m4349a(this.f4062b)) {
            m4346a(this.f4062b, i, 0, i2, 0, this.f4076p);
            measuredWidth = this.f4062b.getMeasuredWidth() + m4351b(this.f4062b);
            iMax = Math.max(iMax, this.f4062b.getMeasuredHeight() + m4353c(this.f4062b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4062b.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[c] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m4349a(this.f4061a)) {
            m4346a(this.f4061a, i, iMax3, i2, 0, this.f4076p);
            measuredWidth2 = this.f4061a.getMeasuredWidth() + m4351b(this.f4061a);
            iMax = Math.max(iMax, this.f4061a.getMeasuredHeight() + m4353c(this.f4061a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4061a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (m4349a(this.f4063c)) {
            iMax4 += m4343a(this.f4063c, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f4063c.getMeasuredHeight() + m4353c(this.f4063c));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4063c.getMeasuredState());
        }
        if (m4349a(this.f4069i)) {
            iMax4 += m4343a(this.f4069i, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f4069i.getMeasuredHeight() + m4353c(this.f4069i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4069i.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iM4343a = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).f4090b == 0 && m4349a(childAt)) {
                iM4343a += m4343a(childAt, i, iM4343a, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + m4353c(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.f4079s + this.f4080t;
        int i5 = this.f4077q + this.f4078r;
        if (m4349a(this.f4066f)) {
            m4343a(this.f4066f, i, iM4343a + i5, i2, i4, iArr);
            int measuredWidth3 = this.f4066f.getMeasuredWidth() + m4351b(this.f4066f);
            measuredHeight = this.f4066f.getMeasuredHeight() + m4353c(this.f4066f);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f4066f.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (m4349a(this.f4067g)) {
            iMax2 = Math.max(iMax2, m4343a(this.f4067g, i, iM4343a + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.f4067g.getMeasuredHeight() + m4353c(this.f4067g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f4067g.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iM4343a + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (m4360r()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa A[LOOP:0: B:104:0x02a8->B:105:0x02aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cc A[LOOP:1: B:107:0x02ca->B:108:0x02cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0306 A[LOOP:2: B:116:0x0304->B:117:0x0306, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: renamed from: a */
    private int m4345a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i5 = layoutParams.leftMargin - i;
            int i6 = layoutParams.rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    /* JADX INFO: renamed from: a */
    private int m4344a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iM4342a = m4342a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM4342a, iMax + measuredWidth, view.getMeasuredHeight() + iM4342a);
        return iMax + measuredWidth + layoutParams.rightMargin;
    }

    /* JADX INFO: renamed from: b */
    private int m4352b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iM4342a = m4342a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM4342a, iMax, view.getMeasuredHeight() + iM4342a);
        return iMax - (measuredWidth + layoutParams.leftMargin);
    }

    /* JADX INFO: renamed from: a */
    private int m4342a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iM4341a = m4341a(layoutParams.f2966a);
        if (iM4341a == 48) {
            return getPaddingTop() - i2;
        }
        if (iM4341a == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < layoutParams.topMargin) {
            iMax = layoutParams.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < layoutParams.bottomMargin) {
                iMax = Math.max(0, iMax - (layoutParams.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    /* JADX INFO: renamed from: a */
    private int m4341a(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f4084x & 112;
    }

    /* JADX INFO: renamed from: a */
    private void m4348a(List<View> list, int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4090b == 0 && m4349a(childAt) && m4350b(layoutParams.f2966a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f4090b == 0 && m4349a(childAt2) && m4350b(layoutParams2.f2966a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private int m4350b(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4349a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    private int m4351b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    /* JADX INFO: renamed from: c */
    private int m4353c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public InterfaceC1741gf getWrapper() {
        if (this.f4054I == null) {
            this.f4054I = new C1767he(this, true);
        }
        return this.f4054I;
    }

    /* JADX INFO: renamed from: k */
    void m4374k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f4090b != 2 && childAt != this.f4061a) {
                removeViewAt(childCount);
                this.f4051F.add(childAt);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    void m4375l() {
        for (int size = this.f4051F.size() - 1; size >= 0; size--) {
            addView(this.f4051F.get(size));
        }
        this.f4051F.clear();
    }

    /* JADX INFO: renamed from: d */
    private boolean m4354d(View view) {
        return view.getParent() == this || this.f4051F.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f4059N = z;
        requestLayout();
    }

    public void setMenuCallbacks(InterfaceC1714ff.a aVar, MenuBuilder.InterfaceC0552a interfaceC0552a) {
        this.f4057L = aVar;
        this.f4058M = interfaceC0552a;
        if (this.f4061a != null) {
            this.f4061a.setMenuCallbacks(aVar, interfaceC0552a);
        }
    }

    /* JADX INFO: renamed from: s */
    private void m4361s() {
        if (this.f4081u == null) {
            this.f4081u = new C1756gu();
        }
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f4055J;
    }

    Context getPopupContext() {
        return this.f4072l;
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* JADX INFO: renamed from: b */
        int f4090b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4090b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4090b = 0;
            this.f2966a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f4090b = 0;
            this.f4090b = layoutParams.f4090b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4090b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4090b = 0;
            m4376a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4090b = 0;
        }

        /* JADX INFO: renamed from: a */
        void m4376a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.Toolbar.SavedState.1
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
        int f4091a;

        /* JADX INFO: renamed from: b */
        boolean f4092b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4091a = parcel.readInt();
            this.f4092b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4091a);
            parcel.writeInt(this.f4092b ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$a */
    class C0658a implements InterfaceC1714ff {

        /* JADX INFO: renamed from: a */
        MenuBuilder f4093a;

        /* JADX INFO: renamed from: b */
        MenuItemImpl f4094b;

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public void mo2437a(Parcelable parcelable) {
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public void mo2440a(InterfaceC1714ff.a aVar) {
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public boolean mo2442a() {
            return false;
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: b */
        public int mo2445b() {
            return 0;
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: c */
        public Parcelable mo2448c() {
            return null;
        }

        C0658a() {
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public void mo2436a(Context context, MenuBuilder menuBuilder) {
            if (this.f4093a != null && this.f4094b != null) {
                this.f4093a.mo3350d(this.f4094b);
            }
            this.f4093a = menuBuilder;
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public void mo2441a(boolean z) {
            if (this.f4094b != null) {
                boolean z2 = false;
                if (this.f4093a != null) {
                    int size = this.f4093a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f4093a.getItem(i) == this.f4094b) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                mo2447b(this.f4093a, this.f4094b);
            }
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: a */
        public boolean mo2443a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.m4372i();
            ViewParent parent = Toolbar.this.f4062b.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.f4062b);
                }
                Toolbar.this.addView(Toolbar.this.f4062b);
            }
            Toolbar.this.f4063c = menuItemImpl.getActionView();
            this.f4094b = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f4063c.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.f4063c);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                layoutParamsGenerateDefaultLayoutParams.f2966a = 8388611 | (Toolbar.this.f4064d & 112);
                layoutParamsGenerateDefaultLayoutParams.f4090b = 2;
                Toolbar.this.f4063c.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f4063c);
            }
            Toolbar.this.m4374k();
            Toolbar.this.requestLayout();
            menuItemImpl.m3383e(true);
            if (Toolbar.this.f4063c instanceof InterfaceC1695en) {
                ((InterfaceC1695en) Toolbar.this.f4063c).mo4189a();
            }
            return true;
        }

        @Override // p000.InterfaceC1714ff
        /* JADX INFO: renamed from: b */
        public boolean mo2447b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.f4063c instanceof InterfaceC1695en) {
                ((InterfaceC1695en) Toolbar.this.f4063c).mo4195b();
            }
            Toolbar.this.removeView(Toolbar.this.f4063c);
            Toolbar.this.removeView(Toolbar.this.f4062b);
            Toolbar.this.f4063c = null;
            Toolbar.this.m4375l();
            this.f4094b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.m3383e(false);
            return true;
        }
    }
}
