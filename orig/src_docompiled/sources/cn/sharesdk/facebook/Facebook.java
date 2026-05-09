package cn.sharesdk.facebook;

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
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class Facebook extends Platform {
    public static final String NAME = "Facebook";

    /* JADX INFO: renamed from: a */
    private String f5478a;

    /* JADX INFO: renamed from: b */
    private String f5479b;

    public static class ShareParams extends Platform.ShareParams {
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

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 10;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    public Facebook(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5478a = getDevinfo("ConsumerKey");
        this.f5479b = getDevinfo("RedirectUrl");
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5478a = getNetworkDevinfo("api_key", "ConsumerKey");
        this.f5479b = getNetworkDevinfo("redirect_uri", "RedirectUrl");
        if (TextUtils.isEmpty(this.f5479b)) {
            this.f5479b = "fbconnect://success";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0815d c0815dM5910a = C0815d.m5910a(this);
        c0815dM5910a.m5916a(this.f5478a);
        c0815dM5910a.m5924d(this.f5479b);
        c0815dM5910a.m5918a(strArr);
        c0815dM5910a.m5915a(new AuthorizeListener() { // from class: cn.sharesdk.facebook.Facebook.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (Facebook.this.listener != null) {
                    Facebook.this.listener.onError(Facebook.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("oauth_token");
                int i = bundle.getInt("oauth_token_expires");
                if (i == 0) {
                    try {
                        i = ResHelper.parseInt(String.valueOf(bundle.get("expires_in")));
                    } catch (Throwable th) {
                        C0851d.m6195a().m8610d(th);
                        i = 0;
                    }
                }
                if (TextUtils.isEmpty(string)) {
                    string = bundle.getString("access_token");
                }
                Facebook.this.f5513db.putToken(string);
                Facebook.this.f5513db.putExpiresIn(i);
                c0815dM5910a.m5917a(string, String.valueOf(i));
                Facebook.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (Facebook.this.listener != null) {
                    Facebook.this.listener.onCancel(Facebook.this, 1);
                }
            }
        }, isSSODisable());
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        C0815d c0815dM5910a = C0815d.m5910a(this);
        c0815dM5910a.m5916a(this.f5478a);
        return c0815dM5910a.m5922b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid()) {
            C0815d c0815dM5910a = C0815d.m5910a(this);
            c0815dM5910a.m5916a(this.f5478a);
            String token = this.f5513db.getToken();
            String strValueOf = String.valueOf(this.f5513db.getExpiresIn());
            if (token != null && strValueOf != null) {
                c0815dM5910a.m5917a(token, strValueOf);
                if (c0815dM5910a.m5919a()) {
                    return true;
                }
            }
        } else if ((obj instanceof Platform.ShareParams) && ((Platform.ShareParams) obj).getShareType() == 4) {
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(final Platform.ShareParams shareParams) {
        HashMap<String, Object> mapM5920b;
        C0815d c0815dM5910a = C0815d.m5910a(this);
        c0815dM5910a.m5916a(this.f5478a);
        try {
            String shortLintk = getShortLintk(shareParams.getText(), false);
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            String titleUrl = shareParams.getTitleUrl();
            String url = shareParams.getUrl();
            if (shareParams.getShareType() == 4 && (!TextUtils.isEmpty(titleUrl) || !TextUtils.isEmpty(url))) {
                if (TextUtils.isEmpty(imageUrl) && !TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                    shareParams.setImageUrl(uploadImageToFileServer(imagePath));
                }
                c0815dM5910a.m5914a(shareParams, new PlatformActionListener() { // from class: cn.sharesdk.facebook.Facebook.2
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i, Throwable th) {
                        if (Facebook.this.listener != null) {
                            Facebook.this.listener.onError(Facebook.this, 9, th);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
                        if (Facebook.this.listener != null) {
                            map.put("ShareParams", shareParams);
                            Facebook.this.listener.onComplete(Facebook.this, 9, map);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i) {
                        if (Facebook.this.listener != null) {
                            Facebook.this.listener.onCancel(Facebook.this, 9);
                        }
                    }
                });
                return;
            }
            if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                mapM5920b = c0815dM5910a.m5921b(shortLintk, imagePath);
            } else if (!TextUtils.isEmpty(imageUrl)) {
                File file = new File(BitmapHelper.downloadBitmap(this.context, imageUrl));
                if (file.exists()) {
                    mapM5920b = c0815dM5910a.m5921b(shortLintk, file.getAbsolutePath());
                } else {
                    mapM5920b = c0815dM5910a.m5920b(shortLintk);
                }
            } else {
                mapM5920b = c0815dM5910a.m5920b(shortLintk);
            }
            if (mapM5920b != null && mapM5920b.size() > 0) {
                if (!mapM5920b.containsKey("error_code") && !mapM5920b.containsKey("error")) {
                    if (this.listener != null) {
                        mapM5920b.put("ShareParams", shareParams);
                        this.listener.onComplete(this, 9, mapM5920b);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable(new Hashon().fromHashMap(mapM5920b)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 9, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        HashMap map;
        try {
            HashMap<String, Object> mapM5923c = C0815d.m5910a(this).m5923c(str);
            if (mapM5923c != null && mapM5923c.size() > 0) {
                if (!mapM5923c.containsKey("error_code") && !mapM5923c.containsKey("error")) {
                    if (str == null) {
                        this.f5513db.putUserId(String.valueOf(mapM5923c.get("id")));
                        this.f5513db.put("nickname", String.valueOf(mapM5923c.get(Const.TableSchema.COLUMN_NAME)));
                        this.f5513db.put("gender", "male".equals(String.valueOf(mapM5923c.get("gender"))) ? "0" : "1");
                        this.f5513db.put("token_for_business", (String) mapM5923c.get("token_for_business"));
                        HashMap map2 = mapM5923c.containsKey("picture") ? (HashMap) mapM5923c.get("picture") : null;
                        if (map2 != null && (map = (HashMap) map2.get("data")) != null) {
                            this.f5513db.put("icon", String.valueOf(map.get("url")));
                        }
                        try {
                            if (mapM5923c.containsKey("birthday")) {
                                String[] strArrSplit = String.valueOf(mapM5923c.get("birthday")).split("/");
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(1, ResHelper.parseInt(strArrSplit[2]));
                                calendar.set(2, ResHelper.parseInt(strArrSplit[0]) - 1);
                                calendar.set(5, ResHelper.parseInt(strArrSplit[1]));
                                this.f5513db.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                            }
                        } catch (Throwable th) {
                            C0851d.m6195a().m8610d(th);
                        }
                        this.f5513db.put("secretType", "true".equals(String.valueOf(mapM5923c.get("verified"))) ? "1" : "0");
                        this.f5513db.put("snsUserUrl", String.valueOf(mapM5923c.get("link")));
                        this.f5513db.put("resume", String.valueOf(mapM5923c.get("link")));
                        ArrayList<HashMap> arrayList = mapM5923c.containsKey("education") ? (ArrayList) mapM5923c.get("education") : null;
                        if (arrayList != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (HashMap map3 : arrayList) {
                                HashMap map4 = new HashMap();
                                map4.put("school_type", 0);
                                HashMap map5 = map3.containsKey("school") ? (HashMap) map3.get("school") : null;
                                if (map5 != null) {
                                    map4.put("school", String.valueOf(map5.get(Const.TableSchema.COLUMN_NAME)));
                                }
                                try {
                                    map4.put("year", Integer.valueOf(ResHelper.parseInt(String.valueOf((map3.containsKey("year") ? (HashMap) map3.get("year") : null).get(Const.TableSchema.COLUMN_NAME)))));
                                } catch (Throwable th2) {
                                    C0851d.m6195a().m8610d(th2);
                                }
                                map4.put("background", 0);
                                arrayList2.add(map4);
                            }
                            HashMap map6 = new HashMap();
                            map6.put("list", arrayList2);
                            String strFromHashMap = new Hashon().fromHashMap(map6);
                            this.f5513db.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                        }
                        ArrayList<HashMap> arrayList3 = mapM5923c.containsKey("work") ? (ArrayList) mapM5923c.get("work") : null;
                        if (arrayList3 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            for (HashMap map7 : arrayList3) {
                                HashMap map8 = new HashMap();
                                HashMap map9 = (HashMap) map7.get("employer");
                                if (map9 != null) {
                                    map8.put("company", String.valueOf(map9.get(Const.TableSchema.COLUMN_NAME)));
                                }
                                HashMap map10 = (HashMap) map7.get("position");
                                if (map10 != null) {
                                    map8.put("position", String.valueOf(map10.get(Const.TableSchema.COLUMN_NAME)));
                                }
                                try {
                                    String[] strArrSplit2 = String.valueOf(map7.get("start_date")).split("-");
                                    map8.put("start_date", Integer.valueOf((ResHelper.parseInt(strArrSplit2[0]) * 100) + ResHelper.parseInt(strArrSplit2[1])));
                                } catch (Throwable th3) {
                                    C0851d.m6195a().m8610d(th3);
                                }
                                try {
                                    String[] strArrSplit3 = String.valueOf(map7.get("end_date")).split("-");
                                    map8.put("end_date", Integer.valueOf((ResHelper.parseInt(strArrSplit3[0]) * 100) + ResHelper.parseInt(strArrSplit3[1])));
                                } catch (Throwable th4) {
                                    C0851d.m6195a().m8610d(th4);
                                    map8.put("end_date", 0);
                                }
                                arrayList4.add(map8);
                            }
                            HashMap map11 = new HashMap();
                            map11.put("list", arrayList4);
                            String strFromHashMap2 = new Hashon().fromHashMap(map11);
                            this.f5513db.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                        }
                    }
                    if (this.listener != null) {
                        this.listener.onComplete(this, 8, mapM5923c);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM5923c)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th5) {
            if (this.listener != null) {
                this.listener.onError(this, 8, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        aVar.f5621b = shareParams.getText();
        if (map != null) {
            if (map != null && map.containsKey("source")) {
                aVar.f5623d.add(String.valueOf(map.get("source")));
            } else if (4 == shareParams.getShareType()) {
                aVar.f5623d.add(shareParams.getImageUrl());
                String titleUrl = shareParams.getTitleUrl();
                if (TextUtils.isEmpty(titleUrl)) {
                    titleUrl = shareParams.getUrl();
                }
                aVar.f5622c.add(titleUrl);
            }
            Object obj = map.get("post_id");
            aVar.f5620a = obj == null ? null : String.valueOf(obj);
            aVar.f5626g = map;
        }
        return aVar;
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
    public void getFriendList(int i, int i2, String str) {
        try {
            HashMap<String, Object> mapM5912a = C0815d.m5910a(this).m5912a(i, i2 * i, str);
            if (mapM5912a != null && mapM5912a.size() > 0) {
                if (!mapM5912a.containsKey("error_code") && !mapM5912a.containsKey("error")) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, 2, mapM5912a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapM5912a)));
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
            HashMap<String, Object> mapM5913a = C0815d.m5910a(this).m5913a(str, str2, map, map2);
            if (mapM5913a != null && mapM5913a.size() > 0) {
                if (!mapM5913a.containsKey("error_code") && !mapM5913a.containsKey("error")) {
                    if (this.listener != null) {
                        this.listener.onComplete(this, i, mapM5913a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(mapM5913a)));
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
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        try {
            HashMap<String, Object> mapM5912a = C0815d.m5910a(this).m5912a(i, i2, str);
            if (mapM5912a != null && mapM5912a.size() > 0 && !mapM5912a.containsKey("error_code") && !mapM5912a.containsKey("error")) {
                mapM5912a.put("current_limit", Integer.valueOf(i));
                mapM5912a.put("current_cursor", Integer.valueOf(i2));
                return filterFriendshipInfo(2, mapM5912a);
            }
            return null;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        Object obj = map.get("data");
        HashMap map2 = null;
        if (obj == null) {
            return null;
        }
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("type", "FOLLOWING");
        map3.put("snsplat", Integer.valueOf(getPlatformId()));
        map3.put("snsuid", this.f5513db.getUserId());
        int iIntValue = ((Integer) map.get("current_cursor")).intValue();
        int iIntValue2 = ((Integer) map.get("current_limit")).intValue();
        ArrayList arrayList = new ArrayList();
        ArrayList<HashMap> arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        for (HashMap map4 : arrayList2) {
            if (map4 != null) {
                HashMap map5 = new HashMap();
                map5.put("snsuid", String.valueOf(map4.get("id")));
                map5.put("nickname", String.valueOf(map4.get(Const.TableSchema.COLUMN_NAME)));
                map5.put("gender", "male".equals(String.valueOf(map4.get("gender"))) ? "0" : "1");
                map5.put("secretType", "true".equals(String.valueOf(map4.get("verified"))) ? "1" : "0");
                map5.put("snsUserUrl", String.valueOf(map4.get("link")));
                map5.put("resume", String.valueOf(map4.get("link")));
                HashMap map6 = map4.containsKey("picture") ? (HashMap) map4.get("picture") : map2;
                if (map6 != null) {
                    HashMap map7 = map6.containsKey("data") ? (HashMap) map6.get("data") : map2;
                    if (map7 != null) {
                        map5.put("icon", String.valueOf(map7.get("url")));
                    }
                }
                int i2 = 0;
                try {
                    if (map4.containsKey("birthday")) {
                        String[] strArrSplit = String.valueOf(map4.get("birthday")).split("/");
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, ResHelper.parseInt(strArrSplit[2]));
                        calendar.set(2, ResHelper.parseInt(strArrSplit[0]) - 1);
                        calendar.set(5, ResHelper.parseInt(strArrSplit[1]));
                        map5.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                    }
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                }
                ArrayList<HashMap> arrayList3 = map4.containsKey("education") ? (ArrayList) map4.get("education") : map2;
                if (arrayList3 != 0) {
                    ArrayList arrayList4 = new ArrayList();
                    for (HashMap map8 : arrayList3) {
                        HashMap map9 = new HashMap();
                        map9.put("school_type", Integer.valueOf(i2));
                        HashMap map10 = (HashMap) map8.get("school");
                        if (map10 != null) {
                            map9.put("school", String.valueOf(map10.get(Const.TableSchema.COLUMN_NAME)));
                        }
                        try {
                            map9.put("year", Integer.valueOf(ResHelper.parseInt(String.valueOf(((HashMap) map8.get("year")).get(Const.TableSchema.COLUMN_NAME)))));
                        } catch (Throwable th2) {
                            C0851d.m6195a().m8610d(th2);
                        }
                        map9.put("background", 0);
                        arrayList4.add(map9);
                        i2 = 0;
                    }
                    HashMap map11 = new HashMap();
                    map11.put("list", arrayList4);
                    String strFromHashMap = new Hashon().fromHashMap(map11);
                    map5.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                }
                ArrayList<HashMap> arrayList5 = map4.containsKey("work") ? (ArrayList) map4.get("work") : null;
                if (arrayList5 != null) {
                    ArrayList arrayList6 = new ArrayList();
                    for (HashMap map12 : arrayList5) {
                        HashMap map13 = new HashMap();
                        HashMap map14 = (HashMap) map12.get("employer");
                        if (map14 != null) {
                            map13.put("company", String.valueOf(map14.get(Const.TableSchema.COLUMN_NAME)));
                        }
                        HashMap map15 = (HashMap) map12.get("position");
                        if (map15 != null) {
                            map13.put("position", String.valueOf(map15.get(Const.TableSchema.COLUMN_NAME)));
                        }
                        try {
                            String[] strArrSplit2 = String.valueOf(map12.get("start_date")).split("-");
                            map13.put("start_date", Integer.valueOf((ResHelper.parseInt(strArrSplit2[0]) * 100) + ResHelper.parseInt(strArrSplit2[1])));
                        } catch (Throwable th3) {
                            C0851d.m6195a().m8610d(th3);
                        }
                        try {
                            String[] strArrSplit3 = String.valueOf(map12.get("end_date")).split("-");
                            map13.put("end_date", Integer.valueOf((ResHelper.parseInt(strArrSplit3[0]) * 100) + ResHelper.parseInt(strArrSplit3[1])));
                        } catch (Throwable th4) {
                            C0851d.m6195a().m8610d(th4);
                            map13.put("end_date", 0);
                        }
                        arrayList6.add(map13);
                    }
                    HashMap map16 = new HashMap();
                    map16.put("list", arrayList6);
                    String strFromHashMap2 = new Hashon().fromHashMap(map16);
                    map5.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                }
                arrayList.add(map5);
                map2 = null;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        map3.put("nextCursor", (iIntValue + arrayList.size()) + (iIntValue2 >= arrayList.size() ? "_true" : "_false"));
        map3.put("list", arrayList);
        return map3;
    }
}
