package p000;

import android.util.Log;

/* JADX INFO: compiled from: Log.java */
/* JADX INFO: loaded from: classes.dex */
public class ahb {

    /* JADX INFO: renamed from: a */
    public static boolean f909a = false;

    /* JADX INFO: renamed from: a */
    public static void m1039a(String str, String str2) {
        if (f909a) {
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1040a(String str, String str2, Exception exc) {
        if (f909a) {
            Log.i(str, exc.toString() + ":  [" + str2 + "]");
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1041b(String str, String str2) {
        if (f909a) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1042b(String str, String str2, Exception exc) {
        if (f909a) {
            Log.e(str, exc.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m1043c(String str, String str2) {
        if (f909a) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m1045d(String str, String str2) {
        if (f909a) {
            Log.w(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m1044c(String str, String str2, Exception exc) {
        if (f909a) {
            Log.w(str, exc.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
