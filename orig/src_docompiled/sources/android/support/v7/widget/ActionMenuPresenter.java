package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import p000.AbstractC1702eu;
import p000.AbstractViewOnAttachStateChangeListenerC1747gl;
import p000.C1693el;
import p000.C1713fe;
import p000.C1768hf;
import p000.InterfaceC1714ff;
import p000.InterfaceC1715fg;
import p000.InterfaceC1718fj;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter extends AbstractC1702eu implements ActionProvider.SubUiVisibilityListener {

    /* JADX INFO: renamed from: A */
    private C0562b f3366A;

    /* JADX INFO: renamed from: g */
    C0564d f3367g;

    /* JADX INFO: renamed from: h */
    C0565e f3368h;

    /* JADX INFO: renamed from: i */
    C0561a f3369i;

    /* JADX INFO: renamed from: j */
    RunnableC0563c f3370j;

    /* JADX INFO: renamed from: k */
    final C0566f f3371k;

    /* JADX INFO: renamed from: l */
    int f3372l;

    /* JADX INFO: renamed from: m */
    private Drawable f3373m;

    /* JADX INFO: renamed from: n */
    private boolean f3374n;

    /* JADX INFO: renamed from: o */
    private boolean f3375o;

    /* JADX INFO: renamed from: p */
    private boolean f3376p;

    /* JADX INFO: renamed from: q */
    private int f3377q;

    /* JADX INFO: renamed from: r */
    private int f3378r;

    /* JADX INFO: renamed from: s */
    private int f3379s;

    /* JADX INFO: renamed from: t */
    private boolean f3380t;

    /* JADX INFO: renamed from: u */
    private boolean f3381u;

    /* JADX INFO: renamed from: v */
    private boolean f3382v;

    /* JADX INFO: renamed from: w */
    private boolean f3383w;

    /* JADX INFO: renamed from: x */
    private int f3384x;

    /* JADX INFO: renamed from: y */
    private final SparseBooleanArray f3385y;

    /* JADX INFO: renamed from: z */
    private View f3386z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f3385y = new SparseBooleanArray();
        this.f3371k = new C0566f();
    }

    @Override // p000.AbstractC1702eu, p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
        super.mo2436a(context, menuBuilder);
        Resources resources = context.getResources();
        C1693el c1693elM9059a = C1693el.m9059a(context);
        if (!this.f3376p) {
            this.f3375o = c1693elM9059a.m9061b();
        }
        if (!this.f3382v) {
            this.f3377q = c1693elM9059a.m9062c();
        }
        if (!this.f3380t) {
            this.f3379s = c1693elM9059a.m9060a();
        }
        int measuredWidth = this.f3377q;
        if (this.f3375o) {
            if (this.f3367g == null) {
                this.f3367g = new C0564d(this.f9681a);
                if (this.f3374n) {
                    this.f3367g.setImageDrawable(this.f3373m);
                    this.f3373m = null;
                    this.f3374n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3367g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f3367g.getMeasuredWidth();
        } else {
            this.f3367g = null;
        }
        this.f3378r = measuredWidth;
        this.f3384x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f3386z = null;
    }

    /* JADX INFO: renamed from: a */
    public void m3444a(Configuration configuration) {
        if (!this.f3380t) {
            this.f3379s = C1693el.m9059a(this.f9682b).m9060a();
        }
        if (this.f9683c != null) {
            this.f9683c.mo2458a(true);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3450b(boolean z) {
        this.f3375o = z;
        this.f3376p = true;
    }

    /* JADX INFO: renamed from: c */
    public void m3451c(boolean z) {
        this.f3383w = z;
    }

    /* JADX INFO: renamed from: a */
    public void m3445a(Drawable drawable) {
        if (this.f3367g != null) {
            this.f3367g.setImageDrawable(drawable);
        } else {
            this.f3374n = true;
            this.f3373m = drawable;
        }
    }

    /* JADX INFO: renamed from: e */
    public Drawable m3452e() {
        if (this.f3367g != null) {
            return this.f3367g.getDrawable();
        }
        if (this.f3374n) {
            return this.f3373m;
        }
        return null;
    }

    @Override // p000.AbstractC1702eu
    /* JADX INFO: renamed from: a */
    public InterfaceC1715fg mo3443a(ViewGroup viewGroup) {
        InterfaceC1715fg interfaceC1715fg = this.f9686f;
        InterfaceC1715fg interfaceC1715fgMo3443a = super.mo3443a(viewGroup);
        if (interfaceC1715fg != interfaceC1715fgMo3443a) {
            ((ActionMenuView) interfaceC1715fgMo3443a).setPresenter(this);
        }
        return interfaceC1715fgMo3443a;
    }

    @Override // p000.AbstractC1702eu
    /* JADX INFO: renamed from: a */
    public View mo3442a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m3392m()) {
            actionView = super.mo3442a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // p000.AbstractC1702eu
    /* JADX INFO: renamed from: a */
    public void mo3446a(MenuItemImpl menuItemImpl, InterfaceC1715fg.a aVar) {
        aVar.mo2423a(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f9686f);
        if (this.f3366A == null) {
            this.f3366A = new C0562b();
        }
        actionMenuItemView.setPopupCallback(this.f3366A);
    }

    @Override // p000.AbstractC1702eu
    /* JADX INFO: renamed from: a */
    public boolean mo3448a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.m3388i();
    }

    @Override // p000.AbstractC1702eu, p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        super.mo2441a(z);
        ((View) this.f9686f).requestLayout();
        boolean z2 = false;
        if (this.f9683c != null) {
            ArrayList<MenuItemImpl> arrayListM3359l = this.f9683c.m3359l();
            int size = arrayListM3359l.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = arrayListM3359l.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> arrayListM3360m = this.f9683c != null ? this.f9683c.m3360m() : null;
        if (this.f3375o && arrayListM3360m != null) {
            int size2 = arrayListM3360m.size();
            if (size2 == 1) {
                z2 = !arrayListM3360m.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f3367g == null) {
                this.f3367g = new C0564d(this.f9681a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f3367g.getParent();
            if (viewGroup != this.f9686f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f3367g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f9686f;
                actionMenuView.addView(this.f3367g, actionMenuView.m3472c());
            }
        } else if (this.f3367g != null && this.f3367g.getParent() == this.f9686f) {
            ((ViewGroup) this.f9686f).removeView(this.f3367g);
        }
        ((ActionMenuView) this.f9686f).setOverflowReserved(this.f3375o);
    }

    @Override // p000.AbstractC1702eu
    /* JADX INFO: renamed from: a */
    public boolean mo3449a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f3367g) {
            return false;
        }
        return super.mo3449a(viewGroup, i);
    }

    @Override // p000.AbstractC1702eu, p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2444a(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.m3393t() != this.f9683c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.m3393t();
        }
        View viewM3436a = m3436a(subMenuBuilder2.getItem());
        if (viewM3436a == null) {
            return false;
        }
        this.f3372l = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f3369i = new C0561a(this.f9682b, subMenuBuilder, viewM3436a);
        this.f3369i.m9158a(z);
        this.f3369i.m9153a();
        super.mo2444a(subMenuBuilder);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private View m3436a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f9686f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof InterfaceC1715fg.a) && ((InterfaceC1715fg.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3453f() {
        if (!this.f3375o || m3457j() || this.f9683c == null || this.f9686f == null || this.f3370j != null || this.f9683c.m3360m().isEmpty()) {
            return false;
        }
        this.f3370j = new RunnableC0563c(new C0565e(this.f9682b, this.f9683c, this.f3367g, true));
        ((View) this.f9686f).post(this.f3370j);
        super.mo2444a((SubMenuBuilder) null);
        return true;
    }

    /* JADX INFO: renamed from: g */
    public boolean m3454g() {
        if (this.f3370j != null && this.f9686f != null) {
            ((View) this.f9686f).removeCallbacks(this.f3370j);
            this.f3370j = null;
            return true;
        }
        C0565e c0565e = this.f3368h;
        if (c0565e == null) {
            return false;
        }
        c0565e.m9162d();
        return true;
    }

    /* JADX INFO: renamed from: h */
    public boolean m3455h() {
        return m3454g() | m3456i();
    }

    /* JADX INFO: renamed from: i */
    public boolean m3456i() {
        if (this.f3369i == null) {
            return false;
        }
        this.f3369i.m9162d();
        return true;
    }

    /* JADX INFO: renamed from: j */
    public boolean m3457j() {
        return this.f3368h != null && this.f3368h.m9163f();
    }

    /* JADX INFO: renamed from: k */
    public boolean m3458k() {
        return this.f3370j != null || m3457j();
    }

    @Override // p000.AbstractC1702eu, p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public boolean mo2442a() {
        ArrayList<MenuItemImpl> arrayListM3357j;
        int size;
        int iM3463a;
        int i;
        int i2;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        int i3 = 0;
        if (actionMenuPresenter.f9683c != null) {
            arrayListM3357j = actionMenuPresenter.f9683c.m3357j();
            size = arrayListM3357j.size();
        } else {
            arrayListM3357j = null;
            size = 0;
        }
        int i4 = actionMenuPresenter.f3379s;
        int i5 = actionMenuPresenter.f3378r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f9686f;
        int i6 = i4;
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = arrayListM3357j.get(i9);
            if (menuItemImpl.m3390k()) {
                i7++;
            } else if (menuItemImpl.m3389j()) {
                i8++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.f3383w && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (actionMenuPresenter.f3375o && (z2 || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f3385y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f3381u) {
            iM3463a = i5 / actionMenuPresenter.f3384x;
            i = ((i5 % actionMenuPresenter.f3384x) / iM3463a) + actionMenuPresenter.f3384x;
        } else {
            iM3463a = 0;
            i = 0;
        }
        int i11 = i5;
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            MenuItemImpl menuItemImpl2 = arrayListM3357j.get(i12);
            if (menuItemImpl2.m3390k()) {
                View viewMo3442a = actionMenuPresenter.mo3442a(menuItemImpl2, actionMenuPresenter.f3386z, viewGroup);
                if (actionMenuPresenter.f3386z == null) {
                    actionMenuPresenter.f3386z = viewMo3442a;
                }
                if (actionMenuPresenter.f3381u) {
                    iM3463a -= ActionMenuView.m3463a(viewMo3442a, i, iM3463a, iMakeMeasureSpec, i3);
                } else {
                    viewMo3442a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo3442a.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                menuItemImpl2.m3382d(z);
                i2 = size;
            } else if (menuItemImpl2.m3389j()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i11 > 0 && (!actionMenuPresenter.f3381u || iM3463a > 0);
                if (z4) {
                    boolean z5 = z4;
                    View viewMo3442a2 = actionMenuPresenter.mo3442a(menuItemImpl2, actionMenuPresenter.f3386z, viewGroup);
                    i2 = size;
                    if (actionMenuPresenter.f3386z == null) {
                        actionMenuPresenter.f3386z = viewMo3442a2;
                    }
                    if (actionMenuPresenter.f3381u) {
                        int iM3463a2 = ActionMenuView.m3463a(viewMo3442a2, i, iM3463a, iMakeMeasureSpec, 0);
                        iM3463a -= iM3463a2;
                        if (iM3463a2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewMo3442a2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewMo3442a2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = actionMenuPresenter.f3381u ? z5 & (i11 >= 0) : z5 & (i11 + i13 > 0);
                } else {
                    i2 = size;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        MenuItemImpl menuItemImpl3 = arrayListM3357j.get(i14);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.m3388i()) {
                                i10++;
                            }
                            menuItemImpl3.m3382d(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                menuItemImpl2.m3382d(z4);
            } else {
                i2 = size;
                menuItemImpl2.m3382d(false);
                i12++;
                size = i2;
                actionMenuPresenter = this;
                i3 = 0;
            }
            i12++;
            size = i2;
            actionMenuPresenter = this;
            i3 = 0;
        }
        return true;
    }

    @Override // p000.AbstractC1702eu, p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
        m3455h();
        super.mo2439a(menuBuilder, z);
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: c */
    public Parcelable mo2448c() {
        SavedState savedState = new SavedState();
        savedState.f3387a = this.f3372l;
        return savedState;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f3387a <= 0 || (menuItemFindItem = this.f9683c.findItem(savedState.f3387a)) == null) {
                return;
            }
            mo2444a((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    @Override // android.support.v4.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.mo2444a((SubMenuBuilder) null);
        } else if (this.f9683c != null) {
            this.f9683c.m3340b(false);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3447a(ActionMenuView actionMenuView) {
        this.f9686f = actionMenuView;
        actionMenuView.mo2430a(this.f9683c);
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        public int f3387a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3387a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3387a);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$d */
    class C0564d extends AppCompatImageView implements ActionMenuView.InterfaceC0567a {

        /* JADX INFO: renamed from: b */
        private final float[] f3393b;

        @Override // android.support.v7.widget.ActionMenuView.InterfaceC0567a
        /* JADX INFO: renamed from: c */
        public boolean mo3298c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.InterfaceC0567a
        /* JADX INFO: renamed from: d */
        public boolean mo3299d() {
            return false;
        }

        public C0564d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.f3393b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C1768hf.m9634a(this, getContentDescription());
            setOnTouchListener(new AbstractViewOnAttachStateChangeListenerC1747gl(this) { // from class: android.support.v7.widget.ActionMenuPresenter.d.1
                @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
                /* JADX INFO: renamed from: a */
                public InterfaceC1718fj mo3300a() {
                    if (ActionMenuPresenter.this.f3368h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f3368h.m9160b();
                }

                @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
                /* JADX INFO: renamed from: b */
                public boolean mo3301b() {
                    ActionMenuPresenter.this.m3453f();
                    return true;
                }

                @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
                /* JADX INFO: renamed from: c */
                public boolean mo3462c() {
                    if (ActionMenuPresenter.this.f3370j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.m3454g();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.m3453f();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$e */
    class C0565e extends C1713fe {
        public C0565e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            m9154a(GravityCompat.END);
            m9157a(ActionMenuPresenter.this.f3371k);
        }

        @Override // p000.C1713fe
        /* JADX INFO: renamed from: e */
        protected void mo3461e() {
            if (ActionMenuPresenter.this.f9683c != null) {
                ActionMenuPresenter.this.f9683c.close();
            }
            ActionMenuPresenter.this.f3368h = null;
            super.mo3461e();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$a */
    class C0561a extends C1713fe {
        public C0561a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).m3388i()) {
                m9155a(ActionMenuPresenter.this.f3367g == null ? (View) ActionMenuPresenter.this.f9686f : ActionMenuPresenter.this.f3367g);
            }
            m9157a(ActionMenuPresenter.this.f3371k);
        }

        @Override // p000.C1713fe
        /* JADX INFO: renamed from: e */
        protected void mo3461e() {
            ActionMenuPresenter.this.f3369i = null;
            ActionMenuPresenter.this.f3372l = 0;
            super.mo3461e();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$f */
    class C0566f implements InterfaceC1714ff.a {
        C0566f() {
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public boolean mo3279a(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f3372l = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            InterfaceC1714ff.a aVarD = ActionMenuPresenter.this.m9100d();
            if (aVarD != null) {
                return aVarD.mo3279a(menuBuilder);
            }
            return false;
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public void mo3278a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.mo3364q().m3340b(false);
            }
            InterfaceC1714ff.a aVarD = ActionMenuPresenter.this.m9100d();
            if (aVarD != null) {
                aVarD.mo3278a(menuBuilder, z);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$c */
    class RunnableC0563c implements Runnable {

        /* JADX INFO: renamed from: b */
        private C0565e f3391b;

        public RunnableC0563c(C0565e c0565e) {
            this.f3391b = c0565e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f9683c != null) {
                ActionMenuPresenter.this.f9683c.m3354g();
            }
            View view = (View) ActionMenuPresenter.this.f9686f;
            if (view != null && view.getWindowToken() != null && this.f3391b.m9161c()) {
                ActionMenuPresenter.this.f3368h = this.f3391b;
            }
            ActionMenuPresenter.this.f3370j = null;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuPresenter$b */
    class C0562b extends ActionMenuItemView.AbstractC0551b {
        C0562b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.AbstractC0551b
        /* JADX INFO: renamed from: a */
        public InterfaceC1718fj mo3302a() {
            if (ActionMenuPresenter.this.f3369i != null) {
                return ActionMenuPresenter.this.f3369i.m9160b();
            }
            return null;
        }
    }
}
