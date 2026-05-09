package p000;

import android.graphics.Matrix;
import android.support.transition.R;
import android.view.View;

/* JADX INFO: renamed from: dp */
/* JADX INFO: compiled from: ViewUtilsBase.java */
/* JADX INFO: loaded from: classes.dex */
class C1668dp {

    /* JADX INFO: renamed from: a */
    private float[] f9418a;

    C1668dp() {
    }

    /* JADX INFO: renamed from: a */
    public void mo8879a(View view, float f) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: renamed from: a */
    public float mo8878a(View view) {
        Float f = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    /* JADX INFO: renamed from: b */
    public void mo8880b(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo8881c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo8885a(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo8885a((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    /* JADX INFO: renamed from: b */
    public void mo8886b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            mo8886b((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo8887c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f9418a;
        if (fArr == null) {
            fArr = new float[9];
            this.f9418a = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f, fSqrt));
        float f2 = fArr[0] / fSqrt;
        float f3 = fArr[4] / fSqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    /* JADX INFO: renamed from: a */
    public void mo8889a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
