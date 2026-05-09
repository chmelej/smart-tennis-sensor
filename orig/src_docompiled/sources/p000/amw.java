package p000;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: Handshake.java */
/* JADX INFO: loaded from: classes.dex */
public final class amw {

    /* JADX INFO: renamed from: a */
    private final anj f1917a;

    /* JADX INFO: renamed from: b */
    private final amm f1918b;

    /* JADX INFO: renamed from: c */
    private final List<Certificate> f1919c;

    /* JADX INFO: renamed from: d */
    private final List<Certificate> f1920d;

    private amw(anj anjVar, amm ammVar, List<Certificate> list, List<Certificate> list2) {
        this.f1917a = anjVar;
        this.f1918b = ammVar;
        this.f1919c = list;
        this.f1920d = list2;
    }

    /* JADX INFO: renamed from: a */
    public static amw m2048a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        List listEmptyList;
        List listEmptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        amm ammVarM1977a = amm.m1977a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        anj anjVarM4487a = anj.m4487a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = anm.m4501a(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = anm.m4501a(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new amw(anjVarM4487a, ammVarM1977a, listEmptyList, listEmptyList2);
    }

    /* JADX INFO: renamed from: a */
    public amm m2049a() {
        return this.f1918b;
    }

    /* JADX INFO: renamed from: b */
    public List<Certificate> m2050b() {
        return this.f1919c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof amw)) {
            return false;
        }
        amw amwVar = (amw) obj;
        return this.f1917a.equals(amwVar.f1917a) && this.f1918b.equals(amwVar.f1918b) && this.f1919c.equals(amwVar.f1919c) && this.f1920d.equals(amwVar.f1920d);
    }

    public int hashCode() {
        return ((((((527 + this.f1917a.hashCode()) * 31) + this.f1918b.hashCode()) * 31) + this.f1919c.hashCode()) * 31) + this.f1920d.hashCode();
    }
}
