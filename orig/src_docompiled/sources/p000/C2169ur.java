package p000;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: renamed from: ur */
/* JADX INFO: compiled from: PLVideoEncodeSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2169ur {

    /* JADX INFO: renamed from: j */
    private static final int[][] f12936j = {new int[]{240, 240}, new int[]{320, 240}, new int[]{352, 352}, new int[]{640, 352}, new int[]{360, 360}, new int[]{480, 360}, new int[]{640, 360}, new int[]{480, 480}, new int[]{640, 480}, new int[]{848, 480}, new int[]{544, 544}, new int[]{720, 544}, new int[]{720, 720}, new int[]{960, 720}, new int[]{1280, 720}, new int[]{1088, 1088}, new int[]{1440, 1088}};

    /* JADX INFO: renamed from: a */
    private Context f12937a;

    /* JADX INFO: renamed from: b */
    private int f12938b = 0;

    /* JADX INFO: renamed from: c */
    private int f12939c = 0;

    /* JADX INFO: renamed from: d */
    private int f12940d = 30;

    /* JADX INFO: renamed from: e */
    private int f12941e = 1000000;

    /* JADX INFO: renamed from: f */
    private int f12942f = 30;

    /* JADX INFO: renamed from: g */
    private a f12943g = a.QUALITY_PRIORITY;

    /* JADX INFO: renamed from: h */
    private b f12944h = b.VIDEO_ENCODING_SIZE_LEVEL_480P_1;

    /* JADX INFO: renamed from: i */
    private boolean f12945i = true;

    /* JADX INFO: renamed from: ur$a */
    /* JADX INFO: compiled from: PLVideoEncodeSetting.java */
    public enum a {
        QUALITY_PRIORITY,
        BITRATE_PRIORITY
    }

    /* JADX INFO: renamed from: ur$b */
    /* JADX INFO: compiled from: PLVideoEncodeSetting.java */
    public enum b {
        VIDEO_ENCODING_SIZE_LEVEL_240P_1,
        VIDEO_ENCODING_SIZE_LEVEL_240P_2,
        VIDEO_ENCODING_SIZE_LEVEL_352P_1,
        VIDEO_ENCODING_SIZE_LEVEL_352P_2,
        VIDEO_ENCODING_SIZE_LEVEL_360P_1,
        VIDEO_ENCODING_SIZE_LEVEL_360P_2,
        VIDEO_ENCODING_SIZE_LEVEL_360P_3,
        VIDEO_ENCODING_SIZE_LEVEL_480P_1,
        VIDEO_ENCODING_SIZE_LEVEL_480P_2,
        VIDEO_ENCODING_SIZE_LEVEL_480P_3,
        VIDEO_ENCODING_SIZE_LEVEL_544P_1,
        VIDEO_ENCODING_SIZE_LEVEL_544P_2,
        VIDEO_ENCODING_SIZE_LEVEL_720P_1,
        VIDEO_ENCODING_SIZE_LEVEL_720P_2,
        VIDEO_ENCODING_SIZE_LEVEL_720P_3,
        VIDEO_ENCODING_SIZE_LEVEL_1088P_1,
        VIDEO_ENCODING_SIZE_LEVEL_1088P_2
    }

    public C2169ur(Context context) {
        this.f12937a = context;
    }

    /* JADX INFO: renamed from: a */
    public C2169ur m11824a(int i, int i2) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setPreferredEncodingSize: " + i + "x" + i2);
        this.f12938b = i;
        this.f12939c = i2;
        if (i % 16 != 0 || i2 % 16 != 0) {
            C2201vw.f13219h.m12050b("the encoding size is not multiple of 16 !");
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2169ur m11826a(b bVar) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setEncodingSizeLevel: " + bVar);
        this.f12944h = bVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2169ur m11823a(int i) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setEncodingFps: " + i);
        this.f12940d = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C2169ur m11829b(int i) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setEncodingBitrate: " + i);
        this.f12941e = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2169ur m11825a(a aVar) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setEncodingBitrateMode: " + aVar);
        this.f12943g = aVar;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C2169ur m11831c(int i) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setIFrameInterval: " + i);
        this.f12942f = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2169ur m11827a(boolean z) {
        C2201vw.f13219h.m12053c("PLVideoEncodeSetting", "setIFrameInterval: " + z);
        this.f12945i = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public int m11822a() {
        if (this.f12938b != 0) {
            return this.f12938b;
        }
        if (this.f12937a.getResources().getConfiguration().orientation == 1) {
            return f12936j[this.f12944h.ordinal()][1];
        }
        return f12936j[this.f12944h.ordinal()][0];
    }

    /* JADX INFO: renamed from: b */
    public int m11828b() {
        if (this.f12939c != 0) {
            return this.f12939c;
        }
        if (this.f12937a.getResources().getConfiguration().orientation == 1) {
            return f12936j[this.f12944h.ordinal()][0];
        }
        return f12936j[this.f12944h.ordinal()][1];
    }

    /* JADX INFO: renamed from: c */
    public int m11830c() {
        return this.f12940d;
    }

    /* JADX INFO: renamed from: d */
    public int m11832d() {
        return this.f12941e;
    }

    /* JADX INFO: renamed from: e */
    public a m11833e() {
        return this.f12943g;
    }

    /* JADX INFO: renamed from: f */
    public int m11834f() {
        return this.f12942f;
    }

    /* JADX INFO: renamed from: g */
    public boolean m11835g() {
        return this.f12945i;
    }

    /* JADX INFO: renamed from: a */
    public static C2169ur m11821a(Context context, JSONObject jSONObject) {
        C2169ur c2169ur = new C2169ur(context);
        c2169ur.m11824a(jSONObject.optInt("preferredEncodingWidth", 0), jSONObject.optInt("preferredEncodingHeight", 0));
        c2169ur.m11823a(jSONObject.optInt("encodingFps", 30));
        c2169ur.m11829b(jSONObject.optInt("encodingBitrate", 1000000));
        c2169ur.m11831c(jSONObject.optInt("iFrameInterval", 30));
        c2169ur.m11825a(a.valueOf(jSONObject.optString("bitrateMode", a.QUALITY_PRIORITY.name())));
        c2169ur.m11826a(b.valueOf(jSONObject.optString("encodingSizeLevel", b.VIDEO_ENCODING_SIZE_LEVEL_480P_1.name())));
        c2169ur.m11827a(jSONObject.optBoolean("isHWCodecEnabled", true));
        return c2169ur;
    }
}
