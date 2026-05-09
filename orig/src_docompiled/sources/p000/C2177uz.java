package p000;

/* JADX INFO: renamed from: uz */
/* JADX INFO: compiled from: FPSController.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2177uz {

    /* JADX INFO: renamed from: a */
    private int f12994a = 30;

    /* JADX INFO: renamed from: b */
    private float f12995b = -1.0f;

    /* JADX INFO: renamed from: c */
    private float f12996c = 0.0f;

    /* JADX INFO: renamed from: d */
    private long f12997d = 0;

    /* JADX INFO: renamed from: e */
    private long f12998e = 0;

    /* JADX INFO: renamed from: a */
    public boolean m11880a() {
        this.f12997d++;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f12997d != 0 && jCurrentTimeMillis - this.f12998e > 1000) {
            int iRound = Math.round((this.f12997d * 1000) / (jCurrentTimeMillis - this.f12998e));
            this.f12998e = jCurrentTimeMillis;
            this.f12997d = 0L;
            if (iRound <= this.f12994a) {
                this.f12995b = -1.0f;
            } else {
                this.f12995b = iRound / (iRound - this.f12994a);
            }
            C2201vw.f13217f.m12051b("FPSController", "average fps = " + iRound + ", delta fps = " + this.f12995b);
        }
        if (this.f12995b < 0.0f) {
            return false;
        }
        this.f12996c += 1.0f;
        if (this.f12996c < this.f12995b) {
            return false;
        }
        this.f12996c -= this.f12995b;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m11879a(int i) {
        this.f12994a = i;
        C2201vw.f13217f.m12053c("FPSController", "set desire fps:" + this.f12994a);
    }
}
