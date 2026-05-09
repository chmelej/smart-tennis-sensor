package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
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
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyRequest;

/* JADX INFO: renamed from: cn.sharesdk.facebook.d */
/* JADX INFO: compiled from: FbHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0815d extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static final String[] f5491b = {"user_about_me", "user_birthday", "user_photos", "publish_actions", "user_friends"};

    /* JADX INFO: renamed from: c */
    private static C0815d f5492c;

    /* JADX INFO: renamed from: d */
    private String f5493d;

    /* JADX INFO: renamed from: e */
    private String f5494e;

    /* JADX INFO: renamed from: f */
    private long f5495f;

    /* JADX INFO: renamed from: g */
    private String f5496g;

    /* JADX INFO: renamed from: h */
    private C0819a f5497h;

    /* JADX INFO: renamed from: i */
    private String[] f5498i;

    /* JADX INFO: renamed from: j */
    private String f5499j;

    /* JADX INFO: renamed from: a */
    public static C0815d m5910a(Platform platform) {
        if (f5492c == null) {
            f5492c = new C0815d(platform);
        }
        return f5492c;
    }

    private C0815d(Platform platform) {
        super(platform);
        this.f5497h = C0819a.m5962a();
    }

    /* JADX INFO: renamed from: a */
    public void m5916a(String str) {
        this.f5496g = str;
    }

    /* JADX INFO: renamed from: a */
    public void m5917a(String str, String str2) {
        this.f5494e = str;
        if (str2 == null || str2.equals("0")) {
            return;
        }
        try {
            this.f5495f = System.currentTimeMillis() + ((long) (ResHelper.parseInt(str2) * 1000));
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m5919a() {
        return this.f5494e != null && (this.f5495f == 0 || System.currentTimeMillis() < this.f5495f);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        Bundle bundle = new Bundle();
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", this.f5499j);
        bundle.putString("type", "user_agent");
        String[] strArr = this.f5498i == null ? f5491b : this.f5498i;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(str);
            i++;
        }
        bundle.putString("scope", sb.toString());
        bundle.putString("client_id", this.f5496g);
        bundle.putString("response_type", "code");
        this.f5493d = "https://www.facebook.com/dialog/oauth?" + ResHelper.encodeUrl(bundle);
        ShareSDK.logApiEvent("/dialog/oauth", m5994c());
        return this.f5493d;
    }

    /* JADX INFO: renamed from: a */
    public void m5918a(String[] strArr) {
        this.f5498i = strArr;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0814c(c0826e);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f5499j;
    }

    /* JADX INFO: renamed from: b */
    public boolean m5922b() {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f5496g);
        if (this.f5498i != null && this.f5498i.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", this.f5498i));
        }
        ResolveInfo resolveInfoResolveActivity = getPlatform().getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null) {
            return false;
        }
        try {
            for (Signature signature : getPlatform().getContext().getPackageManager().getPackageInfo(resolveInfoResolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(signature.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // cn.sharesdk.framework.AbstractC0827b, cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0825d getSSOProcessor(C0824c c0824c) {
        C0813b c0813b = new C0813b(c0824c);
        c0813b.m5985a(32525);
        c0813b.m5907a(this.f5496g, this.f5498i == null ? f5491b : this.f5498i);
        return c0813b;
    }

    /* JADX INFO: renamed from: a */
    public void m5915a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m5993b(authorizeListener);
        } else {
            m5992a(new SSOListener() { // from class: cn.sharesdk.facebook.d.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0851d.m6195a().m8610d(th);
                    C0815d.this.m5993b(authorizeListener);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    authorizeListener.onComplete(bundle);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    authorizeListener.onCancel();
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5914a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        String imageUrl = shareParams.getImageUrl();
        String title = shareParams.getTitle();
        String text = shareParams.getText();
        String musicUrl = shareParams.getMusicUrl();
        String url = shareParams.getUrl();
        String titleUrl = shareParams.getTitleUrl();
        if (!TextUtils.isEmpty(titleUrl)) {
            titleUrl = this.f5563a.getShortLintk(titleUrl, false);
            shareParams.setTitleUrl(titleUrl);
        } else if (!TextUtils.isEmpty(url)) {
            titleUrl = this.f5563a.getShortLintk(url, false);
            shareParams.setUrl(titleUrl);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.facebook.com/dialog/feed?");
        sb.append("app_id=");
        sb.append(this.f5496g);
        sb.append("&redirect_uri=fbconnect://success");
        sb.append("&link=");
        sb.append(Data.urlEncode(titleUrl, "utf-8"));
        if (!TextUtils.isEmpty(imageUrl)) {
            sb.append("&picture=");
            sb.append(Data.urlEncode(imageUrl, "utf-8"));
        }
        if (!TextUtils.isEmpty(title)) {
            sb.append("&caption=");
            sb.append(Data.urlEncode(title, "utf-8"));
        }
        if (!TextUtils.isEmpty(text)) {
            sb.append("&description=");
            sb.append(Data.urlEncode(text, "utf-8"));
        }
        if (!TextUtils.isEmpty(musicUrl)) {
            sb.append("&source=");
            sb.append(Data.urlEncode(musicUrl, "utf-8"));
            if (!TextUtils.isEmpty(text)) {
                sb.append("&name=");
                sb.append(Data.urlEncode(text, "utf-8"));
            }
        }
        C0816e c0816e = new C0816e();
        c0816e.m5931a(sb.toString());
        c0816e.m5930a(platformActionListener);
        c0816e.show(this.f5563a.getContext(), null);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m5920b(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5494e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("message", str));
        String strM5971b = this.f5497h.m5971b("https://graph.facebook.com/v2.5/me/feed", arrayList, "/v2.5/me/feed", m5994c());
        if (strM5971b == null || strM5971b.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5971b);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m5921b(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5494e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("caption", str));
        String strM5964a = this.f5497h.m5964a("https://graph.facebook.com/v2.5/me/photos", arrayList, new KVPair<>("source", str2), "/v2.5/me/photos", m5994c());
        if (strM5964a == null || strM5964a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5964a);
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m5923c(String str) {
        String str2 = "/me";
        if (str != null) {
            str2 = "/" + str;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5494e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work"));
        String strM5967a = this.f5497h.m5967a("https://graph.facebook.com/v2.5" + str2, arrayList, "get_user_info", m5994c());
        C0851d.m6195a().m8615i("facebook helper getUser", new Object[0]);
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5967a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m5912a(int i, int i2, String str) {
        String str2 = str != null ? str : "me";
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5494e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("limit", String.valueOf(i)));
        arrayList.add(new KVPair<>("offset", String.valueOf(i2)));
        arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work"));
        String strM5967a = this.f5497h.m5967a("https://graph.facebook.com/v2.5/" + str2 + (TextUtils.isEmpty(str) ? "/friends" : "/taggable_friends"), arrayList, "friends", m5994c());
        if (strM5967a == null || strM5967a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5967a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m5913a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) {
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
        arrayList.add(new KVPair<>("access_token", this.f5494e));
        arrayList.add(new KVPair<>("format", "json"));
        if (map2 == null || map2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair<String> kVPair2 = null;
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                kVPair2 = new KVPair<>(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
            strHttpPost = this.f5497h.httpGet(str, arrayList, null, null);
        } else {
            strHttpPost = SpdyRequest.POST_METHOD.equals(str2.toUpperCase()) ? this.f5497h.httpPost(str, arrayList, kVPair, null, null) : null;
        }
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    /* JADX INFO: renamed from: d */
    public void m5924d(String str) {
        this.f5499j = str;
    }
}
