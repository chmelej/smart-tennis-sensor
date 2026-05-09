package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: om */
/* JADX INFO: compiled from: AbstractBox.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1983om implements InterfaceC1938nj {

    /* JADX INFO: renamed from: a */
    private static AbstractC2029po f11943a = AbstractC2029po.m11097a(AbstractC1983om.class);

    /* JADX INFO: renamed from: j */
    static final /* synthetic */ boolean f11944j = true;

    /* JADX INFO: renamed from: b */
    private byte[] f11945b;

    /* JADX INFO: renamed from: c */
    private InterfaceC1940nl f11946c;

    /* JADX INFO: renamed from: d */
    protected String f11947d;

    /* JADX INFO: renamed from: g */
    long f11950g;

    /* JADX INFO: renamed from: i */
    InterfaceC1987oq f11952i;

    /* JADX INFO: renamed from: k */
    private ByteBuffer f11953k;

    /* JADX INFO: renamed from: h */
    long f11951h = -1;

    /* JADX INFO: renamed from: l */
    private ByteBuffer f11954l = null;

    /* JADX INFO: renamed from: f */
    boolean f11949f = true;

    /* JADX INFO: renamed from: e */
    boolean f11948e = true;

    /* JADX INFO: renamed from: a */
    protected abstract void mo10760a(ByteBuffer byteBuffer);

    /* JADX INFO: renamed from: a_ */
    protected abstract long mo10761a_();

    /* JADX INFO: renamed from: b */
    protected abstract void mo10762b(ByteBuffer byteBuffer);

    /* JADX INFO: renamed from: c */
    private synchronized void m10894c() {
        if (!this.f11949f) {
            try {
                f11943a.mo11091a("mem mapping " + m10899m());
                this.f11953k = this.f11952i.m10917a(this.f11950g, this.f11951h);
                this.f11949f = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected AbstractC1983om(String str) {
        this.f11947d = str;
    }

    @Override // p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
        if (this.f11949f) {
            if (this.f11948e) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(C2025pk.m11093a(mo1637a()));
                m10896d(byteBufferAllocate);
                mo10762b(byteBufferAllocate);
                if (this.f11954l != null) {
                    this.f11954l.rewind();
                    while (this.f11954l.remaining() > 0) {
                        byteBufferAllocate.put(this.f11954l);
                    }
                }
                writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
                return;
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((m10897d() ? 8 : 16) + ("uuid".equals(m10899m()) ? 16 : 0));
            m10896d(byteBufferAllocate2);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.f11953k.position(0));
            return;
        }
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate((m10897d() ? 8 : 16) + ("uuid".equals(m10899m()) ? 16 : 0));
        m10896d(byteBufferAllocate3);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate3.rewind());
        this.f11952i.m10916a(this.f11950g, this.f11951h, writableByteChannel);
    }

    /* JADX INFO: renamed from: l */
    public final synchronized void m10898l() {
        m10894c();
        f11943a.mo11091a("parsing details of " + m10899m());
        if (this.f11953k != null) {
            ByteBuffer byteBuffer = this.f11953k;
            this.f11948e = true;
            byteBuffer.rewind();
            mo10760a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.f11954l = byteBuffer.slice();
            }
            this.f11953k = null;
            if (!f11944j && !m10895c(byteBuffer)) {
                throw new AssertionError();
            }
        }
    }

    @Override // p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public long mo1637a() {
        long jLimit;
        if (!this.f11949f) {
            jLimit = this.f11951h;
        } else if (this.f11948e) {
            jLimit = mo10761a_();
        } else {
            jLimit = this.f11953k != null ? this.f11953k.limit() : 0;
        }
        return jLimit + ((long) ((jLimit >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(m10899m()) ? 16 : 0))) + ((long) (this.f11954l != null ? this.f11954l.limit() : 0));
    }

    /* JADX INFO: renamed from: m */
    public String m10899m() {
        return this.f11947d;
    }

    /* JADX INFO: renamed from: n */
    public byte[] m10900n() {
        return this.f11945b;
    }

    @Override // p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1640a(InterfaceC1940nl interfaceC1940nl) {
        this.f11946c = interfaceC1940nl;
    }

    /* JADX INFO: renamed from: o */
    public boolean m10901o() {
        return this.f11948e;
    }

    /* JADX INFO: renamed from: c */
    private boolean m10895c(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(C2025pk.m11093a(mo10761a_() + ((long) (this.f11954l != null ? this.f11954l.limit() : 0))));
        mo10762b(byteBufferAllocate);
        if (this.f11954l != null) {
            this.f11954l.rewind();
            while (this.f11954l.remaining() > 0) {
                byteBufferAllocate.put(this.f11954l);
            }
        }
        byteBuffer.rewind();
        byteBufferAllocate.rewind();
        if (byteBuffer.remaining() != byteBufferAllocate.remaining()) {
            System.err.print(String.valueOf(m10899m()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + byteBufferAllocate.remaining());
            f11943a.mo11092b(String.valueOf(m10899m()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + byteBufferAllocate.remaining());
            return false;
        }
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 1;
        int iLimit2 = byteBufferAllocate.limit() - 1;
        while (iLimit >= iPosition) {
            byte b = byteBuffer.get(iLimit);
            byte b2 = byteBufferAllocate.get(iLimit2);
            if (b != b2) {
                f11943a.mo11092b(String.format("%s: buffers differ at %d: %2X/%2X", m10899m(), Integer.valueOf(iLimit), Byte.valueOf(b), Byte.valueOf(b2)));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[byteBufferAllocate.remaining()];
                byteBuffer.get(bArr);
                byteBufferAllocate.get(bArr2);
                System.err.println("original      : " + C1932nd.m10730a(bArr, 4));
                System.err.println("reconstructed : " + C1932nd.m10730a(bArr2, 4));
                return false;
            }
            iLimit--;
            iLimit2--;
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    private boolean m10897d() {
        int i = "uuid".equals(m10899m()) ? 24 : 8;
        if (!this.f11949f) {
            return this.f11951h + ((long) i) < 4294967296L;
        }
        if (this.f11948e) {
            return (mo10761a_() + ((long) (this.f11954l != null ? this.f11954l.limit() : 0))) + ((long) i) < 4294967296L;
        }
        return ((long) (this.f11953k.limit() + i)) < 4294967296L;
    }

    /* JADX INFO: renamed from: d */
    private void m10896d(ByteBuffer byteBuffer) {
        if (m10897d()) {
            C1935ng.m10750b(byteBuffer, mo1637a());
            byteBuffer.put(C1933ne.m10731a(m10899m()));
        } else {
            C1935ng.m10750b(byteBuffer, 1L);
            byteBuffer.put(C1933ne.m10731a(m10899m()));
            C1935ng.m10746a(byteBuffer, mo1637a());
        }
        if ("uuid".equals(m10899m())) {
            byteBuffer.put(m10900n());
        }
    }
}
