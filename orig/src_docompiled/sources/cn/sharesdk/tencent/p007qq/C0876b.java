package cn.sharesdk.tencent.p007qq;

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
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.b */
/* JADX INFO: compiled from: QQHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0876b extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static final String[] f5778b = {"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};

    /* JADX INFO: renamed from: c */
    private static C0876b f5779c;

    /* JADX INFO: renamed from: d */
    private String f5780d;

    /* JADX INFO: renamed from: e */
    private String[] f5781e;

    /* JADX INFO: renamed from: f */
    private String f5782f;

    /* JADX INFO: renamed from: g */
    private String f5783g;

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    /* JADX INFO: renamed from: a */
    public static C0876b m6311a(Platform platform) {
        if (f5779c == null) {
            f5779c = new C0876b(platform);
        }
        return f5779c;
    }

    private C0876b(Platform platform) {
        super(platform);
    }

    /* JADX INFO: renamed from: a */
    public void m6317a(String str) {
        this.f5780d = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6319a(String[] strArr) {
        this.f5781e = strArr;
    }

    /* JADX INFO: renamed from: a */
    public void m6316a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            m5993b(authorizeListener);
        } else {
            m5992a(new SSOListener() { // from class: cn.sharesdk.tencent.qq.b.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    C0876b.this.m5993b(authorizeListener);
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

    /* JADX INFO: renamed from: b */
    public void m6321b(String str) {
        this.f5782f = str;
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6322c(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", str));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String strM5968a = C0819a.m5962a().m5968a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/oauth2.0/me", m5994c());
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

    /* JADX INFO: renamed from: d */
    public void m6323d(String str) {
        this.f5783g = str;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        String redirectUri;
        ShareSDK.logApiEvent("/oauth2.0/authorize", m5994c());
        String strM6314b = m6314b();
        try {
            redirectUri = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            redirectUri = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f5780d + "&redirect_uri=" + redirectUri + "&display=mobile&scope=" + strM6314b;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0875a(c0826e);
    }

    /* JADX INFO: renamed from: b */
    private String m6314b() {
        String[] strArr = this.f5781e == null ? f5778b : this.f5781e;
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
        C0877c c0877c = new C0877c(c0824c);
        c0877c.m5985a(5656);
        c0877c.m6325a(this.f5780d, m6314b());
        return c0877c;
    }

    /* JADX INFO: renamed from: e */
    public HashMap<String, Object> m6324e(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f5783g));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5780d));
        arrayList.add(new KVPair<>("openid", this.f5782f));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String strM5968a = C0819a.m5962a().m5968a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/user/get_simple_userinfo", m5994c());
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m6318a(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, cn.sharesdk.framework.PlatformActionListener r19, boolean r20, int r21) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.tencent.p007qq.C0876b.m6318a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, cn.sharesdk.framework.PlatformActionListener, boolean, int):void");
    }

    /* JADX INFO: renamed from: a */
    public boolean m6320a() {
        String str;
        try {
            try {
                try {
                    try {
                        str = this.f5563a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
                    } catch (Throwable unused) {
                        str = this.f5563a.getContext().getPackageManager().getPackageInfo("com.tencent.minihd.qq", 0).versionName;
                    }
                } catch (Throwable unused2) {
                    str = null;
                }
            } catch (Throwable unused3) {
                str = this.f5563a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqqi", 0).versionName;
            }
        } catch (Throwable unused4) {
            str = this.f5563a.getContext().getPackageManager().getPackageInfo("com.tencent.qqlite", 0).versionName;
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: renamed from: a */
    private void m6313a(String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener) {
        if (str5 == null && str4 != null && new File(str4).exists()) {
            str5 = ((C0874QQ) this.f5563a).uploadImageToFileServer(str4);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("http://openmobile.qq.com/api/check?");
            sb.append("page=shareindex.html&");
            sb.append("style=9&");
            sb.append("action=shareToQQ&");
            sb.append("sdkv=2.2.1&");
            sb.append("sdkp=a&");
            sb.append("appId=");
            sb.append(this.f5780d);
            sb.append("&");
            DeviceHelper deviceHelper = DeviceHelper.getInstance(this.f5563a.getContext());
            sb.append("status_os=");
            sb.append(Data.urlEncode(deviceHelper.getOSVersionName(), "utf-8"));
            sb.append("&");
            sb.append("status_machine=");
            sb.append(Data.urlEncode(deviceHelper.getModel(), "utf-8"));
            sb.append("&");
            sb.append("status_version=");
            sb.append(Data.urlEncode(String.valueOf(deviceHelper.getOSVersionInt()), "utf-8"));
            sb.append("&");
            String appName = deviceHelper.getAppName();
            if (!TextUtils.isEmpty(appName)) {
                sb.append("site=");
                sb.append(Data.urlEncode(appName, "utf-8"));
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 40) {
                    str = str.substring(40) + "...";
                }
                if (str.length() > 80) {
                    str = str.substring(80) + "...";
                }
                sb.append("title=");
                sb.append(Data.urlEncode(str, "utf-8"));
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append("summary=");
                sb.append(Data.urlEncode(str3, "utf-8"));
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("targeturl=");
                sb.append(Data.urlEncode(str2, "utf-8"));
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str5)) {
                sb.append("imageUrl=");
                sb.append(Data.urlEncode(str5, "utf-8"));
                sb.append("&");
            }
            sb.append("type=1");
            C0880f c0880f = new C0880f();
            c0880f.m6347a(sb.toString());
            c0880f.m6346a(platformActionListener);
            c0880f.m6348b(this.f5780d);
            c0880f.show(this.f5563a.getContext(), null);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.f5563a, 9, th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m6315b(String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener) {
        String strM5971b;
        try {
            boolean z = (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) ? false : true;
            String str7 = !z ? "/t/add_t" : "/t/add_pic_t";
            String str8 = "https://graph.qq.com" + str7;
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("oauth_consumer_key", this.f5780d));
            arrayList.add(new KVPair<>("access_token", this.f5783g));
            arrayList.add(new KVPair<>("openid", this.f5782f));
            arrayList.add(new KVPair<>("format", "json"));
            arrayList.add(new KVPair<>("content", str3));
            if (z) {
                if (TextUtils.isEmpty(str4)) {
                    str4 = BitmapHelper.downloadBitmap(this.f5563a.getContext(), str5);
                }
                strM5971b = C0819a.m5962a().m5964a(str8, arrayList, new KVPair<>("pic", str4), str7, m5994c());
            } else {
                strM5971b = C0819a.m5962a().m5971b(str8, arrayList, str7, m5994c());
            }
            if (strM5971b == null || strM5971b.length() <= 0 || platformActionListener == null) {
                return;
            }
            HashMap<String, Object> mapFromJson = new Hashon().fromJson(strM5971b);
            if (((Integer) mapFromJson.get("ret")).intValue() != 0) {
                platformActionListener.onError(this.f5563a, 9, new Exception(strM5971b));
            } else {
                platformActionListener.onComplete(this.f5563a, 9, mapFromJson);
            }
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.f5563a, 9, th);
            }
        }
    }
}
