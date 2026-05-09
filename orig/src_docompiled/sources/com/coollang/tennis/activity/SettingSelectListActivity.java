package com.coollang.tennis.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p000.C1822jf;
import p000.C1854kk;
import p000.C1873lc;
import p000.C1887lq;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingSelectListActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6842a;

    /* JADX INFO: renamed from: b */
    private ListView f6843b;

    /* JADX INFO: renamed from: c */
    private View f6844c;

    /* JADX INFO: renamed from: d */
    private View f6845d;

    /* JADX INFO: renamed from: e */
    private C1822jf f6846e;

    /* JADX INFO: renamed from: f */
    private String[] f6847f = new String[0];

    /* JADX INFO: renamed from: g */
    private int f6848g;

    /* JADX INFO: renamed from: h */
    private HashMap<String, Integer> f6849h;

    /* JADX INFO: renamed from: i */
    private List<String> f6850i;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_racket_select);
        m7255c();
        m7257d();
        m7259e();
        m7263h();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: c */
    private void m7255c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6848g = extras.getInt("racketSelect");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7257d() {
        this.f6842a = (NavigateView) findViewById(R.id.navigateView);
        this.f6843b = (ListView) findViewById(R.id.lv_racket_select);
        this.f6844c = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
        this.f6845d = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: e */
    private void m7259e() {
        this.f6842a.setRightHideBtn(true);
        this.f6844c.findViewById(R.id.top_line).setVisibility(8);
        this.f6845d.findViewById(R.id.bottom_line).setVisibility(8);
        this.f6843b.addHeaderView(this.f6844c);
        this.f6843b.addFooterView(this.f6845d);
        switch (this.f6848g) {
            case 1005:
                this.f6842a.setTitle(getString(R.string.racket_factory));
                this.f6846e = new C1822jf(this, getResources().getStringArray(R.array.racket_factory), 0);
                break;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                this.f6842a.setTitle(getString(R.string.racket_hor_line_factory));
                this.f6846e = new C1822jf(this, getResources().getStringArray(R.array.racket_line_factory), 0);
                break;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                this.f6842a.setTitle(getString(R.string.racket_ver_line_factory));
                this.f6846e = new C1822jf(this, getResources().getStringArray(R.array.racket_line_factory), 0);
                break;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                this.f6842a.setTitle(getString(R.string.province));
                this.f6846e = new C1822jf(this, this.f6847f, 2);
                m7261f();
                break;
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                this.f6842a.setTitle(getString(R.string.country));
                this.f6846e = new C1822jf(this, this.f6847f, 3);
                m7262g();
                break;
            default:
                this.f6846e = new C1822jf(this, getResources().getStringArray(R.array.racket_factory), 0);
                break;
        }
        this.f6843b.setAdapter((ListAdapter) this.f6846e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.SettingSelectListActivity$1] */
    /* JADX INFO: renamed from: f */
    private void m7261f() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.SettingSelectListActivity.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                C1854kk c1854kk = new C1854kk(SettingSelectListActivity.this);
                SettingSelectListActivity.this.f6849h = c1854kk.m10103a();
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r5) {
                super.onPostExecute(r5);
                if (SettingSelectListActivity.this.f6849h == null) {
                    SettingSelectListActivity.this.f6849h = new HashMap();
                }
                Iterator it = SettingSelectListActivity.this.f6849h.keySet().iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                SettingSelectListActivity.this.f6847f = (String[]) arrayList.toArray(new String[arrayList.size()]);
                SettingSelectListActivity.this.f6846e = new C1822jf(SettingSelectListActivity.this, SettingSelectListActivity.this.f6847f, 2);
                SettingSelectListActivity.this.f6843b.setAdapter((ListAdapter) SettingSelectListActivity.this.f6846e);
            }
        }.execute(new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.SettingSelectListActivity$2] */
    /* JADX INFO: renamed from: g */
    private void m7262g() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.SettingSelectListActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                C1854kk c1854kk = new C1854kk(SettingSelectListActivity.this);
                SettingSelectListActivity.this.f6850i = c1854kk.m10107c();
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r5) {
                super.onPostExecute(r5);
                if (SettingSelectListActivity.this.f6850i == null) {
                    SettingSelectListActivity.this.f6850i = new ArrayList();
                }
                SettingSelectListActivity.this.f6847f = (String[]) SettingSelectListActivity.this.f6850i.toArray(new String[SettingSelectListActivity.this.f6850i.size()]);
                SettingSelectListActivity.this.f6846e = new C1822jf(SettingSelectListActivity.this, SettingSelectListActivity.this.f6847f, 3);
                SettingSelectListActivity.this.f6843b.setAdapter((ListAdapter) SettingSelectListActivity.this.f6846e);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: h */
    private void m7263h() {
        this.f6843b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.SettingSelectListActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    return;
                }
                if (i == 1) {
                    if (SettingSelectListActivity.this.f6848g == 1008) {
                        SettingSelectListActivity.this.m7251a(SettingSelectListActivity.this.f6846e.getItem(i - 1));
                        return;
                    }
                    return;
                }
                SettingSelectListActivity.this.m7251a(SettingSelectListActivity.this.f6846e.getItem(i - 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7251a(String str) {
        switch (this.f6848g) {
            case 1005:
                C1887lq.m10410a(this, 1005, str);
                break;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                C1887lq.m10410a(this, PointerIconCompat.TYPE_CELL, str);
                break;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                C1887lq.m10410a(this, PointerIconCompat.TYPE_CROSSHAIR, str);
                break;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                C1887lq.m10410a(this, PointerIconCompat.TYPE_TEXT, str);
                break;
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                akd.m1706a().m1722c(new C1873lc(str, 1, 46));
                break;
        }
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 31 || c1873lc.f11072i == 36 || c1873lc.f11072i == 37) {
            finish();
        } else if (c1873lc.f11072i == 46) {
            m7733j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }
}
