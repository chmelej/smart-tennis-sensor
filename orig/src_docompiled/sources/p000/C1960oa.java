package p000;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.ark;

/* JADX INFO: renamed from: oa */
/* JADX INFO: compiled from: SampleToChunkBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1960oa extends AbstractC1985oo {

    /* JADX INFO: renamed from: b */
    private static final /* synthetic */ ark.InterfaceC0740a f11846b = null;

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11847c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11848k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f11849l = null;

    /* JADX INFO: renamed from: a */
    List<a> f11850a;

    static {
        m10828d();
    }

    /* JADX INFO: renamed from: d */
    private static /* synthetic */ void m10828d() {
        aru aruVar = new aru("SampleToChunkBox.java", C1960oa.class);
        f11846b = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        f11847c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        f11848k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        f11849l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    public C1960oa() {
        super("stsc");
        this.f11850a = Collections.emptyList();
    }

    /* JADX INFO: renamed from: c */
    public List<a> m10830c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11846b, this, this));
        return this.f11850a;
    }

    /* JADX INFO: renamed from: a */
    public void m10829a(List<a> list) {
        C1988or.m10919a().m10921a(aru.m5284a(f11847c, this, this, list));
        this.f11850a = list;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11850a.size() * 12) + 8;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        int iM11093a = C2025pk.m11093a(C1934nf.m10733a(byteBuffer));
        this.f11850a = new ArrayList(iM11093a);
        for (int i = 0; i < iM11093a; i++) {
            this.f11850a.add(new a(C1934nf.m10733a(byteBuffer), C1934nf.m10733a(byteBuffer), C1934nf.m10733a(byteBuffer)));
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11850a.size());
        for (a aVar : this.f11850a) {
            C1935ng.m10750b(byteBuffer, aVar.m10831a());
            C1935ng.m10750b(byteBuffer, aVar.m10832b());
            C1935ng.m10750b(byteBuffer, aVar.m10833c());
        }
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11848k, this, this));
        return "SampleToChunkBox[entryCount=" + this.f11850a.size() + "]";
    }

    /* JADX INFO: renamed from: oa$a */
    /* JADX INFO: compiled from: SampleToChunkBox.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        long f11851a;

        /* JADX INFO: renamed from: b */
        long f11852b;

        /* JADX INFO: renamed from: c */
        long f11853c;

        public a(long j, long j2, long j3) {
            this.f11851a = j;
            this.f11852b = j2;
            this.f11853c = j3;
        }

        /* JADX INFO: renamed from: a */
        public long m10831a() {
            return this.f11851a;
        }

        /* JADX INFO: renamed from: b */
        public long m10832b() {
            return this.f11852b;
        }

        /* JADX INFO: renamed from: c */
        public long m10833c() {
            return this.f11853c;
        }

        public String toString() {
            return "Entry{firstChunk=" + this.f11851a + ", samplesPerChunk=" + this.f11852b + ", sampleDescriptionIndex=" + this.f11853c + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11851a == aVar.f11851a && this.f11853c == aVar.f11853c && this.f11852b == aVar.f11852b;
        }

        public int hashCode() {
            return (((((int) (this.f11851a ^ (this.f11851a >>> 32))) * 31) + ((int) (this.f11852b ^ (this.f11852b >>> 32)))) * 31) + ((int) (this.f11853c ^ (this.f11853c >>> 32)));
        }
    }
}
