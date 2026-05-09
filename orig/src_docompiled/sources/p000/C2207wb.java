package p000;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: renamed from: wb */
/* JADX INFO: compiled from: Egl10.java */
/* JADX INFO: loaded from: classes.dex */
public class C2207wb implements InterfaceC2209wd {

    /* JADX INFO: renamed from: a */
    private EGLDisplay f13253a;

    /* JADX INFO: renamed from: b */
    private EGLContext f13254b;

    /* JADX INFO: renamed from: c */
    private EGLConfig f13255c;

    /* JADX INFO: renamed from: d */
    private EGL10 f13256d = (EGL10) EGLContext.getEGL();

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12091a(Object obj, long j) {
    }

    public C2207wb(Object obj, int i) {
        this.f13253a = EGL10.EGL_NO_DISPLAY;
        this.f13254b = EGL10.EGL_NO_CONTEXT;
        this.f13255c = null;
        if (this.f13253a != EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        obj = obj == null ? EGL10.EGL_NO_CONTEXT : obj;
        this.f13253a = this.f13256d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f13253a == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.f13256d.eglInitialize(this.f13253a, new int[2])) {
            this.f13253a = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        if (this.f13254b == EGL10.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigM12086a = m12086a(i, 2);
            if (eGLConfigM12086a == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext = this.f13256d.eglCreateContext(this.f13253a, eGLConfigM12086a, (EGLContext) obj, new int[]{12440, 2, 12344});
            m12087a("eglCreateContext");
            this.f13255c = eGLConfigM12086a;
            this.f13254b = eGLContextEglCreateContext;
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12089a() {
        if (this.f13253a != EGL10.EGL_NO_DISPLAY) {
            this.f13256d.eglMakeCurrent(this.f13253a, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.f13256d.eglDestroyContext(this.f13253a, this.f13254b);
            this.f13256d.eglTerminate(this.f13253a);
        }
        this.f13253a = EGL10.EGL_NO_DISPLAY;
        this.f13254b = EGL10.EGL_NO_CONTEXT;
        this.f13255c = null;
    }

    @Override // p000.InterfaceC2209wd
    public void finalize() {
        if (this.f13253a != EGL10.EGL_NO_DISPLAY) {
            Log.w("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
            mo12089a();
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12090a(Object obj) {
        this.f13256d.eglDestroySurface(this.f13253a, (EGLSurface) obj);
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: b */
    public Object mo12092b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = this.f13256d.eglCreateWindowSurface(this.f13253a, this.f13255c, obj, new int[]{12344});
        m12087a("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eGLSurfaceEglCreateWindowSurface;
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: c */
    public void mo12093c(Object obj) {
        EGLDisplay eGLDisplay = this.f13253a;
        EGL10 egl10 = this.f13256d;
        if (eGLDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.d("EGL10", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!this.f13256d.eglMakeCurrent(this.f13253a, eGLSurface, eGLSurface, this.f13254b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: d */
    public boolean mo12094d(Object obj) {
        return this.f13256d.eglSwapBuffers(this.f13253a, (EGLSurface) obj);
    }

    /* JADX INFO: renamed from: a */
    private EGLConfig m12086a(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f13256d.eglChooseConfig(this.f13253a, iArr, eGLConfigArr, eGLConfigArr.length, new int[1])) {
            Log.w("EGL10", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    /* JADX INFO: renamed from: a */
    private void m12087a(String str) {
        int iEglGetError = this.f13256d.eglGetError();
        if (iEglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
        }
    }

    /* JADX INFO: renamed from: b */
    public static Object m12088b() {
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }
}
