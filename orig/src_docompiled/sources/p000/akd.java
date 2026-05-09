package p000;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes.dex */
public class akd {

    /* JADX INFO: renamed from: a */
    public static String f1430a = "Event";

    /* JADX INFO: renamed from: b */
    static volatile akd f1431b;

    /* JADX INFO: renamed from: c */
    private static final ake f1432c = new ake();

    /* JADX INFO: renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f1433d = new HashMap();

    /* JADX INFO: renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<akn>> f1434e;

    /* JADX INFO: renamed from: f */
    private final Map<Object, List<Class<?>>> f1435f;

    /* JADX INFO: renamed from: g */
    private final Map<Class<?>, Object> f1436g;

    /* JADX INFO: renamed from: h */
    private final ThreadLocal<C0179a> f1437h;

    /* JADX INFO: renamed from: i */
    private final akg f1438i;

    /* JADX INFO: renamed from: j */
    private final akc f1439j;

    /* JADX INFO: renamed from: k */
    private final akb f1440k;

    /* JADX INFO: renamed from: l */
    private final akm f1441l;

    /* JADX INFO: renamed from: m */
    private final ExecutorService f1442m;

    /* JADX INFO: renamed from: n */
    private final boolean f1443n;

    /* JADX INFO: renamed from: o */
    private final boolean f1444o;

    /* JADX INFO: renamed from: p */
    private final boolean f1445p;

    /* JADX INFO: renamed from: q */
    private final boolean f1446q;

    /* JADX INFO: renamed from: r */
    private final boolean f1447r;

    /* JADX INFO: renamed from: s */
    private final boolean f1448s;

    /* JADX INFO: renamed from: a */
    public static akd m1706a() {
        if (f1431b == null) {
            synchronized (akd.class) {
                if (f1431b == null) {
                    f1431b = new akd();
                }
            }
        }
        return f1431b;
    }

    public akd() {
        this(f1432c);
    }

    akd(ake akeVar) {
        this.f1437h = new ThreadLocal<C0179a>() { // from class: akd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0179a initialValue() {
                return new C0179a();
            }
        };
        this.f1434e = new HashMap();
        this.f1435f = new HashMap();
        this.f1436g = new ConcurrentHashMap();
        this.f1438i = new akg(this, Looper.getMainLooper(), 10);
        this.f1439j = new akc(this);
        this.f1440k = new akb(this);
        this.f1441l = new akm(akeVar.f1465h);
        this.f1444o = akeVar.f1458a;
        this.f1445p = akeVar.f1459b;
        this.f1446q = akeVar.f1460c;
        this.f1447r = akeVar.f1461d;
        this.f1443n = akeVar.f1462e;
        this.f1448s = akeVar.f1463f;
        this.f1442m = akeVar.f1464g;
    }

    /* JADX INFO: renamed from: a */
    public void m1719a(Object obj) {
        m1713a(obj, false, 0);
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m1713a(Object obj, boolean z, int i) {
        Iterator<akl> it = this.f1441l.m1733a(obj.getClass()).iterator();
        while (it.hasNext()) {
            m1711a(obj, it.next(), z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1711a(Object obj, akl aklVar, boolean z, int i) {
        Class<?> cls = aklVar.f1484c;
        CopyOnWriteArrayList<akn> copyOnWriteArrayList = this.f1434e.get(cls);
        akn aknVar = new akn(obj, aklVar, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f1434e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aknVar)) {
            throw new akf("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || aknVar.f1490c > copyOnWriteArrayList.get(i2).f1490c) {
                copyOnWriteArrayList.add(i2, aknVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f1435f.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f1435f.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (z) {
            if (this.f1448s) {
                for (Map.Entry<Class<?>, Object> entry : this.f1436g.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        m1716b(aknVar, entry.getValue());
                    }
                }
                return;
            }
            m1716b(aknVar, this.f1436g.get(cls));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1716b(akn aknVar, Object obj) {
        if (obj != null) {
            m1709a(aknVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1712a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<akn> copyOnWriteArrayList = this.f1434e.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                akn aknVar = copyOnWriteArrayList.get(i);
                if (aknVar.f1488a == obj) {
                    aknVar.f1491d = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m1721b(Object obj) {
        List<Class<?>> list = this.f1435f.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m1712a(obj, it.next());
            }
            this.f1435f.remove(obj);
        } else {
            Log.w(f1430a, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1722c(Object obj) {
        C0179a c0179a = this.f1437h.get();
        List<Object> list = c0179a.f1451a;
        list.add(obj);
        if (c0179a.f1452b) {
            return;
        }
        c0179a.f1453c = Looper.getMainLooper() == Looper.myLooper();
        c0179a.f1452b = true;
        if (c0179a.f1456f) {
            throw new akf("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                m1710a(list.remove(0), c0179a);
            } finally {
                c0179a.f1452b = false;
                c0179a.f1453c = false;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1710a(Object obj, C0179a c0179a) {
        boolean zM1715a;
        Class<?> cls = obj.getClass();
        if (this.f1448s) {
            List<Class<?>> listM1707a = m1707a(cls);
            int size = listM1707a.size();
            zM1715a = false;
            for (int i = 0; i < size; i++) {
                zM1715a |= m1715a(obj, c0179a, listM1707a.get(i));
            }
        } else {
            zM1715a = m1715a(obj, c0179a, cls);
        }
        if (zM1715a) {
            return;
        }
        if (this.f1445p) {
            Log.d(f1430a, "No subscribers registered for event " + cls);
        }
        if (!this.f1447r || cls == akh.class || cls == akk.class) {
            return;
        }
        m1722c(new akh(this, obj));
    }

    /* JADX INFO: renamed from: a */
    private boolean m1715a(Object obj, C0179a c0179a, Class<?> cls) {
        CopyOnWriteArrayList<akn> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f1434e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (akn aknVar : copyOnWriteArrayList) {
            c0179a.f1455e = obj;
            c0179a.f1454d = aknVar;
            try {
                m1709a(aknVar, obj, c0179a.f1453c);
                if (c0179a.f1456f) {
                    return true;
                }
            } finally {
                c0179a.f1455e = null;
                c0179a.f1454d = null;
                c0179a.f1456f = false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m1709a(akn aknVar, Object obj, boolean z) {
        switch (aknVar.f1489b.f1483b) {
            case PostThread:
                m1718a(aknVar, obj);
                return;
            case MainThread:
                if (z) {
                    m1718a(aknVar, obj);
                    return;
                } else {
                    this.f1438i.m1724a(aknVar, obj);
                    return;
                }
            case BackgroundThread:
                if (z) {
                    this.f1439j.m1705a(aknVar, obj);
                    return;
                } else {
                    m1718a(aknVar, obj);
                    return;
                }
            case Async:
                this.f1440k.m1704a(aknVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + aknVar.f1489b.f1483b);
        }
    }

    /* JADX INFO: renamed from: a */
    private List<Class<?>> m1707a(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (f1433d) {
            arrayList = f1433d.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    m1714a(arrayList, superclass.getInterfaces());
                }
                f1433d.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    static void m1714a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m1714a(list, cls.getInterfaces());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1717a(aki akiVar) {
        Object obj = akiVar.f1473a;
        akn aknVar = akiVar.f1474b;
        aki.m1726a(akiVar);
        if (aknVar.f1491d) {
            m1718a(aknVar, obj);
        }
    }

    /* JADX INFO: renamed from: a */
    void m1718a(akn aknVar, Object obj) {
        try {
            aknVar.f1489b.f1482a.invoke(aknVar.f1488a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            m1708a(aknVar, obj, e2.getCause());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1708a(akn aknVar, Object obj, Throwable th) {
        if (obj instanceof akk) {
            if (this.f1444o) {
                Log.e(f1430a, "SubscriberExceptionEvent subscriber " + aknVar.f1488a.getClass() + " threw an exception", th);
                akk akkVar = (akk) obj;
                Log.e(f1430a, "Initial event " + akkVar.f1480c + " caused exception in " + akkVar.f1481d, akkVar.f1479b);
                return;
            }
            return;
        }
        if (this.f1443n) {
            throw new akf("Invoking subscriber failed", th);
        }
        if (this.f1444o) {
            Log.e(f1430a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + aknVar.f1488a.getClass(), th);
        }
        if (this.f1446q) {
            m1722c(new akk(this, th, obj, aknVar.f1488a));
        }
    }

    /* JADX INFO: renamed from: akd$a */
    /* JADX INFO: compiled from: EventBus.java */
    static final class C0179a {

        /* JADX INFO: renamed from: a */
        final List<Object> f1451a = new ArrayList();

        /* JADX INFO: renamed from: b */
        boolean f1452b;

        /* JADX INFO: renamed from: c */
        boolean f1453c;

        /* JADX INFO: renamed from: d */
        akn f1454d;

        /* JADX INFO: renamed from: e */
        Object f1455e;

        /* JADX INFO: renamed from: f */
        boolean f1456f;

        C0179a() {
        }
    }

    /* JADX INFO: renamed from: b */
    ExecutorService m1720b() {
        return this.f1442m;
    }
}
