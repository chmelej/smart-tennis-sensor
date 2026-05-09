package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import p000.AbstractC1762h;
import p000.C1843k;
import p000.InterfaceC1816j;
import p000.InterfaceC1870l;

/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private InterfaceC0220a f2032a;

    /* JADX INFO: renamed from: android.arch.lifecycle.ReportFragment$a */
    interface InterfaceC0220a {
        /* JADX INFO: renamed from: a */
        void m2201a();

        /* JADX INFO: renamed from: b */
        void m2202b();

        /* JADX INFO: renamed from: c */
        void m2203c();
    }

    /* JADX INFO: renamed from: a */
    public static void m2196a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2197a(InterfaceC0220a interfaceC0220a) {
        if (interfaceC0220a != null) {
            interfaceC0220a.m2201a();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2199b(InterfaceC0220a interfaceC0220a) {
        if (interfaceC0220a != null) {
            interfaceC0220a.m2202b();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2200c(InterfaceC0220a interfaceC0220a) {
        if (interfaceC0220a != null) {
            interfaceC0220a.m2203c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m2197a(this.f2032a);
        m2198a(AbstractC1762h.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m2199b(this.f2032a);
        m2198a(AbstractC1762h.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m2200c(this.f2032a);
        m2198a(AbstractC1762h.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m2198a(AbstractC1762h.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m2198a(AbstractC1762h.a.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m2198a(AbstractC1762h.a.ON_DESTROY);
        this.f2032a = null;
    }

    /* JADX INFO: renamed from: a */
    private void m2198a(AbstractC1762h.a aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof InterfaceC1870l) {
            ((InterfaceC1870l) activity).m10176a().m10070a(aVar);
        } else if (activity instanceof InterfaceC1816j) {
            AbstractC1762h lifecycle = ((InterfaceC1816j) activity).getLifecycle();
            if (lifecycle instanceof C1843k) {
                ((C1843k) lifecycle).m10070a(aVar);
            }
        }
    }
}
