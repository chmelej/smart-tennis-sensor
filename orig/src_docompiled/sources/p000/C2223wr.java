package p000;

import android.opengl.Matrix;

/* JADX INFO: renamed from: wr */
/* JADX INFO: compiled from: RendererCommon.java */
/* JADX INFO: loaded from: classes.dex */
public class C2223wr {

    /* JADX INFO: renamed from: a */
    private static float f13362a = 0.5625f;

    /* JADX INFO: renamed from: a */
    public static final float[] m12160a() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }

    /* JADX INFO: renamed from: a */
    public static float[] m12161a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
        return fArr3;
    }
}
