package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p000.aqp;

/* JADX INFO: compiled from: ChannelManager.java */
/* JADX INFO: loaded from: classes.dex */
public class aqm {

    /* JADX INFO: renamed from: a */
    private static volatile Map<String, String> f4695a = null;

    /* JADX INFO: renamed from: b */
    private static volatile long f4696b = 30000;

    /* JADX INFO: renamed from: c */
    private static volatile Map<String, String> f4697c = null;

    /* JADX INFO: renamed from: f */
    private static volatile Context f4700f = null;

    /* JADX INFO: renamed from: g */
    private static volatile aqs f4701g = null;

    /* JADX INFO: renamed from: h */
    private static volatile String f4702h = null;

    /* JADX INFO: renamed from: i */
    private static volatile String f4703i = null;

    /* JADX INFO: renamed from: j */
    private static volatile String f4704j = null;

    /* JADX INFO: renamed from: k */
    private static volatile String f4705k = null;

    /* JADX INFO: renamed from: l */
    private static volatile boolean f4706l = true;

    /* JADX INFO: renamed from: m */
    private static volatile aqp f4707m = null;

    /* JADX INFO: renamed from: o */
    private static volatile boolean f4709o = false;

    /* JADX INFO: renamed from: p */
    private volatile String f4710p;

    /* JADX INFO: renamed from: q */
    private volatile int f4711q;

    /* JADX INFO: renamed from: r */
    private volatile aqq f4712r;

    /* JADX INFO: renamed from: s */
    private volatile short f4713s;

    /* JADX INFO: renamed from: t */
    private volatile long f4714t;

    /* JADX INFO: renamed from: u */
    private volatile long f4715u;

    /* JADX INFO: renamed from: v */
    private final aqp.InterfaceC0730a f4716v;

    /* JADX INFO: renamed from: w */
    private volatile boolean f4717w;

    /* JADX INFO: renamed from: x */
    private volatile Object f4718x;

    /* JADX INFO: renamed from: d */
    private static volatile aqo f4698d = aqo.SPDY;

    /* JADX INFO: renamed from: e */
    private static volatile aqk f4699e = aqk.NET_CHANGED;

    /* JADX INFO: renamed from: n */
    private static volatile aqu f4708n = aqu.REMOTE;

    private aqm() {
        this.f4710p = null;
        this.f4711q = -1;
        this.f4712r = null;
        this.f4714t = -1L;
        this.f4715u = -1L;
        this.f4716v = new aqp.InterfaceC0730a() { // from class: aqm.1
            @Override // p000.aqp.InterfaceC0730a
            /* JADX INFO: renamed from: a */
            public void mo5071a(aqo aqoVar, String str, int i, String str2) {
                try {
                    if (!TextUtils.isEmpty(str) && i > 0) {
                        boolean unused = aqm.f4706l = false;
                        aqm.this.f4710p = str;
                        aqm.this.f4711q = i;
                        aqo unused2 = aqm.f4698d = aqoVar;
                    }
                    aqm.this.m5063a(str2);
                } catch (Throwable unused3) {
                    aqm.this.m5040a(aql.DNS_PARSE_FAILED, "host [" + str + "] failed");
                }
                aqm.this.f4717w = false;
            }

            @Override // p000.aqp.InterfaceC0730a
            /* JADX INFO: renamed from: a */
            public void mo5070a(aql aqlVar, String str) {
                aqm.this.f4717w = false;
                aqm.this.m5040a(aqlVar, str);
            }
        };
        this.f4717w = false;
        this.f4718x = null;
        f4707m.m5106a(this.f4716v);
    }

    /* JADX INFO: renamed from: aqm$a */
    /* JADX INFO: compiled from: ChannelManager.java */
    public static final class C0728a {
        /* JADX INFO: renamed from: a */
        public final C0728a m5074a(long j, long j2) {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final C0728a m5086b(long j) {
            return this;
        }

        public C0728a(Context context, String str, String str2) {
            Context unused = aqm.f4700f = context;
            aqp unused2 = aqm.f4707m = new aqp(context);
            Map unused3 = aqm.f4695a = new HashMap();
            Map unused4 = aqm.f4697c = new HashMap();
            boolean unused5 = aqm.f4706l = true;
            String unused6 = aqm.f4704j = str;
            String unused7 = aqm.f4702h = str2;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5077a(aqs aqsVar) {
            aqs unused = aqm.f4701g = aqsVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5081a(String str, long j) {
            aqm.f4707m.m5109a(str, aqm.f4704j, aqm.f4702h, j);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5083a(String str, String str2, String str3) {
            aqm.f4707m.m5108a(str, str2, str3);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5080a(String str, int i) {
            aqm.f4707m.m5107a(str, i);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5079a(String str) {
            String unused = aqm.f4703i = str;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final C0728a m5087b(String str) {
            String unused = aqm.f4705k = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5073a(long j) {
            long unused = aqm.f4696b = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5072a() {
            boolean unused = aqm.f4706l = true;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final C0728a m5085b() {
            boolean unused = aqm.f4709o = true;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5084a(boolean z) {
            if (z) {
                aqm.f4697c.put("c0", Build.BRAND);
                aqm.f4697c.put("c1", Build.MODEL);
                aqm.f4697c.put("c2", aic.m1302d(aqm.f4700f));
                aqm.f4697c.put("c3", aic.m1303e(aqm.f4700f));
                aqm.f4697c.put("c4", aic.m1301c(aqm.f4700f));
                aqm.f4697c.put("c5", aic.m1297a());
                aqm.f4697c.put("c6", aic.m1304f(aqm.f4700f));
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5076a(aqo aqoVar) {
            aqo unused = aqm.f4698d = aqoVar;
            aqm.f4707m.m5105a(aqoVar);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5078a(aqu aquVar) {
            aqu unused = aqm.f4708n = aquVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5075a(aqk aqkVar) {
            aqk unused = aqm.f4699e = aqkVar;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final C0728a m5088c(String str) {
            aqm.f4695a.remove(str);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C0728a m5082a(String str, String str2) {
            aqm.f4695a.put(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final aqm m5089c() {
            return new aqm();
        }
    }

    /* JADX INFO: renamed from: a */
    public final aqo m5061a() {
        return f4698d;
    }

    /* JADX INFO: renamed from: b */
    public final aqn m5065b() {
        try {
            if (this.f4712r != null) {
                return this.f4712r.mo5120e();
            }
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "readyChannelState", th);
        }
        return aqn.DISCONNECTED;
    }

    /* JADX INFO: renamed from: a */
    public final void m5064a(String str, byte[] bArr, aqr aqrVar) {
        try {
            if (this.f4712r != null) {
                this.f4712r.mo5114a(str, bArr, aqrVar);
            }
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "send", th);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m5066c() {
        try {
            if (this.f4712r == null || this.f4712r.mo5120e() != aqn.OPEN) {
                return;
            }
            HashMap map = new HashMap();
            map.putAll(f4697c);
            String str = String.format("http://%s:%d/%s/%s/%d/%s", this.f4710p, Integer.valueOf(this.f4711q), "h", f4704j, Integer.valueOf(m5058n()), f4702h);
            String strM5125a = aqt.m5125a(f4700f, str, map, f4704j, f4705k);
            if (TextUtils.isEmpty(strM5125a)) {
                aiv.m1420d("ChannelManager", "hisMessage[sgin==null]");
                m5040a(aql.SIGN_FAILED, "");
                return;
            }
            URI uri = new URI(m5038a(str, map, strM5125a));
            String str2 = uri.getPath() + "?" + uri.getQuery();
            aiv.m1415b("ChannelManager", "hisMessage url [" + str2 + "]");
            this.f4712r.mo5114a(str2, null, null);
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "send", th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m5060a(String str, String str2, String str3) {
        String str4;
        int i = -1;
        try {
            if (this.f4712r == null || this.f4712r.mo5120e() != aqn.OPEN) {
                return -1;
            }
            HashMap map = new HashMap();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return -1;
            }
            map.putAll(f4697c);
            map.put("id", str);
            if (!TextUtils.isEmpty(str2)) {
                map.put("del_pack", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("ec", str3);
            }
            String str5 = String.format("http://%s:%d/%s/%s/%d/%s", this.f4710p, Integer.valueOf(this.f4711q), "A_R", f4704j, Integer.valueOf(m5058n()), f4702h);
            String strM5125a = aqt.m5125a(f4700f, str5, map, f4704j, f4705k);
            if (TextUtils.isEmpty(strM5125a)) {
                aiv.m1420d("ChannelManager", "reportMessages[sgin==null]");
                m5040a(aql.SIGN_FAILED, "");
                return -1;
            }
            URI uri = new URI(m5038a(str5, map, strM5125a));
            String str6 = uri.getPath() + "?" + uri.getQuery();
            try {
                aiv.m1415b("ChannelManager", "reportMessages url [" + str6 + "]");
                int iMo5114a = this.f4712r.mo5114a(str6, null, null);
                if (iMo5114a == 0 || iMo5114a == -1) {
                    return iMo5114a;
                }
                try {
                    aqj aqjVar = new aqj(f4700f, "ackFailed");
                    LinkedHashMap<String, String> linkedHashMapM1305g = aic.m1305g(f4700f);
                    linkedHashMapM1305g.put("ackRequestCode", Integer.toString(iMo5114a));
                    aqjVar.m5023a(linkedHashMapM1305g);
                    return this.f4712r.mo5114a(str6, null, null);
                } catch (Throwable th) {
                    i = iMo5114a;
                    str4 = str6;
                    th = th;
                    aqj aqjVar2 = new aqj(f4700f, "ackFailed");
                    LinkedHashMap<String, String> linkedHashMapM1305g2 = aic.m1305g(f4700f);
                    linkedHashMapM1305g2.put("ackRequestCode", Integer.toString(i));
                    aqjVar2.m5023a(linkedHashMapM1305g2);
                    int iMo5114a2 = this.f4712r.mo5114a(str4, null, null);
                    aiv.m1419c("ChannelManager", "reportMessages", th);
                    return iMo5114a2;
                }
            } catch (Throwable th2) {
                str4 = str6;
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            str4 = null;
        }
    }

    /* JADX INFO: renamed from: m */
    private final void m5057m() {
        switch (f4698d) {
            case SPDY:
                try {
                    if (this.f4712r != null && f4709o && (this.f4712r instanceof aqx)) {
                        this.f4712r.mo5118c();
                        this.f4712r = new aqx();
                        f4709o = false;
                    }
                    if (this.f4712r == null || !(this.f4712r instanceof aqx)) {
                        this.f4712r = new aqx();
                    }
                } catch (Throwable th) {
                    aiv.m1419c("ChannelManager", "builder.changeChannel.initSpdy", th);
                    m5040a(aql.SPDY_INIT_THROWABLE, "builder.changeChannel.initSpdy error");
                }
                break;
            case CHUNKED:
                try {
                    if (this.f4712r == null || !(this.f4712r instanceof aqv)) {
                        this.f4712r = new aqv();
                    }
                } catch (Throwable th2) {
                    m5040a(aql.CHUNKED_INIT_THROWABLE, "builder.changeChannel.initSpdy error");
                    aiv.m1419c("ChannelManager", "builder.changeChannel.initChunked", th2);
                    return;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m5062a(Object obj) {
        this.f4718x = obj;
    }

    /* JADX INFO: renamed from: a */
    public final void m5063a(String str) {
        try {
            if (!f4706l && this.f4710p != null && -1 != this.f4711q) {
                if (m5065b() == aqn.CONNECTING) {
                    aiv.m1418c("ChannelManager", "connenct[connecting]");
                    return;
                } else {
                    m5050f(str);
                    return;
                }
            }
            if (this.f4717w) {
                aiv.m1418c("ChannelManager", "connenct[dnsing]");
            } else {
                this.f4717w = true;
                f4707m.m5112b(f4698d);
            }
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "connenct", th);
        }
    }

    /* JADX INFO: renamed from: f */
    private final void m5050f(String str) {
        try {
            m5057m();
            if (this.f4712r == null) {
                aiv.m1418c("ChannelManager", "dataChannel==null");
                return;
            }
            m5059o();
            String strM5124a = aqt.m5124a(f4700f, f4698d.m5092b(), this.f4713s, this.f4714t, this.f4715u, f4699e.m5024a(), f4708n.m5129a());
            HashMap map = new HashMap();
            map.putAll(f4695a);
            HashMap map2 = new HashMap();
            f4697c.put("ov", Build.VERSION.RELEASE);
            f4697c.put("sv", aic.m1305g(f4700f).get("agooReleaseTime"));
            f4697c.put("pm", ahw.m1271a(Build.MODEL.getBytes()));
            map2.putAll(f4697c);
            if (!TextUtils.isEmpty(strM5124a)) {
                map2.put("c", strM5124a);
            }
            String str2 = String.format("http://%s:%d/%s/%s/%d/%s", this.f4710p, Integer.valueOf(this.f4711q), f4703i, f4704j, Integer.valueOf(m5058n()), f4702h);
            String strM5125a = aqt.m5125a(f4700f, str2, map2, f4704j, f4705k);
            if (TextUtils.isEmpty(strM5125a)) {
                m5040a(aql.SIGN_FAILED, "");
                return;
            }
            String strM5038a = m5038a(str2, map2, strM5125a);
            Log.d("ChannelManager", "mCurrentChannelType = " + f4698d);
            switch (f4698d) {
                case SPDY:
                    aiv.m1418c("ChannelManager", "connenct  [SpdyChannel]");
                    break;
                case CHUNKED:
                    aiv.m1418c("ChannelManager", "connenct  [ChunkedChannel]");
                    break;
                default:
                    aiv.m1418c("ChannelManager", "connenct  [SpdyChannel]");
                    break;
            }
            SharedPreferences.Editor editorEdit = f4700f.getSharedPreferences("AGOO_CONNECT", 4).edit();
            editorEdit.putString("AGOO_CONNECT_HOST", this.f4710p);
            editorEdit.putInt("AGOO_CONNECT_PORT", this.f4711q);
            editorEdit.commit();
            this.f4712r.mo5116a(this.f4718x, f4700f, strM5038a, map, f4696b, f4701g, str);
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "_connenct", th);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m5067d() {
        try {
            if (this.f4712r == null || m5065b() != aqn.OPEN) {
                return;
            }
            this.f4712r.mo5115a();
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "disconnect", th);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m5068e() {
        try {
            if (this.f4712r != null) {
                this.f4712r.mo5119d();
            }
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "shutdown", th);
        }
    }

    /* JADX INFO: renamed from: f */
    public final long m5069f() {
        try {
            if (this.f4712r != null) {
                return this.f4712r.mo5117b();
            }
            return -1L;
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "ping", th);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    private final String m5038a(String str, Map<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder();
        try {
            aqf aqfVar = new aqf();
            if (map != null && (r6 = map.entrySet().iterator()) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !aie.m1309a(entry.getKey()) && !aie.m1309a(entry.getValue())) {
                        aqfVar.m5012a(entry.getKey(), entry.getValue());
                    }
                }
            }
            sb.append(str);
            String strM5011a = aqfVar.m5011a();
            if (TextUtils.indexOf(str, "?") == -1) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append("s=" + str2);
            if (!TextUtils.isEmpty(strM5011a)) {
                sb.append("&");
                sb.append(strM5011a);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: n */
    private static final int m5058n() {
        try {
            return f4700f.getPackageManager().getPackageInfo(f4700f.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            aiv.m1419c("ChannelManager", "getAppVersionCode", th);
            return -1;
        }
    }

    /* JADX INFO: renamed from: o */
    private final void m5059o() {
        try {
            SharedPreferences sharedPreferences = f4700f.getSharedPreferences("AGOO_CONNECT", 4);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f4715u = sharedPreferences.getLong("AGOO_CONNECT_CLIENT_CREATE_TIME", jCurrentTimeMillis);
            this.f4714t = sharedPreferences.getLong("AGOO_CONNECT_LAST_RECONNECT_TIME", jCurrentTimeMillis);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (this.f4715u == jCurrentTimeMillis) {
                editorEdit.putLong("AGOO_CONNECT_CLIENT_CREATE_TIME", jCurrentTimeMillis);
            }
            try {
                this.f4713s = Short.parseShort(sharedPreferences.getString("AGOO_CONNECT_COUNT", "0"));
            } catch (Throwable unused) {
            }
            aiv.m1412a("ChannelManager", "time[" + jCurrentTimeMillis + "]mClientCreateTime[" + this.f4715u + "]mLastReconnectTime[" + this.f4714t + "]");
            this.f4713s = (short) (this.f4713s + 1);
            editorEdit.putLong("AGOO_CONNECT_LAST_RECONNECT_TIME", jCurrentTimeMillis);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int) this.f4713s);
            editorEdit.putString("AGOO_CONNECT_COUNT", sb.toString());
            editorEdit.commit();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5040a(aql aqlVar, String str) {
        try {
            if (f4701g != null) {
                f4701g.mo1231a(this.f4718x, -1L, aqlVar, null, null);
            }
        } catch (Throwable unused) {
        }
    }
}
