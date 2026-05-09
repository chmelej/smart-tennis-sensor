package p000;

import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import p000.amz;
import p000.ang;

/* JADX INFO: compiled from: CallServerInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class aob implements amz {

    /* JADX INFO: renamed from: a */
    private final boolean f4323a;

    public aob(boolean z) {
        this.f4323a = z;
    }

    @Override // p000.amz
    /* JADX INFO: renamed from: a */
    public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) throws ProtocolException {
        ang angVarM4473a;
        aog aogVar = (aog) interfaceC0211a;
        aoc aocVarM4633g = aogVar.m4633g();
        anz anzVarM4632f = aogVar.m4632f();
        anv anvVar = (anv) aogVar.mo2117b();
        ane aneVarMo2115a = aogVar.mo2115a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        aogVar.m4635i().m2042c(aogVar.m4634h());
        aocVarM4633g.mo4613a(aneVarMo2115a);
        aogVar.m4635i().m2031a(aogVar.m4634h(), aneVarMo2115a);
        ang.C0669a c0669aMo4609a = null;
        if (aof.m4628c(aneVarMo2115a.m4422b()) && aneVarMo2115a.m4424d() != null) {
            if ("100-continue".equalsIgnoreCase(aneVarMo2115a.m4421a("Expect"))) {
                aocVarM4633g.mo4612a();
                aogVar.m4635i().m2044e(aogVar.m4634h());
                c0669aMo4609a = aocVarM4633g.mo4609a(true);
            }
            if (c0669aMo4609a == null) {
                aogVar.m4635i().m2043d(aogVar.m4634h());
                C0680a c0680a = new C0680a(aocVarM4633g.mo4611a(aneVarMo2115a, aneVarMo2115a.m4424d().mo4445a()));
                BufferedSink bufferedSinkBuffer = Okio.buffer(c0680a);
                aneVarMo2115a.m4424d().mo4446a(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                aogVar.m4635i().m2028a(aogVar.m4634h(), c0680a.f4324a);
            } else if (!anvVar.m4573d()) {
                anzVarM4632f.m4606e();
            }
        }
        aocVarM4633g.mo4614b();
        if (c0669aMo4609a == null) {
            aogVar.m4635i().m2044e(aogVar.m4634h());
            c0669aMo4609a = aocVarM4633g.mo4609a(false);
        }
        ang angVarM4473a2 = c0669aMo4609a.m4468a(aneVarMo2115a).m4465a(anzVarM4632f.m4604c().m4572c()).m4464a(jCurrentTimeMillis).m4474b(System.currentTimeMillis()).m4473a();
        int iM4451b = angVarM4473a2.m4451b();
        if (iM4451b == 100) {
            angVarM4473a2 = aocVarM4633g.mo4609a(false).m4468a(aneVarMo2115a).m4465a(anzVarM4632f.m4604c().m4572c()).m4464a(jCurrentTimeMillis).m4474b(System.currentTimeMillis()).m4473a();
            iM4451b = angVarM4473a2.m4451b();
        }
        aogVar.m4635i().m2032a(aogVar.m4634h(), angVarM4473a2);
        if (this.f4323a && iM4451b == 101) {
            angVarM4473a = angVarM4473a2.m4456g().m4470a(anm.f4209c).m4473a();
        } else {
            angVarM4473a = angVarM4473a2.m4456g().m4470a(aocVarM4633g.mo4610a(angVarM4473a2)).m4473a();
        }
        if ("close".equalsIgnoreCase(angVarM4473a.m4448a().m4421a("Connection")) || "close".equalsIgnoreCase(angVarM4473a.m4449a("Connection"))) {
            anzVarM4632f.m4606e();
        }
        if ((iM4451b != 204 && iM4451b != 205) || angVarM4473a.m4455f().mo4480b() <= 0) {
            return angVarM4473a;
        }
        throw new ProtocolException("HTTP " + iM4451b + " had non-zero Content-Length: " + angVarM4473a.m4455f().mo4480b());
    }

    /* JADX INFO: renamed from: aob$a */
    /* JADX INFO: compiled from: CallServerInterceptor.java */
    static final class C0680a extends ForwardingSink {

        /* JADX INFO: renamed from: a */
        long f4324a;

        C0680a(Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            this.f4324a += j;
        }
    }
}
