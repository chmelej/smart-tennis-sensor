package cn.sharesdk.tencent.weibo;

/* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.a */
/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes.dex */
public class C0889a {
    /* JADX INFO: renamed from: a */
    protected static char m6418a(int i) {
        if (i >= 0 && i <= 25) {
            return (char) (i + 65);
        }
        if (i >= 26 && i <= 51) {
            return (char) ((i - 26) + 97);
        }
        if (i >= 52 && i <= 61) {
            return (char) ((i - 52) + 48);
        }
        if (i == 62) {
            return '+';
        }
        return i == 63 ? '/' : '?';
    }

    /* JADX INFO: renamed from: a */
    public static String m6419a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i += 3) {
            stringBuffer.append(m6420a(bArr, i));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    protected static char[] m6420a(byte[] bArr, int i) {
        int length = (bArr.length - i) - 1;
        int i2 = length >= 2 ? 2 : length;
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            int i5 = bArr[i + i4];
            if (i5 < 0) {
                i5 += 256;
            }
            i3 += i5 << ((2 - i4) * 8);
        }
        char[] cArr = new char[4];
        for (int i6 = 0; i6 < 4; i6++) {
            cArr[i6] = m6418a((i3 >>> ((3 - i6) * 6)) & 63);
        }
        if (length < 1) {
            cArr[2] = '=';
        }
        if (length < 2) {
            cArr[3] = '=';
        }
        return cArr;
    }
}
