package com.coollang.tennis.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import java.util.ArrayList;
import java.util.List;
import p000.C1828jl;
import p000.C1873lc;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingTennisLevelActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6877a;

    /* JADX INFO: renamed from: b */
    private ListView f6878b;

    /* JADX INFO: renamed from: c */
    private View f6879c;

    /* JADX INFO: renamed from: d */
    private View f6880d;

    /* JADX INFO: renamed from: e */
    private C1828jl f6881e;

    /* JADX INFO: renamed from: f */
    private String f6882f;

    /* JADX INFO: renamed from: g */
    private List<String> f6883g;

    /* JADX INFO: renamed from: h */
    private int f6884h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_tennis_level);
        m7290c();
        m7291d();
        m7292e();
        m7294g();
    }

    /* JADX INFO: renamed from: c */
    private void m7290c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6882f = extras.getString("content");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7291d() {
        this.f6877a = (NavigateView) findViewById(R.id.navigateView);
        this.f6878b = (ListView) findViewById(R.id.lv_racket_select);
        this.f6879c = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
        this.f6880d = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: e */
    private void m7292e() {
        this.f6877a.setTitle(R.string.tennis_level);
        this.f6877a.setRightHideBtn(true);
        this.f6879c.findViewById(R.id.top_line).setVisibility(8);
        this.f6880d.findViewById(R.id.bottom_line).setVisibility(8);
        this.f6878b.addHeaderView(this.f6879c);
        this.f6878b.addFooterView(this.f6880d);
        m7293f();
        this.f6881e = new C1828jl(this.f6883g, this, this.f6884h);
        this.f6878b.setAdapter((ListAdapter) this.f6881e);
    }

    /* JADX INFO: renamed from: f */
    private void m7293f() {
        this.f6883g = new ArrayList();
        for (int i = 0; i < 11; i++) {
            this.f6883g.add(String.format("%.01f", Float.valueOf((i * 0.5f) + 1.0f)));
            if (this.f6882f != null && this.f6882f.equals(this.f6883g.get(i))) {
                this.f6884h = i;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m7294g() {
        this.f6878b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.SettingTennisLevelActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                akd.m1706a().m1722c(new C1873lc(SettingTennisLevelActivity.this.f6881e.getItem(i - 1), 1, 47));
                SettingTennisLevelActivity.this.m7733j();
            }
        });
    }
}
