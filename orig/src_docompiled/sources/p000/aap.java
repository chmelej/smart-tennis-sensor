package p000;

/* JADX INFO: loaded from: classes.dex */
final class aap implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ int f63a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ acs f64b;

    aap(acs acsVar, int i) {
        this.f64b = acsVar;
        this.f63a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        acs.m259a(this.f64b, this.f63a, true);
        acs.m259a(this.f64b, this.f63a, false);
    }
}
