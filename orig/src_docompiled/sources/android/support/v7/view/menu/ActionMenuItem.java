package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* JADX INFO: renamed from: a */
    private final int f3185a;

    /* JADX INFO: renamed from: b */
    private final int f3186b;

    /* JADX INFO: renamed from: c */
    private final int f3187c;

    /* JADX INFO: renamed from: d */
    private final int f3188d;

    /* JADX INFO: renamed from: e */
    private CharSequence f3189e;

    /* JADX INFO: renamed from: f */
    private CharSequence f3190f;

    /* JADX INFO: renamed from: g */
    private Intent f3191g;

    /* JADX INFO: renamed from: h */
    private char f3192h;

    /* JADX INFO: renamed from: j */
    private char f3194j;

    /* JADX INFO: renamed from: l */
    private Drawable f3196l;

    /* JADX INFO: renamed from: n */
    private Context f3198n;

    /* JADX INFO: renamed from: o */
    private MenuItem.OnMenuItemClickListener f3199o;

    /* JADX INFO: renamed from: p */
    private CharSequence f3200p;

    /* JADX INFO: renamed from: q */
    private CharSequence f3201q;

    /* JADX INFO: renamed from: i */
    private int f3193i = 4096;

    /* JADX INFO: renamed from: k */
    private int f3195k = 4096;

    /* JADX INFO: renamed from: m */
    private int f3197m = 0;

    /* JADX INFO: renamed from: r */
    private ColorStateList f3202r = null;

    /* JADX INFO: renamed from: s */
    private PorterDuff.Mode f3203s = null;

    /* JADX INFO: renamed from: t */
    private boolean f3204t = false;

    /* JADX INFO: renamed from: u */
    private boolean f3205u = false;

    /* JADX INFO: renamed from: v */
    private int f3206v = 16;

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f3198n = context;
        this.f3185a = i2;
        this.f3186b = i;
        this.f3187c = i3;
        this.f3188d = i4;
        this.f3189e = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3194j;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3195k;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3186b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3196l;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3191g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3185a;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3192h;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3193i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3188d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3189e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f3190f != null ? this.f3190f : this.f3189e;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3206v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3206v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3206v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3206v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f3194j = Character.toLowerCase(c);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f3194j = Character.toLowerCase(c);
        this.f3195k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f3206v = (z ? 1 : 0) | (this.f3206v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f3206v = (z ? 2 : 0) | (this.f3206v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f3206v = (z ? 16 : 0) | (this.f3206v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3196l = drawable;
        this.f3197m = 0;
        m3291a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f3197m = i;
        this.f3196l = ContextCompat.getDrawable(this.f3198n, i);
        m3291a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3191g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f3192h = c;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f3192h = c;
        this.f3193i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3199o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f3192h = c;
        this.f3194j = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f3192h = c;
        this.f3193i = KeyEvent.normalizeMetaState(i);
        this.f3194j = Character.toLowerCase(c2);
        this.f3195k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3189e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f3189e = this.f3198n.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3190f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f3206v = (this.f3206v & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f3200p = charSequence;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3200p;
    }

    @Override // android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f3201q = charSequence;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3201q;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3202r = colorStateList;
        this.f3204t = true;
        m3291a();
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3202r;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3203s = mode;
        this.f3205u = true;
        m3291a();
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3203s;
    }

    /* JADX INFO: renamed from: a */
    private void m3291a() {
        if (this.f3196l != null) {
            if (this.f3204t || this.f3205u) {
                this.f3196l = DrawableCompat.wrap(this.f3196l);
                this.f3196l = this.f3196l.mutate();
                if (this.f3204t) {
                    DrawableCompat.setTintList(this.f3196l, this.f3202r);
                }
                if (this.f3205u) {
                    DrawableCompat.setTintMode(this.f3196l, this.f3203s);
                }
            }
        }
    }
}
