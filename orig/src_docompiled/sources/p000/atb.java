package p000;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/* JADX INFO: compiled from: AppCompatActivityPermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
class atb extends atd<AppCompatActivity> {
    public atb(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    @Override // p000.atd
    /* JADX INFO: renamed from: a */
    public FragmentManager mo5403a() {
        return m5410c().getSupportFragmentManager();
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
