package p000;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: tw */
/* JADX INFO: compiled from: UrlSafeBase64.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2147tw {
    /* JADX INFO: renamed from: a */
    public static String m11721a(String str) {
        try {
            return m11722a(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m11722a(byte[] bArr) {
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m11723b(String str) {
        return Base64.decode(str, 10);
    }
}
