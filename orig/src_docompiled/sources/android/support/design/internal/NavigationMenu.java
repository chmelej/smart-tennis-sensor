package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo2425a(i, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(m3353f(), this, menuItemImpl);
        menuItemImpl.m3372a(navigationSubMenu);
        return navigationSubMenu;
    }
}
