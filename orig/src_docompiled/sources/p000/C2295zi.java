package p000;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

/* JADX INFO: renamed from: zi */
/* JADX INFO: loaded from: classes.dex */
public final class C2295zi {

    /* JADX INFO: renamed from: a */
    public static C2298zl f13785a = null;

    /* JADX INFO: renamed from: b */
    private static int f13786b = 6;

    /* JADX INFO: renamed from: c */
    private static a f13787c;

    /* JADX INFO: renamed from: d */
    private static a f13788d;

    /* JADX INFO: renamed from: e */
    private static final String f13789e;

    /* JADX INFO: renamed from: zi$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        int mo12553a();

        /* JADX INFO: renamed from: a */
        void mo12554a(String str, String str2);

        /* JADX INFO: renamed from: b */
        void mo12555b(String str, String str2);

        /* JADX INFO: renamed from: c */
        void mo12556c(String str, String str2);

        /* JADX INFO: renamed from: d */
        void mo12557d(String str, String str2);
    }

    static {
        C2296zj c2296zj = new C2296zj();
        f13787c = c2296zj;
        f13788d = c2296zj;
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb.append("] BOARD:[" + Build.BOARD);
        sb.append("] DEVICE:[" + Build.DEVICE);
        sb.append("] DISPLAY:[" + Build.DISPLAY);
        sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb.append("] HOST:[" + Build.HOST);
        sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb.append("] MODEL:[" + Build.MODEL);
        sb.append("] PRODUCT:[" + Build.PRODUCT);
        sb.append("] TAGS:[" + Build.TAGS);
        sb.append("] TYPE:[" + Build.TYPE);
        sb.append("] USER:[" + Build.USER + "]");
        f13789e = sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m12547a(String str) {
        return f13785a != null ? f13785a.m12562a(str) : str;
    }

    /* JADX INFO: renamed from: a */
    public static void m12548a(String str, String str2) {
        m12549a(str, str2, null);
    }

    /* JADX INFO: renamed from: a */
    public static void m12549a(String str, String str2, Object... objArr) {
        if (f13788d == null || f13788d.mo12553a() > 4) {
            return;
        }
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        String strM12547a = m12547a(str);
        a aVar = f13788d;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        aVar.mo12557d(strM12547a, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m12550b(String str, String str2) {
        if (f13788d == null || f13788d.mo12553a() > 3) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        String strM12547a = m12547a(str);
        a aVar = f13788d;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        aVar.mo12556c(strM12547a, str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m12551c(String str, String str2) {
        if (f13788d == null || f13788d.mo12553a() > 2) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        String strM12547a = m12547a(str);
        a aVar = f13788d;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        aVar.mo12554a(strM12547a, str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m12552d(String str, String str2) {
        if (f13788d == null || f13788d.mo12553a() > 1) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        String strM12547a = m12547a(str);
        a aVar = f13788d;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        aVar.mo12555b(strM12547a, str2);
    }
}
