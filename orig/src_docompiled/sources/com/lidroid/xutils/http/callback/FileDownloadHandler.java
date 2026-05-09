package com.lidroid.xutils.http.callback;

/* JADX INFO: loaded from: classes.dex */
public class FileDownloadHandler {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        r14.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
    
        if (r19 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        r19.updateProgress(r11, r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        com.lidroid.xutils.util.IOUtils.closeQuietly(r13);
        com.lidroid.xutils.util.IOUtils.closeQuietly(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        if (r8.exists() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
    
        if (android.text.TextUtils.isEmpty(r22) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
    
        r1 = new java.io.File(r8.getParent(), r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
    
        if (r1.exists() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
    
        if (r8.renameTo(r1) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b5, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b6, code lost:
    
        r1 = new java.io.File(r8.getParent(), java.lang.String.valueOf(java.lang.System.currentTimeMillis()) + r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d4, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File handleEntity(org.apache.http.HttpEntity r18, com.lidroid.xutils.http.callback.RequestCallBackHandler r19, java.lang.String r20, boolean r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.callback.FileDownloadHandler.handleEntity(org.apache.http.HttpEntity, com.lidroid.xutils.http.callback.RequestCallBackHandler, java.lang.String, boolean, java.lang.String):java.io.File");
    }
}
