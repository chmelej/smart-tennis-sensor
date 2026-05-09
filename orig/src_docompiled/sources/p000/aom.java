package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000.amx;
import p000.ang;

/* JADX INFO: compiled from: Http1Codec.java */
/* JADX INFO: loaded from: classes.dex */
public final class aom implements aoc {

    /* JADX INFO: renamed from: a */
    final anb f4352a;

    /* JADX INFO: renamed from: b */
    final anz f4353b;

    /* JADX INFO: renamed from: c */
    final BufferedSource f4354c;

    /* JADX INFO: renamed from: d */
    final BufferedSink f4355d;

    /* JADX INFO: renamed from: e */
    int f4356e = 0;

    /* JADX INFO: renamed from: f */
    private long f4357f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public aom(anb anbVar, anz anzVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f4352a = anbVar;
        this.f4353b = anzVar;
        this.f4354c = bufferedSource;
        this.f4355d = bufferedSink;
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public Sink mo4611a(ane aneVar, long j) {
        if ("chunked".equalsIgnoreCase(aneVar.m4421a("Transfer-Encoding"))) {
            return m4655d();
        }
        if (j != -1) {
            return m4649a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public void mo4613a(ane aneVar) {
        m4651a(aneVar.m4423c(), aoi.m4637a(aneVar, this.f4353b.m4604c().m4571b().m4484b().type()));
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public anh mo4610a(ang angVar) {
        this.f4353b.f4309c.m2045f(this.f4353b.f4308b);
        String strM4449a = angVar.m4449a(MIME.CONTENT_TYPE);
        if (!aoe.m4625b(angVar)) {
            return new aoh(strM4449a, 0L, Okio.buffer(m4653b(0L)));
        }
        if ("chunked".equalsIgnoreCase(angVar.m4449a("Transfer-Encoding"))) {
            return new aoh(strM4449a, -1L, Okio.buffer(m4650a(angVar.m4448a().m4419a())));
        }
        long jM4621a = aoe.m4621a(angVar);
        if (jM4621a != -1) {
            return new aoh(strM4449a, jM4621a, Okio.buffer(m4653b(jM4621a)));
        }
        return new aoh(strM4449a, -1L, Okio.buffer(m4656e()));
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public void mo4612a() {
        this.f4355d.flush();
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: b */
    public void mo4614b() {
        this.f4355d.flush();
    }

    /* JADX INFO: renamed from: a */
    public void m4651a(amx amxVar, String str) {
        if (this.f4356e != 0) {
            throw new IllegalStateException("state: " + this.f4356e);
        }
        this.f4355d.writeUtf8(str).writeUtf8("\r\n");
        int iM2052a = amxVar.m2052a();
        for (int i = 0; i < iM2052a; i++) {
            this.f4355d.writeUtf8(amxVar.m2053a(i)).writeUtf8(": ").writeUtf8(amxVar.m2056b(i)).writeUtf8("\r\n");
        }
        this.f4355d.writeUtf8("\r\n");
        this.f4356e = 1;
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public ang.C0669a mo4609a(boolean z) throws IOException {
        if (this.f4356e != 1 && this.f4356e != 3) {
            throw new IllegalStateException("state: " + this.f4356e);
        }
        try {
            aok aokVarM4647a = aok.m4647a(m4648f());
            ang.C0669a c0669aM4466a = new ang.C0669a().m4467a(aokVarM4647a.f4349a).m4463a(aokVarM4647a.f4350b).m4471a(aokVarM4647a.f4351c).m4466a(m4654c());
            if (z && aokVarM4647a.f4350b == 100) {
                return null;
            }
            if (aokVarM4647a.f4350b == 100) {
                this.f4356e = 3;
                return c0669aM4466a;
            }
            this.f4356e = 4;
            return c0669aM4466a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f4353b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* JADX INFO: renamed from: f */
    private String m4648f() {
        String utf8LineStrict = this.f4354c.readUtf8LineStrict(this.f4357f);
        this.f4357f -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }

    /* JADX INFO: renamed from: c */
    public amx m4654c() {
        amx.C0209a c0209a = new amx.C0209a();
        while (true) {
            String strM4648f = m4648f();
            if (strM4648f.length() != 0) {
                ank.f4205a.mo2160a(c0209a, strM4648f);
            } else {
                return c0209a.m2061a();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public Sink m4655d() {
        if (this.f4356e == 1) {
            this.f4356e = 2;
            return new C0684b();
        }
        throw new IllegalStateException("state: " + this.f4356e);
    }

    /* JADX INFO: renamed from: a */
    public Sink m4649a(long j) {
        if (this.f4356e == 1) {
            this.f4356e = 2;
            return new C0686d(j);
        }
        throw new IllegalStateException("state: " + this.f4356e);
    }

    /* JADX INFO: renamed from: b */
    public Source m4653b(long j) {
        if (this.f4356e == 4) {
            this.f4356e = 5;
            return new C0687e(j);
        }
        throw new IllegalStateException("state: " + this.f4356e);
    }

    /* JADX INFO: renamed from: a */
    public Source m4650a(amy amyVar) {
        if (this.f4356e == 4) {
            this.f4356e = 5;
            return new C0685c(amyVar);
        }
        throw new IllegalStateException("state: " + this.f4356e);
    }

    /* JADX INFO: renamed from: e */
    public Source m4656e() {
        if (this.f4356e != 4) {
            throw new IllegalStateException("state: " + this.f4356e);
        }
        if (this.f4353b == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f4356e = 5;
        this.f4353b.m4606e();
        return new C0688f();
    }

    /* JADX INFO: renamed from: a */
    void m4652a(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }

    /* JADX INFO: renamed from: aom$d */
    /* JADX INFO: compiled from: Http1Codec.java */
    final class C0686d implements Sink {

        /* JADX INFO: renamed from: b */
        private final ForwardingTimeout f4370b;

        /* JADX INFO: renamed from: c */
        private boolean f4371c;

        /* JADX INFO: renamed from: d */
        private long f4372d;

        C0686d(long j) {
            this.f4370b = new ForwardingTimeout(aom.this.f4355d.timeout());
            this.f4372d = j;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f4370b;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws ProtocolException {
            if (this.f4371c) {
                throw new IllegalStateException("closed");
            }
            anm.m4505a(buffer.size(), 0L, j);
            if (j > this.f4372d) {
                throw new ProtocolException("expected " + this.f4372d + " bytes but received " + j);
            }
            aom.this.f4355d.write(buffer, j);
            this.f4372d -= j;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f4371c) {
                return;
            }
            aom.this.f4355d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (this.f4371c) {
                return;
            }
            this.f4371c = true;
            if (this.f4372d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            aom.this.m4652a(this.f4370b);
            aom.this.f4356e = 3;
        }
    }

    /* JADX INFO: renamed from: aom$b */
    /* JADX INFO: compiled from: Http1Codec.java */
    final class C0684b implements Sink {

        /* JADX INFO: renamed from: b */
        private final ForwardingTimeout f4363b;

        /* JADX INFO: renamed from: c */
        private boolean f4364c;

        C0684b() {
            this.f4363b = new ForwardingTimeout(aom.this.f4355d.timeout());
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f4363b;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) {
            if (this.f4364c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            aom.this.f4355d.writeHexadecimalUnsignedLong(j);
            aom.this.f4355d.writeUtf8("\r\n");
            aom.this.f4355d.write(buffer, j);
            aom.this.f4355d.writeUtf8("\r\n");
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f4364c) {
                return;
            }
            aom.this.f4355d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f4364c) {
                return;
            }
            this.f4364c = true;
            aom.this.f4355d.writeUtf8("0\r\n\r\n");
            aom.this.m4652a(this.f4363b);
            aom.this.f4356e = 3;
        }
    }

    /* JADX INFO: renamed from: aom$a */
    /* JADX INFO: compiled from: Http1Codec.java */
    abstract class AbstractC0683a implements Source {

        /* JADX INFO: renamed from: a */
        protected final ForwardingTimeout f4358a;

        /* JADX INFO: renamed from: b */
        protected boolean f4359b;

        /* JADX INFO: renamed from: c */
        protected long f4360c;

        private AbstractC0683a() {
            this.f4358a = new ForwardingTimeout(aom.this.f4354c.timeout());
            this.f4360c = 0L;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f4358a;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long j2 = aom.this.f4354c.read(buffer, j);
                if (j2 > 0) {
                    this.f4360c += j2;
                }
                return j2;
            } catch (IOException e) {
                m4657a(false, e);
                throw e;
            }
        }

        /* JADX INFO: renamed from: a */
        protected final void m4657a(boolean z, IOException iOException) {
            if (aom.this.f4356e == 6) {
                return;
            }
            if (aom.this.f4356e != 5) {
                throw new IllegalStateException("state: " + aom.this.f4356e);
            }
            aom.this.m4652a(this.f4358a);
            aom.this.f4356e = 6;
            if (aom.this.f4353b != null) {
                aom.this.f4353b.m4602a(!z, aom.this, this.f4360c, iOException);
            }
        }
    }

    /* JADX INFO: renamed from: aom$e */
    /* JADX INFO: compiled from: Http1Codec.java */
    class C0687e extends AbstractC0683a {

        /* JADX INFO: renamed from: f */
        private long f4374f;

        C0687e(long j) {
            super();
            this.f4374f = j;
            if (this.f4374f == 0) {
                m4657a(true, null);
            }
        }

        @Override // p000.aom.AbstractC0683a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f4359b) {
                throw new IllegalStateException("closed");
            }
            if (this.f4374f == 0) {
                return -1L;
            }
            long j2 = super.read(buffer, Math.min(this.f4374f, j));
            if (j2 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m4657a(false, protocolException);
                throw protocolException;
            }
            this.f4374f -= j2;
            if (this.f4374f == 0) {
                m4657a(true, null);
            }
            return j2;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4359b) {
                return;
            }
            if (this.f4374f != 0 && !anm.m4512a(this, 100, TimeUnit.MILLISECONDS)) {
                m4657a(false, null);
            }
            this.f4359b = true;
        }
    }

    /* JADX INFO: renamed from: aom$c */
    /* JADX INFO: compiled from: Http1Codec.java */
    class C0685c extends AbstractC0683a {

        /* JADX INFO: renamed from: f */
        private final amy f4366f;

        /* JADX INFO: renamed from: g */
        private long f4367g;

        /* JADX INFO: renamed from: h */
        private boolean f4368h;

        C0685c(amy amyVar) {
            super();
            this.f4367g = -1L;
            this.f4368h = true;
            this.f4366f = amyVar;
        }

        @Override // p000.aom.AbstractC0683a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f4359b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f4368h) {
                return -1L;
            }
            if (this.f4367g == 0 || this.f4367g == -1) {
                m4658a();
                if (!this.f4368h) {
                    return -1L;
                }
            }
            long j2 = super.read(buffer, Math.min(j, this.f4367g));
            if (j2 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m4657a(false, protocolException);
                throw protocolException;
            }
            this.f4367g -= j2;
            return j2;
        }

        /* JADX INFO: renamed from: a */
        private void m4658a() throws ProtocolException {
            if (this.f4367g != -1) {
                aom.this.f4354c.readUtf8LineStrict();
            }
            try {
                this.f4367g = aom.this.f4354c.readHexadecimalUnsignedLong();
                String strTrim = aom.this.f4354c.readUtf8LineStrict().trim();
                if (this.f4367g < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f4367g + strTrim + "\"");
                }
                if (this.f4367g == 0) {
                    this.f4368h = false;
                    aoe.m4623a(aom.this.f4352a.m2136g(), this.f4366f, aom.this.m4654c());
                    m4657a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4359b) {
                return;
            }
            if (this.f4368h && !anm.m4512a(this, 100, TimeUnit.MILLISECONDS)) {
                m4657a(false, null);
            }
            this.f4359b = true;
        }
    }

    /* JADX INFO: renamed from: aom$f */
    /* JADX INFO: compiled from: Http1Codec.java */
    class C0688f extends AbstractC0683a {

        /* JADX INFO: renamed from: f */
        private boolean f4376f;

        C0688f() {
            super();
        }

        @Override // p000.aom.AbstractC0683a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f4359b) {
                throw new IllegalStateException("closed");
            }
            if (this.f4376f) {
                return -1L;
            }
            long j2 = super.read(buffer, j);
            if (j2 != -1) {
                return j2;
            }
            this.f4376f = true;
            m4657a(true, null);
            return -1L;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f4359b) {
                return;
            }
            if (!this.f4376f) {
                m4657a(false, null);
            }
            this.f4359b = true;
        }
    }
}
