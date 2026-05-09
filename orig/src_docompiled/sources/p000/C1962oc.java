package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: oc */
/* JADX INFO: compiled from: StaticChunkOffsetBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1962oc extends AbstractC1939nk {

    /* JADX INFO: renamed from: b */
    private static final /* synthetic */ ark.InterfaceC0740a f11857b = null;

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11858c = null;

    /* JADX INFO: renamed from: a */
    private long[] f11859a;

    static {
        m10836c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10836c() {
        aru aruVar = new aru("StaticChunkOffsetBox.java", C1962oc.class);
        f11857b = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        f11858c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    public C1962oc() {
        super("stco");
        this.f11859a = new long[0];
    }

    @Override // p000.AbstractC1939nk
    /* JADX INFO: renamed from: b */
    public long[] mo10758b() {
        C1988or.m10919a().m10921a(aru.m5283a(f11857b, this, this));
        return this.f11859a;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11859a.length * 4) + 8;
    }

    /* JADX INFO: renamed from: a */
    public void m10837a(long[] jArr) {
        C1988or.m10919a().m10921a(aru.m5284a(f11858c, this, this, jArr));
        this.f11859a = jArr;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        int iM11093a = C2025pk.m11093a(C1934nf.m10733a(byteBuffer));
        this.f11859a = new long[iM11093a];
        for (int i = 0; i < iM11093a; i++) {
            this.f11859a[i] = C1934nf.m10733a(byteBuffer);
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11859a.length);
        for (long j : this.f11859a) {
            C1935ng.m10750b(byteBuffer, j);
        }
    }
}
