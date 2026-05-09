package p000;

import p000.afq;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes.dex */
public class afh {

    /* JADX INFO: renamed from: a */
    private final afv f755a;

    /* JADX INFO: renamed from: b */
    private final agh f756b;

    public afh() {
        this(new afq.C0088a());
    }

    public afh(afx afxVar) {
        this.f756b = new agh();
        this.f755a = afxVar.mo881a(this.f756b);
    }

    /* JADX INFO: renamed from: a */
    public void m841a(aff affVar, byte[] bArr) {
        try {
            this.f756b.m918a(bArr);
            affVar.mo525a(this.f755a);
        } finally {
            this.f756b.m916a();
            this.f755a.mo903x();
        }
    }
}
