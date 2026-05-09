package cn.sharesdk.tencent.qzone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
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
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qzone.b */
/* JADX INFO: compiled from: QZoneHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0885b extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static final String[] f5824b = {"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};

    /* JADX INFO: renamed from: c */
    private static C0885b f5825c;

    /* JADX INFO: renamed from: d */
    private String f5826d;

    /* JADX INFO: renamed from: e */
    private String f5827e;

    /* JADX INFO: renamed from: f */
    private String f5828f;

    /* JADX INFO: renamed from: g */
    private C0819a f5829g;

    /* JADX INFO: renamed from: h */
    private String[] f5830h;

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    /* JADX INFO: renamed from: a */
    public static C0885b m6371a(Platform platform) {
        if (f5825c == null) {
            f5825c = new C0885b(platform);
        }
        return f5825c;
    }

    private C0885b(Platform platform) {
        super(platform);
        this.f5829g = C0819a.m5962a();
    }

    /* JADX INFO: renamed from: a */
    public void m6377a(String str) {
        this.f5826d = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6379a(String[] strArr) {
        this.f5830h = strArr;
    }

    /* JADX INFO: renamed from: a */
    public void m6376a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m5993b(authorizeListener);
        } else {
            m5992a(new SSOListener() { // from class: cn.sharesdk.tencent.qzone.b.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0885b.this.m5993b(authorizeListener);
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

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        String redirectUri;
        ShareSDK.logApiEvent("/oauth2.0/authorize", m5994c());
        String strM6373b = m6373b();
        try {
            redirectUri = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            redirectUri = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f5826d + "&redirect_uri=" + redirectUri + "&display=mobile&scope=" + strM6373b;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0884a(c0826e);
    }

    /* JADX INFO: renamed from: b */
    private String m6373b() {
        String[] strArr = this.f5830h == null ? f5824b : this.f5830h;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(str);
            i++;
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.AbstractC0827b, cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0825d getSSOProcessor(C0824c c0824c) {
        C0886c c0886c = new C0886c(c0824c);
        c0886c.m5985a(5656);
        c0886c.m6387a(this.f5826d, m6373b());
        return c0886c;
    }

    /* JADX INFO: renamed from: b */
    public void m6382b(String str) {
        this.f5827e = str;
    }

    /* JADX INFO: renamed from: c */
    public void m6384c(String str) {
        this.f5828f = str;
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6385d(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5828f));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5826d));
        arrayList.add(new KVPair<>("openid", this.f5827e));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String strM5968a = this.f5829g.m5968a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/user/get_simple_userinfo", m5994c());
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX INFO: renamed from: a */
    public void m6378a(String str, String str2, String str3, String str4, String str5, PlatformActionListener platformActionListener) {
        if (TextUtils.isEmpty(str5)) {
            str5 = DeviceHelper.getInstance(this.f5563a.getContext()).getAppName();
        }
        if (str5.length() > 20) {
            str5 = str5.substring(0, 20) + "...";
        }
        String str6 = str5;
        if (!TextUtils.isEmpty(str) && str.length() > 200) {
            str = str.substring(0, 200);
        }
        m6383b(str, str2, str3, str4, str6, platformActionListener);
    }

    /* JADX INFO: renamed from: b */
    public void m6383b(String str, String str2, String str3, String str4, String str5, PlatformActionListener platformActionListener) {
        String str6 = "1";
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            str6 = "3";
        } else if (TextUtils.isEmpty(str2)) {
            if (platformActionListener != null) {
                platformActionListener.onError(null, 9, new Throwable("The param of title or titleUrl is null !"));
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str4)) {
            File file = new File(str4);
            if (file.exists() && str4.startsWith("/data/")) {
                String absolutePath = new File(ResHelper.getCachePath(this.f5563a.getContext(), "images"), System.currentTimeMillis() + file.getName()).getAbsolutePath();
                str4 = ResHelper.copyFile(str4, absolutePath) ? absolutePath : null;
            }
        }
        if (!TextUtils.isEmpty(str3) && str3.length() > 600) {
            str3 = str3.substring(0, 600);
        }
        StringBuilder sb = new StringBuilder();
        if (str6 == "3") {
            sb.append("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        } else {
            sb.append("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&image_url=");
            sb.append(Base64.encodeToString(str4.getBytes("utf-8"), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("&title=");
            sb.append(Base64.encodeToString(str.getBytes("utf-8"), 2));
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&description=");
            sb.append(Base64.encodeToString(str3.getBytes("utf-8"), 2));
        }
        sb.append("&share_id=");
        sb.append(this.f5826d);
        if (!TextUtils.isEmpty(str2)) {
            sb.append("&url=");
            sb.append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
        }
        sb.append("&app_name=");
        sb.append(Base64.encodeToString(str5.getBytes("utf-8"), 2));
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&share_qq_ext_str=");
            sb.append(Base64.encodeToString(str3.getBytes(), 2));
        }
        sb.append("&req_type=");
        sb.append(Base64.encodeToString(str6.getBytes("utf-8"), 2));
        String str7 = m6380a() ? "1" : "0";
        sb.append("&cflag=");
        sb.append(Base64.encodeToString(str7.getBytes("utf-8"), 2));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(sb.toString()));
        if (this.f5563a.getContext().getPackageManager().resolveActivity(intent, 1) != null) {
            C0887d c0887d = new C0887d();
            c0887d.m6400a(sb.toString(), true);
            c0887d.m6398a(platformActionListener);
            c0887d.m6399a(this.f5826d);
            c0887d.show(this.f5563a.getContext(), null);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m6380a() {
        String str;
        try {
            str = this.f5563a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            str = null;
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6374a(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5828f));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5826d));
        arrayList.add(new KVPair<>("openid", this.f5827e));
        arrayList.add(new KVPair<>("format", "json"));
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 200) {
                str2 = str2.substring(0, 199) + "…";
            }
            arrayList.add(new KVPair<>("photodesc", str2));
        }
        arrayList.add(new KVPair<>("mobile", "1"));
        KVPair<String> kVPair = new KVPair<>("picture", str);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String strM5966a = this.f5829g.m5966a("https://graph.qq.com/photo/upload_pic", arrayList, kVPair, arrayList2, "/photo/upload_pic", m5994c());
        if (strM5966a == null || strM5966a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5966a);
    }

    /* JADX INFO: renamed from: e */
    public HashMap<String, Object> m6386e(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", str));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String strM5968a = this.f5829g.m5968a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/oauth2.0/me", m5994c());
        if (strM5968a.startsWith("callback")) {
            while (!strM5968a.startsWith("{") && strM5968a.length() > 0) {
                strM5968a = strM5968a.substring(1);
            }
            while (!strM5968a.endsWith("}") && strM5968a.length() > 0) {
                strM5968a = strM5968a.substring(0, strM5968a.length() - 1);
            }
        }
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fe, code lost:
    
        r8 = null;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> m6375a(java.lang.String r8, java.lang.String r9, java.util.HashMap<java.lang.String, java.lang.Object> r10, java.util.HashMap<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.tencent.qzone.C0885b.m6375a(java.lang.String, java.lang.String, java.util.HashMap, java.util.HashMap):java.util.HashMap");
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6381b(String str, String str2) throws Throwable {
        String strM5971b;
        boolean z = !TextUtils.isEmpty(str);
        String str3 = z ? "/t/add_pic_t" : "/t/add_t";
        String str4 = "https://graph.qq.com" + str3;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5826d));
        arrayList.add(new KVPair<>("access_token", this.f5828f));
        arrayList.add(new KVPair<>("openid", this.f5827e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("content", str2));
        if (z) {
            strM5971b = this.f5829g.m5964a(str4, arrayList, new KVPair<>("pic", str), str3, m5994c());
        } else {
            strM5971b = this.f5829g.m5971b(str4, arrayList, str3, m5994c());
        }
        if (strM5971b == null || strM5971b.length() <= 0) {
            return null;
        }
        HashMap<String, Object> mapFromJson = new Hashon().fromJson(strM5971b);
        if (((Integer) mapFromJson.get("ret")).intValue() != 0) {
            throw new Throwable(strM5971b);
        }
        return mapFromJson;
    }
}
