package p000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: CipherSuite.java */
/* JADX INFO: loaded from: classes.dex */
public final class amm {

    /* JADX INFO: renamed from: bk */
    final String f1869bk;

    /* JADX INFO: renamed from: a */
    static final Comparator<String> f1780a = new Comparator<String>() { // from class: amm.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };

    /* JADX INFO: renamed from: bl */
    private static final Map<String, amm> f1844bl = new TreeMap(f1780a);

    /* JADX INFO: renamed from: b */
    public static final amm f1833b = m1978a("SSL_RSA_WITH_NULL_MD5", 1);

    /* JADX INFO: renamed from: c */
    public static final amm f1845c = m1978a("SSL_RSA_WITH_NULL_SHA", 2);

    /* JADX INFO: renamed from: d */
    public static final amm f1846d = m1978a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* JADX INFO: renamed from: e */
    public static final amm f1847e = m1978a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* JADX INFO: renamed from: f */
    public static final amm f1848f = m1978a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* JADX INFO: renamed from: g */
    public static final amm f1849g = m1978a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* JADX INFO: renamed from: h */
    public static final amm f1850h = m1978a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* JADX INFO: renamed from: i */
    public static final amm f1851i = m1978a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* JADX INFO: renamed from: j */
    public static final amm f1852j = m1978a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* JADX INFO: renamed from: k */
    public static final amm f1853k = m1978a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* JADX INFO: renamed from: l */
    public static final amm f1854l = m1978a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* JADX INFO: renamed from: m */
    public static final amm f1855m = m1978a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* JADX INFO: renamed from: n */
    public static final amm f1856n = m1978a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* JADX INFO: renamed from: o */
    public static final amm f1857o = m1978a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* JADX INFO: renamed from: p */
    public static final amm f1858p = m1978a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* JADX INFO: renamed from: q */
    public static final amm f1859q = m1978a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* JADX INFO: renamed from: r */
    public static final amm f1860r = m1978a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* JADX INFO: renamed from: s */
    public static final amm f1861s = m1978a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* JADX INFO: renamed from: t */
    public static final amm f1862t = m1978a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* JADX INFO: renamed from: u */
    public static final amm f1863u = m1978a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* JADX INFO: renamed from: v */
    public static final amm f1864v = m1978a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* JADX INFO: renamed from: w */
    public static final amm f1865w = m1978a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* JADX INFO: renamed from: x */
    public static final amm f1866x = m1978a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* JADX INFO: renamed from: y */
    public static final amm f1867y = m1978a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* JADX INFO: renamed from: z */
    public static final amm f1868z = m1978a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* JADX INFO: renamed from: A */
    public static final amm f1754A = m1978a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* JADX INFO: renamed from: B */
    public static final amm f1755B = m1978a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* JADX INFO: renamed from: C */
    public static final amm f1756C = m1978a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* JADX INFO: renamed from: D */
    public static final amm f1757D = m1978a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* JADX INFO: renamed from: E */
    public static final amm f1758E = m1978a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* JADX INFO: renamed from: F */
    public static final amm f1759F = m1978a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* JADX INFO: renamed from: G */
    public static final amm f1760G = m1978a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* JADX INFO: renamed from: H */
    public static final amm f1761H = m1978a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* JADX INFO: renamed from: I */
    public static final amm f1762I = m1978a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* JADX INFO: renamed from: J */
    public static final amm f1763J = m1978a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* JADX INFO: renamed from: K */
    public static final amm f1764K = m1978a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* JADX INFO: renamed from: L */
    public static final amm f1765L = m1978a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* JADX INFO: renamed from: M */
    public static final amm f1766M = m1978a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* JADX INFO: renamed from: N */
    public static final amm f1767N = m1978a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* JADX INFO: renamed from: O */
    public static final amm f1768O = m1978a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* JADX INFO: renamed from: P */
    public static final amm f1769P = m1978a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* JADX INFO: renamed from: Q */
    public static final amm f1770Q = m1978a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* JADX INFO: renamed from: R */
    public static final amm f1771R = m1978a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* JADX INFO: renamed from: S */
    public static final amm f1772S = m1978a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* JADX INFO: renamed from: T */
    public static final amm f1773T = m1978a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* JADX INFO: renamed from: U */
    public static final amm f1774U = m1978a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* JADX INFO: renamed from: V */
    public static final amm f1775V = m1978a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* JADX INFO: renamed from: W */
    public static final amm f1776W = m1978a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* JADX INFO: renamed from: X */
    public static final amm f1777X = m1978a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* JADX INFO: renamed from: Y */
    public static final amm f1778Y = m1978a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* JADX INFO: renamed from: Z */
    public static final amm f1779Z = m1978a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* JADX INFO: renamed from: aa */
    public static final amm f1807aa = m1978a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* JADX INFO: renamed from: ab */
    public static final amm f1808ab = m1978a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* JADX INFO: renamed from: ac */
    public static final amm f1809ac = m1978a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* JADX INFO: renamed from: ad */
    public static final amm f1810ad = m1978a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* JADX INFO: renamed from: ae */
    public static final amm f1811ae = m1978a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* JADX INFO: renamed from: af */
    public static final amm f1812af = m1978a("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* JADX INFO: renamed from: ag */
    public static final amm f1813ag = m1978a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* JADX INFO: renamed from: ah */
    public static final amm f1814ah = m1978a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* JADX INFO: renamed from: ai */
    public static final amm f1815ai = m1978a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* JADX INFO: renamed from: aj */
    public static final amm f1816aj = m1978a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* JADX INFO: renamed from: ak */
    public static final amm f1817ak = m1978a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* JADX INFO: renamed from: al */
    public static final amm f1818al = m1978a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* JADX INFO: renamed from: am */
    public static final amm f1819am = m1978a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* JADX INFO: renamed from: an */
    public static final amm f1820an = m1978a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* JADX INFO: renamed from: ao */
    public static final amm f1821ao = m1978a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* JADX INFO: renamed from: ap */
    public static final amm f1822ap = m1978a("TLS_FALLBACK_SCSV", 22016);

    /* JADX INFO: renamed from: aq */
    public static final amm f1823aq = m1978a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* JADX INFO: renamed from: ar */
    public static final amm f1824ar = m1978a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* JADX INFO: renamed from: as */
    public static final amm f1825as = m1978a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* JADX INFO: renamed from: at */
    public static final amm f1826at = m1978a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* JADX INFO: renamed from: au */
    public static final amm f1827au = m1978a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* JADX INFO: renamed from: av */
    public static final amm f1828av = m1978a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* JADX INFO: renamed from: aw */
    public static final amm f1829aw = m1978a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* JADX INFO: renamed from: ax */
    public static final amm f1830ax = m1978a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* JADX INFO: renamed from: ay */
    public static final amm f1831ay = m1978a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* JADX INFO: renamed from: az */
    public static final amm f1832az = m1978a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* JADX INFO: renamed from: aA */
    public static final amm f1781aA = m1978a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* JADX INFO: renamed from: aB */
    public static final amm f1782aB = m1978a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* JADX INFO: renamed from: aC */
    public static final amm f1783aC = m1978a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* JADX INFO: renamed from: aD */
    public static final amm f1784aD = m1978a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* JADX INFO: renamed from: aE */
    public static final amm f1785aE = m1978a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* JADX INFO: renamed from: aF */
    public static final amm f1786aF = m1978a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* JADX INFO: renamed from: aG */
    public static final amm f1787aG = m1978a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* JADX INFO: renamed from: aH */
    public static final amm f1788aH = m1978a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* JADX INFO: renamed from: aI */
    public static final amm f1789aI = m1978a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* JADX INFO: renamed from: aJ */
    public static final amm f1790aJ = m1978a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* JADX INFO: renamed from: aK */
    public static final amm f1791aK = m1978a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* JADX INFO: renamed from: aL */
    public static final amm f1792aL = m1978a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* JADX INFO: renamed from: aM */
    public static final amm f1793aM = m1978a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* JADX INFO: renamed from: aN */
    public static final amm f1794aN = m1978a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* JADX INFO: renamed from: aO */
    public static final amm f1795aO = m1978a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* JADX INFO: renamed from: aP */
    public static final amm f1796aP = m1978a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* JADX INFO: renamed from: aQ */
    public static final amm f1797aQ = m1978a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* JADX INFO: renamed from: aR */
    public static final amm f1798aR = m1978a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* JADX INFO: renamed from: aS */
    public static final amm f1799aS = m1978a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* JADX INFO: renamed from: aT */
    public static final amm f1800aT = m1978a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* JADX INFO: renamed from: aU */
    public static final amm f1801aU = m1978a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* JADX INFO: renamed from: aV */
    public static final amm f1802aV = m1978a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* JADX INFO: renamed from: aW */
    public static final amm f1803aW = m1978a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* JADX INFO: renamed from: aX */
    public static final amm f1804aX = m1978a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* JADX INFO: renamed from: aY */
    public static final amm f1805aY = m1978a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* JADX INFO: renamed from: aZ */
    public static final amm f1806aZ = m1978a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* JADX INFO: renamed from: ba */
    public static final amm f1834ba = m1978a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* JADX INFO: renamed from: bb */
    public static final amm f1835bb = m1978a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* JADX INFO: renamed from: bc */
    public static final amm f1836bc = m1978a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* JADX INFO: renamed from: bd */
    public static final amm f1837bd = m1978a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* JADX INFO: renamed from: be */
    public static final amm f1838be = m1978a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* JADX INFO: renamed from: bf */
    public static final amm f1839bf = m1978a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* JADX INFO: renamed from: bg */
    public static final amm f1840bg = m1978a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* JADX INFO: renamed from: bh */
    public static final amm f1841bh = m1978a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* JADX INFO: renamed from: bi */
    public static final amm f1842bi = m1978a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* JADX INFO: renamed from: bj */
    public static final amm f1843bj = m1978a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* JADX INFO: renamed from: a */
    public static synchronized amm m1977a(String str) {
        amm ammVar;
        ammVar = f1844bl.get(str);
        if (ammVar == null) {
            ammVar = new amm(str);
            f1844bl.put(str, ammVar);
        }
        return ammVar;
    }

    /* JADX INFO: renamed from: a */
    static List<amm> m1979a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m1977a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private amm(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1869bk = str;
    }

    /* JADX INFO: renamed from: a */
    private static amm m1978a(String str, int i) {
        return m1977a(str);
    }

    public String toString() {
        return this.f1869bk;
    }
}
