package com.coollang.tennis.activity;

import android.view.View;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.NavigateView;
import p000.C1896lz;
import p000.C1920ms;

/* JADX INFO: loaded from: classes.dex */
public class FastUseActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6369a;

    /* JADX INFO: renamed from: b */
    private BaseLineView f6370b;

    /* JADX INFO: renamed from: c */
    private BaseLineView f6371c;

    /* JADX INFO: renamed from: d */
    private BaseLineView f6372d;

    /* JADX INFO: renamed from: e */
    private BaseLineView f6373e;

    /* JADX INFO: renamed from: f */
    private BaseLineView f6374f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6375g;

    /* JADX INFO: renamed from: h */
    private BaseLineView f6376h;

    /* JADX INFO: renamed from: i */
    private BaseLineView f6377i;

    /* JADX INFO: renamed from: j */
    private BaseLineView f6378j;

    /* JADX INFO: renamed from: k */
    private BaseLineView f6379k;

    /* JADX INFO: renamed from: l */
    private BaseLineView f6380l;

    /* JADX INFO: renamed from: m */
    private C1920ms f6381m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_fast_use);
        m6921c();
        m6922d();
        m6923e();
    }

    /* JADX INFO: renamed from: c */
    private void m6921c() {
        this.f6369a = (NavigateView) findViewById(R.id.history_title);
        this.f6370b = (BaseLineView) findViewById(R.id.blv_install);
        this.f6371c = (BaseLineView) findViewById(R.id.blv_open);
        this.f6372d = (BaseLineView) findViewById(R.id.blv_connect);
        this.f6373e = (BaseLineView) findViewById(R.id.blv_use);
        this.f6374f = (BaseLineView) findViewById(R.id.blv_close);
        this.f6375g = (BaseLineView) findViewById(R.id.blv_check_data);
        this.f6376h = (BaseLineView) findViewById(R.id.blv_update);
        this.f6377i = (BaseLineView) findViewById(R.id.blv_reset_factory);
        this.f6378j = (BaseLineView) findViewById(R.id.blv_status);
        this.f6379k = (BaseLineView) findViewById(R.id.blv_power);
        this.f6380l = (BaseLineView) findViewById(R.id.blv_speciall);
    }

    /* JADX INFO: renamed from: d */
    private void m6922d() {
        this.f6369a.setTitle(getString(R.string.personal_text3));
        this.f6369a.setRightButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6369a.setRightButtonText(getString(R.string.history_list));
        this.f6369a.setRightButtonTextSize(17);
        this.f6369a.setRightHideBtn(true);
    }

    /* JADX INFO: renamed from: e */
    private void m6923e() {
        this.f6370b.setOnClickListener(this);
        this.f6371c.setOnClickListener(this);
        this.f6372d.setOnClickListener(this);
        this.f6373e.setOnClickListener(this);
        this.f6374f.setOnClickListener(this);
        this.f6375g.setOnClickListener(this);
        this.f6376h.setOnClickListener(this);
        this.f6377i.setOnClickListener(this);
        this.f6378j.setOnClickListener(this);
        this.f6379k.setOnClickListener(this);
        this.f6380l.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.blv_check_data /* 2131296397 */:
                m6920a(5);
                break;
            case R.id.blv_close /* 2131296399 */:
                m6920a(4);
                break;
            case R.id.blv_connect /* 2131296400 */:
                m6920a(2);
                break;
            case R.id.blv_install /* 2131296406 */:
                m6920a(0);
                break;
            case R.id.blv_open /* 2131296409 */:
                m6920a(1);
                break;
            case R.id.blv_power /* 2131296411 */:
                m6920a(9);
                break;
            case R.id.blv_reset_factory /* 2131296412 */:
                m6920a(7);
                break;
            case R.id.blv_speciall /* 2131296423 */:
                m6920a(9);
                break;
            case R.id.blv_status /* 2131296424 */:
                m6920a(8);
                break;
            case R.id.blv_update /* 2131296426 */:
                m6920a(6);
                break;
            case R.id.blv_use /* 2131296427 */:
                m6920a(3);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6920a(int i) {
        if (this.f6381m == null) {
            this.f6381m = new C1920ms(this);
        }
        this.f6381m.m10606a(i);
        this.f6381m.m10605a();
    }
}
