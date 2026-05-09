package com.coollang.tennis.activity;

import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.NavigateView;
import p000.C1873lc;
import p000.C1887lq;
import p000.C1902me;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingSelectRacketLineActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6854a;

    /* JADX INFO: renamed from: b */
    private RelativeLayout f6855b;

    /* JADX INFO: renamed from: c */
    private TextView f6856c;

    /* JADX INFO: renamed from: d */
    private TextView f6857d;

    /* JADX INFO: renamed from: e */
    private TextView f6858e;

    /* JADX INFO: renamed from: f */
    private BaseLineView f6859f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6860g;

    /* JADX INFO: renamed from: h */
    private int f6861h;

    /* JADX INFO: renamed from: i */
    private String f6862i;

    /* JADX INFO: renamed from: j */
    private String f6863j;

    /* JADX INFO: renamed from: k */
    private String f6864k;

    /* JADX INFO: renamed from: l */
    private String f6865l;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_racket_line);
        m7268c();
        m7269d();
        m7270e();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: c */
    private void m7268c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6861h = extras.getInt("lineDirection");
            this.f6862i = extras.getString("lineFactory");
            this.f6863j = extras.getString("lineType");
            this.f6864k = extras.getString("lineWidth");
            this.f6865l = extras.getString("linePower");
        }
        if (this.f6862i == null) {
            this.f6862i = "";
        }
        if (this.f6863j == null) {
            this.f6863j = "";
        }
        if (this.f6864k == null) {
            this.f6864k = "";
        }
        if (this.f6865l == null) {
            this.f6865l = "";
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7269d() {
        this.f6854a = (NavigateView) findViewById(R.id.navigateView);
        this.f6855b = (RelativeLayout) findViewById(R.id.rl_racket_factory);
        this.f6856c = (TextView) findViewById(R.id.tv_factory_racket);
        this.f6857d = (TextView) findViewById(R.id.tv_type_racket);
        this.f6859f = (BaseLineView) findViewById(R.id.blv_buy_day);
        this.f6860g = (BaseLineView) findViewById(R.id.blv_hor_line);
        this.f6858e = (TextView) findViewById(R.id.tv_brand_model);
        if (MyApplication.m7738a().m7748h()) {
            this.f6858e.setTextSize(12.0f);
            this.f6859f.setLeftTextSize(12);
            this.f6860g.setLeftTextSize(12);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m7270e() {
        if (this.f6861h == 1006) {
            this.f6854a.setTitle(R.string.hor_line);
        } else {
            this.f6854a.setTitle(R.string.ver_line);
        }
        this.f6854a.setRightHideBtn(true);
        this.f6856c.setText(this.f6862i);
        this.f6857d.setText(this.f6863j);
        this.f6859f.setRightText(this.f6864k);
        this.f6860g.setRightText(this.f6865l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        m7271f();
    }

    /* JADX INFO: renamed from: f */
    private void m7271f() {
        this.f6855b.setOnClickListener(this);
        this.f6859f.setOnClickListener(this);
        this.f6860g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.blv_buy_day) {
            if (this.f6861h == 1006) {
                C1887lq.m10418b(this, 1100, this.f6864k);
                return;
            } else {
                C1887lq.m10418b(this, 1102, this.f6864k);
                return;
            }
        }
        if (id == R.id.blv_hor_line) {
            if (this.f6861h == 1006) {
                C1887lq.m10418b(this, 1101, this.f6865l);
                return;
            } else {
                C1887lq.m10418b(this, 1103, this.f6865l);
                return;
            }
        }
        if (id != R.id.rl_racket_factory) {
            return;
        }
        if (this.f6861h == 1006) {
            if (C1902me.m10488b()) {
                C1887lq.m10410a(this, PointerIconCompat.TYPE_CELL, "Head");
                return;
            } else {
                C1887lq.m10408a(this, PointerIconCompat.TYPE_CELL);
                return;
            }
        }
        if (C1902me.m10488b()) {
            C1887lq.m10410a(this, PointerIconCompat.TYPE_CROSSHAIR, "Head");
        } else {
            C1887lq.m10408a(this, PointerIconCompat.TYPE_CROSSHAIR);
        }
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 36) {
            if (this.f6861h == 1006) {
                this.f6856c.setText(c1873lc.f11067d);
                this.f6857d.setText(c1873lc.f11064a);
                return;
            }
            return;
        }
        if (c1873lc.f11072i == 37) {
            if (this.f6861h == 1007) {
                this.f6856c.setText(c1873lc.f11067d);
                this.f6857d.setText(c1873lc.f11064a);
                return;
            }
            return;
        }
        if (c1873lc.f11072i == 32) {
            if (this.f6861h == 1006) {
                this.f6859f.setRightText(c1873lc.f11064a);
            }
        } else if (c1873lc.f11072i == 33) {
            if (this.f6861h == 1006) {
                this.f6860g.setRightText(c1873lc.f11064a);
            }
        } else if (c1873lc.f11072i == 34) {
            if (this.f6861h == 1007) {
                this.f6859f.setRightText(c1873lc.f11064a);
            }
        } else if (c1873lc.f11072i == 35 && this.f6861h == 1007) {
            this.f6860g.setRightText(c1873lc.f11064a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }
}
