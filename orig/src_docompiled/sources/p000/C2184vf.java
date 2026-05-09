package p000;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: renamed from: vf */
/* JADX INFO: compiled from: SectionInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class C2184vf {

    /* JADX INFO: renamed from: a */
    public File f13045a;

    /* JADX INFO: renamed from: b */
    public int f13046b;

    /* JADX INFO: renamed from: c */
    public int f13047c;

    /* JADX INFO: renamed from: d */
    public long f13048d;

    /* JADX INFO: renamed from: e */
    public long f13049e;

    /* JADX INFO: renamed from: f */
    public int f13050f;

    /* JADX INFO: renamed from: g */
    public int f13051g;

    public C2184vf() {
    }

    public C2184vf(String str, int i, int i2, long j, long j2, int i3, int i4) {
        this.f13045a = new File(str);
        this.f13046b = i;
        this.f13047c = i2;
        this.f13048d = j;
        this.f13049e = j2;
        this.f13050f = i3;
        this.f13051g = i4;
    }

    /* JADX INFO: renamed from: a */
    public static C2184vf m11925a(JSONObject jSONObject) {
        return new C2184vf(jSONObject.optString("fileName"), jSONObject.optInt("audioIndex"), jSONObject.optInt("videoIndex"), jSONObject.optLong("startTimeMs"), jSONObject.optLong("durationMs"), jSONObject.optInt("audioFrameNum"), jSONObject.optInt("videoFrameNum"));
    }
}
