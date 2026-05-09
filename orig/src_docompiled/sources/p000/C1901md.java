package p000;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: renamed from: md */
/* JADX INFO: compiled from: NetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1901md {

    /* JADX INFO: renamed from: a */
    private static NetworkInfo f11449a;

    /* JADX INFO: renamed from: a */
    public static boolean m10477a() {
        f11449a = ((ConnectivityManager) C1914mm.m10554a().getSystemService("connectivity")).getActiveNetworkInfo();
        return f11449a != null && f11449a.isAvailable();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10478b() {
        return m10477a() && f11449a.getType() == 0;
    }
}
