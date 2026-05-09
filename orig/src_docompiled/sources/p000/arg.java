package p000;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes.dex */
public final class arg {

    /* JADX INFO: renamed from: a */
    private volatile boolean f4852a;

    /* JADX INFO: renamed from: b */
    private volatile int f4853b;

    /* JADX INFO: renamed from: c */
    private volatile String f4854c;

    /* JADX INFO: renamed from: d */
    private volatile String f4855d;

    /* JADX INFO: renamed from: e */
    private volatile String f4856e;

    /* JADX INFO: renamed from: f */
    private Map<String, String> f4857f = new HashMap();

    /* JADX INFO: renamed from: a */
    public Map<String, String> m5253a() {
        return this.f4857f;
    }

    /* JADX INFO: renamed from: a */
    public void m5256a(Map<String, String> map) {
        this.f4857f.putAll(map);
    }

    /* JADX INFO: renamed from: b */
    public boolean m5259b() {
        return this.f4852a;
    }

    /* JADX INFO: renamed from: a */
    public void m5257a(boolean z) {
        this.f4852a = z;
    }

    /* JADX INFO: renamed from: c */
    public String m5260c() {
        return this.f4854c;
    }

    /* JADX INFO: renamed from: a */
    public void m5255a(String str) {
        this.f4854c = str;
    }

    /* JADX INFO: renamed from: d */
    public String m5262d() {
        return this.f4855d;
    }

    /* JADX INFO: renamed from: b */
    public void m5258b(String str) {
        this.f4855d = str;
    }

    /* JADX INFO: renamed from: e */
    public String m5263e() {
        return this.f4856e;
    }

    /* JADX INFO: renamed from: c */
    public void m5261c(String str) {
        this.f4856e = str;
    }

    /* JADX INFO: renamed from: f */
    public int m5264f() {
        return this.f4853b;
    }

    /* JADX INFO: renamed from: a */
    public void m5254a(int i) {
        this.f4853b = i;
    }

    public String toString() {
        return "Result [isSuccess=" + this.f4852a + ", httpCode=" + this.f4853b + ", data=" + this.f4854c + ", retDesc=" + this.f4855d + ", retCode=" + this.f4856e + ", headers=" + this.f4857f + "]";
    }
}
