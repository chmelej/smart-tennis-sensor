package p000;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: b */
/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class C0758b extends AbstractC0785c {

    /* JADX INFO: renamed from: a */
    private final Object f5085a = new Object();

    /* JADX INFO: renamed from: b */
    private ExecutorService f5086b = Executors.newFixedThreadPool(2);

    /* JADX INFO: renamed from: c */
    private volatile Handler f5087c;

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f5086b.execute(runnable);
    }

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: b */
    public void mo2b(Runnable runnable) {
        if (this.f5087c == null) {
            synchronized (this.f5085a) {
                if (this.f5087c == null) {
                    this.f5087c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f5087c.post(runnable);
    }

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: b */
    public boolean mo3b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
