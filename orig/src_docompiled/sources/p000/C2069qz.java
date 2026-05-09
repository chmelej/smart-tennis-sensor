package p000;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p000.InterfaceC2094rx;

/* JADX INFO: renamed from: qz */
/* JADX INFO: compiled from: ImageLoaderConfiguration.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2069qz {

    /* JADX INFO: renamed from: a */
    final Resources f12458a;

    /* JADX INFO: renamed from: b */
    final int f12459b;

    /* JADX INFO: renamed from: c */
    final int f12460c;

    /* JADX INFO: renamed from: d */
    final int f12461d;

    /* JADX INFO: renamed from: e */
    final int f12462e;

    /* JADX INFO: renamed from: f */
    final InterfaceC2103sf f12463f;

    /* JADX INFO: renamed from: g */
    final Executor f12464g;

    /* JADX INFO: renamed from: h */
    final Executor f12465h;

    /* JADX INFO: renamed from: i */
    final boolean f12466i;

    /* JADX INFO: renamed from: j */
    final boolean f12467j;

    /* JADX INFO: renamed from: k */
    final int f12468k;

    /* JADX INFO: renamed from: l */
    final int f12469l;

    /* JADX INFO: renamed from: m */
    final EnumC2081rk f12470m;

    /* JADX INFO: renamed from: n */
    final InterfaceC2061qr f12471n;

    /* JADX INFO: renamed from: o */
    final InterfaceC2052qi f12472o;

    /* JADX INFO: renamed from: p */
    final InterfaceC2094rx f12473p;

    /* JADX INFO: renamed from: q */
    final InterfaceC2088rr f12474q;

    /* JADX INFO: renamed from: r */
    final C2067qx f12475r;

    /* JADX INFO: renamed from: s */
    final InterfaceC2094rx f12476s;

    /* JADX INFO: renamed from: t */
    final InterfaceC2094rx f12477t;

    private C2069qz(a aVar) {
        this.f12458a = aVar.f12480b.getResources();
        this.f12459b = aVar.f12481c;
        this.f12460c = aVar.f12482d;
        this.f12461d = aVar.f12483e;
        this.f12462e = aVar.f12484f;
        this.f12463f = aVar.f12485g;
        this.f12464g = aVar.f12486h;
        this.f12465h = aVar.f12487i;
        this.f12468k = aVar.f12490l;
        this.f12469l = aVar.f12491m;
        this.f12470m = aVar.f12493o;
        this.f12472o = aVar.f12498t;
        this.f12471n = aVar.f12497s;
        this.f12475r = aVar.f12502x;
        this.f12473p = aVar.f12500v;
        this.f12474q = aVar.f12501w;
        this.f12466i = aVar.f12488j;
        this.f12467j = aVar.f12489k;
        this.f12476s = new b(this.f12473p);
        this.f12477t = new c(this.f12473p);
        C2106si.m11524a(aVar.f12503y);
    }

    /* JADX INFO: renamed from: a */
    C2079ri m11367a() {
        DisplayMetrics displayMetrics = this.f12458a.getDisplayMetrics();
        int i = this.f12459b;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.f12460c;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new C2079ri(i, i2);
    }

    /* JADX INFO: renamed from: qz$a */
    /* JADX INFO: compiled from: ImageLoaderConfiguration.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final EnumC2081rk f12479a = EnumC2081rk.FIFO;

        /* JADX INFO: renamed from: b */
        private Context f12480b;

        /* JADX INFO: renamed from: w */
        private InterfaceC2088rr f12501w;

        /* JADX INFO: renamed from: c */
        private int f12481c = 0;

        /* JADX INFO: renamed from: d */
        private int f12482d = 0;

        /* JADX INFO: renamed from: e */
        private int f12483e = 0;

        /* JADX INFO: renamed from: f */
        private int f12484f = 0;

        /* JADX INFO: renamed from: g */
        private InterfaceC2103sf f12485g = null;

        /* JADX INFO: renamed from: h */
        private Executor f12486h = null;

        /* JADX INFO: renamed from: i */
        private Executor f12487i = null;

        /* JADX INFO: renamed from: j */
        private boolean f12488j = false;

        /* JADX INFO: renamed from: k */
        private boolean f12489k = false;

        /* JADX INFO: renamed from: l */
        private int f12490l = 3;

        /* JADX INFO: renamed from: m */
        private int f12491m = 4;

        /* JADX INFO: renamed from: n */
        private boolean f12492n = false;

        /* JADX INFO: renamed from: o */
        private EnumC2081rk f12493o = f12479a;

        /* JADX INFO: renamed from: p */
        private int f12494p = 0;

        /* JADX INFO: renamed from: q */
        private long f12495q = 0;

        /* JADX INFO: renamed from: r */
        private int f12496r = 0;

        /* JADX INFO: renamed from: s */
        private InterfaceC2061qr f12497s = null;

        /* JADX INFO: renamed from: t */
        private InterfaceC2052qi f12498t = null;

        /* JADX INFO: renamed from: u */
        private InterfaceC2059qp f12499u = null;

        /* JADX INFO: renamed from: v */
        private InterfaceC2094rx f12500v = null;

        /* JADX INFO: renamed from: x */
        private C2067qx f12502x = null;

        /* JADX INFO: renamed from: y */
        private boolean f12503y = false;

        public a(Context context) {
            this.f12480b = context.getApplicationContext();
        }

        /* JADX INFO: renamed from: a */
        public a m11388a(int i) {
            if (i <= 0 || i >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.f12497s != null) {
                C2106si.m11526c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.f12494p = (int) (Runtime.getRuntime().maxMemory() * (i / 100.0f));
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m11391b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.f12498t != null) {
                C2106si.m11526c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            this.f12495q = i;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m11392c(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.f12498t != null) {
                C2106si.m11526c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            this.f12496r = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11389a(C2067qx c2067qx) {
            this.f12502x = c2067qx;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C2069qz m11390a() {
            m11370b();
            return new C2069qz(this);
        }

        /* JADX INFO: renamed from: b */
        private void m11370b() {
            if (this.f12486h == null) {
                this.f12486h = C2065qv.m11271a(this.f12490l, this.f12491m, this.f12493o);
            } else {
                this.f12488j = true;
            }
            if (this.f12487i == null) {
                this.f12487i = C2065qv.m11271a(this.f12490l, this.f12491m, this.f12493o);
            } else {
                this.f12489k = true;
            }
            if (this.f12498t == null) {
                if (this.f12499u == null) {
                    this.f12499u = C2065qv.m11278b();
                }
                this.f12498t = C2065qv.m11273a(this.f12480b, this.f12499u, this.f12495q, this.f12496r);
            }
            if (this.f12497s == null) {
                this.f12497s = C2065qv.m11274a(this.f12494p);
            }
            if (this.f12492n) {
                this.f12497s = new C2063qt(this.f12497s, C2107sj.m11529a());
            }
            if (this.f12500v == null) {
                this.f12500v = C2065qv.m11276a(this.f12480b);
            }
            if (this.f12501w == null) {
                this.f12501w = C2065qv.m11275a(this.f12503y);
            }
            if (this.f12502x == null) {
                this.f12502x = C2067qx.m11300t();
            }
        }
    }

    /* JADX INFO: renamed from: qz$b */
    /* JADX INFO: compiled from: ImageLoaderConfiguration.java */
    static class b implements InterfaceC2094rx {

        /* JADX INFO: renamed from: a */
        private final InterfaceC2094rx f12504a;

        public b(InterfaceC2094rx interfaceC2094rx) {
            this.f12504a = interfaceC2094rx;
        }

        @Override // p000.InterfaceC2094rx
        /* JADX INFO: renamed from: a */
        public InputStream mo11393a(String str, Object obj) {
            switch (InterfaceC2094rx.a.m11489a(str)) {
                case HTTP:
                case HTTPS:
                    throw new IllegalStateException();
                default:
                    return this.f12504a.mo11393a(str, obj);
            }
        }
    }

    /* JADX INFO: renamed from: qz$c */
    /* JADX INFO: compiled from: ImageLoaderConfiguration.java */
    static class c implements InterfaceC2094rx {

        /* JADX INFO: renamed from: a */
        private final InterfaceC2094rx f12505a;

        public c(InterfaceC2094rx interfaceC2094rx) {
            this.f12505a = interfaceC2094rx;
        }

        @Override // p000.InterfaceC2094rx
        /* JADX INFO: renamed from: a */
        public InputStream mo11393a(String str, Object obj) {
            InputStream inputStreamMo11393a = this.f12505a.mo11393a(str, obj);
            switch (InterfaceC2094rx.a.m11489a(str)) {
                case HTTP:
                case HTTPS:
                    return new C2077rg(inputStreamMo11393a);
                default:
                    return inputStreamMo11393a;
            }
        }
    }
}
