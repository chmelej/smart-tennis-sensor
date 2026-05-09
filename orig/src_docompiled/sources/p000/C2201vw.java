package p000;

import android.util.Log;

/* JADX INFO: renamed from: vw */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class C2201vw {

    /* JADX INFO: renamed from: a */
    public static final C2201vw f13212a = new C2201vw("");

    /* JADX INFO: renamed from: b */
    public static final C2201vw f13213b = new C2201vw("Pili-System");

    /* JADX INFO: renamed from: c */
    public static final C2201vw f13214c = new C2201vw("Pili-SCREEN");

    /* JADX INFO: renamed from: d */
    public static final C2201vw f13215d = new C2201vw("Pili-Record");

    /* JADX INFO: renamed from: e */
    public static final C2201vw f13216e = new C2201vw("Pili-Editor");

    /* JADX INFO: renamed from: f */
    public static final C2201vw f13217f = new C2201vw("Pili-Capture");

    /* JADX INFO: renamed from: g */
    public static final C2201vw f13218g = new C2201vw("Pili-Processing");

    /* JADX INFO: renamed from: h */
    public static final C2201vw f13219h = new C2201vw("Pili-Encode");

    /* JADX INFO: renamed from: i */
    public static final C2201vw f13220i = new C2201vw("Pili-Decode");

    /* JADX INFO: renamed from: j */
    public static final C2201vw f13221j = new C2201vw("Pili-OpenGL");

    /* JADX INFO: renamed from: k */
    public static final C2201vw f13222k = new C2201vw("Pili-Player");

    /* JADX INFO: renamed from: l */
    public static final C2201vw f13223l = new C2201vw("Pili-Stat");

    /* JADX INFO: renamed from: m */
    public static final C2201vw f13224m = new C2201vw("Pili-Network");

    /* JADX INFO: renamed from: n */
    public static final C2201vw f13225n = new C2201vw("Pili-Muxer");

    /* JADX INFO: renamed from: o */
    public static final C2201vw f13226o = new C2201vw("Pili-Upload");

    /* JADX INFO: renamed from: p */
    public static final C2201vw f13227p = new C2201vw("Pili-Trim");

    /* JADX INFO: renamed from: q */
    public static final C2201vw f13228q = new C2201vw("Pili-AudioMix");

    /* JADX INFO: renamed from: r */
    public static final C2201vw f13229r = new C2201vw("Pili-Resampler");

    /* JADX INFO: renamed from: s */
    public static final C2201vw f13230s = new C2201vw("Pili-Transcode");

    /* JADX INFO: renamed from: t */
    public static final C2201vw f13231t = new C2201vw("Pili-Composer");

    /* JADX INFO: renamed from: u */
    public static final C2201vw f13232u = new C2201vw("Pili-Parser");

    /* JADX INFO: renamed from: v */
    public static final C2201vw f13233v = new C2201vw("Pili-Utils");

    /* JADX INFO: renamed from: w */
    private static String f13234w = "PLDroidShortVideo";

    /* JADX INFO: renamed from: x */
    private static int f13235x = 4;

    /* JADX INFO: renamed from: y */
    private final String f13236y;

    private C2201vw(String str) {
        this.f13236y = str;
    }

    /* JADX INFO: renamed from: a */
    public void m12049a(String str, String str2) {
        if (f13235x > 2) {
            return;
        }
        Log.v(f13234w, m12047d(str) + str2);
    }

    /* JADX INFO: renamed from: b */
    public void m12051b(String str, String str2) {
        if (f13235x > 3) {
            return;
        }
        Log.d(f13234w, m12047d(str) + str2);
    }

    /* JADX INFO: renamed from: a */
    public void m12048a(String str) {
        m12053c(null, str);
    }

    /* JADX INFO: renamed from: c */
    public void m12053c(String str, String str2) {
        if (f13235x > 4) {
            return;
        }
        Log.i(f13234w, m12047d(str) + str2);
    }

    /* JADX INFO: renamed from: b */
    public void m12050b(String str) {
        m12054d(null, str);
    }

    /* JADX INFO: renamed from: d */
    public void m12054d(String str, String str2) {
        if (f13235x > 5) {
            return;
        }
        Log.w(f13234w, m12047d(str) + str2);
    }

    /* JADX INFO: renamed from: c */
    public void m12052c(String str) {
        m12055e(null, str);
    }

    /* JADX INFO: renamed from: e */
    public void m12055e(String str, String str2) {
        if (f13235x > 6) {
            return;
        }
        Log.e(f13234w, m12047d(str) + str2);
    }

    /* JADX INFO: renamed from: d */
    private String m12047d(String str) {
        String str2 = "";
        if (this.f13236y != null && !"".equals(this.f13236y)) {
            str2 = "" + this.f13236y + ":";
        }
        if (str == null || "".equals(str)) {
            return str2;
        }
        return str2 + str + ":";
    }
}
