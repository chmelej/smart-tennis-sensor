package p000;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: fb */
/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class MenuItemC1710fb extends AbstractC1703ev<SupportMenuItem> implements MenuItem {

    /* JADX INFO: renamed from: c */
    private Method f9761c;

    MenuItemC1710fb(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((SupportMenuItem) this.f9694b).getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((SupportMenuItem) this.f9694b).getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((SupportMenuItem) this.f9694b).getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f9694b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f9694b).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f9694b).getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f9694b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f9694b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f9694b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f9694b).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((SupportMenuItem) this.f9694b).getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f9694b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((SupportMenuItem) this.f9694b).getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((SupportMenuItem) this.f9694b).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((SupportMenuItem) this.f9694b).setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((SupportMenuItem) this.f9694b).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        ((SupportMenuItem) this.f9694b).setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f9694b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((SupportMenuItem) this.f9694b).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((SupportMenuItem) this.f9694b).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((SupportMenuItem) this.f9694b).setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f9694b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((SupportMenuItem) this.f9694b).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f9694b).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((SupportMenuItem) this.f9694b).isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f9694b).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((SupportMenuItem) this.f9694b).isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f9694b).setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((SupportMenuItem) this.f9694b).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f9694b).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((SupportMenuItem) this.f9694b).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f9694b).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m9102a(((SupportMenuItem) this.f9694b).getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f9694b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f9694b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f9694b).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f9694b).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((SupportMenuItem) this.f9694b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f9694b).setActionView(i);
        View actionView = ((SupportMenuItem) this.f9694b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.f9694b).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f9694b).getActionView();
        return actionView instanceof b ? ((b) actionView).m9145c() : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((SupportMenuItem) this.f9694b).setSupportActionProvider(actionProvider != null ? mo9143a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        android.support.v4.view.ActionProvider supportActionProvider = ((SupportMenuItem) this.f9694b).getSupportActionProvider();
        if (supportActionProvider instanceof a) {
            return ((a) supportActionProvider).f9762a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((SupportMenuItem) this.f9694b).expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f9694b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f9694b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f9694b).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((SupportMenuItem) this.f9694b).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((SupportMenuItem) this.f9694b).getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((SupportMenuItem) this.f9694b).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((SupportMenuItem) this.f9694b).getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((SupportMenuItem) this.f9694b).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((SupportMenuItem) this.f9694b).getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((SupportMenuItem) this.f9694b).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((SupportMenuItem) this.f9694b).getIconTintMode();
    }

    /* JADX INFO: renamed from: a */
    public void m9144a(boolean z) {
        try {
            if (this.f9761c == null) {
                this.f9761c = ((SupportMenuItem) this.f9694b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f9761c.invoke(this.f9694b, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* JADX INFO: renamed from: a */
    a mo9143a(ActionProvider actionProvider) {
        return new a(this.f9691a, actionProvider);
    }

    /* JADX INFO: renamed from: fb$d */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    class d extends C1704ew<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f9694b).onMenuItemClick(MenuItemC1710fb.this.m9101a(menuItem));
        }
    }

    /* JADX INFO: renamed from: fb$c */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    class c extends C1704ew<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f9694b).onMenuItemActionExpand(MenuItemC1710fb.this.m9101a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f9694b).onMenuItemActionCollapse(MenuItemC1710fb.this.m9101a(menuItem));
        }
    }

    /* JADX INFO: renamed from: fb$a */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    class a extends android.support.v4.view.ActionProvider {

        /* JADX INFO: renamed from: a */
        final ActionProvider f9762a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f9762a = actionProvider;
        }

        @Override // android.support.v4.view.ActionProvider
        public View onCreateActionView() {
            return this.f9762a.onCreateActionView();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.f9762a.onPerformDefaultAction();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean hasSubMenu() {
            return this.f9762a.hasSubMenu();
        }

        @Override // android.support.v4.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f9762a.onPrepareSubMenu(MenuItemC1710fb.this.m9102a(subMenu));
        }
    }

    /* JADX INFO: renamed from: fb$b */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    static class b extends FrameLayout implements InterfaceC1695en {

        /* JADX INFO: renamed from: a */
        final CollapsibleActionView f9764a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f9764a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // p000.InterfaceC1695en
        /* JADX INFO: renamed from: a */
        public void mo4189a() {
            this.f9764a.onActionViewExpanded();
        }

        @Override // p000.InterfaceC1695en
        /* JADX INFO: renamed from: b */
        public void mo4195b() {
            this.f9764a.onActionViewCollapsed();
        }

        /* JADX INFO: renamed from: c */
        View m9145c() {
            return (View) this.f9764a;
        }
    }
}
