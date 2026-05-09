package p000;

import java.nio.ByteBuffer;
import java.util.Date;
import p000.ark;

/* JADX INFO: renamed from: nw */
/* JADX INFO: compiled from: MovieHeaderBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1955nw extends AbstractC1985oo {

    /* JADX INFO: renamed from: A */
    private static final /* synthetic */ ark.InterfaceC0740a f11791A = null;

    /* JADX INFO: renamed from: B */
    private static final /* synthetic */ ark.InterfaceC0740a f11792B = null;

    /* JADX INFO: renamed from: C */
    private static final /* synthetic */ ark.InterfaceC0740a f11793C = null;

    /* JADX INFO: renamed from: D */
    private static final /* synthetic */ ark.InterfaceC0740a f11794D = null;

    /* JADX INFO: renamed from: E */
    private static final /* synthetic */ ark.InterfaceC0740a f11795E = null;

    /* JADX INFO: renamed from: F */
    private static final /* synthetic */ ark.InterfaceC0740a f11796F = null;

    /* JADX INFO: renamed from: G */
    private static final /* synthetic */ ark.InterfaceC0740a f11797G = null;

    /* JADX INFO: renamed from: H */
    private static final /* synthetic */ ark.InterfaceC0740a f11798H = null;

    /* JADX INFO: renamed from: I */
    private static final /* synthetic */ ark.InterfaceC0740a f11799I = null;

    /* JADX INFO: renamed from: J */
    private static final /* synthetic */ ark.InterfaceC0740a f11800J = null;

    /* JADX INFO: renamed from: K */
    private static final /* synthetic */ ark.InterfaceC0740a f11801K = null;

    /* JADX INFO: renamed from: L */
    private static final /* synthetic */ ark.InterfaceC0740a f11802L = null;

    /* JADX INFO: renamed from: M */
    private static final /* synthetic */ ark.InterfaceC0740a f11803M = null;

    /* JADX INFO: renamed from: N */
    private static final /* synthetic */ ark.InterfaceC0740a f11804N = null;

    /* JADX INFO: renamed from: O */
    private static final /* synthetic */ ark.InterfaceC0740a f11805O = null;

    /* JADX INFO: renamed from: P */
    private static final /* synthetic */ ark.InterfaceC0740a f11806P = null;

    /* JADX INFO: renamed from: Q */
    private static final /* synthetic */ ark.InterfaceC0740a f11807Q = null;

    /* JADX INFO: renamed from: R */
    private static final /* synthetic */ ark.InterfaceC0740a f11808R = null;

    /* JADX INFO: renamed from: S */
    private static final /* synthetic */ ark.InterfaceC0740a f11809S = null;

    /* JADX INFO: renamed from: T */
    private static final /* synthetic */ ark.InterfaceC0740a f11810T = null;

    /* JADX INFO: renamed from: U */
    private static final /* synthetic */ ark.InterfaceC0740a f11811U = null;

    /* JADX INFO: renamed from: V */
    private static final /* synthetic */ ark.InterfaceC0740a f11812V = null;

    /* JADX INFO: renamed from: W */
    private static final /* synthetic */ ark.InterfaceC0740a f11813W = null;

    /* JADX INFO: renamed from: X */
    private static final /* synthetic */ ark.InterfaceC0740a f11814X = null;

    /* JADX INFO: renamed from: v */
    private static final /* synthetic */ ark.InterfaceC0740a f11815v = null;

    /* JADX INFO: renamed from: w */
    private static final /* synthetic */ ark.InterfaceC0740a f11816w = null;

    /* JADX INFO: renamed from: x */
    private static final /* synthetic */ ark.InterfaceC0740a f11817x = null;

    /* JADX INFO: renamed from: y */
    private static final /* synthetic */ ark.InterfaceC0740a f11818y = null;

    /* JADX INFO: renamed from: z */
    private static final /* synthetic */ ark.InterfaceC0740a f11819z = null;

    /* JADX INFO: renamed from: a */
    private Date f11820a;

    /* JADX INFO: renamed from: b */
    private Date f11821b;

    /* JADX INFO: renamed from: c */
    private long f11822c;

    /* JADX INFO: renamed from: k */
    private long f11823k;

    /* JADX INFO: renamed from: l */
    private double f11824l;

    /* JADX INFO: renamed from: m */
    private float f11825m;

    /* JADX INFO: renamed from: n */
    private C2030pp f11826n;

    /* JADX INFO: renamed from: o */
    private long f11827o;

    /* JADX INFO: renamed from: p */
    private int f11828p;

    /* JADX INFO: renamed from: q */
    private int f11829q;

    /* JADX INFO: renamed from: r */
    private int f11830r;

    /* JADX INFO: renamed from: s */
    private int f11831s;

    /* JADX INFO: renamed from: t */
    private int f11832t;

    /* JADX INFO: renamed from: u */
    private int f11833u;

    static {
        m10810j();
    }

    /* JADX INFO: renamed from: j */
    private static /* synthetic */ void m10810j() {
        aru aruVar = new aru("MovieHeaderBox.java", C1955nw.class);
        f11815v = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        f11816w = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        f11796F = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        f11797G = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        f11798H = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 215);
        f11799I = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        f11800J = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 226);
        f11801K = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        f11802L = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        f11803M = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        f11804N = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        f11805O = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        f11817x = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        f11806P = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        f11807Q = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        f11808R = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 258);
        f11809S = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        f11810T = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        f11811U = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 270);
        f11812V = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        f11813W = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        f11814X = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        f11818y = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        f11819z = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        f11791A = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 83);
        f11792B = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        f11793C = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        f11794D = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 139);
        f11795E = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 195);
    }

    public C1955nw() {
        super("mvhd");
        this.f11824l = 1.0d;
        this.f11825m = 1.0f;
        this.f11826n = C2030pp.f12194j;
    }

    /* JADX INFO: renamed from: c */
    public Date m10816c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11815v, this, this));
        return this.f11820a;
    }

    /* JADX INFO: renamed from: d */
    public Date m10818d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11816w, this, this));
        return this.f11821b;
    }

    /* JADX INFO: renamed from: e */
    public long m10819e() {
        C1988or.m10919a().m10921a(aru.m5283a(f11817x, this, this));
        return this.f11822c;
    }

    /* JADX INFO: renamed from: f */
    public long m10820f() {
        C1988or.m10919a().m10921a(aru.m5283a(f11818y, this, this));
        return this.f11823k;
    }

    /* JADX INFO: renamed from: g */
    public double m10821g() {
        C1988or.m10919a().m10921a(aru.m5283a(f11819z, this, this));
        return this.f11824l;
    }

    /* JADX INFO: renamed from: h */
    public float m10822h() {
        C1988or.m10919a().m10921a(aru.m5283a(f11791A, this, this));
        return this.f11825m;
    }

    /* JADX INFO: renamed from: i */
    public long m10823i() {
        C1988or.m10919a().m10921a(aru.m5283a(f11793C, this, this));
        return this.f11827o;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return (m10908p() == 1 ? 32L : 20L) + 80;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        if (m10908p() == 1) {
            this.f11820a = C2026pl.m11095a(C1934nf.m10738e(byteBuffer));
            this.f11821b = C2026pl.m11095a(C1934nf.m10738e(byteBuffer));
            this.f11822c = C1934nf.m10733a(byteBuffer);
            this.f11823k = C1934nf.m10738e(byteBuffer);
        } else {
            this.f11820a = C2026pl.m11095a(C1934nf.m10733a(byteBuffer));
            this.f11821b = C2026pl.m11095a(C1934nf.m10733a(byteBuffer));
            this.f11822c = C1934nf.m10733a(byteBuffer);
            this.f11823k = C1934nf.m10733a(byteBuffer);
        }
        this.f11824l = C1934nf.m10739f(byteBuffer);
        this.f11825m = C1934nf.m10741h(byteBuffer);
        C1934nf.m10736c(byteBuffer);
        C1934nf.m10733a(byteBuffer);
        C1934nf.m10733a(byteBuffer);
        this.f11826n = C2030pp.m11099a(byteBuffer);
        this.f11828p = byteBuffer.getInt();
        this.f11829q = byteBuffer.getInt();
        this.f11830r = byteBuffer.getInt();
        this.f11831s = byteBuffer.getInt();
        this.f11832t = byteBuffer.getInt();
        this.f11833u = byteBuffer.getInt();
        this.f11827o = C1934nf.m10733a(byteBuffer);
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11794D, this, this));
        return "MovieHeaderBox[creationTime=" + m10816c() + ";modificationTime=" + m10818d() + ";timescale=" + m10819e() + ";duration=" + m10820f() + ";rate=" + m10821g() + ";volume=" + m10822h() + ";matrix=" + this.f11826n + ";nextTrackId=" + m10823i() + "]";
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        if (m10908p() == 1) {
            C1935ng.m10746a(byteBuffer, C2026pl.m11094a(this.f11820a));
            C1935ng.m10746a(byteBuffer, C2026pl.m11094a(this.f11821b));
            C1935ng.m10750b(byteBuffer, this.f11822c);
            C1935ng.m10746a(byteBuffer, this.f11823k);
        } else {
            C1935ng.m10750b(byteBuffer, C2026pl.m11094a(this.f11820a));
            C1935ng.m10750b(byteBuffer, C2026pl.m11094a(this.f11821b));
            C1935ng.m10750b(byteBuffer, this.f11822c);
            C1935ng.m10750b(byteBuffer, this.f11823k);
        }
        C1935ng.m10744a(byteBuffer, this.f11824l);
        C1935ng.m10752c(byteBuffer, this.f11825m);
        C1935ng.m10749b(byteBuffer, 0);
        C1935ng.m10750b(byteBuffer, 0L);
        C1935ng.m10750b(byteBuffer, 0L);
        this.f11826n.m11100b(byteBuffer);
        byteBuffer.putInt(this.f11828p);
        byteBuffer.putInt(this.f11829q);
        byteBuffer.putInt(this.f11830r);
        byteBuffer.putInt(this.f11831s);
        byteBuffer.putInt(this.f11832t);
        byteBuffer.putInt(this.f11833u);
        C1935ng.m10750b(byteBuffer, this.f11827o);
    }

    /* JADX INFO: renamed from: a */
    public void m10812a(Date date) {
        C1988or.m10919a().m10921a(aru.m5284a(f11795E, this, this, date));
        this.f11820a = date;
        if (C2026pl.m11094a(date) >= 4294967296L) {
            m10905c(1);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10815b(Date date) {
        C1988or.m10919a().m10921a(aru.m5284a(f11796F, this, this, date));
        this.f11821b = date;
        if (C2026pl.m11094a(date) >= 4294967296L) {
            m10905c(1);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10811a(long j) {
        C1988or.m10919a().m10921a(aru.m5284a(f11797G, this, this, ars.m5279a(j)));
        this.f11822c = j;
    }

    /* JADX INFO: renamed from: b */
    public void m10814b(long j) {
        C1988or.m10919a().m10921a(aru.m5284a(f11798H, this, this, ars.m5279a(j)));
        this.f11823k = j;
        if (j >= 4294967296L) {
            m10905c(1);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10813a(C2030pp c2030pp) {
        C1988or.m10919a().m10921a(aru.m5284a(f11801K, this, this, c2030pp));
        this.f11826n = c2030pp;
    }

    /* JADX INFO: renamed from: c */
    public void m10817c(long j) {
        C1988or.m10919a().m10921a(aru.m5284a(f11802L, this, this, ars.m5279a(j)));
        this.f11827o = j;
    }
}
