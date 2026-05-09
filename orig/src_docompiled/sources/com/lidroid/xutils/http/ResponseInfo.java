package com.lidroid.xutils.http;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/* JADX INFO: loaded from: classes.dex */
public final class ResponseInfo<T> {
    public final Header contentEncoding;
    public final long contentLength;
    public final Header contentType;
    public final Locale locale;
    public final ProtocolVersion protocolVersion;
    public final String reasonPhrase;
    private final HttpResponse response;
    public T result;
    public final boolean resultFormCache;
    public final int statusCode;

    public Header[] getAllHeaders() {
        if (this.response == null) {
            return null;
        }
        return this.response.getAllHeaders();
    }

    public Header[] getHeaders(String str) {
        if (this.response == null) {
            return null;
        }
        return this.response.getHeaders(str);
    }

    public Header getFirstHeader(String str) {
        if (this.response == null) {
            return null;
        }
        return this.response.getFirstHeader(str);
    }

    public Header getLastHeader(String str) {
        if (this.response == null) {
            return null;
        }
        return this.response.getLastHeader(str);
    }

    public ResponseInfo(HttpResponse httpResponse, T t, boolean z) {
        this.response = httpResponse;
        this.result = t;
        this.resultFormCache = z;
        if (httpResponse != null) {
            this.locale = httpResponse.getLocale();
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine != null) {
                this.statusCode = statusLine.getStatusCode();
                this.protocolVersion = statusLine.getProtocolVersion();
                this.reasonPhrase = statusLine.getReasonPhrase();
            } else {
                this.statusCode = 0;
                this.protocolVersion = null;
                this.reasonPhrase = null;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                this.contentLength = entity.getContentLength();
                this.contentType = entity.getContentType();
                this.contentEncoding = entity.getContentEncoding();
                return;
            } else {
                this.contentLength = 0L;
                this.contentType = null;
                this.contentEncoding = null;
                return;
            }
        }
        this.locale = null;
        this.statusCode = 0;
        this.protocolVersion = null;
        this.reasonPhrase = null;
        this.contentLength = 0L;
        this.contentType = null;
        this.contentEncoding = null;
    }
}
