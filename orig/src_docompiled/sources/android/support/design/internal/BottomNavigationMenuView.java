package android.support.design.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import p000.C0744as;
import p000.C1648cw;
import p000.C1684ee;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements InterfaceC1715fg {

    /* JADX INFO: renamed from: a */
    private static final int[] f2184a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    private static final int[] f2185b = {-16842910};

    /* JADX INFO: renamed from: c */
    private final TransitionSet f2186c;

    /* JADX INFO: renamed from: d */
    private final int f2187d;

    /* JADX INFO: renamed from: e */
    private final int f2188e;

    /* JADX INFO: renamed from: f */
    private final int f2189f;

    /* JADX INFO: renamed from: g */
    private final int f2190g;

    /* JADX INFO: renamed from: h */
    private final int f2191h;

    /* JADX INFO: renamed from: i */
    private final View.OnClickListener f2192i;

    /* JADX INFO: renamed from: j */
    private final Pools.Pool<BottomNavigationItemView> f2193j;

    /* JADX INFO: renamed from: k */
    private boolean f2194k;

    /* JADX INFO: renamed from: l */
    private int f2195l;

    /* JADX INFO: renamed from: m */
    private BottomNavigationItemView[] f2196m;

    /* JADX INFO: renamed from: n */
    private int f2197n;

    /* JADX INFO: renamed from: o */
    private int f2198o;

    /* JADX INFO: renamed from: p */
    private ColorStateList f2199p;

    /* JADX INFO: renamed from: q */
    private int f2200q;

    /* JADX INFO: renamed from: r */
    private ColorStateList f2201r;

    /* JADX INFO: renamed from: s */
    private final ColorStateList f2202s;

    /* JADX INFO: renamed from: t */
    private int f2203t;

    /* JADX INFO: renamed from: u */
    private int f2204u;

    /* JADX INFO: renamed from: v */
    private Drawable f2205v;

    /* JADX INFO: renamed from: w */
    private int f2206w;

    /* JADX INFO: renamed from: x */
    private int[] f2207x;

    /* JADX INFO: renamed from: y */
    private BottomNavigationPresenter f2208y;

    /* JADX INFO: renamed from: z */
    private MenuBuilder f2209z;

    /* JADX INFO: renamed from: a */
    private boolean m2427a(int i, int i2) {
        if (i == -1) {
            if (i2 <= 3) {
                return false;
            }
        } else if (i != 0) {
            return false;
        }
        return true;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2193j = new Pools.SynchronizedPool(5);
        this.f2197n = 0;
        this.f2198o = 0;
        Resources resources = getResources();
        this.f2187d = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_item_max_width);
        this.f2188e = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_item_min_width);
        this.f2189f = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_active_item_max_width);
        this.f2190g = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_active_item_min_width);
        this.f2191h = resources.getDimensionPixelSize(android.support.design.R.dimen.design_bottom_navigation_height);
        this.f2202s = m2429a(R.attr.textColorSecondary);
        this.f2186c = new AutoTransition();
        this.f2186c.m3103a(0);
        this.f2186c.mo3062a(115L);
        this.f2186c.mo3063a(new FastOutSlowInInterpolator());
        this.f2186c.m3104a(new C0744as());
        this.f2192i = new View.OnClickListener() { // from class: android.support.design.internal.BottomNavigationMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (BottomNavigationMenuView.this.f2209z.m3335a(itemData, BottomNavigationMenuView.this.f2208y, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.f2207x = new int[5];
    }

    @Override // p000.InterfaceC1715fg
    /* JADX INFO: renamed from: a */
    public void mo2430a(MenuBuilder menuBuilder) {
        this.f2209z = menuBuilder;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f2209z.m3357j().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2191h, 1073741824);
        if (m2427a(this.f2195l, size2) && this.f2194k) {
            View childAt = getChildAt(this.f2198o);
            int iMax = this.f2190g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f2189f, ExploreByTouchHelper.INVALID_ID), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i3 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f2188e * i3), Math.min(iMax, this.f2189f));
            int i4 = size - iMin;
            int iMin2 = Math.min(i4 / (i3 == 0 ? 1 : i3), this.f2187d);
            int i5 = i4 - (i3 * iMin2);
            int i6 = 0;
            while (i6 < childCount) {
                if (getChildAt(i6).getVisibility() != 8) {
                    this.f2207x[i6] = i6 == this.f2198o ? iMin : iMin2;
                    if (i5 > 0) {
                        int[] iArr = this.f2207x;
                        iArr[i6] = iArr[i6] + 1;
                        i5--;
                    }
                } else {
                    this.f2207x[i6] = 0;
                }
                i6++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f2189f);
            int i7 = size - (size2 * iMin3);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.f2207x[i8] = iMin3;
                    if (i7 > 0) {
                        int[] iArr2 = this.f2207x;
                        iArr2[i8] = iArr2[i8] + 1;
                        i7--;
                    }
                } else {
                    this.f2207x[i8] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f2207x[i9], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(this.f2191h, iMakeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2199p = colorStateList;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.f2199p;
    }

    public void setItemIconSize(int i) {
        this.f2200q = i;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public int getItemIconSize() {
        return this.f2200q;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2201r = colorStateList;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f2201r;
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f2203t = i;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                if (this.f2201r != null) {
                    bottomNavigationItemView.setTextColor(this.f2201r);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.f2203t;
    }

    public void setItemTextAppearanceActive(int i) {
        this.f2204u = i;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                if (this.f2201r != null) {
                    bottomNavigationItemView.setTextColor(this.f2201r);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.f2204u;
    }

    public void setItemBackgroundRes(int i) {
        this.f2206w = i;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f2206w;
    }

    public void setItemBackground(Drawable drawable) {
        this.f2205v = drawable;
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        if (this.f2196m != null && this.f2196m.length > 0) {
            return this.f2196m[0].getBackground();
        }
        return this.f2205v;
    }

    public void setLabelVisibilityMode(int i) {
        this.f2195l = i;
    }

    public int getLabelVisibilityMode() {
        return this.f2195l;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.f2194k = z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2431a() {
        return this.f2194k;
    }

    /* JADX INFO: renamed from: a */
    public ColorStateList m2429a(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM8972a = C1684ee.m8972a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListM8972a.getDefaultColor();
        return new ColorStateList(new int[][]{f2185b, f2184a, EMPTY_STATE_SET}, new int[]{colorStateListM8972a.getColorForState(f2185b, defaultColor), i2, defaultColor});
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f2208y = bottomNavigationPresenter;
    }

    /* JADX INFO: renamed from: b */
    public void m2432b() {
        removeAllViews();
        if (this.f2196m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.f2196m) {
                if (bottomNavigationItemView != null) {
                    this.f2193j.release(bottomNavigationItemView);
                }
            }
        }
        if (this.f2209z.size() == 0) {
            this.f2197n = 0;
            this.f2198o = 0;
            this.f2196m = null;
            return;
        }
        this.f2196m = new BottomNavigationItemView[this.f2209z.size()];
        boolean zM2427a = m2427a(this.f2195l, this.f2209z.m3357j().size());
        for (int i = 0; i < this.f2209z.size(); i++) {
            this.f2208y.m2446b(true);
            this.f2209z.getItem(i).setCheckable(true);
            this.f2208y.m2446b(false);
            BottomNavigationItemView newItem = getNewItem();
            this.f2196m[i] = newItem;
            newItem.setIconTintList(this.f2199p);
            newItem.setIconSize(this.f2200q);
            newItem.setTextColor(this.f2202s);
            newItem.setTextAppearanceInactive(this.f2203t);
            newItem.setTextAppearanceActive(this.f2204u);
            newItem.setTextColor(this.f2201r);
            if (this.f2205v != null) {
                newItem.setItemBackground(this.f2205v);
            } else {
                newItem.setItemBackground(this.f2206w);
            }
            newItem.setShifting(zM2427a);
            newItem.setLabelVisibilityMode(this.f2195l);
            newItem.mo2423a((MenuItemImpl) this.f2209z.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.f2192i);
            addView(newItem);
        }
        this.f2198o = Math.min(this.f2209z.size() - 1, this.f2198o);
        this.f2209z.getItem(this.f2198o).setChecked(true);
    }

    /* JADX INFO: renamed from: c */
    public void m2434c() {
        if (this.f2209z == null || this.f2196m == null) {
            return;
        }
        int size = this.f2209z.size();
        if (size != this.f2196m.length) {
            m2432b();
            return;
        }
        int i = this.f2197n;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f2209z.getItem(i2);
            if (item.isChecked()) {
                this.f2197n = item.getItemId();
                this.f2198o = i2;
            }
        }
        if (i != this.f2197n) {
            C1648cw.m8820a(this, this.f2186c);
        }
        boolean zM2427a = m2427a(this.f2195l, this.f2209z.m3357j().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.f2208y.m2446b(true);
            this.f2196m[i3].setLabelVisibilityMode(this.f2195l);
            this.f2196m[i3].setShifting(zM2427a);
            this.f2196m[i3].mo2423a((MenuItemImpl) this.f2209z.getItem(i3), 0);
            this.f2208y.m2446b(false);
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemViewAcquire = this.f2193j.acquire();
        return bottomNavigationItemViewAcquire == null ? new BottomNavigationItemView(getContext()) : bottomNavigationItemViewAcquire;
    }

    public int getSelectedItemId() {
        return this.f2197n;
    }

    /* JADX INFO: renamed from: b */
    void m2433b(int i) {
        int size = this.f2209z.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.f2209z.getItem(i2);
            if (i == item.getItemId()) {
                this.f2197n = i;
                this.f2198o = i2;
                item.setChecked(true);
                return;
            }
        }
    }
}
