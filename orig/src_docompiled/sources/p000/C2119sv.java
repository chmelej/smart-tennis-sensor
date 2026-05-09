package p000;

import java.util.Arrays;

/* JADX INFO: renamed from: sv */
/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2119sv {

    /* JADX INFO: renamed from: a */
    private final String[] f12699a;

    private C2119sv(String[] strArr) {
        this.f12699a = strArr;
    }

    /* JADX INFO: renamed from: a */
    private static String m11587a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static C2119sv m11588a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new C2119sv(strArr2);
    }

    /* JADX INFO: renamed from: a */
    public String m11591a(String str) {
        return m11587a(this.f12699a, str);
    }

    /* JADX INFO: renamed from: a */
    public int m11589a() {
        return this.f12699a.length / 2;
    }

    /* JADX INFO: renamed from: a */
    public String m11590a(int i) {
        return this.f12699a[i * 2];
    }

    /* JADX INFO: renamed from: b */
    public String m11592b(int i) {
        return this.f12699a[(i * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2119sv) && Arrays.equals(((C2119sv) obj).f12699a, this.f12699a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12699a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM11589a = m11589a();
        for (int i = 0; i < iM11589a; i++) {
            sb.append(m11590a(i));
            sb.append(": ");
            sb.append(m11592b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
