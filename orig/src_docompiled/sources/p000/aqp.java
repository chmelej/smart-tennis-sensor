package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import p000.aqg;

/* JADX INFO: compiled from: DNSManager.java */
/* JADX INFO: loaded from: classes.dex */
class aqp {

    /* JADX INFO: renamed from: a */
    private volatile String f4731a;

    /* JADX INFO: renamed from: b */
    private volatile String f4732b;

    /* JADX INFO: renamed from: c */
    private volatile String f4733c;

    /* JADX INFO: renamed from: d */
    private volatile String f4734d;

    /* JADX INFO: renamed from: e */
    private volatile String f4735e;

    /* JADX INFO: renamed from: f */
    private volatile String f4736f;

    /* JADX INFO: renamed from: g */
    private volatile String f4737g;

    /* JADX INFO: renamed from: k */
    private volatile aqo f4741k;

    /* JADX INFO: renamed from: l */
    private volatile aqo f4742l;

    /* JADX INFO: renamed from: m */
    private volatile Context f4743m;

    /* JADX INFO: renamed from: p */
    private volatile RunnableC0731b f4746p;

    /* JADX INFO: renamed from: s */
    private volatile aqg f4749s;

    /* JADX INFO: renamed from: h */
    private volatile int f4738h = -1;

    /* JADX INFO: renamed from: i */
    private volatile long f4739i = -1;

    /* JADX INFO: renamed from: j */
    private volatile InterfaceC0730a f4740j = null;

    /* JADX INFO: renamed from: n */
    private volatile int f4744n = 0;

    /* JADX INFO: renamed from: o */
    private volatile boolean f4745o = false;

    /* JADX INFO: renamed from: q */
    private volatile double f4747q = 0.0d;

    /* JADX INFO: renamed from: r */
    private volatile double f4748r = 0.0d;

    /* JADX INFO: renamed from: aqp$a */
    /* JADX INFO: compiled from: DNSManager.java */
    public interface InterfaceC0730a {
        /* JADX INFO: renamed from: a */
        void mo5070a(aql aqlVar, String str);

        /* JADX INFO: renamed from: a */
        void mo5071a(aqo aqoVar, String str, int i, String str2);
    }

    aqp(Context context) {
        this.f4741k = aqo.SPDY;
        this.f4742l = aqo.SPDY;
        this.f4743m = null;
        this.f4746p = null;
        this.f4749s = null;
        this.f4743m = context;
        this.f4749s = new aqg();
        this.f4746p = new RunnableC0731b();
        this.f4741k = aqo.SPDY;
        this.f4742l = aqo.SPDY;
    }

    /* JADX INFO: renamed from: a */
    public final void m5106a(InterfaceC0730a interfaceC0730a) {
        this.f4740j = interfaceC0730a;
    }

    /* JADX INFO: renamed from: a */
    public final void m5105a(aqo aqoVar) {
        this.f4741k = aqoVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m5109a(String str, String str2, String str3, long j) {
        this.f4733c = str;
        this.f4731a = str2;
        this.f4732b = str3;
        this.f4739i = j;
    }

    /* JADX INFO: renamed from: a */
    public final void m5108a(String str, String str2, String str3) {
        this.f4735e = str;
        this.f4736f = str2;
        this.f4737g = str3;
    }

    /* JADX INFO: renamed from: a */
    public final void m5107a(String str, int i) {
        this.f4734d = str;
        this.f4738h = i;
    }

    /* JADX INFO: renamed from: b */
    public final void m5112b(aqo aqoVar) {
        if (this.f4745o) {
            aiv.m1418c("DNSManager", "DNSRemote[runing....]");
            return;
        }
        this.f4745o = true;
        try {
            this.f4746p.m5113a(aqoVar);
            new Thread(this.f4746p, "agoo-dns").start();
        } catch (Throwable unused) {
            m5104a(aql.HTTP_GATEWAY_TIMEOUT, "thread target  failed");
        }
    }

    /* JADX INFO: renamed from: aqp$b */
    /* JADX INFO: compiled from: DNSManager.java */
    final class RunnableC0731b implements Runnable {

        /* JADX INFO: renamed from: b */
        private volatile boolean f4752b = false;

        /* JADX INFO: renamed from: c */
        private volatile aqo f4753c = aqo.SPDY;

        RunnableC0731b() {
        }

        /* JADX INFO: renamed from: a */
        public void m5113a(aqo aqoVar) {
            this.f4753c = aqoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                } catch (Throwable th) {
                    aiv.m1421d("DNSManager", "host Throwable", th);
                    aqp.this.m5104a(aql.HTTP_GATEWAY_TIMEOUT, "remote get apoll failed");
                }
                if (this.f4752b) {
                    aiv.m1418c("DNSManager", "DNSRemote[runing....]");
                    return;
                }
                this.f4752b = true;
                if (aqp.this.f4742l == this.f4753c) {
                    if (aqp.this.m5111a()) {
                        aiv.m1418c("DNSManager", "refreshLocalHost successfully");
                        return;
                    } else {
                        aqp.this.m5099b();
                        return;
                    }
                }
                aiv.m1418c("DNSManager", "currentChannleType[" + aqp.this.f4742l.m5091a() + "]!=channelType[" + this.f4753c.m5091a() + "]");
                aqp.this.f4742l = this.f4753c;
                aqp.this.m5099b();
            } finally {
                this.f4752b = false;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m5111a() {
        boolean z = true;
        try {
            SharedPreferences sharedPreferences = this.f4743m.getSharedPreferences("AGOO_HOST", 4);
            int i = sharedPreferences.getInt("AGOO_HOST_SIZE", 0);
            if (i > 0 && this.f4744n < i) {
                String string = sharedPreferences.getString("AGOO_HOST_VALUE_" + this.f4744n, null);
                aqo aqoVarM5090a = aqo.m5090a(sharedPreferences.getInt("AGOO_HOST_TYPE", aqo.SPDY.m5092b()));
                aiv.m1418c("DNSManager", "refreshLocalHost,mHostIndex=" + this.f4744n);
                if (!TextUtils.isEmpty(string)) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.remove("AGOO_HOST_VALUE_" + this.f4744n);
                    editorEdit.commit();
                    m5097a(aqoVarM5090a, string, this.f4732b);
                    try {
                        this.f4744n++;
                        return true;
                    } catch (Throwable unused) {
                        m5104a(aql.HTTP_GATEWAY_TIMEOUT, "refresh failed");
                        return z;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            z = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m5099b() {
        int i;
        String str;
        aqg.C0720a c0720aM5014a;
        try {
            aqf aqfVar = new aqf();
            aqfVar.m5012a("deviceId", this.f4732b);
            aqfVar.m5012a("app_version_code", "" + m5103d());
            aqfVar.m5012a("agoo_version_code", "" + this.f4739i);
            if (!TextUtils.isEmpty(this.f4731a)) {
                aqfVar.m5012a("appkey", "" + this.f4731a);
            }
            int i2 = this.f4738h;
            if (C07291.f4750a[this.f4741k.ordinal()] == 1) {
                i = i2;
                str = String.format("%s/%s/", this.f4733c, "activeip");
            } else {
                str = String.format("%s/%s/", this.f4733c, "spdyip");
                i = 80;
            }
            aiv.m1418c("DNSManager", "apollUrl" + str);
            ahp ahpVar = new ahp(this.f4743m);
            String strM1241c = ahpVar.m1241c();
            if (!TextUtils.isEmpty(strM1241c)) {
                aqfVar.m5012a("nt", strM1241c);
            }
            String strM1240b = ahpVar.m1240b();
            if (!TextUtils.isEmpty(strM1240b)) {
                aqfVar.m5012a("apn", strM1240b);
            }
            String strM5102c = m5102c();
            if (!TextUtils.isEmpty(strM5102c)) {
                aqfVar.m5012a("agoo_operators", strM5102c);
            }
            if (!TextUtils.isEmpty(this.f4735e)) {
                aqfVar.m5012a("ttid", "" + this.f4735e);
            }
            if (!TextUtils.isEmpty(this.f4736f)) {
                aqfVar.m5012a("imei", "" + this.f4736f);
            }
            if (!TextUtils.isEmpty(this.f4737g)) {
                aqfVar.m5012a("imsi", "" + this.f4737g);
            }
            if (new BigDecimal(this.f4748r).compareTo(new BigDecimal(0.0d)) != 0) {
                aqfVar.m5012a("lac", "" + this.f4748r);
            }
            if (new BigDecimal(this.f4747q).compareTo(new BigDecimal(0.0d)) != 0) {
                aqfVar.m5012a("lat", "" + this.f4747q);
            }
            if (!TextUtils.isEmpty(this.f4734d) && this.f4738h != -1) {
                c0720aM5014a = this.f4749s.m5015a(this.f4743m, new HttpHost(this.f4734d, i), str, aqfVar);
            } else {
                c0720aM5014a = this.f4749s.m5014a(this.f4743m, str, aqfVar);
            }
            if (c0720aM5014a == null) {
                aqj aqjVar = new aqj(this.f4743m, "dnsRequestError");
                LinkedHashMap<String, String> linkedHashMapM5095a = m5095a(this.f4743m);
                linkedHashMapM5095a.put("faileReasons", "result == null");
                aqjVar.m5023a(linkedHashMapM5095a);
                m5096a(this.f4743m, aql.HTTP_MOVED_TEMP.toString(), this.f4733c);
                m5104a(aql.HTTP_MOVED_TEMP, this.f4733c);
                return;
            }
            Map<String, String> map = c0720aM5014a.f4638b;
            if (map != null && !map.isEmpty()) {
                String str2 = map.get("server");
                if (TextUtils.isEmpty(str2)) {
                    aiv.m1418c("DNSManager", "register--->[serverName==null]");
                    aqj aqjVar2 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a2 = m5095a(this.f4743m);
                    linkedHashMapM5095a2.put("faileReasons", "[serverName==null]");
                    aqjVar2.m5023a(linkedHashMapM5095a2);
                    m5096a(this.f4743m, "serverName==null", str);
                    m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
                    return;
                }
                if (!aid.m1306a(str2)) {
                    aiv.m1418c("DNSManager", "register--->[serverName!=wjas]");
                    aqj aqjVar3 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a3 = m5095a(this.f4743m);
                    linkedHashMapM5095a3.put("faileReasons", "[serverName!=wjas]");
                    aqjVar3.m5023a(linkedHashMapM5095a3);
                    m5096a(this.f4743m, "serverName!=wjas", str);
                    m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
                    return;
                }
                if (300 <= c0720aM5014a.f4637a && 400 > c0720aM5014a.f4637a) {
                    aqj aqjVar4 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a4 = m5095a(this.f4743m);
                    linkedHashMapM5095a4.put("faileReasons", Integer.toString(c0720aM5014a.f4637a));
                    aqjVar4.m5023a(linkedHashMapM5095a4);
                    m5096a(this.f4743m, "300<=statusCode<400", str);
                    m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
                    return;
                }
                if (400 <= c0720aM5014a.f4637a && 500 > c0720aM5014a.f4637a) {
                    aqj aqjVar5 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a5 = m5095a(this.f4743m);
                    linkedHashMapM5095a5.put("faileReasons", Integer.toString(c0720aM5014a.f4637a));
                    aqjVar5.m5023a(linkedHashMapM5095a5);
                    m5096a(this.f4743m, "400<=statusCode<500", str);
                    m5104a(aql.DNS_NOT_FOUND, "get [" + str + "] error");
                    return;
                }
                if (200 != c0720aM5014a.f4637a) {
                    aqj aqjVar6 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a6 = m5095a(this.f4743m);
                    linkedHashMapM5095a6.put("faileReasons", Integer.toString(c0720aM5014a.f4637a));
                    aqjVar6.m5023a(linkedHashMapM5095a6);
                    m5096a(this.f4743m, Integer.toString(c0720aM5014a.f4637a), str);
                    m5104a(aql.DNS_NOT_FOUND, "get [" + str + "] error");
                    return;
                }
                if (TextUtils.isEmpty(c0720aM5014a.f4639c)) {
                    aqj aqjVar7 = new aqj(this.f4743m, "dnsRequestError");
                    LinkedHashMap<String, String> linkedHashMapM5095a7 = m5095a(this.f4743m);
                    linkedHashMapM5095a7.put("faileReasons", "responseBody is null");
                    aqjVar7.m5023a(linkedHashMapM5095a7);
                    m5096a(this.f4743m, "responseBody is null", str);
                    m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
                    return;
                }
                String[] strArrM5098a = m5098a(c0720aM5014a.f4639c);
                if (strArrM5098a != null && strArrM5098a.length > 0) {
                    this.f4742l = this.f4741k;
                    if (c0720aM5014a.f4638b != null && TextUtils.equals(c0720aM5014a.f4638b.get("spdy"), "off")) {
                        this.f4742l = aqo.CHUNKED;
                    }
                    aiv.m1418c("DNSManager", " initChannel[" + this.f4741k.m5091a() + "]--> resultChannel[" + this.f4742l.m5091a() + "]");
                    new aqj(this.f4743m, "dnsRequestSuccess").m5023a(m5095a(this.f4743m));
                    m5110a(strArrM5098a, this.f4742l);
                    m5097a(this.f4742l, strArrM5098a[0], this.f4732b);
                    return;
                }
                m5096a(this.f4743m, "ips==null", str);
                aqj aqjVar8 = new aqj(this.f4743m, "dnsRequestError");
                LinkedHashMap<String, String> linkedHashMapM5095a8 = m5095a(this.f4743m);
                linkedHashMapM5095a8.put("faileReasons", "ips==null");
                aqjVar8.m5023a(linkedHashMapM5095a8);
                m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
                return;
            }
            aqj aqjVar9 = new aqj(this.f4743m, "dnsRequestError");
            LinkedHashMap<String, String> linkedHashMapM5095a9 = m5095a(this.f4743m);
            linkedHashMapM5095a9.put("faileReasons", "headers==null");
            aqjVar9.m5023a(linkedHashMapM5095a9);
            m5096a(this.f4743m, "headers==null", str);
            m5104a(aql.HTTP_MOVED_TEMP, "get [" + str + "] error");
        } catch (Throwable th) {
            aiv.m1421d("DNSManager", "host Throwable", th);
            m5104a(aql.DNS_REQUEST_FAILED, "remote get apoll failed");
        }
    }

    /* JADX INFO: renamed from: aqp$1 */
    /* JADX INFO: compiled from: DNSManager.java */
    static /* synthetic */ class C07291 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4750a = new int[aqo.values().length];

        static {
            try {
                f4750a[aqo.CHUNKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private LinkedHashMap<String, String> m5095a(Context context) {
        Throwable th;
        LinkedHashMap<String, String> linkedHashMap;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("AGOO_CONNECT", 4);
            String string = sharedPreferences.getString("AGOO_CONNECT_HOST", null);
            int i = sharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
            String strM1241c = new ahp(context).m1241c();
            long j = context.getSharedPreferences("AppStore", 4).getLong("agoo_release_time", 0L);
            linkedHashMap = new LinkedHashMap<>();
            try {
                linkedHashMap.put("ip", string);
                linkedHashMap.put("port", Integer.toString(i));
                linkedHashMap.put("netType", strM1241c);
                linkedHashMap.put("appKey", this.f4731a);
                linkedHashMap.put("deviceId", this.f4732b);
                linkedHashMap.put("agooReleasetime", Long.toString(j));
            } catch (Throwable th2) {
                th = th2;
                Log.d("getConnectHeader", "e=" + th.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            linkedHashMap = null;
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    final void m5110a(String[] strArr, aqo aqoVar) {
        try {
            SharedPreferences.Editor editorEdit = this.f4743m.getSharedPreferences("AGOO_HOST", 4).edit();
            editorEdit.clear();
            int length = strArr.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    editorEdit.putString("AGOO_HOST_VALUE_" + i, strArr[i2]);
                    i++;
                }
            }
            editorEdit.putInt("AGOO_HOST_TYPE", aqoVar.m5092b());
            editorEdit.putInt("AGOO_HOST_SIZE", i);
            editorEdit.commit();
            this.f4744n = 0;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private String[] m5098a(String str) {
        String[] strArrSplit = TextUtils.split(str, "\\|");
        for (String str2 : strArrSplit) {
            if (!m5101b(str2)) {
                return null;
            }
        }
        return strArrSplit;
    }

    /* JADX INFO: renamed from: a */
    private final void m5096a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_dns_errorid", str);
            editorEdit.putString("agoo_dns_path", str2);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private final boolean m5101b(String str) {
        String str2 = "((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d)";
        return Pattern.compile("(" + str2 + ").(" + str2 + ").(" + str2 + ").(" + str2 + "):\\d*$").matcher(str).matches();
    }

    /* JADX INFO: renamed from: c */
    private final String m5102c() {
        String strM1300b = aic.m1300b(this.f4743m);
        if (TextUtils.isEmpty(strM1300b)) {
            return null;
        }
        if (strM1300b.startsWith("46000") || strM1300b.startsWith("46002")) {
            return "china_mobile";
        }
        if (strM1300b.startsWith("46001")) {
            return "china_unicom";
        }
        if (strM1300b.startsWith("46003")) {
            return "china_telecom";
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    private final String m5103d() {
        try {
            return this.f4743m.getPackageManager().getPackageInfo(this.f4743m.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m5097a(aqo aqoVar, String str, String str2) {
        if (this.f4745o) {
            try {
                try {
                } catch (Throwable unused) {
                    m5104a(aql.DNS_PARSE_FAILED, "parse apoll host[" + str + "] failed");
                }
                if (TextUtils.isEmpty(str)) {
                    m5104a(aql.DNS_PARSE_FAILED, "parse apoll host[" + str + "] failed");
                    return;
                }
                String[] strArrSplit = TextUtils.split(str, ":");
                String str3 = null;
                int iIntValue = -1;
                if (strArrSplit != null && strArrSplit.length > 0) {
                    str3 = strArrSplit[0];
                    iIntValue = 80;
                    try {
                        iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                    } catch (RuntimeException unused2) {
                    }
                }
                if (this.f4740j != null) {
                    this.f4740j.mo5071a(aqoVar, str3, iIntValue, str2);
                }
            } finally {
                this.f4745o = false;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m5104a(aql aqlVar, String str) {
        if (this.f4745o) {
            try {
                if (this.f4740j != null) {
                    this.f4740j.mo5070a(aqlVar, str);
                }
            } catch (Throwable unused) {
            }
            this.f4745o = false;
        }
    }
}
