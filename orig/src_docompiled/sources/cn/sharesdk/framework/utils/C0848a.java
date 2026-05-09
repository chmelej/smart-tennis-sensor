package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.http.client.util.URLEncodedUtils;
import com.mob.tools.network.KVPair;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyRequest;

/* JADX INFO: renamed from: cn.sharesdk.framework.utils.a */
/* JADX INFO: compiled from: Oauth1Signer.java */
/* JADX INFO: loaded from: classes.dex */
public class C0848a {

    /* JADX INFO: renamed from: a */
    private b f5695a = new b();

    /* JADX INFO: renamed from: b */
    private C0849b f5696b = new C0849b("-._~", false);

    /* JADX INFO: renamed from: cn.sharesdk.framework.utils.a$a */
    /* JADX INFO: compiled from: Oauth1Signer.java */
    public enum a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* JADX INFO: renamed from: cn.sharesdk.framework.utils.a$b */
    /* JADX INFO: compiled from: Oauth1Signer.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public String f5701a;

        /* JADX INFO: renamed from: b */
        public String f5702b;

        /* JADX INFO: renamed from: c */
        public String f5703c;

        /* JADX INFO: renamed from: d */
        public String f5704d;

        /* JADX INFO: renamed from: e */
        public String f5705e;
    }

    /* JADX INFO: renamed from: a */
    public void m6187a(String str, String str2, String str3) {
        this.f5695a.f5701a = str;
        this.f5695a.f5702b = str2;
        this.f5695a.f5705e = str3;
    }

    /* JADX INFO: renamed from: a */
    public b m6181a() {
        return this.f5695a;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<KVPair<String>> m6183a(String str, ArrayList<KVPair<String>> arrayList) {
        return m6184a(str, arrayList, a.HMAC_SHA1);
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<KVPair<String>> m6184a(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return m6179a(str, SpdyRequest.POST_METHOD, arrayList, aVar);
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<KVPair<String>> m6188b(String str, ArrayList<KVPair<String>> arrayList) {
        return m6189b(str, arrayList, a.HMAC_SHA1);
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<KVPair<String>> m6189b(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return m6179a(str, SpdyRequest.GET_METHOD, arrayList, aVar);
    }

    /* JADX INFO: renamed from: c */
    public ArrayList<KVPair<String>> m6190c(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return m6179a(str, "PUT", arrayList, aVar);
    }

    /* JADX INFO: renamed from: a */
    public void m6186a(String str, String str2) {
        this.f5695a.f5703c = str;
        this.f5695a.f5704d = str2;
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<KVPair<String>> m6179a(String str, String str2, ArrayList<KVPair<String>> arrayList, a aVar) throws NoSuchAlgorithmException, InvalidKeyException {
        String strTrim;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = null;
        switch (aVar) {
            case HMAC_SHA1:
                str3 = "HMAC-SHA1";
                SecretKeySpec secretKeySpec = new SecretKeySpec((m6182a(this.f5695a.f5702b) + '&' + m6182a(this.f5695a.f5704d)).getBytes("utf-8"), "HMAC-SHA1");
                Mac mac = Mac.getInstance("HMAC-SHA1");
                mac.init(secretKeySpec);
                strTrim = new String(Base64.encode(mac.doFinal((str2 + '&' + m6182a(str) + '&' + m6182a(m6180b(m6178a(jCurrentTimeMillis, arrayList, "HMAC-SHA1")))).getBytes("utf-8")), 0)).trim();
                break;
            case PLAINTEXT:
                str3 = "PLAINTEXT";
                strTrim = m6182a(this.f5695a.f5702b) + '&' + m6182a(this.f5695a.f5704d);
                break;
            default:
                strTrim = null;
                break;
        }
        ArrayList<KVPair<String>> arrayListM6177a = m6177a(jCurrentTimeMillis, str3);
        arrayListM6177a.add(new KVPair<>("oauth_signature", strTrim));
        return arrayListM6177a;
    }

    /* JADX INFO: renamed from: a */
    public String m6182a(String str) {
        return str == null ? "" : this.f5696b.escape(str);
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<KVPair<String>> m6178a(long j, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                map.put(m6182a(kVPair.name), m6182a(kVPair.value));
            }
        }
        ArrayList<KVPair<String>> arrayListM6177a = m6177a(j, str);
        if (arrayListM6177a != null) {
            for (KVPair<String> kVPair2 : arrayListM6177a) {
                map.put(m6182a(kVPair2.name), m6182a(kVPair2.value));
            }
        }
        String[] strArr = new String[map.size()];
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = (String) ((Map.Entry) it.next()).getKey();
            i++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (String str2 : strArr) {
            arrayList2.add(new KVPair<>(str2, map.get(str2)));
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: b */
    private String m6180b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (KVPair<String> kVPair : arrayList) {
            if (i > 0) {
                sb.append('&');
            }
            sb.append(kVPair.name);
            sb.append('=');
            sb.append(kVPair.value);
            i++;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private ArrayList<KVPair<String>> m6177a(long j, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f5695a.f5701a));
        arrayList.add(new KVPair<>("oauth_signature_method", str));
        arrayList.add(new KVPair<>("oauth_timestamp", String.valueOf(j / 1000)));
        arrayList.add(new KVPair<>("oauth_nonce", String.valueOf(j)));
        arrayList.add(new KVPair<>("oauth_version", "1.0"));
        String str2 = this.f5695a.f5703c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair<>("oauth_token", str2));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<KVPair<String>> m6185a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder("OAuth ");
        int i = 0;
        for (KVPair<String> kVPair : arrayList) {
            if (i > 0) {
                sb.append(',');
            }
            String strM6182a = m6182a(kVPair.value);
            sb.append(kVPair.name);
            sb.append("=\"");
            sb.append(strM6182a);
            sb.append("\"");
            i++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("Authorization", sb.toString()));
        arrayList2.add(new KVPair<>(MIME.CONTENT_TYPE, URLEncodedUtils.CONTENT_TYPE));
        return arrayList2;
    }
}
