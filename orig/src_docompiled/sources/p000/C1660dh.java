package p000;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: dh */
/* JADX INFO: compiled from: ViewGroupUtilsApi18.java */
/* JADX INFO: loaded from: classes.dex */
class C1660dh {

    /* JADX INFO: renamed from: a */
    private static Method f9392a;

    /* JADX INFO: renamed from: b */
    private static boolean f9393b;

    /* JADX INFO: renamed from: a */
    static void m8851a(ViewGroup viewGroup, boolean z) {
        m8850a();
        if (f9392a != null) {
            try {
                f9392a.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m8850a() {
        if (f9393b) {
            return;
        }
        try {
            f9392a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f9392a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        f9393b = true;
    }
}
