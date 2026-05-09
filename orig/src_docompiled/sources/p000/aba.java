package p000;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class aba implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ List f91a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ aax f92b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ aay f93c;

    aba(aay aayVar, List list, aax aaxVar) {
        this.f93c = aayVar;
        this.f91a = list;
        this.f92b = aaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f93c.m40a(this.f91a, this.f92b);
    }
}
