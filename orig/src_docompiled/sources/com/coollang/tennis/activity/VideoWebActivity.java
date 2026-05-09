package com.coollang.tennis.activity;

import android.graphics.Color;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import com.umeng.message.PushAgent;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.Cookie;
import p000.C1874ld;

/* JADX INFO: loaded from: classes.dex */
public class VideoWebActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f7241a;

    /* JADX INFO: renamed from: b */
    private WebView f7242b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_video_web);
        m7655c();
        PushAgent.getInstance(this).onAppStart();
        this.f7241a.setBackgroundColor(Color.parseColor("#99000000"));
        String stringExtra = getIntent().getStringExtra("title");
        String stringExtra2 = getIntent().getStringExtra("imgUrl");
        this.f7241a.setTitle(stringExtra);
        this.f7242b.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.VideoWebActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoWebActivity.this.f7241a.getVisibility() == 0) {
                    VideoWebActivity.this.f7241a.setVisibility(8);
                } else {
                    VideoWebActivity.this.f7241a.setVisibility(0);
                }
            }
        });
        this.f7242b.getSettings().setCacheMode(1);
        this.f7242b.getSettings().setBuiltInZoomControls(true);
        this.f7242b.getSettings().setAllowFileAccess(true);
        this.f7242b.getSettings().setJavaScriptEnabled(true);
        this.f7242b.getSettings().setCacheMode(2);
        this.f7242b.getSettings().setAllowFileAccess(true);
        this.f7242b.getSettings().setAppCacheEnabled(true);
        this.f7242b.getSettings().setDomStorageEnabled(true);
        this.f7242b.getSettings().setDatabaseEnabled(true);
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();
        cookieManager.removeAllCookie();
        List<Cookie> cookies = C1874ld.f11074ao.getCookies();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cookies.size(); i++) {
            Cookie cookie = cookies.get(i);
            arrayList.add(cookie.getName() + "=" + cookie.getValue() + ";");
            cookieManager.setCookie(stringExtra2, (String) arrayList.get(i));
        }
        CookieSyncManager.getInstance().sync();
        this.f7242b.loadUrl(stringExtra2);
        this.f7242b.setWebViewClient(new WebViewClient() { // from class: com.coollang.tennis.activity.VideoWebActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m7655c() {
        this.f7241a = (NavigateView) findViewById(R.id.navigateView);
        this.f7242b = (WebView) findViewById(R.id.activity_video_web);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f7242b != null) {
            this.f7242b.setVisibility(8);
            this.f7242b.destroy();
        }
        super.onDestroy();
    }
}
