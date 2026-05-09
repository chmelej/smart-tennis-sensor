package com.lidroid.xutils.http.callback;

import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes.dex */
public class StringDownloadHandler {
    public String handleEntity(HttpEntity httpEntity, RequestCallBackHandler requestCallBackHandler, String str) throws Throwable {
        Throwable th;
        InputStream content;
        long j;
        if (httpEntity == null) {
            return null;
        }
        long j2 = 0;
        long contentLength = httpEntity.getContentLength();
        if (requestCallBackHandler != null && !requestCallBackHandler.updateProgress(contentLength, 0L, true)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            content = httpEntity.getContent();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content, str));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                        long jSizeOfString = j2 + OtherUtils.sizeOfString(line, str);
                        if (requestCallBackHandler != null && !requestCallBackHandler.updateProgress(contentLength, jSizeOfString, false)) {
                            j = jSizeOfString;
                            break;
                        }
                        j2 = jSizeOfString;
                    } else {
                        j = j2;
                        break;
                    }
                }
                if (requestCallBackHandler != null) {
                    requestCallBackHandler.updateProgress(contentLength, j, true);
                }
                IOUtils.closeQuietly(content);
                return sb.toString().trim();
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(content);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            content = null;
        }
    }
}
