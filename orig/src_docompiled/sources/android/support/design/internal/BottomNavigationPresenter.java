package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;
import p000.InterfaceC1714ff;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationPresenter implements InterfaceC1714ff {

    /* JADX INFO: renamed from: a */
    private MenuBuilder f2211a;

    /* JADX INFO: renamed from: b */
    private BottomNavigationMenuView f2212b;

    /* JADX INFO: renamed from: c */
    private boolean f2213c = false;

    /* JADX INFO: renamed from: d */
    private int f2214d;

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2439a(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2440a(InterfaceC1714ff.a aVar) {
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

    /* JADX INFO: renamed from: a */
    public void m2438a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f2212b = bottomNavigationMenuView;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2436a(Context context, MenuBuilder menuBuilder) {
        this.f2211a = menuBuilder;
        this.f2212b.mo2430a(this.f2211a);
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2441a(boolean z) {
        if (this.f2213c) {
            return;
        }
        if (z) {
            this.f2212b.m2432b();
        } else {
            this.f2212b.m2434c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2435a(int i) {
        this.f2214d = i;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: b */
    public int mo2445b() {
        return this.f2214d;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: c */
    public Parcelable mo2448c() {
        SavedState savedState = new SavedState();
        savedState.f2215a = this.f2212b.getSelectedItemId();
        return savedState;
    }

    @Override // p000.InterfaceC1714ff
    /* JADX INFO: renamed from: a */
    public void mo2437a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2212b.m2433b(((SavedState) parcelable).f2215a);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2446b(boolean z) {
        this.f2213c = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.design.internal.BottomNavigationPresenter.SavedState.1
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
        int f2215a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2215a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2215a);
        }
    }
}
