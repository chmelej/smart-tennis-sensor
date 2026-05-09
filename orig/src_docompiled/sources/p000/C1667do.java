package p000;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: do */
/* JADX INFO: compiled from: ViewUtilsApi22.java */
/* JADX INFO: loaded from: classes.dex */
class C1667do extends C1666dn {

    /* JADX INFO: renamed from: a */
    private static Method f9416a;

    /* JADX INFO: renamed from: b */
    private static boolean f9417b;

    C1667do() {
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: a */
    public void mo8889a(View view, int i, int i2, int i3, int i4) {
        m8888a();
        if (f9416a != null) {
            try {
                f9416a.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* JADX INFO: renamed from: a */
    private void m8888a() {
        if (f9417b) {
            return;
        }
        try {
            f9416a = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f9416a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
        }
        f9417b = true;
    }
}
