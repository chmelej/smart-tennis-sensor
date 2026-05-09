package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: oh */
/* JADX INFO: compiled from: VideoMediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1967oh extends AbstractC1937ni {

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11912c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11913k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f11914l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f11915m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f11916n = null;

    /* JADX INFO: renamed from: a */
    private int f11917a;

    /* JADX INFO: renamed from: b */
    private int[] f11918b;

    static {
        m10868e();
    }

    /* JADX INFO: renamed from: e */
    private static /* synthetic */ void m10868e() {
        aru aruVar = new aru("VideoMediaHeaderBox.java", C1967oh.class);
        f11912c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        f11913k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        f11914l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        f11915m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        f11916n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return 12L;
    }

    public C1967oh() {
        super("vmhd");
        this.f11917a = 0;
        this.f11918b = new int[3];
        m10906d(1);
    }

    /* JADX INFO: renamed from: c */
    public int m10869c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11912c, this, this));
        return this.f11917a;
    }

    /* JADX INFO: renamed from: d */
    public int[] m10870d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11913k, this, this));
        return this.f11918b;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        this.f11917a = C1934nf.m10736c(byteBuffer);
        this.f11918b = new int[3];
        for (int i = 0; i < 3; i++) {
            this.f11918b[i] = C1934nf.m10736c(byteBuffer);
        }
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10749b(byteBuffer, this.f11917a);
        for (int i : this.f11918b) {
            C1935ng.m10749b(byteBuffer, i);
        }
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11914l, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + m10869c() + ";opcolor0=" + m10870d()[0] + ";opcolor1=" + m10870d()[1] + ";opcolor2=" + m10870d()[2] + "]";
    }
}
