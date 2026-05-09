package p000;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p000.amy;

/* JADX INFO: compiled from: Address.java */
/* JADX INFO: loaded from: classes.dex */
public final class amf {

    /* JADX INFO: renamed from: a */
    final amy f1709a;

    /* JADX INFO: renamed from: b */
    final amu f1710b;

    /* JADX INFO: renamed from: c */
    final SocketFactory f1711c;

    /* JADX INFO: renamed from: d */
    final amg f1712d;

    /* JADX INFO: renamed from: e */
    final List<anc> f1713e;

    /* JADX INFO: renamed from: f */
    final List<amp> f1714f;

    /* JADX INFO: renamed from: g */
    final ProxySelector f1715g;

    /* JADX INFO: renamed from: h */
    @Nullable
    final Proxy f1716h;

    /* JADX INFO: renamed from: i */
    @Nullable
    final SSLSocketFactory f1717i;

    /* JADX INFO: renamed from: j */
    @Nullable
    final HostnameVerifier f1718j;

    /* JADX INFO: renamed from: k */
    @Nullable
    final aml f1719k;

    public amf(String str, int i, amu amuVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable aml amlVar, amg amgVar, @Nullable Proxy proxy, List<anc> list, List<amp> list2, ProxySelector proxySelector) {
        this.f1709a = new amy.C0210a().m2107a(sSLSocketFactory != null ? "https" : "http").m2112d(str).m2105a(i).m2111c();
        if (amuVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f1710b = amuVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f1711c = socketFactory;
        if (amgVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f1712d = amgVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f1713e = anm.m4500a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f1714f = anm.m4500a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f1715g = proxySelector;
        this.f1716h = proxy;
        this.f1717i = sSLSocketFactory;
        this.f1718j = hostnameVerifier;
        this.f1719k = amlVar;
    }

    /* JADX INFO: renamed from: a */
    public amy m1935a() {
        return this.f1709a;
    }

    /* JADX INFO: renamed from: b */
    public amu m1937b() {
        return this.f1710b;
    }

    /* JADX INFO: renamed from: c */
    public SocketFactory m1938c() {
        return this.f1711c;
    }

    /* JADX INFO: renamed from: d */
    public amg m1939d() {
        return this.f1712d;
    }

    /* JADX INFO: renamed from: e */
    public List<anc> m1940e() {
        return this.f1713e;
    }

    /* JADX INFO: renamed from: f */
    public List<amp> m1941f() {
        return this.f1714f;
    }

    /* JADX INFO: renamed from: g */
    public ProxySelector m1942g() {
        return this.f1715g;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public Proxy m1943h() {
        return this.f1716h;
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public SSLSocketFactory m1944i() {
        return this.f1717i;
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public HostnameVerifier m1945j() {
        return this.f1718j;
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public aml m1946k() {
        return this.f1719k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof amf) {
            amf amfVar = (amf) obj;
            if (this.f1709a.equals(amfVar.f1709a) && m1936a(amfVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f1709a.hashCode()) * 31) + this.f1710b.hashCode()) * 31) + this.f1712d.hashCode()) * 31) + this.f1713e.hashCode()) * 31) + this.f1714f.hashCode()) * 31) + this.f1715g.hashCode()) * 31) + (this.f1716h != null ? this.f1716h.hashCode() : 0)) * 31) + (this.f1717i != null ? this.f1717i.hashCode() : 0)) * 31) + (this.f1718j != null ? this.f1718j.hashCode() : 0)) * 31) + (this.f1719k != null ? this.f1719k.hashCode() : 0);
    }

    /* JADX INFO: renamed from: a */
    boolean m1936a(amf amfVar) {
        return this.f1710b.equals(amfVar.f1710b) && this.f1712d.equals(amfVar.f1712d) && this.f1713e.equals(amfVar.f1713e) && this.f1714f.equals(amfVar.f1714f) && this.f1715g.equals(amfVar.f1715g) && anm.m4510a(this.f1716h, amfVar.f1716h) && anm.m4510a(this.f1717i, amfVar.f1717i) && anm.m4510a(this.f1718j, amfVar.f1718j) && anm.m4510a(this.f1719k, amfVar.f1719k) && m1935a().m2086g() == amfVar.m1935a().m2086g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f1709a.m2085f());
        sb.append(":");
        sb.append(this.f1709a.m2086g());
        if (this.f1716h != null) {
            sb.append(", proxy=");
            sb.append(this.f1716h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f1715g);
        }
        sb.append("}");
        return sb.toString();
    }
}
