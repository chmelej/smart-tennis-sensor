package p000;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000.ark;

/* JADX INFO: renamed from: np */
/* JADX INFO: compiled from: FileTypeBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1948np extends AbstractC1983om {

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11752k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f11753l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f11754m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f11755n = null;

    /* JADX INFO: renamed from: o */
    private static final /* synthetic */ ark.InterfaceC0740a f11756o = null;

    /* JADX INFO: renamed from: p */
    private static final /* synthetic */ ark.InterfaceC0740a f11757p = null;

    /* JADX INFO: renamed from: a */
    private String f11758a;

    /* JADX INFO: renamed from: b */
    private long f11759b;

    /* JADX INFO: renamed from: c */
    private List<String> f11760c;

    static {
        m10792e();
    }

    /* JADX INFO: renamed from: e */
    private static /* synthetic */ void m10792e() {
        aru aruVar = new aru("FileTypeBox.java", C1948np.class);
        f11752k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        f11753l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        f11754m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "long", "minorVersion", "", "void"), 103);
        f11755n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "long"), 113);
        f11756o = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        f11757p = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    public C1948np() {
        super("ftyp");
        this.f11760c = Collections.emptyList();
    }

    public C1948np(String str, long j, List<String> list) {
        super("ftyp");
        this.f11760c = Collections.emptyList();
        this.f11758a = str;
        this.f11759b = j;
        this.f11760c = list;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (this.f11760c.size() * 4) + 8;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        this.f11758a = C1934nf.m10743j(byteBuffer);
        this.f11759b = C1934nf.m10733a(byteBuffer);
        int iRemaining = byteBuffer.remaining() / 4;
        this.f11760c = new LinkedList();
        for (int i = 0; i < iRemaining; i++) {
            this.f11760c.add(C1934nf.m10743j(byteBuffer));
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        byteBuffer.put(C1933ne.m10731a(this.f11758a));
        C1935ng.m10750b(byteBuffer, this.f11759b);
        Iterator<String> it = this.f11760c.iterator();
        while (it.hasNext()) {
            byteBuffer.put(C1933ne.m10731a(it.next()));
        }
    }

    /* JADX INFO: renamed from: c */
    public String m10793c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11752k, this, this));
        return this.f11758a;
    }

    /* JADX INFO: renamed from: d */
    public long m10794d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11755n, this, this));
        return this.f11759b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(m10793c());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(m10794d());
        for (String str : this.f11760c) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }
}
