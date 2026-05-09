package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.sina.weibo.b */
/* JADX INFO: compiled from: SinaWeiboAuthorizeWebviewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0868b extends AbstractC0823b {

    /* JADX INFO: renamed from: d */
    private boolean f5733d;

    public C0868b(C0826e c0826e) {
        super(c0826e);
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(this.f5548b) && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            m6237a(str);
            return true;
        }
        if (str.startsWith("sms:")) {
            String strSubstring = str.substring(4);
            try {
                try {
                    Intent intentM6234b = m6234b(strSubstring);
                    intentM6234b.setPackage("com.android.mms");
                    webView.getContext().startActivity(intentM6234b);
                } catch (Throwable unused) {
                    webView.getContext().startActivity(m6234b(strSubstring));
                }
            } catch (Throwable th) {
                if (this.f5549c != null) {
                    this.f5549c.onError(th);
                }
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(this.f5548b) && str.startsWith(this.f5548b)) {
            webView.stopLoading();
            this.f5547a.finish();
            m6237a(str);
            return;
        }
        if (str.startsWith("sms:")) {
            String strSubstring = str.substring(4);
            try {
                try {
                    Intent intentM6234b = m6234b(strSubstring);
                    intentM6234b.setPackage("com.android.mms");
                    webView.getContext().startActivity(intentM6234b);
                    return;
                } catch (Throwable unused) {
                    webView.getContext().startActivity(m6234b(strSubstring));
                    return;
                }
            } catch (Throwable th) {
                if (this.f5549c != null) {
                    this.f5549c.onError(th);
                    return;
                }
                return;
            }
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX INFO: renamed from: a */
    protected void m6237a(String str) {
        if (this.f5733d) {
            return;
        }
        this.f5733d = true;
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        String string = bundleUrlToBundle.getString("error");
        String string2 = bundleUrlToBundle.getString("error_code");
        if (this.f5549c != null) {
            if (string == null && string2 == null) {
                String string3 = bundleUrlToBundle.getString("code");
                if (TextUtils.isEmpty(string3)) {
                    this.f5549c.onError(new Throwable("Authorize code is empty"));
                }
                m6233a(this.f5547a.m5982a().getPlatform(), string3);
                return;
            }
            if (string.equals("access_denied")) {
                this.f5549c.onCancel();
                return;
            }
            int i = 0;
            try {
                i = ResHelper.parseInt(string2);
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
            }
            this.f5549c.onError(new Throwable(string + " (" + i + ")"));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.sina.weibo.b$1] */
    /* JADX INFO: renamed from: a */
    private void m6233a(final Platform platform, final String str) {
        new Thread() { // from class: cn.sharesdk.sina.weibo.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String strM6252a;
                try {
                    try {
                        strM6252a = C0870d.m6244a(platform).m6252a(platform.getContext(), str);
                    } catch (Throwable th) {
                        C0868b.this.f5549c.onError(th);
                        strM6252a = null;
                    }
                    if (strM6252a == null) {
                        C0868b.this.f5549c.onError(new Throwable("Authorize token is empty"));
                        return;
                    }
                    HashMap mapFromJson = new Hashon().fromJson(strM6252a);
                    Bundle bundle = new Bundle();
                    bundle.putString("uid", String.valueOf(mapFromJson.get("uid")));
                    bundle.putString("remind_in", String.valueOf(mapFromJson.get("remind_in")));
                    bundle.putString("expires_in", String.valueOf(mapFromJson.get("expires_in")));
                    bundle.putString("access_token", String.valueOf(mapFromJson.get("access_token")));
                    C0868b.this.f5549c.onComplete(bundle);
                } catch (Throwable th2) {
                    C0851d.m6195a().m8610d(th2);
                }
            }
        }.start();
    }

    /* JADX INFO: renamed from: b */
    private Intent m6234b(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", "");
        intent.setFlags(268435456);
        return intent;
    }
}
