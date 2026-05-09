package p000;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/* JADX INFO: compiled from: SyncHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class aqg extends aqh {

    /* JADX INFO: renamed from: aqg$a */
    /* JADX INFO: compiled from: SyncHttpClient.java */
    public static final class C0720a {

        /* JADX INFO: renamed from: a */
        public int f4637a;

        /* JADX INFO: renamed from: b */
        public Map<String, String> f4638b;

        /* JADX INFO: renamed from: c */
        public String f4639c;
    }

    /* JADX INFO: renamed from: a */
    public final C0720a m5014a(Context context, String str, aqf aqfVar) {
        return m5015a(context, null, str, aqfVar);
    }

    /* JADX INFO: renamed from: a */
    public final C0720a m5015a(Context context, HttpHost httpHost, String str, aqf aqfVar) throws Throwable {
        HttpGet httpGet;
        String string = null;
        try {
            httpGet = new HttpGet(m5017a(str, aqfVar));
            try {
                if (!ahp.m1237a(context)) {
                    aiv.m1418c("SyncHttp.client", "network connection error[" + httpGet.getURI().toString() + "]");
                    throw new RuntimeException("network connection error[" + httpGet.getURI().toString() + "]");
                }
                DefaultHttpClient defaultHttpClientA = m5018a();
                if (httpHost != null) {
                    defaultHttpClientA.getParams().setParameter("http.route.default-proxy", httpHost);
                }
                HttpResponse httpResponseExecute = defaultHttpClientA.execute(httpGet);
                C0720a c0720a = new C0720a();
                StatusLine statusLine = httpResponseExecute.getStatusLine();
                c0720a.f4637a = statusLine.getStatusCode();
                c0720a.f4638b = m5013a(httpResponseExecute.getAllHeaders());
                if (statusLine.getStatusCode() >= 300) {
                    aiv.m1418c("SyncHttp.client", "request url [" + httpGet.getURI().toString() + "]  result code:[" + statusLine.getStatusCode() + "]");
                    return c0720a;
                }
                HttpEntity entity = httpResponseExecute.getEntity();
                if (entity != null) {
                    string = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
                    c0720a.f4639c = string;
                }
                aiv.m1418c("SyncHttp.client", "request url:[" + httpGet.getURI().toString() + "] : result code [" + statusLine.getStatusCode() + "]:[" + string + "]");
                return c0720a;
            } catch (Throwable th) {
                th = th;
                if (httpGet != null) {
                    aiv.m1421d("SyncHttp.client", "request url error:[" + httpGet.getURI().toString() + "]", th);
                } else {
                    aiv.m1421d("SyncHttp.client", "request url error:[" + str + "]", th);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpGet = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private final Map<String, String> m5013a(Header[] headerArr) {
        HashMap map = new HashMap();
        for (Header header : headerArr) {
            String name = header.getName();
            if (!TextUtils.isEmpty(name)) {
                String value = header.getValue();
                if (!TextUtils.isEmpty(value)) {
                    map.put(name.toLowerCase(), value);
                }
            }
        }
        return map;
    }
}
