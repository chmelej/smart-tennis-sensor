package p000;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: renamed from: ab */
/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class C0004ab implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a */
    private final float[] f88a = new float[9];

    /* JADX INFO: renamed from: b */
    private final float[] f89b = new float[9];

    /* JADX INFO: renamed from: c */
    private final Matrix f90c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f88a);
        matrix2.getValues(this.f89b);
        for (int i = 0; i < 9; i++) {
            this.f89b[i] = this.f88a[i] + ((this.f89b[i] - this.f88a[i]) * f);
        }
        this.f90c.setValues(this.f89b);
        return this.f90c;
    }
}
