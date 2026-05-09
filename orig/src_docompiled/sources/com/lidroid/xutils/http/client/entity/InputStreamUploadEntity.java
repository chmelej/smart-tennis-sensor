package com.lidroid.xutils.http.client.entity;

import android.support.v4.media.session.PlaybackStateCompat;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* JADX INFO: loaded from: classes.dex */
public class InputStreamUploadEntity extends AbstractHttpEntity implements UploadEntity {
    private static final int BUFFER_SIZE = 2048;
    private final InputStream content;
    private final long length;
    private long uploadedSize = 0;
    private RequestCallBackHandler callBackHandler = null;

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    public InputStreamUploadEntity(InputStream inputStream, long j) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Source input stream may not be null");
        }
        this.content = inputStream;
        this.length = j;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        return this.content;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        int i;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[2048];
            int i2 = -1;
            if (this.length < 0) {
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i3);
                    this.uploadedSize += (long) i3;
                    if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.uploadedSize + 1, this.uploadedSize, false)) {
                        throw new InterruptedIOException("cancel");
                    }
                }
            } else {
                long j = this.length;
                for (int i4 = 0; j > 0 && (i = inputStream.read(bArr, i4, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, j))) != i2; i4 = 0) {
                    outputStream.write(bArr, i4, i);
                    long j2 = i;
                    long j3 = j - j2;
                    this.uploadedSize += j2;
                    if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.length, this.uploadedSize, false)) {
                        throw new InterruptedIOException("cancel");
                    }
                    j = j3;
                    i2 = -1;
                }
            }
            outputStream.flush();
            if (this.callBackHandler != null) {
                this.callBackHandler.updateProgress(this.length, this.uploadedSize, true);
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Override // org.apache.http.entity.AbstractHttpEntity, org.apache.http.HttpEntity
    public void consumeContent() throws IOException {
        this.content.close();
    }

    @Override // com.lidroid.xutils.http.client.entity.UploadEntity
    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
    }
}
