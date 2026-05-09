package p000;

import java.util.LinkedHashMap;

/* JADX INFO: renamed from: zk */
/* JADX INFO: loaded from: classes.dex */
public final class C2297zk<K, V> {

    /* JADX INFO: renamed from: a */
    private final LinkedHashMap<K, V> f13790a;

    /* JADX INFO: renamed from: b */
    private int f13791b;

    /* JADX INFO: renamed from: c */
    private int f13792c;

    /* JADX INFO: renamed from: d */
    private int f13793d;

    /* JADX INFO: renamed from: e */
    private int f13794e;

    /* JADX INFO: renamed from: f */
    private int f13795f;

    /* JADX INFO: renamed from: g */
    private int f13796g;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m12558a(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.f13791b     // Catch: java.lang.Throwable -> L6a
            if (r0 < 0) goto L4b
            java.util.LinkedHashMap<K, V> r0 = r2.f13790a     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L12
            int r0 = r2.f13791b     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L12
            goto L4b
        L12:
            int r0 = r2.f13791b     // Catch: java.lang.Throwable -> L6a
            if (r0 <= r3) goto L49
            java.util.LinkedHashMap<K, V> r0 = r2.f13790a     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L1f
            goto L49
        L1f:
            java.util.LinkedHashMap<K, V> r0 = r2.f13790a     // Catch: java.lang.Throwable -> L6a
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6a
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6a
            r0.getValue()     // Catch: java.lang.Throwable -> L6a
            java.util.LinkedHashMap<K, V> r0 = r2.f13790a     // Catch: java.lang.Throwable -> L6a
            r0.remove(r1)     // Catch: java.lang.Throwable -> L6a
            int r0 = r2.f13791b     // Catch: java.lang.Throwable -> L6a
            int r0 = r0 + (-1)
            r2.f13791b = r0     // Catch: java.lang.Throwable -> L6a
            int r0 = r2.f13794e     // Catch: java.lang.Throwable -> L6a
            int r0 = r0 + 1
            r2.f13794e = r0     // Catch: java.lang.Throwable -> L6a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            goto L0
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            return
        L4b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r0.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.Class r1 = r2.getClass()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6a
            r0.append(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L6a
            throw r3     // Catch: java.lang.Throwable -> L6a
        L6a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2297zk.m12558a(int):void");
    }

    /* JADX INFO: renamed from: a */
    public final V m12559a(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f13793d++;
            this.f13791b++;
            vPut = this.f13790a.put(k, v);
            if (vPut != null) {
                this.f13791b--;
            }
        }
        m12558a(this.f13792c);
        return vPut;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized boolean m12560a(K k) {
        return this.f13790a.containsKey(k);
    }

    /* JADX INFO: renamed from: b */
    public final V m12561b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f13790a.get(k);
            if (v != null) {
                this.f13795f++;
                return v;
            }
            this.f13796g++;
            return null;
        }
    }

    public final synchronized String toString() {
        int i;
        i = this.f13795f + this.f13796g;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f13792c), Integer.valueOf(this.f13795f), Integer.valueOf(this.f13796g), Integer.valueOf(i != 0 ? (this.f13795f * 100) / i : 0));
    }
}
