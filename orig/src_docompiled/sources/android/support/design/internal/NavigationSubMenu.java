package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class NavigationSubMenu extends SubMenuBuilder {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, MenuItemImpl menuItemImpl) {
        super(context, navigationMenu, menuItemImpl);
    }

    @Override // android.support.v7.view.menu.MenuBuilder
    /* JADX INFO: renamed from: a */
    public void mo2458a(boolean z) {
        super.mo2458a(z);
        ((MenuBuilder) m3393t()).mo2458a(z);
    }
}
