package p000;

import java.nio.ByteBuffer;
import p000.ark;

/* JADX INFO: renamed from: nm */
/* JADX INFO: compiled from: DataEntryUrlBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1941nm extends AbstractC1985oo {

    /* JADX INFO: renamed from: a */
    private static final /* synthetic */ ark.InterfaceC0740a f11727a = null;

    static {
        m10759c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10759c() {
        aru aruVar = new aru("DataEntryUrlBox.java", C1941nm.class);
        f11727a = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return 4L;
    }

    public C1941nm() {
        super("url ");
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11727a, this, this));
        return "DataEntryUrlBox[]";
    }
}
