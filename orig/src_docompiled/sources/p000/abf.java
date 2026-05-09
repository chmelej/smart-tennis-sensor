package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class abf implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f99a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ace f100b = null;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ aag f101c;

    abf(Context context, aag aagVar) {
        this.f99a = context;
        this.f101c = aagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            aaf aafVar = new aaf(this.f99a, acd.m194a(this.f99a, false, this.f100b), this.f101c.f21a, this.f100b);
            aafVar.m17a().f23c = this.f101c.f23c;
            new aco(aafVar).m254a();
        } catch (Throwable th) {
            acd.f264q.m54b(th);
            acd.m202a(this.f99a, th);
        }
    }
}
