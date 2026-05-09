package p000;

import android.util.Log;

/* JADX INFO: renamed from: si */
/* JADX INFO: compiled from: L.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2106si {

    /* JADX INFO: renamed from: a */
    private static volatile boolean f12642a = false;

    /* JADX INFO: renamed from: b */
    private static volatile boolean f12643b = true;

    /* JADX INFO: renamed from: a */
    public static void m11524a(boolean z) {
        f12642a = z;
    }

    /* JADX INFO: renamed from: a */
    public static void m11522a(String str, Object... objArr) {
        if (f12642a) {
            m11521a(3, null, str, objArr);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11525b(String str, Object... objArr) {
        m11521a(4, null, str, objArr);
    }

    /* JADX INFO: renamed from: c */
    public static void m11526c(String str, Object... objArr) {
        m11521a(5, null, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public static void m11523a(Throwable th) {
        m11521a(6, th, null, new Object[0]);
    }

    /* JADX INFO: renamed from: d */
    public static void m11527d(String str, Object... objArr) {
        m11521a(6, null, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    private static void m11521a(int i, Throwable th, String str, Object... objArr) {
        if (f12643b) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i, C2068qy.f12452a, str);
        }
    }
}
