package p000;

import android.content.Context;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
final class abb implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f94a;

    abb(Context context) {
        this.f94a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        acf.m234a(acd.f267t).m246h();
        abt.m77a(this.f94a, true);
        acs.m255a(this.f94a);
        aay.m38b(this.f94a);
        Thread.UncaughtExceptionHandler unused = acd.f265r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new acm());
        if (acb.m151a() == acc.APP_LAUNCH) {
            acd.m213d(this.f94a);
        }
        if (acb.m166b()) {
            acd.f264q.m59g("Init MTA StatService success.");
        }
    }
}
