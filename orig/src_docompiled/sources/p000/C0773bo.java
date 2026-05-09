package p000;

/* JADX INFO: renamed from: bo */
/* JADX INFO: compiled from: MathUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0773bo {
    /* JADX INFO: renamed from: a */
    public static float m5670a(float f, float f2, float f3) {
        return ((1.0f - f3) * f) + (f3 * f2);
    }

    /* JADX INFO: renamed from: b */
    private static float m5673b(float f, float f2, float f3, float f4) {
        return (f <= f2 || f <= f3 || f <= f4) ? (f2 <= f3 || f2 <= f4) ? f3 > f4 ? f3 : f4 : f2 : f;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m5674b(float f, float f2, float f3) {
        return f + f3 >= f2;
    }

    /* JADX INFO: renamed from: a */
    public static float m5671a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }

    /* JADX INFO: renamed from: a */
    public static float m5672a(float f, float f2, float f3, float f4, float f5, float f6) {
        return m5673b(m5671a(f, f2, f3, f4), m5671a(f, f2, f5, f4), m5671a(f, f2, f5, f6), m5671a(f, f2, f3, f6));
    }
}
