package p000;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class aao implements aax {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f60a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ boolean f61b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ acs f62c;

    aao(acs acsVar, List list, boolean z) {
        this.f62c = acsVar;
        this.f60a = list;
        this.f61b = z;
    }

    @Override // p000.aax
    /* JADX INFO: renamed from: a */
    public final void mo29a() {
        acd.m206b();
        this.f62c.m285b(this.f60a, this.f61b);
    }

    @Override // p000.aax
    /* JADX INFO: renamed from: b */
    public final void mo30b() {
        acd.m210c();
        this.f62c.m283a(this.f60a, this.f61b);
    }
}
