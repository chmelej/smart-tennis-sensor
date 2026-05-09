package p000;

import java.io.File;

/* JADX INFO: renamed from: td */
/* JADX INFO: compiled from: Configuration.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2128td {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2132th f12759a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2130tf f12760b;

    /* JADX INFO: renamed from: c */
    public final C2123sz f12761c;

    /* JADX INFO: renamed from: d */
    public final int f12762d;

    /* JADX INFO: renamed from: e */
    public final int f12763e;

    /* JADX INFO: renamed from: f */
    public final int f12764f;

    /* JADX INFO: renamed from: g */
    public final int f12765g;

    /* JADX INFO: renamed from: h */
    public final int f12766h;

    /* JADX INFO: renamed from: i */
    public InterfaceC2126tb f12767i;

    /* JADX INFO: renamed from: j */
    public InterfaceC2118su f12768j;

    /* JADX INFO: renamed from: k */
    public AbstractC2112so f12769k;

    /* JADX INFO: renamed from: l */
    public boolean f12770l;

    private C2128td(a aVar) {
        this.f12770l = aVar.f12776e;
        this.f12762d = aVar.f12777f;
        this.f12763e = aVar.f12778g;
        this.f12764f = aVar.f12779h;
        this.f12765g = aVar.f12780i;
        this.f12759a = aVar.f12773b;
        this.f12760b = m11635a(aVar.f12774c);
        this.f12766h = aVar.f12781j;
        this.f12761c = aVar.f12775d;
        this.f12767i = aVar.f12782k;
        this.f12769k = aVar.f12772a == null ? C2111sn.f12661a : aVar.f12772a;
        this.f12768j = aVar.f12783l;
    }

    /* JADX INFO: renamed from: a */
    private InterfaceC2130tf m11635a(InterfaceC2130tf interfaceC2130tf) {
        return interfaceC2130tf == null ? new InterfaceC2130tf() { // from class: td.1
            @Override // p000.InterfaceC2130tf
            /* JADX INFO: renamed from: a */
            public String mo11636a(String str, File file) {
                return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
            }
        } : interfaceC2130tf;
    }

    /* JADX INFO: renamed from: td$a */
    /* JADX INFO: compiled from: Configuration.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private AbstractC2112so f12772a = null;

        /* JADX INFO: renamed from: b */
        private InterfaceC2132th f12773b = null;

        /* JADX INFO: renamed from: c */
        private InterfaceC2130tf f12774c = null;

        /* JADX INFO: renamed from: d */
        private C2123sz f12775d = null;

        /* JADX INFO: renamed from: e */
        private boolean f12776e = false;

        /* JADX INFO: renamed from: f */
        private int f12777f = 2097152;

        /* JADX INFO: renamed from: g */
        private int f12778g = 4194304;

        /* JADX INFO: renamed from: h */
        private int f12779h = 10;

        /* JADX INFO: renamed from: i */
        private int f12780i = 60;

        /* JADX INFO: renamed from: j */
        private int f12781j = 3;

        /* JADX INFO: renamed from: k */
        private InterfaceC2126tb f12782k = null;

        /* JADX INFO: renamed from: l */
        private InterfaceC2118su f12783l = null;

        /* JADX INFO: renamed from: a */
        public a m11650a(AbstractC2112so abstractC2112so) {
            this.f12772a = abstractC2112so;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11651a(InterfaceC2132th interfaceC2132th, InterfaceC2130tf interfaceC2130tf) {
            this.f12773b = interfaceC2132th;
            this.f12774c = interfaceC2130tf;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11649a(int i) {
            this.f12777f = i;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m11654b(int i) {
            this.f12778g = i;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m11655c(int i) {
            this.f12779h = i;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public a m11656d(int i) {
            this.f12780i = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11652a(boolean z) {
            this.f12776e = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C2128td m11653a() {
            return new C2128td(this);
        }
    }
}
