package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: renamed from: ce */
/* JADX INFO: compiled from: ZipUtil.java */
/* JADX INFO: loaded from: classes.dex */
final class C0790ce {

    /* JADX INFO: renamed from: ce$a */
    /* JADX INFO: compiled from: ZipUtil.java */
    static class a {

        /* JADX INFO: renamed from: a */
        long f5325a;

        /* JADX INFO: renamed from: b */
        long f5326b;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    static long m5776a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return m5777a(randomAccessFile, m5778a(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    /* JADX INFO: renamed from: a */
    static a m5778a(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        long j2 = j >= 0 ? j : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        while (true) {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.f5326b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                aVar.f5325a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return aVar;
            }
            long j3 = length - 1;
            if (j3 < j2) {
                throw new ZipException("End Of Central Directory signature not found");
            }
            length = j3;
        }
    }

    /* JADX INFO: renamed from: a */
    static long m5777a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = aVar.f5326b;
        randomAccessFile.seek(aVar.f5325a);
        byte[] bArr = new byte[16384];
        int i = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (i != -1) {
            crc32.update(bArr, 0, i);
            long j2 = j - ((long) i);
            if (j2 == 0) {
                break;
            }
            i = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j2));
            j = j2;
        }
        return crc32.getValue();
    }
}
