package com.mob.tools.log;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LogPrinter {
    private HashMap<String, LogCollector> collectors = new HashMap<>();
    private String packageName = "";
    private String scope = "";

    public void setContext(Context context) {
        this.packageName = context.getPackageName();
        if (TextUtils.isEmpty(this.packageName)) {
            this.packageName = "";
        } else {
            this.scope = this.packageName;
        }
    }

    public void setCollector(String str, LogCollector logCollector) {
        this.collectors.put(str, logCollector);
    }

    public int println(String str, int i, int i2, String str2) {
        Thread threadCurrentThread = Thread.currentThread();
        String strProcessMessage = processMessage(threadCurrentThread, str2);
        String scope = getScope(threadCurrentThread);
        LogCollector logCollector = this.collectors.get(str);
        if (logCollector == null) {
            return 0;
        }
        logCollector.log(str, i, i2, scope, strProcessMessage);
        return 0;
    }

    public void nativeCrashLog(String str, String str2) {
        LogCollector logCollector = this.collectors.get(str);
        if (logCollector != null) {
            logCollector.log(str, 6, 2, this.scope, str2);
        }
    }

    private String processMessage(Thread thread, String str) {
        return String.format("%s %s", thread.getName(), str);
    }

    private String getScope(Thread thread) {
        String className;
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
            String fileName = stackTraceElement.getFileName();
            if (fileName == null || fileName.length() <= 0) {
                className = stackTraceElement.getClassName();
            } else {
                className = this.scope + "/" + fileName;
            }
            int lineNumber = stackTraceElement.getLineNumber();
            String strValueOf = String.valueOf(lineNumber);
            if (lineNumber < 0 && ((strValueOf = stackTraceElement.getMethodName()) == null || strValueOf.length() <= 0)) {
                strValueOf = "Unknown Source";
            }
            return className + "(" + strValueOf + ")";
        }
        return this.scope;
    }
}
