package p000;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class amp {

    /* JADX INFO: renamed from: e */
    final boolean f1885e;

    /* JADX INFO: renamed from: f */
    final boolean f1886f;

    /* JADX INFO: renamed from: g */
    @Nullable
    final String[] f1887g;

    /* JADX INFO: renamed from: h */
    @Nullable
    final String[] f1888h;

    /* JADX INFO: renamed from: i */
    private static final amm[] f1883i = {amm.f1804aX, amm.f1835bb, amm.f1805aY, amm.f1836bc, amm.f1842bi, amm.f1841bh};

    /* JADX INFO: renamed from: j */
    private static final amm[] f1884j = {amm.f1804aX, amm.f1835bb, amm.f1805aY, amm.f1836bc, amm.f1842bi, amm.f1841bh, amm.f1789aI, amm.f1790aJ, amm.f1813ag, amm.f1814ah, amm.f1758E, amm.f1762I, amm.f1851i};

    /* JADX INFO: renamed from: a */
    public static final amp f1879a = new C0203a(true).m1996a(f1883i).m1997a(anj.TLS_1_2).m1995a(true).m1999a();

    /* JADX INFO: renamed from: b */
    public static final amp f1880b = new C0203a(true).m1996a(f1884j).m1997a(anj.TLS_1_2, anj.TLS_1_1, anj.TLS_1_0).m1995a(true).m1999a();

    /* JADX INFO: renamed from: c */
    public static final amp f1881c = new C0203a(f1880b).m1997a(anj.TLS_1_0).m1995a(true).m1999a();

    /* JADX INFO: renamed from: d */
    public static final amp f1882d = new C0203a(false).m1999a();

    amp(C0203a c0203a) {
        this.f1885e = c0203a.f1889a;
        this.f1887g = c0203a.f1890b;
        this.f1888h = c0203a.f1891c;
        this.f1886f = c0203a.f1892d;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1990a() {
        return this.f1885e;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public List<amm> m1992b() {
        if (this.f1887g != null) {
            return amm.m1979a(this.f1887g);
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public List<anj> m1993c() {
        if (this.f1888h != null) {
            return anj.m4488a(this.f1888h);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1994d() {
        return this.f1886f;
    }

    /* JADX INFO: renamed from: a */
    void m1989a(SSLSocket sSLSocket, boolean z) {
        amp ampVarM1988b = m1988b(sSLSocket, z);
        if (ampVarM1988b.f1888h != null) {
            sSLSocket.setEnabledProtocols(ampVarM1988b.f1888h);
        }
        if (ampVarM1988b.f1887g != null) {
            sSLSocket.setEnabledCipherSuites(ampVarM1988b.f1887g);
        }
    }

    /* JADX INFO: renamed from: b */
    private amp m1988b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f1887g != null) {
            enabledCipherSuites = anm.m4513a(amm.f1780a, sSLSocket.getEnabledCipherSuites(), this.f1887g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f1888h != null) {
            enabledProtocols = anm.m4513a(anm.f4214h, sSLSocket.getEnabledProtocols(), this.f1888h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iM4494a = anm.m4494a(amm.f1780a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iM4494a != -1) {
            enabledCipherSuites = anm.m4514a(enabledCipherSuites, supportedCipherSuites[iM4494a]);
        }
        return new C0203a(this).m1998a(enabledCipherSuites).m2000b(enabledProtocols).m1999a();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1991a(SSLSocket sSLSocket) {
        if (!this.f1885e) {
            return false;
        }
        if (this.f1888h == null || anm.m4517b(anm.f4214h, this.f1888h, sSLSocket.getEnabledProtocols())) {
            return this.f1887g == null || anm.m4517b(amm.f1780a, this.f1887g, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof amp)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        amp ampVar = (amp) obj;
        if (this.f1885e != ampVar.f1885e) {
            return false;
        }
        return !this.f1885e || (Arrays.equals(this.f1887g, ampVar.f1887g) && Arrays.equals(this.f1888h, ampVar.f1888h) && this.f1886f == ampVar.f1886f);
    }

    public int hashCode() {
        if (this.f1885e) {
            return ((((527 + Arrays.hashCode(this.f1887g)) * 31) + Arrays.hashCode(this.f1888h)) * 31) + (!this.f1886f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f1885e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f1887g != null ? m1992b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f1888h != null ? m1993c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f1886f + ")";
    }

    /* JADX INFO: renamed from: amp$a */
    /* JADX INFO: compiled from: ConnectionSpec.java */
    public static final class C0203a {

        /* JADX INFO: renamed from: a */
        boolean f1889a;

        /* JADX INFO: renamed from: b */
        @Nullable
        String[] f1890b;

        /* JADX INFO: renamed from: c */
        @Nullable
        String[] f1891c;

        /* JADX INFO: renamed from: d */
        boolean f1892d;

        C0203a(boolean z) {
            this.f1889a = z;
        }

        public C0203a(amp ampVar) {
            this.f1889a = ampVar.f1885e;
            this.f1890b = ampVar.f1887g;
            this.f1891c = ampVar.f1888h;
            this.f1892d = ampVar.f1886f;
        }

        /* JADX INFO: renamed from: a */
        public C0203a m1996a(amm... ammVarArr) {
            if (!this.f1889a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[ammVarArr.length];
            for (int i = 0; i < ammVarArr.length; i++) {
                strArr[i] = ammVarArr[i].f1869bk;
            }
            return m1998a(strArr);
        }

        /* JADX INFO: renamed from: a */
        public C0203a m1998a(String... strArr) {
            if (!this.f1889a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f1890b = (String[]) strArr.clone();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0203a m1997a(anj... anjVarArr) {
            if (!this.f1889a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[anjVarArr.length];
            for (int i = 0; i < anjVarArr.length; i++) {
                strArr[i] = anjVarArr[i].f4204f;
            }
            return m2000b(strArr);
        }

        /* JADX INFO: renamed from: b */
        public C0203a m2000b(String... strArr) {
            if (!this.f1889a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f1891c = (String[]) strArr.clone();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0203a m1995a(boolean z) {
            if (!this.f1889a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f1892d = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public amp m1999a() {
            return new amp(this);
        }
    }
}
