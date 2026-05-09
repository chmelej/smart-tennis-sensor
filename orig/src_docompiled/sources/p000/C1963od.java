package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: od */
/* JADX INFO: compiled from: SyncSampleBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1963od extends AbstractC1985oo {

    /* JADX INFO: renamed from: b */
    private static final /* synthetic */ ark.InterfaceC0740a f11860b = null;

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11861c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11862k = null;

    /* JADX INFO: renamed from: a */
    private long[] f11863a;

    static {
        m10838c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10838c() {
        aru aruVar = new aru("SyncSampleBox.java", C1963od.class);
        f11860b = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        f11861c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        f11862k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    public C1963od() {
        super("stss");
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11863a.length * 4) + 8;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        int iM11093a = C2025pk.m11093a(C1934nf.m10733a(byteBuffer));
        this.f11863a = new long[iM11093a];
        for (int i = 0; i < iM11093a; i++) {
            this.f11863a[i] = C1934nf.m10733a(byteBuffer);
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11863a.length);
        for (long j : this.f11863a) {
            C1935ng.m10750b(byteBuffer, j);
        }
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11861c, this, this));
        return "SyncSampleBox[entryCount=" + this.f11863a.length + "]";
    }

    /* JADX INFO: renamed from: a */
    public void m10839a(long[] jArr) {
        C1988or.m10919a().m10921a(aru.m5284a(f11862k, this, this, jArr));
        this.f11863a = jArr;
    }
}
