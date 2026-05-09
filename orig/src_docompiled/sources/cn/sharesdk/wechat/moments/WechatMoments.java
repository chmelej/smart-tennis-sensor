package cn.sharesdk.wechat.moments;

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
public class WechatMoments extends Platform {
    public static final String NAME = "WechatMoments";

    /* JADX INFO: renamed from: a */
    private String f5905a;

    /* JADX INFO: renamed from: b */
    private String f5906b;

    /* JADX INFO: renamed from: c */
    private boolean f5907c;

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
        return 23;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    public WechatMoments(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5905a = getDevinfo("AppId");
        this.f5906b = getDevinfo("AppSecret");
        this.f5907c = "true".equals(getDevinfo("BypassApproval"));
        if (this.f5905a == null || this.f5905a.length() <= 0) {
            this.f5905a = getDevinfo("Wechat", "AppId");
            this.f5907c = "true".equals(getDevinfo("Wechat", "BypassApproval"));
            if (this.f5905a != null && this.f5905a.length() > 0) {
                copyDevinfo("Wechat", NAME);
                this.f5905a = getDevinfo("AppId");
                this.f5907c = "true".equals(getDevinfo("BypassApproval"));
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f5905a = getDevinfo("WechatFavorite", "AppId");
            if (this.f5905a == null || this.f5905a.length() <= 0) {
                return;
            }
            copyDevinfo("WechatFavorite", NAME);
            this.f5905a = getDevinfo("AppId");
            C0851d.m6195a().m8609d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5905a = getNetworkDevinfo("app_id", "AppId");
        this.f5906b = getNetworkDevinfo("app_secret", "AppSecret");
        if (this.f5905a == null || this.f5905a.length() <= 0) {
            this.f5905a = getNetworkDevinfo(22, "app_id", "AppId");
            if (this.f5905a != null && this.f5905a.length() > 0) {
                copyNetworkDevinfo(22, 23);
                this.f5905a = getNetworkDevinfo("app_id", "AppId");
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
            } else {
                this.f5905a = getNetworkDevinfo(37, "app_id", "AppId");
                if (this.f5905a != null && this.f5905a.length() > 0) {
                    copyNetworkDevinfo(23, 23);
                    this.f5905a = getNetworkDevinfo("app_id", "AppId");
                    C0851d.m6195a().m8609d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            }
        }
        if (this.f5906b == null || this.f5906b.length() <= 0) {
            this.f5906b = getNetworkDevinfo(22, "app_secret", "AppSecret");
            if (this.f5906b != null && this.f5906b.length() > 0) {
                copyNetworkDevinfo(22, 23);
                this.f5906b = getNetworkDevinfo("app_secret", "AppSecret");
                C0851d.m6195a().m8609d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            this.f5906b = getNetworkDevinfo(37, "app_secret", "AppSecret");
            if (this.f5906b == null || this.f5906b.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(23, 23);
            this.f5906b = getNetworkDevinfo("app_secret", "AppSecret");
            C0851d.m6195a().m8609d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (TextUtils.isEmpty(this.f5905a) || TextUtils.isEmpty(this.f5906b)) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5905a);
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
        C0909g c0909g = new C0909g(this, 23);
        c0909g.m6561a(this.f5905a, this.f5906b);
        C0911i c0911i = new C0911i(this);
        c0911i.m6577a(c0909g);
        c0911i.m6575a(new AuthorizeListener() { // from class: cn.sharesdk.wechat.moments.WechatMoments.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (WechatMoments.this.listener != null) {
                    WechatMoments.this.listener.onError(WechatMoments.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                WechatMoments.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (WechatMoments.this.listener != null) {
                    WechatMoments.this.listener.onCancel(WechatMoments.this, 1);
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
    private boolean m6511c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C0909g c0909g = new C0909g(this, 23);
        c0909g.m6561a(this.f5905a, this.f5906b);
        return c0909g.m6562a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5905a);
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
        if (i == 9 || isAuthValid() || m6511c()) {
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    @Deprecated
    public boolean isValid() {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5905a);
        return wechatHelperM6516a.m6543c() && wechatHelperM6516a.m6544d() && super.isValid();
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5905a);
        return wechatHelperM6516a.m6543c() && wechatHelperM6516a.m6544d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        shareParams.set("scene", 1);
        WechatHelper wechatHelperM6516a = WechatHelper.m6516a();
        wechatHelperM6516a.m6539a(this.context, this.f5905a);
        C0911i c0911i = new C0911i(this);
        if (this.f5907c) {
            try {
                wechatHelperM6516a.m6538a(c0911i, shareParams, this.listener);
                return;
            } catch (Throwable th) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, th);
                    return;
                }
                return;
            }
        }
        c0911i.m6574a(shareParams, this.listener);
        try {
            wechatHelperM6516a.m6541b(c0911i);
            if (this.listener == null || !wechatHelperM6516a.m6542b()) {
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            if (this.listener != null) {
                this.listener.onComplete(this, 9, map);
            }
        } catch (Throwable th2) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th2);
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
        if (TextUtils.isEmpty(this.f5905a) || TextUtils.isEmpty(this.f5906b)) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        C0909g c0909g = new C0909g(this, 23);
        c0909g.m6561a(this.f5905a, this.f5906b);
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
            this.scene = 1;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return !this.f5907c;
    }
}
