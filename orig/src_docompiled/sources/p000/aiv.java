package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: compiled from: AgooLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class aiv {

    /* JADX INFO: renamed from: a */
    private static volatile aiw f1202a;

    /* JADX INFO: renamed from: a */
    public static final void m1411a(Context context) {
        if (f1202a == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("AppStore", 4);
                boolean z = true;
                if (!sharedPreferences.getBoolean("app_debug", true) && !m1417b(context)) {
                    z = false;
                }
                f1202a = new aix(z, sharedPreferences.getBoolean("app_log_to_file", false));
            } catch (Throwable th) {
                Log.d("AgooLog", "startlog", th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1417b(Context context) {
        try {
            return Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG").getBoolean("false");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1412a(String str, String str2) {
        if (f1202a != null) {
            f1202a.mo1428c(str, str2);
        } else {
            Log.v(str, str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1415b(String str, String str2) {
        if (f1202a != null) {
            f1202a.mo1426b(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1413a(String str, String str2, Throwable th) {
        if (f1202a != null) {
            f1202a.mo1427b(str, str2, th);
        } else {
            Log.i(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m1418c(String str, String str2) {
        if (f1202a != null) {
            f1202a.mo1423a(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1414a(String str, Object... objArr) {
        if (f1202a != null) {
            f1202a.mo1425a(str, objArr);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1416b(String str, String str2, Throwable th) {
        if (f1202a != null) {
            f1202a.mo1424a(str, str2, th);
        } else {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m1420d(String str, String str2) {
        if (f1202a != null) {
            f1202a.mo1430d(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m1419c(String str, String str2, Throwable th) {
        if (f1202a != null) {
            f1202a.mo1429c(str, str2, th);
        } else {
            Log.w(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m1422e(String str, String str2) {
        if (f1202a != null) {
            f1202a.mo1432e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m1421d(String str, String str2, Throwable th) {
        if (f1202a != null) {
            f1202a.mo1431d(str, str2, th);
        } else {
            Log.e(str, str2, th);
        }
    }
}
