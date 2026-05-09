package p000;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: wl */
/* JADX INFO: compiled from: Sticker.java */
/* JADX INFO: loaded from: classes.dex */
public class C2217wl extends C2218wm {

    /* JADX INFO: renamed from: h */
    private int f13322h;

    /* JADX INFO: renamed from: i */
    private int f13323i;

    /* JADX INFO: renamed from: j */
    private float f13324j;

    /* JADX INFO: renamed from: k */
    private float f13325k;

    /* JADX INFO: renamed from: l */
    private float f13326l;

    /* JADX INFO: renamed from: m */
    private float f13327m;

    /* JADX INFO: renamed from: n */
    private float f13328n;

    /* JADX INFO: renamed from: o */
    private int f13329o;

    /* JADX INFO: renamed from: p */
    private Bitmap f13330p;

    /* JADX INFO: renamed from: q */
    private boolean f13331q;

    /* JADX INFO: renamed from: r */
    private C2219wn f13332r;

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: b */
    public boolean mo11988b() {
        this.f13322h = C2200vv.m12046e();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f13330p.getWidth() * this.f13330p.getHeight() * 4);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (this.f13330p.getConfig() == Bitmap.Config.ARGB_8888) {
            this.f13330p.copyPixelsToBuffer(byteBufferAllocateDirect);
            byteBufferAllocateDirect.position(0);
        }
        this.f13323i = C2200vv.m12038a(byteBufferAllocateDirect, this.f13330p.getWidth(), this.f13330p.getHeight(), 6408);
        if (this.f13326l == 0.0f) {
            this.f13326l = this.f13324j + ((this.f13330p.getWidth() * 1.0f) / this.f13335c);
        }
        if (this.f13327m == 0.0f) {
            this.f13327m = this.f13325k + ((this.f13330p.getHeight() * 1.0f) / this.f13336d);
        }
        if (this.f13331q) {
            if (this.f13326l > 1.0f) {
                this.f13324j = 1.0f - (this.f13326l - this.f13324j);
                this.f13326l = 1.0f;
            }
            if (this.f13327m > 1.0f) {
                this.f13325k = 1.0f - (this.f13327m - this.f13325k);
                this.f13327m = 1.0f;
            }
        }
        float f = this.f13335c / this.f13336d;
        float f2 = f * 2.0f;
        this.f13324j *= f2;
        this.f13325k *= 2.0f;
        this.f13326l *= f2;
        this.f13327m *= 2.0f;
        this.f13324j -= f;
        this.f13325k -= 1.0f;
        this.f13326l -= f;
        this.f13327m -= 1.0f;
        this.f13325k *= -1.0f;
        this.f13327m *= -1.0f;
        this.f13339g = new float[16];
        float f3 = this.f13326l - this.f13324j;
        float f4 = this.f13327m - this.f13325k;
        Matrix.orthoM(this.f13339g, 0, -f, f, -1.0f, 1.0f, -1.0f, 1.0f);
        float f5 = f3 / 2.0f;
        float f6 = f4 / 2.0f;
        Matrix.translateM(this.f13339g, 0, this.f13324j + f5, this.f13325k + f6, 0.0f);
        Matrix.rotateM(this.f13339g, 0, this.f13337e, 0.0f, 0.0f, -1.0f);
        Matrix.translateM(this.f13339g, 0, -(this.f13324j + f5), -(this.f13325k + f6), 0.0f);
        this.f13332r = new C2219wn();
        this.f13332r.mo12140a(this.f13335c, this.f13336d);
        this.f13332r.mo11988b();
        return super.mo11988b();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a */
    protected String[] mo11987a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n"};
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: c */
    protected boolean mo11989c() {
        this.f13329o = GLES20.glGetUniformLocation(this.f13338f, "u_alpha");
        return super.mo11989c();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a_ */
    public void mo12129a_(int i) {
        this.f13337e = i;
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: h */
    protected float[] mo12131h() {
        return new float[]{this.f13324j, this.f13327m, this.f13324j, this.f13325k, this.f13326l, this.f13327m, this.f13326l, this.f13325k};
    }

    /* JADX INFO: renamed from: b */
    public int m12130b(int i) {
        int iM12148b = this.f13332r.m12148b(i);
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glBindFramebuffer(36160, this.f13322h);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iM12148b, 0);
        m12142c(this.f13323i);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDisable(3042);
        return iM12148b;
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: d */
    protected void mo11990d() {
        super.mo11990d();
        GLES20.glUniform1f(this.f13329o, this.f13328n);
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: i */
    protected float[] mo12132i() {
        return C2200vv.f13209d;
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: f */
    public void mo11992f() {
        super.mo11992f();
        if (this.f13322h != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.f13322h}, 0);
            this.f13322h = 0;
        }
        if (this.f13323i != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.f13323i}, 0);
            this.f13323i = 0;
        }
        if (this.f13332r != null) {
            this.f13332r.mo11992f();
            this.f13332r = null;
        }
    }
}
