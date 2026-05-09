package com.coollang.tennis.activity;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.BaseBean;
import com.coollang.tennis.widget.NavigateView;
import com.google.gson.Gson;
import java.util.Timer;
import java.util.TimerTask;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1909mh;
import p000.C1926my;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class GetEmailPasswordActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f6382a;

    /* JADX INFO: renamed from: b */
    private LinearLayout f6383b;

    /* JADX INFO: renamed from: c */
    private EditText f6384c;

    /* JADX INFO: renamed from: d */
    private TextView f6385d;

    /* JADX INFO: renamed from: e */
    private LinearLayout f6386e;

    /* JADX INFO: renamed from: f */
    private RelativeLayout f6387f;

    /* JADX INFO: renamed from: g */
    private TextView f6388g;

    /* JADX INFO: renamed from: h */
    private TextView f6389h;

    /* JADX INFO: renamed from: i */
    private TextView f6390i;

    /* JADX INFO: renamed from: j */
    private C1926my f6391j;

    /* JADX INFO: renamed from: k */
    private C1874ld f6392k;

    /* JADX INFO: renamed from: l */
    private Gson f6393l;

    /* JADX INFO: renamed from: m */
    private Timer f6394m;

    /* JADX INFO: renamed from: n */
    private TimerTask f6395n;

    /* JADX INFO: renamed from: o */
    private String f6396o = "";

    /* JADX INFO: renamed from: p */
    private boolean f6397p = true;

    /* JADX INFO: renamed from: q */
    private boolean f6398q = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_get_email_password);
        m6927c();
        m6928d();
        m6929e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6392k = new C1874ld();
        this.f6393l = new Gson();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: c */
    private void m6927c() {
        this.f6382a = (NavigateView) findViewById(R.id.navigateView);
        this.f6383b = (LinearLayout) findViewById(R.id.ll_get_ps_step_one);
        this.f6384c = (EditText) findViewById(R.id.edt_email);
        this.f6385d = (TextView) findViewById(R.id.tv_continue);
        this.f6386e = (LinearLayout) findViewById(R.id.ll_get_ps_step_two);
        this.f6388g = (TextView) findViewById(R.id.tv_email);
        this.f6389h = (TextView) findViewById(R.id.tv_try_again);
        this.f6390i = (TextView) findViewById(R.id.tv_finish);
        this.f6387f = (RelativeLayout) findViewById(R.id.rl_progress);
    }

    /* JADX INFO: renamed from: d */
    private void m6928d() {
        this.f6382a.setTitle(getString(R.string.get_back_title));
        this.f6382a.setRightHideBtn(true);
        SpannableString spannableString = new SpannableString(getString(R.string.get_back_ps_note3));
        String str = MyApplication.m7738a().m7748h() ? "peu plus" : "try again";
        int iIndexOf = getString(R.string.get_back_ps_note3).indexOf(str);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.xiaoqiu)), iIndexOf, str.length() + iIndexOf, 33);
        spannableString.setSpan(new UnderlineSpan(), iIndexOf, str.length() + iIndexOf, 33);
        this.f6389h.setText(spannableString);
    }

    /* JADX INFO: renamed from: e */
    private void m6929e() {
        this.f6385d.setOnClickListener(this);
        this.f6390i.setOnClickListener(this);
        this.f6389h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_continue) {
            m7734k();
            this.f6396o = this.f6384c.getText().toString().trim();
            if (this.f6396o.isEmpty() || !C1909mh.m10522b(this.f6396o)) {
                m6925a(getString(R.string.email_not_valid));
                return;
            } else {
                m6930f();
                this.f6387f.setVisibility(0);
                return;
            }
        }
        if (id == R.id.tv_finish) {
            m7733j();
            return;
        }
        if (id != R.id.tv_try_again) {
            return;
        }
        this.f6397p = false;
        if (this.f6398q) {
            m6930f();
        } else {
            this.f6398q = false;
            m6925a(getString(R.string.send_email_success));
        }
    }

    /* JADX INFO: renamed from: f */
    private void m6930f() {
        this.f6398q = false;
        this.f6392k.m10226h(this.f6396o);
        m6932h();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 59) {
            switch (c1873lc.f11065b) {
                case -1:
                    this.f6387f.setVisibility(8);
                    break;
                case 0:
                    this.f6387f.setVisibility(8);
                    if (((BaseBean) this.f6393l.fromJson(c1873lc.f11064a, BaseBean.class)).ret.equals("-10002")) {
                        m6925a(getString(R.string.user_fail));
                    } else {
                        m6925a(getString(R.string.get_password_error));
                    }
                    break;
                case 1:
                    if (this.f6397p) {
                        this.f6387f.setVisibility(8);
                        m6931g();
                    } else {
                        m6925a(getString(R.string.send_email_success));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m6931g() {
        this.f6388g.setText(this.f6384c.getText().toString().trim());
        this.f6383b.setVisibility(8);
        this.f6386e.setVisibility(0);
    }

    /* JADX INFO: renamed from: h */
    private void m6932h() {
        this.f6394m = new Timer();
        this.f6395n = new TimerTask() { // from class: com.coollang.tennis.activity.GetEmailPasswordActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                GetEmailPasswordActivity.this.f6398q = true;
            }
        };
        this.f6394m.schedule(this.f6395n, 60000L);
    }

    /* JADX INFO: renamed from: a */
    private void m6925a(String str) {
        if (this.f6391j != null && this.f6391j.m10705c()) {
            this.f6391j.m10706d();
        }
        this.f6391j = new C1926my(this);
        this.f6391j.m10697a(8);
        this.f6391j.m10703b(str);
        this.f6391j.m10696a();
        this.f6391j.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.GetEmailPasswordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GetEmailPasswordActivity.this.f6391j.m10706d();
            }
        });
        this.f6391j.m10701b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }
}
