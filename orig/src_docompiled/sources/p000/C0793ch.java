package p000;

import android.animation.TypeEvaluator;

/* JADX INFO: renamed from: ch */
/* JADX INFO: compiled from: FloatArrayEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class C0793ch implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: a */
    private float[] f5328a;

    public C0793ch(float[] fArr) {
        this.f5328a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f5328a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }
}
