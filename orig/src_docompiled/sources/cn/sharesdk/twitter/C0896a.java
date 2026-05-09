package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: renamed from: cn.sharesdk.twitter.a */
/* JADX INFO: compiled from: TwitterAuthorizeWebviewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0896a extends AbstractC0823b {

    /* JADX INFO: renamed from: d */
    private boolean f5890d;

    public C0896a(C0826e c0826e) {
        super(c0826e);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [cn.sharesdk.twitter.a$1] */
    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f5548b != null && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            final String strValueOf = String.valueOf(ResHelper.urlToBundle(str).get("oauth_verifier"));
            new Thread() { // from class: cn.sharesdk.twitter.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        C0896a.this.m6481a(strValueOf);
                    } catch (Throwable th) {
                        C0851d.m6195a().m8610d(th);
                    }
                }
            }.start();
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.twitter.a$2] */
    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f5548b != null && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            final String strValueOf = String.valueOf(ResHelper.urlToBundle(str).get("oauth_verifier"));
            new Thread() { // from class: cn.sharesdk.twitter.a.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        C0896a.this.m6481a(strValueOf);
                    } catch (Throwable th) {
                        C0851d.m6195a().m8610d(th);
                    }
                }
            }.start();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX INFO: renamed from: a */
    public void m6481a(String str) {
        if (this.f5890d) {
            return;
        }
        this.f5890d = true;
        String strM6483a = C0897b.m6482a(this.f5547a.m5982a().getPlatform()).m6483a(str);
        if (strM6483a == null || strM6483a.length() <= 0) {
            if (this.f5549c != null) {
                this.f5549c.onError(new Throwable());
                return;
            }
            return;
        }
        String[] strArrSplit = strM6483a.split("&");
        Bundle bundle = new Bundle();
        for (String str2 : strArrSplit) {
            if (str2 != null) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2.length >= 2) {
                    bundle.putString(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
        if (bundle == null || bundle.size() <= 0) {
            if (this.f5549c != null) {
                this.f5549c.onError(new Throwable());
            }
        } else if (this.f5549c != null) {
            this.f5549c.onComplete(bundle);
        }
    }
}
