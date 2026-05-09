package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.util.IOUtils;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;

    /* JADX INFO: renamed from: in */
    private final InputStream f8945in;
    private long length;

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public InputStreamBody(InputStream inputStream, long j, String str, String str2) {
        super(str2);
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.f8945in = inputStream;
        this.filename = str;
        this.length = j;
    }

    public InputStreamBody(InputStream inputStream, long j, String str) {
        this(inputStream, j, str, "application/octet-stream");
    }

    public InputStreamBody(InputStream inputStream, long j) {
        this(inputStream, j, "no_name", "application/octet-stream");
    }

    public InputStream getInputStream() {
        return this.f8945in;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] bArr = new byte[4096];
            do {
                int i = this.f8945in.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                    this.callBackInfo.pos += (long) i;
                } else {
                    outputStream.flush();
                    return;
                }
            } while (this.callBackInfo.doCallBack(false));
            throw new InterruptedIOException("cancel");
        } finally {
            IOUtils.closeQuietly(this.f8945in);
        }
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public long getContentLength() {
        return this.length;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public String getFilename() {
        return this.filename;
    }
}
