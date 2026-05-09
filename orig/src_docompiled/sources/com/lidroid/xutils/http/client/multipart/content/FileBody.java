package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileBody extends AbstractContentBody {
    private final String charset;
    private final File file;
    private final String filename;

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public FileBody(File file, String str, String str2, String str3) {
        super(str2);
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file;
        if (str != null) {
            this.filename = str;
        } else {
            this.filename = file.getName();
        }
        this.charset = str3;
    }

    public FileBody(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    public FileBody(File file, String str) {
        this(file, null, str, null);
    }

    public FileBody(File file) {
        this(file, null, "application/octet-stream", null);
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public void writeTo(OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file));
            try {
                byte[] bArr = new byte[4096];
                do {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                        this.callBackInfo.pos += (long) i;
                    } else {
                        outputStream.flush();
                        IOUtils.closeQuietly(bufferedInputStream);
                        return;
                    }
                } while (this.callBackInfo.doCallBack(false));
                throw new InterruptedIOException("cancel");
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public String getCharset() {
        return this.charset;
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentDescriptor
    public long getContentLength() {
        return this.file.length();
    }

    @Override // com.lidroid.xutils.http.client.multipart.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}
