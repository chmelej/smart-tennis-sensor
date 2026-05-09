package cn.sharesdk.framework.p004b;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.p004b.p005a.C0831c;
import cn.sharesdk.framework.p004b.p005a.C0832d;
import cn.sharesdk.framework.p004b.p005a.C0833e;
import cn.sharesdk.framework.p004b.p006b.AbstractC0837c;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.c */
/* JADX INFO: compiled from: Protocols.java */
/* JADX INFO: loaded from: classes.dex */
public class C0842c {

    /* JADX INFO: renamed from: a */
    private String f5629a;

    /* JADX INFO: renamed from: b */
    private Context f5630b;

    /* JADX INFO: renamed from: c */
    private C0833e f5631c;

    /* JADX INFO: renamed from: d */
    private DeviceHelper f5632d;

    /* JADX INFO: renamed from: e */
    private NetworkHelper f5633e = new NetworkHelper();

    /* JADX INFO: renamed from: f */
    private Hashon f5634f = new Hashon();

    /* JADX INFO: renamed from: g */
    private String f5635g;

    /* JADX INFO: renamed from: h */
    private String f5636h;

    /* JADX INFO: renamed from: i */
    private boolean f5637i;

    /* JADX INFO: renamed from: j */
    private HashMap<String, String> f5638j;

    /* JADX INFO: renamed from: k */
    private String m6065k() {
        return "http://up.sharesdk.cn/upload/image";
    }

    /* JADX INFO: renamed from: m */
    private String m6067m() {
        return "http://l.mob.com/url/ShareSdkMapping.do";
    }

    public C0842c(Context context, String str) {
        this.f5629a = str;
        this.f5630b = context.getApplicationContext();
        this.f5631c = C0833e.m6025a(this.f5630b);
        this.f5632d = DeviceHelper.getInstance(this.f5630b);
        try {
            this.f5638j = (HashMap) this.f5631c.m6049h("buffered_server_paths");
        } catch (Throwable unused) {
            this.f5638j = new HashMap<>();
        }
        m6061g();
    }

    /* JADX INFO: renamed from: g */
    private void m6061g() {
        this.f5635g = (this.f5632d.getPackageName() + "/" + this.f5632d.getAppVersionName()) + " ShareSDK/2.8.0 " + ("Android/" + this.f5632d.getOSVersionInt());
        this.f5636h = "http://api.share.mob.com:80";
        this.f5637i = true;
    }

    /* JADX INFO: renamed from: a */
    public void m6072a(String str) {
        this.f5636h = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6074a(HashMap<String, String> map) {
        this.f5638j = map;
        this.f5631c.m6031a("buffered_server_paths", this.f5638j);
    }

    /* JADX INFO: renamed from: h */
    private String m6062h() {
        return this.f5636h + "/conn";
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6069a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", this.f5629a));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", this.f5635g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 30000;
        String strHttpPost = this.f5633e.httpPost(m6062h(), arrayList, null, arrayList2, networkTimeOut);
        C0851d.m6195a().m8615i(" isConnectToServer response == %s", strHttpPost);
        return this.f5634f.fromJson(strHttpPost);
    }

    /* JADX INFO: renamed from: i */
    private String m6063i() {
        if (this.f5638j != null && this.f5638j.containsKey("/date")) {
            return this.f5638j.get("/date") + "/date";
        }
        return this.f5636h + "/date";
    }

    /* JADX INFO: renamed from: b */
    public long m6076b() throws Throwable {
        if (!this.f5631c.m6047g()) {
            return 0L;
        }
        String strHttpGet = "{}";
        try {
            strHttpGet = this.f5633e.httpGet(m6063i(), null, null, null);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        HashMap mapFromJson = this.f5634f.fromJson(strHttpGet);
        if (mapFromJson.containsKey("timestamp")) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(mapFromJson.get("timestamp")));
                this.f5631c.m6030a("service_time", Long.valueOf(jCurrentTimeMillis));
                return jCurrentTimeMillis;
            } catch (Throwable th2) {
                C0851d.m6195a().m8610d(th2);
                return this.f5631c.m6026a();
            }
        }
        return this.f5631c.m6026a();
    }

    /* JADX INFO: renamed from: j */
    private String m6064j() {
        return this.f5636h + "/conf5";
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6079c() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", this.f5629a));
        arrayList.add(new KVPair<>("device", this.f5632d.getDeviceKey()));
        arrayList.add(new KVPair<>("plat", String.valueOf(this.f5632d.getPlatformCode())));
        arrayList.add(new KVPair<>("apppkg", this.f5632d.getPackageName()));
        arrayList.add(new KVPair<>("appver", String.valueOf(this.f5632d.getAppVersion())));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(60069)));
        arrayList.add(new KVPair<>("networktype", this.f5632d.getDetailNetworkTypeForStatic()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", this.f5635g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        String strHttpPost = this.f5633e.httpPost(m6064j(), arrayList, null, arrayList2, networkTimeOut);
        C0851d.m6195a().m8615i(" get server config response == %s", strHttpPost);
        return this.f5634f.fromJson(strHttpPost);
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6077b(String str) {
        KVPair<String> kVPair = new KVPair<>("file", str);
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("User-Agent", this.f5635g));
        String strHttpPost = this.f5633e.httpPost(m6065k(), null, kVPair, arrayList, null);
        C0851d.m6195a().m8615i("upload file response == %s", strHttpPost);
        return this.f5634f.fromJson(strHttpPost);
    }

    /* JADX INFO: renamed from: l */
    private String m6066l() {
        if (this.f5638j != null && this.f5638j.containsKey("/log4")) {
            return this.f5638j.get("/log4") + "/log4";
        }
        return this.f5636h + "/log4";
    }

    /* JADX INFO: renamed from: a */
    public boolean m6075a(String str, boolean z) {
        try {
            if ("none".equals(this.f5632d.getDetailNetworkTypeForStatic())) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("m", str));
            arrayList.add(new KVPair<>("t", z ? "1" : "0"));
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Agent", this.f5635g));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            String strHttpPost = this.f5633e.httpPost(m6066l(), arrayList, null, arrayList2, networkTimeOut);
            C0851d.m6195a().m8615i("> Upload All Log  resp: %s", strHttpPost);
            return TextUtils.isEmpty(strHttpPost) || ((Integer) this.f5634f.fromJson(strHttpPost).get(NotificationCompat.CATEGORY_STATUS)).intValue() == 200;
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6070a(String str, ArrayList<String> arrayList, int i, String str2) {
        if (!this.f5637i) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("key", this.f5629a));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new KVPair<>("urls", arrayList.get(i2).toString()));
        }
        arrayList2.add(new KVPair<>("deviceid", this.f5632d.getDeviceKey()));
        arrayList2.add(new KVPair<>("snsplat", String.valueOf(i)));
        String strM6060d = m6060d(str2);
        if (TextUtils.isEmpty(strM6060d)) {
            return null;
        }
        arrayList2.add(new KVPair<>("m", strM6060d));
        ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
        arrayList3.add(new KVPair<>("User-Agent", this.f5635g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 5000;
        networkTimeOut.connectionTimeout = 5000;
        String strHttpPost = this.f5633e.httpPost(m6067m(), arrayList2, null, arrayList3, networkTimeOut);
        C0851d.m6195a().m8615i("> SERVER_SHORT_LINK_URL  resp: %s", strHttpPost);
        if (TextUtils.isEmpty(strHttpPost)) {
            this.f5637i = false;
            return null;
        }
        HashMap<String, Object> mapFromJson = this.f5634f.fromJson(strHttpPost);
        if (((Integer) mapFromJson.get(NotificationCompat.CATEGORY_STATUS)).intValue() != 200) {
            return null;
        }
        return mapFromJson;
    }

    /* JADX INFO: renamed from: d */
    private String m6060d(String str) {
        boolean zM6037b = this.f5631c.m6037b();
        boolean zM6039c = this.f5631c.m6039c();
        StringBuilder sb = new StringBuilder();
        sb.append(Data.urlEncode(this.f5632d.getPackageName(), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(this.f5632d.getAppVersionName(), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(String.valueOf(60069), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(String.valueOf(this.f5632d.getPlatformCode()), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(this.f5632d.getDetailNetworkTypeForStatic(), "utf-8"));
        sb.append("|");
        if (zM6037b) {
            sb.append(Data.urlEncode(String.valueOf(this.f5632d.getOSVersionInt()), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(this.f5632d.getScreenSize(), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(this.f5632d.getManufacturer(), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(this.f5632d.getModel(), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(this.f5632d.getCarrier(), "utf-8"));
            sb.append("|");
        } else {
            sb.append("|||||");
        }
        if (zM6039c) {
            sb.append(str);
        } else {
            sb.append(str.split("\\|")[0]);
            sb.append("|||||");
        }
        String string = sb.toString();
        C0851d.m6195a().m8615i("shorLinkMsg ===>>>>", string);
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", this.f5632d.getDeviceKey(), this.f5629a)), string), 2);
    }

    /* JADX INFO: renamed from: n */
    private String m6068n() {
        if (this.f5638j != null && this.f5638j.containsKey("/snsconf")) {
            return this.f5638j.get("/snsconf") + "/snsconf";
        }
        return this.f5636h + "/snsconf";
    }

    /* JADX INFO: renamed from: d */
    public HashMap<String, Object> m6081d() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", this.f5629a));
        arrayList.add(new KVPair<>("device", this.f5632d.getDeviceKey()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Agent", this.f5635g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.f5634f.fromJson(this.f5633e.httpPost(m6068n(), arrayList, null, arrayList2, networkTimeOut));
    }

    /* JADX INFO: renamed from: a */
    public void m6071a(AbstractC0837c abstractC0837c) {
        C0832d.m6021a(this.f5630b, abstractC0837c.toString(), abstractC0837c.f5595e);
    }

    /* JADX INFO: renamed from: e */
    public ArrayList<C0831c> m6082e() {
        ArrayList<C0831c> arrayListM6023a = C0832d.m6023a(this.f5630b);
        return arrayListM6023a == null ? new ArrayList<>() : arrayListM6023a;
    }

    /* JADX INFO: renamed from: a */
    public void m6073a(ArrayList<String> arrayList) {
        C0832d.m6022a(this.f5630b, arrayList);
    }

    /* JADX INFO: renamed from: f */
    public HashMap<String, Object> m6083f() {
        return this.f5634f.fromJson(this.f5631c.m6043e(this.f5629a));
    }

    /* JADX INFO: renamed from: b */
    public void m6078b(HashMap<String, Object> map) {
        this.f5631c.m6032a(this.f5629a, this.f5634f.fromHashMap(map));
    }

    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m6080c(String str) throws ClassNotFoundException, IOException {
        return this.f5634f.fromJson(new String(Data.AES128Decode(Data.rawMD5(this.f5629a + ":" + this.f5632d.getDeviceKey()), Base64.decode(str, 2)), "UTF-8").trim());
    }
}
