package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* JADX INFO: renamed from: d */
    private MenuBuilder f3299d;

    /* JADX INFO: renamed from: e */
    private MenuItemImpl f3300e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f3299d = menuBuilder;
        this.f3300e = menuItemImpl;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f3299d.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: c */
    public boolean mo3345c() {
        return this.f3299d.mo3345c();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: d */
    public boolean mo3349d() {
        return this.f3299d.mo3349d();
    }

    /* JADX INFO: renamed from: t */
    public Menu m3393t() {
        return this.f3299d;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f3300e;
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    public void mo3327a(MenuBuilder.InterfaceC0552a interfaceC0552a) {
        this.f3299d.mo3327a(interfaceC0552a);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: q */
    public MenuBuilder mo3364q() {
        return this.f3299d.mo3364q();
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    boolean mo3333a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo3333a(menuBuilder, menuItem) || this.f3299d.mo3333a(menuBuilder, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f3300e.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f3300e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m3321a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m3352e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m3323a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m3347d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m3322a(view);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: c */
    public boolean mo3346c(MenuItemImpl menuItemImpl) {
        return this.f3299d.mo3346c(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: d */
    public boolean mo3350d(MenuItemImpl menuItemImpl) {
        return this.f3299d.mo3350d(menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    public String mo3325a() {
        int itemId = this.f3300e != null ? this.f3300e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo3325a() + ":" + itemId;
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.support.v4.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f3299d.setGroupDividerEnabled(z);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: b */
    public boolean mo3341b() {
        return this.f3299d.mo3341b();
    }
}
