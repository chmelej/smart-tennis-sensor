package p000;

/* JADX INFO: renamed from: eb */
/* JADX INFO: compiled from: TwilightCalculator.java */
/* JADX INFO: loaded from: classes.dex */
class C1681eb {

    /* JADX INFO: renamed from: d */
    private static C1681eb f9460d;

    /* JADX INFO: renamed from: a */
    public long f9461a;

    /* JADX INFO: renamed from: b */
    public long f9462b;

    /* JADX INFO: renamed from: c */
    public int f9463c;

    C1681eb() {
    }

    /* JADX INFO: renamed from: a */
    static C1681eb m8934a() {
        if (f9460d == null) {
            f9460d = new C1681eb();
        }
        return f9460d;
    }

    /* JADX INFO: renamed from: a */
    public void m8935a(long j, double d, double d2) {
        double d3 = (0.01720197f * ((j - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin(2.0f * r5) * 3.4906598739326E-4d) + (Math.sin(r5 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = ((double) (Math.round(((double) (r4 - 9.0E-4f)) - r10) + 9.0E-4f)) + ((-d2) / 360.0d) + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(dAsin))) / (Math.cos(d4) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f9463c = 1;
            this.f9461a = -1L;
            this.f9462b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f9463c = 0;
                this.f9461a = -1L;
                this.f9462b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f9461a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            this.f9462b = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            if (this.f9462b < j && this.f9461a > j) {
                this.f9463c = 0;
            } else {
                this.f9463c = 1;
            }
        }
    }
}
