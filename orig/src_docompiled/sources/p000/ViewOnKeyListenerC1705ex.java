package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: ex */
/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1705ex extends AbstractC1712fd implements View.OnKeyListener, PopupWindow.OnDismissListener, InterfaceC1714ff {

    /* JADX INFO: renamed from: g */
    private static final int f9695g = R.layout.abc_cascading_menu_item_layout;

    /* JADX INFO: renamed from: A */
    private PopupWindow.OnDismissListener f9696A;

    /* JADX INFO: renamed from: a */
    final Handler f9697a;

    /* JADX INFO: renamed from: d */
    View f9700d;

    /* JADX INFO: renamed from: e */
    ViewTreeObserver f9701e;

    /* JADX INFO: renamed from: f */
    boolean f9702f;

    /* JADX INFO: renamed from: h */
    private final Context f9703h;

    /* JADX INFO: renamed from: i */
    private final int f9704i;

    /* JADX INFO: renamed from: j */
    private final int f9705j;

    /* JADX INFO: renamed from: k */
    private final int f9706k;

    /* JADX INFO: renamed from: l */
    private final boolean f9707l;

    /* JADX INFO: renamed from: r */
    private View f9713r;

    /* JADX INFO: renamed from: t */
    private boolean f9715t;

    /* JADX INFO: renamed from: u */
    private boolean f9716u;

    /* JADX INFO: renamed from: v */
    private int f9717v;

    /* JADX INFO: renamed from: w */
    private int f9718w;

    /* JADX INFO: renamed from: y */
    private boolean f9720y;

    /* JADX INFO: renamed from: z */
    private InterfaceC1714ff.a f9721z;

    /* JADX INFO: renamed from: m */
    private final List<MenuBuilder> f9708m = new ArrayList();

    /* JADX INFO: renamed from: b */
    final List<a> f9698b = new ArrayList();

    /* JADX INFO: renamed from: c */
    final ViewTreeObserver.OnGlobalLayoutListener f9699c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ex.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC1705ex.this.mo3693f() || ViewOnKeyListenerC1705ex.this.f9698b.size() <= 0 || ViewOnKeyListenerC1705ex.this.f9698b.get(0).f9729a.m3688c()) {
                return;
            }
            View view = ViewOnKeyListenerC1705ex.this.f9700d;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC1705ex.this.mo3690e();
                return;
            }
            Iterator<a> it = ViewOnKeyListenerC1705ex.this.f9698b.iterator();
            while (it.hasNext()) {
                it.next().f9729a.mo3510d();
            }
        }
    };

    /* JADX INFO: renamed from: n */
    private final View.OnAttachStateChangeListener f9709n = new View.OnAttachStateChangeListener() { // from class: ex.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC1705ex.this.f9701e != null) {
                if (!ViewOnKeyListenerC1705ex.this.f9701e.isAlive()) {
                    ViewOnKeyListenerC1705ex.this.f9701e = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC1705ex.this.f9701e.removeGlobalOnLayoutListener(ViewOnKeyListenerC1705ex.this.f9699c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: o */
    private final InterfaceC1750go f9710o = new InterfaceC1750go() { // from class: ex.3
        @Override // p000.InterfaceC1750go
        /* JADX INFO: renamed from: a */
        public void mo3705a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ViewOnKeyListenerC1705ex.this.f9697a.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // p000.InterfaceC1750go
        /* JADX INFO: renamed from: b */
        public void mo3708b(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            ViewOnKeyListenerC1705ex.this.f9697a.removeCallbacksAndMessages(null);
            int size = ViewOnKeyListenerC1705ex.this.f9698b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == ViewOnKeyListenerC1705ex.this.f9698b.get(i).f9730b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < ViewOnKeyListenerC1705ex.this.f9698b.size() ? ViewOnKeyListenerC1705ex.this.f9698b.get(i2) : null;
            ViewOnKeyListenerC1705ex.this.f9697a.postAtTime(new Runnable() { // from class: ex.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        ViewOnKeyListenerC1705ex.this.f9702f = true;
                        aVar.f9730b.m3340b(false);
                        ViewOnKeyListenerC1705ex.this.f9702f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.m3334a(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }
    };

    /* JADX INFO: renamed from: p */
    private int f9711p = 0;

    /* JADX INFO: renamed from: q */
    private int f9712q = 0;

    /* JADX INFO: renamed from: x */
    private boolean f9719x = false;

    /* JADX INFO: renamed from: s */
    private int f9714s = m9112k();

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2442a() {
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: c */
    public Parcelable mo2448c() {
        return null;
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: h */
    protected boolean mo9121h() {
        return false;
    }

    public ViewOnKeyListenerC1705ex(Context context, View view, int i, int i2, boolean z) {
        this.f9703h = context;
        this.f9713r = view;
        this.f9705j = i;
        this.f9706k = i2;
        this.f9707l = z;
        Resources resources = context.getResources();
        this.f9704i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9697a = new Handler();
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: b */
    public void mo9118b(boolean z) {
        this.f9719x = z;
    }

    /* JADX INFO: renamed from: j */
    private MenuPopupWindow m9111j() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f9703h, null, this.f9705j, this.f9706k);
        menuPopupWindow.m3706a(this.f9710o);
        menuPopupWindow.m3681a((AdapterView.OnItemClickListener) this);
        menuPopupWindow.m3682a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.m3685b(this.f9713r);
        menuPopupWindow.m3691e(this.f9712q);
        menuPopupWindow.m3683a(true);
        menuPopupWindow.m3697h(2);
        return menuPopupWindow;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: d */
    public void mo3510d() {
        if (mo3693f()) {
            return;
        }
        Iterator<MenuBuilder> it = this.f9708m.iterator();
        while (it.hasNext()) {
            m9108c(it.next());
        }
        this.f9708m.clear();
        this.f9700d = this.f9713r;
        if (this.f9700d != null) {
            boolean z = this.f9701e == null;
            this.f9701e = this.f9700d.getViewTreeObserver();
            if (z) {
                this.f9701e.addOnGlobalLayoutListener(this.f9699c);
            }
            this.f9700d.addOnAttachStateChangeListener(this.f9709n);
        }
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: e */
    public void mo3690e() {
        int size = this.f9698b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f9698b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f9729a.mo3693f()) {
                    aVar.f9729a.mo3690e();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo3690e();
        return true;
    }

    /* JADX INFO: renamed from: k */
    private int m9112k() {
        return ViewCompat.getLayoutDirection(this.f9713r) == 1 ? 0 : 1;
    }

    /* JADX INFO: renamed from: d */
    private int m9109d(int i) {
        ListView listViewM9122a = this.f9698b.get(this.f9698b.size() - 1).m9122a();
        int[] iArr = new int[2];
        listViewM9122a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f9700d.getWindowVisibleDisplayFrame(rect);
        return this.f9714s == 1 ? (iArr[0] + listViewM9122a.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9114a(MenuBuilder menuBuilder) {
        menuBuilder.m3331a(this, this.f9703h);
        if (mo3693f()) {
            m9108c(menuBuilder);
        } else {
            this.f9708m.add(menuBuilder);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m9108c(MenuBuilder menuBuilder) {
        a aVar;
        View viewM9107a;
        int i;
        int i2;
        int width;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f9703h);
        C1707ez c1707ez = new C1707ez(menuBuilder, layoutInflaterFrom, this.f9707l, f9695g);
        if (!mo3693f() && this.f9719x) {
            c1707ez.m9131a(true);
        } else if (mo3693f()) {
            c1707ez.m9131a(AbstractC1712fd.m9148b(menuBuilder));
        }
        int iA = m9146a(c1707ez, null, this.f9703h, this.f9704i);
        MenuPopupWindow menuPopupWindowM9111j = m9111j();
        menuPopupWindowM9111j.mo3506a((ListAdapter) c1707ez);
        menuPopupWindowM9111j.m3695g(iA);
        menuPopupWindowM9111j.m3691e(this.f9712q);
        if (this.f9698b.size() > 0) {
            aVar = this.f9698b.get(this.f9698b.size() - 1);
            viewM9107a = m9107a(aVar, menuBuilder);
        } else {
            aVar = null;
            viewM9107a = null;
        }
        if (viewM9107a != null) {
            menuPopupWindowM9111j.m3710c(false);
            menuPopupWindowM9111j.m3707a((Object) null);
            int iM9109d = m9109d(iA);
            boolean z = iM9109d == 1;
            this.f9714s = iM9109d;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowM9111j.m3685b(viewM9107a);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f9713r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewM9107a.getLocationOnScreen(iArr2);
                if ((this.f9712q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f9713r.getWidth();
                    iArr2[0] = iArr2[0] + viewM9107a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f9712q & 5) == 5) {
                width = z ? i + iA : i - viewM9107a.getWidth();
            } else {
                width = z ? i + viewM9107a.getWidth() : i - iA;
            }
            menuPopupWindowM9111j.m3687c(width);
            menuPopupWindowM9111j.m3686b(true);
            menuPopupWindowM9111j.m3689d(i2);
        } else {
            if (this.f9715t) {
                menuPopupWindowM9111j.m3687c(this.f9717v);
            }
            if (this.f9716u) {
                menuPopupWindowM9111j.m3689d(this.f9718w);
            }
            menuPopupWindowM9111j.m3679a(m9150i());
        }
        this.f9698b.add(new a(menuPopupWindowM9111j, menuBuilder, this.f9714s));
        menuPopupWindowM9111j.mo3510d();
        ListView listViewG = menuPopupWindowM9111j.mo3694g();
        listViewG.setOnKeyListener(this);
        if (aVar == null && this.f9720y && menuBuilder.m3361n() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.m3361n());
            listViewG.addHeaderView(frameLayout, null, false);
            menuPopupWindowM9111j.mo3510d();
        }
    }

    /* JADX INFO: renamed from: a */
    private MenuItem m9106a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private View m9107a(a aVar, MenuBuilder menuBuilder) {
        C1707ez c1707ez;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemM9106a = m9106a(aVar.f9730b, menuBuilder);
        if (menuItemM9106a == null) {
            return null;
        }
        ListView listViewM9122a = aVar.m9122a();
        ListAdapter adapter = listViewM9122a.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c1707ez = (C1707ez) headerViewListAdapter.getWrappedAdapter();
        } else {
            c1707ez = (C1707ez) adapter;
            headersCount = 0;
        }
        int count = c1707ez.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemM9106a == c1707ez.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewM9122a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewM9122a.getChildCount()) {
            return listViewM9122a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: f */
    public boolean mo3693f() {
        return this.f9698b.size() > 0 && this.f9698b.get(0).f9729a.mo3693f();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.f9698b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f9698b.get(i);
            if (!aVar.f9729a.mo3693f()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.f9730b.m3340b(false);
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        Iterator<a> it = this.f9698b.iterator();
        while (it.hasNext()) {
            m9147a(it.next().m9122a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
        this.f9721z = aVar;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        for (a aVar : this.f9698b) {
            if (subMenuBuilder == aVar.f9730b) {
                aVar.m9122a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        mo9114a((MenuBuilder) subMenuBuilder);
        if (this.f9721z != null) {
            this.f9721z.mo3279a(subMenuBuilder);
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    private int m9110d(MenuBuilder menuBuilder) {
        int size = this.f9698b.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.f9698b.get(i).f9730b) {
                return i;
            }
        }
        return -1;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        int iM9110d = m9110d(menuBuilder);
        if (iM9110d < 0) {
            return;
        }
        int i = iM9110d + 1;
        if (i < this.f9698b.size()) {
            this.f9698b.get(i).f9730b.m3340b(false);
        }
        a aVarRemove = this.f9698b.remove(iM9110d);
        aVarRemove.f9730b.m3339b(this);
        if (this.f9702f) {
            aVarRemove.f9729a.m3709b((Object) null);
            aVarRemove.f9729a.m3684b(0);
        }
        aVarRemove.f9729a.mo3690e();
        int size = this.f9698b.size();
        if (size > 0) {
            this.f9714s = this.f9698b.get(size - 1).f9731c;
        } else {
            this.f9714s = m9112k();
        }
        if (size != 0) {
            if (z) {
                this.f9698b.get(0).f9730b.m3340b(false);
                return;
            }
            return;
        }
        mo3690e();
        if (this.f9721z != null) {
            this.f9721z.mo3278a(menuBuilder, true);
        }
        if (this.f9701e != null) {
            if (this.f9701e.isAlive()) {
                this.f9701e.removeGlobalOnLayoutListener(this.f9699c);
            }
            this.f9701e = null;
        }
        this.f9700d.removeOnAttachStateChangeListener(this.f9709n);
        this.f9696A.onDismiss();
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9113a(int i) {
        if (this.f9711p != i) {
            this.f9711p = i;
            this.f9712q = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.f9713r));
        }
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9115a(View view) {
        if (this.f9713r != view) {
            this.f9713r = view;
            this.f9712q = GravityCompat.getAbsoluteGravity(this.f9711p, ViewCompat.getLayoutDirection(this.f9713r));
        }
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9116a(PopupWindow.OnDismissListener onDismissListener) {
        this.f9696A = onDismissListener;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: g */
    public ListView mo3694g() {
        if (this.f9698b.isEmpty()) {
            return null;
        }
        return this.f9698b.get(this.f9698b.size() - 1).m9122a();
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: b */
    public void mo9117b(int i) {
        this.f9715t = true;
        this.f9717v = i;
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: c */
    public void mo9119c(int i) {
        this.f9716u = true;
        this.f9718w = i;
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: c */
    public void mo9120c(boolean z) {
        this.f9720y = z;
    }

    /* JADX INFO: renamed from: ex$a */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    static class a {

        /* JADX INFO: renamed from: a */
        public final MenuPopupWindow f9729a;

        /* JADX INFO: renamed from: b */
        public final MenuBuilder f9730b;

        /* JADX INFO: renamed from: c */
        public final int f9731c;

        public a(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f9729a = menuPopupWindow;
            this.f9730b = menuBuilder;
            this.f9731c = i;
        }

        /* JADX INFO: renamed from: a */
        public ListView m9122a() {
            return this.f9729a.mo3694g();
        }
    }
}
