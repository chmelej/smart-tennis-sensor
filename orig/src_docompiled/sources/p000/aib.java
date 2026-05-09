package p000;

import android.text.TextUtils;

/* JADX INFO: compiled from: MurmurHashUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class aib {
    /* JADX INFO: renamed from: a */
    public static final int m1296a(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = i3 ^ i2;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = (i6 << 2) + i;
            int i8 = ((bArr[i7 + 0] & 255) | (((((bArr[i7 + 3] << 8) | (bArr[i7 + 2] & 255)) << 8) | (bArr[i7 + 1] & 255)) << 8)) * 1540483477;
            i5 = (i5 * 1540483477) ^ ((i8 ^ (i8 >>> 24)) * 1540483477);
        }
        int i9 = i2 - (i4 << 2);
        if (i9 != 0) {
            if (i9 >= 3) {
                i5 ^= bArr[(i + i2) - 3] << 16;
            }
            if (i9 >= 2) {
                i5 ^= bArr[(i + i2) - 2] << 8;
            }
            if (i9 >= 1) {
                i5 ^= bArr[(i + i2) - 1];
            }
            i5 *= 1540483477;
        }
        int i10 = ((i5 >>> 13) ^ i5) * 1540483477;
        return i10 ^ (i10 >>> 15);
    }

    /* JADX INFO: renamed from: a */
    public static final int m1294a(long j) {
        return m1295a(j, null);
    }

    /* JADX INFO: renamed from: a */
    public static final int m1295a(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            return (int) (((long) Math.abs(m1296a(bytes, 0, bytes.length, Integer.MAX_VALUE))) % j);
        }
        return (int) (Math.random() * j);
    }
}
