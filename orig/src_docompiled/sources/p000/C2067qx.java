package p000;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: renamed from: qx */
/* JADX INFO: compiled from: DisplayImageOptions.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2067qx {

    /* JADX INFO: renamed from: a */
    private final int f12414a;

    /* JADX INFO: renamed from: b */
    private final int f12415b;

    /* JADX INFO: renamed from: c */
    private final int f12416c;

    /* JADX INFO: renamed from: d */
    private final Drawable f12417d;

    /* JADX INFO: renamed from: e */
    private final Drawable f12418e;

    /* JADX INFO: renamed from: f */
    private final Drawable f12419f;

    /* JADX INFO: renamed from: g */
    private final boolean f12420g;

    /* JADX INFO: renamed from: h */
    private final boolean f12421h;

    /* JADX INFO: renamed from: i */
    private final boolean f12422i;

    /* JADX INFO: renamed from: j */
    private final EnumC2078rh f12423j;

    /* JADX INFO: renamed from: k */
    private final BitmapFactory.Options f12424k;

    /* JADX INFO: renamed from: l */
    private final int f12425l;

    /* JADX INFO: renamed from: m */
    private final boolean f12426m;

    /* JADX INFO: renamed from: n */
    private final Object f12427n;

    /* JADX INFO: renamed from: o */
    private final InterfaceC2103sf f12428o;

    /* JADX INFO: renamed from: p */
    private final InterfaceC2103sf f12429p;

    /* JADX INFO: renamed from: q */
    private final InterfaceC2090rt f12430q;

    /* JADX INFO: renamed from: r */
    private final Handler f12431r;

    /* JADX INFO: renamed from: s */
    private final boolean f12432s;

    private C2067qx(a aVar) {
        this.f12414a = aVar.f12433a;
        this.f12415b = aVar.f12434b;
        this.f12416c = aVar.f12435c;
        this.f12417d = aVar.f12436d;
        this.f12418e = aVar.f12437e;
        this.f12419f = aVar.f12438f;
        this.f12420g = aVar.f12439g;
        this.f12421h = aVar.f12440h;
        this.f12422i = aVar.f12441i;
        this.f12423j = aVar.f12442j;
        this.f12424k = aVar.f12443k;
        this.f12425l = aVar.f12444l;
        this.f12426m = aVar.f12445m;
        this.f12427n = aVar.f12446n;
        this.f12428o = aVar.f12447o;
        this.f12429p = aVar.f12448p;
        this.f12430q = aVar.f12449q;
        this.f12431r = aVar.f12450r;
        this.f12432s = aVar.f12451s;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11302a() {
        return (this.f12417d == null && this.f12414a == 0) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m11304b() {
        return (this.f12418e == null && this.f12415b == 0) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m11306c() {
        return (this.f12419f == null && this.f12416c == 0) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public boolean m11307d() {
        return this.f12428o != null;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11308e() {
        return this.f12429p != null;
    }

    /* JADX INFO: renamed from: f */
    public boolean m11309f() {
        return this.f12425l > 0;
    }

    /* JADX INFO: renamed from: a */
    public Drawable m11301a(Resources resources) {
        return this.f12414a != 0 ? resources.getDrawable(this.f12414a) : this.f12417d;
    }

    /* JADX INFO: renamed from: b */
    public Drawable m11303b(Resources resources) {
        return this.f12415b != 0 ? resources.getDrawable(this.f12415b) : this.f12418e;
    }

    /* JADX INFO: renamed from: c */
    public Drawable m11305c(Resources resources) {
        return this.f12416c != 0 ? resources.getDrawable(this.f12416c) : this.f12419f;
    }

    /* JADX INFO: renamed from: g */
    public boolean m11310g() {
        return this.f12420g;
    }

    /* JADX INFO: renamed from: h */
    public boolean m11311h() {
        return this.f12421h;
    }

    /* JADX INFO: renamed from: i */
    public boolean m11312i() {
        return this.f12422i;
    }

    /* JADX INFO: renamed from: j */
    public EnumC2078rh m11313j() {
        return this.f12423j;
    }

    /* JADX INFO: renamed from: k */
    public BitmapFactory.Options m11314k() {
        return this.f12424k;
    }

    /* JADX INFO: renamed from: l */
    public int m11315l() {
        return this.f12425l;
    }

    /* JADX INFO: renamed from: m */
    public boolean m11316m() {
        return this.f12426m;
    }

    /* JADX INFO: renamed from: n */
    public Object m11317n() {
        return this.f12427n;
    }

    /* JADX INFO: renamed from: o */
    public InterfaceC2103sf m11318o() {
        return this.f12428o;
    }

    /* JADX INFO: renamed from: p */
    public InterfaceC2103sf m11319p() {
        return this.f12429p;
    }

    /* JADX INFO: renamed from: q */
    public InterfaceC2090rt m11320q() {
        return this.f12430q;
    }

    /* JADX INFO: renamed from: r */
    public Handler m11321r() {
        return this.f12431r;
    }

    /* JADX INFO: renamed from: s */
    boolean m11322s() {
        return this.f12432s;
    }

    /* JADX INFO: renamed from: qx$a */
    /* JADX INFO: compiled from: DisplayImageOptions.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private int f12433a = 0;

        /* JADX INFO: renamed from: b */
        private int f12434b = 0;

        /* JADX INFO: renamed from: c */
        private int f12435c = 0;

        /* JADX INFO: renamed from: d */
        private Drawable f12436d = null;

        /* JADX INFO: renamed from: e */
        private Drawable f12437e = null;

        /* JADX INFO: renamed from: f */
        private Drawable f12438f = null;

        /* JADX INFO: renamed from: g */
        private boolean f12439g = false;

        /* JADX INFO: renamed from: h */
        private boolean f12440h = false;

        /* JADX INFO: renamed from: i */
        private boolean f12441i = false;

        /* JADX INFO: renamed from: j */
        private EnumC2078rh f12442j = EnumC2078rh.IN_SAMPLE_POWER_OF_2;

        /* JADX INFO: renamed from: k */
        private BitmapFactory.Options f12443k = new BitmapFactory.Options();

        /* JADX INFO: renamed from: l */
        private int f12444l = 0;

        /* JADX INFO: renamed from: m */
        private boolean f12445m = false;

        /* JADX INFO: renamed from: n */
        private Object f12446n = null;

        /* JADX INFO: renamed from: o */
        private InterfaceC2103sf f12447o = null;

        /* JADX INFO: renamed from: p */
        private InterfaceC2103sf f12448p = null;

        /* JADX INFO: renamed from: q */
        private InterfaceC2090rt f12449q = C2065qv.m11279c();

        /* JADX INFO: renamed from: r */
        private Handler f12450r = null;

        /* JADX INFO: renamed from: s */
        private boolean f12451s = false;

        public a() {
            this.f12443k.inPurgeable = true;
            this.f12443k.inInputShareable = true;
        }

        /* JADX INFO: renamed from: a */
        public a m11342a(int i) {
            this.f12433a = i;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m11349b(int i) {
            this.f12434b = i;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m11351c(int i) {
            this.f12435c = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11347a(boolean z) {
            this.f12439g = z;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m11350b(boolean z) {
            this.f12440h = z;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m11352c(boolean z) {
            this.f12441i = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11345a(EnumC2078rh enumC2078rh) {
            this.f12442j = enumC2078rh;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11343a(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.f12443k.inPreferredConfig = config;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public a m11353d(boolean z) {
            this.f12445m = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11346a(InterfaceC2090rt interfaceC2090rt) {
            if (interfaceC2090rt == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.f12449q = interfaceC2090rt;
            return this;
        }

        /* JADX INFO: renamed from: e */
        a m11354e(boolean z) {
            this.f12451s = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11344a(C2067qx c2067qx) {
            this.f12433a = c2067qx.f12414a;
            this.f12434b = c2067qx.f12415b;
            this.f12435c = c2067qx.f12416c;
            this.f12436d = c2067qx.f12417d;
            this.f12437e = c2067qx.f12418e;
            this.f12438f = c2067qx.f12419f;
            this.f12439g = c2067qx.f12420g;
            this.f12440h = c2067qx.f12421h;
            this.f12441i = c2067qx.f12422i;
            this.f12442j = c2067qx.f12423j;
            this.f12443k = c2067qx.f12424k;
            this.f12444l = c2067qx.f12425l;
            this.f12445m = c2067qx.f12426m;
            this.f12446n = c2067qx.f12427n;
            this.f12447o = c2067qx.f12428o;
            this.f12448p = c2067qx.f12429p;
            this.f12449q = c2067qx.f12430q;
            this.f12450r = c2067qx.f12431r;
            this.f12451s = c2067qx.f12432s;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C2067qx m11348a() {
            return new C2067qx(this);
        }
    }

    /* JADX INFO: renamed from: t */
    public static C2067qx m11300t() {
        return new a().m11348a();
    }
}
