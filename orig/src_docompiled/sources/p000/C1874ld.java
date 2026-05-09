package p000;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UpdataBean;
import com.coollang.tennis.beans.UpdataBean.DayData;
import com.coollang.tennis.fragment.VideoFragment;
import com.coollang.tennis.p011db.model.MyActionTable;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.PreferencesCookieStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

/* JADX INFO: renamed from: ld */
/* JADX INFO: compiled from: TennisHttp.java */
/* JADX INFO: loaded from: classes.dex */
public class C1874ld {

    /* JADX INFO: renamed from: an */
    public static HttpUtils f11073an = new HttpUtils();

    /* JADX INFO: renamed from: ao */
    public static CookieStore f11074ao;

    /* JADX INFO: renamed from: ap */
    public static String f11075ap;

    /* JADX INFO: renamed from: aq */
    public static String f11076aq;

    /* JADX INFO: renamed from: ar */
    private int f11117ar;

    /* JADX INFO: renamed from: as */
    private int f11118as;

    /* JADX INFO: renamed from: at */
    private int f11119at;

    /* JADX INFO: renamed from: au */
    private int f11120au;

    /* JADX INFO: renamed from: av */
    private Gson f11121av;

    /* JADX INFO: renamed from: a */
    public final String f11103a = "http://tennis.coollang.com/TLoginController/phoneVerify";

    /* JADX INFO: renamed from: b */
    public final String f11122b = "http://tennis.coollang.com/TLoginController/qqLoginCallBack";

    /* JADX INFO: renamed from: c */
    public final String f11123c = "http://tennis.coollang.com/TLoginController/refreshLogin";

    /* JADX INFO: renamed from: d */
    public final String f11124d = "http://tennis.coollang.com/TennisSportController/getUserUploadTime";

    /* JADX INFO: renamed from: e */
    public final String f11125e = "http://tennis.coollang.com/TennisSportController/addTennisSportMainData";

    /* JADX INFO: renamed from: f */
    public final String f11126f = "http://tennis.coollang.com/TennisSportController/getRanking";

    /* JADX INFO: renamed from: g */
    public final String f11127g = "http://tennis.coollang.com/MemberController/getTennisUserInfo";

    /* JADX INFO: renamed from: h */
    public final String f11128h = "http://tennis.coollang.com/TennisSportController/getData";

    /* JADX INFO: renamed from: i */
    public final String f11129i = "http://tennis.coollang.com/MemberController/uploadUserHeadIcon";

    /* JADX INFO: renamed from: j */
    public final String f11130j = "http://tennis.coollang.com/MemberController/updateMemberInfo";

    /* JADX INFO: renamed from: k */
    public final String f11131k = "http://tennis.coollang.com/TennisSportController/getAnalysisDetailReport";

    /* JADX INFO: renamed from: l */
    public final String f11132l = "http://tennis.coollang.com/getAnalysisDetailReport";

    /* JADX INFO: renamed from: m */
    public final String f11133m = "http://tennis.coollang.com/TargetParamController/addTennisTarget";

    /* JADX INFO: renamed from: n */
    public final String f11134n = "http://tennis.coollang.com/TargetParamController/getTennisTarget";

    /* JADX INFO: renamed from: o */
    public final String f11135o = "http://tennis.coollang.com/TennisSportController/getUserSnsInfo";

    /* JADX INFO: renamed from: p */
    public final String f11136p = "http://tennis.coollang.com/VersionController/getLastVersion";

    /* JADX INFO: renamed from: q */
    public final String f11137q = "http://tennis.coollang.com/PracticeController/getTennisPracticeList";

    /* JADX INFO: renamed from: r */
    public final String f11138r = "http://tennis.coollang.com/PracticeController/getTennisVideoTypeList";

    /* JADX INFO: renamed from: s */
    public final String f11139s = "http://tennis.coollang.com/TLoginController/login";

    /* JADX INFO: renamed from: t */
    public final String f11140t = "http://tennis.coollang.com/TLoginController/emailRegister";

    /* JADX INFO: renamed from: u */
    public final String f11141u = "http://tennis.coollang.com/TLoginController/facebookLogin";

    /* JADX INFO: renamed from: v */
    public final String f11142v = "http://tennis.coollang.com/TennisSportController/deleteDairyData";

    /* JADX INFO: renamed from: w */
    public final String f11143w = "http://tennis.coollang.com/TennisSportController/getDeleteList";

    /* JADX INFO: renamed from: x */
    public final String f11144x = "http://tennis.coollang.com/HardwareController/bindUserOemType";

    /* JADX INFO: renamed from: y */
    public final String f11145y = "http://tennis.coollang.com/TennisSportController/showMedals";

    /* JADX INFO: renamed from: z */
    public final String f11146z = "http://tennis.coollang.com/TennisSportController/getHDVideoList";

    /* JADX INFO: renamed from: A */
    public final String f11077A = "http://tennis.coollang.com/TennisSportController/addPractice";

    /* JADX INFO: renamed from: B */
    public final String f11078B = "http://tennis.coollang.com/TennisSportController/getPractice";

    /* JADX INFO: renamed from: C */
    public final String f11079C = "http://tennis.coollang.com/TennisSportController/addServePractice";

    /* JADX INFO: renamed from: D */
    public final String f11080D = "http://tennis.coollang.com/TennisSportController/getServePractice";

    /* JADX INFO: renamed from: E */
    public final String f11081E = "http://tennis.coollang.com/TennisSportController/deleteHistory";

    /* JADX INFO: renamed from: F */
    public final String f11082F = "http://tennis.coollang.com/TennisSportController/addEquipment";

    /* JADX INFO: renamed from: G */
    public final String f11083G = "http://tennis.coollang.com/TennisSportController/getEquipment";

    /* JADX INFO: renamed from: H */
    public final String f11084H = "http://tennis.coollang.com/TennisSportController/getCareer";

    /* JADX INFO: renamed from: I */
    public final String f11085I = "http://tennis.coollang.com/TennisSportController/addCareer";

    /* JADX INFO: renamed from: J */
    public final String f11086J = "http://tennis.coollang.com/TennisSportController/deleteCareer";

    /* JADX INFO: renamed from: K */
    public final String f11087K = "http://tennis.coollang.com/TennisSportController/uploadRacketIcon";

    /* JADX INFO: renamed from: L */
    public final String f11088L = "http://tennis.coollang.com/TennisSportController/uploadShoesIcon";

    /* JADX INFO: renamed from: M */
    public final String f11089M = "http://tennis.coollang.com/TennisSportController/getUserHistory";

    /* JADX INFO: renamed from: N */
    public final String f11090N = "http://tennis.coollang.com/AccountUserManagerController/getMyEmailCode";

    /* JADX INFO: renamed from: O */
    public final String f11091O = "http://tennis.coollang.com/TennisSportController/addRankLike";

    /* JADX INFO: renamed from: P */
    public final String f11092P = "http://tennis.coollang.com/TennisSportController/delRankLike";

    /* JADX INFO: renamed from: Q */
    public final String f11093Q = "http://tennis.coollang.com/TennisSportController/getMyRankInfo";

    /* JADX INFO: renamed from: R */
    public final String f11094R = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getTypes";

    /* JADX INFO: renamed from: S */
    public final String f11095S = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getRecommendVideos";

    /* JADX INFO: renamed from: T */
    public final String f11096T = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getSearchKeys";

    /* JADX INFO: renamed from: U */
    public final String f11097U = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getVideosByType";

    /* JADX INFO: renamed from: V */
    public final String f11098V = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/searchTitle";

    /* JADX INFO: renamed from: W */
    public final String f11099W = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getCollectionPage";

    /* JADX INFO: renamed from: X */
    public final String f11100X = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getVideoDetail";

    /* JADX INFO: renamed from: Y */
    public final String f11101Y = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/videoLike";

    /* JADX INFO: renamed from: Z */
    public final String f11102Z = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/response";

    /* JADX INFO: renamed from: aa */
    public final String f11104aa = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/responseLike";

    /* JADX INFO: renamed from: ab */
    public final String f11105ab = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/addCollection";

    /* JADX INFO: renamed from: ac */
    public final String f11106ac = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getMyCollection";

    /* JADX INFO: renamed from: ad */
    public final String f11107ad = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getUpToken";

    /* JADX INFO: renamed from: ae */
    public final String f11108ae = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getMyPostVideosPageForHomePage";

    /* JADX INFO: renamed from: af */
    public final String f11109af = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getMsgList";

    /* JADX INFO: renamed from: ag */
    public final String f11110ag = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delAllMsg";

    /* JADX INFO: renamed from: ah */
    public final String f11111ah = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delCollection";

    /* JADX INFO: renamed from: ai */
    public final String f11112ai = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/spotter";

    /* JADX INFO: renamed from: aj */
    public final String f11113aj = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delVideos";

    /* JADX INFO: renamed from: ak */
    public final String f11114ak = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delResponse";

    /* JADX INFO: renamed from: al */
    public final String f11115al = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delMsg";

    /* JADX INFO: renamed from: am */
    public final String f11116am = "http://tennis.coollang.com/Tennis/TennisPostVideosCon/postVideo";

    /* JADX INFO: renamed from: a */
    public void m10186a() {
        f11073an.configTimeout(15000);
    }

    public C1874ld() {
        if (f11073an == null) {
            f11073an = new HttpUtils();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10201b() {
        if (C1902me.m10486b(C1914mm.m10554a(), C1902me.f11451b, new Date().getDate()) != new Date().getDate()) {
            List<Cookie> cookies = new PreferencesCookieStore(C1914mm.m10554a()).getCookies();
            f11074ao = ((DefaultHttpClient) f11073an.getHttpClient()).getCookieStore();
            if (cookies.size() != 0) {
                for (Cookie cookie : cookies) {
                    f11074ao.addCookie(cookie);
                    if (cookie.getName().contentEquals("uid")) {
                        f11076aq = cookie.getValue();
                    }
                }
                C1900mc.m10474b("cookie", "checkCookie====http");
                f11073an.configCookieStore(f11074ao);
                f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/refreshLogin", new RequestCallBack<String>() { // from class: ld.1
                    @Override // com.lidroid.xutils.http.callback.RequestCallBack
                    public void onFailure(HttpException httpException, String str) {
                        C1900mc.m10474b("cookie", "checkCookie====http  error == " + str);
                        C1874ld.this.m10207c();
                    }

                    @Override // com.lidroid.xutils.http.callback.RequestCallBack
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String str = responseInfo.result;
                        C1900mc.m10474b("cookie", "checkCookie====http  success == " + str);
                        if (str.contains("\"ret\":\"0\"")) {
                            C1902me.m10483a(C1914mm.m10554a(), C1902me.f11451b, new Date().getDate());
                            C1874ld.this.m10207c();
                        } else {
                            C1874ld.this.m10207c();
                        }
                    }
                });
                return;
            }
            return;
        }
        C1900mc.m10474b("cookie", "checkCookie====save");
        m10207c();
    }

    /* JADX INFO: renamed from: c */
    public void m10207c() {
        List<Cookie> cookies = new PreferencesCookieStore(C1914mm.m10554a()).getCookies();
        f11074ao = ((DefaultHttpClient) f11073an.getHttpClient()).getCookieStore();
        if (cookies.size() != 0) {
            for (Cookie cookie : cookies) {
                f11074ao.addCookie(cookie);
                if (cookie.getName().contentEquals("uid")) {
                    f11076aq = cookie.getValue();
                }
            }
            f11075ap = C1902me.m10487b(C1914mm.m10554a(), C1902me.f11452c, "");
            C1900mc.m10474b("cookie", "saveCookie====  success == ");
            akd.m1706a().m1722c(new C1873lc("", 1, 0));
            return;
        }
        C1900mc.m10474b("cookie", "saveCookie====  fail == ");
        akd.m1706a().m1722c(new C1873lc("", 0, 0));
    }

    /* JADX INFO: renamed from: s */
    private CookieStore m10185s() {
        if (f11074ao == null) {
            m10207c();
        }
        return f11074ao;
    }

    /* JADX INFO: renamed from: a */
    public void m10192a(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("zone", "86");
        requestParams.addBodyParameter("phone", str);
        requestParams.addBodyParameter("code", str2);
        requestParams.addBodyParameter("oemType", "T0");
        requestParams.addBodyParameter("systemVersion", "Android");
        requestParams.addBodyParameter("appVersion", "1.0.0");
        Log.d("LOGIN_SMS", "http://tennis.coollang.com/TLoginController/phoneVerify");
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/phoneVerify", requestParams, new RequestCallBack<String>() { // from class: ld.11
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                C1900mc.m10475c("TennisHttp", "登录连接失败：" + httpException.toString());
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 1));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                if (str3.contains("\"ret\":\"0\"")) {
                    DefaultHttpClient defaultHttpClient = (DefaultHttpClient) C1874ld.f11073an.getHttpClient();
                    C1874ld.f11074ao = defaultHttpClient.getCookieStore();
                    List<Cookie> cookies = defaultHttpClient.getCookieStore().getCookies();
                    PreferencesCookieStore preferencesCookieStore = new PreferencesCookieStore(C1914mm.m10554a());
                    preferencesCookieStore.clear();
                    for (Cookie cookie : cookies) {
                        preferencesCookieStore.addCookie(cookie);
                        if (cookie.getName().contentEquals("uid")) {
                            C1874ld.f11076aq = cookie.getValue();
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        jSONObject.getString("ret");
                        C1874ld.f11075ap = jSONObject.getString("errDesc");
                        C1902me.m10484a(C1914mm.m10554a(), C1902me.f11452c, C1874ld.f11075ap);
                        akd.m1706a().m1722c(new C1873lc(new JSONObject(C1874ld.f11075ap).getString("FirstLogin"), 1, 1));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                akd.m1706a().m1722c(new C1873lc(str3, 0, 1));
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10204b(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("register", "1");
        requestParams.addBodyParameter("useraccount", str);
        requestParams.addBodyParameter("pwd", str2);
        requestParams.addBodyParameter("oemType", "T0");
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/emailRegister", requestParams, new RequestCallBack<String>() { // from class: ld.21
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                C1900mc.m10475c("TennisHttp", "EmailRegister----------onFailure");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 19));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                C1900mc.m10475c("TennisHttp", "EmailRegister----------onSuccess");
                String str3 = responseInfo.result;
                C1900mc.m10475c("TennisHttp", "EmailLogin--result=" + str3);
                if (str3.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 19));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 19));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10194a(String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("username", str);
        requestParams.addBodyParameter("password", str2);
        requestParams.addBodyParameter("type", "0");
        requestParams.addBodyParameter("oemType", "T0");
        requestParams.addBodyParameter("version", "Android" + str3);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/login", requestParams, new RequestCallBack<String>() { // from class: ld.32
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str4) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 1));
                C1900mc.m10475c("EmailLogin", "EmailLogin----连接失败--" + httpException.toString());
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str4 = responseInfo.result;
                C1900mc.m10475c("EmailLogin", "EmailLogin--result=" + str4);
                if (str4.contains("\"ret\":\"0\"")) {
                    DefaultHttpClient defaultHttpClient = (DefaultHttpClient) C1874ld.f11073an.getHttpClient();
                    C1874ld.f11074ao = defaultHttpClient.getCookieStore();
                    List<Cookie> cookies = defaultHttpClient.getCookieStore().getCookies();
                    PreferencesCookieStore preferencesCookieStore = new PreferencesCookieStore(C1914mm.m10554a());
                    preferencesCookieStore.clear();
                    for (Cookie cookie : cookies) {
                        preferencesCookieStore.addCookie(cookie);
                        if (cookie.getName().contentEquals("uid")) {
                            C1874ld.f11076aq = cookie.getValue();
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        jSONObject.getString("ret");
                        C1874ld.f11075ap = jSONObject.getString("errDesc");
                        C1902me.m10484a(C1914mm.m10554a(), C1902me.f11452c, C1874ld.f11075ap);
                        akd.m1706a().m1722c(new C1873lc(new JSONObject(C1874ld.f11075ap).getString("FirstLogin"), 1, 1));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                akd.m1706a().m1722c(new C1873lc(str4, 0, 1));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10196a(String str, String str2, String str3, String str4, String str5, String str6) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("sex", str4);
        requestParams.addBodyParameter("userName", str5);
        requestParams.addBodyParameter("icon", str6);
        requestParams.addBodyParameter("token", str);
        requestParams.addBodyParameter("openId", str2);
        requestParams.addBodyParameter("type", str3);
        requestParams.addBodyParameter("oemType", "T0");
        requestParams.addBodyParameter("systemVersion", "Android");
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/facebookLogin", requestParams, new RequestCallBack<String>() { // from class: ld.43
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str7) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 1));
                C1900mc.m10475c("TennisHttp", "facebookLogin--onFailure----arg0=" + httpException.toString());
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str7 = responseInfo.result;
                C1900mc.m10475c("TennisHttp", "facebookLogin----onSuccess----result=" + str7);
                if (str7.contains("\"ret\":\"0\"")) {
                    DefaultHttpClient defaultHttpClient = (DefaultHttpClient) C1874ld.f11073an.getHttpClient();
                    C1874ld.f11074ao = defaultHttpClient.getCookieStore();
                    List<Cookie> cookies = defaultHttpClient.getCookieStore().getCookies();
                    PreferencesCookieStore preferencesCookieStore = new PreferencesCookieStore(C1914mm.m10554a());
                    preferencesCookieStore.clear();
                    for (Cookie cookie : cookies) {
                        preferencesCookieStore.addCookie(cookie);
                        if (cookie.getName().contentEquals("uid")) {
                            C1874ld.f11076aq = cookie.getValue();
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str7);
                        jSONObject.getString("ret");
                        C1874ld.f11075ap = jSONObject.getString("errDesc");
                        C1902me.m10484a(C1914mm.m10554a(), C1902me.f11452c, C1874ld.f11075ap);
                        akd.m1706a().m1722c(new C1873lc(new JSONObject(C1874ld.f11075ap).getString("FirstLogin"), 1, 1));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                akd.m1706a().m1722c(new C1873lc(str7, 0, 1));
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10205b(String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("token", str);
        requestParams.addBodyParameter("openId", str2);
        requestParams.addBodyParameter("type", str3);
        requestParams.addBodyParameter("oemType", "T0");
        requestParams.addBodyParameter("systemVersion", "Android");
        requestParams.addBodyParameter("appVersion ", "1.0.0");
        requestParams.addBodyParameter("inviteCode", "");
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TLoginController/qqLoginCallBack", requestParams, new RequestCallBack<String>() { // from class: ld.53
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str4) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 1));
                Toast.makeText(C1914mm.m10554a(), "微信登录连接失败", 0).show();
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str4 = responseInfo.result;
                if (str4.contains("\"ret\":\"0\"")) {
                    DefaultHttpClient defaultHttpClient = (DefaultHttpClient) C1874ld.f11073an.getHttpClient();
                    C1874ld.f11074ao = defaultHttpClient.getCookieStore();
                    List<Cookie> cookies = defaultHttpClient.getCookieStore().getCookies();
                    PreferencesCookieStore preferencesCookieStore = new PreferencesCookieStore(C1914mm.m10554a());
                    preferencesCookieStore.clear();
                    for (Cookie cookie : cookies) {
                        preferencesCookieStore.addCookie(cookie);
                        if (cookie.getName().contentEquals("uid")) {
                            C1874ld.f11076aq = cookie.getValue();
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        jSONObject.getString("ret");
                        C1874ld.f11075ap = jSONObject.getString("errDesc");
                        C1902me.m10484a(C1914mm.m10554a(), C1902me.f11452c, C1874ld.f11075ap);
                        akd.m1706a().m1722c(new C1873lc(new JSONObject(C1874ld.f11075ap).getString("FirstLogin"), 1, 1));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                akd.m1706a().m1722c(new C1873lc(str4, 0, 1));
                Toast.makeText(C1914mm.m10554a(), "微信登录失败", 0).show();
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public void m10212d() {
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/MemberController/getTennisUserInfo", new RequestCallBack<String>() { // from class: ld.59
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 3));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 3));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 3));
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m10210c(final String str, final String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("Type", str);
        requestParams.addBodyParameter("Class", str2);
        f11073an.configCookieStore(m10185s());
        Log.d("TennisHttp", "type" + str + "class=" + str2);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getRanking", requestParams, new RequestCallBack<String>() { // from class: ld.60
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                C1900mc.m10475c("TennisHttp-------getRanking", "获取排行榜连接失败：" + httpException.toString());
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 4, str, str2));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                C1900mc.m10475c("TennisHttp-------getRanking", "result=" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 4, str, str2));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 4, str, str2));
                }
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public void m10216e() {
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getUserUploadTime", new RequestCallBack<String>() { // from class: ld.61
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 2));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.result, 1, 2));
                } else {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.result, 0, 2));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10191a(String str, final long j) {
        this.f11121av = new Gson();
        ArrayList arrayList = new ArrayList();
        UpdataBean updataBean = new UpdataBean();
        String[] strArrSplit = C1912mk.m10534a(j - ((long) C1912mk.m10541c())).split(" ")[0].split("-");
        String str2 = strArrSplit[0] + strArrSplit[1] + strArrSplit[2];
        updataBean.DetailData = new ArrayList();
        updataBean.getClass();
        UpdataBean.DayData dayData = updataBean.new DayData();
        List listFind = DataSupport.where("UserID = ? And date = ?", str, String.valueOf(j)).find(MyMainTable.class);
        if (listFind == null || listFind.isEmpty()) {
            akd.m1706a().m1722c(new C1873lc("main data error", 0, 22, String.valueOf(j)));
            return;
        }
        MyMainTable myMainTable = (MyMainTable) listFind.get(0);
        updataBean.State = String.valueOf(myMainTable.getIsDeleted());
        updataBean.DateTimestamp = Long.toString(myMainTable.getDate());
        updataBean.Caroline = Integer.toString(myMainTable.getCaroline());
        updataBean.Duration = Integer.toString(myMainTable.getDuration());
        updataBean.MaxSpeed = Integer.toString(myMainTable.getMaxSpeed());
        List listFind2 = DataSupport.where("UserID = ? And date = ?", str, String.valueOf(j)).find(MyActionTable.class);
        if (listFind2 == null || listFind2.isEmpty()) {
            akd.m1706a().m1722c(new C1873lc("action data error", 0, 22, String.valueOf(j)));
            return;
        }
        MyActionTable myActionTable = (MyActionTable) listFind2.get(0);
        dayData.FaQiu = Integer.toString(myActionTable.getFaqiu());
        dayData.GaoYa = Integer.toString(myActionTable.getGaoya());
        dayData.JieJi = Integer.toString(myActionTable.getJieji());
        dayData.XueQiu = Integer.toString(myActionTable.getXiaoqiu());
        dayData.XuanQiu = Integer.toString(myActionTable.getXuanqiu());
        dayData.PingJi = Integer.toString(myActionTable.getPingji());
        updataBean.TypeCount = dayData;
        arrayList.add(updataBean);
        String strReplace = this.f11121av.toJson(arrayList).replace("\"DetailData\":[]", C1856km.m10109a().m10111a(str2, str));
        C1900mc.m10473a("UPDATE_BY_DATE", "上传的data=" + strReplace);
        if (strReplace.contains("\"DetailData\":[]")) {
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("data", strReplace);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/addTennisSportMainData", requestParams, new RequestCallBack<String>() { // from class: ld.2
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 22, String.valueOf(j)));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                C1900mc.m10473a("update2ServerByDate", "date == " + j + " onSuccessarg0=" + responseInfo.toString());
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.result, 1, 22, String.valueOf(j)));
                } else {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.result, 0, 22, String.valueOf(j)));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10187a(long j) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("LastUploadTime", Long.toString(j));
        f11073an.configTimeout(6000);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getData", requestParams, new RequestCallBack<String>() { // from class: ld.3
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                C1900mc.m10473a("2015-12-300", "onFailure=" + httpException.toString());
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 8));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                C1900mc.m10473a("2015-12-300", "onSuccess=" + responseInfo.result);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.result, 1, 8));
                } else {
                    akd.m1706a().m1722c(new C1873lc(responseInfo.toString(), 0, 8));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10197a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("UserName", str);
        requestParams.addBodyParameter("Type", "1");
        requestParams.addBodyParameter("Sex", str2);
        requestParams.addBodyParameter("Birthday", str3);
        requestParams.addBodyParameter("Height", str4);
        requestParams.addBodyParameter("Weight", str5);
        requestParams.addBodyParameter("Signature", str6);
        requestParams.addBodyParameter("Address", str7);
        requestParams.addBodyParameter("Hand", str8);
        requestParams.addBodyParameter("Brand", str9);
        requestParams.addBodyParameter("SportAge", str10);
        requestParams.addBodyParameter("StartTennisYear", str11);
        requestParams.addBodyParameter("Level", str12);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/MemberController/updateMemberInfo", requestParams, new RequestCallBack<String>() { // from class: ld.4
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str13) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 7));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str13 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str13, 1, 7));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str13, 0, 7));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10188a(File file) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("userfile", file);
        f11073an.configCookieStore(m10185s());
        f11073an.configSoTimeout(30000);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/MemberController/uploadUserHeadIcon", requestParams, new RequestCallBack<String>() { // from class: ld.5
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 6));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 6));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 6));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10189a(final String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("date", str);
        if (MyApplication.m7738a().m7748h()) {
            requestParams.addBodyParameter("lang", "france");
        } else {
            requestParams.addBodyParameter("lang", MyApplication.m7738a().m7747g() ? "zh_cn" : "english");
        }
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getAnalysisDetailReport", requestParams, new RequestCallBack<String>() { // from class: ld.6
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 9, str));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 9, str));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 9, str));
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10203b(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("count", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TargetParamController/addTennisTarget", requestParams, new RequestCallBack<String>() { // from class: ld.7
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 11));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 11));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 11));
                }
            }
        });
    }

    /* JADX INFO: renamed from: f */
    public void m10219f() {
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TargetParamController/getTennisTarget", new RequestCallBack<String>() { // from class: ld.8
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 12));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                C1900mc.m10475c("TennisHttp-------getTarget", "result=" + str);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 12));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 12));
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m10209c(String str) {
        new RequestParams().addBodyParameter("userID", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getUserSnsInfo", new RequestCallBack<String>() { // from class: ld.9
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 13));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 13));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 13));
                }
            }
        });
    }

    /* JADX INFO: renamed from: g */
    public void m10222g() {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("oemType", MyApplication.m7738a().f7405f);
        C1900mc.m10474b("PID", "pid == " + MyApplication.m7738a().f7405f);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/VersionController/getLastVersion", requestParams, new RequestCallBack<String>() { // from class: ld.10
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 14));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 14));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 14));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10190a(final String str, final int i, final int i2) {
        f11073an.configTimeout(6000);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("date", str);
        requestParams.addBodyParameter("flag", "1");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/deleteDairyData", requestParams, new RequestCallBack<String>() { // from class: ld.12
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 20));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 20, str, i, i2));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 20));
                }
            }
        });
    }

    /* JADX INFO: renamed from: h */
    public void m10225h() {
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getDeleteList", requestParams, new RequestCallBack<String>() { // from class: ld.13
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 21));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 21));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 21));
                }
            }
        });
    }

    /* JADX INFO: renamed from: i */
    public void m10228i() {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("oemType", MyApplication.m7738a().f7405f);
        requestParams.addBodyParameter("phoneType", "Android");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/HardwareController/bindUserOemType", requestParams, new RequestCallBack<String>() { // from class: ld.14
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 23));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 23));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 23));
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public void m10213d(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("medals", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/showMedals", requestParams, new RequestCallBack<String>() { // from class: ld.15
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 24));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 24));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 24));
                }
            }
        });
    }

    /* JADX INFO: renamed from: j */
    public void m10231j() {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("lang", MyApplication.m7738a().m7747g() ? "zh_cn" : "english");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getHDVideoList", requestParams, new RequestCallBack<String>() { // from class: ld.16
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 25));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 25));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 25));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10198a(String str, String str2, String str3, String str4, String str5, String str6, List<String[]> list, final int i) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("Date", str);
        requestParams.addBodyParameter("StartTime", str2);
        requestParams.addBodyParameter("EndTime", str3);
        requestParams.addBodyParameter("ForceTargetTimes", str4);
        requestParams.addBodyParameter("BackTargetTimes", str5);
        requestParams.addBodyParameter("Frequency", str6);
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                switch (i3) {
                    case 0:
                        requestParams.addBodyParameter("Detail[" + i2 + "][T]", list.get(i2)[i3]);
                        break;
                    case 1:
                        requestParams.addBodyParameter("Detail[" + i2 + "][F]", list.get(i2)[i3]);
                        break;
                    case 2:
                        requestParams.addBodyParameter("Detail[" + i2 + "][S]", list.get(i2)[i3]);
                        break;
                    case 3:
                        requestParams.addBodyParameter("Detail[" + i2 + "][D]", list.get(i2)[i3]);
                        break;
                }
            }
        }
        C1808is.m9825a(requestParams);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/addPractice", requestParams, new RequestCallBack<String>() { // from class: ld.17
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str7 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str7, 1, 26, i));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str7, 0, 26));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str7) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 26));
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public void m10217e(String str) {
        C1808is.m9827c(str);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("time", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getPractice", requestParams, new RequestCallBack<String>() { // from class: ld.18
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 27));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 27));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 27));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10199a(String str, String str2, String str3, String str4, List<String[]> list, final int i) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("Date", str);
        requestParams.addBodyParameter("StartTime", str2);
        requestParams.addBodyParameter("EndTime", str3);
        requestParams.addBodyParameter("TargetSpeed", str4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                switch (i3) {
                    case 0:
                        requestParams.addBodyParameter("Detail[" + i2 + "][T]", list.get(i2)[i3]);
                        break;
                    case 1:
                        requestParams.addBodyParameter("Detail[" + i2 + "][S]", list.get(i2)[i3]);
                        break;
                    case 2:
                        requestParams.addBodyParameter("Detail[" + i2 + "][D]", list.get(i2)[i3]);
                        break;
                }
            }
        }
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/addServePractice", requestParams, new RequestCallBack<String>() { // from class: ld.19
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str5 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str5, 1, 28, i));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str5, 0, 28));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str5) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 28));
            }
        });
    }

    /* JADX INFO: renamed from: f */
    public void m10220f(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("time", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getServePractice", requestParams, new RequestCallBack<String>() { // from class: ld.20
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 29));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 29));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 29));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10193a(String str, String str2, final int i) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("type", str);
        requestParams.addBodyParameter("ID", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/deleteHistory", requestParams, new RequestCallBack<String>() { // from class: ld.22
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 30, i));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 30));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 30));
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10206b(String str, String str2, String str3, String str4, String str5, String str6) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("brand", str);
        requestParams.addBodyParameter("buyTime", str2);
        requestParams.addBodyParameter("verticalLine", str3);
        requestParams.addBodyParameter("line", str4);
        requestParams.addBodyParameter("shoesName", str5);
        requestParams.addBodyParameter("shoesBuyTime", str6);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/addEquipment", requestParams, new RequestCallBack<String>() { // from class: ld.23
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str7 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str7, 1, 51));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str7, 0, 51));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str7) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 51));
            }
        });
    }

    /* JADX INFO: renamed from: k */
    public void m10233k() {
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getEquipment", requestParams, new RequestCallBack<String>() { // from class: ld.24
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 52));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 52));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 52));
            }
        });
    }

    /* JADX INFO: renamed from: l */
    public void m10235l() {
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getCareer", requestParams, new RequestCallBack<String>() { // from class: ld.25
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 53));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 53));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 53));
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m10211c(final String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        if (str != null) {
            requestParams.addBodyParameter("ID", str);
        }
        requestParams.addBodyParameter("year", str2);
        requestParams.addBodyParameter("career", str3);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/addCareer", requestParams, new RequestCallBack<String>() { // from class: ld.26
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str4 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str4, 1, 54, str));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str4, 0, 54));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str4) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 54));
            }
        });
    }

    /* JADX INFO: renamed from: g */
    public void m10223g(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("careerID", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/deleteCareer", requestParams, new RequestCallBack<String>() { // from class: ld.27
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 55));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 55));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 55));
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10202b(File file) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("userfile", file);
        f11073an.configCookieStore(m10185s());
        f11073an.configSoTimeout(30000);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/uploadRacketIcon", requestParams, new RequestCallBack<String>() { // from class: ld.28
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 56));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 56));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 56));
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m10208c(File file) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("userfile", file);
        f11073an.configCookieStore(m10185s());
        f11073an.configSoTimeout(30000);
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/uploadShoesIcon", requestParams, new RequestCallBack<String>() { // from class: ld.29
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 57));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 57));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 57));
                }
            }
        });
    }

    /* JADX INFO: renamed from: m */
    public void m10237m() {
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getUserHistory", requestParams, new RequestCallBack<String>() { // from class: ld.30
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 58));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 58));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 58));
            }
        });
    }

    /* JADX INFO: renamed from: h */
    public void m10226h(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter(NotificationCompat.CATEGORY_EMAIL, str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/AccountUserManagerController/getMyEmailCode", requestParams, new RequestCallBack<String>() { // from class: ld.31
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 59));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 59));
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 59));
            }
        });
    }

    /* JADX INFO: renamed from: n */
    public void m10239n() {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("oemType", MyApplication.m7738a().f7405f);
        C1900mc.m10474b("PID", "pid == " + MyApplication.m7738a().f7405f);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/VersionController/getLastVersion", requestParams, new RequestCallBack<String>() { // from class: ld.33
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 60));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 60));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 60));
                }
            }
        });
    }

    /* JADX INFO: renamed from: i */
    public void m10229i(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("userID", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/TennisSportController/getMyRankInfo", requestParams, new RequestCallBack<String>() { // from class: ld.34
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 61));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 61));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 61));
                }
            }
        });
    }

    /* JADX INFO: renamed from: o */
    public void m10241o() {
        Log.e("TennisHttp", "getVideoList: !!!!!!!!!!!!!!!!");
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getTypes", requestParams, new RequestCallBack<String>() { // from class: ld.35
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                Log.e("TennisHttp", "HttpException: !!!!!!!!!!!!!!!!" + httpException.getMessage());
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 62));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                Log.e("TennisHttp", "result :" + str);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 62));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 62));
                }
            }
        });
    }

    /* JADX INFO: renamed from: j */
    public void m10232j(String str) {
        Log.e("TennisHttp", "get_Collection: !!!!!!!!!!!!!!!!");
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("page", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getCollectionPage", requestParams, new RequestCallBack<String>() { // from class: ld.36
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure----get_Collection: !!!!!!!!!!!!!!!!");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 71));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 71));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 71));
                }
            }
        });
    }

    /* JADX INFO: renamed from: k */
    public void m10234k(String str) {
        Log.e("TennisHttp", "get_recommendvideo: !!!!!!!!!!!!!!!!" + str);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("page", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getRecommendVideos", requestParams, new RequestCallBack<String>() { // from class: ld.37
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "失败: !!!!!!!!!!!!!!!!");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 63));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 63));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 63));
                }
            }
        });
    }

    /* JADX INFO: renamed from: p */
    public void m10243p() {
        Log.e("TennisHttp", "getantistop: !!!!!!!!!!!!!!!!");
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getSearchKeys", requestParams, new RequestCallBack<String>() { // from class: ld.38
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                Log.e("TennisHttp", "失败: !!!!!!!!!!!!!!!!");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 64));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                Log.e("TennisHttp", "result :" + str);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    Log.e("TennisHttp", "成功: !!!!!!!!!!!!!!!!");
                    akd.m1706a().m1722c(new C1873lc(str, 1, 64));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 64));
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public void m10214d(String str, String str2) {
        Log.e("TennisHttp", "getvideobytype: !!!!!!!!!!!!" + str + "-" + str2);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("page", str);
        requestParams.addBodyParameter("type", str2);
        final int i = Integer.parseInt(str2);
        this.f11117ar = Integer.parseInt(VideoFragment.f7761c.get(0).f7435ID);
        this.f11118as = Integer.parseInt(VideoFragment.f7761c.get(1).f7435ID);
        this.f11119at = Integer.parseInt(VideoFragment.f7761c.get(2).f7435ID);
        this.f11120au = Integer.parseInt(VideoFragment.f7761c.get(3).f7435ID);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getVideosByType", requestParams, new RequestCallBack<String>() { // from class: ld.39
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                Log.e("TennisHttp", "失败: !!!!!!!!!!!!!!!!");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 65));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    if (i != C1874ld.this.f11117ar) {
                        if (i != C1874ld.this.f11118as) {
                            if (i != C1874ld.this.f11119at) {
                                if (i == C1874ld.this.f11120au) {
                                    Log.e("TennisHttp", "GET_Videos_ByType1 :");
                                    akd.m1706a().m1722c(new C1873lc(str3, 1, 70));
                                    return;
                                }
                                return;
                            }
                            Log.e("TennisHttp", "GET_Videos_ByType1 :");
                            akd.m1706a().m1722c(new C1873lc(str3, 1, 69));
                            return;
                        }
                        Log.e("TennisHttp", "GET_Videos_ByType1 :");
                        akd.m1706a().m1722c(new C1873lc(str3, 1, 68));
                        return;
                    }
                    Log.e("TennisHttp", "GET_Videos_ByType1 :");
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 67));
                    return;
                }
                akd.m1706a().m1722c(new C1873lc(str3, 0, 65));
            }
        });
    }

    /* JADX INFO: renamed from: e */
    public void m10218e(String str, String str2) {
        Log.e("TennisHttp", "getvideobytype: !!!!!!!!!!!!" + str + "-" + str2);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("page", str);
        requestParams.addBodyParameter("title", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/searchTitle", requestParams, new RequestCallBack<String>() { // from class: ld.40
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                Log.e("TennisHttp", "失败: !!!!!!!!!!!!!!!!");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 66));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 66));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 66));
                }
            }
        });
    }

    /* JADX INFO: renamed from: l */
    public void m10236l(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("ID", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getVideoDetail", requestParams, new RequestCallBack<String>() { // from class: ld.41
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure :get_Comment");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 72));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "get_Comment :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 72));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 72));
                }
            }
        });
    }

    /* JADX INFO: renamed from: f */
    public void m10221f(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("videoID", str);
        requestParams.addBodyParameter("like", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/videoLike", requestParams, new RequestCallBack<String>() { // from class: ld.42
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 73));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 73));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 73));
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public void m10215d(String str, String str2, String str3) {
        Log.d("TennisHttp", "Postresponse: " + str + "==" + str2 + " " + str3);
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("videoID", str);
        requestParams.addBodyParameter("parentID", str2);
        requestParams.addBodyParameter("content", str3);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/response", requestParams, new RequestCallBack<String>() { // from class: ld.44
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str4) {
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 74));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str4 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str4);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str4, 1, 74));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str4, 0, 74));
                }
            }
        });
    }

    /* JADX INFO: renamed from: g */
    public void m10224g(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("responseID", str);
        requestParams.addBodyParameter("like", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/responseLike", requestParams, new RequestCallBack<String>() { // from class: ld.45
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                Log.e("TennisHttp", "onFailure:  to_responseLike");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 75));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 75));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 75));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10200a(String str, String str2, final InterfaceC1878lh interfaceC1878lh) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("responseID", str);
        requestParams.addBodyParameter("like", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/responseLike", requestParams, new RequestCallBack<String>() { // from class: ld.46
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                if (interfaceC1878lh != null) {
                    interfaceC1878lh.mo9848b();
                }
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.e("TennisHttp", "result :" + responseInfo.result);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    if (interfaceC1878lh != null) {
                        interfaceC1878lh.mo9847a();
                    }
                } else if (interfaceC1878lh != null) {
                    interfaceC1878lh.mo9848b();
                }
            }
        });
    }

    /* JADX INFO: renamed from: m */
    public void m10238m(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("videoID", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/addCollection", requestParams, new RequestCallBack<String>() { // from class: ld.47
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  ISCollection");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 76));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 76));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 76));
                }
            }
        });
    }

    /* JADX INFO: renamed from: q */
    public void m10245q() {
        RequestParams requestParams = new RequestParams();
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getUpToken", requestParams, new RequestCallBack<String>() { // from class: ld.48
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                Log.e("TennisHttp", "onFailure:  getvideo_tk");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 78));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                Log.e("TennisHttp", "result :" + str);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 78));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 78));
                }
            }
        });
    }

    /* JADX INFO: renamed from: n */
    public void m10240n(String str) {
        RequestParams requestParams = new RequestParams();
        Log.e("TennisHttp", "getmyvideo------  uid:" + f11076aq);
        requestParams.addBodyParameter("page", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getMyPostVideosPageForHomePage", requestParams, new RequestCallBack<String>() { // from class: ld.49
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  getvideo_tk");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 79));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "getmyvideo :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 79));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 79));
                }
            }
        });
    }

    /* JADX INFO: renamed from: o */
    public void m10242o(String str) {
        RequestParams requestParams = new RequestParams();
        Log.e("TennisHttp", "getMsgList:  page" + str);
        requestParams.addBodyParameter("page", str);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/getMsgList", requestParams, new RequestCallBack<String>() { // from class: ld.50
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 80));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 80));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 80));
                }
            }
        });
    }

    /* JADX INFO: renamed from: r */
    public void m10247r() {
        RequestParams requestParams = new RequestParams();
        Log.e("TennisHttp", "clear_allmsg:  clear_allmsg");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delAllMsg", requestParams, new RequestCallBack<String>() { // from class: ld.51
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 81));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str = responseInfo.result;
                Log.e("TennisHttp", "result :" + str);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 81));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str, 0, 81));
                }
            }
        });
    }

    /* JADX INFO: renamed from: p */
    public void m10244p(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("videoID", str);
        Log.e("TennisHttp", "delete_Collection:  delete_Collection");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delCollection", requestParams, new RequestCallBack<String>() { // from class: ld.52
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 82));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 82));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 82));
                }
            }
        });
    }

    /* JADX INFO: renamed from: h */
    public void m10227h(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("spotterType", str);
        requestParams.addBodyParameter("videoID", str2);
        Log.e("TennisHttp", "report_video:  report_video");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/spotter", requestParams, new RequestCallBack<String>() { // from class: ld.54
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 83));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 83));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 83));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10195a(String str, String str2, String str3, String str4) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("spotterType", str);
        requestParams.addBodyParameter("videoID", str2);
        requestParams.addBodyParameter("ResponseID", str3);
        requestParams.addBodyParameter("type", str4);
        Log.e("TennisHttp", "举报视频.评论:  spotterType:" + str);
        Log.e("TennisHttp", "举报视频.评论:  videoID:" + str2);
        Log.e("TennisHttp", "举报视频.评论:  responseID:" + str3);
        Log.e("TennisHttp", "举报视频.评论:  type:" + str4);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/spotter", requestParams, new RequestCallBack<String>() { // from class: ld.55
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str5) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 83));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str5 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str5);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str5, 1, 83));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str5, 0, 83));
                }
            }
        });
    }

    /* JADX INFO: renamed from: q */
    public void m10246q(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("videoID", str);
        Log.e("TennisHttp", "delete_videos:");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delVideos", requestParams, new RequestCallBack<String>() { // from class: ld.56
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 84));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 84));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 84));
                }
            }
        });
    }

    /* JADX INFO: renamed from: r */
    public void m10248r(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.addBodyParameter("responseID", str);
        Log.e("TennisHttp", "delete_comment:");
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/delResponse", requestParams, new RequestCallBack<String>() { // from class: ld.57
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str2) {
                Log.e("TennisHttp", "onFailure:  ");
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 85));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str2 = responseInfo.result;
                Log.e("TennisHttp", "result :" + str2);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 85));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str2, 0, 85));
                }
            }
        });
    }

    /* JADX INFO: renamed from: i */
    public void m10230i(String str, String str2) {
        RequestParams requestParams = new RequestParams();
        Log.e("TennisHttp", "post_video ");
        requestParams.addBodyParameter("title", str);
        requestParams.addBodyParameter("url", str2);
        f11073an.configCookieStore(m10185s());
        f11073an.send(HttpRequest.HttpMethod.POST, "http://tennis.coollang.com/Tennis/TennisPostVideosCon/postVideo", requestParams, new RequestCallBack<String>() { // from class: ld.58
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str3) {
                Log.e("TennisHttp", "delete_msg_onFailure:  " + httpException);
                akd.m1706a().m1722c(new C1873lc(httpException.toString(), -1, 87));
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String str3 = responseInfo.result;
                Log.e("TennisHttp", "delete_msg_result :" + str3);
                if (responseInfo.result.contains("\"ret\":\"0\"")) {
                    akd.m1706a().m1722c(new C1873lc(str3, 1, 87));
                } else {
                    akd.m1706a().m1722c(new C1873lc(str3, 0, 87));
                }
            }
        });
    }
}
