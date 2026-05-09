package p000;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: nh */
/* JADX INFO: compiled from: Utf8.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1936nh {
    /* JADX INFO: renamed from: a */
    public static byte[] m10755a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m10754a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m10756b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}
