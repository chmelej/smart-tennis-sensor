package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: ol */
/* JADX INFO: compiled from: VisualSampleEntry.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1982ol extends AbstractC1968oi implements InterfaceC1940nl {

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f11934b = true;

    /* JADX INFO: renamed from: l */
    private int f11935l;

    /* JADX INFO: renamed from: m */
    private int f11936m;

    /* JADX INFO: renamed from: n */
    private double f11937n;

    /* JADX INFO: renamed from: o */
    private double f11938o;

    /* JADX INFO: renamed from: p */
    private int f11939p;

    /* JADX INFO: renamed from: q */
    private String f11940q;

    /* JADX INFO: renamed from: r */
    private int f11941r;

    /* JADX INFO: renamed from: s */
    private long[] f11942s;

    public C1982ol() {
        super("avc1");
        this.f11937n = 72.0d;
        this.f11938o = 72.0d;
        this.f11939p = 1;
        this.f11940q = "";
        this.f11941r = 24;
        this.f11942s = new long[3];
    }

    public C1982ol(String str) {
        super(str);
        this.f11937n = 72.0d;
        this.f11938o = 72.0d;
        this.f11939p = 1;
        this.f11940q = "";
        this.f11941r = 24;
        this.f11942s = new long[3];
    }

    /* JADX INFO: renamed from: b */
    public int m10882b() {
        return this.f11935l;
    }

    /* JADX INFO: renamed from: b */
    public void m10884b(int i) {
        this.f11935l = i;
    }

    /* JADX INFO: renamed from: c */
    public int m10885c() {
        return this.f11936m;
    }

    /* JADX INFO: renamed from: c */
    public void m10886c(int i) {
        this.f11936m = i;
    }

    /* JADX INFO: renamed from: d */
    public double m10887d() {
        return this.f11937n;
    }

    /* JADX INFO: renamed from: a */
    public void m10881a(double d) {
        this.f11937n = d;
    }

    /* JADX INFO: renamed from: e */
    public double m10889e() {
        return this.f11938o;
    }

    /* JADX INFO: renamed from: b */
    public void m10883b(double d) {
        this.f11938o = d;
    }

    /* JADX INFO: renamed from: f */
    public int m10891f() {
        return this.f11939p;
    }

    /* JADX INFO: renamed from: d */
    public void m10888d(int i) {
        this.f11939p = i;
    }

    /* JADX INFO: renamed from: g */
    public String m10892g() {
        return this.f11940q;
    }

    /* JADX INFO: renamed from: h */
    public int m10893h() {
        return this.f11941r;
    }

    /* JADX INFO: renamed from: e */
    public void m10890e(int i) {
        this.f11941r = i;
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m10902i());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        C1935ng.m10749b(byteBufferAllocate, this.f11919a);
        C1935ng.m10749b(byteBufferAllocate, 0);
        C1935ng.m10749b(byteBufferAllocate, 0);
        C1935ng.m10750b(byteBufferAllocate, this.f11942s[0]);
        C1935ng.m10750b(byteBufferAllocate, this.f11942s[1]);
        C1935ng.m10750b(byteBufferAllocate, this.f11942s[2]);
        C1935ng.m10749b(byteBufferAllocate, m10882b());
        C1935ng.m10749b(byteBufferAllocate, m10885c());
        C1935ng.m10744a(byteBufferAllocate, m10887d());
        C1935ng.m10744a(byteBufferAllocate, m10889e());
        C1935ng.m10750b(byteBufferAllocate, 0L);
        C1935ng.m10749b(byteBufferAllocate, m10891f());
        C1935ng.m10753c(byteBufferAllocate, C1936nh.m10756b(m10892g()));
        byteBufferAllocate.put(C1936nh.m10755a(m10892g()));
        int iM10756b = C1936nh.m10756b(m10892g());
        while (iM10756b < 31) {
            iM10756b++;
            byteBufferAllocate.put((byte) 0);
        }
        C1935ng.m10749b(byteBufferAllocate, m10893h());
        C1935ng.m10749b(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        m10911b(writableByteChannel);
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public long mo1637a() {
        long jK = m10913k() + 78;
        return jK + ((long) ((this.f11957e || jK + 8 >= 4294967296L) ? 16 : 8));
    }
}
