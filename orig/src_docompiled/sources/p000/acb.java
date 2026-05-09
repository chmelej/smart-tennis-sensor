package p000;

import android.content.Context;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class acb {

    /* JADX INFO: renamed from: A */
    private static int f193A = 1;

    /* JADX INFO: renamed from: B */
    private static String f194B = null;

    /* JADX INFO: renamed from: C */
    private static String f195C = null;

    /* JADX INFO: renamed from: D */
    private static String f196D = null;

    /* JADX INFO: renamed from: E */
    private static String f197E = "mta_channel";

    /* JADX INFO: renamed from: F */
    private static int f198F = 180;

    /* JADX INFO: renamed from: G */
    private static int f199G = 1024;

    /* JADX INFO: renamed from: H */
    private static long f200H = 0;

    /* JADX INFO: renamed from: I */
    private static long f201I = 300000;

    /* JADX INFO: renamed from: J */
    private static volatile String f202J = "http://pingma.qq.com:80/mstat/report";

    /* JADX INFO: renamed from: K */
    private static int f203K = 0;

    /* JADX INFO: renamed from: L */
    private static volatile int f204L = 0;

    /* JADX INFO: renamed from: M */
    private static int f205M = 20;

    /* JADX INFO: renamed from: N */
    private static int f206N = 0;

    /* JADX INFO: renamed from: O */
    private static boolean f207O = false;

    /* JADX INFO: renamed from: P */
    private static int f208P = 4096;

    /* JADX INFO: renamed from: Q */
    private static boolean f209Q = false;

    /* JADX INFO: renamed from: R */
    private static String f210R = null;

    /* JADX INFO: renamed from: S */
    private static boolean f211S = false;

    /* JADX INFO: renamed from: T */
    private static aaw f212T = null;

    /* JADX INFO: renamed from: c */
    static String f215c = "__HIBERNATE__";

    /* JADX INFO: renamed from: d */
    static String f216d = "__HIBERNATE__TIME";

    /* JADX INFO: renamed from: e */
    static String f217e = "__MTA_KILL__";

    /* JADX INFO: renamed from: f */
    static String f218f = "";

    /* JADX INFO: renamed from: g */
    static boolean f219g = false;

    /* JADX INFO: renamed from: h */
    static int f220h = 100;

    /* JADX INFO: renamed from: i */
    static long f221i = 10000;

    /* JADX INFO: renamed from: j */
    static boolean f222j = true;

    /* JADX INFO: renamed from: k */
    public static boolean f223k = true;

    /* JADX INFO: renamed from: l */
    static volatile String f224l = "pingma.qq.com:80";

    /* JADX INFO: renamed from: m */
    static boolean f225m = true;

    /* JADX INFO: renamed from: n */
    static int f226n = 0;

    /* JADX INFO: renamed from: o */
    static long f227o = 10000;

    /* JADX INFO: renamed from: p */
    static int f228p = 512;

    /* JADX INFO: renamed from: s */
    private static boolean f231s = false;

    /* JADX INFO: renamed from: t */
    private static boolean f232t = true;

    /* JADX INFO: renamed from: u */
    private static int f233u = 30000;

    /* JADX INFO: renamed from: v */
    private static int f234v = 100000;

    /* JADX INFO: renamed from: w */
    private static int f235w = 30;

    /* JADX INFO: renamed from: x */
    private static int f236x = 10;

    /* JADX INFO: renamed from: y */
    private static int f237y = 100;

    /* JADX INFO: renamed from: z */
    private static int f238z = 30;

    /* JADX INFO: renamed from: q */
    private static abj f229q = abt.m89c();

    /* JADX INFO: renamed from: a */
    static aav f213a = new aav(2);

    /* JADX INFO: renamed from: b */
    static aav f214b = new aav(1);

    /* JADX INFO: renamed from: r */
    private static acc f230r = acc.APP_LAUNCH;

    /* JADX INFO: renamed from: a */
    public static acc m151a() {
        return f230r;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized String m152a(Context context) {
        if (f195C != null) {
            return f195C;
        }
        if (context != null && f195C == null) {
            f195C = abt.m97f(context);
        }
        if (f195C == null || f195C.trim().length() == 0) {
            f229q.m56d("AppKey can not be null or empty, please read Developer's Guide first!");
        }
        return f195C;
    }

    /* JADX INFO: renamed from: a */
    static String m153a(String str) {
        try {
            String string = f214b.f77b.getString(str);
            if (string != null) {
                return string;
            }
            return null;
        } catch (Throwable unused) {
            f229q.m55c("can't find custom key:" + str);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m154a(long j) {
        aby.m129a(aay.m36a(), f215c, j);
        m161a(false);
        f229q.m53b("MTA is disable for current SDK version");
    }

    /* JADX INFO: renamed from: a */
    public static void m155a(acc accVar) {
        f230r = accVar;
        if (accVar != acc.PERIOD) {
            acd.f250c = 0L;
        }
        if (f231s) {
            f229q.m59g("Change to statSendStrategy: " + accVar);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m156a(Context context, aav aavVar) {
        if (aavVar.f76a != f214b.f76a) {
            if (aavVar.f76a == f213a.f76a) {
                f213a = aavVar;
            }
        } else {
            f214b = aavVar;
            m160a(aavVar.f77b);
            if (f214b.f77b.isNull("iplist")) {
                return;
            }
            acf.m234a(context).m239a(f214b.f77b.getString("iplist"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0 A[Catch: Exception -> 0x0234, JSONException -> 0x026e, JSONException | Throwable -> 0x0279, TryCatch #0 {JSONException | Throwable -> 0x0279, blocks: (B:2:0x0000, B:3:0x0006, B:5:0x000d, B:7:0x001b, B:10:0x0024, B:11:0x0027, B:13:0x002f, B:15:0x003b, B:16:0x0043, B:18:0x004b, B:20:0x0056, B:22:0x0060, B:23:0x0063, B:25:0x006b, B:27:0x0074, B:30:0x007c, B:31:0x0080, B:33:0x008c, B:36:0x0099, B:38:0x00a1, B:40:0x00ab, B:41:0x00ad, B:47:0x00c0, B:49:0x00c4, B:50:0x00dc, B:42:0x00b2, B:44:0x00b6, B:51:0x00f6, B:53:0x0100, B:54:0x0108, B:56:0x0112, B:57:0x0128, B:59:0x0134, B:60:0x014c, B:62:0x0162, B:63:0x0178, B:65:0x018e, B:66:0x01a4, B:68:0x01ba, B:69:0x01d0, B:71:0x01e4, B:72:0x0204, B:74:0x0210, B:76:0x022a, B:80:0x023a, B:82:0x0244, B:83:0x025c, B:85:0x026a, B:79:0x0235, B:87:0x026e, B:87:0x026e, B:88:0x0275, B:88:0x0275), top: B:93:0x0000 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m157a(android.content.Context r11, p000.aav r12, org.json.JSONObject r13) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acb.m157a(android.content.Context, aav, org.json.JSONObject):void");
    }

    /* JADX INFO: renamed from: a */
    public static void m158a(Context context, String str) {
        abj abjVar;
        String str2;
        String str3;
        if (context == null) {
            abjVar = f229q;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else {
            if (str != null && str.length() <= 256) {
                if (f195C == null) {
                    f195C = abz.m133a(aby.m128a(context, "_mta_ky_tag_", (String) null));
                }
                if ((!m172d(str) && !m172d(abt.m97f(context))) || (str3 = f195C) == null) {
                    return;
                }
                aby.m131b(context, "_mta_ky_tag_", abz.m137b(str3));
                return;
            }
            abjVar = f229q;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        abjVar.m56d(str2);
    }

    /* JADX INFO: renamed from: a */
    static void m159a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        aav aavVar;
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next.equalsIgnoreCase(Integer.toString(f214b.f76a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    aavVar = f214b;
                } else if (next.equalsIgnoreCase(Integer.toString(f213a.f76a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    aavVar = f213a;
                } else {
                    if (!next.equalsIgnoreCase("rs")) {
                        return;
                    }
                    acc accVarM193a = acc.m193a(jSONObject.getInt(next));
                    if (accVarM193a != null) {
                        f230r = accVarM193a;
                        if (f231s) {
                            f229q.m59g("Change to ReportStrategy:" + accVarM193a.name());
                        }
                    }
                }
                m157a(context, aavVar, jSONObject2);
            }
        } catch (JSONException e) {
            f229q.m54b((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m160a(JSONObject jSONObject) {
        try {
            acc accVarM193a = acc.m193a(jSONObject.getInt("rs"));
            if (accVarM193a != null) {
                m155a(accVarM193a);
            }
        } catch (JSONException unused) {
            if (f231s) {
                f229q.m51a("rs not found.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m161a(boolean z) {
        f232t = z;
        if (z) {
            return;
        }
        f229q.m53b("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m162a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return false;
        }
        String strOptString = jSONObject.optString(str);
        return abt.m91c(str2) && abt.m91c(strOptString) && str2.equalsIgnoreCase(strOptString);
    }

    /* JADX INFO: renamed from: b */
    public static synchronized String m163b(Context context) {
        if (f196D != null) {
            return f196D;
        }
        String strM128a = aby.m128a(context, f197E, "");
        f196D = strM128a;
        if (strM128a == null || f196D.trim().length() == 0) {
            f196D = abt.m98g(context);
        }
        if (f196D == null || f196D.trim().length() == 0) {
            f229q.m55c("installChannel can not be null or empty, please read Developer's Guide first!");
        }
        return f196D;
    }

    /* JADX INFO: renamed from: b */
    public static void m164b(Context context, String str) {
        if (str.length() > 128) {
            f229q.m56d("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f196D = str;
            aby.m131b(context, f197E, str);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m165b(String str) {
        if (str.length() > 128) {
            f229q.m56d("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f196D = str;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m166b() {
        return f231s;
    }

    /* JADX INFO: renamed from: c */
    public static String m167c(Context context) {
        return aby.m128a(context, "mta.acc.qq", f218f);
    }

    /* JADX INFO: renamed from: c */
    public static void m168c(String str) {
        if (str == null || str.length() == 0) {
            f229q.m56d("statReportUrl cannot be null or empty.");
            return;
        }
        f202J = str;
        try {
            f224l = new URI(f202J).getHost();
        } catch (Exception e) {
            f229q.m55c(e);
        }
        if (f231s) {
            f229q.m51a("url:" + f202J + ", domain:" + f224l);
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m169c() {
        return f232t;
    }

    /* JADX INFO: renamed from: d */
    public static int m170d() {
        return f233u;
    }

    /* JADX INFO: renamed from: d */
    public static String m171d(Context context) {
        if (context == null) {
            f229q.m56d("Context for getCustomUid is null.");
            return null;
        }
        if (f210R == null) {
            f210R = aby.m128a(context, "MTA_CUSTOM_UID", "");
        }
        return f210R;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m172d(String str) {
        if (str == null) {
            return false;
        }
        if (f195C == null) {
            f195C = str;
            return true;
        }
        if (f195C.contains(str)) {
            return false;
        }
        f195C += "|" + str;
        return true;
    }

    /* JADX INFO: renamed from: e */
    public static int m173e() {
        return f237y;
    }

    /* JADX INFO: renamed from: e */
    public static String m174e(Context context) {
        return context != null ? C2289zc.m12530a(context).m12531a().m12524a() : "0";
    }

    /* JADX INFO: renamed from: f */
    public static int m175f() {
        return f238z;
    }

    /* JADX INFO: renamed from: g */
    public static int m176g() {
        return f236x;
    }

    /* JADX INFO: renamed from: h */
    public static int m177h() {
        return f193A;
    }

    /* JADX INFO: renamed from: i */
    static int m178i() {
        return f235w;
    }

    /* JADX INFO: renamed from: j */
    public static int m179j() {
        return f234v;
    }

    /* JADX INFO: renamed from: k */
    public static void m180k() {
        f198F = 60;
    }

    /* JADX INFO: renamed from: l */
    public static int m181l() {
        return f198F;
    }

    /* JADX INFO: renamed from: m */
    public static int m182m() {
        return f199G;
    }

    /* JADX INFO: renamed from: n */
    public static void m183n() {
        f222j = true;
    }

    /* JADX INFO: renamed from: o */
    public static boolean m184o() {
        return f223k;
    }

    /* JADX INFO: renamed from: p */
    public static String m185p() {
        return f202J;
    }

    /* JADX INFO: renamed from: q */
    static synchronized void m186q() {
        f204L = 0;
    }

    /* JADX INFO: renamed from: r */
    public static int m187r() {
        return f205M;
    }

    /* JADX INFO: renamed from: s */
    static void m188s() {
        f206N++;
    }

    /* JADX INFO: renamed from: t */
    static void m189t() {
        f206N = 0;
    }

    /* JADX INFO: renamed from: u */
    static int m190u() {
        return f206N;
    }

    /* JADX INFO: renamed from: v */
    public static boolean m191v() {
        return f209Q;
    }

    /* JADX INFO: renamed from: w */
    public static aaw m192w() {
        return f212T;
    }
}
