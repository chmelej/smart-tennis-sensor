package p000;

/* JADX INFO: compiled from: RemoteDfuException.java */
/* JADX INFO: loaded from: classes.dex */
public class alt extends Exception {

    /* JADX INFO: renamed from: a */
    private final int f1684a;

    public alt(String str, int i) {
        super(str);
        this.f1684a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m1907a() {
        return this.f1684a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + this.f1684a + ")";
    }
}
