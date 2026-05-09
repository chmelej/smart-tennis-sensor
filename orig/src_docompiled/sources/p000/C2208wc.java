package p000;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: renamed from: wc */
/* JADX INFO: compiled from: Egl14.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class C2208wc implements InterfaceC2209wd {

    /* JADX INFO: renamed from: a */
    private EGLDisplay f13257a;

    /* JADX INFO: renamed from: b */
    private EGLContext f13258b;

    /* JADX INFO: renamed from: c */
    private EGLConfig f13259c;

    public C2208wc(Object obj, int i) {
        this.f13257a = EGL14.EGL_NO_DISPLAY;
        this.f13258b = EGL14.EGL_NO_CONTEXT;
        this.f13259c = null;
        if (this.f13257a != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        obj = obj == null ? EGL14.EGL_NO_CONTEXT : obj;
        this.f13257a = EGL14.eglGetDisplay(0);
        if (this.f13257a == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = {0, 1};
        if (!EGL14.eglInitialize(this.f13257a, iArr, 0, iArr, 1)) {
            this.f13257a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if (this.f13258b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigM12095a = m12095a(i, 2);
            if (eGLConfigM12095a == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f13257a, eGLConfigM12095a, (EGLContext) obj, new int[]{12440, 2, 12344}, 0);
            m12096a("eglCreateContext");
            this.f13259c = eGLConfigM12095a;
            this.f13258b = eGLContextEglCreateContext;
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12089a() {
        if (this.f13257a != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f13257a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f13257a, this.f13258b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f13257a);
        }
        this.f13257a = EGL14.EGL_NO_DISPLAY;
        this.f13258b = EGL14.EGL_NO_CONTEXT;
        this.f13259c = null;
    }

    @Override // p000.InterfaceC2209wd
    public void finalize() {
        if (this.f13257a != EGL14.EGL_NO_DISPLAY) {
            Log.w("EGL14", "WARNING: EglCore was not explicitly released -- state may be leaked");
            mo12089a();
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12090a(Object obj) {
        EGL14.eglDestroySurface(this.f13257a, (EGLSurface) obj);
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: b */
    public Object mo12092b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f13257a, this.f13259c, obj, new int[]{12344}, 0);
        m12096a("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eGLSurfaceEglCreateWindowSurface;
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: c */
    public void mo12093c(Object obj) {
        if (this.f13257a == EGL14.EGL_NO_DISPLAY) {
            Log.d("EGL14", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!EGL14.eglMakeCurrent(this.f13257a, eGLSurface, eGLSurface, this.f13258b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: d */
    public boolean mo12094d(Object obj) {
        return EGL14.eglSwapBuffers(this.f13257a, (EGLSurface) obj);
    }

    @Override // p000.InterfaceC2209wd
    /* JADX INFO: renamed from: a */
    public void mo12091a(Object obj, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f13257a, (EGLSurface) obj, j);
    }

    /* JADX INFO: renamed from: a */
    private EGLConfig m12095a(int i, int i2) {
        int i3 = i2 >= 3 ? 68 : 4;
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f13257a, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            Log.w("EGL14", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    /* JADX INFO: renamed from: a */
    private void m12096a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
        }
    }

    /* JADX INFO: renamed from: b */
    public static Object m12097b() {
        return EGL14.eglGetCurrentContext();
    }
}
