package p000;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.HandlerThread;

/* JADX INFO: renamed from: wk */
/* JADX INFO: compiled from: MVEffect.java */
/* JADX INFO: loaded from: classes.dex */
public class C2216wk extends C2218wm {

    /* JADX INFO: renamed from: A */
    private volatile boolean f13300A;

    /* JADX INFO: renamed from: B */
    private final Object f13301B;

    /* JADX INFO: renamed from: C */
    private HandlerThread f13302C;

    /* JADX INFO: renamed from: h */
    private int f13303h;

    /* JADX INFO: renamed from: i */
    private float[] f13304i;

    /* JADX INFO: renamed from: j */
    private int f13305j;

    /* JADX INFO: renamed from: k */
    private int f13306k;

    /* JADX INFO: renamed from: l */
    private C2219wn f13307l;

    /* JADX INFO: renamed from: m */
    private C2192vn f13308m;

    /* JADX INFO: renamed from: n */
    private SurfaceTexture f13309n;

    /* JADX INFO: renamed from: o */
    private C2215wj f13310o;

    /* JADX INFO: renamed from: p */
    private int f13311p;

    /* JADX INFO: renamed from: q */
    private int f13312q;

    /* JADX INFO: renamed from: r */
    private C2192vn f13313r;

    /* JADX INFO: renamed from: s */
    private SurfaceTexture f13314s;

    /* JADX INFO: renamed from: t */
    private C2215wj f13315t;

    /* JADX INFO: renamed from: u */
    private int f13316u;

    /* JADX INFO: renamed from: v */
    private int f13317v;

    /* JADX INFO: renamed from: w */
    private int f13318w;

    /* JADX INFO: renamed from: x */
    private volatile int f13319x;

    /* JADX INFO: renamed from: y */
    private final Object f13320y;

    /* JADX INFO: renamed from: z */
    private volatile boolean f13321z;

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: c */
    protected boolean mo11989c() {
        this.f13316u = GLES20.glGetUniformLocation(this.f13338f, "u_tex_mask");
        return super.mo11989c();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a */
    protected String[] mo11987a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex_mv;\nuniform sampler2D u_tex_mask;\nvarying vec2 v_tex_coord;\nvoid main() {\n   vec4 mv_color = texture2D(u_tex_mv, v_tex_coord);\n   vec4 mask_color = texture2D(u_tex_mask, v_tex_coord);\n   float new_alpha = dot(mask_color.rgb, vec3(.33333334, .33333334, .33333334)) * mask_color.a;\n   gl_FragColor = mv_color * new_alpha;\n}\n"};
    }

    /* JADX INFO: renamed from: k */
    private boolean m12127k() {
        if (this.f13310o == null) {
            this.f13310o = new C2215wj();
            this.f13310o.mo12140a(this.f13305j, this.f13306k);
            this.f13310o.mo11988b();
        }
        if (this.f13315t == null) {
            this.f13315t = new C2215wj();
            this.f13315t.mo12140a(this.f13305j, this.f13306k);
            this.f13315t.mo11988b();
        }
        try {
            this.f13309n.updateTexImage();
            this.f13314s.updateTexImage();
            this.f13309n.getTransformMatrix(this.f13304i);
            this.f13312q = this.f13310o.m12149b(this.f13311p, this.f13304i);
            this.f13314s.getTransformMatrix(this.f13304i);
            this.f13318w = this.f13315t.m12149b(this.f13317v, this.f13304i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m12128a(int i) {
        synchronized (this.f13320y) {
            while (this.f13319x < 2) {
                try {
                    this.f13320y.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.f13319x = 0;
        }
        if (!m12127k()) {
            C2201vw.f13216e.m12055e("MVEffect", "update surface textures failed, return the origin tex id.");
            return i;
        }
        int iM12148b = this.f13307l.m12148b(i);
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glBindFramebuffer(36160, this.f13303h);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iM12148b, 0);
        m12142c(this.f13312q);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDisable(3042);
        synchronized (this.f13301B) {
            this.f13321z = true;
            this.f13300A = true;
            this.f13301B.notifyAll();
        }
        return iM12148b;
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: d */
    protected void mo11990d() {
        super.mo11990d();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f13318w);
        GLES20.glUniform1i(this.f13316u, 1);
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: e */
    protected void mo11991e() {
        super.mo11991e();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: f */
    public void mo11992f() {
        super.mo11992f();
        if (this.f13308m != null) {
            this.f13308m.mo12011h();
            this.f13308m = null;
        }
        if (this.f13313r != null) {
            this.f13313r.mo12011h();
            this.f13313r = null;
        }
        synchronized (this.f13301B) {
            this.f13321z = true;
            this.f13300A = true;
            this.f13301B.notifyAll();
        }
        if (this.f13302C != null) {
            this.f13302C.quitSafely();
            this.f13302C = null;
        }
        if (this.f13309n != null) {
            this.f13309n.release();
            this.f13309n = null;
        }
        if (this.f13314s != null) {
            this.f13314s.release();
            this.f13314s = null;
        }
        if (this.f13310o != null) {
            this.f13310o.mo11992f();
            this.f13310o = null;
        }
        if (this.f13315t != null) {
            this.f13315t.mo11992f();
            this.f13315t = null;
        }
        if (this.f13307l != null) {
            this.f13307l.mo11992f();
            this.f13307l = null;
        }
    }
}
