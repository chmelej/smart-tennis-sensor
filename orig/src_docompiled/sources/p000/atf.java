package p000;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/* JADX INFO: compiled from: LowApiPermissionsHelper.java */
/* JADX INFO: loaded from: classes.dex */
class atf<T> extends atg<T> {
    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public boolean mo5401a(String str) {
        return false;
    }

    public atf(T t) {
        super(t);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5400a(int i, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5404a(String str, String str2, String str3, int i, int i2, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: b */
    public Context mo5402b() {
        if (m5410c() instanceof Activity) {
            return (Context) m5410c();
        }
        if (m5410c() instanceof Fragment) {
            return ((Fragment) m5410c()).getContext();
        }
        if (m5410c() instanceof android.app.Fragment) {
            return ((android.app.Fragment) m5410c()).getActivity();
        }
        throw new IllegalStateException("Unknown host: " + m5410c());
    }
}
