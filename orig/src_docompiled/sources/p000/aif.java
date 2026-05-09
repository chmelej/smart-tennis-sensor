package p000;

/* JADX INFO: compiled from: ThreadUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class aif {

    /* JADX INFO: renamed from: a */
    private static int f1128a;

    /* JADX INFO: renamed from: a */
    private static final synchronized int m1310a() {
        int i;
        i = f1128a;
        f1128a = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static final void m1311a(Runnable runnable) {
        if (runnable != null) {
            try {
                new Thread(runnable, "agoo-thread-" + m1310a()).start();
            } catch (Throwable th) {
                aiv.m1421d("ThreadUtil", "startTread", th);
            }
        }
    }
}
