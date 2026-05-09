package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p003a.C0819a;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.g */
/* JADX INFO: compiled from: WXAuthHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0909g {

    /* JADX INFO: renamed from: a */
    private String f5934a;

    /* JADX INFO: renamed from: b */
    private String f5935b;

    /* JADX INFO: renamed from: c */
    private C0819a f5936c = C0819a.m5962a();

    /* JADX INFO: renamed from: d */
    private Platform f5937d;

    /* JADX INFO: renamed from: e */
    private int f5938e;

    public C0909g(Platform platform, int i) {
        this.f5937d = platform;
        this.f5938e = i;
    }

    /* JADX INFO: renamed from: a */
    public void m6561a(String str, String str2) {
        this.f5934a = str;
        this.f5935b = str2;
    }

    /* JADX INFO: renamed from: a */
    public void m6558a(Bundle bundle, AuthorizeListener authorizeListener) {
        String string = bundle.getString("_wxapi_sendauth_resp_url");
        if (TextUtils.isEmpty(string)) {
            if (authorizeListener != null) {
                authorizeListener.onError(null);
                return;
            }
            return;
        }
        int iIndexOf = string.indexOf("://oauth?");
        if (iIndexOf >= 0) {
            string = string.substring(iIndexOf + 1);
        }
        try {
            m6560a(ResHelper.urlToBundle(string).getString("code"), authorizeListener);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            if (authorizeListener != null) {
                authorizeListener.onError(th);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [cn.sharesdk.wechat.utils.g$1] */
    /* JADX INFO: renamed from: a */
    public void m6560a(final String str, final AuthorizeListener authorizeListener) {
        C0851d.m6195a().m8609d("getAuthorizeToken ==>> " + str, new Object[0]);
        new Thread() { // from class: cn.sharesdk.wechat.utils.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("appid", C0909g.this.f5934a));
                    arrayList.add(new KVPair<>("secret", C0909g.this.f5935b));
                    arrayList.add(new KVPair<>("code", str));
                    arrayList.add(new KVPair<>("grant_type", "authorization_code"));
                    try {
                        String strM5967a = C0909g.this.f5936c.m5967a("https://api.weixin.qq.com/sns/oauth2/access_token", arrayList, "/sns/oauth2/access_token", C0909g.this.f5938e);
                        if (TextUtils.isEmpty(strM5967a)) {
                            authorizeListener.onError(new Throwable("Authorize token is empty"));
                            return;
                        }
                        if (!strM5967a.contains("errcode")) {
                            C0909g.this.m6553a(strM5967a);
                            authorizeListener.onComplete(null);
                        } else if (authorizeListener != null) {
                            authorizeListener.onError(new Throwable(strM5967a));
                        }
                    } catch (Throwable th) {
                        authorizeListener.onError(th);
                    }
                } catch (Throwable th2) {
                    C0851d.m6195a().m8610d(th2);
                }
            }
        }.start();
    }

    /* JADX INFO: renamed from: a */
    public boolean m6562a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appid", this.f5934a));
        arrayList.add(new KVPair<>("refresh_token", this.f5937d.getDb().get("refresh_token")));
        arrayList.add(new KVPair<>("grant_type", "refresh_token"));
        try {
            String strM5967a = this.f5936c.m5967a("https://api.weixin.qq.com/sns/oauth2/refresh_token", arrayList, "/sns/oauth2/refresh_token", this.f5938e);
            if (TextUtils.isEmpty(strM5967a) || strM5967a.contains("errcode")) {
                return false;
            }
            m6553a(strM5967a);
            return true;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.wechat.utils.g$2] */
    /* JADX INFO: renamed from: a */
    public void m6559a(final PlatformActionListener platformActionListener) {
        new Thread() { // from class: cn.sharesdk.wechat.utils.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("access_token", C0909g.this.f5937d.getDb().getToken()));
                    arrayList.add(new KVPair<>("openid", C0909g.this.f5937d.getDb().get("openid")));
                    String strM5967a = C0909g.this.f5936c.m5967a("https://api.weixin.qq.com/sns/userinfo", arrayList, "/sns/userinfo", C0909g.this.f5938e);
                    if (TextUtils.isEmpty(strM5967a)) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(C0909g.this.f5937d, 8, new Throwable());
                            return;
                        }
                        return;
                    }
                    C0851d.m6195a().m8609d("getUserInfo ==>>" + strM5967a, new Object[0]);
                    HashMap<String, Object> mapFromJson = new Hashon().fromJson(strM5967a);
                    if (mapFromJson.containsKey("errcode") && ((Integer) mapFromJson.get("errcode")).intValue() != 0) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(C0909g.this.f5937d, 8, new Throwable(new Hashon().fromHashMap(mapFromJson)));
                            return;
                        }
                        return;
                    }
                    String strValueOf = String.valueOf(mapFromJson.get("openid"));
                    String strValueOf2 = String.valueOf(mapFromJson.get("nickname"));
                    try {
                        i = ResHelper.parseInt(String.valueOf(mapFromJson.get("sex")));
                    } catch (Throwable th) {
                        C0851d.m6195a().m8610d(th);
                        i = 2;
                    }
                    String strValueOf3 = String.valueOf(mapFromJson.get("province"));
                    String strValueOf4 = String.valueOf(mapFromJson.get("city"));
                    String strValueOf5 = String.valueOf(mapFromJson.get("country"));
                    String strValueOf6 = String.valueOf(mapFromJson.get("headimgurl"));
                    String strValueOf7 = String.valueOf(mapFromJson.get("unionid"));
                    C0909g.this.f5937d.getDb().put("nickname", strValueOf2);
                    if (i == 1) {
                        C0909g.this.f5937d.getDb().put("gender", "0");
                    } else if (i == 2) {
                        C0909g.this.f5937d.getDb().put("gender", "1");
                    } else {
                        C0909g.this.f5937d.getDb().put("gender", "2");
                    }
                    C0909g.this.f5937d.getDb().putUserId(strValueOf);
                    C0909g.this.f5937d.getDb().put("icon", strValueOf6);
                    C0909g.this.f5937d.getDb().put("province", strValueOf3);
                    C0909g.this.f5937d.getDb().put("city", strValueOf4);
                    C0909g.this.f5937d.getDb().put("country", strValueOf5);
                    C0909g.this.f5937d.getDb().put("openid", strValueOf);
                    C0909g.this.f5937d.getDb().put("unionid", strValueOf7);
                    platformActionListener.onComplete(C0909g.this.f5937d, 8, mapFromJson);
                } catch (Throwable th2) {
                    C0851d.m6195a().m8610d(th2);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6553a(String str) {
        C0851d.m6195a().m8609d("wechat getAuthorizeToken ==>>" + str, new Object[0]);
        HashMap mapFromJson = new Hashon().fromJson(str);
        String strValueOf = String.valueOf(mapFromJson.get("access_token"));
        String strValueOf2 = String.valueOf(mapFromJson.get("refresh_token"));
        String strValueOf3 = String.valueOf(mapFromJson.get("expires_in"));
        this.f5937d.getDb().put("openid", String.valueOf(mapFromJson.get("openid")));
        this.f5937d.getDb().putExpiresIn(Long.valueOf(strValueOf3).longValue());
        this.f5937d.getDb().putToken(strValueOf);
        this.f5937d.getDb().put("refresh_token", strValueOf2);
    }
}
