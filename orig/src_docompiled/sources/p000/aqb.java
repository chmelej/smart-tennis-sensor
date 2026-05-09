package p000;

/* JADX INFO: compiled from: MtopSyncResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class aqb {

    /* JADX INFO: renamed from: a */
    private volatile boolean f4623a;

    /* JADX INFO: renamed from: b */
    private volatile String f4624b;

    /* JADX INFO: renamed from: c */
    private volatile String f4625c;

    /* JADX INFO: renamed from: d */
    private volatile String f4626d;

    /* JADX INFO: renamed from: a */
    public final boolean m4984a() {
        return this.f4623a;
    }

    /* JADX INFO: renamed from: a */
    public final void m4983a(boolean z) {
        this.f4623a = z;
    }

    /* JADX INFO: renamed from: b */
    public final String m4985b() {
        return this.f4624b;
    }

    /* JADX INFO: renamed from: a */
    public final void m4982a(String str) {
        this.f4624b = str;
    }

    /* JADX INFO: renamed from: b */
    public final void m4986b(String str) {
        this.f4625c = str;
    }

    /* JADX INFO: renamed from: c */
    public final void m4987c(String str) {
        this.f4626d = str;
    }

    public final String toString() {
        return "Result [isSuccess=" + this.f4623a + ", data=" + this.f4624b + ", retDesc=" + this.f4625c + ", retCode=" + this.f4626d + "]";
    }
}
