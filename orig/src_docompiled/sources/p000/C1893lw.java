package p000;

import android.support.v4.view.MotionEventCompat;

/* JADX INFO: renamed from: lw */
/* JADX INFO: compiled from: DataUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1893lw {
    /* JADX INFO: renamed from: a */
    public static boolean m10442a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length - 1; i2++) {
            i += bArr[i2] & 255;
        }
        return ((byte) (i & 255)) == bArr[bArr.length - 1];
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10449a(int i) {
        return new byte[]{(byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10443a(byte b) {
        return m10444a(b, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10444a(byte b, byte b2) {
        return m10445a(b, b2, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10445a(byte b, byte b2, byte b3) {
        return m10446a(b, b2, b3, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10446a(byte b, byte b2, byte b3, byte b4) {
        return m10448a(b, b2, b3, b4, (byte) 0, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10448a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6) {
        return new byte[]{-88, b, b2, b3, b4, b5, b6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, m10451b(new byte[]{-88, b, b2, b3, b4, b5, b6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})};
    }

    /* JADX INFO: renamed from: b */
    public static byte m10451b(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += b & 255;
        }
        return (byte) (i & 255);
    }

    /* JADX INFO: renamed from: c */
    public static byte[] m10455c(byte[] bArr) {
        switch (bArr.length) {
            case 1:
                return m10443a(bArr[0]);
            case 2:
                return m10444a(bArr[0], bArr[1]);
            case 3:
                return m10445a(bArr[0], bArr[1], bArr[2]);
            case 4:
                return m10446a(bArr[0], bArr[1], bArr[2], bArr[3]);
            case 5:
                return m10447a(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4]);
            case 6:
                return m10448a(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5]);
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m10447a(byte b, byte b2, byte b3, byte b4, byte b5) {
        return m10448a(b, b2, b3, b4, b5, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m10450a(long j) {
        return new byte[]{(byte) ((j & (-16777216)) >> 24), (byte) ((j & 16711680) >> 16), (byte) ((j & 65280) >> 8), (byte) (j & 255)};
    }

    /* JADX INFO: renamed from: d */
    public static String m10456d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(" " + String.format("%02X", Byte.valueOf(b)));
        }
        C1900mc.m10474b("data", stringBuffer.toString());
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    public static int m10453b(byte b, byte b2) {
        return (Integer.parseInt(String.format("%02X", Byte.valueOf(b)), 16) * 16 * 16) + Integer.parseInt(String.format("%02X", Byte.valueOf(b2)), 16);
    }

    /* JADX INFO: renamed from: b */
    public static int m10452b(byte b) {
        return Integer.parseInt(String.format("%02X", Byte.valueOf(b)), 16);
    }

    /* JADX INFO: renamed from: b */
    public static long m10454b(byte b, byte b2, byte b3, byte b4) {
        int i = 0;
        byte[] bArr = {0, 0, 0, 0, b, b2, b3, b4};
        long j = 0;
        while (i < 8) {
            long j2 = (j << 8) | ((long) (bArr[i] & 255));
            i++;
            j = j2;
        }
        return j;
    }
}
