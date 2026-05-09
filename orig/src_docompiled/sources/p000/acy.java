package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class acy extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ acf f336a;

    acy(acf acfVar) {
        this.f336a = acfVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f336a.f278e != null) {
            this.f336a.f278e.m68a(new aas(this));
        }
    }
}
