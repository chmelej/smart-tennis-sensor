package p000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.apu;
import p000.aql;
import p000.aqm;

/* JADX INFO: compiled from: NewMessagePush.java */
/* JADX INFO: loaded from: classes.dex */
public class aho extends aiy {

    /* JADX INFO: renamed from: B */
    private static int f1055B = 0;

    /* JADX INFO: renamed from: D */
    private static final Random f1056D = new Random();

    /* JADX INFO: renamed from: f */
    private static final String f1057f = "aho";

    /* JADX INFO: renamed from: A */
    private String f1058A;

    /* JADX INFO: renamed from: C */
    private final aqs f1059C;

    /* JADX INFO: renamed from: g */
    private volatile long f1060g;

    /* JADX INFO: renamed from: h */
    private volatile long f1061h;

    /* JADX INFO: renamed from: i */
    private volatile long f1062i;

    /* JADX INFO: renamed from: j */
    private volatile long f1063j;

    /* JADX INFO: renamed from: k */
    private long f1064k;

    /* JADX INFO: renamed from: l */
    private long f1065l;

    /* JADX INFO: renamed from: m */
    private long f1066m;

    /* JADX INFO: renamed from: n */
    private long f1067n;

    /* JADX INFO: renamed from: o */
    private long f1068o;

    /* JADX INFO: renamed from: p */
    private long f1069p;

    /* JADX INFO: renamed from: q */
    private long f1070q;

    /* JADX INFO: renamed from: r */
    private long f1071r;

    /* JADX INFO: renamed from: s */
    private aqm f1072s;

    /* JADX INFO: renamed from: t */
    private aqm.C0728a f1073t;

    /* JADX INFO: renamed from: u */
    private ahn f1074u;

    /* JADX INFO: renamed from: v */
    private String f1075v;

    /* JADX INFO: renamed from: w */
    private boolean f1076w;

    /* JADX INFO: renamed from: x */
    private boolean f1077x;

    /* JADX INFO: renamed from: y */
    private boolean f1078y;

    /* JADX INFO: renamed from: z */
    private aqo f1079z;

    /* JADX INFO: renamed from: e */
    private static boolean m1215e(Context context) {
        return false;
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ int m1216f() {
        int i = f1055B;
        f1055B = i + 1;
        return i;
    }

    public aho(Context context, aiz aizVar) {
        super(context, aizVar);
        this.f1061h = -1L;
        this.f1067n = -1L;
        this.f1068o = -1L;
        this.f1069p = -1L;
        this.f1070q = -1L;
        this.f1071r = -1L;
        this.f1072s = null;
        this.f1073t = null;
        this.f1075v = null;
        this.f1076w = false;
        this.f1077x = false;
        this.f1078y = false;
        this.f1079z = aqo.SPDY;
        this.f1058A = null;
        this.f1059C = new aqs() { // from class: aho.1
            @Override // p000.aqs
            /* JADX INFO: renamed from: a */
            public void mo1229a(Object obj, long j) {
                aho.this.f1067n = System.currentTimeMillis();
                if (j % 2 == 0) {
                    Log.d(aho.f1057f, "heart-->[" + obj.toString() + "][server_receive]");
                    return;
                }
                Log.d(aho.f1057f, "heart-->[" + obj.toString() + "][client_receive]");
            }

            /* JADX INFO: renamed from: c */
            private void m1228c(Object obj, long j) {
                long j2 = 0;
                if (aho.this.f1068o == 0) {
                    aho.this.f1073t.m5086b(0L);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j3 = jCurrentTimeMillis - aho.this.f1068o;
                    aho.this.f1073t.m5086b(jCurrentTimeMillis);
                    j2 = j3;
                }
                Log.d(aho.f1057f, "connect [onDisconnected] [" + obj.toString() + "] sessionId[" + j + "]tcpKeepaliveInterval [" + j2 + "]");
            }

            @Override // p000.aqs
            /* JADX INFO: renamed from: b */
            public void mo1233b(Object obj, long j) {
                Log.d(aho.f1057f, "mPushHandler onClose............");
                m1228c(obj, j);
                ais.m1380a(aho.this.f1209b, aho.this.f1068o, "onClose");
                aho.this.m1453f("agoo_action_heart");
                if (aho.f1055B < 3) {
                    aho.this.f1208a.onHandleError("EVENT_DISCONNECTED");
                }
                aho.this.f1067n = -1L;
                aho.m1216f();
            }

            @Override // p000.aqs
            /* JADX INFO: renamed from: a */
            public void mo1232a(Object obj, long j, String str, byte[] bArr) {
                String str2;
                Throwable th;
                aho.this.f1067n = System.currentTimeMillis();
                Log.d(aho.f1057f, "onData,mLastHeartTime--->[" + aho.this.f1067n + "]");
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                try {
                    str2 = new String(bArr, "utf-8");
                } catch (Throwable th2) {
                    str2 = "";
                    th = th2;
                }
                try {
                    Log.d(aho.f1057f, "message--->[" + obj.toString() + "][" + str2 + "]");
                    aho.this.m1223a(str2);
                } catch (Throwable th3) {
                    th = th3;
                    Log.w(aho.f1057f, "message[" + obj.toString() + "][" + str2 + "]", th);
                }
            }

            @Override // p000.aqs
            /* JADX INFO: renamed from: a */
            public void mo1230a(Object obj, long j, long j2, Map<String, String> map) {
                Log.d(aho.f1057f, "onConnected [" + obj.toString() + "]sessionId[" + j + "]tcpConnectedInterval[" + j2 + "]header[" + map.toString() + "]");
                aho.this.f1208a.onHandleError("EVENT_CONNECTED");
                aho.this.f1067n = System.currentTimeMillis();
                aho.this.f1068o = System.currentTimeMillis();
                aho.this.f1073t.m5074a(aho.this.f1068o, j2);
                aqo aqoVarM5061a = aho.this.f1072s.m5061a();
                Log.d(aho.f1057f, "onConnected initChannel[" + obj.toString() + "][" + aho.this.f1079z.m5091a() + "]-->targetChannel[" + aqoVarM5061a.m5091a() + "]");
                aho.this.m1225a(map);
                aho.this.m1443a("action_get_his_message", 5000L);
                aho.this.m1197a(obj, aho.this.f1068o, map.get("hb"));
                apo.m4884c(aho.this.f1209b, 0);
                apo.m4879b(aho.this.f1209b, 0);
                ais.m1400h(aho.this.f1209b);
            }

            @Override // p000.aqs
            /* JADX INFO: renamed from: a */
            public void mo1231a(Object obj, long j, aql aqlVar, Map<String, String> map, Throwable th) {
                Log.d(aho.f1057f, "mPushHandler onError............error=" + aqlVar.m5028b());
                m1228c(obj, j);
                aho.this.m1203b(obj, aqlVar, map, th);
                if (aho.f1055B < 3) {
                    aho.this.f1208a.onHandleError("EVENT_SPDY_ERROR");
                }
                aho.m1216f();
            }
        };
        this.f1074u = new ahn(apu.m4919E(context), super.m1456i());
        this.f1060g = this.f1074u.m1182c();
        this.f1063j = this.f1074u.m1183d();
        this.f1061h = this.f1074u.m1185f();
        this.f1062i = this.f1074u.m1186g();
        this.f1066m = this.f1074u.m1181b();
        this.f1064k = this.f1074u.m1187h();
        this.f1065l = this.f1074u.m1179a();
        this.f1075v = apu.m4946p(context);
        this.f1058A = aqc.m4989a(context);
        this.f1078y = false;
    }

    /* JADX INFO: renamed from: l */
    private void m1217l() {
        m1446a("agoo_action_re_connect", "agoo_action_heart", "action_get_his_message", "action_ping", "action_connect_unlock", "action_ping_unlock", "android.net.conn.CONNECTIVITY_CHANGE", this.f1058A, "android.intent.action.SCREEN_ON", "android.intent.action.USER_PRESENT", "android.intent.action.AIRPLANE_MODE");
        this.f1073t = new aqm.C0728a(this.f1209b, m1455h(), m1456i());
        this.f1073t.m5073a(this.f1074u.m1184e());
        this.f1073t.m5079a("m");
        this.f1073t.m5077a(this.f1059C);
        apu.EnumC0716a enumC0716aM4921G = apu.m4921G(this.f1209b);
        if (enumC0716aM4921G == apu.EnumC0716a.f4601c || enumC0716aM4921G == apu.EnumC0716a.f4600b || enumC0716aM4921G == apu.EnumC0716a.f4599a) {
            this.f1073t.m5080a(enumC0716aM4921G.mo4960d(), enumC0716aM4921G.mo4958b());
        }
        this.f1073t.m5081a(enumC0716aM4921G.mo4959c(), apu.m4922a());
        this.f1073t.m5087b(m1454g());
        this.f1073t.m5076a(aqo.SPDY);
        this.f1073t.m5084a(false);
        this.f1073t.m5083a(apo.m4887d(this.f1209b), aic.m1298a(this.f1209b), aic.m1300b(this.f1209b));
        this.f1076w = false;
        this.f1077x = false;
    }

    @Override // p000.aiy
    /* JADX INFO: renamed from: a */
    public void mo1222a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (TextUtils.equals(action, "action_ping")) {
            m1211d(context, intent);
            return;
        }
        if (TextUtils.equals(action, "action_ping_unlock")) {
            this.f1077x = false;
            return;
        }
        if (TextUtils.equals(action, "agoo_action_re_connect")) {
            m1207c(context, intent);
            return;
        }
        if (TextUtils.equals(action, "action_connect_unlock")) {
            this.f1076w = false;
            return;
        }
        if (TextUtils.equals(action, "agoo_action_heart")) {
            m1201b(context);
            return;
        }
        if (TextUtils.equals(action, "action_get_his_message")) {
            m1218m();
            return;
        }
        if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
            Log.d(f1057f, "NewMessagePush connect is change.....current connect=android.net.conn.CONNECTIVITY_CHANGE");
            if (ahp.m1237a(context)) {
                apo.m4884c(context, 0);
                apo.m4879b(context, 0);
                Log.d(f1057f, "[network connected success]state[isconnected]");
                m1191a(this.f1063j, "network_error_connect");
                return;
            }
            return;
        }
        if (TextUtils.equals(action, "android.intent.action.SCREEN_ON") || TextUtils.equals(action, "android.intent.action.USER_PRESENT")) {
            m1196a(context);
            return;
        }
        if (TextUtils.equals(action, this.f1058A)) {
            m1214e(context, intent);
        } else if (TextUtils.equals(action, "android.intent.action.AIRPLANE_MODE")) {
            apo.m4884c(context, 0);
            apo.m4879b(context, 0);
            m1202b(context, intent);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1202b(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                boolean z = extras.getBoolean("state");
                Log.d(f1057f, "onHandlerAirplaneMode[" + z + "]");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: m */
    private void m1218m() {
        try {
            if (this.f1072s != null) {
                aqn aqnVarM5065b = this.f1072s.m5065b();
                if (this.f1072s.m5061a() == aqo.SPDY && aqnVarM5065b == aqn.OPEN) {
                    Log.d(f1057f, "onHandlerHisMessage()");
                    this.f1072s.m5066c();
                    this.f1069p = System.currentTimeMillis();
                }
            }
        } catch (Throwable th) {
            Log.e(f1057f, "onHandlerHisMessage error," + th.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1224a(String str, String str2, String str3) {
        String[] strArrSplit;
        try {
            if (this.f1072s != null) {
                aqn aqnVarM5065b = this.f1072s.m5065b();
                aqo aqoVarM5061a = this.f1072s.m5061a();
                if (aqoVarM5061a == aqo.SPDY && aqnVarM5065b == aqn.OPEN) {
                    this.f1072s.m5060a(str, str2, str3);
                    this.f1069p = System.currentTimeMillis();
                    Log.d(f1057f, "handlerACKMessage,mLastHeartTime--->[" + this.f1067n + "]");
                }
                if (aqoVarM5061a == aqo.CHUNKED && aqnVarM5065b == aqn.OPEN && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
                        for (String str4 : strArrSplit) {
                            if (!TextUtils.isEmpty(str4)) {
                                ahm.m1167a(this.f1209b).m1175a(str4, null, "1", "apoll", null, null, "5", str2);
                            }
                        }
                    }
                    aqj aqjVar = new aqj(this.f1209b, "httpAckMsg");
                    LinkedHashMap<String, String> linkedHashMapM1305g = aic.m1305g(this.f1209b);
                    linkedHashMapM1305g.put("msgIds", str);
                    aqjVar.m5023a(linkedHashMapM1305g);
                    Log.d(f1057f, "handlerACKMessage,CHUNKED,mLastHeartTime--->[" + this.f1067n + "]");
                }
            }
        } catch (Throwable th) {
            Log.e(f1057f, "handlerReportMessages", th);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1196a(Context context) {
        try {
            if (this.f1072s != null) {
                if (m1215e(context)) {
                    Log.d(f1057f, "[onHandlerScreenOnOrUserPresent][AirplaneModeOn]");
                }
                if (!ahp.m1237a(context)) {
                    Log.d(f1057f, "[onHandlerScreenOnOrUserPresent][network connected failed]");
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f1067n;
                if (jCurrentTimeMillis >= this.f1070q) {
                    Log.d(f1057f, "onHandlerScreenOnOrUserPresent-->timeout[" + (jCurrentTimeMillis / 1000) + "]");
                    m1192a(this.f1060g, "screen_on_connect", 60000);
                    return;
                }
                m1206c(context);
                aqn aqnVarM5065b = this.f1072s.m5065b();
                if (aqnVarM5065b != aqn.OPEN && aqnVarM5065b != aqn.CONNECTING) {
                    Log.d(f1057f, "onHandlerScreenOn-->state[" + aqnVarM5065b + "]");
                    m1192a(this.f1060g, "screen_on_connect", 60000);
                    return;
                }
                switch (this.f1072s.m5061a()) {
                    case SPDY:
                        Log.d(f1057f, "onHandlerScreenOnOrUserPresent-->[send heart]");
                        this.f1072s.m5069f();
                        break;
                    case CHUNKED:
                        Log.d(f1057f, "onHandlerScreenOnOrUserPresent-->[connect successfully]");
                        break;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1201b(Context context) {
        try {
            if (this.f1072s != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - this.f1067n;
                if (j >= this.f1070q) {
                    ais.m1379a(this.f1209b, j, this.f1068o);
                    long jM1220o = m1220o();
                    Log.d(f1057f, "onHandlerHeart-->[" + jM1220o + "]timeout[" + (j / 1000) + "]ms");
                    m1191a(jM1220o, "heart_connect_timeout");
                }
                Log.d(f1057f, "onHandlerHeart-->[currentTime：" + jCurrentTimeMillis + "][mLastSendDataTime:" + this.f1069p + "][checkHeartInterval:" + this.f1066m + "]");
                if (this.f1072s.m5065b() == aqn.OPEN) {
                    aqo aqoVarM5061a = this.f1072s.m5061a();
                    this.f1069p = jCurrentTimeMillis;
                    switch (aqoVarM5061a) {
                        case SPDY:
                            Log.d(f1057f, "onHandlerHeart-->[send heart]");
                            m1206c(context);
                            this.f1072s.m5069f();
                            break;
                        case CHUNKED:
                            Log.d(f1057f, "onHandlerHeart-->[check heart]");
                            break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1206c(Context context) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(this.f1058A)) {
                    return;
                }
                Intent intent = new Intent(this.f1058A);
                intent.setPackage(context.getPackageName());
                context.sendOrderedBroadcast(intent, null);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1207c(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("CONNECT_STATE");
        boolean booleanExtra = intent.getBooleanExtra("CONNECT_REFRESH_HOST", true);
        if (TextUtils.isEmpty(stringExtra)) {
            Log.v(f1057f, "onHandlerConnect[" + intent.getExtras().toString() + "]");
            return;
        }
        int iM4905r = apo.m4905r(context);
        int iM4904q = apo.m4904q(context);
        Log.d(f1057f, "onHandlerConnect spdyCount=" + iM4905r + ",httpCount=" + iM4904q);
        this.f1072s = this.f1073t.m5089c();
        aqo aqoVarM5061a = this.f1072s != null ? this.f1072s.m5061a() : null;
        if (iM4905r > 6 && aqoVarM5061a != null && aqoVarM5061a.equals(aqo.SPDY)) {
            apo.m4884c(context, 0);
            ais.m1404k(context);
            this.f1079z = aqo.CHUNKED;
            this.f1073t.m5076a(aqo.CHUNKED);
            m1191a(this.f1060g, "error_connect");
            return;
        }
        if (iM4904q > 2 && aqoVarM5061a != null && aqoVarM5061a.equals(aqo.CHUNKED)) {
            apo.m4879b(context, 0);
            this.f1079z = aqo.SPDY;
            this.f1073t.m5076a(aqo.SPDY);
            m1191a(this.f1060g, "error_connect");
            return;
        }
        if (m1215e(context)) {
            Log.d(f1057f, "[airplaneModeOn][true]state[" + stringExtra + "]");
            return;
        }
        m1210d(context);
        m1219n();
        if (booleanExtra) {
            this.f1073t.m5072a();
        }
        Log.v(f1057f, "onHandlerConnect refreshhost[" + booleanExtra + "]state[" + stringExtra + "][threadName:" + Thread.currentThread().getName() + "]");
        if (this.f1072s.m5065b() == aqn.CONNECTING) {
            Log.v(f1057f, "onHandlerConnect[connecting]");
            return;
        }
        this.f1079z = this.f1072s.m5061a();
        if (this.f1079z.equals(aqo.SPDY)) {
            apo.m4884c(context, -1);
        } else if (this.f1079z.equals(aqo.CHUNKED)) {
            apo.m4879b(context, -1);
        }
        this.f1072s.m5062a((Object) stringExtra);
        this.f1072s.m5063a(apo.m4892f(context));
    }

    /* JADX INFO: renamed from: a */
    protected void m1225a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String str = map.get("x-at");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1073t.m5082a("x-at", str);
    }

    /* JADX INFO: renamed from: d */
    private void m1210d(Context context) {
        this.f1065l = this.f1074u.m1179a();
        this.f1073t.m5082a("hb", "" + (this.f1065l / 1000));
        if (TextUtils.indexOf((CharSequence) this.f1075v, 'r') != -1) {
            this.f1073t.m5078a(aqu.REMOTE);
        } else {
            this.f1073t.m5078a(aqu.LOCAL);
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1219n() {
        this.f1073t.m5075a(aqk.NET_CHANGED);
    }

    /* JADX INFO: renamed from: a */
    private final void m1198a(Object obj, aql aqlVar, Map<String, String> map, Throwable th) {
        String str;
        if (obj != null) {
            Log.w(f1057f, "handlerError[" + obj.toString() + "]");
        }
        if (aqlVar != null) {
            Log.w(f1057f, "handlerError[" + aqlVar.m5028b() + "]");
        }
        if (map != null && !map.isEmpty()) {
            Log.w(f1057f, "handlerError[" + map.toString() + "]");
        }
        if (th != null) {
            Log.w(f1057f, "handlerError", th);
        }
        Context context = this.f1209b;
        long j = this.f1068o;
        if (aqlVar == null) {
            str = "";
        } else {
            str = "" + aqlVar.m5028b();
        }
        ais.m1381a(context, j, "onError", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m1203b(Object obj, aql aqlVar, Map<String, String> map, Throwable th) {
        if (aqlVar != null) {
            try {
                if (this.f1072s != null && this.f1073t != null) {
                    m1198a(obj, aqlVar, map, th);
                    aql.EnumC0725a enumC0725aM5027a = aqlVar.m5027a();
                    m1453f("agoo_action_re_connect");
                    m1453f("agoo_action_heart");
                    ais.m1402i(this.f1209b);
                    switch (enumC0725aM5027a) {
                        case DISABLE:
                            Log.w(f1057f, "handlerError[sign error]");
                            this.f1208a.onHandleError("ERRCODE_AUTH_REJECT");
                            break;
                        case PAUSE:
                            Log.w(f1057f, "handlerError[connect pause]");
                            break;
                        case FORCE_CHUNKED:
                            Log.w(f1057f, "handlerError[force_chunked]");
                            ais.m1384a(this.f1209b, th);
                            this.f1079z = aqo.CHUNKED;
                            this.f1073t.m5076a(aqo.CHUNKED);
                            m1191a(this.f1060g, "error_connect");
                            break;
                        case SPDY_RELOAD:
                            Log.w(f1057f, "handlerError[spdy_reload]");
                            this.f1073t.m5085b();
                            this.f1073t.m5072a();
                            m1191a(this.f1060g, "error_connect");
                            break;
                        case RECONNECT_CLEAR_X_TOKEN:
                            Log.w(f1057f, "handlerError[clear_x_token]");
                            this.f1073t.m5088c("x-at");
                            this.f1073t.m5072a();
                            m1191a(this.f1060g, "error_connect");
                            break;
                        case RECONNECT_REFRESH_HOST:
                            Log.w(f1057f, "handlerError[refresh_host]");
                            this.f1073t.m5072a();
                            m1191a(m1220o(), "error_connect");
                            break;
                        case RECONNECT:
                            Log.w(f1057f, "handlerError[only_reconnect]");
                            m1191a(m1220o(), "error_connect");
                            break;
                        case UNNECESSARY:
                            Log.d(f1057f, "handlerError[unnecessary]");
                            break;
                    }
                }
            } catch (Throwable th2) {
                Log.w(f1057f, "handlerError", th2);
            }
        }
    }

    /* JADX INFO: renamed from: o */
    private long m1220o() {
        long jCurrentTimeMillis;
        if (this.f1068o != 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.f1068o;
            this.f1068o = 0L;
        } else {
            jCurrentTimeMillis = 0;
        }
        if (jCurrentTimeMillis == 0) {
            this.f1061h *= 2;
        } else if (0 <= jCurrentTimeMillis && jCurrentTimeMillis < 60000) {
            this.f1061h *= 2;
        } else {
            this.f1061h = this.f1074u.m1185f();
        }
        this.f1061h = this.f1061h >= this.f1062i ? this.f1062i : this.f1061h;
        Log.d(f1057f, "nextErrorInterval [connectInterval:" + jCurrentTimeMillis + "][nextConnectInterval:" + this.f1061h + "]");
        return this.f1061h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1197a(Object obj, long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(str) >= 20) {
                    this.f1065l = r6 * 1000;
                }
            } catch (Throwable th) {
                Log.e(f1057f, "startHeart(" + str + ")", th);
            }
        }
        if (this.f1065l <= this.f1064k) {
            this.f1066m = this.f1065l;
            this.f1070q = this.f1065l * 5;
        } else {
            if (new ahp(this.f1209b).m1239a()) {
                this.f1066m = (long) (this.f1065l * 0.5d);
            } else {
                this.f1066m = (long) (this.f1065l * 0.7d);
            }
            this.f1070q = (long) (this.f1065l * 1.1d);
        }
        Log.d(f1057f, "heart[onh" + obj.toString() + "]heart--->[start checktime:" + (this.f1066m / 1000) + "|timeout:" + (this.f1070q / 1000) + "s]");
        this.f1069p = -1L;
        m1448b("agoo_action_heart", this.f1066m);
    }

    /* JADX INFO: renamed from: a */
    private final void m1191a(long j, String str) {
        m1193a(j, str, true, false, -1);
    }

    /* JADX INFO: renamed from: a */
    private final void m1192a(long j, String str, int i) {
        m1193a(j, str, false, true, i);
    }

    /* JADX INFO: renamed from: a */
    private final void m1193a(long j, String str, boolean z, boolean z2, int i) {
        aqn aqnVarM5065b;
        try {
            String str2 = String.format("%s_%d", str, Integer.valueOf(f1056D.nextInt(10000)));
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f1071r <= jCurrentTimeMillis) {
                Log.v(f1057f, "reConnect[mLastConnectTime:" + this.f1071r + "]<[currentTime:" + jCurrentTimeMillis + "]");
                this.f1071r = -1L;
            }
            long j2 = jCurrentTimeMillis + j;
            if (j2 > this.f1071r && this.f1071r != -1) {
                Log.v(f1057f, "reConnect[interval:" + j2 + "]>[" + this.f1071r + "][state:" + str2 + "]");
                return;
            }
            if (z2) {
                if (this.f1076w) {
                    Log.d(f1057f, "tryConnect[interval:" + j + "][connectContext:" + str2 + "][connnectLock:true]");
                    return;
                }
                this.f1076w = true;
                Log.d(f1057f, "tryConnect[interval:" + j + "][connectContext:" + str2 + "]");
                m1443a("action_connect_unlock", (long) i);
            } else {
                Log.d(f1057f, "forceConnect[interval:" + j + "][connectContext:" + str2 + "]");
            }
            this.f1071r = j2;
            if (this.f1072s != null && (aqnVarM5065b = this.f1072s.m5065b()) != null) {
                if (aqnVarM5065b == aqn.CONNECTING) {
                    Log.d(f1057f, "reConnect[connectContext:" + str2 + "][connecting]");
                    return;
                }
                if (aqnVarM5065b == aqn.OPEN) {
                    Log.w(f1057f, "disconnect[connectContext:" + str2 + "]");
                    this.f1072s.m5067d();
                }
            }
            m1453f("agoo_action_heart");
            Bundle bundle = new Bundle();
            bundle.putBoolean("CONNECT_REFRESH_HOST", z);
            bundle.putString("CONNECT_STATE", str2);
            m1445a("agoo_action_re_connect", bundle, j);
        } catch (Throwable th) {
            Log.w(f1057f, "reConnect", th);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1211d(Context context, Intent intent) {
        try {
            if (this.f1072s != null) {
                if (this.f1079z != aqo.SPDY) {
                    this.f1073t.m5076a(aqo.SPDY);
                    m1191a(this.f1060g, "ping_channge_channle_type_reconnect");
                    return;
                }
                if (C01153.f1084c[this.f1072s.m5065b().ordinal()] == 1) {
                    m1191a(this.f1063j, "ping_reconnect");
                } else {
                    m1201b(context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: aho$3 */
    /* JADX INFO: compiled from: NewMessagePush.java */
    static /* synthetic */ class C01153 {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ int[] f1084c = new int[aqn.values().length];

        static {
            try {
                f1084c[aqn.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f1083b = new int[aql.EnumC0725a.values().length];
            try {
                f1083b[aql.EnumC0725a.DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1083b[aql.EnumC0725a.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1083b[aql.EnumC0725a.FORCE_CHUNKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1083b[aql.EnumC0725a.SPDY_RELOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1083b[aql.EnumC0725a.RECONNECT_CLEAR_X_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1083b[aql.EnumC0725a.RECONNECT_REFRESH_HOST.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1083b[aql.EnumC0725a.RECONNECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1083b[aql.EnumC0725a.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
            f1082a = new int[aqo.values().length];
            try {
                f1082a[aqo.SPDY.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1082a[aqo.CHUNKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1221a() {
        try {
            if (this.f1078y) {
                return;
            }
            this.f1078y = true;
            Log.d(f1057f, "MessagePush [starting]");
            m1217l();
            m1191a(this.f1060g, "init_connect");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m1226b() {
        if (this.f1077x) {
            return true;
        }
        this.f1077x = true;
        if (!this.f1078y) {
            return false;
        }
        m1443a("action_ping", 5000L);
        m1443a("action_ping_unlock", 10000L);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final void m1227c() {
        try {
            if (this.f1078y) {
                this.f1078y = false;
                super.m1457j();
                Log.d(f1057f, "[destroying]");
                if (this.f1072s != null) {
                    this.f1072s.m5068e();
                    this.f1072s = null;
                }
                Log.d(f1057f, "[destroyed]");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: e */
    private final void m1214e(Context context, Intent intent) {
        try {
            if (this.f1072s == null || this.f1072s.m5065b() != aqn.OPEN) {
                return;
            }
            Bundle extras = intent.getExtras();
            for (String str : extras.keySet()) {
                if (TextUtils.isEmpty(str)) {
                    Log.d(f1057f, "path[" + str + "][data==null]");
                } else {
                    byte[] byteArray = extras.getByteArray(str);
                    if (byteArray != null) {
                        if (byteArray.length >= 128) {
                            Log.d(f1057f, "path[" + str + "][" + byteArray.length + ">=128]");
                        } else {
                            try {
                                String str2 = new String(byteArray, "utf-8");
                                Log.d(f1057f, "path[" + str + "][" + str2 + "]");
                            } catch (Throwable unused) {
                            }
                            try {
                                this.f1072s.m5064a(str, byteArray, new aqr() { // from class: aho.2
                                    @Override // p000.aqr
                                    /* JADX INFO: renamed from: a */
                                    public void mo1234a(Object obj, String str3, int i, Map<String, String> map, byte[] bArr) {
                                        aho.this.f1069p = System.currentTimeMillis();
                                        aho.this.f1067n = System.currentTimeMillis();
                                        Log.d(aho.f1057f, "send Data--->path[" + str3 + "][" + i + "]");
                                    }
                                });
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1223a(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray2 = new JSONArray(str);
            int length = jSONArray2.length();
            Bundle bundle = new Bundle();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            while (i < length) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (jSONObject == null) {
                    jSONArray = jSONArray2;
                } else {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    String string3 = jSONObject.getString("b");
                    long j = jSONObject.getLong("f");
                    sb.append(string2);
                    int i2 = length - 1;
                    if (i < i2) {
                        jSONArray = jSONArray2;
                        sb.append(",");
                    } else {
                        jSONArray = jSONArray2;
                    }
                    if (TextUtils.isEmpty(string3)) {
                        m1224a(sb.toString(), sb2.toString(), "11");
                    } else if (TextUtils.isEmpty(string)) {
                        m1224a(sb.toString(), sb2.toString(), "12");
                    } else if (j == -1) {
                        m1224a(sb.toString(), sb2.toString(), "13");
                    } else if (!aiq.m1372a(this.f1209b, string)) {
                        sb2.append(string);
                        if (i < i2) {
                            sb2.append(",");
                        }
                    } else {
                        bundle.putString("id", string2);
                        bundle.putString("body", string3);
                        Bundle bundleM1190a = m1190a(j);
                        if (bundleM1190a != null) {
                            bundle.putAll(bundleM1190a);
                        }
                        try {
                            String string4 = jSONObject.getString("t");
                            if (!TextUtils.isEmpty(string4)) {
                                bundle.putString("time", string4);
                            }
                        } catch (Throwable unused) {
                        }
                        bundle.putLong("trace", System.currentTimeMillis());
                        aqj aqjVar = new aqj(this.f1209b, "ackMessage");
                        LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f1209b);
                        linkedHashMapM4909v.put("messageId", string2);
                        aqjVar.m5023a(linkedHashMapM4909v);
                        m1444a(string, bundle);
                    }
                }
                i++;
                jSONArray2 = jSONArray;
            }
            if (sb2 != null && sb2.length() > 0) {
                m1224a(sb.toString(), sb2.toString(), "10");
            }
            m1224a(sb.toString(), (String) null, (String) null);
        } catch (JSONException e) {
            ais.m1386b(this.f1209b, str);
            Log.e(f1057f, "handlerMessage", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private Bundle m1190a(long j) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString("encrypted", sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", "1");
                    }
                    if (charArray[7] == '1') {
                        bundle.putString("notify", "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString("has_test", "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString("duplicate", "1");
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
