package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.umeng.message.ALIAS_TYPE;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class QZone extends Platform {
    public static final String NAME = "QZone";

    /* JADX INFO: renamed from: a */
    private String f5814a;

    public static class ShareParams extends Platform.ShareParams {

        @Deprecated
        public String comment;

        @Deprecated
        public String imageUrl;

        @Deprecated
        public String site;

        @Deprecated
        public String siteUrl;

        @Deprecated
        public String title;

        @Deprecated
        public String titleUrl;

        @Deprecated
        boolean webShare;
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
        return 6;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    public QZone(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5814a = getDevinfo("AppId");
        if (this.f5814a == null || this.f5814a.length() <= 0) {
            this.f5814a = getDevinfo(ALIAS_TYPE.f9145QQ, "AppId");
            if (this.f5814a == null || this.f5814a.length() <= 0) {
                return;
            }
            copyDevinfo(ALIAS_TYPE.f9145QQ, NAME);
            this.f5814a = getDevinfo("AppId");
            C0851d.m6195a().m8609d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5814a = getNetworkDevinfo("app_id", "AppId");
        if (this.f5814a == null || this.f5814a.length() <= 0) {
            this.f5814a = getNetworkDevinfo(24, "app_id", "AppId");
            if (this.f5814a == null || this.f5814a.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(24, 6);
            this.f5814a = getNetworkDevinfo("app_id", "AppId");
            C0851d.m6195a().m8609d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        C0885b c0885bM6371a = C0885b.m6371a(this);
        c0885bM6371a.m6377a(this.f5814a);
        return c0885bM6371a.m6380a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0885b c0885bM6371a = C0885b.m6371a(this);
        c0885bM6371a.m6377a(this.f5814a);
        c0885bM6371a.m6379a(strArr);
        c0885bM6371a.m6376a(new AuthorizeListener() { // from class: cn.sharesdk.tencent.qzone.QZone.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (QZone.this.listener != null) {
                    QZone.this.listener.onError(QZone.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("open_id");
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                QZone.this.f5513db.putToken(string2);
                QZone.this.f5513db.putTokenSecret("");
                try {
                    QZone.this.f5513db.putExpiresIn(ResHelper.parseLong(string3));
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                }
                QZone.this.f5513db.putUserId(string);
                String string4 = bundle.getString("pf");
                String string5 = bundle.getString("pfkey");
                String string6 = bundle.getString("pay_token");
                QZone.this.f5513db.put("pf", string4);
                QZone.this.f5513db.put("pfkey", string5);
                QZone.this.f5513db.put("pay_token", string6);
                c0885bM6371a.m6382b(string);
                c0885bM6371a.m6384c(string2);
                QZone.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (QZone.this.listener != null) {
                    QZone.this.listener.onCancel(QZone.this, 1);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid() || i == 9) {
            C0885b c0885bM6371a = C0885b.m6371a(this);
            c0885bM6371a.m6377a(this.f5814a);
            c0885bM6371a.m6382b(this.f5513db.getUserId());
            c0885bM6371a.m6384c(this.f5513db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        if (shareParams.isShareTencentWeibo()) {
            m6350a(shareParams);
        } else {
            m6353b(shareParams);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6350a(final Platform.ShareParams shareParams) {
        HashMap<String, Object> mapM6374a;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        boolean zIsShareTencentWeibo = shareParams.isShareTencentWeibo();
        try {
            if (TextUtils.isEmpty(imagePath) && !TextUtils.isEmpty(imageUrl)) {
                shareParams.setImagePath(BitmapHelper.downloadBitmap(this.context, imageUrl));
                doShare(shareParams);
                return;
            }
            if (!isAuthValid()) {
                final PlatformActionListener platformActionListener = getPlatformActionListener();
                setPlatformActionListener(new PlatformActionListener() { // from class: cn.sharesdk.tencent.qzone.QZone.2
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i, Throwable th) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(platform, 9, th);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
                        QZone.this.setPlatformActionListener(platformActionListener);
                        QZone.this.doShare(shareParams);
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i) {
                        if (platformActionListener != null) {
                            platformActionListener.onCancel(platform, 9);
                        }
                    }
                });
                authorize();
                return;
            }
            String text = shareParams.getText();
            if (TextUtils.isEmpty(text)) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable("share params' value of text is empty!"));
                    return;
                }
                return;
            }
            String shortLintk = getShortLintk(text, false);
            shareParams.setText(shortLintk);
            C0885b c0885bM6371a = C0885b.m6371a(this);
            if (zIsShareTencentWeibo) {
                mapM6374a = c0885bM6371a.m6381b(imagePath, shortLintk);
            } else {
                mapM6374a = c0885bM6371a.m6374a(imagePath, shortLintk);
            }
            if (mapM6374a == null && this.listener != null) {
                this.listener.onError(this, 9, new Throwable("response is empty"));
            }
            mapM6374a.put("ShareParams", shareParams);
            if (this.listener != null) {
                this.listener.onComplete(this, 9, mapM6374a);
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m6353b(final Platform.ShareParams shareParams) {
        try {
            String imageUrl = shareParams.getImageUrl();
            String imagePath = shareParams.getImagePath();
            if (isClientValid()) {
                String str = (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) ? imageUrl : imagePath;
                String title = shareParams.getTitle();
                String titleUrl = shareParams.getTitleUrl();
                String site = shareParams.getSite();
                String text = shareParams.getText();
                if (!TextUtils.isEmpty(text)) {
                    text = getShortLintk(text, false);
                    shareParams.setText(text);
                }
                String str2 = text;
                if (!TextUtils.isEmpty(titleUrl)) {
                    titleUrl = getShortLintk(titleUrl, false);
                    shareParams.setTitleUrl(titleUrl);
                }
                C0885b.m6371a(this).m6378a(title, titleUrl, str2, str, site, new PlatformActionListener() { // from class: cn.sharesdk.tencent.qzone.QZone.3
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i, Throwable th) {
                        if (QZone.this.listener != null) {
                            QZone.this.listener.onError(QZone.this, 9, th);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
                        if (QZone.this.listener != null) {
                            map.put("ShareParams", shareParams);
                            QZone.this.listener.onComplete(QZone.this, 9, map);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i) {
                        if (QZone.this.listener != null) {
                            QZone.this.listener.onCancel(QZone.this, 9);
                        }
                    }
                });
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 9, new QQClientNotExistException());
            }
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
            HashMap<String, Object> mapM6385d = C0885b.m6371a(this).m6385d(str);
            if (mapM6385d != null && mapM6385d.size() > 0) {
                if (!mapM6385d.containsKey("ret")) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable());
                        return;
                    }
                    return;
                }
                if (((Integer) mapM6385d.get("ret")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6385d)));
                        return;
                    }
                    return;
                }
                if (str == this.f5513db.getUserId()) {
                    this.f5513db.put("nickname", String.valueOf(mapM6385d.get("nickname")));
                    if (mapM6385d.containsKey("figureurl_qq_1")) {
                        this.f5513db.put("iconQQ", String.valueOf(mapM6385d.get("figureurl_qq_1")));
                    } else if (mapM6385d.containsKey("figureurl_qq_2")) {
                        this.f5513db.put("iconQQ", String.valueOf(mapM6385d.get("figureurl_qq_2")));
                    }
                    if (mapM6385d.containsKey("figureurl_2")) {
                        this.f5513db.put("icon", String.valueOf(mapM6385d.get("figureurl_2")));
                    } else if (mapM6385d.containsKey("figureurl_1")) {
                        this.f5513db.put("icon", String.valueOf(mapM6385d.get("figureurl_1")));
                    } else if (mapM6385d.containsKey("figureurl")) {
                        this.f5513db.put("icon", String.valueOf(mapM6385d.get("figureurl")));
                    }
                    this.f5513db.put("secretType", String.valueOf(mapM6385d.get("is_yellow_vip")));
                    if (String.valueOf(mapM6385d.get("is_yellow_vip")).equals("1")) {
                        this.f5513db.put("snsUserLevel", String.valueOf(mapM6385d.get("level")));
                    }
                    String strValueOf = String.valueOf(mapM6385d.get("gender"));
                    if (strValueOf.equals("男")) {
                        this.f5513db.put("gender", "0");
                    } else if (strValueOf.equals("女")) {
                        this.f5513db.put("gender", "1");
                    } else {
                        this.f5513db.put("gender", "2");
                    }
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 8, mapM6385d);
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
        HashMap<String, Object> mapM6375a = C0885b.m6371a(this).m6375a(str, str2, map, map2);
        if (mapM6375a == null || mapM6375a.size() <= 0) {
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable());
            }
        } else if (!mapM6375a.containsKey("ret")) {
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable());
            }
        } else {
            if (((Integer) mapM6375a.get("ret")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(mapM6375a)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onComplete(this, i, mapM6375a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        aVar.f5621b = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (imagePath != null) {
            aVar.f5624e.add(imagePath);
        } else if (map.get("large_url") != null) {
            aVar.f5623d.add(String.valueOf(map.get("large_url")));
        } else if (map.get("small_url") != null) {
            aVar.f5623d.add(String.valueOf(map.get("small_url")));
        } else if (imageUrl != null) {
            aVar.f5623d.add(imageUrl);
        }
        String titleUrl = shareParams.getTitleUrl();
        if (titleUrl != null) {
            aVar.f5622c.add(titleUrl);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", shareParams.getTitle());
        map2.put("titleUrl", shareParams.getTitleUrl());
        map2.put("site", shareParams.getSite());
        aVar.f5626g = map2;
        return aVar;
    }
}
