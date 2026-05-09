package p000;

import org.json.JSONObject;

/* JADX INFO: renamed from: uj */
/* JADX INFO: compiled from: PLMicrophoneSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2161uj {

    /* JADX INFO: renamed from: a */
    private int f12904a = 1;

    /* JADX INFO: renamed from: b */
    private int f12905b = 44100;

    /* JADX INFO: renamed from: c */
    private int f12906c = 16;

    /* JADX INFO: renamed from: d */
    private int f12907d = 2;

    /* JADX INFO: renamed from: e */
    private boolean f12908e = false;

    /* JADX INFO: renamed from: f */
    private boolean f12909f = true;

    /* JADX INFO: renamed from: a */
    public C2161uj m11777a(int i) {
        this.f12904a = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C2161uj m11780b(int i) {
        this.f12905b = i;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C2161uj m11783c(int i) {
        this.f12906c = i;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C2161uj m11785d(int i) {
        this.f12907d = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2161uj m11778a(boolean z) {
        this.f12909f = z;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C2161uj m11781b(boolean z) {
        this.f12908e = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public int m11776a() {
        return this.f12904a;
    }

    /* JADX INFO: renamed from: b */
    public int m11779b() {
        return this.f12905b;
    }

    /* JADX INFO: renamed from: c */
    public int m11782c() {
        return this.f12906c;
    }

    /* JADX INFO: renamed from: d */
    public int m11784d() {
        return this.f12907d;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11786e() {
        return this.f12909f;
    }

    /* JADX INFO: renamed from: a */
    public static C2161uj m11775a(JSONObject jSONObject) {
        C2161uj c2161uj = new C2161uj();
        c2161uj.m11777a(jSONObject.optInt("audioSource", 1));
        c2161uj.m11780b(jSONObject.optInt("sampleRate", 44100));
        c2161uj.m11783c(jSONObject.optInt("channelConfig", 16));
        c2161uj.m11785d(jSONObject.optInt("audioFormat", 2));
        c2161uj.m11781b(jSONObject.optBoolean("bluetoothSCOEnabled", false));
        c2161uj.m11778a(jSONObject.optBoolean("audioPtsOptimizeEnabled", true));
        return c2161uj;
    }
}
