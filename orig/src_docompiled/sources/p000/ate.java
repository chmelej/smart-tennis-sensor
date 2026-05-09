package p000;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

/* JADX INFO: compiled from: FrameworkFragmentPermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
class ate extends atc<Fragment> {
    public ate(Fragment fragment) {
        super(fragment);
    }

    @Override // p000.atc
    /* JADX INFO: renamed from: a */
    public FragmentManager mo5399a() {
        return m5410c().getChildFragmentManager();
    }

    @Override // p000.atg
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void mo5400a(int i, String... strArr) {
        m5410c().requestPermissions(strArr, i);
    }

    @Override // p000.atg
    @SuppressLint({"NewApi"})
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
