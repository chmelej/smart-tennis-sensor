package com.umeng.update.util;

import android.content.Context;
import java.io.File;
import p000.ats;

/* JADX INFO: loaded from: classes.dex */
public class DeltaUpdate {

    /* JADX INFO: renamed from: a */
    private static boolean f9300a;

    public static native int bspatch(String str, String str2, String str3);

    /* JADX INFO: renamed from: a */
    public static boolean m8791a() {
        return f9300a;
    }

    /* JADX INFO: renamed from: a */
    public static int m8789a(String str, String str2, String str3) {
        return bspatch(str, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public static String m8790a(Context context) {
        return context.getApplicationInfo().sourceDir;
    }

    /* JADX INFO: renamed from: b */
    public static String m8792b(Context context) {
        String strM8790a = m8790a(context);
        return !new File(strM8790a).exists() ? "" : ats.m5469a(new File(strM8790a));
    }

    static {
        try {
            System.loadLibrary("bspatch");
            f9300a = true;
        } catch (UnsatisfiedLinkError unused) {
            f9300a = false;
        }
    }
}
