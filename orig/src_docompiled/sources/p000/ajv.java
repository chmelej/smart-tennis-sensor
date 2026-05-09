package p000;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: OutputSurface.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class ajv implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a */
    private EGL10 f1374a;

    /* JADX INFO: renamed from: b */
    private EGLDisplay f1375b;

    /* JADX INFO: renamed from: c */
    private EGLContext f1376c;

    /* JADX INFO: renamed from: d */
    private EGLSurface f1377d;

    /* JADX INFO: renamed from: e */
    private SurfaceTexture f1378e;

    /* JADX INFO: renamed from: f */
    private Surface f1379f;

    /* JADX INFO: renamed from: g */
    private final Object f1380g;

    /* JADX INFO: renamed from: h */
    private boolean f1381h;

    /* JADX INFO: renamed from: i */
    private ajx f1382i;

    /* JADX INFO: renamed from: j */
    private int f1383j;

    /* JADX INFO: renamed from: k */
    private int f1384k;

    /* JADX INFO: renamed from: l */
    private int f1385l;

    /* JADX INFO: renamed from: m */
    private ByteBuffer f1386m;

    public ajv(int i, int i2, int i3) {
        this.f1375b = null;
        this.f1376c = null;
        this.f1377d = null;
        this.f1380g = new Object();
        this.f1385l = 0;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1383j = i;
        this.f1384k = i2;
        this.f1385l = i3;
        this.f1386m = ByteBuffer.allocateDirect(this.f1383j * this.f1384k * 4);
        this.f1386m.order(ByteOrder.LITTLE_ENDIAN);
        m1652a(i, i2);
        m1657b();
        m1654f();
    }

    public ajv() {
        this.f1375b = null;
        this.f1376c = null;
        this.f1377d = null;
        this.f1380g = new Object();
        this.f1385l = 0;
        m1654f();
    }

    /* JADX INFO: renamed from: f */
    private void m1654f() {
        this.f1382i = new ajx(this.f1385l);
        this.f1382i.m1668b();
        this.f1378e = new SurfaceTexture(this.f1382i.m1665a());
        this.f1378e.setOnFrameAvailableListener(this);
        this.f1379f = new Surface(this.f1378e);
    }

    /* JADX INFO: renamed from: a */
    private void m1652a(int i, int i2) {
        this.f1374a = (EGL10) EGLContext.getEGL();
        this.f1375b = this.f1374a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f1375b == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.f1374a.eglInitialize(this.f1375b, null)) {
            this.f1375b = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f1374a.eglChooseConfig(this.f1375b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, eGLConfigArr.length, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.f1376c = this.f1374a.eglCreateContext(this.f1375b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        m1653a("eglCreateContext");
        if (this.f1376c == null) {
            throw new RuntimeException("null context");
        }
        this.f1377d = this.f1374a.eglCreatePbufferSurface(this.f1375b, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
        m1653a("eglCreatePbufferSurface");
        if (this.f1377d == null) {
            throw new RuntimeException("surface was null");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1655a() {
        if (this.f1374a != null) {
            if (this.f1374a.eglGetCurrentContext().equals(this.f1376c)) {
                this.f1374a.eglMakeCurrent(this.f1375b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            }
            this.f1374a.eglDestroySurface(this.f1375b, this.f1377d);
            this.f1374a.eglDestroyContext(this.f1375b, this.f1376c);
        }
        this.f1379f.release();
        this.f1375b = null;
        this.f1376c = null;
        this.f1377d = null;
        this.f1374a = null;
        this.f1382i = null;
        this.f1379f = null;
        this.f1378e = null;
    }

    /* JADX INFO: renamed from: b */
    public void m1657b() {
        if (this.f1374a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        m1653a("before makeCurrent");
        if (!this.f1374a.eglMakeCurrent(this.f1375b, this.f1377d, this.f1377d, this.f1376c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* JADX INFO: renamed from: c */
    public Surface m1658c() {
        return this.f1379f;
    }

    /* JADX INFO: renamed from: d */
    public void m1659d() {
        synchronized (this.f1380g) {
            while (!this.f1381h) {
                try {
                    this.f1380g.wait(5000L);
                    if (!this.f1381h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.f1381h = false;
        }
        this.f1382i.m1667a("before updateTexImage");
        this.f1378e.updateTexImage();
    }

    /* JADX INFO: renamed from: a */
    public void m1656a(boolean z) {
        this.f1382i.m1666a(this.f1378e, z);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f1380g) {
            if (this.f1381h) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.f1381h = true;
            this.f1380g.notifyAll();
        }
    }

    /* JADX INFO: renamed from: e */
    public ByteBuffer m1660e() {
        this.f1386m.rewind();
        GLES20.glReadPixels(0, 0, this.f1383j, this.f1384k, 6408, 5121, this.f1386m);
        return this.f1386m;
    }

    /* JADX INFO: renamed from: a */
    private void m1653a(String str) {
        if (this.f1374a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }
}
