package p000;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: ev */
/* JADX INFO: compiled from: BaseMenuWrapper.java */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC1703ev<T> extends C1704ew<T> {

    /* JADX INFO: renamed from: a */
    final Context f9691a;

    /* JADX INFO: renamed from: c */
    private Map<SupportMenuItem, MenuItem> f9692c;

    /* JADX INFO: renamed from: d */
    private Map<SupportSubMenu, SubMenu> f9693d;

    AbstractC1703ev(Context context, T t) {
        super(t);
        this.f9691a = context;
    }

    /* JADX INFO: renamed from: a */
    final MenuItem m9101a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f9692c == null) {
            this.f9692c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f9692c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemM9165a = C1716fh.m9165a(this.f9691a, supportMenuItem);
        this.f9692c.put(supportMenuItem, menuItemM9165a);
        return menuItemM9165a;
    }

    /* JADX INFO: renamed from: a */
    final SubMenu m9102a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f9693d == null) {
            this.f9693d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f9693d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuM9166a = C1716fh.m9166a(this.f9691a, supportSubMenu);
        this.f9693d.put(supportSubMenu, subMenuM9166a);
        return subMenuM9166a;
    }

    /* JADX INFO: renamed from: a */
    final void m9103a() {
        if (this.f9692c != null) {
            this.f9692c.clear();
        }
        if (this.f9693d != null) {
            this.f9693d.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m9104a(int i) {
        if (this.f9692c == null) {
            return;
        }
        Iterator<SupportMenuItem> it = this.f9692c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    final void m9105b(int i) {
        if (this.f9692c == null) {
            return;
        }
        Iterator<SupportMenuItem> it = this.f9692c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
