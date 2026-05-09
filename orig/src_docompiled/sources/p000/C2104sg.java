package p000;

import android.opengl.GLES10;

/* JADX INFO: renamed from: sg */
/* JADX INFO: compiled from: ImageSizeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2104sg {

    /* JADX INFO: renamed from: a */
    private static C2079ri f12640a;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        f12640a = new C2079ri(iMax, iMax);
    }

    /* JADX INFO: renamed from: a */
    public static C2079ri m11515a(InterfaceC2095ry interfaceC2095ry, C2079ri c2079ri) {
        int iMo11493a = interfaceC2095ry.mo11493a();
        if (iMo11493a <= 0) {
            iMo11493a = c2079ri.m11433a();
        }
        int iMo11496b = interfaceC2095ry.mo11496b();
        if (iMo11496b <= 0) {
            iMo11496b = c2079ri.m11436b();
        }
        return new C2079ri(iMo11493a, iMo11496b);
    }

    /* JADX INFO: renamed from: a */
    public static int m11514a(C2079ri c2079ri, C2079ri c2079ri2, EnumC2082rl enumC2082rl, boolean z) {
        int iMax;
        int i;
        int iM11433a = c2079ri.m11433a();
        int iM11436b = c2079ri.m11436b();
        int iM11433a2 = c2079ri2.m11433a();
        int iM11436b2 = c2079ri2.m11436b();
        switch (enumC2082rl) {
            case FIT_INSIDE:
                if (z) {
                    int i2 = iM11433a / 2;
                    int i3 = iM11436b / 2;
                    i = 1;
                    while (true) {
                        if (i2 / i <= iM11433a2 && i3 / i <= iM11436b2) {
                            iMax = i;
                        } else {
                            i *= 2;
                        }
                    }
                } else {
                    iMax = Math.max(iM11433a / iM11433a2, iM11436b / iM11436b2);
                }
                break;
            case CROP:
                if (z) {
                    int i4 = iM11433a / 2;
                    int i5 = iM11436b / 2;
                    i = 1;
                    while (i4 / i > iM11433a2 && i5 / i > iM11436b2) {
                        i *= 2;
                    }
                    iMax = i;
                } else {
                    iMax = Math.min(iM11433a / iM11433a2, iM11436b / iM11436b2);
                }
                break;
            default:
                iMax = 1;
                break;
        }
        if (iMax < 1) {
            iMax = 1;
        }
        return m11512a(iM11433a, iM11436b, iMax, z);
    }

    /* JADX INFO: renamed from: a */
    private static int m11512a(int i, int i2, int i3, boolean z) {
        int iM11433a = f12640a.m11433a();
        int iM11436b = f12640a.m11436b();
        while (true) {
            if (i / i3 <= iM11433a && i2 / i3 <= iM11436b) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m11513a(C2079ri c2079ri) {
        int iM11433a = c2079ri.m11433a();
        int iM11436b = c2079ri.m11436b();
        return Math.max((int) Math.ceil(iM11433a / f12640a.m11433a()), (int) Math.ceil(iM11436b / f12640a.m11436b()));
    }

    /* JADX INFO: renamed from: b */
    public static float m11516b(C2079ri c2079ri, C2079ri c2079ri2, EnumC2082rl enumC2082rl, boolean z) {
        int iM11433a = c2079ri.m11433a();
        int iM11436b = c2079ri.m11436b();
        int iM11433a2 = c2079ri2.m11433a();
        int iM11436b2 = c2079ri2.m11436b();
        float f = iM11433a;
        float f2 = f / iM11433a2;
        float f3 = iM11436b;
        float f4 = f3 / iM11436b2;
        if ((enumC2082rl != EnumC2082rl.FIT_INSIDE || f2 < f4) && (enumC2082rl != EnumC2082rl.CROP || f2 >= f4)) {
            iM11433a2 = (int) (f / f4);
        } else {
            iM11436b2 = (int) (f3 / f2);
        }
        if ((z || iM11433a2 >= iM11433a || iM11436b2 >= iM11436b) && (!z || iM11433a2 == iM11433a || iM11436b2 == iM11436b)) {
            return 1.0f;
        }
        return iM11433a2 / f;
    }
}
