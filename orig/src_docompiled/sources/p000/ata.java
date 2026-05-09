package p000;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.ActivityCompat;

/* JADX INFO: compiled from: ActivityPermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
class ata extends atc<Activity> {
    public ata(Activity activity) {
        super(activity);
    }

    @Override // p000.atc
    /* JADX INFO: renamed from: a */
    public FragmentManager mo5399a() {
        return m5410c().getFragmentManager();
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5400a(int i, String... strArr) {
        ActivityCompat.requestPermissions(m5410c(), strArr, i);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public boolean mo5401a(String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(m5410c(), str);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: b */
    public Context mo5402b() {
        return m5410c();
    }
}
