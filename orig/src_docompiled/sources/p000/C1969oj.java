package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: oj */
/* JADX INFO: compiled from: AudioSampleEntry.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1969oj extends AbstractC1968oi {

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f11920b = true;

    /* JADX INFO: renamed from: l */
    private int f11921l;

    /* JADX INFO: renamed from: m */
    private int f11922m;

    /* JADX INFO: renamed from: n */
    private long f11923n;

    /* JADX INFO: renamed from: o */
    private int f11924o;

    /* JADX INFO: renamed from: p */
    private int f11925p;

    /* JADX INFO: renamed from: q */
    private int f11926q;

    /* JADX INFO: renamed from: r */
    private long f11927r;

    /* JADX INFO: renamed from: s */
    private long f11928s;

    /* JADX INFO: renamed from: t */
    private long f11929t;

    /* JADX INFO: renamed from: u */
    private long f11930u;

    /* JADX INFO: renamed from: v */
    private int f11931v;

    /* JADX INFO: renamed from: w */
    private long f11932w;

    /* JADX INFO: renamed from: x */
    private byte[] f11933x;

    public C1969oj(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: b */
    public int m10873b() {
        return this.f11921l;
    }

    /* JADX INFO: renamed from: c */
    public long m10875c() {
        return this.f11923n;
    }

    /* JADX INFO: renamed from: b */
    public void m10874b(int i) {
        this.f11921l = i;
    }

    /* JADX INFO: renamed from: c */
    public void m10876c(int i) {
        this.f11922m = i;
    }

    /* JADX INFO: renamed from: a */
    public void m10872a(long j) {
        this.f11923n = j;
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m10902i());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.f11924o == 1 ? 16 : 0) + 28 + (this.f11924o == 2 ? 36 : 0));
        byteBufferAllocate.position(6);
        C1935ng.m10749b(byteBufferAllocate, this.f11919a);
        C1935ng.m10749b(byteBufferAllocate, this.f11924o);
        C1935ng.m10749b(byteBufferAllocate, this.f11931v);
        C1935ng.m10750b(byteBufferAllocate, this.f11932w);
        C1935ng.m10749b(byteBufferAllocate, this.f11921l);
        C1935ng.m10749b(byteBufferAllocate, this.f11922m);
        C1935ng.m10749b(byteBufferAllocate, this.f11925p);
        C1935ng.m10749b(byteBufferAllocate, this.f11926q);
        if (this.f11956d.equals("mlpa")) {
            C1935ng.m10750b(byteBufferAllocate, m10875c());
        } else {
            C1935ng.m10750b(byteBufferAllocate, m10875c() << 16);
        }
        if (this.f11924o == 1) {
            C1935ng.m10750b(byteBufferAllocate, this.f11927r);
            C1935ng.m10750b(byteBufferAllocate, this.f11928s);
            C1935ng.m10750b(byteBufferAllocate, this.f11929t);
            C1935ng.m10750b(byteBufferAllocate, this.f11930u);
        }
        if (this.f11924o == 2) {
            C1935ng.m10750b(byteBufferAllocate, this.f11927r);
            C1935ng.m10750b(byteBufferAllocate, this.f11928s);
            C1935ng.m10750b(byteBufferAllocate, this.f11929t);
            C1935ng.m10750b(byteBufferAllocate, this.f11930u);
            byteBufferAllocate.put(this.f11933x);
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        m10911b(writableByteChannel);
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public long mo1637a() {
        int i = 16;
        long jK = ((long) ((this.f11924o == 1 ? 16 : 0) + 28 + (this.f11924o == 2 ? 36 : 0))) + m10913k();
        if (!this.f11957e && jK + 8 < 4294967296L) {
            i = 8;
        }
        return jK + ((long) i);
    }

    @Override // p000.C1986op
    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.f11930u + ", bytesPerFrame=" + this.f11929t + ", bytesPerPacket=" + this.f11928s + ", samplesPerPacket=" + this.f11927r + ", packetSize=" + this.f11926q + ", compressionId=" + this.f11925p + ", soundVersion=" + this.f11924o + ", sampleRate=" + this.f11923n + ", sampleSize=" + this.f11922m + ", channelCount=" + this.f11921l + ", boxes=" + m10912j() + '}';
    }
}
