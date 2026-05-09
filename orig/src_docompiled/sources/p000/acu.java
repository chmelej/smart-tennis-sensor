package p000;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class acu implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f324a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ boolean f325b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ boolean f326c = true;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ acs f327d;

    acu(acs acsVar, List list, boolean z) {
        this.f327d = acsVar;
        this.f324a = list;
        this.f325b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f327d.m271c(this.f324a, this.f325b);
        if (this.f326c) {
            this.f324a.clear();
        }
    }
}
