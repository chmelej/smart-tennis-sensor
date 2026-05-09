package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.BaseBean;
import com.coollang.tennis.widget.NavigateView;
import com.google.gson.Gson;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1909mh;
import p000.C1913ml;
import p000.C1926my;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class EmailSignUpActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6357a;

    /* JADX INFO: renamed from: b */
    private EditText f6358b;

    /* JADX INFO: renamed from: c */
    private EditText f6359c;

    /* JADX INFO: renamed from: d */
    private EditText f6360d;

    /* JADX INFO: renamed from: e */
    private Button f6361e;

    /* JADX INFO: renamed from: f */
    private C1874ld f6362f;

    /* JADX INFO: renamed from: g */
    private PopupWindow f6363g;

    /* JADX INFO: renamed from: h */
    private C1926my f6364h;

    /* JADX INFO: renamed from: i */
    private Gson f6365i;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_email_sign_up);
        m6917c();
        this.f6362f = new C1874ld();
        this.f6365i = new Gson();
        this.f6357a.setRightHideBtn(true);
        this.f6357a.setTitle("E-mail Sign Up");
        akd.m1706a().m1719a(this);
        this.f6361e.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.EmailSignUpActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmailSignUpActivity.this.m7734k();
                String strTrim = EmailSignUpActivity.this.f6358b.getText().toString().trim();
                String strTrim2 = EmailSignUpActivity.this.f6359c.getText().toString().trim();
                String strTrim3 = EmailSignUpActivity.this.f6360d.getText().toString().trim();
                if (strTrim2.length() < 6 || strTrim3.length() < 6) {
                    EmailSignUpActivity.this.m6914a(EmailSignUpActivity.this.getString(R.string.passowrd_characters));
                    return;
                }
                if (!C1909mh.m10522b(strTrim)) {
                    EmailSignUpActivity.this.m6914a(EmailSignUpActivity.this.getString(R.string.email_not_valid));
                } else if (!strTrim2.equals(strTrim3)) {
                    EmailSignUpActivity.this.m6914a(EmailSignUpActivity.this.getString(R.string.password_identical));
                } else {
                    EmailSignUpActivity.this.m6911a(EmailSignUpActivity.this.f6360d);
                    EmailSignUpActivity.this.f6362f.m10204b(strTrim, strTrim2);
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m6917c() {
        this.f6357a = (NavigateView) findViewById(R.id.navigateView);
        this.f6358b = (EditText) findViewById(R.id.activity_sign_up_et_email);
        this.f6359c = (EditText) findViewById(R.id.activity_sign_up_et_password);
        this.f6360d = (EditText) findViewById(R.id.activity_sign_up_et_confirm);
        this.f6361e = (Button) findViewById(R.id.activity_sign_up_btn_sign_up);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6914a(String str) {
        this.f6364h = new C1926my(this);
        this.f6364h.m10697a(8);
        this.f6364h.m10703b(str);
        this.f6364h.m10696a();
        this.f6364h.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.EmailSignUpActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmailSignUpActivity.this.f6364h.m10706d();
            }
        });
        this.f6364h.m10701b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6911a(View view) {
        this.f6363g = new PopupWindow(View.inflate(this, R.layout.popupwindow_login, null), -1, -1, true);
        this.f6363g.setTouchable(true);
        this.f6363g.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.EmailSignUpActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6363g.setBackgroundDrawable(new BitmapDrawable());
        this.f6363g.showAtLocation(view, 17, 0, 0);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (this.f6363g != null) {
            this.f6363g.dismiss();
            this.f6363g = null;
        }
        if (c1873lc.f11072i == 19) {
            switch (c1873lc.f11065b) {
                case -1:
                    m6914a(getString(R.string.net_fail));
                    C1900mc.m10475c("EmailSignUpActivity", "邮箱注册连接失败");
                    break;
                case 0:
                    BaseBean baseBean = (BaseBean) this.f6365i.fromJson(c1873lc.f11064a, BaseBean.class);
                    if (baseBean != null && baseBean.ret.equals("-11001")) {
                        m6914a(getString(R.string.email_been_registered));
                    } else {
                        m6914a(getString(R.string.sign_email_fail));
                    }
                    C1900mc.m10475c("EmailSignUpActivity", "邮箱注册失败" + c1873lc.f11064a);
                    break;
                case 1:
                    C1900mc.m10475c("EmailSignUpActivity", "邮箱注册成功！");
                    C1913ml.m10552a(R.string.sign_email_success);
                    m7733j();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }

    /* JADX INFO: renamed from: a */
    public static void m6910a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) EmailSignUpActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f6364h != null && this.f6364h.m10705c()) {
            this.f6364h.m10706d();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
