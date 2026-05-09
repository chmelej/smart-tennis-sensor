package p000;

import android.content.Context;
import android.util.Log;

/* JADX INFO: renamed from: pq */
/* JADX INFO: compiled from: CLog.java */
/* JADX INFO: loaded from: classes.dex */
public class C2031pq {

    /* JADX INFO: renamed from: a */
    private static boolean f12207a = true;

    /* JADX INFO: renamed from: a */
    public static void m11101a(Context context) {
        f12207a = (context.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX INFO: renamed from: a */
    public static void m11102a(String str, String str2) {
        if (f12207a) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11103b(String str, String str2) {
        if (f12207a) {
            Log.e(str, str2);
        }
    }
}
