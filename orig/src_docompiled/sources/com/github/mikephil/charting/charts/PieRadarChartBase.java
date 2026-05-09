package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends DataSet<? extends Entry>>> extends Chart<T> {
    private float mRawRotationAngle;
    protected boolean mRotateEnabled;
    private float mRotationAngle;

    public abstract int getIndexForAngle(float f);

    public abstract float getRadius();

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredBottomOffset();

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    public PieRadarChartBase(Context context) {
        super(context);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        this.mDeltaX = this.mData.getXVals().size() - 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchEnabled && this.mChartTouchListener != null) {
            return this.mChartTouchListener.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mChartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) this.mChartTouchListener).computeScroll();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mDataNotSet) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calculateOffsets() {
        float requiredBaseOffset;
        float requiredBaseOffset2;
        float fMin;
        float fConvertDpToPixel;
        float f;
        float fConvertDpToPixel2;
        float f2 = 0.0f;
        if (this.mLegend == null || !this.mLegend.isEnabled()) {
            requiredBaseOffset = 0.0f;
            requiredBaseOffset2 = 0.0f;
            fMin = 0.0f;
        } else {
            float fMin2 = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getFormSize() + this.mLegend.getFormToTextSpace();
            if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART_CENTER) {
                fConvertDpToPixel2 = fMin2 + Utils.convertDpToPixel(13.0f);
            } else if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART) {
                fConvertDpToPixel2 = fMin2 + Utils.convertDpToPixel(8.0f);
                float f3 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
                PointF center = getCenter();
                PointF pointF = new PointF((getWidth() - fConvertDpToPixel2) + 15.0f, f3 + 15.0f);
                float fDistanceToCenter = distanceToCenter(pointF.x, pointF.y);
                PointF position = getPosition(center, getRadius(), getAngleForPoint(pointF.x, pointF.y));
                float fDistanceToCenter2 = distanceToCenter(position.x, position.y);
                float fConvertDpToPixel3 = fDistanceToCenter < fDistanceToCenter2 ? Utils.convertDpToPixel(5.0f) + (fDistanceToCenter2 - fDistanceToCenter) : 0.0f;
                if (pointF.y < center.y || getHeight() - fConvertDpToPixel2 <= getWidth()) {
                    fConvertDpToPixel2 = fConvertDpToPixel3;
                }
            } else {
                if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART_CENTER) {
                    fConvertDpToPixel = fMin2 + Utils.convertDpToPixel(13.0f);
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART) {
                    fConvertDpToPixel = fMin2 + Utils.convertDpToPixel(8.0f);
                    float f4 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
                    PointF center2 = getCenter();
                    PointF pointF2 = new PointF(fConvertDpToPixel - 15.0f, f4 + 15.0f);
                    float fDistanceToCenter3 = distanceToCenter(pointF2.x, pointF2.y);
                    PointF position2 = getPosition(center2, getRadius(), getAngleForPoint(pointF2.x, pointF2.y));
                    float fDistanceToCenter4 = distanceToCenter(position2.x, position2.y);
                    float fConvertDpToPixel4 = fDistanceToCenter3 < fDistanceToCenter4 ? Utils.convertDpToPixel(5.0f) + (fDistanceToCenter4 - fDistanceToCenter3) : 0.0f;
                    if (pointF2.y < center2.y || getHeight() - fConvertDpToPixel <= getWidth()) {
                        fConvertDpToPixel = fConvertDpToPixel4;
                    }
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_LEFT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_RIGHT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_CENTER) {
                    fMin = Math.min(this.mLegend.mNeededHeight + getRequiredBottomOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                    fConvertDpToPixel = 0.0f;
                    f = 0.0f;
                    requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                    float requiredBaseOffset3 = f + getRequiredBaseOffset();
                    requiredBaseOffset2 = 0.0f + getRequiredBaseOffset();
                    f2 = requiredBaseOffset3;
                } else {
                    fConvertDpToPixel = 0.0f;
                }
                f = 0.0f;
                fMin = 0.0f;
                requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                float requiredBaseOffset32 = f + getRequiredBaseOffset();
                requiredBaseOffset2 = 0.0f + getRequiredBaseOffset();
                f2 = requiredBaseOffset32;
            }
            f = fConvertDpToPixel2;
            fConvertDpToPixel = 0.0f;
            fMin = 0.0f;
            requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
            float requiredBaseOffset322 = f + getRequiredBaseOffset();
            requiredBaseOffset2 = 0.0f + getRequiredBaseOffset();
            f2 = requiredBaseOffset322;
        }
        float fConvertDpToPixel5 = Utils.convertDpToPixel(10.0f);
        if (this instanceof RadarChart) {
            if (((RadarChart) this).getXAxis().isEnabled()) {
                fConvertDpToPixel5 = Math.max(Utils.convertDpToPixel(10.0f), r6.mLabelWidth);
            }
        }
        float extraTopOffset = requiredBaseOffset2 + getExtraTopOffset();
        float extraRightOffset = f2 + getExtraRightOffset();
        float extraBottomOffset = fMin + getExtraBottomOffset();
        float fMax = Math.max(fConvertDpToPixel5, requiredBaseOffset + getExtraLeftOffset());
        float fMax2 = Math.max(fConvertDpToPixel5, extraTopOffset);
        float fMax3 = Math.max(fConvertDpToPixel5, extraRightOffset);
        float fMax4 = Math.max(fConvertDpToPixel5, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.mViewPortHandler.restrainViewPort(fMax, fMax2, fMax3, fMax4);
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + fMax + ", offsetTop: " + fMax2 + ", offsetRight: " + fMax3 + ", offsetBottom: " + fMax4);
        }
    }

    public float getAngleForPoint(float f, float f2) {
        PointF centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.x;
        double d2 = f2 - centerOffsets.y;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        return f3 > 360.0f ? f3 - 360.0f : f3;
    }

    protected PointF getPosition(PointF pointF, float f, float f2) {
        double d = f;
        double d2 = f2;
        return new PointF((float) (((double) pointF.x) + (Math.cos(Math.toRadians(d2)) * d)), (float) (((double) pointF.y) + (d * Math.sin(Math.toRadians(d2)))));
    }

    public float distanceToCenter(float f, float f2) {
        float f3;
        float f4;
        PointF centerOffsets = getCenterOffsets();
        if (f > centerOffsets.x) {
            f3 = f - centerOffsets.x;
        } else {
            f3 = centerOffsets.x - f;
        }
        if (f2 > centerOffsets.y) {
            f4 = f2 - centerOffsets.y;
        } else {
            f4 = centerOffsets.y - f2;
        }
        return (float) Math.sqrt(Math.pow(f3, 2.0d) + Math.pow(f4, 2.0d));
    }

    public void setRotationAngle(float f) {
        this.mRawRotationAngle = f;
        this.mRotationAngle = Utils.getNormalizedAngle(this.mRawRotationAngle);
    }

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationEnabled(boolean z) {
        this.mRotateEnabled = z;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width(), contentRect.height());
    }

    public List<SelectionDetail> getSelectionDetailsAtIndex(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mData.getDataSetCount(); i2++) {
            DataSet dataSetByIndex = this.mData.getDataSetByIndex(i2);
            float yValForXIndex = dataSetByIndex.getYValForXIndex(i);
            if (!Float.isNaN(yValForXIndex)) {
                arrayList.add(new SelectionDetail(yValForXIndex, i2, dataSetByIndex));
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public void spin(int i, float f, float f2, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        setRotationAngle(f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f, f2);
        objectAnimatorOfFloat.setDuration(i);
        objectAnimatorOfFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.PieRadarChartBase.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        objectAnimatorOfFloat.start();
    }
}
