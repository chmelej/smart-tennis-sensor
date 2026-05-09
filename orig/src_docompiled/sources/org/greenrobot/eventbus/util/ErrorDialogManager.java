package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import p000.asd;
import p000.ast;
import p000.asv;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogManager {

    /* JADX INFO: renamed from: a */
    public static ast<?> f12050a;

    public static class SupportManagerFragment extends Fragment {

        /* JADX INFO: renamed from: a */
        protected boolean f12055a;

        /* JADX INFO: renamed from: b */
        protected Bundle f12056b;

        /* JADX INFO: renamed from: c */
        private asd f12057c;

        /* JADX INFO: renamed from: d */
        private boolean f12058d;

        /* JADX INFO: renamed from: e */
        private Object f12059e;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f12057c = ErrorDialogManager.f12050a.f5004a.m5367a();
            this.f12057c.m5335a(this);
            this.f12058d = true;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f12058d) {
                this.f12058d = false;
            } else {
                this.f12057c = ErrorDialogManager.f12050a.f5004a.m5367a();
                this.f12057c.m5335a(this);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPause() {
            this.f12057c.m5337b(this);
            super.onPause();
        }

        public void onEventMainThread(asv asvVar) {
            if (ErrorDialogManager.m11041b(this.f12059e, asvVar)) {
                ErrorDialogManager.m11039a(asvVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.f12050a.m5369a(asvVar, this.f12055a, this.f12056b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends android.app.Fragment {

        /* JADX INFO: renamed from: a */
        protected boolean f12051a;

        /* JADX INFO: renamed from: b */
        protected Bundle f12052b;

        /* JADX INFO: renamed from: c */
        private asd f12053c;

        /* JADX INFO: renamed from: d */
        private Object f12054d;

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.f12053c = ErrorDialogManager.f12050a.f5004a.m5367a();
            this.f12053c.m5335a(this);
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f12053c.m5337b(this);
            super.onPause();
        }

        public void onEventMainThread(asv asvVar) {
            if (ErrorDialogManager.m11041b(this.f12054d, asvVar)) {
                ErrorDialogManager.m11039a(asvVar);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                android.app.DialogFragment dialogFragment = (android.app.DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                android.app.DialogFragment dialogFragment2 = (android.app.DialogFragment) ErrorDialogManager.f12050a.m5369a(asvVar, this.f12051a, this.f12052b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected static void m11039a(asv asvVar) {
        if (f12050a.f5004a.f5000f) {
            String str = f12050a.f5004a.f5001g;
            if (str == null) {
                str = asd.f4913a;
            }
            Log.i(str, "Error dialog manager received exception", asvVar.f5006a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static boolean m11041b(Object obj, asv asvVar) {
        Object objM5375b;
        return asvVar == null || (objM5375b = asvVar.m5375b()) == null || objM5375b.equals(obj);
    }
}
