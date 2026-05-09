package p000;

/* JADX INFO: compiled from: RemoteDfuExtendedErrorException.java */
/* JADX INFO: loaded from: classes.dex */
public class alu extends alt {

    /* JADX INFO: renamed from: a */
    private final int f1685a;

    public alu(String str, int i) {
        super(str, 11);
        this.f1685a = i;
    }

    /* JADX INFO: renamed from: b */
    public int m1908b() {
        return this.f1685a;
    }

    @Override // p000.alt, java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error 11." + this.f1685a + ")";
    }
}
