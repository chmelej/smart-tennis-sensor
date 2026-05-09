package com.lidroid.xutils.http.client.entity;

import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.entity.FileEntity;

/* JADX INFO: loaded from: classes.dex */
public class FileUploadEntity extends FileEntity implements UploadEntity {
    private RequestCallBackHandler callBackHandler;
    private long fileSize;
    private long uploadedSize;

    public FileUploadEntity(File file, String str) {
        super(file, str);
        this.uploadedSize = 0L;
        this.callBackHandler = null;
        this.fileSize = file.length();
    }

    @Override // org.apache.http.entity.FileEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                        this.uploadedSize += (long) i;
                        if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.fileSize, this.uploadedSize, false)) {
                            throw new InterruptedIOException("cancel");
                        }
                    } else {
                        outputStream.flush();
                        if (this.callBackHandler != null) {
                            this.callBackHandler.updateProgress(this.fileSize, this.uploadedSize, true);
                        }
                        IOUtils.closeQuietly(bufferedInputStream);
                        return;
                    }
                }
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

    @Override // com.lidroid.xutils.http.client.entity.UploadEntity
    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
    }
}
