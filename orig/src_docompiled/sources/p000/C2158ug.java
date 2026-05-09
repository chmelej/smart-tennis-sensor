package p000;

import org.json.JSONObject;

/* JADX INFO: renamed from: ug */
/* JADX INFO: compiled from: PLFaceBeautySetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2158ug {

    /* JADX INFO: renamed from: a */
    private boolean f12896a = true;

    /* JADX INFO: renamed from: b */
    private float f12897b;

    /* JADX INFO: renamed from: c */
    private float f12898c;

    /* JADX INFO: renamed from: d */
    private float f12899d;

    public C2158ug(float f, float f2, float f3) {
        this.f12897b = f;
        this.f12899d = f3;
        this.f12898c = f2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11767a() {
        return this.f12896a;
    }

    /* JADX INFO: renamed from: a */
    public void m11766a(boolean z) {
        this.f12896a = z;
    }

    /* JADX INFO: renamed from: b */
    public float m11768b() {
        return this.f12897b;
    }

    /* JADX INFO: renamed from: c */
    public float m11769c() {
        return this.f12898c;
    }

    /* JADX INFO: renamed from: d */
    public float m11770d() {
        return this.f12899d;
    }

    /* JADX INFO: renamed from: a */
    public static C2158ug m11765a(JSONObject jSONObject) {
        C2158ug c2158ug = new C2158ug((float) jSONObject.optDouble("beautyLevel"), (float) jSONObject.optDouble("whiten"), (float) jSONObject.optDouble("redden"));
        c2158ug.m11766a(jSONObject.optBoolean("enabled", true));
        return c2158ug;
    }
}
