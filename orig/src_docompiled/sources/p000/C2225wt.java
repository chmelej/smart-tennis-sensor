package p000;

/* JADX INFO: renamed from: wt */
/* JADX INFO: compiled from: ThreadUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2225wt {

    /* JADX INFO: renamed from: wt$a */
    /* JADX INFO: compiled from: ThreadUtils.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private Thread f13379a = Thread.currentThread();

        /* JADX INFO: renamed from: a */
        public void m12164a() {
            if (this.f13379a == null) {
                this.f13379a = Thread.currentThread();
            }
            if (Thread.currentThread() != this.f13379a) {
                throw new IllegalStateException("Wrong thread");
            }
        }
    }
}
