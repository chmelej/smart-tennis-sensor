package p000;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: a */
/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class C0000a extends AbstractC0785c {

    /* JADX INFO: renamed from: a */
    private static volatile C0000a f0a;

    /* JADX INFO: renamed from: d */
    private static final Executor f1d = new Executor() { // from class: a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0000a.m0a().mo2b(runnable);
        }
    };

    /* JADX INFO: renamed from: e */
    private static final Executor f2e = new Executor() { // from class: a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0000a.m0a().mo1a(runnable);
        }
    };

    /* JADX INFO: renamed from: c */
    private AbstractC0785c f4c = new C0758b();

    /* JADX INFO: renamed from: b */
    private AbstractC0785c f3b = this.f4c;

    private C0000a() {
    }

    /* JADX INFO: renamed from: a */
    public static C0000a m0a() {
        if (f0a != null) {
            return f0a;
        }
        synchronized (C0000a.class) {
            if (f0a == null) {
                f0a = new C0000a();
            }
        }
        return f0a;
    }

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f3b.mo1a(runnable);
    }

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: b */
    public void mo2b(Runnable runnable) {
        this.f3b.mo2b(runnable);
    }

    @Override // p000.AbstractC0785c
    /* JADX INFO: renamed from: b */
    public boolean mo3b() {
        return this.f3b.mo3b();
    }
}
