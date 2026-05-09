package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import p000.C1768hf;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements InterfaceC1715fg.a {

    /* JADX INFO: renamed from: d */
    private static final int[] f2225d = {R.attr.state_checked};

    /* JADX INFO: renamed from: c */
    boolean f2226c;

    /* JADX INFO: renamed from: e */
    private final int f2227e;

    /* JADX INFO: renamed from: f */
    private boolean f2228f;

    /* JADX INFO: renamed from: g */
    private final CheckedTextView f2229g;

    /* JADX INFO: renamed from: h */
    private FrameLayout f2230h;

    /* JADX INFO: renamed from: i */
    private MenuItemImpl f2231i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f2232j;

    /* JADX INFO: renamed from: k */
    private boolean f2233k;

    /* JADX INFO: renamed from: l */
    private Drawable f2234l;

    /* JADX INFO: renamed from: m */
    private final AccessibilityDelegateCompat f2235m;

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public boolean mo2424a() {
        return false;
    }

    public void setShortcut(boolean z, char c) {
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2235m = new AccessibilityDelegateCompat() { // from class: android.support.design.internal.NavigationMenuItemView.1
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f2226c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(android.support.design.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        this.f2227e = context.getResources().getDimensionPixelSize(android.support.design.R.dimen.design_navigation_icon_size);
        this.f2229g = (CheckedTextView) findViewById(android.support.design.R.id.design_menu_item_text);
        this.f2229g.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.f2229g, this.f2235m);
    }

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public void mo2423a(MenuItemImpl menuItemImpl, int i) {
        this.f2231i = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, m2456e());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        C1768hf.m9634a(this, menuItemImpl.getTooltipText());
        m2455d();
    }

    /* JADX INFO: renamed from: c */
    private boolean m2454c() {
        return this.f2231i.getTitle() == null && this.f2231i.getIcon() == null && this.f2231i.getActionView() != null;
    }

    /* JADX INFO: renamed from: d */
    private void m2455d() {
        if (m2454c()) {
            this.f2229g.setVisibility(8);
            if (this.f2230h != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) this.f2230h.getLayoutParams();
                layoutParams.width = -1;
                this.f2230h.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f2229g.setVisibility(0);
        if (this.f2230h != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) this.f2230h.getLayoutParams();
            layoutParams2.width = -2;
            this.f2230h.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2457b() {
        if (this.f2230h != null) {
            this.f2230h.removeAllViews();
        }
        this.f2229g.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f2230h == null) {
                this.f2230h = (FrameLayout) ((ViewStub) findViewById(android.support.design.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f2230h.removeAllViews();
            this.f2230h.addView(view);
        }
    }

    /* JADX INFO: renamed from: e */
    private StateListDrawable m2456e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f2225d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // p000.InterfaceC1715fg.a
    public MenuItemImpl getItemData() {
        return this.f2231i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2229g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f2226c != z) {
            this.f2226c = z;
            this.f2235m.sendAccessibilityEvent(this.f2229g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f2229g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f2233k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.f2232j);
            }
            drawable.setBounds(0, 0, this.f2227e, this.f2227e);
        } else if (this.f2228f) {
            if (this.f2234l == null) {
                this.f2234l = ResourcesCompat.getDrawable(getResources(), android.support.design.R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.f2234l != null) {
                    this.f2234l.setBounds(0, 0, this.f2227e, this.f2227e);
                }
            }
            drawable = this.f2234l;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f2229g, drawable, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f2231i != null && this.f2231i.isCheckable() && this.f2231i.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f2225d);
        }
        return iArrOnCreateDrawableState;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2232j = colorStateList;
        this.f2233k = this.f2232j != null;
        if (this.f2231i != null) {
            setIcon(this.f2231i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f2229g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f2229g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f2228f = z;
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIconPadding(int i) {
        this.f2229g.setCompoundDrawablePadding(i);
    }
}
