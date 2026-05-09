package p000;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okio.Buffer;

/* JADX INFO: compiled from: HttpUrl.java */
/* JADX INFO: loaded from: classes.dex */
public final class amy {

    /* JADX INFO: renamed from: d */
    private static final char[] f1923d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a */
    final String f1924a;

    /* JADX INFO: renamed from: b */
    final String f1925b;

    /* JADX INFO: renamed from: c */
    final int f1926c;

    /* JADX INFO: renamed from: e */
    private final String f1927e;

    /* JADX INFO: renamed from: f */
    private final String f1928f;

    /* JADX INFO: renamed from: g */
    private final List<String> f1929g;

    /* JADX INFO: renamed from: h */
    @Nullable
    private final List<String> f1930h;

    /* JADX INFO: renamed from: i */
    @Nullable
    private final String f1931i;

    /* JADX INFO: renamed from: j */
    private final String f1932j;

    amy(C0210a c0210a) {
        this.f1924a = c0210a.f1933a;
        this.f1927e = m2069a(c0210a.f1934b, false);
        this.f1928f = m2069a(c0210a.f1935c, false);
        this.f1925b = c0210a.f1936d;
        this.f1926c = c0210a.m2104a();
        this.f1929g = m2070a(c0210a.f1938f, false);
        this.f1930h = c0210a.f1939g != null ? m2070a(c0210a.f1939g, true) : null;
        this.f1931i = c0210a.f1940h != null ? m2069a(c0210a.f1940h, false) : null;
        this.f1932j = c0210a.toString();
    }

    /* JADX INFO: renamed from: a */
    public URI m2078a() {
        String string = m2093n().m2108b().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public String m2079b() {
        return this.f1924a;
    }

    /* JADX INFO: renamed from: c */
    public boolean m2081c() {
        return this.f1924a.equals("https");
    }

    /* JADX INFO: renamed from: d */
    public String m2083d() {
        if (this.f1927e.isEmpty()) {
            return "";
        }
        int length = this.f1924a.length() + 3;
        return this.f1932j.substring(length, anm.m4492a(this.f1932j, length, this.f1932j.length(), ":@"));
    }

    /* JADX INFO: renamed from: e */
    public String m2084e() {
        if (this.f1928f.isEmpty()) {
            return "";
        }
        return this.f1932j.substring(this.f1932j.indexOf(58, this.f1924a.length() + 3) + 1, this.f1932j.indexOf(64));
    }

    /* JADX INFO: renamed from: f */
    public String m2085f() {
        return this.f1925b;
    }

    /* JADX INFO: renamed from: g */
    public int m2086g() {
        return this.f1926c;
    }

    /* JADX INFO: renamed from: a */
    public static int m2065a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX INFO: renamed from: h */
    public String m2087h() {
        int iIndexOf = this.f1932j.indexOf(47, this.f1924a.length() + 3);
        return this.f1932j.substring(iIndexOf, anm.m4492a(this.f1932j, iIndexOf, this.f1932j.length(), "?#"));
    }

    /* JADX INFO: renamed from: a */
    static void m2071a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* JADX INFO: renamed from: i */
    public List<String> m2088i() {
        int iIndexOf = this.f1932j.indexOf(47, this.f1924a.length() + 3);
        int iM4492a = anm.m4492a(this.f1932j, iIndexOf, this.f1932j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM4492a) {
            int i = iIndexOf + 1;
            int iM4491a = anm.m4491a(this.f1932j, i, iM4492a, '/');
            arrayList.add(this.f1932j.substring(i, iM4491a));
            iIndexOf = iM4491a;
        }
        return arrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public String m2089j() {
        if (this.f1930h == null) {
            return null;
        }
        int iIndexOf = this.f1932j.indexOf(63) + 1;
        return this.f1932j.substring(iIndexOf, anm.m4491a(this.f1932j, iIndexOf, this.f1932j.length(), '#'));
    }

    /* JADX INFO: renamed from: b */
    static void m2076b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static List<String> m2075b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public String m2090k() {
        if (this.f1930h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m2076b(sb, this.f1930h);
        return sb.toString();
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public String m2091l() {
        if (this.f1931i == null) {
            return null;
        }
        return this.f1932j.substring(this.f1932j.indexOf(35) + 1);
    }

    /* JADX INFO: renamed from: m */
    public String m2092m() {
        return m2082d("/...").m2109b("").m2110c("").m2111c().toString();
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public amy m2080c(String str) {
        C0210a c0210aM2082d = m2082d(str);
        if (c0210aM2082d != null) {
            return c0210aM2082d.m2111c();
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public C0210a m2093n() {
        C0210a c0210a = new C0210a();
        c0210a.f1933a = this.f1924a;
        c0210a.f1934b = m2083d();
        c0210a.f1935c = m2084e();
        c0210a.f1936d = this.f1925b;
        c0210a.f1937e = this.f1926c != m2065a(this.f1924a) ? this.f1926c : -1;
        c0210a.f1938f.clear();
        c0210a.f1938f.addAll(m2088i());
        c0210a.m2113e(m2089j());
        c0210a.f1940h = m2091l();
        return c0210a;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0210a m2082d(String str) {
        try {
            return new C0210a().m2106a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static amy m2077e(String str) {
        return new C0210a().m2106a(null, str).m2111c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof amy) && ((amy) obj).f1932j.equals(this.f1932j);
    }

    public int hashCode() {
        return this.f1932j.hashCode();
    }

    public String toString() {
        return this.f1932j;
    }

    /* JADX INFO: renamed from: amy$a */
    /* JADX INFO: compiled from: HttpUrl.java */
    public static final class C0210a {

        /* JADX INFO: renamed from: a */
        @Nullable
        String f1933a;

        /* JADX INFO: renamed from: d */
        @Nullable
        String f1936d;

        /* JADX INFO: renamed from: g */
        @Nullable
        List<String> f1939g;

        /* JADX INFO: renamed from: h */
        @Nullable
        String f1940h;

        /* JADX INFO: renamed from: b */
        String f1934b = "";

        /* JADX INFO: renamed from: c */
        String f1935c = "";

        /* JADX INFO: renamed from: e */
        int f1937e = -1;

        /* JADX INFO: renamed from: f */
        final List<String> f1938f = new ArrayList();

        public C0210a() {
            this.f1938f.add("");
        }

        /* JADX INFO: renamed from: a */
        public C0210a m2107a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f1933a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f1933a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0210a m2109b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f1934b = amy.m2068a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C0210a m2110c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f1935c = amy.m2068a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* JADX INFO: renamed from: d */
        public C0210a m2112d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strM2100e = m2100e(str, 0, str.length());
            if (strM2100e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f1936d = strM2100e;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0210a m2105a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f1937e = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        int m2104a() {
            return this.f1937e != -1 ? this.f1937e : amy.m2065a(this.f1933a);
        }

        /* JADX INFO: renamed from: e */
        public C0210a m2113e(@Nullable String str) {
            this.f1939g = str != null ? amy.m2075b(amy.m2068a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* JADX INFO: renamed from: b */
        C0210a m2108b() {
            int size = this.f1938f.size();
            for (int i = 0; i < size; i++) {
                this.f1938f.set(i, amy.m2068a(this.f1938f.get(i), "[]", true, true, false, true));
            }
            if (this.f1939g != null) {
                int size2 = this.f1939g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f1939g.get(i2);
                    if (str != null) {
                        this.f1939g.set(i2, amy.m2068a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f1940h != null) {
                this.f1940h = amy.m2068a(this.f1940h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* JADX INFO: renamed from: c */
        public amy m2111c() {
            if (this.f1933a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f1936d == null) {
                throw new IllegalStateException("host == null");
            }
            return new amy(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1933a);
            sb.append("://");
            if (!this.f1934b.isEmpty() || !this.f1935c.isEmpty()) {
                sb.append(this.f1934b);
                if (!this.f1935c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f1935c);
                }
                sb.append('@');
            }
            if (this.f1936d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1936d);
                sb.append(']');
            } else {
                sb.append(this.f1936d);
            }
            int iM2104a = m2104a();
            if (iM2104a != amy.m2065a(this.f1933a)) {
                sb.append(':');
                sb.append(iM2104a);
            }
            amy.m2071a(sb, this.f1938f);
            if (this.f1939g != null) {
                sb.append('?');
                amy.m2076b(sb, this.f1939g);
            }
            if (this.f1940h != null) {
                sb.append('#');
                sb.append(this.f1940h);
            }
            return sb.toString();
        }

        /* JADX INFO: renamed from: a */
        C0210a m2106a(@Nullable amy amyVar, String str) {
            int iM4492a;
            int i;
            int i2;
            int iM4491a;
            int iM4490a = anm.m4490a(str, 0, str.length());
            int iM4516b = anm.m4516b(str, iM4490a, str.length());
            int iM2096b = m2096b(str, iM4490a, iM4516b);
            if (iM2096b != -1) {
                if (str.regionMatches(true, iM4490a, "https:", 0, 6)) {
                    this.f1933a = "https";
                    iM4490a += "https:".length();
                } else if (str.regionMatches(true, iM4490a, "http:", 0, 5)) {
                    this.f1933a = "http";
                    iM4490a += "http:".length();
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iM2096b) + "'");
                }
            } else if (amyVar != null) {
                this.f1933a = amyVar.f1924a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iM2097c = m2097c(str, iM4490a, iM4516b);
            char c = '#';
            if (iM2097c >= 2 || amyVar == null || !amyVar.f1924a.equals(this.f1933a)) {
                int i3 = iM4490a + iM2097c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iM4492a = anm.m4492a(str, i3, iM4516b, "@/\\?#");
                    byte bCharAt = iM4492a != iM4516b ? str.charAt(iM4492a) : (byte) -1;
                    if (bCharAt != -1 && bCharAt != c && bCharAt != 47 && bCharAt != 92) {
                        switch (bCharAt) {
                            case 63:
                                break;
                            case 64:
                                if (!z) {
                                    int iM4491a2 = anm.m4491a(str, i3, iM4492a, ':');
                                    i2 = iM4492a;
                                    String strM2066a = amy.m2066a(str, i3, iM4491a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    if (z2) {
                                        strM2066a = this.f1934b + "%40" + strM2066a;
                                    }
                                    this.f1934b = strM2066a;
                                    if (iM4491a2 != i2) {
                                        this.f1935c = amy.m2066a(str, iM4491a2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i2 = iM4492a;
                                    this.f1935c += "%40" + amy.m2066a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                }
                                i3 = i2 + 1;
                                continue;
                                c = '#';
                                break;
                            default:
                                c = '#';
                                break;
                        }
                    }
                }
                i = iM4492a;
                int iM2098d = m2098d(str, i3, i);
                int i4 = iM2098d + 1;
                if (i4 < i) {
                    this.f1936d = m2100e(str, i3, iM2098d);
                    this.f1937e = m2101f(str, i4, i);
                    if (this.f1937e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, i) + '\"');
                    }
                } else {
                    this.f1936d = m2100e(str, i3, iM2098d);
                    this.f1937e = amy.m2065a(this.f1933a);
                }
                if (this.f1936d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, iM2098d) + '\"');
                }
            } else {
                this.f1934b = amyVar.m2083d();
                this.f1935c = amyVar.m2084e();
                this.f1936d = amyVar.f1925b;
                this.f1937e = amyVar.f1926c;
                this.f1938f.clear();
                this.f1938f.addAll(amyVar.m2088i());
                if (iM4490a == iM4516b || str.charAt(iM4490a) == '#') {
                    m2113e(amyVar.m2089j());
                }
                i = iM4490a;
            }
            int iM4492a2 = anm.m4492a(str, i, iM4516b, "?#");
            m2094a(str, i, iM4492a2);
            if (iM4492a2 >= iM4516b || str.charAt(iM4492a2) != '?') {
                iM4491a = iM4492a2;
            } else {
                iM4491a = anm.m4491a(str, iM4492a2, iM4516b, '#');
                this.f1939g = amy.m2075b(amy.m2066a(str, iM4492a2 + 1, iM4491a, " \"'<>#", true, false, true, true, null));
            }
            if (iM4491a < iM4516b && str.charAt(iM4491a) == '#') {
                this.f1940h = amy.m2066a(str, iM4491a + 1, iM4516b, "", true, false, false, false, null);
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        private void m2094a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f1938f.clear();
                this.f1938f.add("");
                i++;
            } else {
                this.f1938f.set(this.f1938f.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = anm.m4492a(str, i3, i2, "/\\");
                boolean z = i < i2;
                m2095a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m2095a(String str, int i, int i2, boolean z, boolean z2) {
            String strM2066a = amy.m2066a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (m2102f(strM2066a)) {
                return;
            }
            if (m2103g(strM2066a)) {
                m2099d();
                return;
            }
            if (this.f1938f.get(this.f1938f.size() - 1).isEmpty()) {
                this.f1938f.set(this.f1938f.size() - 1, strM2066a);
            } else {
                this.f1938f.add(strM2066a);
            }
            if (z) {
                this.f1938f.add("");
            }
        }

        /* JADX INFO: renamed from: f */
        private boolean m2102f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* JADX INFO: renamed from: g */
        private boolean m2103g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* JADX INFO: renamed from: d */
        private void m2099d() {
            if (this.f1938f.remove(this.f1938f.size() - 1).isEmpty() && !this.f1938f.isEmpty()) {
                this.f1938f.set(this.f1938f.size() - 1, "");
            } else {
                this.f1938f.add("");
            }
        }

        /* JADX INFO: renamed from: b */
        private static int m2096b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                if (cCharAt2 == ':') {
                                    return i;
                                }
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: c */
        private static int m2097c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX INFO: renamed from: d */
        private static int m2098d(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* JADX INFO: renamed from: e */
        private static String m2100e(String str, int i, int i2) {
            return anm.m4497a(amy.m2067a(str, i, i2, false));
        }

        /* JADX INFO: renamed from: f */
        private static int m2101f(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(amy.m2066a(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static String m2069a(String str, boolean z) {
        return m2067a(str, 0, str.length(), z);
    }

    /* JADX INFO: renamed from: a */
    private List<String> m2070a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m2069a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: a */
    static String m2067a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                m2073a(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m2073a(okio.Buffer r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = p000.anm.m4489a(r2)
            char r3 = r6.charAt(r1)
            int r3 = p000.anm.m4489a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.writeUtf8CodePoint(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.amy.m2073a(okio.Buffer, java.lang.String, int, int, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    static boolean m2074a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && anm.m4489a(str.charAt(i + 1)) != -1 && anm.m4489a(str.charAt(i3)) != -1;
    }

    /* JADX INFO: renamed from: a */
    static String m2066a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3;
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                str3 = str2;
                if (str3.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || m2074a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, iCharCount);
                    m2072a(buffer, str, iCharCount, i2, str3, z, z2, z3, z4, charset);
                    return buffer.readUtf8();
                }
            } else {
                str3 = str2;
                Buffer buffer2 = new Buffer();
                buffer2.writeUtf8(str, i, iCharCount);
                m2072a(buffer2, str, iCharCount, i2, str3, z, z2, z3, z4, charset);
                return buffer2.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: renamed from: a */
    static void m2072a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !m2074a(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(anm.f4211e)) {
                        buffer2.writeUtf8CodePoint(iCodePointAt);
                    } else {
                        buffer2.writeString(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!buffer2.exhausted()) {
                        int i3 = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f1923d[(i3 >> 4) & 15]);
                        buffer.writeByte((int) f1923d[i3 & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    /* JADX INFO: renamed from: a */
    static String m2068a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m2066a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
