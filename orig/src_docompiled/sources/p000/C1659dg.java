package p000;

import android.animation.LayoutTransition;
import android.support.transition.R;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: dg */
/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
class C1659dg {

    /* JADX INFO: renamed from: a */
    private static LayoutTransition f9387a;

    /* JADX INFO: renamed from: b */
    private static Field f9388b;

    /* JADX INFO: renamed from: c */
    private static boolean f9389c;

    /* JADX INFO: renamed from: d */
    private static Method f9390d;

    /* JADX INFO: renamed from: e */
    private static boolean f9391e;

    /* JADX INFO: renamed from: a */
    static void m8849a(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (f9387a == null) {
            f9387a = new LayoutTransition() { // from class: dg.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            f9387a.setAnimator(2, null);
            f9387a.setAnimator(0, null);
            f9387a.setAnimator(1, null);
            f9387a.setAnimator(3, null);
            f9387a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    m8848a(layoutTransition);
                }
                if (layoutTransition != f9387a) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f9387a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f9389c) {
            try {
                f9388b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f9388b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f9389c = true;
        }
        if (f9388b != null) {
            try {
                boolean z3 = f9388b.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f9388b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8848a(LayoutTransition layoutTransition) {
        if (!f9391e) {
            try {
                f9390d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f9390d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f9391e = true;
        }
        if (f9390d != null) {
            try {
                f9390d.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
