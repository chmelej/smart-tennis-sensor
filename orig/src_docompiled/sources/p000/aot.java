package p000;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import p000.aou;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes.dex */
public final class aot implements Closeable {

    /* JADX INFO: renamed from: r */
    static final /* synthetic */ boolean f4441r = true;

    /* JADX INFO: renamed from: s */
    private static final ExecutorService f4442s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), anm.m4503a("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: a */
    final boolean f4443a;

    /* JADX INFO: renamed from: b */
    final AbstractC0699b f4444b;

    /* JADX INFO: renamed from: d */
    final String f4446d;

    /* JADX INFO: renamed from: e */
    int f4447e;

    /* JADX INFO: renamed from: f */
    int f4448f;

    /* JADX INFO: renamed from: g */
    boolean f4449g;

    /* JADX INFO: renamed from: h */
    final aoy f4450h;

    /* JADX INFO: renamed from: j */
    long f4452j;

    /* JADX INFO: renamed from: n */
    final Socket f4456n;

    /* JADX INFO: renamed from: o */
    final aow f4457o;

    /* JADX INFO: renamed from: p */
    final C0701d f4458p;

    /* JADX INFO: renamed from: t */
    private final ScheduledExecutorService f4460t;

    /* JADX INFO: renamed from: u */
    private final ExecutorService f4461u;

    /* JADX INFO: renamed from: v */
    private boolean f4462v;

    /* JADX INFO: renamed from: c */
    final Map<Integer, aov> f4445c = new LinkedHashMap();

    /* JADX INFO: renamed from: i */
    long f4451i = 0;

    /* JADX INFO: renamed from: k */
    aoz f4453k = new aoz();

    /* JADX INFO: renamed from: l */
    final aoz f4454l = new aoz();

    /* JADX INFO: renamed from: m */
    boolean f4455m = false;

    /* JADX INFO: renamed from: q */
    final Set<Integer> f4459q = new LinkedHashSet();

    /* JADX INFO: renamed from: aot$b */
    /* JADX INFO: compiled from: Http2Connection.java */
    public static abstract class AbstractC0699b {

        /* JADX INFO: renamed from: f */
        public static final AbstractC0699b f4492f = new AbstractC0699b() { // from class: aot.b.1
            @Override // p000.aot.AbstractC0699b
            /* JADX INFO: renamed from: a */
            public void mo4567a(aov aovVar) {
                aovVar.m4756a(aoo.REFUSED_STREAM);
            }
        };

        /* JADX INFO: renamed from: a */
        public void mo4566a(aot aotVar) {
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo4567a(aov aovVar);
    }

    /* JADX INFO: renamed from: c */
    boolean m4720c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    aot(C0698a c0698a) {
        this.f4450h = c0698a.f4489f;
        this.f4443a = c0698a.f4490g;
        this.f4444b = c0698a.f4488e;
        this.f4448f = c0698a.f4490g ? 1 : 2;
        if (c0698a.f4490g) {
            this.f4448f += 2;
        }
        if (c0698a.f4490g) {
            this.f4453k.m4804a(7, 16777216);
        }
        this.f4446d = c0698a.f4485b;
        this.f4460t = new ScheduledThreadPoolExecutor(1, anm.m4503a(anm.m4498a("OkHttp %s Writer", this.f4446d), false));
        if (c0698a.f4491h != 0) {
            this.f4460t.scheduleAtFixedRate(new C0700c(false, 0, 0), c0698a.f4491h, c0698a.f4491h, TimeUnit.MILLISECONDS);
        }
        this.f4461u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), anm.m4503a(anm.m4498a("OkHttp %s Push Observer", this.f4446d), true));
        this.f4454l.m4804a(7, 65535);
        this.f4454l.m4804a(5, 16384);
        this.f4452j = this.f4454l.m4812d();
        this.f4456n = c0698a.f4484a;
        this.f4457o = new aow(c0698a.f4487d, this.f4443a);
        this.f4458p = new C0701d(new aou(c0698a.f4486c, this.f4443a));
    }

    /* JADX INFO: renamed from: a */
    synchronized aov m4702a(int i) {
        return this.f4445c.get(Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    synchronized aov m4715b(int i) {
        aov aovVarRemove;
        aovVarRemove = this.f4445c.remove(Integer.valueOf(i));
        notifyAll();
        return aovVarRemove;
    }

    /* JADX INFO: renamed from: a */
    public synchronized int m4701a() {
        return this.f4454l.m4811c(Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    synchronized void m4710a(long j) {
        this.f4451i += j;
        if (this.f4451i >= this.f4453k.m4812d() / 2) {
            m4704a(0, this.f4451i);
            this.f4451i = 0L;
        }
    }

    /* JADX INFO: renamed from: a */
    public aov m4703a(List<aop> list, boolean z) {
        return m4697b(0, list, z);
    }

    /* JADX INFO: renamed from: b */
    private aov m4697b(int i, List<aop> list, boolean z) {
        int i2;
        aov aovVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.f4457o) {
            synchronized (this) {
                if (this.f4448f > 1073741823) {
                    m4711a(aoo.REFUSED_STREAM);
                }
                if (this.f4449g) {
                    throw new aon();
                }
                i2 = this.f4448f;
                this.f4448f += 2;
                aovVar = new aov(i2, this, z3, false, list);
                z2 = !z || this.f4452j == 0 || aovVar.f4517b == 0;
                if (aovVar.m4760b()) {
                    this.f4445c.put(Integer.valueOf(i2), aovVar);
                }
            }
            if (i == 0) {
                this.f4457o.m4788a(z3, i2, i, list);
            } else {
                if (this.f4443a) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.f4457o.m4782a(i, i2, list);
            }
        }
        if (z2) {
            this.f4457o.m4791b();
        }
        return aovVar;
    }

    /* JADX INFO: renamed from: a */
    public void m4709a(int i, boolean z, Buffer buffer, long j) {
        int iMin;
        long j2;
        if (j == 0) {
            this.f4457o.m4790a(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.f4452j <= 0) {
                    try {
                        if (!this.f4445c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.f4452j), this.f4457o.m4793c());
                j2 = iMin;
                this.f4452j -= j2;
            }
            long j3 = j - j2;
            this.f4457o.m4790a(z && j3 == 0, i, buffer, iMin);
            j = j3;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4705a(final int i, final aoo aooVar) {
        try {
            this.f4460t.execute(new anl("OkHttp %s stream %d", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.1
                @Override // p000.anl
                /* JADX INFO: renamed from: c */
                public void mo2184c() {
                    try {
                        aot.this.m4717b(i, aooVar);
                    } catch (IOException unused) {
                        aot.this.m4700f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    void m4717b(int i, aoo aooVar) {
        this.f4457o.m4784a(i, aooVar);
    }

    /* JADX INFO: renamed from: a */
    void m4704a(final int i, final long j) {
        try {
            this.f4460t.execute(new anl("OkHttp Window Update %s stream %d", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.2
                @Override // p000.anl
                /* JADX INFO: renamed from: c */
                public void mo2184c() {
                    try {
                        aot.this.f4457o.m4783a(i, j);
                    } catch (IOException unused) {
                        aot.this.m4700f();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: renamed from: aot$c */
    /* JADX INFO: compiled from: Http2Connection.java */
    final class C0700c extends anl {

        /* JADX INFO: renamed from: a */
        final boolean f4493a;

        /* JADX INFO: renamed from: c */
        final int f4494c;

        /* JADX INFO: renamed from: d */
        final int f4495d;

        C0700c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", aot.this.f4446d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f4493a = z;
            this.f4494c = i;
            this.f4495d = i2;
        }

        @Override // p000.anl
        /* JADX INFO: renamed from: c */
        public void mo2184c() {
            aot.this.m4714a(this.f4493a, this.f4494c, this.f4495d);
        }
    }

    /* JADX INFO: renamed from: a */
    void m4714a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f4462v;
                this.f4462v = true;
            }
            if (z2) {
                m4700f();
                return;
            }
        }
        try {
            this.f4457o.m4787a(z, i, i2);
        } catch (IOException unused) {
            m4700f();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4716b() {
        this.f4457o.m4791b();
    }

    /* JADX INFO: renamed from: a */
    public void m4711a(aoo aooVar) {
        synchronized (this.f4457o) {
            synchronized (this) {
                if (this.f4449g) {
                    return;
                }
                this.f4449g = true;
                this.f4457o.m4785a(this.f4447e, aooVar, anm.f4207a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m4712a(aoo.NO_ERROR, aoo.CANCEL);
    }

    /* JADX INFO: renamed from: a */
    void m4712a(aoo aooVar, aoo aooVar2) throws IOException {
        if (!f4441r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        aov[] aovVarArr = null;
        try {
            m4711a(aooVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f4445c.isEmpty()) {
                aovVarArr = (aov[]) this.f4445c.values().toArray(new aov[this.f4445c.size()]);
                this.f4445c.clear();
            }
        }
        if (aovVarArr != null) {
            for (aov aovVar : aovVarArr) {
                try {
                    aovVar.m4756a(aooVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f4457o.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f4456n.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f4460t.shutdown();
        this.f4461u.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m4700f() {
        try {
            m4712a(aoo.PROTOCOL_ERROR, aoo.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4718c() {
        m4713a(true);
    }

    /* JADX INFO: renamed from: a */
    void m4713a(boolean z) {
        if (z) {
            this.f4457o.m4779a();
            this.f4457o.m4792b(this.f4453k);
            if (this.f4453k.m4812d() != 65535) {
                this.f4457o.m4783a(0, r6 - 65535);
            }
        }
        new Thread(this.f4458p).start();
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m4721d() {
        return this.f4449g;
    }

    /* JADX INFO: renamed from: aot$a */
    /* JADX INFO: compiled from: Http2Connection.java */
    public static class C0698a {

        /* JADX INFO: renamed from: a */
        Socket f4484a;

        /* JADX INFO: renamed from: b */
        String f4485b;

        /* JADX INFO: renamed from: c */
        BufferedSource f4486c;

        /* JADX INFO: renamed from: d */
        BufferedSink f4487d;

        /* JADX INFO: renamed from: e */
        AbstractC0699b f4488e = AbstractC0699b.f4492f;

        /* JADX INFO: renamed from: f */
        aoy f4489f = aoy.f4555a;

        /* JADX INFO: renamed from: g */
        boolean f4490g;

        /* JADX INFO: renamed from: h */
        int f4491h;

        public C0698a(boolean z) {
            this.f4490g = z;
        }

        /* JADX INFO: renamed from: a */
        public C0698a m4724a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f4484a = socket;
            this.f4485b = str;
            this.f4486c = bufferedSource;
            this.f4487d = bufferedSink;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0698a m4723a(AbstractC0699b abstractC0699b) {
            this.f4488e = abstractC0699b;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0698a m4722a(int i) {
            this.f4491h = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public aot m4725a() {
            return new aot(this);
        }
    }

    /* JADX INFO: renamed from: aot$d */
    /* JADX INFO: compiled from: Http2Connection.java */
    class C0701d extends anl implements aou.InterfaceC0703b {

        /* JADX INFO: renamed from: a */
        final aou f4497a;

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4727a() {
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4728a(int i, int i2, int i3, boolean z) {
        }

        C0701d(aou aouVar) {
            super("OkHttp %s", aot.this.f4446d);
            this.f4497a = aouVar;
        }

        @Override // p000.anl
        /* JADX INFO: renamed from: c */
        protected void mo2184c() throws Throwable {
            aoo aooVar;
            aoo aooVar2;
            aot aotVar;
            aoo aooVar3 = aoo.INTERNAL_ERROR;
            aoo aooVar4 = aoo.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f4497a.m4750a(this);
                        while (this.f4497a.m4751a(false, (aou.InterfaceC0703b) this)) {
                        }
                        aooVar = aoo.NO_ERROR;
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        aot.this.m4712a(aooVar3, aooVar4);
                    } catch (IOException unused2) {
                    }
                    anm.m4506a(this.f4497a);
                    throw th;
                }
                try {
                    try {
                        aooVar2 = aoo.CANCEL;
                        aotVar = aot.this;
                    } catch (IOException unused3) {
                        aooVar3 = aooVar;
                        aooVar = aoo.PROTOCOL_ERROR;
                        aooVar2 = aoo.PROTOCOL_ERROR;
                        aotVar = aot.this;
                    }
                } catch (Throwable th2) {
                    aoo aooVar5 = aooVar;
                    th = th2;
                    aooVar3 = aooVar5;
                    aot.this.m4712a(aooVar3, aooVar4);
                    anm.m4506a(this.f4497a);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            aotVar.m4712a(aooVar, aooVar2);
            anm.m4506a(this.f4497a);
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4735a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (aot.this.m4720c(i)) {
                aot.this.m4708a(i, bufferedSource, i2, z);
                return;
            }
            aov aovVarM4702a = aot.this.m4702a(i);
            if (aovVarM4702a == null) {
                aot.this.m4705a(i, aoo.PROTOCOL_ERROR);
                long j = i2;
                aot.this.m4710a(j);
                bufferedSource.skip(j);
                return;
            }
            aovVarM4702a.m4758a(bufferedSource, i2);
            if (z) {
                aovVarM4702a.m4768i();
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4734a(boolean z, int i, int i2, List<aop> list) {
            if (aot.this.m4720c(i)) {
                aot.this.m4707a(i, list, z);
                return;
            }
            synchronized (aot.this) {
                aov aovVarM4702a = aot.this.m4702a(i);
                if (aovVarM4702a == null) {
                    if (aot.this.f4449g) {
                        return;
                    }
                    if (i <= aot.this.f4447e) {
                        return;
                    }
                    if (i % 2 == aot.this.f4448f % 2) {
                        return;
                    }
                    final aov aovVar = new aov(i, aot.this, false, z, list);
                    aot.this.f4447e = i;
                    aot.this.f4445c.put(Integer.valueOf(i), aovVar);
                    aot.f4442s.execute(new anl("OkHttp %s stream %d", new Object[]{aot.this.f4446d, Integer.valueOf(i)}) { // from class: aot.d.1
                        @Override // p000.anl
                        /* JADX INFO: renamed from: c */
                        public void mo2184c() {
                            try {
                                aot.this.f4444b.mo4567a(aovVar);
                            } catch (IOException e) {
                                aph.m4853c().mo4825a(4, "Http2Connection.Listener failure for " + aot.this.f4446d, e);
                                try {
                                    aovVar.m4756a(aoo.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                aovVarM4702a.m4757a(list);
                if (z) {
                    aovVarM4702a.m4768i();
                }
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4731a(int i, aoo aooVar) {
            if (aot.this.m4720c(i)) {
                aot.this.m4719c(i, aooVar);
                return;
            }
            aov aovVarM4715b = aot.this.m4715b(i);
            if (aovVarM4715b != null) {
                aovVarM4715b.m4761c(aooVar);
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4736a(boolean z, aoz aozVar) {
            aov[] aovVarArr;
            long j;
            int i;
            synchronized (aot.this) {
                int iM4812d = aot.this.f4454l.m4812d();
                if (z) {
                    aot.this.f4454l.m4805a();
                }
                aot.this.f4454l.m4806a(aozVar);
                m4726a(aozVar);
                int iM4812d2 = aot.this.f4454l.m4812d();
                aovVarArr = null;
                if (iM4812d2 == -1 || iM4812d2 == iM4812d) {
                    j = 0;
                } else {
                    j = iM4812d2 - iM4812d;
                    if (!aot.this.f4455m) {
                        aot.this.f4455m = true;
                    }
                    if (!aot.this.f4445c.isEmpty()) {
                        aovVarArr = (aov[]) aot.this.f4445c.values().toArray(new aov[aot.this.f4445c.size()]);
                    }
                }
                aot.f4442s.execute(new anl("OkHttp %s settings", aot.this.f4446d) { // from class: aot.d.2
                    @Override // p000.anl
                    /* JADX INFO: renamed from: c */
                    public void mo2184c() {
                        aot.this.f4444b.mo4566a(aot.this);
                    }
                });
            }
            if (aovVarArr == null || j == 0) {
                return;
            }
            for (aov aovVar : aovVarArr) {
                synchronized (aovVar) {
                    aovVar.m4755a(j);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m4726a(final aoz aozVar) {
            try {
                aot.this.f4460t.execute(new anl("OkHttp %s ACK Settings", new Object[]{aot.this.f4446d}) { // from class: aot.d.3
                    @Override // p000.anl
                    /* JADX INFO: renamed from: c */
                    public void mo2184c() {
                        try {
                            aot.this.f4457o.m4786a(aozVar);
                        } catch (IOException unused) {
                            aot.this.m4700f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4733a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    aot.this.f4460t.execute(aot.this.new C0700c(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (aot.this) {
                    aot.this.f4462v = false;
                    aot.this.notifyAll();
                }
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4732a(int i, aoo aooVar, ByteString byteString) {
            aov[] aovVarArr;
            byteString.size();
            synchronized (aot.this) {
                aovVarArr = (aov[]) aot.this.f4445c.values().toArray(new aov[aot.this.f4445c.size()]);
                aot.this.f4449g = true;
            }
            for (aov aovVar : aovVarArr) {
                if (aovVar.m4754a() > i && aovVar.m4762c()) {
                    aovVar.m4761c(aoo.REFUSED_STREAM);
                    aot.this.m4715b(aovVar.m4754a());
                }
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4730a(int i, long j) {
            if (i == 0) {
                synchronized (aot.this) {
                    aot.this.f4452j += j;
                    aot.this.notifyAll();
                }
                return;
            }
            aov aovVarM4702a = aot.this.m4702a(i);
            if (aovVarM4702a != null) {
                synchronized (aovVarM4702a) {
                    aovVarM4702a.m4755a(j);
                }
            }
        }

        @Override // p000.aou.InterfaceC0703b
        /* JADX INFO: renamed from: a */
        public void mo4729a(int i, int i2, List<aop> list) {
            aot.this.m4706a(i2, list);
        }
    }

    /* JADX INFO: renamed from: a */
    void m4706a(final int i, final List<aop> list) {
        synchronized (this) {
            if (this.f4459q.contains(Integer.valueOf(i))) {
                m4705a(i, aoo.PROTOCOL_ERROR);
                return;
            }
            this.f4459q.add(Integer.valueOf(i));
            try {
                m4694a(new anl("OkHttp %s Push Request[%s]", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.3
                    @Override // p000.anl
                    /* JADX INFO: renamed from: c */
                    public void mo2184c() {
                        if (aot.this.f4450h.mo4801a(i, list)) {
                            try {
                                aot.this.f4457o.m4784a(i, aoo.CANCEL);
                                synchronized (aot.this) {
                                    aot.this.f4459q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m4707a(final int i, final List<aop> list, final boolean z) {
        try {
            m4694a(new anl("OkHttp %s Push Headers[%s]", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.4
                @Override // p000.anl
                /* JADX INFO: renamed from: c */
                public void mo2184c() {
                    boolean zMo4802a = aot.this.f4450h.mo4802a(i, list, z);
                    if (zMo4802a) {
                        try {
                            aot.this.f4457o.m4784a(i, aoo.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (zMo4802a || z) {
                        synchronized (aot.this) {
                            aot.this.f4459q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    void m4708a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            m4694a(new anl("OkHttp %s Push Data[%s]", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.5
                @Override // p000.anl
                /* JADX INFO: renamed from: c */
                public void mo2184c() {
                    try {
                        boolean zMo4803a = aot.this.f4450h.mo4803a(i, buffer, i2, z);
                        if (zMo4803a) {
                            aot.this.f4457o.m4784a(i, aoo.CANCEL);
                        }
                        if (zMo4803a || z) {
                            synchronized (aot.this) {
                                aot.this.f4459q.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* JADX INFO: renamed from: c */
    void m4719c(final int i, final aoo aooVar) {
        m4694a(new anl("OkHttp %s Push Reset[%s]", new Object[]{this.f4446d, Integer.valueOf(i)}) { // from class: aot.6
            @Override // p000.anl
            /* JADX INFO: renamed from: c */
            public void mo2184c() {
                aot.this.f4450h.mo4800a(i, aooVar);
                synchronized (aot.this) {
                    aot.this.f4459q.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m4694a(anl anlVar) {
        if (!m4721d()) {
            this.f4461u.execute(anlVar);
        }
    }
}
