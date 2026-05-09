package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C2253xu;
import p000.C2256xx;

/* JADX INFO: renamed from: xy */
/* JADX INFO: compiled from: RequestCreator.java */
/* JADX INFO: loaded from: classes.dex */
public class C2257xy {

    /* JADX INFO: renamed from: a */
    private static final AtomicInteger f13639a = new AtomicInteger();

    /* JADX INFO: renamed from: b */
    private final C2253xu f13640b;

    /* JADX INFO: renamed from: c */
    private final C2256xx.a f13641c;

    /* JADX INFO: renamed from: d */
    private boolean f13642d;

    /* JADX INFO: renamed from: e */
    private boolean f13643e;

    /* JADX INFO: renamed from: f */
    private boolean f13644f;

    /* JADX INFO: renamed from: g */
    private int f13645g;

    /* JADX INFO: renamed from: h */
    private int f13646h;

    /* JADX INFO: renamed from: i */
    private int f13647i;

    /* JADX INFO: renamed from: j */
    private int f13648j;

    /* JADX INFO: renamed from: k */
    private Drawable f13649k;

    /* JADX INFO: renamed from: l */
    private Drawable f13650l;

    /* JADX INFO: renamed from: m */
    private Object f13651m;

    C2257xy(C2253xu c2253xu, Uri uri, int i) {
        this.f13644f = true;
        if (c2253xu.f13567m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f13640b = c2253xu;
        this.f13641c = new C2256xx.a(uri, i, c2253xu.f13564j);
    }

    C2257xy() {
        this.f13644f = true;
        this.f13640b = null;
        this.f13641c = new C2256xx.a(null, 0, null);
    }

    /* JADX INFO: renamed from: a */
    public C2257xy m12345a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (this.f13650l != null) {
            throw new IllegalStateException("Error image already set.");
        }
        this.f13646h = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    C2257xy m12344a() {
        this.f13643e = false;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2257xy m12346a(int i, int i2) {
        this.f13641c.m12337a(i, i2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C2257xy m12347a(InterfaceC2263yd interfaceC2263yd) {
        this.f13641c.m12338a(interfaceC2263yd);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m12348a(ImageView imageView) {
        m12349a(imageView, (InterfaceC2238xf) null);
    }

    /* JADX INFO: renamed from: a */
    public void m12349a(ImageView imageView, InterfaceC2238xf interfaceC2238xf) {
        Bitmap bitmapM12317b;
        long jNanoTime = System.nanoTime();
        C2265yf.m12390a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.f13641c.m12339a()) {
            this.f13640b.m12313a(imageView);
            if (this.f13644f) {
                C2254xv.m12326a(imageView, m12343b());
                return;
            }
            return;
        }
        if (this.f13643e) {
            if (this.f13641c.m12340b()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.f13644f) {
                    C2254xv.m12326a(imageView, m12343b());
                }
                this.f13640b.m12314a(imageView, new ViewTreeObserverOnPreDrawListenerC2241xi(this, imageView, interfaceC2238xf));
                return;
            }
            this.f13641c.m12337a(width, height);
        }
        C2256xx c2256xxM12342a = m12342a(jNanoTime);
        String strM12387a = C2265yf.m12387a(c2256xxM12342a);
        if (EnumC2249xq.m12296a(this.f13647i) && (bitmapM12317b = this.f13640b.m12317b(strM12387a)) != null) {
            this.f13640b.m12313a(imageView);
            C2254xv.m12325a(imageView, this.f13640b.f13557c, bitmapM12317b, C2253xu.d.MEMORY, this.f13642d, this.f13640b.f13565k);
            if (this.f13640b.f13566l) {
                C2265yf.m12394a("Main", "completed", c2256xxM12342a.m12331b(), "from " + C2253xu.d.MEMORY);
            }
            if (interfaceC2238xf != null) {
                interfaceC2238xf.m12254a();
                return;
            }
            return;
        }
        if (this.f13644f) {
            C2254xv.m12326a(imageView, m12343b());
        }
        this.f13640b.m12315a((AbstractC2234xb) new C2245xm(this.f13640b, imageView, c2256xxM12342a, this.f13647i, this.f13648j, this.f13646h, this.f13650l, strM12387a, this.f13651m, interfaceC2238xf, this.f13642d));
    }

    /* JADX INFO: renamed from: b */
    private Drawable m12343b() {
        if (this.f13645g != 0) {
            return this.f13640b.f13557c.getResources().getDrawable(this.f13645g);
        }
        return this.f13649k;
    }

    /* JADX INFO: renamed from: a */
    private C2256xx m12342a(long j) {
        int andIncrement = f13639a.getAndIncrement();
        C2256xx c2256xxM12341c = this.f13641c.m12341c();
        c2256xxM12341c.f13606a = andIncrement;
        c2256xxM12341c.f13607b = j;
        boolean z = this.f13640b.f13566l;
        if (z) {
            C2265yf.m12394a("Main", "created", c2256xxM12341c.m12331b(), c2256xxM12341c.toString());
        }
        C2256xx c2256xxM12310a = this.f13640b.m12310a(c2256xxM12341c);
        if (c2256xxM12310a != c2256xxM12341c) {
            c2256xxM12310a.f13606a = andIncrement;
            c2256xxM12310a.f13607b = j;
            if (z) {
                C2265yf.m12394a("Main", "changed", c2256xxM12310a.m12330a(), "into " + c2256xxM12310a);
            }
        }
        return c2256xxM12310a;
    }
}
