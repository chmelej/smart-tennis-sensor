package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.animation.EasingFunction;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.ChartInterface;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.DefaultValueFormatter;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public abstract class Chart<T extends ChartData<? extends DataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected boolean mDataNotSet;
    protected ValueFormatter mDefaultFormatter;
    protected float mDeltaX;
    protected Paint mDescPaint;
    protected String mDescription;
    private PointF mDescriptionPosition;
    private boolean mDragDecelerationEnabled;
    private float mDragDecelerationFrictionCoef;
    protected Bitmap mDrawBitmap;
    protected boolean mDrawMarkerViews;
    protected Paint mDrawPaint;
    protected boolean mDrawUnitInChart;
    private float mExtraBottomOffset;
    private float mExtraLeftOffset;
    private float mExtraRightOffset;
    private float mExtraTopOffset;
    private OnChartGestureListener mGestureListener;
    protected Highlight[] mIndicesToHightlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled;
    protected MarkerView mMarkerView;
    private String mNoDataText;
    private String mNoDataTextDescription;
    private boolean mOffsetsCalculated;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled;
    protected ViewPortHandler mViewPortHandler;
    protected float mXChartMax;
    protected float mXChartMin;

    protected abstract void calcMinMax();

    protected abstract void calculateOffsets();

    protected abstract float[] getMarkerPosition(Entry entry, int i);

    public abstract void notifyDataSetChanged();

    public Chart(Context context) {
        super(context);
        this.mLogEnabled = false;
        this.mData = null;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDescription = "Description";
        this.mDataNotSet = true;
        this.mDrawUnitInChart = false;
        this.mDeltaX = 1.0f;
        this.mXChartMin = 0.0f;
        this.mXChartMax = 0.0f;
        this.mTouchEnabled = true;
        this.mNoDataText = "";
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mIndicesToHightlight = new Highlight[0];
        this.mDrawMarkerViews = true;
        this.mJobs = new ArrayList<>();
        init();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLogEnabled = false;
        this.mData = null;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDescription = "Description";
        this.mDataNotSet = true;
        this.mDrawUnitInChart = false;
        this.mDeltaX = 1.0f;
        this.mXChartMin = 0.0f;
        this.mXChartMax = 0.0f;
        this.mTouchEnabled = true;
        this.mNoDataText = "";
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mIndicesToHightlight = new Highlight[0];
        this.mDrawMarkerViews = true;
        this.mJobs = new ArrayList<>();
        init();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLogEnabled = false;
        this.mData = null;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDescription = "Description";
        this.mDataNotSet = true;
        this.mDrawUnitInChart = false;
        this.mDeltaX = 1.0f;
        this.mXChartMin = 0.0f;
        this.mXChartMax = 0.0f;
        this.mTouchEnabled = true;
        this.mNoDataText = "";
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mIndicesToHightlight = new Highlight[0];
        this.mDrawMarkerViews = true;
        this.mJobs = new ArrayList<>();
        init();
    }

    protected void init() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.mAnimator = new ChartAnimator();
        } else {
            this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Chart.this.postInvalidate();
                }
            });
        }
        Utils.init(getContext());
        this.mDefaultFormatter = new DefaultValueFormatter(1);
        this.mViewPortHandler = new ViewPortHandler();
        this.mLegend = new Legend();
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, this.mLegend);
        this.mDescPaint = new Paint(1);
        this.mDescPaint.setColor(-16777216);
        this.mDescPaint.setTextAlign(Paint.Align.RIGHT);
        this.mDescPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mInfoPaint = new Paint(1);
        this.mInfoPaint.setColor(Color.rgb(247, 189, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mDrawPaint = new Paint(4);
        if (this.mLogEnabled) {
            Log.i("", "Chart.init()");
        }
    }

    public void setData(T t) {
        if (t == null) {
            Log.e(LOG_TAG, "Cannot set data for chart. Provided data object is null.");
            return;
        }
        this.mDataNotSet = false;
        this.mOffsetsCalculated = false;
        this.mData = t;
        calculateFormatter(t.getYMin(), t.getYMax());
        for (DataSet dataSet : this.mData.getDataSets()) {
            if (dataSet.needsDefaultFormatter()) {
                dataSet.setValueFormatter(this.mDefaultFormatter);
            }
        }
        notifyDataSetChanged();
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "Data is set.");
        }
    }

    public void clear() {
        this.mData = null;
        this.mDataNotSet = true;
        invalidate();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public boolean isEmpty() {
        return this.mData == null || this.mData.getYValCount() <= 0;
    }

    protected void calculateFormatter(float f, float f2) {
        float fMax;
        if (this.mData == null || this.mData.getXValCount() < 2) {
            fMax = Math.max(Math.abs(f), Math.abs(f2));
        } else {
            fMax = Math.abs(f2 - f);
        }
        this.mDefaultFormatter = new DefaultValueFormatter(Utils.getDecimals(fMax));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDataNotSet || this.mData == null || this.mData.getYValCount() <= 0) {
            canvas.drawText(this.mNoDataText, getWidth() / 2, getHeight() / 2, this.mInfoPaint);
            if (TextUtils.isEmpty(this.mNoDataTextDescription)) {
                return;
            }
            canvas.drawText(this.mNoDataTextDescription, getWidth() / 2, (getHeight() / 2) + (-this.mInfoPaint.ascent()) + this.mInfoPaint.descent(), this.mInfoPaint);
            return;
        }
        if (this.mOffsetsCalculated) {
            return;
        }
        calculateOffsets();
        this.mOffsetsCalculated = true;
    }

    protected void drawDescription(Canvas canvas) {
        if (this.mDescription.equals("")) {
            return;
        }
        if (this.mDescriptionPosition == null) {
            canvas.drawText(this.mDescription, (getWidth() - this.mViewPortHandler.offsetRight()) - 10.0f, (getHeight() - this.mViewPortHandler.offsetBottom()) - 10.0f, this.mDescPaint);
        } else {
            canvas.drawText(this.mDescription, this.mDescriptionPosition.x, this.mDescriptionPosition.y, this.mDescPaint);
        }
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHightlight;
    }

    public boolean valuesToHighlight() {
        return (this.mIndicesToHightlight == null || this.mIndicesToHightlight.length <= 0 || this.mIndicesToHightlight[0] == null) ? false : true;
    }

    public void highlightValues(Highlight[] highlightArr) {
        this.mIndicesToHightlight = highlightArr;
        if (highlightArr == null || highlightArr.length == 0) {
            this.mChartTouchListener.setLastHighlighted(null);
        }
        invalidate();
    }

    public void highlightValue(int i, int i2) {
        if (i < 0 || i2 < 0 || i >= this.mData.getXValCount() || i2 >= this.mData.getDataSetCount()) {
            highlightValues(null);
        } else {
            highlightValues(new Highlight[]{new Highlight(i, i2)});
        }
    }

    public void highlightTouch(Highlight highlight) {
        Entry entryForHighlight;
        if (highlight == null) {
            this.mIndicesToHightlight = null;
            entryForHighlight = null;
        } else {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Highlighted: " + highlight.toString());
            }
            entryForHighlight = this.mData.getEntryForHighlight(highlight);
            if (entryForHighlight == null || entryForHighlight.getXIndex() != highlight.getXIndex()) {
                this.mIndicesToHightlight = null;
                highlight = null;
            } else {
                this.mIndicesToHightlight = new Highlight[]{highlight};
            }
        }
        invalidate();
        if (this.mSelectionListener != null) {
            if (!valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entryForHighlight, highlight.getDataSetIndex(), highlight);
            }
        }
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    protected void drawMarkers(Canvas canvas) {
        Entry entryForHighlight;
        if (this.mMarkerView != null && this.mDrawMarkerViews && valuesToHighlight()) {
            for (int i = 0; i < this.mIndicesToHightlight.length; i++) {
                int xIndex = this.mIndicesToHightlight[i].getXIndex();
                int dataSetIndex = this.mIndicesToHightlight[i].getDataSetIndex();
                float f = xIndex;
                if (f <= this.mDeltaX && f <= this.mDeltaX * this.mAnimator.getPhaseX() && (entryForHighlight = this.mData.getEntryForHighlight(this.mIndicesToHightlight[i])) != null && entryForHighlight.getXIndex() == this.mIndicesToHightlight[i].getXIndex()) {
                    float[] markerPosition = getMarkerPosition(entryForHighlight, dataSetIndex);
                    if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                        this.mMarkerView.refreshContent(entryForHighlight, dataSetIndex);
                        this.mMarkerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        this.mMarkerView.layout(0, 0, this.mMarkerView.getMeasuredWidth(), this.mMarkerView.getMeasuredHeight());
                        float width = (this.mMarkerView.getWidth() * 3) / 4;
                        if (markerPosition[1] - this.mMarkerView.getHeight() <= 0.0f) {
                            this.mMarkerView.draw(canvas, markerPosition[0] + width, markerPosition[1] + (this.mMarkerView.getHeight() - markerPosition[1]));
                        } else {
                            this.mMarkerView.draw(canvas, markerPosition[0] + width, markerPosition[1]);
                        }
                    }
                }
            }
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.mDragDecelerationEnabled = z;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f;
    }

    public void animateXY(int i, int i2, EasingFunction easingFunction, EasingFunction easingFunction2) {
        this.mAnimator.animateXY(i, i2, easingFunction, easingFunction2);
    }

    public void animateX(int i, EasingFunction easingFunction) {
        this.mAnimator.animateX(i, easingFunction);
    }

    public void animateY(int i, EasingFunction easingFunction) {
        this.mAnimator.animateY(i, easingFunction);
    }

    public void animateXY(int i, int i2, Easing.EasingOption easingOption, Easing.EasingOption easingOption2) {
        this.mAnimator.animateXY(i, i2, easingOption, easingOption2);
    }

    public void animateX(int i, Easing.EasingOption easingOption) {
        this.mAnimator.animateX(i, easingOption);
    }

    public void animateY(int i, Easing.EasingOption easingOption) {
        this.mAnimator.animateY(i, easingOption);
    }

    public void animateX(int i) {
        this.mAnimator.animateX(i);
    }

    public void animateY(int i) {
        this.mAnimator.animateY(i);
    }

    public void animateXY(int i, int i2) {
        this.mAnimator.animateXY(i, i2);
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultFormatter;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.mGestureListener = onChartGestureListener;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public void setHighlightEnabled(boolean z) {
        if (this.mData != null) {
            this.mData.setHighlightEnabled(z);
        }
    }

    public boolean isHighlightEnabled() {
        if (this.mData == null) {
            return true;
        }
        return this.mData.isHighlightEnabled();
    }

    public float getYValueSum() {
        return this.mData.getYValueSum();
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getXChartMax() {
        return this.mXChartMax;
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public float getXChartMin() {
        return this.mXChartMin;
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public int getXValCount() {
        return this.mData.getXValCount();
    }

    public float getAverage() {
        return getYValueSum() / this.mData.getYValCount();
    }

    public float getAverage(String str) {
        return this.mData.getDataSetByLabel(str, true).getYValueSum() / r3.getEntryCount();
    }

    public int getValueCount() {
        return this.mData.getYValCount();
    }

    public PointF getCenter() {
        return new PointF(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public PointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public void setDescription(String str) {
        if (str == null) {
            str = "";
        }
        this.mDescription = str;
    }

    public void setDescriptionPosition(float f, float f2) {
        this.mDescriptionPosition = new PointF(f, f2);
    }

    public void setDescriptionTypeface(Typeface typeface) {
        this.mDescPaint.setTypeface(typeface);
    }

    public void setDescriptionTextSize(float f) {
        if (f > 16.0f) {
            f = 16.0f;
        }
        if (f < 6.0f) {
            f = 6.0f;
        }
        this.mDescPaint.setTextSize(Utils.convertDpToPixel(f));
    }

    public void setDescriptionColor(int i) {
        this.mDescPaint.setColor(i);
    }

    public void setExtraOffsets(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public void setExtraTopOffset(float f) {
        this.mExtraTopOffset = Utils.convertDpToPixel(f);
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public void setExtraRightOffset(float f) {
        this.mExtraRightOffset = Utils.convertDpToPixel(f);
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public void setExtraBottomOffset(float f) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(f);
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public void setExtraLeftOffset(float f) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(f);
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public void setLogEnabled(boolean z) {
        this.mLogEnabled = z;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public void setNoDataText(String str) {
        this.mNoDataText = str;
    }

    public void setNoDataTextDescription(String str) {
        this.mNoDataTextDescription = str;
    }

    public void setTouchEnabled(boolean z) {
        this.mTouchEnabled = z;
    }

    public void setMarkerView(MarkerView markerView) {
        this.mMarkerView = markerView;
    }

    public MarkerView getMarkerView() {
        return this.mMarkerView;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void setPaint(Paint paint, int i) {
        if (i == 7) {
            this.mInfoPaint = paint;
        } else {
            if (i != 11) {
                return;
            }
            this.mDescPaint = paint;
        }
    }

    public Paint getPaint(int i) {
        if (i == 7) {
            return this.mInfoPaint;
        }
        if (i != 11) {
            return null;
        }
        return this.mDescPaint;
    }

    public boolean isDrawMarkerViewEnabled() {
        return this.mDrawMarkerViews;
    }

    public void setDrawMarkerViews(boolean z) {
        this.mDrawMarkerViews = z;
    }

    public String getXValue(int i) {
        if (this.mData == null || this.mData.getXValCount() <= i) {
            return null;
        }
        return this.mData.getXVals().get(i);
    }

    public List<Entry> getEntriesAtIndex(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mData.getDataSetCount(); i2++) {
            Entry entryForXIndex = this.mData.getDataSetByIndex(i2).getEntryForXIndex(i);
            if (entryForXIndex != null) {
                arrayList.add(entryForXIndex);
            }
        }
        return arrayList;
    }

    public T getData() {
        return this.mData;
    }

    public float getPercentOfTotal(float f) {
        return (f / this.mData.getYValueSum()) * 100.0f;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.ChartInterface
    public PointF getCenterOfView() {
        return getCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + "/" + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveToGallery(String str, int i) {
        if (i < 0 || i > 100) {
            i = 50;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM");
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        String str2 = file.getAbsolutePath() + "/" + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            getChartBitmap().compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str2).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("description", "MPAndroidChart-Library Save");
            contentValues.put("orientation", (Integer) 0);
            contentValues.put("_data", str2);
            contentValues.put("_size", Long.valueOf(length));
            return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addJob(Runnable runnable) {
        this.mJobs.add(runnable);
    }

    public void removeJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public void clearAllJobs() {
        this.mJobs.clear();
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iConvertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(iConvertDpToPixel, i)), Math.max(getSuggestedMinimumHeight(), resolveSize(iConvertDpToPixel, i2)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.mDrawBitmap != null) {
                this.mDrawBitmap.recycle();
            }
            this.mDrawBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            this.mViewPortHandler.setChartDimens(i, i2);
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            Iterator<Runnable> it = this.mJobs.iterator();
            while (it.hasNext()) {
                post(it.next());
            }
            this.mJobs.clear();
        }
        notifyDataSetChanged();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 11) {
            Log.e(LOG_TAG, "Cannot enable/disable hardware acceleration for devices below API level 11.");
        } else if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }
}
