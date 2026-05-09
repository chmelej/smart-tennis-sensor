package com.lidroid.xutils.http.client;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;

/* JADX INFO: loaded from: classes.dex */
public class RetryHandler implements HttpRequestRetryHandler {
    private static final int RETRY_SLEEP_INTERVAL = 500;
    private final int maxRetries;
    private static HashSet<Class<?>> exceptionWhiteList = new HashSet<>();
    private static HashSet<Class<?>> exceptionBlackList = new HashSet<>();

    static {
        exceptionWhiteList.add(NoHttpResponseException.class);
        exceptionWhiteList.add(UnknownHostException.class);
        exceptionWhiteList.add(SocketException.class);
        exceptionBlackList.add(InterruptedIOException.class);
        exceptionBlackList.add(SSLHandshakeException.class);
    }

    public RetryHandler(int i) {
        this.maxRetries = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    @Override // org.apache.http.client.HttpRequestRetryHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean retryRequest(java.io.IOException r5, int r6, org.apache.http.protocol.HttpContext r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L78
            if (r7 != 0) goto L7
            goto L78
        L7:
            java.lang.String r1 = "http.request_sent"
            java.lang.Object r1 = r7.getAttribute(r1)
            if (r1 != 0) goto L11
            r1 = 0
            goto L17
        L11:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
        L17:
            int r2 = r4.maxRetries
            r3 = 1
            if (r6 <= r2) goto L1e
        L1c:
            r3 = 0
            goto L35
        L1e:
            java.util.HashSet<java.lang.Class<?>> r6 = com.lidroid.xutils.http.client.RetryHandler.exceptionBlackList
            java.lang.Class r2 = r5.getClass()
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L2b
            goto L1c
        L2b:
            java.util.HashSet<java.lang.Class<?>> r6 = com.lidroid.xutils.http.client.RetryHandler.exceptionWhiteList
            java.lang.Class r5 = r5.getClass()
            boolean r5 = r6.contains(r5)
        L35:
            if (r3 == 0) goto L6f
            java.lang.String r5 = "http.request"
            java.lang.Object r5 = r7.getAttribute(r5)     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L61
            boolean r6 = r5 instanceof org.apache.http.client.methods.HttpRequestBase     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L50
            org.apache.http.client.methods.HttpRequestBase r5 = (org.apache.http.client.methods.HttpRequestBase) r5     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "GET"
            java.lang.String r5 = r5.getMethod()     // Catch: java.lang.Throwable -> L67
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L67
            goto L70
        L50:
            boolean r6 = r5 instanceof org.apache.http.impl.client.RequestWrapper     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L6f
            org.apache.http.impl.client.RequestWrapper r5 = (org.apache.http.impl.client.RequestWrapper) r5     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "GET"
            java.lang.String r5 = r5.getMethod()     // Catch: java.lang.Throwable -> L67
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L67
            goto L70
        L61:
            java.lang.String r5 = "retry error, curr request is null"
            com.lidroid.xutils.util.LogUtils.m8419e(r5)     // Catch: java.lang.Throwable -> L67
            goto L6d
        L67:
            r5 = move-exception
            java.lang.String r6 = "retry error"
            com.lidroid.xutils.util.LogUtils.m8420e(r6, r5)
        L6d:
            r5 = 0
            goto L70
        L6f:
            r5 = r3
        L70:
            if (r5 == 0) goto L77
            r6 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r6)
        L77:
            return r5
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.RetryHandler.retryRequest(java.io.IOException, int, org.apache.http.protocol.HttpContext):boolean");
    }
}
