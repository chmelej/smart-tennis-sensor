package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import p000.C1768hf;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements InterfaceC1715fg.a {

    /* JADX INFO: renamed from: a */
    private static final int[] f2171a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    private final int f2172b;

    /* JADX INFO: renamed from: c */
    private float f2173c;

    /* JADX INFO: renamed from: d */
    private float f2174d;

    /* JADX INFO: renamed from: e */
    private float f2175e;

    /* JADX INFO: renamed from: f */
    private int f2176f;

    /* JADX INFO: renamed from: g */
    private boolean f2177g;

    /* JADX INFO: renamed from: h */
    private ImageView f2178h;

    /* JADX INFO: renamed from: i */
    private final TextView f2179i;

    /* JADX INFO: renamed from: j */
    private final TextView f2180j;

    /* JADX INFO: renamed from: k */
    private int f2181k;

    /* JADX INFO: renamed from: l */
    private MenuItemImpl f2182l;

    /* JADX INFO: renamed from: m */
    private ColorStateList f2183m;

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public boolean mo2424a() {
        return false;
    }

    public void setShortcut(boolean z, char c) {
    }

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2181k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(android.support.design.R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(android.support.design.R.drawable.design_bottom_navigation_item_background);
        this.f2172b = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_margin);
        this.f2178h = (ImageView) findViewById(android.support.design.R.id.icon);
        this.f2179i = (TextView) findViewById(android.support.design.R.id.smallLabel);
        this.f2180j = (TextView) findViewById(android.support.design.R.id.largeLabel);
        ViewCompat.setImportantForAccessibility(this.f2179i, 2);
        ViewCompat.setImportantForAccessibility(this.f2180j, 2);
        setFocusable(true);
        m2420a(this.f2179i.getTextSize(), this.f2180j.getTextSize());
    }

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public void mo2423a(MenuItemImpl menuItemImpl, int i) {
        this.f2182l = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        C1768hf.m9634a(this, menuItemImpl.getTooltipText());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i) {
        this.f2181k = i;
    }

    public int getItemPosition() {
        return this.f2181k;
    }

    public void setShifting(boolean z) {
        if (this.f2177g != z) {
            this.f2177g = z;
            if (this.f2182l != null) {
                setChecked(this.f2182l.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f2176f != i) {
            this.f2176f = i;
            if (this.f2182l != null) {
                setChecked(this.f2182l.isChecked());
            }
        }
    }

    @Override // p000.InterfaceC1715fg.a
    public MenuItemImpl getItemData() {
        return this.f2182l;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2179i.setText(charSequence);
        this.f2180j.setText(charSequence);
        if (this.f2182l == null || TextUtils.isEmpty(this.f2182l.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.f2180j.setPivotX(this.f2180j.getWidth() / 2);
        this.f2180j.setPivotY(this.f2180j.getBaseline());
        this.f2179i.setPivotX(this.f2179i.getWidth() / 2);
        this.f2179i.setPivotY(this.f2179i.getBaseline());
        switch (this.f2176f) {
            case -1:
                if (this.f2177g) {
                    if (z) {
                        m2422a(this.f2178h, this.f2172b, 49);
                        m2421a(this.f2180j, 1.0f, 1.0f, 0);
                    } else {
                        m2422a(this.f2178h, this.f2172b, 17);
                        m2421a(this.f2180j, 0.5f, 0.5f, 4);
                    }
                    this.f2179i.setVisibility(4);
                } else if (z) {
                    m2422a(this.f2178h, (int) (this.f2172b + this.f2173c), 49);
                    m2421a(this.f2180j, 1.0f, 1.0f, 0);
                    m2421a(this.f2179i, this.f2174d, this.f2174d, 4);
                } else {
                    m2422a(this.f2178h, this.f2172b, 49);
                    m2421a(this.f2180j, this.f2175e, this.f2175e, 4);
                    m2421a(this.f2179i, 1.0f, 1.0f, 0);
                }
                break;
            case 0:
                if (z) {
                    m2422a(this.f2178h, this.f2172b, 49);
                    m2421a(this.f2180j, 1.0f, 1.0f, 0);
                } else {
                    m2422a(this.f2178h, this.f2172b, 17);
                    m2421a(this.f2180j, 0.5f, 0.5f, 4);
                }
                this.f2179i.setVisibility(4);
                break;
            case 1:
                if (z) {
                    m2422a(this.f2178h, (int) (this.f2172b + this.f2173c), 49);
                    m2421a(this.f2180j, 1.0f, 1.0f, 0);
                    m2421a(this.f2179i, this.f2174d, this.f2174d, 4);
                } else {
                    m2422a(this.f2178h, this.f2172b, 49);
                    m2421a(this.f2180j, this.f2175e, this.f2175e, 4);
                    m2421a(this.f2179i, 1.0f, 1.0f, 0);
                }
                break;
            case 2:
                m2422a(this.f2178h, this.f2172b, 17);
                this.f2180j.setVisibility(8);
                this.f2179i.setVisibility(8);
                break;
        }
        refreshDrawableState();
        setSelected(z);
    }

    /* JADX INFO: renamed from: a */
    private void m2422a(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    private void m2421a(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2179i.setEnabled(z);
        this.f2180j.setEnabled(z);
        this.f2178h.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f2182l != null && this.f2182l.isCheckable() && this.f2182l.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f2171a);
        }
        return iArrOnCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, this.f2183m);
        }
        this.f2178h.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2183m = colorStateList;
        if (this.f2182l != null) {
            setIcon(this.f2182l.getIcon());
        }
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2178h.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.f2178h.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i) {
        TextViewCompat.setTextAppearance(this.f2179i, i);
        m2420a(this.f2179i.getTextSize(), this.f2180j.getTextSize());
    }

    public void setTextAppearanceActive(int i) {
        TextViewCompat.setTextAppearance(this.f2180j, i);
        m2420a(this.f2179i.getTextSize(), this.f2180j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f2179i.setTextColor(colorStateList);
            this.f2180j.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2420a(float f, float f2) {
        this.f2173c = f - f2;
        this.f2174d = (f2 * 1.0f) / f;
        this.f2175e = (f * 1.0f) / f2;
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        ViewCompat.setBackground(this, drawable);
    }
}
