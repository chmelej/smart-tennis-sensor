package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import p000.amz;
import p000.ane;
import p000.ang;

/* JADX INFO: compiled from: BridgeInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoa implements amz {

    /* JADX INFO: renamed from: a */
    private final amr f4322a;

    public aoa(amr amrVar) {
        this.f4322a = amrVar;
    }

    @Override // p000.amz
    /* JADX INFO: renamed from: a */
    public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) {
        ane aneVarMo2115a = interfaceC0211a.mo2115a();
        ane.C0666a c0666aM4426f = aneVarMo2115a.m4426f();
        anf anfVarM4424d = aneVarMo2115a.m4424d();
        if (anfVarM4424d != null) {
            ana anaVarMo4447b = anfVarM4424d.mo4447b();
            if (anaVarMo4447b != null) {
                c0666aM4426f.m4437a(MIME.CONTENT_TYPE, anaVarMo4447b.toString());
            }
            long jMo4445a = anfVarM4424d.mo4445a();
            if (jMo4445a != -1) {
                c0666aM4426f.m4437a("Content-Length", Long.toString(jMo4445a));
                c0666aM4426f.m4438b("Transfer-Encoding");
            } else {
                c0666aM4426f.m4437a("Transfer-Encoding", "chunked");
                c0666aM4426f.m4438b("Content-Length");
            }
        }
        boolean z = false;
        if (aneVarMo2115a.m4421a("Host") == null) {
            c0666aM4426f.m4437a("Host", anm.m4496a(aneVarMo2115a.m4419a(), false));
        }
        if (aneVarMo2115a.m4421a("Connection") == null) {
            c0666aM4426f.m4437a("Connection", "Keep-Alive");
        }
        if (aneVarMo2115a.m4421a("Accept-Encoding") == null && aneVarMo2115a.m4421a("Range") == null) {
            z = true;
            c0666aM4426f.m4437a("Accept-Encoding", "gzip");
        }
        List<amq> listMo2012a = this.f4322a.mo2012a(aneVarMo2115a.m4419a());
        if (!listMo2012a.isEmpty()) {
            c0666aM4426f.m4437a("Cookie", m4608a(listMo2012a));
        }
        if (aneVarMo2115a.m4421a("User-Agent") == null) {
            c0666aM4426f.m4437a("User-Agent", ann.m4524a());
        }
        ang angVarMo2116a = interfaceC0211a.mo2116a(c0666aM4426f.m4440b());
        aoe.m4623a(this.f4322a, aneVarMo2115a.m4419a(), angVarMo2116a.m4454e());
        ang.C0669a c0669aM4468a = angVarMo2116a.m4456g().m4468a(aneVarMo2115a);
        if (z && "gzip".equalsIgnoreCase(angVarMo2116a.m4449a("Content-Encoding")) && aoe.m4625b(angVarMo2116a)) {
            GzipSource gzipSource = new GzipSource(angVarMo2116a.m4455f().mo4481c());
            c0669aM4468a.m4466a(angVarMo2116a.m4454e().m2055b().m2062b("Content-Encoding").m2062b("Content-Length").m2061a());
            c0669aM4468a.m4470a(new aoh(angVarMo2116a.m4449a(MIME.CONTENT_TYPE), -1L, Okio.buffer(gzipSource)));
        }
        return c0669aM4468a.m4473a();
    }

    /* JADX INFO: renamed from: a */
    private String m4608a(List<amq> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            amq amqVar = list.get(i);
            sb.append(amqVar.m2009a());
            sb.append('=');
            sb.append(amqVar.m2011b());
        }
        return sb.toString();
    }
}
