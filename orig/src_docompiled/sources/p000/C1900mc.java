package p000;

import android.util.Log;

/* JADX INFO: renamed from: mc */
/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1900mc {

    /* JADX INFO: renamed from: a */
    public static boolean f11448a = false;

    /* JADX INFO: renamed from: a */
    public static void m10473a(String str, String str2) {
        if (f11448a) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m10474b(String str, String str2) {
        if (f11448a) {
            if (str2.length() > 4000) {
                Log.v(str, "sb.length = " + str2.length());
                int length = str2.length() / 4000;
                int i = 0;
                while (i <= length) {
                    int i2 = i + 1;
                    int i3 = i2 * 4000;
                    if (i3 >= str2.length()) {
                        Log.v(str, "chunk " + i + " of " + length + ":" + str2.substring(i * 4000));
                    } else {
                        Log.v(str, "chunk " + i + " of " + length + ":" + str2.substring(i * 4000, i3));
                    }
                    i = i2;
                }
                return;
            }
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m10475c(String str, String str2) {
        if (f11448a) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m10476d(String str, String str2) {
        if (f11448a) {
            Log.w(str, str2);
        }
    }
}
