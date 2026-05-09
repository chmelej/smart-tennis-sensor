package p000;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p000.C2253xu;

/* JADX INFO: renamed from: xx */
/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2256xx {

    /* JADX INFO: renamed from: s */
    private static final long f13605s = TimeUnit.SECONDS.toNanos(5);

    /* JADX INFO: renamed from: a */
    int f13606a;

    /* JADX INFO: renamed from: b */
    long f13607b;

    /* JADX INFO: renamed from: c */
    int f13608c;

    /* JADX INFO: renamed from: d */
    public final Uri f13609d;

    /* JADX INFO: renamed from: e */
    public final int f13610e;

    /* JADX INFO: renamed from: f */
    public final String f13611f;

    /* JADX INFO: renamed from: g */
    public final List<InterfaceC2263yd> f13612g;

    /* JADX INFO: renamed from: h */
    public final int f13613h;

    /* JADX INFO: renamed from: i */
    public final int f13614i;

    /* JADX INFO: renamed from: j */
    public final boolean f13615j;

    /* JADX INFO: renamed from: k */
    public final boolean f13616k;

    /* JADX INFO: renamed from: l */
    public final boolean f13617l;

    /* JADX INFO: renamed from: m */
    public final float f13618m;

    /* JADX INFO: renamed from: n */
    public final float f13619n;

    /* JADX INFO: renamed from: o */
    public final float f13620o;

    /* JADX INFO: renamed from: p */
    public final boolean f13621p;

    /* JADX INFO: renamed from: q */
    public final Bitmap.Config f13622q;

    /* JADX INFO: renamed from: r */
    public final C2253xu.e f13623r;

    private C2256xx(Uri uri, int i, String str, List<InterfaceC2263yd> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, C2253xu.e eVar) {
        this.f13609d = uri;
        this.f13610e = i;
        this.f13611f = str;
        if (list == null) {
            this.f13612g = null;
        } else {
            this.f13612g = Collections.unmodifiableList(list);
        }
        this.f13613h = i2;
        this.f13614i = i3;
        this.f13615j = z;
        this.f13616k = z2;
        this.f13617l = z3;
        this.f13618m = f;
        this.f13619n = f2;
        this.f13620o = f3;
        this.f13621p = z4;
        this.f13622q = config;
        this.f13623r = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.f13610e > 0) {
            sb.append(this.f13610e);
        } else {
            sb.append(this.f13609d);
        }
        if (this.f13612g != null && !this.f13612g.isEmpty()) {
            for (InterfaceC2263yd interfaceC2263yd : this.f13612g) {
                sb.append(' ');
                sb.append(interfaceC2263yd.mo10440a());
            }
        }
        if (this.f13611f != null) {
            sb.append(" stableKey(");
            sb.append(this.f13611f);
            sb.append(')');
        }
        if (this.f13613h > 0) {
            sb.append(" resize(");
            sb.append(this.f13613h);
            sb.append(',');
            sb.append(this.f13614i);
            sb.append(')');
        }
        if (this.f13615j) {
            sb.append(" centerCrop");
        }
        if (this.f13616k) {
            sb.append(" centerInside");
        }
        if (this.f13618m != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f13618m);
            if (this.f13621p) {
                sb.append(" @ ");
                sb.append(this.f13619n);
                sb.append(',');
                sb.append(this.f13620o);
            }
            sb.append(')');
        }
        if (this.f13622q != null) {
            sb.append(' ');
            sb.append(this.f13622q);
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    String m12330a() {
        long jNanoTime = System.nanoTime() - this.f13607b;
        if (jNanoTime > f13605s) {
            return m12331b() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return m12331b() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    /* JADX INFO: renamed from: b */
    String m12331b() {
        return "[R" + this.f13606a + ']';
    }

    /* JADX INFO: renamed from: c */
    String m12332c() {
        if (this.f13609d != null) {
            return String.valueOf(this.f13609d.getPath());
        }
        return Integer.toHexString(this.f13610e);
    }

    /* JADX INFO: renamed from: d */
    public boolean m12333d() {
        return (this.f13613h == 0 && this.f13614i == 0) ? false : true;
    }

    /* JADX INFO: renamed from: e */
    boolean m12334e() {
        return m12335f() || m12336g();
    }

    /* JADX INFO: renamed from: f */
    boolean m12335f() {
        return m12333d() || this.f13618m != 0.0f;
    }

    /* JADX INFO: renamed from: g */
    boolean m12336g() {
        return this.f13612g != null;
    }

    /* JADX INFO: renamed from: xx$a */
    /* JADX INFO: compiled from: Request.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private Uri f13624a;

        /* JADX INFO: renamed from: b */
        private int f13625b;

        /* JADX INFO: renamed from: c */
        private String f13626c;

        /* JADX INFO: renamed from: d */
        private int f13627d;

        /* JADX INFO: renamed from: e */
        private int f13628e;

        /* JADX INFO: renamed from: f */
        private boolean f13629f;

        /* JADX INFO: renamed from: g */
        private boolean f13630g;

        /* JADX INFO: renamed from: h */
        private boolean f13631h;

        /* JADX INFO: renamed from: i */
        private float f13632i;

        /* JADX INFO: renamed from: j */
        private float f13633j;

        /* JADX INFO: renamed from: k */
        private float f13634k;

        /* JADX INFO: renamed from: l */
        private boolean f13635l;

        /* JADX INFO: renamed from: m */
        private List<InterfaceC2263yd> f13636m;

        /* JADX INFO: renamed from: n */
        private Bitmap.Config f13637n;

        /* JADX INFO: renamed from: o */
        private C2253xu.e f13638o;

        a(Uri uri, int i, Bitmap.Config config) {
            this.f13624a = uri;
            this.f13625b = i;
            this.f13637n = config;
        }

        /* JADX INFO: renamed from: a */
        boolean m12339a() {
            return (this.f13624a == null && this.f13625b == 0) ? false : true;
        }

        /* JADX INFO: renamed from: b */
        boolean m12340b() {
            return (this.f13627d == 0 && this.f13628e == 0) ? false : true;
        }

        /* JADX INFO: renamed from: a */
        public a m12337a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f13627d = i;
            this.f13628e = i2;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m12338a(InterfaceC2263yd interfaceC2263yd) {
            if (interfaceC2263yd == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (interfaceC2263yd.mo10440a() == null) {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            if (this.f13636m == null) {
                this.f13636m = new ArrayList(2);
            }
            this.f13636m.add(interfaceC2263yd);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C2256xx m12341c() {
            if (this.f13630g && this.f13629f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f13629f && this.f13627d == 0 && this.f13628e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.f13630g && this.f13627d == 0 && this.f13628e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.f13638o == null) {
                this.f13638o = C2253xu.e.NORMAL;
            }
            return new C2256xx(this.f13624a, this.f13625b, this.f13626c, this.f13636m, this.f13627d, this.f13628e, this.f13629f, this.f13630g, this.f13631h, this.f13632i, this.f13633j, this.f13634k, this.f13635l, this.f13637n, this.f13638o);
        }
    }
}
