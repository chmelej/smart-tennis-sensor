package p000;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: wm */
/* JADX INFO: compiled from: TextureDrawer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2218wm {

    /* JADX INFO: renamed from: a */
    protected int f13333a;

    /* JADX INFO: renamed from: b */
    protected int f13334b;

    /* JADX INFO: renamed from: c */
    protected int f13335c;

    /* JADX INFO: renamed from: d */
    protected int f13336d;

    /* JADX INFO: renamed from: e */
    protected int f13337e;

    /* JADX INFO: renamed from: f */
    protected int f13338f;

    /* JADX INFO: renamed from: g */
    protected float[] f13339g;

    /* JADX INFO: renamed from: h */
    private int f13340h;

    /* JADX INFO: renamed from: i */
    private int f13341i;

    /* JADX INFO: renamed from: j */
    private int f13342j;

    /* JADX INFO: renamed from: k */
    private int f13343k;

    /* JADX INFO: renamed from: l */
    private int f13344l;

    /* JADX INFO: renamed from: m */
    private int f13345m;

    /* JADX INFO: renamed from: n */
    private int f13346n;

    /* JADX INFO: renamed from: o */
    private float[] f13347o = C2200vv.f13207b;

    /* JADX INFO: renamed from: p */
    private float[] f13348p = C2200vv.f13208c;

    /* JADX INFO: renamed from: q */
    private int f13349q;

    /* JADX INFO: renamed from: r */
    private int f13350r;

    /* JADX INFO: renamed from: s */
    private boolean f13351s;

    /* JADX INFO: renamed from: d */
    protected void mo11990d() {
    }

    /* JADX INFO: renamed from: e */
    protected void mo11991e() {
    }

    /* JADX INFO: renamed from: g */
    protected int mo12126g() {
        return 3553;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo11988b() {
        if (!m12138m() || !mo11989c() || !m12136k()) {
            return false;
        }
        this.f13351s = true;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m12141a(int i, int i2, EnumC2157uf enumC2157uf) {
        if (enumC2157uf == EnumC2157uf.FULL) {
            m12134b(i, i2);
        } else if (enumC2157uf == EnumC2157uf.FIT) {
            m12135c(i, i2);
        }
        return mo11988b();
    }

    /* JADX INFO: renamed from: j */
    public boolean m12143j() {
        return this.f13351s;
    }

    /* JADX INFO: renamed from: b */
    private void m12134b(int i, int i2) {
        this.f13347o = C2200vv.f13207b;
        float f = (this.f13335c * 1.0f) / this.f13336d;
        float f2 = i;
        float f3 = i2;
        if ((f2 * 1.0f) / f3 < f) {
            float f4 = ((f3 - (f2 / f)) / 2.0f) / f3;
            float f5 = 1.0f - f4;
            this.f13348p = new float[]{0.0f, f4, 0.0f, f5, 1.0f, f4, 1.0f, f5};
        } else {
            float f6 = ((f2 - (f3 * f)) / 2.0f) / f2;
            float f7 = 1.0f - f6;
            this.f13348p = new float[]{f6, 0.0f, f6, 1.0f, f7, 0.0f, f7, 1.0f};
        }
    }

    /* JADX INFO: renamed from: c */
    private void m12135c(int i, int i2) {
        float f;
        float f2;
        this.f13348p = C2200vv.f13208c;
        float f3 = 1.0f;
        float f4 = (i * 1.0f) / i2;
        float f5 = 0.0f;
        if (f4 < (this.f13335c * 1.0f) / this.f13336d) {
            float f6 = this.f13336d * f4;
            f = 0.5f - ((f6 / this.f13335c) / 2.0f);
            f2 = ((f6 / this.f13335c) / 2.0f) + 0.5f;
            this.f13349q = (int) (this.f13335c * f);
        } else {
            float f7 = this.f13335c / f4;
            float f8 = 0.5f - ((f7 / this.f13336d) / 2.0f);
            this.f13350r = (int) (this.f13336d * f8);
            f5 = f8;
            f3 = ((f7 / this.f13336d) / 2.0f) + 0.5f;
            f = 0.0f;
            f2 = 1.0f;
        }
        m12133a(f, f2, f5, f3);
    }

    /* JADX INFO: renamed from: a */
    private void m12133a(float f, float f2, float f3, float f4) {
        float f5 = (this.f13335c * 1.0f) / this.f13336d;
        float f6 = f5 * 2.0f;
        float f7 = (f * f6) - f5;
        float f8 = (f6 * f2) - f5;
        float f9 = ((f3 * 2.0f) - 1.0f) * (-1.0f);
        float f10 = ((2.0f * f4) - 1.0f) * (-1.0f);
        this.f13339g = new float[16];
        Matrix.orthoM(this.f13339g, 0, -f5, f5, -1.0f, 1.0f, -1.0f, 1.0f);
        Matrix.rotateM(this.f13339g, 0, this.f13337e, 0.0f, 0.0f, -1.0f);
        this.f13347o = new float[]{f7, f10, f7, f9, f8, f10, f8, f9};
    }

    /* JADX INFO: renamed from: a_ */
    public void mo12129a_(int i) {
        if (this.f13339g == null) {
            this.f13339g = new float[16];
        }
        this.f13337e = i;
        Matrix.setIdentityM(this.f13339g, 0);
        Matrix.rotateM(this.f13339g, 0, i, 0.0f, 0.0f, -1.0f);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo12140a(int i, int i2) {
        this.f13335c = i;
        this.f13336d = i2;
        return true;
    }

    /* JADX INFO: renamed from: c */
    public void m12142c(int i) {
        m12139a(i, (float[]) null);
    }

    /* JADX INFO: renamed from: a */
    public void m12139a(int i, float[] fArr) {
        GLES20.glUseProgram(this.f13338f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(mo12126g(), i);
        if (C2200vv.m12039a()) {
            GLES30.glBindVertexArray(this.f13340h);
        } else {
            m12137l();
        }
        GLES20.glUniformMatrix4fv(this.f13345m, 1, false, this.f13339g != null ? this.f13339g : C2200vv.f13210e, 0);
        if (fArr == null) {
            fArr = C2200vv.f13210e;
        }
        GLES20.glUniformMatrix4fv(this.f13346n, 1, false, fArr, 0);
        GLES20.glViewport(this.f13333a, this.f13334b, this.f13335c, this.f13336d);
        mo11990d();
        GLES20.glDrawArrays(5, 0, 4);
        mo11991e();
        if (C2200vv.m12039a()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(mo12126g(), 0);
    }

    /* JADX INFO: renamed from: f */
    public void mo11992f() {
        if (this.f13338f != 0) {
            GLES20.glDeleteProgram(this.f13338f);
            this.f13338f = 0;
        }
        if (this.f13341i != 0) {
            GLES20.glDeleteBuffers(1, new int[]{this.f13341i}, 0);
            this.f13341i = 0;
        }
        if (this.f13342j != 0) {
            GLES20.glDeleteBuffers(1, new int[]{this.f13342j}, 0);
            this.f13342j = 0;
        }
        if (this.f13340h != 0) {
            GLES30.glDeleteVertexArrays(1, new int[]{this.f13340h}, 0);
            this.f13340h = 0;
        }
    }

    /* JADX INFO: renamed from: k */
    private boolean m12136k() {
        float[] fArrMo12131h = mo12131h();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArrMo12131h.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArrMo12131h);
        floatBufferAsFloatBuffer.rewind();
        float[] fArrMo12132i = mo12132i();
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(fArrMo12132i.length * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArrMo12132i);
        floatBufferAsFloatBuffer2.rewind();
        int[] iArr = new int[2];
        GLES20.glGenBuffers(2, iArr, 0);
        this.f13341i = iArr[0];
        this.f13342j = iArr[1];
        GLES20.glBindBuffer(34962, this.f13341i);
        GLES20.glBufferData(34962, 32, floatBufferAsFloatBuffer, 35044);
        GLES20.glBindBuffer(34962, this.f13342j);
        GLES20.glBufferData(34962, 32, floatBufferAsFloatBuffer2, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (C2200vv.m12039a()) {
            this.f13340h = C2200vv.m12045d();
            GLES30.glBindVertexArray(this.f13340h);
        }
        m12137l();
        if (C2200vv.m12039a()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        return C2200vv.m12040a("TextureDrawer setup VAO, VBOs.");
    }

    /* JADX INFO: renamed from: l */
    private void m12137l() {
        GLES20.glBindBuffer(34962, this.f13341i);
        GLES20.glEnableVertexAttribArray(this.f13343k);
        GLES20.glVertexAttribPointer(this.f13343k, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.f13342j);
        GLES20.glEnableVertexAttribArray(this.f13344l);
        GLES20.glVertexAttribPointer(this.f13344l, 2, 5126, false, 0, 0);
    }

    /* JADX INFO: renamed from: m */
    private boolean m12138m() {
        String[] strArrMo11987a = mo11987a();
        this.f13338f = C2200vv.m12037a(strArrMo11987a[0], strArrMo11987a[1]);
        return this.f13338f != 0;
    }

    /* JADX INFO: renamed from: c */
    protected boolean mo11989c() {
        this.f13343k = GLES20.glGetAttribLocation(this.f13338f, "a_pos");
        this.f13344l = GLES20.glGetAttribLocation(this.f13338f, "a_tex");
        this.f13345m = GLES20.glGetUniformLocation(this.f13338f, "u_mvp");
        this.f13346n = GLES20.glGetUniformLocation(this.f13338f, "u_tex_trans");
        return C2200vv.m12040a("TextureDrawer glBindAttribLocation");
    }

    /* JADX INFO: renamed from: h */
    protected float[] mo12131h() {
        return this.f13347o;
    }

    /* JADX INFO: renamed from: i */
    protected float[] mo12132i() {
        return this.f13348p;
    }

    /* JADX INFO: renamed from: a */
    protected String[] mo11987a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n"};
    }
}
