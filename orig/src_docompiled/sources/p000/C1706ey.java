package p000;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import p000.InterfaceC1714ff;
import p000.InterfaceC1715fg;

/* JADX INFO: renamed from: ey */
/* JADX INFO: compiled from: ListMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1706ey implements AdapterView.OnItemClickListener, InterfaceC1714ff {

    /* JADX INFO: renamed from: a */
    Context f9732a;

    /* JADX INFO: renamed from: b */
    LayoutInflater f9733b;

    /* JADX INFO: renamed from: c */
    MenuBuilder f9734c;

    /* JADX INFO: renamed from: d */
    ExpandedMenuView f9735d;

    /* JADX INFO: renamed from: e */
    int f9736e;

    /* JADX INFO: renamed from: f */
    int f9737f;

    /* JADX INFO: renamed from: g */
    int f9738g;

    /* JADX INFO: renamed from: h */
    a f9739h;

    /* JADX INFO: renamed from: i */
    private InterfaceC1714ff.a f9740i;

    /* JADX INFO: renamed from: j */
    private int f9741j;

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2442a() {
        return false;
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

    public C1706ey(Context context, int i) {
        this(i, 0);
        this.f9732a = context;
        this.f9733b = LayoutInflater.from(this.f9732a);
    }

    public C1706ey(int i, int i2) {
        this.f9738g = i;
        this.f9737f = i2;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
        if (this.f9737f != 0) {
            this.f9732a = new ContextThemeWrapper(context, this.f9737f);
            this.f9733b = LayoutInflater.from(this.f9732a);
        } else if (this.f9732a != null) {
            this.f9732a = context;
            if (this.f9733b == null) {
                this.f9733b = LayoutInflater.from(this.f9732a);
            }
        }
        this.f9734c = menuBuilder;
        if (this.f9739h != null) {
            this.f9739h.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC1715fg m9123a(ViewGroup viewGroup) {
        if (this.f9735d == null) {
            this.f9735d = (ExpandedMenuView) this.f9733b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f9739h == null) {
                this.f9739h = new a();
            }
            this.f9735d.setAdapter((ListAdapter) this.f9739h);
            this.f9735d.setOnItemClickListener(this);
        }
        return this.f9735d;
    }

    /* JADX INFO: renamed from: d */
    public ListAdapter m9126d() {
        if (this.f9739h == null) {
            this.f9739h = new a();
        }
        return this.f9739h;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        if (this.f9739h != null) {
            this.f9739h.notifyDataSetChanged();
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
        this.f9740i = aVar;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnClickListenerC1709fa(subMenuBuilder).m9142a((IBinder) null);
        if (this.f9740i == null) {
            return true;
        }
        this.f9740i.mo3279a(subMenuBuilder);
        return true;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        if (this.f9740i != null) {
            this.f9740i.mo3278a(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f9734c.m3335a(this.f9739h.getItem(i), this, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m9124a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        if (this.f9735d != null) {
            this.f9735d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    /* JADX INFO: renamed from: b */
    public void m9125b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f9735d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public int mo2445b() {
        return this.f9741j;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: c */
    public Parcelable mo2448c() {
        if (this.f9735d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m9124a(bundle);
        return bundle;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
        m9125b((Bundle) parcelable);
    }

    /* JADX INFO: renamed from: ey$a */
    /* JADX INFO: compiled from: ListMenuPresenter.java */
    class a extends BaseAdapter {

        /* JADX INFO: renamed from: b */
        private int f9743b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public a() {
            m9128a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = C1706ey.this.f9734c.m3360m().size() - C1706ey.this.f9736e;
            return this.f9743b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> arrayListM3360m = C1706ey.this.f9734c.m3360m();
            int i2 = i + C1706ey.this.f9736e;
            if (this.f9743b >= 0 && i2 >= this.f9743b) {
                i2++;
            }
            return arrayListM3360m.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C1706ey.this.f9733b.inflate(C1706ey.this.f9738g, viewGroup, false);
            }
            ((InterfaceC1715fg.a) view).mo2423a(getItem(i), 0);
            return view;
        }

        /* JADX INFO: renamed from: a */
        void m9128a() {
            MenuItemImpl menuItemImplM3366s = C1706ey.this.f9734c.m3366s();
            if (menuItemImplM3366s != null) {
                ArrayList<MenuItemImpl> arrayListM3360m = C1706ey.this.f9734c.m3360m();
                int size = arrayListM3360m.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListM3360m.get(i) == menuItemImplM3366s) {
                        this.f9743b = i;
                        return;
                    }
                }
            }
            this.f9743b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m9128a();
            super.notifyDataSetChanged();
        }
    }
}
