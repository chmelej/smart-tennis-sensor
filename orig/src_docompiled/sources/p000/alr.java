package p000;

/* JADX INFO: compiled from: DfuException.java */
/* JADX INFO: loaded from: classes.dex */
public class alr extends Exception {

    /* JADX INFO: renamed from: a */
    private final int f1683a;

    public alr(String str, int i) {
        super(str);
        this.f1683a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m1906a() {
        return this.f1683a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + (this.f1683a & (-16385)) + ")";
    }
}
