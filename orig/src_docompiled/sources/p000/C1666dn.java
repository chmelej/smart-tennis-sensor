package p000;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: dn */
/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
class C1666dn extends C1665dm {

    /* JADX INFO: renamed from: a */
    private static Method f9410a;

    /* JADX INFO: renamed from: b */
    private static boolean f9411b;

    /* JADX INFO: renamed from: c */
    private static Method f9412c;

    /* JADX INFO: renamed from: d */
    private static boolean f9413d;

    /* JADX INFO: renamed from: e */
    private static Method f9414e;

    /* JADX INFO: renamed from: f */
    private static boolean f9415f;

    C1666dn() {
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: a */
    public void mo8885a(View view, Matrix matrix) {
        m8882a();
        if (f9410a != null) {
            try {
                f9410a.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: b */
    public void mo8886b(View view, Matrix matrix) {
        m8883b();
        if (f9412c != null) {
            try {
                f9412c.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: c */
    public void mo8887c(View view, Matrix matrix) {
        m8884c();
        if (f9414e != null) {
            try {
                f9414e.invoke(view, matrix);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getCause());
            } catch (InvocationTargetException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8882a() {
        if (f9411b) {
            return;
        }
        try {
            f9410a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f9410a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        f9411b = true;
    }

    /* JADX INFO: renamed from: b */
    private void m8883b() {
        if (f9413d) {
            return;
        }
        try {
            f9412c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f9412c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        f9413d = true;
    }

    /* JADX INFO: renamed from: c */
    private void m8884c() {
        if (f9415f) {
            return;
        }
        try {
            f9414e = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
            f9414e.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", e);
        }
        f9415f = true;
    }
}
