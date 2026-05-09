package p000;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import p000.ark;

/* JADX INFO: renamed from: oe */
/* JADX INFO: compiled from: TimeToSampleBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1964oe extends AbstractC1985oo {

    /* JADX INFO: renamed from: b */
    static Map<List<a>, SoftReference<long[]>> f11864b = null;

    /* JADX INFO: renamed from: c */
    static final /* synthetic */ boolean f11865c = true;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11866k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f11867l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f11868m = null;

    /* JADX INFO: renamed from: a */
    List<a> f11869a;

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10840c() {
        aru aruVar = new aru("TimeToSampleBox.java", C1964oe.class);
        f11866k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        f11867l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        f11868m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    public C1964oe() {
        super("stts");
        this.f11869a = Collections.emptyList();
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11869a.size() * 8) + 8;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        int iM11093a = C2025pk.m11093a(C1934nf.m10733a(byteBuffer));
        this.f11869a = new ArrayList(iM11093a);
        for (int i = 0; i < iM11093a; i++) {
            this.f11869a.add(new a(C1934nf.m10733a(byteBuffer), C1934nf.m10733a(byteBuffer)));
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11869a.size());
        for (a aVar : this.f11869a) {
            C1935ng.m10750b(byteBuffer, aVar.m10842a());
            C1935ng.m10750b(byteBuffer, aVar.m10844b());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10841a(List<a> list) {
        C1988or.m10919a().m10921a(aru.m5284a(f11867l, this, this, list));
        this.f11869a = list;
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11868m, this, this));
        return "TimeToSampleBox[entryCount=" + this.f11869a.size() + "]";
    }

    /* JADX INFO: renamed from: oe$a */
    /* JADX INFO: compiled from: TimeToSampleBox.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        long f11870a;

        /* JADX INFO: renamed from: b */
        long f11871b;

        public a(long j, long j2) {
            this.f11870a = j;
            this.f11871b = j2;
        }

        /* JADX INFO: renamed from: a */
        public long m10842a() {
            return this.f11870a;
        }

        /* JADX INFO: renamed from: b */
        public long m10844b() {
            return this.f11871b;
        }

        /* JADX INFO: renamed from: a */
        public void m10843a(long j) {
            this.f11870a = j;
        }

        public String toString() {
            return "Entry{count=" + this.f11870a + ", delta=" + this.f11871b + '}';
        }
    }

    static {
        m10840c();
        f11864b = new WeakHashMap();
    }
}
