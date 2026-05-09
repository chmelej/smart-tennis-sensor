package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import p000.C0751at;
import p000.C1699er;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private final MenuBuilder f2356a;

    /* JADX INFO: renamed from: b */
    private final BottomNavigationMenuView f2357b;

    /* JADX INFO: renamed from: c */
    private final BottomNavigationPresenter f2358c;

    /* JADX INFO: renamed from: d */
    private MenuInflater f2359d;

    /* JADX INFO: renamed from: e */
    private InterfaceC0275b f2360e;

    /* JADX INFO: renamed from: f */
    private InterfaceC0274a f2361f;

    /* JADX INFO: renamed from: android.support.design.widget.BottomNavigationView$a */
    public interface InterfaceC0274a {
        /* JADX INFO: renamed from: a */
        void m2627a(MenuItem menuItem);
    }

    /* JADX INFO: renamed from: android.support.design.widget.BottomNavigationView$b */
    public interface InterfaceC0275b {
        /* JADX INFO: renamed from: a */
        boolean m2628a(MenuItem menuItem);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2358c = new BottomNavigationPresenter();
        this.f2356a = new BottomNavigationMenu(context);
        this.f2357b = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f2357b.setLayoutParams(layoutParams);
        this.f2358c.m2438a(this.f2357b);
        this.f2358c.m2435a(1);
        this.f2357b.setPresenter(this.f2358c);
        this.f2356a.m3330a(this.f2358c);
        this.f2358c.mo2436a(getContext(), this.f2356a);
        C1766hd c1766hdM5395b = C0751at.m5395b(context, attributeSet, R.styleable.BottomNavigationView, i, R.style.Widget_Design_BottomNavigationView, R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_itemIconTint)) {
            this.f2357b.setIconTintList(c1766hdM5395b.m9616e(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            this.f2357b.setIconTintList(this.f2357b.m2429a(android.R.attr.textColorSecondary));
        }
        setItemIconSize(c1766hdM5395b.m9615e(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(c1766hdM5395b.m9619g(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(c1766hdM5395b.m9619g(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(c1766hdM5395b.m9616e(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.setElevation(this, c1766hdM5395b.m9615e(R.styleable.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(c1766hdM5395b.m9611c(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(c1766hdM5395b.m9607a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.f2357b.setItemBackgroundRes(c1766hdM5395b.m9619g(R.styleable.BottomNavigationView_itemBackground, 0));
        if (c1766hdM5395b.m9620g(R.styleable.BottomNavigationView_menu)) {
            m2620a(c1766hdM5395b.m9619g(R.styleable.BottomNavigationView_menu, 0));
        }
        c1766hdM5395b.m9606a();
        addView(this.f2357b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            m2618a(context);
        }
        this.f2356a.mo3327a(new MenuBuilder.InterfaceC0552a() { // from class: android.support.design.widget.BottomNavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
            /* JADX INFO: renamed from: a */
            public void mo2621a(MenuBuilder menuBuilder) {
            }

            @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
            /* JADX INFO: renamed from: a */
            public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
                if (BottomNavigationView.this.f2361f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                    return (BottomNavigationView.this.f2360e == null || BottomNavigationView.this.f2360e.m2628a(menuItem)) ? false : true;
                }
                BottomNavigationView.this.f2361f.m2627a(menuItem);
                return true;
            }
        });
    }

    public void setOnNavigationItemSelectedListener(InterfaceC0275b interfaceC0275b) {
        this.f2360e = interfaceC0275b;
    }

    public void setOnNavigationItemReselectedListener(InterfaceC0274a interfaceC0274a) {
        this.f2361f = interfaceC0274a;
    }

    public Menu getMenu() {
        return this.f2356a;
    }

    /* JADX INFO: renamed from: a */
    public void m2620a(int i) {
        this.f2358c.m2446b(true);
        getMenuInflater().inflate(i, this.f2356a);
        this.f2358c.m2446b(false);
        this.f2358c.mo2441a(true);
    }

    public ColorStateList getItemIconTintList() {
        return this.f2357b.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f2357b.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i) {
        this.f2357b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconSize() {
        return this.f2357b.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.f2357b.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2357b.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f2357b.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.f2357b.setItemBackgroundRes(i);
    }

    public Drawable getItemBackground() {
        return this.f2357b.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.f2357b.setItemBackground(drawable);
    }

    public int getSelectedItemId() {
        return this.f2357b.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem menuItemFindItem = this.f2356a.findItem(i);
        if (menuItemFindItem == null || this.f2356a.m3335a(menuItemFindItem, this.f2358c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f2357b.getLabelVisibilityMode() != i) {
            this.f2357b.setLabelVisibilityMode(i);
            this.f2358c.mo2441a(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.f2357b.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f2357b.setItemTextAppearanceInactive(i);
    }

    public int getItemTextAppearanceInactive() {
        return this.f2357b.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i) {
        this.f2357b.setItemTextAppearanceActive(i);
    }

    public int getItemTextAppearanceActive() {
        return this.f2357b.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f2357b.m2431a() != z) {
            this.f2357b.setItemHorizontalTranslationEnabled(z);
            this.f2358c.mo2441a(false);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2618a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.f2359d == null) {
            this.f2359d = new C1699er(getContext());
        }
        return this.f2359d;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2363a = new Bundle();
        this.f2356a.m3326a(savedState.f2363a);
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
        this.f2356a.m3337b(savedState.f2363a);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.BottomNavigationView.SavedState.1
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
        Bundle f2363a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m2623a(parcel, classLoader);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f2363a);
        }

        /* JADX INFO: renamed from: a */
        private void m2623a(Parcel parcel, ClassLoader classLoader) {
            this.f2363a = parcel.readBundle(classLoader);
        }
    }
}
