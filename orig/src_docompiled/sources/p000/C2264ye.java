package p000;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p000.InterfaceC2243xk;

/* JADX INFO: renamed from: ye */
/* JADX INFO: compiled from: UrlConnectionDownloader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2264ye implements InterfaceC2243xk {

    /* JADX INFO: renamed from: a */
    static volatile Object f13689a;

    /* JADX INFO: renamed from: b */
    private static final Object f13690b = new Object();

    /* JADX INFO: renamed from: c */
    private static final ThreadLocal<StringBuilder> f13691c = new ThreadLocal<StringBuilder>() { // from class: ye.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    /* JADX INFO: renamed from: d */
    private final Context f13692d;

    public C2264ye(Context context) {
        this.f13692d = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    protected HttpURLConnection m12376a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    @Override // p000.InterfaceC2243xk
    /* JADX INFO: renamed from: a */
    public InterfaceC2243xk.a mo12284a(Uri uri, int i) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            m12375a(this.f13692d);
        }
        HttpURLConnection httpURLConnectionM12376a = m12376a(uri);
        httpURLConnectionM12376a.setUseCaches(true);
        if (i != 0) {
            if (EnumC2250xr.m12300c(i)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = f13691c.get();
                sb.setLength(0);
                if (!EnumC2250xr.m12298a(i)) {
                    sb.append("no-cache");
                }
                if (!EnumC2250xr.m12299b(i)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionM12376a.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionM12376a.getResponseCode();
        if (responseCode >= 300) {
            httpURLConnectionM12376a.disconnect();
            throw new InterfaceC2243xk.b(responseCode + " " + httpURLConnectionM12376a.getResponseMessage(), i, responseCode);
        }
        return new InterfaceC2243xk.a(httpURLConnectionM12376a.getInputStream(), C2265yf.m12395a(httpURLConnectionM12376a.getHeaderField("X-Android-Response-Source")), httpURLConnectionM12376a.getHeaderFieldInt("Content-Length", -1));
    }

    /* JADX INFO: renamed from: a */
    private static void m12375a(Context context) {
        if (f13689a == null) {
            try {
                synchronized (f13690b) {
                    if (f13689a == null) {
                        f13689a = a.m12378a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ye$a */
    /* JADX INFO: compiled from: UrlConnectionDownloader.java */
    static class a {
        /* JADX INFO: renamed from: a */
        static Object m12378a(Context context) {
            File fileM12396b = C2265yf.m12396b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(fileM12396b, C2265yf.m12381a(fileM12396b)) : installed;
        }
    }
}
