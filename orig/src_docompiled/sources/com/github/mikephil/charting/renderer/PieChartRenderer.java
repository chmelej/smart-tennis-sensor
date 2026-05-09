package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private String mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected Bitmap mDrawBitmap;
    protected Paint mHolePaint;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mChart = pieChart;
        this.mHolePaint = new Paint(1);
        this.mHolePaint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint = new Paint(1);
        this.mTransparentCirclePaint.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mCenterTextPaint = new TextPaint(1);
        this.mCenterTextPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mCenterTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        if (this.mDrawBitmap == null || this.mDrawBitmap.getWidth() != chartWidth || this.mDrawBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            this.mDrawBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mBitmapCanvas = new Canvas(this.mDrawBitmap);
        }
        this.mDrawBitmap.eraseColor(0);
        for (PieDataSet pieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (pieDataSet.isVisible()) {
                drawDataSet(canvas, pieDataSet);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, PieDataSet pieDataSet) {
        float rotationAngle = this.mChart.getRotationAngle();
        List<Entry> yVals = pieDataSet.getYVals();
        float[] drawAngles = this.mChart.getDrawAngles();
        for (int i = 0; i < yVals.size(); i++) {
            float f = drawAngles[i];
            float sliceSpace = pieDataSet.getSliceSpace();
            Entry entry = yVals.get(i);
            if (Math.abs(entry.getVal()) > 1.0E-6d && !this.mChart.needsHighlight(entry.getXIndex(), ((PieData) this.mChart.getData()).getIndexOfDataSet(pieDataSet))) {
                this.mRenderPaint.setColor(pieDataSet.getColor(i));
                float f2 = sliceSpace / 2.0f;
                this.mBitmapCanvas.drawArc(this.mChart.getCircleBox(), (rotationAngle + f2) * this.mAnimator.getPhaseY(), (f - f2) * this.mAnimator.getPhaseY(), true, this.mRenderPaint);
            }
            rotationAngle += f * this.mAnimator.getPhaseX();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i;
        List<Entry> list;
        float val;
        float f;
        float[] fArr;
        PieData pieData;
        int i2;
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            holeRadius = (radius - ((radius / 100.0f) * this.mChart.getHoleRadius())) / 2.0f;
        }
        float f2 = radius - holeRadius;
        PieData pieData2 = (PieData) this.mChart.getData();
        List<PieDataSet> dataSets = pieData2.getDataSets();
        boolean zIsDrawSliceTextEnabled = this.mChart.isDrawSliceTextEnabled();
        int i3 = 0;
        int i4 = 0;
        while (i3 < dataSets.size()) {
            PieDataSet pieDataSet = dataSets.get(i3);
            if (pieDataSet.isDrawValuesEnabled() || zIsDrawSliceTextEnabled) {
                applyValueTextStyle(pieDataSet);
                List<Entry> yVals = pieDataSet.getYVals();
                int iMin = Math.min((int) Math.ceil(yVals.size() * this.mAnimator.getPhaseX()), yVals.size());
                int i5 = 0;
                while (i5 < iMin) {
                    float f3 = drawAngles[i4] / 2.0f;
                    PieData pieData3 = pieData2;
                    List<PieDataSet> list2 = dataSets;
                    double d = f2;
                    float f4 = f2;
                    int i6 = iMin;
                    int i7 = i5;
                    boolean z = zIsDrawSliceTextEnabled;
                    List<Entry> list3 = yVals;
                    float fCos = (float) ((Math.cos(Math.toRadians(this.mAnimator.getPhaseY() * ((rotationAngle + absoluteAngles[i4]) - f3))) * d) + ((double) centerCircleBox.x));
                    float fSin = (float) ((d * Math.sin(Math.toRadians(((absoluteAngles[i4] + rotationAngle) - f3) * this.mAnimator.getPhaseY()))) + ((double) centerCircleBox.y));
                    if (this.mChart.isUsePercentValuesEnabled()) {
                        i = i7;
                        list = list3;
                        val = (list.get(i).getVal() / this.mChart.getYValueSum()) * 100.0f;
                    } else {
                        i = i7;
                        list = list3;
                        val = list.get(i).getVal();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(val);
                    PointF pointF = centerCircleBox;
                    sb.append("");
                    Log.i("PieChart", sb.toString());
                    if (this.mChart.isUsePercentValuesEnabled() && i == i6 - 1) {
                        int i8 = 0;
                        float f5 = 0.0f;
                        while (i8 < i2) {
                            f5 += Float.parseFloat(formatData(String.format("%.01f", Float.valueOf((list.get(i8).getVal() / this.mChart.getYValueSum()) * 100.0f))));
                            i8++;
                            i2 = i2;
                            rotationAngle = rotationAngle;
                            drawAngles = drawAngles;
                        }
                        f = rotationAngle;
                        fArr = drawAngles;
                        Log.i("PieChart", "other == " + f5);
                        val = 100.0f - f5;
                        Log.i("PieChart", "end == " + val);
                    } else {
                        f = rotationAngle;
                        fArr = drawAngles;
                    }
                    String formattedValue = pieDataSet.getValueFormatter().getFormattedValue(val);
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, formattedValue) + Utils.convertDpToPixel(4.0f);
                    boolean zIsDrawValuesEnabled = pieDataSet.isDrawValuesEnabled();
                    if (z && zIsDrawValuesEnabled) {
                        pieData = pieData3;
                        canvas.drawText(pieData.getXVals().get(i), fCos, fSin, this.mValuePaint);
                        if (i < pieData.getXValCount()) {
                            if (pieData.getXVals().get(i).equals(" ")) {
                                canvas.drawText(formattedValue, fCos, fSin + (fCalcTextHeight / 2.0f), this.mValuePaint);
                            } else {
                                canvas.drawText(formattedValue, fCos, fSin + fCalcTextHeight, this.mValuePaint);
                            }
                        }
                    } else {
                        pieData = pieData3;
                        if (!z || zIsDrawValuesEnabled) {
                            if (!z && zIsDrawValuesEnabled) {
                                canvas.drawText(formattedValue, fCos, fSin + (fCalcTextHeight / 2.0f), this.mValuePaint);
                            }
                        } else if (i < pieData.getXValCount()) {
                            canvas.drawText(pieData.getXVals().get(i), fCos, fSin + (fCalcTextHeight / 2.0f), this.mValuePaint);
                        }
                        i4++;
                        i5 = i + 1;
                        pieData2 = pieData;
                        f2 = f4;
                        iMin = i6;
                        zIsDrawSliceTextEnabled = z;
                        centerCircleBox = pointF;
                        rotationAngle = f;
                        drawAngles = fArr;
                        yVals = list;
                        dataSets = list2;
                    }
                    i4++;
                    i5 = i + 1;
                    pieData2 = pieData;
                    f2 = f4;
                    iMin = i6;
                    zIsDrawSliceTextEnabled = z;
                    centerCircleBox = pointF;
                    rotationAngle = f;
                    drawAngles = fArr;
                    yVals = list;
                    dataSets = list2;
                }
            }
            i3++;
            pieData2 = pieData2;
            dataSets = dataSets;
            f2 = f2;
            zIsDrawSliceTextEnabled = zIsDrawSliceTextEnabled;
            centerCircleBox = centerCircleBox;
            rotationAngle = rotationAngle;
            drawAngles = drawAngles;
        }
    }

    public String formatData(String str) {
        return str.contains(",") ? str.replace(",", ".") : str;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap, 0.0f, 0.0f, this.mRenderPaint);
        drawCenterText(canvas);
    }

    protected void drawHole(Canvas canvas) {
        if (this.mChart.isDrawHoleEnabled()) {
            float transparentCircleRadius = this.mChart.getTransparentCircleRadius();
            float holeRadius = this.mChart.getHoleRadius();
            float radius = this.mChart.getRadius();
            PointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (transparentCircleRadius > holeRadius && this.mAnimator.getPhaseX() >= 1.0f && this.mAnimator.getPhaseY() >= 1.0f) {
                int color = this.mTransparentCirclePaint.getColor();
                this.mTransparentCirclePaint.setColor(1627389951 & color);
                this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, (radius / 100.0f) * transparentCircleRadius, this.mTransparentCirclePaint);
                this.mTransparentCirclePaint.setColor(color);
            }
            this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, (radius / 100.0f) * holeRadius, this.mHolePaint);
        }
    }

    protected void drawCenterText(Canvas canvas) {
        String centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (this.mChart.isCenterTextWordWrapEnabled()) {
            float radius = (this.mChart.isDrawHoleEnabled() && this.mChart.isHoleTransparent()) ? this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f) : this.mChart.getRadius();
            RectF rectF = this.mRectBuffer[0];
            rectF.left = centerCircleBox.x - radius;
            rectF.top = centerCircleBox.y - radius;
            rectF.right = centerCircleBox.x + radius;
            rectF.bottom = centerCircleBox.y + radius;
            RectF rectF2 = this.mRectBuffer[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent();
            if (centerTextRadiusPercent > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
                this.mCenterTextLastBounds.set(rectF2);
                this.mCenterTextLastValue = centerText;
                this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            float height = this.mCenterTextLayout.getHeight();
            canvas.save();
            canvas.translate(rectF2.centerX(), rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.mCenterTextLayout.draw(canvas);
            canvas.restore();
            return;
        }
        String[] strArrSplit = centerText.split("\n");
        float f = 0.0f;
        for (String str : strArrSplit) {
            float fCalcTextHeight = Utils.calcTextHeight(this.mCenterTextPaint, str);
            if (fCalcTextHeight > f) {
                f = fCalcTextHeight;
            }
        }
        float f2 = 0.25f * f;
        float length = (strArrSplit.length * f) - ((strArrSplit.length - 1) * f2);
        int length2 = strArrSplit.length;
        float f3 = centerCircleBox.y;
        for (int i = 0; i < strArrSplit.length; i++) {
            canvas.drawText(strArrSplit[(strArrSplit.length - i) - 1], centerCircleBox.x, ((length2 * f) + f3) - (length / 2.0f), this.mCenterTextPaint);
            length2--;
            f3 -= f2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        PieDataSet dataSetByIndex;
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        for (int i = 0; i < highlightArr.length; i++) {
            int xIndex = highlightArr[i].getXIndex();
            if (xIndex < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr[i].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                float phaseY = (xIndex == 0 ? rotationAngle : absoluteAngles[xIndex - 1] + rotationAngle) * this.mAnimator.getPhaseY();
                float f = drawAngles[xIndex];
                float selectionShift = dataSetByIndex.getSelectionShift();
                RectF circleBox = this.mChart.getCircleBox();
                RectF rectF = new RectF(circleBox.left - selectionShift, circleBox.top - selectionShift, circleBox.right + selectionShift, circleBox.bottom + selectionShift);
                this.mRenderPaint.setColor(dataSetByIndex.getColor(xIndex));
                this.mBitmapCanvas.drawArc(rectF, phaseY + (dataSetByIndex.getSliceSpace() / 2.0f), (f * this.mAnimator.getPhaseY()) - (dataSetByIndex.getSliceSpace() / 2.0f), true, this.mRenderPaint);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        List<Entry> list;
        float[] fArr;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            PieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                PointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                List<Entry> yVals = dataSet.getYVals();
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < yVals.size()) {
                    float f = drawAngles[i];
                    if (Math.abs(yVals.get(i).getVal()) > 1.0E-6d) {
                        double d = radius - holeRadius;
                        float f2 = rotationAngle + f;
                        list = yVals;
                        fArr = drawAngles;
                        float fCos = (float) ((Math.cos(Math.toRadians(this.mAnimator.getPhaseY() * f2)) * d) + ((double) centerCircleBox.x));
                        float fSin = (float) ((d * Math.sin(Math.toRadians(f2 * this.mAnimator.getPhaseY()))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(fCos, fSin, holeRadius, this.mRenderPaint);
                    } else {
                        list = yVals;
                        fArr = drawAngles;
                    }
                    rotationAngle += f * this.mAnimator.getPhaseX();
                    i++;
                    yVals = list;
                    drawAngles = fArr;
                }
            }
        }
    }
}
