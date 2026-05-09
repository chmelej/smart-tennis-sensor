package cn.sharesdk.tencent.weibo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.AbstractC0827b;
import cn.sharesdk.framework.Platform;
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
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyRequest;
import org.litepal.util.Const;

/* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.f */
/* JADX INFO: compiled from: Weibo.java */
/* JADX INFO: loaded from: classes.dex */
public class C0894f extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static C0894f f5880b;

    /* JADX INFO: renamed from: c */
    private C0891c f5881c;

    /* JADX INFO: renamed from: d */
    private C0819a f5882d;

    /* JADX INFO: renamed from: a */
    public static C0894f m6454a(Platform platform) {
        if (f5880b == null) {
            f5880b = new C0894f(platform);
        }
        return f5880b;
    }

    private C0894f(Platform platform) {
        super(platform);
        this.f5881c = new C0891c();
        this.f5882d = C0819a.m5962a();
    }

    /* JADX INFO: renamed from: a */
    public void m6463a(String str, String str2) {
        this.f5881c.f5863a = str;
        this.f5881c.f5864b = str2;
    }

    /* JADX INFO: renamed from: a */
    public void m6462a(String str) {
        this.f5881c.f5865c = str;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0892d(c0826e);
    }

    @Override // cn.sharesdk.framework.AbstractC0827b, cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0825d getSSOProcessor(C0824c c0824c) {
        C0893e c0893e = new C0893e(c0824c);
        c0893e.m6452a(this.f5881c);
        return c0893e;
    }

    /* JADX INFO: renamed from: a */
    public void m6461a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m5993b(authorizeListener);
        } else {
            m5992a(new SSOListener() { // from class: cn.sharesdk.tencent.weibo.f.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0851d.m6195a().m8610d(th);
                    C0894f.this.m5993b(authorizeListener);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("access_token", C0894f.this.f5881c.f5866d);
                    bundle2.putString("expires_in", String.valueOf(C0894f.this.f5881c.f5870h));
                    bundle2.putString("openid", String.valueOf(C0894f.this.f5881c.f5868f));
                    bundle2.putString(Const.TableSchema.COLUMN_NAME, String.valueOf(C0894f.this.f5881c.f5867e));
                    bundle2.putString("nick", String.valueOf(C0894f.this.f5881c.f5867e));
                    authorizeListener.onComplete(bundle2);
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
        ShareSDK.logApiEvent("/cgi-bin/oauth2/authorize", m5994c());
        return "https://open.t.qq.com/cgi-bin/oauth2/authorize?client_id=" + this.f5881c.f5863a + "&response_type=code&redirect_uri=" + this.f5881c.f5865c;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f5881c.f5865c;
    }

    /* JADX INFO: renamed from: b */
    public Bundle m6466b(String str) {
        String strM5967a = this.f5882d.m5967a("https://open.t.qq.com/cgi-bin/oauth2/access_token?client_id=" + this.f5881c.f5863a + "&client_secret=" + this.f5881c.f5864b + "&redirect_uri=" + this.f5881c.f5865c + "&grant_type=authorization_code&code=" + str, null, "/cgi-bin/oauth2/access_token", m5994c());
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return ResHelper.urlToBundle("http://open.t.qq.com?" + strM5967a);
    }

    /* JADX INFO: renamed from: a */
    public void m6464a(String str, String str2, String str3, String str4) {
        this.f5881c.f5866d = str;
        this.f5881c.f5867e = str2;
        this.f5881c.f5868f = str3;
        this.f5881c.f5869g = str4;
    }

    /* JADX INFO: renamed from: a */
    private void m6456a(ArrayList<KVPair<String>> arrayList) {
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5881c.f5863a));
        arrayList.add(new KVPair<>("access_token", this.f5881c.f5866d));
        arrayList.add(new KVPair<>("openid", this.f5881c.f5868f));
        arrayList.add(new KVPair<>("clientip", "127.0.0.1"));
        arrayList.add(new KVPair<>("oauth_version", "2.a"));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("scope", "all"));
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6469c(String str) {
        String str2 = "/api/user/info";
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        if (str != null) {
            str2 = "/api/user/other_info";
            arrayList.add(new KVPair<>(Const.TableSchema.COLUMN_NAME, str));
        }
        String strM5967a = this.f5882d.m5967a("https://open.t.qq.com" + str2, arrayList, str2, m5994c());
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5967a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6458a(String str, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>("content", str));
        if (f != 0.0f && f2 != 0.0f) {
            arrayList.add(new KVPair<>("latitude", String.valueOf(f)));
            arrayList.add(new KVPair<>("longitude", String.valueOf(f2)));
        }
        String strM5971b = this.f5882d.m5971b("https://open.t.qq.com/api/t/add", arrayList, "/api/t/add", m5994c());
        if (strM5971b == null || strM5971b.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5971b);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6459a(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>("content", str));
        arrayList.add(new KVPair<>("pic_url", str2));
        if (f != 0.0f && f2 != 0.0f) {
            arrayList.add(new KVPair<>("longitude", String.valueOf(f2)));
            arrayList.add(new KVPair<>("latitude", String.valueOf(f)));
        }
        String strM5971b = this.f5882d.m5971b("https://open.t.qq.com/api/t/add_pic_url", arrayList, "/api/t/add_pic_url", m5994c());
        if (strM5971b == null || strM5971b.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5971b);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6468b(String str, String str2, float f, float f2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>("content", str));
        KVPair<String> kVPair = new KVPair<>("pic", str2);
        if (f != 0.0f && f2 != 0.0f) {
            arrayList.add(new KVPair<>("longitude", String.valueOf(f2)));
            arrayList.add(new KVPair<>("latitude", String.valueOf(f)));
        }
        String strM5964a = this.f5882d.m5964a("https://open.t.qq.com/api/t/add_pic", arrayList, kVPair, "/api/t/add_pic", m5994c());
        if (strM5964a == null || strM5964a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5964a);
    }

    /* JADX INFO: renamed from: d */
    public String m6470d(String str) throws Throwable {
        KVPair<String> kVPair;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            arrayList.add(new KVPair<>("pic_url", str));
            arrayList.add(new KVPair<>("pic_type", "1"));
            kVPair = null;
        } else {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return null;
            }
            KVPair<String> kVPair2 = new KVPair<>("pic", str);
            arrayList.add(new KVPair<>("pic_type", "2"));
            kVPair = kVPair2;
        }
        String strM5964a = this.f5882d.m5964a("https://open.t.qq.com/api/t/upload_pic", arrayList, kVPair, "/api/t/upload_pic", m5994c());
        if (strM5964a != null && strM5964a.length() > 0) {
            HashMap mapFromJson = new Hashon().fromJson(strM5964a);
            if (mapFromJson.containsKey("ret")) {
                if (((Integer) mapFromJson.get("ret")).intValue() == 0) {
                    return (String) ((HashMap) mapFromJson.get("data")).get("imgurl");
                }
                String str2 = "tecent weibo uploadPic == " + str + " == error " + mapFromJson.get(NotificationCompat.CATEGORY_MESSAGE) + "(" + ((Integer) mapFromJson.get("errcode")).intValue() + ")";
                C0851d.m6195a().m8609d(str2, new Object[0]);
                throw new Throwable(str2);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public HashMap<String, Object> m6471e(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>(Const.TableSchema.COLUMN_NAME, str));
        String strM5971b = this.f5882d.m5971b("https://open.t.qq.com/api/friends/add", arrayList, "/api/friends/add", m5994c());
        if (strM5971b == null || strM5971b.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5971b);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6457a(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>("reqnum", String.valueOf(i)));
        arrayList.add(new KVPair<>("startindex", String.valueOf(i2)));
        arrayList.add(new KVPair<>(Const.TableSchema.COLUMN_NAME, str));
        arrayList.add(new KVPair<>("mode", "0"));
        String strM5967a = this.f5882d.m5967a("https://open.t.qq.com/api/friends/user_idollist", arrayList, "/api/friends/user_idollist", m5994c());
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5967a);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6467b(int i, int i2, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        m6456a(arrayList);
        arrayList.add(new KVPair<>("reqnum", String.valueOf(i)));
        arrayList.add(new KVPair<>("startindex", String.valueOf(i2)));
        arrayList.add(new KVPair<>(Const.TableSchema.COLUMN_NAME, str));
        arrayList.add(new KVPair<>("mode", "0"));
        String strM5967a = this.f5882d.m5967a("https://open.t.qq.com/api/friends/user_fanslist", arrayList, "/api/friends/user_fanslist", m5994c());
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5967a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6460a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) {
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
        m6456a(arrayList);
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

    /* JADX INFO: renamed from: a */
    public boolean m6465a() {
        PackageManager packageManager = this.f5563a.getContext().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.WBlog", 16);
            if (packageInfo != null && packageInfo.versionCode >= 44) {
                if (packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("TencentAuth://weibo")), 65536).size() > 0) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
