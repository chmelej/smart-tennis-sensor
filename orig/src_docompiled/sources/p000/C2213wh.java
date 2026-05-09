package p000;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: renamed from: wh */
/* JADX INFO: compiled from: PreviewRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2213wh implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a */
    private WeakReference<GLSurfaceView> f13269a;

    /* JADX INFO: renamed from: b */
    private C2148tx f13270b;

    /* JADX INFO: renamed from: c */
    private C2219wn f13271c;

    /* JADX INFO: renamed from: d */
    private C2215wj f13272d;

    /* JADX INFO: renamed from: f */
    private SurfaceTexture f13274f;

    /* JADX INFO: renamed from: g */
    private int f13275g;

    /* JADX INFO: renamed from: h */
    private int f13276h;

    /* JADX INFO: renamed from: i */
    private int f13277i;

    /* JADX INFO: renamed from: j */
    private int f13278j;

    /* JADX INFO: renamed from: k */
    private int f13279k;

    /* JADX INFO: renamed from: m */
    private InterfaceC2170us f13281m;

    /* JADX INFO: renamed from: n */
    private EnumC2157uf f13282n;

    /* JADX INFO: renamed from: o */
    private volatile boolean f13283o;

    /* JADX INFO: renamed from: e */
    private C2218wm f13273e = new C2218wm();

    /* JADX INFO: renamed from: l */
    private float[] f13280l = new float[16];

    public C2213wh(GLSurfaceView gLSurfaceView, C2158ug c2158ug, EnumC2157uf enumC2157uf) {
        this.f13269a = new WeakReference<>(gLSurfaceView);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(this);
        gLSurfaceView.setRenderMode(0);
        this.f13270b = new C2148tx(gLSurfaceView.getContext(), c2158ug);
        this.f13282n = enumC2157uf;
    }

    /* JADX INFO: renamed from: a */
    public final void m12116a(InterfaceC2170us interfaceC2170us) {
        this.f13281m = interfaceC2170us;
    }

    /* JADX INFO: renamed from: a */
    public void m12114a() {
        GLSurfaceView gLSurfaceView = this.f13269a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.onResume();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m12117b() {
        GLSurfaceView gLSurfaceView = this.f13269a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: wh.1
                @Override // java.lang.Runnable
                public void run() {
                    C2213wh.this.f13270b.m11729b();
                    GLES20.glGetError();
                    if (C2213wh.this.f13274f != null) {
                        C2213wh.this.f13274f.release();
                    }
                    if (C2213wh.this.f13281m != null) {
                        C2213wh.this.f13281m.mo11731d();
                    }
                }
            });
            gLSurfaceView.onPause();
        }
    }

    /* JADX INFO: renamed from: c */
    public SurfaceTexture m12118c() {
        return this.f13274f;
    }

    /* JADX INFO: renamed from: a */
    public void m12115a(int i, int i2, int i3, int i4) {
        this.f13275g = i;
        this.f13276h = i2;
        this.f13277i = i3;
        this.f13278j = i4;
        GLSurfaceView gLSurfaceView = this.f13269a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        C2201vw.f13221j.m12053c("PreviewRenderer", "onSurfaceCreated");
        this.f13270b.mo11730c();
        GLES20.glGetError();
        this.f13277i = 0;
        this.f13278j = 0;
        this.f13272d = null;
        this.f13271c = null;
        this.f13279k = C2200vv.m12044c();
        this.f13274f = new SurfaceTexture(this.f13279k);
        if (this.f13281m != null) {
            this.f13281m.mo11730c();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        C2201vw.f13221j.m12053c("PreviewRenderer", "onSurfaceChanged width:" + i + " height:" + i2);
        this.f13270b.mo11726a(i, i2);
        GLES20.glGetError();
        this.f13273e.mo12140a(i, i2);
        if (this.f13281m != null) {
            this.f13281m.mo11726a(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int iB;
        try {
            this.f13274f.updateTexImage();
            this.f13274f.getTransformMatrix(this.f13280l);
            long timestamp = this.f13274f.getTimestamp();
            C2201vw.f13221j.m12051b("PreviewRenderer", "onDrawFrame: " + timestamp);
            if (this.f13272d == null) {
                if (this.f13277i != 0 && this.f13278j != 0) {
                    this.f13273e.m12141a(this.f13277i, this.f13278j, this.f13282n);
                    this.f13272d = new C2215wj();
                    this.f13272d.mo11988b();
                    this.f13272d.mo12140a(this.f13277i, this.f13278j);
                    this.f13271c = new C2219wn();
                    this.f13271c.mo11988b();
                    this.f13271c.mo12140a(this.f13277i, this.f13278j);
                } else {
                    C2201vw.f13221j.m12053c("PreviewRenderer", "waiting for first render() to set texture size");
                    return;
                }
            }
            int iMo11725a = 0;
            if (this.f13283o) {
                if (this.f13281m != null) {
                    iMo11725a = this.f13281m.mo11725a(this.f13279k, this.f13275g, this.f13276h, timestamp, this.f13280l);
                }
            } else {
                if (this.f13270b.m11728a()) {
                    int iMo11725a2 = this.f13270b.mo11725a(this.f13279k, this.f13275g, this.f13276h, timestamp, this.f13280l);
                    GLES20.glGetError();
                    iB = this.f13271c.m12149b(iMo11725a2, this.f13280l);
                } else {
                    iB = this.f13272d.m12149b(this.f13279k, this.f13280l);
                }
                int i = iB;
                iMo11725a = this.f13281m != null ? this.f13281m.mo11725a(i, this.f13277i, this.f13278j, timestamp, C2200vv.f13210e) : i;
            }
            this.f13273e.m12142c(iMo11725a);
        } catch (Exception unused) {
            C2201vw.f13221j.m12055e("PreviewRenderer", "update surface texture failed !!!");
        }
    }
}
