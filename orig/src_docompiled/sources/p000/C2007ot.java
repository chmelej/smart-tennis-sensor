package p000;

import p000.ark;

/* JADX INFO: renamed from: ot */
/* JADX INFO: compiled from: ESDescriptorBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C2007ot extends C2006os {

    /* JADX INFO: renamed from: c */
    private static final /* synthetic */ ark.InterfaceC0740a f12068c = null;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f12069k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f12070l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f12071m = null;

    static {
        m11047c();
    }

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m11047c() {
        aru aruVar = new aru("ESDescriptorBox.java", C2007ot.class);
        f12068c = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 33);
        f12069k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 37);
        f12070l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 42);
        f12071m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 53);
    }

    public C2007ot() {
        super("esds");
    }

    /* JADX INFO: renamed from: a */
    public void m11048a(C2016pb c2016pb) {
        C1988or.m10919a().m10921a(aru.m5284a(f12069k, this, this, c2016pb));
        super.m11045a((AbstractC2009ov) c2016pb);
    }

    public boolean equals(Object obj) {
        C1988or.m10919a().m10921a(aru.m5284a(f12070l, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2007ot c2007ot = (C2007ot) obj;
        return this.f12067b == null ? c2007ot.f12067b == null : this.f12067b.equals(c2007ot.f12067b);
    }

    public int hashCode() {
        C1988or.m10919a().m10921a(aru.m5283a(f12071m, this, this));
        if (this.f12067b != null) {
            return this.f12067b.hashCode();
        }
        return 0;
    }
}
