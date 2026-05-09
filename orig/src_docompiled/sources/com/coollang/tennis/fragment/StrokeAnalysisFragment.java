package com.coollang.tennis.fragment;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.SportDetailActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.SportDetailBean;
import com.coollang.tennis.widget.CountView;
import com.coollang.tennis.widget.HandView;
import com.coollang.tennis.widget.SportCircleProgressView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.C1808is;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1900mc;
import p000.C1902me;
import p000.C1914mm;
import p000.C1930nb;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class StrokeAnalysisFragment extends BaseFragment implements View.OnClickListener, OnChartValueSelectedListener {

    /* JADX INFO: renamed from: A */
    private RelativeLayout f7705A;

    /* JADX INFO: renamed from: B */
    private HandView f7706B;

    /* JADX INFO: renamed from: C */
    private LinearLayout f7707C;

    /* JADX INFO: renamed from: D */
    private TextView f7708D;

    /* JADX INFO: renamed from: E */
    private TextView f7709E;

    /* JADX INFO: renamed from: F */
    private TextView f7710F;

    /* JADX INFO: renamed from: G */
    private LinearLayout f7711G;

    /* JADX INFO: renamed from: H */
    private RelativeLayout f7712H;

    /* JADX INFO: renamed from: I */
    private SportDetailBean f7713I;

    /* JADX INFO: renamed from: M */
    private float f7717M;

    /* JADX INFO: renamed from: N */
    private float f7718N;

    /* JADX INFO: renamed from: S */
    private ArrayList<String> f7723S;

    /* JADX INFO: renamed from: T */
    private ArrayList<Entry> f7724T;

    /* JADX INFO: renamed from: U */
    private int f7725U;

    /* JADX INFO: renamed from: a */
    public LinearLayout f7726a;

    /* JADX INFO: renamed from: b */
    float[] f7727b;

    /* JADX INFO: renamed from: d */
    String[] f7729d;

    /* JADX INFO: renamed from: e */
    private PieChart f7730e;

    /* JADX INFO: renamed from: f */
    private TextView f7731f;

    /* JADX INFO: renamed from: g */
    private TextView f7732g;

    /* JADX INFO: renamed from: h */
    private TextView f7733h;

    /* JADX INFO: renamed from: i */
    private SportCircleProgressView f7734i;

    /* JADX INFO: renamed from: j */
    private CountView f7735j;

    /* JADX INFO: renamed from: k */
    private SportCircleProgressView f7736k;

    /* JADX INFO: renamed from: l */
    private CountView f7737l;

    /* JADX INFO: renamed from: m */
    private SportCircleProgressView f7738m;

    /* JADX INFO: renamed from: n */
    private CountView f7739n;

    /* JADX INFO: renamed from: o */
    private CombinedChart f7740o;

    /* JADX INFO: renamed from: p */
    private TextView f7741p;

    /* JADX INFO: renamed from: q */
    private RadioGroup f7742q;

    /* JADX INFO: renamed from: r */
    private TextView f7743r;

    /* JADX INFO: renamed from: s */
    private TextView f7744s;

    /* JADX INFO: renamed from: t */
    private TextView f7745t;

    /* JADX INFO: renamed from: u */
    private TextView f7746u;

    /* JADX INFO: renamed from: v */
    private TextView f7747v;

    /* JADX INFO: renamed from: w */
    private TextView f7748w;

    /* JADX INFO: renamed from: x */
    private TextView f7749x;

    /* JADX INFO: renamed from: y */
    private RelativeLayout f7750y;

    /* JADX INFO: renamed from: z */
    private RelativeLayout f7751z;

    /* JADX INFO: renamed from: J */
    private ArrayList<Integer> f7714J = new ArrayList<>();

    /* JADX INFO: renamed from: K */
    private boolean f7715K = false;

    /* JADX INFO: renamed from: L */
    private boolean f7716L = false;

    /* JADX INFO: renamed from: O */
    private ValueFormatter f7719O = new ValueFormatter() { // from class: com.coollang.tennis.fragment.StrokeAnalysisFragment.1
        @Override // com.github.mikephil.charting.utils.ValueFormatter
        public String getFormattedValue(float f) {
            return String.valueOf((int) f);
        }
    };

    /* JADX INFO: renamed from: P */
    private ValueFormatter f7720P = new ValueFormatter() { // from class: com.coollang.tennis.fragment.StrokeAnalysisFragment.2
        @Override // com.github.mikephil.charting.utils.ValueFormatter
        public String getFormattedValue(float f) {
            return String.format("%.01f", Float.valueOf(f)) + "%";
        }
    };

    /* JADX INFO: renamed from: Q */
    private Handler f7721Q = new Handler() { // from class: com.coollang.tennis.fragment.StrokeAnalysisFragment.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            StrokeAnalysisFragment.this.m7956e();
        }
    };

    /* JADX INFO: renamed from: c */
    String[] f7728c = {C1914mm.m10557b(R.string.pingji), C1914mm.m10557b(R.string.xuanqiu), C1914mm.m10557b(R.string.xiaoqiu), C1914mm.m10557b(R.string.jieqiu), C1914mm.m10557b(R.string.kousha), C1914mm.m10557b(R.string.faqiu)};

    /* JADX INFO: renamed from: R */
    private int[] f7722R = {Color.parseColor("#a489d6"), Color.parseColor("#f06fa4"), Color.parseColor("#f88360"), Color.parseColor("#f8c353"), Color.parseColor("#72deae"), Color.parseColor("#7abeea")};

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onNothingSelected() {
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onValueSelected(Entry entry, int i, Highlight highlight) {
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return C1914mm.m10555a(R.layout.fragment_stroke_analysis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7948b() {
        C1900mc.m10474b("initTime", "StrokeAnalysisFragment == initDatabase == " + System.currentTimeMillis());
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * From mydetailtable Where sign2 = ? And UserID = ? order by timestamp asc", ((SportDetailActivity) getActivity()).f6906a.replace("-", ""), C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1"));
        if (cursorFindBySQL.getCount() != 0) {
            while (cursorFindBySQL.moveToNext()) {
                this.f7714J.add(Integer.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("speed"))));
            }
        }
        C1808is.m9827c(this.f7714J);
        cursorFindBySQL.close();
        this.f7715K = true;
        C1900mc.m10474b("initTime", "end = StrokeAnalysisFragment == initDatabase == " + System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: c */
    private void m7953c() {
        new Thread(new Runnable() { // from class: com.coollang.tennis.fragment.StrokeAnalysisFragment.4
            @Override // java.lang.Runnable
            public void run() {
                StrokeAnalysisFragment.this.m7948b();
                StrokeAnalysisFragment.this.f7721Q.sendEmptyMessage(1);
            }
        }).start();
    }

    /* JADX INFO: renamed from: d */
    private void m7955d() {
        this.f7730e.setUsePercentValues(false);
        this.f7730e.setDescription("");
        this.f7730e.setDragDecelerationFrictionCoef(0.95f);
        this.f7730e.setDrawHoleEnabled(true);
        this.f7730e.setHoleColorTransparent(true);
        this.f7730e.setHoleRadius(60.0f);
        this.f7730e.setTransparentCircleRadius(65.0f);
        this.f7730e.setTransparentCircleColor(Color.parseColor("#3F000000"));
        this.f7730e.setDrawCenterText(true);
        this.f7730e.setRotationAngle(180.0f);
        this.f7730e.setRotationEnabled(true);
        this.f7730e.setOnChartValueSelectedListener(this);
        m7942a(6);
        this.f7730e.getLegend().setEnabled(false);
        this.f7730e.animateY(1500, Easing.EasingOption.EaseInOutQuad);
    }

    /* JADX INFO: renamed from: a */
    private void m7942a(int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7727b.length; i3++) {
            i2 = (int) (i2 + this.f7727b[i3]);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            if (this.f7727b[i5] >= 1.0f) {
                arrayList.add(new Entry(this.f7727b[i5], i4));
                arrayList2.add(Integer.valueOf(this.f7722R[i5]));
                i4++;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < i; i6++) {
            if (this.f7727b[i6] >= 1.0f) {
                if ((this.f7727b[i6] * 100.0f) / i2 < 5.0f) {
                    arrayList3.add(" ");
                } else {
                    arrayList3.add(this.f7728c[i6]);
                }
            }
        }
        int[] iArr = new int[arrayList2.size()];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            iArr[i7] = ((Integer) arrayList2.get(i7)).intValue();
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setSliceSpace(0.0f);
        pieDataSet.setSelectionShift(5.0f);
        pieDataSet.setColors(iArr);
        pieDataSet.setSelectionShift(10.0f);
        PieData pieData = new PieData(arrayList3, pieDataSet);
        pieData.setValueFormatter(this.f7719O);
        pieData.setValueTextSize(11.0f);
        pieData.setValueTextColor(-1);
        this.f7730e.setData(pieData);
        this.f7730e.highlightValues(null);
        this.f7730e.setHorizontalFadingEdgeEnabled(true);
        this.f7730e.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m7956e() {
        if (!this.f7715K || this.f7713I == null) {
            return;
        }
        String str = this.f7713I.errDesc.Duration;
        if (str == null || "".equals(str)) {
            str = "0";
        }
        m7946a(this.f7740o, str);
    }

    /* JADX INFO: renamed from: a */
    private void m7946a(CombinedChart combinedChart, String str) {
        int i = Integer.parseInt(str) / 10;
        this.f7729d = new String[11];
        for (int i2 = 0; i2 <= 10; i2++) {
            this.f7729d[i2] = String.valueOf(i * i2);
        }
        this.f7725U = Integer.parseInt(str);
        if (this.f7725U < 10) {
            this.f7741p.setVisibility(0);
        } else {
            this.f7741p.setVisibility(8);
        }
        combinedChart.setDescription("");
        combinedChart.setNoDataTextDescription(C1914mm.m10557b(R.string.no_data));
        combinedChart.setHighlightEnabled(true);
        combinedChart.setTouchEnabled(true);
        combinedChart.setDragDecelerationFrictionCoef(0.9f);
        combinedChart.setDragEnabled(true);
        combinedChart.setScaleEnabled(false);
        combinedChart.setDrawGridBackground(false);
        combinedChart.setHighlightPerDragEnabled(true);
        combinedChart.setPinchZoom(true);
        combinedChart.setBackgroundColor(Color.parseColor("#f7f7f7"));
        combinedChart.animateX(1500);
        Legend legend = combinedChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(10.0f);
        legend.setTextColor(Color.parseColor("#dededf"));
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
        legend.setXEntrySpace(30.0f);
        legend.setYEntrySpace(20.0f);
        legend.setYOffset(180.0f);
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setTextSize(10.0f);
        xAxis.setTextColor(Color.parseColor("#dededf"));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(Color.parseColor("#dededf"));
        xAxis.setSpaceBetweenLabels(1);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        if (this.f7725U >= 10) {
            xAxis.setDrawLabels(true);
        } else {
            xAxis.setDrawLabels(false);
        }
        CombinedData combinedData = new CombinedData(this.f7729d);
        combinedData.setValueTextColor(Color.parseColor("#dededf"));
        YAxis axisLeft = combinedChart.getAxisLeft();
        YAxis axisRight = combinedChart.getAxisRight();
        axisRight.setXOffset(5.0f);
        axisRight.setTextColor(Color.parseColor("#dededf"));
        axisRight.setGridColor(Color.parseColor("#dededf"));
        axisRight.setAxisLineWidth(0.0f);
        axisRight.setAxisMaxValue(200.0f);
        axisRight.setLabelCount(5);
        axisRight.setAxisMinValue(0.0f);
        axisRight.resetAxisMinValue();
        axisRight.setDrawGridLines(true);
        axisRight.setDrawAxisLine(false);
        axisRight.setDrawLabels(false);
        axisLeft.setTextColor(Color.parseColor("#dededf"));
        axisLeft.setAxisLineColor(0);
        axisLeft.setAxisMaxValue(200.0f);
        axisLeft.setLabelCount(5);
        axisLeft.setAxisMinValue(0.1f);
        axisLeft.setDrawLabels(true);
        axisLeft.setStartAtZero(false);
        axisLeft.setDrawGridLines(true);
        axisLeft.setGridColor(Color.parseColor("#dededf"));
        axisLeft.setAxisLineWidth(0.0f);
        axisLeft.setXOffset(5.0f);
        axisLeft.setValueFormatter(this.f7719O);
        combinedData.setData(m7957f());
        combinedChart.setData(combinedData);
        C1900mc.m10475c("Tagg", ">>>>>>>>>");
    }

    /* JADX INFO: renamed from: f */
    private LineData m7957f() {
        this.f7723S = new ArrayList<>();
        this.f7724T = new ArrayList<>();
        for (int i = 0; i < this.f7729d.length; i++) {
            this.f7723S.add(i + "");
        }
        if (this.f7724T.size() != 0) {
            this.f7724T.clear();
        }
        if (this.f7725U >= 10) {
            m7958g();
        } else {
            this.f7724T.add(new Entry(0.0f, 0));
            this.f7724T.add(new Entry(40.0f, 1));
            this.f7724T.add(new Entry(40.0f, 2));
            this.f7724T.add(new Entry(80.0f, 3));
            this.f7724T.add(new Entry(80.0f, 4));
            this.f7724T.add(new Entry(120.0f, 5));
            this.f7724T.add(new Entry(120.0f, 6));
            this.f7724T.add(new Entry(160.0f, 7));
            this.f7724T.add(new Entry(160.0f, 8));
            this.f7724T.add(new Entry(200.0f, 9));
            this.f7724T.add(new Entry(200.0f, 10));
        }
        LineDataSet lineDataSet = new LineDataSet(this.f7724T, "");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setColor(Color.parseColor("#25c9ad"));
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setCircleSize(0.0f);
        lineDataSet.setFillAlpha(30);
        lineDataSet.setFillColor(Color.parseColor("#25c9ad"));
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawCubic(true);
        lineDataSet.setDrawValues(false);
        if (this.f7725U >= 10) {
            lineDataSet.setVisible(true);
        } else {
            lineDataSet.setVisible(false);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineDataSet);
        LineData lineData = new LineData(this.f7723S, arrayList);
        lineData.setValueTextColor(Color.parseColor("#dededf"));
        lineData.setValueTextSize(10.0f);
        return lineData;
    }

    /* JADX INFO: renamed from: g */
    private void m7958g() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int size = this.f7714J.size() / 10;
        int iIntValue = 0;
        for (int i9 = 0; i9 < size; i9++) {
            iIntValue += this.f7714J.get(i9).intValue();
        }
        int i10 = size;
        int iIntValue2 = 0;
        while (true) {
            i = size * 2;
            if (i10 >= i) {
                break;
            }
            iIntValue2 += this.f7714J.get(i10).intValue();
            i10++;
        }
        int iIntValue3 = 0;
        while (true) {
            i2 = size * 3;
            if (i >= i2) {
                break;
            }
            iIntValue3 += this.f7714J.get(i).intValue();
            i++;
        }
        int iIntValue4 = 0;
        while (true) {
            i3 = size * 4;
            if (i2 >= i3) {
                break;
            }
            iIntValue4 += this.f7714J.get(i2).intValue();
            i2++;
        }
        int iIntValue5 = 0;
        while (true) {
            i4 = size * 5;
            if (i3 >= i4) {
                break;
            }
            iIntValue5 += this.f7714J.get(i3).intValue();
            i3++;
        }
        int iIntValue6 = 0;
        while (true) {
            i5 = size * 6;
            if (i4 >= i5) {
                break;
            }
            iIntValue6 += this.f7714J.get(i4).intValue();
            i4++;
        }
        int iIntValue7 = 0;
        while (true) {
            i6 = size * 7;
            if (i5 >= i6) {
                break;
            }
            iIntValue7 += this.f7714J.get(i5).intValue();
            i5++;
        }
        int iIntValue8 = 0;
        while (true) {
            i7 = size * 8;
            if (i6 >= i7) {
                break;
            }
            iIntValue8 += this.f7714J.get(i6).intValue();
            i6++;
        }
        int iIntValue9 = 0;
        while (true) {
            i8 = size * 9;
            if (i7 >= i8) {
                break;
            }
            iIntValue9 += this.f7714J.get(i7).intValue();
            i7++;
        }
        int iIntValue10 = 0;
        while (i8 < size * 10) {
            iIntValue10 += this.f7714J.get(i8).intValue();
            i8++;
        }
        double d = size;
        float f = (float) ((((double) iIntValue) * 1.0d) / d);
        float f2 = (float) ((((double) iIntValue2) * 1.0d) / d);
        float f3 = (float) ((((double) iIntValue4) * 1.0d) / d);
        float f4 = (float) ((((double) iIntValue5) * 1.0d) / d);
        float f5 = (float) ((((double) iIntValue6) * 1.0d) / d);
        float f6 = (float) ((((double) iIntValue7) * 1.0d) / d);
        float f7 = (float) ((((double) iIntValue8) * 1.0d) / d);
        this.f7724T.add(new Entry(f, 0));
        this.f7724T.add(new Entry(f, 1));
        this.f7724T.add(new Entry(f2, 2));
        this.f7724T.add(new Entry((float) ((((double) iIntValue3) * 1.0d) / d), 3));
        this.f7724T.add(new Entry(f3, 4));
        this.f7724T.add(new Entry(f4, 5));
        this.f7724T.add(new Entry(f5, 6));
        this.f7724T.add(new Entry(f6, 7));
        this.f7724T.add(new Entry(f7, 8));
        this.f7724T.add(new Entry((float) ((((double) iIntValue9) * 1.0d) / d), 9));
        this.f7724T.add(new Entry((float) ((((double) iIntValue10) * 1.0d) / d), 10));
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        C1900mc.m10474b("startTime", "StrokeAnalysisFragment ==  initView  ==  " + System.currentTimeMillis());
        C1900mc.m10474b("endTime", "StrokeAnalysisFragment ==  initView  ==  " + System.currentTimeMillis());
        m7950b(view);
        m7946a(this.f7740o, "0");
        m7953c();
        m7959h();
    }

    /* JADX INFO: renamed from: b */
    private void m7950b(View view) {
        this.f7730e = (PieChart) view.findViewById(R.id.pie_chart);
        this.f7731f = (TextView) view.findViewById(R.id.fragment_stroke_analysis_tv_data);
        this.f7732g = (TextView) view.findViewById(R.id.tv_content_count_data);
        this.f7733h = (TextView) view.findViewById(R.id.fragment_stroke_analysis_tv_type);
        this.f7734i = (SportCircleProgressView) view.findViewById(R.id.circleView1);
        this.f7735j = (CountView) view.findViewById(R.id.countview_sport_circleView1);
        this.f7736k = (SportCircleProgressView) view.findViewById(R.id.circleView2);
        this.f7737l = (CountView) view.findViewById(R.id.countview_sport_circleView2);
        this.f7738m = (SportCircleProgressView) view.findViewById(R.id.circleView3);
        this.f7739n = (CountView) view.findViewById(R.id.countview_sport_circleView3);
        this.f7740o = (CombinedChart) view.findViewById(R.id.combined_chart);
        this.f7726a = (LinearLayout) view.findViewById(R.id.fragment_stroke_analysis_ll_share);
        this.f7741p = (TextView) view.findViewById(R.id.fragment_stroke_analysis_tv_cannot_draw_line);
        this.f7742q = (RadioGroup) view.findViewById(R.id.rg_data_type_sport_detail);
        this.f7743r = (TextView) view.findViewById(R.id.tv_xuan_front);
        this.f7744s = (TextView) view.findViewById(R.id.tv_xuan_back);
        this.f7745t = (TextView) view.findViewById(R.id.tv_ping_front);
        this.f7746u = (TextView) view.findViewById(R.id.tv_ping_back);
        this.f7747v = (TextView) view.findViewById(R.id.tv_xiao_front);
        this.f7748w = (TextView) view.findViewById(R.id.tv_xiao_back);
        this.f7749x = (TextView) view.findViewById(R.id.tv_faqiu);
        this.f7750y = (RelativeLayout) view.findViewById(R.id.rl_power_sport_detail);
        this.f7751z = (RelativeLayout) view.findViewById(R.id.rl_keep_sport_detail);
        this.f7705A = (RelativeLayout) view.findViewById(R.id.rl_deep_sport_detail);
        this.f7706B = (HandView) view.findViewById(R.id.hand_view_sport_detail);
        this.f7707C = (LinearLayout) view.findViewById(R.id.ll_data_content_sport_detail);
        this.f7708D = (TextView) view.findViewById(R.id.tv_level_strength_sport_detail);
        this.f7709E = (TextView) view.findViewById(R.id.tv_level_keep_sport_detail);
        this.f7710F = (TextView) view.findViewById(R.id.tv_level_deep_radio_detail);
        this.f7711G = (LinearLayout) view.findViewById(R.id.ll_sport_detail_speed);
        this.f7712H = (RelativeLayout) view.findViewById(R.id.rl_pie_chart_center);
        TextView textView = (TextView) view.findViewById(R.id.tv_title1);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_title2);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_title3);
        if (MyApplication.m7738a().m7748h()) {
            textView.setTextSize(10.0f);
            textView2.setTextSize(10.0f);
            textView3.setTextSize(10.0f);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m7959h() {
        this.f7705A.setOnClickListener(this);
        this.f7751z.setOnClickListener(this);
        this.f7750y.setOnClickListener(this);
        this.f7740o.setOnClickListener(this);
        this.f7706B.setOnClickListener(this);
        this.f7711G.setOnClickListener(this);
        this.f7712H.setOnClickListener(this);
        this.f7742q.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.fragment.StrokeAnalysisFragment.5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != R.id.rb_average_sport_detail) {
                    if (i == R.id.rb_max_sport_detail && StrokeAnalysisFragment.this.f7713I != null) {
                        StrokeAnalysisFragment.this.m7947a(StrokeAnalysisFragment.this.f7713I.errDesc.MaxTypeSpeedData);
                        return;
                    }
                    return;
                }
                if (StrokeAnalysisFragment.this.f7713I != null) {
                    StrokeAnalysisFragment.this.m7947a(StrokeAnalysisFragment.this.f7713I.errDesc.AvgTypeSpeedData);
                }
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        akd.m1706a().m1719a(this);
        ada.m302b(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
        ada.m301a(getActivity());
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 9) {
            C1900mc.m10473a("event.what", "event.what=" + c1873lc.f11065b);
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("StrokeAnalysisFragment", "获取运动详情服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("StrokeAnalysisFragment", "获取运动详情失败");
                    break;
                case 1:
                    C1900mc.m10475c("StrokeAnalysisFragment", "获取运动详情成功  msg == " + c1873lc.f11064a);
                    this.f7713I = (SportDetailBean) new GsonBuilder().registerTypeAdapter(SportDetailBean.class, new SportDetailBean.DetailDeserilizer()).create().fromJson(c1873lc.f11064a, SportDetailBean.class);
                    if (MyApplication.m7738a().m7747g()) {
                        C1902me.m10484a(getActivity(), c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), C1852ki.f10918e + c1873lc.f11067d, true);
                    } else {
                        C1902me.m10484a(getActivity(), "english" + c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), "english" + C1852ki.f10918e + c1873lc.f11067d, true);
                    }
                    mo7736a();
                    break;
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        if (this.f7713I != null) {
            C1808is.m9827c(this.f7713I);
            float f = Float.parseFloat(this.f7713I.errDesc.TypeCount.PingJi);
            float f2 = Float.parseFloat(this.f7713I.errDesc.TypeCount.XuanQiu);
            float f3 = Float.parseFloat(this.f7713I.errDesc.TypeCount.XueQiu);
            float f4 = Float.parseFloat(this.f7713I.errDesc.TypeCount.JieJi);
            float f5 = Float.parseFloat(this.f7713I.errDesc.TypeCount.GaoYa);
            float f6 = Float.parseFloat(this.f7713I.errDesc.TypeCount.FaQiu);
            this.f7717M = f + f2 + f3 + f4 + f5 + f6;
            this.f7718N = (f4 + f5) / (this.f7717M - f6);
            m7963l();
            this.f7727b = new float[]{f, f2, f3, f4, f5, f6};
            m7955d();
            m7956e();
            float f7 = Float.parseFloat(this.f7713I.errDesc.SpeedPercent) * 100.0f;
            float f8 = Float.parseFloat(this.f7713I.errDesc.DurationPercent) * 100.0f;
            float f9 = Float.parseFloat(this.f7713I.errDesc.HitPercent) * 100.0f;
            this.f7734i.setProgress(f7);
            this.f7735j.m8107a((int) f7, 1200);
            this.f7736k.setProgress(f8);
            this.f7737l.m8107a((int) f8, 1200);
            this.f7738m.setProgress(f9);
            this.f7739n.m8107a((int) f9, 1200);
            m7941a(f7, f8, f9);
            if (this.f7713I.errDesc.ForeHandPercent != null && !"".equals(this.f7713I.errDesc.ForeHandPercent)) {
                this.f7706B.setFontPercent(Integer.parseInt(this.f7713I.errDesc.ForeHandPercent));
            }
            if ("0".equals(this.f7713I.errDesc.ForeHandPercent) && "0".equals(this.f7713I.errDesc.BackHandPercent)) {
                this.f7706B.setFontPercent(50);
            }
            m7947a(this.f7713I.errDesc.AvgTypeSpeedData);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7941a(float f, float f2, float f3) {
        if (f >= 90.0f) {
            this.f7708D.setText(R.string.strength_good_level);
        } else if (f >= 80.0f) {
            this.f7708D.setText(R.string.strength_ok_level);
        } else if (f >= 60.0f) {
            this.f7708D.setText(R.string.strength_middle_level);
        } else {
            this.f7708D.setText(R.string.strength_bad_level);
        }
        if (f2 >= 90.0f) {
            this.f7709E.setText(R.string.keep_good_level);
        } else if (f2 >= 80.0f) {
            this.f7709E.setText(R.string.keep_ok_level);
        } else if (f2 >= 60.0f) {
            this.f7709E.setText(R.string.keep_middle_level);
        } else {
            this.f7709E.setText(R.string.keep_bad_level);
        }
        if (f3 >= 80.0f) {
            this.f7710F.setText(R.string.deep_high_level);
        } else if (f3 >= 60.0f) {
            this.f7710F.setText(R.string.deep_middle_level);
        } else {
            this.f7710F.setText(R.string.deep_low_level);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7947a(List<Object> list) {
        if (list == null || list.isEmpty() || list.size() < 6) {
            m7961j();
            return;
        }
        if (((String) list.get(0)).equals("0")) {
            this.f7749x.setText("--");
        } else {
            this.f7749x.setText((String) list.get(0));
        }
        m7943a(this.f7743r, m7940a(list.get(4), 0));
        m7943a(this.f7744s, m7940a(list.get(4), 1));
        m7943a(this.f7745t, m7940a(list.get(5), 0));
        m7943a(this.f7746u, m7940a(list.get(5), 1));
        m7943a(this.f7747v, m7940a(list.get(3), 0));
        m7943a(this.f7748w, m7940a(list.get(3), 1));
        m7960i();
    }

    /* JADX INFO: renamed from: i */
    private void m7960i() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.f7749x.startAnimation(alphaAnimation);
        this.f7743r.startAnimation(alphaAnimation);
        this.f7744s.startAnimation(alphaAnimation);
        this.f7745t.startAnimation(alphaAnimation);
        this.f7746u.startAnimation(alphaAnimation);
        this.f7747v.startAnimation(alphaAnimation);
        this.f7748w.startAnimation(alphaAnimation);
    }

    /* JADX INFO: renamed from: a */
    private void m7943a(TextView textView, String str) {
        if (str == null || "0".equals(str)) {
            textView.setText("--");
        } else {
            textView.setText(str);
        }
    }

    /* JADX INFO: renamed from: j */
    private void m7961j() {
        this.f7743r.setText("--");
        this.f7744s.setText("--");
        this.f7745t.setText("--");
        this.f7746u.setText("--");
        this.f7747v.setText("--");
        this.f7748w.setText("--");
        this.f7749x.setText("--");
    }

    /* JADX INFO: renamed from: a */
    private String m7940a(Object obj, int i) {
        return (String) ((List) obj).get(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.combined_chart /* 2131296490 */:
                m7949b(3);
                break;
            case R.id.hand_view_sport_detail /* 2131296616 */:
                m7949b(4);
                break;
            case R.id.ll_sport_detail_speed /* 2131296846 */:
                m7949b(5);
                break;
            case R.id.rl_deep_sport_detail /* 2131297026 */:
                m7949b(2);
                break;
            case R.id.rl_keep_sport_detail /* 2131297030 */:
                m7949b(1);
                break;
            case R.id.rl_pie_chart_center /* 2131297035 */:
                m7962k();
                break;
            case R.id.rl_power_sport_detail /* 2131297037 */:
                m7949b(0);
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m7949b(int i) {
        new C1930nb(getActivity(), i).m10726a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: k */
    private void m7962k() {
        if (this.f7730e.isUsePercentValuesEnabled()) {
            ((PieData) this.f7730e.getData()).setValueFormatter(this.f7719O);
            this.f7730e.setUsePercentValues(false);
            m7963l();
        } else {
            ((PieData) this.f7730e.getData()).setValueFormatter(this.f7720P);
            this.f7730e.setUsePercentValues(true);
            m7964m();
        }
        this.f7730e.invalidate();
    }

    /* JADX INFO: renamed from: l */
    private void m7963l() {
        this.f7733h.setText(R.string.sport_pie_chart_hit_top);
        this.f7731f.setVisibility(8);
        this.f7732g.setVisibility(0);
        this.f7732g.setText(String.valueOf((int) this.f7717M));
    }

    /* JADX INFO: renamed from: m */
    private void m7964m() {
        this.f7733h.setText(R.string.sport_resport_16);
        this.f7731f.setVisibility(0);
        this.f7732g.setVisibility(8);
        m7965n();
    }

    /* JADX INFO: renamed from: n */
    private void m7965n() {
        if (this.f7718N < 0.2d) {
            this.f7731f.setText(C1914mm.m10557b(R.string.sport_resport_17));
        } else if (this.f7718N > 0.4d) {
            this.f7731f.setText(C1914mm.m10557b(R.string.sport_resport_18));
        } else {
            this.f7731f.setText(C1914mm.m10557b(R.string.sport_resport_19));
        }
    }
}
