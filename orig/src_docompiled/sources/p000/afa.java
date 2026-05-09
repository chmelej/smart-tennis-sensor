package p000;

/* JADX INFO: compiled from: SafeRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class afa implements Runnable {
    /* JADX INFO: renamed from: a */
    public abstract void mo314a();

    @Override // java.lang.Runnable
    public void run() {
        try {
            mo314a();
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
