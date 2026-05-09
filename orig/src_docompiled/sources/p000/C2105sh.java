package p000;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: sh */
/* JADX INFO: compiled from: IoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2105sh {

    /* JADX INFO: renamed from: sh$a */
    /* JADX INFO: compiled from: IoUtils.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        boolean mo11432a(int i, int i2);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11519a(InputStream inputStream, OutputStream outputStream, a aVar, int i) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable <= 0) {
            iAvailable = 512000;
        }
        byte[] bArr = new byte[i];
        if (m11520a(aVar, 0, iAvailable)) {
            return false;
        }
        int i2 = 0;
        do {
            int i3 = inputStream.read(bArr, 0, i);
            if (i3 != -1) {
                outputStream.write(bArr, 0, i3);
                i2 += i3;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!m11520a(aVar, i2, iAvailable));
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m11520a(a aVar, int i, int i2) {
        return (aVar == null || aVar.mo11432a(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static void m11518a(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                m11517a((Closeable) inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        m11517a((Closeable) inputStream);
    }

    /* JADX INFO: renamed from: a */
    public static void m11517a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }
}
