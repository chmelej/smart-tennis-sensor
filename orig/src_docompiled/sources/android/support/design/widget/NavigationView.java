package android.support.design.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import p000.C0739ar;
import p000.C0751at;
import p000.C1684ee;
import p000.C1699er;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: d */
    private static final int[] f2511d = {R.attr.state_checked};

    /* JADX INFO: renamed from: e */
    private static final int[] f2512e = {-16842910};

    /* JADX INFO: renamed from: c */
    InterfaceC0299a f2513c;

    /* JADX INFO: renamed from: f */
    private final NavigationMenu f2514f;

    /* JADX INFO: renamed from: g */
    private final C0739ar f2515g;

    /* JADX INFO: renamed from: h */
    private final int f2516h;

    /* JADX INFO: renamed from: i */
    private MenuInflater f2517i;

    /* JADX INFO: renamed from: android.support.design.widget.NavigationView$a */
    public interface InterfaceC0299a {
        /* JADX INFO: renamed from: a */
        boolean m2800a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.design.R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListM2794c;
        boolean z;
        int iM9619g;
        super(context, attributeSet, i);
        this.f2515g = new C0739ar();
        this.f2514f = new NavigationMenu(context);
        C1766hd c1766hdM5395b = C0751at.m5395b(context, attributeSet, android.support.design.R.styleable.NavigationView, i, android.support.design.R.style.Widget_Design_NavigationView, new int[0]);
        ViewCompat.setBackground(this, c1766hdM5395b.m9605a(android.support.design.R.styleable.NavigationView_android_background));
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, c1766hdM5395b.m9615e(android.support.design.R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, c1766hdM5395b.m9607a(android.support.design.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f2516h = c1766hdM5395b.m9615e(android.support.design.R.styleable.NavigationView_android_maxWidth, 0);
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_itemIconTint)) {
            colorStateListM2794c = c1766hdM5395b.m9616e(android.support.design.R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListM2794c = m2794c(R.attr.textColorSecondary);
        }
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_itemTextAppearance)) {
            iM9619g = c1766hdM5395b.m9619g(android.support.design.R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            iM9619g = 0;
        }
        ColorStateList colorStateListM9616e = c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_itemTextColor) ? c1766hdM5395b.m9616e(android.support.design.R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateListM9616e == null) {
            colorStateListM9616e = m2794c(R.attr.textColorPrimary);
        }
        Drawable drawableM9605a = c1766hdM5395b.m9605a(android.support.design.R.styleable.NavigationView_itemBackground);
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_itemHorizontalPadding)) {
            this.f2515g.m5202d(c1766hdM5395b.m9615e(android.support.design.R.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int iM9615e = c1766hdM5395b.m9615e(android.support.design.R.styleable.NavigationView_itemIconPadding, 0);
        this.f2514f.mo3327a(new MenuBuilder.InterfaceC0552a() { // from class: android.support.design.widget.NavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
            /* JADX INFO: renamed from: a */
            public void mo2621a(MenuBuilder menuBuilder) {
            }

            @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
            /* JADX INFO: renamed from: a */
            public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.f2513c != null && NavigationView.this.f2513c.m2800a(menuItem);
            }
        });
        this.f2515g.m5191a(1);
        this.f2515g.mo2436a(context, this.f2514f);
        this.f2515g.m5192a(colorStateListM2794c);
        if (z) {
            this.f2515g.m5200c(iM9619g);
        }
        this.f2515g.m5198b(colorStateListM9616e);
        this.f2515g.m5193a(drawableM9605a);
        this.f2515g.m5204e(iM9615e);
        this.f2514f.m3330a(this.f2515g);
        addView((View) this.f2515g.m5190a((ViewGroup) this));
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_menu)) {
            m2795a(c1766hdM5395b.m9619g(android.support.design.R.styleable.NavigationView_menu, 0));
        }
        if (c1766hdM5395b.m9620g(android.support.design.R.styleable.NavigationView_headerLayout)) {
            m2796b(c1766hdM5395b.m9619g(android.support.design.R.styleable.NavigationView_headerLayout, 0));
        }
        c1766hdM5395b.m9606a();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2519a = new Bundle();
        this.f2514f.m3326a(savedState.f2519a);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2514f.m3337b(savedState.f2519a);
    }

    public void setNavigationItemSelectedListener(InterfaceC0299a interfaceC0299a) {
        this.f2513c = interfaceC0299a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.f2516h), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.f2516h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.design.internal.ScrimInsetsFrameLayout
    /* JADX INFO: renamed from: a */
    public void mo2462a(WindowInsetsCompat windowInsetsCompat) {
        this.f2515g.m5194a(windowInsetsCompat);
    }

    /* JADX INFO: renamed from: a */
    public void m2795a(int i) {
        this.f2515g.m5199b(true);
        getMenuInflater().inflate(i, this.f2514f);
        this.f2515g.m5199b(false);
        this.f2515g.mo2441a(false);
    }

    public Menu getMenu() {
        return this.f2514f;
    }

    /* JADX INFO: renamed from: b */
    public View m2796b(int i) {
        return this.f2515g.m5197b(i);
    }

    public int getHeaderCount() {
        return this.f2515g.m5203e();
    }

    public ColorStateList getItemIconTintList() {
        return this.f2515g.m5205f();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f2515g.m5192a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f2515g.m5206g();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2515g.m5198b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f2515g.m5207h();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f2515g.m5193a(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.f2515g.m5208i();
    }

    public void setItemHorizontalPadding(int i) {
        this.f2515g.m5202d(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.f2515g.m5202d(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconPadding() {
        return this.f2515g.m5209j();
    }

    public void setItemIconPadding(int i) {
        this.f2515g.m5204e(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.f2515g.m5204e(getResources().getDimensionPixelSize(i));
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.f2514f.findItem(i);
        if (menuItemFindItem != null) {
            this.f2515g.m5195a((MenuItemImpl) menuItemFindItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f2514f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f2515g.m5195a((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.f2515g.m5201d();
    }

    public void setItemTextAppearance(int i) {
        this.f2515g.m5200c(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f2517i == null) {
            this.f2517i = new C1699er(getContext());
        }
        return this.f2517i;
    }

    /* JADX INFO: renamed from: c */
    private ColorStateList m2794c(int i) {
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
        return new ColorStateList(new int[][]{f2512e, f2511d, EMPTY_STATE_SET}, new int[]{colorStateListM8972a.getColorForState(f2512e, defaultColor), i2, defaultColor});
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.NavigationView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        public Bundle f2519a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2519a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f2519a);
        }
    }
}
