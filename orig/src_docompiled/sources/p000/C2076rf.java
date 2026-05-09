package p000;

/* JADX INFO: renamed from: rf */
/* JADX INFO: compiled from: FailReason.java */
/* JADX INFO: loaded from: classes.dex */
public class C2076rf {

    /* JADX INFO: renamed from: a */
    private final a f12557a;

    /* JADX INFO: renamed from: b */
    private final Throwable f12558b;

    /* JADX INFO: renamed from: rf$a */
    /* JADX INFO: compiled from: FailReason.java */
    public enum a {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public C2076rf(a aVar, Throwable th) {
        this.f12557a = aVar;
        this.f12558b = th;
    }
}
