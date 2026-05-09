package p000;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: QueuedWork.java */
/* JADX INFO: loaded from: classes.dex */
public class aey {

    /* JADX INFO: renamed from: c */
    private static long f716c = 5;

    /* JADX INFO: renamed from: a */
    private static List<WeakReference<ScheduledFuture<?>>> f714a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private static ExecutorService f715b = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: d */
    private static ScheduledExecutorService f717d = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: a */
    public static void m779a(Runnable runnable) {
        if (f715b.isShutdown()) {
            f715b = Executors.newSingleThreadExecutor();
        }
        f715b.execute(runnable);
    }

    /* JADX INFO: renamed from: a */
    public static void m778a() {
        try {
            Iterator<WeakReference<ScheduledFuture<?>>> it = f714a.iterator();
            while (it.hasNext()) {
                ScheduledFuture<?> scheduledFuture = it.next().get();
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            f714a.clear();
            if (!f715b.isShutdown()) {
                f715b.shutdown();
            }
            if (!f717d.isShutdown()) {
                f717d.shutdown();
            }
            f715b.awaitTermination(f716c, TimeUnit.SECONDS);
            f717d.awaitTermination(f716c, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m781b(Runnable runnable) {
        if (f717d.isShutdown()) {
            f717d = Executors.newSingleThreadScheduledExecutor();
        }
        f717d.execute(runnable);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m780a(Runnable runnable, long j) {
        if (f717d.isShutdown()) {
            f717d = Executors.newSingleThreadScheduledExecutor();
        }
        f714a.add(new WeakReference<>(f717d.schedule(runnable, j, TimeUnit.MILLISECONDS)));
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m782c(Runnable runnable) {
        if (f717d.isShutdown()) {
            f717d = Executors.newSingleThreadScheduledExecutor();
        }
        try {
            f717d.submit(runnable).get(5L, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
    }
}
