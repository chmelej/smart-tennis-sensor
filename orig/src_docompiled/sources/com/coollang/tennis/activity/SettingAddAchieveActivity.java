package com.coollang.tennis.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import p000.C1873lc;
import p000.C1900mc;
import p000.C1922mu;
import p000.InterfaceC1792ic;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingAddAchieveActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6664a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f6665b;

    /* JADX INFO: renamed from: c */
    private TextView f6666c;

    /* JADX INFO: renamed from: d */
    private EditText f6667d;

    /* JADX INFO: renamed from: e */
    private String f6668e;

    /* JADX INFO: renamed from: f */
    private String f6669f;

    /* JADX INFO: renamed from: g */
    private int f6670g;

    /* JADX INFO: renamed from: h */
    private C1922mu f6671h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_add_his);
        m7104c();
        m7105d();
        m7106e();
        m7107f();
    }

    /* JADX INFO: renamed from: c */
    private void m7104c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6668e = extras.getString("year");
            this.f6669f = extras.getString("archieve");
            this.f6670g = extras.getInt("position");
        }
        C1900mc.m10474b("send", "position == " + this.f6670g);
    }

    /* JADX INFO: renamed from: d */
    private void m7105d() {
        this.f6664a = (NavigateView) findViewById(R.id.navigateView);
        this.f6664a.setRightHideBtn(true);
        this.f6665b = (LinearLayout) findViewById(R.id.ll_year_select);
        this.f6666c = (TextView) findViewById(R.id.tv_year_setting_add_his);
        this.f6667d = (EditText) findViewById(R.id.edt_desc_archieve);
    }

    /* JADX INFO: renamed from: e */
    private void m7106e() {
        this.f6664a.setTitle(R.string.add_archieve);
        this.f6664a.setRightButtonText(getString(R.string.right_text));
        this.f6664a.setRightButtonBackground(android.R.color.transparent);
        this.f6664a.setRightButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SettingAddAchieveActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
            }
        });
    }

    /* JADX INFO: renamed from: f */
    private void m7107f() {
        this.f6665b.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.SettingAddAchieveActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingAddAchieveActivity.this.m7734k();
                SettingAddAchieveActivity.this.m7108g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7108g() {
        this.f6671h = new C1922mu(this, this.f6668e);
        this.f6671h.m10619a(new InterfaceC1792ic() { // from class: com.coollang.tennis.activity.SettingAddAchieveActivity.3
            @Override // p000.InterfaceC1792ic
            /* JADX INFO: renamed from: a */
            public void mo7111a(int i) {
                SettingAddAchieveActivity.this.f6668e = String.valueOf(i + 1970);
                SettingAddAchieveActivity.this.m7109h();
            }
        });
        this.f6671h.m10618a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        m7109h();
        if (this.f6669f == null || this.f6669f.isEmpty()) {
            return;
        }
        this.f6667d.setText(this.f6669f);
        this.f6667d.setSelection(this.f6669f.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7109h() {
        if (this.f6668e == null || this.f6668e.isEmpty()) {
            this.f6668e = "2013";
        }
        this.f6666c.setText(this.f6668e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1722c(new C1873lc(String.valueOf(this.f6670g), 1, 48, this.f6668e, this.f6667d.getText().toString().trim()));
        super.onDestroy();
    }
}
