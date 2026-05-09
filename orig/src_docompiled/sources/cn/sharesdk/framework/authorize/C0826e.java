package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.ResizeLayout;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;

/* JADX INFO: renamed from: cn.sharesdk.framework.authorize.e */
/* JADX INFO: compiled from: WebAuthorizeActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0826e extends C0822a implements Handler.Callback, ResizeLayout.OnResizeListener {

    /* JADX INFO: renamed from: b */
    protected AuthorizeListener f5555b;

    /* JADX INFO: renamed from: c */
    private AuthorizeAdapter f5556c;

    /* JADX INFO: renamed from: d */
    private RegisterView f5557d;

    /* JADX INFO: renamed from: e */
    private WebView f5558e;

    /* JADX INFO: renamed from: a */
    public void m5990a(AuthorizeListener authorizeListener) {
        this.f5555b = authorizeListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f5556c == null) {
            this.f5556c = m5989c();
            if (this.f5556c == null) {
                this.f5556c = new AuthorizeAdapter();
            }
        }
        this.f5556c.setActivity(activity);
    }

    /* JADX INFO: renamed from: c */
    private AuthorizeAdapter m5989c() {
        try {
            ActivityInfo activityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128);
            if (activityInfo.metaData != null && !activityInfo.metaData.isEmpty()) {
                String string = activityInfo.metaData.getString("AuthorizeAdapter");
                if ((string != null && string.length() > 0) || ((string = activityInfo.metaData.getString("Adapter")) != null && string.length() > 0)) {
                    Object objNewInstance = Class.forName(string).newInstance();
                    if (objNewInstance instanceof AuthorizeAdapter) {
                        return (AuthorizeAdapter) objNewInstance;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return null;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        if (this.f5557d == null) {
            this.f5557d = m5991b();
            this.f5557d.m5981a(this);
            this.f5557d.m5977a(this.f5556c.isNotitle());
            this.f5556c.setBodyView(this.f5557d.m5980d());
            this.f5556c.setWebView(this.f5557d.m5978b());
            TitleLayout titleLayoutM5979c = this.f5557d.m5979c();
            this.f5556c.setTitleView(titleLayoutM5979c);
            String name = this.f5546a.getPlatform().getName();
            this.f5556c.setPlatformName(this.f5546a.getPlatform().getName());
            try {
                titleLayoutM5979c.getTvTitle().setText(ResHelper.getStringRes(getContext(), "ssdk_" + name.toLowerCase()));
            } catch (Throwable th) {
                try {
                    titleLayoutM5979c.getTvTitle().setText(ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter"));
                } catch (Throwable unused) {
                    C0851d.m6195a().m8622w(th);
                }
            }
        }
        this.f5556c.onCreate();
        if (this.f5556c != null && !this.f5556c.isPopUpAnimationDisable()) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(550L);
            scaleAnimation.setInterpolator(new a());
            this.f5557d.setAnimation(scaleAnimation);
        }
        this.activity.setContentView(this.f5557d);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [cn.sharesdk.framework.authorize.e$2] */
    /* JADX INFO: renamed from: b */
    protected RegisterView m5991b() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m5976a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.e.1
            /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.framework.authorize.e$1$1] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.framework.authorize.e.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8622w(th);
                            AuthorizeListener authorizeListener = C0826e.this.f5546a.getAuthorizeListener();
                            if (authorizeListener != null) {
                                authorizeListener.onCancel();
                            }
                            C0826e.this.finish();
                        }
                    }
                }.start();
            }
        });
        this.f5558e = registerView.m5978b();
        WebSettings settings = this.f5558e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        this.f5558e.setVerticalScrollBarEnabled(false);
        this.f5558e.setHorizontalScrollBarEnabled(false);
        this.f5558e.setWebViewClient(this.f5546a.getAuthorizeWebviewClient(this));
        new Thread() { // from class: cn.sharesdk.framework.authorize.e.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Message message = new Message();
                    message.what = 2;
                    if ("none".equals(DeviceHelper.getInstance(C0826e.this.activity).getDetailNetworkTypeForStatic())) {
                        message.arg1 = 1;
                        UIHandler.sendMessage(message, C0826e.this);
                        return;
                    }
                    if (ShareSDK.isRemoveCookieOnAuthorize()) {
                        CookieSyncManager.createInstance(C0826e.this.activity);
                        CookieManager.getInstance().removeAllCookie();
                    }
                    message.obj = C0826e.this.f5546a.getAuthorizeUrl();
                    UIHandler.sendMessage(message, C0826e.this);
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
            }
        }.start();
        return registerView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        if (message.arg1 == 1) {
            AuthorizeListener authorizeListener = this.f5546a.getAuthorizeListener();
            if (authorizeListener == null) {
                return false;
            }
            authorizeListener.onError(new Throwable("Network error (platform: " + this.f5546a.getPlatform().getName() + ")"));
            return false;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            finish();
            AuthorizeListener authorizeListener2 = this.f5546a.getAuthorizeListener();
            if (authorizeListener2 == null) {
                return false;
            }
            authorizeListener2.onError(new Throwable("Authorize URL is empty (platform: " + this.f5546a.getPlatform().getName() + ")"));
            return false;
        }
        this.f5558e.loadUrl(str);
        return false;
    }

    @Override // cn.sharesdk.framework.authorize.ResizeLayout.OnResizeListener
    public void OnResize(int i, int i2, int i3, int i4) {
        if (this.f5556c != null) {
            this.f5556c.onResize(i, i2, i3, i4);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        AuthorizeListener authorizeListener;
        boolean zOnKeyEvent = this.f5556c != null ? this.f5556c.onKeyEvent(i, keyEvent) : false;
        if (!zOnKeyEvent && i == 4 && keyEvent.getAction() == 0 && (authorizeListener = this.f5546a.getAuthorizeListener()) != null) {
            authorizeListener.onCancel();
        }
        if (zOnKeyEvent) {
            return true;
        }
        return super.onKeyEvent(i, keyEvent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        if (this.f5556c != null) {
            this.f5556c.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        if (this.f5556c != null) {
            this.f5556c.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        if (this.f5556c != null) {
            this.f5556c.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        if (this.f5556c != null) {
            this.f5556c.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        if (this.f5556c != null) {
            this.f5556c.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f5556c != null) {
            return this.f5556c.onFinish();
        }
        if (this.f5558e != null) {
            this.f5558e.destroy();
            this.f5558e.removeAllViews();
        }
        if (this.activity != null) {
            ((ViewGroup) this.activity.getWindow().getDecorView()).removeAllViews();
        }
        return super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (this.f5556c != null) {
            this.f5556c.onDestroy();
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.framework.authorize.e$a */
    /* JADX INFO: compiled from: WebAuthorizeActivity.java */
    static class a implements Interpolator {

        /* JADX INFO: renamed from: a */
        private float[] f5562a;

        private a() {
            this.f5562a = new float[]{0.0f, 0.02692683f, 0.053847015f, 0.080753915f, 0.10764089f, 0.13450131f, 0.16132854f, 0.18811597f, 0.21485697f, 0.24154496f, 0.26817337f, 0.2947356f, 0.3212251f, 0.34763536f, 0.37395984f, 0.40019205f, 0.42632553f, 0.4523538f, 0.47827047f, 0.50406915f, 0.52974343f, 0.555287f, 0.5806936f, 0.60595685f, 0.6310707f, 0.65602875f, 0.68082494f, 0.70545316f, 0.72990733f, 0.75418144f, 0.7782694f, 0.8021654f, 0.8258634f, 0.8493577f, 0.8726424f, 0.89571184f, 0.9185602f, 0.94118196f, 0.9635715f, 0.9857233f, 1.0076319f, 1.0292919f, 1.0506978f, 1.0718446f, 1.0927268f, 1.1133395f, 1.1336775f, 1.1537358f, 1.1735094f, 1.1929934f, 1.1893399f, 1.1728106f, 1.1565471f, 1.1405534f, 1.1248333f, 1.1093911f, 1.0942302f, 1.0793544f, 1.0647675f, 1.050473f, 1.0364745f, 1.0227754f, 1.0093791f, 0.99628896f, 0.9835081f, 0.9710398f, 0.958887f, 0.9470527f, 0.93553996f, 0.9243516f, 0.91349024f, 0.90295863f, 0.90482706f, 0.9114033f, 0.91775465f, 0.9238795f, 0.9297765f, 0.93544406f, 0.9408808f, 0.94608533f, 0.95105654f, 0.955793f, 0.9602937f, 0.9645574f, 0.96858317f, 0.9723699f, 0.97591674f, 0.97922283f, 0.9822872f, 0.9851093f, 0.98768836f, 0.9900237f, 0.9921147f, 0.993961f, 0.99556196f, 0.9969173f, 0.9980267f, 0.99888986f, 0.99950653f, 0.9998766f, 1.0f};
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) (f * 100.0f);
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            return this.f5562a[i];
        }
    }
}
