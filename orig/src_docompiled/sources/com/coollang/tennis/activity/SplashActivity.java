package com.coollang.tennis.activity;

import android.content.Intent;
import android.os.Handler;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UserInfoBean;
import com.google.gson.Gson;
import com.umeng.message.PushAgent;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1902me;
import p000.C1914mm;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private C1874ld f6894a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_splash);
        PushAgent.getInstance(this).onAppStart();
        MyApplication.m7738a().m7742b();
        this.f6894a = new C1874ld();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        akd.m1706a().m1719a(this);
        new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.SplashActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SplashActivity.this.f6894a.m10201b();
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 0) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    m7306c();
                    break;
                case 1:
                    this.f6894a.m10212d();
                    break;
            }
        }
        if (c1873lc.f11072i == 3) {
            if (c1873lc.f11065b == 1) {
                MyApplication.m7738a().m7741a((UserInfoBean) new Gson().fromJson(c1873lc.f11064a, UserInfoBean.class));
                C1902me.m10482a(C1914mm.m10554a(), MyApplication.m7738a().m7745e().errDesc.UserID);
                C1902me.m10481a(m7304a(MyApplication.m7738a().m7745e().errDesc.Hand));
                MainActivity.m6983a(this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
                return;
            }
            m7306c();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m7306c() {
        startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    private int m7304a(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
