package p000;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: AgooLogger.java */
/* JADX INFO: loaded from: classes.dex */
public final class aix implements aiw {

    /* JADX INFO: renamed from: a */
    private volatile boolean f1203a;

    /* JADX INFO: renamed from: b */
    private volatile boolean f1204b;

    /* JADX INFO: renamed from: c */
    private volatile Logger f1205c;

    public aix() {
        this(false, false);
    }

    public aix(boolean z, boolean z2) throws Throwable {
        this.f1203a = true;
        this.f1204b = false;
        this.f1203a = z;
        this.f1204b = z2;
        if (m1436a()) {
            this.f1203a = true;
            this.f1204b = true;
        }
        m1438b();
    }

    /* JADX INFO: renamed from: a */
    private final boolean m1436a() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.getPath() + "/_agoo_log_bin_");
            Log.v("Agoo", "agoo_logger_path[" + externalStorageDirectory.getPath() + "/_agoo_log_bin_]");
            if (!file.isDirectory()) {
                return false;
            }
            Log.v("Agoo", "agoo_logger_print[true]");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m1438b() throws Throwable {
        if (this.f1204b) {
            String strM1439c = m1439c();
            try {
                FileHandler fileHandler = new FileHandler((Environment.getExternalStorageDirectory().getPath() + File.separator + strM1439c) + "_%g.log", BitmapGlobalConfig.MIN_DISK_CACHE_SIZE, 2, true);
                fileHandler.setFormatter(new C0146a());
                this.f1205c = Logger.getLogger(strM1439c);
                this.f1205c.setLevel(Level.ALL);
                this.f1205c.addHandler(fileHandler);
            } catch (IOException | SecurityException unused) {
            }
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: a */
    public final void mo1425a(String str, Object... objArr) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.INFO, str + ":" + aie.m1308a(objArr));
                } else if (Log.isLoggable(str, 3)) {
                    Log.d(str, aie.m1308a(objArr));
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: a */
    public final void mo1423a(String str, String str2) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.INFO, str + ":" + str2);
                } else {
                    Log.d(str, str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: a */
    public final void mo1424a(String str, String str2, Throwable th) {
        try {
            mo1423a(str, str2 + '\n' + m1437b(th));
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: b */
    public final void mo1426b(String str, String str2) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.INFO, str + ":" + str2);
                } else {
                    Log.i(str, str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: b */
    public final void mo1427b(String str, String str2, Throwable th) {
        try {
            mo1426b(str, str2 + '\n' + m1437b(th));
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: c */
    public final void mo1428c(String str, String str2) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.INFO, str + ":" + str2);
                } else {
                    Log.v(str, str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: d */
    public final void mo1430d(String str, String str2) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.WARNING, str + ":" + str2);
                } else {
                    Log.w(str, str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: c */
    public final void mo1429c(String str, String str2, Throwable th) {
        try {
            mo1430d(str, str2 + '\n' + m1437b(th));
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: e */
    public final void mo1432e(String str, String str2) {
        try {
            if (this.f1203a) {
                if (this.f1204b && this.f1205c != null) {
                    this.f1205c.log(Level.SEVERE, str + ":" + str2);
                } else {
                    Log.e(str, str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aiw
    /* JADX INFO: renamed from: d */
    public final void mo1431d(String str, String str2, Throwable th) {
        try {
            mo1432e(str, str2 + '\n' + m1437b(th));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static String m1437b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: renamed from: c */
    private static String m1439c() throws Throwable {
        String strM1433a = m1433a(Process.myPid());
        if (TextUtils.isEmpty(strM1433a)) {
            strM1433a = "AgooLog";
        }
        return strM1433a.replace(':', '_');
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0075, code lost:
    
        r3 = r2.indexOf("\t");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007b, code lost:
    
        if (r3 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0084, code lost:
    
        r0 = r2.substring(r3 + 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[Catch: IOException -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x00ad, blocks: (B:20:0x0087, B:40:0x00aa), top: B:49:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String m1433a(int r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            r2.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            r2.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r3 = "/cmdline"
            r2.append(r3)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            r3.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            r3.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r5 = "/status"
            r3.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L9f java.lang.Throwable -> La7
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> La8
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> La8
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> La8
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> La8
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            if (r4 != 0) goto L55
            r5 = 0
            int r4 = r1.indexOf(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            java.lang.String r5 = r1.substring(r5, r4)     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            r0 = r5
            r5 = r2
            r1 = r3
            goto L85
        L55:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Throwable -> L9b
            r2.close()     // Catch: java.lang.Throwable -> L93 java.lang.Throwable -> L96
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L93 java.lang.Throwable -> L96
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L93 java.lang.Throwable -> L96
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L93 java.lang.Throwable -> L96
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L93 java.lang.Throwable -> L96
        L67:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Throwable -> L8b java.lang.Throwable -> L90
            if (r2 == 0) goto L85
            java.lang.String r3 = "Name:"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> L8b java.lang.Throwable -> L90
            if (r3 == 0) goto L67
            java.lang.String r3 = "\t"
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Throwable -> L8b java.lang.Throwable -> L90
            if (r3 >= 0) goto L7e
            goto L85
        L7e:
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)     // Catch: java.lang.Throwable -> L8b java.lang.Throwable -> L90
            r0 = r2
        L85:
            if (r5 == 0) goto Lad
            r5.close()     // Catch: java.io.IOException -> Lad
            goto Lad
        L8b:
            r0 = move-exception
            r3 = r1
            r1 = r5
            r5 = r0
            goto La1
        L90:
            r3 = r1
            r1 = r5
            goto La8
        L93:
            r5 = move-exception
            r3 = r1
            goto L99
        L96:
            r3 = r1
            goto L9b
        L98:
            r5 = move-exception
        L99:
            r1 = r2
            goto La1
        L9b:
            r1 = r2
            goto La8
        L9d:
            r5 = move-exception
            goto La1
        L9f:
            r5 = move-exception
            r3 = r1
        La1:
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.io.IOException -> La6
        La6:
            throw r5
        La7:
            r3 = r1
        La8:
            if (r1 == 0) goto Lad
            r1.close()     // Catch: java.io.IOException -> Lad
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.aix.m1433a(int):java.lang.String");
    }

    /* JADX INFO: renamed from: aix$a */
    /* JADX INFO: compiled from: AgooLogger.java */
    static class C0146a extends Formatter {

        /* JADX INFO: renamed from: a */
        private String f1206a;

        private C0146a() {
            this.f1206a = null;
        }

        /* JADX INFO: renamed from: a */
        private void m1440a(LogRecord logRecord) {
            Throwable thrown = logRecord.getThrown();
            if (thrown == null) {
                return;
            }
            this.f1206a = aix.m1437b(thrown);
            StackTraceElement[] stackTrace = thrown.getStackTrace();
            boolean z = false;
            for (int i = 0; i < stackTrace.length; i++) {
                String className = stackTrace[i].getClassName();
                if (className.startsWith(aiv.class.getName())) {
                    z = true;
                } else if (z) {
                    String methodName = stackTrace[i].getMethodName();
                    logRecord.setSourceClassName(className);
                    logRecord.setSourceMethodName(methodName);
                    return;
                }
            }
        }

        @Override // java.util.logging.Formatter
        public final synchronized String format(LogRecord logRecord) {
            StringBuffer stringBuffer;
            m1440a(logRecord);
            stringBuffer = new StringBuffer();
            stringBuffer.append(aix.m1434a(logRecord.getMillis()));
            stringBuffer.append(" ");
            if (logRecord.getSourceClassName() != null) {
                stringBuffer.append(logRecord.getSourceClassName());
            } else {
                stringBuffer.append(logRecord.getLoggerName());
            }
            if (logRecord.getSourceMethodName() != null) {
                stringBuffer.append(" ");
                stringBuffer.append(logRecord.getSourceMethodName());
            }
            stringBuffer.append("[");
            stringBuffer.append(logRecord.getLevel().getLocalizedName());
            stringBuffer.append("]-->");
            stringBuffer.append(formatMessage(logRecord));
            stringBuffer.append("\n");
            if (!TextUtils.isEmpty(this.f1206a)) {
                stringBuffer.append(this.f1206a);
            }
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final String m1434a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
    }
}
