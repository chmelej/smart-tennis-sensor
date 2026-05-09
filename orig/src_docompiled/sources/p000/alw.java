package p000;

/* JADX INFO: compiled from: UnknownResponseException.java */
/* JADX INFO: loaded from: classes.dex */
public class alw extends Exception {

    /* JADX INFO: renamed from: a */
    private static final char[] f1686a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b */
    private final byte[] f1687b;

    /* JADX INFO: renamed from: c */
    private final int f1688c;

    /* JADX INFO: renamed from: d */
    private final int f1689d;

    public alw(String str, byte[] bArr, int i, int i2) {
        super(str);
        this.f1687b = bArr == null ? new byte[0] : bArr;
        this.f1688c = i;
        this.f1689d = i2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("%s (response: %s, expected: 0x%02X%02X..)", super.getMessage(), m1909a(this.f1687b, 0, this.f1687b.length), Integer.valueOf(this.f1688c), Integer.valueOf(this.f1689d));
    }

    /* JADX INFO: renamed from: a */
    public static String m1909a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= i || i2 <= 0) {
            return "";
        }
        int iMin = Math.min(i2, bArr.length - i);
        char[] cArr = new char[iMin * 2];
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = bArr[i + i3] & 255;
            int i5 = i3 * 2;
            cArr[i5] = f1686a[i4 >>> 4];
            cArr[i5 + 1] = f1686a[i4 & 15];
        }
        return "0x" + new String(cArr);
    }
}
