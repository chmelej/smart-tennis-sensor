package p000;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: HexInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class alp extends FilterInputStream {

    /* JADX INFO: renamed from: a */
    private final int f1674a;

    /* JADX INFO: renamed from: b */
    private final byte[] f1675b;

    /* JADX INFO: renamed from: c */
    private int f1676c;

    /* JADX INFO: renamed from: d */
    private int f1677d;

    /* JADX INFO: renamed from: e */
    private int f1678e;

    /* JADX INFO: renamed from: f */
    private int f1679f;

    /* JADX INFO: renamed from: g */
    private int f1680g;

    /* JADX INFO: renamed from: h */
    private int f1681h;

    /* JADX INFO: renamed from: i */
    private final int f1682i;

    /* JADX INFO: renamed from: c */
    private int m1904c(int i) {
        if (i >= 65) {
            return i - 55;
        }
        if (i >= 48) {
            return i - 48;
        }
        return -1;
    }

    public alp(InputStream inputStream, int i) {
        super(new BufferedInputStream(inputStream));
        this.f1674a = 128;
        this.f1675b = new byte[128];
        this.f1676c = 128;
        this.f1678e = this.f1675b.length;
        this.f1679f = 0;
        this.f1682i = i;
        this.f1680g = m1899a(i);
    }

    public alp(byte[] bArr, int i) {
        super(new ByteArrayInputStream(bArr));
        this.f1674a = 128;
        this.f1675b = new byte[128];
        this.f1676c = 128;
        this.f1678e = this.f1675b.length;
        this.f1679f = 0;
        this.f1682i = i;
        this.f1680g = m1899a(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0066 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m1899a(int r10) throws java.io.IOException {
        /*
            r9 = this;
            java.io.InputStream r0 = r9.in
            int r1 = r0.available()
            r0.mark(r1)
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L73
            r2 = 0
            r3 = 0
        Lf:
            r9.m1903b(r1)     // Catch: java.lang.Throwable -> L73
            int r1 = r9.m1900a(r0)     // Catch: java.lang.Throwable -> L73
            int r4 = r9.m1902b(r0)     // Catch: java.lang.Throwable -> L73
            int r5 = r9.m1900a(r0)     // Catch: java.lang.Throwable -> L73
            r6 = 2
            r8 = 4
            if (r5 == r8) goto L50
            switch(r5) {
                case 0: goto L43;
                case 1: goto L3f;
                case 2: goto L27;
                default: goto L26;
            }     // Catch: java.lang.Throwable -> L73
        L26:
            goto L47
        L27:
            int r1 = r9.m1902b(r0)     // Catch: java.lang.Throwable -> L73
            int r1 = r1 << r8
            if (r3 <= 0) goto L3a
            int r4 = r1 >> 16
            int r2 = r2 >> 16
            int r2 = r2 + 1
            if (r4 == r2) goto L3a
            r0.reset()
            return r3
        L3a:
            r9.m1901a(r0, r6)     // Catch: java.lang.Throwable -> L73
        L3d:
            r2 = r1
            goto L66
        L3f:
            r0.reset()
            return r3
        L43:
            int r4 = r4 + r2
            if (r4 < r10) goto L47
            int r3 = r3 + r1
        L47:
            int r1 = r1 * 2
            int r1 = r1 + 2
            long r4 = (long) r1
            r9.m1901a(r0, r4)     // Catch: java.lang.Throwable -> L73
            goto L66
        L50:
            int r1 = r9.m1902b(r0)     // Catch: java.lang.Throwable -> L73
            if (r3 <= 0) goto L60
            int r2 = r2 >> 16
            int r2 = r2 + 1
            if (r1 == r2) goto L60
            r0.reset()
            return r3
        L60:
            int r1 = r1 << 16
            r9.m1901a(r0, r6)     // Catch: java.lang.Throwable -> L73
            goto L3d
        L66:
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L73
            r4 = 10
            if (r1 == r4) goto L66
            r4 = 13
            if (r1 == r4) goto L66
            goto Lf
        L73:
            r10 = move-exception
            r0.reset()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.alp.m1899a(int):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f1680g - this.f1681h;
    }

    /* JADX INFO: renamed from: a */
    public int m1905a(byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            if (this.f1676c < this.f1678e) {
                byte[] bArr2 = this.f1675b;
                int i2 = this.f1676c;
                this.f1676c = i2 + 1;
                bArr[i] = bArr2[i2];
                i++;
            } else {
                int i3 = this.f1681h;
                int iM1898a = m1898a();
                this.f1678e = iM1898a;
                this.f1681h = i3 + iM1898a;
                if (this.f1678e == 0) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return m1905a(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    /* JADX INFO: renamed from: a */
    private int m1898a() throws IOException {
        if (this.f1677d == -1) {
            return 0;
        }
        InputStream inputStream = this.in;
        while (true) {
            int i = inputStream.read();
            this.f1677d++;
            if (i != 10 && i != 13) {
                m1903b(i);
                int iM1900a = m1900a(inputStream);
                this.f1677d += 2;
                int iM1902b = m1902b(inputStream);
                this.f1677d += 4;
                int iM1900a2 = m1900a(inputStream);
                this.f1677d += 2;
                if (iM1900a2 != 4) {
                    switch (iM1900a2) {
                        case 0:
                            if (this.f1679f + iM1902b < this.f1682i) {
                                this.f1677d = (int) (((long) this.f1677d) + m1901a(inputStream, (iM1900a * 2) + 2));
                                iM1900a2 = -1;
                            }
                            break;
                        case 1:
                            this.f1677d = -1;
                            return 0;
                        case 2:
                            int iM1902b2 = m1902b(inputStream) << 4;
                            this.f1677d += 4;
                            if (this.f1681h > 0 && (iM1902b2 >> 16) != (this.f1679f >> 16) + 1) {
                                return 0;
                            }
                            this.f1679f = iM1902b2;
                            this.f1677d = (int) (((long) this.f1677d) + m1901a(inputStream, 2L));
                            break;
                            break;
                        default:
                            this.f1677d = (int) (((long) this.f1677d) + m1901a(inputStream, (iM1900a * 2) + 2));
                            break;
                    }
                } else {
                    int iM1902b3 = m1902b(inputStream);
                    this.f1677d += 4;
                    if (this.f1681h > 0 && iM1902b3 != (this.f1679f >> 16) + 1) {
                        return 0;
                    }
                    this.f1679f = iM1902b3 << 16;
                    this.f1677d = (int) (((long) this.f1677d) + m1901a(inputStream, 2L));
                }
                if (iM1900a2 == 0) {
                    for (int i2 = 0; i2 < this.f1675b.length && i2 < iM1900a; i2++) {
                        int iM1900a3 = m1900a(inputStream);
                        this.f1677d += 2;
                        this.f1675b[i2] = (byte) iM1900a3;
                    }
                    this.f1677d = (int) (((long) this.f1677d) + m1901a(inputStream, 2L));
                    this.f1676c = 0;
                    return iM1900a;
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f1677d = 0;
        this.f1681h = 0;
        this.f1676c = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m1903b(int i) throws als {
        if (i != 58) {
            throw new als("Not a HEX file");
        }
    }

    /* JADX INFO: renamed from: a */
    private long m1901a(InputStream inputStream, long j) throws IOException {
        long jSkip = inputStream.skip(j);
        return jSkip < j ? jSkip + inputStream.skip(j - jSkip) : jSkip;
    }

    /* JADX INFO: renamed from: a */
    private int m1900a(InputStream inputStream) {
        return m1904c(inputStream.read()) | (m1904c(inputStream.read()) << 4);
    }

    /* JADX INFO: renamed from: b */
    private int m1902b(InputStream inputStream) {
        return m1900a(inputStream) | (m1900a(inputStream) << 8);
    }
}
