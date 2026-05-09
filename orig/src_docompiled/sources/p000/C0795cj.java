package p000;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: cj */
/* JADX INFO: compiled from: GhostViewApi21.java */
/* JADX INFO: loaded from: classes.dex */
class C0795cj implements InterfaceC0796ck {

    /* JADX INFO: renamed from: a */
    private static Class<?> f5339a;

    /* JADX INFO: renamed from: b */
    private static boolean f5340b;

    /* JADX INFO: renamed from: c */
    private static Method f5341c;

    /* JADX INFO: renamed from: d */
    private static boolean f5342d;

    /* JADX INFO: renamed from: e */
    private static Method f5343e;

    /* JADX INFO: renamed from: f */
    private static boolean f5344f;

    /* JADX INFO: renamed from: g */
    private final View f5345g;

    @Override // p000.InterfaceC0796ck
    /* JADX INFO: renamed from: a */
    public void mo5790a(ViewGroup viewGroup, View view) {
    }

    /* JADX INFO: renamed from: a */
    static InterfaceC0796ck m5791a(View view, ViewGroup viewGroup, Matrix matrix) {
        m5794b();
        if (f5341c != null) {
            try {
                return new C0795cj((View) f5341c.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    static void m5793a(View view) {
        m5795c();
        if (f5343e != null) {
            try {
                f5343e.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private C0795cj(View view) {
        this.f5345g = view;
    }

    @Override // p000.InterfaceC0796ck
    public void setVisibility(int i) {
        this.f5345g.setVisibility(i);
    }

    /* JADX INFO: renamed from: a */
    private static void m5792a() {
        if (f5340b) {
            return;
        }
        try {
            f5339a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
        }
        f5340b = true;
    }

    /* JADX INFO: renamed from: b */
    private static void m5794b() {
        if (f5342d) {
            return;
        }
        try {
            m5792a();
            f5341c = f5339a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f5341c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e);
        }
        f5342d = true;
    }

    /* JADX INFO: renamed from: c */
    private static void m5795c() {
        if (f5344f) {
            return;
        }
        try {
            m5792a();
            f5343e = f5339a.getDeclaredMethod("removeGhost", View.class);
            f5343e.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
        }
        f5344f = true;
    }
}
