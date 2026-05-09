package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p002v8.renderscript.RenderScript;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p000.C1778hp;
import p000.C1787hy;

/* JADX INFO: renamed from: hn */
/* JADX INFO: compiled from: Allocation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1776hn extends C1777ho {

    /* JADX INFO: renamed from: q */
    static BitmapFactory.Options f10204q = new BitmapFactory.Options();

    /* JADX INFO: renamed from: a */
    C1787hy f10205a;

    /* JADX INFO: renamed from: b */
    Bitmap f10206b;

    /* JADX INFO: renamed from: c */
    int f10207c;

    /* JADX INFO: renamed from: d */
    int f10208d;

    /* JADX INFO: renamed from: e */
    ByteBuffer f10209e;

    /* JADX INFO: renamed from: f */
    long f10210f;

    /* JADX INFO: renamed from: g */
    boolean f10211g;

    /* JADX INFO: renamed from: h */
    boolean f10212h;

    /* JADX INFO: renamed from: i */
    boolean f10213i;

    /* JADX INFO: renamed from: j */
    C1787hy.b f10214j;

    /* JADX INFO: renamed from: k */
    int f10215k;

    /* JADX INFO: renamed from: l */
    int f10216l;

    /* JADX INFO: renamed from: m */
    int f10217m;

    /* JADX INFO: renamed from: n */
    int f10218n;

    /* JADX INFO: renamed from: o */
    long f10219o;

    /* JADX INFO: renamed from: p */
    boolean f10220p;

    /* JADX INFO: renamed from: hn$a */
    /* JADX INFO: compiled from: Allocation.java */
    public enum a {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);


        /* JADX INFO: renamed from: d */
        int f10226d;

        a(int i) {
            this.f10226d = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9693a(long j) {
        this.f10219o = j;
    }

    /* JADX INFO: renamed from: a */
    private void m9687a(C1787hy c1787hy) {
        this.f10215k = c1787hy.m9725e();
        this.f10216l = c1787hy.m9726f();
        this.f10217m = c1787hy.m9727g();
        this.f10218n = this.f10215k;
        if (this.f10216l > 1) {
            this.f10218n *= this.f10216l;
        }
        if (this.f10217m > 1) {
            this.f10218n *= this.f10217m;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9689b(Bitmap bitmap) {
        this.f10206b = bitmap;
    }

    C1776hn(long j, RenderScript renderScript, C1787hy c1787hy, int i) {
        super(j, renderScript);
        this.f10209e = null;
        this.f10210f = 0L;
        this.f10211g = true;
        this.f10212h = true;
        this.f10213i = false;
        this.f10214j = C1787hy.b.POSITIVE_X;
        if ((i & (-228)) != 0) {
            throw new C1781hs("Unknown usage specified.");
        }
        if ((i & 32) != 0) {
            this.f10212h = false;
            if ((i & (-36)) != 0) {
                throw new C1781hs("Invalid usage combination.");
            }
        }
        this.f10205a = c1787hy;
        this.f10207c = i;
        this.f10219o = 0L;
        this.f10220p = false;
        if (c1787hy != null) {
            this.f10208d = this.f10205a.m9730j() * this.f10205a.m9724a().m9710a();
            m9687a(c1787hy);
        }
        if (RenderScript.f4107b) {
            try {
                RenderScript.f4109d.invoke(RenderScript.f4108c, Integer.valueOf(this.f10208d));
            } catch (Exception e) {
                Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + e);
                throw new C1783hu("Couldn't invoke registerNativeAllocation:" + e);
            }
        }
    }

    @Override // p000.C1777ho
    protected void finalize() throws Throwable {
        if (RenderScript.f4107b) {
            RenderScript.f4110e.invoke(RenderScript.f4108c, Integer.valueOf(this.f10208d));
        }
        super.finalize();
    }

    /* JADX INFO: renamed from: a */
    public C1787hy m9692a() {
        return this.f10205a;
    }

    /* JADX INFO: renamed from: c */
    private void m9690c(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            throw new C1781hs("Bitmap has an unsupported format for this operation");
        }
        switch (AnonymousClass1.f10221a[config.ordinal()]) {
            case 1:
                if (this.f10205a.m9724a().f10232c != C1778hp.a.PIXEL_A) {
                    throw new C1781hs("Allocation kind is " + this.f10205a.m9724a().f10232c + ", type " + this.f10205a.m9724a().f10231b + " of " + this.f10205a.m9724a().m9710a() + " bytes, passed bitmap was " + config);
                }
                return;
            case 2:
                if (this.f10205a.m9724a().f10232c == C1778hp.a.PIXEL_RGBA && this.f10205a.m9724a().m9710a() == 4) {
                    return;
                }
                throw new C1781hs("Allocation kind is " + this.f10205a.m9724a().f10232c + ", type " + this.f10205a.m9724a().f10231b + " of " + this.f10205a.m9724a().m9710a() + " bytes, passed bitmap was " + config);
            case 3:
                if (this.f10205a.m9724a().f10232c == C1778hp.a.PIXEL_RGB && this.f10205a.m9724a().m9710a() == 2) {
                    return;
                }
                throw new C1781hs("Allocation kind is " + this.f10205a.m9724a().f10232c + ", type " + this.f10205a.m9724a().f10231b + " of " + this.f10205a.m9724a().m9710a() + " bytes, passed bitmap was " + config);
            case 4:
                if (this.f10205a.m9724a().f10232c == C1778hp.a.PIXEL_RGBA && this.f10205a.m9724a().m9710a() == 2) {
                    return;
                }
                throw new C1781hs("Allocation kind is " + this.f10205a.m9724a().f10232c + ", type " + this.f10205a.m9724a().f10231b + " of " + this.f10205a.m9724a().m9710a() + " bytes, passed bitmap was " + config);
            default:
                return;
        }
    }

    /* JADX INFO: renamed from: hn$1, reason: invalid class name */
    /* JADX INFO: compiled from: Allocation.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f10221a = new int[Bitmap.Config.values().length];

        static {
            try {
                f10221a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10221a[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10221a[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10221a[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m9691d(Bitmap bitmap) {
        if (this.f10215k != bitmap.getWidth() || this.f10216l != bitmap.getHeight()) {
            throw new C1781hs("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9694a(Bitmap bitmap) {
        this.f10229r.m4413f();
        m9690c(bitmap);
        m9691d(bitmap);
        this.f10229r.m4402a(m9698a(this.f10229r), bitmap);
    }

    static {
        f10204q.inScaled = false;
    }

    /* JADX INFO: renamed from: a */
    public static C1776hn m9684a(RenderScript renderScript, C1787hy c1787hy, a aVar, int i) {
        renderScript.m4413f();
        if (c1787hy.m9698a(renderScript) == 0) {
            throw new C1782ht("Bad Type");
        }
        if (!renderScript.m4414g() && (i & 32) != 0) {
            throw new C1783hu("USAGE_IO not supported, Allocation creation failed.");
        }
        long jM4394a = renderScript.m4394a(c1787hy.m9698a(renderScript), aVar.f10226d, i, 0L);
        if (jM4394a == 0) {
            throw new C1783hu("Allocation creation failed.");
        }
        return new C1776hn(jM4394a, renderScript, c1787hy, i);
    }

    /* JADX INFO: renamed from: a */
    public static C1776hn m9683a(RenderScript renderScript, C1787hy c1787hy) {
        return m9684a(renderScript, c1787hy, a.MIPMAP_NONE, 1);
    }

    /* JADX INFO: renamed from: a */
    static C1778hp m9685a(RenderScript renderScript, Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.ALPHA_8) {
            return C1778hp.m9705c(renderScript);
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return C1778hp.m9707e(renderScript);
        }
        if (config == Bitmap.Config.ARGB_8888) {
            return C1778hp.m9708f(renderScript);
        }
        if (config == Bitmap.Config.RGB_565) {
            return C1778hp.m9706d(renderScript);
        }
        throw new C1782ht("Bad bitmap type: " + config);
    }

    /* JADX INFO: renamed from: a */
    static C1787hy m9686a(RenderScript renderScript, Bitmap bitmap, a aVar) {
        C1787hy.a aVar2 = new C1787hy.a(renderScript, m9685a(renderScript, bitmap));
        aVar2.m9732a(bitmap.getWidth());
        aVar2.m9735b(bitmap.getHeight());
        aVar2.m9733a(aVar == a.MIPMAP_FULL);
        return aVar2.m9734a();
    }

    /* JADX INFO: renamed from: a */
    public static C1776hn m9682a(RenderScript renderScript, Bitmap bitmap, a aVar, int i) {
        renderScript.m4413f();
        if (bitmap.getConfig() == null) {
            if ((i & 128) != 0) {
                throw new C1781hs("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return m9682a(renderScript, bitmapCreateBitmap, aVar, i);
        }
        C1787hy c1787hyM9686a = m9686a(renderScript, bitmap, aVar);
        if (aVar == a.MIPMAP_NONE && c1787hyM9686a.m9724a().m9711a(C1778hp.m9708f(renderScript)) && i == 131) {
            long jM4406b = renderScript.m4406b(c1787hyM9686a.m9698a(renderScript), aVar.f10226d, bitmap, i);
            if (jM4406b == 0) {
                throw new C1783hu("Load failed.");
            }
            C1776hn c1776hn = new C1776hn(jM4406b, renderScript, c1787hyM9686a, i);
            c1776hn.m9689b(bitmap);
            return c1776hn;
        }
        long jM4395a = renderScript.m4395a(c1787hyM9686a.m9698a(renderScript), aVar.f10226d, bitmap, i);
        if (jM4395a == 0) {
            throw new C1783hu("Load failed.");
        }
        return new C1776hn(jM4395a, renderScript, c1787hyM9686a, i);
    }

    /* JADX INFO: renamed from: a */
    public void m9695a(Surface surface) {
        this.f10229r.m4413f();
        if ((this.f10207c & 64) == 0) {
            throw new C1782ht("Allocation is not USAGE_IO_OUTPUT.");
        }
        this.f10229r.m4403a(m9698a(this.f10229r), surface);
    }

    /* JADX INFO: renamed from: b */
    public static C1776hn m9688b(RenderScript renderScript, Bitmap bitmap) {
        return m9682a(renderScript, bitmap, a.MIPMAP_NONE, 131);
    }

    @Override // p000.C1777ho
    /* JADX INFO: renamed from: b */
    public void mo9696b() {
        if (this.f10219o != 0) {
            boolean z = false;
            synchronized (this) {
                if (!this.f10220p) {
                    this.f10220p = true;
                    z = true;
                }
            }
            if (z) {
                ReentrantReadWriteLock.ReadLock lock = this.f10229r.f4122l.readLock();
                lock.lock();
                if (this.f10229r.m4416i()) {
                    this.f10229r.m4409b(this.f10219o);
                }
                lock.unlock();
                this.f10219o = 0L;
            }
        }
        if ((this.f10207c & 96) != 0) {
            m9695a((Surface) null);
        }
        super.mo9696b();
    }
}
