package p000;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: renamed from: cn */
/* JADX INFO: compiled from: MatrixUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0799cn {

    /* JADX INFO: renamed from: a */
    public static final Matrix f5349a = new Matrix() { // from class: cn.1
        /* JADX INFO: renamed from: a */
        void m5802a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void reset() {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f, float f2) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2, float f3, float f4) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f, float f2, float f3) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2, float f3, float f4) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2, float f3, float f4) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2) {
            m5802a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2, float f3, float f4) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f, float f2, float f3) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2, float f3, float f4) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2, float f3, float f4) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f, float f2, float f3) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2, float f3, float f4) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            m5802a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            m5802a();
        }
    };
}
