package p000;

/* JADX INFO: renamed from: h */
/* JADX INFO: compiled from: Lifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1762h {

    /* JADX INFO: renamed from: h$a */
    /* JADX INFO: compiled from: Lifecycle.java */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* JADX INFO: renamed from: a */
    public abstract b mo9592a();

    /* JADX INFO: renamed from: a */
    public abstract void mo9593a(InterfaceC1789i interfaceC1789i);

    /* JADX INFO: renamed from: b */
    public abstract void mo9594b(InterfaceC1789i interfaceC1789i);

    /* JADX INFO: renamed from: h$b */
    /* JADX INFO: compiled from: Lifecycle.java */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* JADX INFO: renamed from: a */
        public boolean m9595a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
