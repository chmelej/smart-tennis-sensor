package p000;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;

/* JADX INFO: compiled from: MLog.java */
/* JADX INFO: loaded from: classes.dex */
public class aex {

    /* JADX INFO: renamed from: a */
    public static boolean f711a = false;

    /* JADX INFO: renamed from: b */
    private static String f712b = "MobclickAgent";

    /* JADX INFO: renamed from: c */
    private static int f713c = 2000;

    /* JADX INFO: renamed from: a */
    public static void m771a(String str, Object... objArr) throws Throwable {
        try {
            if (str.contains("%")) {
                m777c(f712b, new Formatter().format(str, objArr).toString(), null);
            } else {
                m777c(str, objArr != null ? (String) objArr[0] : "", null);
            }
        } catch (Throwable th) {
            m772a(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m772a(Throwable th) throws Throwable {
        m777c(f712b, null, th);
    }

    /* JADX INFO: renamed from: a */
    public static void m770a(String str, Throwable th) throws Throwable {
        m777c(f712b, str, th);
    }

    /* JADX INFO: renamed from: a */
    public static void m768a(String str) throws Throwable {
        m769a(f712b, str, null);
    }

    /* JADX INFO: renamed from: b */
    public static void m774b(String str) throws Throwable {
        m775b(f712b, str, null);
    }

    /* JADX INFO: renamed from: c */
    public static void m776c(String str) throws Throwable {
        m777c(f712b, str, null);
    }

    /* JADX INFO: renamed from: a */
    public static void m769a(String str, String str2, Throwable th) throws Throwable {
        if (f711a) {
            m767a(2, str, str2, th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m775b(String str, String str2, Throwable th) throws Throwable {
        if (f711a) {
            m767a(3, str, str2, th);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m777c(String str, String str2, Throwable th) throws Throwable {
        if (f711a) {
            m767a(5, str, str2, th);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m767a(int i, String str, String str2, Throwable th) throws Throwable {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = f713c;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 < 100) {
                    if (length > i2) {
                        switch (i) {
                            case 1:
                                Log.v(str, str2.substring(i4, i2));
                                break;
                            case 2:
                                Log.d(str, str2.substring(i4, i2));
                                break;
                            case 3:
                                Log.i(str, str2.substring(i4, i2));
                                break;
                            case 4:
                                Log.w(str, str2.substring(i4, i2));
                                break;
                            case 5:
                                Log.e(str, str2.substring(i4, i2));
                                break;
                        }
                        i3++;
                        i4 = i2;
                        i2 = f713c + i2;
                    } else {
                        switch (i) {
                            case 1:
                                Log.v(str, str2.substring(i4, length));
                                break;
                            case 2:
                                Log.d(str, str2.substring(i4, length));
                                break;
                            case 3:
                                Log.i(str, str2.substring(i4, length));
                                break;
                            case 4:
                                Log.w(str, str2.substring(i4, length));
                                break;
                            case 5:
                                Log.e(str, str2.substring(i4, length));
                                break;
                        }
                    }
                }
            }
        }
        if (th != null) {
            String strM773b = m773b(th);
            if (TextUtils.isEmpty(strM773b)) {
                return;
            }
            switch (i) {
                case 1:
                    Log.v(str, strM773b);
                    break;
                case 2:
                    Log.d(str, strM773b);
                    break;
                case 3:
                    Log.i(str, strM773b);
                    break;
                case 4:
                    Log.w(str, strM773b);
                    break;
                case 5:
                    Log.e(str, strM773b);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m773b(Throwable th) throws Throwable {
        StringWriter stringWriter;
        PrintWriter printWriter;
        PrintWriter printWriter2 = null;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                th.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                String string = stringWriter.toString();
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable unused) {
                    }
                }
                if (printWriter == null) {
                    return string;
                }
                printWriter.close();
                return string;
            } catch (Throwable unused2) {
                printWriter2 = printWriter;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                return "";
            }
        } catch (Throwable unused4) {
            stringWriter = null;
        }
    }
}
