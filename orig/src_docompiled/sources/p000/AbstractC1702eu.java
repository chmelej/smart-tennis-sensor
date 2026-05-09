package p000;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import p000.InterfaceC1714ff;
import p000.InterfaceC1715fg;

/* JADX INFO: renamed from: eu */
/* JADX INFO: compiled from: BaseMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1702eu implements InterfaceC1714ff {

    /* JADX INFO: renamed from: a */
    protected Context f9681a;

    /* JADX INFO: renamed from: b */
    protected Context f9682b;

    /* JADX INFO: renamed from: c */
    protected MenuBuilder f9683c;

    /* JADX INFO: renamed from: d */
    protected LayoutInflater f9684d;

    /* JADX INFO: renamed from: e */
    protected LayoutInflater f9685e;

    /* JADX INFO: renamed from: f */
    protected InterfaceC1715fg f9686f;

    /* JADX INFO: renamed from: g */
    private InterfaceC1714ff.a f9687g;

    /* JADX INFO: renamed from: h */
    private int f9688h;

    /* JADX INFO: renamed from: i */
    private int f9689i;

    /* JADX INFO: renamed from: j */
    private int f9690j;

    /* JADX INFO: renamed from: a */
    public abstract void mo3446a(MenuItemImpl menuItemImpl, InterfaceC1715fg.a aVar);

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2442a() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3448a(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2443a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public boolean mo2447b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public AbstractC1702eu(Context context, int i, int i2) {
        this.f9681a = context;
        this.f9684d = LayoutInflater.from(context);
        this.f9688h = i;
        this.f9689i = i2;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
        this.f9682b = context;
        this.f9685e = LayoutInflater.from(this.f9682b);
        this.f9683c = menuBuilder;
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC1715fg mo3443a(ViewGroup viewGroup) {
        if (this.f9686f == null) {
            this.f9686f = (InterfaceC1715fg) this.f9684d.inflate(this.f9688h, viewGroup, false);
            this.f9686f.mo2430a(this.f9683c);
            mo2441a(true);
        }
        return this.f9686f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f9686f;
        if (viewGroup == null) {
            return;
        }
        int i = 0;
        if (this.f9683c != null) {
            this.f9683c.m3358k();
            ArrayList<MenuItemImpl> arrayListM3357j = this.f9683c.m3357j();
            int size = arrayListM3357j.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = arrayListM3357j.get(i3);
                if (mo3448a(i2, menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i2);
                    MenuItemImpl itemData = childAt instanceof InterfaceC1715fg.a ? ((InterfaceC1715fg.a) childAt).getItemData() : null;
                    View viewMo3442a = mo3442a(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        viewMo3442a.setPressed(false);
                        viewMo3442a.jumpDrawablesToCurrentState();
                    }
                    if (viewMo3442a != childAt) {
                        m9098a(viewMo3442a, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!mo3449a(viewGroup, i)) {
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m9098a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f9686f).addView(view, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3449a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
        this.f9687g = aVar;
    }

    /* JADX INFO: renamed from: d */
    public InterfaceC1714ff.a m9100d() {
        return this.f9687g;
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC1715fg.a m9099b(ViewGroup viewGroup) {
        return (InterfaceC1715fg.a) this.f9684d.inflate(this.f9689i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public View mo3442a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        InterfaceC1715fg.a aVarM9099b;
        if (view instanceof InterfaceC1715fg.a) {
            aVarM9099b = (InterfaceC1715fg.a) view;
        } else {
            aVarM9099b = m9099b(viewGroup);
        }
        mo3446a(menuItemImpl, aVarM9099b);
        return (View) aVarM9099b;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        if (this.f9687g != null) {
            this.f9687g.mo3278a(menuBuilder, z);
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        if (this.f9687g != null) {
            return this.f9687g.mo3279a(subMenuBuilder);
        }
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public int mo2445b() {
        return this.f9690j;
    }

    /* JADX INFO: renamed from: a */
    public void m9097a(int i) {
        this.f9690j = i;
    }
}
