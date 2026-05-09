package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class ack implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f289a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ace f290b = null;

    ack(Context context) {
        this.f289a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f289a == null) {
            acd.f264q.m56d("The Context of StatService.onResume() can not be null!");
        } else {
            acd.m201a(this.f289a, abt.m101h(this.f289a), this.f290b);
        }
    }
}
