package com.qiniu.pili.droid.shortvideo.p013gl.texread;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes.dex */
public class GlUtil {

    /* JADX INFO: renamed from: a */
    public static final float[] f9042a = new float[16];

    /* JADX INFO: renamed from: b */
    private static int f9043b = 2;

    public static native void read(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    static {
        Matrix.setIdentityM(f9042a, 0);
    }

    /* JADX INFO: renamed from: a */
    public static void m8638a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            throw new RuntimeException(str + ": GLES20 error: " + iGlGetError);
        }
    }

    /* JADX INFO: renamed from: a */
    public static FloatBuffer m8637a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    /* JADX INFO: renamed from: a */
    public static int m8636a(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(i, i2);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameterf(i, 10242, 33071.0f);
        GLES20.glTexParameterf(i, 10243, 33071.0f);
        m8638a("generateTexture");
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8639a() {
        return f9043b > 2;
    }

    @TargetApi(18)
    /* JADX INFO: renamed from: b */
    public static int m8640b(int i) {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(35051, iArr[0]);
        GLES20.glBufferData(35051, i, null, 35049);
        GLES20.glBindBuffer(35051, 0);
        return iArr[0];
    }
}
