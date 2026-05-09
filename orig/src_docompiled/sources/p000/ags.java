package p000;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMCCSystemBufferManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ags implements Serializable {

    /* JADX INFO: renamed from: a */
    private Map<String, ago> f860a = new HashMap();

    /* JADX INFO: renamed from: a */
    public Map<String, ago> m970a() {
        return this.f860a;
    }

    /* JADX INFO: renamed from: b */
    public void m971b() {
        this.f860a.clear();
    }
}
