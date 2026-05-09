package p000;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: CacheControl.java */
/* JADX INFO: loaded from: classes.dex */
public final class ami {

    /* JADX INFO: renamed from: a */
    public static final ami f1723a = new C0198a().m1960a().m1963c();

    /* JADX INFO: renamed from: b */
    public static final ami f1724b = new C0198a().m1962b().m1961a(Integer.MAX_VALUE, TimeUnit.SECONDS).m1963c();

    /* JADX INFO: renamed from: c */
    @Nullable
    String f1725c;

    /* JADX INFO: renamed from: d */
    private final boolean f1726d;

    /* JADX INFO: renamed from: e */
    private final boolean f1727e;

    /* JADX INFO: renamed from: f */
    private final int f1728f;

    /* JADX INFO: renamed from: g */
    private final int f1729g;

    /* JADX INFO: renamed from: h */
    private final boolean f1730h;

    /* JADX INFO: renamed from: i */
    private final boolean f1731i;

    /* JADX INFO: renamed from: j */
    private final boolean f1732j;

    /* JADX INFO: renamed from: k */
    private final int f1733k;

    /* JADX INFO: renamed from: l */
    private final int f1734l;

    /* JADX INFO: renamed from: m */
    private final boolean f1735m;

    /* JADX INFO: renamed from: n */
    private final boolean f1736n;

    /* JADX INFO: renamed from: o */
    private final boolean f1737o;

    private ami(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f1726d = z;
        this.f1727e = z2;
        this.f1728f = i;
        this.f1729g = i2;
        this.f1730h = z3;
        this.f1731i = z4;
        this.f1732j = z5;
        this.f1733k = i3;
        this.f1734l = i4;
        this.f1735m = z6;
        this.f1736n = z7;
        this.f1737o = z8;
        this.f1725c = str;
    }

    ami(C0198a c0198a) {
        this.f1726d = c0198a.f1738a;
        this.f1727e = c0198a.f1739b;
        this.f1728f = c0198a.f1740c;
        this.f1729g = -1;
        this.f1730h = false;
        this.f1731i = false;
        this.f1732j = false;
        this.f1733k = c0198a.f1741d;
        this.f1734l = c0198a.f1742e;
        this.f1735m = c0198a.f1743f;
        this.f1736n = c0198a.f1744g;
        this.f1737o = c0198a.f1745h;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1950a() {
        return this.f1726d;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1951b() {
        return this.f1727e;
    }

    /* JADX INFO: renamed from: c */
    public int m1952c() {
        return this.f1728f;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1953d() {
        return this.f1730h;
    }

    /* JADX INFO: renamed from: e */
    public boolean m1954e() {
        return this.f1731i;
    }

    /* JADX INFO: renamed from: f */
    public boolean m1955f() {
        return this.f1732j;
    }

    /* JADX INFO: renamed from: g */
    public int m1956g() {
        return this.f1733k;
    }

    /* JADX INFO: renamed from: h */
    public int m1957h() {
        return this.f1734l;
    }

    /* JADX INFO: renamed from: i */
    public boolean m1958i() {
        return this.f1735m;
    }

    /* JADX INFO: renamed from: j */
    public boolean m1959j() {
        return this.f1737o;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000.ami m1948a(p000.amx r24) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ami.m1948a(amx):ami");
    }

    public String toString() {
        String str = this.f1725c;
        if (str != null) {
            return str;
        }
        String strM1949k = m1949k();
        this.f1725c = strM1949k;
        return strM1949k;
    }

    /* JADX INFO: renamed from: k */
    private String m1949k() {
        StringBuilder sb = new StringBuilder();
        if (this.f1726d) {
            sb.append("no-cache, ");
        }
        if (this.f1727e) {
            sb.append("no-store, ");
        }
        if (this.f1728f != -1) {
            sb.append("max-age=");
            sb.append(this.f1728f);
            sb.append(", ");
        }
        if (this.f1729g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1729g);
            sb.append(", ");
        }
        if (this.f1730h) {
            sb.append("private, ");
        }
        if (this.f1731i) {
            sb.append("public, ");
        }
        if (this.f1732j) {
            sb.append("must-revalidate, ");
        }
        if (this.f1733k != -1) {
            sb.append("max-stale=");
            sb.append(this.f1733k);
            sb.append(", ");
        }
        if (this.f1734l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1734l);
            sb.append(", ");
        }
        if (this.f1735m) {
            sb.append("only-if-cached, ");
        }
        if (this.f1736n) {
            sb.append("no-transform, ");
        }
        if (this.f1737o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX INFO: renamed from: ami$a */
    /* JADX INFO: compiled from: CacheControl.java */
    public static final class C0198a {

        /* JADX INFO: renamed from: a */
        boolean f1738a;

        /* JADX INFO: renamed from: b */
        boolean f1739b;

        /* JADX INFO: renamed from: c */
        int f1740c = -1;

        /* JADX INFO: renamed from: d */
        int f1741d = -1;

        /* JADX INFO: renamed from: e */
        int f1742e = -1;

        /* JADX INFO: renamed from: f */
        boolean f1743f;

        /* JADX INFO: renamed from: g */
        boolean f1744g;

        /* JADX INFO: renamed from: h */
        boolean f1745h;

        /* JADX INFO: renamed from: a */
        public C0198a m1960a() {
            this.f1738a = true;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0198a m1961a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.f1741d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0198a m1962b() {
            this.f1743f = true;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public ami m1963c() {
            return new ami(this);
        }
    }
}
