package p000;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
final class aau extends TimerTask {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aat f75a;

    aau(aat aatVar) {
        this.f75a = aatVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (acb.m166b()) {
            abt.m89c().m51a("TimerTask run");
        }
        acd.m217f(this.f75a.f74c);
        cancel();
        this.f75a.m35a();
    }
}
