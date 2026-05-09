package cn.sharesdk.framework.utils;

/* JADX INFO: renamed from: cn.sharesdk.framework.utils.b */
/* JADX INFO: compiled from: PercentEscaper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0849b extends AbstractC0852e {

    /* JADX INFO: renamed from: a */
    private static final char[] f5706a = {'+'};

    /* JADX INFO: renamed from: b */
    private static final char[] f5707b = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: c */
    private final boolean f5708c;

    /* JADX INFO: renamed from: d */
    private final boolean[] f5709d;

    public C0849b(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.f5708c = z;
        this.f5709d = m6191a(str);
    }

    /* JADX INFO: renamed from: a */
    private static boolean[] m6191a(String str) {
        char[] charArray = str.toCharArray();
        int iMax = 122;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            zArr[i2] = true;
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            zArr[i3] = true;
        }
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    @Override // cn.sharesdk.framework.utils.AbstractC0852e
    /* JADX INFO: renamed from: a */
    protected int mo6192a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt >= this.f5709d.length || !this.f5709d[cCharAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override // cn.sharesdk.framework.utils.AbstractC0852e, cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= this.f5709d.length || !this.f5709d[cCharAt]) {
                return m6199a(str, i);
            }
        }
        return str;
    }

    @Override // cn.sharesdk.framework.utils.AbstractC0852e
    /* JADX INFO: renamed from: a */
    protected char[] mo6193a(int i) {
        if (i < this.f5709d.length && this.f5709d[i]) {
            return null;
        }
        if (i == 32 && this.f5708c) {
            return f5706a;
        }
        if (i <= 127) {
            return new char[]{'%', f5707b[i >>> 4], f5707b[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr = {'%', f5707b[(i >>> 4) | 12], f5707b[i & 15], '%', f5707b[(i & 3) | 8], f5707b[i & 15]};
            int i2 = i >>> 4;
            int i3 = i2 >>> 2;
            return cArr;
        }
        if (i <= 65535) {
            char[] cArr2 = {'%', 'E', cArr[i >>> 2], '%', f5707b[(i & 3) | 8], f5707b[i & 15], '%', f5707b[(i & 3) | 8], f5707b[i & 15]};
            int i4 = i >>> 4;
            int i5 = i4 >>> 2;
            int i6 = i5 >>> 4;
            char[] cArr3 = f5707b;
            return cArr2;
        }
        if (i <= 1114111) {
            char[] cArr4 = {'%', 'F', f5707b[(i >>> 2) & 7], '%', f5707b[(i & 3) | 8], f5707b[i & 15], '%', f5707b[(i & 3) | 8], f5707b[i & 15], '%', f5707b[(i & 3) | 8], f5707b[i & 15]};
            int i7 = i >>> 4;
            int i8 = i7 >>> 2;
            int i9 = i8 >>> 4;
            int i10 = i9 >>> 2;
            int i11 = i10 >>> 4;
            return cArr4;
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i);
    }
}
