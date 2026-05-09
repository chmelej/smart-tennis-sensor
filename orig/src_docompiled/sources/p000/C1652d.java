package p000;

import java.util.HashMap;
import java.util.Map;
import p000.C1679e;

/* JADX INFO: renamed from: d */
/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class C1652d<K, V> extends C1679e<K, V> {

    /* JADX INFO: renamed from: a */
    private HashMap<K, C1679e.c<K, V>> f9359a = new HashMap<>();

    @Override // p000.C1679e
    /* JADX INFO: renamed from: a */
    protected C1679e.c<K, V> mo8830a(K k) {
        return this.f9359a.get(k);
    }

    @Override // p000.C1679e
    /* JADX INFO: renamed from: a */
    public V mo8831a(K k, V v) {
        C1679e.c<K, V> cVarMo8830a = mo8830a(k);
        if (cVarMo8830a != null) {
            return cVarMo8830a.f9443b;
        }
        this.f9359a.put(k, m8922b(k, v));
        return null;
    }

    @Override // p000.C1679e
    /* JADX INFO: renamed from: b */
    public V mo8832b(K k) {
        V v = (V) super.mo8832b(k);
        this.f9359a.remove(k);
        return v;
    }

    /* JADX INFO: renamed from: c */
    public boolean m8833c(K k) {
        return this.f9359a.containsKey(k);
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m8834d(K k) {
        if (m8833c(k)) {
            return this.f9359a.get(k).f9445d;
        }
        return null;
    }
}
