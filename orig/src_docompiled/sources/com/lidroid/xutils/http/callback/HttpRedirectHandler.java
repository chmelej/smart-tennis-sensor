package com.lidroid.xutils.http.callback;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

/* JADX INFO: loaded from: classes.dex */
public interface HttpRedirectHandler {
    HttpRequestBase getDirectRequest(HttpResponse httpResponse);
}
