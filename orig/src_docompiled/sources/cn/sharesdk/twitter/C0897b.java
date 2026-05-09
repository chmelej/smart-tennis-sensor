package cn.sharesdk.twitter;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.AbstractC0827b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AbstractC0823b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.p003a.C0819a;
import cn.sharesdk.framework.utils.C0848a;
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

/* JADX INFO: renamed from: cn.sharesdk.twitter.b */
/* JADX INFO: compiled from: TwitterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0897b extends AbstractC0827b {

    /* JADX INFO: renamed from: b */
    private static C0897b f5895b;

    /* JADX INFO: renamed from: c */
    private C0848a f5896c;

    /* JADX INFO: renamed from: d */
    private C0819a f5897d;

    /* JADX INFO: renamed from: a */
    public static C0897b m6482a(Platform platform) {
        if (f5895b == null) {
            f5895b = new C0897b(platform);
        }
        return f5895b;
    }

    private C0897b(Platform platform) {
        super(platform);
        this.f5896c = new C0848a();
        this.f5897d = C0819a.m5962a();
    }

    /* JADX INFO: renamed from: a */
    public void m6488a(String str, String str2, String str3) {
        this.f5896c.m6187a(str, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public void m6487a(String str, String str2) {
        this.f5896c.m6186a(str, str2);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f5896c.m6181a().f5705e;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        try {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("oauth_callback", getRedirectUri()));
            m6487a((String) null, (String) null);
            String strM5966a = this.f5897d.m5966a("https://api.twitter.com/oauth/request_token", arrayList, (KVPair<String>) null, this.f5896c.m6185a(this.f5896c.m6183a("https://api.twitter.com/oauth/request_token", arrayList)), "/oauth/request_token", m5994c());
            if (strM5966a == null) {
                return null;
            }
            String[] strArrSplit = strM5966a.split("&");
            HashMap map = new HashMap();
            for (String str : strArrSplit) {
                if (str != null) {
                    String[] strArrSplit2 = str.split("=");
                    if (strArrSplit2.length >= 2) {
                        map.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            }
            if (map.containsKey("oauth_token")) {
                String str2 = (String) map.get("oauth_token");
                m6487a(str2, (String) map.get("oauth_token_secret"));
                ShareSDK.logApiEvent("/oauth/authorize", m5994c());
                return "https://api.twitter.com/oauth/authorize?oauth_token=" + str2;
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0823b getAuthorizeWebviewClient(C0826e c0826e) {
        return new C0896a(c0826e);
    }

    /* JADX INFO: renamed from: a */
    public void m6486a(AuthorizeListener authorizeListener) {
        m5993b(authorizeListener);
    }

    /* JADX INFO: renamed from: a */
    public String m6483a(String str) {
        try {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("oauth_verifier", str));
            return this.f5897d.m5966a("https://api.twitter.com/oauth/access_token", arrayList, (KVPair<String>) null, this.f5896c.m6185a(this.f5896c.m6183a("https://api.twitter.com/oauth/access_token", arrayList)), "/oauth/access_token", m5994c());
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6489b(String str) {
        long j;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        try {
            j = ResHelper.parseLong(str);
        } catch (Throwable unused) {
            j = 0;
            str = null;
        }
        arrayList.add(new KVPair<>("user_id", str == null ? this.f5563a.getDb().getUserId() : String.valueOf(j)));
        String strM5968a = this.f5897d.m5968a("https://api.twitter.com/1.1/users/show.json", arrayList, this.f5896c.m6185a(this.f5896c.m6188b("https://api.twitter.com/1.1/users/show.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/users/show.json", m5994c());
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6490b(String str, String str2) {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("user_id", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String strM5968a = this.f5897d.m5968a("https://api.twitter.com/1.1/friends/list.json", arrayList, this.f5896c.m6185a(this.f5896c.m6188b("https://api.twitter.com/1.1/friends/list.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/friends/list.json", m5994c());
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6492c(String str, String str2) {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("user_id", str));
        } else {
            arrayList.add(new KVPair<>("screen_name", str));
        }
        String strM5968a = this.f5897d.m5968a("https://api.twitter.com/1.1/followers/list.json", arrayList, this.f5896c.m6185a(this.f5896c.m6188b("https://api.twitter.com/1.1/followers/list.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/followers/list.json", m5994c());
        if (strM5968a == null || strM5968a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5968a);
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6491c(String str) {
        return m6493d(str, null);
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6493d(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new KVPair<>("media_ids", str2));
        }
        String strM5966a = this.f5897d.m5966a("https://api.twitter.com/1.1/statuses/update.json", arrayList, (KVPair<String>) null, this.f5896c.m6185a(this.f5896c.m6183a("https://api.twitter.com/1.1/statuses/update.json", arrayList)), "/1.1/statuses/update.json", m5994c());
        if (strM5966a == null || strM5966a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5966a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6485a(String str, String[] strArr) throws Throwable {
        String strDownloadBitmap;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayListM6185a = this.f5896c.m6185a(this.f5896c.m6183a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        arrayListM6185a.remove(1);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < strArr.length && (arrayList2 == null || arrayList2.size() <= 3); i++) {
            try {
                strDownloadBitmap = strArr[i];
            } catch (Exception unused) {
                C0851d.m6195a().m8609d(sb.toString(), new Object[0]);
            }
            if (strDownloadBitmap.startsWith("http")) {
                strDownloadBitmap = BitmapHelper.downloadBitmap(this.f5563a.getContext(), strDownloadBitmap);
            } else {
                if (!TextUtils.isEmpty(strDownloadBitmap) && new File(strDownloadBitmap).exists()) {
                }
            }
            String strM5966a = this.f5897d.m5966a("https://upload.twitter.com/1.1/media/upload.json", arrayList, new KVPair<>("media", strDownloadBitmap), arrayListM6185a, "/1.1/media/upload.json", m5994c());
            sb.append(strArr[i]);
            sb.append(": ");
            sb.append(strM5966a);
            sb.append("\n");
            if (strM5966a != null && strM5966a.length() > 0) {
                arrayList2.add(new Hashon().fromJson(strM5966a));
            }
        }
        sb.setLength(0);
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (((HashMap) arrayList2.get(i2)).containsKey("image")) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(String.valueOf(((HashMap) arrayList2.get(i2)).get("media_id")));
            }
        }
        return m6493d(str, sb.toString());
    }

    /* JADX INFO: renamed from: e */
    public HashMap<String, Object> m6494e(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayListM6185a = this.f5896c.m6185a(this.f5896c.m6183a("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList));
        arrayListM6185a.remove(1);
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        String strM5966a = this.f5897d.m5966a("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList, new KVPair<>("media[]", str2), arrayListM6185a, "/1.1/statuses/update_with_media.json", m5994c());
        if (strM5966a == null || strM5966a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strM5966a);
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6484a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) {
        KVPair<String> kVPair;
        String strHttpPost;
        ArrayList<KVPair<String>> arrayListM6185a;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
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
        if (SpdyRequest.GET_METHOD.equals(str2.toUpperCase())) {
            strHttpPost = this.f5897d.httpGet(str, arrayList, this.f5896c.m6185a(this.f5896c.m6188b(str, arrayList)), null);
        } else if (SpdyRequest.POST_METHOD.equals(str2.toUpperCase())) {
            if (map2 == null || map2.size() <= 0) {
                arrayListM6185a = this.f5896c.m6185a(this.f5896c.m6183a(str, arrayList));
            } else {
                arrayListM6185a = this.f5896c.m6185a(this.f5896c.m6183a(str, new ArrayList<>()));
                arrayListM6185a.remove(1);
            }
            strHttpPost = this.f5897d.httpPost(str, arrayList, kVPair, arrayListM6185a, null);
        } else {
            strHttpPost = null;
        }
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }
}
