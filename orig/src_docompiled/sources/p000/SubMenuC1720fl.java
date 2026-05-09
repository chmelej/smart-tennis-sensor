package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: fl */
/* JADX INFO: compiled from: SubMenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
class SubMenuC1720fl extends MenuC1717fi implements SubMenu {
    SubMenuC1720fl(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    /* JADX INFO: renamed from: b */
    public SupportSubMenu m9168b() {
        return (SupportSubMenu) this.f9694b;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        m9168b().setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m9168b().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        m9168b().setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        m9168b().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        m9168b().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        m9168b().clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        m9168b().setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        m9168b().setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m9101a(m9168b().getItem());
    }
}
