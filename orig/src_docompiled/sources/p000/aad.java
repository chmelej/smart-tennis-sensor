package p000;

import android.util.Log;
import p000.aab;

/* JADX INFO: loaded from: classes.dex */
class aad implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aab.C0003a f18a;

    aad(aab.C0003a c0003a) {
        this.f18a = c0003a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (aab.f6a == null || this.f18a.f12a) {
            return;
        }
        Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onForeground");
        acd.m200a(this.f18a.f14c, "onForeground_WX");
        this.f18a.f12a = true;
    }
}
