package com.coollang.tennis.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.SportDetailBean;
import com.coollang.tennis.widget.CountView;
import com.coollang.tennis.widget.SportCircleProgressView;
import com.coollang.tennis.widget.SportReportChart;
import com.google.gson.GsonBuilder;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1914mm;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SportReportFragment extends BaseFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public SportCircleProgressView f7682a;

    /* JADX INFO: renamed from: b */
    public TextView f7683b;

    /* JADX INFO: renamed from: c */
    public TextView f7684c;

    /* JADX INFO: renamed from: d */
    public TextView f7685d;

    /* JADX INFO: renamed from: e */
    public TextView f7686e;

    /* JADX INFO: renamed from: f */
    public FrameLayout f7687f;

    /* JADX INFO: renamed from: g */
    public int f7688g;

    /* JADX INFO: renamed from: h */
    private CountView f7689h;

    /* JADX INFO: renamed from: i */
    private TextView f7690i;

    /* JADX INFO: renamed from: j */
    private TextView f7691j;

    /* JADX INFO: renamed from: k */
    private TextView f7692k;

    /* JADX INFO: renamed from: l */
    private TextView f7693l;

    /* JADX INFO: renamed from: m */
    private TextView f7694m;

    /* JADX INFO: renamed from: n */
    private TextView f7695n;

    /* JADX INFO: renamed from: o */
    private TextView f7696o;

    /* JADX INFO: renamed from: p */
    private TextView f7697p;

    /* JADX INFO: renamed from: q */
    private float f7698q;

    /* JADX INFO: renamed from: r */
    private float f7699r;

    /* JADX INFO: renamed from: s */
    private float f7700s;

    /* JADX INFO: renamed from: t */
    private SportDetailBean f7701t;

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return C1914mm.m10555a(R.layout.fragment_sport_report);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        m7938b(view);
        Typeface typeface = MyApplication.m7738a().f7404e;
        this.f7683b.setTypeface(typeface);
        this.f7684c.setTypeface(typeface);
        this.f7685d.setTypeface(typeface);
        this.f7686e.setTypeface(typeface);
        this.f7687f.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: b */
    private void m7938b(View view) {
        this.f7682a = (SportCircleProgressView) view.findViewById(R.id.sport_report_circle);
        this.f7689h = (CountView) view.findViewById(R.id.countview_sport_report);
        this.f7690i = (TextView) view.findViewById(R.id.tv_sport_time_title);
        this.f7683b = (TextView) view.findViewById(R.id.tv_sport_time_count);
        this.f7691j = (TextView) view.findViewById(R.id.tv_sport_per_min_title);
        this.f7684c = (TextView) view.findViewById(R.id.tv_sport_per_min_count);
        this.f7692k = (TextView) view.findViewById(R.id.tv_sport_cal_title);
        this.f7685d = (TextView) view.findViewById(R.id.tv_sport_cal_count);
        this.f7693l = (TextView) view.findViewById(R.id.tv_sport_max_speed_title);
        this.f7686e = (TextView) view.findViewById(R.id.tv_sport_max_speed_count);
        this.f7694m = (TextView) view.findViewById(R.id.tv_sport_time_desc);
        this.f7695n = (TextView) view.findViewById(R.id.tv_sport_per_min_desc);
        this.f7696o = (TextView) view.findViewById(R.id.tv_sport_cal_desc);
        this.f7697p = (TextView) view.findViewById(R.id.tv_sport_max_speed_desc);
        this.f7687f = (FrameLayout) view.findViewById(R.id.fragment_sport_resport_fl);
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
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("SportReportFragment", "获取运动详情服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("SportReportFragment", "获取运动详情失败");
                    break;
                case 1:
                    this.f7701t = (SportDetailBean) new GsonBuilder().registerTypeAdapter(SportDetailBean.class, new SportDetailBean.DetailDeserilizer()).create().fromJson(c1873lc.f11064a, SportDetailBean.class);
                    if (MyApplication.m7738a().m7747g()) {
                        C1902me.m10484a(getActivity(), c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), C1852ki.f10918e + c1873lc.f11067d, true);
                    } else if (MyApplication.m7738a().m7748h()) {
                        C1902me.m10484a(getActivity(), "france" + c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), "france" + C1852ki.f10918e + c1873lc.f11067d, true);
                    } else {
                        C1902me.m10484a(getActivity(), "english" + c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), "english" + C1852ki.f10918e + c1873lc.f11067d, true);
                    }
                    mo7736a();
                    C1900mc.m10475c("SportReportFragment", "获取运动详情成功");
                    break;
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        if (this.f7701t != null) {
            this.f7698q = Float.parseFloat(this.f7701t.errDesc.SpeedPercent);
            this.f7699r = Float.parseFloat(this.f7701t.errDesc.DurationPercent);
            this.f7700s = Float.parseFloat(this.f7701t.errDesc.HitPercent);
            this.f7688g = this.f7701t.errDesc.TotalScore;
            this.f7682a.setProgress(this.f7688g);
            this.f7689h.m8107a(this.f7688g, 1200);
            if (this.f7701t.errDesc.ReportInfo.size() < 4) {
                return;
            }
            m7937a(this.f7690i, this.f7683b, this.f7694m, this.f7701t.errDesc.ReportInfo.get(0), "#25c9ad");
            m7937a(this.f7692k, this.f7685d, this.f7696o, this.f7701t.errDesc.ReportInfo.get(1), "#7abeea");
            m7937a(this.f7691j, this.f7684c, this.f7695n, this.f7701t.errDesc.ReportInfo.get(2), "#ff8560");
            m7937a(this.f7693l, this.f7686e, this.f7697p, this.f7701t.errDesc.ReportInfo.get(3), "#f8c353");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7937a(TextView textView, TextView textView2, TextView textView3, SportDetailBean.errDesc.ReportInfo reportInfo, String str) {
        textView.setText(reportInfo.Title);
        String str2 = reportInfo.Value;
        textView2.setText(C1910mi.m10524a(str2, str2 + " " + reportInfo.Unit, 25, Color.parseColor(str)));
        textView3.setText(reportInfo.Describe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.fragment_sport_resport_fl) {
            return;
        }
        m7939c(this.f7684c);
    }

    /* JADX INFO: renamed from: c */
    private void m7939c(View view) {
        View viewInflate = View.inflate(getActivity(), R.layout.popup_sport_report, null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_root);
        ((SportReportChart) viewInflate.findViewById(R.id.sport_report_chart)).setData(this.f7698q, this.f7699r, this.f7700s);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -1, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.fragment.SportReportFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(view, 17, 0, 0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportReportFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                popupWindow.dismiss();
            }
        });
    }
}
