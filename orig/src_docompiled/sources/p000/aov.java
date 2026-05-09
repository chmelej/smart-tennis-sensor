package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: Http2Stream.java */
/* JADX INFO: loaded from: classes.dex */
public final class aov {

    /* JADX INFO: renamed from: i */
    static final /* synthetic */ boolean f4515i = true;

    /* JADX INFO: renamed from: b */
    long f4517b;

    /* JADX INFO: renamed from: c */
    final int f4518c;

    /* JADX INFO: renamed from: d */
    final aot f4519d;

    /* JADX INFO: renamed from: e */
    final C0704a f4520e;

    /* JADX INFO: renamed from: j */
    private final List<aop> f4524j;

    /* JADX INFO: renamed from: k */
    private List<aop> f4525k;

    /* JADX INFO: renamed from: l */
    private boolean f4526l;

    /* JADX INFO: renamed from: m */
    private final C0705b f4527m;

    /* JADX INFO: renamed from: a */
    long f4516a = 0;

    /* JADX INFO: renamed from: f */
    final C0706c f4521f = new C0706c();

    /* JADX INFO: renamed from: g */
    final C0706c f4522g = new C0706c();

    /* JADX INFO: renamed from: h */
    aoo f4523h = null;

    aov(int i, aot aotVar, boolean z, boolean z2, List<aop> list) {
        if (aotVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f4518c = i;
        this.f4519d = aotVar;
        this.f4517b = aotVar.f4454l.m4812d();
        this.f4527m = new C0705b(aotVar.f4453k.m4812d());
        this.f4520e = new C0704a();
        this.f4527m.f4535b = z2;
        this.f4520e.f4530b = z;
        this.f4524j = list;
    }

    /* JADX INFO: renamed from: a */
    public int m4754a() {
        return this.f4518c;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m4760b() {
        if (this.f4523h != null) {
            return false;
        }
        if ((this.f4527m.f4535b || this.f4527m.f4534a) && (this.f4520e.f4530b || this.f4520e.f4529a)) {
            if (this.f4526l) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m4762c() {
        return this.f4519d.f4443a == ((this.f4518c & 1) == 1);
    }

    /* JADX INFO: renamed from: d */
    public synchronized List<aop> m4763d() {
        List<aop> list;
        if (!m4762c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f4521f.enter();
        while (this.f4525k == null && this.f4523h == null) {
            try {
                m4771l();
            } catch (Throwable th) {
                this.f4521f.m4776a();
                throw th;
            }
        }
        this.f4521f.m4776a();
        list = this.f4525k;
        if (list != null) {
            this.f4525k = null;
        } else {
            throw new apa(this.f4523h);
        }
        return list;
    }

    /* JADX INFO: renamed from: e */
    public Timeout m4764e() {
        return this.f4521f;
    }

    /* JADX INFO: renamed from: f */
    public Timeout m4765f() {
        return this.f4522g;
    }

    /* JADX INFO: renamed from: g */
    public Source m4766g() {
        return this.f4527m;
    }

    /* JADX INFO: renamed from: h */
    public Sink m4767h() {
        synchronized (this) {
            if (!this.f4526l && !m4762c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f4520e;
    }

    /* JADX INFO: renamed from: a */
    public void m4756a(aoo aooVar) {
        if (m4753d(aooVar)) {
            this.f4519d.m4717b(this.f4518c, aooVar);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4759b(aoo aooVar) {
        if (m4753d(aooVar)) {
            this.f4519d.m4705a(this.f4518c, aooVar);
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m4753d(aoo aooVar) {
        if (!f4515i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.f4523h != null) {
                return false;
            }
            if (this.f4527m.f4535b && this.f4520e.f4530b) {
                return false;
            }
            this.f4523h = aooVar;
            notifyAll();
            this.f4519d.m4715b(this.f4518c);
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4757a(List<aop> list) {
        boolean zM4760b;
        if (!f4515i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zM4760b = true;
            this.f4526l = true;
            if (this.f4525k == null) {
                this.f4525k = list;
                zM4760b = m4760b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f4525k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f4525k = arrayList;
            }
        }
        if (zM4760b) {
            return;
        }
        this.f4519d.m4715b(this.f4518c);
    }

    /* JADX INFO: renamed from: a */
    void m4758a(BufferedSource bufferedSource, int i) throws EOFException {
        if (!f4515i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f4527m.m4775a(bufferedSource, i);
    }

    /* JADX INFO: renamed from: i */
    void m4768i() {
        boolean zM4760b;
        if (!f4515i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f4527m.f4535b = true;
            zM4760b = m4760b();
            notifyAll();
        }
        if (zM4760b) {
            return;
        }
        this.f4519d.m4715b(this.f4518c);
    }

    /* JADX INFO: renamed from: c */
    synchronized void m4761c(aoo aooVar) {
        if (this.f4523h == null) {
            this.f4523h = aooVar;
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: aov$b */
    /* JADX INFO: compiled from: Http2Stream.java */
    final class C0705b implements Source {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ boolean f4533c = true;

        /* JADX INFO: renamed from: a */
        boolean f4534a;

        /* JADX INFO: renamed from: b */
        boolean f4535b;

        /* JADX INFO: renamed from: e */
        private final Buffer f4537e = new Buffer();

        /* JADX INFO: renamed from: f */
        private final Buffer f4538f = new Buffer();

        /* JADX INFO: renamed from: g */
        private final long f4539g;

        C0705b(long j) {
            this.f4539g = j;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws apa {
            aoo aooVar;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (aov.this) {
                m4773a();
                if (this.f4534a) {
                    throw new IOException("stream closed");
                }
                aooVar = aov.this.f4523h;
                if (this.f4538f.size() > 0) {
                    j2 = this.f4538f.read(buffer, Math.min(j, this.f4538f.size()));
                    aov.this.f4516a += j2;
                } else {
                    j2 = -1;
                }
                if (aooVar == null && aov.this.f4516a >= aov.this.f4519d.f4453k.m4812d() / 2) {
                    aov.this.f4519d.m4704a(aov.this.f4518c, aov.this.f4516a);
                    aov.this.f4516a = 0L;
                }
            }
            if (j2 != -1) {
                m4774a(j2);
                return j2;
            }
            if (aooVar != null) {
                throw new apa(aooVar);
            }
            return -1L;
        }

        /* JADX INFO: renamed from: a */
        private void m4774a(long j) {
            if (!f4533c && Thread.holdsLock(aov.this)) {
                throw new AssertionError();
            }
            aov.this.f4519d.m4710a(j);
        }

        /* JADX INFO: renamed from: a */
        private void m4773a() throws IOException {
            aov.this.f4521f.enter();
            while (this.f4538f.size() == 0 && !this.f4535b && !this.f4534a && aov.this.f4523h == null) {
                try {
                    aov.this.m4771l();
                } finally {
                    aov.this.f4521f.m4776a();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4775a(BufferedSource bufferedSource, long j) throws EOFException {
            boolean z;
            boolean z2;
            if (!f4533c && Thread.holdsLock(aov.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (aov.this) {
                    z = this.f4535b;
                    z2 = j + this.f4538f.size() > this.f4539g;
                }
                if (z2) {
                    bufferedSource.skip(j);
                    aov.this.m4759b(aoo.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.f4537e, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                long j3 = j - j2;
                synchronized (aov.this) {
                    boolean z3 = this.f4538f.size() == 0;
                    this.f4538f.writeAll(this.f4537e);
                    if (z3) {
                        aov.this.notifyAll();
                    }
                }
                j = j3;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return aov.this.f4521f;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (aov.this) {
                this.f4534a = true;
                size = this.f4538f.size();
                this.f4538f.clear();
                aov.this.notifyAll();
            }
            if (size > 0) {
                m4774a(size);
            }
            aov.this.m4769j();
        }
    }

    /* JADX INFO: renamed from: j */
    void m4769j() {
        boolean z;
        boolean zM4760b;
        if (!f4515i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f4527m.f4535b && this.f4527m.f4534a && (this.f4520e.f4530b || this.f4520e.f4529a);
            zM4760b = m4760b();
        }
        if (z) {
            m4756a(aoo.CANCEL);
        } else {
            if (zM4760b) {
                return;
            }
            this.f4519d.m4715b(this.f4518c);
        }
    }

    /* JADX INFO: renamed from: aov$a */
    /* JADX INFO: compiled from: Http2Stream.java */
    final class C0704a implements Sink {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ boolean f4528c = true;

        /* JADX INFO: renamed from: a */
        boolean f4529a;

        /* JADX INFO: renamed from: b */
        boolean f4530b;

        /* JADX INFO: renamed from: e */
        private final Buffer f4532e = new Buffer();

        C0704a() {
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!f4528c && Thread.holdsLock(aov.this)) {
                throw new AssertionError();
            }
            this.f4532e.write(buffer, j);
            while (this.f4532e.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                m4772a(false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m4772a(boolean z) throws IOException {
            long jMin;
            synchronized (aov.this) {
                aov.this.f4522g.enter();
                while (aov.this.f4517b <= 0 && !this.f4530b && !this.f4529a && aov.this.f4523h == null) {
                    try {
                        aov.this.m4771l();
                    } finally {
                    }
                }
                aov.this.f4522g.m4776a();
                aov.this.m4770k();
                jMin = Math.min(aov.this.f4517b, this.f4532e.size());
                aov.this.f4517b -= jMin;
            }
            aov.this.f4522g.enter();
            try {
                aov.this.f4519d.m4709a(aov.this.f4518c, z && jMin == this.f4532e.size(), this.f4532e, jMin);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f4528c && Thread.holdsLock(aov.this)) {
                throw new AssertionError();
            }
            synchronized (aov.this) {
                aov.this.m4770k();
            }
            while (this.f4532e.size() > 0) {
                m4772a(false);
                aov.this.f4519d.m4716b();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return aov.this.f4522g;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f4528c && Thread.holdsLock(aov.this)) {
                throw new AssertionError();
            }
            synchronized (aov.this) {
                if (this.f4529a) {
                    return;
                }
                if (!aov.this.f4520e.f4530b) {
                    if (this.f4532e.size() > 0) {
                        while (this.f4532e.size() > 0) {
                            m4772a(true);
                        }
                    } else {
                        aov.this.f4519d.m4709a(aov.this.f4518c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (aov.this) {
                    this.f4529a = true;
                }
                aov.this.f4519d.m4716b();
                aov.this.m4769j();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m4755a(long j) {
        this.f4517b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: k */
    void m4770k() throws IOException {
        if (this.f4520e.f4529a) {
            throw new IOException("stream closed");
        }
        if (this.f4520e.f4530b) {
            throw new IOException("stream finished");
        }
        if (this.f4523h != null) {
            throw new apa(this.f4523h);
        }
    }

    /* JADX INFO: renamed from: l */
    void m4771l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: renamed from: aov$c */
    /* JADX INFO: compiled from: Http2Stream.java */
    class C0706c extends AsyncTimeout {
        C0706c() {
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            aov.this.m4759b(aoo.CANCEL);
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX INFO: renamed from: a */
        public void m4776a() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
