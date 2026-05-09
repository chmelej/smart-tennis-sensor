package p000;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public class ahw {

    /* JADX INFO: renamed from: a */
    private static final byte[] f1117a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: b */
    private static final byte[] f1118b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    /* JADX INFO: renamed from: c */
    private static final byte[] f1119c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: d */
    private static final byte[] f1120d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    /* JADX INFO: renamed from: e */
    private static final byte[] f1121e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* JADX INFO: renamed from: f */
    private static final byte[] f1122f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9};

    /* JADX INFO: renamed from: a */
    private static final byte[] m1274a(int i) {
        if ((i & 16) == 16) {
            return f1119c;
        }
        if ((i & 32) == 32) {
            return f1121e;
        }
        return f1117a;
    }

    /* JADX INFO: renamed from: b */
    private static final byte[] m1277b(int i) {
        if ((i & 16) == 16) {
            return f1120d;
        }
        if ((i & 32) == 32) {
            return f1122f;
        }
        return f1118b;
    }

    /* JADX INFO: renamed from: a */
    private static final byte[] m1276a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArrM1274a = m1274a(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = bArrM1274a[i5 >>> 18];
                bArr2[i3 + 1] = bArrM1274a[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                break;
            case 2:
                bArr2[i3] = bArrM1274a[i5 >>> 18];
                bArr2[i3 + 1] = bArrM1274a[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArrM1274a[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                break;
            case 3:
                bArr2[i3] = bArrM1274a[i5 >>> 18];
                bArr2[i3 + 1] = bArrM1274a[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = bArrM1274a[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = bArrM1274a[i5 & 63];
                break;
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: a */
    public static final String m1271a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return m1273a(bArr, 0, bArr.length, 0);
    }

    /* JADX INFO: renamed from: a */
    public static final String m1272a(byte[] bArr, int i) {
        return m1273a(bArr, 0, bArr.length, i);
    }

    /* JADX INFO: renamed from: a */
    public static final String m1273a(byte[] bArr, int i, int i2, int i3) {
        boolean z = (i3 & 8) == 0;
        int i4 = (i2 * 4) / 3;
        byte[] bArr2 = new byte[(i2 % 3 > 0 ? 4 : 0) + i4 + (z ? i4 / 76 : 0)];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5) {
            m1276a(bArr, i6 + i, 3, bArr2, i7, i3);
            int i9 = i8 + 4;
            if (z && i9 == 76) {
                bArr2[i7 + 4] = 10;
                i7++;
                i8 = 0;
            } else {
                i8 = i9;
            }
            i6 += 3;
            i7 += 4;
        }
        if (i6 < i2) {
            m1276a(bArr, i6 + i, i2 - i6, bArr2, i7, i3);
            i7 += 4;
        }
        int i10 = i7;
        try {
            return new String(bArr2, 0, i10, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr2, 0, i10);
        }
    }

    /* JADX INFO: renamed from: a */
    private static final int m1270a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArrM1277b = m1277b(i3);
        int i4 = i + 2;
        if (bArr[i4] == 61) {
            bArr2[i2] = (byte) ((((bArrM1277b[bArr[i + 1]] & 255) << 12) | ((bArrM1277b[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i5 = i + 3;
        if (bArr[i5] == 61) {
            int i6 = ((bArrM1277b[bArr[i4]] & 255) << 6) | ((bArrM1277b[bArr[i + 1]] & 255) << 12) | ((bArrM1277b[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i6 >>> 16);
            bArr2[i2 + 1] = (byte) (i6 >>> 8);
            return 2;
        }
        try {
            int i7 = (bArrM1277b[bArr[i5]] & 255) | ((bArrM1277b[bArr[i + 1]] & 255) << 12) | ((bArrM1277b[bArr[i]] & 255) << 18) | ((bArrM1277b[bArr[i4]] & 255) << 6);
            bArr2[i2] = (byte) (i7 >> 16);
            bArr2[i2 + 1] = (byte) (i7 >> 8);
            bArr2[i2 + 2] = (byte) i7;
            return 3;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final byte[] m1278b(byte[] bArr, int i, int i2, int i3) {
        byte[] bArrM1277b = m1277b(i3);
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i4 = 0;
        int iM1270a = 0;
        for (int i5 = i; i5 < i + i2; i5++) {
            byte b = (byte) (bArr[i5] & 127);
            byte b2 = bArrM1277b[b];
            if (b2 < -5) {
                return null;
            }
            if (b2 >= -1) {
                int i6 = i4 + 1;
                bArr3[i4] = b;
                if (i6 > 3) {
                    iM1270a += m1270a(bArr3, 0, bArr2, iM1270a, i3);
                    if (b == 61) {
                        break;
                    }
                    i4 = 0;
                } else {
                    i4 = i6;
                }
            }
        }
        byte[] bArr4 = new byte[iM1270a];
        System.arraycopy(bArr2, 0, bArr4, 0, iM1270a);
        return bArr4;
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m1275a(String str, int i) {
        byte[] bytes;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (Throwable unused) {
            bytes = str.getBytes();
        }
        return m1278b(bytes, 0, bytes.length, i);
    }
}
