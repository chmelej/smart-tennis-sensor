package com.coollang.tennis.base;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Handler;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.UserInfoBean;
import com.google.gson.Gson;
import org.litepal.LitePalApplication;
import p000.C0788cc;
import p000.C1808is;
import p000.C1839jw;
import p000.C1902me;
import p000.C2067qx;
import p000.C2068qy;
import p000.C2069qz;
import p000.C2091ru;

/* JADX INFO: loaded from: classes.dex */
public class MyApplication extends LitePalApplication {

    /* JADX INFO: renamed from: i */
    private static MyApplication f7399i;

    /* JADX INFO: renamed from: a */
    public Bitmap f7400a;

    /* JADX INFO: renamed from: e */
    public Typeface f7404e;

    /* JADX INFO: renamed from: f */
    public String f7405f;

    /* JADX INFO: renamed from: g */
    public String f7406g;

    /* JADX INFO: renamed from: j */
    private Handler f7408j;

    /* JADX INFO: renamed from: k */
    private BluetoothAdapter f7409k;

    /* JADX INFO: renamed from: l */
    private UserInfoBean f7410l;

    /* JADX INFO: renamed from: b */
    public boolean f7401b = false;

    /* JADX INFO: renamed from: c */
    public boolean f7402c = true;

    /* JADX INFO: renamed from: d */
    public int f7403d = 0;

    /* JADX INFO: renamed from: m */
    private int f7411m = 0;

    /* JADX INFO: renamed from: h */
    public boolean f7407h = false;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f7399i = this;
        this.f7404e = Typeface.createFromAsset(getAssets(), "fonts/C.ttf");
        m7740j();
        m7739i();
        C1808is.m9824a().mo9820a(true).mo9819a("CLTennis").mo9822b(true).mo9821b("%d{HH:mm:ss:SSS} %t %c{-5}").mo9818a(1);
    }

    /* JADX INFO: renamed from: i */
    private void m7739i() {
        C2068qy.m11356a().m11364a(new C2069qz.a(getApplicationContext()).m11389a(new C2067qx.a().m11343a(Bitmap.Config.RGB_565).m11349b(R.drawable.ic_head_select).m11351c(R.drawable.ic_head_select).m11342a(R.color.white).m11346a(new C2091ru(500)).m11353d(true).m11347a(false).m11350b(true).m11352c(true).m11348a()).m11388a(10).m11391b(83886080).m11392c(180).m11390a());
    }

    /* JADX INFO: renamed from: a */
    public static MyApplication m7738a() {
        return f7399i;
    }

    /* JADX INFO: renamed from: j */
    private void m7740j() {
        this.f7408j = new Handler();
    }

    /* JADX INFO: renamed from: b */
    public void m7742b() {
        this.f7409k = C1839jw.m10025a(this);
    }

    /* JADX INFO: renamed from: c */
    public BluetoothAdapter m7743c() {
        return this.f7409k;
    }

    /* JADX INFO: renamed from: d */
    public Handler m7744d() {
        return this.f7408j;
    }

    /* JADX INFO: renamed from: e */
    public UserInfoBean m7745e() {
        if (this.f7410l == null) {
            String strM10487b = C1902me.m10487b(getApplicationContext(), "userinfo", "");
            if (!"".equals(strM10487b)) {
                this.f7410l = (UserInfoBean) new Gson().fromJson(strM10487b, UserInfoBean.class);
            }
        }
        return this.f7410l;
    }

    /* JADX INFO: renamed from: a */
    public void m7741a(UserInfoBean userInfoBean) {
        this.f7410l = userInfoBean;
        C1902me.m10484a(getApplicationContext(), "userinfo", new Gson().toJson(userInfoBean));
    }

    /* JADX INFO: renamed from: f */
    public void m7746f() {
        if (this.f7400a == null || this.f7400a.isRecycled()) {
            return;
        }
        this.f7400a.recycle();
        this.f7400a = null;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0788cc.m5746a(context);
    }

    /* JADX INFO: renamed from: g */
    public boolean m7747g() {
        return getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("cn");
    }

    /* JADX INFO: renamed from: h */
    public boolean m7748h() {
        return getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("fr");
    }
}
