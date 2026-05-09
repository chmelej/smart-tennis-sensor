package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import p000.C2067qx;

/* JADX INFO: renamed from: qy */
/* JADX INFO: compiled from: ImageLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2068qy {

    /* JADX INFO: renamed from: a */
    public static final String f12452a = "qy";

    /* JADX INFO: renamed from: e */
    private static volatile C2068qy f12453e;

    /* JADX INFO: renamed from: b */
    private C2069qz f12454b;

    /* JADX INFO: renamed from: c */
    private C2071ra f12455c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC2100sc f12456d = new C2102se();

    /* JADX INFO: renamed from: a */
    public static C2068qy m11356a() {
        if (f12453e == null) {
            synchronized (C2068qy.class) {
                if (f12453e == null) {
                    f12453e = new C2068qy();
                }
            }
        }
        return f12453e;
    }

    protected C2068qy() {
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11364a(C2069qz c2069qz) {
        try {
            if (c2069qz == null) {
                throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
            }
            if (this.f12454b == null) {
                C2106si.m11522a("Initialize ImageLoader with configuration", new Object[0]);
                this.f12455c = new C2071ra(c2069qz);
                this.f12454b = c2069qz;
            } else {
                C2106si.m11526c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11363a(String str, InterfaceC2095ry interfaceC2095ry, C2067qx c2067qx, InterfaceC2100sc interfaceC2100sc, InterfaceC2101sd interfaceC2101sd) {
        m11357b();
        if (interfaceC2095ry == null) {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        if (interfaceC2100sc == null) {
            interfaceC2100sc = this.f12456d;
        }
        InterfaceC2100sc interfaceC2100sc2 = interfaceC2100sc;
        if (c2067qx == null) {
            c2067qx = this.f12454b.f12475r;
        }
        if (TextUtils.isEmpty(str)) {
            this.f12455c.m11407b(interfaceC2095ry);
            interfaceC2100sc2.mo11507a(str, interfaceC2095ry.mo11498d());
            if (c2067qx.m11304b()) {
                interfaceC2095ry.mo11495a(c2067qx.m11303b(this.f12454b.f12458a));
            } else {
                interfaceC2095ry.mo11495a((Drawable) null);
            }
            interfaceC2100sc2.mo11366a(str, interfaceC2095ry.mo11498d(), (Bitmap) null);
            return;
        }
        C2079ri c2079riM11515a = C2104sg.m11515a(interfaceC2095ry, this.f12454b.m11367a());
        String strM11528a = C2107sj.m11528a(str, c2079riM11515a);
        this.f12455c.m11405a(interfaceC2095ry, strM11528a);
        interfaceC2100sc2.mo11507a(str, interfaceC2095ry.mo11498d());
        Bitmap bitmapA = this.f12454b.f12471n.mo11264a(strM11528a);
        if (bitmapA != null && !bitmapA.isRecycled()) {
            C2106si.m11522a("Load image from memory cache [%s]", strM11528a);
            if (c2067qx.m11308e()) {
                RunnableC2074rd runnableC2074rd = new RunnableC2074rd(this.f12455c, bitmapA, new C2072rb(str, interfaceC2095ry, c2079riM11515a, strM11528a, c2067qx, interfaceC2100sc2, interfaceC2101sd, this.f12455c.m11401a(str)), m11355a(c2067qx));
                if (c2067qx.m11322s()) {
                    runnableC2074rd.run();
                    return;
                } else {
                    this.f12455c.m11404a(runnableC2074rd);
                    return;
                }
            }
            c2067qx.m11320q().mo11479a(bitmapA, interfaceC2095ry, EnumC2080rj.MEMORY_CACHE);
            interfaceC2100sc2.mo11366a(str, interfaceC2095ry.mo11498d(), bitmapA);
            return;
        }
        if (c2067qx.m11302a()) {
            interfaceC2095ry.mo11495a(c2067qx.m11301a(this.f12454b.f12458a));
        } else if (c2067qx.m11310g()) {
            interfaceC2095ry.mo11495a((Drawable) null);
        }
        RunnableC2073rc runnableC2073rc = new RunnableC2073rc(this.f12455c, new C2072rb(str, interfaceC2095ry, c2079riM11515a, strM11528a, c2067qx, interfaceC2100sc2, interfaceC2101sd, this.f12455c.m11401a(str)), m11355a(c2067qx));
        if (c2067qx.m11322s()) {
            runnableC2073rc.run();
        } else {
            this.f12455c.m11403a(runnableC2073rc);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11360a(String str, ImageView imageView) {
        m11363a(str, new C2096rz(imageView), (C2067qx) null, (InterfaceC2100sc) null, (InterfaceC2101sd) null);
    }

    /* JADX INFO: renamed from: a */
    public void m11361a(String str, C2079ri c2079ri, C2067qx c2067qx, InterfaceC2100sc interfaceC2100sc) {
        m11362a(str, c2079ri, c2067qx, interfaceC2100sc, (InterfaceC2101sd) null);
    }

    /* JADX INFO: renamed from: a */
    public void m11362a(String str, C2079ri c2079ri, C2067qx c2067qx, InterfaceC2100sc interfaceC2100sc, InterfaceC2101sd interfaceC2101sd) {
        m11357b();
        if (c2079ri == null) {
            c2079ri = this.f12454b.m11367a();
        }
        if (c2067qx == null) {
            c2067qx = this.f12454b.f12475r;
        }
        m11363a(str, new C2098sa(str, c2079ri, EnumC2082rl.CROP), c2067qx, interfaceC2100sc, interfaceC2101sd);
    }

    /* JADX INFO: renamed from: a */
    public Bitmap m11358a(String str) {
        return m11359a(str, null, null);
    }

    /* JADX INFO: renamed from: a */
    public Bitmap m11359a(String str, C2079ri c2079ri, C2067qx c2067qx) {
        if (c2067qx == null) {
            c2067qx = this.f12454b.f12475r;
        }
        C2067qx c2067qxM11348a = new C2067qx.a().m11344a(c2067qx).m11354e(true).m11348a();
        a aVar = new a();
        m11361a(str, c2079ri, c2067qxM11348a, aVar);
        return aVar.m11365a();
    }

    /* JADX INFO: renamed from: b */
    private void m11357b() {
        if (this.f12454b == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    /* JADX INFO: renamed from: a */
    private static Handler m11355a(C2067qx c2067qx) {
        Handler handlerM11321r = c2067qx.m11321r();
        if (c2067qx.m11322s()) {
            return null;
        }
        return (handlerM11321r == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handlerM11321r;
    }

    /* JADX INFO: renamed from: qy$a */
    /* JADX INFO: compiled from: ImageLoader.java */
    static class a extends C2102se {

        /* JADX INFO: renamed from: a */
        private Bitmap f12457a;

        private a() {
        }

        @Override // p000.C2102se, p000.InterfaceC2100sc
        /* JADX INFO: renamed from: a */
        public void mo11366a(String str, View view, Bitmap bitmap) {
            this.f12457a = bitmap;
        }

        /* JADX INFO: renamed from: a */
        public Bitmap m11365a() {
            return this.f12457a;
        }
    }
}
