package p000;

import java.lang.Thread;

/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class adu implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    private Thread.UncaughtExceptionHandler f484a;

    /* JADX INFO: renamed from: b */
    private adz f485b;

    public adu() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f484a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: renamed from: a */
    public void m438a(adz adzVar) {
        this.f485b = adzVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m437a(th);
        if (this.f484a == null || this.f484a == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f484a.uncaughtException(thread, th);
    }

    /* JADX INFO: renamed from: a */
    private void m437a(Throwable th) {
        if (acz.f342f) {
            this.f485b.mo312a(th);
        } else {
            this.f485b.mo312a(null);
        }
    }
}
