package p000;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: TextureRenderer.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class ajx {

    /* JADX INFO: renamed from: a */
    private static final float[] f1389a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: e */
    private int f1393e;

    /* JADX INFO: renamed from: g */
    private int f1395g;

    /* JADX INFO: renamed from: h */
    private int f1396h;

    /* JADX INFO: renamed from: i */
    private int f1397i;

    /* JADX INFO: renamed from: j */
    private int f1398j;

    /* JADX INFO: renamed from: k */
    private int f1399k;

    /* JADX INFO: renamed from: c */
    private float[] f1391c = new float[16];

    /* JADX INFO: renamed from: d */
    private float[] f1392d = new float[16];

    /* JADX INFO: renamed from: f */
    private int f1394f = -12345;

    /* JADX INFO: renamed from: b */
    private FloatBuffer f1390b = ByteBuffer.allocateDirect(f1389a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public ajx(int i) {
        this.f1399k = 0;
        this.f1399k = i;
        this.f1390b.put(f1389a).position(0);
        Matrix.setIdentityM(this.f1392d, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m1665a() {
        return this.f1394f;
    }

    /* JADX INFO: renamed from: a */
    public void m1666a(SurfaceTexture surfaceTexture, boolean z) {
        m1667a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f1392d);
        if (z) {
            this.f1392d[5] = -this.f1392d[5];
            this.f1392d[13] = 1.0f - this.f1392d[13];
        }
        GLES20.glUseProgram(this.f1393e);
        m1667a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f1394f);
        this.f1390b.position(0);
        GLES20.glVertexAttribPointer(this.f1397i, 3, 5126, false, 20, (Buffer) this.f1390b);
        m1667a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f1397i);
        m1667a("glEnableVertexAttribArray maPositionHandle");
        this.f1390b.position(3);
        GLES20.glVertexAttribPointer(this.f1398j, 2, 5126, false, 20, (Buffer) this.f1390b);
        m1667a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f1398j);
        m1667a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f1396h, 1, false, this.f1392d, 0);
        GLES20.glUniformMatrix4fv(this.f1395g, 1, false, this.f1391c, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m1667a("glDrawArrays");
        GLES20.glFinish();
    }

    /* JADX INFO: renamed from: b */
    public void m1668b() {
        this.f1393e = m1664a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        if (this.f1393e == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.f1397i = GLES20.glGetAttribLocation(this.f1393e, "aPosition");
        m1667a("glGetAttribLocation aPosition");
        if (this.f1397i == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f1398j = GLES20.glGetAttribLocation(this.f1393e, "aTextureCoord");
        m1667a("glGetAttribLocation aTextureCoord");
        if (this.f1398j == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f1395g = GLES20.glGetUniformLocation(this.f1393e, "uMVPMatrix");
        m1667a("glGetUniformLocation uMVPMatrix");
        if (this.f1395g == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.f1396h = GLES20.glGetUniformLocation(this.f1393e, "uSTMatrix");
        m1667a("glGetUniformLocation uSTMatrix");
        if (this.f1396h == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f1394f = iArr[0];
        GLES20.glBindTexture(36197, this.f1394f);
        m1667a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        m1667a("glTexParameter");
        Matrix.setIdentityM(this.f1391c, 0);
        if (this.f1399k != 0) {
            Matrix.rotateM(this.f1391c, 0, this.f1399k, 0.0f, 0.0f, 1.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1663a(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        m1667a("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private int m1664a(String str, String str2) {
        int iM1663a;
        int iM1663a2 = m1663a(35633, str);
        if (iM1663a2 == 0 || (iM1663a = m1663a(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m1667a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iM1663a2);
        m1667a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM1663a);
        m1667a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public void m1667a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            throw new RuntimeException(str + ": glError " + iGlGetError);
        }
    }
}
