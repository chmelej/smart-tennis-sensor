package p000;

import java.nio.ByteBuffer;
import java.util.Date;
import p000.ark;

/* JADX INFO: renamed from: nt */
/* JADX INFO: compiled from: MediaHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1952nt extends AbstractC1985oo {

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f11775m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f11776n = null;

    /* JADX INFO: renamed from: o */
    private static final /* synthetic */ ark.InterfaceC0740a f11777o = null;

    /* JADX INFO: renamed from: p */
    private static final /* synthetic */ ark.InterfaceC0740a f11778p = null;

    /* JADX INFO: renamed from: q */
    private static final /* synthetic */ ark.InterfaceC0740a f11779q = null;

    /* JADX INFO: renamed from: r */
    private static final /* synthetic */ ark.InterfaceC0740a f11780r = null;

    /* JADX INFO: renamed from: s */
    private static final /* synthetic */ ark.InterfaceC0740a f11781s = null;

    /* JADX INFO: renamed from: t */
    private static final /* synthetic */ ark.InterfaceC0740a f11782t = null;

    /* JADX INFO: renamed from: u */
    private static final /* synthetic */ ark.InterfaceC0740a f11783u = null;

    /* JADX INFO: renamed from: v */
    private static final /* synthetic */ ark.InterfaceC0740a f11784v = null;

    /* JADX INFO: renamed from: w */
    private static final /* synthetic */ ark.InterfaceC0740a f11785w = null;

    /* JADX INFO: renamed from: a */
    private Date f11786a;

    /* JADX INFO: renamed from: b */
    private Date f11787b;

    /* JADX INFO: renamed from: c */
    private long f11788c;

    /* JADX INFO: renamed from: k */
    private long f11789k;

    /* JADX INFO: renamed from: l */
    private String f11790l;

    static {
        m10800h();
    }

    /* JADX INFO: renamed from: h */
    private static /* synthetic */ void m10800h() {
        aru aruVar = new aru("MediaHeaderBox.java", C1952nt.class);
        f11775m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        f11776n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 50);
        f11785w = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 118);
        f11777o = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 54);
        f11778p = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 58);
        f11779q = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 62);
        f11780r = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 79);
        f11781s = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 83);
        f11782t = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 87);
        f11783u = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 91);
        f11784v = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 95);
    }

    public C1952nt() {
        super("mdhd");
        this.f11786a = new Date();
        this.f11787b = new Date();
        this.f11790l = "eng";
    }

    /* JADX INFO: renamed from: c */
    public Date m10805c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11775m, this, this));
        return this.f11786a;
    }

    /* JADX INFO: renamed from: d */
    public Date m10806d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11776n, this, this));
        return this.f11787b;
    }

    /* JADX INFO: renamed from: e */
    public long m10807e() {
        C1988or.m10919a().m10921a(aru.m5283a(f11777o, this, this));
        return this.f11788c;
    }

    /* JADX INFO: renamed from: f */
    public long m10808f() {
        C1988or.m10919a().m10921a(aru.m5283a(f11778p, this, this));
        return this.f11789k;
    }

    /* JADX INFO: renamed from: g */
    public String m10809g() {
        C1988or.m10919a().m10921a(aru.m5283a(f11779q, this, this));
        return this.f11790l;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (m10908p() == 1 ? 32L : 20L) + 2 + 2;
    }

    /* JADX INFO: renamed from: a */
    public void m10803a(Date date) {
        C1988or.m10919a().m10921a(aru.m5284a(f11780r, this, this, date));
        this.f11786a = date;
    }

    /* JADX INFO: renamed from: a */
    public void m10801a(long j) {
        C1988or.m10919a().m10921a(aru.m5284a(f11782t, this, this, ars.m5279a(j)));
        this.f11788c = j;
    }

    /* JADX INFO: renamed from: b */
    public void m10804b(long j) {
        C1988or.m10919a().m10921a(aru.m5284a(f11783u, this, this, ars.m5279a(j)));
        this.f11789k = j;
    }

    /* JADX INFO: renamed from: a */
    public void m10802a(String str) {
        C1988or.m10919a().m10921a(aru.m5284a(f11784v, this, this, str));
        this.f11790l = str;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        if (m10908p() == 1) {
            this.f11786a = C2026pl.m11095a(C1934nf.m10738e(byteBuffer));
            this.f11787b = C2026pl.m11095a(C1934nf.m10738e(byteBuffer));
            this.f11788c = C1934nf.m10733a(byteBuffer);
            this.f11789k = C1934nf.m10738e(byteBuffer);
        } else {
            this.f11786a = C2026pl.m11095a(C1934nf.m10733a(byteBuffer));
            this.f11787b = C2026pl.m11095a(C1934nf.m10733a(byteBuffer));
            this.f11788c = C1934nf.m10733a(byteBuffer);
            this.f11789k = C1934nf.m10733a(byteBuffer);
        }
        this.f11790l = C1934nf.m10742i(byteBuffer);
        C1934nf.m10736c(byteBuffer);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11785w, this, this));
        return "MediaHeaderBox[creationTime=" + m10805c() + ";modificationTime=" + m10806d() + ";timescale=" + m10807e() + ";duration=" + m10808f() + ";language=" + m10809g() + "]";
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        if (m10908p() == 1) {
            C1935ng.m10746a(byteBuffer, C2026pl.m11094a(this.f11786a));
            C1935ng.m10746a(byteBuffer, C2026pl.m11094a(this.f11787b));
            C1935ng.m10750b(byteBuffer, this.f11788c);
            C1935ng.m10746a(byteBuffer, this.f11789k);
        } else {
            C1935ng.m10750b(byteBuffer, C2026pl.m11094a(this.f11786a));
            C1935ng.m10750b(byteBuffer, C2026pl.m11094a(this.f11787b));
            C1935ng.m10750b(byteBuffer, this.f11788c);
            C1935ng.m10750b(byteBuffer, this.f11789k);
        }
        C1935ng.m10747a(byteBuffer, this.f11790l);
        C1935ng.m10749b(byteBuffer, 0);
    }
}
