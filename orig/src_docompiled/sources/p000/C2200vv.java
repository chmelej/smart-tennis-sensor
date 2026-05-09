package p000;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: vv */
/* JADX INFO: compiled from: GLUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2200vv {

    /* JADX INFO: renamed from: a */
    public static final Object f13206a = new Object();

    /* JADX INFO: renamed from: b */
    public static float[] f13207b = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: c */
    public static float[] f13208c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: d */
    public static float[] f13209d = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* JADX INFO: renamed from: e */
    public static final float[] f13210e = new float[16];

    /* JADX INFO: renamed from: f */
    private static int f13211f = 2;

    static {
        Matrix.setIdentityM(f13210e, 0);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m12039a() {
        return f13211f > 2;
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: b */
    public static boolean m12042b() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        try {
            EGL14.eglGetCurrentContext();
            return true;
        } catch (NoClassDefFoundError unused) {
            Log.i("GLUtils", "EGL14 isn't supported on this platform, change to use EGL10.");
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m12044c() {
        return m12041a(1)[0];
    }

    /* JADX INFO: renamed from: a */
    public static int[] m12041a(int i) {
        int[] iArr = new int[i];
        GLES20.glGenTextures(i, iArr, 0);
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public static int m12037a(String str, String str2) {
        int iM12036a = m12036a(35633, str);
        int iM12036a2 = m12036a(35632, str2);
        if (iM12036a == 0 || iM12036a2 == 0) {
            return -1;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iM12036a);
        GLES20.glAttachShader(iGlCreateProgram, iM12036a2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(iGlCreateProgram);
            Log.d("GLUtils", "Linking of program failed !");
            return -1;
        }
        if (m12043b(iGlCreateProgram)) {
            return iGlCreateProgram;
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m12043b(int i) {
        GLES20.glValidateProgram(i);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i, 35715, iArr, 0);
        Log.d("GLUtils", "Results of validating program: " + iArr[0] + "\nLog:" + GLES20.glGetProgramInfoLog(i));
        return iArr[0] != 0;
    }

    /* JADX INFO: renamed from: a */
    private static int m12036a(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        Log.e("GLUtils", "Compilation of shader failed.");
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m12040a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return true;
        }
        Log.e("GLUtils", str + ": glError 0x" + Integer.toHexString(iGlGetError));
        return false;
    }

    @TargetApi(18)
    /* JADX INFO: renamed from: d */
    public static int m12045d() {
        int[] iArr = new int[1];
        GLES30.glGenVertexArrays(1, iArr, 0);
        return iArr[0];
    }

    /* JADX INFO: renamed from: e */
    public static int m12046e() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    /* JADX INFO: renamed from: a */
    public static int m12038a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        m12040a("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        m12040a("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        m12040a("loadImageTexture");
        return i4;
    }
}
