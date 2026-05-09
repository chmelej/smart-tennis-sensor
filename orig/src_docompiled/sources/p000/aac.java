package p000;

import android.util.Log;
import p000.aab;

/* JADX INFO: loaded from: classes.dex */
class aac implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aab.C0003a f17a;

    aac(aab.C0003a c0003a) {
        this.f17a = c0003a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (aab.f6a == null || !this.f17a.f12a) {
            return;
        }
        Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
        acd.m200a(this.f17a.f14c, "onBackground_WX");
        this.f17a.f12a = false;
    }
}
