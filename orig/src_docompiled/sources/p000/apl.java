package p000;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: CertificateChainCleaner.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class apl {
    /* JADX INFO: renamed from: a */
    public abstract List<Certificate> mo4832a(List<Certificate> list, String str);

    /* JADX INFO: renamed from: a */
    public static apl m4862a(X509TrustManager x509TrustManager) {
        return aph.m4853c().mo4822a(x509TrustManager);
    }
}
