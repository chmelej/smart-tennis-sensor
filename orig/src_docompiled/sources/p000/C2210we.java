package p000;

/* JADX INFO: renamed from: we */
/* JADX INFO: compiled from: EglCore.java */
/* JADX INFO: loaded from: classes.dex */
public class C2210we {

    /* JADX INFO: renamed from: a */
    private InterfaceC2209wd f13260a;

    public C2210we(Object obj, int i) {
        if (C2200vv.m12042b()) {
            this.f13260a = new C2208wc(obj, i);
        } else {
            this.f13260a = new C2207wb(obj, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12099a() {
        this.f13260a.mo12089a();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f13260a != null) {
                this.f13260a.finalize();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12100a(Object obj) {
        this.f13260a.mo12090a(obj);
    }

    /* JADX INFO: renamed from: b */
    public Object m12102b(Object obj) {
        return this.f13260a.mo12092b(obj);
    }

    /* JADX INFO: renamed from: c */
    public void m12103c(Object obj) {
        this.f13260a.mo12093c(obj);
    }

    /* JADX INFO: renamed from: d */
    public boolean m12104d(Object obj) {
        return this.f13260a.mo12094d(obj);
    }

    /* JADX INFO: renamed from: a */
    public void m12101a(Object obj, long j) {
        this.f13260a.mo12091a(obj, j);
    }

    /* JADX INFO: renamed from: b */
    public static Object m12098b() {
        if (C2200vv.m12042b()) {
            return C2208wc.m12097b();
        }
        return C2207wb.m12088b();
    }
}
