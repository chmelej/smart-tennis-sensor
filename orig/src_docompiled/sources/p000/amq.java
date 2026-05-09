package p000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: Cookie.java */
/* JADX INFO: loaded from: classes.dex */
public final class amq {

    /* JADX INFO: renamed from: a */
    private static final Pattern f1893a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b */
    private static final Pattern f1894b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: c */
    private static final Pattern f1895c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: d */
    private static final Pattern f1896d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: e */
    private final String f1897e;

    /* JADX INFO: renamed from: f */
    private final String f1898f;

    /* JADX INFO: renamed from: g */
    private final long f1899g;

    /* JADX INFO: renamed from: h */
    private final String f1900h;

    /* JADX INFO: renamed from: i */
    private final String f1901i;

    /* JADX INFO: renamed from: j */
    private final boolean f1902j;

    /* JADX INFO: renamed from: k */
    private final boolean f1903k;

    /* JADX INFO: renamed from: l */
    private final boolean f1904l;

    /* JADX INFO: renamed from: m */
    private final boolean f1905m;

    private amq(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1897e = str;
        this.f1898f = str2;
        this.f1899g = j;
        this.f1900h = str3;
        this.f1901i = str4;
        this.f1902j = z;
        this.f1903k = z2;
        this.f1905m = z3;
        this.f1904l = z4;
    }

    /* JADX INFO: renamed from: a */
    public String m2009a() {
        return this.f1897e;
    }

    /* JADX INFO: renamed from: b */
    public String m2011b() {
        return this.f1898f;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2007a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !anm.m4520c(str);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static amq m2005a(amy amyVar, String str) {
        return m2004a(System.currentTimeMillis(), amyVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9 A[PHI: r2
      0x00c9: PHI (r2v8 long) = (r2v1 long), (r2v5 long) binds: [B:42:0x00c7, B:53:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    @javax.annotation.Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static p000.amq m2004a(long r26, p000.amy r28, java.lang.String r29) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.amq.m2004a(long, amy, java.lang.String):amq");
    }

    /* JADX INFO: renamed from: a */
    private static long m2003a(String str, int i, int i2) {
        int iM2001a = m2001a(str, i, i2, false);
        Matcher matcher = f1896d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iM2001a < i2) {
            int iM2001a2 = m2001a(str, iM2001a + 1, i2, true);
            matcher.region(iM2001a, iM2001a2);
            if (i3 == -1 && matcher.usePattern(f1896d).matches()) {
                int i8 = Integer.parseInt(matcher.group(1));
                int i9 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
                i6 = i9;
                i3 = i8;
            } else if (i5 == -1 && matcher.usePattern(f1895c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1 && matcher.usePattern(f1894b).matches()) {
                iIndexOf = f1894b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f1893a).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            iM2001a = m2001a(str, iM2001a2 + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(anm.f4213g);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i4);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX INFO: renamed from: a */
    private static int m2001a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private static long m2002a(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m2008b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strM4497a = anm.m4497a(str);
        if (strM4497a == null) {
            throw new IllegalArgumentException();
        }
        return strM4497a;
    }

    /* JADX INFO: renamed from: a */
    public static List<amq> m2006a(amy amyVar, amx amxVar) {
        List<String> listM2057b = amxVar.m2057b("Set-Cookie");
        int size = listM2057b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            amq amqVarM2005a = m2005a(amyVar, listM2057b.get(i));
            if (amqVarM2005a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(amqVarM2005a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return m2010a(false);
    }

    /* JADX INFO: renamed from: a */
    String m2010a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1897e);
        sb.append('=');
        sb.append(this.f1898f);
        if (this.f1904l) {
            if (this.f1899g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(aod.m4615a(new Date(this.f1899g)));
            }
        }
        if (!this.f1905m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f1900h);
        }
        sb.append("; path=");
        sb.append(this.f1901i);
        if (this.f1902j) {
            sb.append("; secure");
        }
        if (this.f1903k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof amq)) {
            return false;
        }
        amq amqVar = (amq) obj;
        return amqVar.f1897e.equals(this.f1897e) && amqVar.f1898f.equals(this.f1898f) && amqVar.f1900h.equals(this.f1900h) && amqVar.f1901i.equals(this.f1901i) && amqVar.f1899g == this.f1899g && amqVar.f1902j == this.f1902j && amqVar.f1903k == this.f1903k && amqVar.f1904l == this.f1904l && amqVar.f1905m == this.f1905m;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f1897e.hashCode()) * 31) + this.f1898f.hashCode()) * 31) + this.f1900h.hashCode()) * 31) + this.f1901i.hashCode()) * 31) + ((int) (this.f1899g ^ (this.f1899g >>> 32)))) * 31) + (!this.f1902j ? 1 : 0)) * 31) + (!this.f1903k ? 1 : 0)) * 31) + (!this.f1904l ? 1 : 0)) * 31) + (!this.f1905m ? 1 : 0);
    }
}
