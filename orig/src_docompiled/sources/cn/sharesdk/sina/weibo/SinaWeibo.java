package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SinaWeibo extends Platform {
    public static final String NAME = "SinaWeibo";

    /* JADX INFO: renamed from: a */
    private String f5721a;

    /* JADX INFO: renamed from: b */
    private String f5722b;

    /* JADX INFO: renamed from: c */
    private String f5723c;

    /* JADX INFO: renamed from: d */
    private boolean f5724d;

    public static class ShareParams extends Platform.ShareParams {

        @Deprecated
        public String imageUrl;

        @Deprecated
        public float latitude;

        @Deprecated
        public float longitude;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    public SinaWeibo(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5721a = getDevinfo("AppKey");
        this.f5722b = getDevinfo("AppSecret");
        this.f5723c = getDevinfo("RedirectUrl");
        this.f5724d = "true".equals(getDevinfo("ShareByAppClient"));
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5721a = getNetworkDevinfo("app_key", "AppKey");
        this.f5722b = getNetworkDevinfo("app_secret", "AppSecret");
        this.f5723c = getNetworkDevinfo("redirect_uri", "RedirectUrl");
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return C0870d.m6244a(this).m6264b();
    }

    /* JADX INFO: renamed from: c */
    private boolean m6208c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        C0870d c0870dM6244a = C0870d.m6244a(this);
        c0870dM6244a.m6259a(this.f5721a, this.f5722b);
        c0870dM6244a.m6258a(this.f5723c);
        return c0870dM6244a.m6261a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        C0870d c0870dM6244a = C0870d.m6244a(this);
        if (i == 9 && this.f5724d && c0870dM6244a.m6264b()) {
            return true;
        }
        if (isAuthValid() || m6208c()) {
            c0870dM6244a.m6259a(this.f5721a, this.f5722b);
            c0870dM6244a.m6263b(this.f5513db.getToken());
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0870d c0870dM6244a = C0870d.m6244a(this);
        c0870dM6244a.m6259a(this.f5721a, this.f5722b);
        c0870dM6244a.m6258a(this.f5723c);
        c0870dM6244a.m6260a(strArr);
        c0870dM6244a.m6257a(new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.SinaWeibo.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                long j;
                String string = bundle.getString("uid");
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                String string4 = bundle.getString("refresh_token");
                SinaWeibo.this.f5513db.put("nickname", bundle.getString("userName"));
                SinaWeibo.this.f5513db.put("remind_in", bundle.getString("remind_in"));
                SinaWeibo.this.f5513db.putToken(string2);
                try {
                    j = ResHelper.parseLong(string3);
                } catch (Throwable unused) {
                    j = 0;
                }
                SinaWeibo.this.f5513db.putExpiresIn(j);
                SinaWeibo.this.f5513db.put("refresh_token", string4);
                SinaWeibo.this.f5513db.putUserId(string);
                c0870dM6244a.m6263b(string2);
                SinaWeibo.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (SinaWeibo.this.listener != null) {
                    SinaWeibo.this.listener.onError(SinaWeibo.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (SinaWeibo.this.listener != null) {
                    SinaWeibo.this.listener.onCancel(SinaWeibo.this, 1);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        try {
            HashMap<String, Object> mapM6268d = C0870d.m6244a(this).m6268d(str);
            if (mapM6268d == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 6, new Throwable());
                }
            } else {
                if (mapM6268d.containsKey("error_code") && ((Integer) mapM6268d.get("error_code")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 6, new Throwable(new Hashon().fromHashMap(mapM6268d)));
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 6, mapM6268d);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 6, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener != null) {
                this.listener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> mapM6253a = C0870d.m6244a(this).m6253a(i, i2, str);
            if (mapM6253a == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 7, new Throwable());
                }
            } else {
                if (mapM6253a.containsKey("error_code") && ((Integer) mapM6253a.get("error_code")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 7, new Throwable(new Hashon().fromHashMap(mapM6253a)));
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 7, mapM6253a);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 7, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
            z = true;
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener != null) {
                this.listener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> mapM6266c = C0870d.m6244a(this).m6266c(str);
            if (mapM6266c == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable());
                    return;
                }
                return;
            }
            if (mapM6266c.containsKey("error_code") && ((Integer) mapM6266c.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6266c)));
                    return;
                }
                return;
            }
            if (z) {
                this.f5513db.putUserId(String.valueOf(mapM6266c.get("id")));
                this.f5513db.put("nickname", String.valueOf(mapM6266c.get("screen_name")));
                this.f5513db.put("icon", String.valueOf(mapM6266c.get("avatar_hd")));
                if (String.valueOf(mapM6266c.get("verified")).equals("true")) {
                    this.f5513db.put("secretType", "1");
                } else {
                    this.f5513db.put("secretType", "0");
                }
                this.f5513db.put("secret", String.valueOf(mapM6266c.get("verified_reason")));
                String strValueOf = String.valueOf(mapM6266c.get("gender"));
                if (strValueOf.equals("m")) {
                    this.f5513db.put("gender", "0");
                } else if (strValueOf.equals("f")) {
                    this.f5513db.put("gender", "1");
                } else {
                    this.f5513db.put("gender", "2");
                }
                this.f5513db.put("snsUserUrl", "http://weibo.com/" + String.valueOf(mapM6266c.get("profile_url")));
                this.f5513db.put("resume", String.valueOf(mapM6266c.get("description")));
                this.f5513db.put("followerCount", String.valueOf(mapM6266c.get("followers_count")));
                this.f5513db.put("favouriteCount", String.valueOf(mapM6266c.get("friends_count")));
                this.f5513db.put("shareCount", String.valueOf(mapM6266c.get("statuses_count")));
                this.f5513db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(mapM6266c.get("created_at")))));
            }
            if (this.listener != null) {
                this.listener.onComplete(this, 8, mapM6266c);
            }
        } catch (Throwable th) {
            this.listener.onError(this, 8, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener != null) {
                this.listener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> mapM6262b = C0870d.m6244a(this).m6262b(i, i2, str);
            if (mapM6262b == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable());
                }
            } else {
                if (mapM6262b.containsKey("error_code") && ((Integer) mapM6262b.get("error_code")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapM6262b)));
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 2, mapM6262b);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2) {
        try {
            HashMap<String, Object> mapM6255a = C0870d.m6244a(this).m6255a(str, str2, map, map2);
            if (mapM6255a != null && mapM6255a.size() > 0) {
                if (mapM6255a.containsKey("error_code") && ((Integer) mapM6255a.get("error_code")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(mapM6255a)));
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, i, mapM6255a);
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable());
            }
        } catch (Throwable th) {
            this.listener.onError(this, i, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        int stringRes;
        String text = shareParams.getText();
        if (TextUtils.isEmpty(text) && (stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_upload_content")) > 0) {
            text = getContext().getString(stringRes);
        }
        C0870d c0870dM6244a = C0870d.m6244a(this);
        c0870dM6244a.m6259a(this.f5721a, this.f5722b);
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (this.f5724d && c0870dM6244a.m6264b()) {
            try {
                c0870dM6244a.m6256a(shareParams, this.listener);
                return;
            } catch (Throwable th) {
                this.listener.onError(this, 9, th);
                return;
            }
        }
        try {
            HashMap<String, Object> mapM6254a = c0870dM6244a.m6254a(getShortLintk(text, false), imageUrl, imagePath, shareParams.getLongitude(), shareParams.getLatitude());
            if (mapM6254a == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable());
                }
            } else if (mapM6254a.containsKey("error_code") && ((Integer) mapM6254a.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable(new Hashon().fromHashMap(mapM6254a)));
                }
            } else {
                mapM6254a.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, mapM6254a);
                }
            }
        } catch (Throwable th2) {
            this.listener.onError(this, 9, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        aVar.f5621b = shareParams.getText();
        if (map != null) {
            aVar.f5620a = String.valueOf(map.get("id"));
            aVar.f5623d.add(String.valueOf(map.get("original_pic")));
            aVar.f5626g = map;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> mapM6262b = C0870d.m6244a(this).m6262b(i, i2, str);
            if (mapM6262b == null || mapM6262b.containsKey("error_code")) {
                return null;
            }
            mapM6262b.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(2, mapM6262b);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> mapM6265c = C0870d.m6244a(this).m6265c(i, i2, str);
            if (mapM6265c == null || mapM6265c.containsKey("error_code")) {
                return null;
            }
            mapM6265c.put("page_count", Integer.valueOf(i));
            mapM6265c.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(10, mapM6265c);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f5513db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> mapM6267d = C0870d.m6244a(this).m6267d(i, i2, str);
            if (mapM6267d == null || mapM6267d.containsKey("error_code")) {
                return null;
            }
            mapM6267d.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(11, mapM6267d);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        Object obj;
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
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
        int i2 = Integer.parseInt(String.valueOf(map.get("current_cursor")));
        int i3 = Integer.parseInt(String.valueOf(map.get("total_number")));
        if (i3 == 0 || (obj = map.get("users")) == null) {
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
                map4.put("icon", String.valueOf(map3.get("avatar_hd")));
                if (String.valueOf(map3.get("verified")).equals("true")) {
                    map4.put("secretType", "1");
                } else {
                    map4.put("secretType", "0");
                }
                map4.put("secret", String.valueOf(map3.get("verified_reason")));
                String strValueOf = String.valueOf(map3.get("gender"));
                if (strValueOf.equals("m")) {
                    map4.put("gender", "0");
                } else if (strValueOf.equals("f")) {
                    map4.put("gender", "1");
                } else {
                    map4.put("gender", "2");
                }
                map4.put("snsUserUrl", "http://weibo.com/" + String.valueOf(map3.get("profile_url")));
                map4.put("resume", String.valueOf(map3.get("description")));
                map4.put("followerCount", String.valueOf(map3.get("followers_count")));
                map4.put("favouriteCount", String.valueOf(map3.get("friends_count")));
                map4.put("shareCount", String.valueOf(map3.get("statuses_count")));
                map4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(map3.get("created_at")))));
                arrayList.add(map4);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        if (10 == i) {
            int iIntValue = ((Integer) map.get("page_count")).intValue();
            int i4 = i2 + 1;
            if (iIntValue * i4 >= i3) {
                sb2 = new StringBuilder();
                sb2.append(i2);
                str2 = "_true";
            } else {
                sb2 = new StringBuilder();
                sb2.append(i4);
                str2 = "_false";
            }
            sb2.append(str2);
            map2.put("nextCursor", sb2.toString());
        } else {
            int size = i2 + arrayList.size();
            if (size >= i3) {
                sb = new StringBuilder();
                sb.append(i3);
                str = "_true";
            } else {
                sb = new StringBuilder();
                sb.append(size);
                str = "_false";
            }
            sb.append(str);
            map2.put("nextCursor", sb.toString());
        }
        map2.put("list", arrayList);
        return map2;
    }
}
