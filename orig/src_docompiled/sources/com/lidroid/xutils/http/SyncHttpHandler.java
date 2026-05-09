package com.lidroid.xutils.http;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.callback.DefaultHttpRedirectHandler;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import java.io.IOException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public class SyncHttpHandler {
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private HttpRedirectHandler httpRedirectHandler;
    private String requestMethod;
    private String requestUrl;
    private int retriedTimes = 0;
    private long expiry = HttpCache.getDefaultExpiryTime();

    public void setHttpRedirectHandler(HttpRedirectHandler httpRedirectHandler) {
        this.httpRedirectHandler = httpRedirectHandler;
    }

    public SyncHttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.charset = str;
    }

    public void setExpiry(long j) {
        this.expiry = j;
    }

    public ResponseStream sendRequest(HttpRequestBase httpRequestBase) throws HttpException {
        IOException iOException;
        boolean zRetryRequest;
        String str;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        do {
            try {
                this.requestUrl = httpRequestBase.getURI().toString();
                this.requestMethod = httpRequestBase.getMethod();
                if (HttpUtils.sHttpCache.isEnabled(this.requestMethod) && (str = HttpUtils.sHttpCache.get(this.requestUrl)) != null) {
                    return new ResponseStream(str);
                }
                return handleResponse(this.client.execute(httpRequestBase, this.context));
            } catch (HttpException e) {
                throw e;
            } catch (NullPointerException e2) {
                iOException = new IOException(e2.getMessage());
                iOException.initCause(e2);
                int i = this.retriedTimes + 1;
                this.retriedTimes = i;
                zRetryRequest = httpRequestRetryHandler.retryRequest(iOException, i, this.context);
            } catch (UnknownHostException e3) {
                iOException = e3;
                int i2 = this.retriedTimes + 1;
                this.retriedTimes = i2;
                zRetryRequest = httpRequestRetryHandler.retryRequest(iOException, i2, this.context);
            } catch (IOException e4) {
                iOException = e4;
                int i3 = this.retriedTimes + 1;
                this.retriedTimes = i3;
                zRetryRequest = httpRequestRetryHandler.retryRequest(iOException, i3, this.context);
            } catch (Throwable th) {
                iOException = new IOException(th.getMessage());
                iOException.initCause(th);
                int i4 = this.retriedTimes + 1;
                this.retriedTimes = i4;
                zRetryRequest = httpRequestRetryHandler.retryRequest(iOException, i4, this.context);
            }
        } while (zRetryRequest);
        throw new HttpException(iOException);
    }

    private ResponseStream handleResponse(HttpResponse httpResponse) throws HttpException {
        if (httpResponse == null) {
            throw new HttpException("response is null");
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode < 300) {
            ResponseStream responseStream = new ResponseStream(httpResponse, this.charset, this.requestUrl, this.expiry);
            responseStream.setRequestMethod(this.requestMethod);
            return responseStream;
        }
        if (statusCode != 301 && statusCode != 302) {
            if (statusCode == 416) {
                throw new HttpException(statusCode, "maybe the file has downloaded completely");
            }
            throw new HttpException(statusCode, statusLine.getReasonPhrase());
        }
        if (this.httpRedirectHandler == null) {
            this.httpRedirectHandler = new DefaultHttpRedirectHandler();
        }
        HttpRequestBase directRequest = this.httpRedirectHandler.getDirectRequest(httpResponse);
        if (directRequest != null) {
            return sendRequest(directRequest);
        }
        return null;
    }
}
