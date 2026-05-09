package p000;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.p013gl.texread.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: wp */
/* JADX INFO: compiled from: GlShader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2221wp {

    /* JADX INFO: renamed from: a */
    private int f13354a;

    /* JADX INFO: renamed from: b */
    private int f13355b;

    /* JADX INFO: renamed from: c */
    private int f13356c = GLES20.glCreateProgram();

    /* JADX INFO: renamed from: a */
    private static int m12151a(int i, String str) {
        int[] iArr = {0};
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            throw new RuntimeException(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        GlUtil.m8638a("compileShader");
        return iGlCreateShader;
    }

    public C2221wp(String str, String str2) {
        this.f13354a = m12151a(35633, str);
        this.f13355b = m12151a(35632, str2);
        if (this.f13356c == 0) {
            throw new RuntimeException("Could not create program");
        }
        GLES20.glAttachShader(this.f13356c, this.f13354a);
        GLES20.glAttachShader(this.f13356c, this.f13355b);
        GLES20.glLinkProgram(this.f13356c);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.f13356c, 35714, iArr, 0);
        if (iArr[0] != 1) {
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.f13356c));
        }
        GlUtil.m8638a("Creating GlShader");
    }

    /* JADX INFO: renamed from: a */
    public int m12152a(String str) {
        if (this.f13356c == -1) {
            throw new RuntimeException("The program has been released");
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f13356c, str);
        if (iGlGetAttribLocation >= 0) {
            return iGlGetAttribLocation;
        }
        throw new RuntimeException("Could not locate '" + str + "' in program");
    }

    /* JADX INFO: renamed from: a */
    public void m12154a(String str, int i, FloatBuffer floatBuffer) {
        if (this.f13356c == -1) {
            throw new RuntimeException("The program has been released");
        }
        int iM12152a = m12152a(str);
        GLES20.glEnableVertexAttribArray(iM12152a);
        GLES20.glVertexAttribPointer(iM12152a, i, 5126, false, 0, (Buffer) floatBuffer);
        GlUtil.m8638a("setVertexAttribArray");
    }

    /* JADX INFO: renamed from: b */
    public int m12155b(String str) {
        if (this.f13356c == -1) {
            throw new RuntimeException("The program has been released");
        }
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f13356c, str);
        if (iGlGetUniformLocation >= 0) {
            return iGlGetUniformLocation;
        }
        throw new RuntimeException("Could not locate uniform '" + str + "' in program");
    }

    /* JADX INFO: renamed from: a */
    public void m12153a() {
        if (this.f13356c == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(this.f13356c);
        GlUtil.m8638a("glUseProgram");
    }

    /* JADX INFO: renamed from: b */
    public void m12156b() {
        if (this.f13354a != -1) {
            GLES20.glDeleteShader(this.f13354a);
            this.f13354a = -1;
        }
        if (this.f13355b != -1) {
            GLES20.glDeleteShader(this.f13355b);
            this.f13355b = -1;
        }
        if (this.f13356c != -1) {
            GLES20.glDeleteProgram(this.f13356c);
            this.f13356c = -1;
        }
    }
}
