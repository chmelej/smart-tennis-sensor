package p000;

import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
final class acm implements Thread.UncaughtExceptionHandler {
    acm() {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (!acb.m169c() || acd.f267t == null) {
            return;
        }
        if (acb.m184o()) {
            acs.m255a(acd.f267t).m281a((aai) new aah(acd.f267t, acd.m194a(acd.f267t, false, (ace) null), th, thread), (aax) null, false, true);
            acd.f264q.m58f("MTA has caught the following uncaught exception:");
            acd.f264q.m52a(th);
        }
        acd.m215e(acd.f267t);
        if (acd.f265r != null) {
            acd.f264q.m59g("Call the original uncaught exception handler.");
            if (acd.f265r instanceof acm) {
                return;
            }
            acd.f265r.uncaughtException(thread, th);
        }
    }
}
