package p000;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: ra */
/* JADX INFO: compiled from: ImageLoaderEngine.java */
/* JADX INFO: loaded from: classes.dex */
class C2071ra {

    /* JADX INFO: renamed from: a */
    final C2069qz f12506a;

    /* JADX INFO: renamed from: b */
    private Executor f12507b;

    /* JADX INFO: renamed from: c */
    private Executor f12508c;

    /* JADX INFO: renamed from: e */
    private final Map<Integer, String> f12510e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f */
    private final Map<String, ReentrantLock> f12511f = new WeakHashMap();

    /* JADX INFO: renamed from: g */
    private final AtomicBoolean f12512g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h */
    private final AtomicBoolean f12513h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i */
    private final AtomicBoolean f12514i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j */
    private final Object f12515j = new Object();

    /* JADX INFO: renamed from: d */
    private Executor f12509d = C2065qv.m11270a();

    C2071ra(C2069qz c2069qz) {
        this.f12506a = c2069qz;
        this.f12507b = c2069qz.f12464g;
        this.f12508c = c2069qz.f12465h;
    }

    /* JADX INFO: renamed from: a */
    void m11403a(final RunnableC2073rc runnableC2073rc) {
        this.f12509d.execute(new Runnable() { // from class: ra.1
            @Override // java.lang.Runnable
            public void run() {
                File fileA = C2071ra.this.f12506a.f12472o.mo11202a(runnableC2073rc.m11431a());
                boolean z = fileA != null && fileA.exists();
                C2071ra.this.m11397e();
                if (z) {
                    C2071ra.this.f12508c.execute(runnableC2073rc);
                } else {
                    C2071ra.this.f12507b.execute(runnableC2073rc);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m11404a(RunnableC2074rd runnableC2074rd) {
        m11397e();
        this.f12508c.execute(runnableC2074rd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m11397e() {
        if (!this.f12506a.f12466i && ((ExecutorService) this.f12507b).isShutdown()) {
            this.f12507b = m11398f();
        }
        if (this.f12506a.f12467j || !((ExecutorService) this.f12508c).isShutdown()) {
            return;
        }
        this.f12508c = m11398f();
    }

    /* JADX INFO: renamed from: f */
    private Executor m11398f() {
        return C2065qv.m11271a(this.f12506a.f12468k, this.f12506a.f12469l, this.f12506a.f12470m);
    }

    /* JADX INFO: renamed from: a */
    String m11399a(InterfaceC2095ry interfaceC2095ry) {
        return this.f12510e.get(Integer.valueOf(interfaceC2095ry.mo11500f()));
    }

    /* JADX INFO: renamed from: a */
    void m11405a(InterfaceC2095ry interfaceC2095ry, String str) {
        this.f12510e.put(Integer.valueOf(interfaceC2095ry.mo11500f()), str);
    }

    /* JADX INFO: renamed from: b */
    void m11407b(InterfaceC2095ry interfaceC2095ry) {
        this.f12510e.remove(Integer.valueOf(interfaceC2095ry.mo11500f()));
    }

    /* JADX INFO: renamed from: a */
    void m11402a(Runnable runnable) {
        this.f12509d.execute(runnable);
    }

    /* JADX INFO: renamed from: a */
    ReentrantLock m11401a(String str) {
        ReentrantLock reentrantLock = this.f12511f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f12511f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    /* JADX INFO: renamed from: a */
    AtomicBoolean m11400a() {
        return this.f12512g;
    }

    /* JADX INFO: renamed from: b */
    Object m11406b() {
        return this.f12515j;
    }

    /* JADX INFO: renamed from: c */
    boolean m11408c() {
        return this.f12513h.get();
    }

    /* JADX INFO: renamed from: d */
    boolean m11409d() {
        return this.f12514i.get();
    }
}
