package p000;

import p000.ark;

/* JADX INFO: renamed from: nk */
/* JADX INFO: compiled from: ChunkOffsetBox.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1939nk extends AbstractC1985oo {

    /* JADX INFO: renamed from: a */
    private static final /* synthetic */ ark.InterfaceC0740a f11726a = null;

    static {
        m10757c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m10757c() {
        aru aruVar = new aru("ChunkOffsetBox.java", AbstractC1939nk.class);
        f11726a = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    /* JADX INFO: renamed from: b */
    public abstract long[] mo10758b();

    public AbstractC1939nk(String str) {
        super(str);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11726a, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + mo10758b().length + "]";
    }
}
