package p000;

/* JADX INFO: renamed from: vx */
/* JADX INFO: compiled from: SharedLibraryNameHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C2202vx {

    /* JADX INFO: renamed from: a */
    private String f13237a;

    /* JADX INFO: renamed from: b */
    private String f13238b;

    /* JADX INFO: renamed from: c */
    private String f13239c;

    /* JADX INFO: renamed from: d */
    private String f13240d;

    /* JADX INFO: renamed from: vx$a */
    /* JADX INFO: compiled from: SharedLibraryNameHelper.java */
    public enum a {
        PL_SO_TYPE_MM,
        PL_SO_TYPE_AMIX,
        PL_SO_TYPE_DECODER,
        PL_SO_TYPE_ENCODER
    }

    /* JADX INFO: renamed from: vx$b */
    /* JADX INFO: compiled from: SharedLibraryNameHelper.java */
    static class b {

        /* JADX INFO: renamed from: a */
        public static final C2202vx f13247a = new C2202vx();
    }

    private C2202vx() {
        this.f13237a = "pldroid_beauty";
        this.f13238b = "pldroid_amix";
        this.f13239c = "pldroid_decoder";
        this.f13240d = "pldroid_encoder";
    }

    /* JADX INFO: renamed from: a */
    public static C2202vx m12056a() {
        return b.f13247a;
    }

    /* JADX INFO: renamed from: a */
    public String m12059a(a aVar) {
        switch (aVar) {
            case PL_SO_TYPE_MM:
                return this.f13237a;
            case PL_SO_TYPE_AMIX:
                return this.f13238b;
            case PL_SO_TYPE_DECODER:
                return this.f13239c;
            case PL_SO_TYPE_ENCODER:
                return this.f13240d;
            default:
                throw new IllegalArgumentException("cannot support the so type:" + aVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m12058a(boolean z) {
        if (z && !C2148tx.f12860a) {
            C2201vw.f13212a.m12055e("PLSONameHelper", "MM Processing is not available");
        }
        return C2148tx.f12860a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12060b() {
        return m12057a(m12059a(a.PL_SO_TYPE_MM));
    }

    /* JADX INFO: renamed from: c */
    public boolean m12061c() {
        return m12057a(m12059a(a.PL_SO_TYPE_ENCODER));
    }

    /* JADX INFO: renamed from: a */
    private boolean m12057a(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (str.contains("/")) {
                System.load(str);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            C2201vw.f13212a.m12055e("PLSONameHelper", "Load error:" + e.getMessage());
            return false;
        }
    }
}
