package p000;

/* JADX INFO: compiled from: PendingPostQueue.java */
/* JADX INFO: loaded from: classes.dex */
final class akj {

    /* JADX INFO: renamed from: a */
    private aki f1476a;

    /* JADX INFO: renamed from: b */
    private aki f1477b;

    akj() {
    }

    /* JADX INFO: renamed from: a */
    synchronized void m1729a(aki akiVar) {
        try {
            if (akiVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f1477b != null) {
                this.f1477b.f1475c = akiVar;
                this.f1477b = akiVar;
            } else if (this.f1476a == null) {
                this.f1477b = akiVar;
                this.f1476a = akiVar;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized aki m1727a() {
        aki akiVar;
        akiVar = this.f1476a;
        if (this.f1476a != null) {
            this.f1476a = this.f1476a.f1475c;
            if (this.f1476a == null) {
                this.f1477b = null;
            }
        }
        return akiVar;
    }

    /* JADX INFO: renamed from: a */
    synchronized aki m1728a(int i) {
        if (this.f1476a == null) {
            wait(i);
        }
        return m1727a();
    }
}
