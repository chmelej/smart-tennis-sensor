package cn.sharesdk.wechat.favorite;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.C0909g;
import cn.sharesdk.wechat.utils.C0911i;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatHelper;
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class WechatFavorite extends Platform {
    public static final String NAME = "WechatFavorite";

    /* JADX INFO: renamed from: a */
    private String f5898a;

    /* JADX INFO: renamed from: b */
    private String f5899b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i, int i2, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 37;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    public WechatFavorite(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5898a = getDevinfo("AppId");
        this.f5899b = getDevinfo("AppSecret");
        if (this.f5898a == null || this.f5898a.length() <= 0) {
            this.f5898a = getDevinfo("Wechat", "AppId");
            if (this.f5898a != null && this.f5898a.length() > 0) {
                copyDevinfo("Wechat", NAME);
                this.f5898a = getDevinfo("AppId");
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f5898a = getDevinfo("WechatMoments", "AppId");
            if (this.f5898a == null || this.f5898a.length() <= 0) {
                return;
            }
            copyDevinfo("WechatMoments", NAME);
            this.f5898a = getDevinfo("AppId");
            C0851d.m6195a().m8609d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5898a = getNetworkDevinfo("app_id", "AppId");
        this.f5899b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f5898a == null || this.f5898a.length() <= 0) {
            this.f5898a = getNetworkDevinfo(22, "app_id", "AppId");
            if (this.f5898a != null && this.f5898a.length() > 0) {
                copyNetworkDevinfo(22, 37);
                this.f5898a = getNetworkDevinfo("app_id", "AppId");
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
            } else {
                this.f5898a = getNetworkDevinfo(23, "app_id", "AppId");
                if (this.f5898a != null && this.f5898a.length() > 0) {
                    copyNetworkDevinfo(23, 37);
                    this.f5898a = getNetworkDevinfo("app_id", "AppId");
                    C0851d.m6195a().m8609d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            }
        }
        if (this.f5899b == null || this.f5899b.length() <= 0) {
            this.f5899b = getNetworkDevinfo(22, "app_secret", "AppSecret");
            if (this.f5899b != null && this.f5899b.length() > 0) {
                copyNetworkDevinfo(22, 37);
                this.f5899b = getNetworkDevinfo("app_secret", "AppSecret");
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f5899b = getNetworkDevinfo(23, "app_secret", "AppSecret");
            if (this.f5899b == null || this.f5899b.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(23, 37);
            this.f5899b = getNetworkDevinfo("app_secret", "AppSecret");
            C0851d.m6195a().m8609d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (TextUtils.isEmpty(this.f5898a) || TextUtils.isEmpty(this.f5899b)) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5898a);
        if (!wechatHelperM6516a.m6543c()) {
            if (this.listener != null) {
                this.listener.onError(this, 1, new WechatClientNotExistException());
                return;
            }
            return;
        }
        if (!wechatHelperM6516a.m6544d()) {
            if (this.listener != null) {
                this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
                return;
            }
            return;
        }
        C0909g c0909g = new C0909g(this, 37);
        c0909g.m6561a(this.f5898a, this.f5899b);
        C0911i c0911i = new C0911i(this);
        c0911i.m6577a(c0909g);
        c0911i.m6575a(new AuthorizeListener() { // from class: cn.sharesdk.wechat.favorite.WechatFavorite.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (WechatFavorite.this.listener != null) {
                    WechatFavorite.this.listener.onError(WechatFavorite.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                WechatFavorite.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (WechatFavorite.this.listener != null) {
                    WechatFavorite.this.listener.onCancel(WechatFavorite.this, 1);
                }
            }
        });
        try {
            wechatHelperM6516a.m6537a(c0911i);
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 1, th);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m6499c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C0909g c0909g = new C0909g(this, 37);
        c0909g.m6561a(this.f5898a, this.f5899b);
        return c0909g.m6562a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5898a);
        if (!wechatHelperM6516a.m6543c()) {
            if (this.listener != null) {
                this.listener.onError(this, i, new WechatClientNotExistException());
            }
            return false;
        }
        if (!wechatHelperM6516a.m6544d()) {
            if (this.listener != null) {
                this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
            }
            return false;
        }
        if (i == 9 || isAuthValid() || m6499c()) {
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    @Deprecated
    public boolean isValid() {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5898a);
        return wechatHelperM6516a.m6543c() && super.isValid();
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5898a);
        return wechatHelperM6516a.m6543c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        shareParams.set("scene", 2);
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5898a);
        C0911i c0911i = new C0911i(this);
        c0911i.m6574a(shareParams, this.listener);
        try {
            wechatHelperM6516a.m6541b(c0911i);
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        if (TextUtils.isEmpty(this.f5898a) || TextUtils.isEmpty(this.f5899b)) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        C0909g c0909g = new C0909g(this, 37);
        c0909g.m6561a(this.f5898a, this.f5899b);
        try {
            c0909g.m6559a(this.listener);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            if (this.listener != null) {
                this.listener.onError(this, 8, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2) {
        if (this.listener != null) {
            this.listener.onCancel(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        String text = shareParams.getText();
        aVar.f5621b = text;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        Bitmap imageData = shareParams.getImageData();
        if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f5623d.add(imageUrl);
        } else if (imagePath != null) {
            aVar.f5624e.add(imagePath);
        } else if (imageData != null) {
            aVar.f5625f.add(imageData);
        }
        String url = shareParams.getUrl();
        if (url != null) {
            aVar.f5622c.add(url);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", shareParams.getTitle());
        map2.put("url", url);
        map2.put("extInfo", null);
        map2.put("content", text);
        map2.put("image", aVar.f5623d);
        map2.put("musicFileUrl", url);
        aVar.f5626g = map2;
        return aVar;
    }

    public static class ShareParams extends WechatHelper.ShareParams {
        public ShareParams() {
            this.scene = 2;
        }
    }
}
