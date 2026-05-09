package p000;

/* JADX INFO: compiled from: NamedRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class anl implements Runnable {

    /* JADX INFO: renamed from: b */
    protected final String f4206b;

    /* JADX INFO: renamed from: c */
    protected abstract void mo2184c();

    public anl(String str, Object... objArr) {
        this.f4206b = anm.m4498a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4206b);
        try {
            mo2184c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
