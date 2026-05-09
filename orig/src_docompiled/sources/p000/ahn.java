package p000;

/* JADX INFO: compiled from: MessageTime.java */
/* JADX INFO: loaded from: classes.dex */
class ahn {

    /* JADX INFO: renamed from: a */
    private boolean f1053a;

    /* JADX INFO: renamed from: b */
    private String f1054b;

    ahn(boolean z, String str) {
        this.f1053a = false;
        this.f1053a = z;
        this.f1054b = str;
    }

    /* JADX INFO: renamed from: a */
    long m1179a() {
        return this.f1053a ? 20000L : 300000L;
    }

    /* JADX INFO: renamed from: b */
    long m1181b() {
        return this.f1053a ? 20000L : 120000L;
    }

    /* JADX INFO: renamed from: c */
    long m1182c() {
        return this.f1053a ? 1000L : 2000L;
    }

    /* JADX INFO: renamed from: d */
    long m1183d() {
        if (this.f1053a) {
            return m1180a(2000L);
        }
        return m1180a(2000L);
    }

    /* JADX INFO: renamed from: a */
    long m1180a(long j) {
        long jM1295a = aib.m1295a(j, this.f1054b);
        if (jM1295a <= 2000) {
            return 2000L;
        }
        return jM1295a;
    }

    /* JADX INFO: renamed from: e */
    public long m1184e() {
        return this.f1053a ? 5000L : 40000L;
    }

    /* JADX INFO: renamed from: f */
    long m1185f() {
        return this.f1053a ? 10000L : 2000L;
    }

    /* JADX INFO: renamed from: g */
    long m1186g() {
        return this.f1053a ? 600000L : 1800000L;
    }

    /* JADX INFO: renamed from: h */
    long m1187h() {
        return this.f1053a ? 30000L : 60000L;
    }
}
