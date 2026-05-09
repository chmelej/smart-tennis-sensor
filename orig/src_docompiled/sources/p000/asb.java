package p000;

/* JADX INFO: compiled from: AsyncPoster.java */
/* JADX INFO: loaded from: classes.dex */
class asb implements Runnable {

    /* JADX INFO: renamed from: a */
    private final asj f4908a = new asj();

    /* JADX INFO: renamed from: b */
    private final asd f4909b;

    asb(asd asdVar) {
        this.f4909b = asdVar;
    }

    /* JADX INFO: renamed from: a */
    public void m5321a(aso asoVar, Object obj) {
        this.f4908a.m5345a(asi.m5341a(asoVar, obj));
        this.f4909b.m5336b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        asi asiVarM5343a = this.f4908a.m5343a();
        if (asiVarM5343a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f4909b.m5333a(asiVarM5343a);
    }
}
