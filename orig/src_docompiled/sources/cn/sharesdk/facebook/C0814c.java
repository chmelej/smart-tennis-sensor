package cn.sharesdk.facebook;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: renamed from: cn.sharesdk.facebook.c */
/* JADX INFO: compiled from: FacebookWebViewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0814c extends AbstractC0823b {
    public C0814c(C0826e c0826e) {
        super(c0826e);
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f5548b)) {
            webView.stopLoading();
            webView.postDelayed(new Runnable() { // from class: cn.sharesdk.facebook.c.1
                @Override // java.lang.Runnable
                public void run() {
                    C0814c.this.f5547a.finish();
                }
            }, 500L);
            m5909a(str);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: renamed from: a */
    protected void m5909a(String str) {
        int i;
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        String string = bundleUrlToBundle.getString("error_message");
        if (string != null && this.f5549c != null) {
            string = "error_message ==>>" + string + "\nerror_code ==>>" + bundleUrlToBundle.getString("error_code");
            this.f5549c.onError(new Throwable(str));
        }
        if (string == null) {
            String string2 = bundleUrlToBundle.getString("access_token");
            String string3 = bundleUrlToBundle.containsKey("expires_in") ? bundleUrlToBundle.getString("expires_in") : "-1";
            if (this.f5549c != null) {
                Bundle bundle = new Bundle();
                bundle.putString("oauth_token", string2);
                bundle.putString("oauth_token_secret", "");
                try {
                    i = ResHelper.parseInt(string3);
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                    i = -1;
                }
                bundle.putInt("oauth_token_expires", i);
                this.f5549c.onComplete(bundle);
            }
        }
    }
}
