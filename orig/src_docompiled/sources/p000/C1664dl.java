package p000;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: dl */
/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1664dl {

    /* JADX INFO: renamed from: a */
    public static final Property<View, Float> f9401a;

    /* JADX INFO: renamed from: b */
    public static final Property<View, Rect> f9402b;

    /* JADX INFO: renamed from: c */
    private static final C1668dp f9403c;

    /* JADX INFO: renamed from: d */
    private static Field f9404d;

    /* JADX INFO: renamed from: e */
    private static boolean f9405e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f9403c = new C1667do();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f9403c = new C1666dn();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f9403c = new C1665dm();
        } else {
            f9403c = new C1668dp();
        }
        f9401a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: dl.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(C1664dl.m8868c(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f) {
                C1664dl.m8862a(view, f.floatValue());
            }
        };
        f9402b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: dl.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC1663dk m8860a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new C1662dj(view);
        }
        return C1661di.m8853d(view);
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC1672dt m8866b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new C1671ds(view);
        }
        return new C1670dr(view.getWindowToken());
    }

    /* JADX INFO: renamed from: a */
    public static void m8862a(View view, float f) {
        f9403c.mo8879a(view, f);
    }

    /* JADX INFO: renamed from: c */
    public static float m8868c(View view) {
        return f9403c.mo8878a(view);
    }

    /* JADX INFO: renamed from: d */
    public static void m8870d(View view) {
        f9403c.mo8880b(view);
    }

    /* JADX INFO: renamed from: e */
    public static void m8871e(View view) {
        f9403c.mo8881c(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m8863a(View view, int i) {
        m8861a();
        if (f9404d != null) {
            try {
                f9404d.setInt(view, i | (f9404d.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m8865a(View view, Matrix matrix) {
        f9403c.mo8885a(view, matrix);
    }

    /* JADX INFO: renamed from: b */
    public static void m8867b(View view, Matrix matrix) {
        f9403c.mo8886b(view, matrix);
    }

    /* JADX INFO: renamed from: c */
    public static void m8869c(View view, Matrix matrix) {
        f9403c.mo8887c(view, matrix);
    }

    /* JADX INFO: renamed from: a */
    public static void m8864a(View view, int i, int i2, int i3, int i4) {
        f9403c.mo8889a(view, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    private static void m8861a() {
        if (f9405e) {
            return;
        }
        try {
            f9404d = View.class.getDeclaredField("mViewFlags");
            f9404d.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f9405e = true;
    }
}
