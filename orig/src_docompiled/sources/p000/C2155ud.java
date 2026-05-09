package p000;

import org.json.JSONObject;

/* JADX INFO: renamed from: ud */
/* JADX INFO: compiled from: PLCameraSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2155ud {

    /* JADX INFO: renamed from: a */
    private static final int[] f12872a = {120, 240, 360, 480, 720, 960, 1080, 1200};

    /* JADX INFO: renamed from: b */
    private a f12873b = a.CAMERA_FACING_BACK;

    /* JADX INFO: renamed from: c */
    private c f12874c = c.RATIO_16_9;

    /* JADX INFO: renamed from: d */
    private b f12875d = b.PREVIEW_SIZE_LEVEL_480P;

    /* JADX INFO: renamed from: ud$a */
    /* JADX INFO: compiled from: PLCameraSetting.java */
    public enum a {
        CAMERA_FACING_BACK,
        CAMERA_FACING_FRONT,
        CAMERA_FACING_3RD
    }

    /* JADX INFO: renamed from: ud$b */
    /* JADX INFO: compiled from: PLCameraSetting.java */
    public enum b {
        PREVIEW_SIZE_LEVEL_120P,
        PREVIEW_SIZE_LEVEL_240P,
        PREVIEW_SIZE_LEVEL_360P,
        PREVIEW_SIZE_LEVEL_480P,
        PREVIEW_SIZE_LEVEL_720P,
        PREVIEW_SIZE_LEVEL_960P,
        PREVIEW_SIZE_LEVEL_1080P,
        PREVIEW_SIZE_LEVEL_1200P
    }

    /* JADX INFO: renamed from: ud$c */
    /* JADX INFO: compiled from: PLCameraSetting.java */
    public enum c {
        RATIO_4_3,
        RATIO_16_9
    }

    /* JADX INFO: renamed from: a */
    public C2155ud m11759a(a aVar) {
        this.f12873b = aVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2155ud m11761a(c cVar) {
        this.f12874c = cVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2155ud m11760a(b bVar) {
        this.f12875d = bVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public a m11758a() {
        return this.f12873b;
    }

    /* JADX INFO: renamed from: b */
    public c m11762b() {
        return this.f12874c;
    }

    /* JADX INFO: renamed from: c */
    public b m11763c() {
        return this.f12875d;
    }

    /* JADX INFO: renamed from: b */
    public static double m11756b(c cVar) {
        switch (cVar) {
            case RATIO_4_3:
                return 1.3333333333333333d;
            case RATIO_16_9:
                return 1.7777777777777777d;
            default:
                throw new IllegalArgumentException("cannot support ratio:" + cVar);
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m11757b(b bVar) {
        return f12872a[bVar.ordinal()];
    }

    /* JADX INFO: renamed from: a */
    public static C2155ud m11755a(JSONObject jSONObject) {
        C2155ud c2155ud = new C2155ud();
        c2155ud.m11759a(a.valueOf(jSONObject.optString("cameraFacingId", a.CAMERA_FACING_BACK.name())));
        c2155ud.m11761a(c.valueOf(jSONObject.optString("cameraPreviewSizeRatio", c.RATIO_16_9.name())));
        c2155ud.m11760a(b.valueOf(jSONObject.optString("cameraPreviewSizeLevel", b.PREVIEW_SIZE_LEVEL_480P.name())));
        return c2155ud;
    }
}
