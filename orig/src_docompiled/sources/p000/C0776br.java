package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: br */
/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0776br {

    /* JADX INFO: renamed from: a */
    private static C0776br f5282a;

    /* JADX INFO: renamed from: b */
    private final Object f5283b = new Object();

    /* JADX INFO: renamed from: c */
    private final Handler f5284c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: br.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            C0776br.this.m5694a((b) message.obj);
            return true;
        }
    });

    /* JADX INFO: renamed from: d */
    private b f5285d;

    /* JADX INFO: renamed from: e */
    private b f5286e;

    /* JADX INFO: renamed from: br$a */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void m5699a();

        /* JADX INFO: renamed from: a */
        void m5700a(int i);
    }

    /* JADX INFO: renamed from: a */
    public static C0776br m5686a() {
        if (f5282a == null) {
            f5282a = new C0776br();
        }
        return f5282a;
    }

    private C0776br() {
    }

    /* JADX INFO: renamed from: a */
    public void m5693a(a aVar, int i) {
        synchronized (this.f5283b) {
            if (m5690f(aVar)) {
                m5687a(this.f5285d, i);
            } else if (m5691g(aVar)) {
                m5687a(this.f5286e, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5692a(a aVar) {
        synchronized (this.f5283b) {
            if (m5690f(aVar)) {
                this.f5285d = null;
                if (this.f5286e != null) {
                    m5688b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5695b(a aVar) {
        synchronized (this.f5283b) {
            if (m5690f(aVar)) {
                m5689b(this.f5285d);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5696c(a aVar) {
        synchronized (this.f5283b) {
            if (m5690f(aVar) && !this.f5285d.f5290c) {
                this.f5285d.f5290c = true;
                this.f5284c.removeCallbacksAndMessages(this.f5285d);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m5697d(a aVar) {
        synchronized (this.f5283b) {
            if (m5690f(aVar) && this.f5285d.f5290c) {
                this.f5285d.f5290c = false;
                m5689b(this.f5285d);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m5698e(a aVar) {
        boolean z;
        synchronized (this.f5283b) {
            z = m5690f(aVar) || m5691g(aVar);
        }
        return z;
    }

    /* JADX INFO: renamed from: br$b */
    /* JADX INFO: compiled from: SnackbarManager.java */
    static class b {

        /* JADX INFO: renamed from: a */
        final WeakReference<a> f5288a;

        /* JADX INFO: renamed from: b */
        int f5289b;

        /* JADX INFO: renamed from: c */
        boolean f5290c;

        /* JADX INFO: renamed from: a */
        boolean m5701a(a aVar) {
            return aVar != null && this.f5288a.get() == aVar;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5688b() {
        if (this.f5286e != null) {
            this.f5285d = this.f5286e;
            this.f5286e = null;
            a aVar = this.f5285d.f5288a.get();
            if (aVar != null) {
                aVar.m5699a();
            } else {
                this.f5285d = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m5687a(b bVar, int i) {
        a aVar = bVar.f5288a.get();
        if (aVar == null) {
            return false;
        }
        this.f5284c.removeCallbacksAndMessages(bVar);
        aVar.m5700a(i);
        return true;
    }

    /* JADX INFO: renamed from: f */
    private boolean m5690f(a aVar) {
        return this.f5285d != null && this.f5285d.m5701a(aVar);
    }

    /* JADX INFO: renamed from: g */
    private boolean m5691g(a aVar) {
        return this.f5286e != null && this.f5286e.m5701a(aVar);
    }

    /* JADX INFO: renamed from: b */
    private void m5689b(b bVar) {
        if (bVar.f5289b == -2) {
            return;
        }
        int i = 2750;
        if (bVar.f5289b > 0) {
            i = bVar.f5289b;
        } else if (bVar.f5289b == -1) {
            i = 1500;
        }
        this.f5284c.removeCallbacksAndMessages(bVar);
        this.f5284c.sendMessageDelayed(Message.obtain(this.f5284c, 0, bVar), i);
    }

    /* JADX INFO: renamed from: a */
    void m5694a(b bVar) {
        synchronized (this.f5283b) {
            if (this.f5285d == bVar || this.f5286e == bVar) {
                m5687a(bVar, 2);
            }
        }
    }
}
