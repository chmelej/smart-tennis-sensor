package p000;

import android.content.Context;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: AsyncHttpRequest.java */
/* JADX INFO: loaded from: classes.dex */
class aqi implements Runnable {

    /* JADX INFO: renamed from: a */
    private final AbstractHttpClient f4648a;

    /* JADX INFO: renamed from: b */
    private final HttpContext f4649b;

    /* JADX INFO: renamed from: c */
    private final HttpUriRequest f4650c;

    /* JADX INFO: renamed from: d */
    private final aqe f4651d;

    /* JADX INFO: renamed from: e */
    private volatile boolean f4652e;

    /* JADX INFO: renamed from: f */
    private Context f4653f;

    public aqi(Context context, AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpHost httpHost, HttpUriRequest httpUriRequest, aqe aqeVar) {
        this.f4648a = abstractHttpClient;
        this.f4649b = httpContext;
        this.f4653f = context;
        this.f4650c = httpUriRequest;
        this.f4651d = aqeVar;
        if (httpHost != null) {
            abstractHttpClient.getParams().setParameter("http.route.default-proxy", httpHost);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f4651d != null) {
                this.f4651d.m4999a();
            }
            if (!ahp.m1237a(this.f4653f)) {
                this.f4651d.m5002a((Throwable) new RuntimeException("http request network connection error[" + this.f4650c.getURI().toString() + "]"));
            } else {
                m5022b();
            }
            if (this.f4651d != null) {
                this.f4651d.m5005b();
            }
        } catch (IOException e) {
            aiv.m1421d("AsyncHttp.request", "http request io", e);
            if (this.f4651d != null) {
                this.f4651d.m5005b();
                if (this.f4652e) {
                    this.f4651d.m5002a((Throwable) e);
                } else {
                    this.f4651d.m5002a((Throwable) e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m5021a() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        HttpResponse httpResponseExecute = this.f4648a.execute(this.f4650c, this.f4649b);
        aiv.m1415b("AsyncHttp.request", "http request:[" + this.f4650c.getURI().toString() + "]===response[:" + httpResponseExecute.getStatusLine().getStatusCode() + "]");
        if (Thread.currentThread().isInterrupted() || this.f4651d == null) {
            return;
        }
        this.f4651d.m5004a(httpResponseExecute);
    }

    /* JADX INFO: renamed from: b */
    private void m5022b() {
        while (true) {
            try {
                m5021a();
                return;
            } catch (IOException e) {
                aiv.m1421d("AsyncHttp.request", "http request makeRequestWithRetries", e);
            } catch (NullPointerException e2) {
                aiv.m1421d("AsyncHttp.request", "", e2);
                new IOException("NPE in HttpClient" + e2.getMessage());
            }
        }
    }
}
