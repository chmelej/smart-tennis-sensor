package p000;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* JADX INFO: renamed from: tt */
/* JADX INFO: compiled from: Crc32.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2144tt {
    /* JADX INFO: renamed from: a */
    public static long m11712a(byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return crc32.getValue();
    }

    /* JADX INFO: renamed from: a */
    public static long m11711a(byte[] bArr) {
        return m11712a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public static long m11710a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[65536];
        CRC32 crc32 = new CRC32();
        while (true) {
            try {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                fileInputStream.close();
            }
        }
        return crc32.getValue();
    }
}
