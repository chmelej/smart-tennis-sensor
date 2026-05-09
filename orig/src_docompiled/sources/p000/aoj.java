package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.android.spdy.SpdyRequest;
import p000.amz;
import p000.ane;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoj implements amz {

    /* JADX INFO: renamed from: a */
    private final anb f4344a;

    /* JADX INFO: renamed from: b */
    private final boolean f4345b;

    /* JADX INFO: renamed from: c */
    private volatile anz f4346c;

    /* JADX INFO: renamed from: d */
    private Object f4347d;

    /* JADX INFO: renamed from: e */
    private volatile boolean f4348e;

    public aoj(anb anbVar, boolean z) {
        this.f4344a = anbVar;
        this.f4345b = z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4646a() {
        return this.f4348e;
    }

    /* JADX INFO: renamed from: a */
    public void m4645a(Object obj) {
        this.f4347d = obj;
    }

    @Override // p000.amz
    /* JADX INFO: renamed from: a */
    public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) throws IOException {
        ang angVarM4473a;
        ane aneVarM4641a;
        ane aneVarMo2115a = interfaceC0211a.mo2115a();
        aog aogVar = (aog) interfaceC0211a;
        amj amjVarM4634h = aogVar.m4634h();
        amv amvVarM4635i = aogVar.m4635i();
        anz anzVar = new anz(this.f4344a.m2145p(), m4640a(aneVarMo2115a.m4419a()), amjVarM4634h, amvVarM4635i, this.f4347d);
        this.f4346c = anzVar;
        ang angVar = null;
        int i = 0;
        while (!this.f4348e) {
            try {
                try {
                    ang angVarM4631a = aogVar.m4631a(aneVarMo2115a, anzVar, null, null);
                    angVarM4473a = angVar != null ? angVarM4631a.m4456g().m4476c(angVar.m4456g().m4470a((anh) null).m4473a()).m4473a() : angVarM4631a;
                    try {
                        aneVarM4641a = m4641a(angVarM4473a, anzVar.m4603b());
                    } catch (IOException e) {
                        anzVar.m4605d();
                        throw e;
                    }
                } catch (anx e2) {
                    if (!m4643a(e2.m4579b(), anzVar, false, aneVarMo2115a)) {
                        throw e2.m4577a();
                    }
                } catch (IOException e3) {
                    if (!m4643a(e3, anzVar, !(e3 instanceof aon), aneVarMo2115a)) {
                        throw e3;
                    }
                }
                if (aneVarM4641a == null) {
                    if (!this.f4345b) {
                        anzVar.m4605d();
                    }
                    return angVarM4473a;
                }
                anm.m4506a(angVarM4473a.m4455f());
                int i2 = i + 1;
                if (i2 > 20) {
                    anzVar.m4605d();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (aneVarM4641a.m4424d() instanceof aol) {
                    anzVar.m4605d();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", angVarM4473a.m4451b());
                }
                if (!m4642a(angVarM4473a, aneVarM4641a.m4419a())) {
                    anzVar.m4605d();
                    anzVar = new anz(this.f4344a.m2145p(), m4640a(aneVarM4641a.m4419a()), amjVarM4634h, amvVarM4635i, this.f4347d);
                    this.f4346c = anzVar;
                } else if (anzVar.m4597a() != null) {
                    throw new IllegalStateException("Closing the body of " + angVarM4473a + " didn't close its backing stream. Bad interceptor?");
                }
                angVar = angVarM4473a;
                aneVarMo2115a = aneVarM4641a;
                i = i2;
            } catch (Throwable th) {
                anzVar.m4601a((IOException) null);
                anzVar.m4605d();
                throw th;
            }
        }
        anzVar.m4605d();
        throw new IOException("Canceled");
    }

    /* JADX INFO: renamed from: a */
    private amf m4640a(amy amyVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierM2141l;
        aml amlVarM2142m;
        if (amyVar.m2081c()) {
            SSLSocketFactory sSLSocketFactoryM2140k = this.f4344a.m2140k();
            hostnameVerifierM2141l = this.f4344a.m2141l();
            sSLSocketFactory = sSLSocketFactoryM2140k;
            amlVarM2142m = this.f4344a.m2142m();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierM2141l = null;
            amlVarM2142m = null;
        }
        return new amf(amyVar.m2085f(), amyVar.m2086g(), this.f4344a.m2138i(), this.f4344a.m2139j(), sSLSocketFactory, hostnameVerifierM2141l, amlVarM2142m, this.f4344a.m2144o(), this.f4344a.m2134e(), this.f4344a.m2150u(), this.f4344a.m2151v(), this.f4344a.m2135f());
    }

    /* JADX INFO: renamed from: a */
    private boolean m4643a(IOException iOException, anz anzVar, boolean z, ane aneVar) {
        anzVar.m4601a(iOException);
        if (this.f4344a.m2148s()) {
            return !(z && (aneVar.m4424d() instanceof aol)) && m4644a(iOException, z) && anzVar.m4607f();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4644a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private ane m4641a(ang angVar, ani aniVar) throws ProtocolException {
        String strM4449a;
        amy amyVarM2080c;
        Proxy proxyM2134e;
        if (angVar == null) {
            throw new IllegalStateException();
        }
        int iM4451b = angVar.m4451b();
        String strM4422b = angVar.m4448a().m4422b();
        switch (iM4451b) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!strM4422b.equals(SpdyRequest.GET_METHOD) && !strM4422b.equals("HEAD")) {
                    return null;
                }
                break;
            case 401:
                return this.f4344a.m2143n().mo1947a(aniVar, angVar);
            case 407:
                if (aniVar != null) {
                    proxyM2134e = aniVar.m4484b();
                } else {
                    proxyM2134e = this.f4344a.m2134e();
                }
                if (proxyM2134e.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f4344a.m2144o().mo1947a(aniVar, angVar);
            case 408:
                if (!this.f4344a.m2148s() || (angVar.m4448a().m4424d() instanceof aol)) {
                    return null;
                }
                if ((angVar.m4457h() == null || angVar.m4457h().m4451b() != 408) && m4639a(angVar, 0) <= 0) {
                    return angVar.m4448a();
                }
                return null;
            case 503:
                if ((angVar.m4457h() == null || angVar.m4457h().m4451b() != 503) && m4639a(angVar, Integer.MAX_VALUE) == 0) {
                    return angVar.m4448a();
                }
                return null;
            default:
                return null;
        }
        if (!this.f4344a.m2147r() || (strM4449a = angVar.m4449a("Location")) == null || (amyVarM2080c = angVar.m4448a().m4419a().m2080c(strM4449a)) == null) {
            return null;
        }
        if (!amyVarM2080c.m2079b().equals(angVar.m4448a().m4419a().m2079b()) && !this.f4344a.m2146q()) {
            return null;
        }
        ane.C0666a c0666aM4426f = angVar.m4448a().m4426f();
        if (aof.m4628c(strM4422b)) {
            boolean zM4629d = aof.m4629d(strM4422b);
            if (aof.m4630e(strM4422b)) {
                c0666aM4426f.m4436a(SpdyRequest.GET_METHOD, (anf) null);
            } else {
                c0666aM4426f.m4436a(strM4422b, zM4629d ? angVar.m4448a().m4424d() : null);
            }
            if (!zM4629d) {
                c0666aM4426f.m4438b("Transfer-Encoding");
                c0666aM4426f.m4438b("Content-Length");
                c0666aM4426f.m4438b(MIME.CONTENT_TYPE);
            }
        }
        if (!m4642a(angVar, amyVarM2080c)) {
            c0666aM4426f.m4438b("Authorization");
        }
        return c0666aM4426f.m4431a(amyVarM2080c).m4440b();
    }

    /* JADX INFO: renamed from: a */
    private int m4639a(ang angVar, int i) {
        String strM4449a = angVar.m4449a("Retry-After");
        if (strM4449a == null) {
            return i;
        }
        if (strM4449a.matches("\\d+")) {
            return Integer.valueOf(strM4449a).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4642a(ang angVar, amy amyVar) {
        amy amyVarM4419a = angVar.m4448a().m4419a();
        return amyVarM4419a.m2085f().equals(amyVar.m2085f()) && amyVarM4419a.m2086g() == amyVar.m2086g() && amyVarM4419a.m2079b().equals(amyVar.m2079b());
    }
}
