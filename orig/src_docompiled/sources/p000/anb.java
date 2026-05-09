package p000;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import p000.amv;
import p000.amx;
import p000.ang;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class anb implements Cloneable {

    /* JADX INFO: renamed from: a */
    static final List<anc> f1947a = anm.m4501a(anc.HTTP_2, anc.HTTP_1_1);

    /* JADX INFO: renamed from: b */
    static final List<amp> f1948b = anm.m4501a(amp.f1880b, amp.f1882d);

    /* JADX INFO: renamed from: A */
    final int f1949A;

    /* JADX INFO: renamed from: B */
    final int f1950B;

    /* JADX INFO: renamed from: C */
    final int f1951C;

    /* JADX INFO: renamed from: c */
    final amt f1952c;

    /* JADX INFO: renamed from: d */
    @Nullable
    final Proxy f1953d;

    /* JADX INFO: renamed from: e */
    final List<anc> f1954e;

    /* JADX INFO: renamed from: f */
    final List<amp> f1955f;

    /* JADX INFO: renamed from: g */
    final List<amz> f1956g;

    /* JADX INFO: renamed from: h */
    final List<amz> f1957h;

    /* JADX INFO: renamed from: i */
    final amv.InterfaceC0208a f1958i;

    /* JADX INFO: renamed from: j */
    final ProxySelector f1959j;

    /* JADX INFO: renamed from: k */
    final amr f1960k;

    /* JADX INFO: renamed from: l */
    @Nullable
    final amh f1961l;

    /* JADX INFO: renamed from: m */
    @Nullable
    final ans f1962m;

    /* JADX INFO: renamed from: n */
    final SocketFactory f1963n;

    /* JADX INFO: renamed from: o */
    @Nullable
    final SSLSocketFactory f1964o;

    /* JADX INFO: renamed from: p */
    @Nullable
    final apl f1965p;

    /* JADX INFO: renamed from: q */
    final HostnameVerifier f1966q;

    /* JADX INFO: renamed from: r */
    final aml f1967r;

    /* JADX INFO: renamed from: s */
    final amg f1968s;

    /* JADX INFO: renamed from: t */
    final amg f1969t;

    /* JADX INFO: renamed from: u */
    final amo f1970u;

    /* JADX INFO: renamed from: v */
    final amu f1971v;

    /* JADX INFO: renamed from: w */
    final boolean f1972w;

    /* JADX INFO: renamed from: x */
    final boolean f1973x;

    /* JADX INFO: renamed from: y */
    final boolean f1974y;

    /* JADX INFO: renamed from: z */
    final int f1975z;

    static {
        ank.f4205a = new ank() { // from class: anb.1
            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public void mo2160a(amx.C0209a c0209a, String str) {
                c0209a.m2059a(str);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public void mo2161a(amx.C0209a c0209a, String str, String str2) {
                c0209a.m2063b(str, str2);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public boolean mo2163a(amo amoVar, anv anvVar) {
                return amoVar.m1987b(anvVar);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public anv mo2156a(amo amoVar, amf amfVar, anz anzVar, ani aniVar) {
                return amoVar.m1984a(amfVar, anzVar, aniVar);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public boolean mo2162a(amf amfVar, amf amfVar2) {
                return amfVar.m1936a(amfVar2);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public Socket mo2158a(amo amoVar, amf amfVar, anz anzVar) {
                return amoVar.m1985a(amfVar, anzVar);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: b */
            public void mo2164b(amo amoVar, anv anvVar) {
                amoVar.m1986a(anvVar);
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public anw mo2157a(amo amoVar) {
                return amoVar.f1872a;
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public int mo2155a(ang.C0669a c0669a) {
                return c0669a.f4182c;
            }

            @Override // p000.ank
            /* JADX INFO: renamed from: a */
            public void mo2159a(amp ampVar, SSLSocket sSLSocket, boolean z) {
                ampVar.m1989a(sSLSocket, z);
            }
        };
    }

    public anb() {
        this(new C0214a());
    }

    anb(C0214a c0214a) {
        boolean z;
        this.f1952c = c0214a.f1977a;
        this.f1953d = c0214a.f1978b;
        this.f1954e = c0214a.f1979c;
        this.f1955f = c0214a.f1980d;
        this.f1956g = anm.m4500a(c0214a.f1981e);
        this.f1957h = anm.m4500a(c0214a.f1982f);
        this.f1958i = c0214a.f1983g;
        this.f1959j = c0214a.f1984h;
        this.f1960k = c0214a.f1985i;
        this.f1961l = c0214a.f1986j;
        this.f1962m = c0214a.f1987k;
        this.f1963n = c0214a.f1988l;
        Iterator<amp> it = this.f1955f.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().m1990a();
            }
        }
        if (c0214a.f1989m != null || !z) {
            this.f1964o = c0214a.f1989m;
            this.f1965p = c0214a.f1990n;
        } else {
            X509TrustManager x509TrustManagerM4504a = anm.m4504a();
            this.f1964o = m2128a(x509TrustManagerM4504a);
            this.f1965p = apl.m4862a(x509TrustManagerM4504a);
        }
        if (this.f1964o != null) {
            aph.m4853c().mo4839a(this.f1964o);
        }
        this.f1966q = c0214a.f1991o;
        this.f1967r = c0214a.f1992p.m1972a(this.f1965p);
        this.f1968s = c0214a.f1993q;
        this.f1969t = c0214a.f1994r;
        this.f1970u = c0214a.f1995s;
        this.f1971v = c0214a.f1996t;
        this.f1972w = c0214a.f1997u;
        this.f1973x = c0214a.f1998v;
        this.f1974y = c0214a.f1999w;
        this.f1975z = c0214a.f2000x;
        this.f1949A = c0214a.f2001y;
        this.f1950B = c0214a.f2002z;
        this.f1951C = c0214a.f1976A;
        if (this.f1956g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f1956g);
        }
        if (this.f1957h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f1957h);
        }
    }

    /* JADX INFO: renamed from: a */
    private static SSLSocketFactory m2128a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextMo4830b = aph.m4853c().mo4830b();
            sSLContextMo4830b.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextMo4830b.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw anm.m4495a("No System TLS", (Exception) e);
        }
    }

    /* JADX INFO: renamed from: a */
    public int m2129a() {
        return this.f1975z;
    }

    /* JADX INFO: renamed from: b */
    public int m2131b() {
        return this.f1949A;
    }

    /* JADX INFO: renamed from: c */
    public int m2132c() {
        return this.f1950B;
    }

    /* JADX INFO: renamed from: d */
    public int m2133d() {
        return this.f1951C;
    }

    /* JADX INFO: renamed from: e */
    public Proxy m2134e() {
        return this.f1953d;
    }

    /* JADX INFO: renamed from: f */
    public ProxySelector m2135f() {
        return this.f1959j;
    }

    /* JADX INFO: renamed from: g */
    public amr m2136g() {
        return this.f1960k;
    }

    /* JADX INFO: renamed from: h */
    ans m2137h() {
        return this.f1961l != null ? this.f1961l.f1721a : this.f1962m;
    }

    /* JADX INFO: renamed from: i */
    public amu m2138i() {
        return this.f1971v;
    }

    /* JADX INFO: renamed from: j */
    public SocketFactory m2139j() {
        return this.f1963n;
    }

    /* JADX INFO: renamed from: k */
    public SSLSocketFactory m2140k() {
        return this.f1964o;
    }

    /* JADX INFO: renamed from: l */
    public HostnameVerifier m2141l() {
        return this.f1966q;
    }

    /* JADX INFO: renamed from: m */
    public aml m2142m() {
        return this.f1967r;
    }

    /* JADX INFO: renamed from: n */
    public amg m2143n() {
        return this.f1969t;
    }

    /* JADX INFO: renamed from: o */
    public amg m2144o() {
        return this.f1968s;
    }

    /* JADX INFO: renamed from: p */
    public amo m2145p() {
        return this.f1970u;
    }

    /* JADX INFO: renamed from: q */
    public boolean m2146q() {
        return this.f1972w;
    }

    /* JADX INFO: renamed from: r */
    public boolean m2147r() {
        return this.f1973x;
    }

    /* JADX INFO: renamed from: s */
    public boolean m2148s() {
        return this.f1974y;
    }

    /* JADX INFO: renamed from: t */
    public amt m2149t() {
        return this.f1952c;
    }

    /* JADX INFO: renamed from: u */
    public List<anc> m2150u() {
        return this.f1954e;
    }

    /* JADX INFO: renamed from: v */
    public List<amp> m2151v() {
        return this.f1955f;
    }

    /* JADX INFO: renamed from: w */
    public List<amz> m2152w() {
        return this.f1956g;
    }

    /* JADX INFO: renamed from: x */
    public List<amz> m2153x() {
        return this.f1957h;
    }

    /* JADX INFO: renamed from: y */
    public amv.InterfaceC0208a m2154y() {
        return this.f1958i;
    }

    /* JADX INFO: renamed from: a */
    public amj m2130a(ane aneVar) {
        return and.m2175a(this, aneVar, false);
    }

    /* JADX INFO: renamed from: anb$a */
    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class C0214a {

        /* JADX INFO: renamed from: b */
        @Nullable
        Proxy f1978b;

        /* JADX INFO: renamed from: j */
        @Nullable
        amh f1986j;

        /* JADX INFO: renamed from: k */
        @Nullable
        ans f1987k;

        /* JADX INFO: renamed from: m */
        @Nullable
        SSLSocketFactory f1989m;

        /* JADX INFO: renamed from: n */
        @Nullable
        apl f1990n;

        /* JADX INFO: renamed from: e */
        final List<amz> f1981e = new ArrayList();

        /* JADX INFO: renamed from: f */
        final List<amz> f1982f = new ArrayList();

        /* JADX INFO: renamed from: a */
        amt f1977a = new amt();

        /* JADX INFO: renamed from: c */
        List<anc> f1979c = anb.f1947a;

        /* JADX INFO: renamed from: d */
        List<amp> f1980d = anb.f1948b;

        /* JADX INFO: renamed from: g */
        amv.InterfaceC0208a f1983g = amv.m2026a(amv.f1915a);

        /* JADX INFO: renamed from: h */
        ProxySelector f1984h = ProxySelector.getDefault();

        /* JADX INFO: renamed from: i */
        amr f1985i = amr.f1906a;

        /* JADX INFO: renamed from: l */
        SocketFactory f1988l = SocketFactory.getDefault();

        /* JADX INFO: renamed from: o */
        HostnameVerifier f1991o = apm.f4598a;

        /* JADX INFO: renamed from: p */
        aml f1992p = aml.f1746a;

        /* JADX INFO: renamed from: q */
        amg f1993q = amg.f1720b;

        /* JADX INFO: renamed from: r */
        amg f1994r = amg.f1720b;

        /* JADX INFO: renamed from: s */
        amo f1995s = new amo();

        /* JADX INFO: renamed from: t */
        amu f1996t = amu.f1914c;

        /* JADX INFO: renamed from: u */
        boolean f1997u = true;

        /* JADX INFO: renamed from: v */
        boolean f1998v = true;

        /* JADX INFO: renamed from: w */
        boolean f1999w = true;

        /* JADX INFO: renamed from: x */
        int f2000x = 10000;

        /* JADX INFO: renamed from: y */
        int f2001y = 10000;

        /* JADX INFO: renamed from: z */
        int f2002z = 10000;

        /* JADX INFO: renamed from: A */
        int f1976A = 0;

        /* JADX INFO: renamed from: a */
        public C0214a m2165a(long j, TimeUnit timeUnit) {
            this.f2000x = anm.m4493a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0214a m2170b(long j, TimeUnit timeUnit) {
            this.f2001y = anm.m4493a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C0214a m2172c(long j, TimeUnit timeUnit) {
            this.f2002z = anm.m4493a("timeout", j, timeUnit);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0214a m2168a(@Nullable Proxy proxy) {
            this.f1978b = proxy;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0214a m2167a(amu amuVar) {
            if (amuVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.f1996t = amuVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0214a m2166a(amg amgVar) {
            if (amgVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f1993q = amgVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public List<amz> m2169a() {
            return this.f1982f;
        }

        /* JADX INFO: renamed from: b */
        public anb m2171b() {
            return new anb(this);
        }
    }
}
