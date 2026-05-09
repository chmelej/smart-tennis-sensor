package cn.sharesdk.tencent.weibo;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.b */
/* JADX INFO: compiled from: Cryptor.java */
/* JADX INFO: loaded from: classes.dex */
public class C0890b {

    /* JADX INFO: renamed from: a */
    private byte[] f5852a;

    /* JADX INFO: renamed from: b */
    private byte[] f5853b;

    /* JADX INFO: renamed from: c */
    private byte[] f5854c;

    /* JADX INFO: renamed from: d */
    private int f5855d;

    /* JADX INFO: renamed from: e */
    private int f5856e;

    /* JADX INFO: renamed from: f */
    private int f5857f;

    /* JADX INFO: renamed from: g */
    private int f5858g;

    /* JADX INFO: renamed from: h */
    private byte[] f5859h;

    /* JADX INFO: renamed from: j */
    private int f5861j;

    /* JADX INFO: renamed from: i */
    private boolean f5860i = true;

    /* JADX INFO: renamed from: k */
    private Random f5862k = new Random();

    /* JADX INFO: renamed from: a */
    public static long m6421a(byte[] bArr, int i, int i2) {
        int i3 = i2 > 8 ? i + 8 : i2 + i;
        long j = 0;
        while (i < i3) {
            long j2 = (j << 8) | ((long) (bArr[i] & 255));
            i++;
            j = j2;
        }
        return (j & 4294967295L) | (j >>> 32);
    }

    /* JADX INFO: renamed from: a */
    public byte[] m6429a(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        this.f5856e = 0;
        this.f5855d = 0;
        this.f5859h = bArr2;
        byte[] bArr3 = new byte[i + 8];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        this.f5853b = m6425a(bArr, i);
        this.f5857f = this.f5853b[0] & 7;
        int i4 = (i2 - this.f5857f) - 10;
        if (i4 < 0) {
            return null;
        }
        for (int i5 = i; i5 < bArr3.length; i5++) {
            bArr3[i5] = 0;
        }
        this.f5854c = new byte[i4];
        this.f5856e = 0;
        this.f5855d = 8;
        this.f5861j = 8;
        this.f5857f++;
        this.f5858g = 1;
        while (this.f5858g <= 2) {
            if (this.f5857f < 8) {
                this.f5857f++;
                this.f5858g++;
            }
            if (this.f5857f == 8) {
                if (!m6427b(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
        while (i4 != 0) {
            if (this.f5857f < 8) {
                this.f5854c[i3] = (byte) (bArr3[(this.f5856e + i) + this.f5857f] ^ this.f5853b[this.f5857f]);
                i3++;
                i4--;
                this.f5857f++;
            }
            if (this.f5857f == 8) {
                this.f5856e = this.f5855d - 8;
                if (!m6427b(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
        this.f5858g = 1;
        while (this.f5858g < 8) {
            if (this.f5857f < 8) {
                if ((bArr3[(this.f5856e + i) + this.f5857f] ^ this.f5853b[this.f5857f]) != 0) {
                    return null;
                }
                this.f5857f++;
            }
            if (this.f5857f == 8) {
                this.f5856e = this.f5855d;
                if (!m6427b(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
            this.f5858g++;
        }
        return this.f5854c;
    }

    /* JADX INFO: renamed from: b */
    public byte[] m6432b(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.f5852a = new byte[8];
        this.f5853b = new byte[8];
        this.f5857f = 1;
        this.f5858g = 0;
        this.f5856e = 0;
        this.f5855d = 0;
        this.f5859h = bArr2;
        this.f5860i = true;
        this.f5857f = (i2 + 10) % 8;
        if (this.f5857f != 0) {
            this.f5857f = 8 - this.f5857f;
        }
        this.f5854c = new byte[this.f5857f + i2 + 10];
        this.f5852a[0] = (byte) ((m6426b() & 248) | this.f5857f);
        for (int i3 = 1; i3 <= this.f5857f; i3++) {
            this.f5852a[i3] = (byte) (m6426b() & 255);
        }
        this.f5857f++;
        for (int i4 = 0; i4 < 8; i4++) {
            this.f5853b[i4] = 0;
        }
        this.f5858g = 1;
        while (this.f5858g <= 2) {
            if (this.f5857f < 8) {
                byte[] bArr3 = this.f5852a;
                int i5 = this.f5857f;
                this.f5857f = i5 + 1;
                bArr3[i5] = (byte) (m6426b() & 255);
                this.f5858g++;
            }
            if (this.f5857f == 8) {
                m6422a();
            }
        }
        while (i2 > 0) {
            if (this.f5857f < 8) {
                byte[] bArr4 = this.f5852a;
                int i6 = this.f5857f;
                this.f5857f = i6 + 1;
                bArr4[i6] = bArr[i];
                i2--;
                i++;
            }
            if (this.f5857f == 8) {
                m6422a();
            }
        }
        this.f5858g = 1;
        while (this.f5858g <= 7) {
            if (this.f5857f < 8) {
                byte[] bArr5 = this.f5852a;
                int i7 = this.f5857f;
                this.f5857f = i7 + 1;
                bArr5[i7] = 0;
                this.f5858g++;
            }
            if (this.f5857f == 8) {
                m6422a();
            }
        }
        return this.f5854c;
    }

    /* JADX INFO: renamed from: a */
    public byte[] m6430a(byte[] bArr, byte[] bArr2) {
        return m6432b(bArr, 0, bArr.length, bArr2);
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6424a(byte[] bArr) {
        int i = 16;
        try {
            long jM6421a = m6421a(bArr, 0, 4);
            long jM6421a2 = m6421a(bArr, 4, 4);
            long jM6421a3 = m6421a(this.f5859h, 0, 4);
            long jM6421a4 = m6421a(this.f5859h, 4, 4);
            long jM6421a5 = m6421a(this.f5859h, 8, 4);
            long jM6421a6 = m6421a(this.f5859h, 12, 4);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) jM6421a);
                    dataOutputStream.writeInt((int) jM6421a2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                long j2 = (j + 2654435769L) & 4294967295L;
                jM6421a = (jM6421a + ((((jM6421a2 << 4) + jM6421a3) ^ (jM6421a2 + j2)) ^ ((jM6421a2 >>> 5) + jM6421a4))) & 4294967295L;
                jM6421a2 = (jM6421a2 + ((((jM6421a << 4) + jM6421a5) ^ (jM6421a + j2)) ^ ((jM6421a >>> 5) + jM6421a6))) & 4294967295L;
                i = i2;
                j = j2;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6425a(byte[] bArr, int i) {
        int i2 = 16;
        try {
            long jM6421a = m6421a(bArr, i, 4);
            long jM6421a2 = m6421a(bArr, i + 4, 4);
            long jM6421a3 = m6421a(this.f5859h, 0, 4);
            long jM6421a4 = m6421a(this.f5859h, 4, 4);
            long jM6421a5 = m6421a(this.f5859h, 8, 4);
            long jM6421a6 = m6421a(this.f5859h, 12, 4);
            long j = 3816266640L;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) jM6421a);
                    dataOutputStream.writeInt((int) jM6421a2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                long j2 = (jM6421a2 - ((((jM6421a << 4) + jM6421a5) ^ (jM6421a + j)) ^ ((jM6421a >>> 5) + jM6421a6))) & 4294967295L;
                jM6421a = (jM6421a - ((((j2 << 4) + jM6421a3) ^ (j2 + j)) ^ ((j2 >>> 5) + jM6421a4))) & 4294967295L;
                j = (j - 2654435769L) & 4294967295L;
                i2 = i3;
                jM6421a2 = j2;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private byte[] m6428b(byte[] bArr) {
        return m6425a(bArr, 0);
    }

    /* JADX INFO: renamed from: a */
    private void m6422a() {
        this.f5857f = 0;
        while (this.f5857f < 8) {
            if (this.f5860i) {
                byte[] bArr = this.f5852a;
                int i = this.f5857f;
                bArr[i] = (byte) (bArr[i] ^ this.f5853b[this.f5857f]);
            } else {
                byte[] bArr2 = this.f5852a;
                int i2 = this.f5857f;
                bArr2[i2] = (byte) (bArr2[i2] ^ this.f5854c[this.f5856e + this.f5857f]);
            }
            this.f5857f++;
        }
        System.arraycopy(m6424a(this.f5852a), 0, this.f5854c, this.f5855d, 8);
        this.f5857f = 0;
        while (this.f5857f < 8) {
            byte[] bArr3 = this.f5854c;
            int i3 = this.f5855d + this.f5857f;
            bArr3[i3] = (byte) (bArr3[i3] ^ this.f5853b[this.f5857f]);
            this.f5857f++;
        }
        System.arraycopy(this.f5852a, 0, this.f5853b, 0, 8);
        this.f5856e = this.f5855d;
        this.f5855d += 8;
        this.f5857f = 0;
        this.f5860i = false;
    }

    /* JADX INFO: renamed from: b */
    private boolean m6427b(byte[] bArr, int i, int i2) {
        this.f5857f = 0;
        while (this.f5857f < 8) {
            if (this.f5861j + this.f5857f >= i2) {
                return true;
            }
            byte[] bArr2 = this.f5853b;
            int i3 = this.f5857f;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.f5855d + i) + this.f5857f]);
            this.f5857f++;
        }
        this.f5853b = m6428b(this.f5853b);
        if (this.f5853b == null) {
            return false;
        }
        this.f5861j += 8;
        this.f5855d += 8;
        this.f5857f = 0;
        return true;
    }

    /* JADX INFO: renamed from: b */
    private int m6426b() {
        return this.f5862k.nextInt();
    }

    /* JADX INFO: renamed from: a */
    public byte[] m6431a(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArrM6429a = m6429a(bArr, 0, bArr.length, bArr2);
        return bArrM6429a == null ? m6423a(i) : bArrM6429a;
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6423a(int i) {
        byte[] bArr = new byte[i];
        this.f5862k.nextBytes(bArr);
        return bArr;
    }
}
