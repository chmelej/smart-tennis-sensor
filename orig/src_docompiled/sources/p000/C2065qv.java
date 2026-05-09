package p000;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: qv */
/* JADX INFO: compiled from: DefaultConfigurationFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C2065qv {
    /* JADX INFO: renamed from: a */
    public static Executor m11271a(int i, int i2, EnumC2081rk enumC2081rk) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (enumC2081rk == EnumC2081rk.LIFO ? new C2085ro() : new LinkedBlockingQueue()), m11272a(i2, "uil-pool-"));
    }

    /* JADX INFO: renamed from: a */
    public static Executor m11270a() {
        return Executors.newCachedThreadPool(m11272a(5, "uil-pool-d-"));
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC2059qp m11278b() {
        return new C2060qq();
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC2052qi m11273a(Context context, InterfaceC2059qp interfaceC2059qp, long j, int i) {
        File fileM11277b = m11277b(context);
        if (j > 0 || i > 0) {
            try {
                return new C2056qm(C2108sk.m11533b(context), fileM11277b, interfaceC2059qp, j, i);
            } catch (IOException e) {
                C2106si.m11523a(e);
            }
        }
        return new C2054qk(C2108sk.m11531a(context), fileM11277b, interfaceC2059qp);
    }

    /* JADX INFO: renamed from: b */
    private static File m11277b(Context context) {
        File fileM11532a = C2108sk.m11532a(context, false);
        File file = new File(fileM11532a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : fileM11532a;
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC2061qr m11274a(int i) {
        if (i == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new C2064qu(i);
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC2094rx m11276a(Context context) {
        return new C2093rw(context);
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC2088rr m11275a(boolean z) {
        return new C2087rq(z);
    }

    /* JADX INFO: renamed from: c */
    public static InterfaceC2090rt m11279c() {
        return new C2092rv();
    }

    /* JADX INFO: renamed from: a */
    private static ThreadFactory m11272a(int i, String str) {
        return new a(i, str);
    }

    /* JADX INFO: renamed from: qv$a */
    /* JADX INFO: compiled from: DefaultConfigurationFactory.java */
    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a */
        private static final AtomicInteger f12401a = new AtomicInteger(1);

        /* JADX INFO: renamed from: d */
        private final String f12404d;

        /* JADX INFO: renamed from: e */
        private final int f12405e;

        /* JADX INFO: renamed from: c */
        private final AtomicInteger f12403c = new AtomicInteger(1);

        /* JADX INFO: renamed from: b */
        private final ThreadGroup f12402b = Thread.currentThread().getThreadGroup();

        a(int i, String str) {
            this.f12405e = i;
            this.f12404d = str + f12401a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f12402b, runnable, this.f12404d + this.f12403c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f12405e);
            return thread;
        }
    }
}
