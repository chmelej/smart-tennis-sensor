package p000;

/* JADX INFO: renamed from: wa */
/* JADX INFO: compiled from: WorkThread.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRunnableC2206wa implements Runnable {

    /* JADX INFO: renamed from: a */
    private volatile boolean f13250a = false;

    /* JADX INFO: renamed from: b */
    private volatile boolean f13251b = false;

    /* JADX INFO: renamed from: c */
    private Thread f13252c;

    /* JADX INFO: renamed from: b */
    protected abstract String mo8629b();

    /* JADX INFO: renamed from: b_ */
    public boolean mo12002b_() {
        C2201vw.f13212a.m12053c(mo8629b(), "start +");
        if (this.f13250a) {
            C2201vw.f13212a.m12054d(mo8629b(), "already started !");
            return false;
        }
        this.f13250a = true;
        m12084b(false);
        this.f13252c = new Thread(this, mo8629b());
        this.f13252c.start();
        C2201vw.f13212a.m12053c(mo8629b(), "start -");
        return true;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo12011h() {
        C2201vw.f13212a.m12053c(mo8629b(), "stop +");
        if (!this.f13250a) {
            C2201vw.f13212a.m12054d(mo8629b(), "already stopped !");
            return false;
        }
        m12084b(true);
        this.f13250a = false;
        C2201vw.f13212a.m12053c(mo8629b(), "stop -");
        return true;
    }

    /* JADX INFO: renamed from: l */
    protected boolean m12085l() {
        return this.f13251b;
    }

    /* JADX INFO: renamed from: b */
    protected void m12084b(boolean z) {
        this.f13251b = z;
    }
}
