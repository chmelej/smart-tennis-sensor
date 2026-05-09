package p000;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: tu */
/* JADX INFO: compiled from: StringMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2145tu {

    /* JADX INFO: renamed from: a */
    private Map<String, Object> f12859a;

    /* JADX INFO: renamed from: tu$a */
    /* JADX INFO: compiled from: StringMap.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11581a(String str, Object obj);
    }

    public C2145tu() {
        this(new HashMap());
    }

    public C2145tu(Map<String, Object> map) {
        this.f12859a = map;
    }

    /* JADX INFO: renamed from: a */
    public C2145tu m11714a(String str, Object obj) {
        this.f12859a.put(str, obj);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2145tu m11715a(Map<String, String> map) {
        this.f12859a.putAll(map);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m11716a(a aVar) {
        for (Map.Entry<String, Object> entry : this.f12859a.entrySet()) {
            aVar.mo11581a(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    public Object m11713a(String str) {
        return this.f12859a.get(str);
    }
}
