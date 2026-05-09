package p000;

import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DigestUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class ahy {
    /* JADX INFO: renamed from: a */
    public static final String m1280a(InputStream inputStream) {
        try {
            return m1281a(inputStream, "MD5");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m1281a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            int i = inputStream.read(bArr, 0, 1024);
            while (i > -1) {
                messageDigest.update(bArr, 0, i);
                i = inputStream.read(bArr, 0, 1024);
            }
            return aia.m1293a(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }
}
