package org.android.spdy;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SpdyRequest {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    private int connectionTimeoutMs;
    private Map<String, String> extHead;
    private String host;
    private String method;
    private int port;
    private RequestPriority priority;
    private String proxyIp;
    private int proxyPort;
    private int requestTimeoutMs;
    private int retryTimes;
    private URL url;

    public SpdyRequest(URL url, String str, int i, String str2, int i2, String str3, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.host = str;
        this.port = i;
        if (str2 != null && i2 != 0) {
            this.proxyIp = str2;
            this.proxyPort = i2;
        }
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    public SpdyRequest(URL url, String str, int i, String str2, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.host = str;
        this.port = i;
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority, int i, int i2) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url, String str) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }

    public void addHeader(String str, String str2) {
        this.extHead.put(str, str2);
    }

    public void addHeaders(Map<String, String> map) {
        this.extHead.putAll(map);
    }

    URL getUrl() {
        return this.url;
    }

    String getMethod() {
        return this.method;
    }

    int getPriority() {
        return this.priority.getPriorityInt();
    }

    private String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.url.getPath());
        if (this.url.getQuery() != null) {
            sb.append("?");
            sb.append(this.url.getQuery());
        }
        if (this.url.getRef() != null) {
            sb.append("#");
            sb.append(this.url.getRef());
        }
        return sb.toString();
    }

    Map<String, String> getHeaders() {
        HashMap map = new HashMap(5);
        map.put(":path", getPath());
        map.put(":method", this.method);
        map.put(":version", "HTTP/1.1");
        map.put(":host", this.url.getAuthority());
        map.put(":scheme", this.url.getProtocol());
        if (this.extHead != null && this.extHead.size() > 0) {
            map.putAll(this.extHead);
        }
        return map;
    }

    String getUrlPath() {
        return this.url.getProtocol() + "://" + this.url.getAuthority() + getPath();
    }

    String getHost() {
        return this.host;
    }

    int getPort() {
        if (this.port < 0) {
            return 80;
        }
        return this.port;
    }

    String getProxyIp() {
        return this.proxyIp;
    }

    int getProxyPort() {
        return this.proxyPort;
    }

    public String getAuthority() {
        return this.host + ":" + Integer.toString(this.port) + "/" + this.proxyIp + ":" + this.proxyPort;
    }

    public int getRequestTimeoutMs() {
        return this.requestTimeoutMs;
    }

    public int getConnectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }
}
