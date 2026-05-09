package p000;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: hl */
/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1774hl {

    /* JADX INFO: renamed from: a */
    private static Method f10203a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f10203a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (f10203a.isAccessible()) {
                    return;
                }
                f10203a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m9679a(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    /* JADX INFO: renamed from: a */
    public static void m9678a(View view, Rect rect, Rect rect2) {
        if (f10203a != null) {
            try {
                f10203a.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m9680b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }
}
