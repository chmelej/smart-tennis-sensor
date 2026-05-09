package com.lidroid.xutils.http.client.entity;

import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* JADX INFO: loaded from: classes.dex */
abstract class DecompressingEntity extends HttpEntityWrapper implements UploadEntity {
    private RequestCallBackHandler callBackHandler;
    private InputStream content;
    private long uncompressedLength;
    private long uploadedSize;

    abstract InputStream decorate(InputStream inputStream);

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    public DecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
        this.uploadedSize = 0L;
        this.callBackHandler = null;
        this.uncompressedLength = httpEntity.getContentLength();
    }

    private InputStream getDecompressingStream() throws IOException {
        InputStream content;
        InputStream inputStream = null;
        try {
            content = this.wrappedEntity.getContent();
        } catch (IOException e) {
            e = e;
        }
        try {
            return decorate(content);
        } catch (IOException e2) {
            e = e2;
            inputStream = content;
            IOUtils.closeQuietly(inputStream);
            throw e;
        }
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() {
        if (this.wrappedEntity.isStreaming()) {
            if (this.content == null) {
                this.content = getDecompressingStream();
            }
            return this.content;
        }
        return getDecompressingStream();
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws Throwable {
        InputStream content;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            content = getContent();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = content.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                        this.uploadedSize += (long) i;
                        if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.uncompressedLength, this.uploadedSize, false)) {
                            throw new InterruptedIOException("cancel");
                        }
                    } else {
                        outputStream.flush();
                        if (this.callBackHandler != null) {
                            this.callBackHandler.updateProgress(this.uncompressedLength, this.uploadedSize, true);
                        }
                        IOUtils.closeQuietly(content);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(content);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            content = null;
        }
    }

    @Override // com.lidroid.xutils.http.client.entity.UploadEntity
    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
    }
}
