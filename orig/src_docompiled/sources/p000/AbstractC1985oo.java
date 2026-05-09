package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: oo */
/* JADX INFO: compiled from: AbstractFullBox.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1985oo extends AbstractC1983om implements InterfaceC1949nq {

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f11958c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f11959k = null;

    /* JADX INFO: renamed from: a */
    private int f11960a;

    /* JADX INFO: renamed from: b */
    private int f11961b;

    static {
        m10903c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10903c() {
        aru aruVar = new aru("AbstractFullBox.java", AbstractC1985oo.class);
        f11958c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        f11959k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    protected AbstractC1985oo(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: p */
    public int m10908p() {
        if (!this.f11948e) {
            m10898l();
        }
        return this.f11960a;
    }

    /* JADX INFO: renamed from: c */
    public void m10905c(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f11958c, this, this, ars.m5278a(i)));
        this.f11960a = i;
    }

    /* JADX INFO: renamed from: q */
    public int m10909q() {
        if (!this.f11948e) {
            m10898l();
        }
        return this.f11961b;
    }

    /* JADX INFO: renamed from: d */
    public void m10906d(int i) {
        C1988or.m10919a().m10921a(aru.m5284a(f11959k, this, this, ars.m5278a(i)));
        this.f11961b = i;
    }

    /* JADX INFO: renamed from: c */
    protected final long m10904c(ByteBuffer byteBuffer) {
        this.f11960a = C1934nf.m10737d(byteBuffer);
        this.f11961b = C1934nf.m10735b(byteBuffer);
        return 4L;
    }

    /* JADX INFO: renamed from: d */
    protected final void m10907d(ByteBuffer byteBuffer) {
        C1935ng.m10753c(byteBuffer, this.f11960a);
        C1935ng.m10745a(byteBuffer, this.f11961b);
    }
}
