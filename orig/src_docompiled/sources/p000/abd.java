package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class abd implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f97a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Throwable f98b;

    abd(Context context, Throwable th) {
        this.f97a = context;
        this.f98b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (acb.m169c()) {
                new aco(new aah(this.f97a, acd.m194a(this.f97a, false, (ace) null), this.f98b, aak.f51a)).m254a();
            }
        } catch (Throwable th) {
            acd.f264q.m57e("reportSdkSelfException error: " + th);
        }
    }
}
