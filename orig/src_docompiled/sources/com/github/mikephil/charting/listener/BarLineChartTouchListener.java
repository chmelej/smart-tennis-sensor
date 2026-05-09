package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleData;
import com.github.mikephil.charting.data.BarLineScatterCandleDataSet;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleData<? extends BarLineScatterCandleDataSet<? extends Entry>>>> {
    private DataSet<?> mClosestDataSetToTouch;
    private PointF mDecelerationCurrentPoint;
    private long mDecelerationLastTime;
    private PointF mDecelerationVelocity;
    private Matrix mMatrix;
    private float mSavedDist;
    private Matrix mSavedMatrix;
    private float mSavedXDist;
    private float mSavedYDist;
    private PointF mTouchPointCenter;
    private PointF mTouchStartPoint;
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleData<? extends BarLineScatterCandleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix) {
        super(barLineChartBase);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mTouchStartPoint = new PointF();
        this.mTouchPointCenter = new PointF();
        this.mSavedXDist = 1.0f;
        this.mSavedYDist = 1.0f;
        this.mSavedDist = 1.0f;
        this.mDecelerationLastTime = 0L;
        this.mDecelerationCurrentPoint = new PointF();
        this.mDecelerationVelocity = new PointF();
        this.mMatrix = matrix;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isDragEnabled() && !((BarLineChartBase) this.mChart).isScaleXEnabled() && !((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            return true;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                stopDeceleration();
                saveTouchStart(motionEvent);
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > Utils.getMinimumFlingVelocity() || Math.abs(yVelocity) > Utils.getMinimumFlingVelocity()) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                    stopDeceleration();
                    this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDecelerationCurrentPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                    this.mDecelerationVelocity = new PointF(xVelocity, yVelocity);
                    Utils.postInvalidateOnAnimation(this.mChart);
                }
                this.mTouchMode = 0;
                ((BarLineChartBase) this.mChart).enableScroll();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
                break;
            case 2:
                if (this.mTouchMode == 1) {
                    ((BarLineChartBase) this.mChart).disableScroll();
                    performDrag(motionEvent);
                } else if (this.mTouchMode == 2 || this.mTouchMode == 3 || this.mTouchMode == 4) {
                    ((BarLineChartBase) this.mChart).disableScroll();
                    if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                        performZoom(motionEvent);
                    }
                } else if (this.mTouchMode == 0 && Math.abs(distance(motionEvent.getX(), this.mTouchStartPoint.x, motionEvent.getY(), this.mTouchStartPoint.y)) > 5.0f) {
                    if (((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                        if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                            this.mTouchMode = 1;
                        } else if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                            performHighlightDrag(motionEvent);
                        }
                    } else if (((BarLineChartBase) this.mChart).isDragEnabled()) {
                        this.mTouchMode = 1;
                    }
                }
                break;
            case 3:
                this.mTouchMode = 0;
                break;
            case 5:
                if (motionEvent.getPointerCount() >= 2) {
                    ((BarLineChartBase) this.mChart).disableScroll();
                    saveTouchStart(motionEvent);
                    this.mSavedXDist = getXDist(motionEvent);
                    this.mSavedYDist = getYDist(motionEvent);
                    this.mSavedDist = spacing(motionEvent);
                    if (this.mSavedDist > 10.0f) {
                        if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                            this.mTouchMode = 4;
                        } else if (this.mSavedXDist > this.mSavedYDist) {
                            this.mTouchMode = 2;
                        } else {
                            this.mTouchMode = 3;
                        }
                    }
                    midPoint(this.mTouchPointCenter, motionEvent);
                }
                break;
            case 6:
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.mVelocityTracker);
                this.mTouchMode = 5;
                break;
        }
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        return true;
    }

    private void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.set(motionEvent.getX(), motionEvent.getY());
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    private void performDrag(MotionEvent motionEvent) {
        float x;
        float y;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (((BarLineChartBase) this.mChart).isAnyAxisInverted() && this.mClosestDataSetToTouch != null && ((BarLineChartBase) this.mChart).getAxis(this.mClosestDataSetToTouch.getAxisDependency()).isInverted()) {
            if (this.mChart instanceof HorizontalBarChart) {
                x = -(motionEvent.getX() - this.mTouchStartPoint.x);
                y = motionEvent.getY() - this.mTouchStartPoint.y;
            } else {
                x = motionEvent.getX() - this.mTouchStartPoint.x;
                y = -(motionEvent.getY() - this.mTouchStartPoint.y);
            }
        } else {
            x = motionEvent.getX() - this.mTouchStartPoint.x;
            y = motionEvent.getY() - this.mTouchStartPoint.y;
        }
        this.mMatrix.postTranslate(x, y);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, x, y);
        }
    }

    private void performZoom(MotionEvent motionEvent) {
        boolean zCanZoomInMoreX;
        boolean zCanZoomInMoreX2;
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float fSpacing = spacing(motionEvent);
            if (fSpacing > 10.0f) {
                PointF trans = getTrans(this.mTouchPointCenter.x, this.mTouchPointCenter.y);
                if (this.mTouchMode == 4) {
                    float f = fSpacing / this.mSavedDist;
                    if (f < 1.0f) {
                        zCanZoomInMoreX2 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX();
                    } else {
                        zCanZoomInMoreX2 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    }
                    float f2 = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? f : 1.0f;
                    if (!((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                        f = 1.0f;
                    }
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled() || zCanZoomInMoreX2) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(f2, f, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f2, f);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.mTouchMode == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    float xDist = getXDist(motionEvent) / this.mSavedXDist;
                    if (xDist < 1.0f) {
                        zCanZoomInMoreX = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX();
                    } else {
                        zCanZoomInMoreX = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    }
                    if (zCanZoomInMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(xDist, 1.0f, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, xDist, 1.0f);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    float yDist = getYDist(motionEvent) / this.mSavedYDist;
                    this.mMatrix.set(this.mSavedMatrix);
                    this.mMatrix.postScale(1.0f, yDist, trans.x, trans.y);
                    if (onChartGestureListener != null) {
                        onChartGestureListener.onChartScale(motionEvent, 1.0f, yDist);
                    }
                }
            }
        }
    }

    private void performHighlight(MotionEvent motionEvent) {
        System.out.println("----------------performHighlight-------------------");
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            ((BarLineChartBase) this.mChart).highlightTouch(null);
            this.mLastHighlighted = null;
        } else {
            this.mLastHighlighted = highlightByTouchPoint;
            ((BarLineChartBase) this.mChart).highlightTouch(highlightByTouchPoint);
        }
    }

    private void performHighlightDrag(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            return;
        }
        this.mLastHighlighted = highlightByTouchPoint;
        ((BarLineChartBase) this.mChart).highlightTouch(highlightByTouchPoint);
    }

    private static void midPoint(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    private static float spacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private static float getXDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float getYDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public PointF getTrans(float f, float f2) {
        float f3;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float fOffsetLeft = f - viewPortHandler.offsetLeft();
        if (((BarLineChartBase) this.mChart).isAnyAxisInverted() && this.mClosestDataSetToTouch != null && ((BarLineChartBase) this.mChart).isInverted(this.mClosestDataSetToTouch.getAxisDependency())) {
            f3 = -(f2 - viewPortHandler.offsetTop());
        } else {
            f3 = -((((BarLineChartBase) this.mChart).getMeasuredHeight() - f2) - viewPortHandler.offsetBottom());
        }
        return new PointF(fOffsetLeft, f3);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
            return super.onDoubleTap(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled()) {
            PointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            ((BarLineChartBase) this.mChart).zoom(((BarLineChartBase) this.mChart).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.mChart).isScaleYEnabled() ? 1.4f : 1.0f, trans.x, trans.y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.x + ", y: " + trans.y);
            }
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        performHighlight(motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        return super.onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void stopDeceleration() {
        this.mDecelerationVelocity = new PointF(0.0f, 0.0f);
    }

    public void computeScroll() {
        if (this.mDecelerationVelocity.x == 0.0f && this.mDecelerationVelocity.y == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationVelocity.x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        this.mDecelerationVelocity.y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        float f = (jCurrentAnimationTimeMillis - this.mDecelerationLastTime) / 1000.0f;
        float f2 = this.mDecelerationVelocity.x * f;
        float f3 = this.mDecelerationVelocity.y * f;
        this.mDecelerationCurrentPoint.x += f2;
        this.mDecelerationCurrentPoint.y += f3;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, this.mDecelerationCurrentPoint.x, this.mDecelerationCurrentPoint.y, 0);
        performDrag(motionEventObtain);
        motionEventObtain.recycle();
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
        this.mDecelerationLastTime = jCurrentAnimationTimeMillis;
        if (Math.abs(this.mDecelerationVelocity.x) >= 0.01d || Math.abs(this.mDecelerationVelocity.y) >= 0.01d) {
            Utils.postInvalidateOnAnimation(this.mChart);
        } else {
            stopDeceleration();
        }
    }
}
