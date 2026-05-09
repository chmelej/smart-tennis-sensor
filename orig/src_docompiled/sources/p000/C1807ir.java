package p000;

/* JADX INFO: renamed from: ir */
/* JADX INFO: compiled from: LogConfigImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C1807ir implements InterfaceC1806iq {

    /* JADX INFO: renamed from: a */
    private static C1807ir f10364a;

    @Override // p000.InterfaceC1806iq
    /* JADX INFO: renamed from: a */
    public InterfaceC1806iq mo9818a(int i) {
        return this;
    }

    @Override // p000.InterfaceC1806iq
    /* JADX INFO: renamed from: a */
    public InterfaceC1806iq mo9819a(String str) {
        return this;
    }

    @Override // p000.InterfaceC1806iq
    /* JADX INFO: renamed from: a */
    public InterfaceC1806iq mo9820a(boolean z) {
        return this;
    }

    @Override // p000.InterfaceC1806iq
    /* JADX INFO: renamed from: b */
    public InterfaceC1806iq mo9821b(String str) {
        return this;
    }

    @Override // p000.InterfaceC1806iq
    /* JADX INFO: renamed from: b */
    public InterfaceC1806iq mo9822b(boolean z) {
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static C1807ir m9823a() {
        if (f10364a == null) {
            synchronized (C1807ir.class) {
                if (f10364a == null) {
                    f10364a = new C1807ir();
                }
            }
        }
        return f10364a;
    }
}
