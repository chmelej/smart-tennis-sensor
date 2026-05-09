package p000;

import android.util.Log;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

/* JADX INFO: compiled from: AbsHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
class aqh {

    /* JADX INFO: renamed from: a */
    private static int f4640a = 10;

    /* JADX INFO: renamed from: b */
    private static int f4641b = 10000;

    /* JADX INFO: renamed from: c */
    private final DefaultHttpClient f4642c;

    /* JADX INFO: renamed from: d */
    private final HttpContext f4643d;

    /* JADX INFO: renamed from: e */
    private final Map<String, String> f4644e;

    public aqh() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, f4641b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(f4640a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f4641b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f4641b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("Agoo-sdk-%s", Double.valueOf(2.0d)));
        this.f4644e = new HashMap();
        this.f4643d = new SyncBasicHttpContext(new BasicHttpContext());
        this.f4642c = new DefaultHttpClient(basicHttpParams);
        this.f4642c.addRequestInterceptor(new HttpRequestInterceptor() { // from class: aqh.1
            @Override // org.apache.http.HttpRequestInterceptor
            public final void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
                for (String str : aqh.this.f4644e.keySet()) {
                    httpRequest.addHeader(str, (String) aqh.this.f4644e.get(str));
                }
            }
        });
        this.f4642c.addResponseInterceptor(new HttpResponseInterceptor() { // from class: aqh.2
            @Override // org.apache.http.HttpResponseInterceptor
            public final void process(HttpResponse httpResponse, HttpContext httpContext) {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
                    return;
                }
                for (HeaderElement headerElement : contentEncoding.getElements()) {
                    if (headerElement.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new C0724a(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        });
        this.f4642c.setRedirectHandler(new RedirectHandler() { // from class: aqh.3
            @Override // org.apache.http.client.RedirectHandler
            public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
                Log.d("httpClient", "getLocationURI[" + m5020a(httpResponse) + "]");
                return null;
            }

            @Override // org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                Log.d("httpClient", "isRedirectRequested[" + m5020a(httpResponse) + "]");
                return false;
            }

            /* JADX INFO: renamed from: a */
            String m5020a(HttpResponse httpResponse) {
                StringBuffer stringBuffer = new StringBuffer();
                Header[] allHeaders = httpResponse.getAllHeaders();
                for (int i = 0; i < allHeaders.length; i++) {
                    stringBuffer.append(allHeaders[i].getName() + "==" + allHeaders[i].getValue());
                }
                return stringBuffer.toString();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final DefaultHttpClient m5018a() {
        return this.f4642c;
    }

    /* JADX INFO: renamed from: b */
    public final HttpContext m5019b() {
        return this.f4643d;
    }

    /* JADX INFO: renamed from: a */
    protected final String m5017a(String str, aqf aqfVar) {
        if (aqfVar == null) {
            return str;
        }
        return str + "?" + aqfVar.m5011a();
    }

    /* JADX INFO: renamed from: aqh$a */
    /* JADX INFO: compiled from: AbsHttpClient.java */
    static final class C0724a extends HttpEntityWrapper {
        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public final long getContentLength() {
            return -1L;
        }

        public C0724a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public final InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }
    }
}
