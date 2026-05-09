package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleData;
import com.github.mikephil.charting.data.BarLineScatterCandleDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.filter.Approximator;
import com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.FillFormatter;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleData<? extends BarLineScatterCandleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleDataProvider {
    private long drawCycles;
    private Integer mAutoScaleLastHighestVisibleXIndex;
    private Integer mAutoScaleLastLowestVisibleXIndex;
    private boolean mAutoScaleMinMaxEnabled;
    protected YAxis mAxisLeft;
    protected YAxisRenderer mAxisRendererLeft;
    protected YAxisRenderer mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    private boolean mCustomViewPortEnabled;
    protected boolean mDoubleTapToZoomEnabled;
    private boolean mDragEnabled;
    protected boolean mDrawBorders;
    protected boolean mDrawGridBackground;
    protected OnDrawListener mDrawListener;
    protected boolean mFilterData;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled;
    protected Transformer mLeftAxisTransformer;
    protected int mMaxVisibleCount;
    protected boolean mPinchZoomEnabled;
    protected Transformer mRightAxisTransformer;
    private boolean mScaleXEnabled;
    private boolean mScaleYEnabled;
    protected XAxis mXAxis;
    protected XAxisRenderer mXAxisRenderer;
    private long totalTime;

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mAutoScaleLastLowestVisibleXIndex = null;
        this.mAutoScaleLastHighestVisibleXIndex = null;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mFilterData = false;
        this.mDrawGridBackground = true;
        this.mDrawBorders = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mCustomViewPortEnabled = false;
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mAutoScaleLastLowestVisibleXIndex = null;
        this.mAutoScaleLastHighestVisibleXIndex = null;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mFilterData = false;
        this.mDrawGridBackground = true;
        this.mDrawBorders = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mCustomViewPortEnabled = false;
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mAutoScaleLastLowestVisibleXIndex = null;
        this.mAutoScaleLastHighestVisibleXIndex = null;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mFilterData = false;
        this.mDrawGridBackground = true;
        this.mDrawBorders = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mCustomViewPortEnabled = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mXAxis = new XAxis();
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.getMatrixTouch());
        this.mGridBackgroundPaint = new Paint();
        this.mGridBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDataNotSet) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        calcModulus();
        this.mXAxisRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
        this.mRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
        drawGridBackground(canvas);
        if (this.mAxisLeft.isEnabled()) {
            this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum);
        }
        if (this.mAxisRight.isEnabled()) {
            this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum);
        }
        this.mXAxisRenderer.renderAxisLine(canvas);
        this.mAxisRendererLeft.renderAxisLine(canvas);
        this.mAxisRendererRight.renderAxisLine(canvas);
        if (this.mAutoScaleMinMaxEnabled) {
            int lowestVisibleXIndex = getLowestVisibleXIndex();
            int highestVisibleXIndex = getHighestVisibleXIndex();
            if (this.mAutoScaleLastLowestVisibleXIndex == null || this.mAutoScaleLastLowestVisibleXIndex.intValue() != lowestVisibleXIndex || this.mAutoScaleLastHighestVisibleXIndex == null || this.mAutoScaleLastHighestVisibleXIndex.intValue() != highestVisibleXIndex) {
                calcMinMax();
                calculateOffsets();
                this.mAutoScaleLastLowestVisibleXIndex = Integer.valueOf(lowestVisibleXIndex);
                this.mAutoScaleLastHighestVisibleXIndex = Integer.valueOf(highestVisibleXIndex);
            }
        }
        int iSave = canvas.save();
        canvas.clipRect(this.mViewPortHandler.getContentRect());
        this.mXAxisRenderer.renderGridLines(canvas);
        this.mAxisRendererLeft.renderGridLines(canvas);
        this.mAxisRendererRight.renderGridLines(canvas);
        if (this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
            this.mXAxisRenderer.renderLimitLines(canvas);
        }
        if (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
            this.mAxisRendererLeft.renderLimitLines(canvas);
        }
        if (this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
            this.mAxisRendererRight.renderLimitLines(canvas);
        }
        this.mRenderer.drawData(canvas);
        if (!this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
            this.mXAxisRenderer.renderLimitLines(canvas);
        }
        if (!this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
            this.mAxisRendererLeft.renderLimitLines(canvas);
        }
        if (!this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
            this.mAxisRendererRight.renderLimitLines(canvas);
        }
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHightlight);
        }
        canvas.restoreToCount(iSave);
        this.mRenderer.drawExtras(canvas);
        this.mXAxisRenderer.renderAxisLabels(canvas);
        this.mAxisRendererLeft.renderAxisLabels(canvas);
        this.mAxisRendererRight.renderAxisLabels(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawMarkers(canvas);
        drawDescription(canvas);
        if (this.mLogEnabled) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            this.totalTime += jCurrentTimeMillis2;
            this.drawCycles++;
            Log.i(Chart.LOG_TAG, "Drawtime: " + jCurrentTimeMillis2 + " ms, average: " + (this.totalTime / this.drawCycles) + " ms, cycles: " + this.drawCycles);
        }
    }

    public void resetTracking() {
        this.totalTime = 0L;
        this.drawCycles = 0L;
    }

    protected void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing Value-Px Matrix, xmin: " + this.mXChartMin + ", xmax: " + this.mXChartMax + ", xdelta: " + this.mDeltaX);
        }
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mXChartMin, this.mDeltaX, this.mAxisRight.mAxisRange, this.mAxisRight.mAxisMinimum);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mXChartMin, this.mDeltaX, this.mAxisLeft.mAxisRange, this.mAxisLeft.mAxisMinimum);
    }

    protected void prepareOffsetMatrix() {
        this.mRightAxisTransformer.prepareMatrixOffset(this.mAxisRight.isInverted());
        this.mLeftAxisTransformer.prepareMatrixOffset(this.mAxisLeft.isInverted());
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mDataNotSet) {
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing...");
        }
        if (this.mRenderer != null) {
            this.mRenderer.initBuffers();
        }
        calcMinMax();
        if (this.mAxisLeft.needsDefaultFormatter()) {
            this.mAxisLeft.setValueFormatter(this.mDefaultFormatter);
        }
        if (this.mAxisRight.needsDefaultFormatter()) {
            this.mAxisRight.setValueFormatter(this.mDefaultFormatter);
        }
        this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum);
        this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum);
        this.mXAxisRenderer.computeAxis(((BarLineScatterCandleData) this.mData).getXValAverageLength(), ((BarLineScatterCandleData) this.mData).getXVals());
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        if (this.mAutoScaleMinMaxEnabled) {
            ((BarLineScatterCandleData) this.mData).calcMinMax(getLowestVisibleXIndex(), getHighestVisibleXIndex());
        }
        float yMin = ((BarLineScatterCandleData) this.mData).getYMin(YAxis.AxisDependency.LEFT);
        float yMax = ((BarLineScatterCandleData) this.mData).getYMax(YAxis.AxisDependency.LEFT);
        float yMin2 = ((BarLineScatterCandleData) this.mData).getYMin(YAxis.AxisDependency.RIGHT);
        float yMax2 = ((BarLineScatterCandleData) this.mData).getYMax(YAxis.AxisDependency.RIGHT);
        float fAbs = Math.abs(yMax - (this.mAxisLeft.isStartAtZeroEnabled() ? 0.0f : yMin));
        float fAbs2 = Math.abs(yMax2 - (this.mAxisRight.isStartAtZeroEnabled() ? 0.0f : yMin2));
        if (fAbs == 0.0f) {
            yMax += 1.0f;
            if (!this.mAxisLeft.isStartAtZeroEnabled()) {
                yMin -= 1.0f;
            }
        }
        if (fAbs2 == 0.0f) {
            yMax2 += 1.0f;
            if (!this.mAxisRight.isStartAtZeroEnabled()) {
                yMin2 -= 1.0f;
            }
        }
        float f = fAbs / 100.0f;
        float spaceTop = this.mAxisLeft.getSpaceTop() * f;
        float f2 = fAbs2 / 100.0f;
        float spaceTop2 = this.mAxisRight.getSpaceTop() * f2;
        float spaceBottom = f * this.mAxisLeft.getSpaceBottom();
        float spaceBottom2 = f2 * this.mAxisRight.getSpaceBottom();
        this.mXChartMax = ((BarLineScatterCandleData) this.mData).getXVals().size() - 1;
        this.mDeltaX = Math.abs(this.mXChartMax - this.mXChartMin);
        this.mAxisLeft.mAxisMaximum = !Float.isNaN(this.mAxisLeft.getAxisMaxValue()) ? this.mAxisLeft.getAxisMaxValue() : yMax + spaceTop;
        this.mAxisRight.mAxisMaximum = !Float.isNaN(this.mAxisRight.getAxisMaxValue()) ? this.mAxisRight.getAxisMaxValue() : yMax2 + spaceTop2;
        this.mAxisLeft.mAxisMinimum = !Float.isNaN(this.mAxisLeft.getAxisMinValue()) ? this.mAxisLeft.getAxisMinValue() : yMin - spaceBottom;
        this.mAxisRight.mAxisMinimum = !Float.isNaN(this.mAxisRight.getAxisMinValue()) ? this.mAxisRight.getAxisMinValue() : yMin2 - spaceBottom2;
        if (this.mAxisLeft.isStartAtZeroEnabled()) {
            this.mAxisLeft.mAxisMinimum = 0.0f;
        }
        if (this.mAxisRight.isStartAtZeroEnabled()) {
            this.mAxisRight.mAxisMinimum = 0.0f;
        }
        this.mAxisLeft.mAxisRange = Math.abs(this.mAxisLeft.mAxisMaximum - this.mAxisLeft.mAxisMinimum);
        this.mAxisRight.mAxisRange = Math.abs(this.mAxisRight.mAxisMaximum - this.mAxisRight.mAxisMinimum);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015b  */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void calculateOffsets() {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.calculateOffsets():void");
    }

    protected void calcModulus() {
        if (this.mXAxis == null || !this.mXAxis.isEnabled()) {
            return;
        }
        if (!this.mXAxis.isAxisModulusCustom()) {
            this.mViewPortHandler.getMatrixTouch().getValues(new float[9]);
            this.mXAxis.mAxisLabelModulus = (int) Math.ceil((((BarLineScatterCandleData) this.mData).getXValCount() * this.mXAxis.mLabelWidth) / (this.mViewPortHandler.contentWidth() * r0[0]));
        }
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "X-Axis modulus: " + this.mXAxis.mAxisLabelModulus + ", x-axis label width: " + this.mXAxis.mLabelWidth + ", content width: " + this.mViewPortHandler.contentWidth());
        }
        if (this.mXAxis.mAxisLabelModulus < 1) {
            this.mXAxis.mAxisLabelModulus = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Entry entry, int i) {
        float xIndex = entry.getXIndex();
        if (this instanceof BarChart) {
            float groupSpace = ((BarData) this.mData).getGroupSpace();
            float entryPosition = ((BarLineScatterCandleDataSet) ((BarLineScatterCandleData) this.mData).getDataSetByIndex(i)).getEntryPosition(entry);
            xIndex += ((((BarLineScatterCandleData) this.mData).getDataSetCount() - 1) * entryPosition) + i + (entryPosition * groupSpace) + (groupSpace / 2.0f);
        }
        float[] fArr = {xIndex, entry.getVal() * this.mAnimator.getPhaseY()};
        getTransformer(((BarLineScatterCandleDataSet) ((BarLineScatterCandleData) this.mData).getDataSetByIndex(i)).getAxisDependency()).pointValuesToPixel(fArr);
        return fArr;
    }

    protected void drawGridBackground(Canvas canvas) {
        if (this.mDrawGridBackground) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
        }
    }

    @Override // com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public Transformer getTransformer(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisTransformer;
        }
        return this.mRightAxisTransformer;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.mChartTouchListener == null || this.mDataNotSet || !this.mTouchEnabled) {
            return false;
        }
        return this.mChartTouchListener.onTouch(this, motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mChartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) this.mChartTouchListener).computeScroll();
        }
    }

    public void zoomIn() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomIn(getWidth() / 2.0f, -(getHeight() / 2.0f)), this, true);
    }

    public void zoomOut() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomOut(getWidth() / 2.0f, -(getHeight() / 2.0f)), this, true);
    }

    public void zoom(float f, float f2, float f3, float f4) {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoom(f, f2, f3, -f4), this, true);
    }

    public void fitScreen() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.fitScreen(), this, true);
    }

    public void setScaleMinima(float f, float f2) {
        this.mViewPortHandler.setMinimumScaleX(f);
        this.mViewPortHandler.setMinimumScaleY(f2);
    }

    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.setMinimumScaleX(this.mDeltaX / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.setMaximumScaleX(this.mDeltaX / f);
    }

    public void setVisibleXRange(float f, float f2) {
        float f3 = this.mDeltaX / f;
        this.mViewPortHandler.setMinMaxScaleX(this.mDeltaX / f2, f3);
    }

    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMinimumScaleY(getDeltaY(axisDependency) / f);
    }

    public void moveViewToX(float f) {
        MoveViewJob moveViewJob = new MoveViewJob(this.mViewPortHandler, f, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this);
        if (this.mViewPortHandler.hasChartDimens()) {
            post(moveViewJob);
        } else {
            this.mJobs.add(moveViewJob);
        }
    }

    public void moveViewToY(float f, YAxis.AxisDependency axisDependency) {
        MoveViewJob moveViewJob = new MoveViewJob(this.mViewPortHandler, 0.0f, f + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this);
        if (this.mViewPortHandler.hasChartDimens()) {
            post(moveViewJob);
        } else {
            this.mJobs.add(moveViewJob);
        }
    }

    public void moveViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        MoveViewJob moveViewJob = new MoveViewJob(this.mViewPortHandler, f, f2 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this);
        if (this.mViewPortHandler.hasChartDimens()) {
            post(moveViewJob);
        } else {
            this.mJobs.add(moveViewJob);
        }
    }

    public void centerViewTo(int i, float f, YAxis.AxisDependency axisDependency) {
        MoveViewJob moveViewJob = new MoveViewJob(this.mViewPortHandler, i - ((getXAxis().getValues().size() / this.mViewPortHandler.getScaleX()) / 2.0f), f + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this);
        if (this.mViewPortHandler.hasChartDimens()) {
            post(moveViewJob);
        } else {
            this.mJobs.add(moveViewJob);
        }
    }

    public void setViewPortOffsets(final float f, final float f2, final float f3, final float f4) {
        this.mCustomViewPortEnabled = true;
        post(new Runnable() { // from class: com.github.mikephil.charting.charts.BarLineChartBase.1
            @Override // java.lang.Runnable
            public void run() {
                BarLineChartBase.this.mViewPortHandler.restrainViewPort(f, f2, f3, f4);
                BarLineChartBase.this.prepareOffsetMatrix();
                BarLineChartBase.this.prepareValuePxMatrix();
            }
        });
    }

    public void resetViewPortOffsets() {
        this.mCustomViewPortEnabled = false;
        calculateOffsets();
    }

    public float getDeltaY(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft.mAxisRange;
        }
        return this.mAxisRight.mAxisRange;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {entry.getXIndex(), entry.getVal()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public void setMaxVisibleValueCount(int i) {
        this.mMaxVisibleCount = i;
    }

    @Override // com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.mHighlightPerDragEnabled = z;
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    public void setGridBackgroundColor(int i) {
        this.mGridBackgroundPaint.setColor(i);
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void setScaleEnabled(boolean z) {
        this.mScaleXEnabled = z;
        this.mScaleYEnabled = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.mScaleXEnabled = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.mScaleYEnabled = z;
    }

    public boolean isScaleXEnabled() {
        return this.mScaleXEnabled;
    }

    public boolean isScaleYEnabled() {
        return this.mScaleYEnabled;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.mDoubleTapToZoomEnabled = z;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public void setDrawGridBackground(boolean z) {
        this.mDrawGridBackground = z;
    }

    public void setDrawBorders(boolean z) {
        this.mDrawBorders = z;
    }

    public void setBorderWidth(float f) {
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(f));
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mDataNotSet || this.mData == 0) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        float[] fArr = {f, 0.0f};
        this.mLeftAxisTransformer.pixelsToValue(fArr);
        double d = fArr[0];
        double dFloor = Math.floor(d);
        double d2 = ((double) this.mDeltaX) * 0.025d;
        if (d < (-d2) || d > ((double) this.mDeltaX) + d2) {
            return null;
        }
        if (dFloor < 0.0d) {
            dFloor = 0.0d;
        }
        if (dFloor >= this.mDeltaX) {
            dFloor = this.mDeltaX - 1.0f;
        }
        int i = (int) dFloor;
        if (d - dFloor > 0.5d) {
            i++;
        }
        List<SelectionDetail> selectionDetailsAtIndex = getSelectionDetailsAtIndex(i);
        float minimumDistance = Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.LEFT);
        float minimumDistance2 = Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.RIGHT);
        if (((BarLineScatterCandleData) this.mData).getFirstRight() == 0) {
            minimumDistance2 = Float.MAX_VALUE;
        }
        if (((BarLineScatterCandleData) this.mData).getFirstLeft() == 0) {
            minimumDistance = Float.MAX_VALUE;
        }
        int closestDataSetIndex = Utils.getClosestDataSetIndex(selectionDetailsAtIndex, f2, minimumDistance < minimumDistance2 ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT);
        if (closestDataSetIndex == -1) {
            return null;
        }
        return new Highlight(i, closestDataSetIndex);
    }

    public int getDataSetIndexByTouchPoint(float f, float f2) {
        if (this.mDataNotSet || this.mData == 0) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return -1;
        }
        float[] fArr = {f, 0.0f};
        this.mLeftAxisTransformer.pixelsToValue(fArr);
        double d = fArr[0];
        double dFloor = Math.floor(d);
        double d2 = ((double) this.mDeltaX) * 0.025d;
        if (d < (-d2) || d > ((double) this.mDeltaX) + d2) {
            return -1;
        }
        if (dFloor < 0.0d) {
            dFloor = 0.0d;
        }
        if (dFloor >= this.mDeltaX) {
            dFloor = this.mDeltaX - 1.0f;
        }
        int i = (int) dFloor;
        if (d - dFloor > 0.5d) {
            i++;
        }
        List<SelectionDetail> selectionDetailsAtIndex = getSelectionDetailsAtIndex(i);
        float minimumDistance = Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.LEFT);
        float minimumDistance2 = Utils.getMinimumDistance(selectionDetailsAtIndex, f2, YAxis.AxisDependency.RIGHT);
        if (((BarLineScatterCandleData) this.mData).getFirstRight() == 0) {
            minimumDistance2 = Float.MAX_VALUE;
        }
        if (((BarLineScatterCandleData) this.mData).getFirstLeft() == 0) {
            minimumDistance = Float.MAX_VALUE;
        }
        int closestDataSetIndex = Utils.getClosestDataSetIndex(selectionDetailsAtIndex, f2, minimumDistance < minimumDistance2 ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT);
        if (closestDataSetIndex == -1) {
            return -1;
        }
        return closestDataSetIndex;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.github.mikephil.charting.data.DataSet] */
    protected List<SelectionDetail> getSelectionDetailsAtIndex(int i) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < ((BarLineScatterCandleData) this.mData).getDataSetCount(); i2++) {
            ?? dataSetByIndex = ((BarLineScatterCandleData) this.mData).getDataSetByIndex(i2);
            if (dataSetByIndex.isHighlightEnabled()) {
                fArr[1] = dataSetByIndex.getYValForXIndex(i);
                getTransformer(dataSetByIndex.getAxisDependency()).pointValuesToPixel(fArr);
                if (!Float.isNaN(fArr[1])) {
                    arrayList.add(new SelectionDetail(fArr[1], i2, dataSetByIndex));
                }
            }
        }
        return arrayList;
    }

    public PointD getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        getTransformer(axisDependency).pixelsToValue(new float[]{f, f2});
        return new PointD(r0[0], r0[1]);
    }

    public PointD getPixelsForValues(float f, float f2, YAxis.AxisDependency axisDependency) {
        getTransformer(axisDependency).pointValuesToPixel(new float[]{f, f2});
        return new PointD(r0[0], r0[1]);
    }

    public float getYValueByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        return (float) getValuesByTouchPoint(f, f2, axisDependency).f8927y;
    }

    public Entry getEntryByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return ((BarLineScatterCandleData) this.mData).getEntryForHighlight(highlightByTouchPoint);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BarLineScatterCandleDataSet<? extends Entry> getDataSetByTouchPoint(float f, float f2) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return (BarLineScatterCandleDataSet) ((BarLineScatterCandleData) this.mData).getDataSetByIndex(highlightByTouchPoint.getDataSetIndex());
        }
        return null;
    }

    public int getLowestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[0] <= 0.0f) {
            return 0;
        }
        return (int) (fArr[0] + 1.0f);
    }

    public int getHighestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        return fArr[0] >= ((float) ((BarLineScatterCandleData) this.mData).getXValCount()) ? ((BarLineScatterCandleData) this.mData).getXValCount() - 1 : (int) fArr[0];
    }

    @Override // android.view.View
    public float getScaleX() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.getScaleX();
    }

    @Override // android.view.View
    public float getScaleY() {
        if (this.mViewPortHandler == null) {
            return 1.0f;
        }
        return this.mViewPortHandler.getScaleY();
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.isFullyZoomedOut();
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public YAxis getAxis(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft;
        }
        return this.mAxisRight;
    }

    @Override // com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider
    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        return getAxis(axisDependency).isInverted();
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public void enableFiltering(Approximator approximator) {
        this.mFilterData = true;
    }

    public void disableFiltering() {
        this.mFilterData = false;
    }

    public boolean isFilteringEnabled() {
        return this.mFilterData;
    }

    public void setPinchZoom(boolean z) {
        this.mPinchZoomEnabled = z;
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public void setDragOffsetX(float f) {
        this.mViewPortHandler.setDragOffsetX(f);
    }

    public void setDragOffsetY(float f) {
        this.mViewPortHandler.setDragOffsetY(f);
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.hasNoDragOffset();
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.mXAxisRenderer = xAxisRenderer;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererLeft = yAxisRenderer;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererRight = yAxisRenderer;
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMax() {
        return Math.max(this.mAxisLeft.mAxisMaximum, this.mAxisRight.mAxisMaximum);
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getYChartMin() {
        return Math.min(this.mAxisLeft.mAxisMinimum, this.mAxisRight.mAxisMinimum);
    }

    public boolean isAnyAxisInverted() {
        return this.mAxisLeft.isInverted() || this.mAxisRight.isInverted();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.mAutoScaleMinMaxEnabled = z;
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setPaint(Paint paint, int i) {
        super.setPaint(paint, i);
        if (i != 4) {
            return;
        }
        this.mGridBackgroundPaint = paint;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Paint getPaint(int i) {
        Paint paint = super.getPaint(i);
        if (paint != null) {
            return paint;
        }
        if (i != 4) {
            return null;
        }
        return this.mGridBackgroundPaint;
    }

    public class DefaultFillFormatter implements FillFormatter {
        protected DefaultFillFormatter() {
        }

        @Override // com.github.mikephil.charting.utils.FillFormatter
        public float getFillLinePosition(LineDataSet lineDataSet, LineData lineData, float f, float f2) {
            if ((lineDataSet.getYMax() > 0.0f && lineDataSet.getYMin() < 0.0f) || BarLineChartBase.this.getAxis(lineDataSet.getAxisDependency()).isStartAtZeroEnabled()) {
                return 0.0f;
            }
            if (lineData.getYMax() > 0.0f) {
                f = 0.0f;
            }
            if (lineData.getYMin() < 0.0f) {
                f2 = 0.0f;
            }
            return lineDataSet.getYMin() >= 0.0f ? f2 : f;
        }
    }
}
