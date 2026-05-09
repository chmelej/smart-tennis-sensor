package cn.sharesdk.tencent.p007qq;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.QQ */
/* JADX INFO: loaded from: classes.dex */
public class C0874QQ extends Platform {
    public static final String NAME = "QQ";

    /* JADX INFO: renamed from: a */
    private String f5769a;

    /* JADX INFO: renamed from: b */
    private boolean f5770b;

    /* JADX INFO: renamed from: c */
    private boolean f5771c;

    /* JADX INFO: renamed from: cn.sharesdk.tencent.qq.QQ$ShareParams */
    public static class ShareParams extends Platform.ShareParams {

        @Deprecated
        public String imageUrl;

        @Deprecated
        public String musicUrl;

        @Deprecated
        public String title;

        @Deprecated
        public String titleUrl;
    }

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
        return 24;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    public C0874QQ(Context context) {
        super(context);
        this.f5771c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5769a = getDevinfo("AppId");
        this.f5770b = "true".equals(getDevinfo("ShareByAppClient"));
        if (this.f5769a == null || this.f5769a.length() <= 0) {
            this.f5769a = getDevinfo("QZone", "AppId");
            if (this.f5769a == null || this.f5769a.length() <= 0) {
                return;
            }
            copyDevinfo("QZone", NAME);
            this.f5769a = getDevinfo("AppId");
            this.f5770b = "true".equals(getDevinfo("ShareByAppClient"));
            C0851d.m6195a().m8609d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5769a = getNetworkDevinfo("app_id", "AppId");
        if (this.f5769a == null || this.f5769a.length() <= 0) {
            this.f5769a = getNetworkDevinfo(6, "app_id", "AppId");
            if (this.f5769a == null || this.f5769a.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(6, 24);
            this.f5769a = getNetworkDevinfo("app_id", "AppId");
            C0851d.m6195a().m8609d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        C0876b c0876bM6311a = C0876b.m6311a(this);
        c0876bM6311a.m6317a(this.f5769a);
        return c0876bM6311a.m6320a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0876b c0876bM6311a = C0876b.m6311a(this);
        c0876bM6311a.m6317a(this.f5769a);
        c0876bM6311a.m6319a(strArr);
        c0876bM6311a.m6316a(new AuthorizeListener() { // from class: cn.sharesdk.tencent.qq.QQ.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (C0874QQ.this.listener != null) {
                    C0874QQ.this.listener.onError(C0874QQ.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("open_id");
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                C0874QQ.this.f5513db.putToken(string2);
                C0874QQ.this.f5513db.putTokenSecret("");
                try {
                    C0874QQ.this.f5513db.putExpiresIn(ResHelper.parseLong(string3));
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                }
                C0874QQ.this.f5513db.putUserId(string);
                String string4 = bundle.getString("pf");
                String string5 = bundle.getString("pfkey");
                String string6 = bundle.getString("pay_token");
                C0874QQ.this.f5513db.put("pf", string4);
                C0874QQ.this.f5513db.put("pfkey", string5);
                C0874QQ.this.f5513db.put("pay_token", string6);
                c0876bM6311a.m6321b(string);
                c0876bM6311a.m6323d(string2);
                C0874QQ.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (C0874QQ.this.listener != null) {
                    C0874QQ.this.listener.onCancel(C0874QQ.this, 1);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid() || (i == 9 && obj != null && (obj instanceof Platform.ShareParams) && !((Platform.ShareParams) obj).isShareTencentWeibo())) {
            C0876b c0876bM6311a = C0876b.m6311a(this);
            c0876bM6311a.m6317a(this.f5769a);
            c0876bM6311a.m6321b(this.f5513db.getUserId());
            c0876bM6311a.m6323d(this.f5513db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(final Platform.ShareParams shareParams) {
        String title = shareParams.getTitle();
        String text = shareParams.getText();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        String musicUrl = shareParams.getMusicUrl();
        String titleUrl = shareParams.getTitleUrl();
        boolean zIsShareTencentWeibo = shareParams.isShareTencentWeibo();
        int hidden = shareParams.getHidden();
        if (TextUtils.isEmpty(title) && TextUtils.isEmpty(text) && TextUtils.isEmpty(imagePath) && TextUtils.isEmpty(imageUrl) && TextUtils.isEmpty(musicUrl)) {
            if (this.listener != null) {
                this.listener.onError(this, 9, new Throwable("qq share must have one param at least"));
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(titleUrl)) {
            titleUrl = getShortLintk(titleUrl, false);
            shareParams.setTitleUrl(titleUrl);
        }
        if (!TextUtils.isEmpty(text)) {
            text = getShortLintk(text, false);
            shareParams.setText(text);
        }
        String str = text;
        C0876b.m6311a(this).m6318a(title, titleUrl, str, imagePath, imageUrl, musicUrl, this.f5770b, new PlatformActionListener() { // from class: cn.sharesdk.tencent.qq.QQ.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i, Throwable th) {
                if (C0874QQ.this.listener != null) {
                    C0874QQ.this.listener.onError(C0874QQ.this, 9, th);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
                HashMap<String, Object> map2 = new HashMap<>();
                if (map != null) {
                    map2.putAll(map);
                }
                map2.put("ShareParams", shareParams);
                if (C0874QQ.this.listener != null) {
                    C0874QQ.this.listener.onComplete(C0874QQ.this, 9, map2);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform, int i) {
                if (C0874QQ.this.listener != null) {
                    C0874QQ.this.listener.onCancel(C0874QQ.this, 9);
                }
            }
        }, zIsShareTencentWeibo, hidden);
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
        if (str == null || str.length() < 0) {
            str = this.f5513db.getUserId();
        }
        if (str == null || str.length() < 0) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new RuntimeException("qq account is null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> mapM6324e = C0876b.m6311a(this).m6324e(str);
            if (mapM6324e != null && mapM6324e.size() > 0) {
                if (!mapM6324e.containsKey("ret")) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable());
                        return;
                    }
                    return;
                }
                if (((Integer) mapM6324e.get("ret")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6324e)));
                        return;
                    }
                    return;
                }
                if (str == this.f5513db.getUserId()) {
                    this.f5513db.put("nickname", String.valueOf(mapM6324e.get("nickname")));
                    if (mapM6324e.containsKey("figureurl_qq_1")) {
                        this.f5513db.put("icon", String.valueOf(mapM6324e.get("figureurl_qq_1")));
                    } else if (mapM6324e.containsKey("figureurl_qq_2")) {
                        this.f5513db.put("icon", String.valueOf(mapM6324e.get("figureurl_qq_2")));
                    }
                    if (mapM6324e.containsKey("figureurl_2")) {
                        this.f5513db.put("iconQzone", String.valueOf(mapM6324e.get("figureurl_2")));
                    } else if (mapM6324e.containsKey("figureurl_1")) {
                        this.f5513db.put("iconQzone", String.valueOf(mapM6324e.get("figureurl_1")));
                    } else if (mapM6324e.containsKey("figureurl")) {
                        this.f5513db.put("iconQzone", String.valueOf(mapM6324e.get("figureurl")));
                    }
                    this.f5513db.put("secretType", String.valueOf(mapM6324e.get("is_yellow_vip")));
                    if (String.valueOf(mapM6324e.get("is_yellow_vip")).equals("1")) {
                        this.f5513db.put("snsUserLevel", String.valueOf(mapM6324e.get("level")));
                    }
                    String strValueOf = String.valueOf(mapM6324e.get("gender"));
                    if (strValueOf.equals("男")) {
                        this.f5513db.put("gender", "0");
                    } else if (strValueOf.equals("女")) {
                        this.f5513db.put("gender", "1");
                    } else {
                        this.f5513db.put("gender", "2");
                    }
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 8, mapM6324e);
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable());
            }
        } catch (Throwable th) {
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
        String titleUrl = shareParams.getTitleUrl();
        aVar.f5622c.add(titleUrl);
        aVar.f5620a = this.f5769a;
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            aVar.f5621b = text;
        }
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (!TextUtils.isEmpty(imagePath)) {
            aVar.f5624e.add(imagePath);
        } else if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f5623d.add(imageUrl);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", shareParams.getTitle());
        map2.put("url", titleUrl);
        map2.put("imageLocalUrl", imagePath);
        map2.put("summary", text);
        map2.put("appName", DeviceHelper.getInstance(this.context).getAppName());
        aVar.f5626g = map2;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public String uploadImageToFileServer(String str) {
        return super.uploadImageToFileServer(str);
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return this.f5771c;
    }
}
