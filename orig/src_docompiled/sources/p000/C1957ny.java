package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: ny */
/* JADX INFO: compiled from: SampleSizeBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1957ny extends AbstractC1985oo {

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11836k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f11837l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f11838m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f11839n = null;

    /* JADX INFO: renamed from: o */
    private static final /* synthetic */ ark.InterfaceC0740a f11840o = null;

    /* JADX INFO: renamed from: p */
    private static final /* synthetic */ ark.InterfaceC0740a f11841p = null;

    /* JADX INFO: renamed from: q */
    private static final /* synthetic */ ark.InterfaceC0740a f11842q = null;

    /* JADX INFO: renamed from: a */
    int f11843a;

    /* JADX INFO: renamed from: b */
    private long f11844b;

    /* JADX INFO: renamed from: c */
    private long[] f11845c;

    static {
        m10824e();
    }

    /* JADX INFO: renamed from: e */
    private static /* synthetic */ void m10824e() {
        aru aruVar = new aru("SampleSizeBox.java", C1957ny.class);
        f11836k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        f11837l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        f11838m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        f11839n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        f11840o = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        f11841p = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        f11842q = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    public C1957ny() {
        super("stsz");
        this.f11845c = new long[0];
    }

    /* JADX INFO: renamed from: c */
    public long m10826c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11836k, this, this));
        return this.f11844b;
    }

    /* JADX INFO: renamed from: d */
    public long m10827d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11839n, this, this));
        if (this.f11844b > 0) {
            return this.f11843a;
        }
        return this.f11845c.length;
    }

    /* JADX INFO: renamed from: a */
    public void m10825a(long[] jArr) {
        C1988or.m10919a().m10921a(aru.m5284a(f11841p, this, this, jArr));
        this.f11845c = jArr;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11844b == 0 ? this.f11845c.length * 4 : 0) + 12;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        this.f11844b = C1934nf.m10733a(byteBuffer);
        this.f11843a = C2025pk.m11093a(C1934nf.m10733a(byteBuffer));
        if (this.f11844b == 0) {
            this.f11845c = new long[this.f11843a];
            for (int i = 0; i < this.f11843a; i++) {
                this.f11845c[i] = C1934nf.m10733a(byteBuffer);
            }
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11844b);
        if (this.f11844b == 0) {
            C1935ng.m10750b(byteBuffer, this.f11845c.length);
            for (long j : this.f11845c) {
                C1935ng.m10750b(byteBuffer, j);
            }
            return;
        }
        C1935ng.m10750b(byteBuffer, this.f11843a);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11842q, this, this));
        return "SampleSizeBox[sampleSize=" + m10826c() + ";sampleCount=" + m10827d() + "]";
    }
}
