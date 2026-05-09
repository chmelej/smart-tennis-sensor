package com.coollang.tennis.activity;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class WebviewActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private WebView f7377a;

    /* JADX INFO: renamed from: b */
    private final String f7378b = "WebviewActivity";

    /* JADX INFO: renamed from: c */
    private ImageView f7379c;

    /* JADX INFO: renamed from: d */
    private RelativeLayout f7380d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_webview);
        this.f7377a = (WebView) findViewById(R.id.webview);
        this.f7379c = (ImageView) findViewById(R.id.back);
        this.f7380d = (RelativeLayout) findViewById(R.id.layout_back);
        String string = getIntent().getExtras().getString("url");
        Log.e("WebviewActivity", "url: " + string);
        this.f7377a.loadUrl(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7379c.setOnClickListener(this);
        this.f7380d.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.layout_back) {
            return;
        }
        finish();
    }
}
