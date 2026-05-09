package com.mob.tools.log;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class NLog {
    private static HashMap<String, NLog> loggers = new HashMap<>();
    private static LogPrinter printer = new LogPrinter();

    protected abstract String getSDKTag();

    static {
        MobUncaughtExceptionHandler.register();
    }

    public NLog() {
        loggers.put(getSDKTag(), this);
        if (loggers.size() == 1) {
            loggers.put("__FIRST__", this);
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            printer.setContext(context);
            NativeErrorHandler.prepare(context);
        }
    }

    public static void setCollector(String str, LogCollector logCollector) {
        printer.setCollector(str, logCollector);
    }

    protected static final NLog getInstanceForSDK(final String str, boolean z) {
        NLog nLog = loggers.get(str);
        if (nLog == null) {
            nLog = loggers.get("__FIRST__");
        }
        return (nLog == null && z) ? new NLog() { // from class: com.mob.tools.log.NLog.1
            @Override // com.mob.tools.log.NLog
            protected String getSDKTag() {
                return str;
            }
        } : nLog;
    }

    /* JADX INFO: renamed from: v */
    public final int m8619v(Throwable th) {
        return printer.println(getSDKTag(), 2, 0, getStackTraceString(th));
    }

    /* JADX INFO: renamed from: v */
    public final int m8618v(Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return printer.println(getSDKTag(), 2, 0, string);
    }

    /* JADX INFO: renamed from: v */
    public final int m8620v(Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return printer.println(getSDKTag(), 2, 0, sb.toString());
    }

    /* JADX INFO: renamed from: d */
    public final int m8610d(Throwable th) {
        return printer.println(getSDKTag(), 3, 0, getStackTraceString(th));
    }

    /* JADX INFO: renamed from: d */
    public final int m8609d(Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return printer.println(getSDKTag(), 3, 0, string);
    }

    /* JADX INFO: renamed from: d */
    public final int m8611d(Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return printer.println(getSDKTag(), 3, 0, sb.toString());
    }

    /* JADX INFO: renamed from: i */
    public final int m8616i(Throwable th) {
        return printer.println(getSDKTag(), 4, 0, getStackTraceString(th));
    }

    /* JADX INFO: renamed from: i */
    public final int m8615i(Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return printer.println(getSDKTag(), 4, 0, string);
    }

    /* JADX INFO: renamed from: i */
    public final int m8617i(Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return printer.println(getSDKTag(), 4, 0, sb.toString());
    }

    /* JADX INFO: renamed from: w */
    public final int m8622w(Throwable th) {
        return printer.println(getSDKTag(), 5, 0, getStackTraceString(th));
    }

    /* JADX INFO: renamed from: w */
    public final int m8621w(Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return printer.println(getSDKTag(), 5, 0, string);
    }

    /* JADX INFO: renamed from: w */
    public final int m8623w(Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return printer.println(getSDKTag(), 5, 0, sb.toString());
    }

    /* JADX INFO: renamed from: e */
    public final int m8613e(Throwable th) {
        return printer.println(getSDKTag(), 6, 0, getStackTraceString(th));
    }

    /* JADX INFO: renamed from: e */
    public final int m8612e(Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return printer.println(getSDKTag(), 6, 0, string);
    }

    /* JADX INFO: renamed from: e */
    public final int m8614e(Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return printer.println(getSDKTag(), 6, 0, sb.toString());
    }

    public final int crash(Throwable th) {
        return printer.println(getSDKTag(), 6, 1, getStackTraceString(th));
    }

    public final void nativeCrashLog(String str) {
        printer.nativeCrashLog(getSDKTag(), str);
    }

    private final String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
