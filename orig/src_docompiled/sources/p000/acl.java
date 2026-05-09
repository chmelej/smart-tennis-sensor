package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class acl implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f291a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ace f292b = null;

    acl(Context context) {
        this.f291a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            acd.m194a(this.f291a, false, this.f292b);
        } catch (Throwable th) {
            acd.f264q.m54b(th);
        }
    }
}
