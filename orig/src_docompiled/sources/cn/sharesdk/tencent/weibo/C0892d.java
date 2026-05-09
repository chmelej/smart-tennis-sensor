package cn.sharesdk.tencent.weibo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.C0826e;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.d */
/* JADX INFO: compiled from: TencentWeiboAuthorizeWebviewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0892d extends AbstractC0823b {

    /* JADX INFO: renamed from: d */
    private int f5874d;

    /* JADX INFO: renamed from: e */
    private boolean f5875e;

    public C0892d(C0826e c0826e) {
        super(c0826e);
        this.f5874d = 0;
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f5548b != null && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            m6442a(str);
            return true;
        }
        if (str.startsWith("wtloginmqq")) {
            int stringRes = ResHelper.getStringRes(this.f5547a.getContext(), "ssdk_use_login_button");
            if (stringRes > 0) {
                Toast.makeText(this.f5547a.getContext(), stringRes, 0).show();
            }
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f5548b != null && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            m6442a(str);
            return;
        }
        if (str.startsWith("wtloginmqq")) {
            int stringRes = ResHelper.getStringRes(this.f5547a.getContext(), "ssdk_use_login_button");
            if (stringRes > 0) {
                Toast.makeText(this.f5547a.getContext(), stringRes, 0).show();
                return;
            }
            return;
        }
        if (str.endsWith("omasflag=")) {
            this.f5874d++;
            if (this.f5874d == 2) {
                webView.stopLoading();
                this.f5547a.finish();
                if (this.f5549c != null) {
                    this.f5549c.onCancel();
                    return;
                }
                return;
            }
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [cn.sharesdk.tencent.weibo.d$1] */
    /* JADX INFO: renamed from: a */
    protected void m6442a(String str) {
        if (this.f5875e) {
            return;
        }
        this.f5875e = true;
        final Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle.containsKey("errorCode")) {
            if (this.f5549c != null) {
                this.f5549c.onError(new Throwable(bundleUrlToBundle.getString("errorMsg") + "(" + bundleUrlToBundle.getInt("errorCode") + ")"));
                return;
            }
            return;
        }
        new Thread() { // from class: cn.sharesdk.tencent.weibo.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Bundle bundleM6466b = C0894f.m6454a(C0892d.this.f5547a.m5982a().getPlatform()).m6466b(bundleUrlToBundle.getString("code"));
                    if (bundleM6466b == null) {
                        if (C0892d.this.f5549c != null) {
                            C0892d.this.f5549c.onError(new Throwable());
                            return;
                        }
                        return;
                    }
                    if (bundleM6466b.containsKey("errorCode")) {
                        if (C0892d.this.f5549c != null) {
                            C0892d.this.f5549c.onError(new Throwable(bundleM6466b.get("errorMsg") + "(" + bundleM6466b.get("errorCode") + ")"));
                            return;
                        }
                        return;
                    }
                    bundleUrlToBundle.putAll(bundleM6466b);
                    if (C0892d.this.f5549c != null) {
                        C0892d.this.f5549c.onComplete(bundleUrlToBundle);
                    }
                } catch (Throwable th) {
                    if (C0892d.this.f5549c != null) {
                        C0892d.this.f5549c.onError(th);
                    }
                }
            }
        }.start();
    }
}
