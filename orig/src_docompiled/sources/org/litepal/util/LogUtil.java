package org.litepal.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtil {
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static int level = 5;

    /* JADX INFO: renamed from: d */
    public static void m11042d(String str, String str2) {
        if (level <= 2) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m11043e(String str, Exception exc) {
        if (level <= 5) {
            Log.e(str, exc.getMessage(), exc);
        }
    }
}
