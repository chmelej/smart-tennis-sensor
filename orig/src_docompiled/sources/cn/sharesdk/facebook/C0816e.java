package cn.sharesdk.facebook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.C0845d;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.facebook.e */
/* JADX INFO: compiled from: WebShareActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0816e extends FakeActivity {

    /* JADX INFO: renamed from: a */
    private String f5502a;

    /* JADX INFO: renamed from: b */
    private PlatformActionListener f5503b;

    /* JADX INFO: renamed from: c */
    private C0812a f5504c;

    /* JADX INFO: renamed from: d */
    private RegisterView f5505d;

    /* JADX INFO: renamed from: e */
    private WebView f5506e;

    /* JADX INFO: renamed from: f */
    private boolean f5507f;

    /* JADX INFO: renamed from: g */
    private boolean f5508g;

    /* JADX INFO: renamed from: a */
    public void m5931a(String str) {
        this.f5502a = str;
    }

    /* JADX INFO: renamed from: a */
    public void m5930a(PlatformActionListener platformActionListener) {
        this.f5503b = platformActionListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f5504c == null) {
            this.f5504c = m5927b();
            if (this.f5504c == null) {
                this.f5504c = new C0812a();
            }
        }
        this.f5504c.m5890a(activity);
    }

    /* JADX INFO: renamed from: b */
    private C0812a m5927b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("FBWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object objNewInstance = Class.forName(string).newInstance();
                if (objNewInstance instanceof C0812a) {
                    return (C0812a) objNewInstance;
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
        this.f5505d = m5929a();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_facebook");
            if (stringRes > 0) {
                this.f5505d.m5979c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            this.f5505d.m5979c().setVisibility(8);
        }
        this.f5504c.m5892a(this.f5505d.m5980d());
        this.f5504c.m5891a(this.f5505d.m5978b());
        this.f5504c.m5893a(this.f5505d.m5979c());
        this.f5504c.m5889a();
        this.activity.setContentView(this.f5505d);
        if ("none".equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f5507f = true;
            finish();
            this.f5503b.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f5505d.m5978b().loadUrl(this.f5502a);
    }

    /* JADX INFO: renamed from: a */
    protected RegisterView m5929a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m5979c().getChildAt(registerView.m5979c().getChildCount() - 1).setVisibility(8);
        registerView.m5976a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.facebook.e.1
            /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.facebook.e$1$1] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.facebook.e.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8610d(th);
                            C0816e.this.finish();
                            C0816e.this.f5503b.onCancel(null, 0);
                        }
                    }
                }.start();
            }
        });
        this.f5506e = registerView.m5978b();
        WebSettings settings = this.f5506e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.f5506e.setVerticalScrollBarEnabled(false);
        this.f5506e.setHorizontalScrollBarEnabled(false);
        this.f5506e.setWebViewClient(new C0845d() { // from class: cn.sharesdk.facebook.e.2
            @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null && str.startsWith("fbconnect://success")) {
                    C0816e.this.m5928b(str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        return registerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m5928b(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle == null) {
            this.f5507f = true;
            finish();
            this.f5503b.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = bundleUrlToBundle.getString("post_id");
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(string)) {
            map.put("post_id", string);
        }
        if (bundleUrlToBundle.containsKey("error_code") || bundleUrlToBundle.containsKey("error")) {
            if (this.f5503b != null) {
                this.f5503b.onError(null, 9, new Throwable(ResHelper.encodeUrl(bundleUrlToBundle)));
            }
            this.f5507f = true;
            finish();
            return;
        }
        this.f5508g = true;
        finish();
        this.f5503b.onComplete(null, 0, map);
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        if (this.f5504c != null) {
            this.f5504c.m5895c();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        if (this.f5504c != null) {
            this.f5504c.m5896d();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        if (this.f5504c != null) {
            this.f5504c.m5897e();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        if (this.f5504c != null) {
            this.f5504c.m5898f();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        if (this.f5504c != null) {
            this.f5504c.m5899g();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.f5507f && !this.f5508g) {
            this.f5503b.onCancel(null, 0);
        }
        if (this.f5504c != null) {
            this.f5504c.m5894b();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f5504c != null) {
            return this.f5504c.m5900h();
        }
        return super.onFinish();
    }
}
