package p000;

import org.json.JSONObject;

/* JADX INFO: renamed from: tz */
/* JADX INFO: compiled from: PLAudioEncodeSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2150tz {

    /* JADX INFO: renamed from: a */
    private int f12868a = 44100;

    /* JADX INFO: renamed from: b */
    private int f12869b = 1;

    /* JADX INFO: renamed from: c */
    private int f12870c = 44100;

    /* JADX INFO: renamed from: d */
    private boolean f12871d = true;

    /* JADX INFO: renamed from: a */
    public C2150tz m11742a(boolean z) {
        C2201vw.f13219h.m12053c("PLAudioEncodeSetting", "setIFrameInterval: " + z);
        this.f12871d = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2150tz m11741a(int i) {
        C2201vw.f13219h.m12053c("PLAudioEncodeSetting", "setSampleRate: " + i);
        this.f12868a = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C2150tz m11745b(int i) {
        C2201vw.f13219h.m12053c("PLAudioEncodeSetting", "setChannels: " + i);
        this.f12869b = i;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C2150tz m11747c(int i) {
        C2201vw.f13219h.m12053c("PLAudioEncodeSetting", "setBitrate: " + i);
        this.f12870c = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11743a() {
        return this.f12871d;
    }

    /* JADX INFO: renamed from: b */
    public int m11744b() {
        return this.f12868a;
    }

    /* JADX INFO: renamed from: c */
    public int m11746c() {
        return this.f12869b;
    }

    /* JADX INFO: renamed from: d */
    public int m11748d() {
        return this.f12870c;
    }

    /* JADX INFO: renamed from: a */
    public static C2150tz m11740a(JSONObject jSONObject) {
        C2150tz c2150tz = new C2150tz();
        c2150tz.m11741a(jSONObject.optInt("sampleRate", 44100));
        c2150tz.m11745b(jSONObject.optInt("channels", 1));
        c2150tz.m11747c(jSONObject.optInt("bitrate", 44100));
        c2150tz.m11742a(jSONObject.optBoolean("isHWCodecEnabled", true));
        return c2150tz;
    }
}
