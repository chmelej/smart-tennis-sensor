package p000;

import android.util.Log;
import p000.C2295zi;

/* JADX INFO: renamed from: zj */
/* JADX INFO: loaded from: classes.dex */
final class C2296zj implements C2295zi.a {
    C2296zj() {
    }

    @Override // p000.C2295zi.a
    /* JADX INFO: renamed from: a */
    public final int mo12553a() {
        return C2295zi.f13786b;
    }

    @Override // p000.C2295zi.a
    /* JADX INFO: renamed from: a */
    public final void mo12554a(String str, String str2) {
        if (C2295zi.f13786b <= 2) {
            Log.i(str, str2);
        }
    }

    @Override // p000.C2295zi.a
    /* JADX INFO: renamed from: b */
    public final void mo12555b(String str, String str2) {
        if (C2295zi.f13786b <= 1) {
            Log.d(str, str2);
        }
    }

    @Override // p000.C2295zi.a
    /* JADX INFO: renamed from: c */
    public final void mo12556c(String str, String str2) {
        if (C2295zi.f13786b <= 3) {
            Log.w(str, str2);
        }
    }

    @Override // p000.C2295zi.a
    /* JADX INFO: renamed from: d */
    public final void mo12557d(String str, String str2) {
        if (C2295zi.f13786b <= 4) {
            Log.e(str, str2);
        }
    }
}
