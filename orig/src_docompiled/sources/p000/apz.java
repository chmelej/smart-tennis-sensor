package p000;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MtopProxyRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class apz {

    /* JADX INFO: renamed from: a */
    private volatile String f4613a;

    /* JADX INFO: renamed from: b */
    private volatile String f4614b;

    /* JADX INFO: renamed from: c */
    private volatile String f4615c;

    /* JADX INFO: renamed from: d */
    private volatile long f4616d = -1;

    /* JADX INFO: renamed from: e */
    private volatile boolean f4617e = true;

    /* JADX INFO: renamed from: f */
    private Map<String, Object> f4618f;

    /* JADX INFO: renamed from: g */
    private Map<String, String> f4619g;

    public apz() {
        this.f4618f = null;
        this.f4619g = null;
        this.f4618f = new HashMap();
        this.f4619g = new HashMap();
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, String> m4966a() {
        return this.f4619g;
    }

    /* JADX INFO: renamed from: b */
    public final String m4969b() {
        return this.f4613a;
    }

    /* JADX INFO: renamed from: a */
    public final void m4967a(String str) {
        this.f4613a = str;
    }

    /* JADX INFO: renamed from: c */
    public final String m4971c() {
        return this.f4614b;
    }

    /* JADX INFO: renamed from: b */
    public final void m4970b(String str) {
        this.f4614b = str;
    }

    /* JADX INFO: renamed from: d */
    public final String m4972d() {
        return this.f4615c;
    }

    /* JADX INFO: renamed from: e */
    public final Map<String, Object> m4973e() {
        return this.f4618f;
    }

    /* JADX INFO: renamed from: a */
    public final void m4968a(String str, Object obj) {
        this.f4618f.put(str, obj);
    }
}
