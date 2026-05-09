package p000;

import android.content.Context;
import com.lidroid.xutils.http.client.multipart.MIME;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: compiled from: AsyncHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class aqd extends aqh {

    /* JADX INFO: renamed from: a */
    private final ThreadPoolExecutor f4627a = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    /* JADX INFO: renamed from: b */
    private final Map<Context, List<WeakReference<Future<?>>>> f4628b = new WeakHashMap();

    /* JADX INFO: renamed from: a */
    public final void m4994a(Context context, String str, aqf aqfVar, aqe aqeVar) {
        m4995a(context, null, str, null, aqfVar, aqeVar);
    }

    /* JADX INFO: renamed from: a */
    public final void m4995a(Context context, HttpHost httpHost, String str, Header[] headerArr, aqf aqfVar, aqe aqeVar) {
        HttpGet httpGet = new HttpGet(m5017a(str, aqfVar));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        m4993a(context, m5018a(), m5019b(), httpHost, httpGet, null, aqeVar);
    }

    /* JADX INFO: renamed from: a */
    private void m4993a(Context context, DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpHost httpHost, HttpUriRequest httpUriRequest, String str, aqe aqeVar) {
        if (str != null) {
            httpUriRequest.addHeader(MIME.CONTENT_TYPE, str);
        }
        Future<?> futureSubmit = this.f4627a.submit(new aqi(context, defaultHttpClient, httpContext, httpHost, httpUriRequest, aqeVar));
        if (context != null) {
            List<WeakReference<Future<?>>> linkedList = this.f4628b.get(context);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f4628b.put(context, linkedList);
            }
            linkedList.add(new WeakReference<>(futureSubmit));
        }
    }
}
