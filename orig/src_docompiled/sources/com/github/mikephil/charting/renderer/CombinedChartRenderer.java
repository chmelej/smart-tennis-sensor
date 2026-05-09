package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.interfaces.BarLineScatterCandleDataProvider;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CombinedChartRenderer extends DataRenderer {
    protected List<DataRenderer> mRenderers;

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        createRenderers(combinedChart, chartAnimator, viewPortHandler);
    }

    protected void createRenderers(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        this.mRenderers = new ArrayList();
        int length = combinedChart.getDrawOrder().length;
        for (int i = 0; i < length; i++) {
            switch (r0[i]) {
                case BAR:
                    if (combinedChart.getBarData() != null) {
                        this.mRenderers.add(new BarChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                    }
                    break;
                case BUBBLE:
                    if (combinedChart.getBubbleData() != null) {
                        this.mRenderers.add(new BubbleChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                    }
                    break;
                case LINE:
                    if (combinedChart.getLineData() != null) {
                        this.mRenderers.add(new LineChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                    }
                    break;
                case CANDLE:
                    if (combinedChart.getCandleData() != null) {
                        this.mRenderers.add(new CandleStickChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                    }
                    break;
                case SCATTER:
                    if (combinedChart.getScatterData() != null) {
                        this.mRenderers.add(new ScatterChartRenderer(combinedChart, chartAnimator, viewPortHandler));
                    }
                    break;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().initBuffers();
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawData(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawValues(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawExtras(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().drawHighlighted(canvas, highlightArr);
        }
    }

    @Override // com.github.mikephil.charting.renderer.Renderer
    public void calcXBounds(BarLineScatterCandleDataProvider barLineScatterCandleDataProvider, int i) {
        Iterator<DataRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            it.next().calcXBounds(barLineScatterCandleDataProvider, i);
        }
    }

    public DataRenderer getSubRenderer(int i) {
        if (i >= this.mRenderers.size() || i < 0) {
            return null;
        }
        return this.mRenderers.get(i);
    }
}
