package p000;

import android.util.Log;

/* JADX INFO: compiled from: BackgroundPoster.java */
/* JADX INFO: loaded from: classes.dex */
final class asc implements Runnable {

    /* JADX INFO: renamed from: a */
    private final asj f4910a = new asj();

    /* JADX INFO: renamed from: b */
    private final asd f4911b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f4912c;

    asc(asd asdVar) {
        this.f4911b = asdVar;
    }

    /* JADX INFO: renamed from: a */
    public void m5322a(aso asoVar, Object obj) {
        asi asiVarM5341a = asi.m5341a(asoVar, obj);
        synchronized (this) {
            this.f4910a.m5345a(asiVarM5341a);
            if (!this.f4912c) {
                this.f4912c = true;
                this.f4911b.m5336b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        asi asiVarM5344a;
        while (true) {
            try {
                asiVarM5344a = this.f4910a.m5344a(1000);
            } catch (InterruptedException e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.f4912c = false;
            }
            if (asiVarM5344a == null) {
                synchronized (this) {
                    asiVarM5344a = this.f4910a.m5343a();
                    if (asiVarM5344a == null) {
                        return;
                    }
                    this.f4912c = false;
                }
            }
            this.f4911b.m5333a(asiVarM5344a);
        }
    }
}
