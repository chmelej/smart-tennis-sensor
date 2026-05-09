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
public class SettingRollBirthdayActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6795a;

    /* JADX INFO: renamed from: b */
    private LoopView f6796b;

    /* JADX INFO: renamed from: c */
    private LoopView f6797c;

    /* JADX INFO: renamed from: d */
    private LoopView f6798d;

    /* JADX INFO: renamed from: e */
    private TextView f6799e;

    /* JADX INFO: renamed from: f */
    private String f6800f;

    /* JADX INFO: renamed from: g */
    private String f6801g;

    /* JADX INFO: renamed from: h */
    private String f6802h;

    /* JADX INFO: renamed from: i */
    private String f6803i;

    /* JADX INFO: renamed from: j */
    private List<String> f6804j = new ArrayList();

    /* JADX INFO: renamed from: k */
    private List<String> f6805k = new ArrayList();

    /* JADX INFO: renamed from: l */
    private List<String> f6806l = new ArrayList();

    /* JADX INFO: renamed from: m */
    private int f6807m = -1;

    /* JADX INFO: renamed from: n */
    private int f6808n = -1;

    /* JADX INFO: renamed from: o */
    private int f6809o = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_roll_birthday);
        m7202c();
        m7205d();
        m7207e();
    }

    /* JADX INFO: renamed from: c */
    private void m7202c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6800f = extras.getString("birthday");
        }
        if (this.f6800f != null) {
            String[] strArrSplit = this.f6800f.split("-");
            this.f6801g = strArrSplit[0];
            this.f6802h = strArrSplit[1];
            this.f6803i = strArrSplit[2];
            return;
        }
        this.f6801g = "2010";
        this.f6802h = "05";
        this.f6803i = "3";
    }

    /* JADX INFO: renamed from: d */
    private void m7205d() {
        this.f6795a = (NavigateView) findViewById(R.id.navigateView);
        this.f6796b = (LoopView) findViewById(R.id.pv_year);
        this.f6797c = (LoopView) findViewById(R.id.pv_month);
        this.f6798d = (LoopView) findViewById(R.id.pv_day);
        this.f6799e = (TextView) findViewById(R.id.tv_content_roll_select);
    }

    /* JADX INFO: renamed from: e */
    private void m7207e() {
        this.f6795a.setTitle(R.string.person_setting_text6);
        this.f6795a.setRightHideBtn(true);
        m7209f();
        m7210g();
        m7212i();
        m7213l();
        m7211h();
        m7214m();
    }

    /* JADX INFO: renamed from: f */
    private void m7209f() {
        this.f6804j.clear();
        int i = Calendar.getInstance().get(1) - 3;
        for (int i2 = 1940; i2 < i; i2++) {
            this.f6804j.add(String.valueOf(i2));
            if (this.f6801g != null && String.valueOf(i2).equals(this.f6801g)) {
                this.f6807m = i2 - 1940;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7210g() {
        String[] stringArray = getResources().getStringArray(R.array.monthes);
        for (int i = 0; i < stringArray.length; i++) {
            this.f6805k.add(stringArray[i]);
            if (this.f6802h != null && Integer.parseInt(this.f6802h) == i + 1) {
                this.f6808n = i;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m7211h() {
        int i = 1;
        if (Integer.parseInt(this.f6802h) == 2) {
            if (Integer.parseInt(this.f6801g) % 400 == 0 || (Integer.parseInt(this.f6801g) % 100 != 0 && Integer.parseInt(this.f6801g) % 4 == 0)) {
                this.f6806l.clear();
                while (i <= 29) {
                    this.f6806l.add(String.valueOf(i));
                    if (i == Integer.parseInt(this.f6803i)) {
                        this.f6809o = i - 1;
                    }
                    i++;
                }
                return;
            }
            this.f6806l.clear();
            while (i <= 28) {
                this.f6806l.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f6803i)) {
                    this.f6809o = i - 1;
                }
                i++;
            }
            return;
        }
        if (Integer.parseInt(this.f6802h) == 4 || Integer.parseInt(this.f6802h) == 6 || Integer.parseInt(this.f6802h) == 9 || Integer.parseInt(this.f6802h) == 11) {
            this.f6806l.clear();
            while (i <= 30) {
                this.f6806l.add(String.valueOf(i));
                if (i == Integer.parseInt(this.f6803i)) {
                    this.f6809o = i - 1;
                }
                i++;
            }
            return;
        }
        this.f6806l.clear();
        while (i <= 31) {
            this.f6806l.add(String.valueOf(i));
            if (i == Integer.parseInt(this.f6803i)) {
                this.f6809o = i - 1;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7212i() {
        this.f6796b.setMiddleAppleColor();
        this.f6796b.setNotLoop();
        this.f6796b.setMiddleLineVisible(false);
        this.f6796b.setArrayList(this.f6804j);
        if (this.f6807m != -1) {
            this.f6796b.setCurrentItem(this.f6807m);
        }
        this.f6796b.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollBirthdayActivity.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                SettingRollBirthdayActivity.this.f6801g = (String) SettingRollBirthdayActivity.this.f6804j.get(i);
                SettingRollBirthdayActivity.this.m7216o();
                SettingRollBirthdayActivity.this.m7215n();
            }
        });
    }

    /* JADX INFO: renamed from: l */
    private void m7213l() {
        this.f6797c.setMiddleAppleColor();
        this.f6797c.setNotLoop();
        this.f6797c.setMiddleLineVisible(false);
        this.f6797c.setArrayList(this.f6805k);
        if (this.f6808n != -1) {
            this.f6797c.setCurrentItem(this.f6808n);
        }
        this.f6797c.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollBirthdayActivity.2
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                SettingRollBirthdayActivity.this.f6802h = String.valueOf(i + 1);
                if (SettingRollBirthdayActivity.this.f6802h.length() < 2) {
                    SettingRollBirthdayActivity.this.f6802h = "0" + SettingRollBirthdayActivity.this.f6802h;
                }
                SettingRollBirthdayActivity.this.m7216o();
                SettingRollBirthdayActivity.this.m7215n();
            }
        });
    }

    /* JADX INFO: renamed from: m */
    private void m7214m() {
        this.f6798d.setMiddleAppleColor();
        this.f6798d.setNotLoop();
        this.f6798d.setMiddleLineVisible(false);
        this.f6798d.setArrayList(this.f6806l);
        if (this.f6809o != -1) {
            this.f6798d.setCurrentItem(this.f6809o);
        }
        this.f6798d.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollBirthdayActivity.3
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                SettingRollBirthdayActivity.this.f6803i = (String) SettingRollBirthdayActivity.this.f6806l.get(i);
                if (SettingRollBirthdayActivity.this.f6803i.length() < 2) {
                    SettingRollBirthdayActivity.this.f6803i = "0" + SettingRollBirthdayActivity.this.f6803i;
                }
                SettingRollBirthdayActivity.this.m7215n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public void m7215n() {
        if (MyApplication.m7738a().m7747g()) {
            this.f6799e.setText(String.format("%s年%s月%s日", this.f6801g, this.f6802h, this.f6803i));
        } else {
            this.f6799e.setText(C1912mk.m10549f(String.format("%s-%s-%s", this.f6801g, this.f6802h, this.f6803i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public void m7216o() {
        m7211h();
        this.f6798d.setArrayList(this.f6806l);
        this.f6798d.setCurrentItem(0);
        this.f6798d.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1722c(new C1873lc(String.format("%s-%s-%s", this.f6801g, this.f6802h, this.f6803i), 1, 45));
        super.onDestroy();
    }
}
