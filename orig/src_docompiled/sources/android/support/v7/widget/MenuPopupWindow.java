package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p000.C1707ez;
import p000.C1744gi;
import p000.InterfaceC1750go;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements InterfaceC1750go {

    /* JADX INFO: renamed from: a */
    private static Method f3631a;

    /* JADX INFO: renamed from: b */
    private InterfaceC1750go f3632b;

    static {
        try {
            f3631a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.ListPopupWindow
    /* JADX INFO: renamed from: a */
    C1744gi mo3677a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    /* JADX INFO: renamed from: a */
    public void m3707a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f3605g.setEnterTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3709b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f3605g.setExitTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3706a(InterfaceC1750go interfaceC1750go) {
        this.f3632b = interfaceC1750go;
    }

    /* JADX INFO: renamed from: c */
    public void m3710c(boolean z) {
        if (f3631a != null) {
            try {
                f3631a.invoke(this.f3605g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // p000.InterfaceC1750go
    /* JADX INFO: renamed from: b */
    public void mo3708b(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f3632b != null) {
            this.f3632b.mo3708b(menuBuilder, menuItem);
        }
    }

    @Override // p000.InterfaceC1750go
    /* JADX INFO: renamed from: a */
    public void mo3705a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f3632b != null) {
            this.f3632b.mo3705a(menuBuilder, menuItem);
        }
    }

    public static class MenuDropDownListView extends C1744gi {

        /* JADX INFO: renamed from: b */
        final int f3633b;

        /* JADX INFO: renamed from: c */
        final int f3634c;

        /* JADX INFO: renamed from: d */
        private InterfaceC1750go f3635d;

        /* JADX INFO: renamed from: e */
        private MenuItem f3636e;

        @Override // p000.C1744gi
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ int mo3711a(int i, int i2, int i3, int i4, int i5) {
            return super.mo3711a(i, i2, i3, i4, i5);
        }

        @Override // p000.C1744gi
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo3712a(MotionEvent motionEvent, int i) {
            return super.mo3712a(motionEvent, i);
        }

        @Override // p000.C1744gi, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // p000.C1744gi, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // p000.C1744gi, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // p000.C1744gi, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // p000.C1744gi, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // p000.C1744gi, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f3633b = 21;
                this.f3634c = 22;
            } else {
                this.f3633b = 22;
                this.f3634c = 21;
            }
        }

        public void setHoverListener(InterfaceC1750go interfaceC1750go) {
            this.f3635d = interfaceC1750go;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f3633b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.f3634c) {
                setSelection(-1);
                ((C1707ez) getAdapter()).m9129a().m3340b(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // p000.C1744gi, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            C1707ez c1707ez;
            int iPointToPosition;
            int i;
            if (this.f3635d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c1707ez = (C1707ez) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c1707ez = (C1707ez) adapter;
                }
                MenuItemImpl item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < c1707ez.getCount()) {
                    item = c1707ez.getItem(i);
                }
                MenuItem menuItem = this.f3636e;
                if (menuItem != item) {
                    MenuBuilder menuBuilderM9129a = c1707ez.m9129a();
                    if (menuItem != null) {
                        this.f3635d.mo3705a(menuBuilderM9129a, menuItem);
                    }
                    this.f3636e = item;
                    if (item != null) {
                        this.f3635d.mo3708b(menuBuilderM9129a, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
