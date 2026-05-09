package p000;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class act implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f319a;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ boolean f321c;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ acs f323e;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f320b = 1;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ boolean f322d = true;

    act(acs acsVar, List list, boolean z) {
        this.f323e = acsVar;
        this.f319a = list;
        this.f321c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f323e.m264a((List<aar>) this.f319a, this.f320b, this.f321c);
        if (this.f322d) {
            this.f319a.clear();
        }
    }
}
