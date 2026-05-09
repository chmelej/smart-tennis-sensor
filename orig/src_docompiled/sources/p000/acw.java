package p000;

/* JADX INFO: loaded from: classes.dex */
final class acw implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aai f329a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ aax f330b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ boolean f331c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ boolean f332d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ acs f333e;

    acw(acs acsVar, aai aaiVar, aax aaxVar, boolean z, boolean z2) {
        this.f333e = acsVar;
        this.f329a = aaiVar;
        this.f330b = aaxVar;
        this.f331c = z;
        this.f332d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f333e.m268b(this.f329a, this.f330b, this.f331c, this.f332d);
    }
}
