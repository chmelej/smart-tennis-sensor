package p000;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: MediaType.java */
/* JADX INFO: loaded from: classes.dex */
public final class ana {

    /* JADX INFO: renamed from: a */
    private static final Pattern f1941a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b */
    private static final Pattern f1942b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c */
    private final String f1943c;

    /* JADX INFO: renamed from: d */
    private final String f1944d;

    /* JADX INFO: renamed from: e */
    private final String f1945e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private final String f1946f;

    private ana(String str, String str2, String str3, @Nullable String str4) {
        this.f1943c = str;
        this.f1944d = str2;
        this.f1945e = str3;
        this.f1946f = str4;
    }

    /* JADX INFO: renamed from: a */
    public static ana m2122a(String str) {
        Matcher matcher = f1941a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = f1942b.matcher(str);
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 != null) {
                    if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                        strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    }
                } else {
                    strGroup2 = matcher2.group(3);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup2 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup2;
            }
        }
        return new ana(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static ana m2123b(String str) {
        try {
            return m2122a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m2124a() {
        return this.f1944d;
    }

    /* JADX INFO: renamed from: b */
    public String m2126b() {
        return this.f1945e;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public Charset m2127c() {
        return m2125a((Charset) null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Charset m2125a(@Nullable Charset charset) {
        try {
            return this.f1946f != null ? Charset.forName(this.f1946f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f1943c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ana) && ((ana) obj).f1943c.equals(this.f1943c);
    }

    public int hashCode() {
        return this.f1943c.hashCode();
    }
}
