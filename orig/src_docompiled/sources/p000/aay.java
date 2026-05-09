package p000;

import android.content.Context;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* JADX INFO: loaded from: classes.dex */
class aay {

    /* JADX INFO: renamed from: d */
    private static abj f80d = abt.m89c();

    /* JADX INFO: renamed from: e */
    private static aay f81e;

    /* JADX INFO: renamed from: f */
    private static Context f82f;

    /* JADX INFO: renamed from: a */
    DefaultHttpClient f83a;

    /* JADX INFO: renamed from: b */
    abn f84b;

    /* JADX INFO: renamed from: c */
    StringBuilder f85c = new StringBuilder(4096);

    /* JADX INFO: renamed from: g */
    private long f86g;

    private aay(Context context) {
        this.f83a = null;
        this.f84b = null;
        this.f86g = 0L;
        try {
            f82f = context.getApplicationContext();
            this.f86g = System.currentTimeMillis() / 1000;
            this.f84b = new abn();
            if (acb.m166b()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable unused) {
                }
            }
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f83a = new DefaultHttpClient(basicHttpParams);
            this.f83a.setKeepAliveStrategy(new aaz(this));
        } catch (Throwable th) {
            f80d.m54b(th);
        }
    }

    /* JADX INFO: renamed from: a */
    static Context m36a() {
        return f82f;
    }

    /* JADX INFO: renamed from: a */
    static void m37a(Context context) {
        f82f = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: b */
    static aay m38b(Context context) {
        if (f81e == null) {
            synchronized (aay.class) {
                if (f81e == null) {
                    f81e = new aay(context);
                }
            }
        }
        return f81e;
    }

    /* JADX INFO: renamed from: a */
    final void m39a(aai aaiVar, aax aaxVar) {
        m41b(Arrays.asList(aaiVar.m26g()), aaxVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void m40a(java.util.List<?> r12, p000.aax r13) {
        /*
            Method dump skipped, instruction units count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.aay.m40a(java.util.List, aax):void");
    }

    /* JADX INFO: renamed from: b */
    final void m41b(List<?> list, aax aaxVar) {
        if (this.f84b != null) {
            this.f84b.m68a(new aba(this, list, aaxVar));
        }
    }
}
