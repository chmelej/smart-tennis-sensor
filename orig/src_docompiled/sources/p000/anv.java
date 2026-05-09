package p000;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import p000.amz;
import p000.ane;
import p000.aot;

/* JADX INFO: compiled from: RealConnection.java */
/* JADX INFO: loaded from: classes.dex */
public final class anv extends aot.AbstractC0699b implements amn {

    /* JADX INFO: renamed from: a */
    public boolean f4279a;

    /* JADX INFO: renamed from: b */
    public int f4280b;

    /* JADX INFO: renamed from: c */
    public int f4281c = 1;

    /* JADX INFO: renamed from: d */
    public final List<Reference<anz>> f4282d = new ArrayList();

    /* JADX INFO: renamed from: e */
    public long f4283e = Long.MAX_VALUE;

    /* JADX INFO: renamed from: g */
    private final amo f4284g;

    /* JADX INFO: renamed from: h */
    private final ani f4285h;

    /* JADX INFO: renamed from: i */
    private Socket f4286i;

    /* JADX INFO: renamed from: j */
    private Socket f4287j;

    /* JADX INFO: renamed from: k */
    private amw f4288k;

    /* JADX INFO: renamed from: l */
    private anc f4289l;

    /* JADX INFO: renamed from: m */
    private aot f4290m;

    /* JADX INFO: renamed from: n */
    private BufferedSource f4291n;

    /* JADX INFO: renamed from: o */
    private BufferedSink f4292o;

    public anv(amo amoVar, ani aniVar) {
        this.f4284g = amoVar;
        this.f4285h = aniVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156 A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m4565a(int r18, int r19, int r20, int r21, boolean r22, p000.amj r23, p000.amv r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.anv.m4565a(int, int, int, int, boolean, amj, amv):void");
    }

    /* JADX INFO: renamed from: a */
    private void m4559a(int i, int i2, int i3, amj amjVar, amv amvVar) throws IOException {
        ane aneVarM4563e = m4563e();
        amy amyVarM4419a = aneVarM4563e.m4419a();
        for (int i4 = 0; i4 < 21; i4++) {
            m4560a(i, i2, amjVar, amvVar);
            aneVarM4563e = m4557a(i2, i3, aneVarM4563e, amyVarM4419a);
            if (aneVarM4563e == null) {
                return;
            }
            anm.m4508a(this.f4286i);
            this.f4286i = null;
            this.f4292o = null;
            this.f4291n = null;
            amvVar.m2037a(amjVar, this.f4285h.m4485c(), this.f4285h.m4484b(), null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4560a(int i, int i2, amj amjVar, amv amvVar) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyM4484b = this.f4285h.m4484b();
        amf amfVarM4483a = this.f4285h.m4483a();
        if (proxyM4484b.type() == Proxy.Type.DIRECT || proxyM4484b.type() == Proxy.Type.HTTP) {
            socketCreateSocket = amfVarM4483a.m1938c().createSocket();
        } else {
            socketCreateSocket = new Socket(proxyM4484b);
        }
        this.f4286i = socketCreateSocket;
        amvVar.m2036a(amjVar, this.f4285h.m4485c(), proxyM4484b);
        this.f4286i.setSoTimeout(i2);
        try {
            aph.m4853c().mo4827a(this.f4286i, this.f4285h.m4485c(), i);
            try {
                this.f4291n = Okio.buffer(Okio.source(this.f4286i));
                this.f4292o = Okio.buffer(Okio.sink(this.f4286i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f4285h.m4485c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4562a(anu anuVar, int i, amj amjVar, amv amvVar) throws Throwable {
        if (this.f4285h.m4483a().m1944i() == null) {
            if (this.f4285h.m4483a().m1940e().contains(anc.H2_PRIOR_KNOWLEDGE)) {
                this.f4287j = this.f4286i;
                this.f4289l = anc.H2_PRIOR_KNOWLEDGE;
                m4558a(i);
                return;
            } else {
                this.f4287j = this.f4286i;
                this.f4289l = anc.HTTP_1_1;
                return;
            }
        }
        amvVar.m2039b(amjVar);
        m4561a(anuVar);
        amvVar.m2030a(amjVar, this.f4288k);
        if (this.f4289l == anc.HTTP_2) {
            m4558a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4558a(int i) throws SocketException {
        this.f4287j.setSoTimeout(0);
        this.f4290m = new aot.C0698a(true).m4724a(this.f4287j, this.f4285h.m4483a().m1935a().m2085f(), this.f4291n, this.f4292o).m4723a(this).m4722a(i).m4725a();
        this.f4290m.m4718c();
    }

    /* JADX INFO: renamed from: a */
    private void m4561a(anu anuVar) throws Throwable {
        SSLSocket sSLSocket;
        anc ancVarM2173a;
        amf amfVarM4483a = this.f4285h.m4483a();
        try {
            try {
                sSLSocket = (SSLSocket) amfVarM4483a.m1944i().createSocket(this.f4286i, amfVarM4483a.m1935a().m2085f(), amfVarM4483a.m1935a().m2086g(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            amp ampVarM4555a = anuVar.m4555a(sSLSocket);
            if (ampVarM4555a.m1994d()) {
                aph.m4853c().mo4828a(sSLSocket, amfVarM4483a.m1935a().m2085f(), amfVarM4483a.m1940e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            amw amwVarM2048a = amw.m2048a(session);
            if (!amfVarM4483a.m1945j().verify(amfVarM4483a.m1935a().m2085f(), session)) {
                X509Certificate x509Certificate = (X509Certificate) amwVarM2048a.m2050b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + amfVarM4483a.m1935a().m2085f() + " not verified:\n    certificate: " + aml.m1969a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + apm.m4863a(x509Certificate));
            }
            amfVarM4483a.m1946k().m1974a(amfVarM4483a.m1935a().m2085f(), amwVarM2048a.m2050b());
            String strMo4824a = ampVarM4555a.m1994d() ? aph.m4853c().mo4824a(sSLSocket) : null;
            this.f4287j = sSLSocket;
            this.f4291n = Okio.buffer(Okio.source(this.f4287j));
            this.f4292o = Okio.buffer(Okio.sink(this.f4287j));
            this.f4288k = amwVarM2048a;
            if (strMo4824a != null) {
                ancVarM2173a = anc.m2173a(strMo4824a);
            } else {
                ancVarM2173a = anc.HTTP_1_1;
            }
            this.f4289l = ancVarM2173a;
            if (sSLSocket != null) {
                aph.m4853c().mo4842b(sSLSocket);
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!anm.m4509a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                aph.m4853c().mo4842b(sSLSocket);
            }
            anm.m4508a((Socket) sSLSocket);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private ane m4557a(int i, int i2, ane aneVar, amy amyVar) throws IOException {
        String str = "CONNECT " + anm.m4496a(amyVar, true) + " HTTP/1.1";
        while (true) {
            aom aomVar = new aom(null, null, this.f4291n, this.f4292o);
            this.f4291n.timeout().timeout(i, TimeUnit.MILLISECONDS);
            this.f4292o.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            aomVar.m4651a(aneVar.m4423c(), str);
            aomVar.mo4614b();
            ang angVarM4473a = aomVar.mo4609a(false).m4468a(aneVar).m4473a();
            long jM4621a = aoe.m4621a(angVarM4473a);
            if (jM4621a == -1) {
                jM4621a = 0;
            }
            Source sourceM4653b = aomVar.m4653b(jM4621a);
            anm.m4518b(sourceM4653b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sourceM4653b.close();
            int iM4451b = angVarM4473a.m4451b();
            if (iM4451b == 200) {
                if (this.f4291n.buffer().exhausted() && this.f4292o.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM4451b == 407) {
                ane aneVarMo1947a = this.f4285h.m4483a().m1939d().mo1947a(this.f4285h, angVarM4473a);
                if (aneVarMo1947a == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(angVarM4473a.m4449a("Connection"))) {
                    return aneVarMo1947a;
                }
                aneVar = aneVarMo1947a;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + angVarM4473a.m4451b());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private ane m4563e() {
        return new ane.C0666a().m4431a(this.f4285h.m4483a().m1935a()).m4437a("Host", anm.m4496a(this.f4285h.m4483a().m1935a(), true)).m4437a("Proxy-Connection", "Keep-Alive").m4437a("User-Agent", ann.m4524a()).m4440b();
    }

    /* JADX INFO: renamed from: a */
    public boolean m4568a(amf amfVar, @Nullable ani aniVar) {
        if (this.f4282d.size() >= this.f4281c || this.f4279a || !ank.f4205a.mo2162a(this.f4285h.m4483a(), amfVar)) {
            return false;
        }
        if (amfVar.m1935a().m2085f().equals(m4571b().m4483a().m1935a().m2085f())) {
            return true;
        }
        if (this.f4290m == null || aniVar == null || aniVar.m4484b().type() != Proxy.Type.DIRECT || this.f4285h.m4484b().type() != Proxy.Type.DIRECT || !this.f4285h.m4485c().equals(aniVar.m4485c()) || aniVar.m4483a().m1945j() != apm.f4598a || !m4569a(amfVar.m1935a())) {
            return false;
        }
        try {
            amfVar.m1946k().m1974a(amfVar.m1935a().m2085f(), m4572c().m2050b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4569a(amy amyVar) {
        if (amyVar.m2086g() != this.f4285h.m4483a().m1935a().m2086g()) {
            return false;
        }
        if (amyVar.m2085f().equals(this.f4285h.m4483a().m1935a().m2085f())) {
            return true;
        }
        return this.f4288k != null && apm.f4598a.m4868a(amyVar.m2085f(), (X509Certificate) this.f4288k.m2050b().get(0));
    }

    /* JADX INFO: renamed from: a */
    public aoc m4564a(anb anbVar, amz.InterfaceC0211a interfaceC0211a, anz anzVar) throws SocketException {
        if (this.f4290m != null) {
            return new aos(anbVar, interfaceC0211a, anzVar, this.f4290m);
        }
        this.f4287j.setSoTimeout(interfaceC0211a.mo2119d());
        this.f4291n.timeout().timeout(interfaceC0211a.mo2119d(), TimeUnit.MILLISECONDS);
        this.f4292o.timeout().timeout(interfaceC0211a.mo2120e(), TimeUnit.MILLISECONDS);
        return new aom(anbVar, anzVar, this.f4291n, this.f4292o);
    }

    /* JADX INFO: renamed from: b */
    public ani m4571b() {
        return this.f4285h;
    }

    @Override // p000.amn
    /* JADX INFO: renamed from: a */
    public Socket mo1981a() {
        return this.f4287j;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4570a(boolean z) {
        if (this.f4287j.isClosed() || this.f4287j.isInputShutdown() || this.f4287j.isOutputShutdown()) {
            return false;
        }
        if (this.f4290m != null) {
            return !this.f4290m.m4721d();
        }
        if (z) {
            try {
                int soTimeout = this.f4287j.getSoTimeout();
                try {
                    this.f4287j.setSoTimeout(1);
                    return !this.f4291n.exhausted();
                } finally {
                    this.f4287j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // p000.aot.AbstractC0699b
    /* JADX INFO: renamed from: a */
    public void mo4567a(aov aovVar) {
        aovVar.m4756a(aoo.REFUSED_STREAM);
    }

    @Override // p000.aot.AbstractC0699b
    /* JADX INFO: renamed from: a */
    public void mo4566a(aot aotVar) {
        synchronized (this.f4284g) {
            this.f4281c = aotVar.m4701a();
        }
    }

    /* JADX INFO: renamed from: c */
    public amw m4572c() {
        return this.f4288k;
    }

    /* JADX INFO: renamed from: d */
    public boolean m4573d() {
        return this.f4290m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f4285h.m4483a().m1935a().m2085f());
        sb.append(":");
        sb.append(this.f4285h.m4483a().m1935a().m2086g());
        sb.append(", proxy=");
        sb.append(this.f4285h.m4484b());
        sb.append(" hostAddress=");
        sb.append(this.f4285h.m4485c());
        sb.append(" cipherSuite=");
        sb.append(this.f4288k != null ? this.f4288k.m2049a() : "none");
        sb.append(" protocol=");
        sb.append(this.f4289l);
        sb.append('}');
        return sb.toString();
    }
}
