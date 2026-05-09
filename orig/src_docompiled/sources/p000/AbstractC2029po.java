package p000;

/* JADX INFO: renamed from: po */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2029po {
    /* JADX INFO: renamed from: a */
    public abstract void mo11091a(String str);

    /* JADX INFO: renamed from: b */
    public abstract void mo11092b(String str);

    /* JADX INFO: renamed from: a */
    public static AbstractC2029po m11097a(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new C2024pj(cls.getSimpleName());
        }
        return new C2027pm(cls.getSimpleName());
    }
}
