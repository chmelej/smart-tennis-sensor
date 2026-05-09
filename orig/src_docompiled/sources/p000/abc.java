package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class abc implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f95a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ ace f96b = null;

    abc(Context context) {
        this.f95a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f95a == null) {
            acd.f264q.m56d("The Context of StatService.onPause() can not be null!");
        } else {
            acd.m208b(this.f95a, abt.m101h(this.f95a), this.f96b);
        }
    }
}
