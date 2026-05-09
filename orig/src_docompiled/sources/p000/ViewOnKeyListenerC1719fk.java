package p000;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.MenuPopupWindow;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: fk */
/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC1719fk extends AbstractC1712fd implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, InterfaceC1714ff {

    /* JADX INFO: renamed from: e */
    private static final int f9783e = R.layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: a */
    final MenuPopupWindow f9784a;

    /* JADX INFO: renamed from: c */
    View f9786c;

    /* JADX INFO: renamed from: d */
    ViewTreeObserver f9787d;

    /* JADX INFO: renamed from: f */
    private final Context f9788f;

    /* JADX INFO: renamed from: g */
    private final MenuBuilder f9789g;

    /* JADX INFO: renamed from: h */
    private final C1707ez f9790h;

    /* JADX INFO: renamed from: i */
    private final boolean f9791i;

    /* JADX INFO: renamed from: j */
    private final int f9792j;

    /* JADX INFO: renamed from: k */
    private final int f9793k;

    /* JADX INFO: renamed from: l */
    private final int f9794l;

    /* JADX INFO: renamed from: n */
    private PopupWindow.OnDismissListener f9796n;

    /* JADX INFO: renamed from: o */
    private View f9797o;

    /* JADX INFO: renamed from: p */
    private InterfaceC1714ff.a f9798p;

    /* JADX INFO: renamed from: q */
    private boolean f9799q;

    /* JADX INFO: renamed from: r */
    private boolean f9800r;

    /* JADX INFO: renamed from: s */
    private int f9801s;

    /* JADX INFO: renamed from: u */
    private boolean f9803u;

    /* JADX INFO: renamed from: b */
    final ViewTreeObserver.OnGlobalLayoutListener f9785b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: fk.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC1719fk.this.mo3693f() || ViewOnKeyListenerC1719fk.this.f9784a.m3688c()) {
                return;
            }
            View view = ViewOnKeyListenerC1719fk.this.f9786c;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC1719fk.this.mo3690e();
            } else {
                ViewOnKeyListenerC1719fk.this.f9784a.mo3510d();
            }
        }
    };

    /* JADX INFO: renamed from: m */
    private final View.OnAttachStateChangeListener f9795m = new View.OnAttachStateChangeListener() { // from class: fk.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC1719fk.this.f9787d != null) {
                if (!ViewOnKeyListenerC1719fk.this.f9787d.isAlive()) {
                    ViewOnKeyListenerC1719fk.this.f9787d = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC1719fk.this.f9787d.removeGlobalOnLayoutListener(ViewOnKeyListenerC1719fk.this.f9785b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: t */
    private int f9802t = 0;

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9114a(MenuBuilder menuBuilder) {
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

    public ViewOnKeyListenerC1719fk(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f9788f = context;
        this.f9789g = menuBuilder;
        this.f9791i = z;
        this.f9790h = new C1707ez(menuBuilder, LayoutInflater.from(context), this.f9791i, f9783e);
        this.f9793k = i;
        this.f9794l = i2;
        Resources resources = context.getResources();
        this.f9792j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9797o = view;
        this.f9784a = new MenuPopupWindow(this.f9788f, null, this.f9793k, this.f9794l);
        menuBuilder.m3331a(this, context);
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: b */
    public void mo9118b(boolean z) {
        this.f9790h.m9131a(z);
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9113a(int i) {
        this.f9802t = i;
    }

    /* JADX INFO: renamed from: j */
    private boolean m9167j() {
        if (mo3693f()) {
            return true;
        }
        if (this.f9799q || this.f9797o == null) {
            return false;
        }
        this.f9786c = this.f9797o;
        this.f9784a.m3682a((PopupWindow.OnDismissListener) this);
        this.f9784a.m3681a((AdapterView.OnItemClickListener) this);
        this.f9784a.m3683a(true);
        View view = this.f9786c;
        boolean z = this.f9787d == null;
        this.f9787d = view.getViewTreeObserver();
        if (z) {
            this.f9787d.addOnGlobalLayoutListener(this.f9785b);
        }
        view.addOnAttachStateChangeListener(this.f9795m);
        this.f9784a.m3685b(view);
        this.f9784a.m3691e(this.f9802t);
        if (!this.f9800r) {
            this.f9801s = m9146a(this.f9790h, null, this.f9788f, this.f9792j);
            this.f9800r = true;
        }
        this.f9784a.m3695g(this.f9801s);
        this.f9784a.m3697h(2);
        this.f9784a.m3679a(m9150i());
        this.f9784a.mo3510d();
        ListView listViewG = this.f9784a.mo3694g();
        listViewG.setOnKeyListener(this);
        if (this.f9803u && this.f9789g.m3361n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f9788f).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f9789g.m3361n());
            }
            frameLayout.setEnabled(false);
            listViewG.addHeaderView(frameLayout, null, false);
        }
        this.f9784a.mo3506a((ListAdapter) this.f9790h);
        this.f9784a.mo3510d();
        return true;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: d */
    public void mo3510d() {
        if (!m9167j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: e */
    public void mo3690e() {
        if (mo3693f()) {
            this.f9784a.mo3690e();
        }
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: f */
    public boolean mo3693f() {
        return !this.f9799q && this.f9784a.mo3693f();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f9799q = true;
        this.f9789g.close();
        if (this.f9787d != null) {
            if (!this.f9787d.isAlive()) {
                this.f9787d = this.f9786c.getViewTreeObserver();
            }
            this.f9787d.removeGlobalOnLayoutListener(this.f9785b);
            this.f9787d = null;
        }
        this.f9786c.removeOnAttachStateChangeListener(this.f9795m);
        if (this.f9796n != null) {
            this.f9796n.onDismiss();
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        this.f9800r = false;
        if (this.f9790h != null) {
            this.f9790h.notifyDataSetChanged();
        }
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
        this.f9798p = aVar;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            C1713fe c1713fe = new C1713fe(this.f9788f, subMenuBuilder, this.f9786c, this.f9791i, this.f9793k, this.f9794l);
            c1713fe.m9157a(this.f9798p);
            c1713fe.m9158a(AbstractC1712fd.m9148b(subMenuBuilder));
            c1713fe.m9156a(this.f9796n);
            this.f9796n = null;
            this.f9789g.m3340b(false);
            int iJ = this.f9784a.m3700j();
            int iK = this.f9784a.m3701k();
            if ((Gravity.getAbsoluteGravity(this.f9802t, ViewCompat.getLayoutDirection(this.f9797o)) & 7) == 5) {
                iJ += this.f9797o.getWidth();
            }
            if (c1713fe.m9159a(iJ, iK)) {
                if (this.f9798p == null) {
                    return true;
                }
                this.f9798p.mo3279a(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f9789g) {
            return;
        }
        mo3690e();
        if (this.f9798p != null) {
            this.f9798p.mo3278a(menuBuilder, z);
        }
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9115a(View view) {
        this.f9797o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo3690e();
        return true;
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: a */
    public void mo9116a(PopupWindow.OnDismissListener onDismissListener) {
        this.f9796n = onDismissListener;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: g */
    public ListView mo3694g() {
        return this.f9784a.mo3694g();
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: b */
    public void mo9117b(int i) {
        this.f9784a.m3687c(i);
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: c */
    public void mo9119c(int i) {
        this.f9784a.m3689d(i);
    }

    @Override // p000.AbstractC1712fd
    /* JADX INFO: renamed from: c */
    public void mo9120c(boolean z) {
        this.f9803u = z;
    }
}
