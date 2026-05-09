package com.coollang.tennis.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private View f7398a;

    /* JADX INFO: renamed from: a */
    public abstract View mo7735a(LayoutInflater layoutInflater);

    /* JADX INFO: renamed from: a */
    public abstract void mo7736a();

    /* JADX INFO: renamed from: a */
    public abstract void mo7737a(View view);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle != null) {
            boolean z = bundle.getBoolean("STATE_SAVE_IS_HIDDEN");
            FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
            if (z) {
                fragmentTransactionBeginTransaction.hide(this);
            } else {
                fragmentTransactionBeginTransaction.show(this);
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7398a = mo7735a(layoutInflater);
        return this.f7398a;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d("aaaa", "onActivityCreated: ========ssss==========");
        mo7737a(this.f7398a);
        mo7736a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("STATE_SAVE_IS_HIDDEN", isHidden());
        super.onSaveInstanceState(bundle);
    }
}
