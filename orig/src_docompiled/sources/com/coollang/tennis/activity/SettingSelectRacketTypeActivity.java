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
import java.util.List;
import p000.C1822jf;
import p000.C1854kk;
import p000.C1873lc;
import p000.C1900mc;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SettingSelectRacketTypeActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6866a;

    /* JADX INFO: renamed from: b */
    private ListView f6867b;

    /* JADX INFO: renamed from: c */
    private View f6868c;

    /* JADX INFO: renamed from: d */
    private View f6869d;

    /* JADX INFO: renamed from: e */
    private C1822jf f6870e;

    /* JADX INFO: renamed from: f */
    private int f6871f;

    /* JADX INFO: renamed from: g */
    private String f6872g;

    /* JADX INFO: renamed from: h */
    private String[] f6873h;

    /* JADX INFO: renamed from: i */
    private List<String> f6874i;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting_racket_type_select);
        m7280c();
        m7283d();
        m7285e();
    }

    /* JADX INFO: renamed from: c */
    private void m7280c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6871f = extras.getInt("type");
            this.f6872g = extras.getString("racketname");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7283d() {
        this.f6866a = (NavigateView) findViewById(R.id.navigateView);
        this.f6867b = (ListView) findViewById(R.id.lv_racket_select);
        this.f6868c = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
        this.f6869d = LayoutInflater.from(this).inflate(R.layout.layout_base_header_list, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: e */
    private void m7285e() {
        this.f6866a.setRightHideBtn(true);
        switch (this.f6871f) {
            case 1005:
                this.f6866a.setTitle(getString(R.string.racket_type));
                if (m7272a("R") != 0) {
                    this.f6873h = getResources().getStringArray(m7272a("R"));
                } else {
                    this.f6873h = new String[0];
                }
                break;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                this.f6866a.setTitle(getString(R.string.racket_hor_line_type));
                if (m7272a("L") != 0) {
                    this.f6873h = getResources().getStringArray(m7272a("L"));
                } else {
                    this.f6873h = new String[0];
                }
                break;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                this.f6866a.setTitle(getString(R.string.racket_ver_line_type));
                if (m7272a("L") != 0) {
                    this.f6873h = getResources().getStringArray(m7272a("L"));
                } else {
                    this.f6873h = new String[0];
                }
                break;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                this.f6866a.setTitle(R.string.person_city_address);
                this.f6873h = new String[0];
                m7286f();
                break;
        }
        this.f6868c.findViewById(R.id.top_line).setVisibility(8);
        this.f6869d.findViewById(R.id.bottom_line).setVisibility(8);
        this.f6867b.addHeaderView(this.f6868c);
        this.f6867b.addFooterView(this.f6869d);
        this.f6870e = new C1822jf(this, this.f6873h, 1);
        this.f6867b.setAdapter((ListAdapter) this.f6870e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.coollang.tennis.activity.SettingSelectRacketTypeActivity$1] */
    /* JADX INFO: renamed from: f */
    private void m7286f() {
        new AsyncTask<Void, Void, Void>() { // from class: com.coollang.tennis.activity.SettingSelectRacketTypeActivity.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                C1854kk c1854kk = new C1854kk(SettingSelectRacketTypeActivity.this);
                int iIntValue = c1854kk.m10103a().get(SettingSelectRacketTypeActivity.this.f6872g).intValue();
                SettingSelectRacketTypeActivity.this.f6874i = c1854kk.m10104a(String.valueOf(iIntValue));
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r5) {
                super.onPostExecute(r5);
                if (SettingSelectRacketTypeActivity.this.f6874i == null) {
                    SettingSelectRacketTypeActivity.this.f6874i = new ArrayList();
                }
                SettingSelectRacketTypeActivity.this.f6873h = (String[]) SettingSelectRacketTypeActivity.this.f6874i.toArray(new String[SettingSelectRacketTypeActivity.this.f6874i.size()]);
                SettingSelectRacketTypeActivity.this.f6870e = new C1822jf(SettingSelectRacketTypeActivity.this, SettingSelectRacketTypeActivity.this.f6873h, 1);
                SettingSelectRacketTypeActivity.this.f6867b.setAdapter((ListAdapter) SettingSelectRacketTypeActivity.this.f6870e);
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: a */
    private int m7272a(String str) {
        int identifier;
        if (this.f6872g.equals("L-Tec")) {
            identifier = getResources().getIdentifier(str + "LTec", "array", "com.coollang.tennis");
        } else {
            identifier = getResources().getIdentifier(str + this.f6872g, "array", "com.coollang.tennis");
        }
        C1900mc.m10475c("resourceId ", "id Head = " + identifier);
        return identifier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6867b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.SettingSelectRacketTypeActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0 || i > SettingSelectRacketTypeActivity.this.f6873h.length) {
                    return;
                }
                SettingSelectRacketTypeActivity.this.m7279b(SettingSelectRacketTypeActivity.this.f6873h[i - 1]);
                SettingSelectRacketTypeActivity.this.m7733j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7279b(String str) {
        switch (this.f6871f) {
            case 1005:
                akd.m1706a().m1722c(new C1873lc(str, 1, 31, this.f6872g));
                break;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                akd.m1706a().m1722c(new C1873lc(str, 1, 36, this.f6872g));
                break;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                akd.m1706a().m1722c(new C1873lc(str, 1, 37, this.f6872g));
                break;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                akd.m1706a().m1722c(new C1873lc(this.f6872g + str, 1, 46));
                break;
        }
    }
}
