package cn.sharesdk.tencent.p007qq;

import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.utils.C0851d;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.a */
/* JADX INFO: compiled from: QQAuthorizeWebviewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class C0875a extends AbstractC0823b {
    public C0875a(C0826e c0826e) {
        super(c0826e);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [cn.sharesdk.tencent.qq.a$1] */
    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        if (str.startsWith(this.f5548b)) {
            webView.setVisibility(4);
            webView.stopLoading();
            this.f5547a.finish();
            new Thread() { // from class: cn.sharesdk.tencent.qq.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        C0875a.this.m6310a(str);
                    } catch (Throwable th) {
                        C0851d.m6195a().m8610d(th);
                    }
                }
            }.start();
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    /* JADX INFO: renamed from: a */
    protected void m6310a(String str) {
        if (str.startsWith(this.f5548b)) {
            str = str.substring(str.indexOf(35) + 1);
        }
        String[] strArrSplit = str.split("&");
        HashMap<String, String> map = new HashMap<>();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            if (strArrSplit2.length < 2) {
                map.put(URLDecoder.decode(strArrSplit2[0]), "");
            } else {
                map.put(URLDecoder.decode(strArrSplit2[0]), URLDecoder.decode(strArrSplit2[1] == null ? "" : strArrSplit2[1]));
            }
        }
        m6309a(map);
    }

    /* JADX INFO: renamed from: a */
    private void m6309a(HashMap<String, String> map) {
        String str = map.get("access_token");
        String str2 = map.get("expires_in");
        String str3 = map.get("error");
        String str4 = map.get("error_description");
        String str5 = map.get("pf");
        String str6 = map.get("pfkey");
        String str7 = map.get("pay_token");
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap<String, Object> mapM6322c = C0876b.m6311a(this.f5547a.m5982a().getPlatform()).m6322c(str);
                if (mapM6322c != null && mapM6322c.size() > 0) {
                    if (!mapM6322c.containsKey("openid")) {
                        if (this.f5549c != null) {
                            this.f5549c.onError(new Throwable());
                            return;
                        }
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", str);
                    bundle.putString("open_id", String.valueOf(mapM6322c.get("openid")));
                    bundle.putString("expires_in", str2);
                    bundle.putString("pf", str5);
                    bundle.putString("pfkey", str6);
                    bundle.putString("pay_token", str7);
                    if (this.f5549c != null) {
                        this.f5549c.onComplete(bundle);
                        return;
                    }
                    return;
                }
                if (this.f5549c != null) {
                    this.f5549c.onError(new Throwable());
                    return;
                }
                return;
            } catch (Throwable th) {
                if (this.f5549c != null) {
                    this.f5549c.onError(th);
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            String str8 = str4 + " (" + str3 + ")";
            if (this.f5549c != null) {
                this.f5549c.onError(new Throwable(str8));
                return;
            }
            return;
        }
        this.f5549c.onError(new Throwable());
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            Method method = sslErrorHandler.getClass().getMethod("proceed", new Class[0]);
            method.setAccessible(true);
            method.invoke(sslErrorHandler, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
