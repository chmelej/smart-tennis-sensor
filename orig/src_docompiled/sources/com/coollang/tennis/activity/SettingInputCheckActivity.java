package com.coollang.tennis.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import p000.C1873lc;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingInputCheckActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6707a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f6708b;

    /* JADX INFO: renamed from: c */
    private LinearLayout f6709c;

    /* JADX INFO: renamed from: d */
    private ImageView f6710d;

    /* JADX INFO: renamed from: e */
    private ImageView f6711e;

    /* JADX INFO: renamed from: f */
    private TextView f6712f;

    /* JADX INFO: renamed from: g */
    private TextView f6713g;

    /* JADX INFO: renamed from: h */
    private String f6714h;

    /* JADX INFO: renamed from: i */
    private int f6715i;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_input_sex);
        m7140c();
        m7141d();
        m7142e();
        m7143f();
    }

    /* JADX INFO: renamed from: c */
    private void m7140c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6715i = extras.getInt("type");
            this.f6714h = extras.getString("content");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7141d() {
        this.f6707a = (NavigateView) findViewById(R.id.navigateView);
        this.f6708b = (LinearLayout) findViewById(R.id.ll_sex_man);
        this.f6709c = (LinearLayout) findViewById(R.id.ll_sex_woman);
        this.f6710d = (ImageView) findViewById(R.id.img_sex_man);
        this.f6711e = (ImageView) findViewById(R.id.img_sex_woman);
        this.f6712f = (TextView) findViewById(R.id.tv_title_check_top);
        this.f6713g = (TextView) findViewById(R.id.tv_title_check_bottom);
    }

    /* JADX INFO: renamed from: e */
    private void m7142e() {
        if (this.f6715i == 2101) {
            this.f6707a.setTitle(R.string.person_setting_text1);
            this.f6712f.setText(R.string.perfect_male);
            this.f6713g.setText(R.string.perfect_female);
            if ("1".equals(this.f6714h)) {
                m7144g();
            } else {
                m7145h();
            }
        } else {
            this.f6707a.setTitle(R.string.first_hand);
            this.f6712f.setText(R.string.first_hand_left);
            this.f6713g.setText(R.string.first_hand_right);
            if ("1".equals(this.f6714h)) {
                m7145h();
            } else {
                m7144g();
            }
        }
        this.f6707a.setRightHideBtn(true);
    }

    /* JADX INFO: renamed from: f */
    private void m7143f() {
        this.f6708b.setOnClickListener(this);
        this.f6709c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_sex_man /* 2131296842 */:
                m7144g();
                if (this.f6715i == 2101) {
                    this.f6714h = "1";
                } else {
                    this.f6714h = "0";
                }
                m7733j();
                break;
            case R.id.ll_sex_woman /* 2131296843 */:
                m7145h();
                if (this.f6715i == 2101) {
                    this.f6714h = "0";
                } else {
                    this.f6714h = "1";
                }
                m7733j();
                break;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7144g() {
        this.f6710d.setVisibility(0);
        this.f6711e.setVisibility(8);
    }

    /* JADX INFO: renamed from: h */
    private void m7145h() {
        this.f6710d.setVisibility(8);
        this.f6711e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6714h != null && !this.f6714h.isEmpty()) {
            if (this.f6715i == 2101) {
                akd.m1706a().m1722c(new C1873lc(this.f6714h, 1, 40));
            } else {
                akd.m1706a().m1722c(new C1873lc(this.f6714h, 1, 43));
            }
        }
        super.onDestroy();
    }
}
