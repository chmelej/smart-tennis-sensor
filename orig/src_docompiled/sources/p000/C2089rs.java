package p000;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;

/* JADX INFO: renamed from: rs */
/* JADX INFO: compiled from: ImageDecodingInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class C2089rs {

    /* JADX INFO: renamed from: a */
    private final String f12605a;

    /* JADX INFO: renamed from: b */
    private final String f12606b;

    /* JADX INFO: renamed from: c */
    private final String f12607c;

    /* JADX INFO: renamed from: d */
    private final C2079ri f12608d;

    /* JADX INFO: renamed from: e */
    private final EnumC2078rh f12609e;

    /* JADX INFO: renamed from: f */
    private final EnumC2082rl f12610f;

    /* JADX INFO: renamed from: g */
    private final InterfaceC2094rx f12611g;

    /* JADX INFO: renamed from: h */
    private final Object f12612h;

    /* JADX INFO: renamed from: i */
    private final boolean f12613i;

    /* JADX INFO: renamed from: j */
    private final BitmapFactory.Options f12614j = new BitmapFactory.Options();

    public C2089rs(String str, String str2, String str3, C2079ri c2079ri, EnumC2082rl enumC2082rl, InterfaceC2094rx interfaceC2094rx, C2067qx c2067qx) {
        this.f12605a = str;
        this.f12606b = str2;
        this.f12607c = str3;
        this.f12608d = c2079ri;
        this.f12609e = c2067qx.m11313j();
        this.f12610f = enumC2082rl;
        this.f12611g = interfaceC2094rx;
        this.f12612h = c2067qx.m11317n();
        this.f12613i = c2067qx.m11316m();
        m11467a(c2067qx.m11314k(), this.f12614j);
    }

    /* JADX INFO: renamed from: a */
    private void m11467a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            m11468b(options, options2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            m11469c(options, options2);
        }
    }

    @TargetApi(10)
    /* JADX INFO: renamed from: b */
    private void m11468b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: c */
    private void m11469c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    /* JADX INFO: renamed from: a */
    public String m11470a() {
        return this.f12605a;
    }

    /* JADX INFO: renamed from: b */
    public String m11471b() {
        return this.f12606b;
    }

    /* JADX INFO: renamed from: c */
    public C2079ri m11472c() {
        return this.f12608d;
    }

    /* JADX INFO: renamed from: d */
    public EnumC2078rh m11473d() {
        return this.f12609e;
    }

    /* JADX INFO: renamed from: e */
    public EnumC2082rl m11474e() {
        return this.f12610f;
    }

    /* JADX INFO: renamed from: f */
    public InterfaceC2094rx m11475f() {
        return this.f12611g;
    }

    /* JADX INFO: renamed from: g */
    public Object m11476g() {
        return this.f12612h;
    }

    /* JADX INFO: renamed from: h */
    public boolean m11477h() {
        return this.f12613i;
    }

    /* JADX INFO: renamed from: i */
    public BitmapFactory.Options m11478i() {
        return this.f12614j;
    }
}
