package p000;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: UMCCAggregatedListObject.java */
/* JADX INFO: loaded from: classes.dex */
public class agm implements Serializable {

    /* JADX INFO: renamed from: a */
    private Map<List<String>, agn> f823a = new HashMap();

    /* JADX INFO: renamed from: b */
    private long f824b = 0;

    /* JADX INFO: renamed from: a */
    public Map<List<String>, agn> m925a() {
        return this.f823a;
    }

    /* JADX INFO: renamed from: b */
    public void m926b() {
        this.f823a.clear();
    }
}
