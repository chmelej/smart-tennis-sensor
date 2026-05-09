package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: ob */
/* JADX INFO: compiled from: SoundMediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1961ob extends AbstractC1937ni {

    /* JADX INFO: renamed from: b */
    private static final /* synthetic */ ark.InterfaceC0740a f11854b = null;

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11855c = null;

    /* JADX INFO: renamed from: a */
    private float f11856a;

    static {
        m10834d();
    }

    /* JADX INFO: renamed from: d */
    private static /* synthetic */ void m10834d() {
        aru aruVar = new aru("SoundMediaHeaderBox.java", C1961ob.class);
        f11854b = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        f11855c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return 8L;
    }

    public C1961ob() {
        super("smhd");
    }

    /* JADX INFO: renamed from: c */
    public float m10835c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11854b, this, this));
        return this.f11856a;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        this.f11856a = C1934nf.m10741h(byteBuffer);
        C1934nf.m10736c(byteBuffer);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10752c(byteBuffer, this.f11856a);
        C1935ng.m10749b(byteBuffer, 0);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11855c, this, this));
        return "SoundMediaHeaderBox[balance=" + m10835c() + "]";
    }
}
