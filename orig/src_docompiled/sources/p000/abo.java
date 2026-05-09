package p000;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class abo {
    /* JADX INFO: renamed from: a */
    public static byte[] m69a(byte[] bArr) {
        return m70a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m70a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = bArr2[i % length];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + iArr[i3] + iArr2[i3]) & 255;
            int i4 = iArr[i3];
            iArr[i3] = iArr[i2];
            iArr[i2] = i4;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            i6 = (i6 + iArr[i5]) & 255;
            int i8 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i8;
            bArr3[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) & 255] ^ bArr[i7]);
        }
        return bArr3;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m71b(byte[] bArr) {
        return m70a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }
}
