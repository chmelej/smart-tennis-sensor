package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr == null) {
            throw new IllegalArgumentException("byte[] may not be null");
        }
        this.data = bArr;
        this.filename = str2;
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
        this.callBackInfo.pos += (long) this.data.length;
        this.callBackInfo.doCallBack(false);
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public long getContentLength() {
        return this.data.length;
    }
}
