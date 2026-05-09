package p000;

/* JADX INFO: renamed from: kb */
/* JADX INFO: compiled from: DealPictureUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1845kb {
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[Catch: IOException -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #17 {IOException -> 0x003e, blocks: (B:28:0x003a, B:19:0x0029, B:63:0x0074, B:54:0x0063), top: B:110:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0074 A[Catch: IOException -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #17 {IOException -> 0x003e, blocks: (B:28:0x003a, B:19:0x0029, B:63:0x0074, B:54:0x0063), top: B:110:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009a A[Catch: IOException -> 0x009e, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x009e, blocks: (B:85:0x009a, B:76:0x0089), top: B:90:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File m10082a(java.io.File r4, java.io.File r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
        Lf:
            int r0 = r2.read(r4)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            r3 = -1
            if (r0 == r3) goto L1b
            r3 = 0
            r1.write(r4, r3, r0)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L45
            goto Lf
        L1b:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            goto L38
        L21:
            r4 = move-exception
            goto L2d
        L23:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L77
        L2d:
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r5 = move-exception
            r5.printStackTrace()
        L37:
            throw r4
        L38:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L77
        L3e:
            r4 = move-exception
            r4.printStackTrace()
            goto L77
        L43:
            r4 = move-exception
            goto L7a
        L45:
            r4 = move-exception
            goto L4b
        L47:
            r4 = move-exception
            goto L7b
        L49:
            r4 = move-exception
            r2 = r0
        L4b:
            r0 = r1
            goto L52
        L4d:
            r4 = move-exception
            r1 = r0
            goto L7b
        L50:
            r4 = move-exception
            r2 = r0
        L52:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            goto L72
        L5b:
            r4 = move-exception
            goto L67
        L5d:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L77
        L67:
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r5 = move-exception
            r5.printStackTrace()
        L71:
            throw r4
        L72:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L3e
        L77:
            return r5
        L78:
            r4 = move-exception
            r1 = r0
        L7a:
            r0 = r2
        L7b:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Throwable -> L81 java.io.IOException -> L83
            goto L98
        L81:
            r4 = move-exception
            goto L8d
        L83:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.io.IOException -> L9e
            goto La2
        L8d:
            if (r0 == 0) goto L97
            r0.close()     // Catch: java.io.IOException -> L93
            goto L97
        L93:
            r5 = move-exception
            r5.printStackTrace()
        L97:
            throw r4
        L98:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.io.IOException -> L9e
            goto La2
        L9e:
            r5 = move-exception
            r5.printStackTrace()
        La2:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1845kb.m10082a(java.io.File, java.io.File):java.io.File");
    }
}
