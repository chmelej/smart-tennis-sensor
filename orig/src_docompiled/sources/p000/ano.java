package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000.amx;
import p000.amz;
import p000.ang;
import p000.anq;

/* JADX INFO: compiled from: CacheInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class ano implements amz {

    /* JADX INFO: renamed from: a */
    final ans f4228a;

    public ano(ans ansVar) {
        this.f4228a = ansVar;
    }

    @Override // p000.amz
    /* JADX INFO: renamed from: a */
    public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) {
        ang angVarM4548a = this.f4228a != null ? this.f4228a.m4548a(interfaceC0211a.mo2115a()) : null;
        anq anqVarM4538a = new anq.C0674a(System.currentTimeMillis(), interfaceC0211a.mo2115a(), angVarM4548a).m4538a();
        ane aneVar = anqVarM4538a.f4234a;
        ang angVar = anqVarM4538a.f4235b;
        if (this.f4228a != null) {
            this.f4228a.m4552a(anqVarM4538a);
        }
        if (angVarM4548a != null && angVar == null) {
            anm.m4506a(angVarM4548a.m4455f());
        }
        if (aneVar == null && angVar == null) {
            return new ang.C0669a().m4468a(interfaceC0211a.mo2115a()).m4467a(anc.HTTP_1_1).m4463a(504).m4471a("Unsatisfiable Request (only-if-cached)").m4470a(anm.f4209c).m4464a(-1L).m4474b(System.currentTimeMillis()).m4473a();
        }
        if (aneVar == null) {
            return angVar.m4456g().m4475b(m4526a(angVar)).m4473a();
        }
        try {
            ang angVarMo2116a = interfaceC0211a.mo2116a(aneVar);
            if (angVarMo2116a == null && angVarM4548a != null) {
            }
            if (angVar != null) {
                if (angVarMo2116a.m4451b() == 304) {
                    ang angVarM4473a = angVar.m4456g().m4466a(m4525a(angVar.m4454e(), angVarMo2116a.m4454e())).m4464a(angVarMo2116a.m4459j()).m4474b(angVarMo2116a.m4460k()).m4475b(m4526a(angVar)).m4469a(m4526a(angVarMo2116a)).m4473a();
                    angVarMo2116a.m4455f().close();
                    this.f4228a.m4550a();
                    this.f4228a.m4551a(angVar, angVarM4473a);
                    return angVarM4473a;
                }
                anm.m4506a(angVar.m4455f());
            }
            ang angVarM4473a2 = angVarMo2116a.m4456g().m4475b(m4526a(angVar)).m4469a(m4526a(angVarMo2116a)).m4473a();
            if (this.f4228a != null) {
                if (aoe.m4625b(angVarM4473a2) && anq.m4532a(angVarM4473a2, aneVar)) {
                    return m4527a(this.f4228a.m4549a(angVarM4473a2), angVarM4473a2);
                }
                if (aof.m4626a(aneVar.m4422b())) {
                    try {
                        this.f4228a.m4553b(aneVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return angVarM4473a2;
        } finally {
            if (angVarM4548a != null) {
                anm.m4506a(angVarM4548a.m4455f());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static ang m4526a(ang angVar) {
        return (angVar == null || angVar.m4455f() == null) ? angVar : angVar.m4456g().m4470a((anh) null).m4473a();
    }

    /* JADX INFO: renamed from: a */
    private ang m4527a(final anp anpVar, ang angVar) {
        Sink sinkM4530a;
        if (anpVar == null || (sinkM4530a = anpVar.m4530a()) == null) {
            return angVar;
        }
        final BufferedSource bufferedSourceMo4481c = angVar.m4455f().mo4481c();
        final BufferedSink bufferedSinkBuffer = Okio.buffer(sinkM4530a);
        return angVar.m4456g().m4470a(new aoh(angVar.m4449a(MIME.CONTENT_TYPE), angVar.m4455f().mo4480b(), Okio.buffer(new Source() { // from class: ano.1

            /* JADX INFO: renamed from: a */
            boolean f4229a;

            @Override // okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long j2 = bufferedSourceMo4481c.read(buffer, j);
                    if (j2 == -1) {
                        if (!this.f4229a) {
                            this.f4229a = true;
                            bufferedSinkBuffer.close();
                        }
                        return -1L;
                    }
                    buffer.copyTo(bufferedSinkBuffer.buffer(), buffer.size() - j2, j2);
                    bufferedSinkBuffer.emitCompleteSegments();
                    return j2;
                } catch (IOException e) {
                    if (!this.f4229a) {
                        this.f4229a = true;
                        anpVar.m4531b();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return bufferedSourceMo4481c.timeout();
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.f4229a && !anm.m4512a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f4229a = true;
                    anpVar.m4531b();
                }
                bufferedSourceMo4481c.close();
            }
        }))).m4473a();
    }

    /* JADX INFO: renamed from: a */
    private static amx m4525a(amx amxVar, amx amxVar2) {
        amx.C0209a c0209a = new amx.C0209a();
        int iM2052a = amxVar.m2052a();
        for (int i = 0; i < iM2052a; i++) {
            String strM2053a = amxVar.m2053a(i);
            String strM2056b = amxVar.m2056b(i);
            if ((!"Warning".equalsIgnoreCase(strM2053a) || !strM2056b.startsWith("1")) && (m4529b(strM2053a) || !m4528a(strM2053a) || amxVar2.m2054a(strM2053a) == null)) {
                ank.f4205a.mo2161a(c0209a, strM2053a, strM2056b);
            }
        }
        int iM2052a2 = amxVar2.m2052a();
        for (int i2 = 0; i2 < iM2052a2; i2++) {
            String strM2053a2 = amxVar2.m2053a(i2);
            if (!m4529b(strM2053a2) && m4528a(strM2053a2)) {
                ank.f4205a.mo2161a(c0209a, strM2053a2, amxVar2.m2056b(i2));
            }
        }
        return c0209a.m2061a();
    }

    /* JADX INFO: renamed from: a */
    static boolean m4528a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    static boolean m4529b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || MIME.CONTENT_TYPE.equalsIgnoreCase(str);
    }
}
