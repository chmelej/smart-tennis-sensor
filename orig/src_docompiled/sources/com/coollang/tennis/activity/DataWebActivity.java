package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.umeng.message.PushAgent;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class DataWebActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    View.OnClickListener f6289a = new View.OnClickListener() { // from class: com.coollang.tennis.activity.DataWebActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    /* JADX INFO: renamed from: b */
    private ImageButton f6290b;

    /* JADX INFO: renamed from: c */
    private TextView f6291c;

    /* JADX INFO: renamed from: d */
    private WebView f6292d;

    /* JADX INFO: renamed from: e */
    private ProgressBar f6293e;

    /* JADX INFO: renamed from: f */
    private String f6294f;

    /* JADX INFO: renamed from: g */
    private String f6295g;

    /* JADX INFO: renamed from: h */
    private String f6296h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_web);
        PushAgent.getInstance(this).onAppStart();
        m6897d();
        m6896c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        if (this.f6296h != null && !"".equalsIgnoreCase(this.f6296h)) {
            this.f6291c.setText(this.f6296h);
        }
        m6898e();
        m6899f();
    }

    /* JADX INFO: renamed from: c */
    private void m6896c() {
        this.f6293e = (ProgressBar) findViewById(R.id.pro_web);
        this.f6292d = (WebView) findViewById(R.id.web);
        this.f6291c = (TextView) findViewById(R.id.tv_head);
        this.f6290b = (ImageButton) findViewById(R.id.ib_backarrow);
    }

    /* JADX INFO: renamed from: d */
    private void m6897d() {
        Intent intent = getIntent();
        this.f6295g = intent.getStringExtra("url");
        this.f6296h = intent.getStringExtra("title");
    }

    /* JADX INFO: renamed from: e */
    private void m6898e() {
        WebSettings settings = this.f6292d.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        this.f6292d.setWebViewClient(new C1000b());
        this.f6292d.addJavascriptInterface(new C0999a(this), "JavaScriptInterface");
        this.f6292d.getSettings().setCacheMode(1);
        this.f6292d.getSettings().setBuiltInZoomControls(true);
        this.f6292d.getSettings().setAllowFileAccess(true);
        this.f6292d.getSettings().setJavaScriptEnabled(true);
        this.f6292d.getSettings().setCacheMode(2);
        this.f6292d.getSettings().setAllowFileAccess(true);
        this.f6292d.getSettings().setAppCacheEnabled(true);
        this.f6292d.getSettings().setDomStorageEnabled(true);
        this.f6292d.getSettings().setDatabaseEnabled(true);
        this.f6292d.loadUrl(this.f6295g);
        this.f6292d.setWebChromeClient(new WebChromeClient() { // from class: com.coollang.tennis.activity.DataWebActivity.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                DataWebActivity.this.f6293e.setProgress(i);
                if (i == 100) {
                    DataWebActivity.this.f6293e.setVisibility(8);
                } else {
                    DataWebActivity.this.f6293e.setVisibility(0);
                }
                C1900mc.m10473a("===============farley", "newProgress=" + i);
            }
        });
    }

    /* JADX INFO: renamed from: f */
    private void m6899f() {
        this.f6290b.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DataWebActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DataWebActivity.this.m7733j();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m6895a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) DataWebActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        CookieSyncManager.getInstance().startSync();
        super.onResume();
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        CookieSyncManager.getInstance().stopSync();
        super.onPause();
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.DataWebActivity$b */
    class C1000b extends WebViewClient {
        C1000b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.DataWebActivity$a */
    class C0999a {

        /* JADX INFO: renamed from: b */
        private Context f6301b;

        @JavascriptInterface
        public void jumpClientAddress() {
        }

        @JavascriptInterface
        public void jumpClientOrder() {
        }

        @JavascriptInterface
        public void jumpInvite(String str, String str2, String str3) {
        }

        public C0999a(Context context) {
            this.f6301b = context;
        }

        @JavascriptInterface
        public void jumpClientGetScore() {
            DataWebActivity.this.m7733j();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.f6294f = this.f6294f.substring(0, this.f6294f.lastIndexOf("-"));
    }
}
