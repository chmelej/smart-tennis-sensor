package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MultipartEntity;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractContentBody implements ContentBody {
    protected MultipartEntity.CallBackInfo callBackInfo = MultipartEntity.CallBackInfo.DEFAULT;
    private final String mediaType;
    private final String mimeType;
    private final String subType;

    public AbstractContentBody(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = str;
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            this.mediaType = str.substring(0, iIndexOf);
            this.subType = str.substring(iIndexOf + 1);
        } else {
            this.mediaType = str;
            this.subType = null;
        }
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getSubType() {
        return this.subType;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public void setCallBackInfo(MultipartEntity.CallBackInfo callBackInfo) {
        this.callBackInfo = callBackInfo;
    }
}
