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
public class asd {

    /* JADX INFO: renamed from: a */
    public static String f4913a = "EventBus";

    /* JADX INFO: renamed from: b */
    static volatile asd f4914b;

    /* JADX INFO: renamed from: c */
    private static final ase f4915c = new ase();

    /* JADX INFO: renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f4916d = new HashMap();

    /* JADX INFO: renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<aso>> f4917e;

    /* JADX INFO: renamed from: f */
    private final Map<Object, List<Class<?>>> f4918f;

    /* JADX INFO: renamed from: g */
    private final Map<Class<?>, Object> f4919g;

    /* JADX INFO: renamed from: h */
    private final ThreadLocal<C0747a> f4920h;

    /* JADX INFO: renamed from: i */
    private final asg f4921i;

    /* JADX INFO: renamed from: j */
    private final asc f4922j;

    /* JADX INFO: renamed from: k */
    private final asb f4923k;

    /* JADX INFO: renamed from: l */
    private final asn f4924l;

    /* JADX INFO: renamed from: m */
    private final ExecutorService f4925m;

    /* JADX INFO: renamed from: n */
    private final boolean f4926n;

    /* JADX INFO: renamed from: o */
    private final boolean f4927o;

    /* JADX INFO: renamed from: p */
    private final boolean f4928p;

    /* JADX INFO: renamed from: q */
    private final boolean f4929q;

    /* JADX INFO: renamed from: r */
    private final boolean f4930r;

    /* JADX INFO: renamed from: s */
    private final boolean f4931s;

    /* JADX INFO: renamed from: t */
    private final int f4932t;

    /* JADX INFO: renamed from: a */
    public static asd m5323a() {
        if (f4914b == null) {
            synchronized (asd.class) {
                if (f4914b == null) {
                    f4914b = new asd();
                }
            }
        }
        return f4914b;
    }

    public asd() {
        this(f4915c);
    }

    asd(ase aseVar) {
        this.f4920h = new ThreadLocal<C0747a>() { // from class: asd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0747a initialValue() {
                return new C0747a();
            }
        };
        this.f4917e = new HashMap();
        this.f4918f = new HashMap();
        this.f4919g = new ConcurrentHashMap();
        this.f4921i = new asg(this, Looper.getMainLooper(), 10);
        this.f4922j = new asc(this);
        this.f4923k = new asb(this);
        this.f4932t = aseVar.f4951j != null ? aseVar.f4951j.size() : 0;
        this.f4924l = new asn(aseVar.f4951j, aseVar.f4949h, aseVar.f4948g);
        this.f4927o = aseVar.f4942a;
        this.f4928p = aseVar.f4943b;
        this.f4929q = aseVar.f4944c;
        this.f4930r = aseVar.f4945d;
        this.f4926n = aseVar.f4946e;
        this.f4931s = aseVar.f4947f;
        this.f4925m = aseVar.f4950i;
    }

    /* JADX INFO: renamed from: a */
    public void m5335a(Object obj) {
        List<asm> listM5356a = this.f4924l.m5356a(obj.getClass());
        synchronized (this) {
            Iterator<asm> it = listM5356a.iterator();
            while (it.hasNext()) {
                m5328a(obj, it.next());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5328a(Object obj, asm asmVar) {
        Class<?> cls = asmVar.f4970c;
        aso asoVar = new aso(obj, asmVar);
        CopyOnWriteArrayList<aso> copyOnWriteArrayList = this.f4917e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f4917e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(asoVar)) {
            throw new asf("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || asmVar.f4971d > copyOnWriteArrayList.get(i).f4988b.f4971d) {
                copyOnWriteArrayList.add(i, asoVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f4918f.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f4918f.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (asmVar.f4972e) {
            if (this.f4931s) {
                for (Map.Entry<Class<?>, Object> entry : this.f4919g.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        m5332b(asoVar, entry.getValue());
                    }
                }
                return;
            }
            m5332b(asoVar, this.f4919g.get(cls));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5332b(aso asoVar, Object obj) {
        if (obj != null) {
            m5326a(asoVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5329a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<aso> copyOnWriteArrayList = this.f4917e.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                aso asoVar = copyOnWriteArrayList.get(i);
                if (asoVar.f4987a == obj) {
                    asoVar.f4989c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m5337b(Object obj) {
        List<Class<?>> list = this.f4918f.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m5329a(obj, it.next());
            }
            this.f4918f.remove(obj);
        } else {
            Log.w(f4913a, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5338c(Object obj) {
        C0747a c0747a = this.f4920h.get();
        List<Object> list = c0747a.f4935a;
        list.add(obj);
        if (c0747a.f4936b) {
            return;
        }
        c0747a.f4937c = Looper.getMainLooper() == Looper.myLooper();
        c0747a.f4936b = true;
        if (c0747a.f4940f) {
            throw new asf("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                m5327a(list.remove(0), c0747a);
            } finally {
                c0747a.f4936b = false;
                c0747a.f4937c = false;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5327a(Object obj, C0747a c0747a) {
        boolean zM5331a;
        Class<?> cls = obj.getClass();
        if (this.f4931s) {
            List<Class<?>> listM5324a = m5324a(cls);
            int size = listM5324a.size();
            zM5331a = false;
            for (int i = 0; i < size; i++) {
                zM5331a |= m5331a(obj, c0747a, listM5324a.get(i));
            }
        } else {
            zM5331a = m5331a(obj, c0747a, cls);
        }
        if (zM5331a) {
            return;
        }
        if (this.f4928p) {
            Log.d(f4913a, "No subscribers registered for event " + cls);
        }
        if (!this.f4930r || cls == ash.class || cls == asl.class) {
            return;
        }
        m5338c(new ash(this, obj));
    }

    /* JADX INFO: renamed from: a */
    private boolean m5331a(Object obj, C0747a c0747a, Class<?> cls) {
        CopyOnWriteArrayList<aso> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f4917e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (aso asoVar : copyOnWriteArrayList) {
            c0747a.f4939e = obj;
            c0747a.f4938d = asoVar;
            try {
                m5326a(asoVar, obj, c0747a.f4937c);
                if (c0747a.f4940f) {
                    return true;
                }
            } finally {
                c0747a.f4939e = null;
                c0747a.f4938d = null;
                c0747a.f4940f = false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m5326a(aso asoVar, Object obj, boolean z) {
        switch (asoVar.f4988b.f4969b) {
            case POSTING:
                m5334a(asoVar, obj);
                return;
            case MAIN:
                if (z) {
                    m5334a(asoVar, obj);
                    return;
                } else {
                    this.f4921i.m5340a(asoVar, obj);
                    return;
                }
            case BACKGROUND:
                if (z) {
                    this.f4922j.m5322a(asoVar, obj);
                    return;
                } else {
                    m5334a(asoVar, obj);
                    return;
                }
            case ASYNC:
                this.f4923k.m5321a(asoVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + asoVar.f4988b.f4969b);
        }
    }

    /* JADX INFO: renamed from: a */
    private static List<Class<?>> m5324a(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (f4916d) {
            arrayList = f4916d.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    m5330a(arrayList, superclass.getInterfaces());
                }
                f4916d.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    static void m5330a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m5330a(list, cls.getInterfaces());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m5333a(asi asiVar) {
        Object obj = asiVar.f4959a;
        aso asoVar = asiVar.f4960b;
        asi.m5342a(asiVar);
        if (asoVar.f4989c) {
            m5334a(asoVar, obj);
        }
    }

    /* JADX INFO: renamed from: a */
    void m5334a(aso asoVar, Object obj) {
        try {
            asoVar.f4988b.f4968a.invoke(asoVar.f4987a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            m5325a(asoVar, obj, e2.getCause());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5325a(aso asoVar, Object obj, Throwable th) {
        if (obj instanceof asl) {
            if (this.f4927o) {
                Log.e(f4913a, "SubscriberExceptionEvent subscriber " + asoVar.f4987a.getClass() + " threw an exception", th);
                asl aslVar = (asl) obj;
                Log.e(f4913a, "Initial event " + aslVar.f4966c + " caused exception in " + aslVar.f4967d, aslVar.f4965b);
                return;
            }
            return;
        }
        if (this.f4926n) {
            throw new asf("Invoking subscriber failed", th);
        }
        if (this.f4927o) {
            Log.e(f4913a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + asoVar.f4987a.getClass(), th);
        }
        if (this.f4929q) {
            m5338c(new asl(this, th, obj, asoVar.f4987a));
        }
    }

    /* JADX INFO: renamed from: asd$a */
    /* JADX INFO: compiled from: EventBus.java */
    static final class C0747a {

        /* JADX INFO: renamed from: a */
        final List<Object> f4935a = new ArrayList();

        /* JADX INFO: renamed from: b */
        boolean f4936b;

        /* JADX INFO: renamed from: c */
        boolean f4937c;

        /* JADX INFO: renamed from: d */
        aso f4938d;

        /* JADX INFO: renamed from: e */
        Object f4939e;

        /* JADX INFO: renamed from: f */
        boolean f4940f;

        C0747a() {
        }
    }

    /* JADX INFO: renamed from: b */
    ExecutorService m5336b() {
        return this.f4925m;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f4932t + ", eventInheritance=" + this.f4931s + "]";
    }
}
