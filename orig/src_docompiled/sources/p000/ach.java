package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class ach implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f284a;

    ach(Context context) {
        this.f284a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            new Thread(new acn(this.f284a), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            acd.f264q.m54b(th);
            acd.m202a(this.f284a, th);
        }
    }
}
