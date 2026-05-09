package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: wi */
/* JADX INFO: compiled from: SurfaceRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC2214wi implements Runnable {

    /* JADX INFO: renamed from: a */
    private Object f13285a;

    /* JADX INFO: renamed from: b */
    private Surface f13286b;

    /* JADX INFO: renamed from: c */
    private int f13287c;

    /* JADX INFO: renamed from: d */
    private int f13288d;

    /* JADX INFO: renamed from: e */
    private C2212wg f13289e;

    /* JADX INFO: renamed from: f */
    private C2218wm f13290f = new C2218wm();

    /* JADX INFO: renamed from: g */
    private a f13291g;

    /* JADX INFO: renamed from: h */
    private volatile boolean f13292h;

    /* JADX INFO: renamed from: i */
    private EnumC2157uf f13293i;

    /* JADX INFO: renamed from: j */
    private volatile boolean f13294j;

    /* JADX INFO: renamed from: wi$b */
    /* JADX INFO: compiled from: SurfaceRenderer.java */
    static class b {

        /* JADX INFO: renamed from: a */
        public int f13296a;

        /* JADX INFO: renamed from: b */
        public int f13297b;

        /* JADX INFO: renamed from: c */
        public int f13298c;

        /* JADX INFO: renamed from: d */
        public long f13299d;

        public b(int i, int i2, int i3, long j) {
            this.f13296a = i;
            this.f13297b = i2;
            this.f13298c = i3;
            this.f13299d = j;
        }
    }

    public RunnableC2214wi(Object obj, Surface surface, int i, int i2, EnumC2157uf enumC2157uf) {
        this.f13285a = obj;
        this.f13286b = surface;
        this.f13287c = i;
        this.f13288d = i2;
        this.f13293i = enumC2157uf;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m12121a() {
        if (this.f13292h) {
            C2201vw.f13219h.m12054d("SurfaceRenderer", "already started !!!");
            return;
        }
        new Thread(this, "SurfaceRenderer").start();
        while (!this.f13294j && !this.f13292h) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m12124b() {
        if (!this.f13292h) {
            C2201vw.f13219h.m12054d("SurfaceRenderer", "not started yet !!!");
            return;
        }
        if (this.f13291g != null) {
            this.f13291g.getLooper().quit();
        }
        while (this.f13292h) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12123a(int i, int i2, int i3, long j) {
        if (this.f13291g != null) {
            this.f13291g.sendMessage(this.f13291g.obtainMessage(0, new b(i, i2, i3, j)));
        }
    }

    /* JADX INFO: renamed from: wi$a */
    /* JADX INFO: compiled from: SurfaceRenderer.java */
    static class a extends Handler {

        /* JADX INFO: renamed from: a */
        private WeakReference<RunnableC2214wi> f13295a;

        public a(RunnableC2214wi runnableC2214wi) {
            this.f13295a = new WeakReference<>(runnableC2214wi);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = (b) message.obj;
            RunnableC2214wi runnableC2214wi = this.f13295a.get();
            if (runnableC2214wi != null) {
                runnableC2214wi.m12119a(bVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12122a(int i) {
        this.f13290f.mo12129a_(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12119a(b bVar) {
        if (!this.f13290f.m12143j() && bVar.f13297b != 0 && bVar.f13298c != 0) {
            this.f13290f.mo12140a(this.f13287c, this.f13288d);
            this.f13290f.m12141a(bVar.f13297b, bVar.f13298c, this.f13293i);
        }
        synchronized (C2200vv.f13206a) {
            if (this.f13290f != null) {
                this.f13290f.m12142c(bVar.f13296a);
            }
        }
        this.f13289e.m12106a(bVar.f13299d);
        this.f13289e.m12109c();
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m12125c() {
        this.f13294j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            if (this.f13294j) {
                C2201vw.f13219h.m12054d("SurfaceRenderer", "shared context is going to be invalid, interrupt now.");
                notify();
                return;
            }
            C2210we c2210we = new C2210we(this.f13285a, 1);
            this.f13289e = new C2212wg(c2210we, this.f13286b, false);
            this.f13289e.m12108b();
            Looper.prepare();
            this.f13291g = new a(this);
            synchronized (this) {
                this.f13292h = true;
                notify();
            }
            Looper.loop();
            this.f13289e.m12110d();
            c2210we.m12099a();
            synchronized (this) {
                this.f13292h = false;
                notify();
            }
        }
    }
}
