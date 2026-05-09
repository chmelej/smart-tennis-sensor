package p000;

/* JADX INFO: compiled from: PendingPostQueue.java */
/* JADX INFO: loaded from: classes.dex */
final class asj {

    /* JADX INFO: renamed from: a */
    private asi f4962a;

    /* JADX INFO: renamed from: b */
    private asi f4963b;

    asj() {
    }

    /* JADX INFO: renamed from: a */
    synchronized void m5345a(asi asiVar) {
        try {
            if (asiVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f4963b != null) {
                this.f4963b.f4961c = asiVar;
                this.f4963b = asiVar;
            } else if (this.f4962a == null) {
                this.f4963b = asiVar;
                this.f4962a = asiVar;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized asi m5343a() {
        asi asiVar;
        asiVar = this.f4962a;
        if (this.f4962a != null) {
            this.f4962a = this.f4962a.f4961c;
            if (this.f4962a == null) {
                this.f4963b = null;
            }
        }
        return asiVar;
    }

    /* JADX INFO: renamed from: a */
    synchronized asi m5344a(int i) {
        if (this.f4962a == null) {
            wait(i);
        }
        return m5343a();
    }
}
