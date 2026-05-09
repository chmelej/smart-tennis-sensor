package p000;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p000.anz;

/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class amo {

    /* JADX INFO: renamed from: c */
    static final /* synthetic */ boolean f1870c = true;

    /* JADX INFO: renamed from: d */
    private static final Executor f1871d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), anm.m4503a("OkHttp ConnectionPool", true));

    /* JADX INFO: renamed from: a */
    final anw f1872a;

    /* JADX INFO: renamed from: b */
    boolean f1873b;

    /* JADX INFO: renamed from: e */
    private final int f1874e;

    /* JADX INFO: renamed from: f */
    private final long f1875f;

    /* JADX INFO: renamed from: g */
    private final Runnable f1876g;

    /* JADX INFO: renamed from: h */
    private final Deque<anv> f1877h;

    public amo() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public amo(int i, long j, TimeUnit timeUnit) {
        this.f1876g = new Runnable() { // from class: amo.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jM1983a = amo.this.m1983a(System.nanoTime());
                    if (jM1983a == -1) {
                        return;
                    }
                    if (jM1983a > 0) {
                        long j2 = jM1983a / 1000000;
                        long j3 = jM1983a - (1000000 * j2);
                        synchronized (amo.this) {
                            try {
                                amo.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f1877h = new ArrayDeque();
        this.f1872a = new anw();
        this.f1874e = i;
        this.f1875f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    anv m1984a(amf amfVar, anz anzVar, ani aniVar) {
        if (!f1870c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (anv anvVar : this.f1877h) {
            if (anvVar.m4568a(amfVar, aniVar)) {
                anzVar.m4600a(anvVar, true);
                return anvVar;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    Socket m1985a(amf amfVar, anz anzVar) {
        if (!f1870c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (anv anvVar : this.f1877h) {
            if (anvVar.m4568a(amfVar, null) && anvVar.m4573d() && anvVar != anzVar.m4604c()) {
                return anzVar.m4599a(anvVar);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m1986a(anv anvVar) {
        if (!f1870c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f1873b) {
            this.f1873b = true;
            f1871d.execute(this.f1876g);
        }
        this.f1877h.add(anvVar);
    }

    /* JADX INFO: renamed from: b */
    boolean m1987b(anv anvVar) {
        if (!f1870c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (anvVar.f4279a || this.f1874e == 0) {
            this.f1877h.remove(anvVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* JADX INFO: renamed from: a */
    long m1983a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            anv anvVar = null;
            int i = 0;
            int i2 = 0;
            for (anv anvVar2 : this.f1877h) {
                if (m1982a(anvVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - anvVar2.f4283e;
                    if (j3 > j2) {
                        anvVar = anvVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f1875f && i <= this.f1874e) {
                if (i > 0) {
                    return this.f1875f - j2;
                }
                if (i2 > 0) {
                    return this.f1875f;
                }
                this.f1873b = false;
                return -1L;
            }
            this.f1877h.remove(anvVar);
            anm.m4508a(anvVar.mo1981a());
            return 0L;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1982a(anv anvVar, long j) {
        List<Reference<anz>> list = anvVar.f4282d;
        int i = 0;
        while (i < list.size()) {
            Reference<anz> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                aph.m4853c().mo4826a("A connection to " + anvVar.m4571b().m4483a().m1935a() + " was leaked. Did you forget to close a response body?", ((anz.C0678a) reference).f4321a);
                list.remove(i);
                anvVar.f4279a = true;
                if (list.isEmpty()) {
                    anvVar.f4283e = j - this.f1875f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
