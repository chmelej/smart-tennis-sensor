package p000;

import android.support.v4.view.MotionEventCompat;
import com.lidroid.xutils.util.CharsetUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: nf */
/* JADX INFO: compiled from: IsoTypeReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1934nf {
    /* JADX INFO: renamed from: a */
    public static int m10732a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    /* JADX INFO: renamed from: a */
    public static long m10733a(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    /* JADX INFO: renamed from: b */
    public static int m10735b(ByteBuffer byteBuffer) {
        return (m10736c(byteBuffer) << 8) + 0 + m10732a(byteBuffer.get());
    }

    /* JADX INFO: renamed from: c */
    public static int m10736c(ByteBuffer byteBuffer) {
        return (m10732a(byteBuffer.get()) << 8) + 0 + m10732a(byteBuffer.get());
    }

    /* JADX INFO: renamed from: d */
    public static int m10737d(ByteBuffer byteBuffer) {
        return m10732a(byteBuffer.get());
    }

    /* JADX INFO: renamed from: a */
    public static String m10734a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return C1936nh.m10754a(bArr);
    }

    /* JADX INFO: renamed from: e */
    public static long m10738e(ByteBuffer byteBuffer) {
        long jM10733a = (m10733a(byteBuffer) << 32) + 0;
        if (jM10733a < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return jM10733a + m10733a(byteBuffer);
    }

    /* JADX INFO: renamed from: f */
    public static double m10739f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((0 | ((bArr[0] << 24) & (-16777216))) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & 255))) / 65536.0d;
    }

    /* JADX INFO: renamed from: g */
    public static double m10740g(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((0 | ((bArr[0] << 24) & (-16777216))) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    /* JADX INFO: renamed from: h */
    public static float m10741h(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[2]);
        return ((short) (((short) (0 | ((r0[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) | (r0[1] & 255))) / 256.0f;
    }

    /* JADX INFO: renamed from: i */
    public static String m10742i(ByteBuffer byteBuffer) {
        int iM10736c = m10736c(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((iM10736c >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: j */
    public static String m10743j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, CharsetUtils.DEFAULT_ENCODING_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
