package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: ar */
/* JADX INFO: compiled from: NavigationMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class C0739ar implements InterfaceC1714ff {

    /* JADX INFO: renamed from: a */
    LinearLayout f4805a;

    /* JADX INFO: renamed from: b */
    MenuBuilder f4806b;

    /* JADX INFO: renamed from: c */
    b f4807c;

    /* JADX INFO: renamed from: d */
    LayoutInflater f4808d;

    /* JADX INFO: renamed from: e */
    int f4809e;

    /* JADX INFO: renamed from: f */
    boolean f4810f;

    /* JADX INFO: renamed from: g */
    ColorStateList f4811g;

    /* JADX INFO: renamed from: h */
    ColorStateList f4812h;

    /* JADX INFO: renamed from: i */
    Drawable f4813i;

    /* JADX INFO: renamed from: j */
    int f4814j;

    /* JADX INFO: renamed from: k */
    int f4815k;

    /* JADX INFO: renamed from: l */
    int f4816l;

    /* JADX INFO: renamed from: m */
    final View.OnClickListener f4817m = new View.OnClickListener() { // from class: ar.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0739ar.this.m5199b(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            boolean zM3335a = C0739ar.this.f4806b.m3335a(itemData, C0739ar.this, 0);
            if (itemData != null && itemData.isCheckable() && zM3335a) {
                C0739ar.this.f4807c.m5214a(itemData);
            }
            C0739ar.this.m5199b(false);
            C0739ar.this.mo2441a(false);
        }
    };

    /* JADX INFO: renamed from: n */
    private NavigationMenuView f4818n;

    /* JADX INFO: renamed from: o */
    private InterfaceC1714ff.a f4819o;

    /* JADX INFO: renamed from: p */
    private int f4820p;

    /* JADX INFO: renamed from: q */
    private int f4821q;

    /* JADX INFO: renamed from: ar$d */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    interface d {
    }

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
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public boolean mo2447b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
        this.f4808d = LayoutInflater.from(context);
        this.f4806b = menuBuilder;
        this.f4816l = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC1715fg m5190a(ViewGroup viewGroup) {
        if (this.f4818n == null) {
            this.f4818n = (NavigationMenuView) this.f4808d.inflate(R.layout.design_navigation_menu, viewGroup, false);
            if (this.f4807c == null) {
                this.f4807c = new b();
            }
            this.f4805a = (LinearLayout) this.f4808d.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f4818n, false);
            this.f4818n.setAdapter(this.f4807c);
        }
        return this.f4818n;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        if (this.f4807c != null) {
            this.f4807c.m5218b();
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
        this.f4819o = aVar;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        if (this.f4819o != null) {
            this.f4819o.mo3278a(menuBuilder, z);
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public int mo2445b() {
        return this.f4820p;
    }

    /* JADX INFO: renamed from: a */
    public void m5191a(int i2) {
        this.f4820p = i2;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: c */
    public Parcelable mo2448c() {
        Bundle bundle = new Bundle();
        if (this.f4818n != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.f4818n.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f4807c != null) {
            bundle.putBundle("android:menu:adapter", this.f4807c.m5220d());
        }
        if (this.f4805a != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f4805a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f4818n.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f4807c.m5213a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f4805a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5195a(MenuItemImpl menuItemImpl) {
        this.f4807c.m5214a(menuItemImpl);
    }

    /* JADX INFO: renamed from: d */
    public MenuItemImpl m5201d() {
        return this.f4807c.m5219c();
    }

    /* JADX INFO: renamed from: b */
    public View m5197b(int i2) {
        View viewInflate = this.f4808d.inflate(i2, (ViewGroup) this.f4805a, false);
        m5196a(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public void m5196a(View view) {
        this.f4805a.addView(view);
        this.f4818n.setPadding(0, 0, 0, this.f4818n.getPaddingBottom());
    }

    /* JADX INFO: renamed from: e */
    public int m5203e() {
        return this.f4805a.getChildCount();
    }

    /* JADX INFO: renamed from: f */
    public ColorStateList m5205f() {
        return this.f4812h;
    }

    /* JADX INFO: renamed from: a */
    public void m5192a(ColorStateList colorStateList) {
        this.f4812h = colorStateList;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: g */
    public ColorStateList m5206g() {
        return this.f4811g;
    }

    /* JADX INFO: renamed from: b */
    public void m5198b(ColorStateList colorStateList) {
        this.f4811g = colorStateList;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: c */
    public void m5200c(int i2) {
        this.f4809e = i2;
        this.f4810f = true;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: h */
    public Drawable m5207h() {
        return this.f4813i;
    }

    /* JADX INFO: renamed from: a */
    public void m5193a(Drawable drawable) {
        this.f4813i = drawable;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: i */
    public int m5208i() {
        return this.f4814j;
    }

    /* JADX INFO: renamed from: d */
    public void m5202d(int i2) {
        this.f4814j = i2;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: j */
    public int m5209j() {
        return this.f4815k;
    }

    /* JADX INFO: renamed from: e */
    public void m5204e(int i2) {
        this.f4815k = i2;
        mo2441a(false);
    }

    /* JADX INFO: renamed from: b */
    public void m5199b(boolean z) {
        if (this.f4807c != null) {
            this.f4807c.m5217a(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5194a(WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.f4821q != systemWindowInsetTop) {
            this.f4821q = systemWindowInsetTop;
            if (this.f4805a.getChildCount() == 0) {
                this.f4818n.setPadding(0, this.f4821q, 0, this.f4818n.getPaddingBottom());
            }
        }
        ViewCompat.dispatchApplyWindowInsets(this.f4805a, windowInsetsCompat);
    }

    /* JADX INFO: renamed from: ar$j */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static abstract class j extends RecyclerView.AbstractC0624v {
        public j(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: ar$g */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.f3823a.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: renamed from: ar$i */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: ar$h */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: ar$a */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: ar$b */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    class b extends RecyclerView.AbstractC0603a<j> {

        /* JADX INFO: renamed from: b */
        private final ArrayList<d> f4824b = new ArrayList<>();

        /* JADX INFO: renamed from: c */
        private MenuItemImpl f4825c;

        /* JADX INFO: renamed from: d */
        private boolean f4826d;

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: a */
        public long mo3864a(int i) {
            return i;
        }

        b() {
            m5211g();
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: a */
        public int mo3863a() {
            return this.f4824b.size();
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: b */
        public int mo3870b(int i) {
            d dVar = this.f4824b.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).m5223a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j mo3871b(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(C0739ar.this.f4808d, viewGroup, C0739ar.this.f4817m);
                case 1:
                    return new i(C0739ar.this.f4808d, viewGroup);
                case 2:
                    return new h(C0739ar.this.f4808d, viewGroup);
                case 3:
                    return new a(C0739ar.this.f4805a);
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo3867a(j jVar, int i) {
            switch (mo3870b(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.f3823a;
                    navigationMenuItemView.setIconTintList(C0739ar.this.f4812h);
                    if (C0739ar.this.f4810f) {
                        navigationMenuItemView.setTextAppearance(C0739ar.this.f4809e);
                    }
                    if (C0739ar.this.f4811g != null) {
                        navigationMenuItemView.setTextColor(C0739ar.this.f4811g);
                    }
                    ViewCompat.setBackground(navigationMenuItemView, C0739ar.this.f4813i != null ? C0739ar.this.f4813i.getConstantState().newDrawable() : null);
                    f fVar = (f) this.f4824b.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.f4829a);
                    navigationMenuItemView.setHorizontalPadding(C0739ar.this.f4814j);
                    navigationMenuItemView.setIconPadding(C0739ar.this.f4815k);
                    navigationMenuItemView.mo2423a(fVar.m5223a(), 0);
                    break;
                case 1:
                    ((TextView) jVar.f3823a).setText(((f) this.f4824b.get(i)).m5223a().getTitle());
                    break;
                case 2:
                    e eVar = (e) this.f4824b.get(i);
                    jVar.f3823a.setPadding(0, eVar.m5221a(), 0, eVar.m5222b());
                    break;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo3866a(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.f3823a).m2457b();
            }
        }

        /* JADX INFO: renamed from: b */
        public void m5218b() {
            m5211g();
            m3880f();
        }

        /* JADX INFO: renamed from: g */
        private void m5211g() {
            if (this.f4826d) {
                return;
            }
            this.f4826d = true;
            this.f4824b.clear();
            this.f4824b.add(new c());
            int size = C0739ar.this.f4806b.m3357j().size();
            int i = -1;
            boolean z = false;
            int size2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = C0739ar.this.f4806b.m3357j().get(i2);
                if (menuItemImpl.isChecked()) {
                    m5214a(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.m3374a(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.f4824b.add(new e(C0739ar.this.f4816l, 0));
                        }
                        this.f4824b.add(new f(menuItemImpl));
                        int size3 = this.f4824b.size();
                        int size4 = subMenu.size();
                        boolean z2 = false;
                        for (int i3 = 0; i3 < size4; i3++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i3);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.m3374a(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    m5214a(menuItemImpl);
                                }
                                this.f4824b.add(new f(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            m5210a(size3, this.f4824b.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        size2 = this.f4824b.size();
                        boolean z3 = menuItemImpl.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            this.f4824b.add(new e(C0739ar.this.f4816l, C0739ar.this.f4816l));
                        }
                        z = z3;
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        m5210a(size2, this.f4824b.size());
                        z = true;
                    }
                    f fVar = new f(menuItemImpl);
                    fVar.f4829a = z;
                    this.f4824b.add(fVar);
                    i = groupId;
                }
            }
            this.f4826d = false;
        }

        /* JADX INFO: renamed from: a */
        private void m5210a(int i, int i2) {
            while (i < i2) {
                ((f) this.f4824b.get(i)).f4829a = true;
                i++;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m5214a(MenuItemImpl menuItemImpl) {
            if (this.f4825c == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            if (this.f4825c != null) {
                this.f4825c.setChecked(false);
            }
            this.f4825c = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        /* JADX INFO: renamed from: c */
        public MenuItemImpl m5219c() {
            return this.f4825c;
        }

        /* JADX INFO: renamed from: d */
        public Bundle m5220d() {
            Bundle bundle = new Bundle();
            if (this.f4825c != null) {
                bundle.putInt("android:menu:checked", this.f4825c.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f4824b.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.f4824b.get(i);
                if (dVar instanceof f) {
                    MenuItemImpl menuItemImplM5223a = ((f) dVar).m5223a();
                    View actionView = menuItemImplM5223a != null ? menuItemImplM5223a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItemImplM5223a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        public void m5213a(Bundle bundle) {
            MenuItemImpl menuItemImplM5223a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItemImplM5223a2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f4826d = true;
                int size = this.f4824b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.f4824b.get(i2);
                    if ((dVar instanceof f) && (menuItemImplM5223a2 = ((f) dVar).m5223a()) != null && menuItemImplM5223a2.getItemId() == i) {
                        m5214a(menuItemImplM5223a2);
                        break;
                    }
                    i2++;
                }
                this.f4826d = false;
                m5211g();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f4824b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.f4824b.get(i3);
                    if ((dVar2 instanceof f) && (menuItemImplM5223a = ((f) dVar2).m5223a()) != null && (actionView = menuItemImplM5223a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItemImplM5223a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m5217a(boolean z) {
            this.f4826d = z;
        }
    }

    /* JADX INFO: renamed from: ar$f */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class f implements d {

        /* JADX INFO: renamed from: a */
        boolean f4829a;

        /* JADX INFO: renamed from: b */
        private final MenuItemImpl f4830b;

        f(MenuItemImpl menuItemImpl) {
            this.f4830b = menuItemImpl;
        }

        /* JADX INFO: renamed from: a */
        public MenuItemImpl m5223a() {
            return this.f4830b;
        }
    }

    /* JADX INFO: renamed from: ar$e */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class e implements d {

        /* JADX INFO: renamed from: a */
        private final int f4827a;

        /* JADX INFO: renamed from: b */
        private final int f4828b;

        public e(int i, int i2) {
            this.f4827a = i;
            this.f4828b = i2;
        }

        /* JADX INFO: renamed from: a */
        public int m5221a() {
            return this.f4827a;
        }

        /* JADX INFO: renamed from: b */
        public int m5222b() {
            return this.f4828b;
        }
    }

    /* JADX INFO: renamed from: ar$c */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    static class c implements d {
        c() {
        }
    }
}
