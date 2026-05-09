package p000;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.shortvideo.p013gl.texread.GlUtil;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import p000.C2225wt;

/* JADX INFO: renamed from: ws */
/* JADX INFO: compiled from: Texture2DYuvReader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2224ws {

    /* JADX INFO: renamed from: a */
    private static final FloatBuffer f13363a = GlUtil.m8637a(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});

    /* JADX INFO: renamed from: c */
    private final C2222wq f13365c;

    /* JADX INFO: renamed from: d */
    private final C2221wp f13366d;

    /* JADX INFO: renamed from: e */
    private final int f13367e;

    /* JADX INFO: renamed from: f */
    private final int f13368f;

    /* JADX INFO: renamed from: g */
    private final int f13369g;

    /* JADX INFO: renamed from: h */
    private int f13370h;

    /* JADX INFO: renamed from: k */
    private ByteBuffer f13373k;

    /* JADX INFO: renamed from: l */
    private ByteBuffer f13374l;

    /* JADX INFO: renamed from: m */
    private int f13375m;

    /* JADX INFO: renamed from: n */
    private int f13376n;

    /* JADX INFO: renamed from: o */
    private int f13377o;

    /* JADX INFO: renamed from: p */
    private int f13378p;

    /* JADX INFO: renamed from: b */
    private FloatBuffer f13364b = GlUtil.m8637a(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});

    /* JADX INFO: renamed from: i */
    private final C2225wt.a f13371i = new C2225wt.a();

    /* JADX INFO: renamed from: j */
    private boolean f13372j = false;

    public C2224ws(int i, int i2) {
        this.f13375m = i;
        this.f13377o = i;
        this.f13376n = i2;
        this.f13378p = i2;
        this.f13371i.m12164a();
        this.f13365c = new C2222wq(6408);
        this.f13366d = new C2221wp("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
        this.f13366d.m12153a();
        this.f13367e = this.f13366d.m12155b("texMatrix");
        this.f13368f = this.f13366d.m12155b("xUnit");
        this.f13369g = this.f13366d.m12155b("coeffs");
        GLES20.glUniform1i(this.f13366d.m12155b("oesTex"), 0);
        GlUtil.m8638a("Initialize fragment shader uniform values.");
    }

    @TargetApi(18)
    /* JADX INFO: renamed from: a */
    public ByteBuffer m12162a(int i) {
        int i2;
        int i3;
        int i4;
        this.f13371i.m12164a();
        if (this.f13372j) {
            throw new IllegalStateException("YuvReader.read called on released object");
        }
        int i5 = this.f13377o;
        if (i5 % 8 != 0) {
            throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
        }
        if (i5 < this.f13377o) {
            throw new IllegalArgumentException("Invalid stride, must >= width");
        }
        this.f13366d.m12153a();
        this.f13366d.m12154a("in_pos", 2, f13363a);
        this.f13366d.m12154a("in_tc", 2, this.f13364b);
        int i6 = (this.f13377o + 3) / 4;
        int i7 = (this.f13377o + 7) / 8;
        int i8 = (this.f13378p + 1) / 2;
        int i9 = this.f13378p + i8;
        float[] fArrM12161a = C2223wr.m12161a(GlUtil.f9042a, C2223wr.m12160a());
        int i10 = i5 / 4;
        this.f13365c.m12158a(i10, i9);
        GLES20.glBindFramebuffer(36160, this.f13365c.m12157a());
        GlUtil.m8638a("glBindFramebuffer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniformMatrix4fv(this.f13367e, 1, false, fArrM12161a, 0);
        GLES20.glViewport(0, 0, i6, this.f13378p);
        GLES20.glUniform2f(this.f13368f, fArrM12161a[0] / this.f13377o, fArrM12161a[1] / this.f13377o);
        GLES20.glUniform4f(this.f13369g, 0.299f, 0.587f, 0.114f, 0.0f);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(0, this.f13378p, i7, i8);
        GLES20.glUniform2f(this.f13368f, (fArrM12161a[0] * 2.0f) / this.f13377o, (fArrM12161a[1] * 2.0f) / this.f13377o);
        GLES20.glUniform4f(this.f13369g, -0.169f, -0.331f, 0.499f, 0.5f);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(i5 / 8, this.f13378p, i7, i8);
        GLES20.glUniform4f(this.f13369g, 0.499f, -0.418f, -0.0813f, 0.5f);
        GLES20.glDrawArrays(5, 0, 4);
        if (GlUtil.m8639a()) {
            if (this.f13370h == 0) {
                this.f13370h = GlUtil.m8640b(((this.f13377o * this.f13378p) * 3) / 2);
            }
            GLES20.glBindBuffer(35051, this.f13370h);
            i3 = 0;
            i2 = 3553;
            i4 = 36160;
            GlUtil.read(0, 0, i10, i9, 6408, 5121, 0);
            this.f13373k = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, ((this.f13377o * this.f13378p) * 3) / 2, 1);
        } else {
            i2 = 3553;
            i3 = 0;
            i4 = 36160;
            if (this.f13373k == null) {
                this.f13373k = ByteBuffer.allocate(((this.f13377o * this.f13378p) * 3) / 2);
            }
            this.f13373k.clear();
            GLES20.glReadPixels(0, 0, i10, i9, 6408, 5121, this.f13373k);
        }
        GlUtil.m8638a("YuvReader.read");
        if (this.f13374l == null) {
            this.f13374l = ByteBuffer.allocate(((this.f13377o * this.f13378p) * 3) / 2);
        }
        this.f13374l.clear();
        if (this.f13373k != null) {
            this.f13373k.clear();
            this.f13373k.position(i3);
            this.f13373k.limit(this.f13377o * this.f13378p);
            this.f13374l.put(this.f13373k);
            for (int i11 = this.f13378p; i11 < (this.f13378p * 3) / 2; i11++) {
                this.f13373k.clear();
                int i12 = i11 * i5;
                this.f13373k.position(i12);
                this.f13373k.limit(i12 + (i5 / 2));
                this.f13374l.put(this.f13373k);
            }
            for (int i13 = this.f13378p; i13 < (this.f13378p * 3) / 2; i13++) {
                this.f13373k.clear();
                int i14 = i5 / 2;
                int i15 = (i13 * i5) + i14;
                this.f13373k.position(i15);
                this.f13373k.limit(i15 + i14);
                this.f13374l.put(this.f13373k);
            }
            this.f13374l.clear();
        }
        if (GlUtil.m8639a()) {
            GLES30.glUnmapBuffer(35051);
            GLES20.glBindBuffer(35051, i3);
        }
        GLES20.glBindFramebuffer(i4, i3);
        GLES20.glBindTexture(i2, i3);
        return this.f13374l;
    }

    /* JADX INFO: renamed from: a */
    public void m12163a() {
        this.f13371i.m12164a();
        this.f13372j = true;
        this.f13366d.m12156b();
        this.f13365c.m12159b();
    }
}
