package cn.sharesdk.twitter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Twitter extends Platform {
    public static final String NAME = "Twitter";

    /* JADX INFO: renamed from: a */
    private String f5885a;

    /* JADX INFO: renamed from: b */
    private String f5886b;

    /* JADX INFO: renamed from: c */
    private String f5887c;

    public static class ShareParams extends Platform.ShareParams {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 11;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    public Twitter(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5885a = getDevinfo("ConsumerKey");
        this.f5886b = getDevinfo("ConsumerSecret");
        this.f5887c = getDevinfo("CallbackUrl");
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5885a = getNetworkDevinfo("consumer_key", "ConsumerKey");
        this.f5886b = getNetworkDevinfo("consumer_secret", "ConsumerSecret");
        this.f5887c = getNetworkDevinfo("redirect_uri", "CallbackUrl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        HashMap<String, Object> mapM6491c;
        C0897b c0897bM6482a = C0897b.m6482a(this);
        String shortLintk = getShortLintk(shareParams.getText(), false);
        shareParams.setText(shortLintk);
        try {
            String[] imageArray = shareParams.getImageArray();
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            if (imageArray != null && imageArray.length > 0) {
                mapM6491c = c0897bM6482a.m6485a(shortLintk, imageArray);
            } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                mapM6491c = c0897bM6482a.m6494e(shortLintk, imagePath);
            } else if (!TextUtils.isEmpty(imageUrl)) {
                String strDownloadBitmap = BitmapHelper.downloadBitmap(getContext(), imageUrl);
                mapM6491c = new File(strDownloadBitmap).exists() ? c0897bM6482a.m6494e(shortLintk, strDownloadBitmap) : null;
            } else {
                mapM6491c = c0897bM6482a.m6491c(shortLintk);
            }
            if (mapM6491c == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable("response is null"));
                }
            } else if (mapM6491c.containsKey("error_code") || mapM6491c.containsKey("error")) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6491c)));
                }
            } else {
                mapM6491c.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, mapM6491c);
                }
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0897b c0897bM6482a = C0897b.m6482a(this);
        c0897bM6482a.m6488a(this.f5885a, this.f5886b, this.f5887c);
        c0897bM6482a.m6486a(new AuthorizeListener() { // from class: cn.sharesdk.twitter.Twitter.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("oauth_token");
                String string2 = bundle.getString("oauth_token_secret");
                String string3 = bundle.getString("user_id");
                String string4 = bundle.getString("screen_name");
                Twitter.this.f5513db.putToken(string);
                Twitter.this.f5513db.putTokenSecret(string2);
                Twitter.this.f5513db.putUserId(string3);
                Twitter.this.f5513db.put("nickname", string4);
                c0897bM6482a.m6487a(string, string2);
                Twitter.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (Twitter.this.listener != null) {
                    Twitter.this.listener.onError(Twitter.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (Twitter.this.listener != null) {
                    Twitter.this.listener.onCancel(Twitter.this, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid()) {
            C0897b c0897bM6482a = C0897b.m6482a(this);
            c0897bM6482a.m6488a(this.f5885a, this.f5886b, this.f5887c);
            String token = this.f5513db.getToken();
            String tokenSecret = this.f5513db.getTokenSecret();
            if (token != null && tokenSecret != null) {
                c0897bM6482a.m6487a(token, tokenSecret);
                return true;
            }
        }
        innerAuthorize(i, obj);
        return false;
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
        try {
            HashMap<String, Object> mapM6489b = C0897b.m6482a(this).m6489b(str);
            if (mapM6489b != null && mapM6489b.size() > 0) {
                if (!mapM6489b.containsKey("error_code") && !mapM6489b.containsKey("error")) {
                    if (str == null) {
                        this.f5513db.put("nickname", String.valueOf(mapM6489b.get("screen_name")));
                        this.f5513db.put("icon", String.valueOf(mapM6489b.get("profile_image_url")));
                        this.f5513db.put("gender", "2");
                        this.f5513db.put("resume", String.valueOf(mapM6489b.get("description")));
                        this.f5513db.put("secretType", "true".equals(String.valueOf(mapM6489b.get("verified"))) ? "1" : "0");
                        this.f5513db.put("followerCount", String.valueOf(mapM6489b.get("followers_count")));
                        this.f5513db.put("favouriteCount", String.valueOf(mapM6489b.get("friends_count")));
                        this.f5513db.put("shareCount", String.valueOf(mapM6489b.get("statuses_count")));
                        this.f5513db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(mapM6489b.get("created_at")))));
                        this.f5513db.put("snsUserUrl", "https://twitter.com/" + mapM6489b.get("screen_name"));
                    }
                    if (this.listener != null) {
                        this.listener.onComplete(this, 8, mapM6489b);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6489b)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("response is null"));
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
        String userId = TextUtils.isEmpty(null) ? this.f5513db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.f5513db.getUserName();
        }
        if (TextUtils.isEmpty(userId) && this.listener != null) {
            this.listener.onError(this, 2, new Throwable("The account do not authorize!"));
        }
        C0897b c0897bM6482a = C0897b.m6482a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapM6490b = c0897bM6482a.m6490b(userId, str);
            if (mapM6490b != null && mapM6490b.size() > 0) {
                if (!mapM6490b.containsKey("error_code") && !mapM6490b.containsKey("error")) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, 2, mapM6490b);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapM6490b)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 2, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2) {
        try {
            HashMap<String, Object> mapM6484a = C0897b.m6482a(this).m6484a(str, str2, map, map2);
            if (mapM6484a != null && mapM6484a.size() > 0) {
                if (!mapM6484a.containsKey("error_code") && !mapM6484a.containsKey("error")) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, i, mapM6484a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(mapM6484a)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, i, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        ArrayList arrayList;
        C0840f.a aVar = new C0840f.a();
        aVar.f5621b = shareParams.getText();
        if (map != null) {
            HashMap map2 = (HashMap) map.get("entities");
            if (map2 != null && (arrayList = (ArrayList) map2.get("media")) != null && arrayList.size() > 0 && ((HashMap) arrayList.get(0)) != null) {
                aVar.f5623d.add(String.valueOf(map.get("media_url")));
            }
            aVar.f5620a = String.valueOf(map.get("id"));
            aVar.f5626g = map;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i, int i2, String str) {
        String userId = TextUtils.isEmpty(null) ? this.f5513db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.f5513db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        C0897b c0897bM6482a = C0897b.m6482a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapM6492c = c0897bM6482a.m6492c(userId, str);
            if (mapM6492c != null && mapM6492c.size() > 0 && !mapM6492c.containsKey("error_code") && !mapM6492c.containsKey("error")) {
                return filterFriendshipInfo(11, mapM6492c);
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        String userId = TextUtils.isEmpty(null) ? this.f5513db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.f5513db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        C0897b c0897bM6482a = C0897b.m6482a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapM6490b = c0897bM6482a.m6490b(userId, str);
            if (mapM6490b != null && mapM6490b.size() > 0 && !mapM6490b.containsKey("error_code") && !mapM6490b.containsKey("error")) {
                return filterFriendshipInfo(2, mapM6490b);
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        HashMap<String, Object> map2 = new HashMap<>();
        if (i == 2) {
            map2.put("type", "FOLLOWING");
        } else {
            switch (i) {
                case 10:
                    map2.put("type", "FRIENDS");
                    break;
                case 11:
                    map2.put("type", "FOLLOWERS");
                    break;
                default:
                    return null;
            }
        }
        map2.put("snsplat", Integer.valueOf(getPlatformId()));
        map2.put("snsuid", this.f5513db.getUserId());
        String strValueOf = map.containsKey("next_cursor") ? String.valueOf(map.get("next_cursor")) : null;
        Object obj = map.get("users");
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<HashMap> arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        for (HashMap map3 : arrayList2) {
            if (map3 != null) {
                HashMap map4 = new HashMap();
                map4.put("snsuid", String.valueOf(map3.get("id")));
                map4.put("nickname", String.valueOf(map3.get("screen_name")));
                map4.put("icon", String.valueOf(map3.get("profile_image_url")));
                map4.put("gender", "2");
                map4.put("resume", String.valueOf(map3.get("description")));
                map4.put("secretType", "true".equals(String.valueOf(map3.get("verified"))) ? "1" : "0");
                map4.put("followerCount", String.valueOf(map3.get("followers_count")));
                map4.put("favouriteCount", String.valueOf(map3.get("friends_count")));
                map4.put("shareCount", String.valueOf(map3.get("statuses_count")));
                map4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(map3.get("created_at")))));
                map4.put("snsUserUrl", "https://twitter.com/" + map3.get("screen_name"));
                arrayList.add(map4);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        String str = strValueOf + "_false";
        if (TextUtils.isEmpty(strValueOf) || "0".equals(strValueOf)) {
            str = "0_true";
        }
        map2.put("nextCursor", str);
        map2.put("list", arrayList);
        return map2;
    }
}
