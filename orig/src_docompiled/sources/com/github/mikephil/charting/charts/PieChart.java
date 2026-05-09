package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private String mCenterText;
    private float mCenterTextRadiusPercent;
    private boolean mCenterTextWordWrapEnabled;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawXLabels;
    private float mHoleRadiusPercent;
    private float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    public PieChart(Context context) {
        super(context);
        this.mCircleBox = new RectF();
        this.mDrawXLabels = true;
        this.mDrawHole = true;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextWordWrapEnabled = false;
        this.mCenterTextRadiusPercent = 1.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawXLabels = true;
        this.mDrawHole = true;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextWordWrapEnabled = false;
        this.mCenterTextRadiusPercent = 1.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleBox = new RectF();
        this.mDrawXLabels = true;
        this.mDrawHole = true;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextWordWrapEnabled = false;
        this.mCenterTextRadiusPercent = 1.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDataNotSet) {
            return;
        }
        this.mRenderer.drawData(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHightlight);
        }
        this.mRenderer.drawExtras(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calculateOffsets() {
        super.calculateOffsets();
        if (this.mDataNotSet) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        PointF centerOffsets = getCenterOffsets();
        this.mCircleBox.set(centerOffsets.x - diameter, centerOffsets.y - diameter, centerOffsets.x + diameter, centerOffsets.y + diameter);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Entry entry, int i) {
        return new float[0];
    }

    private void calcAngles() {
        this.mDrawAngles = new float[((PieData) this.mData).getYValCount()];
        this.mAbsoluteAngles = new float[((PieData) this.mData).getYValCount()];
        List<PieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        int i = 0;
        int i2 = 0;
        while (i < ((PieData) this.mData).getDataSetCount()) {
            List<Entry> yVals = dataSets.get(i).getYVals();
            int i3 = i2;
            for (int i4 = 0; i4 < yVals.size(); i4++) {
                this.mDrawAngles[i3] = calcAngle(Math.abs(yVals.get(i4).getVal()));
                if (i3 == 0) {
                    this.mAbsoluteAngles[i3] = this.mDrawAngles[i3];
                } else {
                    this.mAbsoluteAngles[i3] = this.mAbsoluteAngles[i3 - 1] + this.mDrawAngles[i3];
                }
                i3++;
            }
            i++;
            i2 = i3;
        }
    }

    public boolean needsHighlight(int i, int i2) {
        if (!valuesToHighlight() || i2 < 0) {
            return false;
        }
        for (int i3 = 0; i3 < this.mIndicesToHightlight.length; i3++) {
            if (this.mIndicesToHightlight[i3].getXIndex() == i && this.mIndicesToHightlight[i3].getDataSetIndex() == i2) {
                return true;
            }
        }
        return false;
    }

    private float calcAngle(float f) {
        return (f / ((PieData) this.mData).getYValueSum()) * 360.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float normalizedAngle = Utils.getNormalizedAngle(f - getRotationAngle());
        for (int i = 0; i < this.mAbsoluteAngles.length; i++) {
            if (this.mAbsoluteAngles[i] > normalizedAngle) {
                return i;
            }
        }
        return -1;
    }

    public int getDataSetIndexForIndex(int i) {
        List<PieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        for (int i2 = 0; i2 < dataSets.size(); i2++) {
            if (dataSets.get(i2).getEntryForXIndex(i) != null) {
                return i2;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public void setHoleColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setXfermode(null);
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i);
    }

    public void setHoleColorTransparent(boolean z) {
        if (z) {
            ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(-1);
            ((PieChartRenderer) this.mRenderer).getPaintHole().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        } else {
            ((PieChartRenderer) this.mRenderer).getPaintHole().setXfermode(null);
        }
    }

    public boolean isHoleTransparent() {
        return ((PieChartRenderer) this.mRenderer).getPaintHole().getXfermode() != null;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.mDrawHole = z;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public void setCenterText(String str) {
        this.mCenterText = str;
    }

    public String getCenterText() {
        return this.mCenterText;
    }

    public void setDrawCenterText(boolean z) {
        this.mDrawCenterText = z;
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBottomOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        if (this.mCircleBox == null) {
            return 0.0f;
        }
        return Math.min(this.mCircleBox.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public PointF getCenterCircleBox() {
        return new PointF(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setCenterTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f);
    }

    public void setCenterTextColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.mHoleRadiusPercent = f;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    public void setTransparentCircleColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setColor(i);
    }

    public void setTransparentCircleRadius(float f) {
        this.mTransparentCircleRadiusPercent = f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    public void setDrawSliceText(boolean z) {
        this.mDrawXLabels = z;
    }

    public boolean isDrawSliceTextEnabled() {
        return this.mDrawXLabels;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public void setUsePercentValues(boolean z) {
        this.mUsePercentValues = z;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public void setCenterTextWordWrapEnabled(boolean z) {
        this.mCenterTextWordWrapEnabled = z;
    }

    public boolean isCenterTextWordWrapEnabled() {
        return this.mCenterTextWordWrapEnabled;
    }

    public void setCenterTextRadiusPercent(float f) {
        this.mCenterTextRadiusPercent = f;
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }
}
