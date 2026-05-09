package p000;

import android.os.SystemClock;

/* JADX INFO: compiled from: DfuProgressInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class alg {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0188a f1588a;

    /* JADX INFO: renamed from: b */
    private int f1589b;

    /* JADX INFO: renamed from: c */
    private int f1590c;

    /* JADX INFO: renamed from: d */
    private int f1591d;

    /* JADX INFO: renamed from: e */
    private int f1592e;

    /* JADX INFO: renamed from: f */
    private int f1593f;

    /* JADX INFO: renamed from: g */
    private int f1594g;

    /* JADX INFO: renamed from: h */
    private int f1595h;

    /* JADX INFO: renamed from: i */
    private int f1596i;

    /* JADX INFO: renamed from: j */
    private int f1597j;

    /* JADX INFO: renamed from: k */
    private long f1598k;

    /* JADX INFO: renamed from: l */
    private long f1599l;

    /* JADX INFO: renamed from: alg$a */
    /* JADX INFO: compiled from: DfuProgressInfo.java */
    public interface InterfaceC0188a {
        /* JADX INFO: renamed from: b */
        void mo1860b();
    }

    public alg(InterfaceC0188a interfaceC0188a) {
        this.f1588a = interfaceC0188a;
    }

    /* JADX INFO: renamed from: a */
    alg m1844a(int i, int i2, int i3) {
        this.f1594g = i;
        this.f1595h = Integer.MAX_VALUE;
        this.f1596i = i2;
        this.f1597j = i3;
        return this;
    }

    /* JADX INFO: renamed from: a */
    alg m1843a(int i) {
        this.f1597j = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public void m1846b(int i) {
        this.f1589b = i;
        this.f1588a.mo1860b();
    }

    /* JADX INFO: renamed from: c */
    void m1849c(int i) {
        if (this.f1598k == 0) {
            this.f1598k = SystemClock.elapsedRealtime();
            this.f1591d = i;
        }
        this.f1590c = i;
        this.f1589b = (int) ((i * 100.0f) / this.f1594g);
        this.f1588a.mo1860b();
    }

    /* JADX INFO: renamed from: d */
    void m1851d(int i) {
        m1849c(this.f1590c + i);
    }

    /* JADX INFO: renamed from: e */
    void m1853e(int i) {
        this.f1593f = i;
    }

    /* JADX INFO: renamed from: f */
    void m1855f(int i) {
        this.f1595h = i;
    }

    /* JADX INFO: renamed from: a */
    boolean m1845a() {
        return this.f1590c == this.f1594g;
    }

    /* JADX INFO: renamed from: b */
    boolean m1847b() {
        return this.f1590c % this.f1595h == 0;
    }

    /* JADX INFO: renamed from: c */
    int m1848c() {
        return Math.min(this.f1594g - this.f1590c, this.f1595h - (this.f1590c % this.f1595h));
    }

    /* JADX INFO: renamed from: d */
    public int m1850d() {
        return this.f1589b;
    }

    /* JADX INFO: renamed from: e */
    int m1852e() {
        return this.f1590c;
    }

    /* JADX INFO: renamed from: f */
    public float m1854f() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        float f = jElapsedRealtime - this.f1598k != 0 ? (this.f1590c - this.f1592e) / (jElapsedRealtime - this.f1599l) : 0.0f;
        this.f1599l = jElapsedRealtime;
        this.f1592e = this.f1590c;
        return f;
    }

    /* JADX INFO: renamed from: g */
    public float m1856g() {
        if (SystemClock.elapsedRealtime() - this.f1598k != 0) {
            return (this.f1590c - this.f1591d) / (r0 - this.f1598k);
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: h */
    public int m1857h() {
        return this.f1596i;
    }

    /* JADX INFO: renamed from: i */
    public int m1858i() {
        return this.f1597j;
    }

    /* JADX INFO: renamed from: j */
    boolean m1859j() {
        return this.f1596i == this.f1597j;
    }
}
