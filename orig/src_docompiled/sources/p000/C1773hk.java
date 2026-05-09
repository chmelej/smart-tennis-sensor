package p000;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;

/* JADX INFO: renamed from: hk */
/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes.dex */
public class C1773hk {

    /* JADX INFO: renamed from: a */
    final ArrayMap<RecyclerView.AbstractC0624v, a> f10197a = new ArrayMap<>();

    /* JADX INFO: renamed from: b */
    final LongSparseArray<RecyclerView.AbstractC0624v> f10198b = new LongSparseArray<>();

    /* JADX INFO: renamed from: hk$b */
    /* JADX INFO: compiled from: ViewInfoStore.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo3831a(RecyclerView.AbstractC0624v abstractC0624v);

        /* JADX INFO: renamed from: a */
        void mo3832a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2);

        /* JADX INFO: renamed from: b */
        void mo3833b(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2);

        /* JADX INFO: renamed from: c */
        void mo3834c(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar, RecyclerView.AbstractC0608f.c cVar2);
    }

    /* JADX INFO: renamed from: a */
    public void m9660a() {
        this.f10197a.clear();
        this.f10198b.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m9662a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar) {
        a aVarM9675a = this.f10197a.get(abstractC0624v);
        if (aVarM9675a == null) {
            aVarM9675a = a.m9675a();
            this.f10197a.put(abstractC0624v, aVarM9675a);
        }
        aVarM9675a.f10201b = cVar;
        aVarM9675a.f10200a |= 4;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9664a(RecyclerView.AbstractC0624v abstractC0624v) {
        a aVar = this.f10197a.get(abstractC0624v);
        return (aVar == null || (aVar.f10200a & 1) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public RecyclerView.AbstractC0608f.c m9665b(RecyclerView.AbstractC0624v abstractC0624v) {
        return m9658a(abstractC0624v, 4);
    }

    /* JADX INFO: renamed from: c */
    public RecyclerView.AbstractC0608f.c m9668c(RecyclerView.AbstractC0624v abstractC0624v) {
        return m9658a(abstractC0624v, 8);
    }

    /* JADX INFO: renamed from: a */
    private RecyclerView.AbstractC0608f.c m9658a(RecyclerView.AbstractC0624v abstractC0624v, int i) {
        a aVarValueAt;
        RecyclerView.AbstractC0608f.c cVar;
        int iIndexOfKey = this.f10197a.indexOfKey(abstractC0624v);
        if (iIndexOfKey < 0 || (aVarValueAt = this.f10197a.valueAt(iIndexOfKey)) == null || (aVarValueAt.f10200a & i) == 0) {
            return null;
        }
        aVarValueAt.f10200a &= i ^ (-1);
        if (i == 4) {
            cVar = aVarValueAt.f10201b;
        } else if (i == 8) {
            cVar = aVarValueAt.f10202c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarValueAt.f10200a & 12) == 0) {
            this.f10197a.removeAt(iIndexOfKey);
            a.m9676a(aVarValueAt);
        }
        return cVar;
    }

    /* JADX INFO: renamed from: a */
    public void m9661a(long j, RecyclerView.AbstractC0624v abstractC0624v) {
        this.f10198b.put(j, abstractC0624v);
    }

    /* JADX INFO: renamed from: b */
    public void m9667b(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar) {
        a aVarM9675a = this.f10197a.get(abstractC0624v);
        if (aVarM9675a == null) {
            aVarM9675a = a.m9675a();
            this.f10197a.put(abstractC0624v, aVarM9675a);
        }
        aVarM9675a.f10200a |= 2;
        aVarM9675a.f10201b = cVar;
    }

    /* JADX INFO: renamed from: d */
    public boolean m9670d(RecyclerView.AbstractC0624v abstractC0624v) {
        a aVar = this.f10197a.get(abstractC0624v);
        return (aVar == null || (aVar.f10200a & 4) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public RecyclerView.AbstractC0624v m9659a(long j) {
        return this.f10198b.get(j);
    }

    /* JADX INFO: renamed from: c */
    public void m9669c(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0608f.c cVar) {
        a aVarM9675a = this.f10197a.get(abstractC0624v);
        if (aVarM9675a == null) {
            aVarM9675a = a.m9675a();
            this.f10197a.put(abstractC0624v, aVarM9675a);
        }
        aVarM9675a.f10202c = cVar;
        aVarM9675a.f10200a |= 8;
    }

    /* JADX INFO: renamed from: e */
    public void m9671e(RecyclerView.AbstractC0624v abstractC0624v) {
        a aVarM9675a = this.f10197a.get(abstractC0624v);
        if (aVarM9675a == null) {
            aVarM9675a = a.m9675a();
            this.f10197a.put(abstractC0624v, aVarM9675a);
        }
        aVarM9675a.f10200a |= 1;
    }

    /* JADX INFO: renamed from: f */
    public void m9672f(RecyclerView.AbstractC0624v abstractC0624v) {
        a aVar = this.f10197a.get(abstractC0624v);
        if (aVar == null) {
            return;
        }
        aVar.f10200a &= -2;
    }

    /* JADX INFO: renamed from: a */
    public void m9663a(b bVar) {
        for (int size = this.f10197a.size() - 1; size >= 0; size--) {
            RecyclerView.AbstractC0624v abstractC0624vKeyAt = this.f10197a.keyAt(size);
            a aVarRemoveAt = this.f10197a.removeAt(size);
            if ((aVarRemoveAt.f10200a & 3) == 3) {
                bVar.mo3831a(abstractC0624vKeyAt);
            } else if ((aVarRemoveAt.f10200a & 1) != 0) {
                if (aVarRemoveAt.f10201b == null) {
                    bVar.mo3831a(abstractC0624vKeyAt);
                } else {
                    bVar.mo3832a(abstractC0624vKeyAt, aVarRemoveAt.f10201b, aVarRemoveAt.f10202c);
                }
            } else if ((aVarRemoveAt.f10200a & 14) == 14) {
                bVar.mo3833b(abstractC0624vKeyAt, aVarRemoveAt.f10201b, aVarRemoveAt.f10202c);
            } else if ((aVarRemoveAt.f10200a & 12) == 12) {
                bVar.mo3834c(abstractC0624vKeyAt, aVarRemoveAt.f10201b, aVarRemoveAt.f10202c);
            } else if ((aVarRemoveAt.f10200a & 4) != 0) {
                bVar.mo3832a(abstractC0624vKeyAt, aVarRemoveAt.f10201b, null);
            } else if ((aVarRemoveAt.f10200a & 8) != 0) {
                bVar.mo3833b(abstractC0624vKeyAt, aVarRemoveAt.f10201b, aVarRemoveAt.f10202c);
            } else {
                int i = aVarRemoveAt.f10200a;
            }
            a.m9676a(aVarRemoveAt);
        }
    }

    /* JADX INFO: renamed from: g */
    public void m9673g(RecyclerView.AbstractC0624v abstractC0624v) {
        int size = this.f10198b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (abstractC0624v == this.f10198b.valueAt(size)) {
                this.f10198b.removeAt(size);
                break;
            }
            size--;
        }
        a aVarRemove = this.f10197a.remove(abstractC0624v);
        if (aVarRemove != null) {
            a.m9676a(aVarRemove);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9666b() {
        a.m9677b();
    }

    /* JADX INFO: renamed from: h */
    public void m9674h(RecyclerView.AbstractC0624v abstractC0624v) {
        m9672f(abstractC0624v);
    }

    /* JADX INFO: renamed from: hk$a */
    /* JADX INFO: compiled from: ViewInfoStore.java */
    static class a {

        /* JADX INFO: renamed from: d */
        static Pools.Pool<a> f10199d = new Pools.SimplePool(20);

        /* JADX INFO: renamed from: a */
        int f10200a;

        /* JADX INFO: renamed from: b */
        RecyclerView.AbstractC0608f.c f10201b;

        /* JADX INFO: renamed from: c */
        RecyclerView.AbstractC0608f.c f10202c;

        private a() {
        }

        /* JADX INFO: renamed from: a */
        static a m9675a() {
            a aVarAcquire = f10199d.acquire();
            return aVarAcquire == null ? new a() : aVarAcquire;
        }

        /* JADX INFO: renamed from: a */
        static void m9676a(a aVar) {
            aVar.f10200a = 0;
            aVar.f10201b = null;
            aVar.f10202c = null;
            f10199d.release(aVar);
        }

        /* JADX INFO: renamed from: b */
        static void m9677b() {
            while (f10199d.acquire() != null) {
            }
        }
    }
}
