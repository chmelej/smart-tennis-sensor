package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import p000.C1684ee;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* JADX INFO: renamed from: A */
    private View f3267A;

    /* JADX INFO: renamed from: B */
    private ActionProvider f3268B;

    /* JADX INFO: renamed from: C */
    private MenuItem.OnActionExpandListener f3269C;

    /* JADX INFO: renamed from: E */
    private ContextMenu.ContextMenuInfo f3271E;

    /* JADX INFO: renamed from: a */
    MenuBuilder f3272a;

    /* JADX INFO: renamed from: b */
    private final int f3273b;

    /* JADX INFO: renamed from: c */
    private final int f3274c;

    /* JADX INFO: renamed from: d */
    private final int f3275d;

    /* JADX INFO: renamed from: e */
    private final int f3276e;

    /* JADX INFO: renamed from: f */
    private CharSequence f3277f;

    /* JADX INFO: renamed from: g */
    private CharSequence f3278g;

    /* JADX INFO: renamed from: h */
    private Intent f3279h;

    /* JADX INFO: renamed from: i */
    private char f3280i;

    /* JADX INFO: renamed from: k */
    private char f3282k;

    /* JADX INFO: renamed from: m */
    private Drawable f3284m;

    /* JADX INFO: renamed from: o */
    private SubMenuBuilder f3286o;

    /* JADX INFO: renamed from: p */
    private Runnable f3287p;

    /* JADX INFO: renamed from: q */
    private MenuItem.OnMenuItemClickListener f3288q;

    /* JADX INFO: renamed from: r */
    private CharSequence f3289r;

    /* JADX INFO: renamed from: s */
    private CharSequence f3290s;

    /* JADX INFO: renamed from: z */
    private int f3297z;

    /* JADX INFO: renamed from: j */
    private int f3281j = 4096;

    /* JADX INFO: renamed from: l */
    private int f3283l = 4096;

    /* JADX INFO: renamed from: n */
    private int f3285n = 0;

    /* JADX INFO: renamed from: t */
    private ColorStateList f3291t = null;

    /* JADX INFO: renamed from: u */
    private PorterDuff.Mode f3292u = null;

    /* JADX INFO: renamed from: v */
    private boolean f3293v = false;

    /* JADX INFO: renamed from: w */
    private boolean f3294w = false;

    /* JADX INFO: renamed from: x */
    private boolean f3295x = false;

    /* JADX INFO: renamed from: y */
    private int f3296y = 16;

    /* JADX INFO: renamed from: D */
    private boolean f3270D = false;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f3297z = 0;
        this.f3272a = menuBuilder;
        this.f3273b = i2;
        this.f3274c = i;
        this.f3275d = i3;
        this.f3276e = i4;
        this.f3277f = charSequence;
        this.f3297z = i5;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3375a() {
        if ((this.f3288q != null && this.f3288q.onMenuItemClick(this)) || this.f3272a.mo3333a(this.f3272a, this)) {
            return true;
        }
        if (this.f3287p != null) {
            this.f3287p.run();
            return true;
        }
        if (this.f3279h != null) {
            try {
                this.f3272a.m3353f().startActivity(this.f3279h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f3268B != null && this.f3268B.onPerformDefaultAction();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3296y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f3296y |= 16;
        } else {
            this.f3296y &= -17;
        }
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3274c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f3273b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3275d;
    }

    /* JADX INFO: renamed from: b */
    public int m3376b() {
        return this.f3276e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3279h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3279h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3282k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f3282k == c) {
            return this;
        }
        this.f3282k = Character.toLowerCase(c);
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f3282k == c && this.f3283l == i) {
            return this;
        }
        this.f3282k = Character.toLowerCase(c);
        this.f3283l = KeyEvent.normalizeMetaState(i);
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3283l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3280i;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3281j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f3280i == c) {
            return this;
        }
        this.f3280i = c;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f3280i == c && this.f3281j == i) {
            return this;
        }
        this.f3280i = c;
        this.f3281j = KeyEvent.normalizeMetaState(i);
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f3280i = c;
        this.f3282k = Character.toLowerCase(c2);
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f3280i = c;
        this.f3281j = KeyEvent.normalizeMetaState(i);
        this.f3282k = Character.toLowerCase(c2);
        this.f3283l = KeyEvent.normalizeMetaState(i2);
        this.f3272a.mo2458a(false);
        return this;
    }

    /* JADX INFO: renamed from: c */
    char m3379c() {
        return this.f3272a.mo3345c() ? this.f3282k : this.f3280i;
    }

    /* JADX INFO: renamed from: d */
    String m3381d() {
        char cM3379c = m3379c();
        if (cM3379c == 0) {
            return "";
        }
        Resources resources = this.f3272a.m3353f().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f3272a.m3353f()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i = this.f3272a.mo3345c() ? this.f3283l : this.f3281j;
        m3368a(sb, i, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        m3368a(sb, i, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        m3368a(sb, i, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        m3368a(sb, i, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        m3368a(sb, i, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        m3368a(sb, i, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cM3379c == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cM3379c == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cM3379c == ' ') {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        } else {
            sb.append(cM3379c);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static void m3368a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* JADX INFO: renamed from: e */
    boolean m3384e() {
        return this.f3272a.mo3349d() && m3379c() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f3286o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f3286o != null;
    }

    /* JADX INFO: renamed from: a */
    public void m3372a(SubMenuBuilder subMenuBuilder) {
        this.f3286o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f3277f;
    }

    /* JADX INFO: renamed from: a */
    CharSequence m3371a(InterfaceC1715fg.a aVar) {
        if (aVar != null && aVar.mo2424a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3277f = charSequence;
        this.f3272a.mo2458a(false);
        if (this.f3286o != null) {
            this.f3286o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f3272a.m3353f().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3278g != null ? this.f3278g : this.f3277f;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3278g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f3277f;
        }
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f3284m != null) {
            return m3367a(this.f3284m);
        }
        if (this.f3285n == 0) {
            return null;
        }
        Drawable drawableM8975b = C1684ee.m8975b(this.f3272a.m3353f(), this.f3285n);
        this.f3285n = 0;
        this.f3284m = drawableM8975b;
        return m3367a(drawableM8975b);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3285n = 0;
        this.f3284m = drawable;
        this.f3295x = true;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f3284m = null;
        this.f3285n = i;
        this.f3295x = true;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3291t = colorStateList;
        this.f3293v = true;
        this.f3295x = true;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3291t;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3292u = mode;
        this.f3294w = true;
        this.f3295x = true;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3292u;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m3367a(Drawable drawable) {
        if (drawable != null && this.f3295x && (this.f3293v || this.f3294w)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.f3293v) {
                DrawableCompat.setTintList(drawable, this.f3291t);
            }
            if (this.f3294w) {
                DrawableCompat.setTintMode(drawable, this.f3292u);
            }
            this.f3295x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3296y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f3296y;
        this.f3296y = (z ? 1 : 0) | (this.f3296y & (-2));
        if (i != this.f3296y) {
            this.f3272a.mo2458a(false);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3374a(boolean z) {
        this.f3296y = (z ? 4 : 0) | (this.f3296y & (-5));
    }

    /* JADX INFO: renamed from: f */
    public boolean m3385f() {
        return (this.f3296y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3296y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f3296y & 4) != 0) {
            this.f3272a.m3329a((MenuItem) this);
        } else {
            m3378b(z);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    void m3378b(boolean z) {
        int i = this.f3296y;
        this.f3296y = (z ? 2 : 0) | (this.f3296y & (-3));
        if (i != this.f3296y) {
            this.f3272a.mo2458a(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3268B == null || !this.f3268B.overridesItemVisibility()) ? (this.f3296y & 8) == 0 : (this.f3296y & 8) == 0 && this.f3268B.isVisible();
    }

    /* JADX INFO: renamed from: c */
    boolean m3380c(boolean z) {
        int i = this.f3296y;
        this.f3296y = (z ? 0 : 8) | (this.f3296y & (-9));
        return i != this.f3296y;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m3380c(z)) {
            this.f3272a.m3328a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3288q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f3277f != null) {
            return this.f3277f.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m3373a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f3271E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f3271E;
    }

    /* JADX INFO: renamed from: g */
    public void m3386g() {
        this.f3272a.m3338b(this);
    }

    /* JADX INFO: renamed from: h */
    public boolean m3387h() {
        return this.f3272a.m3365r();
    }

    /* JADX INFO: renamed from: i */
    public boolean m3388i() {
        return (this.f3296y & 32) == 32;
    }

    /* JADX INFO: renamed from: j */
    public boolean m3389j() {
        return (this.f3297z & 1) == 1;
    }

    /* JADX INFO: renamed from: k */
    public boolean m3390k() {
        return (this.f3297z & 2) == 2;
    }

    /* JADX INFO: renamed from: d */
    public void m3382d(boolean z) {
        if (z) {
            this.f3296y |= 32;
        } else {
            this.f3296y &= -33;
        }
    }

    /* JADX INFO: renamed from: l */
    public boolean m3391l() {
        return (this.f3297z & 4) == 4;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f3297z = i;
                this.f3272a.m3338b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        this.f3267A = view;
        this.f3268B = null;
        if (view != null && view.getId() == -1 && this.f3273b > 0) {
            view.setId(this.f3273b);
        }
        this.f3272a.m3338b(this);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i) {
        Context contextM3353f = this.f3272a.m3353f();
        setActionView(LayoutInflater.from(contextM3353f).inflate(i, (ViewGroup) new LinearLayout(contextM3353f), false));
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        if (this.f3267A != null) {
            return this.f3267A;
        }
        if (this.f3268B == null) {
            return null;
        }
        this.f3267A = this.f3268B.onCreateActionView(this);
        return this.f3267A;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.f3268B;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f3268B != null) {
            this.f3268B.reset();
        }
        this.f3267A = null;
        this.f3268B = actionProvider;
        this.f3272a.mo2458a(true);
        if (this.f3268B != null) {
            this.f3268B.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: android.support.v7.view.menu.MenuItemImpl.1
                @Override // android.support.v4.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.f3272a.m3328a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!m3392m()) {
            return false;
        }
        if (this.f3269C == null || this.f3269C.onMenuItemActionExpand(this)) {
            return this.f3272a.mo3346c(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f3297z & 8) == 0) {
            return false;
        }
        if (this.f3267A == null) {
            return true;
        }
        if (this.f3269C == null || this.f3269C.onMenuItemActionCollapse(this)) {
            return this.f3272a.mo3350d(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: m */
    public boolean m3392m() {
        if ((this.f3297z & 8) == 0) {
            return false;
        }
        if (this.f3267A == null && this.f3268B != null) {
            this.f3267A = this.f3268B.onCreateActionView(this);
        }
        return this.f3267A != null;
    }

    /* JADX INFO: renamed from: e */
    public void m3383e(boolean z) {
        this.f3270D = z;
        this.f3272a.mo2458a(false);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f3270D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3269C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f3289r = charSequence;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3289r;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f3290s = charSequence;
        this.f3272a.mo2458a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3290s;
    }
}
