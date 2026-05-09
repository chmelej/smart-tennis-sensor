package p000;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class abn {

    /* JADX INFO: renamed from: a */
    ExecutorService f146a;

    public abn() {
        this.f146a = null;
        this.f146a = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: renamed from: a */
    public final void m68a(Runnable runnable) {
        this.f146a.execute(runnable);
    }
}
