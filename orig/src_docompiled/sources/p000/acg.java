package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class acg implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f282a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f283b = -1;

    acg(Context context) {
        this.f282a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            acd.m215e(this.f282a);
            acs.m255a(this.f282a).m280a(this.f283b);
        } catch (Throwable th) {
            acd.f264q.m54b(th);
            acd.m202a(this.f282a, th);
        }
    }
}
