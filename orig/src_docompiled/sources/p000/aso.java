package p000;

/* JADX INFO: compiled from: Subscription.java */
/* JADX INFO: loaded from: classes.dex */
final class aso {

    /* JADX INFO: renamed from: a */
    final Object f4987a;

    /* JADX INFO: renamed from: b */
    final asm f4988b;

    /* JADX INFO: renamed from: c */
    volatile boolean f4989c = true;

    aso(Object obj, asm asmVar) {
        this.f4987a = obj;
        this.f4988b = asmVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aso)) {
            return false;
        }
        aso asoVar = (aso) obj;
        return this.f4987a == asoVar.f4987a && this.f4988b.equals(asoVar.f4988b);
    }

    public int hashCode() {
        return this.f4987a.hashCode() + this.f4988b.f4973f.hashCode();
    }
}
