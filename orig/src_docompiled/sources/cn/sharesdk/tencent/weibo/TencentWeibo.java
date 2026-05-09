package cn.sharesdk.tencent.weibo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class TencentWeibo extends Platform {
    public static final String NAME = "TencentWeibo";

    /* JADX INFO: renamed from: a */
    private String f5847a;

    /* JADX INFO: renamed from: b */
    private String f5848b;

    /* JADX INFO: renamed from: c */
    private String f5849c;

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
    public HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    public TencentWeibo(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f5847a = getDevinfo("AppKey");
        this.f5848b = getDevinfo("AppSecret");
        this.f5849c = getDevinfo("RedirectUri");
        if (this.f5849c == null || this.f5849c.length() <= 0) {
            this.f5849c = getDevinfo("RedirectUrl");
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f5847a = getNetworkDevinfo("app_key", "AppKey");
        this.f5848b = getNetworkDevinfo("app_secret", "AppSecret");
        this.f5849c = getNetworkDevinfo("redirect_uri", "RedirectUri");
        if (this.f5849c == null || this.f5849c.length() <= 0) {
            this.f5849c = getDevinfo("RedirectUrl");
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return C0894f.m6454a(this).m6465a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0894f c0894fM6454a = C0894f.m6454a(this);
        c0894fM6454a.m6463a(this.f5847a, this.f5848b);
        c0894fM6454a.m6462a(this.f5849c);
        c0894fM6454a.m6461a(new AuthorizeListener() { // from class: cn.sharesdk.tencent.weibo.TencentWeibo.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (TencentWeibo.this.listener != null) {
                    TencentWeibo.this.listener.onError(TencentWeibo.this, 1, th);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                int i;
                TencentWeibo.this.f5513db.putToken(bundle.getString("access_token"));
                TencentWeibo.this.f5513db.putTokenSecret("");
                try {
                    i = ResHelper.parseInt(bundle.getString("expires_in"));
                } catch (Throwable unused) {
                    i = 0;
                }
                TencentWeibo.this.f5513db.putExpiresIn(i);
                TencentWeibo.this.f5513db.putUserId(bundle.getString("openid"));
                TencentWeibo.this.f5513db.put(Const.TableSchema.COLUMN_NAME, bundle.getString(Const.TableSchema.COLUMN_NAME));
                TencentWeibo.this.f5513db.put("nick", bundle.getString("nick"));
                TencentWeibo.this.f5513db.put("openid", bundle.getString("openid"));
                TencentWeibo.this.f5513db.put("openkey", bundle.getString("openkey"));
                c0894fM6454a.m6464a(TencentWeibo.this.f5513db.getToken(), TencentWeibo.this.f5513db.get(Const.TableSchema.COLUMN_NAME), TencentWeibo.this.f5513db.getUserId(), TencentWeibo.this.f5513db.get("openkey"));
                TencentWeibo.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (TencentWeibo.this.listener != null) {
                    TencentWeibo.this.listener.onCancel(TencentWeibo.this, 1);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        if (isAuthValid()) {
            C0894f c0894fM6454a = C0894f.m6454a(this);
            c0894fM6454a.m6463a(this.f5847a, this.f5848b);
            c0894fM6454a.m6462a(this.f5849c);
            c0894fM6454a.m6464a(this.f5513db.getToken(), this.f5513db.get(Const.TableSchema.COLUMN_NAME), this.f5513db.getUserId(), this.f5513db.get("openkey"));
            return true;
        }
        innerAuthorize(i, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        Throwable th;
        long jCurrentTimeMillis;
        int length;
        String str;
        String string;
        int i;
        int i2;
        HashMap<String, Object> mapM6458a;
        int iIntValue;
        String str2;
        String[] strArr;
        String strM6470d;
        int stringRes;
        String text = shareParams.getText();
        if (TextUtils.isEmpty(text) && (stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_upload_content")) > 0) {
            text = getContext().getString(stringRes);
            shareParams.setText(text);
        }
        C0894f c0894fM6454a = C0894f.m6454a(this);
        String shortLintk = getShortLintk(text, false);
        shareParams.setText(shortLintk);
        String imageUrl = shareParams.getImageUrl();
        float latitude = shareParams.getLatitude();
        float longitude = shareParams.getLongitude();
        String imagePath = shareParams.getImagePath();
        String[] imageArray = shareParams.getImageArray();
        if (imageArray == null) {
            imageArray = new String[0];
        }
        String str3 = "";
        int i3 = 9;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            length = imageArray.length;
            str = "";
            string = "";
            i = 0;
            i2 = 0;
        } catch (Throwable th2) {
            th = th2;
        }
        while (i < length) {
            int i4 = length;
            try {
                String str4 = imageArray[i];
                if (i2 >= i3) {
                    break;
                }
                try {
                    strM6470d = c0894fM6454a.m6470d(str4);
                    strArr = imageArray;
                } catch (Throwable th3) {
                    StringBuilder sb = new StringBuilder();
                    str2 = string;
                    try {
                        sb.append(str2);
                        strArr = imageArray;
                        sb.append(th3.getMessage());
                        sb.append("\n");
                        string = sb.toString();
                        strM6470d = null;
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        str3 = str2;
                    }
                }
                try {
                    if (!TextUtils.isEmpty(strM6470d)) {
                        i2++;
                        str = str + "," + strM6470d;
                    }
                    i++;
                    length = i4;
                    imageArray = strArr;
                    i3 = 9;
                } catch (Throwable th5) {
                    th = th5;
                    str3 = string;
                }
            } catch (Throwable th6) {
                th = th6;
                str2 = string;
            }
            th = th;
            str3 = str2;
            if (this.listener != null) {
                this.listener.onError(this, 9, new Throwable(th.getMessage() + "\n" + str3));
                return;
            }
            return;
        }
        String str5 = string;
        String str6 = str;
        try {
            NLog nLogM6195a = C0851d.m6195a();
            Object[] objArr = new Object[1];
            try {
                objArr[0] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                nLogM6195a.m8615i("upload pic use total time ===>>> %s ", objArr);
                try {
                    if (!TextUtils.isEmpty(str6)) {
                        String strSubstring = str6.substring(1);
                        mapM6458a = c0894fM6454a.m6459a(shortLintk, strSubstring, latitude, longitude);
                        str6 = strSubstring;
                    } else if (!TextUtils.isEmpty(imageUrl)) {
                        mapM6458a = c0894fM6454a.m6459a(shortLintk, imageUrl, latitude, longitude);
                    } else if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                        mapM6458a = c0894fM6454a.m6458a(shortLintk, latitude, longitude);
                    } else {
                        mapM6458a = c0894fM6454a.m6468b(shortLintk, imagePath, latitude, longitude);
                    }
                    if (mapM6458a == null) {
                        if (this.listener != null) {
                            this.listener.onError(this, 9, new Throwable(" response is null\n" + str5));
                            return;
                        }
                        return;
                    }
                    if (mapM6458a.containsKey("errcode") && (iIntValue = ((Integer) mapM6458a.get("errcode")).intValue()) != 0) {
                        C0851d.m6195a().m8615i("tecent weibo error %s", mapM6458a.get(NotificationCompat.CATEGORY_MESSAGE) + "(" + iIntValue + ")");
                        if (this.listener != null) {
                            this.listener.onError(this, 9, new Throwable(new Hashon().fromHashMap(mapM6458a)));
                            return;
                        }
                        return;
                    }
                    Object obj = mapM6458a.get("imgurl");
                    if (obj == null && !TextUtils.isEmpty(str6)) {
                        imageUrl = str6;
                    } else if (obj != null || TextUtils.isEmpty(imageUrl)) {
                        imageUrl = obj == null ? "" : obj;
                    }
                    HashMap<String, Object> map = (HashMap) mapM6458a.get("data");
                    if (map == null) {
                        if (this.listener != null) {
                            this.listener.onError(this, 9, new Throwable(str5));
                        }
                    } else {
                        map.put("imgurl", imageUrl);
                        map.put("ShareParams", shareParams);
                        if (this.listener != null) {
                            this.listener.onComplete(this, 9, map);
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str3 = str5;
                }
            } catch (Throwable th8) {
                th = th8;
                str3 = str5;
                th = th;
            }
        } catch (Throwable th9) {
            th = th9;
            str3 = str5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        try {
            HashMap<String, Object> mapM6471e = C0894f.m6454a(this).m6471e(str);
            if (mapM6471e == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 6, new Throwable(" response is null"));
                }
            } else {
                if (mapM6471e.containsKey("errcode") && ((Integer) mapM6471e.get("errcode")).intValue() != 0) {
                    String strFromHashMap = new Hashon().fromHashMap(mapM6471e);
                    if (this.listener != null) {
                        this.listener.onError(this, 6, new Throwable(strFromHashMap));
                        return;
                    }
                    return;
                }
                HashMap<String, Object> map = (HashMap) mapM6471e.get("data");
                if (map != null) {
                    mapM6471e = map;
                }
                if (this.listener != null) {
                    this.listener.onComplete(this, 6, mapM6471e);
                }
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 6, th);
            }
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
            HashMap<String, Object> mapM6469c = C0894f.m6454a(this).m6469c(str);
            if (mapM6469c == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(" response is null"));
                    return;
                }
                return;
            }
            if (mapM6469c.containsKey("errcode") && ((Integer) mapM6469c.get("errcode")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapM6469c)));
                    return;
                }
                return;
            }
            HashMap<String, Object> map = (HashMap) mapM6469c.get("data");
            if (map == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable());
                    return;
                }
                return;
            }
            if (str == null) {
                this.f5513db.put("nickname", String.valueOf(map.get("nick")));
                this.f5513db.put("icon", String.valueOf(map.get("head")) + "/100");
                this.f5513db.put("secretType", String.valueOf(map.get("isvip")));
                this.f5513db.put("secret", String.valueOf(map.get("verifyinfo")));
                String strValueOf = String.valueOf(map.get("sex"));
                if ("1".equals(strValueOf)) {
                    this.f5513db.put("gender", "0");
                } else if ("2".equals(strValueOf)) {
                    this.f5513db.put("gender", "1");
                } else {
                    this.f5513db.put("gender", "2");
                }
                String strValueOf2 = String.valueOf(map.get("birth_year"));
                String strValueOf3 = String.valueOf(map.get("birth_month"));
                String strValueOf4 = String.valueOf(map.get("birth_day"));
                if (!TextUtils.isEmpty(strValueOf2) && !TextUtils.isEmpty(strValueOf3) && !TextUtils.isEmpty(strValueOf4)) {
                    this.f5513db.put("birthday", String.valueOf(ResHelper.dateStrToLong(strValueOf2 + "-" + strValueOf3 + "-" + strValueOf4)));
                }
                this.f5513db.put("snsUserUrl", "http://t.qq.com/" + String.valueOf(map.get(Const.TableSchema.COLUMN_NAME)));
                this.f5513db.put("resume", String.valueOf(map.get("introduction")));
                this.f5513db.put("followerCount", String.valueOf(map.get("fansnum")));
                this.f5513db.put("favouriteCount", String.valueOf(map.get("idolnum")));
                this.f5513db.put("shareCount", String.valueOf(map.get("tweetnum")));
                this.f5513db.put("snsregat", String.valueOf(map.get("regtime")));
                this.f5513db.put("snsUserLevel", String.valueOf(map.get("level")));
                ArrayList arrayList = (ArrayList) map.get("edu");
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("school_type", 0);
                            jSONObject.put("school", String.valueOf(((HashMap) arrayList.get(i)).get("schoolid")));
                            jSONObject.put("classes", String.valueOf(((HashMap) arrayList.get(i)).get("departmentid")));
                            jSONObject.put("background", 0);
                            try {
                                jSONObject.put("year", (Integer) ((HashMap) arrayList.get(i)).get("year"));
                            } catch (Throwable th) {
                                C0851d.m6195a().m8610d(th);
                                jSONObject.put("year", 0);
                            }
                        } catch (JSONException e) {
                            C0851d.m6195a().m8610d(e);
                        }
                        jSONArray.put(jSONObject);
                    }
                    if (jSONArray.length() > 0) {
                        this.f5513db.put("educationJSONArrayStr", jSONArray.toString());
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                ArrayList arrayList2 = (ArrayList) map.get("comp");
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("company", String.valueOf(((HashMap) arrayList2.get(i2)).get("company_name")));
                            jSONObject2.put("dept", String.valueOf(((HashMap) arrayList2.get(i2)).get("department_name")));
                            try {
                                jSONObject2.put("start_date", ((Integer) ((HashMap) arrayList2.get(i2)).get("begin_year")).intValue() * 100);
                            } catch (Throwable th2) {
                                C0851d.m6195a().m8610d(th2);
                                jSONObject2.put("start_date", 0);
                            }
                            try {
                                int iIntValue = ((Integer) ((HashMap) arrayList2.get(i2)).get("end_year")).intValue();
                                if (iIntValue >= 9999) {
                                    iIntValue = 0;
                                }
                                jSONObject2.put("end_date", iIntValue * 100);
                            } catch (Throwable th3) {
                                C0851d.m6195a().m8610d(th3);
                                jSONObject2.put("end_date", 0);
                            }
                        } catch (JSONException e2) {
                            C0851d.m6195a().m8610d(e2);
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    if (jSONArray2.length() > 0) {
                        this.f5513db.put("workJSONArrayStr", jSONArray2.toString());
                    }
                }
            }
            if (this.listener != null) {
                this.listener.onComplete(this, 8, map);
            }
        } catch (Throwable th4) {
            if (this.listener != null) {
                this.listener.onError(this, 8, th4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        C0894f c0894fM6454a = C0894f.m6454a(this);
        if (str == null) {
            try {
                str = this.f5513db.get(Const.TableSchema.COLUMN_NAME);
            } catch (Throwable th) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, th);
                    return;
                }
                return;
            }
        }
        HashMap<String, Object> mapM6457a = c0894fM6454a.m6457a(i, i2 * i, str);
        if (mapM6457a == null) {
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable("response is null"));
                return;
            }
            return;
        }
        if (mapM6457a.containsKey("errcode") && ((Integer) mapM6457a.get("errcode")).intValue() != 0) {
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapM6457a)));
                return;
            }
            return;
        }
        HashMap<String, Object> map = (HashMap) mapM6457a.get("data");
        if (map == null) {
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable());
            }
        } else if (this.listener != null) {
            this.listener.onComplete(this, 2, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2) {
        HashMap<String, Object> mapM6460a = C0894f.m6454a(this).m6460a(str, str2, map, map2);
        if (mapM6460a == null) {
            if (this.listener != null) {
                this.listener.onError(this, i, new Throwable("response is null"));
            }
        } else {
            if (mapM6460a.containsKey("errcode") && ((Integer) mapM6460a.get("errcode")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(mapM6460a)));
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onComplete(this, i, mapM6460a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        aVar.f5621b = shareParams.getText();
        if (map != null) {
            String str = (String) map.get("imgurl");
            if (!TextUtils.isEmpty(str)) {
                aVar.f5623d.add(str);
            }
            aVar.f5620a = String.valueOf(map.get("id"));
        }
        aVar.f5626g = map;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        C0894f c0894fM6454a = C0894f.m6454a(this);
        if (str == null) {
            try {
                str = this.f5513db.get(Const.TableSchema.COLUMN_NAME);
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
                return null;
            }
        }
        HashMap<String, Object> mapM6457a = c0894fM6454a.m6457a(i, i2, str);
        if (mapM6457a == null) {
            return null;
        }
        if (mapM6457a.containsKey("errcode") && ((Integer) mapM6457a.get("errcode")).intValue() != 0) {
            C0851d.m6195a().m8610d(new Throwable(new Hashon().fromHashMap(mapM6457a)));
        }
        HashMap<String, Object> map = (HashMap) mapM6457a.get("data");
        if (map == null) {
            return null;
        }
        map.put("current_cursor", Integer.valueOf(i2));
        return filterFriendshipInfo(2, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i, int i2, String str) {
        C0894f c0894fM6454a = C0894f.m6454a(this);
        if (str == null) {
            try {
                str = this.f5513db.get(Const.TableSchema.COLUMN_NAME);
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
                return null;
            }
        }
        HashMap<String, Object> mapM6467b = c0894fM6454a.m6467b(i, i2, str);
        if (mapM6467b == null) {
            return null;
        }
        if (mapM6467b.containsKey("errcode") && ((Integer) mapM6467b.get("errcode")).intValue() != 0) {
            C0851d.m6195a().m8610d(new Throwable(new Hashon().fromHashMap(mapM6467b)));
        }
        HashMap<String, Object> map = (HashMap) mapM6467b.get("data");
        if (map == null) {
            return null;
        }
        map.put("current_cursor", Integer.valueOf(i2));
        return filterFriendshipInfo(11, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        Object obj;
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
        map2.put("snsuid", this.f5513db.get(Const.TableSchema.COLUMN_NAME));
        int i2 = map.containsKey("curnum") ? Integer.parseInt(String.valueOf(map.get("curnum"))) : 0;
        int i3 = map.containsKey("nextstartpos") ? Integer.parseInt(String.valueOf(map.get("nextstartpos"))) : 0;
        if (i2 == 0 || (obj = map.get("info")) == null) {
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
                map4.put("snsuid", String.valueOf(map3.get(Const.TableSchema.COLUMN_NAME)));
                map4.put("nickname", String.valueOf(map3.get("nick")));
                String strValueOf = map3.containsKey("head") ? String.valueOf(map3.get("head")) : null;
                if (!TextUtils.isEmpty(strValueOf)) {
                    map4.put("icon", strValueOf + "/100");
                }
                map4.put("secretType", String.valueOf(map3.get("isvip")));
                String strValueOf2 = String.valueOf(map3.get("sex"));
                if ("1".equals(strValueOf2)) {
                    map4.put("gender", "0");
                } else if ("2".equals(strValueOf2)) {
                    map4.put("gender", "1");
                } else {
                    map4.put("gender", "2");
                }
                map4.put("snsUserUrl", "http://t.qq.com/" + String.valueOf(map3.get(Const.TableSchema.COLUMN_NAME)));
                map4.put("followerCount", String.valueOf(map3.get("fansnum")));
                map4.put("favouriteCount", String.valueOf(map3.get("idolnum")));
                arrayList.add(map4);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        String str = i3 + "_false";
        if (i3 == 0) {
            str = "0_true";
        }
        map2.put("nextCursor", str);
        map2.put("list", arrayList);
        return map2;
    }
}
