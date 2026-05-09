package com.lidroid.xutils.http.client.multipart.content;

/* JADX INFO: loaded from: classes.dex */
public interface ContentDescriptor {
    String getCharset();

    long getContentLength();

    String getMediaType();

    String getMimeType();

    String getSubType();

    String getTransferEncoding();
}
