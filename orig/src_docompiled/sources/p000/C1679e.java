package p000;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: e */
/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class C1679e<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a */
    private c<K, V> f9438a;

    /* JADX INFO: renamed from: b */
    private c<K, V> f9439b;

    /* JADX INFO: renamed from: c */
    private WeakHashMap<f<K, V>, Boolean> f9440c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d */
    private int f9441d = 0;

    /* JADX INFO: renamed from: e$f */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    interface f<K, V> {
        /* JADX INFO: renamed from: a_ */
        void mo8930a_(c<K, V> cVar);
    }

    /* JADX INFO: renamed from: a */
    protected c<K, V> mo8830a(K k) {
        c<K, V> cVar = this.f9438a;
        while (cVar != null && !cVar.f9442a.equals(k)) {
            cVar = cVar.f9444c;
        }
        return cVar;
    }

    /* JADX INFO: renamed from: a */
    public V mo8831a(K k, V v) {
        c<K, V> cVarMo8830a = mo8830a(k);
        if (cVarMo8830a != null) {
            return cVarMo8830a.f9443b;
        }
        m8922b(k, v);
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected c<K, V> m8922b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f9441d++;
        if (this.f9439b == null) {
            this.f9438a = cVar;
            this.f9439b = this.f9438a;
            return cVar;
        }
        this.f9439b.f9444c = cVar;
        cVar.f9445d = this.f9439b;
        this.f9439b = cVar;
        return cVar;
    }

    /* JADX INFO: renamed from: b */
    public V mo8832b(K k) {
        c<K, V> cVarMo8830a = mo8830a(k);
        if (cVarMo8830a == null) {
            return null;
        }
        this.f9441d--;
        if (!this.f9440c.isEmpty()) {
            Iterator<f<K, V>> it = this.f9440c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo8930a_(cVarMo8830a);
            }
        }
        if (cVarMo8830a.f9445d != null) {
            cVarMo8830a.f9445d.f9444c = cVarMo8830a.f9444c;
        } else {
            this.f9438a = cVarMo8830a.f9444c;
        }
        if (cVarMo8830a.f9444c != null) {
            cVarMo8830a.f9444c.f9445d = cVarMo8830a.f9445d;
        } else {
            this.f9439b = cVarMo8830a.f9445d;
        }
        cVarMo8830a.f9444c = null;
        cVarMo8830a.f9445d = null;
        return cVarMo8830a.f9443b;
    }

    /* JADX INFO: renamed from: a */
    public int m8921a() {
        return this.f9441d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f9438a, this.f9439b);
        this.f9440c.put(aVar, false);
        return aVar;
    }

    /* JADX INFO: renamed from: b */
    public Iterator<Map.Entry<K, V>> m8923b() {
        b bVar = new b(this.f9439b, this.f9438a);
        this.f9440c.put(bVar, false);
        return bVar;
    }

    /* JADX INFO: renamed from: c */
    public C1679e<K, V>.d m8924c() {
        C1679e<K, V>.d dVar = new d();
        this.f9440c.put(dVar, false);
        return dVar;
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m8925d() {
        return this.f9438a;
    }

    /* JADX INFO: renamed from: e */
    public Map.Entry<K, V> m8926e() {
        return this.f9439b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1679e)) {
            return false;
        }
        C1679e c1679e = (C1679e) obj;
        if (m8921a() != c1679e.m8921a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c1679e.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: e$e */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a */
        c<K, V> f9449a;

        /* JADX INFO: renamed from: b */
        c<K, V> f9450b;

        /* JADX INFO: renamed from: a */
        abstract c<K, V> mo8927a(c<K, V> cVar);

        /* JADX INFO: renamed from: b */
        abstract c<K, V> mo8928b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f9449a = cVar2;
            this.f9450b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9450b != null;
        }

        @Override // p000.C1679e.f
        /* JADX INFO: renamed from: a_ */
        public void mo8930a_(c<K, V> cVar) {
            if (this.f9449a == cVar && cVar == this.f9450b) {
                this.f9450b = null;
                this.f9449a = null;
            }
            if (this.f9449a == cVar) {
                this.f9449a = mo8928b(this.f9449a);
            }
            if (this.f9450b == cVar) {
                this.f9450b = m8931b();
            }
        }

        /* JADX INFO: renamed from: b */
        private c<K, V> m8931b() {
            if (this.f9450b == this.f9449a || this.f9449a == null) {
                return null;
            }
            return mo8927a(this.f9450b);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f9450b;
            this.f9450b = m8931b();
            return cVar;
        }
    }

    /* JADX INFO: renamed from: e$a */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p000.C1679e.e
        /* JADX INFO: renamed from: a */
        c<K, V> mo8927a(c<K, V> cVar) {
            return cVar.f9444c;
        }

        @Override // p000.C1679e.e
        /* JADX INFO: renamed from: b */
        c<K, V> mo8928b(c<K, V> cVar) {
            return cVar.f9445d;
        }
    }

    /* JADX INFO: renamed from: e$b */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p000.C1679e.e
        /* JADX INFO: renamed from: a */
        c<K, V> mo8927a(c<K, V> cVar) {
            return cVar.f9445d;
        }

        @Override // p000.C1679e.e
        /* JADX INFO: renamed from: b */
        c<K, V> mo8928b(c<K, V> cVar) {
            return cVar.f9444c;
        }
    }

    /* JADX INFO: renamed from: e$d */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b */
        private c<K, V> f9447b;

        /* JADX INFO: renamed from: c */
        private boolean f9448c;

        private d() {
            this.f9448c = true;
        }

        @Override // p000.C1679e.f
        /* JADX INFO: renamed from: a_ */
        public void mo8930a_(c<K, V> cVar) {
            if (cVar == this.f9447b) {
                this.f9447b = this.f9447b.f9445d;
                this.f9448c = this.f9447b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9448c ? C1679e.this.f9438a != null : (this.f9447b == null || this.f9447b.f9444c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f9448c) {
                this.f9448c = false;
                this.f9447b = C1679e.this.f9438a;
            } else {
                this.f9447b = this.f9447b != null ? this.f9447b.f9444c : null;
            }
            return this.f9447b;
        }
    }

    /* JADX INFO: renamed from: e$c */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        final K f9442a;

        /* JADX INFO: renamed from: b */
        final V f9443b;

        /* JADX INFO: renamed from: c */
        c<K, V> f9444c;

        /* JADX INFO: renamed from: d */
        c<K, V> f9445d;

        c(K k, V v) {
            this.f9442a = k;
            this.f9443b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9442a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9443b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f9442a + "=" + this.f9443b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f9442a.equals(cVar.f9442a) && this.f9443b.equals(cVar.f9443b);
        }
    }
}
