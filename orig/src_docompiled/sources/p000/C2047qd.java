package p000;

import java.nio.ByteBuffer;
import java.util.List;
import p000.ark;

/* JADX INFO: renamed from: qd */
/* JADX INFO: compiled from: AvcConfigurationBox.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2047qd extends AbstractC1983om {

    /* JADX INFO: renamed from: A */
    private static final /* synthetic */ ark.InterfaceC0740a f12271A = null;

    /* JADX INFO: renamed from: B */
    private static final /* synthetic */ ark.InterfaceC0740a f12272B = null;

    /* JADX INFO: renamed from: C */
    private static final /* synthetic */ ark.InterfaceC0740a f12273C = null;

    /* JADX INFO: renamed from: D */
    private static final /* synthetic */ ark.InterfaceC0740a f12274D = null;

    /* JADX INFO: renamed from: E */
    private static final /* synthetic */ ark.InterfaceC0740a f12275E = null;

    /* JADX INFO: renamed from: F */
    private static final /* synthetic */ ark.InterfaceC0740a f12276F = null;

    /* JADX INFO: renamed from: G */
    private static final /* synthetic */ ark.InterfaceC0740a f12277G = null;

    /* JADX INFO: renamed from: H */
    private static final /* synthetic */ ark.InterfaceC0740a f12278H = null;

    /* JADX INFO: renamed from: I */
    private static final /* synthetic */ ark.InterfaceC0740a f12279I = null;

    /* JADX INFO: renamed from: J */
    private static final /* synthetic */ ark.InterfaceC0740a f12280J = null;

    /* JADX INFO: renamed from: K */
    private static final /* synthetic */ ark.InterfaceC0740a f12281K = null;

    /* JADX INFO: renamed from: L */
    private static final /* synthetic */ ark.InterfaceC0740a f12282L = null;

    /* JADX INFO: renamed from: b */
    private static final /* synthetic */ ark.InterfaceC0740a f12283b = null;

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f12284c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f12285k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f12286l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f12287m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f12288n = null;

    /* JADX INFO: renamed from: o */
    private static final /* synthetic */ ark.InterfaceC0740a f12289o = null;

    /* JADX INFO: renamed from: p */
    private static final /* synthetic */ ark.InterfaceC0740a f12290p = null;

    /* JADX INFO: renamed from: q */
    private static final /* synthetic */ ark.InterfaceC0740a f12291q = null;

    /* JADX INFO: renamed from: r */
    private static final /* synthetic */ ark.InterfaceC0740a f12292r = null;

    /* JADX INFO: renamed from: s */
    private static final /* synthetic */ ark.InterfaceC0740a f12293s = null;

    /* JADX INFO: renamed from: t */
    private static final /* synthetic */ ark.InterfaceC0740a f12294t = null;

    /* JADX INFO: renamed from: u */
    private static final /* synthetic */ ark.InterfaceC0740a f12295u = null;

    /* JADX INFO: renamed from: v */
    private static final /* synthetic */ ark.InterfaceC0740a f12296v = null;

    /* JADX INFO: renamed from: w */
    private static final /* synthetic */ ark.InterfaceC0740a f12297w = null;

    /* JADX INFO: renamed from: x */
    private static final /* synthetic */ ark.InterfaceC0740a f12298x = null;

    /* JADX INFO: renamed from: y */
    private static final /* synthetic */ ark.InterfaceC0740a f12299y = null;

    /* JADX INFO: renamed from: z */
    private static final /* synthetic */ ark.InterfaceC0740a f12300z = null;

    /* JADX INFO: renamed from: a */
    public C2048qe f12301a;

    static {
        m11169c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m11169c() {
        aru aruVar = new aru("AvcConfigurationBox.java", C2047qd.class);
        f12283b = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        f12284c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        f12293s = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        f12294t = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        f12295u = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        f12296v = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        f12297w = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        f12298x = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        f12299y = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        f12300z = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        f12271A = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        f12272B = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        f12285k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        f12273C = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        f12274D = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        f12275E = aruVar.m5287a("method-execution", aruVar.m5288a("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        f12276F = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        f12277G = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        f12278H = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        f12279I = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        f12280J = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        f12281K = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        f12282L = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        f12286l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        f12287m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        f12288n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        f12289o = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        f12290p = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        f12291q = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        f12292r = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    public C2047qd() {
        super("avcC");
        this.f12301a = new C2048qe();
    }

    /* JADX INFO: renamed from: a */
    public void m11170a(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12290p, this, this, ars.m5278a(i)));
        this.f12301a.f12302a = i;
    }

    /* JADX INFO: renamed from: b */
    public void m11172b(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12291q, this, this, ars.m5278a(i)));
        this.f12301a.f12303b = i;
    }

    /* JADX INFO: renamed from: c */
    public void m11174c(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12292r, this, this, ars.m5278a(i)));
        this.f12301a.f12304c = i;
    }

    /* JADX INFO: renamed from: d */
    public void m11175d(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12293s, this, this, ars.m5278a(i)));
        this.f12301a.f12305d = i;
    }

    /* JADX INFO: renamed from: e */
    public void m11176e(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12294t, this, this, ars.m5278a(i)));
        this.f12301a.f12306e = i;
    }

    /* JADX INFO: renamed from: a */
    public void m11171a(List<byte[]> list) {
        C1988or.m10919a().m10921a(aru.m5284a(f12295u, this, this, list));
        this.f12301a.f12307f = list;
    }

    /* JADX INFO: renamed from: b */
    public void m11173b(List<byte[]> list) {
        C1988or.m10919a().m10921a(aru.m5284a(f12296v, this, this, list));
        this.f12301a.f12308g = list;
    }

    /* JADX INFO: renamed from: f */
    public void m11177f(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12298x, this, this, ars.m5278a(i)));
        this.f12301a.f12310i = i;
    }

    /* JADX INFO: renamed from: g */
    public void m11178g(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12300z, this, this, ars.m5278a(i)));
        this.f12301a.f12311j = i;
    }

    /* JADX INFO: renamed from: h */
    public void m11179h(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f12272B, this, this, ars.m5278a(i)));
        this.f12301a.f12312k = i;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        this.f12301a = new C2048qe(byteBuffer);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    public long mo10761a_() {
        C1988or.m10919a().m10921a(aru.m5283a(f12277G, this, this));
        return this.f12301a.m11180a();
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    public void mo10762b(ByteBuffer byteBuffer) {
        C1988or.m10919a().m10921a(aru.m5284a(f12278H, this, this, byteBuffer));
        this.f12301a.m11181a(byteBuffer);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f12282L, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.f12301a + '}';
    }
}
