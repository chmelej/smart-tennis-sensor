package p000;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: fd */
/* JADX INFO: compiled from: MenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1712fd implements AdapterView.OnItemClickListener, InterfaceC1714ff, InterfaceC1718fj {

    /* JADX INFO: renamed from: a */
    private Rect f9769a;

    /* JADX INFO: renamed from: a */
    public abstract void mo9113a(int i);

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo9114a(MenuBuilder menuBuilder);

    /* JADX INFO: renamed from: a */
    public abstract void mo9115a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo9116a(PopupWindow.OnDismissListener onDismissListener);

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2443a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public int mo2445b() {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo9117b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo9118b(boolean z);

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public boolean mo2447b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo9119c(int i);

    /* JADX INFO: renamed from: c */
    public abstract void mo9120c(boolean z);

    /* JADX INFO: renamed from: h */
    protected boolean mo9121h() {
        return true;
    }

    AbstractC1712fd() {
    }

    /* JADX INFO: renamed from: a */
    public void m9149a(Rect rect) {
        this.f9769a = rect;
    }

    /* JADX INFO: renamed from: i */
    public Rect m9150i() {
        return this.f9769a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m9147a(listAdapter).f9744a.m3335a((MenuItem) listAdapter.getItem(i), this, mo9121h() ? 0 : 4);
    }

    /* JADX INFO: renamed from: a */
    protected static int m9146a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup frameLayout = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    protected static C1707ez m9147a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C1707ez) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C1707ez) listAdapter;
    }

    /* JADX INFO: renamed from: b */
    protected static boolean m9148b(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
