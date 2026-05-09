package p000;

import android.util.Log;

/* JADX INFO: compiled from: Log.java */
/* JADX INFO: loaded from: classes.dex */
public class atj {

    /* JADX INFO: renamed from: a */
    public static boolean f5037a = false;

    /* JADX INFO: renamed from: a */
    public static void m5423a(String str, String str2) {
        if (f5037a) {
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5424a(String str, String str2, Exception exc) {
        if (f5037a) {
            Log.i(str, String.valueOf(exc.toString()) + ":  [" + str2 + "]");
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m5425b(String str, String str2) {
        if (f5037a) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m5426b(String str, String str2, Exception exc) {
        if (f5037a) {
            Log.e(str, String.valueOf(exc.toString()) + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m5427c(String str, String str2) {
        if (f5037a) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m5428c(String str, String str2, Exception exc) {
        if (f5037a) {
            Log.d(str, String.valueOf(exc.toString()) + ":  [" + str2 + "]");
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5429d(String str, String str2) {
        if (f5037a) {
            Log.w(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5430d(String str, String str2, Exception exc) {
        if (f5037a) {
            Log.w(str, String.valueOf(exc.toString()) + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
