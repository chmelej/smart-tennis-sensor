package p000;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* JADX INFO: compiled from: ConscryptPlatform.java */
/* JADX INFO: loaded from: classes.dex */
public class apd extends aph {
    private apd() {
    }

    /* JADX INFO: renamed from: e */
    private Provider m4838e() {
        return new OpenSSLProvider();
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4828a(SSLSocket sSLSocket, String str, List<anc> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) aph.m4851a(list).toArray(new String[0]));
            return;
        }
        super.mo4828a(sSLSocket, str, list);
    }

    @Override // p000.aph
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo4824a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo4824a(sSLSocket);
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: b */
    public SSLContext mo4830b() {
        try {
            return SSLContext.getInstance("TLS", m4838e());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static aph m4837a() {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (Conscrypt.isAvailable()) {
                return new apd();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4839a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
