package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewPortHandler {
    protected final Matrix mMatrixTouch = new Matrix();
    protected RectF mContentRect = new RectF();
    protected float mChartWidth = 0.0f;
    protected float mChartHeight = 0.0f;
    private float mMinScaleY = 1.0f;
    private float mMinScaleX = 1.0f;
    private float mMaxScaleX = Float.MAX_VALUE;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mTransOffsetX = 0.0f;
    private float mTransOffsetY = 0.0f;

    public void setChartDimens(float f, float f2) {
        float fOffsetLeft = offsetLeft();
        float fOffsetTop = offsetTop();
        float fOffsetRight = offsetRight();
        float fOffsetBottom = offsetBottom();
        this.mChartHeight = f2;
        this.mChartWidth = f;
        restrainViewPort(fOffsetLeft, fOffsetTop, fOffsetRight, fOffsetBottom);
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public void restrainViewPort(float f, float f2, float f3, float f4) {
        this.mContentRect.set(f, f2, this.mChartWidth - f3, this.mChartHeight - f4);
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public PointF getContentCenter() {
        return new PointF(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public Matrix zoomIn(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f, f2);
        return matrix;
    }

    public Matrix zoomOut(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f, f2);
        return matrix;
    }

    public Matrix zoom(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f, f2, f3, f4);
        return matrix;
    }

    public Matrix fitScreen() {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        matrix.getValues(fArr);
        matrix.setValues(fArr);
        return matrix;
    }

    public synchronized void centerViewPort(float[] fArr, View view) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public Matrix refresh(Matrix matrix, View view, boolean z) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float fHeight;
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[0];
        float f3 = fArr[5];
        float f4 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f2), this.mMaxScaleX);
        this.mScaleY = Math.max(this.mMinScaleY, f4);
        float fWidth = 0.0f;
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fHeight = 0.0f;
        }
        float fMin = Math.min(Math.max(f, ((-fWidth) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float fMax = Math.max(Math.min(f3, (fHeight * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        fArr[2] = fMin;
        fArr[0] = this.mScaleX;
        fArr[5] = fMax;
        fArr[4] = this.mScaleY;
        matrix.setValues(fArr);
    }

    public void setMinimumScaleX(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.mMinScaleX = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleX(float f) {
        this.mMaxScaleX = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.mMinScaleX = f;
        this.mMaxScaleX = f2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.mMinScaleY = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public boolean isInBoundsX(float f) {
        return isInBoundsLeft(f) && isInBoundsRight(f);
    }

    public boolean isInBoundsY(float f) {
        return isInBoundsTop(f) && isInBoundsBottom(f);
    }

    public boolean isInBounds(float f, float f2) {
        return isInBoundsX(f) && isInBoundsY(f2);
    }

    public boolean isInBoundsLeft(float f) {
        return this.mContentRect.left <= f;
    }

    public boolean isInBoundsRight(float f) {
        return this.mContentRect.right >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsTop(float f) {
        return this.mContentRect.top <= f;
    }

    public boolean isInBoundsBottom(float f) {
        return this.mContentRect.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutY() {
        return this.mScaleY <= this.mMinScaleY && this.mMinScaleY <= 1.0f;
    }

    public boolean isFullyZoomedOutX() {
        return this.mScaleX <= this.mMinScaleX && this.mMinScaleX <= 1.0f;
    }

    public void setDragOffsetX(float f) {
        this.mTransOffsetX = Utils.convertDpToPixel(f);
    }

    public void setDragOffsetY(float f) {
        this.mTransOffsetY = Utils.convertDpToPixel(f);
    }

    public boolean hasNoDragOffset() {
        return this.mTransOffsetX <= 0.0f && this.mTransOffsetY <= 0.0f;
    }

    public boolean canZoomOutMoreX() {
        return this.mScaleX > this.mMinScaleX;
    }

    public boolean canZoomInMoreX() {
        return this.mScaleX < this.mMaxScaleX;
    }
}
