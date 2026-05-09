package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.AbstractC0827b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.AbstractC0825d;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0824c;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.p003a.C0819a;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyRequest;

/* JADX INFO: renamed from: cn.sharesdk.sina.weibo.d */
/* JADX INFO: compiled from: Weibo.java */
/* JADX INFO: loaded from: classes.dex */
public class C0870d extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static C0870d f5740b;

    /* JADX INFO: renamed from: c */
    private String f5741c;

    /* JADX INFO: renamed from: d */
    private String f5742d;

    /* JADX INFO: renamed from: e */
    private String f5743e;

    /* JADX INFO: renamed from: f */
    private String f5744f;

    /* JADX INFO: renamed from: g */
    private String[] f5745g;

    /* JADX INFO: renamed from: h */
    private C0819a f5746h;

    /* JADX INFO: renamed from: i */
    private Context f5747i;

    /* JADX INFO: renamed from: a */
    public static synchronized C0870d m6244a(Platform platform) {
        if (f5740b == null) {
            f5740b = new C0870d(platform);
        }
        return f5740b;
    }

    private C0870d(Platform platform) {
        super(platform);
        this.f5745g = new String[]{"follow_app_official_microblog"};
        this.f5746h = C0819a.m5962a();
        this.f5747i = platform.getContext();
    }

    /* JADX INFO: renamed from: a */
    public void m6259a(String str, String str2) {
        this.f5741c = str;
        this.f5742d = str2;
    }

    /* JADX INFO: renamed from: a */
    public void m6258a(String str) {
        this.f5743e = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6260a(String[] strArr) {
        this.f5745g = strArr;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0868b(c0826e);
    }

    @Override // cn.sharesdk.framework.AbstractC0827b, cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0825d getSSOProcessor(C0824c c0824c) {
        ServiceConnectionC0869c serviceConnectionC0869c = new ServiceConnectionC0869c(c0824c);
        serviceConnectionC0869c.m5985a(32973);
        serviceConnectionC0869c.m6242a(this.f5741c, this.f5743e, this.f5745g);
        return serviceConnectionC0869c;
    }

    /* JADX INFO: renamed from: a */
    public void m6257a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m5993b(authorizeListener);
        } else {
            m5992a(new SSOListener() { // from class: cn.sharesdk.sina.weibo.d.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0851d.m6195a().m8610d(th);
                    C0870d.this.m5993b(authorizeListener);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    try {
                        ResHelper.parseLong(bundle.getString("expires_in"));
                        authorizeListener.onComplete(bundle);
                    } catch (Throwable th) {
                        onFailed(th);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    authorizeListener.onCancel();
                }
            });
        }
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("client_id", this.f5741c));
        arrayList.add(new KVPair("response_type", "code"));
        arrayList.add(new KVPair("redirect_uri", this.f5743e));
        if (this.f5745g != null && this.f5745g.length > 0) {
            arrayList.add(new KVPair("scope", TextUtils.join(",", this.f5745g)));
        }
        arrayList.add(new KVPair("display", "mobile"));
        String str = "https://open.weibo.cn/oauth2/authorize?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList);
        ShareSDK.logApiEvent("/oauth2/authorize", m5994c());
        return str;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return TextUtils.isEmpty(this.f5743e) ? "https://api.weibo.com/oauth2/default.html" : this.f5743e;
    }

    /* JADX INFO: renamed from: a */
    public String m6252a(Context context, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("client_id", this.f5741c));
        arrayList.add(new KVPair<>("client_secret", this.f5742d));
        arrayList.add(new KVPair<>("redirect_uri", this.f5743e));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        arrayList.add(new KVPair<>("code", str));
        String strM5971b = this.f5746h.m5971b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", m5994c());
        ShareSDK.logApiEvent("/oauth2/access_token", m5994c());
        return strM5971b;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6261a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("client_id", this.f5741c));
        arrayList.add(new KVPair<>("client_secret", this.f5742d));
        arrayList.add(new KVPair<>("redirect_uri", this.f5743e));
        arrayList.add(new KVPair<>("grant_type", "refresh_token"));
        arrayList.add(new KVPair<>("refresh_token", this.f5563a.getDb().get("refresh_token")));
        try {
            String strM5971b = this.f5746h.m5971b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", m5994c());
            if (TextUtils.isEmpty(strM5971b) || strM5971b.contains("error") || strM5971b.contains("error_code")) {
                return false;
            }
            m6251e(strM5971b);
            return true;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6263b(String str) {
        this.f5744f = str;
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6266c(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        if (this.f5744f != null) {
            arrayList.add(new KVPair<>("access_token", this.f5744f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String strM5967a = this.f5746h.m5967a("https://api.weibo.com/2/users/show.json", arrayList, "/2/users/show.json", m5994c());
        if (strM5967a != null) {
            return new Hashon().fromJson(strM5967a);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m6264b() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.sina.weibo");
        intent.setType("image/*");
        ResolveInfo resolveInfoResolveActivity = this.f5563a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setPackage("com.sina.weibog3");
            intent2.setType("image/*");
            resolveInfoResolveActivity = this.f5563a.getContext().getPackageManager().resolveActivity(intent2, 0);
        }
        return resolveInfoResolveActivity != null;
    }

    /* JADX INFO: renamed from: a */
    public void m6256a(final Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) {
        if (shareParams.getImageData() == null && TextUtils.isEmpty(shareParams.getImagePath()) && !TextUtils.isEmpty(shareParams.getImageUrl())) {
            try {
                File file = new File(BitmapHelper.downloadBitmap(this.f5747i, shareParams.getImageUrl()));
                if (file.exists()) {
                    shareParams.setImagePath(file.getAbsolutePath());
                }
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
            }
        }
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            shareParams.setText(getPlatform().getShortLintk(text, false));
        }
        AuthorizeListener authorizeListener = new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.d.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th2) {
                if (platformActionListener != null) {
                    platformActionListener.onError(C0870d.this.f5563a, 9, th2);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                if (platformActionListener != null) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("ShareParams", shareParams);
                    platformActionListener.onComplete(C0870d.this.f5563a, 9, map);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (platformActionListener != null) {
                    platformActionListener.onCancel(C0870d.this.f5563a, 9);
                }
            }
        };
        C0867a c0867a = new C0867a();
        c0867a.m6231a(this.f5741c);
        c0867a.m6229a(shareParams);
        c0867a.m6230a(authorizeListener);
        c0867a.show(this.f5747i, null, true);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6254a(String str, String str2, String str3, float f, float f2) throws Throwable {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new Throwable("weibo content can not be null!");
        }
        if (!TextUtils.isEmpty(str3)) {
            return m6249b(str3, str, f, f2);
        }
        if (!TextUtils.isEmpty(str2)) {
            return m6246a(str, str2, f, f2);
        }
        return m6245a(str, f, f2);
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6246a(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        arrayList.add(new KVPair<>("access_token", this.f5744f));
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        arrayList.add(new KVPair<>("url", str2));
        String strM5971b = this.f5746h.m5971b("https://api.weibo.com/2/statuses/upload_url_text.json", arrayList, "/2/statuses/upload_url_text.json", m5994c());
        if (strM5971b != null) {
            return new Hashon().fromJson(strM5971b);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private HashMap<String, Object> m6249b(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        arrayList.add(new KVPair<>("access_token", this.f5744f));
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str2));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        String strM5964a = this.f5746h.m5964a("https://api.weibo.com/2/statuses/upload.json", arrayList, new KVPair<>("pic", str), "/2/statuses/upload.json", m5994c());
        if (strM5964a != null) {
            return new Hashon().fromJson(strM5964a);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6245a(String str, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        arrayList.add(new KVPair<>("access_token", this.f5744f));
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        arrayList.add(new KVPair<>("long", String.valueOf(f)));
        arrayList.add(new KVPair<>("lat", String.valueOf(f2)));
        String strM5971b = this.f5746h.m5971b("https://api.weibo.com/2/statuses/update.json", arrayList, "/2/statuses/update.json", m5994c());
        if (strM5971b != null) {
            return new Hashon().fromJson(strM5971b);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6268d(String str) {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        arrayList.add(new KVPair<>("access_token", this.f5744f));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String strM5971b = this.f5746h.m5971b("https://api.weibo.com/2/friendships/create.json", arrayList, "/2/friendships/create.json", m5994c());
        if (strM5971b != null) {
            return new Hashon().fromJson(strM5971b);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6253a(int i, int i2, String str) {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("page", String.valueOf(i2)));
        String strM5967a = this.f5746h.m5967a("https://api.weibo.com/2/statuses/user_timeline.json", arrayList, "/2/statuses/user_timeline.json", m5994c());
        if (strM5967a != null) {
            return new Hashon().fromJson(strM5967a);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6262b(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        if (this.f5744f != null) {
            arrayList.add(new KVPair<>("access_token", this.f5744f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i2)));
        String strM5967a = this.f5746h.m5967a("https://api.weibo.com/2/friendships/friends.json", arrayList, "/2/friendships/friends.json", m5994c());
        if (strM5967a != null) {
            return new Hashon().fromJson(strM5967a);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6265c(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        if (this.f5744f != null) {
            arrayList.add(new KVPair<>("access_token", this.f5744f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("page", String.valueOf(i2)));
        String strM5967a = this.f5746h.m5967a("https://api.weibo.com/2/friendships/friends/bilateral.json", arrayList, "/2/friendships/friends/bilateral.json", m5994c());
        if (strM5967a != null) {
            return new Hashon().fromJson(strM5967a);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6267d(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.f5741c));
        if (this.f5744f != null) {
            arrayList.add(new KVPair<>("access_token", this.f5744f));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i2)));
        String strM5967a = this.f5746h.m5967a("https://api.weibo.com/2/friendships/followers.json", arrayList, "/2/friendships/followers.json", m5994c());
        if (strM5967a != null) {
            return new Hashon().fromJson(strM5967a);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6255a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) {
        KVPair<String> kVPair;
        String strHttpPost;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair<>("source", this.f5741c));
        if (this.f5744f != null) {
            arrayList.add(new KVPair<>("access_token", this.f5744f));
        }
        if (map2 == null || map2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair<String> kVPair2 = null;
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                kVPair2 = new KVPair<>(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        try {
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
            strHttpPost = new NetworkHelper().httpGet(str, arrayList, null, null);
        } else {
            strHttpPost = SpdyRequest.POST_METHOD.equals(str2.toUpperCase()) ? new NetworkHelper().httpPost(str, arrayList, kVPair, null, null) : null;
        }
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    /* JADX INFO: renamed from: e */
    private void m6251e(String str) {
        HashMap mapFromJson = new Hashon().fromJson(str);
        String strValueOf = String.valueOf(mapFromJson.get("uid"));
        String strValueOf2 = String.valueOf(mapFromJson.get("expires_in"));
        String strValueOf3 = String.valueOf(mapFromJson.get("access_token"));
        String strValueOf4 = String.valueOf(mapFromJson.get("refresh_token"));
        String strValueOf5 = String.valueOf(mapFromJson.get("remind_in"));
        this.f5563a.getDb().putUserId(strValueOf);
        this.f5563a.getDb().putExpiresIn(Long.valueOf(strValueOf2).longValue());
        this.f5563a.getDb().putToken(strValueOf3);
        this.f5563a.getDb().put("refresh_token", strValueOf4);
        this.f5563a.getDb().put("remind_in", strValueOf5);
    }
}
