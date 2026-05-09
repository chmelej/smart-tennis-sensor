package p000;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: dm */
/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
class C1665dm extends C1668dp {

    /* JADX INFO: renamed from: a */
    private static Method f9406a;

    /* JADX INFO: renamed from: b */
    private static boolean f9407b;

    /* JADX INFO: renamed from: c */
    private static Method f9408c;

    /* JADX INFO: renamed from: d */
    private static boolean f9409d;

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: b */
    public void mo8880b(View view) {
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: c */
    public void mo8881c(View view) {
    }

    C1665dm() {
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: a */
    public void mo8879a(View view, float f) {
        m8876a();
        if (f9406a != null) {
            try {
                f9406a.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // p000.C1668dp
    /* JADX INFO: renamed from: a */
    public float mo8878a(View view) {
        m8877b();
        if (f9408c != null) {
            try {
                return ((Float) f9408c.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.mo8878a(view);
    }

    /* JADX INFO: renamed from: a */
    private void m8876a() {
        if (f9407b) {
            return;
        }
        try {
            f9406a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f9406a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        f9407b = true;
    }

    /* JADX INFO: renamed from: b */
    private void m8877b() {
        if (f9409d) {
            return;
        }
        try {
            f9408c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f9408c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        f9409d = true;
    }
}
