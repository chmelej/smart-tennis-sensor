package p000;

/* JADX INFO: loaded from: classes.dex */
final class acx implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aav f334a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ acs f335b;

    acx(acs acsVar, aav aavVar) {
        this.f335b = acsVar;
        this.f334a = aavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f335b.m269b(this.f334a);
    }
}
