package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;

/* JADX INFO: loaded from: classes.dex */
public class ScaledImageView extends ImageView implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.dragScrollMinDistSquare = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare *= this.dragScrollMinDistSquare;
        setOnTouchListener(this);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        setImageBitmap(bitmap);
        int[] iArr = {getWidth(), getHeight()};
        int[] iArrFixRect = BitmapHelper.fixRect(new int[]{this.bitmap.getWidth(), this.bitmap.getHeight()}, iArr);
        int[] iArr2 = {(iArr[0] - iArrFixRect[0]) / 2, (iArr[1] - iArrFixRect[1]) / 2};
        float[] fArr = {iArrFixRect[0] / r1[0], iArrFixRect[1] / r1[1]};
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(fArr[0], fArr[1]);
        this.matrix.postTranslate(iArr2[0], iArr2[1]);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        if (this.matrix != null) {
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    this.matrix = new Matrix();
                    this.matrix.set(getImageMatrix());
                    this.savedMatrix = new Matrix();
                    this.savedMatrix.set(this.matrix);
                    this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                    this.mode = 1;
                    break;
                case 1:
                    if (this.listener != null) {
                        this.listener.onMactrixChage(this.matrix);
                    }
                    float x = motionEvent.getX(0) - this.downPoint[0];
                    float y = motionEvent.getY(0) - this.downPoint[1];
                    if (this.mode == 1 && (x * x) + (y * y) <= this.dragScrollMinDistSquare) {
                        performClick();
                    }
                    this.mode = 0;
                    break;
                case 2:
                    if (this.mode == 1) {
                        float[] fArr = {motionEvent.getX(0), motionEvent.getY(0)};
                        this.matrix.set(this.savedMatrix);
                        this.matrix.postTranslate(fArr[0] - this.downPoint[0], fArr[1] - this.downPoint[1]);
                    } else if (this.mode == 2) {
                        float[] fArr2 = {motionEvent.getX(1), motionEvent.getY(1)};
                        this.matrix.set(this.savedMatrix);
                        this.matrix.postTranslate(fArr2[0] - this.downPoint[0], fArr2[1] - this.downPoint[1]);
                    } else if (this.mode == 3) {
                        float[] fArr3 = {motionEvent.getX(0), motionEvent.getY(0)};
                        float[] fArr4 = {motionEvent.getX(1), motionEvent.getY(1)};
                        float f = fArr3[0] - fArr4[0];
                        float f2 = fArr3[1] - fArr4[1];
                        this.matrix.set(this.savedMatrix);
                        float fSqrt = (float) Math.sqrt(((f * f) + (f2 * f2)) / this.distSquare);
                        float[] fArr5 = {(fArr3[0] + fArr4[0]) / 2.0f, (fArr3[1] + fArr4[1]) / 2.0f};
                        this.matrix.postScale(fSqrt, fSqrt, fArr5[0], fArr5[1]);
                    }
                    break;
                case 5:
                    float[] fArr6 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float[] fArr7 = {motionEvent.getX(1), motionEvent.getY(1)};
                    float f3 = fArr6[0] - fArr7[0];
                    float f4 = fArr6[1] - fArr7[1];
                    this.distSquare = (f3 * f3) + (f4 * f4);
                    this.mode = 3;
                    break;
                case 6:
                    this.downPoint = new float[]{motionEvent.getX(1), motionEvent.getY(1)};
                    this.savedMatrix.set(this.matrix);
                    this.mode = 2;
                    break;
                case 261:
                    float[] fArr8 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float[] fArr9 = {motionEvent.getX(1), motionEvent.getY(1)};
                    float f5 = fArr8[0] - fArr9[0];
                    float f6 = fArr8[1] - fArr9[1];
                    this.distSquare = (f5 * f5) + (f6 * f6);
                    this.mode = 3;
                    break;
                case 262:
                    this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                    this.savedMatrix.set(this.matrix);
                    this.mode = 1;
                    break;
                default:
                    return false;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            this.matrix = new Matrix();
            float[] fArr = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            this.matrix.setValues(fArr);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.bitmap, 0, 0, this.bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            this.matrix = new Matrix();
            this.matrix.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    public void rotateRight() {
        try {
            this.matrix = new Matrix();
            float[] fArr = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            this.matrix.setValues(fArr);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.bitmap, 0, 0, this.bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            this.matrix = new Matrix();
            this.matrix.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    public void zoomIn() {
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap bitmapCaptureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (bitmapCaptureView == null) {
                MobLog.getInstance().m8621w("ivPhoto.getDrawingCache() returns null", new Object[0]);
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCaptureView, rect.left, rect.top, rect.width(), rect.height());
            bitmapCaptureView.recycle();
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }
}
