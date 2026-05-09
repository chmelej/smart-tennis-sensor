package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

/* JADX INFO: loaded from: classes.dex */
public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    AbstractC0825d getSSOProcessor(C0824c c0824c);
}
