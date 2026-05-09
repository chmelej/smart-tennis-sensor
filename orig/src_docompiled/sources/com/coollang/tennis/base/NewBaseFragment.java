package com.coollang.tennis.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/* JADX INFO: loaded from: classes.dex */
public abstract class NewBaseFragment extends Fragment {
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
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("STATE_SAVE_IS_HIDDEN", isHidden());
        super.onSaveInstanceState(bundle);
    }
}
