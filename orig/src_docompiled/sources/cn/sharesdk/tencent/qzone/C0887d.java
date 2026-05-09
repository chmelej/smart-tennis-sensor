package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
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
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.List;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qzone.d */
/* JADX INFO: compiled from: ShareActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0887d extends FakeActivity {

    /* JADX INFO: renamed from: a */
    private String f5835a;

    /* JADX INFO: renamed from: b */
    private boolean f5836b;

    /* JADX INFO: renamed from: c */
    private PlatformActionListener f5837c;

    /* JADX INFO: renamed from: d */
    private RegisterView f5838d;

    /* JADX INFO: renamed from: e */
    private WebView f5839e;

    /* JADX INFO: renamed from: f */
    private String f5840f;

    /* JADX INFO: renamed from: g */
    private boolean f5841g;

    /* JADX INFO: renamed from: h */
    private boolean f5842h;

    /* JADX INFO: renamed from: i */
    private QZoneWebShareAdapter f5843i;

    /* JADX INFO: renamed from: a */
    public void m6400a(String str, boolean z) {
        this.f5835a = str;
        this.f5836b = z;
    }

    /* JADX INFO: renamed from: a */
    public void m6398a(PlatformActionListener platformActionListener) {
        this.f5837c = platformActionListener;
    }

    /* JADX INFO: renamed from: a */
    public void m6399a(String str) {
        this.f5840f = "tencent" + str;
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.f5843i == null) {
            this.f5843i = m6390b();
            if (this.f5843i == null) {
                this.f5843i = new QZoneWebShareAdapter();
            }
        }
        this.f5843i.setActivity(activity);
    }

    /* JADX INFO: renamed from: b */
    private QZoneWebShareAdapter m6390b() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("QZoneWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object objNewInstance = Class.forName(string).newInstance();
                if (objNewInstance instanceof QZoneWebShareAdapter) {
                    return (QZoneWebShareAdapter) objNewInstance;
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
        Intent intent = this.activity.getIntent();
        String scheme = intent.getScheme();
        if (scheme != null && scheme.startsWith(this.f5840f)) {
            finish();
            Bundle bundleUrlToBundle = ResHelper.urlToBundle(intent.getDataString());
            String strValueOf = String.valueOf(bundleUrlToBundle.get("result"));
            String strValueOf2 = String.valueOf(bundleUrlToBundle.get("action"));
            if ("shareToQQ".equals(strValueOf2) || "shareToQzone".equals(strValueOf2)) {
                if ("complete".equals(strValueOf)) {
                    if (this.f5837c != null) {
                        this.f5837c.onComplete(null, 9, new Hashon().fromJson(String.valueOf(bundleUrlToBundle.get("response"))));
                    }
                } else if ("error".equals(strValueOf)) {
                    if (this.f5837c != null) {
                        this.f5837c.onError(null, 9, new Throwable(String.valueOf(bundleUrlToBundle.get("response"))));
                    }
                } else if (this.f5837c != null) {
                    this.f5837c.onCancel(null, 9);
                }
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setClass(this.activity, MobUIShell.class);
            intent2.setFlags(335544320);
            startActivity(intent2);
            return;
        }
        if (this.f5836b) {
            m6394c();
        } else {
            m6396d();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m6394c() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5835a));
            intent.putExtra("pkg_name", this.activity.getPackageName());
            if (Build.VERSION.SDK_INT >= 11) {
                intent.setFlags(268468224);
            }
            this.activity.startActivity(intent);
            FakeActivity.registerExecutor(this.f5840f, this);
            finish();
        } catch (Throwable th) {
            if (this.f5837c != null) {
                this.f5837c.onError(null, 0, th);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m6396d() {
        this.f5838d = m6397a();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_qzone");
            if (stringRes > 0) {
                this.f5838d.m5979c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            this.f5838d.m5979c().setVisibility(8);
        }
        this.f5843i.setBodyView(this.f5838d.m5980d());
        this.f5843i.setWebView(this.f5838d.m5978b());
        this.f5843i.setTitleView(this.f5838d.m5979c());
        this.f5843i.onCreate();
        this.activity.setContentView(this.f5838d);
        if ("none".equals(DeviceHelper.getInstance(this.activity).getDetailNetworkTypeForStatic())) {
            this.f5842h = true;
            finish();
            this.f5837c.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
            return;
        }
        this.f5838d.m5978b().loadUrl(this.f5835a);
    }

    /* JADX INFO: renamed from: a */
    protected RegisterView m6397a() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.m5979c().getChildAt(registerView.m5979c().getChildCount() - 1).setVisibility(8);
        registerView.m5976a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.tencent.qzone.d.1
            /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.tencent.qzone.d$1$1] */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.tencent.qzone.d.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8610d(th);
                            C0887d.this.finish();
                            C0887d.this.f5837c.onCancel(null, 0);
                        }
                    }
                }.start();
            }
        });
        this.f5839e = registerView.m5978b();
        WebSettings settings = this.f5839e.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        settings.setSavePassword(false);
        this.f5839e.setVerticalScrollBarEnabled(false);
        this.f5839e.setHorizontalScrollBarEnabled(false);
        this.f5839e.setWebViewClient(new C0845d() { // from class: cn.sharesdk.tencent.qzone.d.2
            @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null && str.startsWith(C0887d.this.f5840f)) {
                    C0887d.this.m6393b(str);
                } else if (str != null && str.startsWith("mqzone://")) {
                    C0887d.this.m6395c(str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        return registerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m6393b(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle == null) {
            this.f5842h = true;
            finish();
            this.f5837c.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = bundleUrlToBundle.getString("action");
        if (!"share".equals(string) && !"shareToQzone".equals(string)) {
            this.f5842h = true;
            finish();
            this.f5837c.onError(null, 0, new Throwable("action error: " + str2));
            return;
        }
        String string2 = bundleUrlToBundle.getString("result");
        if ("cancel".equals(string2)) {
            finish();
            this.f5837c.onCancel(null, 0);
            return;
        }
        if (!"complete".equals(string2)) {
            this.f5842h = true;
            finish();
            this.f5837c.onError(null, 0, new Throwable("operation failed: " + str2));
            return;
        }
        String string3 = bundleUrlToBundle.getString("response");
        if (TextUtils.isEmpty(string3)) {
            this.f5842h = true;
            finish();
            this.f5837c.onError(null, 0, new Throwable("response empty" + str2));
            return;
        }
        this.f5841g = true;
        finish();
        this.f5837c.onComplete(null, 0, new Hashon().fromJson(string3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m6395c(String str) {
        List<ResolveInfo> listQueryIntentActivities;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            listQueryIntentActivities = this.activity.getPackageManager().queryIntentActivities(intent, 1);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
            return;
        }
        startActivity(intent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        if (this.f5843i != null) {
            this.f5843i.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        if (this.f5843i != null) {
            this.f5843i.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        if (this.f5843i != null) {
            this.f5843i.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        if (this.f5843i != null) {
            this.f5843i.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        if (this.f5843i != null) {
            this.f5843i.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.f5836b && !this.f5842h && !this.f5841g) {
            this.f5837c.onCancel(null, 0);
        }
        if (this.f5843i != null) {
            this.f5843i.onDestroy();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.f5843i != null) {
            return this.f5843i.onFinish();
        }
        return super.onFinish();
    }
}
