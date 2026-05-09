package com.coollang.tennis.activity;

import android.os.Bundle;
import android.widget.TextView;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.widget.NavigateView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import p000.C1873lc;
import p000.C1912mk;
import p000.InterfaceC1792ic;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingRollMonthActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6813a;

    /* JADX INFO: renamed from: b */
    private TextView f6814b;

    /* JADX INFO: renamed from: c */
    private TextView f6815c;

    /* JADX INFO: renamed from: d */
    private LoopView f6816d;

    /* JADX INFO: renamed from: e */
    private LoopView f6817e;

    /* JADX INFO: renamed from: f */
    private String f6818f;

    /* JADX INFO: renamed from: g */
    private int f6819g;

    /* JADX INFO: renamed from: h */
    private int f6820h = -1;

    /* JADX INFO: renamed from: i */
    private int f6821i = -1;

    /* JADX INFO: renamed from: j */
    private List<String> f6822j;

    /* JADX INFO: renamed from: k */
    private List<String> f6823k;

    /* JADX INFO: renamed from: l */
    private int f6824l;

    /* JADX INFO: renamed from: m */
    private int f6825m;

    /* JADX INFO: renamed from: n */
    private String f6826n;

    /* JADX INFO: renamed from: o */
    private String f6827o;

    /* JADX INFO: renamed from: p */
    private String[] f6828p;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.layout_setting_roll_month);
        m7222c();
        m7224d();
        m7225e();
    }

    /* JADX INFO: renamed from: c */
    private void m7222c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6818f = extras.getString("equipDate");
            this.f6819g = extras.getInt("roll_type");
        }
        if (this.f6818f != null && this.f6818f.contains("-")) {
            String[] strArrSplit = this.f6818f.split("-");
            this.f6826n = strArrSplit[0];
            this.f6827o = strArrSplit[1];
            if (this.f6827o.length() == 1) {
                this.f6827o = "0" + this.f6827o;
                return;
            }
            return;
        }
        this.f6826n = "2015";
        this.f6827o = "03";
    }

    /* JADX INFO: renamed from: d */
    private void m7224d() {
        this.f6813a = (NavigateView) findViewById(R.id.navigateView);
        this.f6814b = (TextView) findViewById(R.id.tv_title_roll_select);
        this.f6815c = (TextView) findViewById(R.id.tv_content_roll_select);
        this.f6816d = (LoopView) findViewById(R.id.pv_year);
        this.f6817e = (LoopView) findViewById(R.id.pv_month);
    }

    /* JADX INFO: renamed from: e */
    private void m7225e() {
        this.f6813a.setTitle(R.string.buy_date);
        this.f6813a.setRightHideBtn(true);
        this.f6814b.setText(R.string.buy_date);
        this.f6828p = getResources().getStringArray(R.array.monthes);
        this.f6822j = new ArrayList();
        this.f6824l = Calendar.getInstance().get(1);
        this.f6825m = Calendar.getInstance().get(2) + 1;
        for (int i = 1970; i <= this.f6824l; i++) {
            this.f6822j.add(String.valueOf(i));
            if (this.f6826n.equals(String.valueOf(i))) {
                this.f6820h = i - 1970;
            }
        }
        this.f6816d.setArrayList(this.f6822j);
        if (this.f6820h != -1) {
            this.f6816d.setCurrentItem(this.f6820h);
        }
        this.f6816d.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollMonthActivity.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i2) {
                SettingRollMonthActivity.this.f6826n = (String) SettingRollMonthActivity.this.f6822j.get(i2);
                SettingRollMonthActivity.this.m7228f();
                SettingRollMonthActivity.this.f6817e.setArrayList(SettingRollMonthActivity.this.f6823k);
                SettingRollMonthActivity.this.f6817e.setCurrentItem(0);
                SettingRollMonthActivity.this.f6817e.invalidate();
                SettingRollMonthActivity.this.m7229g();
            }
        });
        this.f6816d.setNotLoop();
        this.f6816d.setMiddleLineVisible(false);
        this.f6817e.setVisibility(0);
        this.f6817e.setMiddleLineVisible(false);
        this.f6823k = new ArrayList();
        m7228f();
        this.f6817e.setArrayList(this.f6823k);
        if (this.f6821i != -1) {
            this.f6817e.setCurrentItem(this.f6821i);
        }
        this.f6817e.setNotLoop();
        this.f6817e.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollMonthActivity.2
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i2) {
                SettingRollMonthActivity.this.f6827o = String.valueOf(i2 + 1);
                if (SettingRollMonthActivity.this.f6827o.length() < 2) {
                    SettingRollMonthActivity.this.f6827o = "0" + SettingRollMonthActivity.this.f6827o;
                }
                SettingRollMonthActivity.this.m7229g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m7228f() {
        int i = 1;
        if (Integer.parseInt(this.f6826n) == this.f6824l) {
            this.f6821i = 0;
            this.f6823k.clear();
            while (i <= this.f6825m) {
                this.f6823k.add(this.f6828p[i - 1]);
                i++;
            }
            return;
        }
        this.f6823k.clear();
        while (i < 13) {
            int i2 = i - 1;
            this.f6823k.add(this.f6828p[i2]);
            if (i == Integer.parseInt(this.f6827o)) {
                this.f6821i = i2;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7229g() {
        if (MyApplication.m7738a().m7747g()) {
            this.f6815c.setText(String.format("%s年%s月", this.f6826n, this.f6827o));
        } else {
            this.f6815c.setText(C1912mk.m10550g(String.format("%s-%s", this.f6826n, this.f6827o)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6819g == 2200) {
            akd.m1706a().m1722c(new C1873lc(this.f6826n + "-" + this.f6827o, 1, 49));
        } else if (this.f6819g == 2201) {
            akd.m1706a().m1722c(new C1873lc(this.f6826n + "-" + this.f6827o, 1, 50));
        }
        super.onDestroy();
    }
}
