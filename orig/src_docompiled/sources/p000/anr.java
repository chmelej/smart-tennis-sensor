package p000;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.BufferedSink;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class anr implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    static final Pattern f4248a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: j */
    static final /* synthetic */ boolean f4249j = true;

    /* JADX INFO: renamed from: b */
    final apb f4250b;

    /* JADX INFO: renamed from: c */
    final int f4251c;

    /* JADX INFO: renamed from: d */
    BufferedSink f4252d;

    /* JADX INFO: renamed from: e */
    final LinkedHashMap<String, C0676b> f4253e;

    /* JADX INFO: renamed from: f */
    int f4254f;

    /* JADX INFO: renamed from: g */
    boolean f4255g;

    /* JADX INFO: renamed from: h */
    boolean f4256h;

    /* JADX INFO: renamed from: i */
    boolean f4257i;

    /* JADX INFO: renamed from: k */
    private long f4258k;

    /* JADX INFO: renamed from: l */
    private long f4259l;

    /* JADX INFO: renamed from: m */
    private long f4260m;

    /* JADX INFO: renamed from: n */
    private final Executor f4261n;

    /* JADX INFO: renamed from: o */
    private final Runnable f4262o;

    /* JADX INFO: renamed from: a */
    synchronized void m4540a(C0675a c0675a, boolean z) {
        C0676b c0676b = c0675a.f4263a;
        if (c0676b.f4272f != c0675a) {
            throw new IllegalStateException();
        }
        if (z && !c0676b.f4271e) {
            for (int i = 0; i < this.f4251c; i++) {
                if (!c0675a.f4264b[i]) {
                    c0675a.m4546b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.f4250b.mo4816b(c0676b.f4270d[i])) {
                    c0675a.m4546b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f4251c; i2++) {
            File file = c0676b.f4270d[i2];
            if (z) {
                if (this.f4250b.mo4816b(file)) {
                    File file2 = c0676b.f4269c[i2];
                    this.f4250b.mo4815a(file, file2);
                    long j = c0676b.f4268b[i2];
                    long jMo4817c = this.f4250b.mo4817c(file2);
                    c0676b.f4268b[i2] = jMo4817c;
                    this.f4259l = (this.f4259l - j) + jMo4817c;
                }
            } else {
                this.f4250b.mo4814a(file);
            }
        }
        this.f4254f++;
        c0676b.f4272f = null;
        if (c0676b.f4271e | z) {
            c0676b.f4271e = f4249j;
            this.f4252d.writeUtf8("CLEAN").writeByte(32);
            this.f4252d.writeUtf8(c0676b.f4267a);
            c0676b.m4547a(this.f4252d);
            this.f4252d.writeByte(10);
            if (z) {
                long j2 = this.f4260m;
                this.f4260m = j2 + 1;
                c0676b.f4273g = j2;
            }
        } else {
            this.f4253e.remove(c0676b.f4267a);
            this.f4252d.writeUtf8("REMOVE").writeByte(32);
            this.f4252d.writeUtf8(c0676b.f4267a);
            this.f4252d.writeByte(10);
        }
        this.f4252d.flush();
        if (this.f4259l > this.f4258k || m4541a()) {
            this.f4261n.execute(this.f4262o);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m4541a() {
        if (this.f4254f < 2000 || this.f4254f < this.f4253e.size()) {
            return false;
        }
        return f4249j;
    }

    /* JADX INFO: renamed from: a */
    boolean m4542a(C0676b c0676b) {
        if (c0676b.f4272f != null) {
            c0676b.f4272f.m4545a();
        }
        for (int i = 0; i < this.f4251c; i++) {
            this.f4250b.mo4814a(c0676b.f4269c[i]);
            this.f4259l -= c0676b.f4268b[i];
            c0676b.f4268b[i] = 0;
        }
        this.f4254f++;
        this.f4252d.writeUtf8("REMOVE").writeByte(32).writeUtf8(c0676b.f4267a).writeByte(10);
        this.f4253e.remove(c0676b.f4267a);
        if (m4541a()) {
            this.f4261n.execute(this.f4262o);
        }
        return f4249j;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m4543b() {
        return this.f4256h;
    }

    /* JADX INFO: renamed from: d */
    private synchronized void m4539d() {
        if (m4543b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.f4255g) {
            m4539d();
            m4544c();
            this.f4252d.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f4255g && !this.f4256h) {
            for (C0676b c0676b : (C0676b[]) this.f4253e.values().toArray(new C0676b[this.f4253e.size()])) {
                if (c0676b.f4272f != null) {
                    c0676b.f4272f.m4546b();
                }
            }
            m4544c();
            this.f4252d.close();
            this.f4252d = null;
            this.f4256h = f4249j;
            return;
        }
        this.f4256h = f4249j;
    }

    /* JADX INFO: renamed from: c */
    void m4544c() {
        while (this.f4259l > this.f4258k) {
            m4542a(this.f4253e.values().iterator().next());
        }
        this.f4257i = false;
    }

    /* JADX INFO: renamed from: anr$a */
    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class C0675a {

        /* JADX INFO: renamed from: a */
        final C0676b f4263a;

        /* JADX INFO: renamed from: b */
        final boolean[] f4264b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ anr f4265c;

        /* JADX INFO: renamed from: d */
        private boolean f4266d;

        /* JADX INFO: renamed from: a */
        void m4545a() {
            if (this.f4263a.f4272f == this) {
                for (int i = 0; i < this.f4265c.f4251c; i++) {
                    try {
                        this.f4265c.f4250b.mo4814a(this.f4263a.f4270d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f4263a.f4272f = null;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m4546b() {
            synchronized (this.f4265c) {
                if (this.f4266d) {
                    throw new IllegalStateException();
                }
                if (this.f4263a.f4272f == this) {
                    this.f4265c.m4540a(this, false);
                }
                this.f4266d = anr.f4249j;
            }
        }
    }

    /* JADX INFO: renamed from: anr$b */
    /* JADX INFO: compiled from: DiskLruCache.java */
    final class C0676b {

        /* JADX INFO: renamed from: a */
        final String f4267a;

        /* JADX INFO: renamed from: b */
        final long[] f4268b;

        /* JADX INFO: renamed from: c */
        final File[] f4269c;

        /* JADX INFO: renamed from: d */
        final File[] f4270d;

        /* JADX INFO: renamed from: e */
        boolean f4271e;

        /* JADX INFO: renamed from: f */
        C0675a f4272f;

        /* JADX INFO: renamed from: g */
        long f4273g;

        /* JADX INFO: renamed from: a */
        void m4547a(BufferedSink bufferedSink) {
            for (long j : this.f4268b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }
}
