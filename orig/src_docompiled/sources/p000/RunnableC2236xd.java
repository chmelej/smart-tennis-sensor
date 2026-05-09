package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC2258xz;
import p000.C2251xs;
import p000.C2253xu;
import p000.InterfaceC2243xk;

/* JADX INFO: renamed from: xd */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC2236xd implements Runnable {

    /* JADX INFO: renamed from: t */
    private static final Object f13461t = new Object();

    /* JADX INFO: renamed from: u */
    private static final ThreadLocal<StringBuilder> f13462u = new ThreadLocal<StringBuilder>() { // from class: xd.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };

    /* JADX INFO: renamed from: v */
    private static final AtomicInteger f13463v = new AtomicInteger();

    /* JADX INFO: renamed from: w */
    private static final AbstractC2258xz f13464w = new AbstractC2258xz() { // from class: xd.2
        @Override // p000.AbstractC2258xz
        /* JADX INFO: renamed from: a */
        public boolean mo12224a(C2256xx c2256xx) {
            return true;
        }

        @Override // p000.AbstractC2258xz
        /* JADX INFO: renamed from: a */
        public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + c2256xx);
        }
    };

    /* JADX INFO: renamed from: a */
    final int f13465a = f13463v.incrementAndGet();

    /* JADX INFO: renamed from: b */
    final C2253xu f13466b;

    /* JADX INFO: renamed from: c */
    final C2242xj f13467c;

    /* JADX INFO: renamed from: d */
    final InterfaceC2237xe f13468d;

    /* JADX INFO: renamed from: e */
    final C2261yb f13469e;

    /* JADX INFO: renamed from: f */
    final String f13470f;

    /* JADX INFO: renamed from: g */
    final C2256xx f13471g;

    /* JADX INFO: renamed from: h */
    final int f13472h;

    /* JADX INFO: renamed from: i */
    int f13473i;

    /* JADX INFO: renamed from: j */
    final AbstractC2258xz f13474j;

    /* JADX INFO: renamed from: k */
    AbstractC2234xb f13475k;

    /* JADX INFO: renamed from: l */
    List<AbstractC2234xb> f13476l;

    /* JADX INFO: renamed from: m */
    Bitmap f13477m;

    /* JADX INFO: renamed from: n */
    Future<?> f13478n;

    /* JADX INFO: renamed from: o */
    C2253xu.d f13479o;

    /* JADX INFO: renamed from: p */
    Exception f13480p;

    /* JADX INFO: renamed from: q */
    int f13481q;

    /* JADX INFO: renamed from: r */
    int f13482r;

    /* JADX INFO: renamed from: s */
    C2253xu.e f13483s;

    /* JADX INFO: renamed from: a */
    private static boolean m12230a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    RunnableC2236xd(C2253xu c2253xu, C2242xj c2242xj, InterfaceC2237xe interfaceC2237xe, C2261yb c2261yb, AbstractC2234xb abstractC2234xb, AbstractC2258xz abstractC2258xz) {
        this.f13466b = c2253xu;
        this.f13467c = c2242xj;
        this.f13468d = interfaceC2237xe;
        this.f13469e = c2261yb;
        this.f13475k = abstractC2234xb;
        this.f13470f = abstractC2234xb.m12214e();
        this.f13471g = abstractC2234xb.m12212c();
        this.f13483s = abstractC2234xb.m12220k();
        this.f13472h = abstractC2234xb.m12217h();
        this.f13473i = abstractC2234xb.m12218i();
        this.f13474j = abstractC2258xz;
        this.f13482r = abstractC2258xz.mo12301a();
    }

    /* JADX INFO: renamed from: a */
    static Bitmap m12225a(InputStream inputStream, C2256xx c2256xx) throws IOException {
        C2247xo c2247xo = new C2247xo(inputStream);
        long jM12292a = c2247xo.m12292a(65536);
        BitmapFactory.Options optionsM12353c = AbstractC2258xz.m12353c(c2256xx);
        boolean zM12352a = AbstractC2258xz.m12352a(optionsM12353c);
        boolean zM12401c = C2265yf.m12401c(c2247xo);
        c2247xo.m12293a(jM12292a);
        if (zM12401c) {
            byte[] bArrM12399b = C2265yf.m12399b(c2247xo);
            if (zM12352a) {
                BitmapFactory.decodeByteArray(bArrM12399b, 0, bArrM12399b.length, optionsM12353c);
                AbstractC2258xz.m12351a(c2256xx.f13613h, c2256xx.f13614i, optionsM12353c, c2256xx);
            }
            return BitmapFactory.decodeByteArray(bArrM12399b, 0, bArrM12399b.length, optionsM12353c);
        }
        if (zM12352a) {
            BitmapFactory.decodeStream(c2247xo, null, optionsM12353c);
            AbstractC2258xz.m12351a(c2256xx.f13613h, c2256xx.f13614i, optionsM12353c, c2256xx);
            c2247xo.m12293a(jM12292a);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(c2247xo, null, optionsM12353c);
        if (bitmapDecodeStream == null) {
            throw new IOException("Failed to decode stream.");
        }
        return bitmapDecodeStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        m12229a(this.f13471g);
                        if (this.f13466b.f13566l) {
                            C2265yf.m12393a("Hunter", "executing", C2265yf.m12385a(this));
                        }
                        this.f13477m = m12232a();
                        if (this.f13477m == null) {
                            this.f13467c.m12279c(this);
                        } else {
                            this.f13467c.m12270a(this);
                        }
                    } catch (IOException e) {
                        this.f13480p = e;
                        this.f13467c.m12276b(this);
                    }
                } catch (C2251xs.a e2) {
                    this.f13480p = e2;
                    this.f13467c.m12276b(this);
                } catch (Exception e3) {
                    this.f13480p = e3;
                    this.f13467c.m12279c(this);
                }
            } catch (OutOfMemoryError e4) {
                StringWriter stringWriter = new StringWriter();
                this.f13469e.m12373e().m12374a(new PrintWriter(stringWriter));
                this.f13480p = new RuntimeException(stringWriter.toString(), e4);
                this.f13467c.m12279c(this);
            } catch (InterfaceC2243xk.b e5) {
                if (!e5.f13520a || e5.f13521b != 504) {
                    this.f13480p = e5;
                }
                this.f13467c.m12279c(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    /* JADX INFO: renamed from: a */
    Bitmap m12232a() {
        Bitmap bitmapM12227a;
        if (EnumC2249xq.m12296a(this.f13472h)) {
            bitmapM12227a = this.f13468d.mo12251a(this.f13470f);
            if (bitmapM12227a != null) {
                this.f13469e.m12363a();
                this.f13479o = C2253xu.d.MEMORY;
                if (this.f13466b.f13566l) {
                    C2265yf.m12394a("Hunter", "decoded", this.f13471g.m12330a(), "from cache");
                }
                return bitmapM12227a;
            }
        } else {
            bitmapM12227a = null;
        }
        this.f13471g.f13608c = this.f13482r == 0 ? EnumC2250xr.OFFLINE.f13551d : this.f13473i;
        AbstractC2258xz.a aVarMo12223a = this.f13474j.mo12223a(this.f13471g, this.f13473i);
        if (aVarMo12223a != null) {
            this.f13479o = aVarMo12223a.m12356c();
            this.f13481q = aVarMo12223a.m12357d();
            bitmapM12227a = aVarMo12223a.m12354a();
            if (bitmapM12227a == null) {
                InputStream inputStreamM12355b = aVarMo12223a.m12355b();
                try {
                    Bitmap bitmapM12225a = m12225a(inputStreamM12355b, this.f13471g);
                    C2265yf.m12392a(inputStreamM12355b);
                    bitmapM12227a = bitmapM12225a;
                } catch (Throwable th) {
                    C2265yf.m12392a(inputStreamM12355b);
                    throw th;
                }
            }
        }
        if (bitmapM12227a != null) {
            if (this.f13466b.f13566l) {
                C2265yf.m12393a("Hunter", "decoded", this.f13471g.m12330a());
            }
            this.f13469e.m12365a(bitmapM12227a);
            if (this.f13471g.m12334e() || this.f13481q != 0) {
                synchronized (f13461t) {
                    if (this.f13471g.m12335f() || this.f13481q != 0) {
                        bitmapM12227a = m12227a(this.f13471g, bitmapM12227a, this.f13481q);
                        if (this.f13466b.f13566l) {
                            C2265yf.m12393a("Hunter", "transformed", this.f13471g.m12330a());
                        }
                    }
                    if (this.f13471g.m12336g()) {
                        bitmapM12227a = m12226a(this.f13471g.f13612g, bitmapM12227a);
                        if (this.f13466b.f13566l) {
                            C2265yf.m12394a("Hunter", "transformed", this.f13471g.m12330a(), "from custom transformations");
                        }
                    }
                }
                if (bitmapM12227a != null) {
                    this.f13469e.m12369b(bitmapM12227a);
                }
            }
        }
        return bitmapM12227a;
    }

    /* JADX INFO: renamed from: a */
    void m12233a(AbstractC2234xb abstractC2234xb) {
        boolean z = this.f13466b.f13566l;
        C2256xx c2256xx = abstractC2234xb.f13447b;
        if (this.f13475k == null) {
            this.f13475k = abstractC2234xb;
            if (z) {
                if (this.f13476l == null || this.f13476l.isEmpty()) {
                    C2265yf.m12394a("Hunter", "joined", c2256xx.m12330a(), "to empty hunter");
                    return;
                } else {
                    C2265yf.m12394a("Hunter", "joined", c2256xx.m12330a(), C2265yf.m12386a(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.f13476l == null) {
            this.f13476l = new ArrayList(3);
        }
        this.f13476l.add(abstractC2234xb);
        if (z) {
            C2265yf.m12394a("Hunter", "joined", c2256xx.m12330a(), C2265yf.m12386a(this, "to "));
        }
        C2253xu.e eVarM12220k = abstractC2234xb.m12220k();
        if (eVarM12220k.ordinal() > this.f13483s.ordinal()) {
            this.f13483s = eVarM12220k;
        }
    }

    /* JADX INFO: renamed from: b */
    void m12235b(AbstractC2234xb abstractC2234xb) {
        boolean zRemove;
        if (this.f13475k == abstractC2234xb) {
            this.f13475k = null;
            zRemove = true;
        } else {
            zRemove = this.f13476l != null ? this.f13476l.remove(abstractC2234xb) : false;
        }
        if (zRemove && abstractC2234xb.m12220k() == this.f13483s) {
            this.f13483s = m12231o();
        }
        if (this.f13466b.f13566l) {
            C2265yf.m12394a("Hunter", "removed", abstractC2234xb.f13447b.m12330a(), C2265yf.m12386a(this, "from "));
        }
    }

    /* JADX INFO: renamed from: o */
    private C2253xu.e m12231o() {
        C2253xu.e eVarM12220k = C2253xu.e.LOW;
        boolean z = true;
        boolean z2 = (this.f13476l == null || this.f13476l.isEmpty()) ? false : true;
        if (this.f13475k == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVarM12220k;
        }
        if (this.f13475k != null) {
            eVarM12220k = this.f13475k.m12220k();
        }
        if (z2) {
            int size = this.f13476l.size();
            for (int i = 0; i < size; i++) {
                C2253xu.e eVarM12220k2 = this.f13476l.get(i).m12220k();
                if (eVarM12220k2.ordinal() > eVarM12220k.ordinal()) {
                    eVarM12220k = eVarM12220k2;
                }
            }
        }
        return eVarM12220k;
    }

    /* JADX INFO: renamed from: b */
    boolean m12236b() {
        if (this.f13475k == null) {
            return (this.f13476l == null || this.f13476l.isEmpty()) && this.f13478n != null && this.f13478n.cancel(false);
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    boolean m12237c() {
        return this.f13478n != null && this.f13478n.isCancelled();
    }

    /* JADX INFO: renamed from: a */
    boolean m12234a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f13482r > 0)) {
            return false;
        }
        this.f13482r--;
        return this.f13474j.mo12302a(z, networkInfo);
    }

    /* JADX INFO: renamed from: d */
    boolean m12238d() {
        return this.f13474j.mo12303b();
    }

    /* JADX INFO: renamed from: e */
    Bitmap m12239e() {
        return this.f13477m;
    }

    /* JADX INFO: renamed from: f */
    String m12240f() {
        return this.f13470f;
    }

    /* JADX INFO: renamed from: g */
    int m12241g() {
        return this.f13472h;
    }

    /* JADX INFO: renamed from: h */
    C2256xx m12242h() {
        return this.f13471g;
    }

    /* JADX INFO: renamed from: i */
    AbstractC2234xb m12243i() {
        return this.f13475k;
    }

    /* JADX INFO: renamed from: j */
    C2253xu m12244j() {
        return this.f13466b;
    }

    /* JADX INFO: renamed from: k */
    List<AbstractC2234xb> m12245k() {
        return this.f13476l;
    }

    /* JADX INFO: renamed from: l */
    Exception m12246l() {
        return this.f13480p;
    }

    /* JADX INFO: renamed from: m */
    C2253xu.d m12247m() {
        return this.f13479o;
    }

    /* JADX INFO: renamed from: n */
    C2253xu.e m12248n() {
        return this.f13483s;
    }

    /* JADX INFO: renamed from: a */
    static void m12229a(C2256xx c2256xx) {
        String strM12332c = c2256xx.m12332c();
        StringBuilder sb = f13462u.get();
        sb.ensureCapacity("Picasso-".length() + strM12332c.length());
        sb.replace("Picasso-".length(), sb.length(), strM12332c);
        Thread.currentThread().setName(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    static RunnableC2236xd m12228a(C2253xu c2253xu, C2242xj c2242xj, InterfaceC2237xe interfaceC2237xe, C2261yb c2261yb, AbstractC2234xb abstractC2234xb) {
        C2256xx c2256xxM12212c = abstractC2234xb.m12212c();
        List<AbstractC2258xz> listM12309a = c2253xu.m12309a();
        int size = listM12309a.size();
        for (int i = 0; i < size; i++) {
            AbstractC2258xz abstractC2258xz = listM12309a.get(i);
            if (abstractC2258xz.mo12224a(c2256xxM12212c)) {
                return new RunnableC2236xd(c2253xu, c2242xj, interfaceC2237xe, c2261yb, abstractC2234xb, abstractC2258xz);
            }
        }
        return new RunnableC2236xd(c2253xu, c2242xj, interfaceC2237xe, c2261yb, abstractC2234xb, f13464w);
    }

    /* JADX INFO: renamed from: a */
    static Bitmap m12226a(List<InterfaceC2263yd> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final InterfaceC2263yd interfaceC2263yd = list.get(i);
            try {
                Bitmap bitmapMo10439a = interfaceC2263yd.mo10439a(bitmap);
                if (bitmapMo10439a == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(interfaceC2263yd.mo10440a());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<InterfaceC2263yd> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().mo10440a());
                        sb.append('\n');
                    }
                    C2253xu.f13555a.post(new Runnable() { // from class: xd.4
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                }
                if (bitmapMo10439a == bitmap && bitmap.isRecycled()) {
                    C2253xu.f13555a.post(new Runnable() { // from class: xd.5
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + interfaceC2263yd.mo10440a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                }
                if (bitmapMo10439a != bitmap && !bitmap.isRecycled()) {
                    C2253xu.f13555a.post(new Runnable() { // from class: xd.6
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + interfaceC2263yd.mo10440a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
                i++;
                bitmap = bitmapMo10439a;
            } catch (RuntimeException e) {
                C2253xu.f13555a.post(new Runnable() { // from class: xd.3
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("Transformation " + interfaceC2263yd.mo10440a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX INFO: renamed from: a */
    static Bitmap m12227a(C2256xx c2256xx, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i5;
        int i6;
        int i7;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = c2256xx.f13617l;
        Matrix matrix = new Matrix();
        int i8 = 0;
        if (c2256xx.m12335f()) {
            int i9 = c2256xx.f13613h;
            int i10 = c2256xx.f13614i;
            float f6 = c2256xx.f13618m;
            if (f6 != 0.0f) {
                if (c2256xx.f13621p) {
                    matrix.setRotate(f6, c2256xx.f13619n, c2256xx.f13620o);
                } else {
                    matrix.setRotate(f6);
                }
            }
            if (c2256xx.f13615j) {
                float f7 = i9;
                float f8 = f7 / width;
                float f9 = i10;
                float f10 = f9 / height;
                if (f8 > f10) {
                    int iCeil = (int) Math.ceil(r10 * (f10 / f8));
                    i7 = (height - iCeil) / 2;
                    f10 = f9 / iCeil;
                    i5 = iCeil;
                    f5 = f8;
                    i6 = width;
                } else {
                    int iCeil2 = (int) Math.ceil(r6 * (f8 / f10));
                    f5 = f7 / iCeil2;
                    i5 = height;
                    i8 = (width - iCeil2) / 2;
                    i6 = iCeil2;
                    i7 = 0;
                }
                if (m12230a(z, width, height, i9, i10)) {
                    matrix.preScale(f5, f10);
                }
                i4 = i7;
                i2 = i6;
                i3 = i5;
            } else {
                if (c2256xx.f13616k) {
                    float f11 = i9 / width;
                    float f12 = i10 / height;
                    if (f11 >= f12) {
                        f11 = f12;
                    }
                    if (m12230a(z, width, height, i9, i10)) {
                        matrix.preScale(f11, f11);
                    }
                } else if ((i9 != 0 || i10 != 0) && (i9 != width || i10 != height)) {
                    if (i9 != 0) {
                        f = i9;
                        f2 = width;
                    } else {
                        f = i10;
                        f2 = height;
                    }
                    float f13 = f / f2;
                    if (i10 != 0) {
                        f3 = i10;
                        f4 = height;
                    } else {
                        f3 = i9;
                        f4 = width;
                    }
                    float f14 = f3 / f4;
                    if (m12230a(z, width, height, i9, i10)) {
                        matrix.preScale(f13, f14);
                    }
                }
                i2 = width;
                i3 = height;
                i4 = 0;
            }
        } else {
            i2 = width;
            i3 = height;
            i4 = 0;
        }
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i8, i4, i2, i3, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
