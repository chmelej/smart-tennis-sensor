package p000;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: compiled from: InputSurface.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class ajs {

    /* JADX INFO: renamed from: a */
    private EGLDisplay f1352a;

    /* JADX INFO: renamed from: b */
    private EGLContext f1353b;

    /* JADX INFO: renamed from: c */
    private EGLSurface f1354c;

    /* JADX INFO: renamed from: d */
    private Surface f1355d;

    public ajs(Surface surface) {
        if (surface == null) {
            throw new NullPointerException();
        }
        this.f1355d = surface;
        m1614d();
    }

    /* JADX INFO: renamed from: d */
    private void m1614d() {
        this.f1352a = EGL14.eglGetDisplay(0);
        if (this.f1352a == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f1352a, iArr, 0, iArr, 1)) {
            this.f1352a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f1352a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f1353b = EGL14.eglCreateContext(this.f1352a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        m1613a("eglCreateContext");
        if (this.f1353b == null) {
            throw new RuntimeException("null context");
        }
        this.f1354c = EGL14.eglCreateWindowSurface(this.f1352a, eGLConfigArr[0], this.f1355d, new int[]{12344}, 0);
        m1613a("eglCreateWindowSurface");
        if (this.f1354c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1615a() {
        if (EGL14.eglGetCurrentContext().equals(this.f1353b)) {
            EGL14.eglMakeCurrent(this.f1352a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f1352a, this.f1354c);
        EGL14.eglDestroyContext(this.f1352a, this.f1353b);
        this.f1355d.release();
        this.f1352a = null;
        this.f1353b = null;
        this.f1354c = null;
        this.f1355d = null;
    }

    /* JADX INFO: renamed from: b */
    public void m1617b() {
        if (!EGL14.eglMakeCurrent(this.f1352a, this.f1354c, this.f1354c, this.f1353b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m1618c() {
        return EGL14.eglSwapBuffers(this.f1352a, this.f1354c);
    }

    /* JADX INFO: renamed from: a */
    public void m1616a(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f1352a, this.f1354c, j);
    }

    /* JADX INFO: renamed from: a */
    private void m1613a(String str) {
        boolean z = false;
        while (EGL14.eglGetError() != 12288) {
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }
}
