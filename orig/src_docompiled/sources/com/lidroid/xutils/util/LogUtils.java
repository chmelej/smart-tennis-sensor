package com.lidroid.xutils.util;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    public static boolean allowD = true;
    public static boolean allowE = true;
    public static boolean allowI = true;
    public static boolean allowV = true;
    public static boolean allowW = true;
    public static boolean allowWtf = true;
    public static CustomLogger customLogger = null;
    public static String customTagPrefix = "";

    public interface CustomLogger {
        /* JADX INFO: renamed from: d */
        void m8428d(String str, String str2);

        /* JADX INFO: renamed from: d */
        void m8429d(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: e */
        void m8430e(String str, String str2);

        /* JADX INFO: renamed from: e */
        void m8431e(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: i */
        void m8432i(String str, String str2);

        /* JADX INFO: renamed from: i */
        void m8433i(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: v */
        void m8434v(String str, String str2);

        /* JADX INFO: renamed from: v */
        void m8435v(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: w */
        void m8436w(String str, String str2);

        /* JADX INFO: renamed from: w */
        void m8437w(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: w */
        void m8438w(String str, Throwable th);

        void wtf(String str, String str2);

        void wtf(String str, String str2, Throwable th);

        void wtf(String str, Throwable th);
    }

    private LogUtils() {
    }

    private static String generateTag(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String str = String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        if (TextUtils.isEmpty(customTagPrefix)) {
            return str;
        }
        return String.valueOf(customTagPrefix) + ":" + str;
    }

    /* JADX INFO: renamed from: d */
    public static void m8417d(String str) {
        if (allowD) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8428d(strGenerateTag, str);
            } else {
                Log.d(strGenerateTag, str);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m8418d(String str, Throwable th) {
        if (allowD) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8429d(strGenerateTag, str, th);
            } else {
                Log.d(strGenerateTag, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m8419e(String str) {
        if (allowE) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8430e(strGenerateTag, str);
            } else {
                Log.e(strGenerateTag, str);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m8420e(String str, Throwable th) {
        if (allowE) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8431e(strGenerateTag, str, th);
            } else {
                Log.e(strGenerateTag, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m8421i(String str) {
        if (allowI) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8432i(strGenerateTag, str);
            } else {
                Log.i(strGenerateTag, str);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m8422i(String str, Throwable th) {
        if (allowI) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8433i(strGenerateTag, str, th);
            } else {
                Log.i(strGenerateTag, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m8423v(String str) {
        if (allowV) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8434v(strGenerateTag, str);
            } else {
                Log.v(strGenerateTag, str);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m8424v(String str, Throwable th) {
        if (allowV) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8435v(strGenerateTag, str, th);
            } else {
                Log.v(strGenerateTag, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m8425w(String str) {
        if (allowW) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8436w(strGenerateTag, str);
            } else {
                Log.w(strGenerateTag, str);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m8426w(String str, Throwable th) {
        if (allowW) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8437w(strGenerateTag, str, th);
            } else {
                Log.w(strGenerateTag, str, th);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m8427w(Throwable th) {
        if (allowW) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.m8438w(strGenerateTag, th);
            } else {
                Log.w(strGenerateTag, th);
            }
        }
    }

    public static void wtf(String str) {
        if (allowWtf) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.wtf(strGenerateTag, str);
            } else {
                Log.wtf(strGenerateTag, str);
            }
        }
    }

    public static void wtf(String str, Throwable th) {
        if (allowWtf) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.wtf(strGenerateTag, str, th);
            } else {
                Log.wtf(strGenerateTag, str, th);
            }
        }
    }

    public static void wtf(Throwable th) {
        if (allowWtf) {
            String strGenerateTag = generateTag(OtherUtils.getCallerStackTraceElement());
            if (customLogger != null) {
                customLogger.wtf(strGenerateTag, th);
            } else {
                Log.wtf(strGenerateTag, th);
            }
        }
    }
}
