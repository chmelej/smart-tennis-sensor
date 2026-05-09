package p000;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class ain {

    /* JADX INFO: renamed from: a */
    private static final String[] f1179a = new String[0];

    /* JADX INFO: renamed from: b */
    private static InterfaceC0142a f1180b = InterfaceC0142a.f1186a;

    /* JADX INFO: renamed from: c */
    private HttpURLConnection f1181c;

    /* JADX INFO: renamed from: d */
    private final URL f1182d;

    /* JADX INFO: renamed from: e */
    private final String f1183e;

    /* JADX INFO: renamed from: f */
    private String f1184f;

    /* JADX INFO: renamed from: g */
    private int f1185g;

    /* JADX INFO: renamed from: ain$a */
    /* JADX INFO: compiled from: HttpRequest.java */
    public interface InterfaceC0142a {

        /* JADX INFO: renamed from: a */
        public static final InterfaceC0142a f1186a = new InterfaceC0142a() { // from class: ain.a.1
            @Override // p000.ain.InterfaceC0142a
            /* JADX INFO: renamed from: a */
            public HttpURLConnection mo1357a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // p000.ain.InterfaceC0142a
            /* JADX INFO: renamed from: a */
            public HttpURLConnection mo1358a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        /* JADX INFO: renamed from: a */
        HttpURLConnection mo1357a(URL url);

        /* JADX INFO: renamed from: a */
        HttpURLConnection mo1358a(URL url, Proxy proxy);
    }

    /* JADX INFO: renamed from: ain$b */
    /* JADX INFO: compiled from: HttpRequest.java */
    public static class C0143b extends RuntimeException {
        protected C0143b(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* JADX INFO: renamed from: d */
    private Proxy m1352d() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f1184f, this.f1185g));
    }

    /* JADX INFO: renamed from: e */
    private HttpURLConnection m1353e() {
        HttpURLConnection httpURLConnectionMo1357a;
        try {
            if (this.f1184f != null) {
                httpURLConnectionMo1357a = f1180b.mo1358a(this.f1182d, m1352d());
            } else {
                httpURLConnectionMo1357a = f1180b.mo1357a(this.f1182d);
            }
            httpURLConnectionMo1357a.setRequestMethod(this.f1183e);
            return httpURLConnectionMo1357a;
        } catch (IOException e) {
            throw new C0143b(e);
        }
    }

    public String toString() {
        return m1356c() + ' ' + m1355b();
    }

    /* JADX INFO: renamed from: a */
    public HttpURLConnection m1354a() {
        if (this.f1181c == null) {
            this.f1181c = m1353e();
        }
        return this.f1181c;
    }

    /* JADX INFO: renamed from: b */
    public URL m1355b() {
        return m1354a().getURL();
    }

    /* JADX INFO: renamed from: c */
    public String m1356c() {
        return m1354a().getRequestMethod();
    }
}
