package p000;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p000.anb;
import p000.ane;

/* JADX INFO: renamed from: sm */
/* JADX INFO: compiled from: UploadInfoCollector.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2110sm {

    /* JADX INFO: renamed from: a */
    private static ExecutorService f12650a;

    /* JADX INFO: renamed from: b */
    private static anb f12651b;

    /* JADX INFO: renamed from: c */
    private static C2110sm f12652c;

    /* JADX INFO: renamed from: d */
    private final String f12653d;

    /* JADX INFO: renamed from: e */
    private final String f12654e;

    /* JADX INFO: renamed from: f */
    private File f12655f = null;

    /* JADX INFO: renamed from: g */
    private long f12656g;

    /* JADX INFO: renamed from: sm$a */
    /* JADX INFO: compiled from: UploadInfoCollector.java */
    public static abstract class a {
        /* JADX INFO: renamed from: a */
        public abstract String mo11552a();
    }

    private C2110sm(String str, String str2) {
        this.f12654e = str;
        this.f12653d = str2;
        try {
            m11550c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static C2110sm m11538a() {
        if (f12652c == null) {
            f12652c = new C2110sm("_qiniu_record_file_hs5z9lo7anx03", "https://uplog.qbox.me/log/3");
        }
        return f12652c;
    }

    /* JADX INFO: renamed from: a */
    public static void m11545a(C2137tm c2137tm, a aVar) {
        try {
            if (C2109sl.f12644a) {
                m11538a().m11551c(c2137tm, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11548b(C2137tm c2137tm, a aVar) {
        m11545a(c2137tm, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m11540a(java.io.File r2, java.lang.String r3, boolean r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L31
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L31
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e java.io.FileNotFoundException -> L21
            byte[] r2 = r3.getBytes(r2)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e java.io.FileNotFoundException -> L21
            r1.write(r2)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e java.io.FileNotFoundException -> L21
            r1.flush()     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e java.io.FileNotFoundException -> L21
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L38
            goto L38
        L1c:
            r2 = move-exception
            goto L39
        L1e:
            r2 = move-exception
            r0 = r1
            goto L28
        L21:
            r2 = move-exception
            r0 = r1
            goto L32
        L24:
            r2 = move-exception
            r1 = r0
            goto L39
        L27:
            r2 = move-exception
        L28:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L38
        L2d:
            r0.close()     // Catch: java.io.IOException -> L38
            goto L38
        L31:
            r2 = move-exception
        L32:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L38
            goto L2d
        L38:
            return
        L39:
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.io.IOException -> L3e
        L3e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2110sm.m11540a(java.io.File, java.lang.String, boolean):void");
    }

    /* JADX INFO: renamed from: b */
    private static anb m11547b() {
        if (f12651b == null) {
            anb.C0214a c0214a = new anb.C0214a();
            c0214a.m2165a(10L, TimeUnit.SECONDS);
            c0214a.m2170b(15L, TimeUnit.SECONDS);
            c0214a.m2172c((((C2109sl.f12649f / 2) + 1) * 60) - 10, TimeUnit.SECONDS);
            f12651b = c0214a.m2171b();
        }
        return f12651b;
    }

    /* JADX INFO: renamed from: c */
    private void m11550c() throws IOException {
        if (C2109sl.f12644a) {
            m11539a(m11536a(C2109sl.f12646c));
        }
        if (!C2109sl.f12644a && f12650a != null) {
            f12650a.shutdown();
        }
        if (C2109sl.f12644a) {
            if (f12650a == null || f12650a.isShutdown()) {
                f12650a = Executors.newSingleThreadExecutor();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private File m11536a(String str) {
        return new File(str);
    }

    /* JADX INFO: renamed from: a */
    private void m11539a(File file) throws IOException {
        if (file == null) {
            throw new IOException("record's dir is not setted");
        }
        if (!file.exists()) {
            if (file.mkdirs()) {
                return;
            }
            throw new IOException("mkdir failed: " + file.getAbsolutePath());
        }
        if (!file.isDirectory()) {
            throw new IOException(file.getAbsolutePath() + " is not a dir");
        }
        this.f12655f = new File(file, this.f12654e);
    }

    /* JADX INFO: renamed from: c */
    private void m11551c(final C2137tm c2137tm, final a aVar) {
        if (f12650a == null || f12650a.isShutdown()) {
            return;
        }
        f12650a.submit(new Runnable() { // from class: sm.1
            @Override // java.lang.Runnable
            public void run() {
                if (C2109sl.f12644a) {
                    try {
                        C2110sm.this.m11541a(aVar.mo11552a(), C2110sm.this.f12655f);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        if (!C2109sl.f12645b || c2137tm == C2137tm.f12827a) {
            return;
        }
        f12650a.submit(new Runnable() { // from class: sm.2
            @Override // java.lang.Runnable
            public void run() {
                if (C2109sl.f12644a && C2109sl.f12645b) {
                    try {
                        C2110sm.this.m11544a(c2137tm, C2110sm.this.f12655f);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11541a(String str, File file) throws Throwable {
        if (!C2109sl.f12644a || file.length() >= C2109sl.f12647d) {
            return;
        }
        m11540a(file, str + "\n", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11544a(C2137tm c2137tm, File file) throws Throwable {
        if (!C2109sl.f12645b || file.length() <= C2109sl.f12648e) {
            return;
        }
        long time = new Date().getTime();
        if (time > this.f12656g + ((long) (C2109sl.f12649f * 60 * 1000))) {
            this.f12656g = time;
            if (m11549b(c2137tm, file)) {
                m11540a(file, "", false);
                m11540a(file, "", false);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m11549b(C2137tm c2137tm, File file) {
        try {
            ang angVarMo1966b = m11547b().m2130a(new ane.C0666a().m4435a(this.f12653d).m4439b("Authorization", "UpToken " + c2137tm.f12828b).m4439b("User-Agent", C2127tc.m11630a().m11634b(c2137tm.f12829c)).m4432a(anf.m4441a(ana.m2123b("text/plain"), file)).m4440b()).mo1966b();
            try {
                return m11546a(angVarMo1966b);
            } finally {
                try {
                    angVarMo1966b.m4455f().close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m11546a(ang angVar) {
        return angVar.m4452c() && angVar.m4449a("X-Reqid") != null;
    }
}
