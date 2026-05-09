package p000;

/* JADX INFO: renamed from: nd */
/* JADX INFO: compiled from: Hex.java */
/* JADX INFO: loaded from: classes.dex */
public class C1932nd {

    /* JADX INFO: renamed from: a */
    private static final char[] f11723a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a */
    public static String m10729a(byte[] bArr) {
        return m10730a(bArr, 0);
    }

    /* JADX INFO: renamed from: a */
    public static String m10730a(byte[] bArr, int i) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1) + (i > 0 ? length / i : 0)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i > 0 && i3 % i == 0 && i2 > 0) {
                cArr[i2] = '-';
                i2++;
            }
            int i4 = i2 + 1;
            cArr[i2] = f11723a[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = f11723a[bArr[i3] & 15];
        }
        return new String(cArr);
    }
}
