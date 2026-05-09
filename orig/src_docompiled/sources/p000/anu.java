package p000;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpecSelector.java */
/* JADX INFO: loaded from: classes.dex */
public final class anu {

    /* JADX INFO: renamed from: a */
    private final List<amp> f4275a;

    /* JADX INFO: renamed from: b */
    private int f4276b = 0;

    /* JADX INFO: renamed from: c */
    private boolean f4277c;

    /* JADX INFO: renamed from: d */
    private boolean f4278d;

    public anu(List<amp> list) {
        this.f4275a = list;
    }

    /* JADX INFO: renamed from: a */
    public amp m4555a(SSLSocket sSLSocket) throws UnknownServiceException {
        amp ampVar;
        int i = this.f4276b;
        int size = this.f4275a.size();
        while (true) {
            if (i >= size) {
                ampVar = null;
                break;
            }
            ampVar = this.f4275a.get(i);
            if (ampVar.m1991a(sSLSocket)) {
                this.f4276b = i + 1;
                break;
            }
            i++;
        }
        if (ampVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f4278d + ", modes=" + this.f4275a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f4277c = m4554b(sSLSocket);
        ank.f4205a.mo2159a(ampVar, sSLSocket, this.f4278d);
        return ampVar;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4556a(IOException iOException) {
        this.f4278d = true;
        if (!this.f4277c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    /* JADX INFO: renamed from: b */
    private boolean m4554b(SSLSocket sSLSocket) {
        for (int i = this.f4276b; i < this.f4275a.size(); i++) {
            if (this.f4275a.get(i).m1991a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
