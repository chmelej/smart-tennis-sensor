package p000;

/* JADX INFO: compiled from: Subscription.java */
/* JADX INFO: loaded from: classes.dex */
final class akn {

    /* JADX INFO: renamed from: a */
    final Object f1488a;

    /* JADX INFO: renamed from: b */
    final akl f1489b;

    /* JADX INFO: renamed from: c */
    final int f1490c;

    /* JADX INFO: renamed from: d */
    volatile boolean f1491d = true;

    akn(Object obj, akl aklVar, int i) {
        this.f1488a = obj;
        this.f1489b = aklVar;
        this.f1490c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof akn)) {
            return false;
        }
        akn aknVar = (akn) obj;
        return this.f1488a == aknVar.f1488a && this.f1489b.equals(aknVar.f1489b);
    }

    public int hashCode() {
        return this.f1488a.hashCode() + this.f1489b.f1485d.hashCode();
    }
}
