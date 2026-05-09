package p000;

import org.android.spdy.SpdyRequest;
import p000.amz;

/* JADX INFO: compiled from: ConnectInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class ant implements amz {

    /* JADX INFO: renamed from: a */
    public final anb f4274a;

    public ant(anb anbVar) {
        this.f4274a = anbVar;
    }

    @Override // p000.amz
    /* JADX INFO: renamed from: a */
    public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) {
        aog aogVar = (aog) interfaceC0211a;
        ane aneVarMo2115a = aogVar.mo2115a();
        anz anzVarM4632f = aogVar.m4632f();
        return aogVar.m4631a(aneVarMo2115a, anzVarM4632f, anzVarM4632f.m4598a(this.f4274a, interfaceC0211a, !aneVarMo2115a.m4422b().equals(SpdyRequest.GET_METHOD)), anzVarM4632f.m4604c());
    }
}
