package com.lidroid.xutils.http.client.util;

import android.text.TextUtils;
import com.lidroid.xutils.util.LogUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes.dex */
public class URIBuilder {
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String str) {
        try {
            digestURI(new URI(str));
        } catch (URISyntaxException e) {
            LogUtils.m8420e(e.getMessage(), e);
        }
    }

    public URIBuilder(URI uri) {
        digestURI(uri);
    }

    private void digestURI(URI uri) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        this.encodedPath = uri.getRawPath();
        this.path = uri.getPath();
        this.encodedQuery = uri.getRawQuery();
        this.queryParams = parseQuery(uri.getRawQuery());
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
    }

    private List<NameValuePair> parseQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return URLEncodedUtils.parse(str);
    }

    public URI build(Charset charset) {
        return new URI(buildString(charset));
    }

    private String buildString(Charset charset) {
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(this.scheme);
            sb.append(':');
        }
        if (this.encodedSchemeSpecificPart != null) {
            sb.append(this.encodedSchemeSpecificPart);
        } else {
            if (this.encodedAuthority != null) {
                sb.append("//");
                sb.append(this.encodedAuthority);
            } else if (this.host != null) {
                sb.append("//");
                if (this.encodedUserInfo != null) {
                    sb.append(this.encodedUserInfo);
                    sb.append("@");
                } else if (this.userInfo != null) {
                    sb.append(encodeUserInfo(this.userInfo, charset));
                    sb.append("@");
                }
                if (InetAddressUtils.isIPv6Address(this.host)) {
                    sb.append("[");
                    sb.append(this.host);
                    sb.append("]");
                } else {
                    sb.append(this.host);
                }
                if (this.port >= 0) {
                    sb.append(":");
                    sb.append(this.port);
                }
            }
            if (this.encodedPath != null) {
                sb.append(normalizePath(this.encodedPath));
            } else if (this.path != null) {
                sb.append(encodePath(normalizePath(this.path), charset));
            }
            if (this.encodedQuery != null) {
                sb.append("?");
                sb.append(this.encodedQuery);
            } else if (this.queryParams != null) {
                sb.append("?");
                sb.append(encodeQuery(this.queryParams, charset));
            }
        }
        if (this.encodedFragment != null) {
            sb.append("#");
            sb.append(this.encodedFragment);
        } else if (this.fragment != null) {
            sb.append("#");
            sb.append(encodeFragment(this.fragment, charset));
        }
        return sb.toString();
    }

    private String encodeUserInfo(String str, Charset charset) {
        return URLEncodedUtils.encUserInfo(str, charset);
    }

    private String encodePath(String str, Charset charset) {
        return URLEncodedUtils.encPath(str, charset).replace("+", "20%");
    }

    private String encodeQuery(List<NameValuePair> list, Charset charset) {
        return URLEncodedUtils.format(list, charset);
    }

    private String encodeFragment(String str, Charset charset) {
        return URLEncodedUtils.encFragment(str, charset);
    }

    public URIBuilder setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(String.valueOf(str) + ':' + str2);
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        this.path = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder setQuery(String str) {
        this.queryParams = parseQuery(str);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder addParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator<NameValuePair> it = this.queryParams.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    it.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setFragment(String str) {
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPath() {
        return this.path;
    }

    public List<NameValuePair> getQueryParams() {
        if (this.queryParams != null) {
            return new ArrayList(this.queryParams);
        }
        return new ArrayList();
    }

    public String getFragment() {
        return this.fragment;
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }
}
