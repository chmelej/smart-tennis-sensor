package p000;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import p000.MenuItemC1710fb;

/* JADX INFO: renamed from: fc */
/* JADX INFO: compiled from: MenuItemWrapperJB.java */
/* JADX INFO: loaded from: classes.dex */
class C1711fc extends MenuItemC1710fb {
    C1711fc(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // p000.MenuItemC1710fb
    /* JADX INFO: renamed from: a */
    MenuItemC1710fb.a mo9143a(ActionProvider actionProvider) {
        return new a(this.f9691a, actionProvider);
    }

    /* JADX INFO: renamed from: fc$a */
    /* JADX INFO: compiled from: MenuItemWrapperJB.java */
    class a extends MenuItemC1710fb.a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: c */
        ActionProvider.VisibilityListener f9767c;

        public a(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            return this.f9762a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.f9762a.overridesItemVisibility();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean isVisible() {
            return this.f9762a.isVisible();
        }

        @Override // android.support.v4.view.ActionProvider
        public void refreshVisibility() {
            this.f9762a.refreshVisibility();
        }

        @Override // android.support.v4.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f9767c = visibilityListener;
            this.f9762a.setVisibilityListener(visibilityListener != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f9767c != null) {
                this.f9767c.onActionProviderVisibilityChanged(z);
            }
        }
    }
}
