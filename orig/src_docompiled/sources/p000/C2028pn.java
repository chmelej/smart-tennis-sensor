package p000;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: pn */
/* JADX INFO: compiled from: LazyList.java */
/* JADX INFO: loaded from: classes.dex */
public class C2028pn<E> extends AbstractList<E> {

    /* JADX INFO: renamed from: c */
    private static final AbstractC2029po f12189c = AbstractC2029po.m11097a(C2028pn.class);

    /* JADX INFO: renamed from: a */
    List<E> f12190a;

    /* JADX INFO: renamed from: b */
    Iterator<E> f12191b;

    public C2028pn(List<E> list, Iterator<E> it) {
        this.f12190a = list;
        this.f12191b = it;
    }

    /* JADX INFO: renamed from: a */
    private void m11096a() {
        f12189c.mo11091a("blowup running");
        while (this.f12191b.hasNext()) {
            this.f12190a.add(this.f12191b.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.f12190a.size() > i) {
            return this.f12190a.get(i);
        }
        if (this.f12191b.hasNext()) {
            this.f12190a.add(this.f12191b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: pn.1

            /* JADX INFO: renamed from: a */
            int f12192a = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12192a < C2028pn.this.f12190a.size() || C2028pn.this.f12191b.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f12192a < C2028pn.this.f12190a.size()) {
                    List<E> list = C2028pn.this.f12190a;
                    int i = this.f12192a;
                    this.f12192a = i + 1;
                    return list.get(i);
                }
                C2028pn.this.f12190a.add(C2028pn.this.f12191b.next());
                return (E) next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        f12189c.mo11091a("potentially expensive size() call");
        m11096a();
        return this.f12190a.size();
    }
}
