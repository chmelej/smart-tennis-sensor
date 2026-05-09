package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes.dex */
public final class amx {

    /* JADX INFO: renamed from: a */
    private final String[] f1921a;

    amx(C0209a c0209a) {
        this.f1921a = (String[]) c0209a.f1922a.toArray(new String[c0209a.f1922a.size()]);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public String m2054a(String str) {
        return m2051a(this.f1921a, str);
    }

    /* JADX INFO: renamed from: a */
    public int m2052a() {
        return this.f1921a.length / 2;
    }

    /* JADX INFO: renamed from: a */
    public String m2053a(int i) {
        return this.f1921a[i * 2];
    }

    /* JADX INFO: renamed from: b */
    public String m2056b(int i) {
        return this.f1921a[(i * 2) + 1];
    }

    /* JADX INFO: renamed from: b */
    public List<String> m2057b(String str) {
        int iM2052a = m2052a();
        ArrayList arrayList = null;
        for (int i = 0; i < iM2052a; i++) {
            if (str.equalsIgnoreCase(m2053a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m2056b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: renamed from: b */
    public C0209a m2055b() {
        C0209a c0209a = new C0209a();
        Collections.addAll(c0209a.f1922a, this.f1921a);
        return c0209a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof amx) && Arrays.equals(((amx) obj).f1921a, this.f1921a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1921a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM2052a = m2052a();
        for (int i = 0; i < iM2052a; i++) {
            sb.append(m2053a(i));
            sb.append(": ");
            sb.append(m2056b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m2051a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: amx$a */
    /* JADX INFO: compiled from: Headers.java */
    public static final class C0209a {

        /* JADX INFO: renamed from: a */
        final List<String> f1922a = new ArrayList(20);

        /* JADX INFO: renamed from: a */
        C0209a m2059a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return m2063b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return m2063b("", str.substring(1));
            }
            return m2063b("", str);
        }

        /* JADX INFO: renamed from: a */
        public C0209a m2060a(String str, String str2) {
            m2058d(str, str2);
            return m2063b(str, str2);
        }

        /* JADX INFO: renamed from: b */
        C0209a m2063b(String str, String str2) {
            this.f1922a.add(str);
            this.f1922a.add(str2.trim());
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0209a m2062b(String str) {
            int i = 0;
            while (i < this.f1922a.size()) {
                if (str.equalsIgnoreCase(this.f1922a.get(i))) {
                    this.f1922a.remove(i);
                    this.f1922a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C0209a m2064c(String str, String str2) {
            m2058d(str, str2);
            m2062b(str);
            m2063b(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: d */
        private void m2058d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(anm.m4498a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(anm.m4498a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public amx m2061a() {
            return new amx(this);
        }
    }
}
