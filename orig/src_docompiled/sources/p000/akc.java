package p000;

import android.util.Log;

/* JADX INFO: compiled from: BackgroundPoster.java */
/* JADX INFO: loaded from: classes.dex */
final class akc implements Runnable {

    /* JADX INFO: renamed from: a */
    private final akj f1427a = new akj();

    /* JADX INFO: renamed from: b */
    private final akd f1428b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f1429c;

    akc(akd akdVar) {
        this.f1428b = akdVar;
    }

    /* JADX INFO: renamed from: a */
    public void m1705a(akn aknVar, Object obj) {
        aki akiVarM1725a = aki.m1725a(aknVar, obj);
        synchronized (this) {
            this.f1427a.m1729a(akiVarM1725a);
            if (!this.f1429c) {
                this.f1429c = true;
                this.f1428b.m1720b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        aki akiVarM1728a;
        while (true) {
            try {
                akiVarM1728a = this.f1427a.m1728a(1000);
            } catch (InterruptedException e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.f1429c = false;
            }
            if (akiVarM1728a == null) {
                synchronized (this) {
                    akiVarM1728a = this.f1427a.m1727a();
                    if (akiVarM1728a == null) {
                        return;
                    }
                    this.f1429c = false;
                }
            }
            this.f1428b.m1717a(akiVarM1728a);
        }
    }
}
