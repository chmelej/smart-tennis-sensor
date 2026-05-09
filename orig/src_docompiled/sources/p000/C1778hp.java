package p000;

import android.support.p002v8.renderscript.RenderScript;
import android.support.v4.view.PointerIconCompat;

/* JADX INFO: renamed from: hp */
/* JADX INFO: compiled from: Element.java */
/* JADX INFO: loaded from: classes.dex */
public class C1778hp extends C1777ho {

    /* JADX INFO: renamed from: a */
    int f10230a;

    /* JADX INFO: renamed from: b */
    b f10231b;

    /* JADX INFO: renamed from: c */
    a f10232c;

    /* JADX INFO: renamed from: d */
    boolean f10233d;

    /* JADX INFO: renamed from: e */
    int f10234e;

    /* JADX INFO: renamed from: a */
    public int m9710a() {
        return this.f10230a;
    }

    /* JADX INFO: renamed from: hp$b */
    /* JADX INFO: compiled from: Element.java */
    public enum b {
        NONE(0, 0),
        FLOAT_32(2, 4),
        FLOAT_64(3, 8),
        SIGNED_8(4, 1),
        SIGNED_16(5, 2),
        SIGNED_32(6, 4),
        SIGNED_64(7, 8),
        UNSIGNED_8(8, 1),
        UNSIGNED_16(9, 2),
        UNSIGNED_32(10, 4),
        UNSIGNED_64(11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5(13, 2),
        UNSIGNED_5_5_5_1(14, 2),
        UNSIGNED_4_4_4_4(15, 2),
        MATRIX_4X4(16, 64),
        MATRIX_3X3(17, 36),
        MATRIX_2X2(18, 16),
        RS_ELEMENT(1000),
        RS_TYPE(PointerIconCompat.TYPE_CONTEXT_MENU),
        RS_ALLOCATION(PointerIconCompat.TYPE_HAND),
        RS_SAMPLER(PointerIconCompat.TYPE_HELP),
        RS_SCRIPT(PointerIconCompat.TYPE_WAIT);


        /* JADX INFO: renamed from: x */
        int f10271x;

        /* JADX INFO: renamed from: y */
        int f10272y;

        b(int i, int i2) {
            this.f10271x = i;
            this.f10272y = i2;
        }

        b(int i) {
            this.f10271x = i;
            this.f10272y = 4;
            if (RenderScript.f4112g == 8) {
                this.f10272y = 32;
            }
        }
    }

    /* JADX INFO: renamed from: hp$a */
    /* JADX INFO: compiled from: Element.java */
    public enum a {
        USER(0),
        PIXEL_L(7),
        PIXEL_A(8),
        PIXEL_LA(9),
        PIXEL_RGB(10),
        PIXEL_RGBA(11),
        PIXEL_DEPTH(12),
        PIXEL_YUV(13);


        /* JADX INFO: renamed from: i */
        int f10246i;

        a(int i) {
            this.f10246i = i;
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1778hp m9704b(RenderScript renderScript) {
        if (renderScript.f4124n == null) {
            renderScript.f4124n = m9701a(renderScript, b.UNSIGNED_8);
        }
        return renderScript.f4124n;
    }

    /* JADX INFO: renamed from: c */
    public static C1778hp m9705c(RenderScript renderScript) {
        if (renderScript.f4125o == null) {
            renderScript.f4125o = m9703a(renderScript, b.UNSIGNED_8, a.PIXEL_A);
        }
        return renderScript.f4125o;
    }

    /* JADX INFO: renamed from: d */
    public static C1778hp m9706d(RenderScript renderScript) {
        if (renderScript.f4126p == null) {
            renderScript.f4126p = m9703a(renderScript, b.UNSIGNED_5_6_5, a.PIXEL_RGB);
        }
        return renderScript.f4126p;
    }

    /* JADX INFO: renamed from: e */
    public static C1778hp m9707e(RenderScript renderScript) {
        if (renderScript.f4127q == null) {
            renderScript.f4127q = m9703a(renderScript, b.UNSIGNED_4_4_4_4, a.PIXEL_RGBA);
        }
        return renderScript.f4127q;
    }

    /* JADX INFO: renamed from: f */
    public static C1778hp m9708f(RenderScript renderScript) {
        if (renderScript.f4128r == null) {
            renderScript.f4128r = m9703a(renderScript, b.UNSIGNED_8, a.PIXEL_RGBA);
        }
        return renderScript.f4128r;
    }

    /* JADX INFO: renamed from: g */
    public static C1778hp m9709g(RenderScript renderScript) {
        if (renderScript.f4129s == null) {
            renderScript.f4129s = m9702a(renderScript, b.UNSIGNED_8, 4);
        }
        return renderScript.f4129s;
    }

    C1778hp(long j, RenderScript renderScript, b bVar, a aVar, boolean z, int i) {
        super(j, renderScript);
        if (bVar == b.UNSIGNED_5_6_5 || bVar == b.UNSIGNED_4_4_4_4 || bVar == b.UNSIGNED_5_5_5_1) {
            this.f10230a = bVar.f10272y;
        } else if (i == 3) {
            this.f10230a = bVar.f10272y * 4;
        } else {
            this.f10230a = bVar.f10272y * i;
        }
        this.f10231b = bVar;
        this.f10232c = aVar;
        this.f10233d = z;
        this.f10234e = i;
    }

    /* JADX INFO: renamed from: h */
    public long m9712h(RenderScript renderScript) {
        return renderScript.m4407b(this.f10231b.f10271x, this.f10232c.f10246i, this.f10233d, this.f10234e);
    }

    /* JADX INFO: renamed from: a */
    static C1778hp m9701a(RenderScript renderScript, b bVar) {
        a aVar = a.USER;
        return new C1778hp(renderScript.m4396a(bVar.f10271x, aVar.f10246i, false, 1), renderScript, bVar, aVar, false, 1);
    }

    /* JADX INFO: renamed from: a */
    public static C1778hp m9702a(RenderScript renderScript, b bVar, int i) {
        if (i < 2 || i > 4) {
            throw new C1781hs("Vector size out of range 2-4.");
        }
        switch (bVar) {
            case FLOAT_32:
            case FLOAT_64:
            case SIGNED_8:
            case SIGNED_16:
            case SIGNED_32:
            case SIGNED_64:
            case UNSIGNED_8:
            case UNSIGNED_16:
            case UNSIGNED_32:
            case UNSIGNED_64:
            case BOOLEAN:
                a aVar = a.USER;
                return new C1778hp(renderScript.m4396a(bVar.f10271x, aVar.f10246i, false, i), renderScript, bVar, aVar, false, i);
            default:
                throw new C1781hs("Cannot create vector of non-primitive type.");
        }
    }

    /* JADX INFO: renamed from: a */
    public static C1778hp m9703a(RenderScript renderScript, b bVar, a aVar) {
        int i;
        if (aVar != a.PIXEL_L && aVar != a.PIXEL_A && aVar != a.PIXEL_LA && aVar != a.PIXEL_RGB && aVar != a.PIXEL_RGBA && aVar != a.PIXEL_DEPTH && aVar != a.PIXEL_YUV) {
            throw new C1781hs("Unsupported DataKind");
        }
        if (bVar != b.UNSIGNED_8 && bVar != b.UNSIGNED_16 && bVar != b.UNSIGNED_5_6_5 && bVar != b.UNSIGNED_4_4_4_4 && bVar != b.UNSIGNED_5_5_5_1) {
            throw new C1781hs("Unsupported DataType");
        }
        if (bVar == b.UNSIGNED_5_6_5 && aVar != a.PIXEL_RGB) {
            throw new C1781hs("Bad kind and type combo");
        }
        if (bVar == b.UNSIGNED_5_5_5_1 && aVar != a.PIXEL_RGBA) {
            throw new C1781hs("Bad kind and type combo");
        }
        if (bVar == b.UNSIGNED_4_4_4_4 && aVar != a.PIXEL_RGBA) {
            throw new C1781hs("Bad kind and type combo");
        }
        if (bVar == b.UNSIGNED_16 && aVar != a.PIXEL_DEPTH) {
            throw new C1781hs("Bad kind and type combo");
        }
        switch (aVar) {
            case PIXEL_LA:
                i = 2;
                break;
            case PIXEL_RGB:
                i = 3;
                break;
            case PIXEL_RGBA:
                i = 4;
                break;
            default:
                i = 1;
                break;
        }
        return new C1778hp(renderScript.m4396a(bVar.f10271x, aVar.f10246i, true, i), renderScript, bVar, aVar, true, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m9711a(C1778hp c1778hp) {
        if (equals(c1778hp)) {
            return true;
        }
        return this.f10230a == c1778hp.f10230a && this.f10231b != b.NONE && this.f10231b == c1778hp.f10231b && this.f10234e == c1778hp.f10234e;
    }
}
