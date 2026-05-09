package p000;

/* JADX INFO: renamed from: or */
/* JADX INFO: compiled from: RequiresParseDetailAspect.java */
/* JADX INFO: loaded from: classes.dex */
public class C1988or {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C1988or f11971a = null;

    /* JADX INFO: renamed from: b */
    private static /* synthetic */ Throwable f11972b;

    static {
        try {
            m10920b();
        } catch (Throwable th) {
            f11972b = th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C1988or m10919a() {
        if (f11971a == null) {
            throw new arl("com.googlecode.mp4parser.RequiresParseDetailAspect", f11972b);
        }
        return f11971a;
    }

    /* JADX INFO: renamed from: b */
    private static /* synthetic */ void m10920b() {
        f11971a = new C1988or();
    }

    /* JADX INFO: renamed from: a */
    public void m10921a(ark arkVar) {
        if (arkVar.mo5275a() instanceof AbstractC1983om) {
            if (((AbstractC1983om) arkVar.mo5275a()).m10901o()) {
                return;
            }
            ((AbstractC1983om) arkVar.mo5275a()).m10898l();
        } else {
            throw new RuntimeException("Only methods in subclasses of " + AbstractC1983om.class.getName() + " can  be annotated with ParseDetail");
        }
    }
}
