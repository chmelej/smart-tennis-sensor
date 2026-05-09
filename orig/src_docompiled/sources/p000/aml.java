package p000;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* JADX INFO: compiled from: CertificatePinner.java */
/* JADX INFO: loaded from: classes.dex */
public final class aml {

    /* JADX INFO: renamed from: a */
    public static final aml f1746a = new C0199a().m1975a();

    /* JADX INFO: renamed from: b */
    private final Set<C0200b> f1747b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private final apl f1748c;

    aml(Set<C0200b> set, @Nullable apl aplVar) {
        this.f1747b = set;
        this.f1748c = aplVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aml) {
            aml amlVar = (aml) obj;
            if (anm.m4510a(this.f1748c, amlVar.f1748c) && this.f1747b.equals(amlVar.f1747b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1748c != null ? this.f1748c.hashCode() : 0) * 31) + this.f1747b.hashCode();
    }

    /* JADX INFO: renamed from: a */
    public void m1974a(String str, List<Certificate> list) {
        List<C0200b> listM1973a = m1973a(str);
        if (listM1973a.isEmpty()) {
            return;
        }
        if (this.f1748c != null) {
            list = this.f1748c.mo4832a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listM1973a.size();
            ByteString byteStringM1971b = null;
            ByteString byteStringM1970a = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C0200b c0200b = listM1973a.get(i2);
                if (c0200b.f1752c.equals("sha256/")) {
                    if (byteStringM1971b == null) {
                        byteStringM1971b = m1971b(x509Certificate);
                    }
                    if (c0200b.f1753d.equals(byteStringM1971b)) {
                        return;
                    }
                } else if (c0200b.f1752c.equals("sha1/")) {
                    if (byteStringM1970a == null) {
                        byteStringM1970a = m1970a(x509Certificate);
                    }
                    if (c0200b.f1753d.equals(byteStringM1970a)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + c0200b.f1752c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m1969a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listM1973a.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C0200b c0200b2 = listM1973a.get(i4);
            sb.append("\n    ");
            sb.append(c0200b2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    List<C0200b> m1973a(String str) {
        List<C0200b> listEmptyList = Collections.emptyList();
        for (C0200b c0200b : this.f1747b) {
            if (c0200b.m1976a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(c0200b);
            }
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: a */
    aml m1972a(@Nullable apl aplVar) {
        return anm.m4510a(this.f1748c, aplVar) ? this : new aml(this.f1747b, aplVar);
    }

    /* JADX INFO: renamed from: a */
    public static String m1969a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m1971b((X509Certificate) certificate).base64();
    }

    /* JADX INFO: renamed from: a */
    static ByteString m1970a(X509Certificate x509Certificate) {
        return ByteString.m10878of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* JADX INFO: renamed from: b */
    static ByteString m1971b(X509Certificate x509Certificate) {
        return ByteString.m10878of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    /* JADX INFO: renamed from: aml$b */
    /* JADX INFO: compiled from: CertificatePinner.java */
    static final class C0200b {

        /* JADX INFO: renamed from: a */
        final String f1750a;

        /* JADX INFO: renamed from: b */
        final String f1751b;

        /* JADX INFO: renamed from: c */
        final String f1752c;

        /* JADX INFO: renamed from: d */
        final ByteString f1753d;

        /* JADX INFO: renamed from: a */
        boolean m1976a(String str) {
            if (this.f1750a.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                return (str.length() - iIndexOf) - 1 == this.f1751b.length() && str.regionMatches(false, iIndexOf + 1, this.f1751b, 0, this.f1751b.length());
            }
            return str.equals(this.f1751b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0200b) {
                C0200b c0200b = (C0200b) obj;
                if (this.f1750a.equals(c0200b.f1750a) && this.f1752c.equals(c0200b.f1752c) && this.f1753d.equals(c0200b.f1753d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f1750a.hashCode()) * 31) + this.f1752c.hashCode()) * 31) + this.f1753d.hashCode();
        }

        public String toString() {
            return this.f1752c + this.f1753d.base64();
        }
    }

    /* JADX INFO: renamed from: aml$a */
    /* JADX INFO: compiled from: CertificatePinner.java */
    public static final class C0199a {

        /* JADX INFO: renamed from: a */
        private final List<C0200b> f1749a = new ArrayList();

        /* JADX INFO: renamed from: a */
        public aml m1975a() {
            return new aml(new LinkedHashSet(this.f1749a), null);
        }
    }
}
