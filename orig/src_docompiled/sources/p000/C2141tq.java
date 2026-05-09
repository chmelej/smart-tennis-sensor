package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: renamed from: tq */
/* JADX INFO: compiled from: AndroidNetwork.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2141tq {
    /* JADX INFO: renamed from: a */
    public static boolean m11706a() {
        Context contextM11708a = C2143ts.m11708a();
        if (contextM11708a == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) contextM11708a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
