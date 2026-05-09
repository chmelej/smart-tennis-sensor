package de.greenrobot.event.util;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import p000.akd;
import p000.akq;
import p000.aks;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogManager {

    /* JADX INFO: renamed from: a */
    public static akq<?> f9377a;

    public static class SupportManagerFragment extends Fragment {

        /* JADX INFO: renamed from: a */
        protected boolean f9382a;

        /* JADX INFO: renamed from: b */
        protected Bundle f9383b;

        /* JADX INFO: renamed from: c */
        private akd f9384c;

        /* JADX INFO: renamed from: d */
        private boolean f9385d;

        /* JADX INFO: renamed from: e */
        private Object f9386e;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f9384c = ErrorDialogManager.f9377a.f1506a.m1735a();
            this.f9384c.m1719a(this);
            this.f9385d = true;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f9385d) {
                this.f9385d = false;
            } else {
                this.f9384c = ErrorDialogManager.f9377a.f1506a.m1735a();
                this.f9384c.m1719a(this);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPause() {
            this.f9384c.m1721b(this);
            super.onPause();
        }

        public void onEventMainThread(aks aksVar) {
            if (ErrorDialogManager.m8845b(this.f9386e, aksVar)) {
                ErrorDialogManager.m8843a(aksVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.f9377a.m1737a(aksVar, this.f9382a, this.f9383b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends android.app.Fragment {

        /* JADX INFO: renamed from: a */
        protected boolean f9378a;

        /* JADX INFO: renamed from: b */
        protected Bundle f9379b;

        /* JADX INFO: renamed from: c */
        private akd f9380c;

        /* JADX INFO: renamed from: d */
        private Object f9381d;

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.f9380c = ErrorDialogManager.f9377a.f1506a.m1735a();
            this.f9380c.m1719a(this);
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f9380c.m1721b(this);
            super.onPause();
        }

        public void onEventMainThread(aks aksVar) {
            if (ErrorDialogManager.m8845b(this.f9381d, aksVar)) {
                ErrorDialogManager.m8843a(aksVar);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                android.app.DialogFragment dialogFragment = (android.app.DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                android.app.DialogFragment dialogFragment2 = (android.app.DialogFragment) ErrorDialogManager.f9377a.m1737a(aksVar, this.f9378a, this.f9379b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m8843a(aks aksVar) {
        if (f9377a.f1506a.f1502f) {
            String str = f9377a.f1506a.f1503g;
            if (str == null) {
                str = akd.f1430a;
            }
            Log.i(str, "Error dialog manager received exception", aksVar.f1508a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static boolean m8845b(Object obj, aks aksVar) {
        Object objM1743b;
        return aksVar == null || (objM1743b = aksVar.m1743b()) == null || objM1743b.equals(obj);
    }
}
