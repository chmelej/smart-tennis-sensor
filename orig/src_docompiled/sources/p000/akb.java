package p000;

/* JADX INFO: compiled from: AsyncPoster.java */
/* JADX INFO: loaded from: classes.dex */
class akb implements Runnable {

    /* JADX INFO: renamed from: a */
    private final akj f1425a = new akj();

    /* JADX INFO: renamed from: b */
    private final akd f1426b;

    akb(akd akdVar) {
        this.f1426b = akdVar;
    }

    /* JADX INFO: renamed from: a */
    public void m1704a(akn aknVar, Object obj) {
        this.f1425a.m1729a(aki.m1725a(aknVar, obj));
        this.f1426b.m1720b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        aki akiVarM1727a = this.f1425a.m1727a();
        if (akiVarM1727a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f1426b.m1717a(akiVarM1727a);
    }
}
