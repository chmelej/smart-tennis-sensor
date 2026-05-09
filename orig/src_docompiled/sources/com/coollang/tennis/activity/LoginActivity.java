package com.coollang.tennis.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.smssdk.SMSSDK;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UserInfoBean;
import com.google.gson.Gson;
import com.umeng.message.PushAgent;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1889ls;
import p000.C1896lz;
import p000.C1899mb;
import p000.C1900mc;
import p000.C1902me;
import p000.C1909mh;
import p000.C1914mm;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class LoginActivity extends FragmentActivity implements View.OnClickListener, PlatformActionListener {

    /* JADX INFO: renamed from: A */
    private Button f6433A;

    /* JADX INFO: renamed from: B */
    private ImageButton f6434B;

    /* JADX INFO: renamed from: C */
    private LinearLayout f6435C;

    /* JADX INFO: renamed from: b */
    private Button f6437b;

    /* JADX INFO: renamed from: c */
    private Button f6438c;

    /* JADX INFO: renamed from: e */
    private EditText f6440e;

    /* JADX INFO: renamed from: f */
    private EditText f6441f;

    /* JADX INFO: renamed from: g */
    private TextView f6442g;

    /* JADX INFO: renamed from: i */
    private TimerTask f6444i;

    /* JADX INFO: renamed from: j */
    private Timer f6445j;

    /* JADX INFO: renamed from: k */
    private String f6446k;

    /* JADX INFO: renamed from: l */
    private String f6447l;

    /* JADX INFO: renamed from: m */
    private PopupWindow f6448m;

    /* JADX INFO: renamed from: n */
    private Platform f6449n;

    /* JADX INFO: renamed from: p */
    private String f6451p;

    /* JADX INFO: renamed from: q */
    private String f6452q;

    /* JADX INFO: renamed from: r */
    private String f6453r;

    /* JADX INFO: renamed from: s */
    private String f6454s;

    /* JADX INFO: renamed from: t */
    private String f6455t;

    /* JADX INFO: renamed from: u */
    private C1874ld f6456u;

    /* JADX INFO: renamed from: v */
    private ImageView f6457v;

    /* JADX INFO: renamed from: w */
    private C1899mb f6458w;

    /* JADX INFO: renamed from: x */
    private EditText f6459x;

    /* JADX INFO: renamed from: y */
    private EditText f6460y;

    /* JADX INFO: renamed from: z */
    private Button f6461z;

    /* JADX INFO: renamed from: d */
    private boolean f6439d = true;

    /* JADX INFO: renamed from: h */
    private int f6443h = 60;

    /* JADX INFO: renamed from: o */
    private boolean f6450o = true;

    /* JADX INFO: renamed from: a */
    Handler f6436a = new Handler() { // from class: com.coollang.tennis.activity.LoginActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (LoginActivity.this.f6443h > 0) {
                        LoginActivity.this.f6437b.setText(LoginActivity.this.f6443h + " s");
                    } else {
                        LoginActivity.this.f6437b.setText(C1914mm.m10557b(R.string.get_identify_code2));
                        LoginActivity.this.f6437b.setEnabled(true);
                        LoginActivity.this.f6443h = 30;
                        LoginActivity.this.f6444i.cancel();
                    }
                    break;
                case 1:
                    LoginActivity.this.m6956a(LoginActivity.this.f6459x);
                    LoginActivity.this.f6456u.m10196a(LoginActivity.this.f6451p, LoginActivity.this.f6452q, "5", LoginActivity.this.f6453r, LoginActivity.this.f6455t, LoginActivity.this.f6454s);
                    break;
            }
        }
    };

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
    }

    /* JADX INFO: renamed from: n */
    static /* synthetic */ int m6977n(LoginActivity loginActivity) {
        int i = loginActivity.f6443h;
        loginActivity.f6443h = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (MyApplication.m7738a().m7747g()) {
            setContentView(R.layout.acitivty_login);
            m6978a();
        } else {
            setContentView(R.layout.activity_login_en);
            m6966e();
        }
        PushAgent.getInstance(this).onAppStart();
        akd.m1706a().m1719a(this);
        this.f6456u = new C1874ld();
        SMSSDK.initSDK(this, "de241bc58470", "9ca2d03a894a2517193c6f7962aefe36");
        ShareSDK.initSDK(this);
    }

    /* JADX INFO: renamed from: e */
    private void m6966e() {
        this.f6459x = (EditText) findViewById(R.id.activity_login_en_et_email);
        this.f6460y = (EditText) findViewById(R.id.activity_login_en_et_password);
        this.f6461z = (Button) findViewById(R.id.activity_login_en_btn_sign_up);
        this.f6433A = (Button) findViewById(R.id.activity_login_en_btn_log_in);
        this.f6434B = (ImageButton) findViewById(R.id.activity_login_en_ib_facebook);
        this.f6435C = (LinearLayout) findViewById(R.id.activity_login_en_ll_forgot_password);
        this.f6461z.setOnClickListener(this);
        this.f6433A.setOnClickListener(this);
        this.f6434B.setOnClickListener(this);
        this.f6435C.setOnClickListener(this);
        String strM10487b = C1902me.m10487b(this, "user_name_en", "");
        this.f6459x.setText(strM10487b);
        if (strM10487b.isEmpty()) {
            return;
        }
        this.f6459x.setSelection(strM10487b.length());
    }

    /* JADX INFO: renamed from: a */
    protected void m6978a() {
        this.f6442g = (TextView) findViewById(R.id.shengming);
        this.f6440e = (EditText) findViewById(R.id.userName);
        this.f6441f = (EditText) findViewById(R.id.password);
        this.f6437b = (Button) findViewById(R.id.getPassword);
        this.f6438c = (Button) findViewById(R.id.Login);
        this.f6457v = (ImageView) findViewById(R.id.activity_login_iv_weixin);
        this.f6457v.setOnClickListener(this);
        this.f6438c.setEnabled(false);
        this.f6437b.setOnClickListener(this);
        this.f6438c.setOnClickListener(this);
        this.f6442g.setOnClickListener(this);
        this.f6440e.addTextChangedListener(new C1889ls() { // from class: com.coollang.tennis.activity.LoginActivity.2
            @Override // p000.C1889ls, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (C1909mh.m10521a(charSequence.toString())) {
                    LoginActivity.this.f6440e.setTextColor(C1914mm.m10559d(R.color.target_2));
                } else {
                    LoginActivity.this.f6440e.setTextColor(C1914mm.m10559d(R.color.white));
                }
            }
        });
        this.f6441f.addTextChangedListener(new C1889ls() { // from class: com.coollang.tennis.activity.LoginActivity.3
            @Override // p000.C1889ls, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().length() == 4) {
                    LoginActivity.this.f6441f.setTextColor(C1914mm.m10559d(R.color.target_2));
                    LoginActivity.this.f6438c.setEnabled(true);
                } else {
                    LoginActivity.this.f6441f.setTextColor(C1914mm.m10559d(R.color.white));
                    LoginActivity.this.f6438c.setEnabled(false);
                }
            }
        });
        String strM10487b = C1902me.m10487b(this, "user_name", "");
        this.f6440e.setText(strM10487b);
        if (strM10487b.isEmpty()) {
            return;
        }
        this.f6440e.setSelection(strM10487b.length());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.Login /* 2131296266 */:
                m6981d();
                break;
            case R.id.activity_login_en_btn_log_in /* 2131296302 */:
                String strTrim = this.f6459x.getText().toString().trim();
                String strTrim2 = this.f6460y.getText().toString().trim();
                if (!TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                    m6956a(this.f6459x);
                    this.f6456u.m10194a(strTrim, strTrim2, m6979b());
                    C1902me.m10484a(this, "user_name_en", strTrim);
                } else {
                    Toast.makeText(this, R.string.email_password_write, 0).show();
                }
                break;
            case R.id.activity_login_en_btn_sign_up /* 2131296303 */:
                EmailSignUpActivity.m6910a(this);
                break;
            case R.id.activity_login_en_ib_facebook /* 2131296306 */:
                m6956a(this.f6459x);
                m6970g();
                break;
            case R.id.activity_login_en_ll_forgot_password /* 2131296307 */:
                C1887lq.m10431i(this);
                break;
            case R.id.activity_login_iv_weixin /* 2131296308 */:
                m6956a(this.f6438c);
                m6968f();
                break;
            case R.id.getPassword /* 2131296610 */:
                this.f6446k = this.f6440e.getText().toString().trim();
                if (TextUtils.isEmpty(this.f6446k) || !C1909mh.m10521a(this.f6446k)) {
                    Toast.makeText(this, C1914mm.m10557b(R.string.pinputphone), 0).show();
                } else {
                    SMSSDK.getVerificationCode("86", this.f6446k);
                    this.f6437b.setEnabled(false);
                    m6980c();
                }
                break;
            case R.id.shengming /* 2131297089 */:
                DataWebActivity.m6895a(this, "http://www.coollang.com/appcontent/responsibility/?type=2", C1914mm.m10557b(R.string.neccery));
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6979b() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f6448m != null) {
            this.f6448m.dismiss();
            this.f6448m = null;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m6968f() {
        this.f6449n = new Wechat(this);
        this.f6449n.setPlatformActionListener(this);
        this.f6449n.showUser(null);
        this.f6449n.authorize();
    }

    /* JADX INFO: renamed from: g */
    private void m6970g() {
        this.f6449n = ShareSDK.getPlatform(Facebook.NAME);
        CookieSyncManager.createInstance(this.f6449n.getContext());
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
        if (this.f6449n.isValid()) {
            this.f6449n.removeAccount();
        }
        this.f6449n.setPlatformActionListener(new PlatformActionListener() { // from class: com.coollang.tennis.activity.LoginActivity.4
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i, Throwable th) {
                C1900mc.m10475c("LoginActivity", "arg2=" + th.toString());
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
                LoginActivity.this.f6451p = platform.getDb().getToken();
                LoginActivity.this.f6452q = platform.getDb().getUserId();
                LoginActivity.this.f6453r = platform.getDb().getUserGender();
                LoginActivity.this.f6454s = platform.getDb().getUserIcon();
                LoginActivity.this.f6455t = platform.getDb().getUserName();
                LoginActivity.this.f6436a.sendEmptyMessage(1);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform, int i) {
                C1900mc.m10475c("LoginActivity", "arg1 = " + i);
            }
        });
        this.f6449n.showUser(null);
        this.f6449n.SSOSetting(false);
    }

    /* JADX INFO: renamed from: c */
    public void m6980c() {
        this.f6445j = new Timer();
        this.f6444i = new TimerTask() { // from class: com.coollang.tennis.activity.LoginActivity.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LoginActivity.m6977n(LoginActivity.this);
                LoginActivity.this.f6436a.sendEmptyMessage(0);
            }
        };
        this.f6445j.schedule(this.f6444i, 0L, 1000L);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (this.f6448m != null) {
            this.f6448m.dismiss();
            this.f6448m = null;
        }
        if (c1873lc.f11072i == 1) {
            switch (c1873lc.f11065b) {
                case -1:
                    Toast.makeText(this, C1914mm.m10557b(R.string.login_connectionerror), 0).show();
                    break;
                case 0:
                    Toast.makeText(this, C1914mm.m10557b(R.string.login_failed), 0).show();
                    break;
                case 1:
                    if ("1".equals(c1873lc.f11064a)) {
                        this.f6450o = true;
                    } else {
                        this.f6450o = false;
                    }
                    this.f6456u.m10212d();
                    Toast.makeText(this, C1914mm.m10557b(R.string.login_success), 0).show();
                    break;
            }
        }
        if (c1873lc.f11072i == 3) {
            UserInfoBean userInfoBean = new UserInfoBean();
            if (c1873lc.f11065b == 1) {
                C1900mc.m10475c("LoginActivity", "获取用户信息成功");
                userInfoBean = (UserInfoBean) new Gson().fromJson(c1873lc.f11064a, UserInfoBean.class);
                MyApplication.m7738a().m7741a(userInfoBean);
                C1902me.m10482a(getApplicationContext(), MyApplication.m7738a().m7745e().errDesc.UserID);
                C1902me.m10481a(m6954a(MyApplication.m7738a().m7745e().errDesc.Hand));
            } else if (c1873lc.f11065b == 0) {
                C1900mc.m10475c("LoginActivity", "获取用户信息失败");
            } else if (c1873lc.f11065b == -1) {
                C1900mc.m10475c("LoginActivity", "获取用户信息连接失败");
            }
            if (this.f6450o) {
                if (userInfoBean.errDesc != null) {
                    C1887lq.m10414a(this, userInfoBean.errDesc.Icon, userInfoBean.errDesc.UserName);
                } else {
                    C1887lq.m10414a(this, (String) null, (String) null);
                }
            } else {
                MainActivity.m6983a(this);
            }
            finish();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6981d() {
        this.f6447l = this.f6441f.getText().toString();
        this.f6446k = this.f6440e.getText().toString();
        if (TextUtils.isEmpty(this.f6446k) || !C1909mh.m10521a(this.f6446k)) {
            Toast.makeText(this, C1914mm.m10557b(R.string.pinputphone), 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.f6447l) || this.f6447l.length() < 4) {
            Toast.makeText(this, C1914mm.m10557b(R.string.inputyan), 0).show();
            return;
        }
        m6956a(this.f6438c);
        this.f6456u.m10192a(this.f6446k, this.f6447l);
        C1902me.m10484a(this, "user_name", this.f6446k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6956a(View view) {
        if (this.f6448m != null && this.f6448m.isShowing()) {
            this.f6448m.dismiss();
        }
        this.f6448m = new PopupWindow(View.inflate(this, R.layout.popupwindow_login, null), -1, -1, true);
        this.f6448m.setTouchable(true);
        this.f6448m.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.activity.LoginActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f6448m.setBackgroundDrawable(new BitmapDrawable());
        this.f6448m.showAtLocation(view, 17, 0, 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
        if (this.f6458w != null) {
            getContentResolver().unregisterContentObserver(this.f6458w);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        this.f6456u.m10205b(platform.getDb().getToken(), platform.getDb().getUserId(), "2");
        if (this.f6449n == null || !this.f6449n.isValid()) {
            return;
        }
        this.f6449n.removeAccount();
    }

    /* JADX INFO: renamed from: a */
    private int m6954a(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
