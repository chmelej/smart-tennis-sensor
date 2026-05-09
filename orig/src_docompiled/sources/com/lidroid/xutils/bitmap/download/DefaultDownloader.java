package com.lidroid.xutils.bitmap.download;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDownloader extends Downloader {
    @Override // com.lidroid.xutils.bitmap.download.Downloader
    public long downloadToStream(String str, OutputStream outputStream, BitmapUtils.BitmapLoadTask<?> bitmapLoadTask) throws Throwable {
        Throwable th;
        Throwable th2;
        long contentLength;
        long jCurrentTimeMillis;
        if (bitmapLoadTask == null || bitmapLoadTask.isCancelled() || bitmapLoadTask.getTargetContainer() == null) {
            return -1L;
        }
        BufferedInputStream bufferedInputStream = null;
        OtherUtils.trustAllHttpsURLConnection();
        long j = 0;
        try {
            try {
                if (str.startsWith("/")) {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    contentLength = fileInputStream.available();
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                    try {
                        bufferedInputStream = bufferedInputStream2;
                        jCurrentTimeMillis = System.currentTimeMillis() + getDefaultExpiry();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                    }
                } else if (str.startsWith("assets/")) {
                    InputStream inputStreamOpen = getContext().getAssets().open(str.substring(7, str.length()));
                    contentLength = inputStreamOpen.available();
                    jCurrentTimeMillis = Long.MAX_VALUE;
                    bufferedInputStream = new BufferedInputStream(inputStreamOpen);
                } else {
                    URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                    uRLConnectionOpenConnection.setConnectTimeout(getDefaultConnectTimeout());
                    uRLConnectionOpenConnection.setReadTimeout(getDefaultReadTimeout());
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
                    try {
                        long expiration = uRLConnectionOpenConnection.getExpiration();
                        long jCurrentTimeMillis2 = expiration < System.currentTimeMillis() ? System.currentTimeMillis() + getDefaultExpiry() : expiration;
                        contentLength = uRLConnectionOpenConnection.getContentLength();
                        bufferedInputStream = bufferedInputStream3;
                        jCurrentTimeMillis = jCurrentTimeMillis2;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream = bufferedInputStream3;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
            if (!bitmapLoadTask.isCancelled() && bitmapLoadTask.getTargetContainer() != null) {
                byte[] bArr = new byte[4096];
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                        long j2 = j + ((long) i);
                        if (bitmapLoadTask.isCancelled() || bitmapLoadTask.getTargetContainer() == null) {
                            break;
                        }
                        bitmapLoadTask.updateProgress(contentLength, j2);
                        j = j2;
                    } else {
                        bufferedOutputStream.flush();
                        IOUtils.closeQuietly(bufferedInputStream);
                        return jCurrentTimeMillis;
                    }
                    th = th;
                    LogUtils.m8420e(th.getMessage(), th);
                    IOUtils.closeQuietly(bufferedInputStream);
                    return -1L;
                }
                IOUtils.closeQuietly(bufferedInputStream);
                return -1L;
            }
            IOUtils.closeQuietly(bufferedInputStream);
            return -1L;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
