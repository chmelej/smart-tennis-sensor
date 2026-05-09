package p000;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: compiled from: PublicSuffixDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public final class api {

    /* JADX INFO: renamed from: a */
    private static final byte[] f4588a = {42};

    /* JADX INFO: renamed from: b */
    private static final String[] f4589b = new String[0];

    /* JADX INFO: renamed from: c */
    private static final String[] f4590c = {"*"};

    /* JADX INFO: renamed from: d */
    private static final api f4591d = new api();

    /* JADX INFO: renamed from: e */
    private final AtomicBoolean f4592e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f */
    private final CountDownLatch f4593f = new CountDownLatch(1);

    /* JADX INFO: renamed from: g */
    private byte[] f4594g;

    /* JADX INFO: renamed from: h */
    private byte[] f4595h;

    /* JADX INFO: renamed from: a */
    public static api m4855a() {
        return f4591d;
    }

    /* JADX INFO: renamed from: a */
    public String m4860a(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrM4857a = m4857a(strArrSplit);
        if (strArrSplit.length == strArrM4857a.length && strArrM4857a[0].charAt(0) != '!') {
            return null;
        }
        if (strArrM4857a[0].charAt(0) == '!') {
            length = strArrSplit.length - strArrM4857a.length;
        } else {
            length = strArrSplit.length - (strArrM4857a.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        while (length < strArrSplit2.length) {
            sb.append(strArrSplit2[length]);
            sb.append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private String[] m4857a(String[] strArr) {
        String strM4856a;
        String strM4856a2;
        String strM4856a3;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (!this.f4592e.get() && this.f4592e.compareAndSet(false, true)) {
            m4858b();
        } else {
            try {
                this.f4593f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.f4594g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(anm.f4211e);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                strM4856a = null;
                break;
            }
            strM4856a = m4856a(this.f4594g, bArr, i2);
            if (strM4856a != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f4588a;
                strM4856a2 = m4856a(this.f4594g, bArr2, i3);
                if (strM4856a2 != null) {
                    break;
                }
            }
            strM4856a2 = null;
        } else {
            strM4856a2 = null;
        }
        if (strM4856a2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                strM4856a3 = m4856a(this.f4595h, bArr, i4);
                if (strM4856a3 != null) {
                    break;
                }
            }
            strM4856a3 = null;
        } else {
            strM4856a3 = null;
        }
        if (strM4856a3 != null) {
            return ("!" + strM4856a3).split("\\.");
        }
        if (strM4856a == null && strM4856a2 == null) {
            return f4590c;
        }
        if (strM4856a != null) {
            strArrSplit = strM4856a.split("\\.");
        } else {
            strArrSplit = f4589b;
        }
        if (strM4856a2 != null) {
            strArrSplit2 = strM4856a2.split("\\.");
        } else {
            strArrSplit2 = f4589b;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    /* JADX INFO: renamed from: a */
    private static String m4856a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, anm.f4211e);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private void m4858b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m4859c();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    aph.m4853c().mo4825a(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4859c() {
        InputStream resourceAsStream = api.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr);
            byte[] bArr2 = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr2);
            synchronized (this) {
                this.f4594g = bArr;
                this.f4595h = bArr2;
            }
            this.f4593f.countDown();
        } finally {
            anm.m4506a(bufferedSourceBuffer);
        }
    }
}
