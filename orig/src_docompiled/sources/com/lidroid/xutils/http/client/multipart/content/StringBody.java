package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class StringBody extends AbstractContentBody {
    private final Charset charset;
    private final byte[] content;

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public String getFilename() {
        return null;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    public static StringBody create(String str, String str2, Charset charset) {
        try {
            return new StringBody(str, str2, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    public static StringBody create(String str, Charset charset) {
        return create(str, null, charset);
    }

    public static StringBody create(String str) {
        return create(str, null, null);
    }

    public StringBody(String str, String str2, Charset charset) {
        super(str2);
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        this.content = str.getBytes(charset.name());
        this.charset = charset;
    }

    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    public StringBody(String str) {
        this(str, "text/plain", null);
    }

    public Reader getReader() {
        return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[4096];
        do {
            int i = byteArrayInputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
                this.callBackInfo.pos += (long) i;
            } else {
                outputStream.flush();
                return;
            }
        } while (this.callBackInfo.doCallBack(false));
        throw new InterruptedIOException("cancel");
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getCharset() {
        return this.charset.name();
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }
}
