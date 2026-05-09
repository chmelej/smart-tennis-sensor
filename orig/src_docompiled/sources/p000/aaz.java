package p000;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
final class aaz extends DefaultConnectionKeepAliveStrategy {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ aay f87a;

    aaz(aay aayVar) {
        this.f87a = aayVar;
    }

    @Override // org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy, org.apache.http.conn.ConnectionKeepAliveStrategy
    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        if (keepAliveDuration == -1) {
            return 30000L;
        }
        return keepAliveDuration;
    }
}
