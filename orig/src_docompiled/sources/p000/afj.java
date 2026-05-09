package p000;

import java.io.ByteArrayOutputStream;
import p000.afq;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes.dex */
public class afj {

    /* JADX INFO: renamed from: a */
    private final ByteArrayOutputStream f757a;

    /* JADX INFO: renamed from: b */
    private final agg f758b;

    /* JADX INFO: renamed from: c */
    private afv f759c;

    public afj() {
        this(new afq.C0088a());
    }

    public afj(afx afxVar) {
        this.f757a = new ByteArrayOutputStream();
        this.f758b = new agg(this.f757a);
        this.f759c = afxVar.mo881a(this.f758b);
    }

    /* JADX INFO: renamed from: a */
    public byte[] m842a(aff affVar) {
        this.f757a.reset();
        affVar.mo529b(this.f759c);
        return this.f757a.toByteArray();
    }
}
