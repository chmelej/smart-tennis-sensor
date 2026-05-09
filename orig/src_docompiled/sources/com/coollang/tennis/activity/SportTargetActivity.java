package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.SportTargetBean;
import com.coollang.tennis.widget.MultiColorSeekBar;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import com.umeng.message.PushAgent;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1910mi;
import p000.C1914mm;
import p000.DialogC1867kx;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SportTargetActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private TextView f6939a;

    /* JADX INFO: renamed from: b */
    private TextView f6940b;

    /* JADX INFO: renamed from: c */
    private TextView f6941c;

    /* JADX INFO: renamed from: d */
    private MultiColorSeekBar f6942d;

    /* JADX INFO: renamed from: g */
    private DialogC1867kx f6945g;

    /* JADX INFO: renamed from: h */
    private SportTargetBean f6946h;

    /* JADX INFO: renamed from: i */
    private Gson f6947i;

    /* JADX INFO: renamed from: j */
    private C1874ld f6948j;

    /* JADX INFO: renamed from: e */
    private int f6943e = 2000;

    /* JADX INFO: renamed from: f */
    private int f6944f = 2000;

    /* JADX INFO: renamed from: k */
    private int f6949k = 4000;

    /* JADX INFO: renamed from: l */
    private int f6950l = 0;

    /* JADX INFO: renamed from: m */
    private int f6951m = 0;

    /* JADX INFO: renamed from: n */
    private int f6952n = 0;

    /* JADX INFO: renamed from: o */
    private boolean f6953o = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_sport_target);
        akd.m1706a().m1719a(this);
        PushAgent.getInstance(this).onAppStart();
        this.f6948j = new C1874ld();
        this.f6947i = new Gson();
        NavigateView navigateView = (NavigateView) findViewById(R.id.navigateView);
        navigateView.setTitle(C1914mm.m10557b(R.string.target));
        navigateView.setRightImg(R.drawable.ic_save);
        if (MyApplication.m7738a().m7748h()) {
            navigateView.setRightButtonTextSize(10);
            navigateView.setLeftButtonTextSize(10);
            navigateView.setTitleTextSize(12);
        }
        navigateView.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SportTargetActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                C1900mc.m10475c("SportTargetActivity", "currentProgress=" + SportTargetActivity.this.f6944f + "    startProgress=" + SportTargetActivity.this.f6943e);
                if (SportTargetActivity.this.f6944f != SportTargetActivity.this.f6943e) {
                    SportTargetActivity.this.m7339c();
                } else {
                    SportTargetActivity.this.m7733j();
                }
            }
        });
        navigateView.setRightButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.SportTargetActivity.2
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                C1900mc.m10475c("SportTargetActivity", "onComplete----------currentProgress=" + SportTargetActivity.this.f6944f);
                SportTargetActivity.this.f6948j.m10203b(String.valueOf(SportTargetActivity.this.f6944f));
            }
        });
        this.f6939a = (TextView) findViewById(R.id.activity_sport_target_pat);
        this.f6940b = (TextView) findViewById(R.id.activity_sport_target_tv_sport_time);
        this.f6941c = (TextView) findViewById(R.id.activity_sport_target_tv_calori);
        this.f6942d = (MultiColorSeekBar) findViewById(R.id.activity_sport_target_seekbar);
        this.f6942d.setMax(this.f6949k);
        this.f6942d.setOnSeekbarChangedListener(new MultiColorSeekBar.InterfaceC1342a() { // from class: com.coollang.tennis.activity.SportTargetActivity.3
            @Override // com.coollang.tennis.widget.MultiColorSeekBar.InterfaceC1342a
            /* JADX INFO: renamed from: a */
            public void mo7343a(int i) {
                C1900mc.m10475c("SportTargetActivity", "onChangedProgress-----------------");
                SportTargetActivity.this.f6944f = i;
                SportTargetActivity.this.m7335a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m7339c() {
        this.f6945g = new DialogC1867kx(this, C1914mm.m10557b(R.string.isSave), "", C1914mm.m10557b(R.string.save), C1914mm.m10557b(R.string.unSave), new DialogC1867kx.a() { // from class: com.coollang.tennis.activity.SportTargetActivity.4
            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7196a(String str) {
                SportTargetActivity.this.f6948j.m10203b(String.valueOf(SportTargetActivity.this.f6944f));
            }

            @Override // p000.DialogC1867kx.a
            /* JADX INFO: renamed from: a */
            public void mo7195a() {
                SportTargetActivity.this.m7733j();
            }
        });
        this.f6945g.show();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 12) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("SportTargetActivity", "获取运动目标连接服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("SportTargetActivity", "获取运动目标失败");
                    break;
                case 1:
                    this.f6947i = new Gson();
                    this.f6946h = (SportTargetBean) this.f6947i.fromJson(c1873lc.f11064a, SportTargetBean.class);
                    C1900mc.m10475c("SportTargetActivity", "获取运动目标成功");
                    break;
            }
        }
        if (c1873lc.f11072i == 11) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("SportTargetActivity", "保存运动目标连接服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("SportTargetActivity", "保存运动目标失败");
                    break;
                case 1:
                    C1900mc.m10475c("SportTargetActivity", "保存运动目标成功");
                    this.f6943e = this.f6944f;
                    Toast.makeText(this, C1914mm.m10557b(R.string.save_success), 0).show();
                    m7733j();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7336a(Activity activity, int i, int i2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) SportTargetActivity.class);
        intent.putExtra("startProgress", i);
        intent.putExtra("average", i2);
        intent.putExtra("recommend", i3);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f6953o) {
            Intent intent = getIntent();
            this.f6950l = intent.getIntExtra("startProgress", 0);
            this.f6951m = intent.getIntExtra("average", 0);
            this.f6952n = intent.getIntExtra("recommend", 0);
            this.f6944f = this.f6950l;
            this.f6943e = this.f6944f;
            m7342d();
            this.f6953o = false;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7342d() {
        this.f6942d.setProgress(this.f6943e, this.f6951m, this.f6952n);
        m7335a(this.f6943e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7335a(int i) {
        String strValueOf = String.valueOf(i);
        this.f6939a.setText(C1910mi.m10524a(strValueOf, strValueOf + C1914mm.m10557b(R.string.pat), 45, Color.parseColor("#25c9ad")));
        int i2 = i / 6;
        String strValueOf2 = String.valueOf(i2);
        this.f6940b.setText(C1910mi.m10524a(strValueOf2, strValueOf2 + C1914mm.m10557b(R.string.minute), 33, Color.parseColor("#ff8560")));
        String strValueOf3 = String.valueOf(i2 * 7);
        this.f6941c.setText(C1910mi.m10524a(strValueOf3, strValueOf3 + C1914mm.m10557b(R.string.cal), 33, Color.parseColor("#ff8560")));
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f6944f != this.f6943e) {
                m7339c();
                return true;
            }
            m7733j();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }
}
