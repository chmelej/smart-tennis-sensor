package p000;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: renamed from: uk */
/* JADX INFO: compiled from: PLRecordSetting.java */
/* JADX INFO: loaded from: classes.dex */
public class C2162uk {

    /* JADX INFO: renamed from: b */
    private File f12911b;

    /* JADX INFO: renamed from: c */
    private String f12912c;

    /* JADX INFO: renamed from: a */
    private long f12910a = 10000;

    /* JADX INFO: renamed from: d */
    private EnumC2157uf f12913d = EnumC2157uf.FULL;

    /* JADX INFO: renamed from: a */
    public C2162uk m11789a(long j) {
        this.f12910a = j;
        C2201vw.f13215d.m12053c("PLRecordSetting", "setMaxRecordDuration: " + j + " ms");
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2162uk m11790a(File file) {
        this.f12911b = file;
        C2201vw.f13215d.m12053c("PLRecordSetting", "setVideoCacheDir: " + file);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2162uk m11791a(String str) {
        return m11790a(new File(str));
    }

    /* JADX INFO: renamed from: b */
    public C2162uk m11794b(String str) {
        this.f12912c = str;
        C2201vw.f13215d.m12053c("PLRecordSetting", "setVideoFilepath: " + str);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2162uk m11792a(EnumC2157uf enumC2157uf) {
        this.f12913d = enumC2157uf;
        C2201vw.f13216e.m12053c("PLRecordSetting", "setDisplayMode: " + enumC2157uf);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public long m11788a() {
        return this.f12910a;
    }

    /* JADX INFO: renamed from: b */
    public File m11793b() {
        return this.f12911b;
    }

    /* JADX INFO: renamed from: c */
    public String m11795c() {
        return this.f12912c;
    }

    /* JADX INFO: renamed from: d */
    public EnumC2157uf m11796d() {
        return this.f12913d;
    }

    /* JADX INFO: renamed from: a */
    public static C2162uk m11787a(JSONObject jSONObject) {
        C2162uk c2162uk = new C2162uk();
        c2162uk.m11789a(jSONObject.optInt("maxRecordDuration", 10000));
        c2162uk.m11791a(jSONObject.optString("videoCacheDir"));
        c2162uk.m11794b(jSONObject.optString("recordFilePath"));
        c2162uk.m11792a(EnumC2157uf.valueOf(jSONObject.optString("displayMode", EnumC2157uf.FULL.name())));
        return c2162uk;
    }
}
