package com.coollang.tennis.activity;

import android.view.View;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.NavigateView;
import p000.C1921mt;

/* JADX INFO: loaded from: classes.dex */
public class HeadFastUseActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6411a;

    /* JADX INFO: renamed from: b */
    private BaseLineView f6412b;

    /* JADX INFO: renamed from: c */
    private BaseLineView f6413c;

    /* JADX INFO: renamed from: d */
    private BaseLineView f6414d;

    /* JADX INFO: renamed from: e */
    private BaseLineView f6415e;

    /* JADX INFO: renamed from: f */
    private BaseLineView f6416f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6417g;

    /* JADX INFO: renamed from: h */
    private C1921mt f6418h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_fast_use_head);
        m6941c();
        m6942d();
        m6943e();
    }

    /* JADX INFO: renamed from: c */
    private void m6941c() {
        this.f6411a = (NavigateView) findViewById(R.id.history_title);
        this.f6412b = (BaseLineView) findViewById(R.id.blv_open);
        this.f6413c = (BaseLineView) findViewById(R.id.blv_close);
        this.f6414d = (BaseLineView) findViewById(R.id.blv_check_data);
        this.f6415e = (BaseLineView) findViewById(R.id.blv_connect);
        this.f6416f = (BaseLineView) findViewById(R.id.blv_power);
        this.f6417g = (BaseLineView) findViewById(R.id.blv_reset_factory);
    }

    /* JADX INFO: renamed from: d */
    private void m6942d() {
        this.f6411a.setTitle(getString(R.string.personal_text3));
        this.f6411a.setRightButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6411a.setRightButtonText(getString(R.string.history_list));
        this.f6411a.setRightButtonTextSize(17);
        this.f6411a.setRightHideBtn(true);
    }

    /* JADX INFO: renamed from: e */
    private void m6943e() {
        this.f6412b.setOnClickListener(this);
        this.f6413c.setOnClickListener(this);
        this.f6414d.setOnClickListener(this);
        this.f6415e.setOnClickListener(this);
        this.f6416f.setOnClickListener(this);
        this.f6417g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blv_check_data /* 2131296397 */:
                m6940a(2);
                break;
            case R.id.blv_close /* 2131296399 */:
                m6940a(1);
                break;
            case R.id.blv_connect /* 2131296400 */:
                m6940a(3);
                break;
            case R.id.blv_open /* 2131296409 */:
                m6940a(0);
                break;
            case R.id.blv_power /* 2131296411 */:
                m6940a(4);
                break;
            case R.id.blv_reset_factory /* 2131296412 */:
                m6940a(5);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6940a(int i) {
        if (this.f6418h == null) {
            this.f6418h = new C1921mt(this);
        }
        this.f6418h.m10615a(i);
        this.f6418h.m10614a();
    }
}
