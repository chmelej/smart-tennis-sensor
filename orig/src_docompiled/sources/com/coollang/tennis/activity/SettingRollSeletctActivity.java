package com.coollang.tennis.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jeesoft.widget.pickerview.LoopView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import java.util.ArrayList;
import java.util.List;
import p000.C1873lc;
import p000.InterfaceC1792ic;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingRollSeletctActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6831a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f6832b;

    /* JADX INFO: renamed from: c */
    private TextView f6833c;

    /* JADX INFO: renamed from: d */
    private TextView f6834d;

    /* JADX INFO: renamed from: e */
    private LoopView f6835e;

    /* JADX INFO: renamed from: f */
    private int f6836f;

    /* JADX INFO: renamed from: g */
    private String f6837g;

    /* JADX INFO: renamed from: h */
    private List<String> f6838h = new ArrayList();

    /* JADX INFO: renamed from: i */
    private int f6839i = -1;

    /* JADX INFO: renamed from: j */
    private String f6840j;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_roll_select);
        m7237c();
        m7238d();
        m7239e();
        m7240f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6834d.setText(this.f6838h.get(this.f6835e.getCurrentItem()));
        this.f6840j = this.f6838h.get(this.f6835e.getCurrentItem());
        m7232a(this.f6835e.getCurrentItem());
    }

    /* JADX INFO: renamed from: c */
    private void m7237c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6836f = extras.getInt("rollType");
            this.f6837g = extras.getString("rollData");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7238d() {
        this.f6831a = (NavigateView) findViewById(R.id.navigateView);
        this.f6832b = (LinearLayout) findViewById(R.id.ll_content);
        this.f6833c = (TextView) findViewById(R.id.tv_title_roll_select);
        this.f6834d = (TextView) findViewById(R.id.tv_content_roll_select);
        this.f6835e = (LoopView) findViewById(R.id.picklerview);
    }

    /* JADX INFO: renamed from: e */
    private void m7239e() {
        this.f6831a.setRightHideBtn(true);
        switch (this.f6836f) {
            case 1100:
                this.f6831a.setTitle(getString(R.string.hor_line_width));
                this.f6833c.setText(getString(R.string.hor_line_width));
                m7241g();
                break;
            case 1101:
                this.f6831a.setTitle(getString(R.string.hor_line_power));
                this.f6833c.setText(R.string.hor_line_power);
                m7242h();
                break;
            case 1102:
                this.f6831a.setTitle(getString(R.string.ver_line_width));
                this.f6833c.setText(getString(R.string.ver_line_width));
                m7241g();
                break;
            case 1103:
                this.f6831a.setTitle(getString(R.string.ver_line_power));
                this.f6833c.setText(R.string.ver_line_power);
                m7242h();
                break;
            case 1104:
                this.f6831a.setTitle(R.string.person_setting_text3);
                this.f6833c.setText(R.string.person_setting_text3);
                m7243i();
                break;
            case 1105:
                this.f6831a.setTitle(R.string.person_setting_text2);
                this.f6833c.setText(R.string.person_setting_text2);
                m7244l();
                break;
            case 1106:
                this.f6831a.setTitle(R.string.person_setting_text9);
                this.f6833c.setText(R.string.person_setting_text9);
                m7245m();
                break;
        }
        this.f6835e.setMiddleAppleColor();
        this.f6835e.setNotLoop();
        this.f6835e.setMiddleLineVisible(false);
        this.f6835e.setArrayList(this.f6838h);
        if (this.f6839i != -1) {
            this.f6835e.setCurrentItem(this.f6839i);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m7240f() {
        this.f6835e.setListener(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingRollSeletctActivity.1
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                SettingRollSeletctActivity.this.f6834d.setText((CharSequence) SettingRollSeletctActivity.this.f6838h.get(i));
                SettingRollSeletctActivity.this.f6840j = (String) SettingRollSeletctActivity.this.f6838h.get(SettingRollSeletctActivity.this.f6835e.getCurrentItem());
                SettingRollSeletctActivity.this.m7232a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7232a(int i) {
        if (this.f6836f == 1104) {
            this.f6840j = String.valueOf(i + 20);
        } else if (this.f6836f == 1105) {
            this.f6840j = String.valueOf(i + 100);
        } else if (this.f6836f == 1106) {
            this.f6840j = String.valueOf(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7234a(String str) {
        switch (this.f6836f) {
            case 1100:
                akd.m1706a().m1722c(new C1873lc(str, 1, 32));
                break;
            case 1101:
                akd.m1706a().m1722c(new C1873lc(str, 1, 33));
                break;
            case 1102:
                akd.m1706a().m1722c(new C1873lc(str, 1, 34));
                break;
            case 1103:
                akd.m1706a().m1722c(new C1873lc(str, 1, 35));
                break;
            case 1104:
                akd.m1706a().m1722c(new C1873lc(str, 1, 41));
                break;
            case 1105:
                akd.m1706a().m1722c(new C1873lc(str, 1, 42));
                break;
            case 1106:
                akd.m1706a().m1722c(new C1873lc(str, 1, 44));
                break;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7241g() {
        String[] stringArray = getResources().getStringArray(R.array.line_width);
        for (int i = 0; i < stringArray.length; i++) {
            this.f6838h.add(stringArray[i]);
            if (this.f6837g != null && stringArray[i].equals(this.f6837g)) {
                this.f6839i = i;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m7242h() {
        for (int i = 30; i < 78; i++) {
            this.f6838h.add(String.format("%dlbs", Integer.valueOf(i)));
            if (this.f6837g != null && String.format("%dlbs", Integer.valueOf(i)).equals(this.f6837g)) {
                this.f6839i = i - 30;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7243i() {
        for (int i = 20; i < 200; i++) {
            this.f6838h.add(String.format("%d kg", Integer.valueOf(i)));
            if (this.f6837g != null && String.valueOf(i).equals(this.f6837g)) {
                this.f6839i = i - 20;
            }
        }
    }

    /* JADX INFO: renamed from: l */
    private void m7244l() {
        for (int i = 100; i < 230; i++) {
            this.f6838h.add(String.format("%d cm", Integer.valueOf(i)));
            if (this.f6837g != null && String.valueOf(i).equals(this.f6837g)) {
                this.f6839i = i - 100;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    private void m7245m() {
        for (int i = 0; i < 80; i++) {
            if (i == 0) {
                this.f6838h.add(getString(R.string.ball_age_zero));
            } else {
                this.f6838h.add(String.format(getString(R.string.ball_age_format), Integer.valueOf(i)));
            }
            if (this.f6837g != null && String.valueOf(i).equals(this.f6837g)) {
                this.f6839i = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m7234a(this.f6840j);
        super.onDestroy();
    }
}
