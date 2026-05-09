package com.mob.tools.network;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface HttpConnection {
    InputStream getErrorStream();

    Map<String, List<String>> getHeaderFields();

    InputStream getInputStream();

    int getResponseCode();
}
