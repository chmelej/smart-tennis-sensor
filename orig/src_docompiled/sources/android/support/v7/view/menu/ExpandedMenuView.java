package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p000.C1766hd;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.InterfaceC0553b, AdapterView.OnItemClickListener, InterfaceC1715fg {

    /* JADX INFO: renamed from: a */
    private static final int[] f3219a = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: b */
    private MenuBuilder f3220b;

    /* JADX INFO: renamed from: c */
    private int f3221c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, f3219a, i, 0);
        if (c1766hdM9601a.m9620g(0)) {
            setBackgroundDrawable(c1766hdM9601a.m9605a(0));
        }
        if (c1766hdM9601a.m9620g(1)) {
            setDivider(c1766hdM9601a.m9605a(1));
        }
        c1766hdM9601a.m9606a();
    }

    @Override // p000.InterfaceC1715fg
    /* JADX INFO: renamed from: a */
    public void mo2430a(MenuBuilder menuBuilder) {
        this.f3220b = menuBuilder;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0553b
    /* JADX INFO: renamed from: a */
    public boolean mo3303a(MenuItemImpl menuItemImpl) {
        return this.f3220b.m3334a(menuItemImpl, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo3303a((MenuItemImpl) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f3221c;
    }
}
