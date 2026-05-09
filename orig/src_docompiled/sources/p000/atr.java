package p000;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: DeflaterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class atr {

    /* JADX INFO: renamed from: a */
    public static int f5054a;

    /* JADX INFO: renamed from: a */
    public static byte[] m5466a(String str, String str2) {
        if (ats.m5474d(str)) {
            return null;
        }
        return m5467a(str.getBytes(str2));
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m5467a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f5054a = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int iDeflate = deflater.deflate(bArr2);
                    f5054a += iDeflate;
                    byteArrayOutputStream.write(bArr2, 0, iDeflate);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }
}
