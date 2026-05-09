package p000;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: BasicCertificateChainCleaner.java */
/* JADX INFO: loaded from: classes.dex */
public final class apj extends apl {

    /* JADX INFO: renamed from: a */
    private final apn f4596a;

    public apj(apn apnVar) {
        this.f4596a = apnVar;
    }

    @Override // p000.apl
    /* JADX INFO: renamed from: a */
    public List<Certificate> mo4832a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateMo4833a = this.f4596a.mo4833a(x509Certificate);
            if (x509CertificateMo4833a != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateMo4833a)) {
                    arrayList.add(x509CertificateMo4833a);
                }
                if (m4861a(x509CertificateMo4833a, x509CertificateMo4833a)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m4861a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4861a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.f4596a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof apj) && ((apj) obj).f4596a.equals(this.f4596a);
    }
}
