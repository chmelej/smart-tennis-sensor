package p000;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: rp */
/* JADX INFO: compiled from: LinkedBlockingDeque.java */
/* JADX INFO: loaded from: classes.dex */
public class C2086rp<E> extends AbstractQueue<E> implements Serializable, InterfaceBlockingQueueC2083rm<E> {

    /* JADX INFO: renamed from: a */
    transient c<E> f12585a;

    /* JADX INFO: renamed from: b */
    transient c<E> f12586b;

    /* JADX INFO: renamed from: c */
    final ReentrantLock f12587c;

    /* JADX INFO: renamed from: d */
    private transient int f12588d;

    /* JADX INFO: renamed from: e */
    private final int f12589e;

    /* JADX INFO: renamed from: f */
    private final Condition f12590f;

    /* JADX INFO: renamed from: g */
    private final Condition f12591g;

    /* JADX INFO: renamed from: rp$c */
    /* JADX INFO: compiled from: LinkedBlockingDeque.java */
    static final class c<E> {

        /* JADX INFO: renamed from: a */
        E f12597a;

        /* JADX INFO: renamed from: b */
        c<E> f12598b;

        /* JADX INFO: renamed from: c */
        c<E> f12599c;

        c(E e) {
            this.f12597a = e;
        }
    }

    public C2086rp() {
        this(Integer.MAX_VALUE);
    }

    public C2086rp(int i) {
        this.f12587c = new ReentrantLock();
        this.f12590f = this.f12587c.newCondition();
        this.f12591g = this.f12587c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.f12589e = i;
    }

    /* JADX INFO: renamed from: b */
    private boolean m11438b(c<E> cVar) {
        if (this.f12588d >= this.f12589e) {
            return false;
        }
        c<E> cVar2 = this.f12585a;
        cVar.f12599c = cVar2;
        this.f12585a = cVar;
        if (this.f12586b == null) {
            this.f12586b = cVar;
        } else {
            cVar2.f12598b = cVar;
        }
        this.f12588d++;
        this.f12590f.signal();
        return true;
    }

    /* JADX INFO: renamed from: c */
    private boolean m11439c(c<E> cVar) {
        if (this.f12588d >= this.f12589e) {
            return false;
        }
        c<E> cVar2 = this.f12586b;
        cVar.f12598b = cVar2;
        this.f12586b = cVar;
        if (this.f12585a == null) {
            this.f12585a = cVar;
        } else {
            cVar2.f12599c = cVar;
        }
        this.f12588d++;
        this.f12590f.signal();
        return true;
    }

    /* JADX INFO: renamed from: f */
    private E m11440f() {
        c<E> cVar = this.f12585a;
        if (cVar == null) {
            return null;
        }
        c<E> cVar2 = cVar.f12599c;
        E e = cVar.f12597a;
        cVar.f12597a = null;
        cVar.f12599c = cVar;
        this.f12585a = cVar2;
        if (cVar2 == null) {
            this.f12586b = null;
        } else {
            cVar2.f12598b = null;
        }
        this.f12588d--;
        this.f12591g.signal();
        return e;
    }

    /* JADX INFO: renamed from: g */
    private E m11441g() {
        c<E> cVar = this.f12586b;
        if (cVar == null) {
            return null;
        }
        c<E> cVar2 = cVar.f12598b;
        E e = cVar.f12597a;
        cVar.f12597a = null;
        cVar.f12598b = cVar;
        this.f12586b = cVar2;
        if (cVar2 == null) {
            this.f12585a = null;
        } else {
            cVar2.f12599c = null;
        }
        this.f12588d--;
        this.f12591g.signal();
        return e;
    }

    /* JADX INFO: renamed from: a */
    void m11445a(c<E> cVar) {
        c<E> cVar2 = cVar.f12598b;
        c<E> cVar3 = cVar.f12599c;
        if (cVar2 == null) {
            m11440f();
            return;
        }
        if (cVar3 == null) {
            m11441g();
            return;
        }
        cVar2.f12599c = cVar3;
        cVar3.f12598b = cVar2;
        cVar.f12597a = null;
        this.f12588d--;
        this.f12591g.signal();
    }

    /* JADX INFO: renamed from: a */
    public void m11444a(E e) {
        if (!m11450c(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m11448b(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return m11438b((c) cVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m11450c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return m11439c((c) cVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m11452d(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        while (!m11439c((c) cVar)) {
            try {
                this.f12591g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m11446a(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (m11439c((c) cVar)) {
                    z = true;
                    break;
                }
                if (nanos <= 0) {
                    z = false;
                    break;
                }
                nanos = this.f12591g.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public E m11442a() {
        E eM11447b = m11447b();
        if (eM11447b == null) {
            throw new NoSuchElementException();
        }
        return eM11447b;
    }

    /* JADX INFO: renamed from: b */
    public E m11447b() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return m11440f();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: c */
    public E m11449c() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        while (true) {
            try {
                E eM11440f = m11440f();
                if (eM11440f != null) {
                    return eM11440f;
                }
                this.f12590f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public E m11443a(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eM11440f = m11440f();
                if (eM11440f != null) {
                    return eM11440f;
                }
                if (nanos > 0) {
                    nanos = this.f12590f.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public E m11451d() {
        E eM11453e = m11453e();
        if (eM11453e == null) {
            throw new NoSuchElementException();
        }
        return eM11453e;
    }

    /* JADX INFO: renamed from: e */
    public E m11453e() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return this.f12585a == null ? null : this.f12585a.f12597a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m11454e(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            for (c<E> cVar = this.f12585a; cVar != null; cVar = cVar.f12599c) {
                if (obj.equals(cVar.f12597a)) {
                    m11445a((c) cVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        m11444a(e);
        return true;
    }

    public boolean offer(E e) {
        return m11450c(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        m11452d(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return m11446a(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return m11442a();
    }

    @Override // java.util.Queue
    public E poll() {
        return m11447b();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        return m11449c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return m11443a(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return m11451d();
    }

    @Override // java.util.Queue
    public E peek() {
        return m11453e();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return this.f12589e - this.f12588d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            int iMin = Math.min(i, this.f12588d);
            for (int i2 = 0; i2 < iMin; i2++) {
                collection.add(this.f12585a.f12597a);
                m11440f();
            }
            return iMin;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return m11454e(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            return this.f12588d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            for (c<E> cVar = this.f12585a; cVar != null; cVar = cVar.f12599c) {
                if (obj.equals(cVar.f12597a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f12588d];
            int i = 0;
            c<E> cVar = this.f12585a;
            while (cVar != null) {
                int i2 = i + 1;
                objArr[i] = cVar.f12597a;
                cVar = cVar.f12599c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f12588d) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f12588d));
            }
            int i = 0;
            c<E> cVar = this.f12585a;
            while (cVar != null) {
                tArr[i] = cVar.f12597a;
                cVar = cVar.f12599c;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            c<E> cVar = this.f12585a;
            if (cVar == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = cVar.f12597a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                cVar = cVar.f12599c;
                if (cVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.f12587c;
        reentrantLock.lock();
        try {
            c<E> cVar = this.f12585a;
            while (cVar != null) {
                cVar.f12597a = null;
                c<E> cVar2 = cVar.f12599c;
                cVar.f12598b = null;
                cVar.f12599c = null;
                cVar = cVar2;
            }
            this.f12586b = null;
            this.f12585a = null;
            this.f12588d = 0;
            this.f12591g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }

    /* JADX INFO: renamed from: rp$a */
    /* JADX INFO: compiled from: LinkedBlockingDeque.java */
    abstract class a implements Iterator<E> {

        /* JADX INFO: renamed from: a */
        c<E> f12592a;

        /* JADX INFO: renamed from: b */
        E f12593b;

        /* JADX INFO: renamed from: d */
        private c<E> f12595d;

        /* JADX INFO: renamed from: a */
        abstract c<E> mo11456a();

        /* JADX INFO: renamed from: a */
        abstract c<E> mo11457a(c<E> cVar);

        a() {
            ReentrantLock reentrantLock = C2086rp.this.f12587c;
            reentrantLock.lock();
            try {
                this.f12592a = mo11456a();
                this.f12593b = this.f12592a == null ? null : this.f12592a.f12597a;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX INFO: renamed from: b */
        private c<E> m11455b(c<E> cVar) {
            while (true) {
                c<E> cVarMo11457a = mo11457a(cVar);
                if (cVarMo11457a == null) {
                    return null;
                }
                if (cVarMo11457a.f12597a != null) {
                    return cVarMo11457a;
                }
                if (cVarMo11457a == cVar) {
                    return mo11456a();
                }
                cVar = cVarMo11457a;
            }
        }

        /* JADX INFO: renamed from: b */
        void m11458b() {
            ReentrantLock reentrantLock = C2086rp.this.f12587c;
            reentrantLock.lock();
            try {
                this.f12592a = m11455b(this.f12592a);
                this.f12593b = this.f12592a == null ? null : this.f12592a.f12597a;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12592a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f12592a == null) {
                throw new NoSuchElementException();
            }
            this.f12595d = this.f12592a;
            E e = this.f12593b;
            m11458b();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            c<E> cVar = this.f12595d;
            if (cVar == null) {
                throw new IllegalStateException();
            }
            this.f12595d = null;
            ReentrantLock reentrantLock = C2086rp.this.f12587c;
            reentrantLock.lock();
            try {
                if (cVar.f12597a != null) {
                    C2086rp.this.m11445a((c) cVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: rp$b */
    /* JADX INFO: compiled from: LinkedBlockingDeque.java */
    class b extends a {
        private b() {
            super();
        }

        @Override // p000.C2086rp.a
        /* JADX INFO: renamed from: a */
        c<E> mo11456a() {
            return C2086rp.this.f12585a;
        }

        @Override // p000.C2086rp.a
        /* JADX INFO: renamed from: a */
        c<E> mo11457a(c<E> cVar) {
            return cVar.f12599c;
        }
    }
}
