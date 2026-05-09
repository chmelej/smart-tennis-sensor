package p000;

/* JADX INFO: compiled from: NoAspectBoundException.java */
/* JADX INFO: loaded from: classes.dex */
public class arl extends RuntimeException {

    /* JADX INFO: renamed from: a */
    Throwable f4860a;

    public arl(String str, Throwable th) {
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception while initializing ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(th);
            str = stringBuffer.toString();
        }
        super(str);
        this.f4860a = th;
    }

    public arl() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4860a;
    }
}
