package com.coollang.tennis.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.p007qq.C0874QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.coollang.tennis.widget.BaseLineView;
import com.coollang.tennis.widget.NavigateView;
import com.lidroid.xutils.util.PreferencesCookieStore;
import com.umeng.message.PushAgent;
import org.litepal.crud.DataSupport;
import p000.C1834jr;
import p000.C1839jw;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1890lt;
import p000.C1896lz;
import p000.C1902me;
import p000.C1912mk;
import p000.C1914mm;
import p000.C1926my;

/* JADX INFO: loaded from: classes.dex */
public class SettingActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    public static boolean f6644a = false;

    /* JADX INFO: renamed from: b */
    private NavigateView f6645b;

    /* JADX INFO: renamed from: c */
    private TextView f6646c;

    /* JADX INFO: renamed from: d */
    private RelativeLayout f6647d;

    /* JADX INFO: renamed from: e */
    private RadioGroup f6648e;

    /* JADX INFO: renamed from: f */
    private Button f6649f;

    /* JADX INFO: renamed from: g */
    private BaseLineView f6650g;

    /* JADX INFO: renamed from: h */
    private BaseLineView f6651h;

    /* JADX INFO: renamed from: i */
    private BaseLineView f6652i;

    /* JADX INFO: renamed from: j */
    private BaseLineView f6653j;

    /* JADX INFO: renamed from: k */
    private BaseLineView f6654k;

    /* JADX INFO: renamed from: l */
    private BaseLineView f6655l;

    /* JADX INFO: renamed from: m */
    private BaseLineView f6656m;

    /* JADX INFO: renamed from: n */
    private BaseLineView f6657n;

    /* JADX INFO: renamed from: o */
    private LinearLayout f6658o;

    /* JADX INFO: renamed from: p */
    private BaseLineView f6659p;

    /* JADX INFO: renamed from: q */
    private BaseLineView f6660q;

    /* JADX INFO: renamed from: r */
    private BaseLineView f6661r;

    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_setting);
        PushAgent.getInstance(this).onAppStart();
        m7094e();
        this.f6645b.setTitle(C1914mm.m10557b(R.string.setting));
        this.f6645b.setRightHideBtn(true);
        if (!MyApplication.m7738a().m7747g()) {
            findViewById(R.id.line_share).setVisibility(8);
            this.f6655l.setVisibility(8);
        }
        if (C1902me.m10479a().equalsIgnoreCase("TS")) {
            this.f6658o.setVisibility(8);
        } else {
            this.f6658o.setVisibility(0);
        }
        this.f6661r.setRightText(C1902me.m10480a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6657n.setLeftText(C1914mm.m10557b(R.string.personal_text11) + " " + m7100d());
        m7095f();
    }

    /* JADX INFO: renamed from: e */
    private void m7094e() {
        this.f6645b = (NavigateView) findViewById(R.id.navigateView);
        this.f6650g = (BaseLineView) findViewById(R.id.blv_personal_setting);
        this.f6651h = (BaseLineView) findViewById(R.id.blv_use_setting);
        this.f6652i = (BaseLineView) findViewById(R.id.blv_faq_setting);
        this.f6653j = (BaseLineView) findViewById(R.id.blv_buy_setting);
        this.f6654k = (BaseLineView) findViewById(R.id.blv_reset_setting);
        this.f6655l = (BaseLineView) findViewById(R.id.blv_share_setting);
        this.f6656m = (BaseLineView) findViewById(R.id.blv_advice_setting);
        this.f6657n = (BaseLineView) findViewById(R.id.blv_version_setting);
        this.f6647d = (RelativeLayout) findViewById(R.id.activity_sport_detail_rl_share);
        this.f6648e = (RadioGroup) findViewById(R.id.activity_sport_detail_rg);
        this.f6649f = (Button) findViewById(R.id.activity_sport_detail_btn_cancle);
        this.f6646c = (TextView) findViewById(R.id.activity_setting_tv_exit_login);
        this.f6658o = (LinearLayout) findViewById(R.id.ll_setting_use);
        this.f6659p = (BaseLineView) findViewById(R.id.blv_equip_setting);
        this.f6660q = (BaseLineView) findViewById(R.id.blv_my_history_setting);
        this.f6661r = (BaseLineView) findViewById(R.id.blv_userId_setting);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.activity_setting_tv_exit_login /* 2131296333 */:
                new PreferencesCookieStore(getApplicationContext()).clear();
                C1834jr.m10010a();
                m7099c();
                break;
            case R.id.activity_sport_detail_btn_cancle /* 2131296345 */:
                this.f6647d.setVisibility(8);
                break;
            case R.id.activity_sport_detail_rl_share /* 2131296351 */:
                this.f6647d.setVisibility(8);
                break;
            case R.id.blv_advice_setting /* 2131296392 */:
                startActivity(new Intent(this, (Class<?>) AdvoiceActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                break;
            case R.id.blv_buy_setting /* 2131296396 */:
                if (C1902me.m10488b()) {
                    DataWebActivity.m6895a(this, "https://detail.tmall.com/item.htm?id=536578823524", C1914mm.m10557b(R.string.setting_about_us));
                } else {
                    DataWebActivity.m6895a(this, getString(R.string.about_us_url), C1914mm.m10557b(R.string.setting_about_us));
                }
                break;
            case R.id.blv_equip_setting /* 2131296401 */:
                C1887lq.m10429g(this);
                break;
            case R.id.blv_faq_setting /* 2131296402 */:
                if (MyApplication.m7738a().m7747g()) {
                    if (C1902me.m10488b()) {
                        DataWebActivity.m6895a(this, "http://appserv.coollang.com/TennisViewController/faq_HD", C1914mm.m10557b(R.string.personal_text4));
                    } else {
                        DataWebActivity.m6895a(this, "http://appserv.coollang.com/TennisViewController/faq", C1914mm.m10557b(R.string.personal_text4));
                    }
                } else {
                    DataWebActivity.m6895a(this, "http://appserv.coollang.com/TennisViewController/faqEn", C1914mm.m10557b(R.string.personal_text4));
                }
                break;
            case R.id.blv_my_history_setting /* 2131296407 */:
                C1887lq.m10428f(this);
                break;
            case R.id.blv_personal_setting /* 2131296410 */:
                C1887lq.m10430h(this);
                break;
            case R.id.blv_reset_setting /* 2131296413 */:
                if (MyApplication.m7738a().f7401b) {
                    m7096g();
                } else {
                    Toast.makeText(C1914mm.m10554a(), C1914mm.m10557b(R.string.connect_device), 0).show();
                }
                break;
            case R.id.blv_share_setting /* 2131296419 */:
                this.f6647d.setVisibility(0);
                break;
            case R.id.blv_use_setting /* 2131296428 */:
                if (C1902me.m10488b()) {
                    startActivity(new Intent(this, (Class<?>) HeadFastUseActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                } else {
                    startActivity(new Intent(this, (Class<?>) FastUseActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }
                break;
            case R.id.iv_return /* 2131296734 */:
                finish();
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m7099c() {
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        Process.killProcess(Process.myPid());
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.activity_sport_detail_rb_friend /* 2131296346 */:
                this.f6647d.setVisibility(8);
                m7091a(WechatMoments.NAME);
                break;
            case R.id.activity_sport_detail_rb_qq /* 2131296347 */:
                this.f6647d.setVisibility(8);
                m7093b(C0874QQ.NAME);
                break;
            case R.id.activity_sport_detail_rb_weixin /* 2131296348 */:
                this.f6647d.setVisibility(8);
                m7091a(Wechat.NAME);
                break;
            case R.id.activity_sport_detail_rb_zone /* 2131296349 */:
                this.f6647d.setVisibility(8);
                m7093b(QZone.NAME);
                break;
        }
        ((RadioButton) this.f6648e.findViewById(i)).setChecked(false);
    }

    /* JADX INFO: renamed from: f */
    private void m7095f() {
        this.f6646c.setOnClickListener(this);
        this.f6647d.setOnClickListener(this);
        this.f6648e.setOnCheckedChangeListener(this);
        this.f6649f.setOnClickListener(this);
        this.f6650g.setOnClickListener(this);
        this.f6651h.setOnClickListener(this);
        this.f6652i.setOnClickListener(this);
        this.f6653j.setOnClickListener(this);
        this.f6654k.setOnClickListener(this);
        this.f6655l.setOnClickListener(this);
        this.f6656m.setOnClickListener(this);
        this.f6657n.setOnClickListener(this);
        this.f6659p.setOnClickListener(this);
        this.f6660q.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    private void m7091a(String str) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(getString(R.string.app_name));
        onekeyShare.setText(getString(R.string.invait));
        onekeyShare.setTitleUrl(getString(R.string.share_url));
        onekeyShare.setUrl(getString(R.string.share_url));
        onekeyShare.setSiteUrl(getString(R.string.share_url));
        onekeyShare.setImagePath(C1890lt.m10438a("logo", ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_logo)).getBitmap()));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this);
    }

    /* JADX INFO: renamed from: b */
    private void m7093b(String str) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(getString(R.string.app_name));
        onekeyShare.setTitleUrl(getString(R.string.share_url));
        onekeyShare.setUrl(getString(R.string.share_url));
        onekeyShare.setSiteUrl(getString(R.string.share_url));
        onekeyShare.setImagePath(C1890lt.m10438a("logo", ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_logo)).getBitmap()));
        onekeyShare.setText(getString(R.string.invait));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this);
    }

    /* JADX INFO: renamed from: g */
    private void m7096g() {
        final C1926my c1926my = new C1926my(this);
        c1926my.m10700a(C1914mm.m10557b(R.string.sport_list_text3));
        c1926my.m10703b(C1914mm.m10557b(R.string.setting_reset_content));
        c1926my.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.SettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingActivity.this.m7098i();
                SettingActivity.this.m7097h();
                c1926my.m10706d();
            }
        });
        c1926my.m10701b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7097h() {
        C1874ld c1874ld = new C1874ld();
        String strM10539b = C1912mk.m10539b();
        if (DataSupport.where("date = ? And UserID = ?", Long.toString(C1912mk.m10538b(strM10539b + " 00:00:00")), C1902me.m10480a(this)).count(MyMainTable.class) > 0) {
            c1874ld.m10190a(strM10539b, 1, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m7098i() {
        C1839jw.m10026a().m10042a(4);
    }

    /* JADX INFO: renamed from: d */
    public String m7100d() {
        try {
            return C1914mm.m10554a().getPackageManager().getPackageInfo(C1914mm.m10554a().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f6647d.getVisibility() == 0) {
            this.f6647d.setVisibility(8);
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
