package p000;

import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import p000.InterfaceC1715fg;

/* JADX INFO: renamed from: ez */
/* JADX INFO: compiled from: MenuAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1707ez extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    MenuBuilder f9744a;

    /* JADX INFO: renamed from: b */
    private int f9745b = -1;

    /* JADX INFO: renamed from: c */
    private boolean f9746c;

    /* JADX INFO: renamed from: d */
    private final boolean f9747d;

    /* JADX INFO: renamed from: e */
    private final LayoutInflater f9748e;

    /* JADX INFO: renamed from: f */
    private final int f9749f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1707ez(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.f9747d = z;
        this.f9748e = layoutInflater;
        this.f9744a = menuBuilder;
        this.f9749f = i;
        m9132b();
    }

    /* JADX INFO: renamed from: a */
    public void m9131a(boolean z) {
        this.f9746c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> arrayListM3360m = this.f9747d ? this.f9744a.m3360m() : this.f9744a.m3357j();
        if (this.f9745b < 0) {
            return arrayListM3360m.size();
        }
        return arrayListM3360m.size() - 1;
    }

    /* JADX INFO: renamed from: a */
    public MenuBuilder m9129a() {
        return this.f9744a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> arrayListM3360m = this.f9747d ? this.f9744a.m3360m() : this.f9744a.m3357j();
        if (this.f9745b >= 0 && i >= this.f9745b) {
            i++;
        }
        return arrayListM3360m.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9748e.inflate(this.f9749f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f9744a.mo3341b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        InterfaceC1715fg.a aVar = (InterfaceC1715fg.a) view;
        if (this.f9746c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.mo2423a(getItem(i), 0);
        return view;
    }

    /* JADX INFO: renamed from: b */
    void m9132b() {
        MenuItemImpl menuItemImplM3366s = this.f9744a.m3366s();
        if (menuItemImplM3366s != null) {
            ArrayList<MenuItemImpl> arrayListM3360m = this.f9744a.m3360m();
            int size = arrayListM3360m.size();
            for (int i = 0; i < size; i++) {
                if (arrayListM3360m.get(i) == menuItemImplM3366s) {
                    this.f9745b = i;
                    return;
                }
            }
        }
        this.f9745b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m9132b();
        super.notifyDataSetChanged();
    }
}
