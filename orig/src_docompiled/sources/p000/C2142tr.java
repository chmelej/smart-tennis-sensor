package p000;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: tr */
/* JADX INFO: compiled from: AsyncRun.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2142tr {
    /* JADX INFO: renamed from: a */
    public static void m11707a(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
