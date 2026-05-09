package p000;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: AESStringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class aih {
    /* JADX INFO: renamed from: a */
    private static IllegalStateException m1314a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    /* JADX INFO: renamed from: a */
    public static String m1316a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw m1314a(str, e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m1315a(byte[] bArr) {
        return m1316a(bArr, "UTF-8");
    }
}
