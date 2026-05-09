package p000;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import p000.C2067qx;
import p000.C2076rf;
import p000.C2105sh;
import p000.InterfaceC2094rx;

/* JADX INFO: renamed from: rc */
/* JADX INFO: compiled from: LoadAndDisplayImageTask.java */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC2073rc implements Runnable, C2105sh.a {

    /* JADX INFO: renamed from: a */
    final String f12526a;

    /* JADX INFO: renamed from: b */
    final InterfaceC2095ry f12527b;

    /* JADX INFO: renamed from: c */
    final C2067qx f12528c;

    /* JADX INFO: renamed from: d */
    final InterfaceC2100sc f12529d;

    /* JADX INFO: renamed from: e */
    final InterfaceC2101sd f12530e;

    /* JADX INFO: renamed from: f */
    private final C2071ra f12531f;

    /* JADX INFO: renamed from: g */
    private final C2072rb f12532g;

    /* JADX INFO: renamed from: h */
    private final Handler f12533h;

    /* JADX INFO: renamed from: i */
    private final C2069qz f12534i;

    /* JADX INFO: renamed from: j */
    private final InterfaceC2094rx f12535j;

    /* JADX INFO: renamed from: k */
    private final InterfaceC2094rx f12536k;

    /* JADX INFO: renamed from: l */
    private final InterfaceC2094rx f12537l;

    /* JADX INFO: renamed from: m */
    private final InterfaceC2088rr f12538m;

    /* JADX INFO: renamed from: n */
    private final String f12539n;

    /* JADX INFO: renamed from: o */
    private final C2079ri f12540o;

    /* JADX INFO: renamed from: p */
    private final boolean f12541p;

    /* JADX INFO: renamed from: q */
    private EnumC2080rj f12542q = EnumC2080rj.NETWORK;

    public RunnableC2073rc(C2071ra c2071ra, C2072rb c2072rb, Handler handler) {
        this.f12531f = c2071ra;
        this.f12532g = c2072rb;
        this.f12533h = handler;
        this.f12534i = c2071ra.f12506a;
        this.f12535j = this.f12534i.f12473p;
        this.f12536k = this.f12534i.f12476s;
        this.f12537l = this.f12534i.f12477t;
        this.f12538m = this.f12534i.f12474q;
        this.f12526a = c2072rb.f12518a;
        this.f12539n = c2072rb.f12519b;
        this.f12527b = c2072rb.f12520c;
        this.f12540o = c2072rb.f12521d;
        this.f12528c = c2072rb.f12522e;
        this.f12529d = c2072rb.f12523f;
        this.f12530e = c2072rb.f12524g;
        this.f12541p = this.f12528c.m11322s();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m11414b() || m11416c()) {
            return;
        }
        ReentrantLock reentrantLock = this.f12532g.f12525h;
        C2106si.m11522a("Start display image task [%s]", this.f12539n);
        if (reentrantLock.isLocked()) {
            C2106si.m11522a("Image already is loading. Waiting... [%s]", this.f12539n);
        }
        reentrantLock.lock();
        try {
            m11423i();
            Bitmap bitmapA = this.f12534i.f12471n.mo11264a(this.f12539n);
            if (bitmapA == null || bitmapA.isRecycled()) {
                bitmapA = m11418d();
                if (bitmapA == null) {
                    return;
                }
                m11423i();
                m11429o();
                if (this.f12528c.m11307d()) {
                    C2106si.m11522a("PreProcess image before caching in memory [%s]", this.f12539n);
                    bitmapA = this.f12528c.m11318o().m11511a(bitmapA);
                    if (bitmapA == null) {
                        C2106si.m11527d("Pre-processor returned null [%s]", this.f12539n);
                    }
                }
                if (bitmapA != null && this.f12528c.m11311h()) {
                    C2106si.m11522a("Cache image in memory [%s]", this.f12539n);
                    this.f12534i.f12471n.mo11266a(this.f12539n, bitmapA);
                }
            } else {
                this.f12542q = EnumC2080rj.MEMORY_CACHE;
                C2106si.m11522a("...Get cached bitmap from memory after waiting. [%s]", this.f12539n);
            }
            if (bitmapA != null && this.f12528c.m11308e()) {
                C2106si.m11522a("PostProcess image before displaying [%s]", this.f12539n);
                bitmapA = this.f12528c.m11319p().m11511a(bitmapA);
                if (bitmapA == null) {
                    C2106si.m11527d("Post-processor returned null [%s]", this.f12539n);
                }
            }
            m11423i();
            m11429o();
            reentrantLock.unlock();
            m11412a(new RunnableC2066qw(bitmapA, this.f12532g, this.f12531f, this.f12542q), this.f12541p, this.f12533h, this.f12531f);
        } catch (a unused) {
            m11421g();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m11414b() {
        AtomicBoolean atomicBooleanM11400a = this.f12531f.m11400a();
        if (atomicBooleanM11400a.get()) {
            synchronized (this.f12531f.m11406b()) {
                if (atomicBooleanM11400a.get()) {
                    C2106si.m11522a("ImageLoader is paused. Waiting...  [%s]", this.f12539n);
                    try {
                        this.f12531f.m11406b().wait();
                        C2106si.m11522a(".. Resume loading [%s]", this.f12539n);
                    } catch (InterruptedException unused) {
                        C2106si.m11527d("Task was interrupted [%s]", this.f12539n);
                        return true;
                    }
                }
            }
        }
        return m11424j();
    }

    /* JADX INFO: renamed from: c */
    private boolean m11416c() {
        if (!this.f12528c.m11309f()) {
            return false;
        }
        C2106si.m11522a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.f12528c.m11315l()), this.f12539n);
        try {
            Thread.sleep(this.f12528c.m11315l());
            return m11424j();
        } catch (InterruptedException unused) {
            C2106si.m11527d("Task was interrupted [%s]", this.f12539n);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8 A[Catch: Throwable -> 0x009a, OutOfMemoryError -> 0x009e, IOException -> 0x00a2, IllegalStateException -> 0x00a6, a -> 0x00d6, TRY_LEAVE, TryCatch #12 {a -> 0x00d6, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0015, B:11:0x0039, B:13:0x003f, B:22:0x004f, B:24:0x0068, B:26:0x006e, B:28:0x007a, B:29:0x0084, B:31:0x008d, B:33:0x0093, B:43:0x00a8), top: B:60:0x0001 }] */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap m11418d() throws p000.RunnableC2073rc.a {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.RunnableC2073rc.m11418d():android.graphics.Bitmap");
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m11410a(String str) {
        return this.f12538m.mo11461a(new C2089rs(this.f12539n, str, this.f12526a, this.f12540o, this.f12527b.mo11497c(), m11422h(), this.f12528c));
    }

    /* JADX INFO: renamed from: e */
    private boolean m11419e() {
        C2106si.m11522a("Cache image on disk [%s]", this.f12539n);
        try {
            boolean zM11420f = m11420f();
            if (!zM11420f) {
                return zM11420f;
            }
            int i = this.f12534i.f12461d;
            int i2 = this.f12534i.f12462e;
            if (i <= 0 && i2 <= 0) {
                return zM11420f;
            }
            C2106si.m11522a("Resize image in disk cache [%s]", this.f12539n);
            m11415b(i, i2);
            return zM11420f;
        } catch (IOException e) {
            C2106si.m11523a(e);
            return false;
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m11420f() {
        return this.f12534i.f12472o.mo11204a(this.f12526a, m11422h().mo11393a(this.f12526a, this.f12528c.m11317n()), this);
    }

    /* JADX INFO: renamed from: b */
    private boolean m11415b(int i, int i2) {
        File fileA = this.f12534i.f12472o.mo11202a(this.f12526a);
        if (fileA == null || !fileA.exists()) {
            return false;
        }
        Bitmap bitmapMo11461a = this.f12538m.mo11461a(new C2089rs(this.f12539n, InterfaceC2094rx.a.FILE.m11491b(fileA.getAbsolutePath()), this.f12526a, new C2079ri(i, i2), EnumC2082rl.FIT_INSIDE, m11422h(), new C2067qx.a().m11344a(this.f12528c).m11345a(EnumC2078rh.IN_SAMPLE_INT).m11348a()));
        if (bitmapMo11461a != null && this.f12534i.f12463f != null) {
            C2106si.m11522a("Process image before cache on disk [%s]", this.f12539n);
            bitmapMo11461a = this.f12534i.f12463f.m11511a(bitmapMo11461a);
            if (bitmapMo11461a == null) {
                C2106si.m11527d("Bitmap processor for disk cache returned null [%s]", this.f12539n);
            }
        }
        if (bitmapMo11461a == null) {
            return false;
        }
        boolean zA = this.f12534i.f12472o.mo11203a(this.f12526a, bitmapMo11461a);
        bitmapMo11461a.recycle();
        return zA;
    }

    @Override // p000.C2105sh.a
    /* JADX INFO: renamed from: a */
    public boolean mo11432a(int i, int i2) {
        return this.f12541p || m11417c(i, i2);
    }

    /* JADX INFO: renamed from: c */
    private boolean m11417c(final int i, final int i2) {
        if (m11430p() || m11424j()) {
            return false;
        }
        if (this.f12530e == null) {
            return true;
        }
        m11412a(new Runnable() { // from class: rc.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC2073rc.this.f12530e.m11510a(RunnableC2073rc.this.f12526a, RunnableC2073rc.this.f12527b.mo11498d(), i, i2);
            }
        }, false, this.f12533h, this.f12531f);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m11413a(final C2076rf.a aVar, final Throwable th) {
        if (this.f12541p || m11430p() || m11424j()) {
            return;
        }
        m11412a(new Runnable() { // from class: rc.2
            @Override // java.lang.Runnable
            public void run() {
                if (RunnableC2073rc.this.f12528c.m11306c()) {
                    RunnableC2073rc.this.f12527b.mo11495a(RunnableC2073rc.this.f12528c.m11305c(RunnableC2073rc.this.f12534i.f12458a));
                }
                RunnableC2073rc.this.f12529d.mo11508a(RunnableC2073rc.this.f12526a, RunnableC2073rc.this.f12527b.mo11498d(), new C2076rf(aVar, th));
            }
        }, false, this.f12533h, this.f12531f);
    }

    /* JADX INFO: renamed from: g */
    private void m11421g() {
        if (this.f12541p || m11430p()) {
            return;
        }
        m11412a(new Runnable() { // from class: rc.3
            @Override // java.lang.Runnable
            public void run() {
                RunnableC2073rc.this.f12529d.mo11509b(RunnableC2073rc.this.f12526a, RunnableC2073rc.this.f12527b.mo11498d());
            }
        }, false, this.f12533h, this.f12531f);
    }

    /* JADX INFO: renamed from: h */
    private InterfaceC2094rx m11422h() {
        if (this.f12531f.m11408c()) {
            return this.f12536k;
        }
        if (this.f12531f.m11409d()) {
            return this.f12537l;
        }
        return this.f12535j;
    }

    /* JADX INFO: renamed from: i */
    private void m11423i() throws a {
        m11425k();
        m11427m();
    }

    /* JADX INFO: renamed from: j */
    private boolean m11424j() {
        return m11426l() || m11428n();
    }

    /* JADX INFO: renamed from: k */
    private void m11425k() throws a {
        if (m11426l()) {
            throw new a();
        }
    }

    /* JADX INFO: renamed from: l */
    private boolean m11426l() {
        if (!this.f12527b.mo11499e()) {
            return false;
        }
        C2106si.m11522a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f12539n);
        return true;
    }

    /* JADX INFO: renamed from: m */
    private void m11427m() throws a {
        if (m11428n()) {
            throw new a();
        }
    }

    /* JADX INFO: renamed from: n */
    private boolean m11428n() {
        if (!(!this.f12539n.equals(this.f12531f.m11399a(this.f12527b)))) {
            return false;
        }
        C2106si.m11522a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f12539n);
        return true;
    }

    /* JADX INFO: renamed from: o */
    private void m11429o() throws a {
        if (m11430p()) {
            throw new a();
        }
    }

    /* JADX INFO: renamed from: p */
    private boolean m11430p() {
        if (!Thread.interrupted()) {
            return false;
        }
        C2106si.m11522a("Task was interrupted [%s]", this.f12539n);
        return true;
    }

    /* JADX INFO: renamed from: a */
    String m11431a() {
        return this.f12526a;
    }

    /* JADX INFO: renamed from: a */
    static void m11412a(Runnable runnable, boolean z, Handler handler, C2071ra c2071ra) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            c2071ra.m11402a(runnable);
        } else {
            handler.post(runnable);
        }
    }

    /* JADX INFO: renamed from: rc$a */
    /* JADX INFO: compiled from: LoadAndDisplayImageTask.java */
    class a extends Exception {
        a() {
        }
    }
}
