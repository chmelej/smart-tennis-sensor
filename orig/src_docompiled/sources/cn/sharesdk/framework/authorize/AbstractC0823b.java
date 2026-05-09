package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.C0845d;

/* JADX INFO: renamed from: cn.sharesdk.framework.authorize.b */
/* JADX INFO: compiled from: AuthorizeWebviewClient.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0823b extends C0845d {

    /* JADX INFO: renamed from: a */
    protected C0826e f5547a;

    /* JADX INFO: renamed from: b */
    protected String f5548b;

    /* JADX INFO: renamed from: c */
    protected AuthorizeListener f5549c;

    public AbstractC0823b(C0826e c0826e) {
        this.f5547a = c0826e;
        AuthorizeHelper authorizeHelperA = c0826e.m5982a();
        this.f5548b = authorizeHelperA.getRedirectUri();
        this.f5549c = authorizeHelperA.getAuthorizeListener();
    }

    @Override // cn.sharesdk.framework.C0845d, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.stopLoading();
        AuthorizeListener authorizeListener = this.f5547a.m5982a().getAuthorizeListener();
        this.f5547a.finish();
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable(str + " (" + i + "): " + str2));
        }
    }
}
