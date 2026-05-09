package p000;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/* JADX INFO: compiled from: SupportFragmentPermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
class ath extends atd<Fragment> {
    public ath(Fragment fragment) {
        super(fragment);
    }

    @Override // p000.atd
    /* JADX INFO: renamed from: a */
    public FragmentManager mo5403a() {
        return m5410c().getChildFragmentManager();
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5400a(int i, String... strArr) {
        m5410c().requestPermissions(strArr, i);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public boolean mo5401a(String str) {
        return m5410c().shouldShowRequestPermissionRationale(str);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: b */
    public Context mo5402b() {
        return m5410c().getActivity();
    }
}
