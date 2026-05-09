package cn.sharesdk.tencent.p007qq;

import android.app.Activity;
import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import cn.sharesdk.framework.C0845d;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.f */
/* JADX INFO: compiled from: WebShareActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0880f extends FakeActivity {

    /* JADX INFO: renamed from: a */
    private String f5803a;

    /* JADX INFO: renamed from: b */
    private PlatformActionListener f5804b;

    /* JADX INFO: renamed from: c */
    private String f5805c;

    /* JADX INFO: renamed from: d */
    private QQWebShareAdapter f5806d;

    /* JADX INFO: renamed from: e */
    private RegisterView f5807e;

    /* JADX INFO: renamed from: f */
    private WebView f5808f;

    /* JADX INFO: renamed from: g */
    private boolean f5809g;

    /* JADX INFO: renamed from: h */
    private boolean f5810h;

    /* JADX INFO: renamed from: a */
    public void m6347a(String str) {
        this.f5803a = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6346a(PlatformActionListener platformActionListener) {
        this.f5804b = platformActionListener;
    }

    /* JADX INFO: renamed from: b */
    public void m6348b(String str) {
        this.f5805c = "tencent" + str;
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f5806d == null) {
            this.f5806d = m6338b();
            if (this.f5806d == null) {
                this.f5806d = new QQWebShareAdapter();
            }
        }
        this.f5806d.setActivity(activity);
    }

    /* JADX INFO: renamed from: b */
    private QQWebShareAdapter m6338b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("QQWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object objNewInstance = Class.forName(string).newInstance();
                if (objNewInstance instanceof QQWebShareAdapter) {
                    return (QQWebShareAdapter) objNewInstance;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.f5807e = m6345a();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_qq");
            if (stringRes > 0) {
                this.f5807e.m5979c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            this.f5807e.m5979c().setVisibility(8);
        }
        this.f5806d.setBodyView(this.f5807e.m5980d());
        this.f5806d.setWebView(this.f5807e.m5978b());
        this.f5806d.setTitleView(this.f5807e.m5979c());
        this.f5806d.onCreate();
        this.activity.setContentView(this.f5807e);
        if ("none".equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f5809g = true;
            finish();
            this.f5804b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f5807e.m5978b().loadUrl(this.f5803a);
    }

    /* JADX INFO: renamed from: a */
    protected RegisterView m6345a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m5979c().getChildAt(registerView.m5979c().getChildCount() - 1).setVisibility(8);
        registerView.m5976a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.tencent.qq.f.1
            /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.tencent.qq.f$1$1] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.tencent.qq.f.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8610d(th);
                            C0880f.this.finish();
                            C0880f.this.f5804b.onCancel(null, 0);
                        }
                    }
                }.start();
            }
        });
        this.f5808f = registerView.m5978b();
        WebSettings settings = this.f5808f.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.f5808f.setVerticalScrollBarEnabled(false);
        this.f5808f.setHorizontalScrollBarEnabled(false);
        this.f5808f.setWebViewClient(new C0845d() { // from class: cn.sharesdk.tencent.qq.f.2
            @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null && str.startsWith(C0880f.this.f5805c)) {
                    C0880f.this.m6341c(str);
                } else if (str != null && str.startsWith("http://www.myapp.com/down/")) {
                    C0880f.this.f5810h = true;
                } else if (str != null && str.startsWith("wtloginmqq://")) {
                    int stringRes = ResHelper.getStringRes(C0880f.this.activity, "ssdk_use_login_button");
                    if (stringRes > 0) {
                        Toast.makeText(C0880f.this.activity, stringRes, 0).show();
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (str != null && str.startsWith("wtloginmqq://")) {
                    int stringRes = ResHelper.getStringRes(C0880f.this.activity, "ssdk_use_login_button");
                    if (stringRes > 0) {
                        Toast.makeText(C0880f.this.activity, stringRes, 0).show();
                        return;
                    }
                    return;
                }
                super.onPageStarted(webView, str, bitmap);
            }
        });
        return registerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m6341c(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle == null) {
            this.f5809g = true;
            finish();
            this.f5804b.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = bundleUrlToBundle.getString("action");
        if (!"share".equals(string) && !"shareToQQ".equals(string)) {
            this.f5809g = true;
            finish();
            this.f5804b.onError(null, 0, new Throwable("action error: " + str2));
            return;
        }
        String string2 = bundleUrlToBundle.getString("result");
        if ("cancel".equals(string2)) {
            finish();
            this.f5804b.onCancel(null, 0);
            return;
        }
        if (!"complete".equals(string2)) {
            this.f5809g = true;
            finish();
            this.f5804b.onError(null, 0, new Throwable("operation failed: " + str2));
            return;
        }
        String string3 = bundleUrlToBundle.getString("response");
        if (TextUtils.isEmpty(string3)) {
            this.f5809g = true;
            finish();
            this.f5804b.onError(null, 0, new Throwable("response empty" + str2));
            return;
        }
        this.f5810h = true;
        finish();
        this.f5804b.onComplete(null, 0, new Hashon().fromJson(string3));
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        if (this.f5806d != null) {
            this.f5806d.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        if (this.f5806d != null) {
            this.f5806d.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        if (this.f5806d != null) {
            this.f5806d.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        if (this.f5806d != null) {
            this.f5806d.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        if (this.f5806d != null) {
            this.f5806d.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.f5809g && !this.f5810h) {
            this.f5804b.onCancel(null, 0);
        }
        if (this.f5806d != null) {
            this.f5806d.onDestroy();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f5806d != null) {
            return this.f5806d.onFinish();
        }
        return super.onFinish();
    }
}
