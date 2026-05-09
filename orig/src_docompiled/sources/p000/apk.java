package p000;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: BasicTrustRootIndex.java */
/* JADX INFO: loaded from: classes.dex */
public final class apk implements apn {

    /* JADX INFO: renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f4597a = new LinkedHashMap();

    public apk(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> linkedHashSet = this.f4597a.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>(1);
                this.f4597a.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // p000.apn
    /* JADX INFO: renamed from: a */
    public X509Certificate mo4833a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f4597a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof apk) && ((apk) obj).f4597a.equals(this.f4597a);
    }

    public int hashCode() {
        return this.f4597a.hashCode();
    }
}
